package com.yiya.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.bean.SysUser;
import com.yiya.bean.TabAffiliateRuleReportList;
import com.yiya.model.TabAffiliateRuleReportListModel;
import com.yiya.service.TabAffiliateRuleReportListService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;



/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月23日
 * @description
 */
@Controller
@RequestMapping("tabAffiliateRuleReportList")
public class TabAffiliateRuleReportListAction extends BaseAction{
	
	@Autowired
	private TabAffiliateRuleReportListService tabAffiliateRuleReportListService;
	
	@RequestMapping("/list")
	public ModelAndView mapList(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		return forword("tabAffiliateRule/tabAffiliateRule", context);
	}
	

	@RequestMapping("/dataList")
	public void dataList(TabAffiliateRuleReportListModel model,HttpServletResponse response){
		
		List<TabAffiliateRuleReportListModel> list = tabAffiliateRuleReportListService.queryJoinTabAffiliateRule(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/save")
	public void add(TabAffiliateRuleReportList tabAffiliateRuleReportList,HttpServletResponse response,HttpServletRequest request){
		
		try {
			if(tabAffiliateRuleReportList.getId() == null){
				tabAffiliateRuleReportListService.add(tabAffiliateRuleReportList);	
				sendSuccessMessage(response, "添加成功");
			}else{
				tabAffiliateRuleReportListService.updateSelective(tabAffiliateRuleReportList);
				sendSuccessMessage(response, "修改成功");
			}
		} catch (DuplicateKeyException e) {
			sendFailureMessage(response, "规则代码不能重复");
		}
	}
	
	@RequestMapping("/delete")
	public void delete(Long id,HttpServletResponse response){
		
		tabAffiliateRuleReportListService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/getId")
	public void getId(Long affiliate_rule_id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		context.put(SUCCESS, true);
		context.put("data", tabAffiliateRuleReportListService.selectById(affiliate_rule_id));
		HtmlUtil.writerJson(response, context);
	}

}
