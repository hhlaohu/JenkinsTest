package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrComplementPic;
import com.yiya.mapper.TabUsrComplementPicMapper;


@Service("tabUsrComplementPicService")
public class TabUsrComplementPicService extends BaseService<TabUsrComplementPic> {
	private final static Logger log= Logger.getLogger(TabUsrComplementPicService.class);
	@Autowired
    private TabUsrComplementPicMapper mapper;

	public TabUsrComplementPicMapper getMapper() {
		return mapper;
	}
 
	public void update(TabUsrComplementPic tucp){
		mapper.update(tucp);
	}
	
	public void add(TabUsrComplementPic tucp){
		mapper.add(tucp);
	}
	
	public void delete(TabUsrComplementPic tucp){
		mapper.delete(tucp);
	}
	
	public List<TabUsrComplementPic> queryByUsrInfId(Integer usrInfId){
		return mapper.queryByList(null);
		
	}
	

}
