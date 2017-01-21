package com.yiya.model;

import java.math.BigDecimal;

public class OperatorDailyModel extends BaseModel {
	private int operator_id;
	private String operator;
	private String operator_time;
	private String operator_content;
	private int customer_id;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customerId) {
		customer_id = customerId;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operatorId) {
		operator_id = operatorId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operatorTime) {
		operator_time = operatorTime;
	}
	public String getOperator_content() {
		return operator_content;
	}
	public void setOperator_content(String operatorContent) {
		operator_content = operatorContent;
	}

	


}
