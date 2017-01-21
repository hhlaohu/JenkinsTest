package com.yiya.mapper;

import java.util.Map;

import com.yiya.bean.TabCheckLog;

public interface TabCheckLogMapper extends BaseMapper<TabCheckLog> {
	
	public void update(TabCheckLog tu);
	
	public void add(TabCheckLog tu);
	
	public void delete(TabCheckLog tu);
	
	public TabCheckLog queryLastCheckLog(Map<String, Object> params);

	
}
