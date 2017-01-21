package com.yiya.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年2月18日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: http通信的工具类
**********************************************************
 */
public class HttpUtil {
    
    /**
     * 使用Get方式获取数据
     * 
     * @param url URL包括参数，http://HOST/XX?XX=XX&XXX=XXX
     * @return
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e.getMessage());
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                System.out.println("关闭http流出现异常！" + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return result;
    }
    

    /**
     * 把url 默认 iso8859-1的编码 重新编码UTF-8返回
     * 
     * @param str
     *            url
     * @return 转码后的url
     */
    public static final String convertUrlValue(String str) {
        try {
            return new String(str.getBytes("iso8859-1"), "UTF-8");
        } catch (Exception e) {
            System.out.println("字符转码出现异常！" + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }
}
