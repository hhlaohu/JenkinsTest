package com.yiya.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.bean.SysUser;
import com.yiya.bean.TabAffiliateRule;
import com.yiya.model.TabAffiliateRuleModel;
import com.yiya.service.SysUserService;
import com.yiya.service.TabAffiliateRuleService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月23日
 * @description
 */
@Controller
@RequestMapping("tabAffiliateRule")
public class TabAffiliateRuleAction extends BaseAction {

	@Autowired
	private TabAffiliateRuleService tabAffiliateRuleService;
	
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/list")
	public ModelAndView mapList(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		return forword("tabAffiliateRule/tabAffiliateRule", context);
	}

	@RequestMapping("/dataList")
	public void dataList(TabAffiliateRuleModel model, HttpServletResponse response) throws Exception {

		List<TabAffiliateRuleModel> list = tabAffiliateRuleService.queryByConditionAndPage(model);
		//显示添加人
		for(TabAffiliateRuleModel rule:list){
			SysUser user = sysUserService.queryById(rule.getAdd_usr_id());
			if(user != null){
				rule.setAdd_usr_name(user.getUsr_name());	
			}
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Integer total = tabAffiliateRuleService.queryTotal(model);
		jsonMap.put("total", total.intValue());
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/save")
	public void add(TabAffiliateRule tabAffiliateRule, HttpServletResponse response, HttpServletRequest request) {

		if (tabAffiliateRule.getAffiliate_rule_id() != null) {
			tabAffiliateRuleService.update(tabAffiliateRule);
			sendSuccessMessage(response, "修改成功");
		} else {
			tabAffiliateRule.setAdd_time(new Date());
			tabAffiliateRule.setAdd_usr_id(SessionUtils.getUser(request).getId().longValue());
			tabAffiliateRuleService.add(tabAffiliateRule);
			sendSuccessMessage(response, "保存成功");
		}
		sendSuccessMessage(response, "成功");
	}

	@RequestMapping("/delete")
	public void delete(Long affiliate_rule_id, HttpServletResponse response) {

		tabAffiliateRuleService.delete(affiliate_rule_id);
		sendSuccessMessage(response, "成功");
	}

	@RequestMapping("/getId")
	public void getId(Long affiliate_rule_id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		context.put(SUCCESS, true);
		context.put("data", tabAffiliateRuleService.selectById(affiliate_rule_id));
		HtmlUtil.writerJson(response, context);
	}

	@RequestMapping("getAllRules")
	@ResponseBody
	public List<TabAffiliateRuleModel> getAllRules() {
         
		return tabAffiliateRuleService.getAllRules();
	}

}
