package com.yiya.action;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.AffiliateRule;
import com.yiya.bean.AntiFraudReportList;
import com.yiya.bean.BlacklistReportList;
import com.yiya.bean.Bondsmaninf;
import com.yiya.bean.BorrowUserOrder;
import com.yiya.bean.OrderBean;
import com.yiya.bean.ScoreBean;
import com.yiya.bean.ScoreReport;
import com.yiya.bean.ScoreReportList;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabAreaBean;
import com.yiya.bean.TabOrderCheckLog;
import com.yiya.bean.TabUsrinf2;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.OrderModel;
import com.yiya.model.ParameterMap;
import com.yiya.service.OrderService;
import com.yiya.service.ScheduledExecutorServiceTask;
import com.yiya.service.ScoreService;
import com.yiya.service.SendMessage;
import com.yiya.service.SysRoleRelService;
import com.yiya.service.SysUserService;
import com.yiya.service.TabUsrOrderPicService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;
import com.yiya.utils.Tools;
import com.yiya.utils.URLUtils;

/**
 * 风控借款控制类
 * @Company tesu
 * @author lifaqiu
 * @date 2017-1-10
 */
@Controller
@RequestMapping("/orderManager") 
public class OrderManagerAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(OrderManagerAction.class);
	
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired(required = false)
	private OrderService<OrderBean> orderService;
	
	@Autowired
	private TabUsrOrderPicService tabUsrOrderPicService;
	
	@Autowired(required = false)
	private ScoreService<ScoreBean> scoreService;
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@Value("${sendToCustomerWhenStartBidding}")
	private String sendToCustomerWhenStartBidding;

	@Value("${sendToRiskControlOperatorWhenStartBidding}")
	private String sendToRiskControlOperatorWhenStartBidding;

	@Value("${sendToRiskControlOperatorWhenStartBidding}")
	private String sendToMarketingOperatorWhenStartBidding;
	
	//审核不通过以后给客户发送短信
	@Value("${sendToCustomerWhenPassFail}")
	private String sendToCustomerWhenPassFail;
	//信用千金审核不通过以后给运营人员发送短信
	@Value("${sendToOperatorWhenPassFail}")
	private String sendToOperatorWhenPassFail;
	//初审通过，发送短信给复审人
	@Value("${approval_first_pass}")
	private String approval_first_pass;
	//复审通过，发送短信给终审人	
	@Value("${approval_second_pass}")
	//终审通过，发送短信给资金专员
	private String approval_second_pass;
	
	@Value("${approval_three_pass}")
	private String approval_three_pass;
	
	@Value("${setMemberToVip}")
	private String setMemberToVipUrl;
	
	@Autowired
	private SendMessage sendMessage;

	@Autowired
	private TabUsrinf2Service tabUsrinf2Service;
	
	@RequestMapping("/orderList") 
	public ModelAndView orderList(HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("getStoreType_url"), "");
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				JSONArray array = JSONArray.parseArray(jsonObject.get("dataList").toString());
				for (Object object : array) {
					JSONObject jsonObject2 = (JSONObject)object;
					Map<String, String> map = new HashMap<String, String>();
					map.put("order_type", jsonObject2.get("store_type_id").toString());
					map.put("name", jsonObject2.get("name").toString());
					dataList.add(map);
				}
			}
		} catch (Exception e) {
			
		}
		context.put("dataList", dataList);
		return forword("orderManager/orderList",context); 
	}
	
	@RequestMapping("/viewOrderById") 
	public ModelAndView viewOrderById(Integer is_check,Integer usr_order_id, HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		BorrowUserOrder borrowUserOrder = orderService.findBorrowUserOrderByUsrOrderId(usr_order_id);
		Integer register_place = borrowUserOrder.getRegister_place();
		String register_place_ = "";
		if (register_place != null && !"0".equals(register_place)) {
			TabAreaBean tabAreaBean = scoreService.findTabAreaBeanByAreaId(register_place);
			while (tabAreaBean != null) {
				String area_name = tabAreaBean.getArea_name();
				if (area_name != null) {
					register_place_ = area_name + register_place_;
				}
				Integer area_parent_id = tabAreaBean.getArea_parent_id();
				if (area_parent_id != null && area_parent_id != 0) {
					tabAreaBean = scoreService.findTabAreaBeanByAreaId(area_parent_id);
				}else {
					tabAreaBean = null;
				}
			}
		}
		borrowUserOrder.setRegister_place_(register_place_);
		borrowUserOrder.setId_card_front_pic(URLUtils.get("picServerIp") + borrowUserOrder.getId_card_front_pic());
		borrowUserOrder.setId_card_reverse_pic(URLUtils.get("picServerIp") + borrowUserOrder.getId_card_reverse_pic());
		borrowUserOrder.setWith_id_card_pic(URLUtils.get("picServerIp") + borrowUserOrder.getWith_id_card_pic());
		
		List<Bondsmaninf> tabOrderBondsmaninfs = scoreService.findBondsmaninfList(usr_order_id);
		
		List<TabOrderCheckLog> tabOrderCheckLogs = orderService.findTabOrderCheckLogsByUsrOrderId(usr_order_id);
		if (tabOrderCheckLogs == null) {
			tabOrderCheckLogs = new ArrayList<TabOrderCheckLog>();
		}
		
		List<String> tempPics = orderService.findOrderPicByUsrOrderId(usr_order_id);
		List<String> pics = new ArrayList<String>();
		if (tempPics != null) {
			for (String pic : tempPics) {
				pics.add(URLUtils.get("picServerIp") + pic);
			}
		}
		
		if (borrowUserOrder.getHave_scoring_report() == 0) {
			borrowUserOrder.setHave_scoring_report(0);
		}else {
			// 客户基本信息，还款能力总结，结论。。。
			ScoreReport scoreReport = scoreService.findScoreReportByUsrOrderId(usr_order_id);
			// 联系人信息
			List<ScoringReportBondsmaninf> scoringReportBondsmaninfs = scoreService.findScoringReportBondsmaninfByReportId(scoreReport.getReport_id());
			// 平台黑名单查询
			List<BlacklistReportList> blacklistReportLists = scoreService.findBlacklistReportListByReportId(scoreReport.getReport_id());
			// 第三方反欺诈信息查询
			List<AntiFraudReportList> antiFraudReportLists = scoreService.findAntiFraudReportListByReportId(scoreReport.getReport_id());
			// 信用评分部分
			List<ScoreReportList> scoreReportLists1 = scoreService.findScoreReportListByReportId(scoreReport.getReport_id());
			// 客户还款实力
			List<ScoreReportList> scoreReportLists2 = scoreService.findScoreReportListByRuleTypeId(1);
			// 手工补充查询部分
			List<AffiliateRule> affiliateRules = scoreService.findAffiliateRuleByReportId(scoreReport.getReport_id());
			
			context.put("scoreReport", scoreReport);
			context.put("scoringReportBondsmaninfs", scoringReportBondsmaninfs);
			context.put("blacklistReportLists", blacklistReportLists);
			context.put("antiFraudReportLists", antiFraudReportLists);
			context.put("scoreReportLists1", scoreReportLists1);
			context.put("scoreReportLists2", scoreReportLists2);
			context.put("affiliateRules", affiliateRules);
		}
		
		context.put("borrowUserOrder", borrowUserOrder);
		context.put("tabOrderBondsmaninfs", tabOrderBondsmaninfs);
		context.put("pics", pics);
		context.put("tabOrderCheckLogs", tabOrderCheckLogs);
		context.put("is_check", is_check);
		context.put("usr_order_id", usr_order_id);
		return forword("orderManager/viewOrderDesc",context); 
	}

	@RequestMapping("/viewOrderAllotById") 
	public ModelAndView viewOrderAllotById(Integer allot,Integer usr_order_id, HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		BorrowUserOrder borrowUserOrder = orderService.findBorrowUserOrderByUsrOrderId(usr_order_id);
		
		List<TabOrderCheckLog> tabOrderCheckLogs = orderService.findTabOrderCheckLogsByUsrOrderId(usr_order_id);
		if (tabOrderCheckLogs == null) {
			tabOrderCheckLogs = new ArrayList<TabOrderCheckLog>();
		}
		
		context.put("borrowUserOrder", borrowUserOrder);
		context.put("tabOrderCheckLogs", tabOrderCheckLogs);
		context.put("allot", allot);
		context.put("usr_order_id", usr_order_id);
		return forword("orderManager/viewOrderAllotDesc",context); 
	}
	
	@RequestMapping("/fundList") 
	public ModelAndView fundList(HttpServletRequest request) throws Exception{
		
		Map<String,Object> context = getRootMap();
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("getStoreType_url"), "");
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				JSONArray array = JSONArray.parseArray(jsonObject.get("dataList").toString());
				for (Object object : array) {
					JSONObject jsonObject2 = (JSONObject)object;
					Map<String, String> map = new HashMap<String, String>();
					map.put("order_type", jsonObject2.get("store_type_id").toString());
					map.put("name", jsonObject2.get("name").toString());
					dataList.add(map);
				}
			}
		} catch (Exception e) {
			
		}
		context.put("dataList", dataList);
		return forword("orderManager/fundList",context); 
	}
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/orderDataList") 
	public void orderDataList(OrderModel model,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		model.setSubmit_step(5);
		boolean check_1 = false;
		boolean check_2 = false;
		boolean check_3 = false;
		boolean createReport = false;
		SysUser sysUser = SessionUtils.getUser(request);
		List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
		for (SysRoleRel sysRoleRel : SysRoleRelList) {
			Integer roleId = sysRoleRel.getRoleId();
			List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
			for (SysRoleRel buttonRels : buttonRelsList) {
				if (buttonRels.getObjId() == 60) {
					check_1 = true;
				}
				if (buttonRels.getObjId() == 61) {
					check_2 = true;
				}
				if (buttonRels.getObjId() == 62) {
					check_3 = true;
				}
				if (buttonRels.getObjId() == 64) {
					createReport = true;
				}
			}
		}
		List<BorrowUserOrder> dataList = orderService.getOrderDataList(model);
		if (dataList != null) {
			for (BorrowUserOrder borrowUserOrder : dataList) {
				borrowUserOrder.setCheck_1(check_1);
				borrowUserOrder.setCheck_2(check_2);
				borrowUserOrder.setCheck_3(check_3);
				borrowUserOrder.setCreateReport(createReport);
				borrowUserOrder.setAdd_usr_id(sysUser.getId());
				try {
					String create_time = borrowUserOrder.getCreate_time();
					create_time = create_time.substring(0, create_time.length() - 2);
					borrowUserOrder.setCreate_time(create_time);
				} catch (Exception e) {
					
				}
			}
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/fundDataList") 
	public void fundDataList(OrderModel model,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		model.setSubmit_step(5);
		model.setCheck_status(3);
		boolean allot = false;
		SysUser sysUser = SessionUtils.getUser(request);
		List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
		for (SysRoleRel sysRoleRel : SysRoleRelList) {
			Integer roleId = sysRoleRel.getRoleId();
			List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
			for (SysRoleRel buttonRels : buttonRelsList) {
				if (buttonRels.getObjId() == 63) {
					allot = true;
				}
			}
		}
		List<BorrowUserOrder> dataList = orderService.getOrderDataList(model);
		if (dataList != null) {
			for (BorrowUserOrder borrowUserOrder : dataList) {
				borrowUserOrder.setAllot(allot);
			}
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/updateCheckStatus") 
	public void updateCheckStatus(Integer usr_order_id, Integer check_status, String check_remark,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("usr_order_id", usr_order_id);
		parameterMap.put("check_status", check_status);
		int i = 0;
		try {
			i = orderService.updateCheckStatus(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "审核失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "审核失败：" + e.getMessage());
		}
		if (i > 0) {
			try {
				if (check_remark == null) {
					check_remark = "";
				}
				//1：待复审，2：待终审，3：审核通过，4：初审不通过，5：复审不通过，6：终审不通过
				String check_result = null;
				switch (check_status) {
				case 1:
					check_result = "初审通过";
					break;
				case 2:
					check_result = "复审通过";
					break;
				case 3:
					check_result = "终审通过";
					break;
				case 4:
					check_result = "初审不通过";
					break;
				case 5:
					check_result = "复审不通过";
					break;
				case 6:
					check_result = "终审不通过";
					break;

				default:
					break;
				}
				SysUser sysUser = SessionUtils.getUser(request);
				TabOrderCheckLog tabOrderCheckLog = new TabOrderCheckLog();
				tabOrderCheckLog.setCheck_remark(check_remark);
				tabOrderCheckLog.setCheck_result(check_result);
				tabOrderCheckLog.setDeal_time(new Date());
				tabOrderCheckLog.setDeal_user(sysUser.getUsr_name());
				tabOrderCheckLog.setDeal_user_id(sysUser.getId());
				tabOrderCheckLog.setUsr_order_id(usr_order_id);
				orderService.addTabOrderCheckLog(tabOrderCheckLog);
			} catch (Exception e) {
				log.info("增加审核日志出错：" + e.getMessage());
			}
		}
		
		BorrowUserOrder borrowUserOrder = orderService.findBorrowUserOrderByUsrOrderId(usr_order_id);
		String newString = "("+borrowUserOrder.getBorrower_usrname()+borrowUserOrder.getBorrower_mobile_phone()+")";
		String content = null;
		switch (check_status) {
		case 1:
			//初审通过，发送短信给复审人
			content = approval_first_pass.replace("()", newString);
			sysUserService.sendMessageByButtonAuthority(content, 61);
			break;
		case 2:
			//复审通过，发送短信给终审人
			content = approval_second_pass.replace("()", newString);
			sysUserService.sendMessageByButtonAuthority(content, 62);
			break;
		case 3:
			//终审通过，发送短信给资金专员
			content = approval_three_pass.replace("()", newString);
			sysUserService.sendMessageByButtonAuthority(content, 63);
			break;
		case 4:
		case 5:
		case 6:
			//不通过，发送给用户
			sendMessage.sendGroupSmsToClient(sendToCustomerWhenPassFail, borrowUserOrder.getBorrower_mobile_phone(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
			//不通过，发送给运营
			content = sendToOperatorWhenPassFail.replace("()", newString);
			sendMessage.sendGroupSmsToClient(content, sendMessage.getMarketingManagerPhones(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
			break;

		default:
			break;
		}
		
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/updateOrderAllot") 
	public void updateOrderAllot(Integer usr_order_id, Integer order_allot, String check_remark,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("usr_order_id", usr_order_id);
		parameterMap.put("order_allot", order_allot);
		parameterMap.put("check_status", 7);
		int i = 0;
		try {
			i = orderService.updateCheckStatus(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "分配失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "分配失败：" + e.getMessage());
		}
		if (i > 0) {
			try {
				if (check_remark == null) {
					check_remark = "";
				}
				String check_result = "分配成功";
				SysUser sysUser = SessionUtils.getUser(request);
				TabOrderCheckLog tabOrderCheckLog = new TabOrderCheckLog();
				tabOrderCheckLog.setCheck_remark(check_remark);
				tabOrderCheckLog.setCheck_result(check_result);
				tabOrderCheckLog.setDeal_time(new Date());
				tabOrderCheckLog.setDeal_user(sysUser.getUsr_name());
				tabOrderCheckLog.setDeal_user_id(sysUser.getId());
				tabOrderCheckLog.setUsr_order_id(usr_order_id);
				orderService.addTabOrderCheckLog(tabOrderCheckLog);
			} catch (Exception e) {
				log.info("增加审核日志出错：" + e.getMessage());
			}
			
			// 如果是P2P
			if (order_allot == 1) {
				final int oid = usr_order_id;
				ScheduledExecutorServiceTask.scheduledThreadPool.execute(new Runnable() {
					
					@Override
					public void run() {
						createBidding(oid);
					}
				});
			}
		}
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 发标
	 * @ps:
	 * @author lifaqiu
	 * @date 2017-1-13
	 * @param usr_order_id
	 * @return
	 */
	private void createBidding(int usr_order_id) {
		BorrowUserOrder borrowUserOrder = orderService.findBorrowUserOrderByUsrOrderId(usr_order_id);
		TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId((long)borrowUserOrder.getBorrow_uid());
		if (tabUsrinf2 == null) {
			log.info("setUsrOrder根据usrId=" + borrowUserOrder.getBorrow_uid() + "无法找到记录");
			return ;
		}
		// 组装参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("order_id", borrowUserOrder.getOrder_sn());
		params.put("borrow_uid", borrowUserOrder.getBorrow_uid().toString());
		params.put("borrow_name", borrowUserOrder.getBorrow_name());
		params.put("borrow_money", borrowUserOrder.getOrder_money());
		params.put("borrow_duration", borrowUserOrder.getBorrow_duration().toString());
		params.put("interest_type", borrowUserOrder.getInterest_type().toString());
		params.put("borrow_interest", borrowUserOrder.getBorrow_interest().toString());
		params.put("borrow_interest_rate", borrowUserOrder.getBorrow_interest_rate().toString());
		params.put("fee", borrowUserOrder.getFee().toString());
		params.put("borrow_use_desc", borrowUserOrder.getBorrow_use_desc());
		String borrow_info = borrowUserOrder.getBorrow_info();
		try {
			borrow_info = URLEncoder.encode(borrow_info, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			borrow_info = "";
		}
		params.put("borrow_info", borrow_info);
		
		List<String> tempPics = orderService.findOrderPicByUsrOrderId(usr_order_id);
		StringBuffer picPath = new StringBuffer();
		if (tempPics != null) {
			int size = tempPics.size();
			for (int i = 0; i < size; i++) {
				if (i == size - 1) {
					picPath.append(URLUtils.get("picServerIp") + tempPics.get(i));
				}else {					
					picPath.append(URLUtils.get("picServerIp") + tempPics.get(i)).append("|");
				}
			}
		}
		
		// 图片路径拼接字符串
		params.put("picPath", picPath.toString());
		params.put("borrow_use", borrowUserOrder.getBorrow_use().toString());
		log.info("createBiddingUrl param" + params.toString());
		String createBidding = URLUtils.get("createBidding");
		// 调用发标接口
		String result = HttpRequestUtil.sendPost(createBidding, Tools.createLinkString(params, false));
		if (StringUtil.isEmpty(result)) {
			log.info("调用链金所接口失败 userId:" + borrowUserOrder.getBorrow_uid());
			return;
		}
		log.info("createBiddingUrl result" + result.toString());
		JSONObject reusltObj = JSONObject.parseObject(result);
		if (reusltObj.getIntValue("code") == WebServiceConstant.CODE_SUCCESS) {
			String userPhone = tabUsrinf2.getMobile_phone();
			// 发标成功以后给客户发送短信
			sendMessage.sendGroupSmsToClient(sendToCustomerWhenStartBidding, userPhone,
					WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
			// 发标成功以后给风控发送短信
			sysUserService.sendMessageByButtonAuthority(
					sendMessage.insertContentPhoneNumber(sendToRiskControlOperatorWhenStartBidding, userPhone),
					WebServiceConstant.BORROW_CHECK_BUTTON_ID);
			// 发标成功以后给运营人员发送短信
			sendMessage.sendGroupSmsToClient(
					sendMessage.insertContentPhoneNumber(sendToMarketingOperatorWhenStartBidding, userPhone),
					sendMessage.getMarketingManagerPhones(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
			// 设置借款人为投资人
			setMemberToVip(tabUsrinf2.getUsrid());
			BigDecimal amount = new BigDecimal(borrowUserOrder.getOrder_money());
			amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
//			// 异步调用采集系统
//			threadPoolTaskExecutor.execute(new InvocateFkGatherDataTask(tabUsrinf2.getUsrid(), tabUsrinf2.getBorrower_usrname(),
//							tabUsrinf2.getBorrower_mobile_phone(), tabUsrinf2.getBorrower_id_card(), "",
//							tabUsrinf2.getBank_id(), borrowUserOrder.getOrder_source(), amount, borrowUserOrder.getOrder_sn()));
		} else {
			log.info("调用链金所接口失败 userId:" + borrowUserOrder.getBorrow_uid());
		}
	}
	
	/**
	 * 设置会员等级
	 * @ps:
	 * @author lifaqiu
	 * @date 2017-1-13
	 * @param usrid
	 * @return
	 */
	private void setMemberToVip(Long usrid) {
		log.info("setMemberToVipUrl request param--" + "usrid=" + usrid + ",vip=1");
		String result = HttpRequestUtil.sendPost(setMemberToVipUrl, "is_vip=1&usrid=" + usrid);
		if (StringUtil.isEmpty(result)) {
			log.info("设置借款人失败,usrid=" + usrid);
			return;
		}
		JSONObject resultObj = JSONObject.parseObject(result);
		if (resultObj.getIntValue("code") == WebServiceConstant.CODE_SUCCESS) {
			log.info("设置借款人成功,usrid=" + usrid);
		} else {
			log.info("设置借款人失败,usrid=" + usrid);
		}
	}

	@RequestMapping("/updateUmpire") 
	public void updateUmpire(Integer report_id, String refund_verdict, String umpire,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (refund_verdict == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写还款能力总结");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (umpire == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写批判人");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("report_id", report_id);
		parameterMap.put("refund_verdict", refund_verdict);
		parameterMap.put("umpire", umpire);
		int i = 0;
		try {
			i = orderService.updateReportInfo(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "保存失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "保存失败：" + e.getMessage());
		}
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/updateFirstPerson") 
	public void updateFirstPerson(Integer report_id, String first_trial_verdict, String first_person,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (first_trial_verdict == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写初审结论");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (first_person == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写初审人");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("report_id", report_id);
		parameterMap.put("first_trial_verdict", first_trial_verdict);
		parameterMap.put("first_person", first_person);
		int i = 0;
		try {
			i = orderService.updateReportInfo(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "保存失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "保存失败：" + e.getMessage());
		}
		
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/updateRecheck") 
	public void updateRecheck(Integer report_id, String recheck_verdict, String recheck_person,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (recheck_verdict == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写复审结论");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (recheck_person == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写复审人");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("report_id", report_id);
		parameterMap.put("recheck_verdict", recheck_verdict);
		parameterMap.put("recheck_person", recheck_person);
		int i = 0;
		try {
			i = orderService.updateReportInfo(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "保存失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "保存失败：" + e.getMessage());
		}
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/updateLast") 
	public void updateLast(Integer report_id, String last_trial_verdict, String last_person,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (last_trial_verdict == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写终审结论");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (last_person == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "请填写终审人");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("report_id", report_id);
		parameterMap.put("last_trial_verdict", last_trial_verdict);
		parameterMap.put("last_person", last_person);
		int i = 0;
		try {
			i = orderService.updateReportInfo(parameterMap.getMap());
			if (i <= 0) {
				jsonMap.put("code", -1);
				jsonMap.put("msg", "保存失败");
			}
		} catch (Exception e) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "保存失败：" + e.getMessage());
		}
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
}
