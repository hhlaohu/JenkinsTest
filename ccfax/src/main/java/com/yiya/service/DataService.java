package com.yiya.service;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yiya.bean.GatherType;
import com.yiya.bean.GatherValue;
import com.yiya.bean.ScoringGatherField;
import com.yiya.bean.ShuZunQuotaData;
import com.yiya.bean.ShuZunQuotalistResponse;
import com.yiya.bean.shuzun.ApiReturnInfo;
import com.yiya.bean.shuzun.CommonUtil;
import com.yiya.bean.shuzun.QuotaResult;
import com.yiya.bean.shuzun.ResultCode;
import com.yiya.bean.shuzun.ResultOutput;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.ScoringGatherFieldModel;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.HttpUtil;
import com.yiya.utils.MD5Utils;
import com.yiya.utils.StringUtil;

/**
 * @author frank_wang
 * @data 2016年11月9日
 * @description 获取第三方数据
 */
@Service
public class DataService {

	private final static Logger log = Logger.getLogger(DataService.class);
	
	@Value("${getquotalistUrl}")
	private String getquotalistUrl; 
	
	@Value("${searchreportUrl}")
	private String searchreportUrl; 
	
	@Value("${accountID}")
	private String accountID;
	
	@Value("${privatekey}")
	private String privatekey; 
	
	private Gson gson = new Gson();

	@Autowired
	private GatherValueService gatherValueService;

	@Autowired
	private GatherTypeService gatherTypeService;
	
	@Autowired
	private ScoringGatherFieldService scoringGatherFieldService;
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 写入采集字段表
	 * @param usrid
	 */
	public void writeGatherField(JSONArray array,String source){
		List<ScoringGatherField> list = new ArrayList<ScoringGatherField>();
		for(int i = 0;i<array.size();i++){
			 JSONObject obj = (JSONObject)array.get(i);
			 for (Map.Entry<String, Object> entry : obj.entrySet()) {
				String name = entry.getKey();
				if(!scoringGatherFieldService.isExistByFieldName(name)){
					ScoringGatherField field = new ScoringGatherField();
					field.setAdd_time(new Date());
					field.setField_name(entry.getKey());
					field.setGather_type_id(gatherTypeService.queryByName(source).getGather_type_id());
					list.add(field);
				}
			}
		}
		if(list.size() >0){
			scoringGatherFieldService.batchInsert(list);	
		}
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 写入字段取值表
	 * @param usrid
	 */
	public void writeGatherValue(JSONArray array,Integer usrid,String source){
		List<GatherValue> gatherValueList = new ArrayList<GatherValue>();
		GatherType type = gatherTypeService.queryByName(source);
		for(int i=0;i<array.size();i++){
			JSONObject jsonObj = (JSONObject)array.get(i);
			for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
				GatherValue gatherValue = new GatherValue();
				Object object = entry.getValue();
				gatherValue.setGather_field_value(object == null?"":object.toString());
				gatherValue.setAdd_time(new Date());
				gatherValue.setUsrid(usrid);
				gatherValue.setGather_type_id(type.getGather_type_id());
				ScoringGatherField field =scoringGatherFieldService.getScoringGatherFieldByName(entry.getKey());
				gatherValue.setGather_field_id(field.getGather_field_id());
				gatherValueList.add(gatherValue);
			}
		}
		//先删除原有已存在数据
		gatherValueService.deleteByusrIdAndTypeId(usrid, type.getGather_type_id());
		//插入数据
		gatherValueService.batchInsert(gatherValueList);
	}
	/**
	 * 获取数尊需要采集的指标列表
	 * @return
	 */
	public String getShuZunQuotaList(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("accountID", accountID);
//		jsonObject.put("quotaType", "1");
		
//		String sign = MD5Utils.MD5("accountID"+accountID+"quotaType"+"1"+privatekey);
		String sign = MD5Utils.MD5("accountID"+accountID+privatekey);
		jsonObject.put("sign", sign);
		
//		String params = "accountID="+accountID+"&quotaType="+"1"+"&sign="+sign;
		String params = "accountID="+accountID+"&sign="+sign;
		log.info("获取账户所开通的指标列表参数："+jsonObject.toString());
		String data = HttpRequestUtil.sendGet(getquotalistUrl, params);
		log.info("获取账户所开通的指标列表："+data);
		ShuZunQuotalistResponse shuZunQuotalistResponse = gson.fromJson(data, ShuZunQuotalistResponse.class);
		
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
								quotas.add(scoringGatherField.getField_name());
								break in;
							}
						}
					}
				}
			}
		}
		return StringUtil.listToString(quotas);
	}
	
	/**
	 * 数尊数据采集返回结果
	 * @param mobile
	 * @param cardID
	 * @param name
	 * @param bankID
	 * @return
	 * @throws Exception
	 */
	public String getShuZunSearchReport(int userId,String mobile,String cardID,String name,String bankID) throws Exception{
		String select = getShuZunQuotaList();
//		String select = "MD001,MD003,MD002,S0190";
		
		StringBuffer url = new StringBuffer();
        url.append(searchreportUrl);
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("accountID", accountID);
        paramMap.put("bankID", bankID);
        paramMap.put("cardID", cardID);
        paramMap.put("mobile", mobile);
        paramMap.put("name", name);
        paramMap.put("select", select);
        
        Map<String,String> myMap = StringUtil.makeSort(paramMap);
        
        StringBuffer signStr = new StringBuffer();
        
        for (String key : myMap.keySet()) {
            signStr.append(key + paramMap.get(key));
        }
        signStr.append(privatekey);

        String sign = MD5Utils.MD5(signStr.toString());
        paramMap.put("sign", sign);
        
        boolean isFirst = true;
        for (String key : paramMap.keySet()) {
            String value = paramMap.get(key);
            if(CommonUtil.isChineseChar(value)){
            	value = URLEncoder.encode(value, "UTF-8");
            }
            if (isFirst) {
                url.append("?" + key + "=" + value);
                isFirst = false;
            } else {
                url.append("&" + key + "=" + value);
            }
        }
        String responseData = HttpUtil.sendGet(url.toString());
        log.info("获取数尊采集结果:" + responseData);
        writeShuZunData(userId, responseData);
		return responseData;
	}
	
	public void writeShuZunData(int userId,String responseData){
		List<GatherValue> gatherValueList = new ArrayList<GatherValue>();
		GatherType gatherType = gatherTypeService.queryByName(WebServiceConstant.SOURCE_SHU_ZUN);
		Type type = new TypeToken<ApiReturnInfo<ArrayList<ResultOutput>>>() {}.getType();
		ApiReturnInfo<ArrayList<ResultOutput>> obj = gson.fromJson(responseData, type);
    	ArrayList<ResultOutput> list = obj.getData();
    	if (ResultCode.RESULT_CODE_SUCC.equals(obj.getResCode()) || ResultCode.RESULT_CODE_PARTSUCC.equals(obj.getResCode())) {
    		for (ResultOutput quota : list) {
                if (ResultCode.RESULT_CODE_SUCC.equals(quota.getResCode())) {
                    QuotaResult info = quota.getQuotaInfo();
                    
                    log.info("指标[" + info.getQuotaID() + " " + info.getQuotaName() + "] 返回值:" + buildResult(info)) ;
                    GatherValue gatherValue = new GatherValue();
    				gatherValue.setGather_field_value(buildResult(info));
    				gatherValue.setAdd_time(new Date());
    				gatherValue.setUsrid(userId);
    				gatherValue.setGather_type_id(gatherType.getGather_type_id());
    				ScoringGatherField field =scoringGatherFieldService.getScoringGatherFieldByName(info.getQuotaID());
    				gatherValue.setGather_field_id(field.getGather_field_id());
    				gatherValueList.add(gatherValue);
                }
            }
    		gatherValueService.batchInsert(gatherValueList);
    	}else {

        	log.info("错误码:" + obj.getResCode() + ", 错误信息:" + obj.getResMsg()) ;
        }
		
	}
	
	private String buildResult(QuotaResult quotaResult) {
        String s = "";
        if (null != quotaResult) {

           
        	String quotaID = quotaResult.getQuotaID();
        	String quotaValue = String.valueOf(quotaResult.getQuotaValue());
        		if(quotaID.equals("MD001")){  //手机当前状态
        			if(StringUtil.isEmpty(quotaValue)){
                		s = s+"0";
                	}else {
                		s = s + quotaValue;
                	}
            	}else if(quotaID.equals("MD002")){  //手机使用时间
            		if(StringUtil.isEmpty(quotaValue)){
                		s = s+"0";
                	}else {
                		if(quotaValue.equals("A")){
                			s = s+"1";
                		}else if(quotaValue.equals("B")){
                			s = s+"2";
                		}else if(quotaValue.equals("C")){
                			s = s+"3";
                		}else if(quotaValue.equals("D")){
                			s = s+"4";
                		}else if(quotaValue.equals("E")){
                			s = s+"5";
                		}else {
                			s = s + quotaValue;
                		}
                	}
            	}else if(quotaID.equals("MD003")){ //手机运营商返回身份证号码、姓名与用户身份证、姓名是否匹配
            		if(StringUtil.isEmpty(quotaValue)){
                		s = s+"0";
                	}else {
                		if(quotaValue.equals("0,0,0")){
                			s = s +"1";
                		}else {
                			s = s +"-1";
                		}
                	}
            	}else if(quotaID.equals("S0618")){ //3个月内失败交易笔数/近3月身份验证失败交易/是否存在盗卡风险
            		if(StringUtil.isEmpty(quotaValue)){
                		s = s+"0";
                	}else {
                		if(quotaValue.equals("0")){
                			s = s +"1";
                		}else {
                			s = s +"0";
                		}
                	}
            	}else {
            		 // * 1 数值型
                    // * 2 字符型
                    // * 3 boolean型
                    // * 4 Object 型
                    switch (quotaResult.getQuotaValueType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        s = s + String.valueOf(quotaResult.getQuotaValue());
                        break;
                    case 4:
                        s = new Gson().toJson(quotaResult.getQuotaValue());
                        break;
        
                    default:
                        break;
                    }
                    quotaResult.getQuotaValue();
            	}
        	}
        s = s + "\t";
        return s;
    }
}
