package com.yiya.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabScoringReportList;
import com.yiya.bean.TabScoringReportListExample;
import com.yiya.mapper.TabScoringReportListMapper;
import com.yiya.model.TabScoringReportListModel;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Service     
public class TabScoringReportListService{

	
	@Autowired
    private TabScoringReportListMapper mapper;
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月17日
	 * @description 条件分页查找信用评分项
	 * @param reportId
	 */
	public List<TabScoringReportList> queryScoringReportListPage(TabScoringReportListModel model){
		
		if(model.getReport_id() == null){
			return null;
		}
		List<TabScoringReportList> list = new ArrayList<TabScoringReportList>();
		TabScoringReportListExample example = new TabScoringReportListExample();
		example.setLimit(model.getRows());
		example.setStart((model.getPage()-1)*model.getRows());
		example.createCriteria().andReport_idEqualTo(model.getReport_id());
		example.setOrderByClause("scoring_rule_id  asc");
		list = mapper.selectByExample(example);
		return list;
		
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月17日
	 * @description 条件查询总数信用评分
	 * @return
	 */
	public Integer queryTotalByReportId(TabScoringReportListModel model){
		
		if(model.getReport_id() == null){
			return null;
		}
		TabScoringReportListExample example = new TabScoringReportListExample();
		example.createCriteria().andReport_idEqualTo(model.getReport_id());
		List<TabScoringReportList> list = mapper.selectByExample(example);
		if(null != list && list.size() > 0){
			return list.size();
		}else{
			return 0;
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月23日
	 * @description 根据主键有选择性的修改
	 */
	public void updateSelectiveByPrimaryKey(TabScoringReportList tabScoringReportList){
		
		if(tabScoringReportList.getId() == null){
			throw new RuntimeException("TabScoringReportList id should not be null");
		}
		
		mapper.updateByPrimaryKeySelective(tabScoringReportList);
	}
	
}
