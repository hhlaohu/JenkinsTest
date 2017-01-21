package com.yiya.model;

public class SysUserModel extends BaseModel {
	
	private Integer id;//   id主键	private String usr_name;//   登录帐号
	private String usr_pass;//   登录密码
	private String real_name;//   真实姓名
	private String login_ip;//   登录ip	private Integer state;//   状态 0=可用,1=禁用	private Integer loginCount;//   登录总次数	private java.sql.Timestamp loginTime;//   最后登录时间	private Integer deleted;//   删除状态 0=未删除,1=已删除	private java.sql.Timestamp createTime;//   创建时间	private java.sql.Timestamp updateTime;//   修改时间	private Integer createBy;//   创建人	private Integer updateBy;//   修改人
	private String tel;
	private Integer is_send_message;// 是否发送短信
	
		public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getUsr_name() {
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
	public Integer getState() {	    return this.state;	}	public void setState(Integer state) {	    this.state=state;	}	public Integer getLoginCount() {	    return this.loginCount;	}	public void setLoginCount(Integer loginCount) {	    this.loginCount=loginCount;	}	public java.sql.Timestamp getLoginTime() {	    return this.loginTime;	}	public void setLoginTime(java.sql.Timestamp loginTime) {	    this.loginTime=loginTime;	}	public Integer getDeleted() {	    return this.deleted;	}	public void setDeleted(Integer deleted) {	    this.deleted=deleted;	}	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}	public java.sql.Timestamp getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.sql.Timestamp updateTime) {	    this.updateTime=updateTime;	}	public Integer getCreateBy() {	    return this.createBy;	}	public void setCreateBy(Integer createBy) {	    this.createBy=createBy;	}	public Integer getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(Integer updateBy) {	    this.updateBy=updateBy;	}
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
