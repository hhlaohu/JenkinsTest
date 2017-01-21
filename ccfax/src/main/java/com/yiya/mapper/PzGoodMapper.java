package com.yiya.mapper;

import java.util.List;
import java.util.Map;

import com.yiya.bean.PzGood;
import com.yiya.model.PzGoodAndSpecConfigModel;
import com.yiya.model.PzGoodModel;


public interface PzGoodMapper<T> extends BaseMapper<T> {
	
	/**
	 * 添加配置管理信息
	 */
	public void addPzGood(Map<String, Object> params);
	
	/**
	 * 查询配置管理信息总条目数
	 */
    public Integer queryCountbyAll();
   
    /**
     * 查询配置管理信息列表
     * @param params
     * @return
     */
    public List<T> queryByAll(Map<String,Object> params);
    
    /**
     * 修改配置管理信息
     * @param params
     */
    public void modifyPzGood(Map<String,Object> params);
    
    /**
     * 按货物名称查询总数目
     */
    public Integer queryPzGoodNameCount(PzGoodModel model);
    
    /**
     * 查询货物名称List
     */
    public List<PzGood> listAll();
    
    /**
     * 匹配pz_good表
     */
    public PzGood matchGoodWithCondition(Map<String, Object> map);
    
    /**
     * 联表spec_config 查询
     */
    public List<PzGoodAndSpecConfigModel> queryAllJoinSpecConfig(Map<String,Object> params);
    
    /**
     * 规格查询互斥
     * @param params
     * @return
     */
    public List<PzGoodAndSpecConfigModel> queryPzGoodSizeReject(Map<String,Object> params);
    
    /**
	  * 批量导入配置信息queryByone
	  */
	 public Integer insertBatchPzGood(PzGood pzGood);
	 
	 public T queryByone(T t);
	 
	 public List<T> queryPlace();
	 
	 public List<T> queryLevel();
	 
	 public T queryByName(Map<String, Object> map);
	 
	 /**
	  * 新增配置管理判断
	  * @param map
	  * @return
	  */
	 public T queryLevelIn(Map<String, Object> map);
	 public T querySizeIn(Map<String, Object> map);
	 public T queryAllByName(Map<String, Object> map);
	 public T queryAllByName2(Map<String, Object> map);
	 public T queryPlaceIsAll(Map<String, Object> map);
     public T queryLevelIsAll(Map<String, Object> map);
	 public T querySizeIsAll(Map<String, Object> map);
		 
}
