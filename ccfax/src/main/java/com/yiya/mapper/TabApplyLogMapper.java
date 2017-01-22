package com.yiya.mapper;

import com.yiya.bean.TabApplyLog;
import com.yiya.model.TabApplyLogModel;

public interface TabApplyLogMapper<T> extends BaseMapper<T> {
	
	public void update(TabApplyLog tu);
	
	public void add(TabApplyLog tu);
	
	public void delete(TabApplyLog tu);
	
	public TabApplyLog queryMaxApplyTime(TabApplyLogModel model);
}
