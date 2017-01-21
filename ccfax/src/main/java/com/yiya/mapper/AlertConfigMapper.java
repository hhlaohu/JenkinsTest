package com.yiya.mapper;

import java.util.List;
import java.util.Map;
import com.yiya.bean.AlertConfig;
import com.yiya.model.AlertConfigModel;


public interface AlertConfigMapper<T> extends BaseMapper<T> {
	
	/**
	 *查询预警配置信息总条数
	 */
	public Integer queryCountAll();
	
	
	/**
	 *  查询预警配置信息列表
	 * @param params
	 * @return
	 */
	public List<AlertConfig> queryByAll(Map<String,Object> params);
	
	
	/**
	 * 修改预警配置信息
	 */
	 public void updateAlertConfig(Map<String,Object> params);
}
