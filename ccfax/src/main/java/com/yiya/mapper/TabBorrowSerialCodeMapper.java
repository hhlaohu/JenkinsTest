package com.yiya.mapper;

import com.yiya.bean.TabBorrowSerialCode;
import com.yiya.bean.TabBorrowSerialCodeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TabBorrowSerialCodeMapper {
    int countByExample(TabBorrowSerialCodeExample example);

    int deleteByExample(TabBorrowSerialCodeExample example);

    int insert(TabBorrowSerialCode record);

    int insertSelective(TabBorrowSerialCode record);

    List<TabBorrowSerialCode> selectByExample(TabBorrowSerialCodeExample example);

    int updateByExampleSelective(@Param("record") TabBorrowSerialCode record, @Param("example") TabBorrowSerialCodeExample example);

    int updateByExample(@Param("record") TabBorrowSerialCode record, @Param("example") TabBorrowSerialCodeExample example);
    
    TabBorrowSerialCode selectLastCodeByBorrowType(Map<String, Object> map);
}