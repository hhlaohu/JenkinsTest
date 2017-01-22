package com.yiya.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.yiya.model.DbjeModel;
import com.yiya.model.TabStockModel;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf;

public interface TabUsrDecorationContractPicMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrDecorationContractPic tudcp);
	
	public void add(TabUsrDecorationContractPic tudcp);
	
	public void delete(TabUsrDecorationContractPic tudcp);

	public List<TabUsrDecorationContractPic> queryTabUsrDecorationContractPic(TabUsrDecorationContractPic tudcp);
}
