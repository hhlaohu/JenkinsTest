package com.yiya.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.bean.TabAntiFraudReportList;
import com.yiya.model.TabAntiFraudReportListModel;
import com.yiya.service.TabAntiFraudReportListService;
import com.yiya.utils.HtmlUtil;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Controller
@RequestMapping("tabAntiFraudReportList")
public class TabAntiFraudReportListAction extends BaseAction{
	         
	@Autowired
	private TabAntiFraudReportListService tabAntiFraudReportListService;

	@RequestMapping("/getAntiFraudReportListByReportId")
	public void getAntiFraudReportListByReportId(TabAntiFraudReportListModel model, HttpServletResponse response){
		
		List<TabAntiFraudReportList> list = tabAntiFraudReportListService.queryAntiFraudReportListPage(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		jsonMap.put("total", tabAntiFraudReportListService.queryTotalByReportId(model));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
}
