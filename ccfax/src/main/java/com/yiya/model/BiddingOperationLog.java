package com.yiya.model;

import java.util.Date;

/**
 * @author wang_xiao_long
 * @data 2016年9月9日
 * @description 标的操作日志
 */
public class BiddingOperationLog {

	/** 日志Id */
	private String log_id;
	/** 标Id */
	private String borrow_id;
	/** 操作人Id */
	private String deal_user;
	/** 审核意见 */
	private String deal_info;
	/** 处理时间 */
	private Integer deal_time;
	/** 处理时间Date */
	private Date deal_time_date;
	/** 发标时间 */
	private Integer borrow_add_time;
	/** 发标时间Date */
	private Date borrow_add_time_date;
	/** 具体操作名称 */
	private String operation;

	public String getLog_id() {
		return log_id;
	}

	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	public String getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(String borrow_id) {
		this.borrow_id = borrow_id;
	}

	public String getDeal_user() {
		return deal_user;
	}

	public void setDeal_user(String deal_user) {
		this.deal_user = deal_user;
	}

	public String getDeal_info() {
		return deal_info;
	}

	public void setDeal_info(String deal_info) {
		this.deal_info = deal_info;
	}

	public Integer getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(Integer deal_time) {
		this.deal_time = deal_time;
	}

	public Integer getBorrow_add_time() {
		return borrow_add_time;
	}

	public void setBorrow_add_time(Integer borrow_add_time) {
		this.borrow_add_time = borrow_add_time;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getDeal_time_date() {
		return deal_time_date;
	}

	public void setDeal_time_date(Date deal_time_date) {
		this.deal_time_date = deal_time_date;
	}

	public Date getBorrow_add_time_date() {
		return borrow_add_time_date;
	}

	public void setBorrow_add_time_date(Date borrow_add_time_date) {
		this.borrow_add_time_date = borrow_add_time_date;
	}
     
}
