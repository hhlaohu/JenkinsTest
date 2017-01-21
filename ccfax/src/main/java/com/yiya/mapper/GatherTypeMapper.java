package com.yiya.mapper;

import java.util.List;

import com.yiya.bean.GatherType;

/**
 * @author frank_wang
 * @data 2016年11月3日
 * @description
 */
public interface GatherTypeMapper extends BaseMapper<GatherType> {

 	 List<GatherType> queryAll();
 	 
 	 List<GatherType> queryByCondition(GatherType type);
 	 
}
