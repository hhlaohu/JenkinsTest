package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.yiya.utils.DateUtil;

public class ScoreReport extends BaseBean{
	private Integer report_id;
	private Integer usrid;
	private BigDecimal sum_score;
	private BigDecimal scoring_quota;
	private Date create_time;
	String create_time_str;
	private Integer add_usr_id;
	private Integer usrinf_id;
    private String sex;
    private String sex_;
    private String age;
    private String marital;
    private String marital_;
    private String mobile_phone;
    private String diploma;
    private String diploma_;
    private String register_place;
    private String register_place_;
    private String local_register_place;
    private String local_register_place_;
    private String bank_id;
    private String income;
    private String house_type;
    private String fixed_assets;
    private String employment;
    private String income_;
    private String house_type_;
    private String fixed_assets_;
    private String employment_;
    private String com_name;
    private String industry_;
    private String profession_level_;
    private String cur_hire_duration_;
    private String schooling_system_;
    private String industry;
    private String profession_level;
    private String cur_hire_duration;
    private String schooling_system;
    private String graduate_school;
    private String repaying_source;
	private String borrower_usrname;
    private String borrower_id_card;
    private String borrower_mobile_phone;
    private String mobile_imei;
    private String mobile_idfa;
    private String ip;
    private String refund_verdict;
    private String umpire;
    private String first_trial_verdict;
    private String first_person;
    private String recheck_verdict;
    private String recheck_person;
    private String last_trial_verdict;
    private String last_person;
    private String order_sn;
    private String store_type_name;
    private Integer usr_order_id;
    
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public String getStore_type_name() {
		return store_type_name;
	}
	public void setStore_type_name(String store_type_name) {
		this.store_type_name = store_type_name;
	}
	public Integer getUsr_order_id() {
		return usr_order_id;
	}
	public void setUsr_order_id(Integer usr_order_id) {
		this.usr_order_id = usr_order_id;
	}
	public BigDecimal getScoring_quota() {
		return scoring_quota;
	}
	public void setScoring_quota(BigDecimal scoring_quota) {
		this.scoring_quota = scoring_quota;
	}
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
		if (sum_score != null) {
			 sum_score = sum_score.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
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
	
	public Integer getUsrinf_id() {
		return usrinf_id;
	}
	public void setUsrinf_id(Integer usrinf_id) {
		this.usrinf_id = usrinf_id;
	}
	public String getSex_() {
		return sex_;
	}
	public void setSex_(String sex_) {
		this.sex_ = sex_;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
		this.mobile_phone = mobile_phone == null ? "" : mobile_phone.trim();
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma == null ? "" : diploma.trim();
	}
	
	public String getRegister_place() {
		return register_place;
	}
	public void setRegister_place(String register_place) {
		this.register_place = register_place == null ? "" : register_place.trim();
	}
	public String getRegister_place_() {
		return register_place_;
	}
	public void setRegister_place_(String register_place_) {
		this.register_place_ = register_place_;
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
		this.bank_id = bank_id == null ? "" : bank_id.trim();
	}
	public String getIncome_() {
		return income_;
	}
	public void setIncome_(String income_) {
		this.income_ = income_;
	}
	public String getHouse_type_() {
		return house_type_;
	}
	public void setHouse_type_(String house_type_) {
		this.house_type_ = house_type_;
	}
	public String getFixed_assets_() {
		return fixed_assets_;
	}
	public void setFixed_assets_(String fixed_assets_) {
		this.fixed_assets_ = fixed_assets_;
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
		this.com_name = com_name == null ? "" : com_name.trim();
	}
	public String getIndustry_() {
		return industry_;
	}
	public void setIndustry_(String industry_) {
		this.industry_ = industry_;
	}
	public String getProfession_level_() {
		return profession_level_;
	}
	public void setProfession_level_(String profession_level_) {
		this.profession_level_ = profession_level_;
	}
	public String getCur_hire_duration_() {
		return cur_hire_duration_;
	}
	public void setCur_hire_duration_(String cur_hire_duration_) {
		this.cur_hire_duration_ = cur_hire_duration_;
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
		this.graduate_school = graduate_school == null ? "" : graduate_school.trim();
	}
	public String getRepaying_source() {
		return repaying_source;
	}
	public void setRepaying_source(String repaying_source) {
		this.repaying_source = repaying_source == null ? "" : repaying_source.trim();
	}
	public String getBorrower_usrname() {
		return borrower_usrname;
	}
	public void setBorrower_usrname(String borrower_usrname) {
		this.borrower_usrname = borrower_usrname == null ? "" : borrower_usrname.trim();
	}
	public String getBorrower_id_card() {
		return borrower_id_card;
	}
	public void setBorrower_id_card(String borrower_id_card) {
		this.borrower_id_card = borrower_id_card == null ? "" : borrower_id_card.trim();
	}
	public String getBorrower_mobile_phone() {
		return borrower_mobile_phone;
	}
	public void setBorrower_mobile_phone(String borrower_mobile_phone) {
		this.borrower_mobile_phone = borrower_mobile_phone == null ? "" : borrower_mobile_phone.trim();
	}
	public String getMobile_imei() {
		return mobile_imei;
	}
	public void setMobile_imei(String mobile_imei) {
		this.mobile_imei = mobile_imei == null ? "" : mobile_imei.trim();
	}
	public String getMobile_idfa() {
		return mobile_idfa;
	}
	public void setMobile_idfa(String mobile_idfa) {
		this.mobile_idfa = mobile_idfa == null ? "" : mobile_idfa.trim();
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip == null ? "" : ip.trim();
	}
	public String getRefund_verdict() {
		return refund_verdict;
	}
	public void setRefund_verdict(String refund_verdict) {
		this.refund_verdict = refund_verdict == null ? "" : refund_verdict.trim();
	}
	public String getUmpire() {
		return umpire;
	}
	public void setUmpire(String umpire) {
		this.umpire = umpire == null ? "" : umpire.trim();
	}
	public String getFirst_trial_verdict() {
		return first_trial_verdict;
	}
	public void setFirst_trial_verdict(String first_trial_verdict) {
		this.first_trial_verdict = first_trial_verdict == null ? "" : first_trial_verdict.trim();
	}
	public String getFirst_person() {
		return first_person;
	}
	public void setFirst_person(String first_person) {
		this.first_person = first_person == null ? "" : first_person.trim();
	}
	public String getRecheck_verdict() {
		return recheck_verdict;
	}
	public void setRecheck_verdict(String recheck_verdict) {
		this.recheck_verdict = recheck_verdict == null ? "" : recheck_verdict.trim();
	}
	public String getRecheck_person() {
		return recheck_person;
	}
	public void setRecheck_person(String recheck_person) {
		this.recheck_person = recheck_person == null ? "" : recheck_person.trim();
	}
	public String getLast_trial_verdict() {
		return last_trial_verdict;
	}
	public void setLast_trial_verdict(String last_trial_verdict) {
		this.last_trial_verdict = last_trial_verdict == null ? "" : last_trial_verdict.trim();
	}
	public String getLast_person() {
		return last_person;
	}
	public void setLast_person(String last_person) {
		this.last_person = last_person == null ? "" : last_person.trim();
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex == null ? "" : sex.trim();
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital == null ? "" : marital.trim();
	}
	public String getLocal_register_place() {
		return local_register_place;
	}
	public void setLocal_register_place(String local_register_place) {
		this.local_register_place = local_register_place == null ? "" : local_register_place.trim();
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income == null ? "" : income.trim();
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type == null ? "" : house_type.trim();
	}
	public String getFixed_assets() {
		return fixed_assets;
	}
	public void setFixed_assets(String fixed_assets) {
		this.fixed_assets = fixed_assets == null ? "" : fixed_assets.trim();
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment == null ? "" : employment.trim();
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry == null ? "" : industry.trim();
	}
	public String getProfession_level() {
		return profession_level;
	}
	public void setProfession_level(String profession_level) {
		this.profession_level = profession_level == null ? "" : profession_level.trim();
	}
	public String getCur_hire_duration() {
		return cur_hire_duration;
	}
	public void setCur_hire_duration(String cur_hire_duration) {
		this.cur_hire_duration = cur_hire_duration == null ? "" : cur_hire_duration.trim();
	}
	public String getSchooling_system() {
		return schooling_system;
	}
	public void setSchooling_system(String schooling_system) {
		this.schooling_system = schooling_system == null ? "" : schooling_system.trim();
	}
	public String getDiploma_() {
		return diploma_;
	}
	public void setDiploma_(String diploma_) {
		this.diploma_ = diploma_;
	}
	public String getCreate_time_str() {
		
		return DateUtil.getPlusTime2(create_time);
	}
	public void setCreate_time_str(String create_time_str) {
		this.create_time_str = create_time_str;
	}
	
}
