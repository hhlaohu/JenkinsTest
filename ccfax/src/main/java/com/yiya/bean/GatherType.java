package com.yiya.bean;

import java.util.Date;

/**
 * @author Frank_wang
 * @data 2016年11月3日
 * @description 采集数据来源
 */
public class GatherType {

	/**主键*/
	private Integer gather_type_id;
	
	/**字段来源分类*/
	private String gather_type_name;
	
	/**添加时间*/
	private Date add_time;
	
	/**管理员id*/
	private Integer add_usr_id;

	public Integer getGather_type_id() {
		return gather_type_id;
	}

	public void setGather_type_id(Integer gather_type_id) {
		this.gather_type_id = gather_type_id;
	}

	public String getGather_type_name() {
		return gather_type_name;
	}

	public void setGather_type_name(String gather_type_name) {
		this.gather_type_name = gather_type_name;
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
