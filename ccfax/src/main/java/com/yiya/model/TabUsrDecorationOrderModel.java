package com.yiya.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.yiya.bean.TabUsrDecorationContractPic;
import com.yiya.bean.TabUsrPremisePermitPic;

/** 装修房产订单表**/
public class TabUsrDecorationOrderModel extends BaseModel{
	/**自动增长**/
	@Id
	private Integer decoration_order_id;

	/**订单号**/
	@Column
	private String order_sn;

	/**对应用户基本信息id**/
	@Column
	private Integer usrinf_id;

	/**装修房产地址，省**/
	@Column
	private String decoration_addr_province;

	/**装修房产地址，市**/
	@Column
	private String decoration_addr_city;

	/**装修房产地址，县**/
	@Column
	private String decoration_addr_county;

	/**装修房产地址，街道(详细地址)**/
	@Column
	private String decoration_addr_street;

	/**房产产权人**/
	@Column
	private String house_owner;

	/**建筑面积**/
	@Column
	private BigDecimal build_area;

	/**房产购买价格**/
	@Column
	private BigDecimal house_price;

	/**房产购买情况（1：一次性购买 ，2：按揭购买）**/
	@Column
	private Integer house_buy_type;

	/**装修合同价**/
	@Column
	private BigDecimal decoration_contract_price;

	/**4	装修付款方式（1：一次性付款 ，2：按进度付款，3：其它）**/
	@Column
	private Integer decoration_pay_type;

	/**装修合同工期**/
	@Column
	private BigDecimal decoration_contract_period;
	
	/**装修合同照片*/
	private List<TabUsrDecorationContractPic> tabUsrDecorationContractPicList;
	
	/**装修合同照片*/
	private List<TabUsrPremisePermitPic> tabUsrPremisePermitPicList;

	public Integer getDecoration_order_id() {
		return decoration_order_id;
	}

	public void setDecoration_order_id(Integer decoration_order_id) {
		this.decoration_order_id = decoration_order_id;
	}

	public Integer getUsrinf_id() {
		return usrinf_id;
	}

	public void setUsrinf_id(Integer usrinf_id) {
		this.usrinf_id = usrinf_id;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn=order_sn;
	}

	public String getOrder_sn() {
		return this.order_sn;
	}
	
	public void setDecoration_addr_province(String decoration_addr_province) {
		this.decoration_addr_province=decoration_addr_province;
	}

	public String getDecoration_addr_province() {
		return this.decoration_addr_province;
	}

	public void setDecoration_addr_city(String decoration_addr_city) {
		this.decoration_addr_city=decoration_addr_city;
	}

	public String getDecoration_addr_city() {
		return this.decoration_addr_city;
	}

	public void setDecoration_addr_county(String decoration_addr_county) {
		this.decoration_addr_county=decoration_addr_county;
	}

	public String getDecoration_addr_county() {
		return this.decoration_addr_county;
	}

	public void setDecoration_addr_street(String decoration_addr_street) {
		this.decoration_addr_street=decoration_addr_street;
	}

	public String getDecoration_addr_street() {
		return this.decoration_addr_street;
	}

	public void setHouse_owner(String house_owner) {
		this.house_owner=house_owner;
	}

	public String getHouse_owner() {
		return this.house_owner;
	}

	public void setBuild_area(BigDecimal build_area) {
		this.build_area=build_area;
	}

	public BigDecimal getBuild_area() {
		return this.build_area;
	}

	public void setHouse_price(BigDecimal house_price) {
		this.house_price=house_price;
	}

	public BigDecimal getHouse_price() {
		return this.house_price;
	}

	public void setHouse_buy_type(Integer house_buy_type) {
		this.house_buy_type=house_buy_type;
	}

	public Integer getHouse_buy_type() {
		return this.house_buy_type;
	}

	public void setDecoration_contract_price(BigDecimal decoration_contract_price) {
		this.decoration_contract_price=decoration_contract_price;
	}

	public BigDecimal getDecoration_contract_price() {
		return this.decoration_contract_price;
	}

	public void setDecoration_pay_type(Integer decoration_pay_type) {
		this.decoration_pay_type=decoration_pay_type;
	}

	public Integer getDecoration_pay_type() {
		return this.decoration_pay_type;
	}

	public void setDecoration_contract_period(BigDecimal decoration_contract_period) {
		this.decoration_contract_period=decoration_contract_period;
	}

	public BigDecimal getDecoration_contract_period() {
		return this.decoration_contract_period;
	}

	public List<TabUsrDecorationContractPic> getTabUsrDecorationContractPicList() {
		return tabUsrDecorationContractPicList;
	}

	public void setTabUsrDecorationContractPicList(List<TabUsrDecorationContractPic> tabUsrDecorationContractPicList) {
		this.tabUsrDecorationContractPicList = tabUsrDecorationContractPicList;
	}

	public List<TabUsrPremisePermitPic> getTabUsrPremisePermitPicList() {
		return tabUsrPremisePermitPicList;
	}

	public void setTabUsrPremisePermitPicList(List<TabUsrPremisePermitPic> tabUsrPremisePermitPicList) {
		this.tabUsrPremisePermitPicList = tabUsrPremisePermitPicList;
	}

	@Override
	public String toString() {
		return "TabUsrDecorationOrderModel [decoration_order_id=" + decoration_order_id + ", order_sn=" + order_sn
				+ ", usrinf_id=" + usrinf_id + ", decoration_addr_province=" + decoration_addr_province
				+ ", decoration_addr_city=" + decoration_addr_city + ", decoration_addr_county="
				+ decoration_addr_county + ", decoration_addr_street=" + decoration_addr_street + ", house_owner="
				+ house_owner + ", build_area=" + build_area + ", house_price=" + house_price + ", house_buy_type="
				+ house_buy_type + ", decoration_contract_price=" + decoration_contract_price + ", decoration_pay_type="
				+ decoration_pay_type + ", decoration_contract_period=" + decoration_contract_period
				+ ", tabUsrDecorationContractPicList=" + tabUsrDecorationContractPicList
				+ ", tabUsrPremisePermitPicList=" + tabUsrPremisePermitPicList + "]";
	}
     
}