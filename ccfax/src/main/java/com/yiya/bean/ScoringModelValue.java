package com.yiya.bean;

import java.util.Date;


public class ScoringModelValue extends BaseBean {
	
	private Integer score_id;
	private Integer scoring_rule_id;
	private Integer scoring_field_id;
	private String upper_limit;
	private String lower_limit;
	private Float score_value;
	private Integer unite_value;
	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	private String rule_name;
	private String field_name;
	
	
	public Integer getScore_id() {
		return score_id;
	}
	public void setScore_id(Integer score_id) {
		this.score_id = score_id;
	}
	public Integer getScoring_rule_id() {
		return scoring_rule_id;
	}
	public void setScoring_rule_id(Integer scoring_rule_id) {
		this.scoring_rule_id = scoring_rule_id;
	}
	public Integer getScoring_field_id() {
		return scoring_field_id;
	}
	public void setScoring_field_id(Integer scoring_field_id) {
		this.scoring_field_id = scoring_field_id;
	}
	public String getUpper_limit() {
		return upper_limit;
	}
	public void setUpper_limit(String upper_limit) {
		this.upper_limit = upper_limit;
	}
	public String getLower_limit() {
		return lower_limit;
	}
	public void setLower_limit(String lower_limit) {
		this.lower_limit = lower_limit;
	}
	public Float getScore_value() {
		return score_value;
	}
	public void setScore_value(Float score_value) {
		this.score_value = score_value;
	}
	public Integer getUnite_value() {
		return unite_value;
	}
	public void setUnite_value(Integer unite_value) {
		this.unite_value = unite_value;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Integer getAdd_usr_id() {
		return add_usr_id;
	}
	public void setAdd_usr_id(Integer add_usr_id) {
		this.add_usr_id = add_usr_id;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	
	
	
	
	
}
