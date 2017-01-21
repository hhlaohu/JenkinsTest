package com.yiya.mapper;

import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabOrderBondsmaninfMapper {
    int countByExample(TabOrderBondsmaninfExample example);

    int deleteByExample(TabOrderBondsmaninfExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TabOrderBondsmaninf record);

    int insertSelective(TabOrderBondsmaninf record);

    List<TabOrderBondsmaninf> selectByExample(TabOrderBondsmaninfExample example);

    TabOrderBondsmaninf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TabOrderBondsmaninf record, @Param("example") TabOrderBondsmaninfExample example);

    int updateByExample(@Param("record") TabOrderBondsmaninf record, @Param("example") TabOrderBondsmaninfExample example);

    int updateByPrimaryKeySelective(TabOrderBondsmaninf record);

    int updateByPrimaryKey(TabOrderBondsmaninf record);
}