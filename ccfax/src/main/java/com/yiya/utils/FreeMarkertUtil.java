package com.yiya.utils;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 封装freemarker用于创建模板和加载模板
 * @author Administrator
 *
 */
public class FreeMarkertUtil 
{
	/* 创建配置 */  
	private static  Configuration config = new Configuration();
	
	
	/**
	 * 根据模板生成html
	 * @param templateName
	 * @param root
	 * @param out
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void processTemplate(String templateName, Map<?,?> paramMap, Writer out) throws IOException, TemplateException
	{
		try
		{
			//获得模板
			Template template=config.getTemplate(templateName,"utf-8");
			
			//生成文件（这里是我们是生成html）
			template.process(paramMap, out);   
			
		    out.flush();   
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (TemplateException e)
		{
			e.printStackTrace();
		}
		finally
		{
		   try 
			 {
				out.close();
				out=null;
			 } 
			 catch (IOException e)
			 {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 初始化模板配置
	 * @param servletContext javax.servlet.ServletContext
	 * @param templateDir 模板位置
	 * @throws IOException 
	 */
	public static void initConfig(String basePath) throws IOException
	{
		 	config.setLocale(Locale.CHINA);
		    config.setDefaultEncoding("utf-8");
		    config.setEncoding(Locale.CHINA, "utf-8");
		    /* 指定模板存放的路径 */ 
		    config.setDirectoryForTemplateLoading(new File(basePath));  
		    config.setObjectWrapper(new DefaultObjectWrapper());
	}

}
