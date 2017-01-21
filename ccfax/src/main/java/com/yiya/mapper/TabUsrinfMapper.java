package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.yiya.model.DbjeModel;
import com.yiya.model.TabStockModel;
import com.yiya.model.TabUsrinfModel;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabUsrinf;

public interface TabUsrinfMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrinf tu);
	
	public void add(TabUsrinf tu);
	
	public void delete(TabUsrinf tu);
	
	/**
	 * 查看用户信息是否存在
	 */
	public Integer isExistTabUsrinf(TabUsrinf tabUsrinf);
	
	/**
	 * 根据用户的usrid查询用户信息
	 */
	public TabUsrinf queryTabUsrinf(TabUsrinf tabUsrinf);
	
	/**
	 * 修改额度使用状态
	 */
	public void updateLimitStatus(TabUsrinf tabUsrinf);
	
	/**
	 * 查询所有用户帐号
	 * @param bean
	 * @return
	 */
	public List<TabUsrinf> queryAllUsrinf(TabUsrinf bean);
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月19日
	 * @description 根据条件查询用户授权信息列表
	 * @param model
	 * @return
	 */
	public List<TabUsrinfModel> queryCreditStatusList(Map<String, Object> params);
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月19日
	 * @description 根据条件查询用户授权信息列表总数
	 * @param params
	 * @return
	 */
	public int queryCreditStatusListCount(Map<String, Object> params);
	
}
