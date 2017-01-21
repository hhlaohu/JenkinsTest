package com.yiya.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMap{
	
	public ParameterMap() {
		this.map = new HashMap<String, Object>();
	}
	
	public ParameterMap(Map<String, Object> map){
		
		this.map = map;
		
	}

	private Map<String, Object> map;
	
	
	public String createLinkString(boolean encode) {
		List<String> keys = new ArrayList<String>(this.map.keySet());
		// 排序
		Collections.sort(keys);
		String prestr = "";
		String charset = this.map.get("_input_charset") == null ? "UTF-8" : this.map.get("_input_charset").toString();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = this.map.get(key);
			if (encode) {
				try {
					value = URLEncoder.encode(String.valueOf(value), charset);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public ParameterMap put(String key, Object value) {
		this.getMap().put(key, value);
		return this;
	}
	
	public Object get(String key) {
		return this.getMap().get(key);
	}
	
	public ParameterMap remove(String key) {
		this.getMap().remove(key);
		return this;
	}
	
	public ParameterMap clear() {
		this.getMap().clear();
		return this;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return this.getMap().toString();
	}
	
}
