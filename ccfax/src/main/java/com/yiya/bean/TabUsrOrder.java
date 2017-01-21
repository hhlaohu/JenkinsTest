package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TabUsrOrder {
    private Long usr_order_id;
    
    @NotEmpty(message = "order_sn 不能为null")
    private String order_sn;

    private Integer order_type;

    private BigDecimal order_money;

    private Date create_time;

    private Date check_time;

    @NotNull(message = "order_status 不能为null")
    private Integer order_status;

    private String borrower_usrname;

    private String borrower_id_card;
    private String storer_id_card;//商户身份证
    
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

    private Integer amortization_cnt;

    private String amortization_money;

    private Long store_uid;

    private String store_name;

    private Long borrow_uid;

    private BigDecimal store_charge_rate;

    private BigDecimal user_charge_rate;

    private BigDecimal borrow_interest_rate;

    private String store_contract;

    private String store_tel;

    private String check_remark;

    private Date remit_time;

    private String borrower_mobile_phone;

    private String mobile_imei;

    private String mobile_idfa;

    private String ip;

    private String contract_number;

    private String check_alive_pic;

    private Integer xiaoshi_check_alive_result;

    private Integer xiaoshi_id_card_check_result;

    private String xiaoshi_id_card_check_msg;

    private String xiaoshi_id_card_check_score;

    private String xiaoshi_id_card_check_guid;

    private Integer order_source;

    private String store_type_name;

    private Long rule_set_id;

    private Integer have_scoring_report;

    private Byte interest_type;

    private BigDecimal borrow_interest;

    private BigDecimal each_amount;

    private Integer borrow_duration;

    private BigDecimal fee;

    private Byte borrow_use;

    private Byte check_status;

    private String borrower_address_book;

    private String borrower_call_records;

    private String borrower_sms;

    private String borrower_app_name;

    private String borrowed_contract;

    private Byte order_allot;

    private Byte submit_step;

    private String borrow_info;

    private String borrow_name;

    private String borrow_use_desc;

    private String pedestrian_inquiry_account;

    private String pedestrian_inquiry_pwd;

    private String store_website;

    private String store_website_account;

    private String vehicle_no;

    private Integer scene_id;
    
    public TabUsrOrder() {

  	}

    public TabUsrOrder(Long usr_order_id,Integer order_status) {
  		
  		this.usr_order_id = usr_order_id;
  		this.order_status = order_status;
  	}
    
  	public TabUsrOrder(String order_sn,Integer order_status) {
  		
  		this.order_sn = order_sn;
  		this.order_status = order_status;
  	}
  	
  	public TabUsrOrder(String order_sn,Integer order_status,Date check_time) {
  		
  		this.order_sn = order_sn;
  		this.order_status = order_status;
  		this.check_time = check_time;
  	}
  	
    public TabUsrOrder(String order_sn,Integer order_status,Date check_time,String check_remark) {
  		
  		this.order_sn = order_sn;
  		this.order_status = order_status;
  		this.check_time = check_time;
  		this.check_remark = check_remark;
  	}

    public Long getUsr_order_id() {
        return usr_order_id;
    }

    public void setUsr_order_id(Long usr_order_id) {
        this.usr_order_id = usr_order_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn == null ? null : order_sn.trim();
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public BigDecimal getOrder_money() {
        return order_money;
    }

    public void setOrder_money(BigDecimal order_money) {
        this.order_money = order_money;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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

    public String getBorrower_usrname() {
        return borrower_usrname;
    }

    public void setBorrower_usrname(String borrower_usrname) {
        this.borrower_usrname = borrower_usrname == null ? null : borrower_usrname.trim();
    }

    public String getBorrower_id_card() {
        return borrower_id_card;
    }

    public void setBorrower_id_card(String borrower_id_card) {
        this.borrower_id_card = borrower_id_card == null ? null : borrower_id_card.trim();
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
        this.mobile_phone = mobile_phone == null ? null : mobile_phone.trim();
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
        this.bank_id = bank_id == null ? null : bank_id.trim();
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
        this.com_name = com_name == null ? null : com_name.trim();
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
        this.graduate_school = graduate_school == null ? null : graduate_school.trim();
    }

    public String getRepaying_source() {
        return repaying_source;
    }

    public void setRepaying_source(String repaying_source) {
        this.repaying_source = repaying_source == null ? null : repaying_source.trim();
    }

    public String getId_card_front_pic() {
        return id_card_front_pic;
    }

    public void setId_card_front_pic(String id_card_front_pic) {
        this.id_card_front_pic = id_card_front_pic == null ? null : id_card_front_pic.trim();
    }

    public String getId_card_reverse_pic() {
        return id_card_reverse_pic;
    }

    public void setId_card_reverse_pic(String id_card_reverse_pic) {
        this.id_card_reverse_pic = id_card_reverse_pic == null ? null : id_card_reverse_pic.trim();
    }

    public String getWith_id_card_pic() {
        return with_id_card_pic;
    }

    public void setWith_id_card_pic(String with_id_card_pic) {
        this.with_id_card_pic = with_id_card_pic == null ? null : with_id_card_pic.trim();
    }

    public String getCredit_report_pic() {
        return credit_report_pic;
    }

    public void setCredit_report_pic(String credit_report_pic) {
        this.credit_report_pic = credit_report_pic == null ? null : credit_report_pic.trim();
    }

    public Integer getAmortization_cnt() {
        return amortization_cnt;
    }

    public void setAmortization_cnt(Integer amortization_cnt) {
        this.amortization_cnt = amortization_cnt;
    }

    public String getAmortization_money() {
        return amortization_money;
    }

    public void setAmortization_money(String amortization_money) {
        this.amortization_money = amortization_money == null ? null : amortization_money.trim();
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
        this.store_name = store_name == null ? null : store_name.trim();
    }

    public Long getBorrow_uid() {
        return borrow_uid;
    }

    public void setBorrow_uid(Long borrow_uid) {
        this.borrow_uid = borrow_uid;
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
        this.store_contract = store_contract == null ? null : store_contract.trim();
    }

    public String getStore_tel() {
        return store_tel;
    }

    public void setStore_tel(String store_tel) {
        this.store_tel = store_tel == null ? null : store_tel.trim();
    }

    public String getCheck_remark() {
        return check_remark;
    }

    public void setCheck_remark(String check_remark) {
        this.check_remark = check_remark == null ? null : check_remark.trim();
    }

    public Date getRemit_time() {
        return remit_time;
    }

    public void setRemit_time(Date remit_time) {
        this.remit_time = remit_time;
    }

    public String getBorrower_mobile_phone() {
        return borrower_mobile_phone;
    }

    public void setBorrower_mobile_phone(String borrower_mobile_phone) {
        this.borrower_mobile_phone = borrower_mobile_phone == null ? null : borrower_mobile_phone.trim();
    }

    public String getMobile_imei() {
        return mobile_imei;
    }

    public void setMobile_imei(String mobile_imei) {
        this.mobile_imei = mobile_imei == null ? null : mobile_imei.trim();
    }

    public String getMobile_idfa() {
        return mobile_idfa;
    }

    public void setMobile_idfa(String mobile_idfa) {
        this.mobile_idfa = mobile_idfa == null ? null : mobile_idfa.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number == null ? null : contract_number.trim();
    }

    public String getCheck_alive_pic() {
        return check_alive_pic;
    }

    public void setCheck_alive_pic(String check_alive_pic) {
        this.check_alive_pic = check_alive_pic == null ? null : check_alive_pic.trim();
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
        this.xiaoshi_id_card_check_msg = xiaoshi_id_card_check_msg == null ? null : xiaoshi_id_card_check_msg.trim();
    }

    public String getXiaoshi_id_card_check_score() {
        return xiaoshi_id_card_check_score;
    }

    public void setXiaoshi_id_card_check_score(String xiaoshi_id_card_check_score) {
        this.xiaoshi_id_card_check_score = xiaoshi_id_card_check_score == null ? null : xiaoshi_id_card_check_score.trim();
    }

    public String getXiaoshi_id_card_check_guid() {
        return xiaoshi_id_card_check_guid;
    }

    public void setXiaoshi_id_card_check_guid(String xiaoshi_id_card_check_guid) {
        this.xiaoshi_id_card_check_guid = xiaoshi_id_card_check_guid == null ? null : xiaoshi_id_card_check_guid.trim();
    }

    public Integer getOrder_source() {
        return order_source;
    }

    public void setOrder_source(Integer order_source) {
        this.order_source = order_source;
    }

    public String getStore_type_name() {
        return store_type_name;
    }

    public void setStore_type_name(String store_type_name) {
        this.store_type_name = store_type_name == null ? null : store_type_name.trim();
    }

    public Long getRule_set_id() {
        return rule_set_id;
    }

    public void setRule_set_id(Long rule_set_id) {
        this.rule_set_id = rule_set_id;
    }

    public Integer getHave_scoring_report() {
        return have_scoring_report;
    }

    public void setHave_scoring_report(Integer have_scoring_report) {
        this.have_scoring_report = have_scoring_report;
    }

    public Byte getInterest_type() {
        return interest_type;
    }

    public void setInterest_type(Byte interest_type) {
        this.interest_type = interest_type;
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

    public Byte getCheck_status() {
        return check_status;
    }

    public void setCheck_status(Byte check_status) {
        this.check_status = check_status;
    }

    public String getBorrower_address_book() {
        return borrower_address_book;
    }

    public void setBorrower_address_book(String borrower_address_book) {
        this.borrower_address_book = borrower_address_book == null ? null : borrower_address_book.trim();
    }

    public String getBorrower_call_records() {
        return borrower_call_records;
    }

    public void setBorrower_call_records(String borrower_call_records) {
        this.borrower_call_records = borrower_call_records == null ? null : borrower_call_records.trim();
    }

    public String getBorrower_sms() {
        return borrower_sms;
    }

    public void setBorrower_sms(String borrower_sms) {
        this.borrower_sms = borrower_sms == null ? null : borrower_sms.trim();
    }

    public String getBorrower_app_name() {
        return borrower_app_name;
    }

    public void setBorrower_app_name(String borrower_app_name) {
        this.borrower_app_name = borrower_app_name == null ? null : borrower_app_name.trim();
    }

    public String getBorrowed_contract() {
        return borrowed_contract;
    }

    public void setBorrowed_contract(String borrowed_contract) {
        this.borrowed_contract = borrowed_contract == null ? null : borrowed_contract.trim();
    }

    public Byte getOrder_allot() {
        return order_allot;
    }

    public void setOrder_allot(Byte order_allot) {
        this.order_allot = order_allot;
    }

    public Byte getSubmit_step() {
        return submit_step;
    }

    public void setSubmit_step(Byte submit_step) {
        this.submit_step = submit_step;
    }

    public String getBorrow_info() {
        return borrow_info;
    }

    public void setBorrow_info(String borrow_info) {
        this.borrow_info = borrow_info == null ? null : borrow_info.trim();
    }

    public String getBorrow_name() {
        return borrow_name;
    }

    public void setBorrow_name(String borrow_name) {
        this.borrow_name = borrow_name == null ? null : borrow_name.trim();
    }

    public String getBorrow_use_desc() {
        return borrow_use_desc;
    }

    public void setBorrow_use_desc(String borrow_use_desc) {
        this.borrow_use_desc = borrow_use_desc == null ? null : borrow_use_desc.trim();
    }

    public String getPedestrian_inquiry_account() {
        return pedestrian_inquiry_account;
    }

    public void setPedestrian_inquiry_account(String pedestrian_inquiry_account) {
        this.pedestrian_inquiry_account = pedestrian_inquiry_account == null ? null : pedestrian_inquiry_account.trim();
    }

    public String getPedestrian_inquiry_pwd() {
        return pedestrian_inquiry_pwd;
    }

    public void setPedestrian_inquiry_pwd(String pedestrian_inquiry_pwd) {
        this.pedestrian_inquiry_pwd = pedestrian_inquiry_pwd == null ? null : pedestrian_inquiry_pwd.trim();
    }

    public String getStore_website() {
        return store_website;
    }

    public void setStore_website(String store_website) {
        this.store_website = store_website == null ? null : store_website.trim();
    }

    public String getStore_website_account() {
        return store_website_account;
    }

    public void setStore_website_account(String store_website_account) {
        this.store_website_account = store_website_account == null ? null : store_website_account.trim();
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no == null ? null : vehicle_no.trim();
    }

    public Integer getScene_id() {
        return scene_id;
    }

    public void setScene_id(Integer scene_id) {
        this.scene_id = scene_id;
    }

	public String getStorer_id_card() {
		return storer_id_card;
	}

	public void setStorer_id_card(String storer_id_card) {
		this.storer_id_card = storer_id_card;
	}
    
}