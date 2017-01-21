package com.yiya.model;

import java.util.Date;

/**
 * @author Frank_Wang
 * @data 2016年11月4日
 * @description 采集数据字段管理
 */
public class ScoringGatherFieldModel extends BaseModel{

	/**主键*/
	private Long gather_field_id;
	
	/**字段名*/
	private String field_name;
	
	/**字段描述*/
	private String field_desc;
	
	/**字段值类型*/
	private Integer field_value_type;
	
	/**字段来源分类*/
	private Integer gather_type_id;
	
	/**添加时间*/
	private Date add_time;
	
	/**管理员id*/
	private Integer add_usr_id;
	
	/**数据来源中文名称*/
	private String gather_type_name;
	
	/**管理员名字*/
	private String sys_usr_name;

	/**使用开关0:不使用，1：使用，默认为0*/
	private Integer is_enable;
	

	
	
	public Integer getIs_enable() {
		return is_enable;
	}

	public void setIs_enable(Integer is_enable) {
		this.is_enable = is_enable;
	}

	public Long getGather_field_id() {
		return gather_field_id;
	}

	public void setGather_field_id(Long gather_field_id) {
		this.gather_field_id = gather_field_id;
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

	public Integer getGather_type_id() {
		return gather_type_id;
	}

	public void setGather_type_id(Integer gather_type_id) {
		this.gather_type_id = gather_type_id;
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

	public String getGather_type_name() {
		return gather_type_name;
	}

	public void setGather_type_name(String gather_type_name) {
		this.gather_type_name = gather_type_name;
	}

	public String getSys_usr_name() {
		return sys_usr_name;
	}

	public void setSys_usr_name(String sys_usr_name) {
		this.sys_usr_name = sys_usr_name;
	}
	
}
