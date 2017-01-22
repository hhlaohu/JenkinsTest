package com.yiya.bean;

import java.math.BigDecimal;


public class GoodsStock extends BaseBean {
	
	private Integer good_id;//商品id
	private String good_name;//   商品名	private BigDecimal good_price;//   商品价格	private BigDecimal impawn_rate;//   质押率
	private String good_desc;//   商品描述
	private Integer good_type;//商品类别：0:原木，1：方料，2：板材，3：其它
	
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public BigDecimal getGood_price() {
		return good_price;
	}
	public void setGood_price(BigDecimal good_price) {
		this.good_price = good_price;
	}
	public BigDecimal getImpawn_rate() {
		return impawn_rate;
	}
	public void setImpawn_rate(BigDecimal impawn_rate) {
		this.impawn_rate = impawn_rate;
	}
	public String getGood_desc() {
		return good_desc;
	}
	public void setGood_desc(String good_desc) {
		this.good_desc = good_desc;
	}
	public Integer getGood_type() {
		return good_type;
	}
	public void setGood_type(Integer good_type) {
		this.good_type = good_type;
	}
	
}
