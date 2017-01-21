package com.yiya.service;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.AlertConfig;
import com.yiya.mapper.AlertConfigMapper;
import com.yiya.model.AlertConfigModel;






@Service("alertConfigService")
public class AlertConfigService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(AlertConfigService.class);

	@Autowired
    private AlertConfigMapper<T> mapper;
	
	@Override
	public AlertConfigMapper<T> getMapper() {
		return mapper;
	}
	
	/**
	 *查询预警配置信息总条数
	 */
	public Integer queryCountAll(){
		return getMapper().queryCountAll();
	}
	
	/**
	 *  查询预警配置信息列表
	 */
	public List<AlertConfig> queryByAll(Map<String,Object> params){
		return getMapper().queryByAll(params);
	}
	
	/**
	 * 修改预警配置信息
	 */
	 public void updateAlertConfig(Map<String,Object> params){
		 getMapper().updateAlertConfig(params);
	 }
}
