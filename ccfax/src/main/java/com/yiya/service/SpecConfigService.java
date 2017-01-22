package com.yiya.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.SpecConfig;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrinf;
import com.yiya.mapper.SpecConfigMapper;
import com.yiya.mapper.TabBondsmaninfMapper;
import com.yiya.mapper.TabUsrOtherPicMapper;
import com.yiya.mapper.TabUsrinfMapper;
import com.yiya.model.DbjeModel;


@Service("specConfigService")
public class SpecConfigService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(SpecConfigService.class);
	@Autowired
    private SpecConfigMapper<T> mapper;

	public SpecConfigMapper<T> getMapper() {
		return mapper;
	}
 
	public void update(SpecConfig sc){
		mapper.update(sc);
	}
	
	public void add(SpecConfig sc){
		mapper.add(sc);
	}
	
	public void delete(SpecConfig sc){
		mapper.delete(sc);
	}
	
	public List<T> querySpecConfigList(){
		return mapper.querySpecConfigList();
	}
	
	public SpecConfig querySpecConfigReject(Integer spec_id){
		return mapper.querySpecConfigReject(spec_id);
	}
	
	public SpecConfig querySpecConfig(SpecConfig specConfig){
		return mapper.querySpecConfig(specConfig);
	}
}
