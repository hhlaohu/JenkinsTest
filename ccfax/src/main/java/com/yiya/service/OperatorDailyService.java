package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.Dbje;
import com.yiya.bean.ErrorDaily;
import com.yiya.bean.TabCustomer;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.DbjeMapper;
import com.yiya.mapper.OperatorDailyMapper;
import com.yiya.mapper.TabCustomerMapper;
import com.yiya.model.DbjeModel;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.OperatorDailyModel;
import com.yiya.model.TabCustomerModel;

@Service("operatorDailyService")
public class OperatorDailyService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(OperatorDailyService.class);

	@Autowired
    private OperatorDailyMapper<T> mapper;

	public OperatorDailyMapper<T> getMapper() {
		return mapper;
	}
	
   
    


}
