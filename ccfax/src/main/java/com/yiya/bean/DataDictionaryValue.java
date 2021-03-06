package com.yiya.bean;

import java.util.Date;

/**
 * 数据字典value实体
 * @author lifaqiu
 * @date 2016-11-03
 */
public class DataDictionaryValue extends BaseBean{
	private Integer dictionary_value_id;	
	private Integer dictionary_type_id;	
	private String dictionary_type_name;	
	private String dictionary_value_name;	
	private Integer dictionary_value_key;	
	private Date add_time;	
	private Integer add_usr_id;
	private String add_usr_name;
	
	public String getDictionary_type_name() {
		return dictionary_type_name;
	}
	public void setDictionary_type_name(String dictionary_type_name) {
		this.dictionary_type_name = dictionary_type_name;
	}
	public String getAdd_usr_name() {
		return add_usr_name;
	}
	public void setAdd_usr_name(String add_usr_name) {
		this.add_usr_name = add_usr_name;
	}
	public Integer getDictionary_value_id() {
		return dictionary_value_id;
	}
	public void setDictionary_value_id(Integer dictionary_value_id) {
		this.dictionary_value_id = dictionary_value_id;
	}
	public Integer getDictionary_type_id() {
		return dictionary_type_id;
	}
	public void setDictionary_type_id(Integer dictionary_type_id) {
		this.dictionary_type_id = dictionary_type_id;
	}
	public String getDictionary_value_name() {
		return dictionary_value_name;
	}
	public void setDictionary_value_name(String dictionary_value_name) {
		this.dictionary_value_name = dictionary_value_name;
	}
	public Integer getDictionary_value_key() {
		return dictionary_value_key;
	}
	public void setDictionary_value_key(Integer dictionary_value_key) {
		this.dictionary_value_key = dictionary_value_key;
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
