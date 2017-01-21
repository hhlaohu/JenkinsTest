package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.GatherType;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.GatherTypeMapper;

/**
 * @author Administrator
 * @data 2016年10月9日
 * @description
 */
@Service("gatherTypeService")
public class GatherTypeService extends BaseService<GatherType> {

	
	@Autowired
    private GatherTypeMapper mapper;
	
	@Override
	public BaseMapper<GatherType> getMapper() {
		return mapper;
	}
	
	public List<GatherType> queryAll(){
		return mapper.queryAll();
	}
	
	public List<GatherType> queryByCondition(GatherType type){
		return mapper.queryByCondition(type);
	}
	
	public GatherType queryByName(String name){
		GatherType gatherType = new GatherType();
		gatherType.setGather_type_name(name);
		List<GatherType> list = queryByCondition(gatherType);
		return list.get(0);
	}
	
}
