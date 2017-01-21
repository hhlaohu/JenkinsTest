package com.yiya.model;

public class product_controllModel extends BaseModel{
	private int pz_id;
	private String pz_good_name;
	private String pz_good_place;

	private int pz_good_level;
	private Integer pz_good_size;
	private String market_prices;
	private String pledge_multiplier;
	public int getPz_id() {
		return pz_id;
	}
	public String getPz_good_place() {
		return pz_good_place;
	}
	public void setPz_good_place(String pzGoodPlace) {
		pz_good_place = pzGoodPlace;
	}
	public void setPz_id(int pzId) {
		pz_id = pzId;
	}
	public String getPz_good_name() {
		return pz_good_name;
	}
	public void setPz_good_name(String pzGoodName) {
		pz_good_name = pzGoodName;
	}

	public int getPz_good_level() {
		return pz_good_level;
	}
	public void setPz_good_level(int pzGoodLevel) {
		pz_good_level = pzGoodLevel;
	}
	public Integer getPz_good_size() {
		return pz_good_size;
	}
	public void setPz_good_size(Integer pz_good_size) {
		this.pz_good_size = pz_good_size;
	}
	public String getMarket_prices() {
		return market_prices;
	}
	public void setMarket_prices(String marketPrices) {
		market_prices = marketPrices;
	}
	public String getPledge_multiplier() {
		return pledge_multiplier;
	}
	public void setPledge_multiplier(String pledgeMultiplier) {
		pledge_multiplier = pledgeMultiplier;
	}
}
