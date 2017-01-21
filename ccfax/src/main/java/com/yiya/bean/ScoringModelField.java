package com.yiya.bean;

import java.util.Date;


public class ScoringModelField extends BaseBean 
{

	private Integer scoring_field_id;
	private String field_name;//字段名
	private String field_name_ch;//中文字段名
	private String field_desc;//字段描述
	private Integer field_value_type;//字段值类型（字符串，整型，枚举等）
	private Integer field_type_id;//字段业务分类（基础字段，外部字段，运营字段，行为字段等）
	private String field_value_ini;//字段默认值
	private Date  add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	private Integer  combined_field_id_1;//组合字段1id
	private Integer  combined_field_id_2;//组合字段2id
	private String combined_operate;//运算符，+,-,*,/
	private Integer is_combined;//字段类型（0：非组合字段，1：组合字段）
	
	private String field_type_name;
	private Integer dictionary_type_id;
	
	
	public String getField_type_name() {
		return field_type_name;
	}
	public void setField_type_name(String field_type_name) {
		this.field_type_name = field_type_name;
	}
	public String getField_name_ch() {
		return field_name_ch;
	}
	public void setField_name_ch(String field_name_ch) {
		this.field_name_ch = field_name_ch;
	}
	public Integer getScoring_field_id() {
		return scoring_field_id;
	}
	public void setScoring_field_id(Integer scoring_field_id) {
		this.scoring_field_id = scoring_field_id;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getField_desc() {
		return field_desc;
	}
	public void setField_desc(String field_desc) {
		this.field_desc = field_desc;
	}
	public Integer getField_value_type() {
		return field_value_type;
	}
	public void setField_value_type(Integer field_value_type) {
		this.field_value_type = field_value_type;
	}
	public Integer getField_type_id() {
		return field_type_id;
	}
	public void setField_type_id(Integer field_type_id) {
		this.field_type_id = field_type_id;
	}
	public String getField_value_ini() {
		return field_value_ini;
	}
	public void setField_value_ini(String field_value_ini) {
		this.field_value_ini = field_value_ini;
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
	public Integer getCombined_field_id_1() {
		return combined_field_id_1;
	}
	public void setCombined_field_id_1(Integer combined_field_id_1) {
		this.combined_field_id_1 = combined_field_id_1;
	}
	public Integer getCombined_field_id_2() {
		return combined_field_id_2;
	}
	public void setCombined_field_id_2(Integer combined_field_id_2) {
		this.combined_field_id_2 = combined_field_id_2;
	}
	public String getCombined_operate() {
		return combined_operate;
	}
	public void setCombined_operate(String combined_operate) {
		this.combined_operate = combined_operate;
	}
	public Integer getIs_combined() {
		return is_combined;
	}
	public void setIs_combined(Integer is_combined) {
		this.is_combined = is_combined;
	}
	public Integer getDictionary_type_id() {
		return dictionary_type_id;
	}
	public void setDictionary_type_id(Integer dictionary_type_id) {
		this.dictionary_type_id = dictionary_type_id;
	}


	
	
	
	
	
	
	
	
	
}
