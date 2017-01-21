package com.yiya.model;
import javax.persistence.Column;
import javax.persistence.Id;

/** 补充资料照片表**/
public class TabUsrComplementPicModel extends BaseModel{
	/****/
	@Id
	private Integer id;

	/**对应用户基本信息id**/
	@Column
	private Integer usrinf_id;

	/**补充照片描述**/
	@Column
	private String com_pic_desc;

	/**补充照片url**/
	@Column
	private String com_pic_addr;
	
	/**图片类型，是否打码，0：未打码，1：打码**/
	@Column
	private Integer pic_type;
	

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

	public void setCom_pic_desc(String com_pic_desc) {
		this.com_pic_desc=com_pic_desc;
	}

	public String getCom_pic_desc() {
		return this.com_pic_desc;
	}

	public void setCom_pic_addr(String com_pic_addr) {
		this.com_pic_addr=com_pic_addr;
	}

	public String getCom_pic_addr() {
		return this.com_pic_addr;
	}

	public Integer getPic_type() {
		return pic_type;
	}

	public void setPic_type(Integer pic_type) {
		this.pic_type = pic_type;
	}

}