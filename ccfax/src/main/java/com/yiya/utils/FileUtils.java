package com.yiya.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author frank_wang
 * @data 2016年10月26日
 * @description 文件相关的工具类
 */
public class FileUtils {

	/**
	 * @author frank_wang
	 * @data 2016年10月26日
	 * @description 文件转换为字节流，仅针对类路径
	 * @param path
	 *            不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。
	 *            其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
	 * @return
	 * @throws IOException
	 */
	public static byte[] getResourceByClassPath(String path, Class classz) throws IOException {

		InputStream s = classz.getResourceAsStream(path);

		ArrayList<byte[]> bufferList = new ArrayList<byte[]>();
		byte[] buffer = new byte[4096];
		int read = 0;
		int total = 0;
		while ((read = s.read(buffer)) > 0) {
			byte[] b = new byte[read];
			System.arraycopy(buffer, 0, b, 0, read);
			bufferList.add(b);
			total += read;
		}
		s.close();

		byte[] result = new byte[total];
		int pos = 0;
		for (int i = 0; i < bufferList.size(); i++) {
			byte[] b = bufferList.get(i);
			System.arraycopy(b, 0, result, pos, b.length);
			pos += b.length;
		}

		return result;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月10日
	 * @description 文件转换为字节数组，任何路径
	 * @param filePath
	 * @return
	 */
	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月10日
	 * @description 
	 * @param bfile
	 * @param filePath
	 * @param fileName
	 */
	public static void getFile(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + "\\" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月30日
	 * @description 将多个文件压缩成zip包
	 * @param fileList
	 * @param zipName
	 * @param tempFilePath
	 * @return
	 */
	public static ByteArrayOutputStream fileToZip(List<String> fileList, String zipName, String tempFilePath){
		
		byte[] buffer = new byte[1024];
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(tempFilePath +File.separator + zipName + ".zip"));
			List<File> filedata = new ArrayList<File>();
			for (int i = 0, len = fileList.size(); i < len; i++) {
				filedata.add(new File(fileList.get(i)));
			}
			for (int j = 0, len = filedata.size(); j < len; j++) {
				FileInputStream fis = new FileInputStream(filedata.get(j));
				out.putNextEntry(new ZipEntry(filedata.get(j).getName()));
				int dataLen;
				// 读入需要下载的文件的内容，打包到zip文件
				while ((dataLen = fis.read(buffer)) > 0) {
					out.write(buffer, 0, dataLen);
				}
				out.closeEntry();
				fis.close();
			}
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 读取压缩包
		File filezip = new File(tempFilePath + File.separator +zipName + ".zip");
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			FileInputStream inStream = new FileInputStream(filezip);
			BufferedInputStream bis = new BufferedInputStream(inStream);
			int c = bis.read();
			while (c != -1) {
				baos.write(c);
				c = bis.read();
			}
			bis.close();
			inStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return baos;
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月2日
	 * @description 删除文件夹
	 * @param sPath
	 * @return
	 */
	public static void deleteAllFilesOfDir(File path) {  
	    if (!path.exists())  
	        return;  
	    if (path.isFile()) {  
	        path.delete();  
	        return;  
	    }  
	    File[] files = path.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        deleteAllFilesOfDir(files[i]);  
	    }  
	    path.delete();  
	} 
}
