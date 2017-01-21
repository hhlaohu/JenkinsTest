package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TabApplyLog extends BaseBean{
	/**
	 * 申请记录
	 */
		private Integer id;
		private Integer usrinf_id;
		private Date apply_time;//申请时间
		private String check_result;//审核结果
		private BigDecimal applyfor_limit;//申请授信额度
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
		public Date getApply_time() {
			return apply_time;
		}
		public void setApply_time(Date apply_time) {
			this.apply_time = apply_time;
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


}
