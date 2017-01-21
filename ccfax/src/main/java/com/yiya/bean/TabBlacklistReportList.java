package com.yiya.bean;

public class TabBlacklistReportList {
    private Integer id;

    private Integer report_id;

    private String blacklist_type;

    private String blacklist_value;

    private Byte is_hit;

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
        this.blacklist_type = blacklist_type == null ? null : blacklist_type.trim();
    }

    public String getBlacklist_value() {
        return blacklist_value;
    }

    public void setBlacklist_value(String blacklist_value) {
        this.blacklist_value = blacklist_value == null ? null : blacklist_value.trim();
    }

    public Byte getIs_hit() {
        return is_hit;
    }

    public void setIs_hit(Byte is_hit) {
        this.is_hit = is_hit;
    }
}