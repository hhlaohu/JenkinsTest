package com.yiya.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysRoleRel.RelType;
import com.yiya.bean.SysUser;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.SysUserMapper;
import com.yiya.model.SysUserModel;
import com.yiya.utils.StringUtil;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserService<br>
 * <b>作者：</b>罗泽军<br>
 * <b>日期：</b> Dec 9, 2011 <br>
 * <b>版权所有：<b>版权所有(C) 2011，WWW.VOWO.COM<br>
 */
@Service("sysUserService")
public class SysUserService extends BaseService<SysUser> implements InitializingBean,ApplicationContextAware{
	private final static Logger log= Logger.getLogger(SysUserService.class);
	
	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	private ApplicationContext context;
	
	private SendMessage sendMessage; 
	
	@Override
	public void delete(Object[] ids) throws Exception {
		super.delete(ids);
		for(Object id :  ids){
			sysRoleRelService.deleteByObjId((Integer)id, RelType.USER.key);
		}
	}
	/**
	 * 检查登录
	 * @param usr_name
	 * @param usr_pass
	 * @return
	 */
	public SysUser queryLogin(String usr_name,String usr_pass){
		SysUserModel model = new SysUserModel();
		model.setUsr_name(usr_name);
		model.setUsr_pass(usr_pass);
		return getMapper().queryLogin(model);
	}
	
	/**
	 * 查询账号总数，检查是否存在
	 * @param usr_name
	 * @return
	 */
	public int getUserCountByName(String usr_name){
		return getMapper().getUserCountByName(usr_name);
	}
	
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	public List<SysRoleRel> getUserRole(Integer userId){
		return sysRoleRelService.queryByObjId(userId,RelType.USER.key);
	}
	
	/**
	 * 添加用户权限
	 * @param userId
	 * @param roleIds
	 * @throws Exception
	 */
	public void addUserRole(Integer userId,Integer[] roleIds) throws Exception{
		if(userId == null ||  roleIds == null || roleIds.length < 1 ){ 
			return;
		}
		//清除关联关系
		sysRoleRelService.deleteByObjId(userId, RelType.USER.key);
		for(Integer roleId :roleIds ){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(userId);
			rel.setRelType(RelType.USER.key);
			sysRoleRelService.add(rel);
		}
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月13日
	 * @description 根据条件查询，没有分页
	 * @param model
	 * @return
	 */
	public List<SysUser> queryByListWithoutPager(SysUserModel model){
		
		return getMapper().queryByListWithoutPager(model);
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月13日
	 * @description 给具有某种权限的人员发送短信
	 */
	public void sendMessageByButtonAuthority(String content,Integer buttonId){
		log.info("sendMessageByButtonAuthority param---content:"+content+"--buttonId:"+buttonId);
		Set<String> secondVerifyPhones = new HashSet<String>();
		List<SysUser> sysUserList = queryByListWithoutPager(null);
		for(SysUser user:sysUserList){
			List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(user.getId(), WebServiceConstant.RELATION_SYS_ROLE); // 根据用户id查找角色和权限
			for (SysRoleRel sysRoleRel : SysRoleRelList) {
				Integer roleId = sysRoleRel.getRoleId();
				List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, WebServiceConstant.RELATION_SYS_BTN); // 根据用户角色查找是否有审核权限
				for (SysRoleRel buttonRels : buttonRelsList) {
					if(buttonId.equals(buttonRels.getObjId()) && !StringUtil.isEmpty(user.getTel()) && 
							WebServiceConstant.IS_SEND_MESSAGE_OPEN.equals(user.getIs_send_message())){
						secondVerifyPhones.add(user.getTel());
					}
				}
			}
		}
		if(secondVerifyPhones.isEmpty()){
			return;
		}
		Iterator<String> iterator = secondVerifyPhones.iterator();
		StringBuffer buffer = new StringBuffer();
 		while(iterator.hasNext()){
			buffer.append(iterator.next()+",");
		}
	    String telephones = buffer.toString().substring(0, buffer.toString().lastIndexOf(","));
	    sendMessage.sendGroupSmsToClient(content, telephones,WebServiceConstant.SHORT_MESSAGE_CHANEL_5);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年10月13日
	 * @description 查询出具有某种权限的人
	 * @return List<SysUser>
	 */
	public List<SysUser> querySysUsersByButtonAuthority(Integer buttonId,boolean ifFilterTelephone){
		
		Set<SysUser> sysUserSet = new HashSet<SysUser>();
		
		List<SysUser> sysUserList = queryByListWithoutPager(null);
		
		for(SysUser user:sysUserList){
			if(user.getId().intValue()==15){
				System.out.println();
			}
			List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(user.getId(), WebServiceConstant.RELATION_SYS_ROLE); // 根据用户id查找角色和权限
			for (SysRoleRel sysRoleRel : SysRoleRelList) {
				Integer roleId = sysRoleRel.getRoleId();
				List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, WebServiceConstant.RELATION_SYS_BTN); // 根据用户角色查找是否有审核权限
				for (SysRoleRel buttonRels : buttonRelsList) {
					if(ifFilterTelephone){
						if(buttonId.equals(buttonRels.getObjId())&& !StringUtil.isEmpty(user.getTel())){
							sysUserSet.add(user);
						}	
					}else{
						if(buttonId.equals(buttonRels.getObjId())){
							sysUserSet.add(user);
						}
					}
					
				}
			}
		}
		return new ArrayList<SysUser>(sysUserSet);
	} 
	
	@Autowired
    private SysUserMapper<SysUser> mapper;

		
	public SysUserMapper<SysUser> getMapper() {
		return mapper;
	}
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		sendMessage = context.getBean("sendMessage", SendMessage.class);
	}
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

}
