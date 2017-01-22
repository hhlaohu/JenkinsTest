package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;


public class ScoringRuleSet extends BaseBean {
	
	private Integer rule_set_id;
	private String rule_set_name;//规则集名称	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	private String rule_set_type_name;
	private Integer rule_set_type_id;//规则集业务分类id
	private BigDecimal upper_amount;//金额下限，同一个业务分类下根据金额确定规则集
	private BigDecimal lower_amount;//金额上限
	
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
	public Integer getRule_set_type_id() {
		return rule_set_type_id;
	}
	public void setRule_set_type_id(Integer rule_set_type_id) {
		this.rule_set_type_id = rule_set_type_id;
	}
	public BigDecimal getUpper_amount() {
		return upper_amount;
	}
	public void setUpper_amount(BigDecimal upper_amount) {
		this.upper_amount = upper_amount;
	}
	public BigDecimal getLower_amount() {
		return lower_amount;
	}
	public void setLower_amount(BigDecimal lower_amount) {
		this.lower_amount = lower_amount;
	}
	public String getRule_set_type_name() {
		return rule_set_type_name;
	}
	public void setRule_set_type_name(String rule_set_type_name) {
		this.rule_set_type_name = rule_set_type_name;
	}
	
	
}
