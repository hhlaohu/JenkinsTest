package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabUsrOrderPic;

/** **/
public class TabBorrowInfoModel extends BaseModel{
	
	private boolean veriy_auth; //借款列表是否有审核权限
	private boolean modify_bidding_auth; //借款列表修改权限
	
	/**标id**/
	private String  bidding_id;
	/**临时标id**/
	
	private String  tmpbidding_id;

	/**借款人UID**/
	@NotNull(message="borrow_uid 不能为null")
	private Long borrow_uid;

	/**标的名称（借款标题）**/
	@NotNull(message = "borrow_name 不能为null")
	private String borrow_name;

	/**借款类型，1提单质押 2提单转现货 3.现货 4.生产金融  5分期购  6 信金链 7优金链**/
	
	private Integer product_type;

	/**借款金额**/
	@NotNull(message = "borrow_money 不能为null")
	private BigDecimal borrow_money;

	/**借款时间（期限）**/
	@NotNull(message = "borrow_duration 不能为null")
	private Integer borrow_duration;

	/**借款时间文字描述**/
	
	private String borrow_duration_txt;

	/**借款利率**/
	@NotNull(message = "borrow_interest_rate 不能为null")
	private BigDecimal borrow_interest_rate;

	/**还款方式（1 天标， 2 按月分期还款（等额本息） ，3按季分期还款， 4每月还息到期还本， 5一次性还款，6利息复投 7.等额本金**/
	
	private Integer repayment_type;
	/**1.信用标 2担保标**/
	
	private Integer borrow_type;

	/**利息，手续费**/
	
	private BigDecimal borrow_interest;

	private String borrow_info;

	/**是否允许自动投标**/
	
	private Integer can_auto;

	/**募集时间（天）**/
	private String collect_day;

	/**最多投标额度，0为无限额**/
	
	private BigDecimal borrow_max;

	/**投标代收金额限制设置**/
	
	private BigDecimal money_collect;

	/**审核意见**/
	
	private String check_remark;

	/**0：待审核，1：初审失败 ，2 ：初审通过**/
	
	private Integer borrow_status;

	/**链金所接口返回的提交时间**/
	
	private Integer add_time;
	
	/**发标时间查询条件起始值*/
	private Date add_time_start_time;
	
	/**发标时间查询条件末尾值*/
	private Date add_time_end_time;
	
	/**新的发标时间*/
	private Date new_add_time;
	
	private Byte borrow_use;

	/**审核人id**/
	
	private Integer deal_user;
	
	/**借款人姓名**/
	
	private String borrow_realname;
	
	/**处理时间(毫秒)**/
	
	private Integer deal_time;
	private Date deal_time_descDate;
	
	/**全木行订单号**/
	
	private String order_id;
	
	/**链金所返回的处理人id(lzh_borrow_verify表的deal_user字段)**/
	
	private String deal_userid;
	/**链金所返回的处理人id对应姓名(lzh_borrow_verify表的deal_user字段)**/
	
	private String deal_userid_name;
	
	/**征信报告*/
	private String credit_report_pic;
	
	/**商品图片*/
	private String updata;
	
	/**综合服务费*/
	private BigDecimal colligate;
	
	/**担保公司名称*/
	private String company_name;
	
	/**担保公司服务费*/
	private BigDecimal vouch_money;
	
	/**货物入仓单*/
	private String warehousing;
	
	/**最小投资额*/
	private BigDecimal borrow_min;
	
	/**是否是测试标*/
	private Integer test;
	
	/**担保公司ID*/
	private Integer danbao;
	
	/**提单质押时间*/
	private Integer genzong_add_time;
	
	/**提单质押时间Date类型*/
	private Date genzong_add_time_date;
	
	/**订单类型*/
	@NotNull(message = "order_type 不能为null")
	private Integer order_type;
	
	/**住房状态*/
	private Byte house_type;
	
	/**固定资产*/
	private Byte fixed_assets;
	
	/**商家ID*/
	@NotNull(message = "store_uid 不能为null")
	private Long store_uid;
	
	/**商家名称*/
	@NotNull(message = "store_name 不能为null")
	private String store_name;
	
	/**用户订单照片列表*/
	@NotEmpty(message = "usr_order_pic_list 不能为null")
	private String usr_order_pic_list;
	
	/**每期还款金额*/
	@NotNull(message = "each_amount 不能为null")
	private BigDecimal each_amount;
	
	/**每期还款金额*/
	@NotNull(message = "fee 不能为null")
	private BigDecimal fee;
	
	/**还款类型*/
	@NotNull(message = "interest_type 不能为null")
	private Byte interest_type;
	
	/**商家服务费费率*/
	@NotNull(message = "store_charge_rate 不能为null")
	private BigDecimal store_charge_rate;
	
	/**链金所手续费费率*/
	@NotNull(message = "user_charge_rate 不能为null")
	private BigDecimal user_charge_rate;
	
	/**商家联系人*/
	private String store_contract;
	
	/**商家电话*/
	private String store_tel;
	
	/**借款人手机号*/
    private String borrower_mobile_phone;
    
    private String mobile_imei;
    
    private String mobile_idfa;
    
    private String ip;
    
    /**投标密码*/
	private String bidding_pwd;
	
	/**借款用途描述*/
	 @NotNull(message="borrow_use_desc 不能为空")
    private String borrow_use_desc;
    
    /**订单来源*/
    @NotNull(message="order_source 不能为空")
    private Integer order_source;
    
    /**店铺名称*/
    private String store_type_name;
    
    /**提交步骤*/
    @NotNull(message="submit_step 不能为空")
    private Byte submit_step;
    
    /**借款人手机通讯录*/
    private String borrower_address_book;
    
    /**借款人通话记录*/
    private String borrower_call_records;
    
    /**借款人手机短信*/
    private String borrower_sms;
    
    /**借款人手机应用程序名称*/
    private String borrower_app_name;
    
    /**借款人姓名*/
    private String borrower_usrname;
    
    /**借款人身份证号*/
    private String borrower_id_card;
    
    private String id_card_front_pic;

    private String id_card_reverse_pic;

    private String with_id_card_pic;
    
    @NotNull(message="usr_order_id 不能为空")
    private Long usr_order_id;
    
    /** 担保人信息json字符串 */
	private String bondsmaninf_list;
	
	/** 担保人信息列表 */
	private List<TabOrderBondsmaninf> tabOrderBondsmaninfList;
	
	/** 用户订单照片列表 */
	private List<TabUsrOrderPic> tabUsrOrderPicList;
	
	/** 行业*/
	private Integer industry;
	
	private Byte sex;

    private Integer age;

    private Byte marital;

    private String mobile_phone;

    private Integer diploma;

    private Integer register_place;

    private Byte local_register_place;

    private String bank_id;

    private Integer income;

    private Byte employment;

    private String com_name;

    private Integer profession_level;

    private Integer cur_hire_duration;

    private Integer schooling_system;

    private String graduate_school;

    private String repaying_source;

    private Integer have_scoring_report;

    private String borrowed_contract;

    private Byte order_allot;

    private String pedestrian_inquiry_account;

    private String pedestrian_inquiry_pwd;

    private String store_website;

    private String store_website_account;

    private String vehicle_no;
    
    /**场景模板ID*/
    private Integer scene_id;

    
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

	public String getBidding_id() {
		return bidding_id;
	}

	public void setBidding_id(String bidding_id) {
		this.bidding_id = bidding_id;
	}

	public Long getBorrow_uid() {
		return borrow_uid;
	}

	public void setBorrow_uid(Long borrow_uid) {
		this.borrow_uid = borrow_uid;
	}

	public String getBorrow_name() {
		return borrow_name;
	}

	public void setBorrow_name(String borrow_name) {
		this.borrow_name = borrow_name;
	}

	public Integer getProduct_type() {
		return product_type;
	}

	public void setProduct_type(Integer product_type) {
		this.product_type = product_type;
	}

	public BigDecimal getBorrow_money() {
		return borrow_money;
	}

	public void setBorrow_money(BigDecimal borrow_money) {
		this.borrow_money = borrow_money;
	}

	public Integer getBorrow_duration() {
		return borrow_duration;
	}

	public void setBorrow_duration(Integer borrow_duration) {
		this.borrow_duration = borrow_duration;
	}

	public String getBorrow_duration_txt() {
		return borrow_duration_txt;
	}

	public void setBorrow_duration_txt(String borrow_duration_txt) {
		this.borrow_duration_txt = borrow_duration_txt;
	}

	public BigDecimal getBorrow_interest_rate() {
		return borrow_interest_rate;
	}

	public void setBorrow_interest_rate(BigDecimal borrow_interest_rate) {
		this.borrow_interest_rate = borrow_interest_rate;
	}

	public Integer getRepayment_type() {
		return repayment_type;
	}

	public void setRepayment_type(Integer repayment_type) {
		this.repayment_type = repayment_type;
	}

	public BigDecimal getBorrow_interest() {
		return borrow_interest;
	}

	public void setBorrow_interest(BigDecimal borrow_interest) {
		this.borrow_interest = borrow_interest;
	}

	public String getBorrow_info() {
		return borrow_info;
	}

	public void setBorrow_info(String borrow_info) {
		this.borrow_info = borrow_info;
	}

	public Integer getCan_auto() {
		return can_auto;
	}

	public void setCan_auto(Integer can_auto) {
		this.can_auto = can_auto;
	}

	public String getCollect_day() {
		return collect_day;
	}

	public void setCollect_day(String collect_day) {
		this.collect_day = collect_day;
	}

	public BigDecimal getBorrow_max() {
		return borrow_max;
	}

	public void setBorrow_max(BigDecimal borrow_max) {
		this.borrow_max = borrow_max;
	}

	public BigDecimal getMoney_collect() {
		return money_collect;
	}

	public void setMoney_collect(BigDecimal money_collect) {
		this.money_collect = money_collect;
	}

	public String getCheck_remark() {
		return check_remark;
	}

	public void setCheck_remark(String check_remark) {
		this.check_remark = check_remark;
	}

	public Integer getBorrow_status() {
		return borrow_status;
	}

	public void setBorrow_status(Integer borrow_status) {
		this.borrow_status = borrow_status;
	}

	public Integer getDeal_user() {
		return deal_user;
	}

	public void setDeal_user(Integer deal_user) {
		this.deal_user = deal_user;
	}

	public boolean isVeriy_auth() {
		return veriy_auth;
	}

	public void setVeriy_auth(boolean veriy_auth) {
		this.veriy_auth = veriy_auth;
	}

	public Integer getBorrow_type() {
		return borrow_type;
	}

	public void setBorrow_type(Integer borrow_type) {
		this.borrow_type = borrow_type;
	}

	public String getBorrow_realname() {
		return borrow_realname;
	}

	public void setBorrow_realname(String borrow_realname) {
		this.borrow_realname = borrow_realname;
	}

	public Integer getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(Integer deal_time) {
		this.deal_time = deal_time;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Integer add_time) {
		this.add_time = add_time;
	}

	public String getDeal_userid() {
		return deal_userid;
	}

	public void setDeal_userid(String deal_userid) {
		this.deal_userid = deal_userid;
	}

	public String getDeal_userid_name() {
		return deal_userid_name;
	}

	public void setDeal_userid_name(String deal_userid_name) {
		this.deal_userid_name = deal_userid_name;
	}

	public String getTmpbidding_id() {
		return tmpbidding_id;
	}

	public void setTmpbidding_id(String tmpbidding_id) {
		this.tmpbidding_id = tmpbidding_id;
	}

	public Date getDeal_time_descDate() {
		return deal_time_descDate;
	}

	public void setDeal_time_descDate(Date deal_time_descDate) {
		this.deal_time_descDate = deal_time_descDate;
	}

	public Date getAdd_time_start_time() {
		return add_time_start_time;
	}

	public void setAdd_time_start_time(Date add_time_start_time) {
		this.add_time_start_time = add_time_start_time;
	}

	public Date getAdd_time_end_time() {
		return add_time_end_time;
	}

	public void setAdd_time_end_time(Date add_time_end_time) {
		this.add_time_end_time = add_time_end_time;
	}

	public Date getNew_add_time() {
		return new_add_time;
	}

	public void setNew_add_time(Date new_add_time) {
		this.new_add_time = new_add_time;
	}
	
	public Byte getBorrow_use() {
		return borrow_use;
	}

	public void setBorrow_use(Byte borrow_use) {
		this.borrow_use = borrow_use;
	}

	public String getCredit_report_pic() {
		return credit_report_pic;
	}

	public void setCredit_report_pic(String credit_report_pic) {
		this.credit_report_pic = credit_report_pic;
	}
	
	public String getUpdata() {
		return updata;
	}

	public void setUpdata(String updata) {
		this.updata = updata;
	}

	public BigDecimal getColligate() {
		return colligate;
	}

	public void setColligate(BigDecimal colligate) {
		this.colligate = colligate;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public BigDecimal getVouch_money() {
		return vouch_money;
	}

	public void setVouch_money(BigDecimal vouch_money) {
		this.vouch_money = vouch_money;
	}

	public String getWarehousing() {
		return warehousing;
	}

	public void setWarehousing(String warehousing) {
		this.warehousing = warehousing;
	}

	public BigDecimal getBorrow_min() {
		return borrow_min;
	}

	public void setBorrow_min(BigDecimal borrow_min) {
		this.borrow_min = borrow_min;
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}
	
	public Integer getDanbao() {
		return danbao;
	}

	public void setDanbao(Integer danbao) {
		this.danbao = danbao;
	}

	public Integer getGenzong_add_time() {
		return genzong_add_time;
	}

	public void setGenzong_add_time(Integer genzong_add_time) {
		this.genzong_add_time = genzong_add_time;
	}

	public Date getGenzong_add_time_date() {
		return genzong_add_time_date;
	}

	public void setGenzong_add_time_date(Date genzong_add_time_date) {
		this.genzong_add_time_date = genzong_add_time_date;
	}

	public boolean isModify_bidding_auth() {
		return modify_bidding_auth;
	}

	public void setModify_bidding_auth(boolean modify_bidding_auth) {
		this.modify_bidding_auth = modify_bidding_auth;
	}

	public Integer getOrder_type() {
		return order_type;
	}

	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
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

	public String getUsr_order_pic_list() {
		return usr_order_pic_list;
	}

	public void setUsr_order_pic_list(String usr_order_pic_list) {
		this.usr_order_pic_list = usr_order_pic_list;
	}

	public BigDecimal getEach_amount() {
		return each_amount;
	}

	public void setEach_amount(BigDecimal each_amount) {
		this.each_amount = each_amount;
	}
	
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	
	public Byte getInterest_type() {
		return interest_type;
	}

	public void setInterest_type(Byte interest_type) {
		this.interest_type = interest_type;
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

	public String getBidding_pwd() {
		return bidding_pwd;
	}

	public void setBidding_pwd(String bidding_pwd) {
		this.bidding_pwd = bidding_pwd;
	}

	public String getBorrow_use_desc() {
		return borrow_use_desc;
	}

	public void setBorrow_use_desc(String borrow_use_desc) {
		this.borrow_use_desc = borrow_use_desc;
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
		this.store_type_name = store_type_name;
	}
    
	public Byte getSubmit_step() {
		return submit_step;
	}

	public void setSubmit_step(Byte submit_step) {
		this.submit_step = submit_step;
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
	
	public Long getUsr_order_id() {
		return usr_order_id;
	}

	public void setUsr_order_id(Long usr_order_id) {
		this.usr_order_id = usr_order_id;
	}
	
	public String getBondsmaninf_list() {
		return bondsmaninf_list;
	}

	public void setBondsmaninf_list(String bondsmaninf_list) {
		this.bondsmaninf_list = bondsmaninf_list;
	}

	public List<TabOrderBondsmaninf> getTabOrderBondsmaninfList() {
		return tabOrderBondsmaninfList;
	}

	public void setTabOrderBondsmaninfList(List<TabOrderBondsmaninf> tabOrderBondsmaninfList) {
		this.tabOrderBondsmaninfList = tabOrderBondsmaninfList;
	}

	public List<TabUsrOrderPic> getTabUsrOrderPicList() {
		return tabUsrOrderPicList;
	}

	public void setTabUsrOrderPicList(List<TabUsrOrderPic> tabUsrOrderPicList) {
		this.tabUsrOrderPicList = tabUsrOrderPicList;
	}

	public Integer getIndustry() {
		return industry;
	}

	public void setIndustry(Integer industry) {
		this.industry = industry;
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

	public Integer getHave_scoring_report() {
		return have_scoring_report;
	}

	public void setHave_scoring_report(Integer have_scoring_report) {
		this.have_scoring_report = have_scoring_report;
	}

	public String getBorrowed_contract() {
		return borrowed_contract;
	}

	public void setBorrowed_contract(String borrowed_contract) {
		this.borrowed_contract = borrowed_contract;
	}

	public Byte getOrder_allot() {
		return order_allot;
	}

	public void setOrder_allot(Byte order_allot) {
		this.order_allot = order_allot;
	}

	public String getPedestrian_inquiry_account() {
		return pedestrian_inquiry_account;
	}

	public void setPedestrian_inquiry_account(String pedestrian_inquiry_account) {
		this.pedestrian_inquiry_account = pedestrian_inquiry_account;
	}

	public String getPedestrian_inquiry_pwd() {
		return pedestrian_inquiry_pwd;
	}

	public void setPedestrian_inquiry_pwd(String pedestrian_inquiry_pwd) {
		this.pedestrian_inquiry_pwd = pedestrian_inquiry_pwd;
	}

	public String getStore_website() {
		return store_website;
	}

	public void setStore_website(String store_website) {
		this.store_website = store_website;
	}

	public String getStore_website_account() {
		return store_website_account;
	}

	public void setStore_website_account(String store_website_account) {
		this.store_website_account = store_website_account;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	
	public Integer getScene_id() {
		return scene_id;
	}

	public void setScene_id(Integer scene_id) {
		this.scene_id = scene_id;
	}

	@Override
	public String toString() {
		return "TabBorrowInfoModel [veriy_auth=" + veriy_auth + ", modify_bidding_auth=" + modify_bidding_auth
				+ ", bidding_id=" + bidding_id + ", tmpbidding_id=" + tmpbidding_id + ", borrow_uid=" + borrow_uid
				+ ", borrow_name=" + borrow_name + ", product_type=" + product_type + ", borrow_money=" + borrow_money
				+ ", borrow_duration=" + borrow_duration + ", borrow_duration_txt=" + borrow_duration_txt
				+ ", borrow_interest_rate=" + borrow_interest_rate + ", repayment_type=" + repayment_type
				+ ", borrow_type=" + borrow_type + ", borrow_interest=" + borrow_interest + ", borrow_info="
				+ borrow_info + ", can_auto=" + can_auto + ", collect_day=" + collect_day + ", borrow_max=" + borrow_max
				+ ", money_collect=" + money_collect + ", check_remark=" + check_remark + ", borrow_status="
				+ borrow_status + ", add_time=" + add_time + ", add_time_start_time=" + add_time_start_time
				+ ", add_time_end_time=" + add_time_end_time + ", new_add_time=" + new_add_time + ", borrow_use="
				+ borrow_use + ", deal_user=" + deal_user + ", borrow_realname=" + borrow_realname + ", deal_time="
				+ deal_time + ", deal_time_descDate=" + deal_time_descDate + ", order_id=" + order_id + ", deal_userid="
				+ deal_userid + ", deal_userid_name=" + deal_userid_name + ", credit_report_pic=" + credit_report_pic
				+ ", updata=" + updata + ", colligate=" + colligate + ", company_name=" + company_name
				+ ", vouch_money=" + vouch_money + ", warehousing=" + warehousing + ", borrow_min=" + borrow_min
				+ ", test=" + test + ", danbao=" + danbao + ", genzong_add_time=" + genzong_add_time
				+ ", genzong_add_time_date=" + genzong_add_time_date + ", order_type=" + order_type + ", house_type="
				+ house_type + ", fixed_assets=" + fixed_assets + ", store_uid=" + store_uid + ", store_name="
				+ store_name + ", usr_order_pic_list=" + usr_order_pic_list + ", each_amount=" + each_amount + ", fee="
				+ fee + ", interest_type=" + interest_type + ", store_charge_rate=" + store_charge_rate
				+ ", user_charge_rate=" + user_charge_rate + ", store_contract=" + store_contract + ", store_tel="
				+ store_tel + ", borrower_mobile_phone=" + borrower_mobile_phone + ", mobile_imei=" + mobile_imei
				+ ", mobile_idfa=" + mobile_idfa + ", ip=" + ip + ", bidding_pwd=" + bidding_pwd + ", borrow_use_desc="
				+ borrow_use_desc + ", order_source=" + order_source + ", store_type_name=" + store_type_name
				+ ", submit_step=" + submit_step + ", borrower_address_book=" + borrower_address_book
				+ ", borrower_call_records=" + borrower_call_records + ", borrower_sms=" + borrower_sms
				+ ", borrower_app_name=" + borrower_app_name + ", borrower_usrname=" + borrower_usrname
				+ ", borrower_id_card=" + borrower_id_card + ", id_card_front_pic=" + id_card_front_pic
				+ ", id_card_reverse_pic=" + id_card_reverse_pic + ", with_id_card_pic=" + with_id_card_pic
				+ ", usr_order_id=" + usr_order_id + ", bondsmaninf_list=" + bondsmaninf_list
				+ ", tabOrderBondsmaninfList=" + tabOrderBondsmaninfList + ", tabUsrOrderPicList=" + tabUsrOrderPicList
				+ ", industry=" + industry + ", sex=" + sex + ", age=" + age + ", marital=" + marital
				+ ", mobile_phone=" + mobile_phone + ", diploma=" + diploma + ", register_place=" + register_place
				+ ", local_register_place=" + local_register_place + ", bank_id=" + bank_id + ", income=" + income
				+ ", employment=" + employment + ", com_name=" + com_name + ", profession_level=" + profession_level
				+ ", cur_hire_duration=" + cur_hire_duration + ", schooling_system=" + schooling_system
				+ ", graduate_school=" + graduate_school + ", repaying_source=" + repaying_source
				+ ", have_scoring_report=" + have_scoring_report + ", borrowed_contract=" + borrowed_contract
				+ ", order_allot=" + order_allot + ", pedestrian_inquiry_account=" + pedestrian_inquiry_account
				+ ", pedestrian_inquiry_pwd=" + pedestrian_inquiry_pwd + ", store_website=" + store_website
				+ ", store_website_account=" + store_website_account + ", vehicle_no=" + vehicle_no + ", scene_id="
				+ scene_id + "]";
	}
	
}