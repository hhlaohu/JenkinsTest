package com.yiya.mapper;

import com.yiya.bean.TabAffiliateRule;
import com.yiya.bean.TabAffiliateRuleExample;
import com.yiya.model.TabAffiliateRuleModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabAffiliateRuleMapper {
    int countByExample(TabAffiliateRuleExample example);

    int deleteByExample(TabAffiliateRuleExample example);

    int deleteByPrimaryKey(Long affiliate_rule_id);

    int insert(TabAffiliateRule record);

    int insertSelective(TabAffiliateRule record);

    List<TabAffiliateRuleModel> selectByExample(TabAffiliateRuleExample example);

    TabAffiliateRule selectByPrimaryKey(Long affiliate_rule_id);

    int updateByExampleSelective(@Param("record") TabAffiliateRule record, @Param("example") TabAffiliateRuleExample example);

    int updateByExample(@Param("record") TabAffiliateRule record, @Param("example") TabAffiliateRuleExample example);

    int updateByPrimaryKeySelective(TabAffiliateRule record);

    int updateByPrimaryKey(TabAffiliateRule record);
}