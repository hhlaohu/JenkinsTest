package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.BorrowUserOrder;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabOrderCheckLog;
import com.yiya.model.OrderModel;



public interface OrderMapper<T> extends BaseMapper<T> {

	int getOrderDataCnt(OrderModel model);

	List<BorrowUserOrder> getOrderDataList(OrderModel model);

	BorrowUserOrder findBorrowUserOrderByUsrOrderId(Integer usr_order_id);

	List<TabOrderCheckLog> findTabOrderCheckLogsByUsrOrderId(
			Integer usr_order_id);

	int updateCheckStatus(Map<String, Object> map);

	void addTabOrderCheckLog(TabOrderCheckLog tabOrderCheckLog);

	List<TabOrderBondsmaninf> findTabOrderBondsmaninfsByUsrOrderId(
			Integer usr_order_id);

	List<String> findOrderPicByUsrOrderId(Integer usr_order_id);

	//获取合同，产品，项目几个类型的照片地址
	List<String> getPicAdd(Integer usr_order_id);
	
	void updateOrderHaveScoringReport(String order_sn);

	int updateReportInfo(Map<String, Object> map);

}
