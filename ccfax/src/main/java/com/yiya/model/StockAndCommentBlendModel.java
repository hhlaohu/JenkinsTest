package com.yiya.model;

/**
 * @author wang_xiao_long
 * @data 2016年8月9日
 * @description 用于ORM映射tab_stock和tab_stock_comment的联表结果
 */
public class StockAndCommentBlendModel extends BaseModel {

	private int stock_comment_id;;// 主键id
	private Integer stock_id;;// 库存id
	private Integer customer_id;;// 客户id

	private String good_name;// 商品名
	private String good_place;// 商品产地
	private Integer good_level;// 商品等级
	private String good_size;// 商品规格
	private String good_volume;// 体积
	private String good_weight;// 重量

	private String good_name_comment;// 商品名称备注名
	private String good_place_comment;// 商品产地备注名
	private int good_level_comment;// 商品等级备注名
	private String good_size_comment;// 商品名称规格注名
	private String good_volume_comment;// 商品体积备注名
	private String good_weight_comment;

	public int getStock_comment_id() {
		return stock_comment_id;
	}

	public void setStock_comment_id(int stock_comment_id) {
		this.stock_comment_id = stock_comment_id;
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

	public String getGood_size_comment() {
		return good_size_comment;
	}

	public void setGood_size_comment(String good_size_comment) {
		this.good_size_comment = good_size_comment;
	}

	public String getGood_volume_comment() {
		return good_volume_comment;
	}

	public void setGood_volume_comment(String good_volume_comment) {
		this.good_volume_comment = good_volume_comment;
	}

	public String getGood_weight_comment() {
		return good_weight_comment;
	}

	public void setGood_weight_comment(String good_weight_comment) {
		this.good_weight_comment = good_weight_comment;
	}

	@Override
	public String toString() {
		return "StockAndCommentBlendModel [stock_comment_id=" + stock_comment_id + ", stock_id=" + stock_id
				+ ", customer_id=" + customer_id + ", good_name=" + good_name + ", good_place=" + good_place
				+ ", good_level=" + good_level + ", good_size=" + good_size + ", good_volume=" + good_volume
				+ ", good_weight=" + good_weight + ", good_name_comment=" + good_name_comment + ", good_place_comment="
				+ good_place_comment + ", good_level_comment=" + good_level_comment + ", good_size_comment="
				+ good_size_comment + ", good_volume_comment=" + good_volume_comment + ", good_weight_comment="
				+ good_weight_comment + "]";
	}
	
	

}
