package com.yiya.mapper;





import java.util.List;

import com.yiya.bean.SpecConfig;
import com.yiya.bean.TabUsrinf;


public interface SpecConfigMapper<T> extends BaseMapper<T> {
	
	public void update(SpecConfig sc);
	
	public void add(SpecConfig sc);
	
	public void delete(SpecConfig sc);
	
	public List<T> querySpecConfigList();
	
	public SpecConfig querySpecConfigReject(Integer spec_id);
	
	public SpecConfig querySpecConfig(SpecConfig specConfig);
}
