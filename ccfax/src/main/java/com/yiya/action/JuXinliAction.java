package com.yiya.action;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.BondsMan;
import com.yiya.bean.JsonResponse;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.JuXinLiSetPhoneCheckModel;
import com.yiya.model.JuXinLiSubmitDataModel;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.StringUtil;

@Controller
@RequestMapping("/juxinli")
public class JuXinliAction extends BaseAction {
	
	private final static Logger log = Logger.getLogger(JuXinliAction.class);
	
	@Value("${submitDataUrl}")
	private String submitDataUrl; 
	
	@Value("${setPhoneCheckUrl}")
	private String setPhoneCheckUrl;
	
	@Value("${setPassCheckUrl}")
	private String setPassCheckUrl;
	
	

	@RequestMapping(value="/submitData",method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse submitData(JuXinLiSubmitDataModel model){
		
		log.info("JuXinliAction方法submitData()接收参数："+model.toString());
		JSONObject obj = new JSONObject();
		//如果没有数据源，默认为空数组，不要赋值空字符串
		List<Map<String, Object>> selected_website = new ArrayList<Map<String,Object>>();
		Map<String, Object> jingdongMap = new HashMap<String,Object>();
		jingdongMap.put("website", "jingdong");
		jingdongMap.put("category", "e_business");
		selected_website.add(jingdongMap);
		boolean skip_mobile = false;
		Map<String, Object> basic_info = new HashMap<String,Object>();
		basic_info.put("name", model.getUsr_name());
		basic_info.put("id_card_num", model.getId_card());
		basic_info.put("cell_phone_num", model.getCell_phone());
		basic_info.put("home_addr", model.getHome_addr());
		basic_info.put("home_tel", model.getHome_tel());
		basic_info.put("work_tel", model.getWork_tel());
		basic_info.put("work_addr", model.getWork_addr());
		
		String bondsmainf_list = model.getBondsmaninf_list();
		List<BondsMan> contactList = JSONObject.parseArray(bondsmainf_list, BondsMan.class);
		obj.put("selected_website", selected_website);
		obj.put("basic_info", basic_info);
		obj.put("skip_mobile", skip_mobile);
		//php系统传过来的联系人类型是Int,需要转为字符串类型
        List<Map<String, Object>> contacts = new ArrayList<Map<String,Object>>();		
		if(contactList!=null && contactList.size()>0){
			for(BondsMan bondsMan:contactList){
				Map<String, Object> contactsMap = new HashMap<String,Object>();
			    contactsMap.put("contact_tel", bondsMan.getContact_tel());
			    contactsMap.put("contact_type", bondsMan.getContact_type()+"");
			    contactsMap.put("contact_name", bondsMan.getContact_name());
			    contacts.add(contactsMap);
			}
			  
		}else{
			return JsonResponse.fail("联系人不能为空");
		}
		obj.put("contacts", contacts);
		log.info("调用聚信立提交申请表接口请求参数："+obj.toString());
		int timeout = 120000;
		String data = null;
		try {
			data = HttpRequestUtil.sendPostJsonContentType(submitDataUrl,obj.toString(),timeout);
		}catch (SocketTimeoutException e) {
			e.printStackTrace();
			JsonResponse response = new JsonResponse();
			response.setCode(WebServiceConstant.CODE_FAIL_TIMEOUT);
			response.setMsg("调用聚信立接口失败，原因：服务器连接超时");
			return response;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail("调用聚信立接口失败，原因："+e.getMessage());
		}
		log.info("调用聚信立提交申请表单接口结果："+data);
		JSONObject result = JSONObject.parseObject(data);
		boolean success = result.getBooleanValue("success");
		String message = result.getString("message");
		int code = result.getIntValue("code");
		JsonResponse response = new JsonResponse();
		HashMap<String,Object> resultText = new HashMap<String,Object>();
		if(!success){
			response.setCode(JsonResponse.FAIL);
			response.setMsg(message);
			resultText.put("code", code);
			response.setResultText(resultText);
			return response;
		}else{
			response.setCode(JsonResponse.SUCCESS);
			response.setMsg(message);
			resultText.put("code", code);
			JSONObject dataBody = result.getJSONObject("data");
			resultText.put("token", dataBody.getString("token"));
			JSONObject dataSourceBody = dataBody.getJSONObject("datasource");
			resultText.put("website", dataSourceBody.getString("website"));
			resultText.put("name", dataSourceBody.getString("name"));
			response.setResultText(resultText);
			return response;
		}
	} 
	
	@RequestMapping(value="/setPhoneCheck",method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse setPhoneCheck(JuXinLiSetPhoneCheckModel model){
		
		log.info("JuXinliAction方法JuXinLiSetPhoneCheckModel()接收参数："+model.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("token", model.getToken());
		jsonObject.put("account", model.getAccount());
		jsonObject.put("password", model.getPassword());
		String website = model.getWebsite();
  		if(StringUtil.isEmpty(website)){
  			website = "jingdong";
  		}
		jsonObject.put("website", website);
		String cptcha = model.getCaptcha();	
		if(!StringUtil.isEmpty(cptcha)){
			jsonObject.put("captcha", cptcha);
			jsonObject.put("type", model.getType());
		}else if(!StringUtil.isEmpty(model.getType())){
			jsonObject.put("type", model.getType());
		}
		log.info("调用聚信立提交数据源采集请求参数："+jsonObject.toString());
		//设置超时时间两分钟
        int timeout = 120000;
		String data = null;
		try {
			data = HttpRequestUtil.sendPostJsonContentType(setPhoneCheckUrl,jsonObject.toString(),timeout);
		}catch (SocketTimeoutException e) {
			e.printStackTrace();
			JsonResponse response = new JsonResponse();
			response.setCode(WebServiceConstant.CODE_FAIL_TIMEOUT);
			response.setMsg("调用聚信立接口失败，原因：服务器连接超时");
			return response;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail("调用聚信立接口失败，原因："+e.getMessage());
		}
		log.info("调用聚信立提交数据源采集请求返回结果"+data);
		JSONObject result = JSONObject.parseObject(data);
		boolean success = result.getBooleanValue("success");
		JSONObject dataObject = result.getJSONObject("data");
		JsonResponse response = new JsonResponse();
		HashMap<String,Object> resultText = new HashMap<String,Object>();
		if(!success){
			response.setCode(JsonResponse.FAIL);
			response.setMsg(result.getString("message"));
			return response;
		}else{
			response.setCode(JsonResponse.SUCCESS);
			response.setMsg("调用接口成功");
			resultText.put("code", dataObject.getString("process_code"));
			resultText.put("type", dataObject.getString("type"));
			resultText.put("finish", dataObject.getString("finish"));
			response.setResultText(resultText);
			return response; 
		}
	}
	
	@RequestMapping(value="/setPassCheck",method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse setPassCheck(String token){
		
		if(StringUtil.isEmpty(token)){
			return JsonResponse.fail("参数token不能为空");
		}
		log.info("JuXinliAction方法setPassCheck()接收参数："+token);
        JSONObject object = new JSONObject();
        object.put("token", token);
        log.info("调用聚信立跳过接口请求参数："+object.toString());
        //设置超时时间两分钟
        int timeout = 120000;
		String data = null;
		try {
			data = HttpRequestUtil.sendPostJsonContentType(setPassCheckUrl, object.toJSONString(),timeout);
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			JsonResponse response = new JsonResponse();
			response.setCode(WebServiceConstant.CODE_FAIL_TIMEOUT);
			response.setMsg("调用聚信立接口失败，原因：服务器连接超时");
			return response;
		}catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail("调用聚信立接口失败，原因："+e.getMessage());
		}
		log.info("调用聚信立跳过接口返回结果："+data);
		JSONObject result = JSONObject.parseObject(data);
		boolean success = result.getBooleanValue("success");
		JSONObject dataObject = result.getJSONObject("data");
		JsonResponse response = new JsonResponse();
		HashMap<String,Object> resultText = new HashMap<String,Object>();
		if(!success){
			response.setCode(JsonResponse.FAIL);
			response.setMsg(result.getString("message"));
			return response;
		}else{
			response.setCode(JsonResponse.SUCCESS);
			response.setMsg(dataObject.getString("content"));
			resultText.put("code", dataObject.getString("process_code"));
			resultText.put("type", dataObject.getString("type"));
			resultText.put("finish", dataObject.getString("finish"));
			response.setResultText(resultText);
			return response; 
		}
		
	}
	
}
