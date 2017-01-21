package com.yiya.utils.json;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class JsonParser {
	/**
	 * 通过URL从服务器上下载下来，保存为字符串，以便待会进行JSON解析
	 * @param strUrl 
	 * @return
	 */
	public static String connServerForResult(String strUrl) {
		HttpGet httpRequest = new HttpGet(strUrl);
		String strResult = "";
		try {
			HttpClient httpClient = new DefaultHttpClient();

			HttpResponse httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				strResult = EntityUtils.toString(httpResponse.getEntity());
//				System.out.println(strResult);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}

//	/**
//	 * 普通Json数据解析  （这只是测试类，根据下载的JSON格式进行变化）
//	 * @param strResult 从URL中得到的字符串
//	 */
//	public static void parseJson(String strResult) {
//		try {
//			JSONObject jsonObj = new JSONObject(strResult)
//					.getJSONObject("singer");
//			int id = jsonObj.getInt("id");
//			String name = jsonObj.getString("name");
//			String gender = jsonObj.getString("gender");
//		} catch (JSONException e) {
//			System.out.println("Json parse error");
//			e.printStackTrace();
//		}
//	}
}
