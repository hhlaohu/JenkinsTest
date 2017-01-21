package com.yiya.bean;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

public class JsonResponse {
	public static final int SUCCESS = 0;
	public static final int FAIL = -1;
	
	private int code;
	private String msg;
    private HashMap<String,Object> resultText = new HashMap<String, Object>();

    public JsonResponse(){}
    
    public JsonResponse(int code,String msg){
    	this.code = code;
    	this.msg = msg;
    }
    
    public static JsonResponse success(){
    	return new JsonResponse(SUCCESS,"成功");
    }
    
    public static JsonResponse success(String msg){
    	return new JsonResponse(SUCCESS,msg);
    }
    
    public static JsonResponse fail(){
    	return new JsonResponse(FAIL,"失败");
    }
    
    public static JsonResponse fail(String msg){
    	return new JsonResponse(FAIL,msg);
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

	public HashMap<String, Object> getResultText() {
		return resultText;
	}

	public void setResultText(HashMap<String, Object> resultText) {
		this.resultText = resultText;
	}

    public JsonResponse put(String key,Object value){
        this.resultText.put(key,value);
        return this;
    }

    @Override
    public String toString(){
        return "{\"code\":\""+this.code+"\",\"msg\":\""+this.msg+"\",\"resultText\":\""+ JSONObject.toJSONString(resultText) +"\"}";
    }
}
