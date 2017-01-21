package com.yiya.mapper;

import com.yiya.bean.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabUsrOrderPicMapper {
    int countByExample(TabUsrOrderPicExample example);

    int deleteByExample(TabUsrOrderPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TabUsrOrderPic record);

    int insertSelective(TabUsrOrderPic record);

    List<TabUsrOrderPic> selectByExample(TabUsrOrderPicExample example);

    TabUsrOrderPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TabUsrOrderPic record, @Param("example") TabUsrOrderPicExample example);

    int updateByExample(@Param("record") TabUsrOrderPic record, @Param("example") TabUsrOrderPicExample example);

    int updateByPrimaryKeySelective(TabUsrOrderPic record);

    int updateByPrimaryKey(TabUsrOrderPic record);
}