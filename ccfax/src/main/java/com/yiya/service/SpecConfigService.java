package com.yiya.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.SpecConfig;
import com.yiya.mapper.SpecConfigMapper;


@Service("specConfigService")
public class SpecConfigService extends BaseService<SpecConfig> {
	private final static Logger log= Logger.getLogger(SpecConfigService.class);
	@Autowired
    private SpecConfigMapper mapper;

	public SpecConfigMapper getMapper() {
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
	
	public List<SpecConfig> querySpecConfigList(){
		return mapper.querySpecConfigList();
	}
	
	public SpecConfig querySpecConfigReject(Integer spec_id){
		return mapper.querySpecConfigReject(spec_id);
	}
	
	public SpecConfig querySpecConfig(SpecConfig specConfig){
		return mapper.querySpecConfig(specConfig);
	}
}
