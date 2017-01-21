package com.yiya.bean;


import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;

/** 担保人基本信息表**/
public class TabBondsmaninf extends BaseBean {
	/****/
	@Id
	private Integer id;

	/**对应用户基本信息id**/
	@Column
	private Integer usrinf_id;

	/**关系姓名**/
	@Column
	private String rel_usrname;

	/**关系**/
	@Column
	private String relation;

	/**手机号码**/
	@Column
	private String rel_mobile_phone;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsrinf_id() {
		return usrinf_id;
	}

	public void setUsrinf_id(Integer usrinf_id) {
		this.usrinf_id = usrinf_id;
	}

	public String getRel_usrname() {
		return rel_usrname;
	}

	public void setRel_usrname(String rel_usrname) {
		this.rel_usrname = rel_usrname;
	}

	public void setRelation(String relation) {
		this.relation=relation;
	}

	public String getRelation() {
		return this.relation;
	}

	public String getRel_mobile_phone() {
		return rel_mobile_phone;
	}

	public void setRel_mobile_phone(String rel_mobile_phone) {
		this.rel_mobile_phone = rel_mobile_phone;
	}

}