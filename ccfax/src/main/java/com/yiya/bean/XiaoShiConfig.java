package com.yiya.bean;

/**
 * @author wangxiaolong
 * @data 2016年10月9日
 * @description 小视科技产品配置表
 */
public class XiaoShiConfig {
   
	/**主键*/
	private Integer id;
	
	/**产品类型*/
	private int product_type;
	
	/**产品描述*/
	private String product_desc;
	
	/**配置状态，0表示开关关闭，1表示开关开启*/
	private boolean config_status;
	
	/**分数标准*/
	private Integer score_standard;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getProduct_type() {
		return product_type;
	}

	public void setProduct_type(int product_type) {
		this.product_type = product_type;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public boolean isConfig_status() {
		return config_status;
	}

	public void setConfig_status(boolean config_status) {
		this.config_status = config_status;
	}

	public Integer getScore_standard() {
		return score_standard;
	}

	public void setScore_standard(Integer score_standard) {
		this.score_standard = score_standard;
	}
}
