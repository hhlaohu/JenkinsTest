package com.yiya.bean;

import java.util.Date;

public class RuleSetQuotaBean extends BaseBean{
	private Integer quota_id;
	private Integer rule_set_id;
	private Float min_score;
	private Float max_score;
	private Float min_quota;
	private Float max_quota;
	private Date add_time;
	private Integer add_usr_id;
	public Integer getQuota_id() {
		return quota_id;
	}
	public void setQuota_id(Integer quota_id) {
		this.quota_id = quota_id;
	}
	public Integer getRule_set_id() {
		return rule_set_id;
	}
	public void setRule_set_id(Integer rule_set_id) {
		this.rule_set_id = rule_set_id;
	}
	public Float getMin_score() {
		return min_score;
	}
	public void setMin_score(Float min_score) {
		this.min_score = min_score;
	}
	public Float getMax_score() {
		return max_score;
	}
	public void setMax_score(Float max_score) {
		this.max_score = max_score;
	}
	public Float getMin_quota() {
		return min_quota;
	}
	public void setMin_quota(Float min_quota) {
		this.min_quota = min_quota;
	}
	public Float getMax_quota() {
		return max_quota;
	}
	public void setMax_quota(Float max_quota) {
		this.max_quota = max_quota;
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
