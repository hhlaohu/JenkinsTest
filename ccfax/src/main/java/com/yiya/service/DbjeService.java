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
import com.yiya.mapper.TabCustomerMapper;
import com.yiya.model.DbjeModel;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.TabCustomerModel;

@Service("dbjeService")
public class DbjeService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(DbjeService.class);

	@Autowired
    private DbjeMapper<T> mapper;

	public DbjeMapper<T> getMapper() {
		return mapper;
	}
	
    public List<Dbje> queryByList(DbjeModel tb){
	 return mapper.queryByList(tb);
    }
	
    public Dbje queryDbmoney(DbjeModel tb){
   	 return mapper.queryDbmoney(tb);
       }
    
	public void update(DbjeModel tb){
		mapper.update(tb);
	}
	
	public void add(DbjeModel tb){
		mapper.add(tb);
	}
	
	public void delete(DbjeModel tb){
		mapper.delete(tb);
	}
	
	public void updateName(DbjeModel tb){
		mapper.updateName(tb);
	}

}
