package com.yiya.mapper;

import com.yiya.bean.TabScoringReportList;
import com.yiya.bean.TabScoringReportListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabScoringReportListMapper {
    int countByExample(TabScoringReportListExample example);

    int deleteByExample(TabScoringReportListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TabScoringReportList record);

    int insertSelective(TabScoringReportList record);

    List<TabScoringReportList> selectByExampleWithBLOBs(TabScoringReportListExample example);

    List<TabScoringReportList> selectByExample(TabScoringReportListExample example);

    TabScoringReportList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TabScoringReportList record, @Param("example") TabScoringReportListExample example);

    int updateByExampleWithBLOBs(@Param("record") TabScoringReportList record, @Param("example") TabScoringReportListExample example);

    int updateByExample(@Param("record") TabScoringReportList record, @Param("example") TabScoringReportListExample example);

    int updateByPrimaryKeySelective(TabScoringReportList record);

    int updateByPrimaryKeyWithBLOBs(TabScoringReportList record);

    int updateByPrimaryKey(TabScoringReportList record);
}