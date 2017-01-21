package com.yiya.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.bean.TabAreaBean;
import com.yiya.mapper.BaseMapper;
import com.yiya.mapper.TabAreaBeanMapper;
import com.yiya.model.TabUsrinf2Model;


/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月23日
 * @description
 */
@Service("TabAreaService")
public class TabAreaBeanService extends BaseService<TabAreaBean> {

	
	@Autowired
	private TabAreaBeanMapper  tabAreaMapper;
	
	@Override
	public BaseMapper<TabAreaBean> getMapper() {
		
		return tabAreaMapper;
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 * @param typeId
	 * @return
	 */
	public List<TabAreaBean> queryListByTypeId(Integer typeId){
        
		TabAreaBean bean = new TabAreaBean(typeId,null,null);
		return tabAreaMapper.queryByCondition(bean);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 * @return
	 */
	public TabAreaBean queryTabAreaBeanByAreaId(Integer areaId){
		
		TabAreaBean bean = new TabAreaBean(null,areaId,null);
		List<TabAreaBean> list = tabAreaMapper.queryByCondition(bean);
		if(list != null && list.size() == 1){
			return list.get(0);
		}
		return null;
	}
	
    /**
     * @author frank_wang[JackLikeYou2016@gmail.com]
     * @date 2016年11月24日
     * @description
     * @param parentId
     * @return
     */
    public List<TabAreaBean> queryTabAreaBeanByParentId(Integer parentId){
		
		TabAreaBean bean = new TabAreaBean(null,null,parentId);
		List<TabAreaBean> list = tabAreaMapper.queryByCondition(bean);
		return list;
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 处理户籍地区的数据，以显示省市县
	 */
	public void dealTabArea(TabUsrinf2Model model){
		TabAreaBean initialBean = queryTabAreaBeanByAreaId(model.getRegister_place());
		if(null != initialBean){
			if(initialBean.getArea_parent_id() != 0){
	            if(initialBean.getArea_deep().intValue() == 3){
	            	TabAreaBean cityBean = queryTabAreaBeanByAreaId(initialBean.getArea_parent_id());
	            	TabAreaBean provinceBean = queryTabAreaBeanByAreaId(cityBean.getArea_parent_id());
	            	model.setArea_county(initialBean.getArea_id());
	            	model.setArea_city(cityBean.getArea_id());
	            	model.setArea_province(provinceBean.getArea_id());
	            }else if(initialBean.getArea_deep().intValue() == 2){
	            	TabAreaBean provinceBean = queryTabAreaBeanByAreaId(initialBean.getArea_parent_id()); 
	            	model.setArea_city(initialBean.getArea_id());
	            	model.setArea_province(provinceBean.getArea_id());
	            }
		   }else{
			   model.setArea_province(model.getRegister_place());
		   }
		}
	}
}
