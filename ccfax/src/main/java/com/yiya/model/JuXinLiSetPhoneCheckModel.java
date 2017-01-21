package com.yiya.model;

public class JuXinLiSetPhoneCheckModel {
    private String token;
    private String account;
    private String password;
    private String captcha;
    private String type;
    private String website;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "JuXinLiSetPhoneCheckModel [token=" + token + ", account=" + account + ", password=" + password
				+ ", captcha=" + captcha + ", type=" + type + ", website=" + website + "]";
	}
    
    
}
