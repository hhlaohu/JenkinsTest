package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class BorrowUserOrder extends BaseBean{

	private Integer usr_order_id;
	private Integer borrow_uid;
	private Integer order_type;
	private String store_type_name;
	private String borrower_mobile_phone;
	private String borrower_usrname;
	private String order_sn;
	private String create_time;
	private String order_money;
	private Integer amortization_cnt;
	private Integer check_status;//订单审核状态：0：待初审，1：待复审，2：待终审，3：审核通过，4：初审不通过，5：复审不通过，6：终审不通过，7：已分配
	private Integer order_source; //0：秒赊，1：链金所
	private String check_status_;
	private String order_source_;
	private Integer interest_type;
	private String interest_type_;
	private Integer order_allot;
	private String order_allot_;
	
    private Date check_time;
    private Integer order_status;
    private String borrower_id_card;
    private Byte sex;
    private String sex_;
    private Integer age;
    private Byte marital;
    private String marital_;
    private String mobile_phone;
    private Integer diploma;
    private String diploma_;
    private Integer register_place;
    private String register_place_;
    private Byte local_register_place;
    private String local_register_place_;
    private String bank_id;
    private Integer income;
    private String income_;
    private Byte house_type;
    private String house_type_;
    private Byte fixed_assets;
    private String fixed_assets_;
    private Byte employment;
    private String employment_;
    private String com_name;
    private Integer industry;
    private String industry_;
    private Integer profession_level;
    private String profession_level_;
    private Integer cur_hire_duration;
    private String cur_hire_duration_;
    private Integer schooling_system;
    private String schooling_system_;
    private String graduate_school;
    private String repaying_source;
    private String id_card_front_pic;
    private String id_card_reverse_pic;
    private String with_id_card_pic;
    private String credit_report_pic;
    private String amortization_money;
    private Long store_uid;
    private String store_name;
    private BigDecimal store_charge_rate;
    private BigDecimal user_charge_rate;
    private BigDecimal borrow_interest_rate;
    private String store_contract;
    private String store_tel;
    private String check_remark;
    private Date remit_time;
    private String mobile_imei;
    private String mobile_idfa;
    private String ip;
    private String contract_number;
    private String check_alive_pic;
    private Integer xiaoshi_check_alive_result;
    private String xiaoshi_check_alive_result_;
    private Integer xiaoshi_id_card_check_result;
    private String xiaoshi_id_card_check_msg;
    private String xiaoshi_id_card_check_score;
    private String xiaoshi_id_card_check_guid;
    private Long rule_set_id;
    private Integer have_scoring_report;
    private BigDecimal borrow_interest;
    private BigDecimal each_amount;
    private Integer borrow_duration;
    private BigDecimal fee;
    private Byte borrow_use;
    private String borrower_address_book;
    private String borrower_call_records;
    private String borrower_sms;
    private String borrower_app_name;
    private String borrowed_contract;
    private Byte submit_step;
    
    private String borrow_name;
    private String borrow_use_desc;
    private String borrow_info;
	
	private Boolean check_1;
	private Boolean check_2;
	private Boolean check_3;
	private Boolean createReport;
	private Boolean allot;
	
	private Integer add_usr_id;
	
	public String getBorrow_name() {
		return borrow_name;
	}
	public void setBorrow_name(String borrow_name) {
		this.borrow_name = borrow_name;
	}
	public String getBorrow_use_desc() {
		return borrow_use_desc;
	}
	public void setBorrow_use_desc(String borrow_use_desc) {
		this.borrow_use_desc = borrow_use_desc;
	}
	public String getBorrow_info() {
		return borrow_info;
	}
	public void setBorrow_info(String borrow_info) {
		this.borrow_info = borrow_info;
	}
	public Boolean getAllot() {
		return allot;
	}
	public void setAllot(Boolean allot) {
		this.allot = allot;
	}
	public Integer getUsr_order_id() {
		return usr_order_id;
	}
	public void setUsr_order_id(Integer usr_order_id) {
		this.usr_order_id = usr_order_id;
	}
	public Integer getBorrow_uid() {
		return borrow_uid;
	}
	public void setBorrow_uid(Integer borrow_uid) {
		this.borrow_uid = borrow_uid;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public String getStore_type_name() {
		return store_type_name;
	}
	public void setStore_type_name(String store_type_name) {
		this.store_type_name = store_type_name;
	}
	public String getBorrower_mobile_phone() {
		return borrower_mobile_phone;
	}
	public void setBorrower_mobile_phone(String borrower_mobile_phone) {
		this.borrower_mobile_phone = borrower_mobile_phone;
	}
	public String getBorrower_usrname() {
		return borrower_usrname;
	}
	public void setBorrower_usrname(String borrower_usrname) {
		this.borrower_usrname = borrower_usrname;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getOrder_money() {
		return order_money;
	}
	public void setOrder_money(String order_money) {
		this.order_money = order_money;
	}
	public Integer getAmortization_cnt() {
		return amortization_cnt;
	}
	public void setAmortization_cnt(Integer amortization_cnt) {
		this.amortization_cnt = amortization_cnt;
	}
	public Integer getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Integer check_status) {
		this.check_status = check_status;
	}
	public Integer getOrder_source() {
		return order_source;
	}
	public void setOrder_source(Integer order_source) {
		this.order_source = order_source;
	}
	public String getOrder_source_() {
		//0：秒赊，1：链金所
		if (order_source != null && order_source == 0) {
			return "秒赊";
		}
		if (order_source != null && order_source == 1) {
			return "链金所";
		}
		return order_source_;
	}
	public void setOrder_source_(String order_source_) {
		this.order_source_ = order_source_;
	}
	public String getCheck_status_() {
		//订单审核状态：0：待初审，1：待复审，2：待终审，3：审核通过，4：初审不通过，5：复审不通过，6：终审不通过，7：已分配
		if (check_status == null) {
			return "未知";
		}
		String str = "未知";
		switch (check_status) {
		case 0:
			str = "待初审";
			break;
		case 1:
			str = "待复审";
			break;
		case 2:
			str = "待终审";
			break;
		case 3:
			str = "审核通过";
			break;
		case 4:
			str = "初审不通过";
			break;
		case 5:
			str = "复审不通过";
			break;
		case 6:
			str = "终审不通过";
			break;
		case 7:
			str = "已分配";
			break;

		default:
			break;
		}
		return str;
	}
	public void setCheck_status_(String check_status_) {
		this.check_status_ = check_status_;
	}
	public Boolean getCheck_1() {
		return check_1;
	}
	public void setCheck_1(Boolean check_1) {
		this.check_1 = check_1;
	}
	public Boolean getCheck_2() {
		return check_2;
	}
	public void setCheck_2(Boolean check_2) {
		this.check_2 = check_2;
	}
	public Boolean getCheck_3() {
		return check_3;
	}
	public void setCheck_3(Boolean check_3) {
		this.check_3 = check_3;
	}
	public Integer getInterest_type() {
		return interest_type;
	}
	public void setInterest_type(Integer interest_type) {
		this.interest_type = interest_type;
	}
	public String getInterest_type_() {
		//类型，0：等额本息，1：等额本金
		if (interest_type != null && interest_type == 0) {
			return "等额本息";
		}
		if (interest_type != null && interest_type == 1) {
			return "等额本金";
		}
		return interest_type_;
	}
	public void setInterest_type_(String interest_type_) {
		this.interest_type_ = interest_type_;
	}
	public Integer getOrder_allot() {
		return order_allot;
	}
	public void setOrder_allot(Integer order_allot) {
		this.order_allot = order_allot;
	}
	public String getOrder_allot_() {
		//资金分配：0：未分配，1：p2p平台融资，2：自有资金，3：银行资金
		if (order_allot != null && order_allot == 0) {
			return "未分配";
		}
		if (order_allot != null && order_allot == 1) {
			return "p2p平台融资";
		}
		if (order_allot != null && order_allot == 2) {
			return "自有资金";
		}
		if (order_allot != null && order_allot == 3) {
			return "银行资金";
		}
		return order_allot_;
	}
	public void setOrder_allot_(String order_allot_) {
		this.order_allot_ = order_allot_;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public String getBorrower_id_card() {
		return borrower_id_card;
	}
	public void setBorrower_id_card(String borrower_id_card) {
		this.borrower_id_card = borrower_id_card;
	}
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	public String getSex_() {
		return sex_;
	}
	public void setSex_(String sex_) {
		this.sex_ = sex_;
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
	public String getMarital_() {
		return marital_;
	}
	public void setMarital_(String marital_) {
		this.marital_ = marital_;
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
	public String getDiploma_() {
		return diploma_;
	}
	public void setDiploma_(String diploma_) {
		this.diploma_ = diploma_;
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
	public String getLocal_register_place_() {
		return local_register_place_;
	}
	public void setLocal_register_place_(String local_register_place_) {
		this.local_register_place_ = local_register_place_;
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
	public String getIncome_() {
		return income_;
	}
	public void setIncome_(String income_) {
		this.income_ = income_;
	}
	public Byte getHouse_type() {
		return house_type;
	}
	public void setHouse_type(Byte house_type) {
		this.house_type = house_type;
	}
	public String getHouse_type_() {
		return house_type_;
	}
	public void setHouse_type_(String house_type_) {
		this.house_type_ = house_type_;
	}
	public Byte getFixed_assets() {
		return fixed_assets;
	}
	public void setFixed_assets(Byte fixed_assets) {
		this.fixed_assets = fixed_assets;
	}
	public String getFixed_assets_() {
		return fixed_assets_;
	}
	public void setFixed_assets_(String fixed_assets_) {
		this.fixed_assets_ = fixed_assets_;
	}
	public Byte getEmployment() {
		return employment;
	}
	public void setEmployment(Byte employment) {
		this.employment = employment;
	}
	public String getEmployment_() {
		return employment_;
	}
	public void setEmployment_(String employment_) {
		this.employment_ = employment_;
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
	public String getIndustry_() {
		return industry_;
	}
	public void setIndustry_(String industry_) {
		this.industry_ = industry_;
	}
	public Integer getProfession_level() {
		return profession_level;
	}
	public void setProfession_level(Integer profession_level) {
		this.profession_level = profession_level;
	}
	public String getProfession_level_() {
		return profession_level_;
	}
	public void setProfession_level_(String profession_level_) {
		this.profession_level_ = profession_level_;
	}
	public Integer getCur_hire_duration() {
		return cur_hire_duration;
	}
	public void setCur_hire_duration(Integer cur_hire_duration) {
		this.cur_hire_duration = cur_hire_duration;
	}
	public String getCur_hire_duration_() {
		return cur_hire_duration_;
	}
	public void setCur_hire_duration_(String cur_hire_duration_) {
		this.cur_hire_duration_ = cur_hire_duration_;
	}
	public Integer getSchooling_system() {
		return schooling_system;
	}
	public void setSchooling_system(Integer schooling_system) {
		this.schooling_system = schooling_system;
	}
	public String getSchooling_system_() {
		return schooling_system_;
	}
	public void setSchooling_system_(String schooling_system_) {
		this.schooling_system_ = schooling_system_;
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
	public String getAmortization_money() {
		return amortization_money;
	}
	public void setAmortization_money(String amortization_money) {
		this.amortization_money = amortization_money;
	}
	public Long getStore_uid() {
		return store_uid;
	}
	public void setStore_uid(Long store_uid) {
		this.store_uid = store_uid;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public BigDecimal getStore_charge_rate() {
		return store_charge_rate;
	}
	public void setStore_charge_rate(BigDecimal store_charge_rate) {
		this.store_charge_rate = store_charge_rate;
	}
	public BigDecimal getUser_charge_rate() {
		return user_charge_rate;
	}
	public void setUser_charge_rate(BigDecimal user_charge_rate) {
		this.user_charge_rate = user_charge_rate;
	}
	public BigDecimal getBorrow_interest_rate() {
		return borrow_interest_rate;
	}
	public void setBorrow_interest_rate(BigDecimal borrow_interest_rate) {
		this.borrow_interest_rate = borrow_interest_rate;
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
	public String getCheck_remark() {
		return check_remark;
	}
	public void setCheck_remark(String check_remark) {
		this.check_remark = check_remark;
	}
	public Date getRemit_time() {
		return remit_time;
	}
	public void setRemit_time(Date remit_time) {
		this.remit_time = remit_time;
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
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
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
	public Integer getXiaoshi_id_card_check_result() {
		return xiaoshi_id_card_check_result;
	}
	public void setXiaoshi_id_card_check_result(Integer xiaoshi_id_card_check_result) {
		this.xiaoshi_id_card_check_result = xiaoshi_id_card_check_result;
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
	public Long getRule_set_id() {
		if (rule_set_id == null) {
			return 0L;
		}
		return rule_set_id;
	}
	public void setRule_set_id(Long rule_set_id) {
		this.rule_set_id = rule_set_id;
	}
	public Integer getHave_scoring_report() {
		if (have_scoring_report == null) {
			return 0;
		}
		return have_scoring_report;
	}
	public void setHave_scoring_report(Integer have_scoring_report) {
		this.have_scoring_report = have_scoring_report;
	}
	public BigDecimal getBorrow_interest() {
		return borrow_interest;
	}
	public void setBorrow_interest(BigDecimal borrow_interest) {
		this.borrow_interest = borrow_interest;
	}
	public BigDecimal getEach_amount() {
		return each_amount;
	}
	public void setEach_amount(BigDecimal each_amount) {
		this.each_amount = each_amount;
	}
	public Integer getBorrow_duration() {
		return borrow_duration;
	}
	public void setBorrow_duration(Integer borrow_duration) {
		this.borrow_duration = borrow_duration;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public Byte getBorrow_use() {
		return borrow_use;
	}
	public void setBorrow_use(Byte borrow_use) {
		this.borrow_use = borrow_use;
	}
	public String getBorrower_address_book() {
		return borrower_address_book;
	}
	public void setBorrower_address_book(String borrower_address_book) {
		this.borrower_address_book = borrower_address_book;
	}
	public String getBorrower_call_records() {
		return borrower_call_records;
	}
	public void setBorrower_call_records(String borrower_call_records) {
		this.borrower_call_records = borrower_call_records;
	}
	public String getBorrower_sms() {
		return borrower_sms;
	}
	public void setBorrower_sms(String borrower_sms) {
		this.borrower_sms = borrower_sms;
	}
	public String getBorrower_app_name() {
		return borrower_app_name;
	}
	public void setBorrower_app_name(String borrower_app_name) {
		this.borrower_app_name = borrower_app_name;
	}
	public String getBorrowed_contract() {
		return borrowed_contract;
	}
	public void setBorrowed_contract(String borrowed_contract) {
		this.borrowed_contract = borrowed_contract;
	}
	public Byte getSubmit_step() {
		return submit_step;
	}
	public void setSubmit_step(Byte submit_step) {
		this.submit_step = submit_step;
	}
	public String getRegister_place_() {
		return register_place_;
	}
	public void setRegister_place_(String register_place_) {
		this.register_place_ = register_place_;
	}
	public String getXiaoshi_check_alive_result_() {
		if (xiaoshi_check_alive_result == null) {
			return "未知";
		}
		return xiaoshi_check_alive_result==0?"通过":"不通过";
	}
	public void setXiaoshi_check_alive_result_(String xiaoshi_check_alive_result_) {
		this.xiaoshi_check_alive_result_ = xiaoshi_check_alive_result_;
	}
	public Boolean getCreateReport() {
		return createReport;
	}
	public void setCreateReport(Boolean createReport) {
		this.createReport = createReport;
	}
	public Integer getAdd_usr_id() {
		return add_usr_id;
	}
	public void setAdd_usr_id(Integer add_usr_id) {
		this.add_usr_id = add_usr_id;
	}
	
	
}
