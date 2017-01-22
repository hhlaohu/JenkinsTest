package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrinf;
import com.yiya.mapper.TabBondsmaninfMapper;
import com.yiya.mapper.TabUsrComplementPicMapper;
import com.yiya.mapper.TabUsrOtherPicMapper;
import com.yiya.mapper.TabUsrinfMapper;
import com.yiya.model.DbjeModel;


@Service("tabUsrComplementPicService")
public class TabUsrComplementPicService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(TabUsrComplementPicService.class);
	@Autowired
    private TabUsrComplementPicMapper<T> mapper;

	public TabUsrComplementPicMapper<T> getMapper() {
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
	
	public List<T> queryByUsrInfId(Integer usrInfId){
		return mapper.queryByList(null);
		
	}
	

}
