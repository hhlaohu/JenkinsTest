package com.yiya.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
  private static final String TAG = "MD5Utils";

  public static String getMD5Str(String strSrc) {
    MessageDigest md = null;
    String md5Str = null;

    byte[] bt = strSrc.getBytes();
    try {
      md = MessageDigest.getInstance("MD5");
      md.update(bt);
      md5Str = bytes2Hex(md.digest());
    } catch (NoSuchAlgorithmException e) {
//      LogUtil.e("MD5Utils", e, new String[] {e.getMessage()});
    	e.printStackTrace();
    }
    return md5Str;
  }

  public String get16MD5Str(String strSrc) {
    String md5Str32 = getMD5Str(strSrc);

    if (md5Str32 != null) {
      return md5Str32.substring(16);
    }

    return null;
  }
  
  public static String bytes2Hex(byte[] bts) {
	    StringBuilder des = new StringBuilder(bts.length);
	    String tmp = null;
	    for (int i = 0; i < bts.length; i++) {
	      tmp = Integer.toHexString(bts[i] & 0xFF);
	      if (tmp.length() == 1) {
	        des.append("0");
	      }
	      des.append(tmp);
	    }
	    return des.toString();
	  }
  
  public final static String MD5(String s) {
      char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

      try {
          byte[] btInput = s.getBytes("UTF-8");
          // 获得MD5摘要算法的 MessageDigest 对象
          MessageDigest mdInst = MessageDigest.getInstance("MD5");
          // 使用指定的字节更新摘要
          mdInst.update(btInput);
          // 获得密文
          byte[] md = mdInst.digest();
          // 把密文转换成十六进制的字符串形式
          int j = md.length;
          char str[] = new char[j * 2];
          int k = 0;
          for (int i = 0; i < j; i++) {
              byte byte0 = md[i];
              str[k++] = hexDigits[byte0 >>> 4 & 0xf];
              str[k++] = hexDigits[byte0 & 0xf];
          }
          return new String(str);
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
}
