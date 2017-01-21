package com.yiya.bean;

import java.util.Date;


public class ScoringModelType extends BaseBean {
	
		private Integer field_type_id;	private String field_type_name;//字段类型名（基础字段，外部字段，运营字段，行为字段等）	private String field_type_desc;//字段描述
	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	
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
