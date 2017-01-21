package com.yiya.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TabStock extends BaseBean {
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

	private String good_volume;//体积
	private String good_weight;//重量
	private BigDecimal market_prices;//市场指导价

	private BigDecimal pledge_multiplier;//质押系数
	private BigDecimal lump_sum; //折后总价
	private BigDecimal market_total_price;//市场总价
	private String check_time;//最近盘点时间
	private Date put_success_time;//入库成功时间
	private String good_name_comment;//商品名称备注名
	private String good_place_comment;//商品产地备注名
	private int good_level_comment;//商品等级备注名
	private Integer good_size_comment;//商品名称规格注名
	
	/** 以下参数为调用仓库系统getCustomerStockList接口返回的接收参数*/
	private Integer good_id;//  商品id
	private Integer putstock_id;//   入库单号
	private Integer total_good_count;//   库存总件数
	private Integer good_number;//   库存数量
	private Integer space_id;//   仓位，1、2、3等
	private Integer storage_id=0;//   仓库id，分仓，深圳、东莞等
	private String bar_code;// 入库条形码
	private Long put_time;// 入库时间
	private Integer lease_type;// 租赁类型，0：日租，1：月租
	private BigDecimal daily;// 日租单价（元/立方/日）
	private Integer lock_status;// 锁定状态：0：未锁定，1：锁定
	private String business_pag_no;// 商家包号
	
	private String customer_name="";//客户名称
	private String good_bill="";//  提单号
	private String pick_numbers="";//  提货车号
	private Long put_time_start;//入库开始时间
	private Long put_time_end;//入库结束时间
	private Long out_time_start;//出库开始时间
	private Long out_time_end;//出库结束时间
	private Long last_check_time;//最近盘点时间
	
	private String good_size_comment_spec_name;//备注表规格对应的配置项名字
	
	
	
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
	public int getGood_level_comment() {
		return good_level_comment;
	}
	public void setGood_level_comment(int good_level_comment) {
		this.good_level_comment = good_level_comment;
	}
	public Integer getGood_size_comment() {
		return good_size_comment;
	}
	public void setGood_size_comment(Integer good_size_comment) {
		this.good_size_comment = good_size_comment;
	}
	public Integer getGood_id() {
		return good_id;
	}
	public void setGood_id(Integer good_id) {
		this.good_id = good_id;
	}
	public Integer getPutstock_id() {
		return putstock_id;
	}
	public void setPutstock_id(Integer putstock_id) {
		this.putstock_id = putstock_id;
	}
	public Integer getTotal_good_count() {
		return total_good_count;
	}
	public void setTotal_good_count(Integer total_good_count) {
		this.total_good_count = total_good_count;
	}
	public Integer getGood_number() {
		return good_number;
	}
	public void setGood_number(Integer good_number) {
		this.good_number = good_number;
	}
	public Integer getSpace_id() {
		return space_id;
	}
	public void setSpace_id(Integer space_id) {
		this.space_id = space_id;
	}
	public Integer getStorage_id() {
		return storage_id;
	}
	public void setStorage_id(Integer storage_id) {
		this.storage_id = storage_id;
	}
	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public Integer getLease_type() {
		return lease_type;
	}
	public void setLease_type(Integer lease_type) {
		this.lease_type = lease_type;
	}
	public BigDecimal getDaily() {
		return daily;
	}
	public void setDaily(BigDecimal daily) {
		this.daily = daily;
	}
	public Integer getLock_status() {
		return lock_status;
	}
	public void setLock_status(Integer lock_status) {
		this.lock_status = lock_status;
	}
	public String getBusiness_pag_no() {
		return business_pag_no;
	}
	public void setBusiness_pag_no(String business_pag_no) {
		this.business_pag_no = business_pag_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getGood_bill() {
		return good_bill;
	}
	public void setGood_bill(String good_bill) {
		this.good_bill = good_bill;
	}
	public String getPick_numbers() {
		return pick_numbers;
	}
	public void setPick_numbers(String pick_numbers) {
		this.pick_numbers = pick_numbers;
	}
	public Long getPut_time_start() {
		return put_time_start;
	}
	public void setPut_time_start(Long put_time_start) {
		this.put_time_start = put_time_start;
	}
	public Long getPut_time_end() {
		return put_time_end;
	}
	public void setPut_time_end(Long put_time_end) {
		this.put_time_end = put_time_end;
	}
	public Long getOut_time_start() {
		return out_time_start;
	}
	public void setOut_time_start(Long out_time_start) {
		this.out_time_start = out_time_start;
	}
	public Long getOut_time_end() {
		return out_time_end;
	}
	public void setOut_time_end(Long out_time_end) {
		this.out_time_end = out_time_end;
	}
	public Long getLast_check_time() {
		return last_check_time;
	}
	public void setLast_check_time(Long last_check_time) {
		this.last_check_time = last_check_time;
	}
	public String getGood_size_comment_spec_name() {
		return good_size_comment_spec_name;
	}
	public void setGood_size_comment_spec_name(String good_size_comment_spec_name) {
		this.good_size_comment_spec_name = good_size_comment_spec_name;
	}
	
	public Date getPut_success_time() {
		return put_success_time;
	}
	public void setPut_success_time(Date put_success_time) {
		this.put_success_time = put_success_time;
	}
	public Long getPut_time() {
		return put_time;
	}
	public void setPut_time(Long put_time) {
		this.put_time = put_time;
	}
	@Override
	public String toString() {
		return "TabStock [tab_stock_id=" + tab_stock_id + ", stock_id=" + stock_id + ", customer_id=" + customer_id
				+ ", area_name=" + area_name + ", space_name=" + space_name + ", good_name=" + good_name
				+ ", good_place=" + good_place + ", good_level=" + good_level + ", good_size=" + good_size
				+ ", good_type=" + good_type + ", good_volume=" + good_volume + ", good_weight=" + good_weight
				+ ", market_prices=" + market_prices + ", pledge_multiplier=" + pledge_multiplier + ", lump_sum="
				+ lump_sum + ", market_total_price=" + market_total_price + ", check_time=" + check_time
				+ ", put_success_time=" + put_success_time + ", good_name_comment=" + good_name_comment
				+ ", good_place_comment=" + good_place_comment + ", good_level_comment=" + good_level_comment
				+ ", good_size_comment=" + good_size_comment + ", good_id=" + good_id + ", putstock_id=" + putstock_id
				+ ", total_good_count=" + total_good_count + ", good_number=" + good_number + ", space_id=" + space_id
				+ ", storage_id=" + storage_id + ", bar_code=" + bar_code + ", put_time=" + put_time + ", lease_type="
				+ lease_type + ", daily=" + daily + ", lock_status=" + lock_status + ", business_pag_no="
				+ business_pag_no + ", customer_name=" + customer_name + ", good_bill=" + good_bill + ", pick_numbers="
				+ pick_numbers + ", put_time_start=" + put_time_start + ", put_time_end=" + put_time_end
				+ ", out_time_start=" + out_time_start + ", out_time_end=" + out_time_end + ", last_check_time="
				+ last_check_time + ", good_size_comment_spec_name=" + good_size_comment_spec_name + "]";
	}
	
	
	
}
