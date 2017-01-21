package com.yiya.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrDecorationOrder;
import com.yiya.mapper.TabUsrDecorationOrderMapper;
import com.yiya.model.TabUsrDecorationOrderModel;


@Service("tabUsrDecorationOrderService")
public class TabUsrDecorationOrderService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(TabUsrDecorationOrderService.class);
	@Autowired
    private TabUsrDecorationOrderMapper<T> mapper;

	public TabUsrDecorationOrderMapper<T> getMapper() {
		return mapper;
	}
 
	public void update(TabUsrDecorationOrder tudo){
		mapper.update(tudo);
	}
	
	public void add(TabUsrDecorationOrder tudo){
		mapper.add(tudo);
	}
	
	public void delete(TabUsrDecorationOrder tudo){
		mapper.delete(tudo);
	}
	
	public TabUsrDecorationOrder queryTabUsrDecorationOrder(TabUsrDecorationOrderModel model){
		return mapper.queryTabUsrDecorationOrder(model);
	}
	
	public List<TabUsrDecorationOrder> queryTabUsrDecorationOrderList(TabUsrDecorationOrderModel model){
		return mapper.queryTabUsrDecorationOrderList(model);
	}
	
}
