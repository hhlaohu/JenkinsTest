package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.XiaoShiConfig;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.XiaoShiConfigMapper;

/**
 * @author Administrator
 * @data 2016年10月9日
 * @description
 */
@Service("xiaoShiConfigService")
public class XiaoShiConfigService extends BaseService<XiaoShiConfig> {

	
	@Autowired
    private XiaoShiConfigMapper mapper;
	
	@Override
	public BaseMapper<XiaoShiConfig> getMapper() {
		return mapper;
	}
	
	public List<XiaoShiConfig> queryByCondition(XiaoShiConfig config){
 		return mapper.queryByCondition(config);
	}
	
	public void update(XiaoShiConfig config){
 		mapper.update(config);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月29日
	 * @description
	 * @param type
	 * @return
	 */
	public  XiaoShiConfig queryConfigByType(Integer type){
		
		XiaoShiConfig condition = new XiaoShiConfig();
		condition.setProduct_type(type);
		List<XiaoShiConfig> configList = queryByCondition(condition);
		XiaoShiConfig config = configList.get(0);
		return config;
	}
  
}
