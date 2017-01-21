package com.yiya.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/** **/

public class PzGood  extends BaseBean {
	/****/
	@Id
	private Long pz_id;

	/**货物名称**/
	@Column
	private String pz_good_name;

	/**产地**/
	@Column
	private String pz_good_place;

	/**等级{1,顶级2,普一3普二,4，统材}下拉**/
	@Column
	private Integer pz_good_level;

	/**规格**/
	@Column
	private Integer pz_good_size;

	/**市场指导价格**/
	@Column
	private BigDecimal market_prices;

	/**计量单位**/
	@Column
	private String unit;

	/**质押系数**/
	@Column
	private BigDecimal pledge_multiplier;

	public void setPz_id(Long pz_id) {
		this.pz_id=pz_id;
	}

	public Long getPz_id() {
		return this.pz_id;
	}

	public void setPz_good_name(String pz_good_name) {
		this.pz_good_name=pz_good_name;
	}

	public String getPz_good_name() {
		return this.pz_good_name;
	}

	public void setPz_good_place(String pz_good_place) {
		this.pz_good_place=pz_good_place;
	}

	public String getPz_good_place() {
		return this.pz_good_place;
	}

	public void setPz_good_level(Integer pz_good_level) {
		this.pz_good_level=pz_good_level;
	}

	public Integer getPz_good_size() {
		return pz_good_size;
	}

	public void setPz_good_size(Integer pz_good_size) {
		this.pz_good_size = pz_good_size;
	}

	public Integer getPz_good_level() {
		return this.pz_good_level;
	}

	public void setMarket_prices(BigDecimal market_prices) {
		this.market_prices=market_prices;
	}

	public BigDecimal getMarket_prices() {
		return this.market_prices;
	}

	public void setUnit(String unit) {
		this.unit=unit;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setPledge_multiplier(BigDecimal pledge_multiplier) {
		this.pledge_multiplier=pledge_multiplier;
	}

	public BigDecimal getPledge_multiplier() {
		return this.pledge_multiplier;
	}

}