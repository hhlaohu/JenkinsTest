/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月21日
 * @description
 */
package com.yiya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.SysMenuBtn;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrinf2;
import com.yiya.bean.TabUsrinf2Example;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.TabUsrinf2Mapper;
import com.yiya.model.TabBorrowInfoModel;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.utils.CopyProperties;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;
import com.yiya.utils.Tools;
import com.yiya.utils.URLUtils;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年11月21日
 * @description
 */
@Service
public class TabUsrinf2Service implements InitializingBean, ApplicationContextAware {

	private final static Logger log = Logger.getLogger(TabUsrinf2Service.class);

	@Autowired
	private TabUsrinf2Mapper tabUsrinf2Mapper;

	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	private GatherValueService gatherValueService;

	private ScoringGatherFieldService scoringGatherFieldService;

	private DataService dataService;

	private ApplicationContext context;
	
	public void insert(TabUsrinf2 tabUsrinf2) {

		tabUsrinf2Mapper.insert(tabUsrinf2);
	};

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月7日
	 * @description 不更新 空的
	 * @param tabUsrinf2
	 */
	public void insertSelective(TabUsrinf2 tabUsrinf2) {

		tabUsrinf2Mapper.insertSelective(tabUsrinf2);
	};
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月4日
	 * @description
	 */
	public void update(TabUsrinf2 tabUsrinf2){
		
		tabUsrinf2Mapper.updateByPrimaryKey(tabUsrinf2);
	}
	

	public void updateByPrimaryKeySelective(TabUsrinf2 tabUsrinf2) {

		tabUsrinf2Mapper.updateByPrimaryKeySelective(tabUsrinf2);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 * @param model
	 * @return
	 */
	public Integer queryByCount(TabUsrinf2Model model) {
		return tabUsrinf2Mapper.queryByCount(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description
	 * @param model
	 * @return
	 */
	public List<TabUsrinf2Model> queryByList(TabUsrinf2Model model) {
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
		return tabUsrinf2Mapper.queryByList(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月29日
	 * @descriptionm 全表查询用户表
	 * @return
	 */
	public List<TabUsrinf2> queryAll() {
		TabUsrinf2Example example = new TabUsrinf2Example();
		List<TabUsrinf2> list = tabUsrinf2Mapper.selectByExample(example);
		return list;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月21日
	 * @description 查询链金所是否已认证该用户信息，认证信息是否一致
	 * @return
	 */
	public boolean identifiedUserInfoBySina(TabUsrinf2Model tabUsrinf2Model) {

		Map<String, String> args = new HashMap<String, String>();
		// 设置页面数据
		args.put("usrid", tabUsrinf2Model.getUsrid().toString());
		args.put("usrname", tabUsrinf2Model.getUsrname());
		args.put("id_card", tabUsrinf2Model.getId_card());
		args.put("_input_charset", "UTF-8");
		String url = URLUtils.get("identifiedUserInfoBySina");
		log.info("identifiedUserInfoBySina request param---" + args.toString());
		String return_data = HttpRequestUtil.sendPost(url, Tools.createLinkString(args, false));
		log.info("identifiedUserInfoBySina result-----" + return_data);
		if (StringUtil.isEmpty(return_data)) {
			log.error("identifiedUserInfoBySina 接口异常,usrId=" + tabUsrinf2Model.getUsrid());
			return false;
		}
		if (WebServiceConstant.CODE_SUCCESS == JSONObject.parseObject(return_data).getIntValue("code")) {
			log.info("identifiedUserInfoBySina 认证成功 usrId=" + tabUsrinf2Model.getUsrid());
			return true;
		} else {
			log.error("identifiedUserInfoBySina 校验失败,usrId=" + tabUsrinf2Model.getUsrid());
			return false;
		}
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月21日
	 * @description 根据usrinf_id查询 TabUsrinf2
	 * @return
	 */
	public TabUsrinf2 queryTabUsrinf2ByUsrinfId(Long usrinf_id) {

		if (usrinf_id == null) {
			return null;
		}
		TabUsrinf2Example example = new TabUsrinf2Example();
		example.createCriteria().andUsrinf_idEqualTo(usrinf_id);
		List<TabUsrinf2> list = tabUsrinf2Mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月21日
	 * @description 根据usrId查询 TabUsrinf2
	 * @return
	 */
	public TabUsrinf2 queryTabUsrinf2ByUsrId(Long usrId) {

		if (usrId == null) {
			return null;
		}
		TabUsrinf2Example example = new TabUsrinf2Example();
		example.createCriteria().andUsridEqualTo(usrId);
		List<TabUsrinf2> list = tabUsrinf2Mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月29日
	 * @description 克隆出TabUsrinf2
	 * @return
	 */
	public TabUsrinf2 copyTabusrinf2(TabUsrinf2 model) {
		TabUsrinf2 tabUsrinf = new TabUsrinf2();
		CopyProperties.copyPropertysWithoutNull(tabUsrinf, model);
		return tabUsrinf;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月21日
	 * @description 根据usrId查询 TabUsrinf2
	 * @return
	 */
	public TabUsrinf2Model queryTabUsrinf2ByIdCard(String id_card) {
		if (StringUtil.isEmpty(id_card)) {
			return null;
		}
		TabUsrinf2Model model = new TabUsrinf2Model();
		model.setId_card(id_card);
		List<TabUsrinf2Model> list = queryByList(model);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 
	 * @return
	 */
	public void dealJson(TabUsrinf2Model tabUsrinf2Model) {

		// 担保人json字符串转换
		List<TabBondsmaninf> tabBondsmaninfList = null;
		if (!StringUtil.isEmpty(tabUsrinf2Model.getBondsmaninf_list())) {
			tabBondsmaninfList = com.alibaba.fastjson.JSONObject.parseArray(tabUsrinf2Model.getBondsmaninf_list(),
					TabBondsmaninf.class);
		}
		// 订单照片转换
		List<TabUsrOrderPic> tabUsrOrderPicList = null;
		if (!StringUtil.isEmpty(tabUsrinf2Model.getUsr_order_pic_list())) {
			tabUsrOrderPicList = com.alibaba.fastjson.JSONObject.parseArray(tabUsrinf2Model.getUsr_order_pic_list(),
					TabUsrOrderPic.class);
		}
		// 其它类型照片转换
		List<TabUsrOtherPic> tabUsrOtherPicList = null;
		if (!StringUtil.isEmpty(tabUsrinf2Model.getOther_pic_list())) {
			tabUsrOrderPicList = com.alibaba.fastjson.JSONObject.parseArray(tabUsrinf2Model.getOther_pic_list(),
					TabUsrOrderPic.class);
		}

		tabUsrinf2Model.setTabBondsmaninfList(tabBondsmaninfList);
		tabUsrinf2Model.setTabUsrOrderPicList(tabUsrOrderPicList);
		tabUsrinf2Model.setTabUsrOtherPicList(tabUsrOtherPicList);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月22日
	 * @description 重载的方法
	 * @return
	 */
	public void dealJson(TabBorrowInfoModel tabBorrowInfoModel) {

		// 担保人json字符串转换
		List<TabOrderBondsmaninf> tabOrderBondsmaninfList = null;
		if (!StringUtil.isEmpty(tabBorrowInfoModel.getBondsmaninf_list())) {
			tabOrderBondsmaninfList = com.alibaba.fastjson.JSONObject.parseArray(tabBorrowInfoModel.getBondsmaninf_list(),
					TabOrderBondsmaninf.class);
		}
		// 订单照片转换
		List<TabUsrOrderPic> tabUsrOrderPicList = null;
		if (!StringUtil.isEmpty(tabBorrowInfoModel.getUsr_order_pic_list())) {
			tabUsrOrderPicList = com.alibaba.fastjson.JSONObject.parseArray(tabBorrowInfoModel.getUsr_order_pic_list(),
					TabUsrOrderPic.class);
		}
		tabBorrowInfoModel.setTabOrderBondsmaninfList(tabOrderBondsmaninfList);
		tabBorrowInfoModel.setTabUsrOrderPicList(tabUsrOrderPicList);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description 查询用户信息表关联订单表，根据id_card关联
	 * @param model
	 * @return
	 */
	public List<TabUsrinf2Model> selectUserWithOrderTable(TabUsrinf2Model model) {
		
		Integer rowCount = selectUserWithOrderTableCount(model);
		model.getPager().setRowCount(rowCount);
		return tabUsrinf2Mapper.selectUserWithOrderTable(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description 根据条件 查询用户信息表关联订单表 总数
	 * @param model
	 * @return
	 */
	public Integer selectUserWithOrderTableCount(TabUsrinf2Model model) {

		return tabUsrinf2Mapper.selectUserWithOrderTableCount(model);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 判断是否有对应按钮的处理权限
	 * @return
	 */
	public boolean isAuthority(HttpServletRequest request, TabUsrinf2Model model, String menuName, String btnName) {

		SysUser sysUser = SessionUtils.getUser(request);
		List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
		for (SysRoleRel sysRoleRel : SysRoleRelList) {
			Integer roleId = sysRoleRel.getRoleId();
			List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
			for (SysRoleRel buttonRels : buttonRelsList) {
				if (buttonRels.getObjId().equals(sysMenuBtnService.getBtnIdByMenuNameAndBtnName(menuName, btnName))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月5日
	 * @description 保存到采集数据表中去
	 */
	public void saveToGatherTable(Map<String, Object> map) {
		JSONArray array = new JSONArray();
		JSONObject obj = (JSONObject) JSONObject.toJSON(map);
		array.add(obj);
		dataService.writeGatherField(array, WebServiceConstant.SOURCE_USER);
		dataService.writeGatherValue(array, ((Long)map.get("usrid")).intValue(), WebServiceConstant.SOURCE_USER);
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月20日
	 * @description 保存到采集数据表中去  [重载方法]
	 */
	public void saveToGatherTable(TabUsrinf2 tabUsrinf2) {
		JSONArray array = new JSONArray();
		JSONObject obj = (JSONObject) JSONObject.toJSON(tabUsrinf2);
		array.add(obj);
		dataService.writeGatherField(array, WebServiceConstant.SOURCE_USER);
		dataService.writeGatherValue(array, tabUsrinf2.getUsrid().intValue(), WebServiceConstant.SOURCE_USER);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {

		sysRoleRelService = context.getBean("sysRoleRelService", SysRoleRelService.class);
		sysMenuBtnService = context.getBean("sysMenuBtnService", SysMenuBtnService.class);
		gatherValueService = context.getBean("gatherValueService", GatherValueService.class);
		scoringGatherFieldService = context.getBean("scoringGatherFieldService", ScoringGatherFieldService.class);
		dataService = context.getBean("dataService", DataService.class);
	}

}
