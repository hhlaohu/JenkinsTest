package com.yiya.bean;

public class ShuZunSearchData {
	private String resCode;
	private String resMsg;
	private ShuZunQuotaInfo quotaInfo;
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public ShuZunQuotaInfo getQuotaInfo() {
		return quotaInfo;
	}
	public void setQuotaInfo(ShuZunQuotaInfo quotaInfo) {
		this.quotaInfo = quotaInfo;
	}
	@Override
	public String toString() {
		return "ShuZunSearchData [resCode=" + resCode + ", resMsg=" + resMsg + ", quotaInfo=" + quotaInfo + "]";
	}

}
