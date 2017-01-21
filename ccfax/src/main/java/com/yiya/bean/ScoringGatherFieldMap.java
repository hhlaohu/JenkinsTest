package com.yiya.bean;

import java.util.Date;

/**
 * @author frank_wang
 * @data 2016年11月10日
 * @description 评分模型字段与采集字段映射关系
 */
public class ScoringGatherFieldMap extends BaseBean 
{

	private Integer id;
	
	private Integer scoring_field_id;
	
	private Integer gather_field_id;
	
	private Date add_time;
	
	private Integer add_usr_id;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScoring_field_id() {
		return scoring_field_id;
	}

	public void setScoring_field_id(Integer scoring_field_id) {
		this.scoring_field_id = scoring_field_id;
	}

	public Integer getGather_field_id() {
		return gather_field_id;
	}

	public void setGather_field_id(Integer gather_field_id) {
		this.gather_field_id = gather_field_id;
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
