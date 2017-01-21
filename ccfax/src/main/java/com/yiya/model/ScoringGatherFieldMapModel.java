package com.yiya.model;

import java.util.Date;

/**
 * @author frank_wang
 * @data 2016年11月10日
 * @description
 */
public class ScoringGatherFieldMapModel extends BaseModel {
	
	private Integer id;//主键
	private Integer scoring_field_id;//评分字段Id
	private String scoring_field_name;//评分字段名
	private String scoring_field_name_ch;//评分中文字段名
	private String scoring_field_desc;//评分字段描述
	private Integer gather_field_id;//采集字段Id
	private String gather_field_name;//采集字段名
	private String gather_field_desc;//采集字段描述
	private String gather_type_name;//采集字段来源
	private Integer gather_type_id;//采集字段来源ID
	
	
	private Integer add_usr_id;//添加人ID
	private String sys_usr_name;//添加人名字
	private Date add_time;//添加时间
	
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
	public String getScoring_field_name() {
		return scoring_field_name;
	}
	public void setScoring_field_name(String scoring_field_name) {
		this.scoring_field_name = scoring_field_name;
	}
	public String getScoring_field_name_ch() {
		return scoring_field_name_ch;
	}
	public void setScoring_field_name_ch(String scoring_field_name_ch) {
		this.scoring_field_name_ch = scoring_field_name_ch;
	}
	public String getScoring_field_desc() {
		return scoring_field_desc;
	}
	public void setScoring_field_desc(String scoring_field_desc) {
		this.scoring_field_desc = scoring_field_desc;
	}
	public Integer getGather_field_id() {
		return gather_field_id;
	}
	public void setGather_field_id(Integer gather_field_id) {
		this.gather_field_id = gather_field_id;
	}
	public String getGather_field_name() {
		return gather_field_name;
	}
	public void setGather_field_name(String gather_field_name) {
		this.gather_field_name = gather_field_name;
	}
	public String getGather_field_desc() {
		return gather_field_desc;
	}
	public void setGather_field_desc(String gather_field_desc) {
		this.gather_field_desc = gather_field_desc;
	}
	public String getGather_type_name() {
		return gather_type_name;
	}
	public void setGather_type_name(String gather_type_name) {
		this.gather_type_name = gather_type_name;
	}
	public Integer getGather_type_id() {
		return gather_type_id;
	}
	public void setGather_type_id(Integer gather_type_id) {
		this.gather_type_id = gather_type_id;
	}
	public Integer getAdd_usr_id() {
		return add_usr_id;
	}
	public void setAdd_usr_id(Integer add_usr_id) {
		this.add_usr_id = add_usr_id;
	}
	public String getSys_usr_name() {
		return sys_usr_name;
	}
	public void setSys_usr_name(String sys_usr_name) {
		this.sys_usr_name = sys_usr_name;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	@Override
	public String toString() {
		return "ScoringGatherFieldMapModel [id=" + id + ", scoring_field_id=" + scoring_field_id
				+ ", scoring_field_name=" + scoring_field_name + ", scoring_field_name_ch=" + scoring_field_name_ch
				+ ", scoring_field_desc=" + scoring_field_desc + ", gather_field_id=" + gather_field_id
				+ ", gather_field_name=" + gather_field_name + ", gather_field_desc=" + gather_field_desc
				+ ", gather_type_name=" + gather_type_name + ", add_usr_id=" + add_usr_id + ", sys_usr_name="
				+ sys_usr_name + ", add_time=" + add_time + "]";
	}
}
