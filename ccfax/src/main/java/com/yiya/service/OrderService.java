package com.yiya.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.BorrowUserOrder;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabOrderCheckLog;
import com.yiya.mapper.OrderMapper;
import com.yiya.model.OrderModel;

@Service("orderService")
public class OrderService<T> extends BaseService<T>{
	
	private final static Logger log= Logger.getLogger(OrderService.class);
	
	@Autowired
    private OrderMapper<T> mapper;

	public OrderMapper<T> getMapper() {
		return mapper;
	}

	public List<BorrowUserOrder> getOrderDataList(OrderModel model) throws Exception {
		Integer rowCount = getOrderDataCnt(model);
		model.getPager().setRowCount(rowCount);
		return mapper.getOrderDataList(model);
	}
	
	public int getOrderDataCnt(OrderModel model) throws Exception {
		return mapper.getOrderDataCnt(model);
	}

	public BorrowUserOrder findBorrowUserOrderByUsrOrderId(Integer usr_order_id) {
		
		return mapper.findBorrowUserOrderByUsrOrderId(usr_order_id);
	}

	public List<TabOrderCheckLog> findTabOrderCheckLogsByUsrOrderId(
			Integer usr_order_id) {
		
		return mapper.findTabOrderCheckLogsByUsrOrderId(usr_order_id);
	}

	public int updateCheckStatus(Map<String, Object> map) {
		
		return mapper.updateCheckStatus(map);
	}

	public void addTabOrderCheckLog(TabOrderCheckLog tabOrderCheckLog) {
		
		mapper.addTabOrderCheckLog(tabOrderCheckLog);
	}

	public List<TabOrderBondsmaninf> findTabOrderBondsmaninfsByUsrOrderId(
			Integer usr_order_id) {
	
		return mapper.findTabOrderBondsmaninfsByUsrOrderId(usr_order_id);
	}

	public List<String> findOrderPicByUsrOrderId(Integer usr_order_id) {
		
		return mapper.findOrderPicByUsrOrderId(usr_order_id);
	}
	
	//获取合同，产品，项目几个类型的照片地址
	public List<String> getPicAdd(Integer usr_order_id)
	{
		return mapper.getPicAdd(usr_order_id);
	}

	public void updateOrderHaveScoringReport(String order_sn) {
		
		mapper.updateOrderHaveScoringReport(order_sn);
	}

	public int updateReportInfo(Map<String, Object> map) {
		
		return mapper.updateReportInfo(map);
	}

}
