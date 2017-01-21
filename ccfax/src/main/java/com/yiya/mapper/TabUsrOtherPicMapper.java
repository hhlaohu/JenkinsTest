package com.yiya.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.yiya.model.DbjeModel;
import com.yiya.model.TabStockModel;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrinf;

public interface TabUsrOtherPicMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrOtherPic tuop);
	
	public void add(TabUsrOtherPic tuop);
	
	public void delete(TabUsrOtherPic tuop);
	

	
}
