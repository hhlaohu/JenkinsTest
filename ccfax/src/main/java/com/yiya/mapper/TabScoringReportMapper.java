package com.yiya.mapper;

import com.yiya.bean.TabScoringReport;
import com.yiya.bean.TabScoringReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabScoringReportMapper {
    int countByExample(TabScoringReportExample example);

    int deleteByExample(TabScoringReportExample example);

    int deleteByPrimaryKey(Integer report_id);

    int insert(TabScoringReport record);

    int insertSelective(TabScoringReport record);

    List<TabScoringReport> selectByExample(TabScoringReportExample example);

    TabScoringReport selectByPrimaryKey(Integer report_id);

    int updateByExampleSelective(@Param("record") TabScoringReport record, @Param("example") TabScoringReportExample example);

    int updateByExample(@Param("record") TabScoringReport record, @Param("example") TabScoringReportExample example);

    int updateByPrimaryKeySelective(TabScoringReport record);

    int updateByPrimaryKey(TabScoringReport record);
}