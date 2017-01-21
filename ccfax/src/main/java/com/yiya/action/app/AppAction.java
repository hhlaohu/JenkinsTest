package com.yiya.action.app;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.yiya.action.BaseAction;
import com.yiya.bean.DataDictionaryValue;
import com.yiya.bean.IdCard;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.JsonResponse2;
import com.yiya.bean.OrderBean;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabApplyLog;
import com.yiya.bean.TabBorrowInfo;
import com.yiya.bean.TabCheckLog;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrDecorationOrder;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf2;
import com.yiya.bean.XiaoShiConfig;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.BiddingOperationLog;
import com.yiya.model.DataParameterModel;
import com.yiya.model.TabBorrowInfoModel;
import com.yiya.model.TabCheckLogModel;
import com.yiya.model.TabUsrComplementPicModel;
import com.yiya.model.TabUsrDecorationOrderModel;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.service.DataManagerService;
import com.yiya.service.OrderService;
import com.yiya.service.ScheduledExecutorServiceTask;
import com.yiya.service.SendMessage;
import com.yiya.service.SysUserService;
import com.yiya.service.TabApplyLogService;
import com.yiya.service.TabAreaBeanService;
import com.yiya.service.TabBondsmaninfService;
import com.yiya.service.TabBorrowSerialCodeService;
import com.yiya.service.TabCheckLogService;
import com.yiya.service.TabOrderBondsmaninfService;
import com.yiya.service.TabUsrComplementPicService;
import com.yiya.service.TabUsrDecorationContractPicService;
import com.yiya.service.TabUsrDecorationOrderService;
import com.yiya.service.TabUsrOrderPicService;
import com.yiya.service.TabUsrOrderService;
import com.yiya.service.TabUsrOtherPicService;
import com.yiya.service.TabUsrPremisePermitPicService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.service.XiaoShiConfigService;
import com.yiya.thread.InvocateFkGatherDataTask;
import com.yiya.utils.CopyProperties;
import com.yiya.utils.DateUtil;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.HttpsClientUtil;
import com.yiya.utils.ImageProcess;
import com.yiya.utils.NumberToCN;
import com.yiya.utils.ParamCheckUtil;
import com.yiya.utils.ShellUtil;
import com.yiya.utils.StringUtil;
import com.yiya.utils.ToHtmlUtils;
import com.yiya.utils.Tools;
import com.yiya.utils.URLUtils;

@Controller
@RequestMapping("/user")
public class AppAction extends BaseAction {

	private final static Logger log = Logger.getLogger(AppAction.class);
	
	@Autowired(required = false)
	private OrderService<OrderBean> orderService;
	
	@Autowired
	private TabUsrDecorationOrderService<TabUsrDecorationOrder> tabUsrDecorationOrderService;

	@Autowired
	private TabBondsmaninfService tabBondsmaninfService;

	@Autowired
	private TabUsrOtherPicService<TabUsrOtherPic> tabUsrOtherPicService;

	@Autowired
	private TabUsrPremisePermitPicService tabUsrPremisePermitPicService;

	@Autowired
	private TabUsrDecorationContractPicService tabUsrDecorationContractPicService;

	@Autowired
	private TabApplyLogService tabApplyLogService;

	@Autowired
	private TabUsrComplementPicService tabUsrComplementPicService;

	@Autowired
	private XiaoShiConfigService xiaoShiConfigService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private TabCheckLogService tabCheckLogService;

	@Autowired
	private SendMessage sendMessage;

	@Autowired
	private TabUsrinf2Service tabUsrinf2Service;

	@Autowired
	private TabAreaBeanService tabAreaBeanService;

	@Autowired
	private TabUsrOrderPicService tabUsrOrderPicService;

	@Autowired
	private TabUsrOrderService tabUsrOrderService;

	@Autowired(required = false)
	private DataManagerService dataManagerService;

	@Autowired
	private TabBorrowSerialCodeService tabBorrowSerialCodeService;

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	private TabOrderBondsmaninfService tabOrderBondsmaninfService;

	@Value("${sendToFirstVerifyContent}")
	private String sendToFirstVerifyContent;

	@Value("${sendToCustomerWhenChecking}")
	private String sendToCustomerWhenChecking;

	@Value("${sendToCustomerWhenStartBidding}")
	private String sendToCustomerWhenStartBidding;

	@Value("${sendToRiskControlOperatorWhenStartBidding}")
	private String sendToRiskControlOperatorWhenStartBidding;

	@Value("${sendToRiskControlOperatorWhenStartBidding}")
	private String sendToMarketingOperatorWhenStartBidding;

	@Value("${picServerIp}")
	private String picServerIp;

	@Value("${createBidding}")
	private String createBiddingUrl;

	@Value("${getUsrDebtAmount}")
	private String getUsrDebtAmountUrl;

	@Value("${picServerPath}")
	private String picServerPath;

	@Value("${getCreditUserBorrowInfo}")
	private String getCreditUserBorrowInfo;

	@Value("${isBindBankCard}")
	private String isBindBankCard;

	@Value("${setMemberToVip}")
	private String setMemberToVipUrl;

	@Value("${findStoreTypeDescByStoreTypeId}")
	private String findStoreTypeDescByStoreTypeIdUrl;
	
	@Value("${is_local_register_place}")
	private String is_local_register_place;
	
	@Value("${infoSubmitSuccessMessageToOperator}")
	private String infoSubmitSuccessMessageToOperator;
	
	@Value("${infoSubmitSuccessMessageToOrderFirst}")
	private String infoSubmitSuccessMessageToOrderFirst;
	
	@Value("${infoSubmitSuccessMessageToCustomer}")
	private String infoSubmitSuccessMessageToCustomer;
	
	@Value("${infoSubmitStartToStore}")
	private String infoSubmitStartToStore;
	
	@Value("${afterThreeHoursToCustomer}")
	private String afterThreeHoursToCustomer;
	
	@Value("${msUrl}")
	private String msUrl;
	
	
	
	// 局部异常捕捉,也可以配置全局的异常捕捉
	@ExceptionHandler(RuntimeException.class) // 在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
	public void exceptionHandler(RuntimeException ex, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		ex.printStackTrace();
		log.error(ex.getMessage(), ex);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("msg", ex.getMessage());
		jsonMap.put("code", -1);
		jsonMap.put("exceptionType", ex.getClass().getName());
		HtmlUtil.writerJson(response, jsonMap);
	}

	//
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月21日
	 * @description 写入授信资料新接口
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("setCreditInf_2")
	@ResponseBody
	public JsonResponse2 setCreditInf_2(@Valid TabUsrinf2Model tabUsrinf2Model, BindingResult result)
			throws IOException, IllegalAccessException, InvocationTargetException {

		try {
			log.info("setCreditInf_2 request param--" + tabUsrinf2Model.toString());
			// 处理JSON字符串
			tabUsrinf2Service.dealJson(tabUsrinf2Model);
			// 判断是插入还是更新
			TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId(tabUsrinf2Model.getUsrid());
			// 插入
			if (tabUsrinf2 == null) {
				// 必输项校验
				if (result.hasErrors()) {
					return JsonResponse2.fail(result.getFieldError().getField() + "不能为空");
				}
				// 持久化基本信息表
				TabUsrinf2 tabUsrinfSave = new TabUsrinf2();
				CopyProperties.copyPropertysWithoutNull(tabUsrinfSave, tabUsrinf2Model);
				if (tabUsrinfSave.getId_card() != null) {
					tabUsrinfSave.setSex(new Byte(IdCard.getGenderByIdCard(tabUsrinfSave.getId_card())));
					tabUsrinfSave.setAge(IdCard.getAgeByIdCard(tabUsrinfSave.getId_card()));
				} else {
					tabUsrinfSave.setSex(new Byte("0"));
					tabUsrinfSave.setAge(0);
				}
				tabUsrinf2Service.insertSelective(tabUsrinfSave);
				return JsonResponse2.success("usrid=" + tabUsrinf2Model.getUsrid() + "授信资料插入成功");
			} else {
				// 更新基本信息资料
				TabUsrinf2 updateTabUsrinf2 = new TabUsrinf2();
				CopyProperties.copyPropertysWithoutNull(updateTabUsrinf2, tabUsrinf2Model);
				updateTabUsrinf2.setUsrinf_id(tabUsrinf2.getUsrinf_id());
				tabUsrinf2Service.updateByPrimaryKeySelective(updateTabUsrinf2);
				// 如果合同编号为空则更新
				if (StringUtil.isEmpty(tabUsrinf2Model.getContract_number())) {
					TabUsrinf2 queryTabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(tabUsrinf2.getUsrinf_id());
					queryTabUsrinf2.setContract_number(null);
					tabUsrinf2Service.update(queryTabUsrinf2);
				}
				// 更新担保人信息
				tabBondsmaninfService.updateTabBondsmanList(tabUsrinf2Model.getTabBondsmaninfList(),
						tabUsrinf2.getUsrinf_id());
				// 更新其它照片列表
				tabUsrOtherPicService.updateTabUsrOtherPicList(tabUsrinf2Model.getTabUsrOtherPicList(),
						tabUsrinf2.getUsrinf_id().intValue());
				// 保存到采集数据表中
				TabUsrinf2 tabUsrinf2Query = tabUsrinf2Service.queryTabUsrinf2ByUsrId(tabUsrinf2.getUsrid());
				Map<String, Object> saveGatherMap = new HashMap<String, Object>();
				saveGatherMap.put("age", tabUsrinf2Query.getAge());
				saveGatherMap.put("sex", tabUsrinf2Query.getSex());
				saveGatherMap.put("marital", tabUsrinf2Query.getMarital());
				saveGatherMap.put("diploma", tabUsrinf2Query.getDiploma());
				saveGatherMap.put("local_register_place", tabUsrinf2Query.getLocal_register_place());
				saveGatherMap.put("register_place", tabUsrinf2Query.getRegister_place());
				saveGatherMap.put("industry", tabUsrinf2Query.getIndustry());
				saveGatherMap.put("profession_level", tabUsrinf2Query.getProfession_level());
				saveGatherMap.put("cur_hire_duration", tabUsrinf2Query.getCur_hire_duration());
				saveGatherMap.put("income", tabUsrinf2Query.getIncome());
				saveGatherMap.put("house_type", tabUsrinf2Query.getHouse_type());
				saveGatherMap.put("fixed_assets", tabUsrinf2Query.getFixed_assets());
				saveGatherMap.put("usrid", tabUsrinf2Query.getUsrid());
				tabUsrinf2Service.saveToGatherTable(saveGatherMap);
				return JsonResponse2.success("usrid=" + tabUsrinf2Model.getUsrid() + "授信资料更新成功成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("setCreditInf_2 fail--------------" + tabUsrinf2Model.getUsrid());
			return JsonResponse2.fail("setCreditInf_2 失败," + e.getMessage());
		}
	}

	/**
	 * 修改授信状态接口
	 * 
	 * @param usrid
	 * @param check_flag
	 * @param request
	 * @return
	 */
	@RequestMapping("setCreditStatus")
	@ResponseBody
	public JsonResponse2 setCreditStatus(@RequestParam("usrid") Integer usrid,
			@RequestParam("check_flag") Integer check_flag, HttpServletRequest request) {
		try {
			log.debug("usrid=" + usrid + "," + "check_flag=" + check_flag);
			TabApplyLog tal = new TabApplyLog();
			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(Long.valueOf(usrid));
			if (tabUsrinf == null) {
				return JsonResponse2.fail("无法找到tabUsrinf--usrid=" + usrid);
			}
			if (check_flag == 1) {
				if (tabUsrinf.getCheck_flag().intValue() != 3 && tabUsrinf.getCheck_flag().intValue() != 5) { // 授信额度审核状态已被风控系统审核修改为3：初审通过，5：复审通过，,则不能重新设置为1
					tabUsrinf.setCheck_flag(check_flag.byteValue());
					tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
					log.info("授信状态check_flag修改为1，未审核");
					// 额度的审核会从初始状态变为待审核，此时需要发送短信给具有待审核权限的人员
					StringBuffer buffer = new StringBuffer(sendToFirstVerifyContent);
					sysUserService.sendMessageByButtonAuthority(
							buffer.insert(4, tabUsrinf.getMobile_phone()).toString(),
							WebServiceConstant.FIRST_VERIFY_BUTTON_ID);
					// 额度的审核会从初始状态变为待审核，此时需要发送短信给客户
					sendMessage.sendGroupSmsToClient(sendToCustomerWhenChecking, tabUsrinf.getMobile_phone(), null);
				}
				tal.setUsrinf_id(tabUsrinf.getUsrinf_id().intValue());
				tal.setCheck_result(tabUsrinf.getCheck_flag().toString());
				tal.setApplyfor_limit(new BigDecimal(0));
				tal.setApply_time(new Date());
				tabApplyLogService.update(tal);// 更新申请记录
				return JsonResponse2.success("授信状态修改成功");
			}
			if (check_flag == 2) {
				tabUsrinf.setCheck_flag(check_flag.byteValue());
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				log.info("授信状态check_flag修改为2，初审不通过");
				return JsonResponse2.success("授信状态修改成功");
			}
			if (check_flag == 3) {
				tabUsrinf.setCheck_flag(check_flag.byteValue());
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				log.info("授信状态check_flag修改为3，初审通过");
				return JsonResponse2.success("授信状态修改成功");
			}
			if (check_flag == 4) {
				tabUsrinf.setCheck_flag(check_flag.byteValue());
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				log.info("授信状态check_flag修改为4，复审不通过");
				return JsonResponse2.success("授信状态修改成功");
			}
			if (check_flag == 5) {
				tabUsrinf.setCheck_flag(check_flag.byteValue());
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				log.info("授信状态check_flag修改为5，复审通过");
				return JsonResponse2.success("授信状态修改成功");
			}
			return JsonResponse2.fail("授信状态修改失败");
		} catch (Exception e) {
			log.error("修改授信状态出错,usrid=" + usrid, e);
			return JsonResponse2.fail("修改授信状态出错 ");
		}
	}

	/**
	 * 获取授信状态接口
	 * 
	 * @param usrid
	 * @param request
	 * @return
	 */
	@RequestMapping("getCreditStatus")
	@ResponseBody
	public JsonResponse2 getCreditStatus(@RequestParam("usrid") Long usrid, HttpServletRequest request) {
		try {
			log.debug("usrid=" + usrid);
			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usrid);
			if (tabUsrinf == null) {
				return JsonResponse2.success("未提交申请").put("check_flag", 0).put("loan_limit", new BigDecimal(0))
						.put("loan_useble", new BigDecimal(0)).put("is_activate", 0).put("is_loan", 1)
						.put("limit_validity_time", "");
			}
			Date limit_validity_time = tabUsrinf.getLimit_validity_time();
			long limit_time = 0L;
			if (null != limit_validity_time) {
				limit_time = limit_validity_time.getTime() / 1000;
			}
			if (tabUsrinf.getCheck_flag() == 0) {
				log.info("提交未完成，check_flag=0；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + "; 额度是否冻结？is_loan="
						+ tabUsrinf.getIs_loan());
				return JsonResponse2.success("提交未完成").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 1) {
				log.info("授信额度未审核，check_flag=1；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + "; 额度是否冻结？is_loan="
						+ tabUsrinf.getIs_loan());
				return JsonResponse2.success("未审核").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 2) {
				log.info("授信额度初审不通过，check_flag=2；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate()
						+ "; 额度是否冻结？is_loan=" + tabUsrinf.getIs_loan());
				return JsonResponse2.success("初审不通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 3) {
				log.info("授信额度初审通过，check_flag=3；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate()
						+ "; 额度是否冻结？is_loan=" + tabUsrinf.getIs_loan());
				return JsonResponse2.success("初审通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 4) {
				log.info("授信额度复审不通过，check_flag=4;用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate()
						+ "；额度是否冻结？is_loan=" + tabUsrinf.getIs_loan());
				return JsonResponse2.success("复审不通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 5) {
				log.info("复审通过，check_flag=5；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + ";授信额度是否冻结？is_loan="
						+ tabUsrinf.getIs_loan());
				return JsonResponse2.success("复审通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", tabUsrinf.getLoan_limit())
						.put("loan_useble", tabUsrinf.getLoan_limit().subtract(tabUsrinf.getLoan_used()))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			if (tabUsrinf.getCheck_flag() == 6) {
				log.info("账号被冻结，check_flag=6；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + ";授信额度已冻结is_loan=0");
				return JsonResponse2.success("账号被冻结").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", new BigDecimal(0)).put("loan_useble", new BigDecimal(0))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", 0)
						.put("limit_validity_time", limit_time);
			}
			// 终审不通过
			if (WebServiceConstant.CHECK_FLAG_FINAL_NOT_PASS.equals(tabUsrinf.getCheck_flag())) {
				log.info("终审不通过，check_flag=7；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + ";授信额度是否冻结？is_loan="
						+ tabUsrinf.getIs_loan());
				return JsonResponse2.success("终审不通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", tabUsrinf.getLoan_limit())
						.put("loan_useble", tabUsrinf.getLoan_limit().subtract(tabUsrinf.getLoan_used()))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			// 终审通过
			if (WebServiceConstant.CHECK_FLAG_FINAL_PASS.equals(tabUsrinf.getCheck_flag())) {
				log.info("终审通过，check_flag=8；用户帐号是否激活？is_activate=" + tabUsrinf.getIs_activate() + ";授信额度是否冻结？is_loan="
						+ tabUsrinf.getIs_loan());
				return JsonResponse2.success("终审通过").put("check_flag", tabUsrinf.getCheck_flag())
						.put("loan_limit", tabUsrinf.getLoan_limit())
						.put("loan_useble", tabUsrinf.getLoan_limit().subtract(tabUsrinf.getLoan_used()))
						.put("is_activate", tabUsrinf.getIs_activate()).put("is_loan", tabUsrinf.getIs_loan())
						.put("limit_validity_time", limit_time);
			}
			return JsonResponse2.fail("查询获取授信状态出错 ");
		} catch (Exception e) {
			log.error("获取授信状态出错,usrid=" + usrid, e);
			return JsonResponse2.fail("查询获取授信状态出错 ");
		}
	}

	/**
	 * 修改已用授信额度接口
	 */
	@RequestMapping("setCreditLimit")
	@ResponseBody
	public JsonResponse2 setCreditLimit(@RequestParam("usrid") Long usrid, @RequestParam("add_flag") Integer add_flag,
			@RequestParam("loan_change") BigDecimal loan_change, HttpServletRequest request) {
		try {
			log.debug("usrid=" + usrid + ",add_flag=" + add_flag + ",loan_change=" + loan_change);
			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usrid);
			if (tabUsrinf == null) {
				return JsonResponse2.fail("用户不存在");
			}
			if (add_flag == 1) {// 增加
				BigDecimal addLoanUsed = tabUsrinf.getLoan_used();
				addLoanUsed = addLoanUsed.add(loan_change);
				BigDecimal loan_limit = tabUsrinf.getLoan_limit();
				if (addLoanUsed.compareTo(loan_limit) == 1) {
					return JsonResponse2.fail("可用额度不能超过贷款总额度！");
				}
				tabUsrinf.setLoan_used(addLoanUsed);
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				return JsonResponse2.success("已用授信额度增加");
			}
			if (add_flag == 2) {// 减少
				BigDecimal cutLoanUsed = tabUsrinf.getLoan_used();
				cutLoanUsed = cutLoanUsed.subtract(loan_change);
				if (cutLoanUsed.signum() == -1) {
					cutLoanUsed = new BigDecimal(0);
					log.error("变动的额度不能超过已用授信额度！");
				}
				tabUsrinf.setLoan_used(cutLoanUsed);
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				return JsonResponse2.success("已用授信额度减少");
			}
			return JsonResponse2.fail("已用授信额度修改失败");
		} catch (Exception e) {
			log.error("已用授信额度修改出错,usrid=" + usrid, e);
			return JsonResponse2.fail("已用授信额度修改出错 ");
		}
	}

	/**
	 * 获取风控用户补充资料打码图片
	 * 
	 * @param usrid
	 * @param request
	 * @return
	 */
	@RequestMapping("getUsrFkPic")
	@ResponseBody
	public JsonResponse2 getUsrFkPic(@RequestParam("usr_id") Long usr_id, HttpServletRequest request) {
		try {
			log.debug("usr_id" + usr_id);
			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usr_id);
			if (tabUsrinf == null) {
				return JsonResponse2.fail("用户不存在");
			}
			Long usrinf_id = tabUsrinf.getUsrinf_id();
			TabUsrComplementPicModel model = new TabUsrComplementPicModel();
			model.setUsrinf_id(usrinf_id.intValue());
			model.setPic_type(1);// 打码图片
			List<TabUsrComplementPic> usrComplementPic_list = tabUsrComplementPicService.queryByList(model);
			List<String> pic_addr_list = new ArrayList<String>();
			if (usrComplementPic_list.size() > 0) {
				for (TabUsrComplementPic tabUsrComplementPic : usrComplementPic_list) {
					if (null != tabUsrComplementPic) {
						String msUrl = URLUtils.get("msUrl");
						String host = msUrl.substring(0, msUrl.lastIndexOf('/'));
						String pic_urlStr = host + tabUsrComplementPic.getCom_pic_addr();
						pic_addr_list.add(pic_urlStr);
					}
				}
			}
			log.debug("图片所属usr_id：" + usr_id + "; 图片地址集合pic_addr_list大小：" + pic_addr_list.size());
			return JsonResponse2.success().put("usr_id", usr_id).put("pic_addr_list", pic_addr_list);
		} catch (Exception e) {
			log.error("获取风控用户补充资料图片出错,usrid=" + usr_id, e);
			return JsonResponse2.fail("获取风控用户补充资料图片出错,usrid=" + usr_id);
		}
	}

	/**
	 * 获取用户房产（装修）打码图片(管理订单号)
	 * 
	 * @param order_id
	 * @param request
	 * @return
	 */
	@RequestMapping("getUsrDecorationOrder_pic")
	@ResponseBody
	public JsonResponse2 getUsrDecorationOrder_pic(@RequestParam("order_id") String order_id,
			HttpServletRequest request) {
		try {
			log.debug("order_id" + order_id);
			TabUsrDecorationOrderModel order = new TabUsrDecorationOrderModel();
			order.setOrder_sn(order_id);
			Integer count = tabUsrDecorationOrderService.queryByCount(order);
			if (count <= 0) {
				return JsonResponse2.fail("用户不存在");
			}
			TabUsrDecorationOrder tabUsrDecorationOrder = tabUsrDecorationOrderService
					.queryTabUsrDecorationOrder(order);
			List<String> house_pic_addr_list = new ArrayList<String>();// 存放房产证图片list;
			List<String> decoration_pic_addr_list = new ArrayList<String>();// 存放装修图片list;
			if (null != tabUsrDecorationOrder) {
				Integer decoration_order_id = tabUsrDecorationOrder.getDecoration_order_id();
				String order_sn = tabUsrDecorationOrder.getOrder_sn();
				// 1:房产证图片
				TabUsrPremisePermitPic house_model = new TabUsrPremisePermitPic();
				house_model.setDecoration_order_id(decoration_order_id);
				house_model.setOrder_sn(order_sn);
				house_model.setPic_type(1);// 打码图片
				List<TabUsrPremisePermitPic> houseList = tabUsrPremisePermitPicService
						.queryTabUsrPremisePermitPic(house_model);
				if (houseList.size() > 0) {
					for (TabUsrPremisePermitPic tabUsrPremisePermitPic : houseList) {
						if (null != tabUsrPremisePermitPic) {
							String msUrl = URLUtils.get("msUrl");
							String host = msUrl.substring(0, msUrl.lastIndexOf('/'));
							String pic_urlStr = host + tabUsrPremisePermitPic.getPic_addr();
							// String pic_urlStr =
							// tabUsrPremisePermitPic.getPic_addr();
							house_pic_addr_list.add(pic_urlStr);
						}
					}
				}
				// 2:装修图片
				TabUsrDecorationContractPic decoration_model = new TabUsrDecorationContractPic();
				decoration_model.setDecoration_order_id(decoration_order_id);
				decoration_model.setOrder_sn(order_sn);
				decoration_model.setPic_type(1);// 打码图片
				List<TabUsrDecorationContractPic> decorationList = tabUsrDecorationContractPicService
						.queryTabUsrDecorationContractPic(decoration_model);
				if (decorationList.size() > 0) {
					for (TabUsrDecorationContractPic tabUsrDecorationContractPic : decorationList) {
						if (null != tabUsrDecorationContractPic) {
							String msUrl = URLUtils.get("msUrl");
							String host = msUrl.substring(0, msUrl.lastIndexOf('/'));
							String pic_urlStr = host + tabUsrDecorationContractPic.getPic_addr();
							// String pic_urlStr =
							// tabUsrDecorationContractPic.getPic_addr();
							decoration_pic_addr_list.add(pic_urlStr);
						}
					}
				}
			}
			log.debug("图片所属order_sn：" + order_id + "; 房产证图片地址集合house_pic_addr_list大小：" + house_pic_addr_list.size()
					+ ";装修图片地址集合decoration_pic_addr_list大小：" + decoration_pic_addr_list.size());
			return JsonResponse2.success().put("order_id", order_id).put("house_pic_addr_list", house_pic_addr_list)
					.put("decoration_pic_addr_list", decoration_pic_addr_list);
		} catch (Exception e) {
			log.error("获取风控用户补充资料图片出错,order_sn=" + order_id, e);
			return JsonResponse2.fail("获取风控用户补充资料图片出错,order_sn=" + order_id);
		}
	}

	/**
	 * 激活用户账号接口（包括乐购和乐装，新浪绑卡成功后调用此接口）
	 * 
	 * @param usrid
	 * @param check_flag
	 * @param request
	 * @return
	 */
	@RequestMapping("setUsrActivate")
	@ResponseBody
	public JsonResponse2 setUsrActivate(@RequestParam("usrid") Long usrid, HttpServletRequest request) {
		try {
			log.debug("setUsrActivate usrid=" + usrid);
			TabUsrinf2 tabUsrinf = new TabUsrinf2();
			if (null != usrid) {
				tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usrid);
				if (tabUsrinf == null) {
					return JsonResponse2.fail("用户不存在");
				}
				tabUsrinf.setIs_activate(WebServiceConstant.IS_ACTIVATE_TRUE.byteValue()); // 修改用户账号为激活状态
				tabUsrinf.setIs_loan(WebServiceConstant.IS_LOAN_TRUE.byteValue()); // 额度可以使用（仅乐购的额度可以使用，乐装无额度）
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				// 增加定时器，判断所有用户（乐购用户）额度有效期是否已经过期，过期则冻结其额度
				List<TabUsrinf2> usrinf_List = tabUsrinf2Service.queryAll();
				if (null != usrinf_List && usrinf_List.size() > 0) {
					int nowDate = (int) (new Date().getTime() / 1000);
					for (TabUsrinf2 usrinf : usrinf_List) {
						if (null != usrinf) {
							Byte credit_type = usrinf.getCredit_type();
							if (credit_type.intValue() == 0) { // 乐购用户
								Date limit_validity_time = usrinf.getLimit_validity_time();
								if (null != limit_validity_time) {
									int validity_time = (int) (limit_validity_time.getTime() / 1000);
									if (validity_time < nowDate) {
										taskToUpdateLoan(10, usrinf.getUsrid(), 0); // 10s执行一次定时器
									}
								}
							}
						}
					}
				}
				return JsonResponse2.success("激活用户账号成功,usrid=" + usrid);
			} else {
				return JsonResponse2.fail("激活用户账号失败,usrid=" + usrid);
			}

		} catch (Exception e) {
			log.error("激活用户账号出错,usrid=" + usrid, e);
			return JsonResponse2.fail("激活用户账号出错 ");
		}
	}

	/**
	 * APP端获取小视科技产品开关配置接口
	 * 
	 * @author wang_xiao_long
	 * @date 20161009
	 */
	@RequestMapping("getXiaoShiProductConfig")
	@ResponseBody
	public JsonResponse2 getXiaoShiProductConfig(Long usrid) {
		try {
			// 参数校验
			if (usrid == null) {
				return JsonResponse2.fail("usrid 不能为空");
			}
			log.info("getXiaoShiProductConfig param " + ",usrid=" + usrid);
			// 获取配置文件信息
			String xiao_shi_account = URLUtils.get("xiao_shi_account");
			String xiao_shi_password = URLUtils.get("xiao_shi_password");
			int xiao_shi_max_left_times = Integer.valueOf(URLUtils.get("xiao_shi_max_left_times"));
			long xiao_shi_max_duration = Long.valueOf(URLUtils.get("xiao_shi_max_duration"));
			// 查找数据库配置信息
			XiaoShiConfig config = xiaoShiConfigService.queryConfigByType(WebServiceConstant.PRODUCT_TYPE_CHECK_ALIVE);
			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usrid);
			if (tabUsrinf == null) {
				return JsonResponse2.fail("没有用户记录");
			}
			// 0表示可以调用接口。-1表示开关状态关闭。-2表示两小时内调用不能超过4次。
			int flag = (config.isConfig_status() == true ? 0 : -1);
			if (flag == 0) {
				Date xiaoShiInvocationTime = tabUsrinf.getXiao_shi_invocation_time();
				int xiao_shi_left_times = tabUsrinf.getXiao_shi_left_times();
				// 如果时间不为空说明调用过了，如果为空说明该用户还没有调用过
				if (xiaoShiInvocationTime != null) {
					long xiaoShiInvocationTimeLong = xiaoShiInvocationTime.getTime();
					if ((System.currentTimeMillis() - xiaoShiInvocationTimeLong) >= xiao_shi_max_duration) {
						// 如果大于两个小时，重新设置可调用次数为xiao_shi_max_left_times次
						tabUsrinf.setXiao_shi_left_times(xiao_shi_max_left_times);
						tabUsrinf.setXiao_shi_invocation_time(new Date());
						tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
					} else {
						// 如果小于两个小时，则判断剩余次数
						if (xiao_shi_left_times == 0) {
							// 0表示可以调用接口。-1表示开关状态关闭。-2表示两小时内调用不能超过4次。
							flag = -2;
						}
					}
				} else {
					tabUsrinf.setXiao_shi_invocation_time(new Date());
					tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				}
			}
			return JsonResponse2.success().put("flag", flag).put("usrinf_id", tabUsrinf.getUsrinf_id())
					.put("xiao_shi_account", xiao_shi_account).put("xiao_shi_password", xiao_shi_password);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取信息出错", e);
			return JsonResponse2.fail("查询出错:" + e.getMessage());
		}
	}

	/**
	 * APP端将小视科技返回值写入风控系统
	 * 
	 * @author wang_xiao_long
	 * @date 20161009
	 */
	@RequestMapping("updateXiaoShiResult")
	@ResponseBody
	public JsonResponse2 updateXiaoShiResult(Long usr_order_id,Long usrinf_id, Integer interface_result, String pic_file,
			HttpServletRequest request) {
		try {
			log.info(
					"updateXiaoShiResult param " + ",usrinf_id=" + usr_order_id + ",interface_result=" + interface_result);
			if (!StringUtil.isEmpty(pic_file)) {
				log.info("pic_file:" + pic_file.substring(0, 100));
			}
			if (usr_order_id == null) {
				return JsonResponse2.fail("usr_order_id 不能为空");
			}
			if (interface_result == null) {
				return JsonResponse2.fail("interface_result 不能为空");
			}
			if (interface_result.intValue() == WebServiceConstant.CODE_SUCCESS && StringUtil.isEmpty(pic_file)) {
				return JsonResponse2.fail("pic_file 不能为空");
			}
			TabUsrOrder tabUsrOrder = tabUsrOrderService.queryByUsrOrderId(usr_order_id);
			if (tabUsrOrder == null) {
				return JsonResponse2.fail("根据usr_order_id未查询到tabUsrOrder");
			}
			
			int pass_flag = -1;
			String upload_check_alive_pic = URLUtils.get("upload_check_alive_pic");
			// 文件名字
			String fileName = UUID.randomUUID() + ".jpg";
			// 保存图片
			ImageProcess.GenerateImage2(pic_file, upload_check_alive_pic + "/" + fileName);
			log.info("check_alive_pic 物理路径：" + upload_check_alive_pic + "/" + fileName);
			String check_alive_pic = URLUtils.get("picStr") + "/check_alive/" + fileName;// 写入数据库并在前台展示的虚拟路径
			log.info("check_alive_pic虚拟路径地址" + check_alive_pic);
			tabUsrOrder.setCheck_alive_pic(check_alive_pic);
			tabUsrOrder.setXiaoshi_check_alive_result(interface_result);
			// 调用一次就减少一次
			TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(usrinf_id);
			tabUsrinf2.setXiao_shi_left_times(tabUsrinf2.getXiao_shi_left_times() - 1);
			//更新注册用户表
			tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf2);
			// 如果活体检测成功，则判断身份证号姓名照片比对接口是否开启
			if (interface_result.intValue() == WebServiceConstant.CODE_SUCCESS) {
				XiaoShiConfig condition = new XiaoShiConfig();
				condition.setProduct_type(WebServiceConstant.PRODUCT_TYPE_ID_CARD_CHECK);
				List<XiaoShiConfig> xiaoShiConfigList = xiaoShiConfigService.queryByCondition(condition);
				XiaoShiConfig config = xiaoShiConfigList.get(0);
				if (config.isConfig_status()) {
					// 调用接口
					String id_name_face_result = callIdNameFaceInterface(tabUsrOrder.getBorrower_usrname(), tabUsrOrder.getBorrower_id_card(),
							pic_file);
					com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSONObject
							.parseObject(id_name_face_result);
					int result = jsonObj.getIntValue("RESULT");
					String msg = jsonObj.getString("MESSAGE");
					String guid = jsonObj.getString("guid");
					tabUsrOrder.setXiaoshi_id_card_check_result(result);
					tabUsrOrder.setXiaoshi_id_card_check_msg(msg);
					tabUsrOrder.setXiaoshi_id_card_check_guid(guid);
					if (WebServiceConstant.XIAO_SHI_ID_NAME_FACE_RESULT_SCORE.equals(jsonObj.getInteger("RESULT"))) {
						String score = jsonObj.getJSONObject("data").getString("score");
						tabUsrOrder.setXiaoshi_id_card_check_score(score);
					}
					// 设置对比分数是否通过标志
					if (new BigDecimal(tabUsrOrder.getXiaoshi_id_card_check_score()).intValue() > config
							.getScore_standard()) {
						pass_flag = 0;
					}
				}
			}
			// 更新数据库
			tabUsrOrderService.updateByPrimaryKeySelective(tabUsrOrder);
			return JsonResponse2.success().put("pass_flag", pass_flag);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取信息出错", e);
			return JsonResponse2.fail("查询出错:" + e.getMessage());
		}
	}

	/**
	 * @author frank_wang
	 * @data 2016年10月24日
	 * @description 发送短信给风控人员，提供给外系统接口
	 * @return
	 */
	@RequestMapping("sendMessageToFengKongOperator")
	@ResponseBody
	public JsonResponse2 sendMessageToFengKongOperator(Integer button_id, String content) {
		try {
			sysUserService.sendMessageByButtonAuthority(content, button_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("根据权限发送短信失败");
		}
		return JsonResponse2.success();
	}

	/**
	 * @author frank_wang
	 * @data 2016年10月25日
	 * @description 获取审核日志列表（根据用户ID）
	 * @return
	 */
	@RequestMapping("getCheckLogList")
	@ResponseBody
	public JsonResponse2 getCheckLogList(Long borrow_uid) {
		try {

			log.info("getCheckLogList param----borrow_uid:" + borrow_uid);
			if (borrow_uid == null) {
				return JsonResponse2.fail("borrow_uid should not be null");
			}

			TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrId(borrow_uid);

			TabCheckLogModel condition = new TabCheckLogModel();
			condition.setUsrinf_id(tabUsrinf.getUsrinf_id().intValue());
			List<TabCheckLog> list = tabCheckLogService.queryByList(condition);
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			for (TabCheckLog log : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("operate_time", DateUtil.getTimestampSecond(log.getOperate_time()));
				map.put("operator", log.getOperator());
				map.put("check_remark", log.getCheck_remark());
				map.put("check_result", tabCheckLogService.transterCheckResult(Integer.valueOf(log.getCheck_result())));
				map.put("applyfor_limit", log.getApplyfor_limit());
				resultList.add(map);
			}
			String phpCheckFlag = transferCheckFlag(tabUsrinf.getCheck_flag().byteValue(), tabUsrinf);
			// 当前审批人处理
			List<SysUser> sysUserList = new ArrayList<SysUser>();
			String currentCheckOperator = "";
			if (WebServiceConstant.CHECK_FLAG_TO_AUDIT.equals(tabUsrinf.getCheck_flag())) {
				sysUserList = sysUserService.querySysUsersByButtonAuthority(WebServiceConstant.FIRST_VERIFY_BUTTON_ID,
						false);
			} else if (WebServiceConstant.CHECK_FLAG_FIRST_PASS.equals(tabUsrinf.getCheck_flag())) {
				sysUserList = sysUserService.querySysUsersByButtonAuthority(WebServiceConstant.SECOND_VERIFY_BUTTON_ID,
						false);
			} else if (WebServiceConstant.CHECK_FLAG_SECOND_PASS.equals(tabUsrinf.getCheck_flag())) {
				sysUserList = sysUserService.querySysUsersByButtonAuthority(WebServiceConstant.FINAL_VERIFY_BUTTON_ID,
						false);
			}
			if (!sysUserList.isEmpty()) {
				for (SysUser sysUser : sysUserList) {
					currentCheckOperator += (sysUser.getReal_name() + ",");
				}
				currentCheckOperator = currentCheckOperator.substring(0, currentCheckOperator.length() - 1);
			}

			Date applyForDate = tabUsrinf.getApplyfor_time();
			String applyForDateString = "";
			if (null != applyForDate) {
				applyForDateString = String.valueOf(applyForDate.getTime());
				applyForDateString = applyForDateString.substring(0, applyForDateString.length() - 3);
			}

			return JsonResponse2.success().put("check_log_list", resultList).put("applyfor_time", applyForDateString)
					.put("mobile_phone", tabUsrinf.getMobile_phone()).put("usrname", tabUsrinf.getUsrname())
					.put("loan_limit", tabUsrinf.getLoan_limit())
					.put("loan_useble", tabUsrinf.getLoan_limit().subtract(tabUsrinf.getLoan_used()))
					.put("check_flag", phpCheckFlag).put("current_check_operator", currentCheckOperator);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取日志列表失败,usrinf_id:" + borrow_uid);
		}
		return JsonResponse2.success();
	}

	/**
	 * @author frank_wang
	 * @data 2016年10月25日
	 * @description 获取标的审核日志列表（根据用户ID）
	 * @return
	 */
	@RequestMapping("getbiddingCheckLogList")
	@ResponseBody
	public JsonResponse2 getbiddingCheckLogList(String order_no) {
		try {
			log.info("getCheckLogList param----borrow_uid:" + order_no);
			if (order_no == null) {
				return JsonResponse2.fail("order_no should not be null");
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("order_no", order_no);
			params.put("borrow_status", WebServiceConstant.BORROW_STATUS_ALL.toString());
			String url = URLUtils.get("getBiddingList");
			log.info("getBiddingList接口请求参数为" + params.toString());
			// 调用接口
			String data = HttpRequestUtil.sendPost(url, Tools.createLinkString(params, false));
			log.info("getBiddingList返回结果:" + data);
			if (StringUtils.isEmpty(data)) {
				return JsonResponse2.fail("getbiddingCheckLogList获取日志列表失败--order_no:" + order_no);
			}
			com.alibaba.fastjson.JSONObject result = com.alibaba.fastjson.JSONObject.parseObject(data);
			if (WebServiceConstant.CODE_SUCCESS == result.getIntValue("code")) {
				String bidding_list = result.getJSONObject("return_param").getString("bidding_list");
				List<TabBorrowInfo> bidBorrowInfosList = com.alibaba.fastjson.JSONObject.parseArray(bidding_list,
						TabBorrowInfo.class);
				if (null != bidBorrowInfosList && bidBorrowInfosList.size() > 0) {
					TabBorrowInfo tabBorrowInfo = bidBorrowInfosList.get(0);
					List<BiddingOperationLog> logList = tabBorrowInfo.getCheck_remark_dataList();
					if (logList != null && logList.size() > 0) {
						List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
						for (BiddingOperationLog log : logList) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("deal_time", log.getDeal_time());
							SysUser bean = sysUserService.queryById(log.getDeal_user());
							if (null != bean) {
								map.put("deal_user", bean.getReal_name());
							} else {
								map.put("deal_user", "");
							}
							map.put("deal_info", log.getDeal_info());
							map.put("operation", log.getOperation());
							mapList.add(map);
						}
						return JsonResponse2.success().put("check_log_list", mapList);
					}
				}
				return JsonResponse2.success("没有数据");
			} else {
				return JsonResponse2.fail("调用链金所接口失败，原因：" + result.getString("msg"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("getbiddingCheckLogList获取日志列表失败,order_no:" + order_no);
			return JsonResponse2.fail(e.getMessage());
		}
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月29日
	 * @description 根据UserId是否IsLoan标志
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getIsLoanByUserId")
	@ResponseBody
	public JsonResponse getIsLoanByUserId(Long userId) throws Exception {

		if (null == userId) {
			return JsonResponse.fail("userId should not be null");
		}
		TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId(userId);
		if (tabUsrinf2 == null) {
			return JsonResponse.fail("根据userId查询不到基本信息");
		}
		return JsonResponse.success().put("is_loan", tabUsrinf2.getIs_loan()).put("usrname", tabUsrinf2.getUsrname())
				.put("id_card ", tabUsrinf2.getId_card()).put("mobile_phone", tabUsrinf2.getMobile_phone());
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 根据数据字典类型编码查找相应的数据字典值
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDictionaryDatasource")
	@ResponseBody
	public JsonResponse2 getDictionaryDatasource(String type_code) throws Exception {

		try {
			if (StringUtil.isEmpty(type_code)) {
				throw new Exception("type_code should not be null");
			}
			DataParameterModel model = new DataParameterModel(null, null, null, null, null, type_code);
			List<DataDictionaryValue> list = dataManagerService.queryDDVListWithoutPage(model);
			return JsonResponse2.success().put("data_list", list);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse2.fail(e.getMessage());
		}
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月29日
	 * @description 创建用户订单并发标
	 * @param tabUsrinf2Model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("setUsrOrder")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	@ResponseBody
	public JsonResponse2 setUsrOrder(@Valid TabBorrowInfoModel model, BindingResult bindingResult,
			HttpServletRequest request) throws Exception {

//		log.info("setUsrOrder request param--" + model.toString());
//	    //必输项校验
//		if (bindingResult.hasErrors()) {
//			return JsonResponse2.fail(bindingResult.getFieldError().getField() + "不能为空");
//		}
//	    //处理请求参数
//		List<TabUsrOrderPic> tabUsrOrderPicList = JSONObject.parseArray(model.getUsr_order_pic_list(),
//				TabUsrOrderPic.class);
//		//图片路径拼接字符串
//		String picPath = tabUsrOrderPicService.getPicPath(tabUsrOrderPicList);
//		//获取店铺类型信息
//		JSONObject storeInfoObj = JSONObject.parseObject(HttpRequestUtil.sendGet(findStoreTypeDescByStoreTypeIdUrl,"store_type_id=" + model.getOrder_type()));
//		// 创建订单号
//		String orderNo = tabUsrOrderService.produceOrderNo(model.getOrder_type());
//		// 持久化订单
//		TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId(model.getBorrow_uid());
//		if (tabUsrinf2 == null) {
//			log.info("setUsrOrder根据usrId=" + model.getBorrow_uid() + "无法找到记录");
//			return JsonResponse2.fail("setUsrOrder根据usrId=" + model.getBorrow_uid() + "无法找到记录");
//		}
//		TabUsrOrder tabUsrOrder = new TabUsrOrder();
//		CopyProperties.copyPropertysWithoutNull(tabUsrOrder, tabUsrinf2);
//		CopyProperties.copyPropertysWithoutNull(tabUsrOrder, model);
//		tabUsrOrder.setOrder_sn(orderNo);
//		tabUsrOrder.setOrder_money(model.getBorrow_money());
//		tabUsrOrder.setAmortization_cnt(model.getBorrow_duration());
//		tabUsrOrder.setAmortization_money(model.getEach_amount() + "元,手续费用：" + model.getFee());
//		tabUsrOrder.setOrder_status(WebServiceConstant.ORDER_STATUS_TO_AUDIT);
//		tabUsrOrder.setCreate_time(new Date());
//		tabUsrOrder.setHave_scoring_report(0);
//		tabUsrOrder.setStore_type_name(storeInfoObj.getJSONObject("data").getString("type"));
//		tabUsrOrderService.insert(tabUsrOrder);
//		// 持久化订单照片表
//		tabUsrOrderPicService.insertTabUsrOrderPicList(tabUsrOrderPicList, tabUsrOrder.getUsr_order_id(), orderNo);
//		// 持久化身份证相关照片
//		tabUsrOrderPicService.insert(new TabUsrOrderPic(orderNo, new Byte(WebServiceConstant.PIC_TYPE_IDCARD_FRONT), 
//				tabUsrinf2.getId_card_front_pic()));
//		tabUsrOrderPicService.insert(new TabUsrOrderPic(orderNo, new Byte(WebServiceConstant.PIC_TYPE_IDCARD_REVERSE), 
//				tabUsrinf2.getId_card_reverse_pic()));
//		tabUsrOrderPicService.insert(new TabUsrOrderPic(orderNo, new Byte(WebServiceConstant.PIC_TYPE_IDCARD_WITH), 
//				tabUsrinf2.getWith_id_card_pic()));
//		//保存联系人信息和订单号的关联
//		List<TabBondsmaninf> tabBondsmaninf_List = tabBondsmaninfService.queryByList(
//				new TabBondsmaninfModel(tabUsrinf2.getUsrinf_id().intValue()));
//		tabOrderBondsmaninfService.insertTabOrderBondsmaninfList(tabBondsmaninf_List, tabUsrOrder.getUsr_order_id());
//		// 组装参数
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("order_id", orderNo);
//		params.put("borrow_uid", model.getBorrow_uid().toString());
//		params.put("borrow_name", model.getBorrow_name());
//		params.put("borrow_money", model.getBorrow_money().toString());
//		params.put("borrow_duration", model.getBorrow_duration().toString());
//		params.put("interest_type", model.getInterest_type().toString());
//		params.put("borrow_interest", model.getBorrow_interest().toString());
//		params.put("borrow_interest_rate", model.getBorrow_interest_rate().toString());
//		params.put("fee", model.getFee().toString());
//		params.put("borrow_use_desc", storeInfoObj.getJSONObject("data").getString("bidprefix"));
//		// 生成发标标题
//		tabBorrowSerialCodeService.produceBorrowTitle(model.getOrder_type(),params);
//		// 生成项目信息
//		params.put("borrow_info", URLEncoder.encode(tabBorrowSerialCodeService.produceBorrowInfo(request, model, tabUsrinf2,storeInfoObj.getJSONObject("data").getString("type")), "UTF-8"));
//		params.put("picPath", picPath);
//		params.put("borrow_use", model.getBorrow_use());
//		log.info("createBiddingUrl param" + params.toString());
//		//调用发标接口
//		String result = HttpRequestUtil.sendPost(createBiddingUrl, Tools.createLinkString(params, false));
//		if (StringUtil.isEmpty(result)) {
//			throw new RuntimeException("调用链金所接口失败 userId:" + model.getBorrow_uid());
//		}
//		log.info("createBiddingUrl result" + result.toString());
//		JSONObject reusltObj = JSONObject.parseObject(result);
//		if (reusltObj.getIntValue("code") == WebServiceConstant.CODE_SUCCESS) {
//			String userPhone = tabUsrinf2.getMobile_phone();
//			// 发标成功以后给客户发送短信
//			sendMessage.sendGroupSmsToClient(sendToCustomerWhenStartBidding, userPhone,
//					WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
//			// 发标成功以后给风控发送短信
//			sysUserService.sendMessageByButtonAuthority(
//					sendMessage.insertContentPhoneNumber(sendToRiskControlOperatorWhenStartBidding, userPhone),
//					WebServiceConstant.BORROW_CHECK_BUTTON_ID);
//			// 发标成功以后给运营人员发送短信
//			sendMessage.sendGroupSmsToClient(
//					sendMessage.insertContentPhoneNumber(sendToMarketingOperatorWhenStartBidding, userPhone),
//					sendMessage.getMarketingManagerPhones(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
//			//设置借款人为投资人
//			setMemberToVip(tabUsrinf2.getUsrid());
//			//异步调用采集系统
//			threadPoolTaskExecutor.execute(new InvocateFkGatherDataTask(tabUsrinf2.getUsrid(), tabUsrinf2.getBorrower_usrname(),
//					tabUsrinf2.getBorrower_mobile_phone(), tabUsrinf2.getBorrower_id_card(),"",tabUsrinf2.getBank_id(),
//					model.getOrder_source(),model.getBorrow_money(),orderNo));
//			return JsonResponse2.success()
//					.put("borrow_id", reusltObj.getJSONObject("return_param").getString("borrow_id"))
//					.put("tmpbidding_id", reusltObj.getJSONObject("return_param").getString("tmpbidding_id"));
//		} else {
//			throw new RuntimeException("调用链金所接口失败 userId:" + model.getBorrow_uid());
//		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月11日
	 * @description 提交订单资料接口
	 * @return
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	@RequestMapping("setOrdersInf")
	@ResponseBody
	public JsonResponse2 setOrdersInf(@Valid TabBorrowInfoModel model, BindingResult result,HttpServletRequest request)
			throws NumberFormatException, Exception {

		log.info("setOrdersInf request params---" + model.toString());
		
		if (ParamCheckUtil.checkParams(result, "submit_step") != null) {
			return ParamCheckUtil.checkParams(result, "submit_step");
		}
		if (WebServiceConstant.SUBMIT_STEP_CREATE.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result,
					"borrow_money,borrow_interest,borrow_interest_rate,each_amount,borrow_interest_rate,"
							+ "store_charge_rate,user_charge_rate,borrow_duration,fee,interest_type,borrow_use,store_uid,store_name,"
							+ "store_contract,store_tel,borrow_uid,order_type,order_source");
			if (response != null) {
				return response;
			}
			// 生成订单号
			String orderNo = tabUsrOrderService.produceOrderNo(model.getOrder_type());
			TabUsrOrder tabUsrOrder = new TabUsrOrder();
			tabUsrOrder.setOrder_sn(orderNo);
			tabUsrOrder.setAmortization_money(model.getEach_amount() + "元,手续费用：" + model.getFee() + "元");
			tabUsrOrder.setOrder_money(model.getBorrow_money());
			tabUsrOrder.setAmortization_cnt(model.getBorrow_duration());
			// 生成发标标题
			tabUsrOrder.setBorrow_name(tabBorrowSerialCodeService.produceBorrowTitle(model.getOrder_type()));
			// 获取店铺类型信息
			try {
				JSONObject storeInfoObj = JSONObject.parseObject(HttpRequestUtil
						.sendGet(findStoreTypeDescByStoreTypeIdUrl, "store_type_id=" + model.getOrder_type()));
				tabUsrOrder.setStore_type_name(storeInfoObj.getJSONObject("data").getString("type"));
				tabUsrOrder.setBorrow_use_desc(storeInfoObj.getJSONObject("data").getString("bidprefix"));
			} catch (Exception e) {
				e.printStackTrace();
				log.info("获取店铺类型信息失败");
			}
			CopyProperties.copyPropertysWithoutNull(tabUsrOrder, model);
			// 持久化订单
			tabUsrOrderService.insertSelective(tabUsrOrder);
			return JsonResponse2.success().put("usr_order_id", tabUsrOrder.getUsr_order_id());
		} else if (WebServiceConstant.SUBMIT_STEP_ID_CARD.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result,
					"borrower_usrname,borrower_id_card,id_card_front_pic,id_card_reverse_pic,with_id_card_pic,usr_order_id");
			if (response != null) {
				return response;
			}
			TabUsrOrder order = tabUsrOrderService.queryByUsrOrderId(model.getUsr_order_id());
			try {
				order.setSex(new Byte(IdCard.getGenderByIdCard(model.getBorrower_id_card())));
				order.setAge(IdCard.getAgeByIdCard(model.getBorrower_id_card()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("身份证格式不合法");
			}
			
			CopyProperties.copyPropertysWithoutNull(order, model);
			// 更新订单表
			tabUsrOrderService.updateByPrimaryKeySelective(order);
			return JsonResponse2.success().put("usr_order_id", order.getUsr_order_id());

		} else if (WebServiceConstant.SUBMIT_STEP_CHECK_ALIVE.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result, "usr_order_id");
			if (response != null) {
				return response;
			}
			TabUsrOrder usrorder = tabUsrOrderService.queryByUsrOrderId(model.getUsr_order_id());
			CopyProperties.copyPropertysWithoutNull(usrorder, model);
			tabUsrOrderService.updateByPrimaryKeySelective(usrorder);
			return JsonResponse2.success().put("usr_order_id", usrorder.getUsr_order_id());
		} else if (WebServiceConstant.SUBMIT_STEP_IDENTITY.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result, "borrow_uid,usr_order_id,marital,diploma,register_place,bank_id,"
					+ "income,cur_hire_duration,industry,profession_level");
			if (response != null) {
				return response;
			}
			TabUsrOrder usrorder = tabUsrOrderService.queryByUsrOrderId(model.getUsr_order_id());
			// 处理Json参数
			tabUsrinf2Service.dealJson(model);
			CopyProperties.copyPropertysWithoutNull(usrorder, model);
			//查询户籍是否是商家本地户籍
			try {
				JSONObject resultObj = JSONObject.parseObject(HttpRequestUtil
						.sendGet(is_local_register_place, "store_uid=" + usrorder.getStore_uid()+"&register_place="+model.getRegister_place()));
				usrorder.setLocal_register_place(resultObj.getByte("local_register_place"));
			} catch (Exception e) {
				e.printStackTrace();
				log.info("获取店铺类型信息失败");
			}
			//生成项目信息
			String type = "";
			try {
				JSONObject storeInfoObj = JSONObject.parseObject(HttpRequestUtil
						.sendGet(findStoreTypeDescByStoreTypeIdUrl, "store_type_id=" + usrorder.getOrder_type()));
				type = storeInfoObj.getJSONObject("data").getString("type");
			} catch (Exception e) {
				e.printStackTrace();
				log.info("获取店铺类型信息失败");
			}
			usrorder.setBorrow_info(tabBorrowSerialCodeService.produceBorrowInfo(request,type,usrorder));
			// 更新订单表
			tabUsrOrderService.updateByPrimaryKeySelective(usrorder);
			// 更新联系人信息
			tabOrderBondsmaninfService.insertList(model.getTabOrderBondsmaninfList(), usrorder.getUsr_order_id());
			sendMessage.sendGroupSmsToClient(new StringBuffer(infoSubmitStartToStore).insert(3, usrorder.getBorrower_mobile_phone()).toString(), 
					usrorder.getStore_tel(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
			return JsonResponse2.success().put("usr_order_id", usrorder.getUsr_order_id());
		} else if (WebServiceConstant.SUBMIT_STEP_CONTRACT.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result, "usr_order_id");
			if (response != null) {
				return response;
			}
			// 处理图片Json参数
			tabUsrinf2Service.dealJson(model);
			TabUsrOrder usrorder = tabUsrOrderService.queryByUsrOrderId(model.getUsr_order_id());
			CopyProperties.copyPropertysWithoutNull(usrorder, model);
			tabUsrOrderService.updateByPrimaryKeySelective(usrorder);
			// 持久化订单照片表
			tabUsrOrderPicService.insertTabUsrOrderPicList(model.getTabUsrOrderPicList(), usrorder.getUsr_order_id(),
								usrorder.getOrder_sn());
			//生成合同
			get_exchang_contract(usrorder.getOrder_sn(),request);
			
			return JsonResponse2.success().put("usr_order_id", usrorder.getUsr_order_id());
		} else if (WebServiceConstant.SUBMIT_STEP_FINAL.equals(model.getSubmit_step())) {
			// 参数校验
			JsonResponse2 response = ParamCheckUtil.checkParams(result, "usr_order_id");
			if (response != null) {
				return response;
			}
			TabUsrOrder usrorder = tabUsrOrderService.queryByUsrOrderId(model.getUsr_order_id());
			CopyProperties.copyPropertysWithoutNull(usrorder, model);
			usrorder.setOrder_status(WebServiceConstant.ORDER_STATUS_TO_AUDIT);
			// 更新订单表
			tabUsrOrderService.updateByPrimaryKeySelective(usrorder);
			//资料提交成功发送短信
			try {
				//发送短信给风控订单初审人员
				sysUserService.sendMessageByButtonAuthority(new StringBuffer(infoSubmitSuccessMessageToOrderFirst)
						.insert(13, usrorder.getBorrower_usrname()+usrorder.getBorrower_mobile_phone()).toString(),
						WebServiceConstant.ORDER_CHECK_FIRST_ID);
				//发送短信给运营人员
				sendMessage.sendGroupSmsToClient(new StringBuffer(infoSubmitSuccessMessageToOperator).
						insert(3, usrorder.getBorrower_usrname()+usrorder.getBorrower_mobile_phone()).toString(),
						sendMessage.getMarketingManagerPhones(), WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
				//发送短信给用户
				sendMessage.sendGroupSmsToClient(infoSubmitSuccessMessageToCustomer, usrorder.getBorrower_mobile_phone(), 
						WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("发送短信出错，usr_order_id="+usrorder.getUsr_order_id());
			}
			//异步调用采集系统
			threadPoolTaskExecutor.execute(new InvocateFkGatherDataTask(usrorder.getBorrow_uid(), usrorder.getBorrower_usrname(),
					usrorder.getBorrower_mobile_phone(), usrorder.getBorrower_id_card(), "",
					usrorder.getBank_id(), usrorder.getOrder_source(), usrorder.getOrder_money(), usrorder.getOrder_sn()));
			
			return JsonResponse2.success().put("usr_order_id", usrorder.getUsr_order_id());
		} else {
			return JsonResponse2.fail("submit_step 值不合法");
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月16日
	 * @description 获取订单合同
	 * @return
	 */
	@RequestMapping("get_orders_contract")
	@ResponseBody
	public JsonResponse2 getOrderContract(Long usr_order_id,HttpServletRequest request,HttpServletResponse response){
		
		if(usr_order_id == null){
			return JsonResponse2.fail("usr_order_id should not be null");
		}
		TabUsrOrder tabUsrOrder = tabUsrOrderService.queryByUsrOrderId(usr_order_id);
		String contract = tabUsrOrder.getBorrowed_contract();
		//全路径
		String entire_path = msUrl.replace("/tsfkxt", "") +contract;
		
		return JsonResponse2.success().put("borrowed_contract", entire_path);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 上传图片
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("uploadPicture")
	@ResponseBody
	public JsonResponse2 uploadPicture(MultipartFile pic_string, Long usrid) throws IllegalStateException, IOException {

		if (usrid == null) {
			return JsonResponse2.fail("usrid should not be null");
		}
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
			pic_string.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse2.fail("图片上传失败").put("pic_path", "");
		}
		String path = usrid.toString() + "/" + fileName;
		return JsonResponse2.success("图片上传成功").put("pic_path", path);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 获取用户信息列表
	 * @return
	 */
	@RequestMapping("getUsrList")
	@ResponseBody
	public JsonResponse2 getUsrList(TabUsrinf2Model model, Integer page_no, Integer page_number) {

		if (page_no == null) {
			page_no = 1;
		}
		if (page_number == null) {
			page_number = 10;
		}
		model.setPage(page_no);
		model.setRows(page_number);
		// 查询数据
		List<TabUsrinf2Model> dataList = tabUsrinf2Service.queryByList(model);
		List<Map<String, Object>> usr_list = new ArrayList<Map<String, Object>>();
		for (TabUsrinf2Model tabUsrinf2Model : dataList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("usrid", tabUsrinf2Model.getUsrid());
			map.put("mobile_phone", tabUsrinf2Model.getMobile_phone());
			map.put("usrname", tabUsrinf2Model.getUsrname());
			map.put("id_card", tabUsrinf2Model.getId_card());
			map.put("is_activate", tabUsrinf2Model.getIs_activate());
			map.put("is_store", tabUsrinf2Model.getIs_store());
			Long usrid = tabUsrinf2Model.getUsrid();
			map.put("borrow_cnt", tabUsrOrderService.getBorrowCount(usrid));
			usr_list.add(map);
		}
		// 总条数
		int record_total = tabUsrinf2Service.queryByCount(model);
		// 总页数
		int page_total = record_total / page_number;
		if (record_total % page_number != 0) {
			page_total++;
		}
		return JsonResponse2.success().put("usr_list", usr_list).put("page_total", page_total).put("record_total",
				record_total);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 获取用户信息详情接口
	 * @return
	 */
	@RequestMapping("getUsrInf")
	@ResponseBody
	public JsonResponse2 getUsrInf(Long usrid) {

		if (usrid == null) {
			return JsonResponse2.fail("usrid should not be null");
		}
		log.info("getUsrInf request param usrid=" + usrid);
		TabUsrinf2 tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId(usrid);
		if (tabUsrinf2 == null) {
			return JsonResponse2.success();
		}
		String idCard = tabUsrinf2.getId_card();
		List<TabUsrOrder> tabUsrOrderList = tabUsrOrderService.queryOrderByUsrId(usrid);
		HashMap<String, Object> return_param = new HashMap<String, Object>();
		// 调用外系统接口,查询借款总金额以及最近7天要还金额
		getUsrDebtAmount(usrid, return_param);
		// 调用外系统接口，查询用户帮卡信息
		getUsrBankInfo(usrid, return_param);
		// 绑定返回参数
		return_param.put("usrid", tabUsrinf2.getUsrid());
		return_param.put("mobile_phone", tabUsrinf2.getMobile_phone());
		return_param.put("usrname", tabUsrinf2.getUsrname());
		return_param.put("is_store", tabUsrinf2.getIs_store());
		return_param.put("borrower_usrname", tabUsrinf2.getBorrower_usrname());
		return_param.put("borrower_id_card", tabUsrinf2.getBorrower_id_card());
		return_param.put("borrow_cnt", tabUsrOrderService.getBorrowCount(usrid));
		return_param.put("id_card", idCard);
		return_param.put("id_card_front_pic", picServerIp + tabUsrinf2.getId_card_front_pic());
		return_param.put("id_card_reverse_pic", picServerIp + tabUsrinf2.getId_card_reverse_pic());
		return_param.put("with_id_card_pic", picServerIp + tabUsrinf2.getWith_id_card_pic());
		return_param.put("is_activate", tabUsrinf2.getIs_activate());
		return_param.put("head_portrait_pic", picServerIp + tabUsrinf2.getHead_portrait_pic());
		return_param.put("order_list", tabUsrOrderList);
		JsonResponse2 jsonResponse2 = JsonResponse2.success();
		jsonResponse2.setReturn_param(return_param);
		return jsonResponse2;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 获取订单信息列表接口
	 * @return
	 */
	@RequestMapping("getUsrOrderList")
	@ResponseBody
	public JsonResponse2 getUsrOrderList(TabUsrinf2Model tabUsrinf2Model, Integer page_no, Integer page_number) {

		log.info("getUsrOrderList request param---" + tabUsrinf2Model.toString());
		;
		if (page_no == null) {
			page_no = 1;
		}
		if (page_number == null) {
			page_number = 10;
		}
		// 由于前期设计有误，这里参数需要转换下
		TabUsrinf2Model newModel = new TabUsrinf2Model();
		newModel.setPage(page_no);
		newModel.setRows(page_number);
		newModel.setBorrower_usrname(tabUsrinf2Model.getUsrname());
		newModel.setBorrower_id_card(tabUsrinf2Model.getId_card());
		newModel.setBorrower_mobile_phone(tabUsrinf2Model.getMobile_phone());
		newModel.setStore_name(tabUsrinf2Model.getStore_name());
		newModel.setOrder_status(tabUsrinf2Model.getOrder_status());
		newModel.setBorrow_uid(tabUsrinf2Model.getUsrid());
		List<TabUsrOrder> list = tabUsrOrderService.queryByList(newModel);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if (list != null && list.size() > 0) {
			for (TabUsrOrder order : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("order_sn", order.getOrder_sn());
				map.put("create_time", DateUtil.getTimestampSecond(order.getCreate_time()));
				map.put("order_type", order.getOrder_type());
				map.put("store_type_name", order.getStore_type_name());
				map.put("borrow_uid", order.getBorrow_uid());
				// 借款人手机号
				map.put("mobile_phone", order.getBorrower_mobile_phone());
				map.put("usrname", order.getBorrower_usrname());
				map.put("id_card", order.getBorrower_id_card());
				map.put("order_money", order.getOrder_money().setScale(2, BigDecimal.ROUND_HALF_UP));
				map.put("store_uid", order.getStore_uid());
				map.put("store_name", order.getStore_name());
				map.put("order_status", order.getOrder_status());
				map.put("submit_step", order.getSubmit_step());
				map.put("scene_id", order.getScene_id());
				map.put("borrowed_contract", order.getBorrowed_contract());
				map.put("usr_order_id", order.getUsr_order_id());
				map.put("amortization_cnt", order.getAmortization_cnt());
				map.put("amortization_money", order.getAmortization_money());
				mapList.add(map);
			}
			// 总条数
			int record_total = tabUsrOrderService.queryByCount(newModel);
			// 总页数
			int page_total = record_total / page_number;
			if (record_total % page_number != 0) {
				page_total++;
			}
			return JsonResponse2.success().put("order_list", mapList).put("page_total", page_total).put("record_total",
					record_total);
		}

		return JsonResponse2.success().put("order_list", mapList).put("page_total", 0).put("record_total", 0);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 查询订单详细信息
	 * @param order_sn
	 * @return
	 */
	@RequestMapping("getUsrOrderInf")
	@ResponseBody
	public JsonResponse2 getUsrOrderInf(String order_sn) {

		log.info("getUsrOrderInf request order_sn:" + order_sn);
		if (StringUtil.isEmpty(order_sn)) {
			return JsonResponse2.fail("order_sn should not be null");
		}
		TabUsrOrder order = tabUsrOrderService.queryOrderByOrderNo(order_sn);
		if (order == null) {
			return JsonResponse2.fail("根据订单号未查询到订单,order_sn=" + order_sn);
		}
		List<TabUsrOrderPic> tabUsrOrderPicList = tabUsrOrderPicService.queryPicByUserOrderId(order.getUsr_order_id());
		if (tabUsrOrderPicList != null && tabUsrOrderPicList.size() > 0) {
			for (TabUsrOrderPic pic : tabUsrOrderPicList) {
				pic.setPic_addr(picServerIp + "/" + pic.getPic_addr());
			}
		}
		Integer checkTime = 0;
		if (order.getCheck_time() != null) {
			checkTime = DateUtil.getTimestampSecond(order.getCheck_time());
		}
		return JsonResponse2.success().put("order_sn", order_sn)
				.put("create_time", DateUtil.getTimestampSecond(order.getCreate_time()))
				.put("order_type", order.getOrder_type()).put("borrow_uid", order.getBorrow_uid())
				.put("mobile_phone", order.getMobile_phone()).put("usrname", order.getBorrower_usrname())
				.put("id_card", order.getBorrower_id_card()).put("order_money", order.getOrder_money())
				.put("store_uid", order.getStore_uid()).put("store_name", order.getStore_name())
				.put("check_time", checkTime).put("order_status", order.getOrder_status())
				.put("amortization_cnt", order.getAmortization_cnt())
				.put("amortization_money", order.getAmortization_money()).put("usr_order_pic_list", tabUsrOrderPicList)
				.put("borrow_interest_rate", order.getBorrow_interest_rate())
				.put("store_charge_rate", order.getStore_charge_rate())
				.put("user_charge_rate", order.getUser_charge_rate()).put("check_remark", order.getCheck_remark())
				.put("remit_time", order.getRemit_time() == null ? ""
						: DateUtil.getTimestampSecond(order.getRemit_time()))
				.put("borrower_mobile_phone", order.getBorrower_mobile_phone());
				
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月01日
	 * @description 设置订单状态
	 * @param order_sn
	 * @return
	 */
	@RequestMapping("setOrderStatus")
	@ResponseBody
	public JsonResponse2 setOrderStatus(@Valid TabUsrOrder order) {

		log.info("setOrderStatus request params:" + order.toString());
		// 当订单状态为2时要设置打款给商家时间
		if (WebServiceConstant.ORDER_STATUS_TO_REPAY.equals(order.getOrder_status())) {
			order.setRemit_time(new Date());
		}
		tabUsrOrderService.updateByOrderSnSelective(order, order.getOrder_sn());
		return JsonResponse2.success();
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description
	 * @return
	 */
	@RequestMapping("setUsrStoreStatus")
	@ResponseBody
	public JsonResponse2 setUsrStoreStatus(String usrid, String is_store) {

		if (StringUtils.isEmpty(usrid)) {
			return JsonResponse2.fail("usrid should not be null");
		}

		if (StringUtils.isEmpty(is_store)) {
			return JsonResponse2.fail("is_store should not be null");
		}
		TabUsrinf2 tabUsrinfQuery = tabUsrinf2Service.queryTabUsrinf2ByUsrId(Long.valueOf(usrid));
		if (tabUsrinfQuery == null) {
			return JsonResponse2.fail("根据usrId=" + usrid + "无法查询到用户信息");
		}
		TabUsrinf2 tabUsrinf2 = new TabUsrinf2();
		tabUsrinf2.setUsrid(Long.valueOf(usrid));
		tabUsrinf2.setIs_store(new Byte(is_store));
		tabUsrinf2.setUsrinf_id(tabUsrinfQuery.getUsrinf_id());
		tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf2);

		return JsonResponse2.success("修改用户开店状态成功");
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description 获取用户营收统计列表
	 * @return
	 */
	@RequestMapping("get_debt_amount_list")
	@ResponseBody
	public JsonResponse2 getDebtAmountList(TabUsrinf2Model model, Integer page_no, Integer page_number) {
		if (model.getUsr_type() == null) {
			return JsonResponse2.fail("usr_type should not be null");
		}
		log.info("getDebtAmountList request params----" + model.toString());
		// 处理请求参数
		if (page_no == null) {
			page_no = 1;
		}
		if (page_number == null) {
			page_number = 10;
		}
		// 由于前期设计不合理，这边需要转换下
		model.setBorrower_mobile_phone(model.getMobile_phone());
		model.setBorrower_usrname(model.getBorrower_usrname());
		model.setMobile_phone(null);
		model.setUsrname(null);

		model.setPage(page_no);
		model.setRows(page_number);
		model.setIs_store(new Byte(model.getUsr_type()));
		List<TabUsrinf2Model> list = tabUsrinf2Service.selectUserWithOrderTable(model);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if (list == null || list.size() == 0) {
			return JsonResponse2.success("根据条件没有查询到数据").put("debt_amount_list", mapList);
		}
		for (TabUsrinf2Model tempModel : list) {
			String orderSn = tempModel.getOrder_sn();
			JSONObject obj = getCreditUserBorrowInfo(orderSn);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("borrow_uid", tempModel.getUsrid());
			map.put("borrow_name",
					tempModel.getBorrower_usrname() == null ? tempModel.getUsrname() : tempModel.getBorrower_usrname());
			map.put("mobile_phone", tempModel.getMobile_phone());
			map.put("store_uid", tempModel.getStore_uid());
			map.put("order_sn", tempModel.getOrder_sn());
			map.put("store_name", tempModel.getStore_name());
			map.put("store_contract", tempModel.getStore_contract());
			// 营收统计
			map.put("store_charge",
					(tempModel.getOrder_money() == null ? new BigDecimal(0) : tempModel.getOrder_money())
							.multiply(tempModel.getStore_charge_rate() == null ? new BigDecimal(0)
									: tempModel.getStore_charge_rate())
							.multiply(new BigDecimal(0.01)).setScale(2, BigDecimal.ROUND_HALF_UP));
			map.put("store_tel", tempModel.getStore_tel());
			map.put("total", obj == null ? "" : obj.getString("total"));
			map.put("fee_total", obj == null ? "" : obj.getString("fee_total"));
			map.put("borrow_id_url", obj == null ? "" : obj.getString("borrow_id_url"));
			map.put("second_verify_time", obj == null ? "" : obj.getString("second_verify_time"));
			map.put("borrow_id", obj == null ? "" : obj.getString("borrow_id"));
			map.put("each_repayment_mount", obj == null ? "" : obj.getString("each_repayment_mount"));
			map.put("borrow_money", obj == null ? "" : obj.getString("borrow_money"));
			map.put("borrow_interest", obj == null ? "" : obj.getString("borrow_interest"));
			map.put("pending_repayment_money", obj == null ? "" : obj.getString("pending_repayment_money"));
			map.put("repayment_money", obj == null ? "" : obj.getString("repayment_money"));
			mapList.add(map);
		}
		// 总条数
		int record_total = tabUsrinf2Service.selectUserWithOrderTableCount(model);
		// 总页数
		int page_total = record_total / page_number;
		if (record_total % page_number != 0) {
			page_total++;
		}
		return JsonResponse2.success().put("debt_amount_list", mapList).put("page_total", page_total)
				.put("record_total", record_total);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 调用链金所获取借款总金额以及最近7天要还金额
	 * @param usrid
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getUsrDebtAmount(Long usrid, Map<String, Object> map) {
		// 为统一格式，如果没查询到信息则统一返回空字符串
		map.put("borrow_amount", 0.00);
		map.put("refund_amount_7", 0.00);
		map.put("shouldreturn_amount_1", 0.00);
		Map<String, String> params = new HashMap<String, String>();
		params.put("usrid", usrid.toString());
		log.info("getUsrDebtAmount request usrid=" + usrid);
		String result = HttpRequestUtil.sendGet(getUsrDebtAmountUrl, Tools.createLinkString(params, false));
		log.info("getUsrDebtAmount result--" + result);
		if (StringUtil.isEmpty(result)) {
			log.error("调用链金所获取借款总金额失败，usrid=" + usrid);
			return map;
		}
		JSONObject jsonObj = JSONObject.parseObject(result);
		if (WebServiceConstant.CODE_SUCCESS == jsonObj.getIntValue("code")) {
			map.put("borrow_amount", jsonObj.getJSONObject("return_param").getBigDecimal("debt_amount").setScale(2,
					BigDecimal.ROUND_HALF_UP));
			map.put("refund_amount_7", jsonObj.getJSONObject("return_param").getBigDecimal("refund_amount_7")
					.setScale(2, BigDecimal.ROUND_HALF_UP));
			map.put("shouldreturn_amount_1", jsonObj.getJSONObject("return_param")
					.getBigDecimal("shouldreturn_amount_1").setScale(2, BigDecimal.ROUND_HALF_UP));
		} else {
			log.error("调用链金所获取借款总金额失败，usrid=" + usrid + ",原因：" + jsonObj.getString("msg"));
		}
		return map;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月13日
	 * @description 查询用户绑卡信息
	 * @return
	 */
	public Map<String, Object> getUsrBankInfo(Long usrid, Map<String, Object> map) {
		// 为统一格式，如果没查询到信息则统一返回空字符串
		map.put("card_name", "");
		map.put("card_no", "");
		String result = HttpRequestUtil.sendPost(isBindBankCard, "usrid=" + usrid.toString());
		if (StringUtils.isEmpty(result)) {
			log.error("根据usrid=" + usrid + "查询用户帮卡信息失败");
			return map;
		}
		JSONObject resultObj = JSONObject.parseObject(result);
		if (resultObj.getIntValue("code") == 0) {
			map.put("card_name", resultObj.getString("card_name"));
			map.put("card_no", resultObj.getString("card_no"));
			return map;
		}
		log.error("根据usrid=" + usrid + "查询用户帮卡信息失败,原因：" + resultObj.getString("msg"));
		return map;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description 根据订单号查询标的信息
	 * @param order_sn
	 * @return
	 */
	public JSONObject getCreditUserBorrowInfo(String order_sn) {

		String params = "order_sn=" + order_sn;
		String result = HttpRequestUtil.sendGet(getCreditUserBorrowInfo, params);
		if (StringUtils.isEmpty(result)) {
			return null;
		}
		JSONObject obj = JSONObject.parseObject(result);
		if (WebServiceConstant.CODE_SUCCESS == obj.getIntValue("code")) {
			return obj.getJSONObject("return_param");
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月5日
	 * @description 设置为借款人
	 * @param usrid
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

	/**
	 * @author wang_xiao_long
	 * @data 2016年10月11日
	 * @description 调用小视身份证号、名字、图像比对接口
	 */
	private String callIdNameFaceInterface(String name, String idCard, String image) {
		String xiao_shi_id_name_face_url = URLUtils.get("xiao_shi_id_name_face_url");
		String postStr = getidNameFaceCheckParas(name, idCard, image);
		String result = HttpsClientUtil.doPost(xiao_shi_id_name_face_url, postStr, "utf-8");
		log.info("xiao_shi_id_name_face_url result:" + xiao_shi_id_name_face_url);
		return result;
	}

	/**
	 * 生成人脸三维认证的参数
	 * 
	 * @param name
	 * @param idCard
	 * @param image
	 * @return
	 */
	public static String getidNameFaceCheckParas(String name, String idCard, String image) {
		JsonObject totalJsonObj = new JsonObject();
		totalJsonObj.addProperty("loginName", URLUtils.get("xiao_shi_account"));
		totalJsonObj.addProperty("pwd", URLUtils.get("xiao_shi_password"));
		totalJsonObj.addProperty("serviceName", URLUtils.get("xiao_shi_face_service_name"));
		JsonObject paramJsonObj = new JsonObject();
		paramJsonObj.addProperty("idCard", idCard);
		paramJsonObj.addProperty("name", name);
		paramJsonObj.addProperty("image", image);
		totalJsonObj.add("param", paramJsonObj);
		log.info("idCard:" + idCard + ",name:" + name + ",image:" + image.substring(0, 100));
		return totalJsonObj.toString();
	}

	private void taskToUpdateLoan(int delay, final Long usrid, final Integer is_loan) {
		ScheduledExecutorServiceTask.scheduledThreadPool.schedule(new Runnable() {

			public void run() {
				TabUsrinf2 tabUsrinf = new TabUsrinf2();
				tabUsrinf.setUsrid(usrid);
				tabUsrinf.setIs_loan(is_loan.byteValue());
				tabUsrinf.setFreeze_remark("额度有效期过期");
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
				log.info(usrid + "用户的额度有效期已经过期, 10s后授信额度将被冻结");
			}
		}, delay, TimeUnit.SECONDS);
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean isNum(String str) {
		try {
			new BigDecimal(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @author frank_wang
	 * @data 2016年10月27日
	 * @description 与上一个方法重载，因为参数不同,重载原因是因为初期一些人程序设置不合理，然后本人又不想进行copyproperties.
	 * @param javaCheckFlag
	 * @param model
	 * @return
	 */
	private String transferCheckFlag(Byte javaCheckFlag, TabUsrinf2 model) {
		String phpFlag = null;
		if (WebServiceConstant.CHECK_FLAG_INITIAL.equals(javaCheckFlag)) {
			// 申请中
			phpFlag = "0";
		} else if (WebServiceConstant.CHECK_FLAG_FIRST_PASS.equals(javaCheckFlag)
				|| WebServiceConstant.CHECK_FLAG_SECOND_PASS.equals(javaCheckFlag)
				|| WebServiceConstant.CHECK_FLAG_TO_AUDIT.equals(javaCheckFlag)) {
			// 审批中
			phpFlag = "1";
		} else if (WebServiceConstant.CHECK_FLAG_FINAL_NOT_PASS.equals(javaCheckFlag)
				|| WebServiceConstant.CHECK_FLAG_SECOND_NOT_PASS.equals(javaCheckFlag)
				|| WebServiceConstant.CHECK_FLAG_FIRST_NOT_PASS.equals(javaCheckFlag)) {
			// 审批不通过
			phpFlag = "2";
		} else if (WebServiceConstant.IS_ACTIVATE_FALSE.equals(model.getIs_activate())) {
			// 未激活
			phpFlag = "3";
		} else if (WebServiceConstant.IS_ACTIVATE_TRUE.equals(model.getIs_activate())
				&& WebServiceConstant.IS_LOAN_TRUE.equals(model.getIs_loan())) {
			// 正常
			phpFlag = "4";
		}
		if (WebServiceConstant.CHECK_FLAG_FINAL_PASS.equals(javaCheckFlag)) {
			if (WebServiceConstant.IS_LOAN_FALSE.equals(model.getIs_loan())) {
				// 冻结
				phpFlag = "5";
			}
		}
		return phpFlag;
	}
	
	
	
	public void get_exchang_contract(String order_sn,HttpServletRequest request)
	{
		String path = request.getSession().getServletContext().getRealPath("/") + "files/TSFQG.html";
		
		//设置页面数据
		Map<String,Object> result = new HashMap<String,Object>();
		try
		{
	    	SimpleDateFormat ft=new SimpleDateFormat("yyyy年MM月dd日");
	    	Map<String,Object> params = new HashMap<String,Object>();
	    	//取订单信息
			TabUsrOrder tabUsrOrder = tabUsrOrderService.queryOrderByOrderNo(order_sn);
			TabUsrOrder up_tabUsrOrder = tabUsrOrderService.queryOrderByOrderNo(order_sn);
			tabUsrOrder.setOrder_sn("HT-" + tabUsrOrder.getOrder_sn());
			//打码
			tabUsrOrder.setBorrower_id_card(ToHtmlUtils.strReplaceMethod(tabUsrOrder.getBorrower_id_card()));
			tabUsrOrder.setStorer_id_card("*******");
			tabUsrOrder.setBorrower_mobile_phone(ToHtmlUtils.strReplaceMethod(tabUsrOrder.getBorrower_mobile_phone()));
			tabUsrOrder.setStore_tel(ToHtmlUtils.strReplaceMethod(tabUsrOrder.getStore_tel()));
			
			
			Document doc = Jsoup.parse(new File(path), "UTF-8");
			Element show_pic = doc.getElementById("show_pic");
			//产品照片
			List<String> tempPics = orderService.getPicAdd(tabUsrOrder.getUsr_order_id().intValue());
			if (CollectionUtils.isNotEmpty(tempPics))
			{
				for (int i=0 ; i < tempPics.size() ; i++ )
				{
					String pic_addr = tempPics.get(0);//获取第一张图片
					show_pic.attr("src",  URLUtils.get("picServerIp") + pic_addr);
					show_pic.attr("style","cursor: pointer;width:180px; height:145px;padding: 10px;display:block");
				}
			}
			params.put("pic_addr", show_pic);
			//借款人联系人
			List<TabOrderBondsmaninf> bondsmaninfList = tabOrderBondsmaninfService.selectByUserOrderId(tabUsrOrder.getUsr_order_id());
			if ( CollectionUtils.isNotEmpty(bondsmaninfList))
			{
				for (int i=0 ; i < bondsmaninfList.size() ; i++ )
				{
					TabOrderBondsmaninf bondsmaninf1= bondsmaninfList.get(0);//联系人1
					params.put("bondsmaninf1", bondsmaninf1);
					if (i == 1)
					{
						TabOrderBondsmaninf bondsmaninf2= bondsmaninfList.get(1);//联系人2
						params.put("bondsmaninf2", bondsmaninf2);
						break;
					}	
					
				}
			}
			String fileName = tabUsrOrder.getOrder_sn() + "_Constract.html";
			
			params.put("fileName", fileName);//用于合同唯一标识
			params.put("date", ft.format(new Date()));
			params.put("order", tabUsrOrder);
			params.put("cn_money", NumberToCN.number2CNMontrayUnit(tabUsrOrder.getOrder_money()));//大写金额
			//计划金额,本金,计划利息 均乘以 期数
			BigDecimal borrow_interest = new BigDecimal(0);
			//1：等额本金时，利息为0
			if ( 1 == tabUsrOrder.getInterest_type())
			{
				borrow_interest = new BigDecimal(0);
			}
			else
			{
				borrow_interest = tabUsrOrder.getBorrow_interest();
			}	
			params.put("total_money", (borrow_interest.add(tabUsrOrder.getOrder_money()).add(tabUsrOrder.getFee().multiply(new BigDecimal(tabUsrOrder.getAmortization_cnt())))) );//计划金额
			params.put("each_amount", (tabUsrOrder.getOrder_money() ));//本金
			params.put("borrow_interest",borrow_interest );//利息
			params.put("close_date","以实际借款日期为准" );//截止日
			
			ToHtmlUtils util = new ToHtmlUtils();
			util.viewContract(params, request);
			
			
			String borrowed_contract = URLUtils.get("picStr") + "/contract/" + fileName;// 写入数据库并在前台展示的虚拟路径
			up_tabUsrOrder.setBorrowed_contract(borrowed_contract);
			tabUsrOrderService.updateByOrderSnSelective(up_tabUsrOrder, up_tabUsrOrder.getOrder_sn());
			
			result.put("code", "1");
			result.put("msg","html合同生成成功");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result.put("code", "-1");
			result.put("msg", e.getMessage());
		}
	}
}
