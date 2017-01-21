package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.SysMenu;
import com.yiya.model.SysMenuModel;

/**
 * SysMenu Mapper
 * @author Administrator
 *
 */
public interface SysMenuMapper<T> extends BaseMapper<T> {
	
	/**
	 * 查询所有系统菜单列表
	 * @return
	 */
	public List<T> queryByAll();
	
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRootMenu(java.util.Map map);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getChildMenu();
	
	

	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(Integer roleId);
	
	
	/**
	 * 根据用户id查询父菜单菜单
	 * @param userId
	 * @return
	 */
	public List<T> getRootMenuByUser(Integer userId);
	
	/**
	 * 根据用户id查询子菜单菜单
	 * @param userId
	 * @return
	 */
	public List<T> getChildMenuByUser(Integer userId);
	
	/***
	 * 菜单管理列表查询
	 * @return
	 */
	public List<SysMenu> querySysMenuAll(Map<String, Object> params);
	
	/**
	 * 菜单管理查询列表总数
	 */
	public Integer queryCountbyAll();
	
	/**
	 * 查询父级菜单列表
	 */
	public List<SysMenu> queryParentNameList(SysMenuModel sm);
}
