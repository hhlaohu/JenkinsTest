package com.yiya.bean;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

public class JsonResponse2 {
	public static final int SUCCESS = 0;
	public static final int FAIL = -1;
	
	private int code;
	private String msg;
    private HashMap<String,Object> return_param = new HashMap<String, Object>();

    public JsonResponse2(){}
    
    public JsonResponse2(int code,String msg){
    	this.code = code;
    	this.msg = msg;
    }
    
    public static JsonResponse2 success(){
    	return new JsonResponse2(SUCCESS,"成功");
    }
    
    public static JsonResponse2 success(String msg){
    	return new JsonResponse2(SUCCESS,msg);
    }
    
    public static JsonResponse2 fail(){
    	return new JsonResponse2(FAIL,"失败");
    }
    
    public static JsonResponse2 fail(String msg){
    	return new JsonResponse2(FAIL,msg);
    }
    
    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, Object> getReturn_param() {
		return return_param;
	}

	public void setReturn_param(HashMap<String, Object> return_param) {
		this.return_param = return_param;
	}

    public JsonResponse2 put(String key,Object value){
        this.return_param.put(key,value);
        return this;
    }

    public JsonResponse2 remove(String key){
        this.return_param.remove(key);
        return this;
    }

    
    @Override
    public String toString(){
        return "{\"code\":\""+this.code+"\",\"msg\":\""+this.msg+"\",\"return_param\":\""+ JSONObject.toJSONString(return_param) +"\"}";
    }
}
