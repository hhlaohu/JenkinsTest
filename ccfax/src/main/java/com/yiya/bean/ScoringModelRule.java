package com.yiya.bean;

import java.util.Date;


public class ScoringModelRule extends BaseBean {
	
	private Integer scoring_rule_id;
	private String rule_code;
	private String rule_name;
	private String rule_desc;
	private Integer is_active;//激活标志
	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	private Integer rule_set_id;
	private Integer rule_type_id;
	private String rule_set_name;
	
	private Float score_value;//得分
	
	public Integer getScoring_rule_id() {
		return scoring_rule_id;
	}
	public void setScoring_rule_id(Integer scoring_rule_id) {
		this.scoring_rule_id = scoring_rule_id;
	}
	public String getRule_code() {
		return rule_code;
	}
	public void setRule_code(String rule_code) {
		this.rule_code = rule_code;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getRule_desc() {
		return rule_desc;
	}
	public void setRule_desc(String rule_desc) {
		this.rule_desc = rule_desc;
	}
	public Integer getIs_active() {
		return is_active;
	}
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
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
	public Integer getRule_set_id() {
		return rule_set_id;
	}
	public void setRule_set_id(Integer rule_set_id) {
		this.rule_set_id = rule_set_id;
	}
	public String getRule_set_name() {
		return rule_set_name;
	}
	public void setRule_set_name(String rule_set_name) {
		this.rule_set_name = rule_set_name;
	}
	public Float getScore_value() {
		return score_value;
	}
	public void setScore_value(Float score_value) {
		this.score_value = score_value;
	}
	public Integer getRule_type_id() {
		return rule_type_id;
	}
	public void setRule_type_id(Integer rule_type_id) {
		this.rule_type_id = rule_type_id;
	}
	
	
}
