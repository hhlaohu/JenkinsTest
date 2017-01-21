package com.yiya.model;

import java.math.BigDecimal;


/**
 * @author wang_xiao_long
 * @data 2016年8月10日
 * @description 用于ORM映射 pz_good与spec_config的联表
 */
public class PzGoodAndSpecConfigModel {
	
	private Integer pz_id;

	private String pz_good_name;

	private String pz_good_place;

	private Integer pz_good_level;

	private Integer pz_good_size;

	private BigDecimal market_prices;

	private String unit;

	private BigDecimal pledge_multiplier;

	private Integer spec_id;

	private String spec_name;

	private Integer spec_type;

	private Integer value_begin;

	private Integer value_end;

	public Integer getPz_id() {
		return pz_id;
	}

	public void setPz_id(Integer pz_id) {
		this.pz_id = pz_id;
	}

	public String getPz_good_name() {
		return pz_good_name;
	}

	public void setPz_good_name(String pz_good_name) {
		this.pz_good_name = pz_good_name;
	}

	public String getPz_good_place() {
		return pz_good_place;
	}

	public void setPz_good_place(String pz_good_place) {
		this.pz_good_place = pz_good_place;
	}

	public Integer getPz_good_level() {
		return pz_good_level;
	}

	public void setPz_good_level(Integer pz_good_level) {
		this.pz_good_level = pz_good_level;
	}

	
	public Integer getPz_good_size() {
		return pz_good_size;
	}

	public void setPz_good_size(Integer pz_good_size) {
		this.pz_good_size = pz_good_size;
	}

	public BigDecimal getMarket_prices() {
		return market_prices;
	}

	public void setMarket_prices(BigDecimal market_prices) {
		this.market_prices = market_prices;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPledge_multiplier() {
		return pledge_multiplier;
	}

	public void setPledge_multiplier(BigDecimal pledge_multiplier) {
		this.pledge_multiplier = pledge_multiplier;
	}

	public Integer getSpec_id() {
		return spec_id;
	}

	public void setSpec_id(Integer spec_id) {
		this.spec_id = spec_id;
	}

	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}

	public Integer getSpec_type() {
		return spec_type;
	}

	public void setSpec_type(Integer spec_type) {
		this.spec_type = spec_type;
	}

	public Integer getValue_begin() {
		return value_begin;
	}

	public void setValue_begin(Integer value_begin) {
		this.value_begin = value_begin;
	}

	public Integer getValue_end() {
		return value_end;
	}

	public void setValue_end(Integer value_end) {
		this.value_end = value_end;
	}
	
}
