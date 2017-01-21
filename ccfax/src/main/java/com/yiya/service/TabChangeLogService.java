package com.yiya.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabApplyLog;
import com.yiya.bean.TabChangeLog;
import com.yiya.mapper.TabApplyLogMapper;
import com.yiya.mapper.TabChangeLogMapper;
import com.yiya.model.TabApplyLogModel;


@Service("tabChangeLogService")
public class TabChangeLogService extends BaseService<TabChangeLog> {
	private final static Logger log= Logger.getLogger(TabChangeLogService.class);
	@Autowired
    private TabChangeLogMapper mapper;

	public TabChangeLogMapper getMapper() {
		return mapper;
	}
 
	public void update(TabChangeLog tcl){
		mapper.update(tcl);
	}
	
	public void add(TabChangeLog tcl){
		mapper.add(tcl);
	}
	
	public void delete(TabChangeLog tcl){
		mapper.delete(tcl);
	}
	
	public TabChangeLog queryTabChangeLog(Integer usrinf_id){
		return getMapper().queryTabChangeLog(usrinf_id);
	}
	
}
