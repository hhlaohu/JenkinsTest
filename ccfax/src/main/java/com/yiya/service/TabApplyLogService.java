package com.yiya.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabApplyLog;
import com.yiya.mapper.TabApplyLogMapper;
import com.yiya.model.TabApplyLogModel;


@Service("tabApplyLogService")
public class TabApplyLogService extends BaseService<TabApplyLog> {
	private final static Logger log= Logger.getLogger(TabApplyLogService.class);
	@Autowired
    private TabApplyLogMapper mapper;

	public TabApplyLogMapper getMapper() {
		return mapper;
	}
 
	public void update(TabApplyLog tu){
		mapper.update(tu);
	}
	
	public void add(TabApplyLog tu){
		mapper.add(tu);
	}
	
	public void delete(TabApplyLog tu){
		mapper.delete(tu);
	}
	
	public TabApplyLog queryMaxApplyTime(TabApplyLogModel model){
		return mapper.queryMaxApplyTime(model);
	}
	
}
