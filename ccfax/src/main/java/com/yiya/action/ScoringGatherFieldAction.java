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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.bean.GatherType;
import com.yiya.bean.ScoringGatherField;
import com.yiya.bean.SysUser;
import com.yiya.model.ScoringGatherFieldModel;
import com.yiya.service.GatherTypeService;
import com.yiya.service.ScoringGatherFieldService;
import com.yiya.service.SysUserService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * @author frank_wang
 * @data 2016年11月3日
 * @description 第三方数据字段管理
 */
@Controller
@RequestMapping("/scoringGatherField")
public class ScoringGatherFieldAction extends BaseAction {

	@Autowired
	private ScoringGatherFieldService scoringGatherFieldService;

	@Autowired
	private GatherTypeService gatherTypeService;
	
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/list")
	public ModelAndView fieldManager(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		List<GatherType> gatherTypeList = gatherTypeService.queryAll();
		context.put("gatherTypeList", gatherTypeList);
		return forword("scoringGatherField/scoringGatherField", context);
	}

	@RequestMapping("/dataList")
	public void dataList(ScoringGatherFieldModel model, HttpServletResponse response) throws Exception {

		//默认查询全部,查询sql中判断参数不为空&&不为9时，则带Is_enable查询
		if (model.getIs_enable() == null)
		{
			model.setIs_enable(9);
		}
		List<ScoringGatherFieldModel> list = scoringGatherFieldService.queryJoinScoringTypeTable(model);
		for (ScoringGatherFieldModel tempModel : list) {
			if(tempModel.getAdd_usr_id() != null){
				SysUser user = sysUserService.queryById(tempModel.getAdd_usr_id());
				if(user != null){
					tempModel.setSys_usr_name(user.getReal_name());	
				}				
			}
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		Integer count = scoringGatherFieldService.queryByCount(model);
		jsonMap.put("total", count);
		jsonMap.put("rows", list);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/queryByCondition")
	@ResponseBody
	public List<ScoringGatherField> queryByCondition(ScoringGatherFieldModel model) throws Exception {
        if(0 == model.getGather_type_id().intValue()){
        	model.setGather_type_id(null);
        }
		List<ScoringGatherField> list = scoringGatherFieldService.queryByCondition(model);
		return list;
	}

	@RequestMapping("/save")
	public void saveScoringGatherField(ScoringGatherField bean, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		try {
			if (bean.getGather_field_id() != null) {
				scoringGatherFieldService.update(bean);
				sendSuccessMessage(response, "修改成功");
			} else {
				bean.setAdd_time(new Date());
				bean.setAdd_usr_id(SessionUtils.getUser(request).getId());
				scoringGatherFieldService.add(bean);
				sendSuccessMessage(response, "保存成功");
			}
		} catch (DuplicateKeyException e) {
			sendFailureMessage(response, "字段名字不能重复");
		}
	}

	@RequestMapping("/getId")
	public void getId(Long gather_field_id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		ScoringGatherFieldModel model = new ScoringGatherFieldModel();
		model.setGather_field_id(gather_field_id);
		List<ScoringGatherField> list = scoringGatherFieldService.queryByCondition(model);

		if (list == null || list.size() == 0) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", list.get(0));
		HtmlUtil.writerJson(response, context);
	}

	@RequestMapping("/delete")
	public void deleteScoringGatherField(ScoringGatherField bean, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		scoringGatherFieldService.delete(bean.getGather_field_id());
		sendSuccessMessage(response, "删除成功");
	}
	
	

}
