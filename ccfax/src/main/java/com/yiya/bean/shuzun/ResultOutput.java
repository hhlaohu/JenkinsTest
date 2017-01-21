package com.yiya.bean.shuzun;

import java.io.Serializable;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年3月1日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: 用于封装指标查询后的结果 
**********************************************************
 */
public class ResultOutput implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6069709153673277765L;
    /**
     * 返回应答码
     */
    private String resCode;
    /**
     * 应答码描述
     */
    private String resMsg;
    /**
     * 指标返回信息
     */
    private QuotaResult quotaInfo;
    /**
     * @return the resCode
     */
    public String getResCode() {
        return resCode;
    }
    /**
     * @param resCode the resCode to set
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;

        this.resMsg = ResultCode.resultCodeMap.get(resCode);
    }
    /**
     * @return the resMsg
     */
    public String getResMsg() {
        return resMsg;
    }
    /**
     * @param resMsg the resMsg to set
     */
    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
    /**
     * @return the quotaInfo
     */
    public QuotaResult getQuotaInfo() {
        return quotaInfo;
    }
    /**
     * @param quotaInfo the quotaInfo to set
     */
    public void setQuotaInfo(QuotaResult quotaInfo) {
        this.quotaInfo = quotaInfo;
    }
    
    
}
