package com.yiya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yiya.bean.TabAffiliateRuleReportList;
import com.yiya.bean.TabAffiliateRuleReportListExample;
import com.yiya.model.TabAffiliateRuleReportListModel;

public interface TabAffiliateRuleReportListMapper {
    int countByExample(TabAffiliateRuleReportListExample example);

    int deleteByExample(TabAffiliateRuleReportListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TabAffiliateRuleReportList record);

    int insertSelective(TabAffiliateRuleReportList record);

    List<TabAffiliateRuleReportList> selectByExample(TabAffiliateRuleReportListExample example);

    TabAffiliateRuleReportList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TabAffiliateRuleReportList record, @Param("example") TabAffiliateRuleReportListExample example);

    int updateByExample(@Param("record") TabAffiliateRuleReportList record, @Param("example") TabAffiliateRuleReportListExample example);

    int updateByPrimaryKeySelective(TabAffiliateRuleReportList record);

    int updateByPrimaryKey(TabAffiliateRuleReportList record);
    
    List<TabAffiliateRuleReportListModel> queryJoinTabAffiliateRule(TabAffiliateRuleReportListModel model);
    
    Integer queryJoinTabAffiliateRuleCount(TabAffiliateRuleReportListModel model);
    
}