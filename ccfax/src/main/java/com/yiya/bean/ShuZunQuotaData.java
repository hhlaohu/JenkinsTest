package com.yiya.bean;

import java.util.List;

public class ShuZunQuotaData {
	private String quotaID;
	private int quotaType;
	private String quotaName;
	private double quotaPrice;
	private List<ShuZunQuotaParam> quotaParamList;
	private String quotaValueDesc;
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
	public List<ShuZunQuotaParam> getQuotaParamList() {
		return quotaParamList;
	}
	public void setQuotaParamList(List<ShuZunQuotaParam> quotaParamList) {
		this.quotaParamList = quotaParamList;
	}
	public String getQuotaValueDesc() {
		return quotaValueDesc;
	}
	public void setQuotaValueDesc(String quotaValueDesc) {
		this.quotaValueDesc = quotaValueDesc;
	}
	@Override
	public String toString() {
		return "ShuZunQuotaData [quotaID=" + quotaID + ", quotaType="
				+ quotaType + ", quotaName=" + quotaName + ", quotaPrice="
				+ quotaPrice + ", quotaParamList=" + quotaParamList
				+ ", quotaValueDesc=" + quotaValueDesc + "]";
	}

}
