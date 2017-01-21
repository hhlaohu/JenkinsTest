package com.yiya.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yiya.annotation.Auth;
import com.yiya.aop.Key;
import com.yiya.bean.BaseBean.DELETED;
import com.yiya.bean.BaseBean.STATE;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.SysMenu;
import com.yiya.bean.SysMenuBtn;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TreeNode;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.SiteMainModel;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.service.ScheduledExecutorServiceTask;
import com.yiya.service.SendMessage;
import com.yiya.service.SysMenuBtnService;
import com.yiya.service.SysMenuService;
import com.yiya.service.SysRoleRelService;
import com.yiya.service.SysUserService;
import com.yiya.service.TabUsrOrderService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.Constant.SuperAdmin;
import com.yiya.utils.DateUtil;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.MethodUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.Tools;
import com.yiya.utils.TreeUtil;
import com.yiya.utils.URLUtils;

@Controller
public class MainAction extends BaseAction implements InitializingBean {

	private final static Logger log = Logger.getLogger(MainAction.class);

	// Servrice start
	@Autowired(required = false)
	private SysMenuService sysMenuService;

	@Autowired(required = false)
	private SysUserService sysUserService;

	@Autowired(required = false)
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	@Autowired
	private TabUsrinf2Service tabUsrinf2Service;

	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	@Autowired
	private TabUsrOrderService tabUsrOrderService;

	@Autowired
	private SendMessage sendMessage;

	@Value("${getBiddingList}")
	private String getBiddingListUrl;

	@Value("${project_name}")
	private String project_name;

	@Value("${afterThreeHoursToCustomer}")
	private String afterThreeHoursToCustomer;
	
	@Value("${runTimeEnvironment}")
	private String runTimeEnvironment;

	/**
	 * index.jsp 跳转到 login.shtml
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("login", context);
	}

	/**
	 * 登录页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("login", context);
	}

	/**
	 * 登录
	 * 
	 * @param usr_name
	 *            登录账号
	 * @param usr_pass
	 *            密码
	 * @param verifyCode
	 *            验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/toLogin")
	@Key(operation = "用户登录", param = "toLogin")
	public void toLogin(String usr_name, String usr_pass, String verifyCode, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String vcode = SessionUtils.getValidateCode(request);
		SessionUtils.removeValidateCode(request);// 清除验证码，确保验证码只能用一次
		if (StringUtils.isBlank(verifyCode)) {
			sendFailureMessage(response, "验证码不能为空.");
			return;
		}
		// 判断验证码是否正确
		if (!verifyCode.toLowerCase().equals(vcode)) {
			sendFailureMessage(response, "验证码输入错误.");
			return;
		}
		String login_ip = request.getRemoteAddr();
		if (StringUtils.isBlank(usr_name)) {
			sendFailureMessage(response, "账号不能为空.");
			return;
		}
		if (StringUtils.isBlank(usr_pass)) {
			sendFailureMessage(response, "密码不能为空.");
			return;
		}
		String msg = "用户登录日志:";
		SysUser user = sysUserService.queryLogin(usr_name, MethodUtil.MD5(usr_pass));
		if (user == null) {
			// 记录错误登录日志
			log.debug(msg + "[" + usr_name + "]" + "账号或者密码输入错误.");
			sendFailureMessage(response, "账号或者密码输入错误.");
			return;
		}
		if (STATE.DISABLE.key == user.getState()) {
			sendFailureMessage(response, "账号已被禁用.");
			return;
		}
		// 登录次数加1 修改登录时间
		int loginCount = 0;
		if (user.getLoginCount() != null) {
			loginCount = user.getLoginCount();
		}
		user.setLoginCount(loginCount + 1);
		user.setLoginTime(DateUtil.getDateByString(""));
		user.setLogin_ip(login_ip);
		sysUserService.update(user);
		// 设置User到Session
		SessionUtils.setUser(request, user);
		SysUser user2 = SessionUtils.getUser(request);
		// 记录成功登录日志
		log.debug(msg + "[" + usr_name + "]" + "登录成功");
		sendSuccessMessage(response, "登录成功.");
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/logout")
	@Key(operation = "用户退出登录", param = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SessionUtils.removeUser(request);
		response.sendRedirect(URLUtils.get("msUrl") + "/login.shtml");
	}

	/**
	 * 获取Action下的按钮
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/getActionBtn")
	public void getActionBtn(String url, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> actionTypes = new ArrayList<String>();
		// 判断是否超级管理员
		if (SessionUtils.isAdmin(request)) {
			result.put("allType", true);
		} else {
			String menuUrl = URLUtils.getReqUri(url);
			menuUrl = StringUtils.remove(menuUrl, request.getContextPath());
			// 获取权限按钮
			actionTypes = SessionUtils.getMemuBtnListVal(request, StringUtils.trim(menuUrl));
			result.put("allType", false);
			result.put("types", actionTypes);
		}
		result.put(SUCCESS, true);
		HtmlUtil.writerJson(response, result);
	}

	/**
	 * 修改密码
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/modifyPwd")
	@Key(operation = "用户修改密码", param = "modifyPwd")
	public void modifyPwd(String oldPwd, String newPwd, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SysUser user = SessionUtils.getUser(request);
		if (user == null) {
			sendFailureMessage(response, "对不起,登录超时.");
			return;
		}
		SysUser bean = sysUserService.queryById(user.getId());
		if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
			sendFailureMessage(response, "对不起,用户不存在.");
			return;
		}
		if (StringUtils.isBlank(newPwd)) {
			sendFailureMessage(response, "密码不能为空.");
			return;
		}
		// 不是超级管理员，匹配旧密码
		if (!MethodUtil.ecompareMD5(oldPwd, bean.getUsr_pass())) {
			sendFailureMessage(response, "旧密码输入不匹配.");
			return;
		}
		bean.setUsr_pass(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "保存成功.");
	}

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/main")
	public ModelAndView main(SiteMainModel model, HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser user = SessionUtils.getUser(request);
		List<SysMenu> rootMenus = null;
		List<SysMenu> childMenus = null;
		List<SysMenuBtn> childBtns = null;
		// 超级管理员
		if (user != null && SuperAdmin.YES.key == user.getSuperAdmin()) {
			rootMenus = sysMenuService.getRootMenu(null);// 查询所有根节点
			childMenus = sysMenuService.getChildMenu();// 查询所有子节点
		} else {
			rootMenus = sysMenuService.getRootMenuByUser(user.getId());// 根节点
			childMenus = sysMenuService.getChildMenuByUser(user.getId());// 子节点
			childBtns = sysMenuBtnService.getMenuBtnByUser(user.getId());// 按钮操作
			buildData(childMenus, childBtns, request); // 构建必要的数据
		}
		context.put("user", user);
		context.put("menuList", treeMenu(rootMenus, childMenus));
		context.put("project_name", project_name);

		return forword("main/main", context);
	}

	/**
	 * @author wang_xiao_long
	 * @data 2016年8月26日
	 * @description 检查是否有审核事项
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCheckToDo")
	@ResponseBody
	public JsonResponse getCheckToDo(HttpServletRequest request) throws Exception {

		try {
			// 判断用户是否有额度审批权限
			boolean isLimitAuth = false;

			boolean isLimitFirstAuth = false;
			boolean isLimitSecondAuth = false;
			boolean isLimitFinalAuth = false;

			int limitToCheckNum = 0;
			// 判断用户是否有借款审核权限
			boolean isBorrowAuth = false;
			int borrowCheckTodoNum = 0;

			SysUser sysUser = SessionUtils.getUser(request);
			if (sysUser != null) {
				List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(),
						WebServiceConstant.RELATION_SYS_ROLE); // 根据用户id查找角色和权限
				for (SysRoleRel sysRoleRel : SysRoleRelList) {
					Integer roleId = sysRoleRel.getRoleId();
					List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId,
							WebServiceConstant.RELATION_SYS_BTN); // 根据用户角色查找是否有审核权限
					for (SysRoleRel buttonRels : buttonRelsList) {

						if (WebServiceConstant.FIRST_VERIFY_BUTTON_ID.equals(buttonRels.getObjId())) {
							isLimitFirstAuth = true;
						}
						if (WebServiceConstant.SECOND_VERIFY_BUTTON_ID.equals(buttonRels.getObjId())) {
							isLimitSecondAuth = true;
						}
						if (WebServiceConstant.FINAL_VERIFY_BUTTON_ID.equals(buttonRels.getObjId())) {
							isLimitFinalAuth = true;
						}

						if (WebServiceConstant.BORROW_CHECK_BUTTON_ID.equals(buttonRels.getObjId())) {
							isBorrowAuth = true;
						}
						if (isLimitAuth && isBorrowAuth) {
							break;
						}
					}
				}
				if (isLimitFirstAuth) {
					// 找出额度待初审的事项【查询本地用户信息表】
					TabUsrinf2Model usrInfModel = new TabUsrinf2Model();
					usrInfModel.setCheck_flag(WebServiceConstant.CHECK_FLAG_TO_AUDIT.byteValue());
					limitToCheckNum = tabUsrinf2Service.queryByCount(usrInfModel);
				}

				if (isLimitSecondAuth) {
					// 找出额度待复审的事项【查询本地用户信息表】
					TabUsrinf2Model usrInfModel = new TabUsrinf2Model();
					usrInfModel.setCheck_flag(WebServiceConstant.CHECK_FLAG_FIRST_PASS.byteValue());
					limitToCheckNum += tabUsrinf2Service.queryByCount(usrInfModel);
				}

				if (isLimitFinalAuth) {
					// 找出额度待复审的事项【查询本地用户信息表】
					TabUsrinf2Model usrInfModel = new TabUsrinf2Model();
					usrInfModel.setCheck_flag(WebServiceConstant.CHECK_FLAG_SECOND_PASS.byteValue());
					limitToCheckNum += tabUsrinf2Service.queryByCount(usrInfModel);
				}

				if (isBorrowAuth) {
					// 找出是否有标的待审核事项
					Map<String, String> borrowParams = new HashMap<String, String>();
					borrowParams.put("borrow_status", WebServiceConstant.BORROW_STATUS_CHECK_TODO.toString());
					log.info("getBiddingList接口请求参数为" + borrowParams.toString());
					// 调用接口
					log.info("getBiddingListUrl:" + getBiddingListUrl);
					String data = HttpRequestUtil.sendPost(getBiddingListUrl,
							Tools.createLinkString(borrowParams, false));
					log.info("getBiddingList返回结果" + data);
					JSONObject paramObject = JSONObject.parseObject(data);
					JSONObject returnParamObject = paramObject.getJSONObject("return_param");
					if (returnParamObject != null) {
						borrowCheckTodoNum = returnParamObject.getInteger("record_total");
					}
				}
				return JsonResponse.success().put("limitToCheckNum", limitToCheckNum).put("borrowCheckTodoNum",
						borrowCheckTodoNum);
			} else {
				return JsonResponse.success().put("limitToCheckNum", 0).put("borrowCheckTodoNum", 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail(e.getMessage());
		}
	}

	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private List<TreeNode> treeMenu(List<SysMenu> rootMenus, List<SysMenu> childMenus) {
		TreeUtil util = new TreeUtil(rootMenus, childMenus);
		return util.getTreeNode();
	}

	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private void buildData(List<SysMenu> childMenus, List<SysMenuBtn> childBtns, HttpServletRequest request) {
		// 能够访问的url列表
		List<String> accessUrls = new ArrayList<String>();
		// 菜单对应的按钮
		Map<String, List> menuBtnMap = new HashMap<String, List>();
		for (SysMenu menu : childMenus) {
			// 判断URL是否为空
			if (StringUtils.isNotBlank(menu.getUrl())) {
				List<String> btnTypes = new ArrayList<String>();
				for (SysMenuBtn btn : childBtns) {
					if (menu.getId().equals(btn.getMenuid())) {
						btnTypes.add(btn.getBtnType());
						URLUtils.getBtnAccessUrls(menu.getUrl(), btn.getActionUrls(), accessUrls);
					}
				}
				menuBtnMap.put(menu.getUrl(), btnTypes);
				URLUtils.getBtnAccessUrls(menu.getUrl(), menu.getActions(), accessUrls);
				accessUrls.add(menu.getUrl());
			}
		}
		SessionUtils.setAccessUrl(request, accessUrls);// 设置可访问的URL
		SessionUtils.setMemuBtnMap(request, menuBtnMap); // 设置可用的按钮
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		new Thread(new Runnable() {
			@Override
			public void run() {
				List<TabUsrOrder> tabUsrOrderList = tabUsrOrderService
						.queryByOrderStatus(WebServiceConstant.ORDER_STATUS_INFO_SUBMIT);
				if (tabUsrOrderList != null) {
					for (TabUsrOrder order : tabUsrOrderList) {
						if (order.getCreate_time() != null) {
							Long createTime = order.getCreate_time().getTime();
							Long substract = System.currentTimeMillis() - createTime;
							// 转换为小时
							Long hour = substract / 1000 / 60 / 60;
							final String mobilePhone = order.getMobile_phone();
							final Long usrOrderId = order.getUsr_order_id();
							if (hour >= 24) {
								order.setOrder_status(WebServiceConstant.ORDER_STATUS_NOT_VALID);
								tabUsrOrderService.updateByPrimaryKeySelective(order);
							} else {
								// 创建订单3小时后如果订单还在提交中，则提醒客户尽快提交
								if(WebServiceConstant.RUNTIME_ENVIRONMENT.equals(runTimeEnvironment)){
									if(createTime+3*60*60*1000-System.currentTimeMillis() > 0){
										ScheduledExecutorServiceTask.scheduledThreadPool.schedule(new Runnable() {
											public void run() {
												sendMessage.sendGroupSmsToClient(afterThreeHoursToCustomer,
														mobilePhone,
														WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
											}
										}, createTime+3*60*60*1000-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
									}	
								}
								
								// 创建订单24小时后如果订单还是在提交中，则置订单状态为无效
								ScheduledExecutorServiceTask.scheduledThreadPool.schedule(new Runnable() {
									public void run() {
										TabUsrOrder updateOrder = new TabUsrOrder(usrOrderId,WebServiceConstant.ORDER_STATUS_NOT_VALID);
										tabUsrOrderService.updateByPrimaryKeySelective(updateOrder);
									}
								}, createTime+24*60*60*1000-System.currentTimeMillis(), TimeUnit.MILLISECONDS);

							}

						}

					}
				}
			}
		}).start();
	}

}
