package com.yiya.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.bean.TabBlacklistReportList;
import com.yiya.model.TabBlacklistReportListModel;
import com.yiya.service.TabBlackListReportListService;
import com.yiya.utils.HtmlUtil;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月17日
 * @description
 */
@Controller
@RequestMapping("tabBlacklistReportList")
public class TabBlacklistReportListAction extends BaseAction{
	         
	@Autowired
	private TabBlackListReportListService tabBlackListReportListService;

	@RequestMapping("/getBlackListReportListByReportId")
	public void getAntiFraudReportListByReportId(TabBlacklistReportListModel model, HttpServletResponse response){
		
		List<TabBlacklistReportList> list = tabBlackListReportListService.queryAntiFraudReportListPage(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
}
