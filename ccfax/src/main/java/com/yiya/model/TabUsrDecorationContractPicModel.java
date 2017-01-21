package com.yiya.model;

import javax.persistence.Column;
import javax.persistence.Id;

/** 装修合同照片**/
public class TabUsrDecorationContractPicModel extends BaseModel{
	/**自增长id**/
	@Id
	private Integer id;

	/**装修房产订单id**/
	@Column
	private Integer decoration_order_id;

	/**照片描述**/
	@Column
	private String pic_desc;

	/**照片地址**/
	@Column
	private String pic_addr;

	/**订单号**/
	@Column
	private String order_sn;

	/**是否打码，0：未打码，1：打码**/
	@Column
	private Integer pic_type;
	
	/**图片排序序号**/
	@Column
	private Integer sequence;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDecoration_order_id() {
		return decoration_order_id;
	}

	public void setDecoration_order_id(Integer decoration_order_id) {
		this.decoration_order_id = decoration_order_id;
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

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public Integer getPic_type() {
		return pic_type;
	}

	public void setPic_type(Integer pic_type) {
		this.pic_type = pic_type;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	
}