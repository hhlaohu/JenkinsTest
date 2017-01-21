package com.yiya.model;

/**
 * 数据字典参数类
 * @author lifaqiu
 * @date 2016-11-03
 */
public class DataParameterModel extends BaseModel{
	private Integer dictionary_type_id;	
	private String dictionary_type_name;

	private String dictionary_value_name;
	private Integer dictionary_value_key;
	
	private String dictionary_type_code;
	private String dictionary_type_code1;
	
	
	/**
	 * 默认构造器
	 */
	public DataParameterModel(){
		
	}

	/**
	 * @param dictionary_type_id
	 * @param dictionary_type_name
	 * @param dictionary_value_name
	 * @param dictionary_value_key
	 * @param dictionary_type_code
	 */
	public DataParameterModel(Integer dictionary_type_id, String dictionary_type_name, String dictionary_value_name,
			Integer dictionary_value_key,String dictionary_type_code) {
		super();
		this.dictionary_type_id = dictionary_type_id;
		this.dictionary_type_name = dictionary_type_name;
		this.dictionary_value_name = dictionary_value_name;
		this.dictionary_value_key = dictionary_value_key;
		this.dictionary_type_code = dictionary_type_code;
	}
	
	public DataParameterModel(Integer dictionary_type_id, String dictionary_type_name, String dictionary_value_name,
			Integer dictionary_value_key,String dictionary_type_code,String dictionary_type_code1) {
		super();
		this.dictionary_type_id = dictionary_type_id;
		this.dictionary_type_name = dictionary_type_name;
		this.dictionary_value_name = dictionary_value_name;
		this.dictionary_value_key = dictionary_value_key;
		this.dictionary_type_code = dictionary_type_code;
		this.dictionary_type_code1 = dictionary_type_code1;
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

	public String getDictionary_type_name() {
		return dictionary_type_name;
	}

	public void setDictionary_type_name(String dictionary_type_name) {
		this.dictionary_type_name = dictionary_type_name;
	}

	public String getDictionary_type_code() {
		return dictionary_type_code;
	}

	public void setDictionary_type_code(String dictionary_type_code) {
		this.dictionary_type_code = dictionary_type_code;
	}
	
}
