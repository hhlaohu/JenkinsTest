package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;


public class TabCheckLogModel extends BaseModel{
	
	private Integer id;
	private Integer usrinf_id;
	private Date operate_time;//操作时间
	private String operator;//操作人
	private String check_result;//审核结果
	private BigDecimal applyfor_limit;//申请授信额度
	private BigDecimal loan_limit;//贷款总额度
	private BigDecimal second_check_loan_limit;//复审额度
	private String check_remark;//审核意见

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
	public Date getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCheck_result() {
		return check_result;
	}
	public void setCheck_result(String check_result) {
		this.check_result = check_result;
	}
	public BigDecimal getApplyfor_limit() {
		return applyfor_limit;
	}
	public void setApplyfor_limit(BigDecimal applyfor_limit) {
		this.applyfor_limit = applyfor_limit;
	}
	public String getCheck_remark() {
		return check_remark;
	}
	public void setCheck_remark(String check_remark) {
		this.check_remark = check_remark;
	}
	public BigDecimal getLoan_limit() {
		return loan_limit;
	}
	public void setLoan_limit(BigDecimal loan_limit) {
		this.loan_limit = loan_limit;
	}
	public BigDecimal getSecond_check_loan_limit() {
		return second_check_loan_limit;
	}
	public void setSecond_check_loan_limit(BigDecimal second_check_loan_limit) {
		this.second_check_loan_limit = second_check_loan_limit;
	}

}