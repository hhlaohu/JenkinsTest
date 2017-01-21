package com.yiya.bean;

import java.util.Date;


public class AntiFraudModelValue extends BaseBean {
	
	private Integer anti_fraud_id;
	private Integer anti_fraud_rule_id;
	private Integer scoring_field_id;
	private String hit_value;
	private Integer hit_condition;
	private Integer unite_value;
	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	private String rule_name;
	private String field_name;
	
	


	public Integer getAnti_fraud_rule_id() {
		return anti_fraud_rule_id;
	}
	public void setAnti_fraud_rule_id(Integer anti_fraud_rule_id) {
		this.anti_fraud_rule_id = anti_fraud_rule_id;
	}
	public Integer getScoring_field_id() {
		return scoring_field_id;
	}
	public void setScoring_field_id(Integer scoring_field_id) {
		this.scoring_field_id = scoring_field_id;
	}
	public Integer getAnti_fraud_id() {
		return anti_fraud_id;
	}
	public void setAnti_fraud_id(Integer anti_fraud_id) {
		this.anti_fraud_id = anti_fraud_id;
	}
	public String getHit_value() {
		return hit_value;
	}
	public void setHit_value(String hit_value) {
		this.hit_value = hit_value;
	}
	public Integer getHit_condition() {
		return hit_condition;
	}
	public void setHit_condition(Integer hit_condition) {
		this.hit_condition = hit_condition;
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
