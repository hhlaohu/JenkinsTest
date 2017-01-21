package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.AffiliateRule;
import com.yiya.bean.AntiFraudModelValue;
import com.yiya.bean.AntiFraudReportList;
import com.yiya.bean.BlacklistReportList;
import com.yiya.bean.Bondsmaninf;
import com.yiya.bean.ScoreReport;
import com.yiya.bean.ScoreReportList;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.TabAreaBean;



public interface ScoreMapper<T> extends BaseMapper<T> {

	List<Map<String, Object>> findBlacklistValue(Map<String, Object> param);

	List<Map<String, Object>> getAntiFraudRuleList(int rule_set_id);

	List<Map<String, Object>> getAntiFraudValueList(int anti_fraud_rule_id);

	Map<String, Object> findScoringGatherFieldMap(int scoring_field_id);

	Map<String, Object> findGatherValue(Map<String, Object> paramMap);

	List<Map<String, Object>> findAllRules(int rule_set_id);

	List<Map<String, Object>> findAllRuleValues(int scoring_rule_id);

	String getgatherFieldValue(Map<String, Object> paramMap);

	Map<String, Object> findCombinedFieldValueMap(int combined_field_id_1);

	Map<String, Object> findQuota(Map<String, Object> paramMap);

	void addScoreReport(ScoreReport scoreReport);

	void addScoreReportList(ScoreReportList scoreReportList);

	String findRuleSetName(int rule_set_id);

	Map<String, String> findUserInfo(Integer usrid);

	void addBlacklistReportList(BlacklistReportList blacklistReportList);

	void addAntiFraudReportList(List<AntiFraudReportList> antiFraudReportLists);

	void addAntiFraudReportList(AntiFraudReportList antiFraudReportList);

	Map<String, Object> findScoreQuotaMap(float sum_score);

	ScoreReport findUserScore(int usrid);

	TabAreaBean findTabAreaBeanByAreaId(Integer areaId);

	ScoreReport findScoreReportByReportId(Integer report_id);
	
	ScoreReport findScoreReportByUsrOrderId(Integer usr_order_id);

	List<Bondsmaninf> findBondsmaninfList(Integer usrinf_id);

	List<AffiliateRule> findAffiliateRuleByReportId(Integer report_id);

	List<ScoringReportBondsmaninf> findScoringReportBondsmaninfByReportId(
			Integer report_id);

	void addScoringReportBondsmaninf(
			ScoringReportBondsmaninf scoringReportBondsmaninf);

	List<BlacklistReportList> findBlacklistReportListByReportId(
			Integer report_id);

	List<AntiFraudReportList> findAntiFraudReportListByReportId(
			Integer report_id);

	List<ScoreReportList> findScoreReportListByReportId(Integer report_id);

	List<ScoreReportList> findScoreReportListByRuleTypeId(int ruleTypeId);
	
	Integer getRuleSetIdByTypeIdAndAmount(Map<String, Object> map);
	
	List<Map<String, Object>>  getAntiFraudRuleListByRuleSetId(Integer rule_set_id);
	
	List<Map<String, Object>> getAntiValueList(Integer anti_fraud_rule_id); 
	
}
