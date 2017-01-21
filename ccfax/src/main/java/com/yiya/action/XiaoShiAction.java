package com.yiya.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiya.bean.JsonResponse;
import com.yiya.bean.SysUser;
import com.yiya.bean.XiaoShiConfig;
import com.yiya.constant.WebServiceConstant;
import com.yiya.service.XiaoShiConfigService;
import com.yiya.utils.SessionUtils;

/**
 * @author wang_xiao_long
 * @data 2016年10月12日
 * @description
 */
@Controller
@RequestMapping("xiaoshi")
public class XiaoShiAction extends BaseAction{
	
	@Autowired
	private XiaoShiConfigService xiaoShiConfigService;

	@RequestMapping("/config")
	public ModelAndView config(HttpServletRequest request){
		Map<String, Object> context = getRootMap();
		SysUser sysUser = SessionUtils.getUser(request);
		context.put("user", sysUser);
		return forword("xiaoshi/config", context);
	}
	
	@RequestMapping("/configStatus")
	@ResponseBody
	public JsonResponse configStatus(){
		
		List<XiaoShiConfig> list = xiaoShiConfigService.queryByCondition(null);
		boolean check_live_status = false;
		boolean id_name_face_status = false;
		Integer score_standard = 0;
		for(XiaoShiConfig config:list){
			if(WebServiceConstant.PRODUCT_TYPE_CHECK_ALIVE == config.getProduct_type()){
				if(config.isConfig_status()){
					check_live_status = true;
				}
			}
			if(WebServiceConstant.PRODUCT_TYPE_ID_CARD_CHECK == config.getProduct_type()){
				if(config.isConfig_status()){
					id_name_face_status = true;
				}
				score_standard = config.getScore_standard();
			}
		}
		return JsonResponse.success()
				.put("check_live_status", check_live_status)
				.put("id_name_face_status", id_name_face_status)
				.put("score_standard", score_standard);
	}
	
	@RequestMapping("/setConfig")
	@ResponseBody
	public JsonResponse setConfig(boolean id_name_face,boolean check_alive,Integer score_standard){
		
		XiaoShiConfig checkAliveConfig = new XiaoShiConfig();
		checkAliveConfig.setProduct_type(WebServiceConstant.PRODUCT_TYPE_CHECK_ALIVE);
		checkAliveConfig.setConfig_status(check_alive);

		XiaoShiConfig idNameFaceConfig = new XiaoShiConfig();
		idNameFaceConfig.setProduct_type(WebServiceConstant.PRODUCT_TYPE_ID_CARD_CHECK);
		idNameFaceConfig.setConfig_status(id_name_face);
		idNameFaceConfig.setScore_standard(score_standard);
		
		xiaoShiConfigService.update(checkAliveConfig);
		xiaoShiConfigService.update(idNameFaceConfig);
		
		return JsonResponse.success();
	}
	
	
}
