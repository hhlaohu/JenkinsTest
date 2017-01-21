package com.yiya.bean;

import java.util.List;

public class ShuZunQuotalistResponse {
	private String resCode;
	private String resMsg;
	private String sign;
	private List<ShuZunQuotaData> data;
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<ShuZunQuotaData> getData() {
		return data;
	}
	public void setData(List<ShuZunQuotaData> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ShuZunQuotalistResponse [resCode=" + resCode + ", resMsg="
				+ resMsg + ", sign=" + sign + ", data=" + data + "]";
	}
	

}
