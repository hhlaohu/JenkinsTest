package com.yiya.model;

import java.util.Date;

import com.yiya.utils.DateUtil;

public class OrderModel extends BaseModel{

	private Integer check_status;
	private Integer submit_step;
	private Integer order_allot;
	private String borrow_uid;
	private Integer order_type;
	private String borrower_mobile_phone;
	private String borrower_usrname;
	private String order_sn;
	private String start_time_str;
	private String end_time_str;
	private Date start_time;
	private Date end_time;
	
	
	public Integer getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Integer check_status) {
		this.check_status = check_status;
	}
	public Integer getOrder_allot() {
		return order_allot;
	}
	public void setOrder_allot(Integer order_allot) {
		this.order_allot = order_allot;
	}
	public Integer getSubmit_step() {
		return submit_step;
	}
	public void setSubmit_step(Integer submit_step) {
		this.submit_step = submit_step;
	}
	public String getBorrow_uid() {
		return borrow_uid == null?null:borrow_uid.trim();
	}
	public void setBorrow_uid(String borrow_uid) {
		this.borrow_uid = borrow_uid;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public String getBorrower_mobile_phone() {
		return borrower_mobile_phone == null?null:borrower_mobile_phone.trim();
	}
	public void setBorrower_mobile_phone(String borrower_mobile_phone) {
		this.borrower_mobile_phone = borrower_mobile_phone;
	}
	public String getBorrower_usrname() {
		return borrower_usrname == null?null:borrower_usrname.trim();
	}
	public void setBorrower_usrname(String borrower_usrname) {
		this.borrower_usrname = borrower_usrname;
	}
	public String getOrder_sn() {
		return order_sn == null?null:order_sn.trim();
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public String getStart_time_str() {
		return start_time_str == null?null:start_time_str.trim();
	}
	public void setStart_time_str(String start_time_str) {
		this.start_time_str = start_time_str;
	}
	public String getEnd_time_str() {
		return end_time_str == null?null:end_time_str.trim();
	}
	public void setEnd_time_str(String end_time_str) {
		this.end_time_str = end_time_str;
	}
	public Date getStart_time() {
		try {
			return DateUtil.getDateFromString(start_time_str);
		} catch (Exception e) {
			
		}
		return null;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		try {
			return DateUtil.getDateFromString(end_time_str);
		} catch (Exception e) {
			
		}
		return null;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	
}
