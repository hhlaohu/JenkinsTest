package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrOtherPic;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月21日
 * @description
 */
public class TabUsrinf2Model extends BaseModel {
	
	private Long usrinf_id;

	@NotNull(message = "usrid 不能为null")
	private Long usrid;

	private String usrname;

	private String id_card;

	private Byte sex;

	private Integer age;

	private Byte marital;

	private String mobile_phone;

	private Integer diploma;

	private Integer register_place;

	private Byte local_register_place;

	private String bank_id;

	private Integer income;

	private Byte house_type;

	private Byte fixed_assets;

	private Byte employment;

	private String com_name;

	private Integer industry;

	private Integer profession_level;

	private Integer cur_hire_duration;

	private Integer schooling_system;

	private String graduate_school;

	private String repaying_source;

	private String id_card_front_pic;

	private String id_card_reverse_pic;

	private String with_id_card_pic;

	private String credit_report_pic;

	private Byte is_face_id_pass;

	private Byte applyfo_flag;

	private Byte check_flag;

	private Byte is_loan;

	private BigDecimal second_check_loan_limit;

	private BigDecimal loan_limit;

	private BigDecimal loan_used;

	private Byte is_firstquery;

	private BigDecimal applyfor_limit;

	private Date applyfor_time;

	private String freeze_remark;

	private Byte is_activate;

	private Date limit_validity_time;

	private Date credit_time;

	private Byte credit_type;

	private String first_check_operator;

	private String second_check_operator;

	private String check_alive_pic;

	private Integer xiaoshi_check_alive_result;

	private String xiaoshi_id_card_check_result;

	private Integer xiao_shi_left_times;

	private Date xiao_shi_invocation_time;

	private String xiaoshi_id_card_check_msg;

	private String xiaoshi_id_card_check_score;

	private String xiaoshi_id_card_check_guid;
	
	private String head_portrait_pic;
	
	/** 担保人信息json字符串 */
	private String bondsmaninf_list;
	
	/** 担保人信息列表 */
	private List<TabBondsmaninf> tabBondsmaninfList;

	/** 其它资料照json字符串*/
	private String other_pic_list;
	
	/** 其它资料照片列表*/
	private List<TabUsrOtherPic> tabUsrOtherPicList;
	
	/** 用户订单照片json字符串 */
	private String usr_order_pic_list;
	
	/** 用户订单照片列表 */
	private List<TabUsrOrderPic> tabUsrOrderPicList;
	
	/**订单号 */
	private  String order_sn;
	
	/**订单类型*/
	private Integer order_type;
	
	/**是否有初审权限*/
	private boolean first_veriy_auth; 
	
	/**是否有复审权限*/
	private boolean second_veriy_auth;
	
	/**是否有终审权限*/
	private boolean final_veriy_auth;
	
	/**是否看征信资料的权限*/
	private boolean credit_info_veriy_auth;
	
	/**是否有资料处理权限*/
	private boolean info_handle_auth; 
	
	/**设置评分报告处理权限*/
	private boolean scoring_report_auth;
	
	/**是否上传了打码资料图片*/
	private boolean pic_type_mosaic;
	
	/**查询条件申请起始时间*/
	private Date applyfor_time_start;
	
	/**查询条件申请末尾时间时间*/
	private Date applyfor_time_end;
	
	/**是否过滤额度状态为初始状态的记录**/
	private boolean if_filter_check_flag_initial;
	
	/**是否是商户*/
	private Byte is_store;
	    
	/**借款人姓名*/
	private String borrower_usrname;
	    
	/**借款人身份证号*/
	private String borrower_id_card;
	
	/**省*/
    private Integer area_province;
    
    /**市*/
    private Integer area_city;
    
    /**县*/
    private Integer area_county;
    
    /**订单金额*/
    private BigDecimal order_money;
    
    /**商户店名*/
    private String store_name;
    
    /**订单状态*/
    private Integer order_status;
    
    /**用户类型，0表示普通用户，1表示商户*/
    private String usr_type;
    
    /**商家联系人*/
    private String store_contract;
    
    /**商家电话*/
    private String store_tel;
    
    /**商家ID*/
    private Long store_uid;
    
    /**商家服务费率*/
    private BigDecimal store_charge_rate;
    
    // 交易查询开始时间
    private Integer start_time;
    
    // 交易查询结束时间
    private Integer end_time;
    
    /**借款人手机号*/
    private String borrower_mobile_phone;
    
    private String mobile_imei;
    
    private String mobile_idfa;
    
    private String ip;
    
    /**旅游合同编号*/
    private String contract_number;
    
    /**订单来源*/
    private Integer order_source;
    
    /**用户ID，等同usrid*/
    private Long borrow_uid;
    
	public Integer getStart_time() {
		return start_time;
	}

	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}

	public Integer getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Integer end_time) {
		this.end_time = end_time;
	}

	public Long getUsrinf_id() {
		return usrinf_id;
	}

	public void setUsrinf_id(Long usrinf_id) {
		this.usrinf_id = usrinf_id;
	}

	public Long getUsrid() {
		return usrid;
	}

	public void setUsrid(Long usrid) {
		this.usrid = usrid;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Byte getMarital() {
		return marital;
	}

	public void setMarital(Byte marital) {
		this.marital = marital;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public Integer getDiploma() {
		return diploma;
	}

	public void setDiploma(Integer diploma) {
		this.diploma = diploma;
	}

	public Integer getRegister_place() {
		return register_place;
	}

	public void setRegister_place(Integer register_place) {
		this.register_place = register_place;
	}

	public Byte getLocal_register_place() {
		return local_register_place;
	}

	public void setLocal_register_place(Byte local_register_place) {
		this.local_register_place = local_register_place;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Byte getHouse_type() {
		return house_type;
	}

	public void setHouse_type(Byte house_type) {
		this.house_type = house_type;
	}

	public Byte getFixed_assets() {
		return fixed_assets;
	}

	public void setFixed_assets(Byte fixed_assets) {
		this.fixed_assets = fixed_assets;
	}

	public Byte getEmployment() {
		return employment;
	}

	public void setEmployment(Byte employment) {
		this.employment = employment;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public Integer getIndustry() {
		return industry;
	}

	public void setIndustry(Integer industry) {
		this.industry = industry;
	}

	public Integer getProfession_level() {
		return profession_level;
	}

	public void setProfession_level(Integer profession_level) {
		this.profession_level = profession_level;
	}

	public Integer getCur_hire_duration() {
		return cur_hire_duration;
	}

	public void setCur_hire_duration(Integer cur_hire_duration) {
		this.cur_hire_duration = cur_hire_duration;
	}

	public Integer getSchooling_system() {
		return schooling_system;
	}

	public void setSchooling_system(Integer schooling_system) {
		this.schooling_system = schooling_system;
	}

	public String getGraduate_school() {
		return graduate_school;
	}

	public void setGraduate_school(String graduate_school) {
		this.graduate_school = graduate_school;
	}

	public String getRepaying_source() {
		return repaying_source;
	}

	public void setRepaying_source(String repaying_source) {
		this.repaying_source = repaying_source;
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

	public String getWith_id_card_pic() {
		return with_id_card_pic;
	}

	public void setWith_id_card_pic(String with_id_card_pic) {
		this.with_id_card_pic = with_id_card_pic;
	}

	public String getCredit_report_pic() {
		return credit_report_pic;
	}

	public void setCredit_report_pic(String credit_report_pic) {
		this.credit_report_pic = credit_report_pic;
	}

	public Byte getIs_face_id_pass() {
		return is_face_id_pass;
	}

	public void setIs_face_id_pass(Byte is_face_id_pass) {
		this.is_face_id_pass = is_face_id_pass;
	}

	public Byte getApplyfo_flag() {
		return applyfo_flag;
	}

	public void setApplyfo_flag(Byte applyfo_flag) {
		this.applyfo_flag = applyfo_flag;
	}

	public Byte getCheck_flag() {
		return check_flag;
	}

	public void setCheck_flag(Byte check_flag) {
		this.check_flag = check_flag;
	}

	public Byte getIs_loan() {
		return is_loan;
	}

	public void setIs_loan(Byte is_loan) {
		this.is_loan = is_loan;
	}

	public BigDecimal getSecond_check_loan_limit() {
		return second_check_loan_limit;
	}

	public void setSecond_check_loan_limit(BigDecimal second_check_loan_limit) {
		this.second_check_loan_limit = second_check_loan_limit;
	}

	public BigDecimal getLoan_limit() {
		return loan_limit;
	}

	public void setLoan_limit(BigDecimal loan_limit) {
		this.loan_limit = loan_limit;
	}

	public BigDecimal getLoan_used() {
		return loan_used;
	}

	public void setLoan_used(BigDecimal loan_used) {
		this.loan_used = loan_used;
	}

	public Byte getIs_firstquery() {
		return is_firstquery;
	}

	public void setIs_firstquery(Byte is_firstquery) {
		this.is_firstquery = is_firstquery;
	}

	public BigDecimal getApplyfor_limit() {
		return applyfor_limit;
	}

	public void setApplyfor_limit(BigDecimal applyfor_limit) {
		this.applyfor_limit = applyfor_limit;
	}

	public Date getApplyfor_time() {
		return applyfor_time;
	}

	public void setApplyfor_time(Date applyfor_time) {
		this.applyfor_time = applyfor_time;
	}

	public String getFreeze_remark() {
		return freeze_remark;
	}

	public void setFreeze_remark(String freeze_remark) {
		this.freeze_remark = freeze_remark;
	}

	public Byte getIs_activate() {
		return is_activate;
	}

	public void setIs_activate(Byte is_activate) {
		this.is_activate = is_activate;
	}

	public Date getLimit_validity_time() {
		return limit_validity_time;
	}

	public void setLimit_validity_time(Date limit_validity_time) {
		this.limit_validity_time = limit_validity_time;
	}

	public Date getCredit_time() {
		return credit_time;
	}

	public void setCredit_time(Date credit_time) {
		this.credit_time = credit_time;
	}

	public Byte getCredit_type() {
		return credit_type;
	}

	public void setCredit_type(Byte credit_type) {
		this.credit_type = credit_type;
	}

	public String getFirst_check_operator() {
		return first_check_operator;
	}

	public void setFirst_check_operator(String first_check_operator) {
		this.first_check_operator = first_check_operator;
	}

	public String getSecond_check_operator() {
		return second_check_operator;
	}

	public void setSecond_check_operator(String second_check_operator) {
		this.second_check_operator = second_check_operator;
	}

	public String getCheck_alive_pic() {
		return check_alive_pic;
	}

	public void setCheck_alive_pic(String check_alive_pic) {
		this.check_alive_pic = check_alive_pic;
	}

	public Integer getXiaoshi_check_alive_result() {
		return xiaoshi_check_alive_result;
	}

	public void setXiaoshi_check_alive_result(Integer xiaoshi_check_alive_result) {
		this.xiaoshi_check_alive_result = xiaoshi_check_alive_result;
	}

	public String getXiaoshi_id_card_check_result() {
		return xiaoshi_id_card_check_result;
	}

	public void setXiaoshi_id_card_check_result(String xiaoshi_id_card_check_result) {
		this.xiaoshi_id_card_check_result = xiaoshi_id_card_check_result;
	}

	public Integer getXiao_shi_left_times() {
		return xiao_shi_left_times;
	}

	public void setXiao_shi_left_times(Integer xiao_shi_left_times) {
		this.xiao_shi_left_times = xiao_shi_left_times;
	}

	public Date getXiao_shi_invocation_time() {
		return xiao_shi_invocation_time;
	}

	public void setXiao_shi_invocation_time(Date xiao_shi_invocation_time) {
		this.xiao_shi_invocation_time = xiao_shi_invocation_time;
	}

	public String getXiaoshi_id_card_check_msg() {
		return xiaoshi_id_card_check_msg;
	}

	public void setXiaoshi_id_card_check_msg(String xiaoshi_id_card_check_msg) {
		this.xiaoshi_id_card_check_msg = xiaoshi_id_card_check_msg;
	}

	public String getXiaoshi_id_card_check_score() {
		return xiaoshi_id_card_check_score;
	}

	public void setXiaoshi_id_card_check_score(String xiaoshi_id_card_check_score) {
		this.xiaoshi_id_card_check_score = xiaoshi_id_card_check_score;
	}

	public String getXiaoshi_id_card_check_guid() {
		return xiaoshi_id_card_check_guid;
	}

	public void setXiaoshi_id_card_check_guid(String xiaoshi_id_card_check_guid) {
		this.xiaoshi_id_card_check_guid = xiaoshi_id_card_check_guid;
	}

	public String getBondsmaninf_list() {
		return bondsmaninf_list;
	}

	public void setBondsmaninf_list(String bondsmaninf_list) {
		this.bondsmaninf_list = bondsmaninf_list;
	}

	public String getOther_pic_list() {
		return other_pic_list;
	}

	public void setOther_pic_list(String other_pic_list) {
		this.other_pic_list = other_pic_list;
	}

	public String getUsr_order_pic_list() {
		return usr_order_pic_list;
	}

	public void setUsr_order_pic_list(String usr_order_pic_list) {
		this.usr_order_pic_list = usr_order_pic_list;
	}
	
	public List<TabBondsmaninf> getTabBondsmaninfList() {
		return tabBondsmaninfList;
	}

	public void setTabBondsmaninfList(List<TabBondsmaninf> tabBondsmaninfList) {
		this.tabBondsmaninfList = tabBondsmaninfList;
	}

	public List<TabUsrOtherPic> getTabUsrOtherPicList() {
		return tabUsrOtherPicList;
	}

	public void setTabUsrOtherPicList(List<TabUsrOtherPic> tabUsrOtherPicList) {
		this.tabUsrOtherPicList = tabUsrOtherPicList;
	}

	public List<TabUsrOrderPic> getTabUsrOrderPicList() {
		return tabUsrOrderPicList;
	}

	public void setTabUsrOrderPicList(List<TabUsrOrderPic> tabUsrOrderPicList) {
		this.tabUsrOrderPicList = tabUsrOrderPicList;
	}
	
	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	
	public Integer getOrder_type() {
		return order_type;
	}

	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	
	public boolean isFirst_veriy_auth() {
		return first_veriy_auth;
	}

	public void setFirst_veriy_auth(boolean first_veriy_auth) {
		this.first_veriy_auth = first_veriy_auth;
	}

	public boolean isSecond_veriy_auth() {
		return second_veriy_auth;
	}

	public void setSecond_veriy_auth(boolean second_veriy_auth) {
		this.second_veriy_auth = second_veriy_auth;
	}

	public boolean isFinal_veriy_auth() {
		return final_veriy_auth;
	}

	public void setFinal_veriy_auth(boolean final_veriy_auth) {
		this.final_veriy_auth = final_veriy_auth;
	}

	public boolean isCredit_info_veriy_auth() {
		return credit_info_veriy_auth;
	}

	public void setCredit_info_veriy_auth(boolean credit_info_veriy_auth) {
		this.credit_info_veriy_auth = credit_info_veriy_auth;
	}

	public boolean isInfo_handle_auth() {
		return info_handle_auth;
	}

	public void setInfo_handle_auth(boolean info_handle_auth) {
		this.info_handle_auth = info_handle_auth;
	}

	public boolean isPic_type_mosaic() {
		return pic_type_mosaic;
	}

	public void setPic_type_mosaic(boolean pic_type_mosaic) {
		this.pic_type_mosaic = pic_type_mosaic;
	}
	
	public Date getApplyfor_time_start() {
		return applyfor_time_start;
	}

	public void setApplyfor_time_start(Date applyfor_time_start) {
		this.applyfor_time_start = applyfor_time_start;
	}

	public Date getApplyfor_time_end() {
		return applyfor_time_end;
	}

	public void setApplyfor_time_end(Date applyfor_time_end) {
		this.applyfor_time_end = applyfor_time_end;
	}

	public boolean isIf_filter_check_flag_initial() {
		return if_filter_check_flag_initial;
	}

	public void setIf_filter_check_flag_initial(boolean if_filter_check_flag_initial) {
		this.if_filter_check_flag_initial = if_filter_check_flag_initial;
	}
	
	public Integer getArea_province() {
		return area_province;
	}

	public void setArea_province(Integer area_province) {
		this.area_province = area_province;
	}

	public Integer getArea_city() {
		return area_city;
	}

	public void setArea_city(Integer area_city) {
		this.area_city = area_city;
	}

	public Integer getArea_county() {
		return area_county;
	}

	public void setArea_county(Integer area_county) {
		this.area_county = area_county;
	}
	
	public BigDecimal getOrder_money() {
		return order_money;
	}

	public void setOrder_money(BigDecimal order_money) {
		this.order_money = order_money;
	}
	
	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public Byte getIs_store() {
		return is_store;
	}

	public void setIs_store(Byte is_store) {
		this.is_store = is_store;
	}

	public String getBorrower_usrname() {
		return borrower_usrname;
	}

	public void setBorrower_usrname(String borrower_usrname) {
		this.borrower_usrname = borrower_usrname;
	}

	public String getBorrower_id_card() {
		return borrower_id_card;
	}

	public void setBorrower_id_card(String borrower_id_card) {
		this.borrower_id_card = borrower_id_card;
	}

	public String getUsr_type() {
		return usr_type;
	}

	public void setUsr_type(String usr_type) {
		this.usr_type = usr_type;
	}

	public String getStore_contract() {
		return store_contract;
	}

	public void setStore_contract(String store_contract) {
		this.store_contract = store_contract;
	}

	public String getStore_tel() {
		return store_tel;
	}

	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}

	public Long getStore_uid() {
		return store_uid;
	}

	public void setStore_uid(Long store_uid) {
		this.store_uid = store_uid;
	}

	public BigDecimal getStore_charge_rate() {
		return store_charge_rate;
	}

	public void setStore_charge_rate(BigDecimal store_charge_rate) {
		this.store_charge_rate = store_charge_rate;
	}

	public boolean isScoring_report_auth() {
		return scoring_report_auth;
	}

	public void setScoring_report_auth(boolean scoring_report_auth) {
		this.scoring_report_auth = scoring_report_auth;
	}
	
	public String getBorrower_mobile_phone() {
		return borrower_mobile_phone;
	}

	public void setBorrower_mobile_phone(String borrower_mobile_phone) {
		this.borrower_mobile_phone = borrower_mobile_phone;
	}
	

	public String getMobile_imei() {
		return mobile_imei;
	}

	public void setMobile_imei(String mobile_imei) {
		this.mobile_imei = mobile_imei;
	}

	public String getMobile_idfa() {
		return mobile_idfa;
	}

	public void setMobile_idfa(String mobile_idfa) {
		this.mobile_idfa = mobile_idfa;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHead_portrait_pic() {
		return head_portrait_pic;
	}

	public void setHead_portrait_pic(String head_portrait_pic) {
		this.head_portrait_pic = head_portrait_pic;
	}
	
	public String getContract_number() {
		return contract_number;
	}

	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}

	public Integer getOrder_source() {
		return order_source;
	}

	public void setOrder_source(Integer order_source) {
		this.order_source = order_source;
	}

	public Long getBorrow_uid() {
		return borrow_uid;
	}

	public void setBorrow_uid(Long borrow_uid) {
		this.borrow_uid = borrow_uid;
	}

	@Override
	public String toString() {
		return "TabUsrinf2Model [usrinf_id=" + usrinf_id + ", usrid=" + usrid + ", usrname=" + usrname + ", id_card="
				+ id_card + ", sex=" + sex + ", age=" + age + ", marital=" + marital + ", mobile_phone=" + mobile_phone
				+ ", diploma=" + diploma + ", register_place=" + register_place + ", local_register_place="
				+ local_register_place + ", bank_id=" + bank_id + ", income=" + income + ", house_type=" + house_type
				+ ", fixed_assets=" + fixed_assets + ", employment=" + employment + ", com_name=" + com_name
				+ ", industry=" + industry + ", profession_level=" + profession_level + ", cur_hire_duration="
				+ cur_hire_duration + ", schooling_system=" + schooling_system + ", graduate_school=" + graduate_school
				+ ", repaying_source=" + repaying_source + ", id_card_front_pic=" + id_card_front_pic
				+ ", id_card_reverse_pic=" + id_card_reverse_pic + ", with_id_card_pic=" + with_id_card_pic
				+ ", credit_report_pic=" + credit_report_pic + ", is_face_id_pass=" + is_face_id_pass
				+ ", applyfo_flag=" + applyfo_flag + ", check_flag=" + check_flag + ", is_loan=" + is_loan
				+ ", second_check_loan_limit=" + second_check_loan_limit + ", loan_limit=" + loan_limit + ", loan_used="
				+ loan_used + ", is_firstquery=" + is_firstquery + ", applyfor_limit=" + applyfor_limit
				+ ", applyfor_time=" + applyfor_time + ", freeze_remark=" + freeze_remark + ", is_activate="
				+ is_activate + ", limit_validity_time=" + limit_validity_time + ", credit_time=" + credit_time
				+ ", credit_type=" + credit_type + ", first_check_operator=" + first_check_operator
				+ ", second_check_operator=" + second_check_operator + ", check_alive_pic=" + check_alive_pic
				+ ", xiaoshi_check_alive_result=" + xiaoshi_check_alive_result + ", xiaoshi_id_card_check_result="
				+ xiaoshi_id_card_check_result + ", xiao_shi_left_times=" + xiao_shi_left_times
				+ ", xiao_shi_invocation_time=" + xiao_shi_invocation_time + ", xiaoshi_id_card_check_msg="
				+ xiaoshi_id_card_check_msg + ", xiaoshi_id_card_check_score=" + xiaoshi_id_card_check_score
				+ ", xiaoshi_id_card_check_guid=" + xiaoshi_id_card_check_guid + ", head_portrait_pic="
				+ head_portrait_pic + ", bondsmaninf_list=" + bondsmaninf_list + ", tabBondsmaninfList="
				+ tabBondsmaninfList + ", other_pic_list=" + other_pic_list + ", tabUsrOtherPicList="
				+ tabUsrOtherPicList + ", usr_order_pic_list=" + usr_order_pic_list + ", tabUsrOrderPicList="
				+ tabUsrOrderPicList + ", order_sn=" + order_sn + ", order_type=" + order_type + ", first_veriy_auth="
				+ first_veriy_auth + ", second_veriy_auth=" + second_veriy_auth + ", final_veriy_auth="
				+ final_veriy_auth + ", credit_info_veriy_auth=" + credit_info_veriy_auth + ", info_handle_auth="
				+ info_handle_auth + ", scoring_report_auth=" + scoring_report_auth + ", pic_type_mosaic="
				+ pic_type_mosaic + ", applyfor_time_start=" + applyfor_time_start + ", applyfor_time_end="
				+ applyfor_time_end + ", if_filter_check_flag_initial=" + if_filter_check_flag_initial + ", is_store="
				+ is_store + ", borrower_usrname=" + borrower_usrname + ", borrower_id_card=" + borrower_id_card
				+ ", area_province=" + area_province + ", area_city=" + area_city + ", area_county=" + area_county
				+ ", order_money=" + order_money + ", store_name=" + store_name + ", order_status=" + order_status
				+ ", usr_type=" + usr_type + ", store_contract=" + store_contract + ", store_tel=" + store_tel
				+ ", store_uid=" + store_uid + ", store_charge_rate=" + store_charge_rate + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", borrower_mobile_phone=" + borrower_mobile_phone + ", mobile_imei="
				+ mobile_imei + ", mobile_idfa=" + mobile_idfa + ", ip=" + ip + ", contract_number=" + contract_number
				+ ", order_source=" + order_source + ", borrow_uid=" + borrow_uid + "]";
	}

}
