package com.yiya.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrinf;
import com.yiya.mapper.TabUsrinfMapper;
import com.yiya.model.TabUsrinfModel;


@Service("tabUsrinfService")
public class TabUsrinfService<T> extends BaseService<T> {
	
	@Autowired
    private TabUsrinfMapper<T> mapper;

	public TabUsrinfMapper<T> getMapper() {
		return mapper;
	}
 
	public void update(TabUsrinf tu){
		mapper.update(tu);
	}
	
	public void add(TabUsrinf tu){
		mapper.add(tu);
	}
	
	public void delete(TabUsrinf tu){
		mapper.delete(tu);
	}
	
	/**
	 * 查看用户信息是否存在
	 */
	public Integer isExistTabUsrinf(TabUsrinf tabUsrinf){
		return getMapper().isExistTabUsrinf(tabUsrinf);
	}
	
	/**
	 * 查询用户信息
	 */
	public TabUsrinf queryTabUsrinf(TabUsrinf tabUsrinf){
		return getMapper().queryTabUsrinf(tabUsrinf);
	}
	
	/**
	 * 修改额度使用状态
	 */
	public void updateLimitStatus(TabUsrinf tabUsrinf){
		 mapper.updateLimitStatus(tabUsrinf);
	}
	
	public List<TabUsrinf> queryAllUsrinf(TabUsrinf bean){
		return mapper.queryAllUsrinf(bean);
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月19日
	 * @description 根据条件查询用户授权信息列表
	 * @param model
	 * @return
	 */
	public List<TabUsrinfModel> queryCreditStatusList(Map<String, Object> params){
		return mapper.queryCreditStatusList(params);
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年10月19日
	 * @description 根据条件查询用户授权信息列表总数
	 * @return
	 */
	public int queryCreditStatusListCount(Map<String, Object> params){
		return mapper.queryCreditStatusListCount(params);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 根据公共平台Id 查询客户
	 * @return
	 */
	public TabUsrinf getTabusrinfByusrid(Integer usrid){
		TabUsrinf condition = new TabUsrinf();
		condition.setUsrid(usrid);
		TabUsrinf tabUsrinf = queryTabUsrinf(condition);
		return tabUsrinf;
	}
	
}
