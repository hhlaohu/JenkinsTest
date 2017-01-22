package com.yiya.bean;


import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;

/** 规格配置信息表**/
public class SpecConfig extends BaseBean {
	/**对应配置管理规格(pz_good_size)**/
	@Id
	private Integer spec_id;

	/**规格名称**/
	@Column
	private String spec_name;

	/**规格类型(值为0：A类；值为1：B类)，A：固定类型如：1/4,2.5；B：范围类型如：1-2，对应于仓库的M*N。**/
	@Column
	private Integer spec_type;

	/**规格起始值**/
	@Column
	private Integer value_begin;

	/**规格结束值**/
	@Column
	private Integer value_end;

	
	
	public Integer getSpec_id() {
		return spec_id;
	}

	public void setSpec_id(Integer spec_id) {
		this.spec_id = spec_id;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name=spec_name;
	}

	public String getSpec_name() {
		return this.spec_name;
	}

	public void setSpec_type(Integer spec_type) {
		this.spec_type=spec_type;
	}

	public Integer getSpec_type() {
		return this.spec_type;
	}

	public void setValue_begin(Integer value_begin) {
		this.value_begin=value_begin;
	}

	public Integer getValue_begin() {
		return this.value_begin;
	}

	public void setValue_end(Integer value_end) {
		this.value_end=value_end;
	}

	public Integer getValue_end() {
		return this.value_end;
	}

}