package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TabCheckLog extends BaseBean{
	
		private Integer id;
		private Integer usrinf_id;//对应用户基本信息id
		private Date operate_time;//操作时间
		private String operator;//操作人
		private String check_result;//审核结果
		private BigDecimal applyfor_limit;//申请初审额度
		private BigDecimal loan_limit;//贷款总额度
		private BigDecimal second_check_loan_limit;//复审额度
		private String check_remark;//审核意见
		
		
		private String user_name; //当前登录帐号(额度审核操作人)
		
		private Date limit_validity_time;//额度有效期
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
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public BigDecimal getLoan_limit() {
			return loan_limit;
		}
		public void setLoan_limit(BigDecimal loan_limit) {
			this.loan_limit = loan_limit;
		}
		public Date getLimit_validity_time() {
			return limit_validity_time;
		}
		public void setLimit_validity_time(Date limit_validity_time) {
			this.limit_validity_time = limit_validity_time;
		}
		public BigDecimal getSecond_check_loan_limit() {
			return second_check_loan_limit;
		}
		public void setSecond_check_loan_limit(BigDecimal second_check_loan_limit) {
			this.second_check_loan_limit = second_check_loan_limit;
		}
		
}
