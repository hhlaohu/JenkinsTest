package com.yiya.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.mapper.DbjeMapper;
import com.yiya.mapper.TabStockCommentMapper;
import com.yiya.mapper.TabStockMapper;

@Service("tabStockCommentService")
public class TabStockCommentService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(TabStockCommentService.class);
	@Autowired
    private TabStockCommentMapper<T> mapper;

	public TabStockCommentMapper<T> getMapper() {
		return mapper;
	}
	
}
