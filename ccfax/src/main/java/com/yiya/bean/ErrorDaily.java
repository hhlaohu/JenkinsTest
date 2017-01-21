package com.yiya.bean;

import java.math.BigDecimal;

public class ErrorDaily extends BaseBean {
	private int error_id;//主键id
	private String error_customer_name;//客户姓名
	private String error_telephone;//客户电话
	private String error_content;//客户内容
	private int error_status;//处理状态
	private String error_deal_with;//处理人
	public int getError_id() {
		return error_id;
	}
	public void setError_id(int errorId) {
		error_id = errorId;
	}
	public String getError_customer_name() {
		return error_customer_name;
	}
	public void setError_customer_name(String errorCustomerName) {
		error_customer_name = errorCustomerName;
	}
	public String getError_telephone() {
		return error_telephone;
	}
	public void setError_telephone(String errorTelephone) {
		error_telephone = errorTelephone;
	}
	public String getError_content() {
		return error_content;
	}
	public void setError_content(String errorContent) {
		error_content = errorContent;
	}
	public int getError_status() {
		return error_status;
	}
	public void setError_status(int errorStatus) {
		error_status = errorStatus;
	}
	public String getError_deal_with() {
		return error_deal_with;
	}
	public void setError_deal_with(String errorDealWith) {
		error_deal_with = errorDealWith;
	}

}
