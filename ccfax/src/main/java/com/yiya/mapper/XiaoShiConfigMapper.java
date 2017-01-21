package com.yiya.mapper;

import java.util.List;

import com.yiya.bean.XiaoShiConfig;

/**
 * @author Administrator
 * @data 2016年10月9日
 * @description
 */
public interface XiaoShiConfigMapper extends BaseMapper<XiaoShiConfig> {
   
	List<XiaoShiConfig> queryByCondition(XiaoShiConfig config);
	
}
