package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;

public class TabStockModel extends BaseModel{
	private Integer tab_stock_id; //主键id
	private Integer stock_id;//库存id
	private Integer customer_id;//客户id
	private String area_name;//仓号
	private String space_name;//仓位
	private String good_name;//商品名
	private String good_place;//商品产地
	private Integer   good_level;//商品等级
	private String good_size;//商品规格
	private Integer good_type;//商品类型
	private Integer good_number;//每件数量
	private Integer lock_status;//锁定标志

	private String good_volume;//体积
	private String good_weight;//重量
	private BigDecimal market_prices;//市场指导价

	private BigDecimal pledge_multiplier;//质押系数
	private BigDecimal lump_sum; //折后总价
	private BigDecimal market_total_price;//市场总价
	private String check_time;//最近盘点时间
	private String good_name_comment;//商品名称备注名
	private String good_place_comment;//商品产地备注名
	private Integer good_level_comment;//商品等级备注名
	private Integer good_size_comment;//商品名称规格注名
	private Date put_success_time;//入库成功时间
	
	private String start_put_time;//查询入库时间条件(入库开始)
	private String end_put_time;//查询入库时间条件(入库结束)
	
	private String bar_code;//入库条形码
	private String business_pag_no;//商家包号
	
	
	
	public Integer getTab_stock_id() {
		return tab_stock_id;
	}
	public void setTab_stock_id(Integer tab_stock_id) {
		this.tab_stock_id = tab_stock_id;
	}
	public Integer getStock_id() {
		return stock_id;
	}
	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getSpace_name() {
		return space_name;
	}
	public void setSpace_name(String space_name) {
		this.space_name = space_name;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_place() {
		return good_place;
	}
	public void setGood_place(String good_place) {
		this.good_place = good_place;
	}
	public Integer getGood_level() {
		return good_level;
	}
	public void setGood_level(Integer good_level) {
		this.good_level = good_level;
	}
	public String getGood_size() {
		return good_size;
	}
	public void setGood_size(String good_size) {
		this.good_size = good_size;
	}
	public Integer getGood_type() {
		return good_type;
	}
	public void setGood_type(Integer good_type) {
		this.good_type = good_type;
	}
	public String getGood_volume() {
		return good_volume;
	}
	public void setGood_volume(String good_volume) {
		this.good_volume = good_volume;
	}
	public String getGood_weight() {
		return good_weight;
	}
	public void setGood_weight(String good_weight) {
		this.good_weight = good_weight;
	}
	public BigDecimal getMarket_prices() {
		return market_prices;
	}
	public void setMarket_prices(BigDecimal market_prices) {
		this.market_prices = market_prices;
	}
	public BigDecimal getPledge_multiplier() {
		return pledge_multiplier;
	}
	public void setPledge_multiplier(BigDecimal pledge_multiplier) {
		this.pledge_multiplier = pledge_multiplier;
	}
	public BigDecimal getLump_sum() {
		return lump_sum;
	}
	public void setLump_sum(BigDecimal lump_sum) {
		this.lump_sum = lump_sum;
	}
	public BigDecimal getMarket_total_price() {
		return market_total_price;
	}
	public void setMarket_total_price(BigDecimal market_total_price) {
		this.market_total_price = market_total_price;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getGood_name_comment() {
		return good_name_comment;
	}
	public void setGood_name_comment(String good_name_comment) {
		this.good_name_comment = good_name_comment;
	}
	public String getGood_place_comment() {
		return good_place_comment;
	}
	public void setGood_place_comment(String good_place_comment) {
		this.good_place_comment = good_place_comment;
	}
	public Integer getGood_level_comment() {
		return good_level_comment;
	}
	public void setGood_level_comment(Integer good_level_comment) {
		this.good_level_comment = good_level_comment;
	}
	public Integer getGood_size_comment() {
		return good_size_comment;
	}
	public void setGood_size_comment(Integer good_size_comment) {
		this.good_size_comment = good_size_comment;
	}
	public Date getPut_success_time() {
		return put_success_time;
	}
	public void setPut_success_time(Date put_success_time) {
		this.put_success_time = put_success_time;
	}
	public String getStart_put_time() {
		return start_put_time;
	}
	public void setStart_put_time(String start_put_time) {
		this.start_put_time = start_put_time;
	}
	public String getEnd_put_time() {
		return end_put_time;
	}
	public void setEnd_put_time(String end_put_time) {
		this.end_put_time = end_put_time;
	}
	public Integer getGood_number() {
		return good_number;
	}
	public void setGood_number(Integer good_number) {
		this.good_number = good_number;
	}
	public Integer getLock_status() {
		return lock_status;
	}
	public void setLock_status(Integer lock_status) {
		this.lock_status = lock_status;
	}
	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public String getBusiness_pag_no() {
		return business_pag_no;
	}
	public void setBusiness_pag_no(String business_pag_no) {
		this.business_pag_no = business_pag_no;
	}
	
}
