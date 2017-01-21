package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.mapper.TabUsrDecorationContractPicMapper;


@Service("tabUsrDecorationContractPicService")
public class TabUsrDecorationContractPicService extends BaseService<TabUsrDecorationContractPic> {
	private final static Logger log= Logger.getLogger(TabUsrDecorationContractPicService.class);
	@Autowired
    private TabUsrDecorationContractPicMapper mapper;

	public TabUsrDecorationContractPicMapper getMapper() {
		return mapper;
	}
 
	public void update(TabUsrDecorationContractPic tudcp){
		mapper.update(tudcp);
	}
	
	public void add(TabUsrDecorationContractPic tudcp){
		mapper.add(tudcp);
	}
	
	public void delete(TabUsrDecorationContractPic tudcp){
		mapper.delete(tudcp);
	}
	
	public List<TabUsrDecorationContractPic> queryTabUsrDecorationContractPic(TabUsrDecorationContractPic tudcp){
		return mapper.queryTabUsrDecorationContractPic(tudcp);
	}

}
