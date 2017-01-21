package com.yiya.model;

import java.math.BigDecimal;

public class TabCustomerModel extends BaseModel {
	private int tab_id;
	private Integer customer_id;
	private String customer_name;
	private Integer customer_type;
	private String address;
	private String telephone;
	private BigDecimal credit_limit;
	private BigDecimal borrow_balance;
	private BigDecimal guarant_balance;
	private BigDecimal rc_guarant_balance;
	private BigDecimal lock_line;
	private BigDecimal temporary_lock_line;
	private String start_time;
	private String end_time;
	private BigDecimal stock_value;
	private BigDecimal break_Stock_value;
	private String comment_contente;
	private String comment_person;

	public int getTab_id() {
		return tab_id;
	}

	public void setTab_id(int tab_id) {
		this.tab_id = tab_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Integer getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(Integer customer_type) {
		this.customer_type = customer_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public BigDecimal getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}

	public BigDecimal getBorrow_balance() {
		return borrow_balance;
	}

	public void setBorrow_balance(BigDecimal borrow_balance) {
		this.borrow_balance = borrow_balance;
	}

	public BigDecimal getGuarant_balance() {
		return guarant_balance;
	}

	public void setGuarant_balance(BigDecimal guarant_balance) {
		this.guarant_balance = guarant_balance;
	}

	public BigDecimal getRc_guarant_balance() {
		return rc_guarant_balance;
	}

	public void setRc_guarant_balance(BigDecimal rc_guarant_balance) {
		this.rc_guarant_balance = rc_guarant_balance;
	}

	public BigDecimal getLock_line() {
		return lock_line;
	}

	public void setLock_line(BigDecimal lock_line) {
		this.lock_line = lock_line;
	}

	public BigDecimal getTemporary_lock_line() {
		return temporary_lock_line;
	}

	public void setTemporary_lock_line(BigDecimal temporary_lock_line) {
		this.temporary_lock_line = temporary_lock_line;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public BigDecimal getStock_value() {
		return stock_value;
	}

	public void setStock_value(BigDecimal stock_value) {
		this.stock_value = stock_value;
	}

	public BigDecimal getBreak_Stock_value() {
		return break_Stock_value;
	}

	public void setBreak_Stock_value(BigDecimal break_Stock_value) {
		this.break_Stock_value = break_Stock_value;
	}

	public String getComment_contente() {
		return comment_contente;
	}

	public void setComment_contente(String comment_contente) {
		this.comment_contente = comment_contente;
	}

	public String getComment_person() {
		return comment_person;
	}

	public void setComment_person(String comment_person) {
		this.comment_person = comment_person;
	}

}
