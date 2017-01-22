package com.yiya.bean;

import java.util.Date;

/**
 * 规则集业务分类
 * Title: TabRuleSetType
 * Description: 
 * @author lidan
 * @date 2017年1月10日 下午2:52:32
 */
public class TabRuleSetType extends BaseBean {
	
	private Integer rule_set_type_id;
	private String rule_set_type_name;//规则业务类型名称	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	

	
	public Integer getRule_set_type_id() {
		return rule_set_type_id;
	}
	public void setRule_set_type_id(Integer rule_set_type_id) {
		this.rule_set_type_id = rule_set_type_id;
	}
	public String getRule_set_type_name() {
		return rule_set_type_name;
	}
	public void setRule_set_type_name(String rule_set_type_name) {
		this.rule_set_type_name = rule_set_type_name;
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
