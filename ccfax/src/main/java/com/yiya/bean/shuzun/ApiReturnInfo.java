package com.yiya.bean.shuzun;

import com.google.gson.Gson;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年2月18日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: 查询的返回信息
**********************************************************
 */
public class ApiReturnInfo<T> {
    
    private String resCode;
    private String resMsg;
    private String sign;
    private T data;
    
    
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
        calcSign();
        
        // 查找错误码对应的  错误描述
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
     * @return the sign
     */
    public String getSign() {
        return sign;
    }
    /**
     * @param sign the sign to set
     */
    public void setSign(String sign) {
        this.sign = sign;
    }
    /**
     * @param sign the sign to set
     */
    private void calcSign() {
        this.sign = CommonUtil.MD5(this.resCode + new Gson().toJson(data)).toUpperCase();
    }
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
        calcSign();
    }
    
}
