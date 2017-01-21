package com.yiya.bean.shuzun;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yiya.utils.HttpUtil;

/**
 * 
********************************************************** 
* @作者: Administrator
* @日期: 2016年2月18日
* @版权: 2016 www.shuzun.net Inc. All rights reserved.
* @描述: 
**********************************************************
 */
public class CommonUtil {
    /**
     * 签名
     */
    private final static String SIGN = "sign";

    private final static char[] mChars = "0123456789ABCDEF".toCharArray();  
    
    public final static String MD5(String s) {
        String result = "";
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] strTemp = s.getBytes("utf-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public final static String convertParams(Map<String,String[]> map, String privateKey){
        
        List<String> paramslist = new ArrayList<String>();
        for (Entry<String, String[]> entry : map.entrySet()) {
            if (!SIGN.equals(entry.getKey())) {
                paramslist.add(entry.getKey() + entry.getValue()[0]);
            }
        }
        
        Collections.sort(paramslist);
        
        StringBuffer sf = new StringBuffer();
        for (String string : paramslist) {
            sf.append(string);
        }
        
        sf.append(privateKey);
        
        System.out.println(sf.toString());
        return MD5(sf.toString());
    }
    
    public final static String convertParamsUTF8(Map<String,String[]> map, String privateKey){
        
        List<String> paramslist = new ArrayList<String>();
        for (Entry<String, String[]> entry : map.entrySet()) {
            if (!SIGN.equals(entry.getKey())) {
                paramslist.add(entry.getKey() + HttpUtil.convertUrlValue(entry.getValue()[0]));
            }
        }
        
        Collections.sort(paramslist);
        
        StringBuffer sf = new StringBuffer();
        for (String string : paramslist) {
            sf.append(string);
        }
        
        sf.append(privateKey);
        
        System.out.println(sf.toString());
        return MD5(sf.toString());
    }
    
    public final static String getTransIdo(){
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHmmssS");
        
        return df.format(d.getTime())+Math.round(Math.random()*899+100);
    }
    

    /**  
     * 字符串转换成十六进制字符串 
     * @param str String 待转换的ASCII字符串 
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B] 
     */    
    public static String str2HexStr(String str){    
        StringBuilder sb = new StringBuilder();  
        byte[] bs = str.getBytes();    
          
        for (int i = 0; i < bs.length; i++){    
            sb.append(mChars[(bs[i] & 0xFF) >> 4]);    
            sb.append(mChars[bs[i] & 0x0F]);  
        }    
        return sb.toString().trim();    
    }
    
    public static void main(String arg[]) {
    } 
    
    public static boolean isChineseChar(String str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m=p.matcher(str);
        if(m.find()){
            temp =  true;
        }
        return temp;
    }
}
