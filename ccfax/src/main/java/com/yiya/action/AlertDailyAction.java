package com.yiya.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.aop.Key;
import com.yiya.bean.AlertConfig;
import com.yiya.bean.AlertDaily;
import com.yiya.model.AlertConfigModel;
import com.yiya.model.AlertDailyModel;
import com.yiya.service.AlertConfigService;
import com.yiya.service.AlertDailyService;
import com.yiya.utils.HtmlUtil;


 
@Controller
@RequestMapping("/alertDaily") 
public class AlertDailyAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(AlertDailyAction.class);
	
	
	@Autowired(required=false)
	private  AlertDailyService<AlertDaily> alertDailyService; 
	
	@Autowired(required=false)
	private AlertConfigService<AlertConfig> alertConfigService;
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(AlertDailyModel model,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("fk/alertDaily",context); 
	}
	
	
	/**
	 * 预警中心信息列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  dataList(AlertDailyModel model,HttpServletResponse response) throws Exception{
		  Map<String, Object> params = new HashMap<String, Object>();
		  Integer total = alertDailyService.queryCountAll();//查询记录总条数
		  
		  int startRow = (model.getPage()-1)*model.getRows();
		  params.put("startRow", startRow);
		  params.put("rows", model.getRows());
		  params.put("alert_time_start", model.getAlert_time_start());//根据警告时间查询
		  params.put("alert_time_end", model.getAlert_time_end());
		  params.put("deal_status",model.getDeal_status());//根据处理状态查询
		  params.put("deal_with", model.getDeal_with());//根据处理人查询
		  List<AlertDaily> dataList = alertDailyService.queryByAll(params);
		  
		  Map<String, Object> jsonMap = new HashMap<String, Object>();
		  jsonMap.put("total",total);//返回记录数
		  jsonMap.put("rows", dataList);//返回页面数据
		  HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**预警中心信息添加**/
	@RequestMapping("/addAlertDaily")
	@Key(operation="预警中心信息添加",param="addAlertDaily")
	public void addAlertDaily(AlertDaily bean,HttpServletResponse response) throws Exception{
		alertDailyService.add(bean);
	}
	
	/**
	 * 修改预警中心信息
	 */
	@RequestMapping("/updateAlertDaily")
	@Key(operation=" 修改预警中心信息",param="updateAlertDaily")
	public void updateAlertDaily(String  alert_id,String deal_status, HttpServletResponse response) throws Exception{
		Map<String,Object>  params = new HashMap<String,Object>();
		params.put("alert_id", alert_id);
		params.put("deal_status", deal_status);
		alertDailyService.updateAlertDaily(params);
	}
	
	/**
	 * 预警配置信息页面列表
	 * @throws Exception
	 */
	@RequestMapping("/alertConfigList") 
	public void  alertConfigList(AlertConfigModel model,HttpServletResponse response) throws Exception{
		Map<String,Object>  params = new HashMap<String,Object>();
		int startRow = (model.getPage()-1)*model.getRows();
		params.put("startRow", startRow);
		params.put("rows", model.getRows());
		List<AlertConfig> dataList = alertConfigService.queryByAll(params);
		
	    Map<String, Object> jsonMap = new HashMap<String, Object>();
	    jsonMap.put("total",alertConfigService.queryCountAll());//返回记录数
	    jsonMap.put("rows", dataList);//返回页面数据
	    HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 修改预警配置信息
	 */
	@RequestMapping("/updateAlertConfig")
	@Key(operation="修改预警配置信息",param="updateAlertConfig")
	public void updateAlertConfig(String id,String msg_status, String msg_content,String wcmr_tel, HttpServletResponse response) throws Exception{
		Map<String,Object>  params = new HashMap<String,Object>();
		params.put("id", id);
		params.put("msg_status", msg_status);
		
		params.put("wcmr_tel", wcmr_tel);
		//params.put("msg_content", msg_content);
		alertConfigService.updateAlertConfig(params);
	}
	
	
}
