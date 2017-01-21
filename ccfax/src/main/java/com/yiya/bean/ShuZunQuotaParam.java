package com.yiya.bean;

public class ShuZunQuotaParam {
	private String quotaParamID;
	private String quotaParamDesc;
	private String quotaParamRequired;
	public String getQuotaParamID() {
		return quotaParamID;
	}
	public void setQuotaParamID(String quotaParamID) {
		this.quotaParamID = quotaParamID;
	}
	public String getQuotaParamDesc() {
		return quotaParamDesc;
	}
	public void setQuotaParamDesc(String quotaParamDesc) {
		this.quotaParamDesc = quotaParamDesc;
	}
	public String getQuotaParamRequired() {
		return quotaParamRequired;
	}
	public void setQuotaParamRequired(String quotaParamRequired) {
		this.quotaParamRequired = quotaParamRequired;
	}
	@Override
	public String toString() {
		return "ShuZunQuotaParam [quotaParamID=" + quotaParamID
				+ ", quotaParamDesc=" + quotaParamDesc
				+ ", quotaParamRequired=" + quotaParamRequired + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quotaParamID == null) ? 0 : quotaParamID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShuZunQuotaParam other = (ShuZunQuotaParam) obj;
		if (quotaParamID == null) {
			if (other.quotaParamID != null)
				return false;
		} else if (!quotaParamID.equals(other.quotaParamID))
			return false;
		return true;
	}
	

}
