package com.yiya.mapper;

import java.util.List;

import com.yiya.model.StockAndCommentBlendModel;
import com.yiya.model.TabStockModel;
import com.yiya.bean.TabStock;

public interface TabStockMapper<T> extends BaseMapper<T> {
	
	public List<TabStock> queryStockDetailList(TabStockModel model);
	
	public int queryStockDetailCount(TabStockModel model);
	
	public void deleteStock(int stock_id);
	
	public List<TabStock> queryAllByList(TabStockModel model);
	
	/**
	 * @param list
	 * @return
	 * @description 查询包含于id集合的记录
	 * @author wang_xiao_long
	 * @date 2016/08/10
	 */
	public List<StockAndCommentBlendModel> queryStockByBatchId(List<Integer> list);
	
	public List<TabStock> queryAllTabStock();
	
	public void addInBatch(List<TabStock> list);
	
	public void updateInBatch(List<TabStock> list);
	
	public void deleteInBatch(List<Integer> list);
	
}
