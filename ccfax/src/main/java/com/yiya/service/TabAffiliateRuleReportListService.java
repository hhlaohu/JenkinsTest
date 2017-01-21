package com.yiya.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabAffiliateRuleReportList;
import com.yiya.bean.TabAffiliateRuleReportListExample;
import com.yiya.mapper.TabAffiliateRuleReportListMapper;
import com.yiya.model.TabAffiliateRuleReportListModel;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月23日
 * @description
 */
@Service("TabAffiliateRuleReportListReportListService")
public class TabAffiliateRuleReportListService{

	
	@Autowired
    private TabAffiliateRuleReportListMapper mapper;
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param TabAffiliateRuleReportList
	 */
	public void add(TabAffiliateRuleReportList TabAffiliateRuleReportList){
		
		if(TabAffiliateRuleReportList == null){
			return;
		}
		mapper.insert(TabAffiliateRuleReportList);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param TabAffiliateRuleReportList
	 */
	public void delete(Long id){
		
		if(id == null){
			return;
		}
		mapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param TabAffiliateRuleReportList
	 */
	public void updateSelective(TabAffiliateRuleReportList TabAffiliateRuleReportList){
		
		if(TabAffiliateRuleReportList.getId() == null){
			return;
		}
		mapper.updateByPrimaryKeySelective(TabAffiliateRuleReportList);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description 条件分页查询
	 * @return
	 */
	public List<TabAffiliateRuleReportList> queryByConditionAndPage(TabAffiliateRuleReportListModel model){
		
		TabAffiliateRuleReportListExample example = new TabAffiliateRuleReportListExample();
		example.setLimit(model.getRows());
		example.setStart((model.getPage()-1)*model.getRows());
		return mapper.selectByExample(example);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param model
	 * @return
	 */
	public Integer queryTotal(TabAffiliateRuleReportListModel model){
		
		TabAffiliateRuleReportListExample example = new TabAffiliateRuleReportListExample();
		return mapper.selectByExample(example).size();
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param affiliate_rule_id
	 * @return
	 */
	public TabAffiliateRuleReportList selectById(Long affiliate_rule_id){
		
		if(affiliate_rule_id == null){
			return null;
		}
		return mapper.selectByPrimaryKey(affiliate_rule_id);
	} 
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月26日
	 * @description 联表TabAffiliateRule查询
	 * @param model
	 * @return
	 */
	public List<TabAffiliateRuleReportListModel> queryJoinTabAffiliateRule(TabAffiliateRuleReportListModel model){
		
		Integer rowCount = queryJoinTabAffiliateRuleCount(model);
		model.getPager().setRowCount(rowCount);
		return mapper.queryJoinTabAffiliateRule(model);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月26日
	 * @description 联表TabAffiliateRule查询总数
	 * @param model
	 * @return
	 */
	public Integer queryJoinTabAffiliateRuleCount(TabAffiliateRuleReportListModel model){
		
		return mapper.queryJoinTabAffiliateRuleCount(model);
	}
	
}
