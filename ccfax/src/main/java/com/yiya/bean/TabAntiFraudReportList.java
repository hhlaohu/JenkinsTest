package com.yiya.bean;

import java.util.Date;

public class TabAntiFraudReportList {
    private Integer id;

    private Integer report_id;

    private Integer anti_fraud_rule_id;

    private String anti_fraud_rule_code;

    private String anti_fraud_rule_name;

    private String anti_fraud_rule_desc;

    private Date create_time;

    private String gather_field_value;

    private Integer scoring_field_id;

    private String scoring_field_name;

    private String scoring_field_name_ch;

    private String scoring_field_desc;

    private Byte is_hit;

    private String gather_type_name;

    private String gather_field_remark;

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

    public Integer getAnti_fraud_rule_id() {
        return anti_fraud_rule_id;
    }

    public void setAnti_fraud_rule_id(Integer anti_fraud_rule_id) {
        this.anti_fraud_rule_id = anti_fraud_rule_id;
    }

    public String getAnti_fraud_rule_code() {
        return anti_fraud_rule_code;
    }

    public void setAnti_fraud_rule_code(String anti_fraud_rule_code) {
        this.anti_fraud_rule_code = anti_fraud_rule_code == null ? null : anti_fraud_rule_code.trim();
    }

    public String getAnti_fraud_rule_name() {
        return anti_fraud_rule_name;
    }

    public void setAnti_fraud_rule_name(String anti_fraud_rule_name) {
        this.anti_fraud_rule_name = anti_fraud_rule_name == null ? null : anti_fraud_rule_name.trim();
    }

    public String getAnti_fraud_rule_desc() {
        return anti_fraud_rule_desc;
    }

    public void setAnti_fraud_rule_desc(String anti_fraud_rule_desc) {
        this.anti_fraud_rule_desc = anti_fraud_rule_desc == null ? null : anti_fraud_rule_desc.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getGather_field_value() {
        return gather_field_value;
    }

    public void setGather_field_value(String gather_field_value) {
        this.gather_field_value = gather_field_value == null ? null : gather_field_value.trim();
    }

    public Integer getScoring_field_id() {
        return scoring_field_id;
    }

    public void setScoring_field_id(Integer scoring_field_id) {
        this.scoring_field_id = scoring_field_id;
    }

    public String getScoring_field_name() {
        return scoring_field_name;
    }

    public void setScoring_field_name(String scoring_field_name) {
        this.scoring_field_name = scoring_field_name == null ? null : scoring_field_name.trim();
    }

    public String getScoring_field_name_ch() {
        return scoring_field_name_ch;
    }

    public void setScoring_field_name_ch(String scoring_field_name_ch) {
        this.scoring_field_name_ch = scoring_field_name_ch == null ? null : scoring_field_name_ch.trim();
    }

    public String getScoring_field_desc() {
        return scoring_field_desc;
    }

    public void setScoring_field_desc(String scoring_field_desc) {
        this.scoring_field_desc = scoring_field_desc == null ? null : scoring_field_desc.trim();
    }

    public Byte getIs_hit() {
        return is_hit;
    }

    public void setIs_hit(Byte is_hit) {
        this.is_hit = is_hit;
    }

    public String getGather_type_name() {
        return gather_type_name;
    }

    public void setGather_type_name(String gather_type_name) {
        this.gather_type_name = gather_type_name == null ? null : gather_type_name.trim();
    }

    public String getGather_field_remark() {
        return gather_field_remark;
    }

    public void setGather_field_remark(String gather_field_remark) {
        this.gather_field_remark = gather_field_remark == null ? null : gather_field_remark.trim();
    }
}