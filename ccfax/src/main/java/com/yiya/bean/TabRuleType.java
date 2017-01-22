package com.yiya.bean;

import java.util.Date;


public class TabRuleType extends BaseBean {
	
	private Integer rule_type_id;
	private String rule_type_name;//规则业务类型名称	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	public Integer getRule_type_id() {
		return rule_type_id;
	}
	public void setRule_type_id(Integer rule_type_id) {
		this.rule_type_id = rule_type_id;
	}
	public String getRule_type_name() {
		return rule_type_name;
	}
	public void setRule_type_name(String rule_type_name) {
		this.rule_type_name = rule_type_name;
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
	
	
}
