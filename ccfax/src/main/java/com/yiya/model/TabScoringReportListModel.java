package com.yiya.model;

import java.math.BigDecimal;
import java.util.Date;

public class TabScoringReportListModel extends BaseModel {
    private Long id;

    private Integer report_id;

    private Integer rule_set_id;

    private String rule_set_name;

    private Integer scoring_rule_id;

    private String scoring_rule_code;

    private String scoring_rule_name;

    private String scoring_rule_desc;

    private Integer scoring_field_id;

    private String scoring_field_name;

    private String scoring_field_name_ch;

    private String scoring_field_desc;

    private Date create_time;

    private BigDecimal score;

    private String gather_field_value;

    private String gather_field_remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getRule_set_id() {
        return rule_set_id;
    }

    public void setRule_set_id(Integer rule_set_id) {
        this.rule_set_id = rule_set_id;
    }

    public String getRule_set_name() {
        return rule_set_name;
    }

    public void setRule_set_name(String rule_set_name) {
        this.rule_set_name = rule_set_name == null ? null : rule_set_name.trim();
    }

    public Integer getScoring_rule_id() {
        return scoring_rule_id;
    }

    public void setScoring_rule_id(Integer scoring_rule_id) {
        this.scoring_rule_id = scoring_rule_id;
    }

    public String getScoring_rule_code() {
        return scoring_rule_code;
    }

    public void setScoring_rule_code(String scoring_rule_code) {
        this.scoring_rule_code = scoring_rule_code == null ? null : scoring_rule_code.trim();
    }

    public String getScoring_rule_name() {
        return scoring_rule_name;
    }

    public void setScoring_rule_name(String scoring_rule_name) {
        this.scoring_rule_name = scoring_rule_name == null ? null : scoring_rule_name.trim();
    }

    public String getScoring_rule_desc() {
        return scoring_rule_desc;
    }

    public void setScoring_rule_desc(String scoring_rule_desc) {
        this.scoring_rule_desc = scoring_rule_desc == null ? null : scoring_rule_desc.trim();
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getGather_field_value() {
        return gather_field_value;
    }

    public void setGather_field_value(String gather_field_value) {
        this.gather_field_value = gather_field_value == null ? null : gather_field_value.trim();
    }

    public String getGather_field_remark() {
        return gather_field_remark;
    }

    public void setGather_field_remark(String gather_field_remark) {
        this.gather_field_remark = gather_field_remark == null ? null : gather_field_remark.trim();
    }
}