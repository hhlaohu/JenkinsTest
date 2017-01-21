package com.yiya.bean.shuzun;

import java.util.HashMap;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年2月18日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: 返回码
**********************************************************
 */
public class ResultCode {
    
    /**
     * 请求成功
     */
    public static final String RESULT_CODE_SUCC = "0000";
    /**
     * 部分请求成功
     */
    public static final String RESULT_CODE_PARTSUCC = "1000";
    /**
     * 请求账号不存在
     */
    public static final String RESULT_CODE_ACCOUNT_ISNOTEXIST = "2000";
    
    /**
     * 请求帐号被冻结
     */
    public static final String RESULT_CODE_ACCOUNT_ISLOCKED = "2001";
    /**
     * 请求没有此接口访问权限
     */
    public static final String RESULT_CODE_NO_PERMISSION = "2002";
    
    /**
     * 请求请求的资源不存在
     */
    public static final String RESULT_CODE_RESOURCES_ISNOTEXIST = "2003";
    
    /**
     * 请求参数为空或格式错误
     */
    public static final String RESULT_CODE_REQUEST_PARAMS_ERROR = "2004";
    
    /**
     * 请求验签失败
     */
    public static final String RESULT_CODE_SIGN_ERROR = "2005";
    
    /**
     * 请求没有查询到结果
     */
    public static final String RESULT_CODE_NO_RESULT = "2006";
    
    /**
     * 请求重复的请求
     */
    public static final String RESULT_CODE_REPEAT_REQUEST = "2008";
    
    /**
     * 请求的数据无效
     */
    public static final String RESULT_CODE_REQUEST_DATA_INVALID = "2009";
    /**
     * 权限不足
     */
    public static final String RESULT_CODE_ACCOUNT_RIGHT = "2010";
    /**
     * 请求账号余额不足
     */
    public static final String RESULT_CODE_ACCOUNT_BALANCE = "2011";
    /**
     * 剩余次数不足
     */
    public static final String RESULT_CODE_ACCOUNT_TIMES = "2012";
    /**
     * 请求url不正确
     */
    public static final String RESULT_CODE_URL_FORBIDDEN = "2013";
    /**
     * 请求ip不正确
     */
    public static final String RESULT_CODE_IP_FORBIDDEN = "2014";
    /**
     * select指标参数不正确
     */
    public static final String RESULT_CODE_INDEX_ERROE = "2015";
    /**
     * 包不存在
     */
    public static final String RESULT_CODE_NOPACKAGE = "2016";
    /**
     * 账户没有包权限
     */
    public static final String RESULT_CODE_ACCOUNT_NOPACKAGE = "2017";
    
    /**
     * 请求   多个非必选参数中必须有一个
     */
    public static final String RESULT_CODE_REQUEST_PARAMSNON_MUST_ONE_ERROR = "2018";
    
    /**
     * 电信认证错误码 包括所有错误 404 500...
     */
    public static final int RESULT_CODE_TELECOMM_ERROR =  2019 ;
    /**
     * 移动数据源错误码
     */
    public static final int RESULT_CODE_MOBILE_ERROR =  2020;
    /**
     * 联通数据源错误码
     */
    public static final int RESULT_CODE_UNICOM_ERROR =  2021;
    /**
     * 银联数据源错误码
     */
    public static final int RESULT_CODE_UNIONPAY_ERROR =  2022;
    
    /**
     * 其他数据源错误码
     */
    public static final int RESULT_CODE_OTHER_ERROR =  2023;
    
    /**
     * 该指标不支持电信号码查询
     */
    public static final String RESULT_CODE_QUOTA_NOT_SUPPORTED_TELECOMM = "2031";
    /**
     * 该指标不支持移动号码查询
     */
    public static final String RESULT_CODE_QUOTA_NOT_SUPPORTED_CMCC = "2032";
    /**
     * 该指标不支持联通号码查询
     */
    public static final String RESULT_CODE_QUOTA_NOT_SUPPORTED_UNICOM = "2033";
    
    /**
     * 上传文件过大
     */
    public static final String RESULT_CODE_UPLOAD_FILE_TOO_LARGE = "3000";
    
    /**
     * 数据正在处理中
     */
    public static final String RESULT_CODE_REQUEST_PROCESSING = "3001";
    public static final int _RESULT_CODE_REQUEST_PROCESSING = 3001;
    /**
     * 银行卡账号输入不正确
     */
    public static final String RESULT_CODE_PARAM_BANKERR = "4001";
    /**
     * 身份证号码输入不正确
     */
    public static final String RESULT_CODE_PARAM_IDERR = "4002";
    /**
     * 组织机构代码不正确
     */
    public static final String RESULT_CODE_PARAM_ORGERR = "4003";
    /**
     * 消费ID格式不正确
     */
    public static final String RESULT_CODE_PARAM_CHARGEIDERR = "4004";
    /**
     * 车牌号格式不正确
     */
    public static final String RESULT_CODE_PARAM_CARNOERR = "4005";
    /**
     * 车架号格式不正确
     */
    public static final String RESULT_CODE_PARAM_CARFARMEERR = "4006";
    /**
     * 发动机号格式不正确
     */
    public static final String RESULT_CODE_PARAM_CARDRIVEERR = "4007";
    /**
     * 营业执照号码格式不正确
     */
    public static final String RESULT_CODE_PARAM_BUSLISERR = "4008";
    /**
     * 固话号码格式不正确
     */
    public static final String RESULT_CODE_FIXEDTELERR = "4009";
    /**
     * 手机号码格式不正确
     */
    public static final String RESULT_CODE_PARAM_TELERR = "4010";
    /**
     * 车辆类型格式不正确
     */
    public static final String RESULT_CODE_PARAM_CATTYPEERR = "4011";
    /**
     * 姓名格式不正确
     */
    public static final String RESULT_CODE_PARAM_NAMEERR = "4012";
    /**
     * 月份格式不正确
     */
    public static final String RESULT_CODE_PARAM_MONTHERR = "4013";
    /**
     * 查询类型格式不正确
     */
    public static final String RESULT_CODE_PARAM_TYPEERR = "4014";
    /**
     * 组织代码名称为空或格式不对
     */
    public static final String RESULT_CODE_PARAM_ORGNAMEERR = "4015";
    /**
     * param参数
     */
    public static final String RESULT_CODE_PARAM_PARAMERR = "4016";
    /**
     * 请求未完全执行成功
     * 
     * 杨总合作 银行要求一次查询多个指标都成功才给返回
     * 一个指标不成功就不返回
     */
    public static final String RESULT_CODE_NOT_COMPLETELY_SUCCESSFUL = "4017";
    /**
     * 系统错误   未知错误
     */
    public static final String RESULT_CODE_ERROR = "9999";
    public static final String RESULT_CODE_UNION_ERROR =  "9998" ;
    
    /**
     * K 错误码  V 错误描述
     */
    public static HashMap<String, String> resultCodeMap = new HashMap<String, String>() {
        /**
         * 
         */
        private static final long serialVersionUID = -6209197629101992324L;

        {
            put(RESULT_CODE_SUCC, "请求成功"); 
            put(RESULT_CODE_PARTSUCC, "部分请求成功"); 
            put(RESULT_CODE_ACCOUNT_ISNOTEXIST, "请求账号不存在"); 
            put(RESULT_CODE_ACCOUNT_ISLOCKED, "请求帐号被冻结");  
            put(RESULT_CODE_NO_PERMISSION, "请求没有此接口访问权限"); 
            put(RESULT_CODE_RESOURCES_ISNOTEXIST, "请求请求的资源不存在"); 
            put(RESULT_CODE_REQUEST_PARAMS_ERROR, "请求参数为空或格式错误"); 
            put(RESULT_CODE_SIGN_ERROR, "请求验签失败");
            put(RESULT_CODE_NO_RESULT, "请求没有查询到结果");
            put(RESULT_CODE_REPEAT_REQUEST, "请求重复的请求");
            put(RESULT_CODE_REQUEST_DATA_INVALID, "请求的数据无效");
            put(RESULT_CODE_REQUEST_PARAMSNON_MUST_ONE_ERROR, "多个非必选参数中必须有一个"); 
            put(RESULT_CODE_UPLOAD_FILE_TOO_LARGE, "上传文件过大"); 
            put(RESULT_CODE_REQUEST_PROCESSING, "银联数据正在处理中"); 
            put(RESULT_CODE_ERROR, "系统错误"); 
            put(RESULT_CODE_UNION_ERROR, "系统错误"); 
            put(RESULT_CODE_ACCOUNT_RIGHT,"账户权限不足");
            put(RESULT_CODE_ACCOUNT_BALANCE,"账户余额不足");
            put(RESULT_CODE_ACCOUNT_TIMES,"账户查询此时不足");
            put(RESULT_CODE_ACCOUNT_NOPACKAGE, "账户没有包权限");
            put(RESULT_CODE_NOPACKAGE, "该包不存在");
            put(RESULT_CODE_URL_FORBIDDEN,"请求的url为空或格式不对");
            put(RESULT_CODE_IP_FORBIDDEN,"请求ip地址为空或格式不对");
            put(RESULT_CODE_INDEX_ERROE,"请求select参数为空或格式不对");
            put(RESULT_CODE_PARAM_BANKERR,"银行卡账号为空或格式不对");
            put(RESULT_CODE_PARAM_IDERR,"身份证号码为空或格式不对");
            put(RESULT_CODE_PARAM_ORGERR,"组织机构代码为空或格式不对");
            put(RESULT_CODE_PARAM_CHARGEIDERR,"消费ID为空或格式不对");
            put(RESULT_CODE_PARAM_CARNOERR,"车牌号为空或格式不对");
            put(RESULT_CODE_PARAM_CARFARMEERR,"车架号为空或格式不对");
            put(RESULT_CODE_PARAM_CARDRIVEERR,"发动机号为空或格式不对");
            put(RESULT_CODE_PARAM_BUSLISERR,"营业执照号码为空或格式不对");
            put(RESULT_CODE_FIXEDTELERR,"固话号码为空或格式不对");
            put(RESULT_CODE_PARAM_TELERR,"手机号码为空或格式不对");
            put(RESULT_CODE_PARAM_CATTYPEERR,"车辆类型为空或格式不对");
            put(RESULT_CODE_PARAM_NAMEERR,"姓名为空或格式不对");
            put(RESULT_CODE_PARAM_MONTHERR,"月份为空或格式不对");
            put(RESULT_CODE_PARAM_TYPEERR,"查询类型为空或格式不对");
            put(RESULT_CODE_PARAM_ORGNAMEERR,"组织代码名称为空或格式不对");
            put(RESULT_CODE_PARAM_PARAMERR,"param为空或格式不对");
            put(_RESULT_CODE_REQUEST_PROCESSING+"","param为空或格式不对");
            
            put(RESULT_CODE_TELECOMM_ERROR+"","电信数据源错误");
            put(RESULT_CODE_OTHER_ERROR+"","其他数据源错误");
            put(RESULT_CODE_MOBILE_ERROR+"","移动数据源错误");
            put(RESULT_CODE_UNICOM_ERROR+"","联通数据源错误");
            put(RESULT_CODE_UNIONPAY_ERROR+"","银联数据源错误"); 
            
            put(RESULT_CODE_QUOTA_NOT_SUPPORTED_TELECOMM, "该指标不支持电信号码查询"); 
            put(RESULT_CODE_QUOTA_NOT_SUPPORTED_CMCC, "该指标不支持移动号码查询"); 
            put(RESULT_CODE_QUOTA_NOT_SUPPORTED_UNICOM, "该指标不支持联通号码查询"); 
            
        }
    };
}
