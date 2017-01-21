package com.yiya.action.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import com.yiya.bean.TabCustomer;
import com.yiya.bean.TabStock;
import com.yiya.model.TabCustomerModel;
import com.yiya.model.TabStockModel;
import com.yiya.service.TabCustomerService;
import com.yiya.service.TabStockService;
import com.yiya.utils.SessionUtils;

@Controller
@RequestMapping("/bb")
public class GetWebInterfaceAction {
	// Servrice start
	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private TabCustomerService<TabCustomer> tabcustomerservice;

	@Autowired(required = false)
	private TabStockService<TabStock> tabStockService;

	@Value("${getCustomerInfo}")
	private String getCustomerInfoInterface;

	@Value("${getStockInfo}")
	private String getStockInfoInterface;

	@Value("${getChainGold}")
	private String getChainGold;

	/**
	 * json URl接口调用
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	public String sendPostRequest(String url) {
		StringBuffer stringBuffer = new StringBuffer("");
		try {
			URL postUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringBuffer.toString();
	}

	/**
	 * json URl得到仓库客户信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInterFaceCustomerList")
	@ResponseBody
	public void getInterFaceCustomerList(HttpServletRequest request) throws Exception {
		String cname = "";
		String addr = "";
		int cid = 0;
		String tel = "";
		int ctype = 0;

		int usrid = 0;
		List<Map<String, Object>> lhmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> ctmap = null;

		List<TabCustomer> tcs = null;
		TabCustomer tabcustomer = null;
		TabCustomer tcsModel = new TabCustomer();
		TabCustomerModel allModel = new TabCustomerModel();
		tcs = tabcustomerservice.queryAllList(allModel);
		// 获取仓库信息
		if (null == SessionUtils.getUser(request)) {

		} else {
			usrid = SessionUtils.getUser(request).getId();
		}

		String url = getCustomerInfoInterface + "?usr_id=" + usrid;
		String data = sendPostRequest(url);

		JSONObject jsonObject = JSONObject.parseObject(data);
		String resultText = jsonObject.get("resultText").toString();

		JSONObject jsonObject_customer_list = JSONObject.parseObject(resultText);
		lhmap = (List<Map<String, Object>>) jsonObject_customer_list.get("customer_list");
		if (lhmap.size() > 0) {
			for (int i = 0; i < lhmap.size(); i++) {
				ctmap = (Map<String, Object>) lhmap.get(i);
				if (null != ctmap.get("customer_name")) {
					cname = ctmap.get("customer_name").toString();
					tcsModel.setCustomer_name(cname);
				}
				if (null != ctmap.get("customer_id")) {
					System.out.println(ctmap.get("customer_id").toString());
					cid = Integer.parseInt(ctmap.get("customer_id").toString());
					tcsModel.setCustomer_id(cid);
				}
				if (null != ctmap.get("addr")) {
					addr = ctmap.get("addr").toString();
					tcsModel.setAddress(addr);
				}
				if (null != ctmap.get("tel")) {
					tel = ctmap.get("tel").toString();
					tcsModel.setTelephone(tel);
				}
				if (null != ctmap.get("customer_type")) {
					ctype = Integer.parseInt(ctmap.get("customer_type").toString());
					tcsModel.setCustomer_type(ctype);
				}

				tabcustomer = tabcustomerservice.queryById(cid);
				if (null == tabcustomer) {
					tabcustomerservice.add(tcsModel);
				} else {
					tabcustomerservice.update(tcsModel);
				}

			}
		}
		// 比较如果客户不存在则删除
		int var = 0;
		int count = 0;
		String size = String.valueOf(lhmap.size());
		for (TabCustomer tcu : tcs) {
			var = 0;
			count = 0;
			for (int i = 0; i < lhmap.size(); i++) {
				ctmap = (Map<String, Object>) lhmap.get(i);
				if (!String.valueOf(tcu.getCustomer_id()).equals(ctmap.get("customer_id").toString())) {
					var += 1;
				} else {
					count += 1;
				}
			}
			if (String.valueOf(var).equals(size)) {
				tabcustomerservice.delete(tcu.getCustomer_id());
			}
		}
	}

	/**
	 * json URl得到仓库客户库存信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	@RequestMapping("/getInterFaceStockList")
	@ResponseBody
	public void getInterFaceStockList(int customerid, HttpServletRequest request) throws Exception {
		int customer_id = customerid;
		int usrid;
		TabStock tsk = new TabStock();
		TabStock tskModel = new TabStock();
		List<TabStock> tskList = null;
		Map<String, Object> ctmap = null;
		List<Map<String, Object>> lhmap = null;
		if (null == SessionUtils.getUser(request)) {
			usrid = 0;
		} else {
			usrid = SessionUtils.getUser(request).getId();
		}

		String url = getStockInfoInterface + "?usr_id=" + usrid + "&customer_id=" + customer_id;
		String data = sendPostRequest(url);

		JSONObject jsonObject = JSONObject.parseObject(data);
		String resultText = jsonObject.get("resultText").toString();

		JSONObject jsonObject_customer_list = JSONObject.parseObject(resultText);
		lhmap = (List<Map<String, Object>>) jsonObject_customer_list.get("stock_list");

		if (lhmap.size() > 0) {
			for (int i = 0; i < lhmap.size(); i++) {
				ctmap = (Map<String, Object>) lhmap.get(i);
				if (null != ctmap.get("area_name")) {
					tskModel.setArea_name(ctmap.get("area_name").toString());
				}
				if (null != ctmap.get("space_name")) {
					tskModel.setSpace_name(ctmap.get("space_name").toString());
				}
				if (null != ctmap.get("good_name")) {
					tskModel.setGood_name(ctmap.get("good_name").toString());
				}
				if (null != ctmap.get("good_place") && !"".equals(ctmap.get("good_place").toString())) {
					tskModel.setGood_place(ctmap.get("good_place").toString());
				}
				if (null != ctmap.get("good_level") && !"".equals(ctmap.get("good_level").toString())) {
					tskModel.setGood_level(Integer.parseInt(ctmap.get("good_level").toString()));
				}
				if (null != ctmap.get("good_size") && !"".equals(ctmap.get("good_size").toString())) {
					tskModel.setGood_size(ctmap.get("good_size").toString());
				}
				if (null != ctmap.get("good_volume") && !"".equals(ctmap.get("good_volume").toString())) {
					tskModel.setGood_volume(ctmap.get("good_volume").toString());
				}
				if (null != ctmap.get("good_weight") && !"".equals(ctmap.get("good_weight").toString())) {
					tskModel.setGood_weight(ctmap.get("good_weight").toString());
				}
				if (null != ctmap.get("good_size") && !"".equals(ctmap.get("good_size").toString())) {
					tskModel.setGood_size(ctmap.get("good_size").toString());
				}
				if (null != ctmap.get("check_time") && !"".equals(ctmap.get("check_time").toString())) {
					tskModel.setCheck_time(ctmap.get("check_time").toString());
				}
				if (null != ctmap.get("stock_id")) {
					tskModel.setStock_id(Integer.parseInt(ctmap.get("stock_id").toString()));
				}
				tskModel.setCustomer_id(customer_id);
				tsk = tabStockService.queryById(tskModel.getStock_id());
				if (null == tsk) {
					tabStockService.add(tskModel);
				} else {
					tabStockService.update(tskModel);
				}

			}
		}

		TabStockModel tskm = new TabStockModel();
		tskm.setCustomer_id(customer_id);
		// 比较如果仓库不存在则删除
		tskList = tabStockService.queryAllByList(tskm);
		int var = 0;
		int count = 0;
		String size = String.valueOf(lhmap.size());
		for (TabStock tcu : tskList) {
			var = 0;
			count = 0;
			for (int i = 0; i < lhmap.size(); i++) {
				ctmap = (Map<String, Object>) lhmap.get(i);
				if (!String.valueOf(tcu.getStock_id()).equals(ctmap.get("stock_id").toString())) {
					var += 1;
				} else {
					count += 1;
				}
			}
			if (String.valueOf(var).equals(size)) {
				tabStockService.delete(tcu.getStock_id());
			}
		}
	}

	/**
	 * json URl得到仓库客户库存信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	@RequestMapping("/getChainGold")
	@ResponseBody
	public void getChainGold(HttpServletRequest request) throws Exception {
		String tel = "13459442268";
		String url = "https://miror.ccfax.cn/java/getinfo/getborrowsum?user_phone=13459442268";
		String data = sendPostRequest(url);

		JSONObject jsonObject = JSONObject.parseObject(data);
		String code = jsonObject.get("code").toString();
		String message = jsonObject.get("message").toString();
	}

	/**
	 * json URl接口调用
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping("/at")
	@ResponseBody
	public String sendhttps(String url) throws IOException {
		StringBuffer stringBuffer = new StringBuffer("");

		URL reqURL = new URL("https://miror.ccfax.cn/java/getinfo/getborrowsum?user_phone=13459442268");

		HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
		httpsConn.setDoOutput(true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), "UTF-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			stringBuffer.append(line);
		}
		reader.close();

		InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());

		int respInt = insr.read();
		while (respInt != -1) {
			System.out.print((char) respInt);
			respInt = insr.read();
		}
		return stringBuffer.toString();
	}
}
