package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TabUsrinf2 {
	
    private Long usrinf_id;

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
    
    private Byte is_store;
    
    private String borrower_usrname;
    
    private String borrower_id_card;
    
    /**借款人手机号*/
    private String borrower_mobile_phone;
    
    private String mobile_imei;
    
    private String mobile_idfa;
    
    private String ip;
    
    private String head_portrait_pic;
    
    private String contract_number;
    
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
        this.usrname = usrname == null ? null : usrname.trim();
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
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
        this.freeze_remark = freeze_remark == null ? null : freeze_remark.trim();
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
        this.first_check_operator = first_check_operator == null ? null : first_check_operator.trim();
    }

    public String getSecond_check_operator() {
        return second_check_operator;
    }

    public void setSecond_check_operator(String second_check_operator) {
        this.second_check_operator = second_check_operator == null ? null : second_check_operator.trim();
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

    public String getXiaoshi_id_card_check_result() {
        return xiaoshi_id_card_check_result;
    }

    public void setXiaoshi_id_card_check_result(String xiaoshi_id_card_check_result) {
        this.xiaoshi_id_card_check_result = xiaoshi_id_card_check_result == null ? null : xiaoshi_id_card_check_result.trim();
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
	
}