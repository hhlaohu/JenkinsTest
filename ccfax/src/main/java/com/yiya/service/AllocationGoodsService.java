package com.yiya.service;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yiya.mapper.AllocationGoodsMapper;;

@Service("allocationGoodsService")
public class AllocationGoodsService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(AllocationGoodsService.class);

	@Autowired
    private AllocationGoodsMapper<T> mapper;

	public AllocationGoodsMapper<T> getMapper() {
		return mapper;
	}
	
}
