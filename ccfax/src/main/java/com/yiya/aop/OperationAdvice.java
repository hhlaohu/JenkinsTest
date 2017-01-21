package com.yiya.aop;

import java.lang.reflect.Field;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yiya.bean.SysUser;
import com.yiya.service.SysUserService;
import com.yiya.utils.DateUtil;
import com.yiya.utils.SessionUtils;

@Aspect
public class OperationAdvice{
	private static Logger log = Logger.getLogger(OperationAdvice.class); 
	@Autowired(required=false) 
	private SysUserService sysUserService; 
	@Autowired
	private JdbcTemplate  jdbcTemplate;


	@Pointcut("execution(public * com..*Action.*(..))")
	public void point() {
	}
	@Around("point() && @annotation(key)")
	public Object  inServiceLayer(ProceedingJoinPoint pjp,Key key) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SysUser user = SessionUtils.getUser(request);
		String ip =request.getRemoteAddr();
		String operation= key.operation();
		String params = key.param();
//		StringBuffer sb = new StringBuffer();
		try{
//			Object[] args = pjp.getArgs();
//			if (args != null && args.length > 0) {
//				for(int i = 0; i < args.length; i++){
//					Object object = args[i];
//					if (object instanceof HttpServletRequest
//							|| object instanceof HttpServletResponse) {
//
//					}else {
//						sb.append("参数").append(i+1).append(":").append(getValue(object)).append(",");
//					}
//				}
//			}
//			String temp =sb.toString();
//			if(temp.endsWith(",")){
//				temp =temp.substring(0, temp.length()-1);
//			}
			if(user==null){
				String users = request.getParameter("usr_name");
				jdbcTemplate.execute("insert into tab_operationlog(userName,operation,content,ip,createTime) values('"+users+"','"+operation+"','"+params+"','"+ip+"',now())");
			}else{
				jdbcTemplate.execute("insert into tab_operationlog(userName,operation,content,ip,createTime) values('"+user.getUsr_name()+"','"+operation+"','"+params+"','"+ip+"',now())");
			}
		}catch(Exception e){
			log.error("写日志记录异常"+pjp.getTarget().getClass().getCanonicalName()+pjp.toShortString());
			e.printStackTrace();
		}
		return pjp.proceed();

	}

	@AfterReturning(pointcut="point()",returning="retVal")
	public void doAccessCheck(Object retVal) {
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getValue(Object object) throws Exception{

		if (object instanceof Integer
				|| object instanceof String
				|| object instanceof Float
				|| object instanceof Boolean
				|| object instanceof Double
				|| object instanceof Short
				|| object instanceof Byte
				|| object instanceof Character) {
			return object == null ? "" : "基本类型参数：" + String.valueOf(object);
		}

		StringBuffer sb = new StringBuffer();
		java.lang.reflect.Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.get(object) != null) {
				if (field.get(object) instanceof Date) {
					sb.append(field.getName()).append(":").append(DateUtil.getPlusTime2((Date)field.get(object))).append(",");
				}else if (field.get(object) instanceof String && !"".equalsIgnoreCase(field.get(object).toString())){
					sb.append(field.getName()).append(":").append(field.get(object)).append(",");
				}else {
					sb.append(field.getName()).append(":").append(field.get(object)).append(",");
				}
			}
		}
		String temp =sb.toString();
		if(temp.endsWith(",")){
			temp = temp.substring(0, temp.length()-1);
		}
		sb = new StringBuffer();
		sb.append("{").append(temp).append("}");
		return sb.toString();
	}

}
