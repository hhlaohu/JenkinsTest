package com.yiya.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yiya.constant.WebServiceConstant;
import com.yiya.service.SysUserService;
import com.yiya.utils.DesUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.HttpUtil;

@Service
public class SendMessage {

	private final static Logger log = Logger.getLogger(SysUserService.class);

	@Value("${ShortMessageInterfackClient}")
	private  String shortMessageInterfackClient;

	@Value("${ShortMessageInterfackGroup}")
	private  String shortMessageInterfackGroup;

	@Value("${platform}")
	private String platform;

	@Value("${key}")
	private String key;
	
	@Value("${get_operate_tel}")
	private String get_operate_tel;

	/**
	 * json URl接口调用
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	public static String sendPostRequest(String url) {
		StringBuffer stringBuffer = new StringBuffer("");
		try {
			URL postUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringBuffer.toString();
	}

	public  String sendSmsToClient(String template_id, String phone_number, String param) {
		//
		StringBuilder sb = null;
		try {
			// new Random()
			String data = platform + new Random().nextInt(9) + phone_number + "-" + template_id;
			String sign = null;
			try {
				sign = URLEncoder.encode(DesUtil.encode(key, data), "UTF-8");
			} catch (Exception e) {
				sign = null;
			}
			param = URLEncoder.encode(param, "UTF-8");
			sb = new StringBuilder();
			sb.append(shortMessageInterfackClient + "?");
			sb.append("template_id=").append(template_id);
			sb.append("&template_value=").append(param);
			sb.append("&platform=").append(platform);
			sb.append("&sign=").append(sign);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendPostRequest(sb.toString());
	}

	/**
	 * @author frank_wang
	 * @data 2016年10月13日
	 * @description 群发短信
	 * @param content
	 * @param phone_numbers
	 * @return
	 */
	public  String sendGroupSmsToClient(String content, String phone_numbers,String chanels) {

		String data = platform + new Random().nextInt(9);
		log.info("data:"+data);
		String url = shortMessageInterfackGroup;

		String sign = null;
		try {
			sign = URLEncoder.encode(DesUtil.encode(key, data), "UTF-8");
		} catch (Exception e) {
			sign = null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("content=").append(content);
		sb.append("&platform=").append(platform);
		sb.append("&sign=").append(sign);
		sb.append("&phone_numbers=").append(phone_numbers);
		if(!StringUtils.isEmpty(chanels)){
			sb.append("&channel=").append(chanels);
		}
		log.info("sendGroupSmsToClient param----" + sb.toString()+"--url--"+shortMessageInterfackGroup);
		String result = sendPost(url, sb.toString());
		if (StringUtils.isNotEmpty(result))
         {
               com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(result);
               if(object.getIntValue("code")!=0){
            	   log.info("发送短信失败，原因"+object.getString("resultText"));
               }else{
            	   log.info("发送短信成功");
               }
         }
		return  result;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			log.info(url+"--result---"+result);
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			// 设置 HttpURLConnection的字符编码
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月1日
	 * @description 给短信内容插入电话号码
	 * @param content
	 * @param mobilePhone
	 * @return
	 */
	public String insertContentPhoneNumber(String content,String mobilePhone){
		
		StringBuffer buffer = new StringBuffer(content);
		buffer.insert(3, mobilePhone);
		return buffer.toString();
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description 获取运营人员电话号码
	 * @return
	 */
	public String getMarketingManagerPhones(){
		
		String result = HttpRequestUtil.sendGet(get_operate_tel, "");
		if(StringUtils.isEmpty(result)){
			log.error("获取信金链运营人员电话号码失败");
			return null;
		}
		JSONObject jsonObj = JSONObject.parseObject(result);
		if(WebServiceConstant.CODE_FAIL == jsonObj.getIntValue("code")){
			log.error("获取信金链运营人员电话号码失败,原因："+jsonObj.getString("msg"));
			return null;
		}
		log.info("运营人员电话号码："+jsonObj.getString("tel_list"));
		return jsonObj.getString("tel_list");
	}
	
	
	
}
