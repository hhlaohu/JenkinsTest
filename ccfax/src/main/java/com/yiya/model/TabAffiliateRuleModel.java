package com.yiya.model;

import java.util.Date;

public class TabAffiliateRuleModel extends BaseModel {
	
    private Long affiliate_rule_id;

    private String rule_code;

    private String rule_name;

    private String rule_desc;

    private Date add_time;

    private Long add_usr_id;
    
    private String add_usr_name;

    public Long getAffiliate_rule_id() {
        return affiliate_rule_id;
    }

    public void setAffiliate_rule_id(Long affiliate_rule_id) {
        this.affiliate_rule_id = affiliate_rule_id;
    }

    public String getRule_code() {
        return rule_code;
    }

    public void setRule_code(String rule_code) {
        this.rule_code = rule_code == null ? null : rule_code.trim();
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name == null ? null : rule_name.trim();
    }

    public String getRule_desc() {
        return rule_desc;
    }

    public void setRule_desc(String rule_desc) {
        this.rule_desc = rule_desc == null ? null : rule_desc.trim();
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Long getAdd_usr_id() {
        return add_usr_id;
    }

    public void setAdd_usr_id(Long add_usr_id) {
        this.add_usr_id = add_usr_id;
    }

	public String getAdd_usr_name() {
		return add_usr_name;
	}

	public void setAdd_usr_name(String add_usr_name) {
		this.add_usr_name = add_usr_name;
	}
}