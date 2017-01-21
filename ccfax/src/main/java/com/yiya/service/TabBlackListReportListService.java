package com.yiya.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabAntiFraudReportList;
import com.yiya.bean.TabAntiFraudReportListExample;
import com.yiya.bean.TabBlacklistReportList;
import com.yiya.bean.TabBlacklistReportListExample;
import com.yiya.mapper.TabBlacklistReportListMapper;
import com.yiya.model.TabAntiFraudReportListModel;
import com.yiya.model.TabBlacklistReportListModel;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Service     
public class TabBlackListReportListService{

	
	@Autowired
    private TabBlacklistReportListMapper mapper;
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月17日
	 * @description 条件查找反欺诈规则报告列表
	 * @param reportId
	 */
	public List<TabBlacklistReportList> queryAntiFraudReportListPage(TabBlacklistReportListModel model){
		
		if(model.getReport_id() == null){
			return null;
		}
		List<TabBlacklistReportList> list = new ArrayList<TabBlacklistReportList>();
		TabBlacklistReportListExample example = new TabBlacklistReportListExample();
		example.createCriteria().andReport_idEqualTo(model.getReport_id());
		list = mapper.selectByExample(example);
		return list;
		
	}
	
}
