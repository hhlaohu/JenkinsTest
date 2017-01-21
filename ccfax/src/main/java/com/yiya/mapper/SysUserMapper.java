package com.yiya.mapper;

import java.util.List;

import com.yiya.model.SysUserModel;

/**
 * SysUser Mapper
 * @author Administrator
 *
 */
public interface SysUserMapper<T> extends BaseMapper<T> {
	
	/**
	 * 检查登录
	 * @param usr_name
	 * @param usr_pass
	 * @return
	 */
	public T queryLogin(SysUserModel model);
	
	
	/**
	 * 查询账号总数，检查是否存在
	 * @param usr_name
	 * @return
	 */
	public int getUserCountByName(String usr_name);
	
	/**
	 * 根据条件查询，没有分页
	 */
	public List<T> queryByListWithoutPager(SysUserModel model);
}
