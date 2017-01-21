package com.yiya.vo;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @data 2016年8月8日
 * @description 值对象用于controller接收值对象
 */
public class PzGoodVo {
   
	private String good_name;
	
	private String good_place;
	
	private Integer good_level;
	
	private String good_size;
	
	private BigDecimal good_volume;
	
	private String stock_id;
	
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

	public String getStock_id() {
		return stock_id;
	}

	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	

	public BigDecimal getGood_volume() {
		return good_volume;
	}

	public void setGood_volume(BigDecimal good_volume) {
		this.good_volume = good_volume;
	}

	@Override
	public String toString() {
		return "PzGoodVo [good_name=" + good_name + ", good_place=" + good_place + ", good_level=" + good_level
				+ ", good_size=" + good_size + ", good_volume=" + good_volume + ", stock_id=" + stock_id + "]";
	}

	
}
