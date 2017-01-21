/******************************************************************************
 * Copyright (C) 2016 ShenZhen TeSu Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为特速金融有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体
 * 不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.yiya.bean;

import java.util.Date;

/**
 * @ClassName: CheckManager
 * @version 1.0 
 * @Desc: TODO
 * @author ming.zhou
 * @date 2016年5月3日下午2:12:20
 * @history v1.0
 *
 */
public class CheckManager
{
    private Integer checkId;
    private Integer spaceId;
    private Integer customerId;
    private String producer;
    private String checker;
    private Integer checkStatus;
    private Date createTime;
    private Date checkTime;
    private String resultDesc;
    private String spaceName;
    private Integer lockStatus;
    private String areaName;
    private String customerName;
    private Integer tsLock;
    
    public Integer getCheckId()
    {
        return checkId;
    }
    public void setCheckId(Integer checkId)
    {
        this.checkId = checkId;
    }
    public Integer getSpaceId()
    {
        return spaceId;
    }
    public void setSpaceId(Integer spaceId)
    {
        this.spaceId = spaceId;
    }
    public Integer getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(Integer customerId)
    {
        this.customerId = customerId;
    }
    public String getProducer()
    {
        return producer;
    }
    public void setProducer(String producer)
    {
        this.producer = producer;
    }
    public String getChecker()
    {
        return checker;
    }
    public void setChecker(String checker)
    {
        this.checker = checker;
    }
    public Integer getCheckStatus()
    {
        return checkStatus;
    }
    public void setCheckStatus(Integer checkStatus)
    {
        this.checkStatus = checkStatus;
    }
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    public Date getCheckTime()
    {
        return checkTime;
    }
    public void setCheckTime(Date checkTime)
    {
        this.checkTime = checkTime;
    }
    public String getResultDesc()
    {
        return resultDesc;
    }
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
    public String getSpaceName()
    {
        return spaceName;
    }
    public void setSpaceName(String spaceName)
    {
        this.spaceName = spaceName;
    }
    public Integer getLockStatus()
    {
        return lockStatus;
    }
    public void setLockStatus(Integer lockStatus)
    {
        this.lockStatus = lockStatus;
    }
    public String getAreaName()
    {
        return areaName;
    }
    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    public Integer getTsLock()
    {
        return tsLock;
    }
    public void setTsLock(Integer tsLock)
    {
        this.tsLock = tsLock;
    }
    
}
