package com.yiya.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.action.app.AppAction;
import com.yiya.bean.ScoringRuleSet;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabScoringReport;
import com.yiya.model.TabScoringReportModel;
import com.yiya.service.ScoringConfigService;
import com.yiya.service.TabScoringReportService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月15日
 * @description
 */
@Controller
@RequestMapping("tabScoringReport")
public class TabScoringReportAction extends BaseAction{
	
	private final static Logger log = Logger.getLogger(TabScoringReportAction.class);
	
	@Autowired
	private TabScoringReportService tabScoringReportService;
	
	@Autowired
	private ScoringConfigService scoringConfigService;

	@RequestMapping("/dataList")
	public void dataList(TabScoringReportModel model,HttpServletResponse response){
		
		List<TabScoringReport> list = tabScoringReportService.queryReportByUsridPage(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Integer total = tabScoringReportService.queryTotalByUsrid(model);
		if(total != null){
			jsonMap.put("total", total.intValue());
		}else{
			jsonMap.put("total", 0);
		}
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/ruleSetList")
    public void ruleSetList(HttpServletResponse response){
		
		List<ScoringRuleSet> list = scoringConfigService.listAllRuleSet(null);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月5日
	 * @description
	 */
	@RequestMapping("/update")
	public void updateReportSelective(TabScoringReport tabScoringReport,HttpServletResponse response,HttpServletRequest request){
		
		try {
			tabScoringReportService.updateSelective(tabScoringReport);
			sendSuccessMessage(response, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("TabScoringReport 更新失败");
			sendFailureMessage(response, "更新失败");
		}
	}
}
