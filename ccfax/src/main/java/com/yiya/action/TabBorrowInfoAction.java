package com.yiya.action;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabBorrowInfo;
import com.yiya.bean.TabDebtBorrowInfo;
import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrDecorationOrder;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf2;
import com.yiya.bean.UsrccfaxInf;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.AllWoodOrderTemp;
import com.yiya.model.BiddingOperationLog;
import com.yiya.model.DataParameterModel;
import com.yiya.model.LzhMemberModel;
import com.yiya.model.TabBorrowInfoModel;
import com.yiya.model.TabUsrComplementPicModel;
import com.yiya.service.SendMessage;
import com.yiya.service.SysRoleRelService;
import com.yiya.service.SysUserService;
import com.yiya.service.TabUsrComplementPicService;
import com.yiya.service.TabUsrDecorationContractPicService;
import com.yiya.service.TabUsrDecorationOrderService;
import com.yiya.service.TabUsrOrderPicService;
import com.yiya.service.TabUsrOrderService;
import com.yiya.service.TabUsrPremisePermitPicService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.DateUtil;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.ShellUtil;
import com.yiya.utils.StringUtil;
import com.yiya.utils.Tools;
import com.yiya.utils.URLUtils;

@Controller
@RequestMapping("/borrowList")
public class TabBorrowInfoAction extends BaseAction {

	private final static Logger log = Logger.getLogger(TabBorrowInfoAction.class);
	
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired
	private TabUsrinf2Service tabUsrinf2Service;
	
	@Autowired(required = false)
	private SysUserService sysUserService;
	
	@Autowired
	private TabUsrPremisePermitPicService<TabUsrPremisePermitPic> tabUsrPremisePermitPicService;
	
	@Autowired
	private TabUsrDecorationContractPicService<TabUsrDecorationContractPic> tabUsrDecorationContractPicService;
	
	@Autowired
	private TabUsrComplementPicService<TabUsrComplementPic> tabUsrComplementPicService;
	
	@Autowired
	private TabUsrDecorationOrderService<TabUsrDecorationOrder> tabUsrDecorationOrderService;
	
	@Autowired
	private TabUsrOrderService tabUsrOrderService;
	
	@Autowired
	private TabUsrOrderPicService tabUsrOrderPicService;
	
	@Autowired
	private SendMessage sendMessage;

	@Value("${updateBiddingStatusUrl}")
	private String updateBiddingStatusUrl;

	@Value("${leGouBiddingNotPassedMessage}")
	private String leGouBiddingNotPassedMessage;

	@Value("${leZhuangBiddingNotPassedMessage}")
	private String leZhuangBiddingNotPassedMessage;
	
	@Value("${sendToCustomerWhenPassFail}")
	private String sendToCustomerWhenPassFail;
	
	@Value("${getInterestInf}")
	private String getInterestInf;
	
	@Value("${isBindBankCard}")
	private String isBindBankCard;
	
	@Value("${getDebtBiddingListUrl}")
	private String getDebtBiddingListUrl;
	
	@Value("${review_debt_borrow_info_url}")
	private String review_debt_borrow_info_url;
	
	@Value("${picServerPath}")
	private String picServerPath;
	
	@Value("${picServerIp}")
	private String picServerIp;

	@Value("${sendToOperatorWhenPassFail}")
	private String sendToOperatorWhenPassFail;
	
	@Value("${sendToOperatorWhenBiddingFirstPass}")
	private String sendToOperatorWhenBiddingFirstPass;
	
	
	@RequestMapping("/list")
	public ModelAndView list(TabBorrowInfoModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		return forword("borrowManager/borrowList", context);
	}
	
	@RequestMapping("/debtList")
	public ModelAndView debtList(TabBorrowInfoModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("borrowManager/debtList", context);
	}

	/**
	 * @author Administrator
	 * @data 2016年11月15日
	 * @description
	 * @param model
	 * @param hrefType 页面跳转类型，1表示跳转到标的审核页面  2表示跳转到标的修改页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/borrowCheck")
	public ModelAndView borrowCheck(TabBorrowInfoModel model,String hrefType, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		//从用户表获取  可用额度以及总额度
		if (null != model.getBorrow_uid()) {
			TabUsrinf2 bean = tabUsrinf2Service.queryTabUsrinf2ByUsrId(Long.valueOf(model.getBorrow_uid()));
			if (null != bean) {
				BigDecimal loan_limit = bean.getLoan_limit();
				context.put("loan_limit", loan_limit == null ? new BigDecimal(0) : loan_limit);
			} else {
				context.put("loan_limit", new BigDecimal(0));
			}
		}
		TabBorrowInfo tabBorrowInfo = getBorrowInfoByBiddingId(model.getBidding_id());
		// 处理数据格式：总手续费两位小数
		if (tabBorrowInfo.getBorrow_interest() != null) {
			tabBorrowInfo.setBorrow_interest(tabBorrowInfo.getBorrow_interest().setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		//解析商品图片字符串
		List<String> picList = new ArrayList<String>();
		if(!StringUtil.isEmpty(tabBorrowInfo.getUpdata())){
			if(tabBorrowInfo.getUpdata().contains("|")){
				String[] array = tabBorrowInfo.getUpdata().split("\\|");
				Collections.addAll(picList, array);
			}else{
				picList.add(tabBorrowInfo.getUpdata());
			}
			context.put("picList", picList);
		}
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		context.put("tabBorrowInfo", tabBorrowInfo);
		List<String> mosaicList = new ArrayList<String>();
		if(WebServiceConstant.HREF_TYPE_CHECK.equals(hrefType)){
			//解析打码图片
			List<TabUsrOrderPic> tabUsrOrderPicMosaicList = tabUsrOrderPicService.queryPicByOrderSnAndPicType(new TabUsrOrderPic(tabBorrowInfo.getOrder_id(),
					new Byte(WebServiceConstant.PIC_TYPE_MOSAIC),null));
			if(tabUsrOrderPicMosaicList != null && tabUsrOrderPicMosaicList.size() > 0){
				for(TabUsrOrderPic tempPic:tabUsrOrderPicMosaicList){
					if(tempPic.getPic_addr() != null){
						mosaicList.add(picServerIp+tempPic.getPic_addr());
					}
				}
			}
			context.put("mosaicList", mosaicList);
			return forword("borrowManager/borrowCheck", context);	
		}else{
			return forword("borrowManager/modifyBiddingInfo", context);
		}
	}

	/**
	 * 调用链金所标的接口getBiddingList获取借款列表数据
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("dataList")
	public void dataList(TabBorrowInfoModel model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			SysUser sysUser = SessionUtils.getUser(request);
			List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
			for (SysRoleRel sysRoleRel : SysRoleRelList) {
				Integer roleId = sysRoleRel.getRoleId();
				List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
				for (SysRoleRel buttonRels : buttonRelsList) {
					if (buttonRels.getObjId() == 30) {
						model.setVeriy_auth(true);
					}
					//标的信息修改
					if (buttonRels.getObjId() == 53) {
						model.setModify_bidding_auth(true);
					}
				}
			}
			Boolean veriy_auth = model.isVeriy_auth();
			Boolean modify_bidding_auth = model.isModify_bidding_auth();
			Integer borrow_status = model.getBorrow_status();
			Long borrow_uid = model.getBorrow_uid(); // 借款人id即授信额度平台统一usrid
			String bidding_id = model.getBidding_id();
			Integer product_type = model.getProduct_type();
			Integer page_no = model.getPage();
			Integer page_number = model.getPager().getPageSize();
			if (null == borrow_status) {
				borrow_status = 3;
			}
			if (null == page_no) {
				page_no = 1;
			}
			if (null == page_number) {
				page_number = 10;
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("borrow_status", borrow_status.toString());
			params.put("borrow_uid", borrow_uid == null ? "" : borrow_uid.toString());
			params.put("bidding_id", bidding_id == null ? "" : bidding_id.toString());
			params.put("product_type", product_type == null ? "" : product_type.toString());
			params.put("page_no", page_no.toString());
			params.put("page_number", page_number.toString());
			params.put("_input_charset", "UTF-8");
			// 发标开始日期
			if (model.getAdd_time_start_time() != null) {
				String addTimeStartTimeString = String.valueOf(model.getAdd_time_start_time().getTime());
				// 精确到秒
				params.put("add_time_start_time",
						addTimeStartTimeString.substring(0, addTimeStartTimeString.length() - 3));
			}
			// 发标结束日期
			if (model.getAdd_time_end_time() != null) {
				String addTimeEndTimeString = String.valueOf(model.getAdd_time_end_time().getTime());
				// 精确到秒
				params.put("add_time_end_time", addTimeEndTimeString.substring(0, addTimeEndTimeString.length() - 3));
			}
			String url = URLUtils.get("getBiddingList");
			log.info("dataList getBiddingList url--"+url);
			log.info("getBiddingList接口请求参数为" + params.toString());
			// 调用接口
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("getBiddingList返回结果" + data);
			// 用urldecode反编码处理结果
			String result = data;
			if (StringUtil.isEmpty(result)) {
				sendFailureMessage(response, "获取链金所标的接口失败！");
				return;
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				JSONObject jsonObject = new JSONObject(return_param);
				String record_total = jsonObject.get("record_total").toString();
				String page_total = jsonObject.get("page_total").toString();
				String bidding_list = jsonObject.get("bidding_list").toString();
				List<TabBorrowInfo> biddBorrowInfosList = com.alibaba.fastjson.JSONObject.parseArray(bidding_list,
						TabBorrowInfo.class);
				log.info("调用链金所标的接口getBiddingList获取借款列表数据成功！借款人borrow_uid=" + borrow_uid + ";标号bidding_id="
						+ bidding_id);
				for (TabBorrowInfo info : biddBorrowInfosList) {
					info.setVeriy_auth(veriy_auth);
					info.setModify_bidding_auth(modify_bidding_auth);
					// 发标时间转换
					if (info.getAdd_time() != null && !new Integer(0).equals(info.getAdd_time())) {
						long add_time = Long.parseLong(info.getAdd_time() + "000");
						java.util.Date add_time_descDate = new java.util.Date(add_time);
						info.setAdd_time_descDate(add_time_descDate);
					} else {
						info.setAdd_time_descDate(null);
					}
					// 处理时间转换
					if (info.getDeal_time() != null && !new Integer(0).equals(info.getDeal_time())) {
						long deal_time = Long.parseLong(info.getDeal_time() + "000");
						java.util.Date deal_time_descDate = new java.util.Date(deal_time);
						info.setDeal_time_descDate(deal_time_descDate);
					} else {
						info.setDeal_time_descDate(null);
					}
					//处理标的操作日志
					List<BiddingOperationLog> biddingOperationLogList = info.getCheck_remark_dataList();
					if (null != biddingOperationLogList && biddingOperationLogList.size() > 0) {
						for (BiddingOperationLog log : biddingOperationLogList) {
							if (!log.getDeal_time().equals(0)) {
								long deal_time = Long.parseLong(log.getDeal_time() + "000");
								java.util.Date deal_time_date = new java.util.Date(deal_time);
								log.setDeal_time_date(deal_time_date);
							}
							if (!log.getBorrow_add_time().equals(0)) {
								long borrow_add_time = Long.parseLong(log.getBorrow_add_time() + "000");
								java.util.Date borrow_add_time_date = new java.util.Date(borrow_add_time);
								log.setBorrow_add_time_date(borrow_add_time_date);
							}
							if (null != log.getDeal_user()) {
								SysUser bean = sysUserService.queryById(log.getDeal_user());
								if (null != bean) {
									log.setDeal_user(bean.getReal_name());
								}
							}
						}
					}
					//借款审核处理人
					String deal_userid = info.getDeal_userid();
					if (null != deal_userid) {
						SysUser bean = sysUserService.queryById(deal_userid);
						if (null != bean) {
							info.setDeal_userid_name(bean.getReal_name());
						} else {
							info.setDeal_userid_name("");
						}
					} else {
						info.setDeal_userid_name("");
					}
				}
				// 设置页面数据
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("page_total", page_total); // 总页数
				jsonMap.put("total", record_total);// 总条数
				jsonMap.put("rows", biddBorrowInfosList);
				HtmlUtil.writerJson(response, jsonMap);

			}else {
				String msg = jsonObj.get("msg").toString();
				sendFailureMessage(response, "获取链金所标的接口失败！" + msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	/**
	 * 查询是否有代付卡
	 * 
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isBindBankCard")
	@ResponseBody
	public JsonResponse isBindBankCard(String usrid) throws Exception {
         
		if(StringUtil.isEmpty(usrid)){
			return JsonResponse.fail("usrId should not be null");
		}
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("usrid", usrid);
		String result = HttpRequestUtil.sendPost(isBindBankCard, Tools.createLinkString(map, false));
		if(com.alibaba.fastjson.JSONObject.parseObject(result).getIntValue("code") == 0){
			return JsonResponse.success();
		}else{
			return JsonResponse.fail();
		}
	}
	
	/**
	 * 获取债权标列表
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("debtDataList")
	public void debtDataList(DataParameterModel model,Integer borrow_id, String user_name,Date start_time,Date end_time,Integer borrow_status, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			Integer page_no = model.getPage();
			Integer page_number = model.getPager().getPageSize();
			if (null == page_no) {
				page_no = 1;
			}
			if (null == page_number) {
				page_number = 10;
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("borrow_status", borrow_status == null ? "7" : borrow_status.toString());
			if (borrow_id != null) {
				params.put("bidding_id", borrow_id.toString());
			}
			if (user_name != null && !"".equals(user_name)) {
				params.put("user_name", user_name);
			}
			params.put("page_no", page_no.toString());
			params.put("page_number", page_number.toString());
			params.put("_input_charset", "UTF-8");
			// 发标开始日期
			if (start_time != null) {
				// 精确到秒
				params.put("start_time", start_time.getTime()/1000 + "");
			}
			// 发标结束日期
			if (end_time != null) {
				params.put("end_time", end_time.getTime()/1000 + "");
			}
			String url = URLUtils.get("getDebtBiddingListUrl");
			log.info("dataList getDebtBiddingListUrl url--"+url);
			log.info("getDebtBiddingListUrl接口请求参数为" + params.toString());
			// 调用接口
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("getDebtBiddingListUrl返回结果" + data);
			// 用urldecode反编码处理结果
			String result = data;
			if (StringUtil.isEmpty(result)) {
				sendFailureMessage(response, "获取链金所债权标的接口失败！");
				return;
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				JSONObject jsonObject = new JSONObject(return_param);
				String record_total = jsonObject.get("record_total").toString();
				String page_total = jsonObject.get("page_total").toString();
				String bidding_list = jsonObject.get("bidding_list").toString();
				List<TabDebtBorrowInfo> biddBorrowInfosList = com.alibaba.fastjson.JSONObject.parseArray(bidding_list,
						TabDebtBorrowInfo.class);
				// 设置页面数据
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("page_total", page_total); // 总页数
				jsonMap.put("total", record_total);// 总条数
				jsonMap.put("rows", biddBorrowInfosList);
				HtmlUtil.writerJson(response, jsonMap);
				
			} else {
				String msg = jsonObj.get("msg").toString();
				sendFailureMessage(response, "获取链金所债权标的接口失败！" + msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置标的状态接口[风控借款列表初审按钮]
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("setBiddingStatus")
	@ResponseBody
	public JsonResponse setBiddingStatus(String bidding_id, String borrow_status, String add_time, String deal_user,
			String check_remark, String order_id, String borrow_uid, String borrow_info, String borrow_use,
			HttpServletRequest request,String is_tocard,String add_image_list, HttpServletResponse response) throws Exception {

		try {
			log.info("borrow_use:" + borrow_use);
			TabUsrOrder tabUsrOrder = tabUsrOrderService.queryOrderByOrderNo(order_id);
			if (StringUtil.isEmpty(bidding_id)) {
				return JsonResponse.fail("标的id不能为空！");
			}
			if (StringUtil.isEmpty(borrow_status)) {
				borrow_status = "1";// 默认审核不通过
			}
			if (StringUtil.isEmpty(add_time)) {
				add_time = "0"; // 发标时间不填写默认为0
			} else {
				String temp_time = Long.toString(getTimeStemp(add_time));
				if (temp_time.length() > 3) {
					add_time = temp_time.substring(0, temp_time.length() - 3);
				}
			}
			if (StringUtil.isEmpty(deal_user)) {
				SysUser sysUser = SessionUtils.getUser(request); // 获取当前处理人(审核人)id
				deal_user = sysUser.getId().toString();
			}
			if (StringUtil.isEmpty(check_remark)) {
				check_remark = "";
			}
			//去除最后的| 分期购打码图片
			if(!StringUtil.isEmpty(add_image_list)){
				if ("|".equals(add_image_list.substring(add_image_list.length() - 1))) {
					add_image_list = add_image_list.substring(0, add_image_list.length()-1);
				}	
			}
			String str = "bidding_id=" + bidding_id + "&borrow_status=" + borrow_status + "&add_time=" + add_time
					+ "&deal_user=" + deal_user + "&check_remark=" + check_remark + "&borrow_info=" + URLEncoder.encode(borrow_info, "UTF-8")
					+ "&add_image_list=" + add_image_list+"&is_tocard="+is_tocard;
			String url = URLUtils.get("setBiddingStatus");
			log.info("setBiddingStatus接口请求参数" + str);
			// 调用接口
			String data = HttpRequestUtil.sendPost(url, str);
			log.info("setBiddingStatus返回结果" + data);
			// 用urldecode反编码处理结果
			String result = URLDecoder.decode(data, "UTF-8");
			if (StringUtil.isEmpty(result)) {
				return JsonResponse.fail("借款列表调用,请求链金所设置标的状态接口失败！");
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			String msg = jsonObj.get("msg").toString();
			if (null != response_code && "0".equals(response_code)) {
				log.info("设置标的状态接口调用成功！审核的标号bidding_id=" + bidding_id);
				if (WebServiceConstant.BORROW_STATUS_CHECK_FAIL.toString().equals(borrow_status)) {
					if ("9".equals(borrow_use)) {
						// 如果标的审核不通过短信通知客户
						log.info("开始发送短信");
						//发送给客户
						sendMessage.sendGroupSmsToClient(sendToCustomerWhenPassFail, tabUsrOrder.getBorrower_mobile_phone(),WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
						//发送给运营人员
						sendMessage.sendGroupSmsToClient(new StringBuffer(sendToOperatorWhenPassFail).
								insert(3, tabUsrOrder.getBorrower_mobile_phone()).toString(),
								sendMessage.getMarketingManagerPhones(),WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
					}
				    //修改订单状态以及审核意见
				    tabUsrOrderService.updateByOrderSnSelective(new TabUsrOrder(order_id, WebServiceConstant.ORDER_STATUS_CHECK_FAIL,new Date(),check_remark), order_id);
				}else if(WebServiceConstant.BORROW_STATUS_CHECK_SUCCESS.toString().equals(borrow_status)){
					if ("9".equals(borrow_use)) {
						//审核成功发送短信给运营
						sendMessage.sendGroupSmsToClient(new StringBuffer(sendToOperatorWhenBiddingFirstPass).
								insert(3, tabUsrOrder.getBorrower_mobile_phone()).toString()
								, sendMessage.getMarketingManagerPhones(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
					}
					tabUsrOrderService.updateByOrderSnSelective(new TabUsrOrder(order_id, null,new Date(),check_remark), order_id);
				}
				
				return JsonResponse.success("审核成功！");
			} else {
				System.out.println(msg);
				log.error(msg);
				return JsonResponse.fail(msg);
			}
		} catch (Exception e) {
			log.error("全木行设置标的状态接口请求失败,请检查参数是否设置正确！", e);
			return JsonResponse.fail("全木行设置标的状态接口请求失败,请检查参数是否设置正确！");
		}
	}
	
	/**
	 * 4.3.18审核债权标的接口
	 * @param borrow_id
	 * @param borrow_status
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("review_debt_borrow_info")
	@ResponseBody
	public JsonResponse review_debt_borrow_info(String borrow_id, String borrow_status, String remarks,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			String str = "borrow_id=" + borrow_id + "&borrow_status=" + borrow_status + "&remarks=" + remarks;
			String url = URLUtils.get("review_debt_borrow_info_url");
			log.info("review_debt_borrow_info_url接口请求参数" + str);
			// 调用接口
			String data = HttpRequestUtil.sendPost(url, str);
			log.info("review_debt_borrow_info返回结果" + data);
			// 用urldecode反编码处理结果
			String result = URLDecoder.decode(data, "UTF-8");
			if (StringUtil.isEmpty(result)) {
				return JsonResponse.fail("请求审核债权标的接口失败！");
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			String msg = jsonObj.get("msg").toString();
			if (null != response_code && "0".equals(response_code)) {
				log.info("设置标的状态接口调用成功！审核的标号borrow_id=" + borrow_id);
				return JsonResponse.success("审核成功！");
			} else {
				System.out.println(msg);
				log.error(msg);
				return JsonResponse.fail(msg);
			}
		} catch (Exception e) {
			log.error("请求审核债权标的接口失败,请检查参数是否设置正确！", e);
			return JsonResponse.fail("请求审核债权标的接口失败,请检查参数是否设置正确！");
		}
	}

	/**
	 * 借款审核不通过时,调用全木行接口setObjectCancel，取消全木行该订单，修改订单状态为取消（只针对product_type=5分期购）
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("setObjectCancel")
	@ResponseBody
	public JsonResponse setObjectCancel(String order_id, String borrow_uid, HttpServletResponse response)
			throws Exception {

		try {
			if (StringUtil.isEmpty(order_id)) {
				return JsonResponse.fail("订单号不能为空！");
			}
			if (StringUtil.isEmpty(borrow_uid)) {
				return JsonResponse.fail("借款人borrow_uid不能为空！");
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("order_id", order_id);
			params.put("borrow_uid", borrow_uid);
			params.put("_input_charset", "UTF-8");
			log.info("借款人borrow_uid=" + borrow_uid);
			String url = URLUtils.get("setObjectCancel");
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			// 用urldecode反编码处理结果
			String result = URLDecoder.decode(data, "UTF-8");
			if (StringUtil.isEmpty(result)) {
				return JsonResponse.fail("借款审核,请求全木行取消订单接口失败！");
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			String msg = jsonObj.get("msg").toString();
			if (null != response_code && "0".equals(response_code)) {
				log.info("取消全木行订单，修改订单状态为0成功！订单号order_sn=" + order_id);
				return JsonResponse.success();
			} else {
				System.out.println(msg);
				log.error(msg);
				return JsonResponse.fail(msg);
			}
		} catch (Exception e) {
			log.error("取消全木行订单，修改订单状态失败！", e);
			return JsonResponse.fail("取消全木行订单，修改订单状态失败！");
		}
	}

	/**
	 * 调用接口获取链金所该客户的详情
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getUsrccfaxInf")
	@ResponseBody
	public JsonResponse getUsrccfaxInf(String usrid, HttpServletResponse response) throws Exception {

		try {
			if (StringUtil.isEmpty(usrid)) {
				return JsonResponse.fail("用户usrid不能为空！");
			}
			Map<String, String> params = new HashMap<String, String>();
			// 设置页面数据
			params.put("usrid", usrid);
			params.put("_input_charset", "UTF-8");
			String url = URLUtils.get("getUsrccfaxInf");
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			// 用urldecode反编码处理结果
			String result = URLDecoder.decode(data, "UTF-8");
			if (StringUtil.isEmpty(result)) {
				return JsonResponse.fail("请求获取链金所客户详情接口失败！");
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			String msg = jsonObj.get("msg").toString();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				Gson gson = new Gson();
				UsrccfaxInf usrccfaxInf = gson.fromJson(return_param, new TypeToken<UsrccfaxInf>() {
				}.getType());
				log.info("调用接口获取链金所该客户的详情成功！用户usrid=" + usrid);
				return JsonResponse.success().put("usrccfaxInf", usrccfaxInf);
			} else {
				System.out.println(msg);
				log.error(msg);
				return JsonResponse.fail(msg);
			}
		} catch (Exception e) {
			log.error("获取链金所当前客户的详情数据失败！", e);
			return JsonResponse.fail("获取链金所当前客户的详情数据失败！");
		}
	}

	/**
	 * 修改发标时间
	 * 
	 * @return
	 * @date 2016/08/21
	 */
	@RequestMapping("/modifyBiddingTime")
	@ResponseBody
	public JsonResponse modifyBiddingTime(TabBorrowInfoModel model, HttpServletRequest request) {
		log.info("modifyBiddingTime接收参数" + model.toString());
		try {
			if (StringUtil.isEmpty(model.getBidding_id())) {
				return JsonResponse.fail("bidding_id不能为空");
			}
			if (model.getNew_add_time() == null) {
				return JsonResponse.fail("新的发标时间不能为空");
			}
			if (StringUtil.isEmpty(model.getCheck_remark())) {
				model.setCheck_remark("修改发标时间");
			}
			SysUser sysUser = SessionUtils.getUser(request); // 获取当前处理人(审核人)id
			model.setDeal_user(sysUser.getId());

			Long temp_add_time_new = model.getNew_add_time().getTime();
			String add_time_new = Long.toString(temp_add_time_new);

			Map<String, String> params = new HashMap<String, String>();
			params.put("bidding_id", model.getBidding_id());
			// 精确到秒
			params.put("add_time_new", add_time_new.substring(0, add_time_new.length() - 3));
			params.put("check_remark", model.getCheck_remark());
			params.put("deal_user", model.getDeal_user().toString());

			// 调用接口
			log.info("updateBiddingStatus接口请求参数：" + params.toString());
			String data = HttpRequestUtil.sendPost(updateBiddingStatusUrl, Tools.createLinkString(params, false));
			log.info("updateBiddingStatus接口返回结果：" + data);
			if (StringUtil.isEmpty(data)) {
				return JsonResponse.fail("调用updateBiddingStatusUrl接口无返回值");
			}
			com.alibaba.fastjson.JSONObject result = com.alibaba.fastjson.JSONObject.parseObject(data);
			if (result.getInteger("code") == WebServiceConstant.CODE_SUCCESS) {
				log.info("updateBiddingStatus接口返回成功");
				return JsonResponse.success("审核成功");
			} else {
				log.info("updateBiddingStatus接口返回失败，原因：" + result.getString(WebServiceConstant.MESSAGE));
				return JsonResponse.fail(result.getString(WebServiceConstant.MESSAGE));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail(e.getMessage());
		}
	}

	/**
	 * 取消发标
	 * 
	 * @return
	 * @date 2016/08/21
	 */
	@RequestMapping("/cancelBidding")
	@ResponseBody
	public JsonResponse cancelBidding(TabBorrowInfoModel model, HttpServletRequest request) {
		log.info("cancelBidding接收参数" + model.toString());
		try {
			if (StringUtil.isEmpty(model.getBidding_id())) {
				return JsonResponse.fail("bidding_id不能为空");
			}
			if (StringUtil.isEmpty(model.getCheck_remark())) {
				return JsonResponse.fail("取消原因必须填写");
			}
			SysUser sysUser = SessionUtils.getUser(request); // 获取当前处理人(审核人)id
			model.setDeal_user(sysUser.getId());

			Map<String, String> params = new HashMap<String, String>();
			params.put("bidding_id", model.getBidding_id());
			params.put("borrow_status", WebServiceConstant.BORROW_STATUS_CHECK_FAIL.toString());
			params.put("check_remark", model.getCheck_remark());
			params.put("deal_user", model.getDeal_user().toString());

			// 调用接口
			log.info("updateBiddingStatus接口请求参数：" + params.toString());
			String data = HttpRequestUtil.sendPost(updateBiddingStatusUrl, Tools.createLinkString(params, false));
			log.info("updateBiddingStatus接口返回结果：" + data);
			if (StringUtil.isEmpty(data)) {
				return JsonResponse.fail("调用updateBiddingStatusUrl接口无返回值");
			}
			com.alibaba.fastjson.JSONObject result = com.alibaba.fastjson.JSONObject.parseObject(data);
			if (result.getInteger("code") == WebServiceConstant.CODE_SUCCESS) {
				log.info("updateBiddingStatus接口返回成功");
				return JsonResponse.success("审核成功");
			} else {
				log.info("updateBiddingStatus接口返回失败，原因：" + result.getString("msg"));
				return JsonResponse.fail(result.getString("msg"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail(e.getMessage());
		}
	}

	/**
	 * 取得征信资料图片url
	 * 
	 * @return
	 * @date 2016/08/24
	 */
	@RequestMapping("/getCreditInformation")
	@ResponseBody
	public JsonResponse getCreditInforMation(Integer borrow_uid, Integer order_id) {

		try {
			// 根据userId获取征信资料Url
			TabUsrinf2 user = tabUsrinf2Service.queryTabUsrinf2ByUsrId(Long.valueOf(borrow_uid));
			String credit_report_pic = "";
			if (null != user) {
				credit_report_pic = user.getCredit_report_pic();
			}
			return JsonResponse.success().put("credit_report_pic", credit_report_pic);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail(e.getMessage());
		}
	}

	/**
	 * 获取全木行订单信息接口
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getOrdersInf")
	public void getOrdersInf(String order_id, HttpServletResponse response) {
		try {
			if (StringUtil.isEmpty(order_id)) {
				sendFailureMessage(response, "订单号不能为空！");
				return;
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("order_id", order_id);
			params.put("_input_charset", "UTF-8");
			String url = URLUtils.get("getOrdersInf");
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			// 用urldecode反编码处理结果
			String result = data;
			if (StringUtil.isEmpty(result)) {
				sendFailureMessage(response, "获取全木行订单信息接口失败！");
				return;
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				JSONObject jsonObject = new JSONObject(return_param);
				String goods_list = jsonObject.get("goods_list").toString();
				String reciver_name = jsonObject.get("reciver_name").toString();
				String reciver_tel = jsonObject.get("reciver_tel").toString();
				String reciver_addr = jsonObject.get("reciver_addr").toString();
				String record_total = jsonObject.get("record_total").toString();
				String page_total = jsonObject.get("page_total").toString();

				Gson gson = new Gson();
				List<AllWoodOrderTemp> goods_list_list = gson.fromJson(goods_list,
						new TypeToken<List<AllWoodOrderTemp>>() {
						}.getType());
				if (null != goods_list_list && goods_list_list.size() > 0) {
					for (AllWoodOrderTemp allWoodOrderTemp : goods_list_list) {
						long add_time = allWoodOrderTemp.getAdd_time();
						Date add_tDate = new Date(Long.parseLong(add_time + "000"));
						allWoodOrderTemp.setAdd_time_desc(DateUtil.DateToStr(add_tDate, "yyyy-MM-dd HH:mm:ss"));
						BigDecimal goods_pay_price = allWoodOrderTemp.getGoods_pay_price();
						BigDecimal goods_num = new BigDecimal(allWoodOrderTemp.getGoods_num());
						BigDecimal goods_total_price = goods_pay_price.multiply(goods_num);
						allWoodOrderTemp.setGoods_total_price(goods_total_price);
					}
				}
				List<AllWoodOrderTemp> dataList = goods_list_list;

				log.info("获取全木行订单信息接口成功！order_id=" + order_id);
				// 设置页面数据
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("rows", dataList);
				jsonMap.put("page_total", page_total); // 总页数
				jsonMap.put("total", record_total);// 总条数
				jsonMap.put("reciver_name", reciver_name);
				jsonMap.put("reciver_tel", reciver_tel);
				jsonMap.put("reciver_addr", reciver_addr);
				HtmlUtil.writerJson(response, jsonMap);

			} else {
				String msg = jsonObj.get("msg").toString();
				sendFailureMessage(response, "获取全木行订单信息接口失败！" + msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调用全木行接口getBuyGoodsList获取客户购买的商品记录
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("purchaseRecord")
	public void purchaseRecord(String borrow_uid, String store_id, TabBorrowInfoModel model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (StringUtil.isEmpty(borrow_uid)) {
				sendFailureMessage(response, "订单号不能为空！");
				return;
			}
			Map<String, String> params = new HashMap<String, String>();
			int startRow = (model.getPage() - 1) * model.getRows();
			params.put("borrow_uid", borrow_uid);
			params.put("store_id", store_id);
			params.put("startRow", startRow + "");
			params.put("rows", model.getPager().getPageSize() + "");
			params.put("_input_charset", "UTF-8");
			String url = URLUtils.get("getBuyGoodsList");
			log.info("getBuyGoodsList request param----" + params.toString());
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("getBuyGoodsList result----" + data);
			// 用urldecode反编码处理结果
			String result = data;
			if (StringUtil.isEmpty(result)) {
				sendFailureMessage(response, "获取全木行客户购买商品记录的接口失败！");
				return;
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				JSONObject jsonObject = new JSONObject(return_param);
				String record_total = jsonObject.get("record_total").toString();
				String page_total = jsonObject.get("page_total").toString();
				String ordersInf_gc = jsonObject.get("ordersInf_goodList").toString();

				Gson gson = new Gson();
				List<AllWoodOrderTemp> ordersInf_gc_list = gson.fromJson(ordersInf_gc,
						new TypeToken<List<AllWoodOrderTemp>>() {
						}.getType());
				if (null != ordersInf_gc_list && ordersInf_gc_list.size() > 0) {
					for (AllWoodOrderTemp allWoodOrderTemp : ordersInf_gc_list) {
						long add_time = allWoodOrderTemp.getAdd_time();
						Date add_timeDate = new Date(Long.parseLong(add_time + "000"));
						allWoodOrderTemp.setAdd_time_desc(DateUtil.DateToStr(add_timeDate, "yyyy-MM-dd HH:mm:ss"));
						BigDecimal goods_pay_price = allWoodOrderTemp.getGoods_pay_price();
						BigDecimal goods_num = new BigDecimal(allWoodOrderTemp.getGoods_num());
						BigDecimal goods_total_price = goods_pay_price.multiply(goods_num);
						allWoodOrderTemp.setGoods_total_price(goods_total_price);
					}
				}
				List<AllWoodOrderTemp> dataList = ordersInf_gc_list;

				log.info("获取全木行客户购买商品记录成功！borrow_uid=" + borrow_uid);
				// 设置页面数据

				jsonMap.put("page_total", page_total); // 总页数
				jsonMap.put("total", record_total);// 总条数
				jsonMap.put("rows", dataList);
				HtmlUtil.writerJson(response, jsonMap);

			} else {
				String msg = jsonObj.get("msg").toString();
				jsonMap.put("total", 0);// 总条数
				jsonMap.put("rows", new ArrayList<AllWoodOrderTemp>());
				HtmlUtil.writerJson(response, jsonMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取全木行订单商品的所有店铺接口
	 * 
	 * @param order_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getOrderStoreList")
	public void getOrderStoreList(HttpServletResponse response) throws Exception {
		try {

			Map<String, String> params = new HashMap<String, String>();
			params.put("_input_charset", "UTF-8");
			String url = URLUtils.get("getOrderStoreList");
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			// 用urldecode反编码处理结果
			String result = data;
			if (StringUtil.isEmpty(result)) {
				sendFailureMessage(response, "获取全木行订单商品的所有店铺接口请求失败！");
				return;
			}
			JSONObject jsonObj = new JSONObject(result);
			// 获取状态
			String response_code = jsonObj.get("code").toString();
			if (null != response_code && "0".equals(response_code)) {
				String return_param = jsonObj.get("return_param").toString();
				JSONObject jsonObject = new JSONObject(return_param);
				String store_list = jsonObject.get("store_list").toString();
				String total = jsonObject.get("total").toString();

				Gson gson = new Gson();
				List<AllWoodOrderTemp> storeList = gson.fromJson(store_list, new TypeToken<List<AllWoodOrderTemp>>() {
				}.getType());
				HtmlUtil.writerJson(response, storeList);

			} else {
				String msg = jsonObj.get("msg").toString();
				sendFailureMessage(response, "获取全木行订单商品的所有店铺接口请求失败！" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 日期时间转毫秒
	 * 
	 * @param str
	 * @return
	 * @throws java.text.ParseException
	 */
	public static long getTimeStemp(String str) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d.getTime();
	}

	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月30日
	 * @description 根据相应条件获取订单照片
	 * @param order_sn
	 * @param pic_type
	 * @return
	 */
	@RequestMapping("getUserOrderPicUrl")
	@ResponseBody
	public JsonResponse getUserOrderPicUrl(TabUsrOrderPic tabUsrOrderPic){
		
		List<TabUsrOrderPic> tabUsrOrderPicList = tabUsrOrderPicService.queryPicByOrderSnNotMosaic(tabUsrOrderPic);
		
		if(tabUsrOrderPicList != null && tabUsrOrderPicList.size() > 0){
			StringBuffer picBuffer = new StringBuffer();
		    for(TabUsrOrderPic tempPic:tabUsrOrderPicList){
		    	String entireUrl = URLUtils.get("picServerIp") + tempPic.getPic_addr() + "|";
		    	picBuffer.append(entireUrl);
		    }	
			// 去除最后的|
			if (picBuffer.length() > 0) {
				if ("|".equals(picBuffer.substring(picBuffer.length() - 1))) {
					picBuffer.deleteCharAt(picBuffer.length() - 1);
				}
				return JsonResponse.success().put("picPath", picBuffer.toString());
			}
		}
		return JsonResponse.fail();
	}
	

	/**
	 * @author frank_wang
	 * @data 2016年11月5日
	 * @description 发标管理
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/startBiddingList")
	public ModelAndView startBiddingList(HttpServletRequest request) throws Exception {
		
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		
		//获取担保公司列表
		String url = URLUtils.get("getCompany");
		String result = HttpRequestUtil.sendPost(url, "");
		log.info("getCompany result---"+result);
		com.alibaba.fastjson.JSONObject resultObj = com.alibaba.fastjson.JSONObject.parseObject(result);
		
		if(resultObj.getIntValue("code") == -1){
			log.error("获取担保公司失败");
		}
		List<Map> list = com.alibaba.fastjson.JSONObject.parseArray(resultObj.getString("dataList"), Map.class);
		context.put("companyList", list);
		
		return forword("borrowManager/startBiddingList", context);
	}

	/**
	 * @author frank_wang
	 * @throws Exception
	 * @data 2016年11月5日
	 * @description 获取会员列表
	 */
	@RequestMapping("/getMemberList")
	public void getMemberList(LzhMemberModel model,HttpServletResponse response) throws Exception {

		log.info("getMemberList param--" + model.toString());
		List<LzhMemberModel> list = new ArrayList<LzhMemberModel>();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, String> params = new HashMap<String, String>();
		if (model.getIs_vip() != null) {
			params.put("is_vip", model.getIs_vip().toString());
		}
		params.put("page_no", model.getPage().toString());
		params.put("page_number", String.valueOf(model.getPager().getPageSize()));
		if (!StringUtil.isEmpty(model.getUser_phone())) {
			params.put("user_phone", model.getUser_phone());
		}
		if (!StringUtil.isEmpty(model.getReal_name())) {
			params.put("real_name", model.getReal_name());
		}

		String url = URLUtils.get("getMemberList");
		log.info("getMemberList接口请求参数为" + params.toString());
		// 调用接口
		String result = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));

		com.alibaba.fastjson.JSONObject jsonResult = com.alibaba.fastjson.JSONObject.parseObject(result);
		log.info("getMemberList返回结果" + result);
		if (StringUtil.isEmpty(result)) {
			throw new Exception("无法获取会员信息");
		}

		list = com.alibaba.fastjson.JSONObject
				.parseArray(jsonResult.getJSONObject("return_param").getString("member_list"), LzhMemberModel.class);

		for (LzhMemberModel tempModel : list) {
			tempModel.setReg_time_date(DateUtil.getDateByTimestampSecond(tempModel.getReg_time().toString()));
		}
		String record_total = jsonResult.getJSONObject("return_param").getString("record_total");
		String page_total = jsonResult.getJSONObject("return_param").getString("page_total");

		jsonMap.put("page_total", page_total); // 总页数
		jsonMap.put("total", record_total);// 总条数
		jsonMap.put("rows", list);
		
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * @author frank_wang
	 * @data 2016年11月7日
	 * @descriptionc 设置链金所客户为vip
	 * @param is_vip
	 * @param usrid
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/setMemberToVip")
	@ResponseBody
	public JsonResponse setMemberToVip(String is_vip, String usrid,HttpServletResponse response) throws Exception {

		log.info("setMemberToVip params---is_vip:" + is_vip + ",usrid:" + usrid);
		
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("is_vip", is_vip);
			params.put("usrid", usrid);

			String url = URLUtils.get("setMemberToVip");
			// 调用接口
			String result = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("setMemberToVip result---"+result);
            return JsonResponse.success();			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("提升投资人失败");
			return JsonResponse.fail(e.getMessage());
		}
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月7日
	 * @description
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getCompany")
	@ResponseBody
	public JsonResponse getCompany(HttpServletResponse response) throws Exception {
          
		String url = URLUtils.get("getCompany");
		String result = HttpRequestUtil.sendPost(url, "");
		log.info("getCompany result---"+result);
		com.alibaba.fastjson.JSONObject resultObj = com.alibaba.fastjson.JSONObject.parseObject(result);
		
		if(resultObj.getIntValue("code") == -1){
			return JsonResponse.fail(resultObj.getString("msg"));
		}
		List<Map> list = com.alibaba.fastjson.JSONObject.parseArray(resultObj.getString("dataList"), Map.class);
		
		log.info("getCompany result---"+result);
		
		return JsonResponse.success().put("list", list);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月8日
	 * @description 上传图片并且返回图片所在服务器的路径
	 * @param file
	 * @return
	 */
	@RequestMapping("uploadPicture")
	@ResponseBody
	public Map<String, Object> uploadPicture(MultipartFile file,String usrid,String order_sn){

		log.info("uploadPicture param----usrid="+usrid);
		Map<String, Object> result = new HashMap<String,Object>();
		
		log.info("uploadPicture usrid=" + usrid);
		// 文件名字
		String fileName = UUID.randomUUID() + ".jpg";
		String dirPath = picServerPath + usrid.toString();
		if (System.getProperties().getProperty("os.name").indexOf("nux") != -1) {
			ShellUtil.exec("cd / ");
			ShellUtil.exec("sudo mkdir -p " + dirPath);
			ShellUtil.exec("chmod -R 777 " + dirPath);
		}
		File targetFile = new File(dirPath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("图片存储失败------------");
			 result.put("code", WebServiceConstant.CODE_FAIL);
             result.put("msg", e.getMessage());
		}
		//返回给前台全路径
		String path = usrid.toString() + "/" + fileName;
		String entirePath = picServerIp + path;
		result.put("path", entirePath);
		result.put("code", WebServiceConstant.CODE_SUCCESS);
		//路径存到数据库
		if(!StringUtil.isEmpty(order_sn)){
			TabUsrOrderPic tabUsrOrderPic =  new TabUsrOrderPic(order_sn, new Byte(WebServiceConstant.PIC_TYPE_MOSAIC),path);
			tabUsrOrderPicService.insert(tabUsrOrderPic);	
		}
		return result;
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月8日
	 * @description 调用链金所发标
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setBiddingInf")
	@ResponseBody
	public JsonResponse setBiddingInf(TabBorrowInfo info) throws Exception {
         
		try {
			String url = URLUtils.get("setBiddingInf");
			
			Map<String, String> params = new HashMap<String,String>();
			//接口必输项
			params.put("borrow_uid", info.getBorrow_uid().toString());
			params.put("borrow_money", info.getBorrow_money().toString());
			params.put("borrow_interest_rate", info.getBorrow_interest_rate().toString());
			params.put("borrow_use", info.getBorrow_use());
			params.put("borrow_duration", info.getBorrow_duration().toString());
			params.put("borrow_min", info.getBorrow_min().toString());
			params.put("collect_day",info.getCollect_day());
			params.put("repayment_type", info.getRepayment_type().toString());			
			params.put("product_type", info.getProduct_type().toString());
			params.put("borrow_name", info.getBorrow_name());
			params.put("borrow_info", URLEncoder.encode(info.getBorrow_info(), "UTF-8"));
			params.put("test",info.getTest().toString());
			params.put("borrow_use_desc", info.getBorrow_use_desc());
			//接口非必输项
			if(info.getBorrow_max() != null){
				params.put("borrow_max", info.getBorrow_max().toString());	
			}
			if(info.getDanbao() != null){
				params.put("danbao", info.getDanbao().toString());
			}
			if(info.getColligate() != null){
				params.put("colligate", info.getColligate().toString());
			}
			if(info.getVouch_money() != null){
				params.put("vouch_money", info.getVouch_money().toString());			
			}
			if(info.getWarehousing() != null){
				params.put("warehousing", URLEncoder.encode(info.getWarehousing(), "UTF-8"));
			}
			if(info.getJiaxi_rate() != null){
				params.put("jiaxi_rate", info.getJiaxi_rate().toString());
			}
			if(!StringUtil.isEmpty(info.getUpdata())){ 
			  String updata = info.getUpdata();
			  updata = updata.substring(0, updata.lastIndexOf("|"));
			  params.put("updata",updata);				
			}
			if(!StringUtil.isEmpty(info.getBidding_pwd())){
				params.put("bidding_pwd", info.getBidding_pwd());
			}
		//调用全木行接口计算总利息并作为请求参数
			int repaymentType = info.getRepayment_type().intValue();
			//根据还款方式计算利息，用于Php前端进行展示
			BigDecimal borrow_interest = null;
			if(WebServiceConstant.REPAYMENT_TYPE_BY_DAY == repaymentType){
				//还款方式如果选择天标,计息方式则按天
				borrow_interest = getBorrowInterestFromAllwood(info.getBorrow_money(),null,
						info.getBorrow_duration(),info.getBorrow_interest_rate(),WebServiceConstant.INTEREST_MODE_DAY);
			}else if(WebServiceConstant.REPAYMENT_TYPE_AVERAGE_CAPITAL_PLUS_INTEREST == repaymentType){
				//还款方式如果选择等额本息,计息方式则按月
				borrow_interest = getBorrowInterestFromAllwood(info.getBorrow_money(),new Integer(0),
						info.getBorrow_duration(),info.getBorrow_interest_rate(),WebServiceConstant.INTEREST_MODE_BY_MONTH);
			}else if(WebServiceConstant.REPAYMENT_TYPE_BY_QUATER == repaymentType){
				//还款方式如果选择按季
				borrow_interest = getBorrowInterestFromAllwood(info.getBorrow_money(),new Integer(0),
						info.getBorrow_duration(),info.getBorrow_interest_rate(),WebServiceConstant.INTEREST_MODE_QUATER);
			}else if(WebServiceConstant.REPAYMENT_TYPE_INTETREST_FIRST_CAPITAL_LATER == repaymentType){
				borrow_interest = getBorrowInterestFromAllwood(info.getBorrow_money(),new Integer(2),
						info.getBorrow_duration(),info.getBorrow_interest_rate(),null);
			}else if(WebServiceConstant.REPAYMENT_TYPE_EQUAL_CAPITAL_NO_INTEREST == repaymentType){
				borrow_interest = getBorrowInterestFromAllwood(info.getBorrow_money(),new Integer(1),
						info.getBorrow_duration(),info.getBorrow_interest_rate(),WebServiceConstant.INTEREST_MODE_BY_MONTH);
			}
			if(borrow_interest != null){
				params.put("borrow_interest", borrow_interest.toString());
			}else{
				throw new Exception("获取利息失败");
			}
			
			log.info("setBiddingInf params--"+params.toString());
			//调用外系统接口
			String result = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("setBiddingInf result--"+result);
			
			com.alibaba.fastjson.JSONObject resultObj = com.alibaba.fastjson.JSONObject.parseObject(result);
			
			if(resultObj.getIntValue("code") == -1){
				return JsonResponse.fail(resultObj.getString("msg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调用发标失败");
			return JsonResponse.fail(e.getMessage());
		}
		return JsonResponse.success();
	}
	
	@RequestMapping("/modifyBiddingInfo")
	@ResponseBody
	public JsonResponse modifyBiddingInfo(TabBorrowInfo info) throws Exception {
         
		try {
			String url = URLUtils.get("setBiddingInf");
			
			Map<String, String> params = new HashMap<String,String>();
			//接口必输项
			params.put("borrow_money", info.getBorrow_money().toString());
			params.put("borrow_interest_rate", info.getBorrow_interest_rate().toString());
			params.put("borrow_duration", info.getBorrow_duration().toString());
			params.put("collect_day",info.getCollect_day());
			params.put("borrow_name", info.getBorrow_name());
			params.put("borrow_info", URLEncoder.encode(info.getBorrow_info(), "UTF-8"));
			params.put("bidding_id", info.getBidding_id());
			params.put("repayment_type", info.getRepayment_type().toString());
			//接口非必输项
			if(info.getColligate() != null){
				params.put("colligate", info.getColligate().toString());
			}
			if(!StringUtil.isEmpty(info.getWarehousing())){
				params.put("warehousing", URLEncoder.encode(info.getWarehousing(), "UTF-8"));
			}
			if(info.getJiaxi_rate() != null){
				params.put("jiaxi_rate", info.getJiaxi_rate().toString());
			}
			//处理图片地址
			String updata = info.getUpdata();
			if(!StringUtil.isEmpty(updata)){
			   updata = updata.substring(0, updata.lastIndexOf("|"));
			   params.put("updata",updata);
			}
			log.info("setBiddingInf(modify) params--"+params.toString());
			//调用外系统接口
			String result = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("setBiddingInf(modify) result--"+result);
			if(StringUtil.isEmpty(result)){
				throw new Exception("修改发标信息失败。。。。");
			}
			com.alibaba.fastjson.JSONObject resultObj = com.alibaba.fastjson.JSONObject.parseObject(result);
			
			if(resultObj.getIntValue("code") == -1){
				return JsonResponse.fail(resultObj.getString("msg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调用发标失败");
			return JsonResponse.fail(e.getMessage());
		}
		return JsonResponse.success();
	}
	
	
	/**
	 * @author frank_wang
	 * @data 2016年11月14日
	 * @description 发标时获取利息
	 * @return BigDecimal
	 * @param BigDecimal amount
	 * @param Integer interest_type
	 * @param Integer periods
	 * @param BigDecimal interest_rate
	 * @param Integer interest_mode
	 */
	private BigDecimal getBorrowInterestFromAllwood(BigDecimal amount,Integer interest_type,Integer periods,BigDecimal interest_rate
			,Integer interest_mode){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("amount", amount.toString());
		if(interest_type != null){
			params.put("interest_type", interest_type.toString());			
		}
		params.put("periods", periods.toString());
		params.put("interest_rate", interest_rate.multiply(new BigDecimal("0.01")).toString());
		if(interest_mode != null){
			params.put("interest_mode", interest_mode.toString());
		}
		log.info("调用接口 getInterestInf 请求参数---"+params.toString());
		String result = HttpRequestUtil.sendPost(getInterestInf, Tools.createLinkString(params, false));
		log.info("调用接口 getInterestInf 返回结果---"+result);
		
		com.alibaba.fastjson.JSONObject response = com.alibaba.fastjson.JSONObject.parseObject(result);
		
		if(WebServiceConstant.CODE_FAIL == response.getIntValue("code")){
			return null;
		}else{
			com.alibaba.fastjson.JSONObject object = (com.alibaba.fastjson.JSONObject)response.getJSONObject("return_param").getJSONArray("interests_list").get(0);
			return object.getBigDecimal("interest_total");
		}
	}
	
	
	/**
	 * @author frank_wang
	 * @data 2016年11月15日
	 * @description 根据标号获取标的信息
	 * @param bidding_id
	 * @return
	 * @throws Exception 
	 */
	private TabBorrowInfo getBorrowInfoByBiddingId(String bidding_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bidding_id", bidding_id.toString());
		params.put("page_no", "1");
		params.put("page_number", "10");
		params.put("borrow_status", "3");
		log.info("getBiddingList接口请求参数为" + params.toString());
		// 调用接口
		String url = URLUtils.get("getBiddingList");
		String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
		log.info("getBiddingList返回结果" + data);
		if(StringUtil.isEmpty(data)){
			throw new Exception("bidding_id:"+bidding_id.toString()+"获取标的信息失败");
		}
		com.alibaba.fastjson.JSONObject resultObj = com.alibaba.fastjson.JSONObject.parseObject(data);
		if(resultObj.getIntValue("code") == -1){
			throw new Exception("bidding_id:"+bidding_id.toString()+"获取标的信息失败");
		}
		String biddingList = resultObj.getJSONObject("return_param").getString("bidding_list");
		
		List<TabBorrowInfo> tabUsrinfList = com.alibaba.fastjson.JSONObject.parseArray(biddingList,TabBorrowInfo.class);
		TabBorrowInfo tabBorrowInfo = tabUsrinfList.get(0);
		return tabBorrowInfo;
	}
	
	
}
