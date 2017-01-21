package com.yiya.model;

import java.math.BigDecimal;

public class DbjeModel extends BaseModel{
	private int db_id;
	private int dbr_id;
	private String dbr_name;
	private int bdbr_id;
	private String bdbr_name;
	private  BigDecimal db_money;
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
