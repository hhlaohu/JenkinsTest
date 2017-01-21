package com.yiya.bean;

import javax.persistence.Column;
import javax.persistence.Id;


public class AlertConfig extends BaseBean {
	/****/
	@Id
	private Long id;

	/**预警条件**/
	@Column
	private String alert_condition;

	/**消息接收人(1.客户，2.风控，3.客户/风控)**/
	@Column
	private Integer msg_status;

	/**风控消息接收人**/
	@Column
	private String msg_with;

	/**通知方式(1.短信)**/
	@Column
	private Integer notice_type;

	/**短信内容**/
	@Column
	private String msg_content;
	
	/**风控消息接收人电话**/
	@Column
	private String wcmr_tel;

	public String getWcmr_tel() {
		return wcmr_tel;
	}

	public void setWcmr_tel(String wcmrTel) {
		wcmr_tel = wcmrTel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlert_condition() {
		return alert_condition;
	}

	public void setAlert_condition(String alert_condition) {
		this.alert_condition = alert_condition;
	}

	public Integer getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(Integer msg_status) {
		this.msg_status = msg_status;
	}

	public String getMsg_with() {
		return msg_with;
	}

	public void setMsg_with(String msg_with) {
		this.msg_with = msg_with;
	}

	public Integer getNotice_type() {
		return notice_type;
	}

	public void setNotice_type(Integer notice_type) {
		this.notice_type = notice_type;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	
}