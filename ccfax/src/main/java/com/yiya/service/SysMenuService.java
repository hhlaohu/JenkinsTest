package com.yiya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.SysMenu;
import com.yiya.bean.SysMenuBtn;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysRoleRel.RelType;
import com.yiya.mapper.SysMenuMapper;
import com.yiya.model.SysMenuModel;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuService<br>
 * <b>作者：</b>罗泽军<br>
 * <b>日期：</b> Dec 9, 2011 <br>
 * <b>版权所有：<b>版权所有(C) 2011，WWW.VOWO.COM<br>
 */
@Service("sysMenuService")
public class SysMenuService extends BaseService<SysMenu> {
	private final static Logger log= Logger.getLogger(SysMenuService.class);


	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;
	
	@Autowired
    private SysMenuMapper<SysMenu> mapper;
	
	/**
	 * 保存菜单btn
	 * @param btns
	 * @throws Exception 
	 */
	public void saveBtns(Integer menuid,List<SysMenuBtn> btns) throws Exception{
		if(btns == null || btns.isEmpty()){
			return;
		}
		for (SysMenuBtn btn : btns) {
			if(btn.getId()!= null && "1".equals(btn.getDeleteFlag())){
				sysMenuBtnService.delete(btn.getId());
				continue;
			}
			btn.setMenuid(menuid);
			if(btn.getId() == null){
				sysMenuBtnService.add(btn);
			}else{
				sysMenuBtnService.update(btn);
			}
		}
		
	}
	
	
	

	public void add(SysMenu menu) throws Exception {
		super.add((SysMenu)menu);
		saveBtns(menu.getId(),menu.getBtns());
	}




	public void update(SysMenu menu) throws Exception {
		super.update((SysMenu)menu);
		saveBtns(menu.getId(),menu.getBtns());
	}




	/**
	 * 查询所有系统菜单列表
	 * @return
	 */
	public List<SysMenu> queryByAll(){
		return mapper.queryByAll();
	}
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<SysMenu> getRootMenu(Integer menuId){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("menuId", menuId);
		return mapper.getRootMenu(map);
	}
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<SysMenu> getChildMenu(){
		return mapper.getChildMenu();
	}
	
	/**
	 * 根据用户id查询父菜单
	 * @param roleId
	 * @return
	 */
	public List<SysMenu> getRootMenuByUser(Integer userId){
		return getMapper().getRootMenuByUser(userId);
	}
	
	
	/**
	 * 根据用户id查询子菜单
	 * @param roleId
	 * @return
	 */
	public List<SysMenu> getChildMenuByUser(Integer userId){
		return getMapper().getChildMenuByUser(userId);
	}
	
	
	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	public List<SysMenu> getMenuByRoleId(Integer roleId){
		return getMapper().getMenuByRoleId(roleId);
	}
	
	
	
	@Override
	public void delete(Object[] ids) throws Exception {
		super.delete(ids);
		//删除关联关系
		for(Object id : ids){
			sysRoleRelService.deleteByObjId((Integer)id, RelType.MENU.key);
			sysMenuBtnService.deleteByMenuid((Integer)id);
		}
	}

	/***
	 * 菜单管理列表查询
	 * @return
	 */
	public List<SysMenu> querySysMenuAll(Map<String, Object> params){
		return getMapper().querySysMenuAll(params);
	}
	
	/**
	 * 菜单管理查询列表总数
	 */
	public Integer queryCountbyAll(){
		return getMapper().queryCountbyAll();
	}
	
	/**
	 * 查询父级菜单列表
	 */
	public List<SysMenu> queryParentNameList(SysMenuModel sm){
		return getMapper().queryParentNameList(sm);
	}
	
	public SysMenuMapper<SysMenu> getMapper() {
		return mapper;
	}

}