package com.yiya.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;


public class AlertDailyModel extends BaseModel {
	/****/
	@Id
	private Long alert_id;

	/**警告时间**/
	@Column
	private Date alert_time;

	/**问题**/
	@Column
	private String alert_content;

	/**状态(0:跟进,1,待处理,2.已解决)**/
	@Column
	private Integer deal_status;

	/**处理人**/
	@Column
	private String deal_with;

	/**处理时间**/
	@Column
	private Date deal_time;
	
	
	private Date alert_time_start;//警告开始时间
	
	private Date alert_time_end;//警告结束时间

	public void setAlert_id(Long alert_id) {
		this.alert_id=alert_id;
	}

	public Long getAlert_id() {
		return this.alert_id;
	}

	public void setAlert_time(Date alert_time) {
		this.alert_time=alert_time;
	}

	public Date getAlert_time() {
		return this.alert_time;
	}
	
	
	public void setAlert_content(String alert_content) {
		this.alert_content=alert_content;
	}

	public String getAlert_content() {
		return this.alert_content;
	}

	public void setDeal_status(Integer deal_status) {
		this.deal_status=deal_status;
	}

	public Integer getDeal_status() {
		return this.deal_status;
	}

	public void setDeal_with(String deal_with) {
		this.deal_with=deal_with;
	}

	public String getDeal_with() {
		return this.deal_with;
	}

	public void setDeal_time(Date deal_time) {
		this.deal_time=deal_time;
	}

	public Date getDeal_time() {
		return this.deal_time;
	}

	public Date getAlert_time_start() {
		return alert_time_start;
	}

	public void setAlert_time_start(Date alert_time_start) {
		this.alert_time_start = alert_time_start;
	}

	public Date getAlert_time_end() {
		return alert_time_end;
	}

	public void setAlert_time_end(Date alert_time_end) {
		this.alert_time_end = alert_time_end;
	}

	
}