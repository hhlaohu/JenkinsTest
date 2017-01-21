package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.SysMenuBtn;

/**
 * SysMenuBtn Mapper
 * @author Administrator
 *
 */
public interface SysMenuBtnMapper<T> extends BaseMapper<T> {
	
	public List<T> queryByMenuid(Integer menuid);
	
	public List<T> queryByMenuUrl(String url); 
	
	public void deleteByMenuid(Integer menuid);
	
	public List<T> getMenuBtnByUser(Integer userid); 
	
	public List<T> queryByAll();
	
	List<SysMenuBtn> queryBtnJoinMenu(Map<String, Object> map);
}
