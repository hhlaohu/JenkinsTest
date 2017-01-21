package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.ScoringGatherFieldMap;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.ScoringGatherFieldMapMapper;
import com.yiya.model.ScoringGatherFieldMapModel;


/**
 * @author frank_wang
 * @data 2016年11月10日
 * @description
 */
@Service("scoringGatherFieldMapService")
public class ScoringGatherFieldMapService extends BaseService<ScoringGatherFieldMap> {

	
	@Autowired
    private ScoringGatherFieldMapMapper mapper;
	
	@Override
	public BaseMapper<ScoringGatherFieldMap> getMapper() {
		return mapper;
	}
	
	public List<ScoringGatherFieldMapModel> queryByCondition(ScoringGatherFieldMapModel model) throws Exception{
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
 		return mapper.queryByCondition(model);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月10日
	 * @description 根据scoring_field_id查找映射
	 * @param scoring_field_id
	 * @return
	 */
	public ScoringGatherFieldMap selectByScoringFieldId(Integer scoring_field_id){
		
		return mapper.selectByScoringFieldId(scoring_field_id);
	}
	
}
