package com.yiya.bean;


import java.util.List;

import javax.persistence.Column;

import com.yiya.model.DebtBorrowCheckLog;

/** **/
public class TabDebtBorrowInfo extends BaseBean {
	
	@Column 
	private Integer borrow_id;

	@Column
	private String  user_name;

	@Column
	private String borrow_name;

	@Column
	private String investor_capital;

	@Column
	private String borrow_interest_rate;

	@Column
	private String collect_total;

	@Column
	private String tran_total;

	@Column
	private String total;

	@Column
	private String collect_interest;

	@Column
	private String totalmoney;

	@Column
	private String tran_price;

	@Column
	private String debt_rate;

	@Column
	private String debt_addtime;

	@Column
	private Integer borrow_status;
	
	private List<DebtBorrowCheckLog> check_remark_dataList;

	public Integer getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(Integer borrow_id) {
		this.borrow_id = borrow_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getBorrow_name() {
		return borrow_name;
	}

	public void setBorrow_name(String borrow_name) {
		this.borrow_name = borrow_name;
	}

	public String getInvestor_capital() {
		return investor_capital;
	}

	public void setInvestor_capital(String investor_capital) {
		this.investor_capital = investor_capital;
	}

	public String getBorrow_interest_rate() {
		return borrow_interest_rate;
	}

	public void setBorrow_interest_rate(String borrow_interest_rate) {
		this.borrow_interest_rate = borrow_interest_rate;
	}

	public String getCollect_total() {
		return collect_total;
	}

	public void setCollect_total(String collect_total) {
		this.collect_total = collect_total;
	}

	public String getTran_total() {
		return tran_total;
	}

	public void setTran_total(String tran_total) {
		this.tran_total = tran_total;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCollect_interest() {
		return collect_interest;
	}

	public void setCollect_interest(String collect_interest) {
		this.collect_interest = collect_interest;
	}

	public String getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getTran_price() {
		return tran_price;
	}

	public void setTran_price(String tran_price) {
		this.tran_price = tran_price;
	}

	public String getDebt_rate() {
		return debt_rate;
	}

	public void setDebt_rate(String debt_rate) {
		this.debt_rate = debt_rate;
	}

	public String getDebt_addtime() {
		return debt_addtime;
	}

	public void setDebt_addtime(String debt_addtime) {
		this.debt_addtime = debt_addtime;
	}

	public Integer getBorrow_status() {
		return borrow_status;
	}

	public void setBorrow_status(Integer borrow_status) {
		this.borrow_status = borrow_status;
	}

	public List<DebtBorrowCheckLog> getCheck_remark_dataList() {
		return check_remark_dataList;
	}

	public void setCheck_remark_dataList(
			List<DebtBorrowCheckLog> check_remark_dataList) {
		this.check_remark_dataList = check_remark_dataList;
	}
	
}