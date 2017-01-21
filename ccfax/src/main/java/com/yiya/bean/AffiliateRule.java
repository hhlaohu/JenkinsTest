package com.yiya.bean;


public class AffiliateRule extends BaseBean{
    private String rule_code;

    private String rule_name;

    private String rule_desc;
    
    private String remark;

	public String getRule_code() {
		return rule_code;
	}

	public void setRule_code(String rule_code) {
		this.rule_code = rule_code;
	}

	public String getRule_name() {
		return rule_name;
	}

	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}

	public String getRule_desc() {
		return rule_desc;
	}

	public void setRule_desc(String rule_desc) {
		this.rule_desc = rule_desc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}