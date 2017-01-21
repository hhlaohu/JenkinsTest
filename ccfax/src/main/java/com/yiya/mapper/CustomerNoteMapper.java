package com.yiya.mapper;

import com.yiya.bean.CustomerNote;
import com.yiya.bean.product_controll;

public interface CustomerNoteMapper<T> extends BaseMapper<T> {
	
   public CustomerNote queryMaxId(CustomerNote model);
   
   public product_controll querypzgoods(product_controll pc);
   
   public product_controll queryStockgoods(product_controll pc);
}
