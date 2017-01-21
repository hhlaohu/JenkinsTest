package com.yiya.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.GoodsStock;
import com.yiya.mapper.GoodsStockMapper;

@Service("goodsStockService")
public class GoodsStockService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(GoodsStockService.class);
	@Autowired
    private GoodsStockMapper<T> mapper;

	public GoodsStockMapper<T> getMapper() {
		return mapper;
	}

}
