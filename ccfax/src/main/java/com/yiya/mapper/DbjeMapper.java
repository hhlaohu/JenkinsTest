package com.yiya.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yiya.bean.Dbje;
import com.yiya.bean.ErrorDaily;
import com.yiya.bean.TabCustomer;
import com.yiya.model.DbjeModel;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.TabCustomerModel;

public interface DbjeMapper<T> extends BaseMapper<T> {
	
	public List<Dbje> queryByList(DbjeModel tb);
	
	public Dbje queryDbmoney(DbjeModel tb);
	
	public void update(DbjeModel tb);
	
	public void add(DbjeModel tb);
	
	public void delete(DbjeModel tb);
	
	public void updateName(DbjeModel tb);
}
