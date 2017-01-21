package com.yiya.bean;

public class ShuZunBaseResponse {
	private String resCode;
	private String resMsg;
	private String sign;
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
	@Override
	public String toString() {
		return "ShuZunBaseResponse [resCode=" + resCode + ", resMsg=" + resMsg + ", sign=" + sign + "]";
	}
	

}
