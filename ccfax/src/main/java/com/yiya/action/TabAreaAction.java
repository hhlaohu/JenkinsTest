package com.yiya.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiya.bean.TabAreaBean;
import com.yiya.service.TabAreaBeanService;
/**
 * @author frank_wang
 * @data 2016年11月3日
 * @description 数据字典  户籍省市县
 */
@Controller
@RequestMapping("/tabArea")
public class TabAreaAction extends BaseAction {

	@Autowired
	private TabAreaBeanService tabAreaBeanService;
	
	
	 /**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 */
	@RequestMapping("queryListByAreaDeep")
	@ResponseBody
	public List<TabAreaBean> queryListByAreaDeep(Integer areaDeep){
		
		return tabAreaBeanService.queryListByTypeId(areaDeep);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 */
	@RequestMapping("queryListByParentId")
	@ResponseBody
	public List<TabAreaBean> queryListByParentId(Integer parent_id){
		
		return tabAreaBeanService.queryTabAreaBeanByParentId(parent_id);
	}
}
