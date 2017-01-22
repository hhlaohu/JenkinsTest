package com.yiya.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.AffiliateRule;
import com.yiya.bean.AntiFraudReportList;
import com.yiya.bean.BlacklistReportList;
import com.yiya.bean.ScoreBean;
import com.yiya.bean.ScoreReport;
import com.yiya.bean.ScoreReportList;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabBondsmaninf;
import com.yiya.bean.TabChangeLog;
import com.yiya.bean.TabOrderBondsmaninf;
import com.yiya.bean.TabUsrComplementPic;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrOrderPic;
import com.yiya.bean.TabUsrOtherPic;
import com.yiya.bean.TabUsrinf;
import com.yiya.bean.TabUsrinf2;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.TabBondsmaninfModel;
import com.yiya.model.TabBorrowInfoModel;
import com.yiya.model.TabChangeLogModel;
import com.yiya.model.TabUsrComplementPicModel;
import com.yiya.model.TabUsrOtherPicModel;
import com.yiya.model.TabUsrinf2Model;
import com.yiya.service.ScoreService;
import com.yiya.service.TabAreaBeanService;
import com.yiya.service.TabBondsmaninfService;
import com.yiya.service.TabChangeLogService;
import com.yiya.service.TabOrderBondsmaninfService;
import com.yiya.service.TabUsrComplementPicService;
import com.yiya.service.TabUsrOrderPicService;
import com.yiya.service.TabUsrOrderService;
import com.yiya.service.TabUsrOtherPicService;
import com.yiya.service.TabUsrinf2Service;
import com.yiya.utils.CopyProperties;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.URLUtils;

@Controller
@RequestMapping("/userManager")
public class UserManagerAction extends BaseAction {

	private final static Logger log = Logger.getLogger(UserManagerAction.class);
	
	@Autowired(required = false)
	private TabUsrComplementPicService<TabUsrComplementPic> tabUsrComplementPicService;

	@Autowired(required = false)
	private TabChangeLogService<TabChangeLog> tabChangeLogService;
	
	@Autowired(required=false)
	private  TabUsrOtherPicService<TabUsrOtherPic> tabUsrOtherPicService; 
	
	@Autowired(required=false)
	private  TabBondsmaninfService<TabBondsmaninf> tabBondsmaninfService; 
	
	@Autowired
	private TabUsrOrderService tabUsrOrderService;
	
	@Autowired
	private TabUsrinf2Service tabUsrinf2Service;
	
	@Autowired
	private TabAreaBeanService tabAreaBeanService;
	
	@Autowired
	private ScoreService<ScoreBean> scoreService;
	
	@Autowired
	private TabOrderBondsmaninfService tabOrderBondsmaninfService;
	
	@Autowired
	private TabUsrOrderPicService tabUsrOrderPicService;

	@Value("${accessReportTokenUrl}")
	private String accessReportTokenUrl;

	@Value("${accessReportDataUrl}")
	private String accessReportDataUrl;

	@Value("${accessReportDataByTokenUrl}")
	private String accessReportDataByTokenUrl;

	@Value("${mobileRawDataUrl}")
	private String mobileRawDataUrl;

	@Value("${mobileRawDataUrlByTokenUrl}")
	private String mobileRawDataUrlByTokenUrl;

	@Value("${eBusinessRawDataUrl}")
	private String eBusinessRawDataUrl;

	@Value("${eBusinessRawDataByTokenUrl}")
	private String eBusinessRawDataByTokenUrl;

	@Value("${picServerIp}")
	private String picServerIp;
	
	@Value("${findStoreTypeDescByStoreTypeId}")
	private String findStoreTypeDescByStoreTypeIdUrl;
	

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(TabUsrinf model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();

		return forword("limitManager/userManager", context);
	}

	@RequestMapping("/info_handle")
	public ModelAndView info_handle(TabUsrinf model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		context.put("usrinf_id", model.getUsrinf_id());
		return forword("limitManager/info_handle", context);
	}
	
	@RequestMapping("/printReport")
	public ModelAndView printReport(Integer report_id, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		
		// 客户基本信息，还款能力总结，结论。。。
		ScoreReport scoreReport = scoreService.findScoreReportByReportId(report_id);
		// 联系人信息
		List<ScoringReportBondsmaninf> scoringReportBondsmaninfs = scoreService.findScoringReportBondsmaninfByReportId(report_id);
		// 平台黑名单查询
		List<BlacklistReportList> blacklistReportLists = scoreService.findBlacklistReportListByReportId(report_id);
		// 第三方反欺诈信息查询
		List<AntiFraudReportList> antiFraudReportLists = scoreService.findAntiFraudReportListByReportId(report_id);
		// 信用评分部分
		List<ScoreReportList> scoreReportLists1 = scoreService.findScoreReportListByReportId(report_id);
		// 客户还款实力
		List<ScoreReportList> scoreReportLists2 = scoreService.findScoreReportListByRuleTypeId(1);
		// 手工补充查询部分
		List<AffiliateRule> affiliateRules = scoreService.findAffiliateRuleByReportId(report_id);
		
		context.put("scoreReport", scoreReport);
		context.put("scoringReportBondsmaninfs", scoringReportBondsmaninfs);
		context.put("blacklistReportLists", blacklistReportLists);
		context.put("antiFraudReportLists", antiFraudReportLists);
		context.put("scoreReportLists1", scoreReportLists1);
		context.put("scoreReportLists2", scoreReportLists2);
		context.put("affiliateRules", affiliateRules);
		return forword("limitManager/print", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(TabUsrinf2Model model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		
		//设置资料处理权限
		Boolean info_handle_auth = tabUsrinf2Service.isAuthority(request, model,WebServiceConstant.MENU_NAME_USER_MANAGER,WebServiceConstant.BTN_NAME_INFO_HANDLE);
		
		//查询数据
		List<TabUsrinf2Model> dataList = tabUsrinf2Service.queryByList(model);
		
		//处理数据
		for (TabUsrinf2Model tabUsrinf2Model : dataList) {
			tabUsrinf2Model.setInfo_handle_auth(info_handle_auth);
			//TODO 原逻辑还有设置打码标志
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/updateLimitStatus")
	public void updateLimitStatus(TabUsrinf2 tu, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(tu.getUsrinf_id());
		if (tabUsrinf == null) {
			jsonMap.put("msg", "1");
		}
		if (tabUsrinf.getIs_loan() == 0) {// 启用额度
			tabUsrinf.setIs_loan(new Byte("1"));
			tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
			jsonMap.put("msg", "2");
		} else {// 禁用额度
			tabUsrinf.setIs_loan(new Byte("0"));
			tabUsrinf.setFreeze_remark(tu.getFreeze_remark());
			tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);
			jsonMap.put("msg", "3");
		}
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 用户管理---资料处理，下载图片到本地
	 * 
	 * @param urlString
	 * @param filename
	 * @param savePath
	 * @throws Exception
	 */
	@RequestMapping("/download_pic")
	public void download_pic(String urlString, String pic_type,HttpServletResponse response) throws Exception {

		String[] file_picStr = urlString.split(",");
		// 线程池
		ExecutorService pool = null;
		HttpURLConnection connection = null;
		String pic_type_name = ""; //区分房产和装修图片压缩包名
		// 图片文件和压缩包存储的位置
		String upload_pic_dir = "";
		if(null!=pic_type&&pic_type.equals("1")){
			upload_pic_dir = URLUtils.get("upload_house_pic");
			pic_type_name = "房产证";
		}else if(null!=pic_type&&pic_type.equals("2")) {
			upload_pic_dir = URLUtils.get("upload_decoration_pic");
			pic_type_name = "装修";
		}else{
			upload_pic_dir = URLUtils.get("upload_pic");
		}
		String tempFilePath = upload_pic_dir;
		// 生成的压缩包名称
		String zipName = "fileData";
		List<String> fileList = new ArrayList<String>();

		// 循环下载
		try {
			for (int i = 0; i < file_picStr.length; i++) {
				pool = Executors.newCachedThreadPool();
				String pic_url = file_picStr[i];
				if(pic_url.indexOf("http://")==-1){
					String localUrl = URLUtils.get("localUrl");
					pic_url =  localUrl.substring(0,localUrl.lastIndexOf("/"))+pic_url;
				}
				final String url = pic_url;
				String fileName = url.substring(url.lastIndexOf('/') + 1);
				System.out.println("正在下载第" + (i + 1) + "个文件，地址：" + url);
				Future<HttpURLConnection> future = pool.submit(new Callable<HttpURLConnection>() {
					@Override
					public HttpURLConnection call() throws Exception {
						HttpURLConnection connection = null;
						connection = (HttpURLConnection) new URL(url).openConnection();
						connection.setConnectTimeout(10000);// 连接超时时间
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
				BufferedInputStream dis = null;
				BufferedOutputStream fos = null;
				URL fileurl = new URL(url);
				// 写入文件
				if (connection.getResponseCode() == 200) {
					File destfileFile = writeFile(new BufferedInputStream(connection.getInputStream()),
							URLDecoder.decode(fileName, "UTF-8"), fileurl,pic_type, response);

					fileList.add(tempFilePath + "/" + destfileFile.getName());
					// fileList.add("http://192.168.0.70:8080/tsfkxt/upload/spgl.png");
					// fileList.add("http://192.168.0.70:8080/tsfkxt/upload/glbj.png");
				} else {
					log.error("获取图片地址失败！");
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
			ByteArrayOutputStream outputStream = fileToZip(fileList, zipName, tempFilePath);
			// 页面输入压缩包流
			byte[] buffer = outputStream.toByteArray();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(pic_type_name+"图片资料.zip", "UTF-8"));
			response.addHeader("Content-Length", "" + outputStream.size());
			response.setContentType("application/octet-stream");
			BufferedOutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入文件
	 * 
	 * @param inputStream
	 */
	public File writeFile(BufferedInputStream bufferedInputStream, String fileName, URL fileurl,String pic_type,
			HttpServletResponse response) {

		// 创建本地文件存储路径
		String upload_pic_dir ="";
		if(null!=pic_type&&pic_type.equals("1")){
			upload_pic_dir = URLUtils.get("upload_house_pic");
		}else if(null!=pic_type&&pic_type.equals("2")) {
			upload_pic_dir = URLUtils.get("upload_decoration_pic");
		}else{
			upload_pic_dir = URLUtils.get("upload_pic");
		}
		File destfileFile = new File(upload_pic_dir + "/" + fileName);
		if (destfileFile.exists()) {
			destfileFile.delete();
		}
		if (!destfileFile.getParentFile().exists()) {
			destfileFile.getParentFile().mkdir();
		}
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

	/**
	 * 将多个文件压缩成zip包
	 * 
	 * @param fileList
	 * @param zipName
	 * @param tempFilePath
	 * @return
	 */
	public ByteArrayOutputStream fileToZip(List<String> fileList, String zipName, String tempFilePath) {
		byte[] buffer = new byte[1024];
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(tempFilePath + zipName + ".zip"));
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
		File filezip = new File(tempFilePath + zipName + ".zip");
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
	 * @date 2016年11月23日
	 * @description 获取授信资料
	 * @param bean
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/userFindUsrInfo_2") 
	public void  userFindUsrInfo_2(TabUsrinf2Model tabUsrinf2Model,HttpServletResponse response,HttpServletRequest request) throws Exception{
		
		TabUsrinf2 tabUsrinf2 = null;
		if(tabUsrinf2Model.getUsrid() != null){
			tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrId(tabUsrinf2Model.getUsrid());
		}else if(tabUsrinf2Model.getUsrinf_id() != null){
			tabUsrinf2 = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(tabUsrinf2Model.getUsrinf_id());
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if(null != tabUsrinf2){
			CopyProperties.copyPropertysWithoutNull(tabUsrinf2Model, tabUsrinf2);
			//处理省市县数据
			tabAreaBeanService.dealTabArea(tabUsrinf2Model);
			//查询子表联系人信息
			TabBondsmaninfModel model = new TabBondsmaninfModel();
			model.setUsrinf_id(tabUsrinf2.getUsrinf_id().intValue());
			List<TabBondsmaninf> tabBondsmaninf_List = tabBondsmaninfService.queryByList(model);
			if(tabBondsmaninf_List.size()>0){
				jsonMap.put("tabBondsmaninf_List", tabBondsmaninf_List);
			}else{
				jsonMap.put(MSG, "无直系亲属信息！");
			}
			//处理身份证照片地址
			String id_card_front_pic = tabUsrinf2Model.getId_card_front_pic();
			String entire_id_card_front_pic_path = picServerIp + "/" + id_card_front_pic;
			tabUsrinf2Model.setId_card_front_pic(entire_id_card_front_pic_path);
			
			String id_card_reverse_pic = tabUsrinf2Model.getId_card_reverse_pic();
			String entire_id_card_reverse_pic_path = picServerIp + "/" + id_card_reverse_pic;
			tabUsrinf2Model.setId_card_reverse_pic(entire_id_card_reverse_pic_path);
			
			String width_id_card = tabUsrinf2Model.getWith_id_card_pic();
			String entire_width_id_card_path = picServerIp + "/" + width_id_card;
			tabUsrinf2Model.setWith_id_card_pic(entire_width_id_card_path);
			
			//查询子表其他增信资料
			TabUsrOtherPicModel tabUsrOtherPic = new TabUsrOtherPicModel();
			tabUsrOtherPic.setUsrinf_id(tabUsrinf2.getUsrinf_id().intValue());
			List<TabUsrOtherPic> tabUsrOtherPic_List = tabUsrOtherPicService.queryByList(tabUsrOtherPic);
			if(tabUsrOtherPic_List.size()>0){
				jsonMap.put("tabUsrOtherPic_List", tabUsrOtherPic_List);
			}	
			//查询补充资料
			TabUsrComplementPicModel tabUsrComplementPic = new TabUsrComplementPicModel();
			tabUsrComplementPic.setUsrinf_id(tabUsrinf2.getUsrinf_id().intValue());
			tabUsrComplementPic.setPic_type(0);
			List<TabUsrComplementPic> tabUsrComplementPic_List = tabUsrComplementPicService.queryByList(tabUsrComplementPic);
			if(tabUsrComplementPic_List!=null && tabUsrComplementPic_List.size()>0){
				jsonMap.put("tabUsrComplementPic_List", tabUsrComplementPic_List);
			}
			//设置评分报告权限
			Boolean scoring_report_auth = tabUsrinf2Service.isAuthority(request, tabUsrinf2Model, WebServiceConstant.MENU_NAME_USER_MANAGER, WebServiceConstant.SCORING_REPORT_AUTH);
			tabUsrinf2Model.setScoring_report_auth(scoring_report_auth);
			jsonMap.put("tabUsrinf", tabUsrinf2Model);
			jsonMap.put(SUCCESS, true);
		}else {
			jsonMap.put(MSG, "查询额度用户信息失败");
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年11月23日
	 * @description 获取订单相关的授信资料
	 * @param bean
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/getUserInfoRelateOrder") 
	public void  getUserInfoRelateOrder(TabBorrowInfoModel tabBorrowInfoModel, HttpServletResponse response,HttpServletRequest request) throws Exception{
		//TODO 
		TabUsrOrder tabUsrOrder = tabUsrOrderService.queryOrderByOrderNo(tabBorrowInfoModel.getOrder_id());
		if(tabUsrOrder == null){
			sendFailureMessage(response, "根据订单号未查询到订单");
			return;
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		//克隆数据
		TabUsrinf2Model tabUsrinf2Model = new TabUsrinf2Model();
		CopyProperties.copyPropertysWithoutNull(tabUsrinf2Model, tabUsrOrder);
		//处理省市县数据
		tabAreaBeanService.dealTabArea(tabUsrinf2Model);
		//查询子表联系人信息
		List<TabOrderBondsmaninf> tabOrderBondsmaninfList = tabOrderBondsmaninfService.selectByUserOrderId(tabUsrOrder.getUsr_order_id());
		if(tabOrderBondsmaninfList.size()>0){
			jsonMap.put("tabBondsmaninf_List", tabOrderBondsmaninfList);
		}else{
			jsonMap.put(MSG, "无直系亲属信息！");
		}
		//处理身份证照片地址
		String id_card_front_pic = tabUsrinf2Model.getId_card_front_pic();
		String entire_id_card_front_pic_path = picServerIp + "/" + id_card_front_pic;
		tabUsrinf2Model.setId_card_front_pic(entire_id_card_front_pic_path);
		
		String id_card_reverse_pic = tabUsrinf2Model.getId_card_reverse_pic();
		String entire_id_card_reverse_pic_path = picServerIp + "/" + id_card_reverse_pic;
		tabUsrinf2Model.setId_card_reverse_pic(entire_id_card_reverse_pic_path);
		
		String width_id_card = tabUsrinf2Model.getWith_id_card_pic();
		String entire_width_id_card_path = picServerIp + "/" + width_id_card;
		tabUsrinf2Model.setWith_id_card_pic(entire_width_id_card_path);
		//设置前台赋值usrid
		tabUsrinf2Model.setUsrid(tabUsrOrder.getBorrow_uid());
		//设置评分报告权限
		Boolean scoring_report_auth = tabUsrinf2Service.isAuthority(request, tabUsrinf2Model, WebServiceConstant.MENU_NAME_USER_MANAGER, WebServiceConstant.SCORING_REPORT_AUTH);
		tabUsrinf2Model.setScoring_report_auth(scoring_report_auth);
		jsonMap.put("tabUsrinf", tabUsrinf2Model);
		jsonMap.put(SUCCESS, true);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	@RequestMapping("getOrderPicByOrderSn")
	public void getOrderPicByOrderSn(String order_sn,HttpServletResponse response,HttpServletRequest request){
		
		List<TabUsrOrderPic> tabUsrOrderPicList = tabUsrOrderPicService.queryPicByOrderSnNotMosaic(new TabUsrOrderPic(order_sn));
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if(null != tabUsrOrderPicList && tabUsrOrderPicList.size() > 0){
			for(TabUsrOrderPic tempic:tabUsrOrderPicList){
				tempic.setPic_addr(picServerIp + tempic.getPic_addr());
			}
		}
		jsonMap.put("picList", tabUsrOrderPicList);
		jsonMap.put(SUCCESS, true);
		//获取前缀
		TabUsrOrder tabUsrOrder = tabUsrOrderService.queryOrderByOrderNo(order_sn);
		String result = HttpRequestUtil.sendGet(findStoreTypeDescByStoreTypeIdUrl,"store_type_id=" + tabUsrOrder.getOrder_type());
		if(!StringUtils.isEmpty(result)){
			JSONObject obj = JSONObject.parseObject(result);
			if(obj.getIntValue("code") == WebServiceConstant.CODE_SUCCESS){
				String bidprefix = obj.getJSONObject("data").getString("bidprefix");
				jsonMap.put("bidprefix", bidprefix);
			}
		}
		jsonMap.put("tabUsrOrder", tabUsrOrder);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * 
	 * 用户管理编辑
	 * 2016-09-20
	 *
	 */
	@RequestMapping("/saveUserManager")
	public void saveUserManager(String usrinfo,String bondsmaninfList,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		TabUsrinf2 tabUsrinf = new TabUsrinf2();
		TabBondsmaninf tabBondsmaninf = null;
		List<TabBondsmaninf> tb_list = null; 
		try {
			tabUsrinf = JSONObject.parseObject(usrinfo, TabUsrinf2.class);
			if(tabUsrinf!=null){
				tabUsrinf2Service.updateByPrimaryKeySelective(tabUsrinf);//授信资料修改
				TabChangeLog changeLog = new TabChangeLog();
				changeLog.setUsrinf_id(tabUsrinf.getUsrinf_id().intValue());
				changeLog.setCh_operate_time(new Date());
				SysUser sysUser = SessionUtils.getUser(request);
				String real_name = sysUser.getReal_name();
				changeLog.setCh_operator(real_name);
				changeLog.setCh_action("用户更新个人信息");
				tabChangeLogService.add(changeLog);
			}
			tb_list = JSONObject.parseArray(bondsmaninfList, TabBondsmaninf.class); 
			if(tb_list!=null && tb_list.size()>0){
				for(TabBondsmaninf tb : tb_list ){
					tabBondsmaninf = new TabBondsmaninf();
					tabBondsmaninf.setId(tb.getId());
					tabBondsmaninf.setRel_usrname(tb.getRel_usrname());
					tabBondsmaninf.setRelation(tb.getRelation());
					tabBondsmaninf.setRel_mobile_phone(tb.getRel_mobile_phone());
					tabBondsmaninfService.update(tabBondsmaninf);//联系人资料修改
				}
			}
			jsonMap.put("msg", 1);
		} catch (Exception e) {
			log.info(usrinfo+","+bondsmaninfList+"用户资料更新失败");
			e.printStackTrace();
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * 查询资料处理中所有打码图片
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/find_mosmic_pic") 
	public void  find_mosmic_pic(TabUsrinf2 bean,HttpServletResponse response,HttpServletRequest request) throws Exception{
		TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(bean.getUsrinf_id());
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if(null!=tabUsrinf){
			//TODO 订单资料相关的打码图片
			
			//查询补充资料(打码图片)
			TabUsrComplementPicModel tabUsrComplementPic = new TabUsrComplementPicModel();
			tabUsrComplementPic.setUsrinf_id(tabUsrinf.getUsrinf_id().intValue());
			tabUsrComplementPic.setPic_type(1);
			List<TabUsrComplementPic> tabUsrComplementPic_List = tabUsrComplementPicService.queryByList(tabUsrComplementPic);
			if(tabUsrComplementPic_List!=null && tabUsrComplementPic_List.size()>0){
				jsonMap.put("tabUsrComplementPic_List", tabUsrComplementPic_List);
			}
			jsonMap.put(SUCCESS, true);
			
		}else {
			jsonMap.put(MSG, "查询资料处理中所有打码图片失败");
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * 征信资料查询
	 * @param tu
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/queryzhengxin_info")
	public void queryzhengxin_info(TabUsrinf2 tu, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		TabUsrinf2 tabUsrinf = tabUsrinf2Service.queryTabUsrinf2ByUsrinfId(tu.getUsrinf_id());
		if(tabUsrinf!=null){
			if (StringUtils.isBlank(tabUsrinf.getCredit_report_pic())) {
				jsonMap.put("msg", "1");//无征信资料
			}else{
				jsonMap.put("tabUsrinf", tabUsrinf);
			}
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 用户资料变更日志查询
	 */
	@RequestMapping("/changeLogList")
	public void changeLogList(TabChangeLogModel model, HttpServletResponse response, HttpServletRequest request)throws Exception {
		List<TabChangeLog> dataList = tabChangeLogService.queryByList(model);
	
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	
	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2017年1月6日
	 * @description 根据Usrid获取关联的订单信息
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/getOrderListByUsrid")
	public void getOrderListByUsrid(TabUsrinf2Model model,HttpServletResponse response, HttpServletRequest request)throws Exception {
	
		try {
			if(model.getBorrow_uid() == null){
				sendFailureMessage(response, "borrow_uid不能为空");
				return;
			}
			List<TabUsrOrder> tabUsrOrderList = tabUsrOrderService.queryByList(model);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total",model.getPager().getRowCount());
			jsonMap.put("rows", tabUsrOrderList);
			HtmlUtil.writerJson(response, jsonMap);
		} catch (Exception e) {
			sendFailureMessage(response, e.getMessage());
		}
	}
}
