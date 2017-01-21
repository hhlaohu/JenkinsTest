package com.yiya.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
import com.yiya.model.BaseModel;

public interface ScoringConfigMapper<T> extends BaseMapper<T> 
{
   

	//查询所有字段类型
	public List<ScoringModelType> listAll(BaseModel model); 
	
	//查询所有字段(整形和浮点型)
	public List<ScoringModelField> listFields(BaseModel model); 
	
	public List<ScoringModelField> listAllFields(BaseModel model);
	
	//查询所有规则集
	public List<ScoringRuleSet> listAllRuleSet(BaseModel model);
	
	//查询规则业务分类
	public List<TabRuleType> listAllRuleType(BaseModel model); 
	
	//查询规则集业务分类
	public List<TabRuleSetType> listRuleSetType(BaseModel model); 
	
	//查询所有规则
	public List<ScoringModelRule> listAllRules(BaseModel model); 
	
	//查询所有反欺诈规则
	public List<AntiFraudModelRule> listAntiFraudRule(BaseModel model); 
	
	//查询字段列表
	public List<ScoringModelField> queryModelFieldList(BaseModel model); 
	
	//查询黑名单类型列表
	public List<BlackListBean> listBlackListType(BaseModel model); 
	
	//查询字段列表总数
	public int queryModelFieldCount(BaseModel model);

	//对模型字段的增，删，改
	public void addModelField(ScoringModelField t);
	
	public void updateModelField(ScoringModelField t);
	
	public void deleteModelField(Integer id);
	
	public ScoringModelField queryFieldById(Integer id);
	
	//删除字段类型对应的字段
	public void deleteFieldByType(Integer field_type_id);
	
	
	//查询评分规则列表
	public List<ScoringModelRule> queryModelRuleList(BaseModel model); 
	
	//查询评分规则列表总数
	public int queryModelRuleCount(BaseModel model);
	
	//对评分规则的增，删，改
	public void addModelRule(ScoringModelRule t);
	
	public void updateModelRule(ScoringModelRule t);
	
	public void deleteModelRule(Integer id);
	
	/**
	 *规则集管理 
	 */
	public  List<ScoringRuleSet> queryRuleSetList(BaseModel model);
	public int queryRuleSetCount(BaseModel model);
	public void addRuleSet(ScoringRuleSet ruleSet);
	public void updateRuleSet(ScoringRuleSet ruleSet);
	public void deleteRuleSet(Integer id);
	public void deleteRuleBySet(Integer ruleSetId);//删除规则集下面的规则
	public void deleteFraudRuleBySet(Integer ruleSetId);//删除规则集下面的反欺诈规则
	
	/**
	 * 规则value管理
	 */
	public  List<ScoringModelValue> queryModelValueList(BaseModel model);
	public int queryModelValueCount(BaseModel model);
	public void addModelValue(ScoringModelValue modelValue);
	public void updateModelValue(ScoringModelValue modelValue);
	public void deleteModelValue(Integer id);
	public void deleteByModelRule(Integer scoring_rule_id);//删除评分规则下的模型value
	
	/**
	 * 反欺诈规则管理
	 */
	public List<AntiFraudModelRule> queryAntiFraudRuleList(BaseModel model); 
	public int queryAntiFraudRuleCount(BaseModel model);
	public void addAntiFraudRule(AntiFraudModelRule t);
	public void updateAntiFraudRule(AntiFraudModelRule t);
	public void deleteAntiFraudRule(Integer id);
	
	/**
	 * 反欺诈规则value管理
	 */
	public List<AntiFraudModelValue> queryAntiFraudValueList(BaseModel model);
	public int queryAntiFraudValueCount(BaseModel model);
	public void addAntiFraudValue(AntiFraudModelValue antiFraudModeValue);
	public void updateAntiFraudValue(AntiFraudModelValue antiFraudModeValue);
	public void deleteAntiFraudValue(Integer id);
	public void deleteByAntiFraudRule(Integer anti_fraud_rule_id);//删除反欺诈规则下的模型value
	
	
	/**
	 * 黑名单类型管理
	 */
	public  List<BlackListBean> queryBlackListTypeList(BaseModel model);
	public int queryBlackListTypeCount(BaseModel model);
	public void addBlackListType(BlackListBean blcakList);
	public void updateBlackListType(BlackListBean blcakList);
	public void deleteBlackListType(Integer id);
	public void deleteBlackListByType(Integer typeId);//删除黑名单类型其下面的黑名单
	
	/**
	 * 黑名单管理
	 */
	public List<BlackListBean> queryBlackListValueList(BaseModel model);
	public int queryBlackListValueCount(BaseModel model);
	public void addBlackListValue(BlackListBean blcakList);
	public void updateBlackListValue(BlackListBean blcakList);
	public void deleteBlackListValue(Integer id);

	public void updateScoringRule(int scoring_rule_id);

	public void updateScoringValue(Integer scoring_rule_id);
	
	public List<TabAreaBean> queryAreaList(Map<String, Object> param);
	
	public List<RuleSetQuotaBean> queryQuotaList(BaseModel model);

	public int queryQuotaCount(BaseModel model);

	public void deleteQuotaValue(Integer quota_id);

	public void addQuotaValue(RuleSetQuotaBean ruleSetQuotaBean);

	public void updateQuotaValue(RuleSetQuotaBean ruleSetQuotaBean);
	
	/**
	 * 规则集管理中，对于金额上限及下限，需限制不交叉
	 */
	public int findLeftCount(Map<String, Object> param);
	public int findRightCount(Map<String, Object> param);
	public int findLeftCountByMap(Map<String, Object> param);
	public int findRightCountByMap(Map<String, Object> param);
	
}
