package com.yiya.bean;


import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 基本信息表**/
public class TabUsrinfParam extends BaseBean {
	

	private Integer id;
	/**id主键**/
	@Id
	private Integer usrinf_id;

	/**平台统一usrid**/
	@Column
	private Integer usrid;

	/**姓名**/
	@Column
	private String usrname;

	/**身份证号码**/
	@Column
	private String id_card;

	/**性别，0：男，1：女**/
	@Column
	private Integer sex;

	/**婚姻状态：0：未婚，1：已婚，2：其他**/
	@Column
	private Integer marital;

	/**现居住地址，省**/
	@Column
	private String addr_province;

	/**现居住地址，市**/
	@Column
	private String addr_city;

	/**现居住地址，县**/
	@Column
	private String addr_country;
	
	/**现居住地址，街道**/
	@Column
	private String addr_street;

	/**籍贯**/
	@Column
	private String usr_native;

	/**最高学历，对应tab_diploma表（1:研究生以上，2:本科，3:大专以下）**/
	@Column
	private Integer diploma;

	/**手机号码**/
	@Column
	private String mobile_phone;

	/**住宅电话**/
	@Column
	private String home_phone;

	/**职业(工作性质，1：国家机关公务员，2：事业单位员工，3：金融机构，4：上市公司，5：私营企业，6：个体户，7：待业或无业人员，8：学生，9：其它职业)**/
	@Column
	private Integer profession;

	/**职位:1.员工，2.经理，3.总监，4.高管**/
	@Column
	private Integer profession_level;

	/**单位名称**/
	@Column
	private String com_name;

	/**单位地址**/
	@Column
	private String com_street;

	/**收入:1.6000以下，2.6000-10000,3,10000-15000,4.15000-20000,5.20000以上**/
	@Column
	private Integer income;

	/**工作年限:1,1年(含)以下，2,1~3年(含)，3,3~5年(含)，4,5年以上**/
	@Column
	private Integer working_long;

	/**入职时间**/
	@Column
	private Date hiredate;

	/**毕业学校**/
	@Column
	private String graduate_school;

	/**毕业时间**/
	@Column
	private Date graduate_time;

	/**身份证正面照**/
	@Column
	private String id_card_front_pic;

	/**身份证反面照**/
	@Column
	private String id_card_reverse_pic;

	/**人脸识别标志（0：为识别，1：已识别）**/
	@Column
	private Integer is_face_id_pass;

	/**手持身份证照片**/
	@Column
	private String with_id_card_pic;

	/**申请标志，0：未申请，1：申请贷款额度，2：提升贷款额度。**/
	@Column
	private Integer applyfo_flag;

	/**审核标志，0：初始状态，1：未审核，:2：初审不通过，3：初审通过，4：复审不通过，5：复审通过**/
	@Column
	private Integer check_flag;

	/**贷款使用标志，0：不能使用，1：能使用**/
	@Column
	private Integer is_loan;

	/**贷款总额度（元）**/
	@Column
	private BigDecimal loan_limit;

	/**已用额度（元）**/
	@Column
	private BigDecimal loan_used;

	/**申请成功后第一次查询标志，0：已查询，1：审核通过，2：审核未通过（1、2为未查询）**/
	@Column
	private Integer is_firstquery;

	/**申请额度（元），初审通过后写入，复审没通过**/
	@Column
	private BigDecimal applyfor_limit;

	/**申请时间**/
	@Column
	private Date applyfor_time;
	
	/**可用额度**/
	private BigDecimal loan_useble;
	
	/**额度冻结原因备注**/
	private String freeze_remark;

	/**是否激活0:未激活，1：已激活**/
	@Column
	private Integer is_activate;

	/**征信报告图片**/
	@Column
	private String credit_report_pic;
	
	/**额度有效期**/
	@Column
	private Date limit_validity_time;
	
	/**复审通过时间**/
	@Column
	private Date credit_time;
	
	/**开通分期类型，0：乐购，1：乐装**/
	@Column
	private Integer credit_type;



	public Integer getUsrinf_id() {
		return usrinf_id;
	}

	public void setUsrinf_id(Integer usrinf_id) {
		this.usrinf_id = usrinf_id;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getMarital() {
		return marital;
	}

	public void setMarital(Integer marital) {
		this.marital = marital;
	}

	public String getAddr_province() {
		return addr_province;
	}

	public void setAddr_province(String addr_province) {
		this.addr_province = addr_province;
	}

	public String getAddr_city() {
		return addr_city;
	}

	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}

	public String getAddr_country() {
		return addr_country;
	}

	public void setAddr_country(String addr_country) {
		this.addr_country = addr_country;
	}

	public String getAddr_street() {
		return addr_street;
	}

	public void setAddr_street(String addr_street) {
		this.addr_street = addr_street;
	}

	public String getUsr_native() {
		return usr_native;
	}

	public void setUsr_native(String usr_native) {
		this.usr_native = usr_native;
	}

	public Integer getDiploma() {
		return diploma;
	}

	public void setDiploma(Integer diploma) {
		this.diploma = diploma;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public Integer getProfession() {
		return profession;
	}

	public void setProfession(Integer profession) {
		this.profession = profession;
	}

	public Integer getProfession_level() {
		return profession_level;
	}

	public void setProfession_level(Integer profession_level) {
		this.profession_level = profession_level;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getCom_street() {
		return com_street;
	}

	public void setCom_street(String com_street) {
		this.com_street = com_street;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getWorking_long() {
		return working_long;
	}

	public void setWorking_long(Integer working_long) {
		this.working_long = working_long;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getGraduate_school() {
		return graduate_school;
	}

	public void setGraduate_school(String graduate_school) {
		this.graduate_school = graduate_school;
	}

	public Date getGraduate_time() {
		return graduate_time;
	}

	public void setGraduate_time(Date graduate_time) {
		this.graduate_time = graduate_time;
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

	public Integer getIs_face_id_pass() {
		return is_face_id_pass;
	}

	public void setIs_face_id_pass(Integer is_face_id_pass) {
		this.is_face_id_pass = is_face_id_pass;
	}

	public String getWith_id_card_pic() {
		return with_id_card_pic;
	}

	public void setWith_id_card_pic(String with_id_card_pic) {
		this.with_id_card_pic = with_id_card_pic;
	}

	public Integer getApplyfo_flag() {
		return applyfo_flag;
	}

	public void setApplyfo_flag(Integer applyfo_flag) {
		this.applyfo_flag = applyfo_flag;
	}

	public Integer getCheck_flag() {
		return check_flag;
	}

	public void setCheck_flag(Integer check_flag) {
		this.check_flag = check_flag;
	}

	public Integer getIs_loan() {
		return is_loan;
	}

	public void setIs_loan(Integer is_loan) {
		this.is_loan = is_loan;
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

	public Integer getIs_firstquery() {
		return is_firstquery;
	}

	public void setIs_firstquery(Integer is_firstquery) {
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

	public BigDecimal getLoan_useble() {
		return loan_useble;
	}

	public void setLoan_useble(BigDecimal loan_useble) {
		this.loan_useble = loan_useble;
	}

	public String getFreeze_remark() {
		return freeze_remark;
	}

	public void setFreeze_remark(String freeze_remark) {
		this.freeze_remark = freeze_remark;
	}

	public Integer getIs_activate() {
		return is_activate;
	}

	public void setIs_activate(Integer is_activate) {
		this.is_activate = is_activate;
	}

	public String getCredit_report_pic() {
		return credit_report_pic;
	}

	public void setCredit_report_pic(String credit_report_pic) {
		this.credit_report_pic = credit_report_pic;
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

	public Integer getCredit_type() {
		return credit_type;
	}

	public void setCredit_type(Integer credit_type) {
		this.credit_type = credit_type;
	}
	


	
}