package com.yiya.utils;

import org.springframework.validation.BindingResult;

import com.yiya.bean.JsonResponse2;

/**
 * @author frank_wang [JackLikeYou2016@gmail.com]
 * @date 2017年1月11日
 * @description 参数校验工具类
 */
public class ParamCheckUtil{
	
	public  static JsonResponse2 checkParams(BindingResult result,String params) {
		
		if(StringUtil.isEmpty(params)){
			return null;
		}
		String[] paramArray = params.split(",");
		for(String param:paramArray){
			if(result.getFieldError(param) != null){
				return JsonResponse2.fail(result.getFieldError(param).getDefaultMessage());
			}
		}
		return null;
	}

}
