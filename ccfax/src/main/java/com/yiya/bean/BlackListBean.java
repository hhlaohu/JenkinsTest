package com.yiya.bean;

import java.util.Date;

/**
 * 黑名单
 * Title: BlackListBean
 * Description: 
 * @author lidan
 * @date 2016年11月10日 上午10:18:58
 */
public class BlackListBean extends BaseBean {
	
	private Integer id;
	private String blacklist_type;//黑名单类型
	
	private Integer blacklist_type_id;//黑名单类型id
	private String blacklist_value;//黑名单值(身份证号码、手机号)
	private Integer is_active;//	激活标志,枚举类型（0未激活，1已激活）
	
	private Date add_time;//添加时间
	private Integer add_usr_id;//管理员id
	
	
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Integer getAdd_usr_id() {
		return add_usr_id;
	}
	public void setAdd_usr_id(Integer add_usr_id) {
		this.add_usr_id = add_usr_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlacklist_type() {
		return blacklist_type;
	}
	public void setBlacklist_type(String blacklist_type) {
		this.blacklist_type = blacklist_type;
	}
	public Integer getBlacklist_type_id() {
		return blacklist_type_id;
	}
	public void setBlacklist_type_id(Integer blacklist_type_id) {
		this.blacklist_type_id = blacklist_type_id;
	}
	public String getBlacklist_value() {
		return blacklist_value;
	}
	public void setBlacklist_value(String blacklist_value) {
		this.blacklist_value = blacklist_value;
	}
	public Integer getIs_active() {
		return is_active;
	}
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	
	
}
