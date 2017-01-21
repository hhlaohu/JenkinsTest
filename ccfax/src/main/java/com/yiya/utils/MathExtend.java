package com.yiya.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
/**
 * 处理简单金额计算常用工具类（带金额单位）
 * @author Administrator
 *
 */
public class MathExtend {
	//默认除法运算精度
	private static final int DEFAULT_DIV_SCALE = 10;
	 
	/**
	* 提供精确的加法运算。
	* @param v1
	* @param v2
	* @return 两个参数的和
	*/
	public static double add(double v1, double v2)
	{
	      BigDecimal b1 = new BigDecimal(Double.toString(v1));
	      BigDecimal b2 = new BigDecimal(Double.toString(v2));
	      return b1.add(b2).doubleValue();
	}
	/**
	   * 提供精确的加法运算
	   * @param v1  
	   * @param v2
	   * @return 两个参数数学加和，以字符串格式返回
	   */
	public static String add(String v1, String v2)
	{
	      BigDecimal b1 = new BigDecimal(v1);
	    BigDecimal b2 = new BigDecimal(v2);
	      return b1.add(b2).toString();
	}
	 
	/**
	* 提供精确的减法运算。
	* @param v1
	* @param v2
	* @return 两个参数的差
	*/
	public static double subtract(double v1, double v2)
	{
	      BigDecimal b1 = new BigDecimal(Double.toString(v1));
	      BigDecimal b2 = new BigDecimal(Double.toString(v2));
	      return b1.subtract(b2).doubleValue();
	}
	 
	/**
	   * 提供精确的减法运算
	   * @param v1
	   * @param v2
	   * @return 两个参数数学差，以字符串格式返回
	   */
	public static String subtract(String v1, String v2)
	{
	      BigDecimal b1 = new BigDecimal(v1);
	      BigDecimal b2 = new BigDecimal(v2);
	      return b1.subtract(b2).toString();
	}
	 
	 
	/**
	* 提供精确的乘法运算。
	* @param v1
	* @param v2
	* @return 两个参数的积
	*/
	public static double multiply(double v1, double v2)
	{
	      BigDecimal b1 = new BigDecimal(Double.toString(v1));
	      BigDecimal b2 = new BigDecimal(Double.toString(v2));
	      return b1.multiply(b2).doubleValue();
	}
//	public static void main(String[] args) {
//		BigDecimal a =new BigDecimal("1.22");
//        System.out.println("construct with a String value: " + a);
//        BigDecimal b =new BigDecimal("2.22");
//        a=a.add(b);  //        a.add(b);  注意二者的不同
//        System.out.println("a plus b is : " + a);
//	}
	
	public static void main(String[] args) {
	    NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用 
	    NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用 
	    percent.setMaximumFractionDigits(3); //百分比小数点最多3位 
	    
	    BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
	    BigDecimal interestRate = new BigDecimal("0.008"); //利率   
	    BigDecimal interest = loanAmount.multiply(interestRate); //相乘
        System.out.println(interest);
	    System.out.println("贷款金额:\t" + currency.format(loanAmount)); 
	    System.out.println("利率:\t" + percent.format(interestRate)); 
	    System.out.println("利息:\t" + currency.format(interest)); 
	}
}
