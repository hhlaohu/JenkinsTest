package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.mapper.TabBondsmaninfMapper;


@Service("tabBondsmaninfService")
public class TabBondsmaninfService extends BaseService<TabBondsmaninf> {

	@Autowired
    private TabBondsmaninfMapper mapper;

	public TabBondsmaninfMapper getMapper() {
		return mapper;
	}
 
	public void update(TabBondsmaninf tb){
		mapper.update(tb);
	}
	
	public void add(TabBondsmaninf tb){
		mapper.add(tb);
	}
	
	public void delete(TabBondsmaninf tb){
		mapper.delete(tb);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 持久化存储list,由于数据很少，就不采用批量方式直接采用循环
	 * @param list
	 * @param usrinf_id
	 */
	public void insertTabBondsmanList(List<TabBondsmaninf> list,Long usrinf_id){
		if(null == list || list.size() == 0){
			return;
		}
		for(TabBondsmaninf tabBondsmaninf:list){
			tabBondsmaninf.setUsrinf_id(usrinf_id.intValue());
			add(tabBondsmaninf);
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 批量更新，先删除后插入
	 * @param list
	 * @param usrinf_id
	 */
	public void updateTabBondsmanList(List<TabBondsmaninf> list,Long usrinf_id){
		
		if(null == list || list.size() == 0){
			return;
		}
		TabBondsmaninf condition = new TabBondsmaninf();
		condition.setUsrinf_id(usrinf_id.intValue());
		delete(condition);
		for(TabBondsmaninf tabBondsmaninf:list){
			tabBondsmaninf.setUsrinf_id(usrinf_id.intValue());
			add(tabBondsmaninf);
		}
	}
	

}
