package com.yiya.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrOrderExample;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.TabUsrOrderMapper;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.utils.DateUtil;
import com.yiya.utils.StringUtil;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月28日
 * @description
 */
@Service("tabUsrOrderService")
public class TabUsrOrderService {

	@Autowired
	private TabUsrOrderMapper mapper;

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description
	 */
	public void insert(TabUsrOrder tabUsrOrder) {

		if (null == tabUsrOrder) {
			return;
		}
		mapper.insert(tabUsrOrder);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月12日
	 * @description 有选择的插入，如果没有附带值，则采用建表时的默认值
	 */
	public void insertSelective(TabUsrOrder tabUsrOrder) {

		if (null == tabUsrOrder) {
			return;
		}
		mapper.insertSelective(tabUsrOrder);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 有选择的更新
	 */
	public void updateByExampleSelective(TabUsrOrder tabUsrOrder, TabUsrOrderExample example) {

		if (null == tabUsrOrder) {
			return;
		}
		mapper.updateByExampleSelective(tabUsrOrder, example);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 根据订单号有选择的更新
	 */
	public void updateByOrderSnSelective(TabUsrOrder tabUsrOrder, String order_sn) {

		if (null == tabUsrOrder || StringUtil.isEmpty(order_sn)) {
			return;
		}
		TabUsrOrderExample example = new TabUsrOrderExample();
		example.createCriteria().andOrder_snEqualTo(order_sn);
		mapper.updateByExampleSelective(tabUsrOrder, example);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 根据主键有选择的更新
	 */
	public void updateByPrimaryKeySelective(TabUsrOrder tabUsrOrder) {

		if (null == tabUsrOrder || tabUsrOrder.getUsr_order_id() == null) {
			return;
		}
		mapper.updateByPrimaryKeySelective(tabUsrOrder);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 产生订单号
	 * @return
	 */
	public synchronized String produceOrderNo(Integer orderType) {

		String timeStamp = DateUtil.getStringOfNowDate("yyyyMMddHHmmss");
		Random random = new Random();
		String randomString = "";
		String orderNo = "";
		for (int i = 0; i < 5; i++) {
			randomString += random.nextInt(10);
		}
		orderNo = timeStamp + "_" + randomString + "_" + orderType;
		return orderNo;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 根据条件分页查询
	 * @param model
	 * @return
	 */
	public List<TabUsrOrder> queryByList(TabUsrinf2Model model) {
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
		return mapper.queryByList(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 查询总数
	 * @param model
	 * @return
	 */
	public Integer queryByCount(TabUsrinf2Model model) {
		return mapper.queryByCount(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description
	 * @param orderNo
	 * @return
	 */
	public TabUsrOrder queryOrderByOrderNo(String orderNo) {
		if (StringUtil.isEmpty(orderNo)) {
			return null;
		}
		TabUsrOrderExample example = new TabUsrOrderExample();
		example.createCriteria().andOrder_snEqualTo(orderNo);
		List<TabUsrOrder> list = mapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月13日
	 * @description 根据usrid查找
	 * @param usrId
	 * @return
	 */
	public List<TabUsrOrder> queryOrderByUsrId(Long usrid) {
		if (usrid == null) {
			return null;
		}
		TabUsrOrderExample example = new TabUsrOrderExample();
		example.createCriteria().andBorrow_uidEqualTo(usrid);
		List<TabUsrOrder> list = mapper.selectByExample(example);
		return list;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月13日
	 * @description 根据usrid查询未还款相应的订单
	 * @param usrid
	 * @return
	 */
	public List<TabUsrOrder> queryNotRepayOrderByUsrId(Long usrid) {
		if (usrid == null) {
			return null;
		}
		TabUsrOrderExample example = new TabUsrOrderExample();
		example.createCriteria().andBorrow_uidEqualTo(usrid)
				.andOrder_statusNotEqualTo(WebServiceConstant.ORDER_STATUS_REPAY_COMPLISH);
		List<TabUsrOrder> list = mapper.selectByExample(example);
		return list;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 根据身份证号算出借款未还款总笔数，即订单总数
	 * @param idCard
	 * @return
	 */
	public Integer getBorrowCount(Long usrid) {
		if (usrid == null) {
			return null;
		}
		List<TabUsrOrder> list = queryNotRepayOrderByUsrId(usrid);
		return list.size();
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月12日
	 * @description 根据主键查询订单
	 * @param usrOrderId
	 * @return
	 */
	public TabUsrOrder queryByUsrOrderId(Long usrOrderId){
		
		if(usrOrderId == null){
			return null;
		}
		return mapper.selectByPrimaryKey(usrOrderId);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月19日
	 * @description 根据订单状态查询订单
	 * @return
	 */
	public List<TabUsrOrder> queryByOrderStatus(Integer status){
		
		if(status == null){
			return null;
		}
		TabUsrOrderExample example = new TabUsrOrderExample();
		example.createCriteria().andOrder_statusEqualTo(status);
		return mapper.selectByExample(example);
	}
	
}
