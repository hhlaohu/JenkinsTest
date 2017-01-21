package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.yiya.utils.DateUtil;

/**
 * 
 * @Description
 * @Company tesu
 * @author lifaqiu
 * @date 2017-1-10
 */
public class Loan extends BaseBean{

	private Integer id;
	private Integer uid;
	private String purpose;
	private BigDecimal amount;
	private String deadline;
	private Date addtime;
	private String addtime_;
	private Integer status;
	private String status_;
	private Integer user_type;
	private String user_type_;
	private String phone;
	private String uname;
	private String idcard;
	private String qudao;
	private Boolean deal;
	
	
	public Boolean getDeal() {
		return deal;
	}
	public void setDeal(Boolean deal) {
		this.deal = deal;
	}
	public String getQudao() {
		return qudao;
	}
	public void setQudao(String qudao) {
		this.qudao = qudao;
	}
	public String getAddtime_() {
		if (addtime != null) {
			return DateUtil.getPlusTime2(addtime);
		}
		return "";
	}
	public void setAddtime_(String addtime_) {
		this.addtime_ = addtime_;
	}
	public String getStatus_() {
		if (status == null) {
			return "未知";
		}
		if (status == 0) {
			return "待处理";
		}else if (status == 1) {
			return "已处理";
		}else {			
			return "未知";
		}
	}
	public void setStatus_(String status_) {
		this.status_ = status_;
	}
	public String getUser_type_() {
		if (user_type == null) {
			return "未知";
		}
		if (user_type == 1) {
			return "个人";
		}else if (user_type == 2) {
			return "企业";
		}else {			
			return "未知";
		}
	}
	public void setUser_type_(String user_type_) {
		this.user_type_ = user_type_;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public BigDecimal getAmount() {
		if (amount != null) {
			amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	
}
