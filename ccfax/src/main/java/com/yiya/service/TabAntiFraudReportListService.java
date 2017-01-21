package com.yiya.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabAntiFraudReportList;
import com.yiya.bean.TabAntiFraudReportListExample;
import com.yiya.mapper.TabAntiFraudReportListMapper;
import com.yiya.model.TabAntiFraudReportListModel;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Service     
public class TabAntiFraudReportListService{

	
	@Autowired
    private TabAntiFraudReportListMapper mapper;
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月17日
	 * @description 条件分页查找反欺诈规则
	 * @param reportId
	 */
	public List<TabAntiFraudReportList> queryAntiFraudReportListPage(TabAntiFraudReportListModel model){
		
		if(model.getReport_id() == null){
			return null;
		}
		List<TabAntiFraudReportList> list = new ArrayList<TabAntiFraudReportList>();
		TabAntiFraudReportListExample example = new TabAntiFraudReportListExample();
		example.setLimit(model.getRows());
		example.setStart((model.getPage()-1)*model.getRows());
		example.createCriteria().andReport_idEqualTo(model.getReport_id());
		example.setOrderByClause("anti_fraud_rule_id asc");
		list = mapper.selectByExample(example);
		return list;
		
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月15日
	 * @description 条件查询总数
	 * @return
	 */
	public Integer queryTotalByReportId(TabAntiFraudReportListModel model){
		
		if(model.getReport_id() == null){
			return null;
		}
		TabAntiFraudReportListExample example = new TabAntiFraudReportListExample();
		example.createCriteria().andReport_idEqualTo(model.getReport_id());
		List<TabAntiFraudReportList> list = mapper.selectByExample(example);
		if(null != list && list.size() > 0){
			return list.size();
		}else{
			return 0;
		}
	}
	
	
}
