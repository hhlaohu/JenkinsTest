package com.yiya.mapper;

import java.util.List;

import com.yiya.bean.ScoringGatherField;
import com.yiya.model.ScoringGatherFieldModel;

/**
 * @author frank_wang
 * @data 2016年11月3日
 * @description
 */
public interface ScoringGatherFieldMapper extends BaseMapper<ScoringGatherField> {

 	 List<ScoringGatherField> queryByCondition(ScoringGatherFieldModel field);
 	 
 	 List<ScoringGatherFieldModel> queryJoinScoringTypeTable(ScoringGatherFieldModel field);
 	 
 	 void batchInsert(List<ScoringGatherField> list);
 	 
}
