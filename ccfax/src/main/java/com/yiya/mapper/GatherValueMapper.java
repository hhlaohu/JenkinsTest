package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.GatherValue;

/**
 * @author frank_wang
 * @data 2016年11月3日
 * @description
 */
public interface GatherValueMapper extends BaseMapper<GatherValue> {

	List<GatherValue> queryByCondition(GatherValue gatherValue);
	
	void batchInsert(List<GatherValue> list);
	
	void batchUpdateGatherValue(List<GatherValue> list);
	
	List<Map<String, Object>> queryGatherValueJoinGatherField(Map<String, Object> map);
	
	void deleteByusrIdAndTypeId(Map<String, Object> map);
 	 
}
