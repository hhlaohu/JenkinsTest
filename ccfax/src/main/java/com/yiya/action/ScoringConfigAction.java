package com.yiya.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.bean.AntiFraudModelRule;
import com.yiya.bean.AntiFraudModelValue;
import com.yiya.bean.BlackListBean;
import com.yiya.bean.DataDictionaryType;
import com.yiya.bean.DataDictionaryValue;
import com.yiya.bean.RuleSetQuotaBean;
import com.yiya.bean.ScoringModelField;
import com.yiya.bean.ScoringModelRule;
import com.yiya.bean.ScoringModelType;
import com.yiya.bean.ScoringModelValue;
import com.yiya.bean.ScoringRuleSet;
import com.yiya.bean.TabRuleSetType;
import com.yiya.bean.TabRuleType;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabAreaBean;
import com.yiya.model.DataParameterModel;
import com.yiya.model.ScoringConfigModel;
import com.yiya.service.DataManagerService;
import com.yiya.service.ScoringConfigService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

@Controller
@RequestMapping("scoringConfig")
public class ScoringConfigAction extends BaseAction{

	@Autowired(required = false) // 自动注入
	private ScoringConfigService<ScoringModelType> scoringConfigService;
	
	@Autowired(required=false)
	private  DataManagerService dataManagerService; 
	/**
	 * 菜单链接到评分模型字段分类页面
	 * @Title: list 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/modelTypePage") 
	public ModelAndView  list(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/scoringModelType",context); 
	}
	
	
	/**
	 * 字段分类列表
	 * @Title: dataList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/modelTypeList") 
	public void  dataList(ScoringConfigModel model,String search_field_type_name,HttpServletResponse response) throws Exception
	{	
		model.setField_type_name(search_field_type_name);
		List<ScoringModelType> dataList = scoringConfigService.queryByList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存字段类型
	 * @Title: save 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/save")
	public void save(ScoringModelType modelType ,HttpServletRequest request,HttpServletResponse response) 
	{
		if (StringUtils.isNotBlank(modelType.getField_type_name()) && modelType.getField_type_name().length() > 16)
		{
			sendFailureMessage(response, "字段类型名长度超过16");
			return;
		}
		if (StringUtils.isNotBlank(modelType.getField_type_desc()) && modelType.getField_type_desc().length() > 64)
		{
			sendFailureMessage(response, "字段描述长度超过64");
			return;
		}
		
		try
		{
			if (modelType.getField_type_id() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				modelType.setAdd_usr_id(user.getId());
				
				scoringConfigService.add(modelType);
			}	
			else
			{
				scoringConfigService.update(modelType);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除字段类型
	 * @Title: delete 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param field_type_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/delete")
	public void delete(Integer field_type_id ,HttpServletResponse response) 
	{
		try
		{
			//先删除类型对应的字段
			scoringConfigService.deleteFieldByType(field_type_id);
			
			//再删除类型
			scoringConfigService.delete(field_type_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	/**
	 * 判断字段是枚举，列出字段对应字典类型的字典值
	 * @Title: getFieldsInfo 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param scoring_field_id
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getFieldsInfo") 
	public void  getFieldsInfo(Integer scoring_field_id,DataParameterModel model,HttpServletResponse response) throws Exception{
		//查询字段信息
		ScoringModelField fieldInfo = scoringConfigService.queryFieldById(scoring_field_id);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if ( null != fieldInfo)
		{
			//判断是枚举类型
			if (fieldInfo.getField_value_type() == 3)
			{
				Integer dictionary_type_id = fieldInfo.getDictionary_type_id();
				
				//获取字段类型
				DataDictionaryType ddt = dataManagerService.findDDTById(dictionary_type_id);
				if ( null != ddt)
				{
					jsonMap.put("is_relational_table", ddt.getIs_relational_table());
					//不关联外表
					if (ddt.getIs_relational_table() == 0)
					{
						//根据字典类型查询字典Value列表
						model.setDictionary_type_id(dictionary_type_id);
						List<DataDictionaryValue> dataList = dataManagerService.queryDDVList(model);
						jsonMap.put("dictionaryValueList", dataList);
					}
					if (ddt.getIs_relational_table() == 1)
					{
						String relational_table_name = ddt.getRelational_table_name();//关联表名
						if ("tab_area".equals(relational_table_name))
						{
							Map<String, Object> param = new HashMap<String,Object>();
							param.put("area_deep", 1);//查询省列表
							List<TabAreaBean> provinceList = scoringConfigService.queryAreaList(param);
							jsonMap.put("provinceList", provinceList);
						}
					}
				}	
			}
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 获取省市区级联下拉框
	 * @Title: getAreaSelectData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getAreaSelectData") 
	public void  getAreaSelectData(Integer area_parent_id,Integer area_deep,HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("area_parent_id", area_parent_id);
		param.put("area_deep", area_deep);//area_deep:2市，3区
		List<TabAreaBean> selectList = scoringConfigService.queryAreaList(param);
		HtmlUtil.writerJson(response, selectList);
	}
	
	
	/**
	 * 设置字段跳转到评分字段
	 * @Title: listField 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/modelFieldPage") 
	public ModelAndView listField(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		//字段类型下拉框
		List<ScoringModelType> dataList = scoringConfigService.listAll(model);
		context.put("modelTypeList", dataList);
		
		//组合字段下拉框
		List<ScoringModelField> modelFieldList = scoringConfigService.listFields(model);
		context.put("modelFieldList", modelFieldList);
		
		return forword("scoring/scoringModelField",context); 
	}
	
	
	/**
	 * 字段下拉项
	 * @Title: getFieldsData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getFieldsData") 
	public void  getFieldsData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//字段下拉框(浮点和整型)
		List<ScoringModelField> modelFieldList = scoringConfigService.listFields(model);
		HtmlUtil.writerJson(response, modelFieldList);
	}
	
	@RequestMapping("/getAllFieldsData") 
	public void  getAllFieldsData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//所有字段下拉框
		List<ScoringModelField> modelFieldList = scoringConfigService.listAllFields(model);
		HtmlUtil.writerJson(response, modelFieldList);
	}
	
	@RequestMapping("/getFieldTypeData") 
	public void  getFieldTypeData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//字段类型下拉框
		List<ScoringModelType> modelTypeList = scoringConfigService.listAll(model);
		HtmlUtil.writerJson(response, modelTypeList);
	}
	/**
	 * 字段列表
	 * @Title: modelFieldList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_field_name
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/modelFieldList") 
	public void  modelFieldList(ScoringConfigModel model,String search_field_name,HttpServletResponse response) throws Exception
	{	
		model.setField_name(search_field_name);
		List<ScoringModelField> dataList = scoringConfigService.queryModelFieldList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * 保存模型字段
	 * @Title: saveField 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param modelField
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveField")
	public void saveField(ScoringModelField modelField ,ScoringConfigModel model,String field_name_temp,HttpServletRequest request,HttpServletResponse response) 
	{
		if (StringUtils.isNotBlank(modelField.getField_name()) && modelField.getField_name().length() > 64)
		{
			sendFailureMessage(response, "字段名长度超过64");
			return;
		}
		if (StringUtils.isNotBlank(modelField.getField_desc()) && modelField.getField_desc().length() > 512)
		{
			sendFailureMessage(response, "字段描述长度超过512");
			return;
		}
		
		try
		{
			model.setField_type_id(null);
			//不管类型，判断添加重复字段(修改字段名时，如果字段名没变,则不校验)
			if (!field_name_temp.equals(model.getField_name()))
			{
				int count = scoringConfigService.queryModelFieldCount(model);
				if (count > 0)
				{
					sendFailureMessage(response, "该字段已添加~~");
					return;
				}
			}
	
			
			//前台传+特殊字符接收不到，转换接收
			if ( modelField.getCombined_operate().equals("1"))
			{
				modelField.setCombined_operate("+");
			}
			if (modelField.getScoring_field_id() == null)
			{
				
				
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				modelField.setAdd_usr_id(user.getId());
				modelField.setField_value_ini("0");//字段默认值
				
				scoringConfigService.addModelField(modelField);
			}	
			else
			{
				scoringConfigService.updateModelField(modelField);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除字段
	 * @Title: deleteField 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param scoring_field_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteField")
	public void deleteField(Integer scoring_field_id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteModelField(scoring_field_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 链接到规则集页面
	 * @Title: modelRuleSetPage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/modelRuleSetPage") 
	public ModelAndView  modelRuleSetPage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/scoringRuleSet",context); 
	}
	
	/**
	 * 规则集列表
	 * @Title: RuleSetList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param set_name
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/ruleSetList") 
	public void  RuleSetList(ScoringConfigModel model,String set_name,HttpServletResponse response) throws Exception
	{	
		model.setRule_set_name(set_name);
		List<ScoringRuleSet> dataList = scoringConfigService.queryRuleSetList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getRuleSetData") 
	public void  getRuleSetData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//组合字段下拉框
		List<ScoringRuleSet> modelFieldList = scoringConfigService.listAllRuleSet(model);
		HtmlUtil.writerJson(response, modelFieldList);
	}
	
	@RequestMapping("/getRuleSetType") 
	public void  getRuleSetType(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//组合字段下拉框
		List<TabRuleSetType> ruleSetTypeList = scoringConfigService.listRuleSetType(model);
		HtmlUtil.writerJson(response, ruleSetTypeList);
	}
	
	/**
	 * 保存规则集
	 * @Title: saveRuleSet 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param ruleSet
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveRuleSet")
	public void saveRuleSet(ScoringRuleSet ruleSet ,HttpServletRequest request,HttpServletResponse response) 
	{
		if (StringUtils.isNotBlank(ruleSet.getRule_set_name()) && ruleSet.getRule_set_name().length() > 64)
		{
			sendFailureMessage(response, "规则集名称长度超过64");
			return;
		}
		try
		{
			if ( ruleSet.getRule_set_id() == null)
			{
				Map<String, Object> param = new HashMap<String,Object>();
				param.put("upper_amount", ruleSet.getUpper_amount());
				param.put("lower_amount", ruleSet.getLower_amount());
				//判断左边界值
				int left = scoringConfigService.findLeftCount(param);
				if ( left > 0)
				{
					sendFailureMessage(response, "金额下限与其他下限值交集");
					return;
				}	
				//判断右边界值
				int right = scoringConfigService.findRightCount(param);
				if ( right > 0)
				{
					sendFailureMessage(response, "金额上限与其他上限值交集");
					return;
				}
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				ruleSet.setAdd_usr_id(user.getId());
				scoringConfigService.addRuleSet(ruleSet);
			}	
			else
			{
				Map<String, Object> param = new HashMap<String,Object>();
				param.put("upper_amount", ruleSet.getUpper_amount());
				param.put("lower_amount", ruleSet.getLower_amount());
				param.put("rule_set_id", ruleSet.getRule_set_id());
				//判断左边界值，排除当前记录
				int left = scoringConfigService.findLeftCountByMap(param);
				if ( left > 0)
				{
					sendFailureMessage(response, "金额下限与其他下限值交集");
					return;
				}	
				
				//判断右边界值，排除当前记录
				int right = scoringConfigService.findRightCountByMap(param);
				if ( right > 0)
				{
					sendFailureMessage(response, "金额上限与其他上限值交集");
					return;
				}
				
				scoringConfigService.updateRuleSet(ruleSet);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除规则集
	 * @Title: deleteRuleSet 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param rule_set_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteRuleSet")
	public void deleteRuleSet(Integer rule_set_id ,HttpServletResponse response) 
	{
		try
		{
			//删除规则集下的规则,反欺诈规则
			scoringConfigService.deleteRuleBySet(rule_set_id);
			scoringConfigService.deleteFraudRuleBySet(rule_set_id);
			
			scoringConfigService.deleteRuleSet(rule_set_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	/**
	 * 评分模型规则页面
	 * @Title: modelRulePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/modelRulePage") 
	public ModelAndView  modelRulePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/scoringModelRule",context); 
	}
	
	@RequestMapping("/getRulesData") 
	public void  getRulesData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//规则下拉框
		List<ScoringModelRule> modelRuleList = scoringConfigService.listAllRules(model);
		HtmlUtil.writerJson(response, modelRuleList);
	}
	
	/**
	 * 模型规则列表
	 * @Title: modelRuleList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_field_name
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/modelRuleList") 
	public void  modelRuleList(ScoringConfigModel model,String search_rule_name,HttpServletResponse response) throws Exception
	{	
		if (null == model.getIs_active())
		{
			model.setIs_active(1);//默认查询激活状态
		}
		model.setRule_name(search_rule_name);
		List<ScoringModelRule> dataList = scoringConfigService.queryModelRuleList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 模型规则列表
	 * @Title: modelRuleList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_field_name
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/quotaValueList") 
	public void  quotaValueList(ScoringConfigModel model,String search_rule_name,HttpServletResponse response) throws Exception
	{	
		List<RuleSetQuotaBean> dataList = scoringConfigService.queryQuotaList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存模型规则
	 * @Title: saveModelRule 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param modelRule
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveModelRule")
	public void saveModelRule(ScoringModelRule modelRule ,HttpServletRequest request,HttpServletResponse response) 
	{
		if (StringUtils.isNotBlank(modelRule.getRule_name()) && modelRule.getRule_name().length() > 64)
		{
			sendFailureMessage(response, "规则名长度超过64");
			return;
		}
		if (StringUtils.isNotBlank(modelRule.getRule_code()) && modelRule.getRule_code().length() > 32)
		{
			sendFailureMessage(response, "规则代码长度超过32");
			return;
		}
		if (StringUtils.isNotBlank(modelRule.getRule_desc()) && modelRule.getRule_desc().length() > 128)
		{
			sendFailureMessage(response, "规则描述长度超过128");
			return;
		}
		try
		{
			if ( modelRule.getScoring_rule_id() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				modelRule.setAdd_usr_id(user.getId());
				modelRule.setIs_active(1);//默认为激活
				scoringConfigService.addModelRule(modelRule);
			}	
			else
			{
				scoringConfigService.updateModelRule(modelRule);
				if (modelRule.getScore_value() > 0) {
					scoringConfigService.updateScoringValue(modelRule.getScoring_rule_id());
				}
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	@RequestMapping("/saveQuotaValue")
	public void saveQuotaValue(Integer quota_id, Integer rule_set_id, String min_quota, String max_quota,String min_score,String max_score, HttpServletRequest request,HttpServletResponse response) 
	{
		RuleSetQuotaBean ruleSetQuotaBean = new RuleSetQuotaBean();
		try {
			float f = Float.parseFloat(min_quota);
		} catch (NumberFormatException e) {
			// 请输入正确的额度最小值
			sendFailureMessage(response, "请输入正确的额度最小值");
			return ;
		}
		try {
			float f = Float.parseFloat(max_quota);
		} catch (NumberFormatException e) {
			// 请输入正确的额度最小值
			sendFailureMessage(response, "请输入正确的额度最大值");
			return ;
		}
		try {
			float f = Float.parseFloat(min_score);
		} catch (NumberFormatException e) {
			// 请输入正确的额度最小值
			sendFailureMessage(response, "请输入正确的得分最小值");
			return ;
		}
		try {
			float f = Float.parseFloat(max_score);
		} catch (NumberFormatException e) {
			// 请输入正确的额度最小值
			sendFailureMessage(response, "请输入正确的得分最大值");
			return ;
		}
		ruleSetQuotaBean.setQuota_id(quota_id);
		ruleSetQuotaBean.setRule_set_id(rule_set_id);
		ruleSetQuotaBean.setMax_quota(Float.parseFloat(max_quota));
		ruleSetQuotaBean.setMax_score(Float.parseFloat(max_score));
		ruleSetQuotaBean.setMin_score(Float.parseFloat(min_score));
		ruleSetQuotaBean.setMin_quota(Float.parseFloat(min_quota));
		try
		{
			if (ruleSetQuotaBean.getQuota_id() == 0)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				ruleSetQuotaBean.setAdd_usr_id(user.getId());
				ruleSetQuotaBean.setAdd_time(new Date());
				scoringConfigService.addQuotaValue(ruleSetQuotaBean);
			}	
			else
			{
				scoringConfigService.updateQuotaValue(ruleSetQuotaBean);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除模型规则
	 * @Title: deleteModelRule 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param scoring_rule_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteModelRule")
	public void deleteModelRule(Integer scoring_rule_id ,HttpServletResponse response) 
	{
		try
		{
			//删除评分规则下的模型value
			scoringConfigService.deleteByModelRule(scoring_rule_id);
			
			scoringConfigService.deleteModelRule(scoring_rule_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 评分模型value
	 * @Title: modelValueRule 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/modelValuePage") 
	public ModelAndView  modelValuePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		//规则下拉框
		List<ScoringModelRule> modelRuleList = scoringConfigService.listAllRules(model);
		//字段下拉框
		List<ScoringModelField> modelFieldList = scoringConfigService.listFields(model);
		context.put("modelRuleList", modelRuleList);
		context.put("modelFieldList", modelFieldList);
		return forword("scoring/scoringModelValue",context); 
	}
	
	/**
	 *评分模型value列表
	 * @Title: modelValueList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_field_id
	 * @param @param search_rule_id
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/modelValueList") 
	public void  modelValueList(ScoringConfigModel model ,Integer search_field_id,Integer search_rule_id,HttpServletResponse response) throws Exception
	{	
		model.setScoring_field_id(search_field_id);
		model.setScoring_rule_id(search_rule_id);
		List<ScoringModelValue> dataList = scoringConfigService.queryModelValueList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存评分模型value
	 * @Title: saveModelValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param modelValue
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveModelValue")
	public void saveModelValue(ScoringModelValue modelValue ,HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			if ( modelValue.getScore_id() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				modelValue.setAdd_usr_id(user.getId());
				scoringConfigService.addModelValue(modelValue);
			}	
			else
			{
				scoringConfigService.updateModelValue(modelValue);
			}
			
			if (modelValue.getScore_value() > 0) {
				int scoring_rule_id = modelValue.getScoring_rule_id();
				scoringConfigService.updateScoringRule(scoring_rule_id);
			}
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	
	/**
	 * 删除评分模型value
	 * @Title: deleteModelValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param score_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteModelValue")
	public void deleteModelValue(Integer score_id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteModelValue(score_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	@RequestMapping("/deleteQuotaValue")
	public void deleteQuotaValue(Integer quota_id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteQuotaValue(quota_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 链接反欺诈规则页面
	 * @Title: antiFraudRulePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/antiFraudRulePage") 
	public ModelAndView antiFraudRulePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/antiFraudModelRule",context); 
	}
	
	/**
	 * 反欺诈规则列表
	 * @Title: antiFraudRuleList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_rule_name
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/antiFraudRuleList") 
	public void  antiFraudRuleList(ScoringConfigModel model ,String search_rule_name,HttpServletResponse response) throws Exception
	{	
		if (null == model.getIs_active())
		{
			model.setIs_active(1);//默认查询激活状态
		}
		model.setRule_name(search_rule_name);
		List<AntiFraudModelRule> dataList = scoringConfigService.queryAntiFraudRuleList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存反欺诈规则
	 * @Title: saveAntiFraudRule 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param antiFraudRule
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveAntiFraudRule")
	public void saveAntiFraudRule(AntiFraudModelRule antiFraudRule ,HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			if ( antiFraudRule.getAnti_fraud_rule_id() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				antiFraudRule.setAdd_usr_id(user.getId());
				antiFraudRule.setIs_active(1);//激活状态
				scoringConfigService.addAntiFraudRule(antiFraudRule);
			}	
			else
			{
				scoringConfigService.updateAntiFraudRule(antiFraudRule);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除反欺诈规则
	 * @Title: deleteAntiFraudRule 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param anti_fraud_rule_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteAntiFraudRule")
	public void deleteAntiFraudRule(Integer anti_fraud_rule_id ,HttpServletResponse response) 
	{
		try
		{
			//删除反欺诈规则下的模型value
			scoringConfigService.deleteByAntiFraudRule(anti_fraud_rule_id);
			
			scoringConfigService.deleteAntiFraudRule(anti_fraud_rule_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 链接到反欺诈模型value页面
	 * @Title: antiFraudValuePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/antiFraudValuePage") 
	public ModelAndView antiFraudValuePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		//反欺诈规则下拉框
		List<AntiFraudModelRule> antiFraudRuleList = scoringConfigService.listAntiFraudRule(model);
		//字段下拉框
		List<ScoringModelField> modelFieldList = scoringConfigService.listFields(model);
		context.put("antiFraudRuleList", antiFraudRuleList);
		context.put("modelFieldList", modelFieldList);
		return forword("scoring/antiFraudModelValue",context); 
	}
	
	/**
	 * 获取反欺诈规则下拉框
	 * @Title: getAntiFraudRulesData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getAntiFraudRulesData") 
	public void getAntiFraudRulesData(ScoringConfigModel model,HttpServletResponse response) throws Exception
	{
		//反欺诈规则下拉框
		List<AntiFraudModelRule> antiFraudRuleList = scoringConfigService.listAntiFraudRule(model);
		HtmlUtil.writerJson(response, antiFraudRuleList);
	}
	

	/**
	 * 反欺诈模型value列表
	 * @Title: antiFraudValueList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/antiFraudValueList") 
	public void  antiFraudValueList(ScoringConfigModel model,Integer search_field_id,Integer search_rule_id,HttpServletResponse response) throws Exception
	{	
		model.setAnti_fraud_rule_id(search_rule_id);
		model.setScoring_field_id(search_field_id);
		List<AntiFraudModelValue> dataList = scoringConfigService.queryAntiFraudValueList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存反欺诈模型value
	 * @Title: saveAntiFraudValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param antiFraudValue
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveAntiFraudValue")
	public void saveAntiFraudValue(AntiFraudModelValue antiFraudValue ,HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			if ( antiFraudValue.getAnti_fraud_id() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				antiFraudValue.setAdd_usr_id(user.getId());
				scoringConfigService.addAntiFraudValue(antiFraudValue);
			}	
			else
			{
				scoringConfigService.updateAntiFraudValue(antiFraudValue);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除反欺诈模型value
	 * @Title: deleteAntiFraudValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param anti_fraud_id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteAntiFraudValue")
	public void deleteAntiFraudValue(Integer anti_fraud_id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteAntiFraudValue(anti_fraud_id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 链接黑名单类型页面
	 * @Title: blacklistTypePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/blacklistTypePage") 
	public ModelAndView blacklistTypePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/blacklistType",context); 
	}
	
	
	@RequestMapping("/getBlacklistTypeData") 
	public void getBlacklistTypeData(ScoringConfigModel model,HttpServletResponse response) throws Exception
	{
		//黑名单下拉框
		List<BlackListBean> antiFraudRuleList = scoringConfigService.listBlackListType(model);
		HtmlUtil.writerJson(response, antiFraudRuleList);
	}	
	/**
	 * 黑名单类型列表
	 * @Title: blacklistTypeList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_blacklist_type
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/blacklistTypeList") 
	public void  blacklistTypeList(ScoringConfigModel model ,String search_blacklist_type,HttpServletResponse response) throws Exception
	{	
		model.setBlacklist_type(search_blacklist_type);
		List<BlackListBean> dataList = scoringConfigService.queryBlackListTypeList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存黑名单类型
	 * @Title: saveBlacklistType 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param backlist
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveBlacklistType")
	public void saveBlacklistType(BlackListBean blacklist ,HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			if ( blacklist.getId() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				blacklist.setAdd_usr_id(user.getId());
				scoringConfigService.addBlackListType(blacklist);
			}	
			else
			{
				scoringConfigService.updateBlackListType(blacklist);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除黑名单类型
	 * @Title: deleteBlacklistType 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteBlacklistType")
	public void deleteBlacklistType(Integer id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteBlackListByType(id);//删除黑名单类型下的黑名单
			
			scoringConfigService.deleteBlackListType(id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	
	/**
	 * 链接黑名单值页面
	 * @Title: blacklistValuePage 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/blacklistValuePage") 
	public ModelAndView blacklistValuePage(ScoringConfigModel model,HttpServletRequest request) throws Exception
	{
		Map<String,Object>  context = getRootMap();
		
		return forword("scoring/blacklistValue",context); 
	}
	
	/**
	 * 黑名单列表
	 * @Title: blacklistTypeValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param search_blacklist_type
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/blacklistTypeValue") 
	public void  blacklistTypeValue(ScoringConfigModel model ,String search_blacklist_value,HttpServletResponse response) throws Exception
	{	
		if ( null == model.getIs_active())
		{
			model.setIs_active(1);//默认查询激活
		}
		model.setBlacklist_value(search_blacklist_value);;
		List<BlackListBean> dataList = scoringConfigService.queryBlackListValueList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 保存黑名单
	 * @Title: saveBlacklistValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param backlist
	 * @param @param request
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/saveBlacklistValue")
	public void saveBlacklistValue(BlackListBean blacklist ,HttpServletRequest request,HttpServletResponse response) 
	{
		try
		{
			if ( blacklist.getId() == null)
			{
				//管理员id
				SysUser user = SessionUtils.getUser(request);
				blacklist.setAdd_usr_id(user.getId());
				blacklist.setIs_active(1);//默认激活
				scoringConfigService.addBlackListValue(blacklist);
			}	
			else
			{
				scoringConfigService.updateBlackListValue(blacklist);
			}
			
			sendSuccessMessage(response, "保存成功~");
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
	}
	
	/**
	 * 删除黑名单
	 * @Title: deleteBlacklistValue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param id
	 * @param @param response 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/deleteBlacklistValue")
	public void deleteBlacklistValue(Integer id ,HttpServletResponse response) 
	{
		try
		{
			scoringConfigService.deleteBlackListValue(id);
		}
		catch(Exception e)
		{
			sendFailureMessage(response, e.getMessage());
		}
		sendSuccessMessage(response, "删除成功~");
	}
	
	/**
	 * 数据字典类型下拉框
	 * @Title: getDictionaryTypeData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getDictionaryTypeData") 
	public void  getDictionaryTypeData(HttpServletResponse response) throws Exception{
		//组合字段下拉框
		List<DataDictionaryType> dictionaryTypeList = dataManagerService.findTypeList();
		HtmlUtil.writerJson(response, dictionaryTypeList);
	}
	
	/**
	 * 获取数据字典value的键值
	 * @Title: findDDVById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param dictionary_value_id
	 * @param @param request
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getKeyValue") 
	public void getKeyValue(Integer dictionary_value_id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if ( null != dictionary_value_id)
		{
			DataDictionaryValue ddv = dataManagerService.findDDVById(dictionary_value_id);
			if ( null != ddv )
			{
				jsonMap.put("result", ddv);
			}
		}	
	
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * 获取所有的规则业务分类
	 * @Title: getRuleTypeData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getRuleTypeData") 
	public void  getRuleTypeData(ScoringConfigModel model,HttpServletResponse response) throws Exception{
		//组合字段下拉框
		List<TabRuleType> ruleTypeList = scoringConfigService.listAllRuleType(model);
		HtmlUtil.writerJson(response, ruleTypeList);
	}
}
