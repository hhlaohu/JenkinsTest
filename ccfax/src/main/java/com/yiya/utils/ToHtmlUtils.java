package com.yiya.utils;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;

import freemarker.template.TemplateException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 生成html临时合同
 * Title: ToHtmlUtils
 * Description: 
 * @author lidan
 * @date 2017年1月16日 下午3:14:57
 */
public class ToHtmlUtils 
{
	
	private final static Logger log = Logger.getLogger(ToHtmlUtils.class);
	private final String TEMPLATE_NAME = "TSFQG";
	
	public void viewContract(Map<String, Object> paramMap,
			HttpServletRequest request) throws IOException, TemplateException 
	{
			log.info("ToHtmlUtils viewContract() method enter ~~~~");
			
			//本地模板路径
			String basePath = request.getSession().getServletContext().getRealPath("/files");
			
			
			//合同模板名称
			String template = TEMPLATE_NAME;
			
	        log.info("合同模板是~~~~" + template);
	        
            //公共配置信息
            FreeMarkertUtil.initConfig(basePath);
            
            
        	String upload_path = URLUtils.get("upload_constract");//服务器地址(生成的html放服务器)
        	String constractName = paramMap.get("fileName").toString();//每个生成的合同保持唯一
        	
            //要输出的html
        	Writer writer  = new OutputStreamWriter(new FileOutputStream(upload_path +"/" + constractName),"UTF-8");  
        	 
    		//根据参数填充html模板，并输出
    		FreeMarkertUtil.processTemplate(template + ".html", paramMap, writer);
    		
            log.info("ToHtmlUtils viewContract() method exist ~~~~");
	}
	
	
	
    /**
     * 给身份证及电话号码，打马赛克
     * @param str
     * @return
     */
    public static String strReplaceMethod(String str)
    {
        String result = "";
    	if (StringUtils.isBlank(str))
    	{
    		return result;
    	}	
        // {}里面的数字可以用来指定前后缀的长度  
        String regex = "(\\w{3})(.*)(\\w{3})";  //前3后3
        StringBuilder sb = new StringBuilder();
        Matcher m = Pattern.compile(regex).matcher(str);  
        //截取前后之后中间替换字符不能为空，则长度要大于6
        if (m.find() && str.length() > 6) 
        {  
            String rep = m.group(2);  
            for (int i = 0; i < rep.length(); i++)
            {  
                sb.append("*");  
            }  
            result = str.replaceAll(rep, sb.toString());
        } 
        else
        {
        	//含中文字符串时
        	System.out.println("else");
        	int len = str.substring(1).length();//截取第一位之后所有的字符
        	if ( len == 0)
        	{
        		//只有一个字符
        		result = str.replace(str.substring(0),"*");
        	}
        	else
        	{
                for (int i = 0; i < len; i++)
                {  
                    sb.append("*");  
                } 
                result = str.replace(str.substring(1),sb.toString());
        	}	
        }	
        System.out.println("result:" +result);
        return  result;
    }
}
