
package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninfExample;
import com.yiya.mapper.TabOrderBondsmaninfMapper;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月22日
 * @description
 */
@Service
public class TabOrderBondsmaninfService {
	
	@Autowired
	private TabOrderBondsmaninfMapper tabOrderBondsmaninfMapper;
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 由于数据量少直接采用循环处理List
	 */
	public void insertTabOrderBondsmaninfList(List<TabBondsmaninf> list,Long usrOrderId){
        if(null == list || list.size() == 0){
        	return ;
        }
        for(TabBondsmaninf tabBondsmaninf:list){
        	tabOrderBondsmaninfMapper.insert(new TabOrderBondsmaninf(usrOrderId, tabBondsmaninf.getRel_usrname(),
        			Integer.valueOf(tabBondsmaninf.getRelation()), tabBondsmaninf.getRel_mobile_phone()));
        }
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 插入列表
	 */
	public void insertList(List<TabOrderBondsmaninf> list,Long usrOrderId){
        if(null == list || list.size() == 0){
        	return ;
        }
        for(TabOrderBondsmaninf tabOrderBondsmaninf:list){
        	tabOrderBondsmaninf.setUsr_order_id(usrOrderId);
        	tabOrderBondsmaninfMapper.insert(tabOrderBondsmaninf);
        }
	}
	
	   /**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月4日
	 * @description
	 * @param userOrderId
	 * @return
	 */
	public List<TabOrderBondsmaninf> selectByUserOrderId(Long userOrderId){
	   
		if(userOrderId == null){
			return null;
		}
		TabOrderBondsmaninfExample example = new TabOrderBondsmaninfExample(); 
	    example.createCriteria().andUsr_order_idEqualTo(userOrderId);
	    return tabOrderBondsmaninfMapper.selectByExample(example);
   }	
}
