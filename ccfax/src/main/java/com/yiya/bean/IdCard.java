/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月1日
 * @description
 */
package com.yiya.bean;

import java.util.Calendar;

import com.yiya.utils.StringUtil;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月1日
 * @description
 */
public class IdCard {
    /** 中国公民身份证号码最小长度。 */
    public  final static int CHINA_ID_MIN_LENGTH = 15;

    /** 中国公民身份证号码最大长度。 */
    public  final static int CHINA_ID_MAX_LENGTH = 18;
    /**
     * 根据身份编号获取年龄
     *
     * @param idCard
     *            身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
    	if(StringUtil.isEmpty(idCard)){
    		return 0;
    	}
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard
     *            身份编号
     * @return 生日(MM)
     */
    public static Short getMonthByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard
     *            身份编号
     * @return 生日(dd)
     */
    public static Short getDateByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(12, 14));
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M-男，F-女，N-未知)
     * @throws Exception 
     */
    public static String getGenderByIdCard(String idCard) throws Exception {
    	
    	if(StringUtil.isEmpty(idCard)){
    		return null;
    	}
        String sGender = "";
        if(idCard.length() == CHINA_ID_MIN_LENGTH){
        	idCard = getEighteenIDCard(idCard);
        }
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "0";//男
        } else {
            sGender = "1";//女
        }
        return sGender;
    }
    
    /** 
     * 根据15位的身份证号码获得18位身份证号码 
     * @param fifteenIDCard 15位的身份证号码 
     * @return 升级后的18位身份证号码 
     * @throws Exception 如果不是15位的身份证号码，则抛出异常 
     */  
    public static String getEighteenIDCard(String fifteenIDCard) throws Exception{  
        if(fifteenIDCard != null && fifteenIDCard.length() == 15){  
            StringBuilder sb = new StringBuilder();  
            sb.append(fifteenIDCard.substring(0, 6))  
              .append("19")  
              .append(fifteenIDCard.substring(6));  
            sb.append(getVerifyCode(sb.toString()));  
            return sb.toString();  
        } else {  
            throw new Exception("不是15位的身份证");  
        }  
    } 
    
    /** 
     * 获取校验码 
     * @param idCardNumber 不带校验位的身份证号码（17位） 
     * @return 校验码 
     * @throws Exception 如果身份证没有加上19，则抛出异常 
     */  
    public static char getVerifyCode(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() < 17) {  
            throw new Exception("不合法的身份证号码");  
        }  
        char[] Ai = idCardNumber.toCharArray();  
        int[] Wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};  
        char[] verifyCode = {'1','0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};  
        int S = 0;  
        int Y;  
        for(int i = 0; i < Wi.length; i++){  
            S += (Ai[i] - '0') * Wi[i];  
        }  
        Y = S % 11;  
        return verifyCode[Y];  
    }  
    
}