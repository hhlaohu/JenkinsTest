package com.yiya.bean;

import java.util.Date;

/**
 * 数据字典类型实体
 * @author lifaqiu
 * @date 2016-11-03
 */
public class DataDictionaryType extends BaseBean{
	private Integer dictionary_type_id;
	private String dictionary_type_name;
	private Date add_time;
	private Integer add_usr_id;
	private String add_usr_name;
	
	private Integer is_relational_table;//是否关联外部表，0：不关联，1：关联，默认不关联
	private String relational_table_name;//关联外部表名
	private String dictionary_type_code;//数据字典编号
	
	
	public String getAdd_usr_name() {
		return add_usr_name;
	}
	public void setAdd_usr_name(String add_usr_name) {
		this.add_usr_name = add_usr_name;
	}
	public Integer getDictionary_type_id() {
		return dictionary_type_id;
	}
	public void setDictionary_type_id(Integer dictionary_type_id) {
		this.dictionary_type_id = dictionary_type_id;
	}
	public String getDictionary_type_name() {
		return dictionary_type_name;
	}
	public void setDictionary_type_name(String dictionary_type_name) {
		this.dictionary_type_name = dictionary_type_name;
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
	public Integer getIs_relational_table() {
		return is_relational_table;
	}
	public void setIs_relational_table(Integer is_relational_table) {
		this.is_relational_table = is_relational_table;
	}
	public String getRelational_table_name() {
		return relational_table_name;
	}
	public void setRelational_table_name(String relational_table_name) {
		this.relational_table_name = relational_table_name;
	}
	public String getDictionary_type_code() {
		return dictionary_type_code;
	}
	public void setDictionary_type_code(String dictionary_type_code) {
		this.dictionary_type_code = dictionary_type_code;
	}
	
	
}
