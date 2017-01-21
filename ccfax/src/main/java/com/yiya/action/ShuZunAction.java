package com.yiya.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yiya.bean.ScoringGatherField;
import com.yiya.bean.ShuZunBaseResponse;
import com.yiya.bean.ShuZunQuotaData;
import com.yiya.bean.ShuZunQuotaParam;
import com.yiya.bean.ShuZunQuotalistResponse;
import com.yiya.bean.ShuZunSearchResponse;
import com.yiya.bean.shuzun.ApiReturnInfo;
import com.yiya.bean.shuzun.CommonUtil;
import com.yiya.bean.shuzun.QuotaResult;
import com.yiya.bean.shuzun.ResultCode;
import com.yiya.bean.shuzun.ResultOutput;
import com.yiya.bean.shuzun.ShuZunRequestParams;
import com.yiya.model.ScoringGatherFieldModel;
import com.yiya.service.DataService;
import com.yiya.service.ScoringGatherFieldService;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.HttpUtil;
import com.yiya.utils.MD5Utils;
import com.yiya.utils.StringUtil;

import java.lang.reflect.Type;
import java.net.URLEncoder;

@Controller
@RequestMapping("/shuzun")
public class ShuZunAction extends BaseAction {
	private final static Logger log = Logger.getLogger(ShuZunAction.class);
	
	@Value("${getquotalistUrl}")
	private String getquotalistUrl; 
	
	@Value("${searchreportUrl}")
	private String searchreportUrl; 
	
	@Value("${accountID}")
	private String accountID;
	
	@Value("${privatekey}")
	private String privatekey; 
	
	private Gson gson = new Gson();
	
	@Autowired(required=false)
	private DataService dataService;
	
	@Autowired
	private ScoringGatherFieldService scoringGatherFieldService;
	
	@RequestMapping(value="/getquotalist",method=RequestMethod.GET)
	@ResponseBody
	public String getquotalist(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("accountID", accountID);
//		jsonObject.put("quotaType", "1");
		
//		String sign = getSign("accountID"+accountID+"quotaType"+"1");
		String sign = getSign("accountID"+accountID);
		jsonObject.put("sign", sign);
		
//		String params = "accountID="+accountID+"&quotaType="+"1"+"&sign="+sign;
		String params = "accountID="+accountID+"&sign="+sign;
		log.info("获取账户所开通的指标列表参数："+jsonObject.toString());
		String data = HttpRequestUtil.sendGet(getquotalistUrl, params);
		log.info("获取账户所开通的指标列表："+data);
		ShuZunQuotalistResponse shuZunQuotalistResponse = gson.fromJson(data, ShuZunQuotalistResponse.class);
		
//		List<ShuZunQuotaParam> quotaParamList = new ArrayList<ShuZunQuotaParam>();
		List<String> quotas = new ArrayList<String>();
		if(shuZunQuotalistResponse.getResCode().equals("0000")){
			ScoringGatherFieldModel model = new ScoringGatherFieldModel();
			model.setGather_type_id(3);
			List<ScoringGatherField> list = scoringGatherFieldService.queryByCondition(model);
			log.info("来自数尊的采集字段:"+list.toString());
			
			List<ShuZunQuotaData> shuZunQuotaDatas = shuZunQuotalistResponse.getData();
			if(list != null && list.size()>0){
				if(shuZunQuotaDatas != null && shuZunQuotaDatas.size()>0){
					out:for(int i=0;i<list.size();i++){
						ScoringGatherField scoringGatherField = list.get(i);
						in:for(int j=0;j<shuZunQuotaDatas.size();j++){
							ShuZunQuotaData shuZunQuotaData = shuZunQuotaDatas.get(j);
							if(scoringGatherField.getField_name().equals(shuZunQuotaData.getQuotaID())){
								List<ShuZunQuotaParam> quotaParams = shuZunQuotaData.getQuotaParamList();
								quotas.add(scoringGatherField.getField_name());
//								for(ShuZunQuotaParam shuZunQuotaParam : quotaParams){
//									if(!quotaParamList.contains(shuZunQuotaParam)){
//										quotaParamList.add(shuZunQuotaParam);
//									}
//								}
								break in;
							}
						}
					}
				}
			}
		}
//		 ShuZunRequestParams shuZunRequestParams = new ShuZunRequestParams();
//		 shuZunRequestParams.setQuotaParamList(quotaParamList);
//		 shuZunRequestParams.setQuotas(StringUtil.listToString(quotas));
//		 log.info("参数列表:"+shuZunRequestParams.toString());
//		return StringUtil.listToString(quotas);
		return data;
	}

	/**
	 * 数据签名
	 * @param string
	 * @return
	 */
	private String getSign(String string) {
		String result = string+privatekey;
		result = MD5Utils.getMD5Str(result);
		return result;
	}
	
	@RequestMapping(value="/searchreport",method=RequestMethod.GET)
	@ResponseBody
	public void searchreport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String mobile = request.getParameter("mobile"); // 手机号码
		String cardID = request.getParameter("cardID"); // 身份证号码
		String name = request.getParameter("name");  // 姓名
		String bankID = request.getParameter("bankID"); //银行卡号
		String userIdStr = request.getParameter("userId"); //统一登陆id
        
//        String mobile = "13772086110"; // 手机号码
//        String cardID = "610121198501216633"; // 身份证号码
//        String name = "何卫靖";  // 姓名
//        String bankID = "4392258383008432";   //银行卡号
//        String userIdStr = "1000"; //统一登陆id
		if(StringUtil.isEmpty(userIdStr)){
			sendFailureMessage(response, "用户ID不能为空");
			return;
		}
		if(StringUtil.isEmpty(mobile)){
			sendFailureMessage(response, "手机号不能为空");
			return;
		}
		if(StringUtil.isEmpty(cardID)){
			sendFailureMessage(response, "身份证号不能为空");
			return;
		}
		if(StringUtil.isEmpty(name)){
			sendFailureMessage(response, "姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(bankID)){
			sendFailureMessage(response, "银行卡号不能为空");
			return;
		}
		int userId =0;
		if(StringUtil.isNumeric(userIdStr)){
			userId = Integer.valueOf(userIdStr);
		}else {
			sendFailureMessage(response, "用户ID格式不对");
			return;
		}
    	String result = dataService.getShuZunSearchReport(userId,mobile, cardID, name, bankID);
    	ShuZunBaseResponse shuZunBaseResponse = gson.fromJson(result, ShuZunBaseResponse.class);
    	if(shuZunBaseResponse.getResCode().equals(ResultCode.RESULT_CODE_SUCC)){
    		sendSuccessMessage(response, "查询成功成功");
    	}else {
    		sendFailureMessage(response, shuZunBaseResponse.getResMsg());
    	}
	}

}
