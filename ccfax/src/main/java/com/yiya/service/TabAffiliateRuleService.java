package com.yiya.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabAffiliateRule;
import com.yiya.bean.TabAffiliateRuleExample;
import com.yiya.mapper.TabAffiliateRuleMapper;
import com.yiya.model.TabAffiliateRuleModel;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月23日
 * @description
 */
@Service("tabAffiliateRuleService")
public class TabAffiliateRuleService{

	
	@Autowired
    private TabAffiliateRuleMapper mapper;
	
	
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param tabAffiliateRule
	 */
	public void add(TabAffiliateRule tabAffiliateRule){
		
		if(tabAffiliateRule == null){
			return;
		}
		mapper.insert(tabAffiliateRule);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param tabAffiliateRule
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
	 * @param tabAffiliateRule
	 */
	public void update(TabAffiliateRule tabAffiliateRule){
		
		if(tabAffiliateRule.getAffiliate_rule_id() == null){
			return;
		}
		mapper.updateByPrimaryKey(tabAffiliateRule);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description 条件分页查询
	 * @return
	 */
	public List<TabAffiliateRuleModel> queryByConditionAndPage(TabAffiliateRuleModel model){
		
		TabAffiliateRuleExample example = new TabAffiliateRuleExample();
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
	public Integer queryTotal(TabAffiliateRuleModel model){
		
		TabAffiliateRuleExample example = new TabAffiliateRuleExample();
		return mapper.selectByExample(example).size();
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description
	 * @param affiliate_rule_id
	 * @return
	 */
	public TabAffiliateRule selectById(Long affiliate_rule_id){
		
		if(affiliate_rule_id == null){
			return null;
		}
		return mapper.selectByPrimaryKey(affiliate_rule_id);
	} 
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月26日
	 * @description 获取所有的附属规则
	 * @return
	 */
	public List<TabAffiliateRuleModel> getAllRules(){
		
		TabAffiliateRuleExample example = new TabAffiliateRuleExample();
		return mapper.selectByExample(example);
	}
	
}
