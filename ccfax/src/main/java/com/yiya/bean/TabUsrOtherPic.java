package com.yiya.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/** 其他增信资料照片表**/
public class TabUsrOtherPic extends BaseBean {
	/****/
	@Id
	private Integer id;

	/**对应用户基本信息id**/
	@Column
	private Integer usrinf_id;

	/**照片描述**/
	@Column
	private String pic_desc;

	/**照片描述**/
	@Column
	private String pic_addr;


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

	public void setPic_desc(String pic_desc) {
		this.pic_desc=pic_desc;
	}

	public String getPic_desc() {
		return this.pic_desc;
	}

	public void setPic_addr(String pic_addr) {
		this.pic_addr=pic_addr;
	}

	public String getPic_addr() {
		return this.pic_addr;
	}


}