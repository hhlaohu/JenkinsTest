package com.yiya.mapper;

import com.yiya.bean.*;
import com.yiya.model.TabUsrinf2Model;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabUsrinf2Mapper {
	
    int countByExample(TabUsrinf2Example example);

    int deleteByExample(TabUsrinf2Example example);

    int deleteByPrimaryKey(Long usrinf_id);

    int insert(TabUsrinf2 record);

    int insertSelective(TabUsrinf2 record);

    List<TabUsrinf2> selectByExample(TabUsrinf2Example example);

    TabUsrinf2 selectByPrimaryKey(Long usrinf_id);

    int updateByExampleSelective(@Param("record") TabUsrinf2 record, @Param("example") TabUsrinf2Example example);

    int updateByExample(@Param("record") TabUsrinf2 record, @Param("example") TabUsrinf2Example example);

    int updateByPrimaryKeySelective(TabUsrinf2 record);

    int updateByPrimaryKey(TabUsrinf2 record);
    
    /**
     * @author frank_wang[JackLikeYou2016@gmail.com]
     * @date 2016年11月23日
     * @description 条件查询（分页）
     * @return
     */
    List<TabUsrinf2Model> queryByList(TabUsrinf2Model model);
    
    Integer queryByCount(TabUsrinf2Model model);
    
    
    /**
     * @author frank_wang[JackLikeYou2016@gmail.com]
     * @date 2016年12月8日
     * @description  查询用户信息表关联订单表，根据id_card关联
     * @param model
     * @return
     */
    List<TabUsrinf2Model> selectUserWithOrderTable(TabUsrinf2Model model);
    
    /**
     * @author frank_wang[JackLikeYou2016@gmail.com]
     * @date 2016年12月8日
     * @description 查询上一个方法的总数
     * @param model
     * @return
     */
    Integer selectUserWithOrderTableCount(TabUsrinf2Model model);
    
}