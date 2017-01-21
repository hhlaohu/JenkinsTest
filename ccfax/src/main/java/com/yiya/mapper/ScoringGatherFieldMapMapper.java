package com.yiya.mapper;

import java.util.List;

import com.yiya.bean.ScoringGatherFieldMap;
import com.yiya.model.ScoringGatherFieldMapModel;

/**
 * @author frank_wang
 * @data 2016年11月10日
 * @description
 */
public interface ScoringGatherFieldMapMapper extends BaseMapper<ScoringGatherFieldMap> {
     
     List<ScoringGatherFieldMapModel> queryByCondition(ScoringGatherFieldMapModel model);
     
     ScoringGatherFieldMap selectByScoringFieldId(Integer scoring_field_id);
	
}
