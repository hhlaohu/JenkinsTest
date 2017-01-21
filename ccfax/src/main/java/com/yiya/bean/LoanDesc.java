package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.yiya.utils.DateUtil;

/**
 * 
 * @Description
 * @Company tesu
 * @author lifaqiu
 * @date 2017-1-10
 */
public class LoanDesc extends BaseBean{

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
	private String qudao;
	
	private Integer pid;
	private String phone;
	private String uname;
	private String idcard;
	private String area;
	private String asset;
	private String bankcard;
	private String bank_state;
	private String city;
	private String handcard_pic;
	private String id_card_front_pic;
	private String id_card_reverse_pic;
	private String income;
	private String marray;
	private String marray_;
	private String position;
	private String province;
	private String work;
	private String work_time;
	private String xueli;
	private String zhengxin_pic;
	private String zhufang;

	private String handcard_pic_s;
	private String handcard_pic_m;
	private String id_card_front_pic_s;
	private String id_card_front_pic_m;
	private String id_card_reverse_pic_s;
	private String id_card_reverse_pic_m;
	
	public String getMarray_() {
		
		return marray_;
	}
	public void setMarray_(String marray_) {
		this.marray_ = marray_;
	}
	public String getHandcard_pic_s() {
		return handcard_pic_s;
	}
	public void setHandcard_pic_s(String handcard_pic_s) {
		this.handcard_pic_s = handcard_pic_s;
	}
	public String getHandcard_pic_m() {
		return handcard_pic_m;
	}
	public void setHandcard_pic_m(String handcard_pic_m) {
		this.handcard_pic_m = handcard_pic_m;
	}
	public String getId_card_front_pic_s() {
		return id_card_front_pic_s;
	}
	public void setId_card_front_pic_s(String id_card_front_pic_s) {
		this.id_card_front_pic_s = id_card_front_pic_s;
	}
	public String getId_card_front_pic_m() {
		return id_card_front_pic_m;
	}
	public void setId_card_front_pic_m(String id_card_front_pic_m) {
		this.id_card_front_pic_m = id_card_front_pic_m;
	}
	public String getId_card_reverse_pic_s() {
		return id_card_reverse_pic_s;
	}
	public void setId_card_reverse_pic_s(String id_card_reverse_pic_s) {
		this.id_card_reverse_pic_s = id_card_reverse_pic_s;
	}
	public String getId_card_reverse_pic_m() {
		return id_card_reverse_pic_m;
	}
	public void setId_card_reverse_pic_m(String id_card_reverse_pic_m) {
		this.id_card_reverse_pic_m = id_card_reverse_pic_m;
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
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public String getBank_state() {
		return bank_state;
	}
	public void setBank_state(String bank_state) {
		this.bank_state = bank_state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHandcard_pic() {
		return handcard_pic;
	}
	public void setHandcard_pic(String handcard_pic) {
		this.handcard_pic = handcard_pic;
	}
	public String getId_card_front_pic() {
		return id_card_front_pic;
	}
	public void setId_card_front_pic(String id_card_front_pic) {
		this.id_card_front_pic = id_card_front_pic;
	}
	public String getId_card_reverse_pic() {
		return id_card_reverse_pic;
	}
	public void setId_card_reverse_pic(String id_card_reverse_pic) {
		this.id_card_reverse_pic = id_card_reverse_pic;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getMarray() {
		return marray;
	}
	public void setMarray(String marray) {
		this.marray = marray;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getZhengxin_pic() {
		return zhengxin_pic;
	}
	public void setZhengxin_pic(String zhengxin_pic) {
		this.zhengxin_pic = zhengxin_pic;
	}
	public String getZhufang() {
		return zhufang;
	}
	public void setZhufang(String zhufang) {
		this.zhufang = zhufang;
	}
	
	
}
