package com.yiya.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonUtil {
	
	//json解析
	public static Map<String, Object> getJsonData(String jsonStr) throws IOException{
		Map<String, Object> myMap = null;
		try {
			Gson gson = new GsonBuilder().create();	
			java.lang.reflect.Type type = new TypeToken<Map<String, Object>>(){}.getType();
			myMap = gson.fromJson(jsonStr, type);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return myMap;
	}
	
	public static String getJsonStr( Map<String, String> srcData) throws IOException{
		String resultJsonStr  = "";
		try {
			Gson gson = new GsonBuilder().create();		
			resultJsonStr = gson.toJson(srcData);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return resultJsonStr;
	}
}
