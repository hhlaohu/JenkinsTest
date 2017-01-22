package com.yiya.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.yiya.model.DbjeModel;
import com.yiya.model.TabStockModel;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf;

public interface TabUsrPremisePermitPicMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrPremisePermitPic tuppp);
	
	public void add(TabUsrPremisePermitPic tuppp);
	
	public void delete(TabUsrPremisePermitPic tuppp);
	
	public List<TabUsrPremisePermitPic> queryTabUsrPremisePermitPic(TabUsrPremisePermitPic tuppp);
	
}
