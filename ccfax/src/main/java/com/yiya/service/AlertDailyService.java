package com.yiya.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.AlertDaily;
import com.yiya.mapper.AlertDailyMapper;
import com.yiya.model.AlertDailyModel;





@Service("alertDailyService")
public class AlertDailyService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(AlertDailyService.class);

	@Autowired
    private AlertDailyMapper<T> mapper;
	
	@Override
	public AlertDailyMapper<T> getMapper() {
		return mapper;
	}
	
	/**
	 * 查询预警中心信息列表
	 */
	public List<AlertDaily> queryByAll(Map<String,Object> params){
		return getMapper().queryByAll(params);
	}
	
	/**
	 * 查询预警中心信息总数
	 */
	public Integer queryCountAll(){
		return getMapper().queryCountAll();
	}
	
	/**
	 * 
	 */
	public void updateAlertDaily(Map<String,Object> params){
		getMapper().updateAlertDaily(params);
	}
}
