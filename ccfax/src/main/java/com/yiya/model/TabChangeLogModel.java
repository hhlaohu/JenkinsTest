package com.yiya.model;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

/** **/
public class TabChangeLogModel extends BaseModel{
	/****/
	@Id
	private Integer id;

	/**对应用户基本信息id**/
	@Column
	private Integer usrinf_id;

	/**操作时间**/
	@Column
	private Date ch_operate_time;

	/**操作人**/
	@Column
	private String ch_operator;

	/**动作(变更的资料)**/
	@Column
	private String ch_action;


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

	public void setCh_operate_time(Date ch_operate_time) {
		this.ch_operate_time=ch_operate_time;
	}

	public Date getCh_operate_time() {
		return this.ch_operate_time;
	}

	public void setCh_operator(String ch_operator) {
		this.ch_operator=ch_operator;
	}

	public String getCh_operator() {
		return this.ch_operator;
	}

	public void setCh_action(String ch_action) {
		this.ch_action=ch_action;
	}

	public String getCh_action() {
		return this.ch_action;
	}

}