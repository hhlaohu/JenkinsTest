package com.yiya.model;

public class SysUserModel extends BaseModel {
	
	private Integer id;//   id主键
	private String usr_pass;//   登录密码
	private String real_name;//   真实姓名
	private String login_ip;//   登录ip
	private String tel;
	private Integer is_send_message;// 是否发送短信
	
	
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getId() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_pass() {
		return usr_pass;
	}
	public void setUsr_pass(String usr_pass) {
		this.usr_pass = usr_pass;
	}
	public Integer getState() {
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Integer getIs_send_message() {
		return is_send_message;
	}
	public void setIs_send_message(Integer is_send_message) {
		this.is_send_message = is_send_message;
	}
	
}