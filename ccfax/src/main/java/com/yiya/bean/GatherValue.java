package com.yiya.bean;

import java.util.Date;

/**
 * @author frank_wang
 * @data 2016年11月9日
 * @description 采集数据表
 */
public class GatherValue {

	private Long id;
	
	private Integer usrid;
	
	/**字段来源ID*/
	private Integer gather_type_id;
	
	/**字段ID*/
	private Integer gather_field_id;
	
	/**关联上级ID*/
	private Long gather_parent_id;
	
	private String gather_field_value;
	
	private Date add_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public Integer getGather_type_id() {
		return gather_type_id;
	}

	public void setGather_type_id(Integer gather_type_id) {
		this.gather_type_id = gather_type_id;
	}

	public Integer getGather_field_id() {
		return gather_field_id;
	}

	public void setGather_field_id(Integer gather_field_id) {
		this.gather_field_id = gather_field_id;
	}

	public String getGather_field_value() {
		return gather_field_value;
	}

	public void setGather_field_value(String gather_field_value) {
		this.gather_field_value = gather_field_value;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	public Long getGather_parent_id() {
		return gather_parent_id;
	}

	public void setGather_parent_id(Long gather_parent_id) {
		this.gather_parent_id = gather_parent_id;
	}

	@Override
	public String toString() {
		return "GatherValue [id=" + id + ", usrid=" + usrid + ", gather_type_id=" + gather_type_id
				+ ", gather_field_id=" + gather_field_id + ", gather_parent_id=" + gather_parent_id
				+ ", gather_field_value=" + gather_field_value + ", add_time=" + add_time + "]";
	}

	
}
