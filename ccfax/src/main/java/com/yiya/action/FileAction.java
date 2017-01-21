package com.yiya.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.utils.DateUtil;
import com.yiya.utils.FileUtils;

/**
 * @author frank_wang [JackLikeYou2016@gmail.com]
 * @date 2017年1月2日
 * @description
 */
@Controller
@RequestMapping("/file") 
public class FileAction extends BaseAction{
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @throws IOException 
	 * @date 2017年1月2日
	 * @description
	 */
	@RequestMapping("downloadFile")
	public void downloadFiles(String urlString,HttpServletRequest request,HttpServletResponse response) throws IOException{
	   
		String[] file_picStr = urlString.split(",");
		// 线程池
		ExecutorService pool = null;
		HttpURLConnection connection = null;
		// 图片文件本地临时存储位置
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String tempFilePath = rootPath+System.currentTimeMillis();
		// 生成的压缩包名称
		String zipName = "fileData";
		List<String> fileList = new ArrayList<String>();

		// 循环下载
		try {
			for (int i = 0; i < file_picStr.length; i++) {
				pool = Executors.newCachedThreadPool();
				final String pic_url = file_picStr[i];
				String fileName = pic_url.substring(pic_url.lastIndexOf('/') + 1);
				System.out.println("正在下载第" + (i + 1) + "个文件，地址：" + pic_url);
				Future<HttpURLConnection> future = pool.submit(new Callable<HttpURLConnection>() {
					@Override
					public HttpURLConnection call() throws Exception {
						HttpURLConnection connection = null;
						connection = (HttpURLConnection) new URL(pic_url).openConnection();
						connection.setConnectTimeout(10000);// 连接pic_url时时间
						connection.setReadTimeout(10000);// 读取超时时间
						connection.setDoInput(true);
						connection.setDoOutput(true);
						connection.setRequestMethod("GET");
						// 断点续连,每次要算出range的范围,请参考Http 1.1协议
						// connection.setRequestProperty("Range", "bytes=0");
						connection.connect();
						return connection;
					}
				});
				connection = future.get();
				System.out.println("下载完成.响应码:" + connection.getResponseCode());
				URL fileurl = new URL(pic_url);
				// 写入文件
				if (connection.getResponseCode() == 200) {
					File destfileFile = writeFile(new BufferedInputStream(connection.getInputStream()),
							URLDecoder.decode(fileName, "UTF-8"), tempFilePath,fileurl, response);

					fileList.add(tempFilePath + "/" + destfileFile.getName());
				} else {
					if (null != connection)
						connection.disconnect();
					if (null != pool)
						pool.shutdown();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != connection)
				connection.disconnect();
			if (null != pool)
				pool.shutdown();
		}
		try {
			// 返回流
			ByteArrayOutputStream outputStream = com.yiya.utils.FileUtils.fileToZip(fileList, zipName, tempFilePath);
			// 页面输入压缩包流
			byte[] buffer = outputStream.toByteArray();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(DateUtil.getStringOfNowDate("yyyyMMddHHmm")+"--图片资料.zip", "UTF-8"));
			response.addHeader("Content-Length", "" + outputStream.size());
			response.setContentType("application/octet-stream");
			BufferedOutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
			FileUtils.deleteAllFilesOfDir(new File(tempFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 写入文件
	 * 
	 * @param inputStream
	 * @throws IOException 
	 */
	private File writeFile(BufferedInputStream bufferedInputStream, String fileName,String tempPath, URL fileurl,
			HttpServletResponse response) throws IOException {

		File destfileFile = new File(tempPath + File.separator + fileName);
		destfileFile.getParentFile().mkdirs();
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(destfileFile);
			byte[] b = new byte[1024];
			int len = 0;
			// 写入文件
			System.out.println("开始写入本地文件.");
			while ((len = bufferedInputStream.read(b, 0, b.length)) != -1) {
				fileOutputStream.write(b, 0, len);
			}
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition",
					"attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileurl.openConnection().getContentLength()));
			System.out.println("写入本地文件完成.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fileOutputStream) {
					fileOutputStream.flush();
					fileOutputStream.close();
				}
				if (null != bufferedInputStream)
					bufferedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return destfileFile;
	}
}
