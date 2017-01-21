package com.yiya.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabScoringReport;
import com.yiya.bean.TabScoringReportExample;
import com.yiya.mapper.TabScoringReportMapper;
import com.yiya.model.TabScoringReportModel;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月15日
 * @description 评分报告
 */
@Service("tabScoringReportService")
public class TabScoringReportService{

	
	@Autowired
    private TabScoringReportMapper mapper;
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月15日
	 * @description 条件分页查询list
	 */
	public List<TabScoringReport> queryReportByUsridPage(TabScoringReportModel model){
		
		if(model.getUsrid() == null){
			return new ArrayList<TabScoringReport>();
		}
		TabScoringReportExample example = new TabScoringReportExample();
		example.setLimit(model.getRows());
		example.setStart((model.getPage()-1)*model.getRows());
		example.createCriteria().andUsridEqualTo(model.getUsrid());
		return mapper.selectByExample(example);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月15日
	 * @description 查询总数
	 * @return
	 */
	public Integer queryTotalByUsrid(TabScoringReportModel model){
		
		if(model.getUsrid() == null){
			return null;
		}
		TabScoringReportExample example = new TabScoringReportExample();
		example.createCriteria().andUsridEqualTo(model.getUsrid());
		List<TabScoringReport> list = mapper.selectByExample(example);
		if(null != list && list.size() > 0){
			return list.size();
		}else{
			return 0;
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月5日
	 * @description
	 */
	public void updateSelective(TabScoringReport tabScoringReport){
		
		mapper.updateByPrimaryKeySelective(tabScoringReport);
	}
	
}
