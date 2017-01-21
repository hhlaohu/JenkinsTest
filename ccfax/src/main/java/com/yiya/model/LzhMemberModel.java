package com.yiya.model;

import java.util.Date;

/**
 * @author frank_wang
 * @data 2016年11月5日
 * @description 链金所会员信息
 */
public class LzhMemberModel extends BaseModel {

	private Integer is_vip;
	
	private String user_phone;
	
	private String user_name;
	
	private String real_name;
	
	/**1是个人 2是企业用户*/
	private Integer user_regtype; 
	
	private Integer id_status;
	
	private Long usrid;
	
	private Integer reg_time;
	
	private Date reg_time_date;
	
	private Integer company_status;
	
	private boolean member_auth;

	public Integer getIs_vip() {
		return is_vip;
	}

	public void setIs_vip(Integer is_vip) {
		this.is_vip = is_vip;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public Integer getUser_regtype() {
		return user_regtype;
	}

	public void setUser_regtype(Integer user_regtype) {
		this.user_regtype = user_regtype;
	}

	public Integer getId_status() {
		return id_status;
	}

	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}

	public Long getUsrid() {
		return usrid;
	}

	public void setUsrid(Long usrid) {
		this.usrid = usrid;
	}

	public Integer getReg_time() {
		return reg_time;
	}

	public void setReg_time(Integer reg_time) {
		this.reg_time = reg_time;
	}

	public Date getReg_time_date() {
		return reg_time_date;
	}

	public void setReg_time_date(Date reg_time_date) {
		this.reg_time_date = reg_time_date;
	}

	public Integer getCompany_status() {
		return company_status;
	}

	public void setCompany_status(Integer company_status) {
		this.company_status = company_status;
	}
	
	public boolean isMember_auth() {
		return member_auth;
	}

	public void setMember_auth(boolean member_auth) {
		this.member_auth = member_auth;
	}

	@Override
	public String toString() {
		return "LzhMemberModel [is_vip=" + is_vip + ", user_phone=" + user_phone + ", user_name=" + user_name
				+ ", real_name=" + real_name + ", user_regtype=" + user_regtype + ", id_status=" + id_status
				+ ", usrid=" + usrid + ", reg_time=" + reg_time + ", reg_time_date=" + reg_time_date
				+ ", company_status=" + company_status + ", member_auth=" + member_auth + "]";
	}
	
}
