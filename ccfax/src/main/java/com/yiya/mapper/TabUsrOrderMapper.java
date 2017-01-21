package com.yiya.mapper;

import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrOrderExample;
import com.yiya.model.TabUsrinf2Model;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author frank_wang [JackLikeYou2016@gmail.com]
 * @date 2017年1月10日
 * @description 注：逆向工程重新生成bean、mapper文件时要记得
 *                 1：insert 语句要加上返回主键值
 *                 2：自己单独写的sql要加上
 *                 3：bean的构造器要加上
 */
public interface TabUsrOrderMapper {
	
    int countByExample(TabUsrOrderExample example);

    int deleteByExample(TabUsrOrderExample example);

    int deleteByPrimaryKey(Long usr_order_id);

    int insert(TabUsrOrder record);

    int insertSelective(TabUsrOrder record);

    List<TabUsrOrder> selectByExample(TabUsrOrderExample example);

    TabUsrOrder selectByPrimaryKey(Long usr_order_id);

    int updateByExampleSelective(@Param("record") TabUsrOrder record, @Param("example") TabUsrOrderExample example);

    int updateByExample(@Param("record") TabUsrOrder record, @Param("example") TabUsrOrderExample example);

    int updateByPrimaryKeySelective(TabUsrOrder record);

    int updateByPrimaryKey(TabUsrOrder record);
    
    int queryByCount(TabUsrinf2Model model);
    
    List<TabUsrOrder> queryByList(TabUsrinf2Model model);

}