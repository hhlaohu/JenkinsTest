package com.yiya.bean;

import java.math.BigDecimal;

public class Dbje extends BaseBean {
	private int db_id; //主键id
	private int dbr_id; //担保客户id
	private String dbr_name; //担保客户姓名
	private int bdbr_id; //被担保人id
	private String bdbr_name; //被担保人姓名
	private  BigDecimal db_money; //担保金额
	public int getDb_id() {
		return db_id;
	}
	public void setDb_id(int dbId) {
		db_id = dbId;
	}
	public int getDbr_id() {
		return dbr_id;
	}
	public void setDbr_id(int dbrId) {
		dbr_id = dbrId;
	}
	public String getDbr_name() {
		return dbr_name;
	}
	public void setDbr_name(String dbrName) {
		dbr_name = dbrName;
	}
	public int getBdbr_id() {
		return bdbr_id;
	}
	public void setBdbr_id(int bdbrId) {
		bdbr_id = bdbrId;
	}
	public String getBdbr_name() {
		return bdbr_name;
	}
	public void setBdbr_name(String bdbrName) {
		bdbr_name = bdbrName;
	}
	public BigDecimal getDb_money() {
		return db_money;
	}
	public void setDb_money(BigDecimal dbMoney) {
		db_money = dbMoney;
	}


}
