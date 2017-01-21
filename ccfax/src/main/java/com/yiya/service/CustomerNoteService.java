package com.yiya.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.CustomerNote;
import com.yiya.bean.product_controll;
import com.yiya.mapper.CustomerNoteMapper;

@Service("customerNoteService")
public class CustomerNoteService<T> extends BaseService<T> {

	@Autowired
    private CustomerNoteMapper<T> mapper;

	public CustomerNoteMapper<T> getMapper() {
		return mapper;
	}
	
	public CustomerNote queryMaxId(CustomerNote model){
		return mapper.queryMaxId(model);
	}

    public product_controll querypzgoods(product_controll pc){
	   return mapper.querypzgoods(pc);
    } 

}
