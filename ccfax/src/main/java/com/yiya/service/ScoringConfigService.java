package com.yiya.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.AntiFraudModelRule;
import com.yiya.bean.AntiFraudModelValue;
import com.yiya.bean.BlackListBean;
import com.yiya.bean.RuleSetQuotaBean;
import com.yiya.bean.ScoringModelField;
import com.yiya.bean.ScoringModelRule;
import com.yiya.bean.ScoringModelType;
import com.yiya.bean.ScoringModelValue;
import com.yiya.bean.ScoringRuleSet;
import com.yiya.bean.TabAreaBean;
import com.yiya.bean.TabRuleSetType;
import com.yiya.bean.TabRuleType;
import com.yiya.mapper.ScoringConfigMapper;
import com.yiya.model.BaseModel;

/**
 * @author Administrator
 * @data 2016年10月9日
 * @description
 */
@Service("scoringConfigService")
public class ScoringConfigService<T> extends BaseService<T> {

	@Autowired
    private ScoringConfigMapper<T> mapper;
  
	@Override
	public ScoringConfigMapper<T> getMapper() {
		return mapper;
	}
	
	//查询所有字段类型
	public List<ScoringModelType> listAll(BaseModel model)
	{
		return mapper.listAll(model);
	}
	
	//查询所有字段(浮点型和整型)
	public List<ScoringModelField> listFields(BaseModel model)
	{
		return mapper.listFields(model);
	}
	
	public List<ScoringModelField> listAllFields(BaseModel model)
	{
		return mapper.listAllFields(model);
	}
	//所有规则集
	public List<ScoringRuleSet> listAllRuleSet(BaseModel model)
	{
		return mapper.listAllRuleSet(model);
	}
	
	//查询规则业务分类
	public List<TabRuleType> listAllRuleType(BaseModel model)
	{
		return mapper.listAllRuleType(model);
	}
	
	//查询规则集业务分类
	public List<TabRuleSetType> listRuleSetType(BaseModel model)
	{
		return mapper.listRuleSetType(model);
	}
	
	//查询所有规则
	public List<ScoringModelRule> listAllRules(BaseModel model)
	{
		return mapper.listAllRules(model);
	}
	
	//查询所有反欺诈规则
	public List<AntiFraudModelRule> listAntiFraudRule(BaseModel model)
	{
		return mapper.listAntiFraudRule(model);
	}
	
	//查询所有黑名单类型
	public List<BlackListBean> listBlackListType(BaseModel model)
	{
		return mapper.listBlackListType(model);
	}
	
	//查询字段列表
	public List<ScoringModelField> queryModelFieldList(BaseModel model)
	{
		Integer rowCount = queryModelFieldCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryModelFieldList(model);
	}
	
	
	//查询字段列表总数
	public int queryModelFieldCount(BaseModel model)
	{
		return mapper.queryModelFieldCount(model);
	}
	
	//对模型字段的增，删，改
	public void addModelField(ScoringModelField t)
	{
		mapper.addModelField(t);
	}
	
	public void updateModelField(ScoringModelField t)
	{
		mapper.updateModelField(t);
	}
	
	public void deleteModelField(Integer id)
	{
		mapper.deleteModelField(id);
	}
	
	public ScoringModelField queryFieldById(Integer id)
	{
		return mapper.queryFieldById(id);
	}
	
	//删除字段类型对应的字段
	public void deleteFieldByType(Integer field_type_id)
	{
		mapper.deleteFieldByType(field_type_id);
	}
	
	
	//查询评分规则列表
	public List<ScoringModelRule> queryModelRuleList(BaseModel model)
	{
		Integer rowCount = queryModelRuleCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryModelRuleList(model);
	}
	
	public List<RuleSetQuotaBean> queryQuotaList(BaseModel model)
	{
		Integer rowCount = queryQuotaCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryQuotaList(model);
	}
	
	
	//查询评分规则列表总数
	public int queryModelRuleCount(BaseModel model)
	{
		return mapper.queryModelRuleCount(model);
	}
	
	public int queryQuotaCount(BaseModel model)
	{
		return mapper.queryQuotaCount(model);
	}
	
	//对评分规则的增，删，改
	public void addModelRule(ScoringModelRule t)
	{
		mapper.addModelRule(t);
	}
	
	public void updateModelRule(ScoringModelRule t)
	{
		mapper.updateModelRule(t);
	}
	
	public void deleteModelRule(Integer id)
	{
		mapper.deleteModelRule(id);
	}
	
	/**
	 *规则集管理 
	 */
	public List<ScoringRuleSet> queryRuleSetList(BaseModel model)
	{
		Integer rowCount = queryRuleSetCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryRuleSetList(model);
	}
	public int queryRuleSetCount(BaseModel model)
	{
		return mapper.queryRuleSetCount(model);
	}
	public void addRuleSet(ScoringRuleSet ruleSet)
	{
		mapper.addRuleSet(ruleSet);
	}
	public void updateRuleSet(ScoringRuleSet ruleSet)
	{
		mapper.updateRuleSet(ruleSet);
	}
	public void deleteRuleSet(Integer id)
	{
		mapper.deleteRuleSet(id);
	}
	//删除规则集下面的规则
	public void deleteRuleBySet(Integer ruleSetId)
	{
		mapper.deleteRuleBySet(ruleSetId);
	}
	
	/**
	 * 规则value管理
	 */
	public  List<ScoringModelValue> queryModelValueList(BaseModel model)
	{
		Integer rowCount = queryModelValueCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryModelValueList(model);
	}
	public int queryModelValueCount(BaseModel model)
	{
		return mapper.queryModelValueCount(model);
	}
	public void addModelValue(ScoringModelValue modelValue)
	{
		mapper.addModelValue(modelValue);
	}
	public void updateModelValue(ScoringModelValue modelValue)
	{
		mapper.updateModelValue(modelValue);
	}
	public void deleteModelValue(Integer id)
	{
		mapper.deleteModelValue(id);
	}
	public void deleteByModelRule(Integer scoring_rule_id)
	{
		mapper.deleteByModelRule(scoring_rule_id);
	}
	
	public void deleteFraudRuleBySet(Integer ruleSetId)
	{
		mapper.deleteFraudRuleBySet(ruleSetId);
	}
	
	/**
	 * 反欺诈规则管理
	 */
	public List<AntiFraudModelRule> queryAntiFraudRuleList(BaseModel model)
	{
		Integer rowCount = queryAntiFraudRuleCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryAntiFraudRuleList(model);
	}
	public int queryAntiFraudRuleCount(BaseModel model)
	{
		return mapper.queryAntiFraudRuleCount(model);
	}
	public void addAntiFraudRule(AntiFraudModelRule t)
	{
		mapper.addAntiFraudRule(t);
	}
	public void updateAntiFraudRule(AntiFraudModelRule t)
	{
		mapper.updateAntiFraudRule(t);
	}
	public void deleteAntiFraudRule(Integer id)
	{
		mapper.deleteAntiFraudRule(id);
	}
	
	
	
	/**
	 * 反欺诈规则value管理
	 */
	public List<AntiFraudModelValue> queryAntiFraudValueList(BaseModel model)
	{
		Integer rowCount = queryAntiFraudValueCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryAntiFraudValueList(model);
	}
	public int queryAntiFraudValueCount(BaseModel model)
	{
		return mapper.queryAntiFraudValueCount(model);
	}	
	public void addAntiFraudValue(AntiFraudModelValue antiFraudModeValue)
	{
		mapper.addAntiFraudValue(antiFraudModeValue);
	}	
	public void updateAntiFraudValue(AntiFraudModelValue antiFraudModeValue)
	{
		mapper.updateAntiFraudValue(antiFraudModeValue);
	}	
	public void deleteAntiFraudValue(Integer id)
	{
		mapper.deleteAntiFraudValue(id);
	}
	public void deleteByAntiFraudRule(Integer anti_fraud_rule_id)
	{
		mapper.deleteByAntiFraudRule(anti_fraud_rule_id);
	}
	
	
	/**
	 * 黑名单类型管理
	 */
	public  List<BlackListBean> queryBlackListTypeList(BaseModel model)
	{
		Integer rowCount = queryBlackListTypeCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryBlackListTypeList(model);
	}
	public int queryBlackListTypeCount(BaseModel model)
	{
		return mapper.queryBlackListTypeCount(model);
	}	
	public void addBlackListType(BlackListBean blcakList)
	{
		mapper.addBlackListType(blcakList);
	}	
	public void updateBlackListType(BlackListBean blcakList)
	{
		mapper.updateBlackListType(blcakList);
	}	
	public void deleteBlackListType(Integer id)
	{
		mapper.deleteBlackListType(id);
	}	
	public void deleteBlackListByType(Integer typeId)
	{
		mapper.deleteBlackListByType(typeId);
	}	
	
	/**
	 * 黑名单管理
	 */
	public List<BlackListBean> queryBlackListValueList(BaseModel model)
	{
		Integer rowCount = queryBlackListValueCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryBlackListValueList(model);
	}	
	public int queryBlackListValueCount(BaseModel model)
	{
		return  mapper.queryBlackListValueCount(model);
	}	
	public void addBlackListValue(BlackListBean blcakList)
	{
		mapper.addBlackListValue(blcakList);
	}	
	public void updateBlackListValue(BlackListBean blcakList)
	{
		mapper.updateBlackListValue(blcakList);
	}	
	public void deleteBlackListValue(Integer id)
	{
		mapper.deleteBlackListValue(id);
	}

	public void updateScoringRule(int scoring_rule_id) {
		
		mapper.updateScoringRule(scoring_rule_id);
	}

	public void updateScoringValue(Integer scoring_rule_id) {
		
		mapper.updateScoringValue(scoring_rule_id);
	}

	public void deleteQuotaValue(Integer quota_id) {
		
		mapper.deleteQuotaValue(quota_id);
	}

	public void addQuotaValue(RuleSetQuotaBean ruleSetQuotaBean) {
		
		mapper.addQuotaValue(ruleSetQuotaBean);
	}

	public void updateQuotaValue(RuleSetQuotaBean ruleSetQuotaBean) {
		
		mapper.updateQuotaValue(ruleSetQuotaBean);
	}	
	
	public List<TabAreaBean> queryAreaList(Map<String, Object> param)
	{
		return mapper.queryAreaList(param);
	}
	
	
	/**
	 * 规则集管理中，对于金额上限及下限，需限制不交叉
	 */
	public int findLeftCount(Map<String, Object> param)
	{
		return mapper.findLeftCount(param);
	}
	public int findRightCount(Map<String, Object> param)
	{
		return mapper.findRightCount(param);
	}
	public int findLeftCountByMap(Map<String, Object> param)
	{
		return mapper.findLeftCountByMap(param);
	}
	public int findRightCountByMap(Map<String, Object> param)
	{
		return mapper.findRightCountByMap(param);
	}
}
