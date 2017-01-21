package com.yiya.action;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.aop.Key;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabApplyLog;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabChangeLog;
import com.yiya.bean.TabCheckLog;
import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrDecorationOrder;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf;
import com.yiya.bean.TabUsrinf2;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.TabApplyLogModel;
import com.yiya.model.TabBondsmaninfModel;
import com.yiya.model.TabCheckLogModel;
import com.yiya.model.TabUsrDecorationOrderModel;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.service.SendMessage;
import com.yiya.service.SysRoleRelService;
import com.yiya.service.SysUserService;
import com.yiya.service.TabApplyLogService;
import com.yiya.service.TabBondsmaninfService;
import com.yiya.service.TabChangeLogService;
import com.yiya.service.TabCheckLogService;
import com.yiya.service.TabUsrComplementPicService;
import com.yiya.service.TabUsrDecorationContractPicService;
import com.yiya.service.TabUsrDecorationOrderService;
import com.yiya.service.TabUsrPremisePermitPicService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;
import com.yiya.utils.URLUtils;

@Controller
@RequestMapping("/creditCheck")
public class CreditCheckAction extends BaseAction {

	private final static Logger log = Logger.getLogger(CreditCheckAction.class);

	@Autowired(required = false)
	private TabUsrinf2Service tabUsrinf2Service;
	@Autowired(required = false)
	private TabApplyLogService tabApplyLogService;
	@Autowired(required = false)
	private TabCheckLogService tabCheckLogService;
	@Autowired(required = false)
	private TabUsrComplementPicService tabUsrComplementPicService;
	@Autowired(required = false)
	private TabBondsmaninfService tabBondsmaninfService;
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	@Autowired(required = false)
	private TabChangeLogService tabChangeLogService;
	@Autowired(required = false)
	private TabUsrDecorationContractPicService tabUsrDecorationContractPicService;
	@Autowired(required = false)
	private TabUsrPremisePermitPicService tabUsrPremisePermitPicService;
	@Autowired
	private TabUsrDecorationOrderService<TabUsrDecorationOrder> tabUsrDecorationOrderService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SendMessage sendMessage;
	
	@Value("${sendToSecondVerifyContent}")
	private String sendToSecondVerifyContent;
	
	@Value("${sendToFinalVerifyContent}")
	private String sendToFinalVerifyContent;
	
	@Value("${sendToFirstVerifyContent}")
	private String sendToFirstVerifyContent;
	
	@Value("${sendToCustomerWhenCheckPassed}")
	private String sendToCustomerWhenCheckPassed;
	
	@Value("${sendToCustomerWhenCheckNotPassed}")
	private String sendToCustomerWhenCheckNotPassed;
	

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(TabUsrinf model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		return forword("limitManager/creditCheck", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(TabUsrinf2Model model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		SysUser sysUser = SessionUtils.getUser(request);
		List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
		for (SysRoleRel sysRoleRel : SysRoleRelList) {
			Integer roleId = sysRoleRel.getRoleId();
			List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
			for (SysRoleRel buttonRels : buttonRelsList) {
				if (buttonRels.getObjId() == 28) {
					model.setFirst_veriy_auth(true);
				}
				if (buttonRels.getObjId() == 34) {
					model.setSecond_veriy_auth(true);
				}
				if (buttonRels.getObjId() == WebServiceConstant.FINAL_VERIFY_BUTTON_ID.intValue()) {
					model.setFinal_veriy_auth(true);
				}
				if(WebServiceConstant.CREDI_INFO_OBJ_ID.equals(buttonRels.getObjId())){
					model.setCredit_info_veriy_auth(true);
				}
			}
		}
		Boolean first_veriy_auth = model.isFirst_veriy_auth();//初审
		Boolean second_veriy_auth = model.isSecond_veriy_auth();//复审
		Boolean final_veriy_auth = model.isFinal_veriy_auth();//终审
		Boolean credit_info_veriy_auth = model.isCredit_info_veriy_auth();//征信资料权限
		//过滤掉审核为初始状态的数据
		model.setIf_filter_check_flag_initial(true);
		List<TabUsrinf2Model> dataList = tabUsrinf2Service.queryByList(model);
		for (TabUsrinf2Model tabUsrinf : dataList) {
			tabUsrinf.setFirst_veriy_auth(first_veriy_auth);
			tabUsrinf.setSecond_veriy_auth(second_veriy_auth);
			tabUsrinf.setFinal_veriy_auth(final_veriy_auth);
			tabUsrinf.setCredit_info_veriy_auth(credit_info_veriy_auth);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 审核日志列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkLog_dataList")
	public void checkLog_dataList(TabCheckLogModel model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		List<TabCheckLog> dataList = tabCheckLogService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 申请记录列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/applyRecord_dataList")
	public void applyRecord_dataList(TabApplyLogModel model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		List<TabApplyLog> dataList = tabApplyLogService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 
	 * @param file
	 * @param uid上传的图片所属用户基本信息usrinf_id
	 * @param sequence上传图片排序
	 * @param order_sn乐装分期上传房产证和装修资料图片携带的订单号
	 * @param pic_flag乐装分期上传房产证和装修资料图片类型（1：房产证图片，2：装修图片）
	 * @param pic_type区分上传的图片是否打码（0：未打码，1：打码） 
	 * 说明： order_sn，pic_flag两个字段在资料处理上传的房产证和装修图片时配套使用
	 * @param request
	 * @param model
	 * @param response
	 */
	@RequestMapping(value = "/uploadFile")
	@Key(operation = "额度审核模块上传补充资料upload", param = "")
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file, Integer uid,Integer sequence,String order_sn,String pic_flag,
			Integer pic_type, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		log.info("风控后台资料处理模块开始上传图片！"+"uid:"+uid+",sequence:"+sequence+",order_sn:"+order_sn+",pic_flag:"+pic_flag+",pic_type"+pic_type);
		String upload_pic_dir = URLUtils.get("upload_pic");
		String path = upload_pic_dir;
		String fileName= UUID.randomUUID()+".jpg";
		log.info("图片路径：" + path);
		System.out.println(System.getProperties().getProperty("os.name").indexOf("nux"));
		if (System.getProperties().getProperty("os.name").indexOf("nux") != -1) {
			exec("cd / ");
			exec("sudo mkdir -p " + path);
			exec("chmod -R 777 " + path);
		}
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileUrl = path + "/" + fileName;
		System.out.println(fileUrl); // Linux服务器图片物理路径
		String com_pic_addr = URLUtils.get("picStr") + "/" + fileName;// 写入数据库并在前台展示的虚拟路径
		if(StringUtil.isEmpty(order_sn)&&StringUtil.isEmpty(pic_flag)){
			// 写入补充资料照片表
			TabUsrComplementPic tabUsrComplementPic = new TabUsrComplementPic();
			tabUsrComplementPic.setUsrinf_id(uid);
			tabUsrComplementPic.setCom_pic_addr(com_pic_addr);
			tabUsrComplementPic.setSequence(sequence);
			tabUsrComplementPic.setPic_type(pic_type);  //此处0，1类型都有可能上传
			if(null!=sequence){
				tabUsrComplementPic.setSequence(sequence);
			}
			tabUsrComplementPicService.add(tabUsrComplementPic);
			log.info("补充资料照片表持久化完成");
		}else {
			TabUsrDecorationOrderModel order_model = new TabUsrDecorationOrderModel();//装修房产订单
			order_model.setOrder_sn(order_sn);
			order_model.setUsrinf_id(uid);
			TabUsrDecorationOrder tabUsrDecorationOrder = tabUsrDecorationOrderService.queryTabUsrDecorationOrder(order_model);
			if(null!=tabUsrDecorationOrder&&null!=pic_flag){
				Integer decoration_order_id = tabUsrDecorationOrder.getDecoration_order_id();
				//写入房产资料照片表
				if(pic_flag.equals("1")){
					TabUsrPremisePermitPic house_pic = new TabUsrPremisePermitPic();
					house_pic.setDecoration_order_id(decoration_order_id);
					house_pic.setOrder_sn(order_sn);
					house_pic.setPic_type(1);
					house_pic.setPic_addr(com_pic_addr);
					house_pic.setSequence(sequence);
					tabUsrPremisePermitPicService.add(house_pic);
					log.info("房产资料照片表持久化完成");
				}
				//写入装修合同照片表
				if(pic_flag.equals("2")){
					TabUsrDecorationContractPic decoration_pic = new TabUsrDecorationContractPic();
					decoration_pic.setDecoration_order_id(decoration_order_id);
					decoration_pic.setOrder_sn(order_sn);
					decoration_pic.setPic_type(1);
					decoration_pic.setPic_addr(com_pic_addr);
					decoration_pic.setSequence(sequence);
					tabUsrDecorationContractPicService.add(decoration_pic);
					log.info("装修合同照片表持久化完成");
				}
			}
		}

		// 用户资料变更日志
		SysUser sysUser = SessionUtils.getUser(request);
		String real_name = sysUser.getReal_name();
		TabChangeLog tabChangeLog = tabChangeLogService.queryTabChangeLog(uid);
		TabChangeLog tcl = new TabChangeLog();
		if (tabChangeLog == null) {
			tcl.setUsrinf_id(uid);
			tcl.setCh_operate_time(new Date());
			tcl.setCh_operator(real_name);
			tcl.setCh_action("用户添加补充资料");
			tabChangeLogService.add(tcl);
		} else {
			tcl.setId(tabChangeLog.getId());
			tcl.setUsrinf_id(uid);
			tcl.setCh_operate_time(new Date());
			tcl.setCh_operator(real_name);
			tcl.setCh_action("用户更新补充资料");
			tabChangeLogService.update(tcl);
		}

		// 返回页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("fileUrl", fileUrl);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * 修改授信额度,审核日志表和申请记录表
	 * @param model
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/updateCheckLog")
	@Key(operation = "额度审核模块调用方法名updateCheckLog审核额度", param = "")
	public void updateCheckLog(TabCheckLog model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (null != model) {
			try {
				//修改用户基本信息表
				TabUsrinf2 tabUsrinf = new TabUsrinf2();
				Date date = new Date();
				SysUser sysUser = SessionUtils.getUser(request); // 获取当前处理人(审核人)
				tabUsrinf.setUsrinf_id(Long.valueOf(model.getUsrinf_id()));
				TabUsrinf2 userInfo = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(Long.valueOf(model.getUsrinf_id()));
				//退回初审状态实际上是待初审，但因为日志要展示，因此CHECK_RESULT增加一个状态，但是CHECK_FLAG不增加
				if(WebServiceConstant.CHECK_RESULT_BACK_TO_FIRST_PASS.equals(model.getCheck_result())){
					tabUsrinf.setCheck_flag(WebServiceConstant.CHECK_FLAG_TO_AUDIT.byteValue());
					//退回初审时，由于前台没有做处理，后台应该保证复审额度和日期都为空
					model.setSecond_check_loan_limit(null);
					model.setLimit_validity_time(null);
				}else if(WebServiceConstant.CHECK_RESULT_BACK_TO_SECOND__PASS.equals(model.getCheck_result())){
					//退回复审时，由于前台没有做处理，后台应该保证终审额度和日期都为空
					model.setLoan_limit(null);
					model.setLimit_validity_time(null);
					tabUsrinf.setCheck_flag(WebServiceConstant.CHECK_FLAG_FIRST_PASS.byteValue());
				}else{
					tabUsrinf.setCheck_flag(new Byte(model.getCheck_result()));					
				}
				
				//如果是初审通过
				if(WebServiceConstant.CHECK_RESULT_TO_SECOND_AUDIT.equals(model.getCheck_result())){
					if(date.getTime()>model.getLimit_validity_time().getTime()){
						jsonMap.put(MSG, 7);//额度有效期不能小于当前时间
						HtmlUtil.writerJson(response, jsonMap);
						return;
					}
					tabUsrinf.setApplyfor_limit(model.getApplyfor_limit());
					tabUsrinf.setLimit_validity_time(model.getLimit_validity_time());// 初审额度有效期
					tabUsrinf.setFirst_check_operator(sysUser.getReal_name());//额度初审操作人
					//初审通过后要给具有复审权限的人员发送短信
					StringBuffer buffer = new StringBuffer(sendToSecondVerifyContent);
                    sysUserService.sendMessageByButtonAuthority(buffer.insert(4, userInfo.getMobile_phone()).toString(),WebServiceConstant.SECOND_VERIFY_BUTTON_ID);
				}
				
				//如果是复审通过
				if(WebServiceConstant.CHECK_RESULT_SECOND_PASS.equals(model.getCheck_result())){
					BigDecimal applyfor_limit = userInfo.getApplyfor_limit(); 
					BigDecimal second_check_loan_limit = model.getSecond_check_loan_limit(); // 复审金额
					if (second_check_loan_limit != null) {
						if (second_check_loan_limit.compareTo(applyfor_limit) == 1) {
							jsonMap.put(MSG, 8);// 复审额度不能大于初审额度
							HtmlUtil.writerJson(response, jsonMap);
							return;
						}
					} else {
						jsonMap.put(MSG, 0);// loan_limit额度不能为空
						HtmlUtil.writerJson(response, jsonMap);
						return;
					}
					tabUsrinf.setSecond_check_loan_limit(second_check_loan_limit);
					tabUsrinf.setLimit_validity_time(model.getLimit_validity_time());// 复审额度有效期
					tabUsrinf.setSecond_check_operator(sysUser.getReal_name());
					//复审通过后要给具有终审权限的人员发送短信
					StringBuffer buffer = new StringBuffer(sendToFinalVerifyContent);
                    sysUserService.sendMessageByButtonAuthority(buffer.insert(4, userInfo.getMobile_phone()).toString(),WebServiceConstant.FINAL_VERIFY_BUTTON_ID);
				}
				
				//如果是终审通过
				if (WebServiceConstant.CHECK_RESULT_FINAL__PASS.equals(model.getCheck_result())) {
					BigDecimal applyfor_limit = userInfo.getSecond_check_loan_limit(); // 复审金额
					BigDecimal loan_limit = model.getLoan_limit(); // 贷款总额度
					if (loan_limit != null) {
						if (loan_limit.compareTo(applyfor_limit) == 1) {
							jsonMap.put(MSG, 8);// 终审额度不能大于复审额度
							HtmlUtil.writerJson(response, jsonMap);
							return;
						}
					} else {
						jsonMap.put(MSG, 0);// loan_limit额度不能为空
						HtmlUtil.writerJson(response, jsonMap);
						return;
					}
					tabUsrinf.setIs_loan(new Byte("1"));// 终审通过,额度能使用
					tabUsrinf.setLoan_limit(loan_limit);
					tabUsrinf.setLimit_validity_time(model.getLimit_validity_time());// 终审额度有效期
					tabUsrinf.setCredit_time(new Date());// 当终审通过时，设置授信时间
					tabUsrinf.setSecond_check_operator(sysUser.getReal_name());
					//终审通过时发送短信给客户
					sendMessage.sendGroupSmsToClient(sendToCustomerWhenCheckPassed, userInfo.getMobile_phone(),null);
				}
				
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);

				model.setOperate_time(new Date());
				model.setOperator(model.getUser_name()); // 审核操作人
				//终审不通过，由于前台没有做处理，后台应该保证终审额度和日期都为空
				if(WebServiceConstant.CHECK_RESULT_FINAL_NOT_PASS.equals(model.getCheck_result())){
					model.setLoan_limit(null);
					model.setLimit_validity_time(null);
				}
				
				tabCheckLogService.add(model);
				
				/** 退回初审 **/
				if (WebServiceConstant.CHECK_RESULT_BACK_TO_FIRST_PASS.equals(model.getCheck_result())) {
					//退回初审需要发送给具有初审权限的风控人员
                    StringBuffer buffer = new StringBuffer(sendToFirstVerifyContent);	
					sysUserService.sendMessageByButtonAuthority(buffer.insert(4, userInfo.getMobile_phone()).toString(),
							WebServiceConstant.FIRST_VERIFY_BUTTON_ID);
					jsonMap.put(MSG, 4);
					HtmlUtil.writerJson(response, jsonMap);
				}
				
				/** 初审不通过 **/
				if (WebServiceConstant.CHECK_RESULT_FIRST_NOT_PASS.equals(model.getCheck_result())) {
					//初审不通过发送短信给客户
					sendMessage.sendGroupSmsToClient(sendToCustomerWhenCheckNotPassed, userInfo.getMobile_phone(),null);
					jsonMap.put(MSG, 5);
					HtmlUtil.writerJson(response, jsonMap);
				}
				
				/**退回复审**/
				if (WebServiceConstant.CHECK_RESULT_BACK_TO_SECOND__PASS.equals(model.getCheck_result())) {
					//退回复审时给具有复审权限的风控人员发送短信
					StringBuffer buffer = new StringBuffer(sendToSecondVerifyContent);
					sysUserService.sendMessageByButtonAuthority(buffer.insert(4, userInfo.getMobile_phone()).toString(), 
							WebServiceConstant.SECOND_VERIFY_BUTTON_ID);
					jsonMap.put(MSG, 10);
					HtmlUtil.writerJson(response, jsonMap);
				}
				
				/** 复审不通过 **/
				if (WebServiceConstant.CHECK_RESULT_SECOND_NOT_PASS.equals(model.getCheck_result())) {
					//复审不通过发送短信给客户
					sendMessage.sendGroupSmsToClient(sendToCustomerWhenCheckNotPassed, userInfo.getMobile_phone(),null);
					jsonMap.put(MSG, 6);
					HtmlUtil.writerJson(response, jsonMap);
				}
				/** 终审不通过 **/
				if (WebServiceConstant.CHECK_FLAG_FINAL_NOT_PASS.equals(tabUsrinf.getCheck_flag())) {
					//终审不通过需要发送短信给客户
					sendMessage.sendGroupSmsToClient(sendToCustomerWhenCheckNotPassed, userInfo.getMobile_phone(),null);
					jsonMap.put(MSG, 9);
					HtmlUtil.writerJson(response, jsonMap);
				}
				
				//终审时才记录申请表
				if(WebServiceConstant.CHECK_RESULT_FINAL__PASS.equals(model.getCheck_result())
					||WebServiceConstant.CHECK_RESULT_FINAL_NOT_PASS.equals(model.getCheck_result())){
					// 写入和修改申请记录表
					TabApplyLog tabApplyLog = new TabApplyLog();
					tabApplyLog.setUsrinf_id(model.getUsrinf_id());
					tabApplyLog.setCheck_result(model.getCheck_result());
					tabApplyLog.setCheck_remark(model.getCheck_remark());
					tabApplyLog.setApplyfor_limit(model.getLoan_limit());
					tabApplyLog.setApply_time(date);
					tabApplyLogService.add(tabApplyLog);					
				}
			
				jsonMap.put(MSG, 3);
			} catch (Exception e) {
				log.error("审核失败！");
				jsonMap.put(MSG, 2);
				e.printStackTrace();
			}
		} else {
			log.error("获取审核情况失败！");
		}

		HtmlUtil.writerJson(response, jsonMap);
	}
	

	/**
	 * @author frank_wang
	 * @data 2016年10月24日
	 * @description 保存审核日志
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveCheckLog")
	@ResponseBody
	public JsonResponse saveCheckLog(TabCheckLog log,HttpServletRequest request) throws Exception {
		SysUser sysUser = SessionUtils.getUser(request); // 获取当前处理人(审核人)
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("usrinf_id", log.getUsrinf_id());
		if(WebServiceConstant.CHECK_RESULT_COMMENT.equals(log.getCheck_result())){
			TabCheckLog tabCheckLog = tabCheckLogService.queryLastCheckLog(condition);
			if(tabCheckLog != null){
				log.setApplyfor_limit(tabCheckLog.getApplyfor_limit());
				log.setSecond_check_loan_limit(tabCheckLog.getSecond_check_loan_limit());
				log.setLoan_limit(tabCheckLog.getLoan_limit());
			}
			log.setOperate_time(new Date());
			log.setOperator(sysUser.getReal_name());
			tabCheckLogService.add(log);
		}
		return JsonResponse.success();
	}
	
	/**
	 * 查询担保人基本信息(直系亲属信息)
	 */
	@RequestMapping("/findBondsmaninf")
	public ModelAndView findBondsmaninf(Integer usrinf_id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		TabBondsmaninfModel model = new TabBondsmaninfModel();
		model.setUsrinf_id(usrinf_id);
		List<TabBondsmaninf> tabBondsmaninf_List = tabBondsmaninfService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if (tabBondsmaninf_List.size() > 0) {
			jsonMap.put(SUCCESS, true);
			jsonMap.put("data", tabBondsmaninf_List);
			context.put("tabBondsmaninf_List", tabBondsmaninf_List);
		} else {
			jsonMap.put(MSG, "查询不到担保人基本信息");
			context.put("tabBondsmaninf_List", "");
		}
		// HtmlUtil.writerJson(response, jsonMap);
		return forword("limitManager/creditCheck", context);

	}
	
	/**
	 * @author frank_wang
	 * @data 2016年10月13日
	 * @description
	 * @param buttonId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSysUsersByButtonId")
	public void getSysUsersByButtonId(Integer buttonId,HttpServletResponse response) throws Exception{
		log.info("getSysUsersByButtonId param--buttonId:"+buttonId);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<SysUser> list = sysUserService.querySysUsersByButtonAuthority(buttonId,false);
		jsonMap.put("total", list.size());
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * 执行CMD命令
	 * 
	 * @param cmd
	 */
	private void exec(String cmd) {
		try {
			String[] command;
			if (System.getProperties().getProperty("os.name").indexOf("nux") != -1) {
				command = new String[] { "sh", "-c", cmd };
			} else {
				command = new String[] { "cmd", "/c", cmd };
			}
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
