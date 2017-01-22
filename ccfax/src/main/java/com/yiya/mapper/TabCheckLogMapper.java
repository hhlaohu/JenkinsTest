package com.yiya.mapper;

import java.util.Map;

import com.yiya.bean.TabCheckLog;

public interface TabCheckLogMapper<T> extends BaseMapper<T> {
	
	public void update(TabCheckLog tu);
	
	public void add(TabCheckLog tu);
	
	public void delete(TabCheckLog tu);
	
	public TabCheckLog queryLastCheckLog(Map<String, Object> params);

	
}
