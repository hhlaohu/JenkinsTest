package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TabScoringReport {
    private Integer report_id;

    private Integer usrid;

    private BigDecimal sum_score;

    private Date create_time;

    private Integer add_usr_id;

    private BigDecimal scoring_quota;

    private String borrower_usrname;

    private String borrower_id_card;

    private String borrower_mobile_phone;

    private String mobile_imei;

    private String mobile_idfa;

    private String ip;

    private String sex;

    private Integer age;

    private String marital;

    private String mobile_phone;

    private String diploma;

    private String register_place;

    private String local_register_place;

    private String bank_id;

    private String income;

    private String house_type;

    private String fixed_assets;

    private String employment;

    private String com_name;

    private String industry;

    private String profession_level;

    private String cur_hire_duration;

    private String schooling_system;

    private String graduate_school;

    private String repaying_source;

    private String refund_verdict;

    private String umpire;

    private String first_trial_verdict;

    private String first_person;

    private String recheck_verdict;

    private String recheck_person;

    private String last_trial_verdict;

    private String last_person;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital == null ? null : marital.trim();
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone == null ? null : mobile_phone.trim();
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma == null ? null : diploma.trim();
    }
    
    public String getRegister_place() {
		return register_place;
	}

	public void setRegister_place(String register_place) {
		this.register_place = register_place;
	}

	public String getLocal_register_place() {
        return local_register_place;
    }

    public void setLocal_register_place(String local_register_place) {
        this.local_register_place = local_register_place == null ? null : local_register_place.trim();
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id == null ? null : bank_id.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type == null ? null : house_type.trim();
    }

    public String getFixed_assets() {
        return fixed_assets;
    }

    public void setFixed_assets(String fixed_assets) {
        this.fixed_assets = fixed_assets == null ? null : fixed_assets.trim();
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment == null ? null : employment.trim();
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name == null ? null : com_name.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getProfession_level() {
        return profession_level;
    }

    public void setProfession_level(String profession_level) {
        this.profession_level = profession_level == null ? null : profession_level.trim();
    }

    public String getCur_hire_duration() {
        return cur_hire_duration;
    }

    public void setCur_hire_duration(String cur_hire_duration) {
        this.cur_hire_duration = cur_hire_duration == null ? null : cur_hire_duration.trim();
    }

    public String getSchooling_system() {
        return schooling_system;
    }

    public void setSchooling_system(String schooling_system) {
        this.schooling_system = schooling_system == null ? null : schooling_system.trim();
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

    public String getRefund_verdict() {
        return refund_verdict;
    }

    public void setRefund_verdict(String refund_verdict) {
        this.refund_verdict = refund_verdict == null ? null : refund_verdict.trim();
    }

    public String getUmpire() {
        return umpire;
    }

    public void setUmpire(String umpire) {
        this.umpire = umpire == null ? null : umpire.trim();
    }

    public String getFirst_trial_verdict() {
        return first_trial_verdict;
    }

    public void setFirst_trial_verdict(String first_trial_verdict) {
        this.first_trial_verdict = first_trial_verdict == null ? null : first_trial_verdict.trim();
    }

    public String getFirst_person() {
        return first_person;
    }

    public void setFirst_person(String first_person) {
        this.first_person = first_person == null ? null : first_person.trim();
    }

    public String getRecheck_verdict() {
        return recheck_verdict;
    }

    public void setRecheck_verdict(String recheck_verdict) {
        this.recheck_verdict = recheck_verdict == null ? null : recheck_verdict.trim();
    }

    public String getRecheck_person() {
        return recheck_person;
    }

    public void setRecheck_person(String recheck_person) {
        this.recheck_person = recheck_person == null ? null : recheck_person.trim();
    }

    public String getLast_trial_verdict() {
        return last_trial_verdict;
    }

    public void setLast_trial_verdict(String last_trial_verdict) {
        this.last_trial_verdict = last_trial_verdict == null ? null : last_trial_verdict.trim();
    }

    public String getLast_person() {
        return last_person;
    }

    public void setLast_person(String last_person) {
        this.last_person = last_person == null ? null : last_person.trim();
    }
}