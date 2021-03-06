package com.yiya.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.aop.Key;
import com.yiya.bean.BaseBean.DELETED;
import com.yiya.bean.BaseBean.STATE;
import com.yiya.bean.SysRole;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.exception.ServiceException;
import com.yiya.model.SysUserModel;
import com.yiya.service.SysRoleService;
import com.yiya.service.SysUserService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.MethodUtil;
import com.yiya.utils.SessionUtils;
 
@Controller
@RequestMapping("/sysUser") 
public class SysUserAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(SysUserAction.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService sysUserService; 
	
	// Servrice start
	@Autowired(required=false) 
	private SysRoleService<SysRole> sysRoleService; 
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(SysUserModel model,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		List<SysUser> dataList = sysUserService.queryByList(model);
		//设置页面数据
		context.put("dataList", dataList);
		return forword("sys/sysUser",context); 
	}
	
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  dataList(SysUserModel model,HttpServletResponse response) throws Exception{
		List<SysUser> dataList = sysUserService.queryByList(model);
		for(SysUser user: dataList){
			List<SysRole> list = sysRoleService.queryByUserid(user.getId());
			user.setRoleStr(rolesToStr(list));
			
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 角色列表转成字符串
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list){
		if(list == null || list.isEmpty()){
			return null;
		}
		StringBuffer str = new StringBuffer();
		for(int i=0;i<list.size();i++){
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if((i+1) < list.size()){
				str.append(",");
			}
		}
		return str.toString();
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	@Key(operation="添加用户",param="sysUser.usr_name")
	public void save(SysUser bean,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		int count = sysUserService.getUserCountByName(bean.getUsr_name());
		if(bean.getId() == null){
			if(count > 0){
				throw new ServiceException("用户名已存在.");
			}
			bean.setUsr_pass(MethodUtil.MD5(bean.getUsr_pass()));
			bean.setDeleted(DELETED.NO.key);
			sysUserService.add(bean);
		}else{
			if(count > 1){
				throw new ServiceException("用户名已存在.");
			}
			//防止用户密码多次加密
			if(bean.getUsr_pass().length()!=32){  //密码长度不是MD5加密后的32位密码（此处存在用户可能设置密码为32位的隐患）
				bean.setUsr_pass(MethodUtil.MD5(bean.getUsr_pass()));
			}
			bean.setDeleted(DELETED.NO.key);
			sysUserService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		SysUser bean  = sysUserService.queryById(id);
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	@Key(operation="删除用户",param="")
	public void delete(Integer[] id,HttpServletResponse response) throws Exception{
		if(null!=id&&!"1".equals(id)){
			sysUserService.delete(id);
			sendSuccessMessage(response, "删除成功");
		}else {
			sendFailureMessage(response, "超级管理员不允许删除.");
		}
	}
	
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updatePwd")
	public void updatePwd(Integer id,String oldPwd,String newPwd,HttpServletRequest request,HttpServletResponse response) throws Exception{
		boolean isAdmin = SessionUtils.isAdmin(request); //是否超级管理员
		SysUser bean  = sysUserService.queryById(id);
		if(bean.getId() == null || DELETED.YES.key == bean.getDeleted()){
			sendFailureMessage(response, "对不起，用户不存在.");
			return;
		}
		if(StringUtils.isBlank(newPwd)){
			sendFailureMessage(response, "Password is required.");
			return;
		}
		//不是超级管理员，匹配旧密码
		if(!isAdmin && !MethodUtil.ecompareMD5(oldPwd,bean.getUsr_pass())){
			sendFailureMessage(response, "旧密码有误.");
			return;
		}
		bean.setUsr_pass(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "保存成功~");
	}
	

	
	/**
	 * 用户授权页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRole") 
	public ModelAndView  userRole(HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("/sys/sysUserRole", context);
	}
	
	/**
	 * 用户授权列表
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/userList") 
	public void  userList(SysUserModel model,HttpServletResponse response) throws Exception{
		model.setState(STATE.ENABLE.key);
		dataList(model, response);
	}

	/**
	 * 查询用户信息
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUser") 
	public void getUser(Integer id,HttpServletResponse response)  throws Exception{
		Map<String,Object>  context = getRootMap();
		SysUser bean  = sysUserService.queryById(id);
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		Integer[] roleIds = null;
		List<SysRoleRel>  roles  =sysUserService.getUserRole(bean.getId());
		if(roles != null){
			roleIds = new Integer[roles.size()];
			int i = 0;
			for(SysRoleRel rel : roles ){
				roleIds[i] = rel.getRoleId();
				i++;
			}
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", bean.getId());
		data.put("usr_name", bean.getUsr_name());
		data.put("real_name", bean.getReal_name());
		data.put("roleIds", roleIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
		
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addUserRole")
	public void addUserRole(Integer id,Integer roleIds[],HttpServletResponse response) throws Exception{
		
		try {
			if(null==roleIds||"".equals(roleIds)){
				String sql=" delete from  sys_role_rel where objId="+id+" ";
				this.jdbcTemplate.execute(sql);
			}else{
				sysUserService.addUserRole(id, roleIds);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sendFailureMessage(response, "保存失败");
		}
		
		sendSuccessMessage(response, "保存成功");
	}
	
}
