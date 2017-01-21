package com.yiya.utils;

/**
 * @author wang_xiao_long
 * @data 2016年10月9日
 * @description
 */
public class ShellUtil {
   
	/**
	 * 执行CMD命令
	 * 
	 * @param cmd
	 */
	public static void exec(String cmd) {
		try {
			String[] command;
			if (System.getProperties().getProperty("os.name").indexOf("nux") != -1) {
				command = new String[] { "sh", "-c", cmd };
			} else {
				command = new String[] { "cmd", "/c", cmd };
			}
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
