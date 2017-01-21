package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class AllWoodOrderTemp extends BaseModel{
	
	/**订单索引id*/
	@Column
	private Long order_id;
	/**订单编号*/
	@Column
	private Long order_sn;
	/**订单生成时间*/
	@Column
	private Long add_time;
	private String add_time_desc;
	/**订单类型*/
	private Integer order_type;
	/**商品总价格*/
	@Column
	private BigDecimal goods_amount;
	/**订单总价格*/
	@Column
	private BigDecimal order_amount;
	/**分期购订单支付差额(分期金额)*/
	@Column
	private Integer order_amount_delta;
	/**运费*/
	@Column
	private BigDecimal shipping_fee;
	/**收货人姓名*/
	@Column
	private String reciver_name;
	/**收货人其它信息(包括手机号，收货地址)*/
	@Column
	private String reciver_info;
	/**商品id*/
	@Column
	private Integer goods_id;
	/**商品名称*/
	@Column
	private String goods_name;
	/**商品数量*/
	@Column
	private Integer goods_num;
	/**商品价格*/
	@Column
	private BigDecimal goods_price;
	/**商品实际成交价*/
	@Column
	private BigDecimal goods_pay_price;
	/**商品小计*/
	@Column
	private BigDecimal goods_total_price;
	
	/**商品分类*/
	private Integer gc_id;
	private String gc_name;
	/**店铺id*/
	private Integer store_id;
	/**店铺名称*/
	private String store_name;
	private String payment_code;
	private String payment_name;
	/**商品主图*/
	private String goods_image;
	private String goods_image_url;
	private String goods_attr;
	private String material;
	private String goods_body;
	/**规格*/
	private String goods_spec;
	private String goods_spec_desc;

	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(Long order_sn) {
		this.order_sn = order_sn;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public BigDecimal getGoods_amount() {
		return goods_amount;
	}
	public void setGoods_amount(BigDecimal goods_amount) {
		this.goods_amount = goods_amount;
	}
	public BigDecimal getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(BigDecimal order_amount) {
		this.order_amount = order_amount;
	}
	public Integer getOrder_amount_delta() {
		return order_amount_delta;
	}
	public void setOrder_amount_delta(Integer order_amount_delta) {
		this.order_amount_delta = order_amount_delta;
	}
	public BigDecimal getShipping_fee() {
		return shipping_fee;
	}
	public void setShipping_fee(BigDecimal shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
	public String getReciver_name() {
		return reciver_name;
	}
	public void setReciver_name(String reciver_name) {
		this.reciver_name = reciver_name;
	}
	public String getReciver_info() {
		return reciver_info;
	}
	public void setReciver_info(String reciver_info) {
		this.reciver_info = reciver_info;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public BigDecimal getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}
	public BigDecimal getGoods_pay_price() {
		return goods_pay_price;
	}
	public void setGoods_pay_price(BigDecimal goods_pay_price) {
		this.goods_pay_price = goods_pay_price;
	}
	public Integer getGc_id() {
		return gc_id;
	}
	public void setGc_id(Integer gc_id) {
		this.gc_id = gc_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getPayment_code() {
		return payment_code;
	}
	public void setPayment_code(String payment_code) {
		this.payment_code = payment_code;
	}
	public String getPayment_name() {
		return payment_name;
	}
	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}
	public String getGoods_image() {
		return goods_image;
	}
	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}
	public String getGoods_spec() {
		return goods_spec;
	}
	public void setGoods_spec(String goods_spec) {
		this.goods_spec = goods_spec;
	}
	public String getGoods_spec_desc() {
		return goods_spec_desc;
	}
	public void setGoods_spec_desc(String goods_spec_desc) {
		this.goods_spec_desc = goods_spec_desc;
	}
	public String getGoods_attr() {
		return goods_attr;
	}
	public void setGoods_attr(String goods_attr) {
		this.goods_attr = goods_attr;
	}
	public String getGoods_body() {
		return goods_body;
	}
	public void setGoods_body(String goods_body) {
		this.goods_body = goods_body;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getGc_name() {
		return gc_name;
	}
	public void setGc_name(String gc_name) {
		this.gc_name = gc_name;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public String getAdd_time_desc() {
		return add_time_desc;
	}
	public void setAdd_time_desc(String add_time_desc) {
		this.add_time_desc = add_time_desc;
	}
	public BigDecimal getGoods_total_price() {
		return goods_total_price;
	}
	public void setGoods_total_price(BigDecimal goods_total_price) {
		this.goods_total_price = goods_total_price;
	}
	public String getGoods_image_url() {
		return goods_image_url;
	}
	public void setGoods_image_url(String goods_image_url) {
		this.goods_image_url = goods_image_url;
	}
	
}
