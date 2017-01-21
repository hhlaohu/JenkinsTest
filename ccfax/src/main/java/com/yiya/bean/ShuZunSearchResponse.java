package com.yiya.bean;

import java.util.List;

public class ShuZunSearchResponse extends ShuZunBaseResponse{
	private String resCode;
	private String resMsg;
	private String sign;
	private List<ShuZunSearchData> data;
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
	public List<ShuZunSearchData> getData() {
		return data;
	}
	public void setData(List<ShuZunSearchData> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ShuZunSearchResponse [resCode=" + resCode + ", resMsg=" + resMsg + ", sign=" + sign + ", data=" + data
				+ "]";
	}
	

}
