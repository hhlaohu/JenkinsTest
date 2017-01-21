package com.yiya.bean.shuzun;

import java.util.List;

import com.yiya.bean.ShuZunQuotaParam;

public class ShuZunRequestParams {
	private String quotas;
	private List<ShuZunQuotaParam> quotaParamList;
	public String getQuotas() {
		return quotas;
	}
	public void setQuotas(String quotas) {
		this.quotas = quotas;
	}
	public List<ShuZunQuotaParam> getQuotaParamList() {
		return quotaParamList;
	}
	public void setQuotaParamList(List<ShuZunQuotaParam> quotaParamList) {
		this.quotaParamList = quotaParamList;
	}
	@Override
	public String toString() {
		return "ShuZunRequestParams [quotas=" + quotas + ", quotaParamList=" + quotaParamList + "]";
	}
	

}
