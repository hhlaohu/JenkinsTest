package com.yiya.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.GatherValue;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.GatherValueMapper;
import com.yiya.utils.StringUtil;

/**
 * @author frank_wang
 * @data 2016年11月9日
 * @description
 */
@Service("gatherValueService")
public class GatherValueService extends BaseService<GatherValue> {

	
	@Autowired
    private GatherValueMapper mapper;
	
	@Override
	public BaseMapper<GatherValue> getMapper() {
		return mapper;
	}
	
	public List<GatherValue> queryByCondition(GatherValue value){
 		return mapper.queryByCondition(value);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 批量插入
	 * @param list
	 */
	public void batchInsert(List<GatherValue> list){
		mapper.batchInsert(list);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 批量更新
	 * @param list
	 */
	public void batchUpdateGatherValue(List<GatherValue> list){
		mapper.batchUpdateGatherValue(list);
	}
	
	
	/**
	 * @author frank_wang
	 * @data 2016年11月18日
	 * @description 根据字段名以及usrId查找gather_value信息
	 * @param fieldName
	 * @return
	 */
	public GatherValue queryGatherValueByFieldName(String fieldName,Integer usrId){
		
		if(StringUtil.isEmpty(fieldName) || usrId == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("field_name", fieldName);
		map.put("usrid", usrId);
		List<Map<String, Object>> list = mapper.queryGatherValueJoinGatherField(map);
		Map<String, Object> resultMap = list.get(0);
		GatherValue gatherValue = new GatherValue();
		gatherValue.setGather_field_id((Integer)resultMap.get("gather_field_id"));
		gatherValue.setGather_field_value((String)resultMap.get("gather_field_value"));
		gatherValue.setUsrid((Integer)resultMap.get("usrid"));
		gatherValue.setId(Long.valueOf(resultMap.get("gather_value_id").toString()));
		return gatherValue;
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月18日
	 * @description 根据usrId以及gather_type_id查找对应的字段名字
	 * @param fieldName
	 * @return
	 */
	public List<String> queryFieldNameSetByUsrIdAndType(Integer usrId,Integer gather_type_id){
		
		if(gather_type_id == null || usrId == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("gather_type_id", gather_type_id);
		map.put("usrid", usrId);
		List<String> stringList = new ArrayList<String>();
		List<Map<String, Object>> list = mapper.queryGatherValueJoinGatherField(map);
		for(Map<String, Object> temp:list){
			stringList.add((String)temp.get("field_name"));
		}
		return stringList;
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月18日
	 * @description 根据usrId以及field_type查找GatherValue
	 * @param fieldName
	 * @return
	 */
	public List<GatherValue> queryGatherValueListByUsrIdAndType(Integer usrId,Integer field_type){
		
		if(field_type == null || usrId == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("field_type", field_type);
		map.put("usrid", usrId);
		List<GatherValue> gatherValueList = new ArrayList<GatherValue>(); 
		List<Map<String, Object>> list = mapper.queryGatherValueJoinGatherField(map);
		for(Map<String, Object> temp:list){
			GatherValue gatherValue = new GatherValue();
			gatherValue.setId(Long.valueOf(temp.get("gather_value_id").toString()));
			gatherValueList.add(gatherValue);
		}
		return gatherValueList;
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月1日
	 * @description 根据usrId删除gather_value表数据
	 * @param usrId gather_type_id
	 */
	public void deleteByusrIdAndTypeId(Integer usrid,Integer gather_type_id){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrid", usrid);
		map.put("gather_type_id", gather_type_id);
		mapper.deleteByusrIdAndTypeId(map);
	}
	
}
