package com.yiya.model;


/**
 * @author lifaqiu
 * @data 2016年9月9日
 * @description 标的操作日志
 */
public class DebtBorrowCheckLog {

	/** 日志Id */
	private String log_id;
	
	private String borrow_id;
	
	private String info;
	
	private String time;

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
