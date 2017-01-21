package com.yiya.mapper;

import java.util.List;

import com.yiya.bean.ErrorDaily;
import com.yiya.bean.TabCustomer;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.TabCustomerModel;

public interface TabCustomerMapper<T> extends BaseMapper<T> {
	
	public List<TabCustomer> queryByList(TabCustomerModel tb);
	
	public List<ErrorDaily> queryErrorDaily(ErrorDailyModel tb);
	
	public int queryErrorDailyCount(ErrorDailyModel tb);
	
	public void errorStatusUp(ErrorDailyModel tb);
	
	public void deleteerror(ErrorDailyModel tb);
	
	public void adderrordaily(ErrorDailyModel tb);
	
	public void batchInsertErrorDaily(List<ErrorDailyModel> list);
	
	public void update(TabCustomerModel tb);
	
	public void updatelockline(TabCustomerModel tb);
	
	public TabCustomer queryBycustomerid(TabCustomerModel tb);
	
	public List<TabCustomer> queryAllList(TabCustomerModel tb);
	
	public void updateborrow(TabCustomer tb);
	
	/**批量更新*/
    public void batchUpdateTabCustomer(List<TabCustomer> list);
}
