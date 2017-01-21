package com.yiya.mapper;



import java.util.List;

import com.yiya.bean.TabAreaBean;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月23日
 * @description
 */
public interface TabAreaBeanMapper extends BaseMapper<TabAreaBean> {

	List<TabAreaBean> queryByCondition(TabAreaBean tabAreaBean);	
}
