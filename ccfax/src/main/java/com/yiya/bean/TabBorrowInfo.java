package com.yiya.bean;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.yiya.model.BiddingOperationLog;

/** **/
public class TabBorrowInfo extends BaseBean {
	
	private boolean veriy_auth; //借款列表是否有审核权限
	private boolean modify_bidding_auth; //借款列表修改权限
	/**标id**/
	@Column 
	private String bidding_id;
	/**临时标id**/
	@Column
	private String  tmpbidding_id;

	/**借款人UID**/
	@Column
	private Integer borrow_uid;

	/**标的名称（借款标题）**/
	@Column
	private String borrow_name;

	/**借款类型，1提单质押 2提单转现货 3.现货 4.生产金融  5分期购  6 信金链 7优金链**/
	@Column
	private Integer product_type;

	/**借款金额**/
	@Column
	private BigDecimal borrow_money;

	/**借款时间（期限）**/ 
	@Column
	private Integer borrow_duration;

	/**借款时间文字描述**/
	@Column
	private String borrow_duration_txt;

	/**借款利率**/
	@Column
	private BigDecimal borrow_interest_rate;

	/**还款方式（1 天标， 2 按月分期还款（等额本息） ，3按季分期还款， 4每月还息到期还本， 5一次性还款，6利息复投  7.等额本金）**/
	@Column
	private Integer repayment_type;
	/**1.信用标 2担保标**/
	@Column
	private Integer borrow_type;

	/**利息，手续费**/
	@Column
	private BigDecimal borrow_interest;

	/**项目阐述**/
	@Column
	private String borrow_info;

	/**是否允许自动投标**/
	@Column
	private Integer can_auto;

	/**募集时间（天）**/
	@Column
	private String collect_day;

	/**最多投标额度，0为无限额**/
	@Column
	private BigDecimal borrow_max;

	/**投标代收金额限制设置**/
	@Column
	private BigDecimal money_collect;

	/**审核意见**/
	@Column
	private String check_remark;

	/**0：待审核，1：初审失败 ，2 ：初审通过**/
	@Column
	private Integer borrow_status;


	/**审核人id**/
	@Column
	private Integer deal_user;
	
	/**借款人姓名**/
	@Column
	private String borrow_realname;
	
	/**处理时间(毫秒)**/
	@Column
	private Integer deal_time;
	private Date deal_time_descDate;
	
	/**链金所接口返回的发标时间**/
	@Column
	private Integer add_time;
	
	/**标的用途,可区分乐装和乐购*/
	private String borrow_use;
	
	private Date add_time_descDate;
	
	/**全木行订单号**/
	@Column
	private String order_id;
	
	/**链金所返回的处理人id(lzh_borrow_verify表的deal_user字段)**/
	@Column
	private String deal_userid;
	/**链金所返回的处理人id对应姓名(lzh_borrow_verify表的deal_user字段)**/
	@Column
	private String deal_userid_name;
	
	/**可用额度**/
	private BigDecimal loan_useble;
	
	/**征信报告*/
	private String credit_report_pic;
	
	private List<BiddingOperationLog> check_remark_dataList;
	
	/**最小投资额*/
	private Integer borrow_min;
	
	/**担保公司id*/
	private Integer danbao;
	
	/**用户公司名称*/
	private String company_name;
	
	/**担保公司名称*/
	private String danbao_company_name;
	
	/**综合服务费*/
	private BigDecimal colligate;
	
	/**担保金额*/
	private BigDecimal vouch_money;
	
	/**入仓单*/
	private String warehousing;
	
	/**商品图片*/
	private String updata;
	
	/**Int 是否是测试标：0否，1表示是测试标，前台不显示*/
	private Integer test;
	
	/**提单质押时间*/
	private Integer genzong_add_time;
	
	/**提单质押Date类型*/
	private Date genzong_add_time_date;
	
	/**加息率*/
	private BigDecimal jiaxi_rate;
	
	private boolean byTheDay;
	
	/**投标密码*/
	private String bidding_pwd;
	
	/**借款用途描述*/
    private String borrow_use_desc;
    
	
	
	public String getBidding_id() {
		return bidding_id;
	}

	public void setBidding_id(String bidding_id) {
		this.bidding_id = bidding_id;
	}

	public Integer getBorrow_uid() {
		return borrow_uid;
	}

	public void setBorrow_uid(Integer borrow_uid) {
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

	public BigDecimal getLoan_useble() {
		return loan_useble;
	}

	public void setLoan_useble(BigDecimal loan_useble) {
		this.loan_useble = loan_useble;
	}

	public Date getAdd_time_descDate() {
		return add_time_descDate;
	}

	public void setAdd_time_descDate(Date add_time_descDate) {
		this.add_time_descDate = add_time_descDate;
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

	public String getBorrow_use() {
		return borrow_use;
	}

	public void setBorrow_use(String borrow_use) {
		this.borrow_use = borrow_use;
	}

	public List<BiddingOperationLog> getCheck_remark_dataList() {
		return check_remark_dataList;
	}

	public void setCheck_remark_dataList(List<BiddingOperationLog> check_remark_dataList) {
		this.check_remark_dataList = check_remark_dataList;
	}

	public Integer getBorrow_min() {
		return borrow_min;
	}

	public void setBorrow_min(Integer borrow_min) {
		this.borrow_min = borrow_min;
	}

	public Integer getDanbao() {
		return danbao;
	}

	public void setDanbao(Integer danbao) {
		this.danbao = danbao;
	}

	public BigDecimal getColligate() {
		return colligate;
	}

	public void setColligate(BigDecimal colligate) {
		this.colligate = colligate;
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

	public String getUpdata() {
		return updata;
	}

	public void setUpdata(String updata) {
		this.updata = updata;
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}
    
	public Integer getGenzong_add_time() {
		return genzong_add_time;
	}

	public void setGenzong_add_time(Integer genzong_add_time) {
		this.genzong_add_time = genzong_add_time;
	}

	public boolean isByTheDay() {
		return byTheDay;
	}

	public void setByTheDay(boolean byTheDay) {
		this.byTheDay = byTheDay;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String getDanbao_company_name() {
		return danbao_company_name;
	}

	public void setDanbao_company_name(String danbao_company_name) {
		this.danbao_company_name = danbao_company_name;
	}

	public Date getGenzong_add_time_date() {
		return genzong_add_time_date;
	}

	public void setGenzong_add_time_date(Date genzong_add_time_date) {
		this.genzong_add_time_date = genzong_add_time_date;
	}

	public String getCredit_report_pic() {
		return credit_report_pic;
	}

	public void setCredit_report_pic(String credit_report_pic) {
		this.credit_report_pic = credit_report_pic;
	}
	
	public boolean isModify_bidding_auth() {
		return modify_bidding_auth;
	}


	public void setModify_bidding_auth(boolean modify_bidding_auth) {
		this.modify_bidding_auth = modify_bidding_auth;
	}

	public BigDecimal getJiaxi_rate() {
		return jiaxi_rate;
	}

	public void setJiaxi_rate(BigDecimal jiaxi_rate) {
		this.jiaxi_rate = jiaxi_rate;
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

	@Override
	public String toString() {
		return "TabBorrowInfo [veriy_auth=" + veriy_auth + ", modify_bidding_auth=" + modify_bidding_auth
				+ ", bidding_id=" + bidding_id + ", tmpbidding_id=" + tmpbidding_id + ", borrow_uid=" + borrow_uid
				+ ", borrow_name=" + borrow_name + ", product_type=" + product_type + ", borrow_money=" + borrow_money
				+ ", borrow_duration=" + borrow_duration + ", borrow_duration_txt=" + borrow_duration_txt
				+ ", borrow_interest_rate=" + borrow_interest_rate + ", repayment_type=" + repayment_type
				+ ", borrow_type=" + borrow_type + ", borrow_interest=" + borrow_interest + ", borrow_info="
				+ borrow_info + ", can_auto=" + can_auto + ", collect_day=" + collect_day + ", borrow_max=" + borrow_max
				+ ", money_collect=" + money_collect + ", check_remark=" + check_remark + ", borrow_status="
				+ borrow_status + ", deal_user=" + deal_user + ", borrow_realname=" + borrow_realname + ", deal_time="
				+ deal_time + ", deal_time_descDate=" + deal_time_descDate + ", add_time=" + add_time + ", borrow_use="
				+ borrow_use + ", add_time_descDate=" + add_time_descDate + ", order_id=" + order_id + ", deal_userid="
				+ deal_userid + ", deal_userid_name=" + deal_userid_name + ", loan_useble=" + loan_useble
				+ ", credit_report_pic=" + credit_report_pic + ", check_remark_dataList=" + check_remark_dataList
				+ ", borrow_min=" + borrow_min + ", danbao=" + danbao + ", company_name=" + company_name
				+ ", danbao_company_name=" + danbao_company_name + ", colligate=" + colligate + ", vouch_money="
				+ vouch_money + ", warehousing=" + warehousing + ", updata=" + updata + ", test=" + test
				+ ", genzong_add_time=" + genzong_add_time + ", genzong_add_time_date=" + genzong_add_time_date
				+ ", jiaxi_rate=" + jiaxi_rate + ", byTheDay=" + byTheDay + ", bidding_pwd=" + bidding_pwd
				+ ", borrow_use_desc=" + borrow_use_desc + "]";
	}
	
}