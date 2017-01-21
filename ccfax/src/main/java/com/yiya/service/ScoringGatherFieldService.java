package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.ScoringGatherField;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.ScoringGatherFieldMapper;
import com.yiya.model.ScoringGatherFieldModel;

/**
 * @author Administrator
 * @data 2016年10月9日
 * @description
 */
@Service("scoringGatherFieldService")
public class ScoringGatherFieldService extends BaseService<ScoringGatherField> {

	
	@Autowired
    private ScoringGatherFieldMapper mapper;
	
	@Override
	public BaseMapper<ScoringGatherField> getMapper() {
		return mapper;
	}
	
	public List<ScoringGatherField> queryByCondition(ScoringGatherFieldModel model){
 		return mapper.queryByCondition(model);
	}
	
	public List<ScoringGatherFieldModel> queryJoinScoringTypeTable(ScoringGatherFieldModel model) throws Exception{
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
 		return mapper.queryJoinScoringTypeTable(model);
	}
	
	public void batchInsert(List<ScoringGatherField> list){
		mapper.batchInsert(list);
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 根据字段名字判断是否已存在表中
	 * @return
	 */
	public Boolean isExistByFieldName(String name){
		
		ScoringGatherField field = getScoringGatherFieldByName(name);
		if(field != null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月9日
	 * @description 根据字段名查记录
	 * @return
	 */
	public ScoringGatherField getScoringGatherFieldByName(String name){
		ScoringGatherFieldModel condition = new ScoringGatherFieldModel();
		condition.setField_name(name);
		List<ScoringGatherField> list = queryByCondition(condition);
        if(list != null && list.size() >0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
	/**
	 * @author frank_wang
	 * @data 2016年11月10日
	 * @description 查询全部采集字段
	 * @return
	 */
	public List<ScoringGatherField> queryAll(){
		return queryByCondition(null);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月10日
	 * @description 根据主键找
	 * @return
	 */
	public ScoringGatherField getScoringGatherFieldById(Long gather_field_id){
		ScoringGatherFieldModel condition = new ScoringGatherFieldModel();
		condition.setGather_field_id(gather_field_id);
		List<ScoringGatherField> list = queryByCondition(condition);
        if(list != null && list.size() >0){
        	return list.get(0);
        }else{
        	return null;
        }
	}
	
}
