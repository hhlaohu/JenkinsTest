package com.yiya.model;


public class ScoringConfigModel extends BaseModel {
	
	private Integer field_type_id;	private String field_type_name;//字段类型名（基础字段，外部字段，运营字段，行为字段等）	private String field_type_desc;//字段描述
	//查询字段下拉列表用到
	private Integer field_value_type;//字段类型
	private Integer is_combined;//是否组合
	
	private Integer scoring_field_id;
	private String field_name;//字段名
	
	private Integer anti_fraud_rule_id;
	private Integer scoring_rule_id;
	private Integer is_active;//激活标志
	private String rule_name;//规则名称
	
	private String rule_set_id;//规则集id
	private String rule_set_name;//规则集名称
	
	private String blacklist_type;//黑名单类型
	private String blacklist_value;//黑名单值
	
	
	
	public String getRule_set_id() {
		return rule_set_id;
	}
	public void setRule_set_id(String rule_set_id) {
		this.rule_set_id = rule_set_id;
	}
	public String getBlacklist_value() {
		return blacklist_value;
	}
	public void setBlacklist_value(String blacklist_value) {
		this.blacklist_value = blacklist_value;
	}
	public String getBlacklist_type() {
		return blacklist_type;
	}
	public void setBlacklist_type(String blacklist_type) {
		this.blacklist_type = blacklist_type;
	}
	public Integer getField_type_id() {
		return field_type_id;
	}
	public void setField_type_id(Integer field_type_id) {
		this.field_type_id = field_type_id;
	}
	public String getField_type_name() {
		return field_type_name;
	}
	public void setField_type_name(String field_type_name) {
		this.field_type_name = field_type_name;
	}
	public String getField_type_desc() {
		return field_type_desc;
	}
	public void setField_type_desc(String field_type_desc) {
		this.field_type_desc = field_type_desc;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public Integer getScoring_field_id() {
		return scoring_field_id;
	}
	public void setScoring_field_id(Integer scoring_field_id) {
		this.scoring_field_id = scoring_field_id;
	}
	public Integer getIs_active() {
		return is_active;
	}
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getRule_set_name() {
		return rule_set_name;
	}
	public void setRule_set_name(String rule_set_name) {
		this.rule_set_name = rule_set_name;
	}
	public Integer getField_value_type() {
		return field_value_type;
	}
	public void setField_value_type(Integer field_value_type) {
		this.field_value_type = field_value_type;
	}
	public Integer getIs_combined() {
		return is_combined;
	}
	public void setIs_combined(Integer is_combined) {
		this.is_combined = is_combined;
	}
	public Integer getScoring_rule_id() {
		return scoring_rule_id;
	}
	public void setScoring_rule_id(Integer scoring_rule_id) {
		this.scoring_rule_id = scoring_rule_id;
	}
	public Integer getAnti_fraud_rule_id() {
		return anti_fraud_rule_id;
	}
	public void setAnti_fraud_rule_id(Integer anti_fraud_rule_id) {
		this.anti_fraud_rule_id = anti_fraud_rule_id;
	}

	
	
}
