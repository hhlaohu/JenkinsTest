package com.yiya.bean;


public class TabStockComment extends BaseBean {
	private int stock_comment_td;;//主键id
	private int stock_id;;//库存id
	private int customer_id;;//客户id
	private String good_name_comment;//商品名称备注名
	private String good_place_comment;//商品产地备注名
	private int good_level_comment;//商品等级备注名
	private Integer good_size_comment;//商品名称规格注名
	private String good_volume_comment;//商品体积备注名
	private String good_weight_comment;//商品体重备注名
	public int getStock_comment_td() {
		return stock_comment_td;
	}
	public void setStock_comment_td(int stockCommentTd) {
		stock_comment_td = stockCommentTd;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stockId) {
		stock_id = stockId;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customerId) {
		customer_id = customerId;
	}
	public String getGood_name_comment() {
		return good_name_comment;
	}
	public void setGood_name_comment(String goodNameComment) {
		good_name_comment = goodNameComment;
	}
	public String getGood_place_comment() {
		return good_place_comment;
	}
	public void setGood_place_comment(String goodPlaceComment) {
		good_place_comment = goodPlaceComment;
	}
	public int getGood_level_comment() {
		return good_level_comment;
	}
	public void setGood_level_comment(int goodLevelComment) {
		good_level_comment = goodLevelComment;
	}
	public Integer getGood_size_comment() {
		return good_size_comment;
	}
	public void setGood_size_comment(Integer good_size_comment) {
		this.good_size_comment = good_size_comment;
	}
	public String getGood_volume_comment() {
		return good_volume_comment;
	}
	public void setGood_volume_comment(String goodVolumeComment) {
		good_volume_comment = goodVolumeComment;
	}
	public String getGood_weight_comment() {
		return good_weight_comment;
	}
	public void setGood_weight_comment(String goodWeightComment) {
		good_weight_comment = goodWeightComment;
	}

}
