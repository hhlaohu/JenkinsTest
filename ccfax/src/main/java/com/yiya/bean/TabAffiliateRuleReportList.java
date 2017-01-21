package com.yiya.bean;

public class TabAffiliateRuleReportList {
    private Long id;

    private Long report_id;

    private Long affiliate_rule_id;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public Long getAffiliate_rule_id() {
        return affiliate_rule_id;
    }

    public void setAffiliate_rule_id(Long affiliate_rule_id) {
        this.affiliate_rule_id = affiliate_rule_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}