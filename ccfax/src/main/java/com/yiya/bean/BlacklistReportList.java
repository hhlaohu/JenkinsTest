package com.yiya.bean;

public class BlacklistReportList extends BaseBean{
	private Integer id;
	private Integer report_id;
	private String blacklist_type;
	private String blacklist_value;
	private Integer is_hit;
	private String is_hit_str;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReport_id() {
		return report_id;
	}
	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}
	public String getBlacklist_type() {
		return blacklist_type;
	}
	public void setBlacklist_type(String blacklist_type) {
		this.blacklist_type = blacklist_type;
	}
	public String getBlacklist_value() {
		return blacklist_value;
	}
	public void setBlacklist_value(String blacklist_value) {
		this.blacklist_value = blacklist_value;
	}
	public Integer getIs_hit() {
		return is_hit;
	}
	public void setIs_hit(Integer is_hit) {
		this.is_hit = is_hit;
	}
	public String getIs_hit_str() {
		if (is_hit == 0) {
			return "未命中";
		}else {
			return "命中";
		}
		
	}
	public void setIs_hit_str(String is_hit_str) {
		this.is_hit_str = is_hit_str;
	}
	
}
