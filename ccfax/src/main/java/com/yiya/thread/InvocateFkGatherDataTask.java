package com.yiya.thread;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrinf2;
import com.yiya.constant.WebServiceConstant;
import com.yiya.service.ScoreService;
import com.yiya.service.TabUsrOrderService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.ApplicationUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.Tools;
import com.yiya.utils.URLUtils;

/**
 * @author frank_wang [JackLikeYou2016@gmail.com]
 * @date 2016年12月19日
 * @description 调用风控采集项目
 */
public class InvocateFkGatherDataTask implements Runnable{
	
	private final static Logger log = Logger.getLogger(InvocateFkGatherDataTask.class);
	
	private Long usrid;
	
	private String name;
	
	private String mobile;
	
	private String cardId;
	
	private String gather_token;
	
	private String bankID;
	
	private Integer order_source;
	
	private BigDecimal amount;
	
	private String order_sn;
	
	private ScoreService scoreService;
	
	private TabUsrOrderService tabUsrOrderService;
	
	private TabUsrinf2Service tabUsrinf2Service;
	
	public InvocateFkGatherDataTask(){
		
	}
	
	public InvocateFkGatherDataTask(Long usrid,String name,String mobile,String cardId,String gather_token, String bankID,Integer order_source,
			BigDecimal amount,String order_sn){
		
		this.usrid = usrid;
		this.name = name;
		this.cardId = cardId;
		this.mobile = mobile;
		this.gather_token = gather_token;
		this.bankID = bankID;
		this.order_source = order_source;
		this.amount = amount;
		this.order_sn = order_sn;
	}

	
	@Override
	public void run() {
		try {
			log.info("进入采集run方法----------"+toString());
			//获取相应service
			scoreService = (ScoreService)ApplicationUtil.getBean("scoreService");
			tabUsrOrderService = (TabUsrOrderService)ApplicationUtil.getBean("tabUsrOrderService");
			tabUsrinf2Service = (TabUsrinf2Service)ApplicationUtil.getBean("tabUsrinf2Service");
			//保存基本信息到采集表
			TabUsrOrder  queryOrder = tabUsrOrderService.queryOrderByOrderNo(order_sn);
			Map<String, Object> saveGatherMap = new HashMap<String, Object>();
			saveGatherMap.put("age", queryOrder.getAge());
			saveGatherMap.put("sex", queryOrder.getSex());
			saveGatherMap.put("marital", queryOrder.getMarital());
			saveGatherMap.put("diploma", queryOrder.getDiploma());
			saveGatherMap.put("local_register_place", queryOrder.getLocal_register_place());
			saveGatherMap.put("register_place", queryOrder.getRegister_place());
			saveGatherMap.put("industry", queryOrder.getIndustry());
			saveGatherMap.put("profession_level", queryOrder.getProfession_level());
			saveGatherMap.put("cur_hire_duration", queryOrder.getCur_hire_duration());
			saveGatherMap.put("income", queryOrder.getIncome());
			saveGatherMap.put("house_type", queryOrder.getHouse_type());
			saveGatherMap.put("fixed_assets", queryOrder.getFixed_assets());
			saveGatherMap.put("usrid", queryOrder.getBorrow_uid());
			tabUsrinf2Service.saveToGatherTable(saveGatherMap);
			
			
			//调用采集系统接口采集数据
			Map<String, HashSet<String>> resultMap = getGatherFields();
			if(resultMap == null){
				log.error("未获取到采集字段");
				return;
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("usrid", usrid.toString());
			params.put("name", name);
			params.put("cardID", cardId);
			params.put("gather_token", gather_token);
			params.put("mobile", mobile);
			params.put("bankID", bankID);
			params.put("gather_fields",JSONObject.toJSONString(resultMap));
		    HttpRequestUtil.sendPost(URLUtils.get("gatherDataUrl"), Tools.createLinkString(params, false));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("调用采集项目报错,usrid="+usrid);
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月16日
	 * @description 根据订单金额和业务规则类型  获取采集所需字段
	 * @return
	 */
	private Map<String, HashSet<String>> getGatherFields(){
		//获取对应的规则集ID
		Integer rule_set_type_id = new Integer(0);
		if(WebServiceConstant.ORDER_SOURCE_MIAO_SHE.equals(order_source)){
			rule_set_type_id = WebServiceConstant.TAB_RULE_SET_TYPE_MIAO_SHE;
		}
		Integer rule_set_id = scoreService.getRuleSetIdByTypeIdAndAmount(amount, rule_set_type_id);
		if(rule_set_id == null){
			log.error("未查找到对应的规则集，amount="+amount+",rule_set_type_id="+rule_set_type_id);
			return null;
		}
		//根据规则集获取需采集的字段
		Map<String, HashSet<String>> resultMap = scoreService.getGatherFiledsByRuleId(rule_set_id);
		if(resultMap == null){
			log.error("根据规则集ID未获取到需要采集的字段，rule_set_id="+rule_set_id);
			return null;
		}
		//保存rule_set_id到订单表
		TabUsrOrder order = new TabUsrOrder();
		order.setOrder_sn(order_sn);
		order.setRule_set_id(Long.valueOf(rule_set_id));
		tabUsrOrderService.updateByOrderSnSelective(order, order_sn);
		return resultMap;
	}

	@Override
	public String toString() {
		return "InvocateFkGatherDataTask [usrid=" + usrid + ", name=" + name + ", mobile=" + mobile + ", cardId="
				+ cardId + ", gather_token=" + gather_token + ", bankID=" + bankID + ", order_source=" + order_source
				+ ", amount=" + amount + ", order_sn=" + order_sn + "]";
	}
	
}
