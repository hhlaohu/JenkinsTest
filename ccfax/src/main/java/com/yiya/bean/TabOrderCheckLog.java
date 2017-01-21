package com.yiya.bean;

import java.util.Date;

import com.yiya.utils.DateUtil;

public class TabOrderCheckLog {
	
	private Integer log_id;
	private Integer usr_order_id;
	private Integer deal_user_id;
	private String deal_user;
	private String check_result;
	private String check_remark;
	private Date deal_time;
	private String deal_time_;
	public Integer getLog_id() {
		return log_id;
	}
	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}
	public Integer getUsr_order_id() {
		return usr_order_id;
	}
	public void setUsr_order_id(Integer usr_order_id) {
		this.usr_order_id = usr_order_id;
	}
	public Integer getDeal_user_id() {
		return deal_user_id;
	}
	public void setDeal_user_id(Integer deal_user_id) {
		this.deal_user_id = deal_user_id;
	}
	public String getDeal_user() {
		return deal_user;
	}
	public void setDeal_user(String deal_user) {
		this.deal_user = deal_user;
	}
	public String getCheck_result() {
		return check_result;
	}
	public void setCheck_result(String check_result) {
		this.check_result = check_result;
	}
	public String getCheck_remark() {
		return check_remark;
	}
	public void setCheck_remark(String check_remark) {
		this.check_remark = check_remark;
	}
	public Date getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}
	public String getDeal_time_() {
		
		return DateUtil.getPlusTime2(deal_time);
	}
	public void setDeal_time_(String deal_time_) {
		this.deal_time_ = deal_time_;
	}
	
	
}
