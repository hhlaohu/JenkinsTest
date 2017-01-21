
package com.yiya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrOrderPicExample;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.TabUsrOrderPicMapper;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月22日
 * @description 
 * 
 * 
 */
@Service
public class TabUsrOrderPicService {
	
	@Autowired
	private TabUsrOrderPicMapper tabUsrOrderPicMapper;
	
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月3日
	 * @description 插入单条数据
	 * @param tabUsrOrderPic
	 */
	public void insert(TabUsrOrderPic tabUsrOrderPic){
		
		tabUsrOrderPicMapper.insert(tabUsrOrderPic);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 由于数据量少直接采用循环处理List
	 */
	public void insertTabUsrOrderPicList(List<TabUsrOrderPic> list,Long usrOrderId,String orderSn){
		
        if(null == list || list.size() == 0){
        	return ;
        }
		for(TabUsrOrderPic pic:list){
			pic.setUsr_order_id(usrOrderId);
			pic.setOrder_sn(orderSn);
			tabUsrOrderPicMapper.insert(pic);
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 由于数据量少直接采用循环处理List
	 */
	public void updateTabUsrOrderPicList(List<TabUsrOrderPic> list,Long usrOrderId,String orderSn){
		
        if(null == list || list.size() == 0){
        	return ;
        }
        TabUsrOrderPicExample example = new TabUsrOrderPicExample();
        example.createCriteria().andOrder_snEqualTo(orderSn);
        tabUsrOrderPicMapper.deleteByExample(example);
		for(TabUsrOrderPic pic:list){
			pic.setUsr_order_id(usrOrderId);
			pic.setOrder_sn(orderSn);
			tabUsrOrderPicMapper.insert(pic);
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月30日
	 * @description 根据订单号查找用户照片列表
	 * @return
	 */
	public List<TabUsrOrderPic> queryPicByUserOrderId(Long usrOrderId){
		
		if(usrOrderId == null){
			return null;
		}
		TabUsrOrderPicExample example = new TabUsrOrderPicExample();
		example.createCriteria().andUsr_order_idEqualTo(usrOrderId);
		return tabUsrOrderPicMapper.selectByExample(example);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月30日
	 * @description 根据订单号查询未打码的照片
	 * @param order_sn
	 * @return
	 */
	public List<TabUsrOrderPic> queryPicByOrderSnNotMosaic(TabUsrOrderPic tabUsrOrderPic){
		
		TabUsrOrderPicExample example = new TabUsrOrderPicExample();
		example.createCriteria().andOrder_snEqualTo(tabUsrOrderPic.getOrder_sn()).andPic_typeNotEqualTo(new Byte(WebServiceConstant.PIC_TYPE_MOSAIC));
		return tabUsrOrderPicMapper.selectByExample(example);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月3日
	 * @description 根据订单号和订单标志查询图片
	 * @param tabUsrOrderPic
	 * @return
	 */
	public List<TabUsrOrderPic> queryPicByOrderSnAndPicType(TabUsrOrderPic tabUsrOrderPic){
		TabUsrOrderPicExample example = new TabUsrOrderPicExample();
		example.createCriteria().andPic_typeEqualTo(tabUsrOrderPic.getPic_type()).andOrder_snEqualTo(tabUsrOrderPic.getOrder_sn());
		return tabUsrOrderPicMapper.selectByExample(example);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月6日
	 * @description 获取图片路径
	 * @return
	 */
	public String getPicPath(List<TabUsrOrderPic> tabUsrOrderPicList){
		String picPath = "";
		for (TabUsrOrderPic pic : tabUsrOrderPicList) {
			picPath += (pic.getPic_addr() + "|");
		}
		picPath = picPath.substring(0, picPath.lastIndexOf("|"));
		return picPath;
	}

}
