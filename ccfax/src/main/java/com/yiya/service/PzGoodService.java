package com.yiya.service;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.PzGood;
import com.yiya.mapper.PzGoodMapper;
import com.yiya.model.PzGoodAndSpecConfigModel;
import com.yiya.model.PzGoodModel;




@Service("pzGoodService")
public class PzGoodService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(PzGoodService.class);

	@Autowired
    private PzGoodMapper<T> mapper;
	
	@Override
	public PzGoodMapper<T> getMapper() {
		return mapper;
	}
	
	/**
	 * 添加配置管理信息
	 * @param params
	 */
	public void addPzGood(Map<String, Object> params){
		getMapper().addPzGood(params);
	}
	
	
	/**
	 * 查询配置管理总条目数
	 * @return
	 */
	public Integer queryCountbyAll(){
		return getMapper().queryCountbyAll();
	}
	
	/**
	 * 查询配置管理信息列表
	 */
	public List<T> queryByAll(Map<String,Object> params){
	    return getMapper().queryByAll(params);
	}
	
	/**
	 * 修改配置管理信息
	 */
	public void modifyPzGood(Map<String,Object> params){
		getMapper().modifyPzGood(params);
	}
	
	 /**
     * 按货物名称查询总数目
     */
	 public Integer queryPzGoodNameCount(PzGoodModel model){
		 return getMapper().queryPzGoodNameCount(model);
	 }
	 
	 /**
	  * 查询货物名称List
	  * @return
	  */
	 public List<PzGood> listAll(){
		 return getMapper().listAll();
	 }
	 
	 /**
	  * 按照一定规则匹配 配置表pz_good
	  */
	 public PzGood matchGoodWithCondition(Map<String, Object> map){
		 return getMapper().matchGoodWithCondition(map);
	 }

	 /**
      * 联表spec_config 查询
      */
	 public List<PzGoodAndSpecConfigModel> queryAllJoinSpecConfig(Map<String,Object> params){
         return getMapper().queryAllJoinSpecConfig(params);		 
	 }
	 
	 
	 /**
     * 规格查询互斥
     * @param params
     * @return
     */
	 public List<PzGoodAndSpecConfigModel> queryPzGoodSizeReject(Map<String,Object> params){
         return getMapper().queryPzGoodSizeReject(params);		 
	 }
	 /**
	  * 批量导入配置信息
	  */
	 public Integer insertBatchPzGood(PzGood pzGood){
		 return getMapper().insertBatchPzGood(pzGood);
	 }
	 
	 public T queryByone(T t){
		 return getMapper().queryByone(t);
	 }
	 
	 public List<T> queryPlace(){
		 return getMapper().queryPlace();
	 }
	 
	 public List<T> queryLevel(){
		 return getMapper().queryLevel();
	 }
	 
	 public T queryLevelIn(Map<String, Object> map){
		 return getMapper().queryLevelIn(map);
	 }
	 public T querySizeIn(Map<String, Object> map){
		 return getMapper().querySizeIn(map);
	 }
	 
	 public T queryByName(Map<String, Object> map){
		 return getMapper().queryByName(map);
	 }
	 
	 public T queryAllByName(Map<String, Object> map){
		 return getMapper().queryAllByName(map);
	 }
	 
	 public T queryAllByName2(Map<String, Object> map){
		 return getMapper().queryAllByName2(map);
	 }
	
	 public T queryPlaceIsAll(Map<String, Object> map){
		 return getMapper().queryPlaceIsAll(map);
	 }
	 
	
	 public T queryLevelIsAll(Map<String, Object> map){
		 return getMapper().queryLevelIsAll(map);
	 }
	 
	 public T querySizeIsAll(Map<String, Object> map){
		 return getMapper().querySizeIsAll(map);
	 }
	 
	
}
