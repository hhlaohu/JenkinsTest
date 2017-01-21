package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrPremisePermitPic;
import com.yiya.bean.TabUsrinf;
import com.yiya.mapper.TabBondsmaninfMapper;
import com.yiya.mapper.TabUsrOtherPicMapper;
import com.yiya.mapper.TabUsrPremisePermitPicMapper;
import com.yiya.mapper.TabUsrinfMapper;
import com.yiya.model.DbjeModel;


@Service("tabUsrPremisePermitPicService")
public class TabUsrPremisePermitPicService extends BaseService<TabUsrPremisePermitPic> {
	private final static Logger log= Logger.getLogger(TabUsrPremisePermitPicService.class);
	@Autowired
    private TabUsrPremisePermitPicMapper mapper;

	public TabUsrPremisePermitPicMapper getMapper() {
		return mapper;
	}
 
	public void update(TabUsrPremisePermitPic tuppp){
		mapper.update(tuppp);
	}
	
	public void add(TabUsrPremisePermitPic tuppp){
		mapper.add(tuppp);
	}
	
	public void delete(TabUsrPremisePermitPic tuppp){
		mapper.delete(tuppp);
	}
	
	public List<TabUsrPremisePermitPic> queryTabUsrPremisePermitPic(TabUsrPremisePermitPic tuppp){
		return mapper.queryTabUsrPremisePermitPic(tuppp);
	}
}
