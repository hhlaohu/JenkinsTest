package com.yiya.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.yiya.bean.AffiliateRule;
import com.yiya.bean.AntiFraudReportList;
import com.yiya.bean.BlacklistReportList;
import com.yiya.bean.Bondsmaninf;
import com.yiya.bean.ScoreReport;
import com.yiya.bean.ScoreReportList;
import com.yiya.bean.ScoringGatherField;
import com.yiya.bean.ScoringGatherFieldMap;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.TabAreaBean;
import com.yiya.mapper.ScoreMapper;

@Service("scoreService")
public class ScoreService<T> extends BaseService<T> implements InitializingBean,ApplicationContextAware {
	
	private final static Logger log= Logger.getLogger(ScoreService.class);
	
	@Autowired
    private ScoreMapper<T> mapper;
	
	private ApplicationContext context;
	
	private ScoringGatherFieldMapService scoringGatherFieldMapService; 
	
	private ScoringGatherFieldService scoringGatherFieldService;

	public ScoreMapper<T> getMapper() {
		return mapper;
	}

	public List<Map<String, Object>> findBlacklistValue(
			Map<String, Object> param) {
		
		return mapper.findBlacklistValue(param);
	}

	public List<Map<String, Object>> getAntiFraudRuleList(int rule_set_id) {
		
		return mapper.getAntiFraudRuleList(rule_set_id);
	}

	public List<Map<String, Object>> getAntiFraudValueList(
			int anti_fraud_rule_id) {
	
		return mapper.getAntiFraudValueList(anti_fraud_rule_id);
	}

	public Map<String, Object> findScoringGatherFieldMap(
			int scoring_field_id) {
		
		return mapper.findScoringGatherFieldMap(scoring_field_id);
	}

	public Map<String, Object> findGatherValue(
			Map<String, Object> paramMap) {
		
		return mapper.findGatherValue(paramMap);
	}

	public List<Map<String, Object>> findAllRules(int rule_set_id) {
		
		return mapper.findAllRules(rule_set_id);
	}

	public List<Map<String, Object>> findAllRuleValues(int scoring_rule_id) {
		
		return mapper.findAllRuleValues(scoring_rule_id);
	}

	public String getgatherFieldValue(Map<String, Object> paramMap) {
		
		return mapper.getgatherFieldValue(paramMap);
	}

	public Map<String, Object> findCombinedFieldValueMap(int combined_field_id_1) {
		
		return mapper.findCombinedFieldValueMap(combined_field_id_1);
	}

	public Map<String, Object> findQuota(Map<String, Object> paramMap) {
		
		return mapper.findQuota(paramMap);
	}

	public void addScoreReport(ScoreReport scoreReport) {
		
		mapper.addScoreReport(scoreReport);
	}

	public void addScoreReportList(List<ScoreReportList> dataList) {
		for (ScoreReportList scoreReportList : dataList) {
			mapper.addScoreReportList(scoreReportList);
		}
	}

	public String findRuleSetName(int rule_set_id) {
		
		return mapper.findRuleSetName(rule_set_id);
	}

	public Map<String, String> findUserInfo(Integer usrid) {
		
		return mapper.findUserInfo(usrid);
	}

	public void addBlacklistReportLists(
			List<BlacklistReportList> blacklistReportLists) {
		for (BlacklistReportList blacklistReportList : blacklistReportLists) {
			mapper.addBlacklistReportList(blacklistReportList);
		}
	}

	public void addAntiFraudReportLists(
			List<AntiFraudReportList> antiFraudReportLists) {
		for (AntiFraudReportList antiFraudReportList : antiFraudReportLists) {
			mapper.addAntiFraudReportList(antiFraudReportList);
		}
	}

	public Map<String, Object> findScoreQuotaMap(float sum_score) {
		
		return mapper.findScoreQuotaMap(sum_score);
	}

	public ScoreReport findUserScore(int usrid) {
		
		return mapper.findUserScore(usrid);
	}

	public TabAreaBean findTabAreaBeanByAreaId(Integer areaId) {
		
		return mapper.findTabAreaBeanByAreaId(areaId);
	}

	public ScoreReport findScoreReportByReportId(Integer report_id) {
		
		return mapper.findScoreReportByReportId(report_id);
	}
	
	public ScoreReport findScoreReportByUsrOrderId(Integer report_id) {
		
		return mapper.findScoreReportByUsrOrderId(report_id);
	}

	public List<Bondsmaninf> findBondsmaninfList(Integer usrinf_id) {
		
		return mapper.findBondsmaninfList(usrinf_id);
	}

	public List<AffiliateRule> findAffiliateRuleByReportId(Integer report_id) {
	
		return mapper.findAffiliateRuleByReportId(report_id);
	}

	public List<ScoringReportBondsmaninf> findScoringReportBondsmaninfByReportId(
			Integer report_id) {
		
		return mapper.findScoringReportBondsmaninfByReportId(report_id);
	}

	public void addScoringReportBondsmaninf(
			List<ScoringReportBondsmaninf> scoringReportBondsmaninfs) {
		for (ScoringReportBondsmaninf scoringReportBondsmaninf : scoringReportBondsmaninfs) {
			mapper.addScoringReportBondsmaninf(scoringReportBondsmaninf);
		}
	}

	public List<BlacklistReportList> findBlacklistReportListByReportId(
			Integer report_id) {
		
		return mapper.findBlacklistReportListByReportId(report_id);
	}

	public List<AntiFraudReportList> findAntiFraudReportListByReportId(
			Integer report_id) {
		
		return mapper.findAntiFraudReportListByReportId(report_id);
	}

	public List<ScoreReportList> findScoreReportListByReportId(Integer report_id) {
		
		return mapper.findScoreReportListByReportId(report_id);
	}

	public List<ScoreReportList> findScoreReportListByRuleTypeId(int ruleTypeId) {
		
		return mapper.findScoreReportListByRuleTypeId(ruleTypeId);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月11日
	 * @description 根据
	 * @param anti_fraud_rule_id
	 * @return
	 */
	public List<Map<String, Object>> getAntiValueList(Integer anti_fraud_rule_id){
		return mapper.getAntiValueList(anti_fraud_rule_id);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月11日
	 * @description 根据规则集查找反欺诈规则
	 * @return
	 */
	public List<Map<String, Object>> getAntiFraudRuleListByRuleSetId(Integer rule_set_id){
		
		return 	mapper.getAntiFraudRuleListByRuleSetId(rule_set_id);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月11日
	 * @description 根据规则集业务分类ID和金额确定对应的规则集
	 * @param amount
	 * @param rule_set_type_id
	 * @return
	 */
	public Integer getRuleSetIdByTypeIdAndAmount(BigDecimal amount,Integer rule_set_type_id){
		
		if(amount == null || rule_set_type_id == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rule_set_type_id", rule_set_type_id);
		map.put("amount", amount.toString());
		return mapper.getRuleSetIdByTypeIdAndAmount(map);
		
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月10日
	 * @description 根据规则集ID获取需要采集的字段,返回key,value键值对，键表示数据来源，值表示数据来源需采集的字段。
	 * @return
	 */
	public Map<String, HashSet<String>> getGatherFiledsByRuleId(Integer rule_set_id){
		Map<String, HashSet<String>> resultMap = new HashMap<String, HashSet<String>>();
		List<Map<String, Object>> ruleList = new ArrayList<Map<String, Object>>();
		ruleList = findAllRules(rule_set_id);
		List<Map<String, Object>> antiRuleList = getAntiFraudRuleListByRuleSetId(rule_set_id);
		ruleList.addAll(antiRuleList);
		if(null != ruleList && ruleList.size() >0){
			for(Map<String, Object> ruleMap:ruleList){
				int scoring_rule_id = ruleMap.containsKey("scoring_rule_id")?Integer.parseInt(ruleMap.get("scoring_rule_id").toString()):0;
				int anti_fraud_rule_id = ruleMap.containsKey("anti_fraud_rule_id")?Integer.parseInt(ruleMap.get("anti_fraud_rule_id").toString()):0;
				List<Map<String, Object>> valueList = new ArrayList<Map<String, Object>>();
				if(scoring_rule_id != 0){
					valueList = findAllRuleValues(scoring_rule_id);
				}
				if(anti_fraud_rule_id != 0){
					valueList = getAntiValueList(anti_fraud_rule_id);
				}
				if(valueList != null && valueList.size() > 0){
					for(Map<String, Object> valueMap : valueList){
						int scoring_field_id = valueMap.containsKey("scoring_field_id")?Integer.parseInt(valueMap.get("scoring_field_id").toString()):0;
						ScoringGatherFieldMap fieldMap = scoringGatherFieldMapService.selectByScoringFieldId(scoring_field_id);
						if(fieldMap == null){
							log.error("未查询到映射，scoring_field_id="+scoring_field_id);
							continue;
						}
						Integer gather_filed_id = fieldMap.getGather_field_id();
						ScoringGatherField gatherField = scoringGatherFieldService.getScoringGatherFieldById(Long.valueOf(gather_filed_id));
						if(gatherField == null){
							log.error("未查询到采集字段，gather_filed_id="+gather_filed_id);
							continue;
						}
						if(gatherField.getIs_enable().intValue() == 0){
							continue;
						}
						Integer gatherTypeId = gatherField.getGather_type_id();
						if(resultMap.containsKey(gatherTypeId.toString())){
							HashSet<String> set = resultMap.get(gatherTypeId.toString());
							set.add(gatherField.getField_name());
						}else{
							HashSet<String> tempSet = new HashSet<String>();
							tempSet.add(gatherField.getField_name());
							resultMap.put(gatherField.getGather_type_id().toString(), tempSet);
						}
					}
				}
			}
			return resultMap;
		}else{
			return null;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {

		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		scoringGatherFieldMapService = context.getBean("scoringGatherFieldMapService", ScoringGatherFieldMapService.class);
		scoringGatherFieldService = context.getBean("scoringGatherFieldService", ScoringGatherFieldService.class);
	}
	
}
