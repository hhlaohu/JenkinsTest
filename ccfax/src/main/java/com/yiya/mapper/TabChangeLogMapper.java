package com.yiya.mapper;

import com.yiya.bean.TabApplyLog;
import com.yiya.bean.TabChangeLog;
import com.yiya.model.TabApplyLogModel;

public interface TabChangeLogMapper<T> extends BaseMapper<T> {
	
	public void update(TabChangeLog tcl);
	
	public void add(TabChangeLog tcl);
	
	public void delete(TabChangeLog tcl);
	
	public TabChangeLog queryTabChangeLog(Integer usrinf_id);
	
}
