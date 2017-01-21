package com.yiya.mapper;

import com.yiya.bean.TabAntiFraudReportList;
import com.yiya.bean.TabAntiFraudReportListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabAntiFraudReportListMapper {
    int countByExample(TabAntiFraudReportListExample example);

    int deleteByExample(TabAntiFraudReportListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TabAntiFraudReportList record);

    int insertSelective(TabAntiFraudReportList record);

    List<TabAntiFraudReportList> selectByExampleWithBLOBs(TabAntiFraudReportListExample example);

    List<TabAntiFraudReportList> selectByExample(TabAntiFraudReportListExample example);

    TabAntiFraudReportList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TabAntiFraudReportList record, @Param("example") TabAntiFraudReportListExample example);

    int updateByExampleWithBLOBs(@Param("record") TabAntiFraudReportList record, @Param("example") TabAntiFraudReportListExample example);

    int updateByExample(@Param("record") TabAntiFraudReportList record, @Param("example") TabAntiFraudReportListExample example);

    int updateByPrimaryKeySelective(TabAntiFraudReportList record);

    int updateByPrimaryKeyWithBLOBs(TabAntiFraudReportList record);

    int updateByPrimaryKey(TabAntiFraudReportList record);
}