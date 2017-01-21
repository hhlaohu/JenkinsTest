package com.yiya.mapper;

import java.util.List;

import com.yiya.model.TabUsrDecorationOrderModel;
import com.yiya.bean.TabUsrDecorationOrder;

public interface TabUsrDecorationOrderMapper<T> extends BaseMapper<T> {
	
	public void update(TabUsrDecorationOrder tudo);
	
	public void add(TabUsrDecorationOrder tudo);
	
	public void delete(TabUsrDecorationOrder tudo);

	public TabUsrDecorationOrder queryTabUsrDecorationOrder(TabUsrDecorationOrderModel model);
	
	public List<TabUsrDecorationOrder> queryTabUsrDecorationOrderList(TabUsrDecorationOrderModel model);
}
