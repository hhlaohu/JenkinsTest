package com.yiya.model;

public class JuXinLiGetRequestModel {
    private String access_token;
    private String name;
    private String idcard;
    private String phone;
    
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "JuXinLiGetRequestModel [access_token=" + access_token + ", name=" + name + ", idcard=" + idcard
				+ ", phone=" + phone + "]";
	}

}
