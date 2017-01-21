package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月15日
 * @description
 */
public class TabScoringReportModel extends BaseModel {

	private Integer report_id;

	private Integer usrid;

	private BigDecimal sum_score;

	private Date create_time;

	private Integer add_usr_id;
	
	private BigDecimal scoring_quota;

	public Integer getReport_id() {
		return report_id;
	}

	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public BigDecimal getSum_score() {
		return sum_score;
	}

	public void setSum_score(BigDecimal sum_score) {
		this.sum_score = sum_score;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getAdd_usr_id() {
		return add_usr_id;
	}

	public void setAdd_usr_id(Integer add_usr_id) {
		this.add_usr_id = add_usr_id;
	}
	
	public BigDecimal getScoring_quota() {
		return scoring_quota;
	}

	public void setScoring_quota(BigDecimal scoring_quota) {
		this.scoring_quota = scoring_quota;
	}

	@Override
	public String toString() {
		return "TabScoringReportModel [report_id=" + report_id + ", usrid=" + usrid + ", sum_score=" + sum_score
				+ ", create_time=" + create_time + ", add_usr_id=" + add_usr_id + ", scoring_quota=" + scoring_quota
				+ "]";
	}

}