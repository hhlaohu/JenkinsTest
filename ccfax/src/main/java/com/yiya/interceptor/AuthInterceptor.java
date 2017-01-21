package com.yiya.interceptor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yiya.action.BaseAction;
import com.yiya.annotation.Auth;
import com.yiya.aop.RequestContext;
import com.yiya.bean.AlertConfig;
import com.yiya.bean.AlertDaily;
import com.yiya.bean.PzGood;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabCustomer;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabStockComment;
import com.yiya.service.AlertConfigService;
import com.yiya.service.AlertDailyService;
import com.yiya.service.PzGoodService;
import com.yiya.service.SysUserService;
import com.yiya.service.TabCustomerService;
import com.yiya.service.TabStockCommentService;
import com.yiya.service.TabStockService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * 权限拦截器
 * @author lu
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	private final static Logger log= Logger.getLogger(AuthInterceptor.class);
	private final static HashSet<String> ignoreAuthSet = new HashSet<String>();
	
	// Servrice start
	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private TabCustomerService<TabCustomer> tabcustomerservice;

	@Autowired(required = false)
	private TabStockService<TabStock> tabStockService;

	@Autowired(required = false)
	private TabStockCommentService<TabStockComment> tabStockCommentService;

	@Autowired(required = false)
	private AlertConfigService<AlertConfig> alertConfigService;

	@Autowired(required = false)
	private AlertDailyService<AlertDaily> alertDailyService;

	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService sysUserService;

	@Autowired
	private PzGoodService<PzGood> pzGoodService;
	
	static{
		// 加载不需要权限判断的路径配置
		ResourceLoader loader = new DefaultResourceLoader();
		Resource resource = loader.getResource("classpath:ignoreAuthUrl.properties");
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			Enumeration<Object> enu = properties.elements();
	        while (enu.hasMoreElements()) {  
	            String value = (String)enu.nextElement();
	            ignoreAuthSet.add(value);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method = (HandlerMethod)handler;
		Auth  auth = method.getMethod().getAnnotation(Auth.class);
		////验证登陆超时问题  auth = null，默认验证 
		String path = request.getServletPath();
		
		//此处过滤客户端请求的接口（待做特殊处理）
		if(path.endsWith(".do")){
			if(ignoreAuthSet.contains(path)){
				return true;
			}
			return true;
		}
		if( auth == null || auth.verifyLogin()){
			String baseUri = request.getContextPath();
			SysUser user =SessionUtils.getUser(request);
			if(user  == null){
				if(path.endsWith(".shtml")){
					response.setStatus(response.SC_GATEWAY_TIMEOUT);
					response.sendRedirect(baseUri+"/login.shtml");
					return false;
				}else{
					response.setStatus(response.SC_GATEWAY_TIMEOUT);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.LOGOUT_FLAG, true);//登录标记 true 退出
					result.put(BaseAction.MSG, "登录超时.");
					HtmlUtil.writerJson(response, result);
					return false;
				}
			}
		}
		//验证URL权限
		if(auth == null || auth.verifyURL()){		
			//判断是否超级管理员
		/*	if(!SessionUtils.isAdmin(request)){
				String menuUrl = StringUtils.remove( request.getRequestURI(),request.getContextPath());;
				if(!SessionUtils.isAccessUrl(request, StringUtils.trim(menuUrl))){					
					//日志记录
					String usr_name = SessionUtils.getUser(request).getUsr_name();
					String msg ="URL权限验证不通过:[url="+menuUrl+"][usr_name ="+ usr_name+"]" ;
					log.error(msg);
					
					response.setStatus(response.SC_FORBIDDEN);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.MSG, "没有权限访问,请联系管理员.");
					HtmlUtil.writerJson(response, result);
					return false;
				}
			}*/
		}

	try{
		RequestContext.begin(request,response);
	//开始初始化RequestContext，这样要就初始化了RequestContext了，那么RequestContext里面的request，和session都有值了，获取的时候就只要
	   RequestContext.get().session();
	   
	   
		//同步仓库系统数据
//	   log.info("开始同步仓库系统客户和库存数据...");
//	   System.out.println("开始同步仓库系统客户和库存数据...");
//		try {
//			WebServicesAction action = new WebServicesAction();
//			action.getInterFaceCustomerList(request);// 调用接口更新风控本地客户信息
//			action.getInterFaceStockList(Integer.valueOf(customer_id), request);// 调用接口更新风控本地库存信息
//			action.getChainGold(request); // 调用接口获取风控本地客户的借款金额
//		} catch (Exception e) {
//			log.error("同步仓库系统数据出错！"+e.getMessage());
//			e.printStackTrace();
//		}
//		log.info("同步仓库系统客户和库存数据结束...");

	}
	finally{
//		RequestContext.end();//不管怎么样都要释放RequestContext里面的资源，避免内存消耗}
	}


		return super.preHandle(request, response, handler);
	}

	
}
