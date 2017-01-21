package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerBean {
	private Integer customer_id;//   id主键
	private String customer_name;//  客户姓名
	private String customer_code;//   客户代码
	private Integer customer_type;//   客户类型：0，融资客户，1，授信客户，2，一般客户
	private String addr;//   客户地址
	private String tel;//   联系电话
	private String business_desc;//   客户经营信息概述
	private BigDecimal financing_cnt;//   融资额度
	private Integer lock_status;//锁定标志，0：未锁定，1：锁定
	
	private String salesman;//   业务员
	private long add_date;//   录入时间
	
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
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public Integer getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(Integer customer_type) {
		this.customer_type = customer_type;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBusiness_desc() {
		return business_desc;
	}
	public void setBusiness_desc(String business_desc) {
		this.business_desc = business_desc;
	}
	public BigDecimal getFinancing_cnt() {
		return financing_cnt;
	}
	public void setFinancing_cnt(BigDecimal financing_cnt) {
		this.financing_cnt = financing_cnt;
	}
	public Integer getLock_status() {
		return lock_status;
	}
	public void setLock_status(Integer lock_status) {
		this.lock_status = lock_status;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(long add_date) {
		this.add_date = add_date;
	}


}
