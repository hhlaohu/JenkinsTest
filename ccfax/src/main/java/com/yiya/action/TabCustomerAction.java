package com.yiya.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yiya.aop.Key;
import com.yiya.bean.AllocationGoods;
import com.yiya.bean.CustomerBean;
import com.yiya.bean.CustomerNote;
import com.yiya.bean.Dbje;
import com.yiya.bean.ErrorDaily;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.OperatorDaily;
import com.yiya.bean.PzGood;
import com.yiya.bean.SpecConfig;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabCustomer;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabStockComment;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.AllocationGoodsModel;
import com.yiya.model.CustomerNoteModel;
import com.yiya.model.DbjeModel;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.OperatorDailyModel;
import com.yiya.model.StockAndCommentBlendModel;
import com.yiya.model.TabCustomerModel;
import com.yiya.model.TabStockModel;
import com.yiya.service.AllocationGoodsService;
import com.yiya.service.CustomerNoteService;
import com.yiya.service.DbjeService;
import com.yiya.service.OperatorDailyService;
import com.yiya.service.PzGoodService;
import com.yiya.service.SendMessage;
import com.yiya.service.SpecConfigService;
import com.yiya.service.TabCustomerService;
import com.yiya.service.TabStockCommentService;
import com.yiya.service.TabStockService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;

@Controller
@RequestMapping("/customer")
public class TabCustomerAction extends BaseAction implements InitializingBean {

	private final static Logger log = Logger.getLogger(TabCustomerAction.class);

	// Servrice start
	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private TabCustomerService<TabCustomer> tabcustomerservice;

	// Servrice start
	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private DbjeService<Dbje> dbjeService;

	@Autowired(required = false)
	private OperatorDailyService<OperatorDaily> operatorDailyService;

	@Autowired(required = false)
	private TabStockService<TabStock> tabStockService;

	@Autowired(required = false)
	private CustomerNoteService<CustomerNote> customerNoteService;

	@Autowired(required = false)
	private TabStockCommentService<TabStockComment> tabStockCommentService;

	@Autowired(required = false)
	private AllocationGoodsService<AllocationGoods> allocationGoodsService;

	@Autowired(required = false)
	private PzGoodService<PzGood> pzGoodService;

	@Autowired(required = false)
	private SpecConfigService specConfigService;

	@Value("${updateStockSwitch}")
	private boolean updateStockSwitch;

	@Value("${getAllCustomerList}")
	private String getAllCustomerList;

	@Value("${getAllStockList}")
	private String getAllStockList;

	@Value("${getChainGold}")
	private String getChainGold;

	/**
	 * ilook 首页
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(TabCustomerModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		AllocationGoodsModel agm = new AllocationGoodsModel();
		List<TabCustomer> dataList = tabcustomerservice.queryAllList(model);
		List<AllocationGoods> goodList = allocationGoodsService.queryByList(agm);
		List<SpecConfig> listSC = specConfigService.querySpecConfigList();
		List<PzGood> listP = pzGoodService.queryPlace();
		List<PzGood> listL = pzGoodService.queryLevel();
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("goodList", goodList);
		context.put("listP", listP);
		context.put("listL", listL);
		context.put("listSC", listSC);
		return forword("TabCustomer/tabcustomer", context);
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
	public void dataList(TabCustomerModel model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		int rowcount = tabcustomerservice.queryByCount(model);
		model.getPager().setRowCount(rowcount);
		List<TabCustomer> dataList = tabcustomerservice.queryByList(model);
		Map<String, Object> resulMap = tabcustomerservice.getBorrowSumFromChainGoldInbulk(dataList);
		if (dataList != null && dataList.size() > 0) {
			TabStockModel tabStockModel = new TabStockModel();
			List<TabStock> tabStockList = new ArrayList<TabStock>();
			for (TabCustomer customer : dataList) {
				BigDecimal plmarketprice = new BigDecimal(0);
				tabStockModel.setCustomer_id(customer.getCustomer_id());
				tabStockList = tabStockService.queryAllByList(tabStockModel);
				if (tabStockList != null && tabStockList.size() > 0) {
					for (TabStock ts : tabStockList) {
						if (null == ts.getGood_volume()) {
							ts.setGood_volume("0");
						}
						if (null == ts.getMarket_prices()) {
							ts.setMarket_prices(new BigDecimal(0));
						}
						if (null == ts.getPledge_multiplier()) {
							ts.setPledge_multiplier(new BigDecimal(0));
						}
						// 计算折后总价
						plmarketprice = plmarketprice.add(new BigDecimal(ts.getGood_volume())
								.multiply(ts.getMarket_prices()).multiply(ts.getPledge_multiplier()));
					}
					customer.setBreak_Stock_value(plmarketprice);
				}
				customer.setBorrow_balance((BigDecimal) resulMap.get(StringUtils.trim(customer.getTelephone())));
			}
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json URl接口调用
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	private String sendPostRequest(String url) throws Exception {
		StringBuffer stringBuffer = new StringBuffer("");
		BufferedReader reader = null;
		try {
			URL postUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.setConnectTimeout(5000);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return stringBuffer.toString();
	}

	/**
	 * json 错误日志页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/geterrorlist")
	public void geterrorlist(ErrorDailyModel model, HttpServletResponse response) throws Exception {
		int rowcount = tabcustomerservice.queryErrorDailyCount(model);
		model.getPager().setRowCount(rowcount);
		List<ErrorDaily> dataList = tabcustomerservice.queryErrorDaily(model);

		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 修改错误日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateerrorstatus")
	@Key(operation = "修改错误日志", param = "updateerrorstatus")
	public void updateerrorstatus(ErrorDailyModel model, HttpServletResponse response) throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			tabcustomerservice.errorStatusUp(model);
			jsonMap.put("msg", "1");
		} catch (Exception e) {
			jsonMap.put("msg", "0");
			e.printStackTrace();
		}

		// 设置页面数据
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 删除错误日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteerror")
	@Key(operation = "删除错误日志", param = "deleteerror")
	public void deleteerror(ErrorDailyModel model, HttpServletResponse response) throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			tabcustomerservice.deleteerror(model);
			jsonMap.put("msg", "1");
		} catch (Exception e) {
			jsonMap.put("msg", "0");
			e.printStackTrace();
		}

		// 设置页面数据

		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 修改客户
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	@Key(operation = "修改客户", param = "update")
	public void update(TabCustomerModel model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String content = "";
		/*
		 * if(null==model.getTemporary_lock_line()){ BigDecimal b1=new
		 * BigDecimal(0); model.setTemporary_lock_line(b1); }
		 */
		try {

			TabCustomer tcs = tabcustomerservice.queryById(model.getCustomer_id());
			if (null == tcs.getTemporary_lock_line()) {
				BigDecimal b1 = new BigDecimal(0);
				tcs.setTemporary_lock_line(b1);
			}
			if (null == tcs.getCredit_limit()) {
				BigDecimal b1 = new BigDecimal(0);
				tcs.setCredit_limit(b1);
			}
			if (null == tcs.getCredit_limit()) {
				BigDecimal b1 = new BigDecimal(0);
				tcs.setCredit_limit(b1);
			}
			if (null != model.getCredit_limit()) {
				if (!tcs.getCredit_limit().toString().equals(model.getCredit_limit().toString())) {
					content += "调整授信额度至：" + model.getCredit_limit() + ",";
				}
			}
			if (null != tcs.getTemporary_lock_line() && null != model.getTemporary_lock_line()) {
				if (!tcs.getTemporary_lock_line().toString().equals(model.getTemporary_lock_line().toString())) {
					content += "调整临时锁止线至：" + model.getTemporary_lock_line().toString() + ",";
				}
			}
			if (null != tcs.getStart_time()) {
				String stime = tcs.getStart_time().trim().toString().substring(0, 19);

				if (!stime.equals(model.getStart_time().trim().toString())) {
					content += "调整临时锁止线开始时间至：" + model.getStart_time().toString() + ",";
				}
				if ("".equals(tcs.getStart_time().toString())) {
					model.setStart_time(null);
				}
			}
			if (null != tcs.getEnd_time()) {
				String etime = tcs.getEnd_time().trim().toString().substring(0, 19);
				if (!etime.equals(model.getEnd_time().trim().toString())) {
					content += "调整临时锁止线结束时间至：" + model.getEnd_time().toString() + ",";
				}
				if ("".equals(tcs.getEnd_time().toString())) {
					model.setEnd_time(null);
				}
			}
			OperatorDaily op = new OperatorDaily();
			SysUser user = SessionUtils.getUser(request);
			if (null == user) {
				op.setOperator("管理员");
			} else {
				op.setOperator(user.getReal_name());
			}
			tabcustomerservice.updatelockline(model);

			op.setCustomer_id(model.getCustomer_id());
			op.setOperator_content(content);
			if (!"".equals(content)) {
				operatorDailyService.add(op);
			}

		} catch (Exception e) {
			jsonMap.put("msg", "操作失败，请和管理员取得联系");

			e.printStackTrace();
			HtmlUtil.writerJson(response, jsonMap);
		}

		// 设置页面数据

		sendSuccessMessage(response, "操作成功");

	}

	/**
	 * json 得到担保金额
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getdbje")
	public void getdbje(DbjeModel model, HttpServletResponse response) throws Exception {

		DbjeModel dbjeModel = null;

		List<Dbje> dataList = null;
		List<Dbje> resultList = null;
		try {
			dataList = dbjeService.queryByList(model);
			for (Dbje db : dataList) {
				dbjeModel = new DbjeModel();
				TabCustomer tcu = tabcustomerservice.queryById(db.getDbr_id());
				if (null != tcu) {
					if (!db.getDbr_name().equals(tcu.getCustomer_name())) {
						dbjeModel.setDbr_id(db.getDbr_id());
						dbjeModel.setDbr_name(tcu.getCustomer_name());
						dbjeService.updateName(dbjeModel);
					}
				}
				dbjeModel.setDbr_id(0);
				dbjeModel.setDbr_name("");
				TabCustomer tcu2 = tabcustomerservice.queryById(db.getBdbr_id());
				if (null != tcu2) {
					if (!db.getBdbr_name().equals(tcu2.getCustomer_name())) {
						dbjeModel.setBdbr_id(db.getBdbr_id());
						dbjeModel.setBdbr_name(tcu.getCustomer_name());
						dbjeService.updateName(dbjeModel);
					}
				}

			}
			resultList = dbjeService.queryByList(model);
			;
			int rowcount = dbjeService.queryByCount(model);
			model.getPager().setRowCount(rowcount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String wtrdbje = "0";
		DbjeModel model2 = new DbjeModel();
		model2.setDbr_id(model.getDbr_id());
		Dbje dbje = dbjeService.queryDbmoney(model2);
		if (null == dbje) {
			wtrdbje = "0";
		} else {
			wtrdbje = dbje.getDb_money().toString();
		}

		String jsrdbje = "0";
		DbjeModel model3 = new DbjeModel();
		model3.setBdbr_id(model.getBdbr_id());
		Dbje dbje2 = dbjeService.queryDbmoney(model3);
		if (null == dbje2) {

		} else {
			jsrdbje = dbje2.getDb_money().toString();
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("wtrdbje", wtrdbje);
		jsonMap.put("jsrdbje", jsrdbje);
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", resultList);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * json 增加担保金额
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adddbje")
	@Key(operation = "增加担保金额", param = "adddbje")
	public void adddbje(DbjeModel model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String content = "";
		OperatorDaily op = new OperatorDaily();
		SysUser user = SessionUtils.getUser(request);
		if (null == user) {
			op.setOperator("管理员");
		} else {
			op.setOperator(user.getReal_name());
		}
		try {
			Dbje dbje = dbjeService.queryById(model);
			if (null == dbje) {
				dbjeService.add(model);
				content += "增加担保人:" + model.getDbr_name() + ",为" + model.getBdbr_name() + ",担保:" + model.getDb_money();
			} else {
				BigDecimal price = dbje.getDb_money();
				BigDecimal addprice = model.getDb_money();
				Double zj = price.add(addprice).doubleValue();
				BigDecimal zjl = new BigDecimal(zj);
				model.setDb_money(zjl);
				dbjeService.update(model);
				content += "担保人:" + model.getDbr_name() + ",为" + model.getBdbr_name() + ",担保:" + model.getDb_money();
			}
			op.setCustomer_id(model.getDbr_id());
			op.setOperator_content(content);
			if (!"".equals(content)) {
				operatorDailyService.add(op);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 设置页面数据
		sendSuccessMessage(response, "操作成功");

	}

	/**
	 * json 增加担保金额
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatedbje")
	@Key(operation = "增加担保金额", param = "updatedbje")
	public void updatedbje(DbjeModel model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String content = "";
		try {
			dbjeService.update(model);

			Dbje dbje = dbjeService.queryById(model);
			OperatorDaily op = new OperatorDaily();
			SysUser user = SessionUtils.getUser(request);
			if (null == user) {
				op.setOperator("管理员");
			} else {
				op.setOperator(user.getReal_name());
			}

			content += "担保人:" + dbje.getDbr_name() + ",被担保人" + dbje.getBdbr_name() + ",修改担保金额至:" + model.getDb_money();
			op.setCustomer_id(model.getDbr_id());
			op.setOperator_content(content);
			if (!"".equals(content)) {
				operatorDailyService.add(op);
			}

		} catch (Exception e) {
			e.printStackTrace();
			sendSuccessMessage(response, "操作失败");
		}
		// 设置页面数据
		sendSuccessMessage(response, "操作成功");

	}

	/**
	 * json 删除担保金额
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletedbje")
	@Key(operation = "删除担保金额", param = "deletedbje")
	public void deletedbje(DbjeModel model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String content = "";
		try {
			dbjeService.delete(model);
			// 插入日志
			OperatorDaily op = new OperatorDaily();
			SysUser user = SessionUtils.getUser(request);
			if (null == user) {
				op.setOperator("管理员");
			} else {
				op.setOperator(user.getReal_name());
			}

			content += "该信息担保人:" + model.getDbr_name() + ",被担保人" + model.getBdbr_name() + ",担保金额:" + model.getDb_money()
					+ "被删除";
			op.setCustomer_id(model.getDbr_id());
			op.setOperator_content(content);
			if (!"".equals(content)) {
				operatorDailyService.add(op);
			}

		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		sendSuccessMessage(response, "1");

	}

	/**
	 * json 得到操作日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperatorDaily")
	public void getOperatorDaily(OperatorDailyModel model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			/*
			 * OperatorDaily op=new OperatorDaily(); SysUser user
			 * =SessionUtils.getUser(request);
			 * op.setOperator(user.getReal_name());
			 * op.setOperator_content("dfs");
			 * op.setCustomer_id(model.getCustomer_id());
			 * operatorDailyService.add(op);
			 */
			int rowcount = operatorDailyService.queryByCount(model);
			model.getPager().setRowCount(rowcount);
			List<OperatorDaily> dataList = operatorDailyService.queryByList(model);
			// 设置页面数据
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("total", model.getPager().getRowCount());
			jsonMap.put("rows", dataList);
			HtmlUtil.writerJson(response, jsonMap);
		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		sendSuccessMessage(response, "1");

	}

	/**
	 * json 得到库存信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getstock")
	public void getstock(TabStockModel model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		BigDecimal marketprice = new BigDecimal(0);
		BigDecimal plmarketprice = new BigDecimal(0);
		BigDecimal totalvolume = new BigDecimal(0);
		BigDecimal topvolume = new BigDecimal(0);
		BigDecimal onevolume = new BigDecimal(0);
		BigDecimal twovolume = new BigDecimal(0);
		BigDecimal materialvolume = new BigDecimal(0);

		List<TabStock> dataList = null;
		// 分页查询
		dataList = tabStockService.queryByList(model);
		int rowcount = tabStockService.queryByCount(model);

		CustomerNote tempCustomerNote = new CustomerNote();
		tempCustomerNote.setCustomer_id(model.getCustomer_id());
		// 查询客户最新的备注信息
		CustomerNote customerNote = customerNoteService.queryMaxId(tempCustomerNote);
		if (null == customerNote) {
			customerNote = new CustomerNote();
			customerNote.setNote_content("暂无备注信息");
		}
		model.getPager().setRowCount(rowcount);

		// 根据客户id查询全部信息(联了商品配置表pz_good以便计算指导价)
		List<TabStock> tabStockList = tabStockService.queryAllByList(model);
		List<Integer> stockIdList = new ArrayList<Integer>();
		if (tabStockList != null && tabStockList.size() > 0) {
			for (TabStock ts : tabStockList) {
				if (null == ts.getGood_volume()) {
					ts.setGood_volume("0");
				}
				if (null == ts.getMarket_prices()) {
					ts.setMarket_prices(new BigDecimal(0));
				}
				if (null == ts.getPledge_multiplier()) {
					ts.setPledge_multiplier(new BigDecimal(0));
				}
				// 计算市场价 体积*价格
				marketprice = marketprice.add(new BigDecimal(ts.getGood_volume()).multiply(ts.getMarket_prices()));
				// 计算折后总价
				plmarketprice = plmarketprice.add(new BigDecimal(ts.getGood_volume()).multiply(ts.getMarket_prices())
						.multiply(ts.getPledge_multiplier()));
				// 计算总体积
				totalvolume = totalvolume.add(new BigDecimal(ts.getGood_volume()));
				stockIdList.add(ts.getStock_id());
			}
		}
		List<StockAndCommentBlendModel> stockAndCommentBlendModelList = tabStockService
				.queryStockByBatchId(stockIdList);
		// 顶级立方米、普一、普二、统材的计算。
		if (stockAndCommentBlendModelList != null && stockAndCommentBlendModelList.size() > 0) {
			for (StockAndCommentBlendModel tempModel : stockAndCommentBlendModelList) {
				// 如果备注表有level备注，就用备注表的level计算（原代码的逻辑目前是这样，这块有疑问）
				if (tempModel.getGood_level_comment() != 0) {
					if ("1".equals(String.valueOf(tempModel.getGood_level_comment()))) {
						topvolume = topvolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("2".equals(String.valueOf(tempModel.getGood_level_comment()))) {
						onevolume = onevolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("3".equals(String.valueOf(tempModel.getGood_level_comment()))) {
						twovolume = twovolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("4".equals(String.valueOf(tempModel.getGood_level_comment()))) {
						materialvolume = materialvolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
				} else {
					if ("1".equals(String.valueOf(tempModel.getGood_level()))) {
						topvolume = topvolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("2".equals(String.valueOf(tempModel.getGood_level()))) {
						onevolume = onevolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("3".equals(String.valueOf(tempModel.getGood_level()))) {
						twovolume = twovolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
					if ("4".equals(String.valueOf(tempModel.getGood_level()))) {
						materialvolume = materialvolume.add(new BigDecimal(tempModel.getGood_volume()));
					}
				}
			}
		}

		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("marketprice", marketprice);
		jsonMap.put("plmarketprice", plmarketprice);
		jsonMap.put("totalvolume", totalvolume);

		jsonMap.put("topvolume", topvolume);
		jsonMap.put("onevolume", onevolume);
		jsonMap.put("twovolume", twovolume);
		jsonMap.put("materialvolume", materialvolume);

		jsonMap.put("fkbzxx", customerNote.getNote_content());
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * json 得到库存详细信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getstockdetail")
	public void getstockdetail(TabStockModel model, HttpServletResponse response) throws Exception {
		TabCustomer tcs = tabcustomerservice.queryById(model.getCustomer_id());
		List<TabStock> dataList = null;

		dataList = tabStockService.queryStockDetailList(model);
		int rowcount = tabStockService.queryStockDetailCount(model);
		model.getPager().setRowCount(rowcount);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("Cname", tcs.getCustomer_name());
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 得到客户备注信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getcustomernote")
	public void getcustomernote(CustomerNoteModel model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		List<CustomerNote> dataList = null;

		dataList = customerNoteService.queryByList(model);
		int rowcount = customerNoteService.queryByCount(model);
		model.getPager().setRowCount(rowcount);

		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 增加客户备注日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addnote")
	@Key(operation = "增加客户备注日志", param = "addnote")
	public void addnote(CustomerNote model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomerNote cn = null;
		try {

			SysUser user = SessionUtils.getUser(request);
			if (null == user) {
				model.setNote_person("管理员");
			} else {
				model.setNote_person(user.getReal_name());
			}
			customerNoteService.add(model);

			CustomerNote ctne = new CustomerNote();
			ctne.setCustomer_id(model.getCustomer_id());
			cn = customerNoteService.queryMaxId(ctne);
			if (null == cn) {
				cn = new CustomerNote();
				cn.setNote_content("暂无备注信息");
			}
		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("fkbzxx", cn.getNote_content());
		jsonMap.put("msg", 1);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * json 更改客户备注日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatenote")
	@Key(operation = "更改客户备注日志", param = "updatenote")
	public void updatenote(CustomerNote model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomerNote cn = null;
		try {

			SysUser user = SessionUtils.getUser(request);
			if (null == user) {
				model.setNote_person("管理员");
			} else {
				model.setNote_person(user.getReal_name());
			}
			customerNoteService.update(model);

			CustomerNote ctne = new CustomerNote();
			ctne.setCustomer_id(model.getCustomer_id());
			cn = customerNoteService.queryMaxId(ctne);
			if (null == cn) {
				cn = new CustomerNote();
				cn.setNote_content("暂无备注信息");
			}
		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("fkbzxx", cn.getNote_content());
		jsonMap.put("msg", 1);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * json 删除客户备注日志
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletenote")
	@Key(operation = "删除客户备注日志", param = "deletenote")
	public void deletenote(CustomerNote model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomerNote cn = null;
		try {

			customerNoteService.delete(model);

			CustomerNote ctne = new CustomerNote();
			ctne.setCustomer_id(model.getCustomer_id());
			cn = customerNoteService.queryMaxId(ctne);
			if (null == cn) {
				cn = new CustomerNote();
				cn.setNote_content("暂无备注信息");
			}
		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("fkbzxx", cn.getNote_content());
		jsonMap.put("msg", 1);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * json 更新风控备注信息
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatefkcomment")
	@Key(operation = "更新风控备注信息", param = "updatefkcomment")
	public void updatefkcomment(TabStockComment model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TabStockComment tc = null;
		try {
			tc = tabStockCommentService.queryById(model);
			if (null == tc) {
				tabStockCommentService.add(model);
			} else {
				tabStockCommentService.update(model);
			}

		} catch (Exception e) {
			sendSuccessMessage(response, "0");
			e.printStackTrace();
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put("msg", 1);
		HtmlUtil.writerJson(response, jsonMap);

	}

	/**
	 * @param userId
	 * @param request
	 * @description 从链金锁获得借款值并更新
	 */
	@RequestMapping("getChainGold")
	public void getChainGold(HttpServletRequest request) {
		ErrorDailyModel tb = new ErrorDailyModel();
		String telephone;
		List<TabCustomer> tcs = null;

		tcs = tabcustomerservice.queryAllList(null);
		if (null != tcs && tcs.size() > 0) {
			List<TabCustomer> tabCustomerList = new ArrayList<TabCustomer>();
			for (TabCustomer cu : tcs) {
				tb.setError_customer_name(cu.getCustomer_name());
				tb.setError_telephone(cu.getTelephone());
				telephone = "?user_phone=" + cu.getTelephone();
				try {
					String data = SendMessage.sendPostRequest(getChainGold + telephone);
					if (StringUtil.isEmpty(data)) {
						throw new RuntimeException("请求调用链金所getChainGold接口获取客户借款金额失败！");
					} else {
						com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(data);
						int code = jsonObject.getIntValue("code");
						TabCustomer tabcustomer = new TabCustomer();
						tabcustomer.setCustomer_id(cu.getCustomer_id());
						if (code == WebServiceConstant.CODE_SUCCESS) {
							String borrow_balance = jsonObject.get("total").toString();
							tabcustomer.setBorrow_balance(new BigDecimal(borrow_balance));
							tabCustomerList.add(tabcustomer);
						} else {
							// 如果获取不到值则设默认值为0
							tabcustomer.setBorrow_balance(new BigDecimal(0));
							tabCustomerList.add(tabcustomer);
							throw new RuntimeException(
									"请求调用链金所getChainGold接口获取客户借款金额失败！失败原因:" + jsonObject.getString("message"));
						}

					}
				} catch (Exception e) {
					tb.setError_content("获取客户借款金额出错");
					tabcustomerservice.adderrordaily(tb);
					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
			if (!tabCustomerList.isEmpty()) {
				tabcustomerservice.batchUpdateTabCustomer(tabCustomerList);
			}
		}
	}

	/**
	 * 容器启动时同步更新库存
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/getInterFaceStockList")
	@ResponseBody
	public JsonResponse getInterFaceStockList() throws Exception {
		TabStock tsk = new TabStock();
		List<TabStock> addList = new ArrayList<TabStock>();
		List<TabStock> updateList = new ArrayList<TabStock>();
		List<Integer> deleteList = new ArrayList<Integer>();
		List<TabStock> tskList = null;
		Map<String, Object> ctmap = null;
		List<Map<String, Object>> lhmap = null;
		Set<Integer> stock_id_set = new HashSet<Integer>(); // 仓库系统库存id的HashSet集合
		String url = getAllStockList;
		String data = sendPostRequest(url);
		log.info("从仓库系统获取库存信息返回结果成功" + data.substring(0, 1000));
		JSONObject jsonObject = JSONObject.parseObject(data);
		String resultText = jsonObject.get("resultText").toString();
		JSONObject jsonObject_customer_list = JSONObject.parseObject(resultText);
		lhmap = (List<Map<String, Object>>) jsonObject_customer_list.get("stock_list");
		if (lhmap.size() > 0) {
			for (int i = 0; i < lhmap.size(); i++) {
				TabStock tskModel = new TabStock();
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
				if (null != ctmap.get("good_number") && !"".equals(ctmap.get("good_number").toString())) {
					tskModel.setGood_number(Integer.parseInt(ctmap.get("good_number").toString()));
				}
				if (null != ctmap.get("lock_status") && !"".equals(ctmap.get("lock_status").toString())) {
					tskModel.setLock_status(Integer.parseInt(ctmap.get("lock_status").toString()));
				}
				if (null != ctmap.get("last_check_time") && !"".equals(ctmap.get("last_check_time").toString())) {
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long ct = Long.parseLong(ctmap.get("last_check_time").toString());
					String time = fmt.format(ct);
					tskModel.setCheck_time(time);
				}
				if (null != ctmap.get("put_time") && !"".equals(ctmap.get("put_time").toString())) {
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long pt = Long.parseLong(ctmap.get("put_time").toString());
					String time = fmt.format(pt);
					Date date = fmt.parse(time);
					tskModel.setPut_success_time(date);
				}
				if (null != ctmap.get("stock_id")) {
					tskModel.setStock_id(Integer.parseInt(ctmap.get("stock_id").toString()));
				}
				if (null != ctmap.get("customer_id")) {
					tskModel.setCustomer_id(Integer.parseInt(ctmap.get("customer_id").toString()));
				}
				tskModel.setBar_code(ctmap.get("bar_code").toString());
				tskModel.setBusiness_pag_no(ctmap.get("business_pag_no").toString());

				tsk = tabStockService.queryById(tskModel.getStock_id());
				if (null == tsk) {
					addList.add(tskModel);
				} else {
					updateList.add(tskModel);
				}
				// 用于判断是否删除更新
				stock_id_set.add(Integer.parseInt(ctmap.get("stock_id").toString()));
			}

			// 比较如果本地库存表不存在，则删除
			tskList = tabStockService.queryAllTabStock();
			if (null != tskList && tskList.size() > 0 && lhmap.size() > 0) {
				for (TabStock stock : tskList) {
					Integer stock_id = stock.getStock_id();
					if (!stock_id_set.contains(stock_id)) {
						deleteList.add(stock_id);
					}
				}
			}
			if (!addList.isEmpty()) {
				tabStockService.addInBatch(addList);
			}
			if (!updateList.isEmpty()) {
				tabStockService.updateInBatch(updateList);
			}
			if (!deleteList.isEmpty()) {
				tabStockService.deleteInBatch(deleteList);
			}
		}
		return JsonResponse.success("更新成功");
	}

	/**
	 * @author wang_xiao_long
	 * @data 2016年9月12日
	 * @description 批量更新客户信息
	 * @throws Exception
	 */
	@RequestMapping("/getInterFaceCustomerList")
	@ResponseBody
	public JsonResponse getInterFaceCustomerList() throws Exception {
		String cname = "";
		String addr = "";
		int cid = 0;
		String tel = "";
		int ctype = 0;
		List<CustomerBean> lhmap = new ArrayList<CustomerBean>();
		Set<Integer> customer_id_set = new HashSet<Integer>(); // 仓库系统客户id的HashSet集合
		List<TabCustomer> tcs = null;
		TabCustomer tabcustomer = null;
		TabCustomer tcsModel = new TabCustomer();
		TabCustomerModel allModel = new TabCustomerModel();
		tcs = tabcustomerservice.queryAllList(allModel);
		// 调用接口
		String data = sendPostRequest(getAllCustomerList);
		log.info("从仓库系统获取客户信息返回结果:" + data);
		org.json.JSONObject jsonObject = new org.json.JSONObject(data);
		String resultText = jsonObject.get("resultText").toString();
		org.json.JSONObject jsonObject_customer_list = new org.json.JSONObject(resultText);
		String customer_list = jsonObject_customer_list.get("customer_list").toString();
		Gson gson = new Gson();
		List<CustomerBean> customersList = gson.fromJson(customer_list, new TypeToken<List<CustomerBean>>() {
		}.getType());
		lhmap = customersList;
		if (lhmap.size() > 0) {
			for (int i = 0; i < lhmap.size(); i++) {
				CustomerBean bean = lhmap.get(i);
				if (null != bean.getCustomer_name()) {
					cname = bean.getCustomer_name();
					tcsModel.setCustomer_name(cname);
				}
				if (null != bean.getCustomer_id()) {
					System.out.println("客户id =" + bean.getCustomer_id());
					cid = bean.getCustomer_id();
					tcsModel.setCustomer_id(cid);
				}
				if (null != bean.getAddr()) {
					addr = bean.getAddr();
					tcsModel.setAddress(addr);
				}
				if (null != bean.getTel()) {
					tel = bean.getTel();
					tcsModel.setTelephone(tel);
				}
				if (null != bean.getCustomer_type()) {
					ctype = bean.getCustomer_type();
					tcsModel.setCustomer_type(ctype);
				}

				tabcustomer = tabcustomerservice.queryById(cid);
				if (null == tabcustomer) {
					tabcustomerservice.add(tcsModel);
				} else {
					tabcustomerservice.update(tcsModel);
				}
				customer_id_set.add(bean.getCustomer_id());

			}
		}
		// 比较如果客户不存在则删除
		if (null != tcs && tcs.size() > 0 && lhmap.size() > 0) {
			for (TabCustomer tcu : tcs) {
				Integer customer_id = tcu.getCustomer_id();
				if (!customer_id_set.contains(customer_id)) {
					tabcustomerservice.delete(customer_id);
				}
			}
		}
		return JsonResponse.success("更新成功");
	}

	/**
	 * @data 2016年9月12日
	 * @description 从炼金锁获取数据更新
	 */
	public void getChainGold() {
		ErrorDailyModel tb = new ErrorDailyModel();
		String telephone;
		List<TabCustomer> tcs = null;

		tcs = tabcustomerservice.queryAllList(null);
		try {
			if (null != tcs && tcs.size() > 0) {
				for (TabCustomer cu : tcs) {
					if (null != cu) {
						tb.setError_customer_name(cu.getCustomer_name());
						tb.setError_telephone(cu.getTelephone().toString());
						telephone = "?user_phone=" + cu.getTelephone();
						String data = SendMessage.sendPostRequest(getChainGold + telephone);
						if (StringUtil.isEmpty(data)) {
							log.error("请求调用链金所getChainGold接口获取客户借款金额失败！");
						}
						log.info("从链金所获取借款金额返回结果:" + data);
						if (!"".equals(data)) {
							org.json.JSONObject jsonObject = new org.json.JSONObject(data);
							String code = jsonObject.get("code").toString();
							TabCustomer tabcustomer = new TabCustomer();
							if (code.equals("0")) {
								String borrow_balance = jsonObject.get("total").toString();
								tabcustomer.setBorrow_balance(new BigDecimal(borrow_balance));
								tabcustomer.setCustomer_id(cu.getCustomer_id());
								tabcustomerservice.update(tabcustomer);
								log.info("请求调用链金所getChainGold接口获取客户借款金额成功！借款金额borrow_balance=" + borrow_balance);
							} else {
								tabcustomer.setBorrow_balance(new BigDecimal(0));
								tabcustomer.setCustomer_id(cu.getCustomer_id());
								tabcustomerservice.updateborrow(tabcustomer);
								log.info("请求调用链金所getChainGold接口获取客户借款金额失败！借款金额borrow_balance默认设置为0.00");
							}
						} else {
							log.error("请求调用链金所getChainGold接口获取客户借款金额失败！");
						}
					}
				}
			}
		} catch (Exception e) {
			tb.setError_content("获取客户借款金额出错");
			tabcustomerservice.adderrordaily(tb);
			log.error(e.getMessage());
			e.printStackTrace();

		}
	}

	/*
	 * 容器初始化时更新数据
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		if (updateStockSwitch) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					boolean flag = true;
					while (flag) {
						try {
							long startTime = System.currentTimeMillis();
							// 更新客户信息
							getInterFaceCustomerList();
							// 更新库存
							getInterFaceStockList();
							// 从链金所获取数据更新
							getChainGold();
							flag = false;
							log.info("COST_TIME-----------------------------------"
									+ (System.currentTimeMillis() - startTime));
						} catch (ConnectException e) {
							e.printStackTrace();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
			}).start();
		}
	}
}
