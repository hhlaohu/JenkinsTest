package com.yiya.mapper;

import com.yiya.bean.TabBlacklistReportList;
import com.yiya.bean.TabBlacklistReportListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabBlacklistReportListMapper {
    int countByExample(TabBlacklistReportListExample example);

    int deleteByExample(TabBlacklistReportListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TabBlacklistReportList record);

    int insertSelective(TabBlacklistReportList record);

    List<TabBlacklistReportList> selectByExample(TabBlacklistReportListExample example);

    TabBlacklistReportList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TabBlacklistReportList record, @Param("example") TabBlacklistReportListExample example);

    int updateByExample(@Param("record") TabBlacklistReportList record, @Param("example") TabBlacklistReportListExample example);

    int updateByPrimaryKeySelective(TabBlacklistReportList record);

    int updateByPrimaryKey(TabBlacklistReportList record);
}