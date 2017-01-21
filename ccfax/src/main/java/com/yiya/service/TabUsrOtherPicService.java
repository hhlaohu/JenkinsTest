package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrOtherPic;
import com.yiya.mapper.TabUsrOtherPicMapper;


@Service("tabUsrOtherPicService")
public class TabUsrOtherPicService<T> extends BaseService<T> {
	
	private final static Logger log= Logger.getLogger(TabUsrOtherPicService.class);
	
	@Autowired
    private TabUsrOtherPicMapper<T> mapper;

	public TabUsrOtherPicMapper<T> getMapper() {
		return mapper;
	}
 
	public void update(TabUsrOtherPic tuop){
		mapper.update(tuop);
	}
	
	public void add(TabUsrOtherPic tuop){
		mapper.add(tuop);
	}
	
	public void delete(TabUsrOtherPic tuop){
		mapper.delete(tuop);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 由于数据量少直接采用循环处理List
	 * @param list
	 * @param usrinf_id
	 */
	public void insertTabUsrOtherPicList(List<TabUsrOtherPic> list,Integer usrinf_id){
		
		if(null == list || list.size() == 0){
			return;
		}
        for(TabUsrOtherPic tabUsrOtherPic:list){
        	tabUsrOtherPic.setUsrinf_id(usrinf_id);
        	mapper.add(tabUsrOtherPic);
        }
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 由于数据量少直接采用循环处理List
	 * @param list
	 * @param usrinf_id
	 */
	public void updateTabUsrOtherPicList(List<TabUsrOtherPic> list,Integer usrinf_id){
		
		if(null == list || list.size() == 0){
			return;
		}
		TabUsrOtherPic condition = new TabUsrOtherPic();
		condition.setUsrinf_id(usrinf_id);
		delete(condition);
        for(TabUsrOtherPic tabUsrOtherPic:list){
        	tabUsrOtherPic.setUsrinf_id(usrinf_id);
        	mapper.add(tabUsrOtherPic);
        }
	}
}
