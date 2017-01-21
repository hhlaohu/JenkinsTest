package com.yiya.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.mapper.TabStockMapper;
import com.yiya.model.StockAndCommentBlendModel;
import com.yiya.model.TabStockModel;
import com.yiya.bean.TabStock;

@Service("tabStockService")
public class TabStockService<T> extends BaseService<T> {
	
	private final static Logger log= Logger.getLogger(TabStockService.class);
	
	@Autowired
    private TabStockMapper<T> mapper;

	public TabStockMapper<T> getMapper() {
		return mapper;
	}
	
	public List<TabStock> queryStockDetailList(TabStockModel model){
		 return mapper.queryStockDetailList(model);
	}
	
	public int queryStockDetailCount(TabStockModel model){
		return mapper.queryStockDetailCount(model);
	}
	
	public void deleteStock(int stock_id){
		mapper.deleteStock(stock_id);
	}
	
	public List<TabStock> queryAllByList(TabStockModel model){
		return mapper.queryAllByList(model);
	}
	
	public List<TabStock> queryAllTabStock(){
		return mapper.queryAllTabStock();
	}
	
	/**
	 * @param customerId
	 * @return float
	 * @description 根据客户id获取库存折后总价
	 * @author wang_xiao_long
	 */
	public BigDecimal getDisCountStockValueByCustId(Integer customerId){
		TabStockModel model = new TabStockModel();
		model.setCustomer_id(customerId);
		List<TabStock> tabStockList = queryAllByList(model);
		BigDecimal disCountStockValue = new BigDecimal(0);
		if(tabStockList != null && tabStockList.size() > 0){
			for(TabStock stock : tabStockList){
				if(null==stock.getGood_volume()){
					stock.setGood_volume("0");
				}
				if(null==stock.getMarket_prices()){
					stock.setMarket_prices(new BigDecimal(0));
				}
				if(null==stock.getPledge_multiplier()){
					stock.setPledge_multiplier(new BigDecimal(0));
				}
				//体积*市场指导价*质押系数
				disCountStockValue = disCountStockValue.add(new BigDecimal(stock.getGood_volume()).multiply(stock.getMarket_prices().
						multiply(stock.getPledge_multiplier())));
				
			}
		}
		return disCountStockValue;
	}
	
	/**
	 * @param List<Integer>
	 * @return List<StockAndCommentBlendModel>
	 * @description 查询包含于id集合的记录
	 * @author wang_xiao_long
	 */
	public List<StockAndCommentBlendModel> queryStockByBatchId(List<Integer> list){
		if(list == null || list.size() ==0){
			return null;
		}
		return getMapper().queryStockByBatchId(list);
	}
	
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年9月14日
	 * @description 批量插入
	 * @param list
	 */
	public void addInBatch(List<TabStock> list){
		if(list == null || list.size() ==0){
			return;
		}
		getMapper().addInBatch(list);
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年9月14日
	 * @description 批量更新
	 * @param list
	 */
	public void updateInBatch(List<TabStock> list){
		if(list == null || list.size() ==0){
			return;
		}
		getMapper().updateInBatch(list);
	}
	
	/**
	 * @author wang_xiao_long
	 * @data 2016年9月14日
	 * @description 批量删除
	 * @param list
	 */
	public void deleteInBatch(List<Integer> list){
		if(list == null || list.size() ==0){
			return;
		}
		getMapper().deleteInBatch(list);
	}
	
}
