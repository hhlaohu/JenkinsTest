package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.AlertDaily;
import com.yiya.model.AlertDailyModel;

public interface AlertDailyMapper<T> extends BaseMapper<T> {
	
	/**
	 * 查询预警中心信息列表
	 */
	public List<AlertDaily> queryByAll(Map<String,Object> params);
	

	/**
	 * 查询预警中心信息总数
	 */
	public Integer queryCountAll();
	
	public void updateAlertDaily(Map<String,Object> params);
}
