package com.yiya.bean;

public class ShuZunQuotaInfo {
	private String quotaID;
	private int quotaType;
	private String quotaName;
	private double quotaPrice;
	private String quotaValue;
	public String getQuotaID() {
		return quotaID;
	}
	public void setQuotaID(String quotaID) {
		this.quotaID = quotaID;
	}
	public int getQuotaType() {
		return quotaType;
	}
	public void setQuotaType(int quotaType) {
		this.quotaType = quotaType;
	}
	public String getQuotaName() {
		return quotaName;
	}
	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}
	public double getQuotaPrice() {
		return quotaPrice;
	}
	public void setQuotaPrice(double quotaPrice) {
		this.quotaPrice = quotaPrice;
	}
	public String getQuotaValue() {
		return quotaValue;
	}
	public void setQuotaValue(String quotaValue) {
		this.quotaValue = quotaValue;
	}
	@Override
	public String toString() {
		return "ShuZunQuotaInfo [quotaID=" + quotaID + ", quotaType=" + quotaType + ", quotaName=" + quotaName
				+ ", quotaPrice=" + quotaPrice + ", quotaValue=" + quotaValue + "]";
	}
	

}
