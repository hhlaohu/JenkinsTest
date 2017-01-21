package com.yiya.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.bean.TabScoringReportList;
import com.yiya.model.TabScoringReportListModel;
import com.yiya.service.TabScoringReportListService;
import com.yiya.utils.HtmlUtil;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Controller
@RequestMapping("tabScoringReportList")
public class TabScoringReportListAction extends BaseAction{
	         
	@Autowired
	private TabScoringReportListService tabScoringReportListService;

	@RequestMapping("/getScoringReportListByReportId")
	public void getAntiFraudReportListByReportId(TabScoringReportListModel model, HttpServletResponse response){
		
		List<TabScoringReportList> list = tabScoringReportListService.queryScoringReportListPage(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		jsonMap.put("total", tabScoringReportListService.queryTotalByReportId(model));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/modifyDetail")
	public void modifyDetail(TabScoringReportList tabScoringReportList, HttpServletResponse response){
		
		tabScoringReportListService.updateSelectiveByPrimaryKey(tabScoringReportList);
		sendSuccessMessage(response, "操作成功");
	}
	
}
