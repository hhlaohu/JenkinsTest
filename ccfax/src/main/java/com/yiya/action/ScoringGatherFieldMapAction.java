package com.yiya.action;

import java.util.Date;
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

import com.yiya.bean.GatherType;
import com.yiya.bean.ScoringGatherField;
import com.yiya.bean.ScoringGatherFieldMap;
import com.yiya.bean.ScoringModelField;
import com.yiya.bean.SysUser;
import com.yiya.model.ScoringGatherFieldMapModel;
import com.yiya.service.GatherTypeService;
import com.yiya.service.ScoringConfigService;
import com.yiya.service.ScoringGatherFieldMapService;
import com.yiya.service.ScoringGatherFieldService;
import com.yiya.service.SysUserService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * @author frank_wang
 * @data 2016年11月10日
 * @description 模型与采集数据映射
 */
@Controller
@RequestMapping("/scoringGatherFieldMap")
public class ScoringGatherFieldMapAction extends BaseAction {

	@Autowired
	private ScoringGatherFieldMapService scoringGatherFieldMapService;

	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private ScoringGatherFieldService scoringGatherFieldService;
	
	@Autowired
	private GatherTypeService gatherTypeService;
	
	@Autowired
	private ScoringConfigService<ScoringModelField> scoringConfigService;
	
	@RequestMapping("/list")
	public ModelAndView mapList(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		List<GatherType> gatherTypeList = gatherTypeService.queryAll();
		context.put("gatherTypeList", gatherTypeList);
		List<ScoringModelField> scoringModelFieldList = scoringConfigService.listAllFields(null);
		context.put("scoringFieldList", scoringModelFieldList);
		List<ScoringGatherField> scoringGatherFieldList = scoringGatherFieldService.queryByCondition(null);
        context.put("scoringGatherFieldList",scoringGatherFieldList);		
		return forword("scoringGatherField/scoringGatherFieldMap", context);
	}
	
	@RequestMapping("/dataList")
	public void dataMapList(ScoringGatherFieldMapModel model, HttpServletResponse response) throws Exception {

		List<ScoringGatherFieldMapModel> list = scoringGatherFieldMapService.queryByCondition(model);
		for (ScoringGatherFieldMapModel tempModel : list) {
			if(tempModel.getAdd_usr_id() != null){
				SysUser user = sysUserService.queryById(tempModel.getAdd_usr_id());
				if(user != null){
					tempModel.setSys_usr_name(user.getReal_name());	
				}
			}
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		Integer count = scoringGatherFieldMapService.queryByCount(model);
		jsonMap.put("total", count);
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/save")
	public void saveScoringGatherFieldMap(ScoringGatherFieldMap bean, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		try {
			if (bean.getId() != null) {
				scoringGatherFieldMapService.update(bean);
				sendSuccessMessage(response, "修改成功");
			} else {
				bean.setAdd_time(new Date());
				bean.setAdd_usr_id(SessionUtils.getUser(request).getId());
				scoringGatherFieldMapService.add(bean);
				sendSuccessMessage(response, "保存成功");
			}
		} catch (DuplicateKeyException e) {
			sendFailureMessage(response, "无法建立该映射，因为该映射已经存在");
		}
	}

	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		ScoringGatherFieldMapModel model = new ScoringGatherFieldMapModel();
		model.setId(id);
		List<ScoringGatherFieldMapModel> list = scoringGatherFieldMapService.queryByCondition(model);

		if (list == null || list.size() == 0) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", list.get(0));
		HtmlUtil.writerJson(response, context);
	}

	@RequestMapping("/delete")
	public void deleteScoringGatherField(ScoringGatherFieldMapModel bean, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		scoringGatherFieldMapService.delete(bean.getId());
		sendSuccessMessage(response, "删除成功");
	}

}
