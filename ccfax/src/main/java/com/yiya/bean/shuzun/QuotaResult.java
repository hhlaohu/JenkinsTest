package com.yiya.bean.shuzun;

import java.io.Serializable;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年2月18日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: 指标查询的返回信息
**********************************************************
 */
public class QuotaResult implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -765603144920482193L;
    private Integer quotaValuePercent;
    
    /**
     * 指标ID
     */
    private String quotaID;
    /**
     * 指标名
     */
    private String quotaName;
    /**
     * 指标类型
     * 1 查询
     * 2 认证
     */
    private int quotaType;
    /**
     * 指标值
     */
    private Object quotaValue;
//    /**
//     * 指标值 对象
//     */
//    private Object quotaValueObject;
    /**
     * 指标价格 单位分
     */
    private int quotaPrice;
    /**
     * 数据类型
     * 1 数值型
     * 2 字符型
     * 3 boolean型
     * 4 Object 型
     */
    private int quotaValueType;
    /**
     * @return the quotaID
     */
    public String getQuotaID() {
        return quotaID;
    }
    /**
     * @param quotaID the quotaID to set
     */
    public void setQuotaID(String quotaID) {
        this.quotaID = quotaID;
    }
    /**
     * @return the quotaName
     */
    public String getQuotaName() {
        return quotaName;
    }
    /**
     * @param quotaName the quotaName to set
     */
    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }
    /**
     * @return the quotaType
     */
    public int getQuotaType() {
        return quotaType;
    }
    /**
     * @param quotaType the quotaType to set
     */
    public void setQuotaType(int quotaType) {
        this.quotaType = quotaType;
    }
    /**
     * @return the quotaValue
     */
    public Object getQuotaValue() {
        return quotaValue;
    }
    /**
     * @param quotaValue the quotaValue to set
     */
    public void setQuotaValue(Object quotaValue) {
        this.quotaValue = quotaValue;
    }
    /**
     * @return the quotaPrice
     */
    public int getQuotaPrice() {
        return quotaPrice;
    }
    /**
     * @param quotaPrice the quotaPrice to set
     */
    public void setQuotaPrice(int quotaPrice) {
        this.quotaPrice = quotaPrice;
    }
    /**
     * @return the quotaValueType
     */
    public int getQuotaValueType() {
        return quotaValueType;
    }
    /**
     * @param quotaValueType the quotaValueType to set
     */
    public void setQuotaValueType(int quotaValueType) {
        this.quotaValueType = quotaValueType;
    }
    public Integer getQuotaValuePercent() {
        return quotaValuePercent;
    }
    public void setQuotaValuePercent(Integer quotaValuePercent) {
        this.quotaValuePercent = quotaValuePercent;
    }
    
    
}
