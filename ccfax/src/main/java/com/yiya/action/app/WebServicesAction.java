package com.yiya.action.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yiya.bean.AlertConfig;
import com.yiya.bean.AlertDaily;
import com.yiya.bean.CustomerBean;
import com.yiya.bean.JsonResponse;
import com.yiya.bean.PzGood;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabCustomer;
import com.yiya.bean.TabStock;
import com.yiya.bean.TabStockComment;
import com.yiya.constant.SpecConfigConstant;
import com.yiya.constant.WebServiceConstant;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.TabCustomerModel;
import com.yiya.model.TabStockModel;
import com.yiya.service.AlertConfigService;
import com.yiya.service.AlertDailyService;
import com.yiya.service.PzGoodService;
import com.yiya.service.SendMessage;
import com.yiya.service.SysUserService;
import com.yiya.service.TabCustomerService;
import com.yiya.service.TabStockCommentService;
import com.yiya.service.TabStockService;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.StringUtil;
import com.yiya.utils.Tools;
import com.yiya.vo.PzGoodVo;

@Controller
@RequestMapping("/riskControl")
public class WebServicesAction{
	private final static Logger log = Logger.getLogger(WebServicesAction.class);

	// Servrice start
	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private TabCustomerService<TabCustomer> tabcustomerservice;

	@Autowired(required = false)
	private TabStockService<TabStock> tabStockService;

	@Autowired(required = false)
	private TabStockCommentService<TabStockComment> tabStockCommentService;

	@Autowired(required = false)
	private AlertConfigService<AlertConfig> alertConfigService;

	@Autowired(required = false)
	private AlertDailyService<AlertDaily> alertDailyService;

	@Autowired(required = false) // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService sysUserService;

	@Autowired
	private PzGoodService<PzGood> pzGoodService;

	@Autowired
	private SendMessage sendMessage;

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
	 * 客户列表---获取库存消息
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/GetKcMessage")
	@ResponseBody
	public JsonResponse GetKcMessage(@RequestParam("customer_id") int customer_id, HttpServletRequest request) {
		try {
			// 更新表tab_customerinfo借款金额
			updateBorrowSumFromChainGold(customer_id);
			// 日期格式转化
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowtime = df.format(now);
			BigDecimal lock_line = new BigDecimal(0);
			TabCustomer tcs = new TabCustomer();
			TabCustomerModel tcsModel = new TabCustomerModel();
			tcsModel.setCustomer_id(customer_id);
			// 查询tab_customerinfo表
			tcs = tabcustomerservice.queryBycustomerid(tcsModel);
			// 没有值设为零
			if (null == tcs.getBorrow_balance()) {
				tcs.setBorrow_balance(new BigDecimal(0));
			}
			if (null == tcs.getGuarant_balance()) {
				tcs.setGuarant_balance(new BigDecimal(0));
			}
			if (null == tcs.getRc_guarant_balance()) {
				tcs.setRc_guarant_balance(new BigDecimal(0));
			}
			if (null == tcs.getCredit_limit()) {
				tcs.setCredit_limit(new BigDecimal(0));
			}
			// 锁止线计算公式 借款金额+为他人担保金额-接受担保金额
			lock_line = tcs.getBorrow_balance().add(tcs.getGuarant_balance()).subtract(tcs.getRc_guarant_balance());
			// 如果锁止线是负数，没有意义，则设为0
			if (lock_line.doubleValue() < 0) {
				lock_line = new BigDecimal(0);
			}
			if (null != tcs.getTemporary_lock_line()) {
				if (!StringUtil.isEmpty(tcs.getStart_time()) && !StringUtil.isEmpty(tcs.getEnd_time())) {
					String stime = tcs.getStart_time().substring(0, 19);
					String etime = tcs.getEnd_time().substring(0, 19);
					if (nowtime.compareTo(stime) > 0) {
						if (nowtime.compareTo(etime) < 0) {
							lock_line = tcs.getTemporary_lock_line();
						}
					}
				}

			}
			// 实时计算客户当前库存折后总价值
			BigDecimal discountStockValue = tabStockService.getDisCountStockValueByCustId(customer_id);
			return JsonResponse.success()
					.put("credit_limit", tcs.getCredit_limit().setScale(2, BigDecimal.ROUND_HALF_UP))
					.put("borrow_balance", tcs.getBorrow_balance())
					.put("lock_line", lock_line.setScale(2, BigDecimal.ROUND_HALF_UP))
					.put("break_Stock_value", discountStockValue.setScale(2, BigDecimal.ROUND_HALF_UP));
		} catch (Exception e) {
			log.error("获取客户信息出错，获取不到该客户库存折后总价值！", e);
			return JsonResponse.fail("查询出错，获取不到该客户库存折后总价值！");
		}
	}

	/**
	 * 获取商品配置信息(取出市场指导价,质押系数的值。主要提供给仓库系统)
	 */
	@RequestMapping("/GetPzGoods")
	@ResponseBody
	public JsonResponse GetPzGoods(PzGoodVo pzGoodVO, HttpServletRequest request) {
		try {
			log.info("WebServicesAction方法GetPzGoods()接收参数：" + pzGoodVO.toString());
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("pz_good_name", pzGoodVO.getGood_name());
			conditionMap.put("pz_good_level", pzGoodVO.getGood_level());
			conditionMap.put("pz_good_place", pzGoodVO.getGood_place());
			conditionMap.put("pz_good_size", pzGoodVO.getGood_size());
			String goodSize = pzGoodVO.getGood_size();
			// 如果规格的分类带*则属于B类，需要进行特殊处理
			if (goodSize.contains("*")) {
				goodSize = goodSize.substring(0, goodSize.indexOf("*"));
				conditionMap.put("pz_good_size", goodSize);
				conditionMap.put("spec_type", SpecConfigConstant.SPEC_TYPE_B);
			} else {
				conditionMap.put("spec_type", SpecConfigConstant.SPEC_TYPE_A);
				// 如果是A类，则用名字来比较
				conditionMap.put("spec_name", goodSize);
			}
			// 匹配pz_good表
			PzGood pzGood = pzGoodService.matchGoodWithCondition(conditionMap);
			// 匹配不成功，查找tab_stock_comment
			if (null == pzGood) {
				TabStockComment comment = tabStockCommentService.queryById(pzGoodVO.getStock_id());
				if (comment != null) {
					if (!StringUtil.isEmpty(comment.getGood_name_comment())) {
						conditionMap.put("pz_good_name", comment.getGood_name_comment());
					}
					if (!StringUtil.isEmpty(comment.getGood_place_comment())) {
						conditionMap.put("pz_good_place", comment.getGood_place_comment());
					}
					if (comment.getGood_size_comment() != null && comment.getGood_size_comment() != 0) {
						conditionMap.put("pz_good_size", comment.getGood_size_comment());
					}
					if (!StringUtil.isEmpty(String.valueOf(comment.getGood_level_comment()))
							&& !"0".equals(String.valueOf(comment.getGood_level_comment()))) {
						conditionMap.put("pz_good_level", comment.getGood_level_comment());
					}
					// 重新组装数据后再一次匹配
					pzGood = pzGoodService.matchGoodWithCondition(conditionMap);
					if (pzGood == null) {
						return JsonResponse.fail("没有数据");
					}
					return JsonResponse.success().put("market_prices", pzGood.getMarket_prices())
							.put("pledge_multiplier", pzGood.getPledge_multiplier());
				} else {
					return JsonResponse.fail("没有数据");
				}
			}
			return JsonResponse.success().put("market_prices", pzGood.getMarket_prices()).put("pledge_multiplier",
					pzGood.getPledge_multiplier());
		} catch (Exception e) {
			log.error("获取商品信息出错，获取不到该商品市场指导价和质押系数！", e);
			return JsonResponse.fail("查询出错，获取不到该商品市场指导价和质押系数！");
		}
	}

	/**
	 * @author wang_xiao_long
	 * @data 2016年8月12日
	 * @description 批量获取商品配置信息(取出市场指导价,质押系数的值。主要提供给仓库系统)
	 * @return
	 */
	@RequestMapping("/GetPzGoodsInBulk")
	@ResponseBody
	public JsonResponse getPzGoodsInBulk(String goods_list, HttpServletRequest request) {
		try {
			log.info("WebServicesAction方法getPzGoodsInBulk()接收参数：" + goods_list.toString());
			List<PzGoodVo> pzGoodVoList = com.alibaba.fastjson.JSONObject.parseArray(goods_list, PzGoodVo.class);
			if (null != pzGoodVoList && pzGoodVoList.size() > 0) {
				List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
				// 库存折后价值
				BigDecimal breakingStockValue = new BigDecimal(0);
				for (PzGoodVo vo : pzGoodVoList) {
					Map<String, Object> conditionMap = new HashMap<String, Object>();
					conditionMap.put("pz_good_name", vo.getGood_name());
					conditionMap.put("pz_good_level", vo.getGood_level());
					conditionMap.put("pz_good_place", vo.getGood_place());
					conditionMap.put("pz_good_size", vo.getGood_size());
					String goodSize = vo.getGood_size();
					// 如果规格的分类带*则属于B类，需要进行特殊处理
					if (goodSize.contains("*")) {
						goodSize = goodSize.substring(0, goodSize.indexOf("*"));
						conditionMap.put("pz_good_size", goodSize);
						conditionMap.put("spec_type", SpecConfigConstant.SPEC_TYPE_B);
					} else {
						conditionMap.put("spec_type", SpecConfigConstant.SPEC_TYPE_A);
						// 如果是A类，则用名字来比较
						conditionMap.put("spec_name", goodSize);
					}
					// 匹配pz_good表
					PzGood pzGood = pzGoodService.matchGoodWithCondition(conditionMap);
					// 匹配不成功，查找tab_stock_comment
					if (null == pzGood) {
						TabStockComment comment = tabStockCommentService.queryById(vo.getStock_id());
						if (comment != null) {
							if (!StringUtil.isEmpty(comment.getGood_name_comment())) {
								conditionMap.put("pz_good_name", comment.getGood_name_comment());
							}
							if (!StringUtil.isEmpty(comment.getGood_place_comment())) {
								conditionMap.put("pz_good_place", comment.getGood_place_comment());
							}
							if (comment.getGood_size_comment() != null && comment.getGood_size_comment() != 0) {
								conditionMap.put("pz_good_size", comment.getGood_size_comment());
							}
							if (!StringUtil.isEmpty(String.valueOf(comment.getGood_level_comment()))
									&& !"0".equals(String.valueOf(comment.getGood_level_comment()))) {
								conditionMap.put("pz_good_level", comment.getGood_level_comment());
							}
							// 重新组装数据后再一次匹配
							pzGood = pzGoodService.matchGoodWithCondition(conditionMap);
							if (pzGood == null) {
								return JsonResponse.fail("获取商品配置信息失败，原因是" + vo.getGood_name() + "无法匹配到数据");
							}
						} else {
							return JsonResponse.fail("获取商品配置信息失败，原因是" + vo.getGood_name() + "无法匹配到数据");
						}
					}
					Map<String, Object> tempMap = new HashMap<String, Object>();
					tempMap.put("market_prices", pzGood.getMarket_prices());
					tempMap.put("pledge_multiplier", pzGood.getPledge_multiplier());
					tempMap.put("stockId", vo.getStock_id());
					resultList.add(tempMap);
					BigDecimal break_StockValue = vo.getGood_volume().multiply(pzGood.getMarket_prices())
							.multiply(pzGood.getPledge_multiplier());
					breakingStockValue = breakingStockValue.add(break_StockValue);
					// breakingStockValue =
					// breakingStockValue.add(vo.getGood_volume().multiply(pzGood.getMarket_prices()).multiply(pzGood.getPledge_multiplier()));
				}
				log.info("本次出库商品折后价值=" + breakingStockValue.setScale(2, BigDecimal.ROUND_HALF_UP));
				return JsonResponse.success().put("list", resultList).put("this_break_stock_value",
						breakingStockValue.setScale(2, BigDecimal.ROUND_HALF_UP));
			} else {
				return JsonResponse.fail("获取商品配置信息失败,原因是传递参数goods_list集合为null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponse.fail("批量获取商品配置信息失败," + "原因是:" + e.getMessage());
		}
	}

	/**
	 * 修改客户接口（同步仓库系统客户，增删改）
	 */
	@RequestMapping("/updateCustomeinf")
	@ResponseBody
	public JsonResponse updateCustomeinf(String updatetype, String customer_id, String customer_name,
			String custome_type, String addr, String tel, HttpServletRequest request) {
		if (updatetype != null && customer_id != null && !StringUtil.isEmpty(customer_id)) {
			// 删除客户
			if (updatetype.equals("0")) {
				try {
					tabcustomerservice.delete(customer_id);
					log.info("风控系统端同步删除客户成功！");
					// 刷新本地客户和库存
					// try {
					// getInterFaceCustomerList(request);// 调用接口更新风控本地客户信息
					// getInterFaceStockList(Integer.valueOf(customer_id),
					// request);// 调用接口更新风控本地库存信息
					// getChainGold(request); // 调用接口获取风控本地客户的借款金额
					// log.info("风控系统端同步刷新本地客户及库存信息成功");
					// } catch (Exception e) {
					// log.error("风控系统端同步刷新本地客户及库存信息出错！" + e.getMessage());
					// e.printStackTrace();
					// }
					return JsonResponse.success();
				} catch (Exception e) {
					log.error("风控系统端同步删除客户失败！" + e);
					e.printStackTrace();
					return JsonResponse.fail("风控系统端同步删除客户失败！");
				}
			}
			// 新增客户
			if (updatetype.equals("1")) {
				try {
					TabCustomer customer = new TabCustomer();
					customer.setCustomer_id(Integer.valueOf(customer_id));
					customer.setCustomer_name(customer_name);
					customer.setCustomer_type(Integer.valueOf(custome_type));
					customer.setAddress(addr);
					customer.setTelephone(tel);
					TabCustomer bean = tabcustomerservice.queryById(customer_id);
					if (null == bean) {
						tabcustomerservice.add(customer);
					} else {
						tabcustomerservice.update(customer);
					}
					log.info("风控系统端同步新增/修改客户成功！");
					// 刷新本地客户和库存
					// try {
					// getInterFaceCustomerList(request);// 调用接口更新风控本地客户信息
					// getInterFaceStockList(Integer.valueOf(customer_id),
					// request);// 调用接口更新风控本地库存信息
					// getChainGold(request); // 调用接口获取风控本地客户的借款金额
					// log.info("风控系统端同步刷新本地客户及库存信息成功");
					// } catch (Exception e) {
					// log.error("风控系统端同步刷新本地客户及库存信息出错！" + e.getMessage());
					// e.printStackTrace();
					// }
					return JsonResponse.success();
				} catch (Exception e) {
					log.error("风控系统端同步新增客户接口失败！" + e);
					e.printStackTrace();
					return JsonResponse.fail("风控系统端同步新增客户失败！");
				}
			}
			return JsonResponse.success();
		} else {
			log.error("风控系统端同步仓库系统客户接口失败,参数传递错误！");
			return JsonResponse.fail("风控系统端同步仓库系统客户接口失败,参数传递错误！");
		}
	}

	/**
	 * 修改库存接口（同步仓库系统库存，增删改）
	 * 
	 * @param userId
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/updateStock")
	@ResponseBody
	public JsonResponse updateStock(String updatetype, String goods_list, HttpServletRequest request)
			throws ParseException {
		List<TabStock> goodsLlist = new ArrayList<TabStock>();
		log.info("Method updateStock params[updatetype:" + updatetype + ",goods_list:" + goods_list);
		try {
			JSONArray jsonArray = new JSONArray(goods_list);
			if (null != jsonArray && jsonArray.length() > 0) {
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					if (null != jsonObject) {
						TabStock bean = new TabStock();
						Integer customer_id = Integer.valueOf(jsonObject.get("customer_id").toString());
						Integer stock_id = Integer.valueOf(jsonObject.get("stock_id").toString());
						bean.setCustomer_id(customer_id);
						bean.setStock_id(stock_id);
						bean.setGood_name(jsonObject.get("good_name").toString());
						bean.setGood_level(Integer.valueOf(jsonObject.get("good_level").toString()));
						bean.setGood_size(jsonObject.get("good_size").toString());
						bean.setGood_place(jsonObject.get("good_place").toString());
						bean.setGood_volume(jsonObject.get("good_volume").toString());
						bean.setArea_name(jsonObject.get("area_name").toString());
						bean.setSpace_name(jsonObject.get("space_name").toString());
						bean.setGood_number(Integer.valueOf(jsonObject.get("good_number").toString()));
						bean.setLock_status(Integer.valueOf(jsonObject.get("lock_status").toString()));
						if (null != jsonObject.get("put_time") && !"".equals(jsonObject.get("put_time").toString())) {
							SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Long pt = Long.parseLong(jsonObject.get("put_time").toString());
							String time = fmt.format(pt);
							Date date = fmt.parse(time);
							bean.setPut_success_time(date);
						}
						bean.setBar_code(jsonObject.get("bar_code").toString());
						bean.setBusiness_pag_no(jsonObject.get("business_pag_no").toString());
						goodsLlist.add(bean);
					}
				}
			} else {
				log.error("风控系统端同步仓库系统库存失败，风控系统接收仓库的商品为空！");
			}
		} catch (JSONException e) {
			log.error("风控系统端同步仓库系统库存失败！" + e.getMessage());
			e.printStackTrace();
		}

		// 同步仓库系统库存到风控
		if (updatetype != null && null != goodsLlist && goodsLlist.size() > 0) {
			if (updatetype.equals("0")) { // 删除库存
				for (TabStock tabStock : goodsLlist) {
					Integer stock_id = tabStock.getStock_id();
					Integer customer_id = tabStock.getCustomer_id();

					// 以下判断删除库存删除库存备注时，同时计算预警信息，低于锁止线则发送短信
					AlertConfig a1 = new AlertConfig();
					AlertConfig a2 = new AlertConfig();
					AlertConfig a3 = new AlertConfig();
					Date now = new Date();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowtime = df.format(now);
					Double lock_line = new Double(0);
					float marketprice = 0;
					float plmarketprice = 0;
					try {
						try {
							tabStockService.deleteStock(stock_id);// 删除库存信息
							tabStockCommentService.delete(stock_id);// 删除备注库存信息
							log.info("风控系统端同步删除库存成功！");
						} catch (Exception e) {
							log.error("风控系统端同步删除库存出错！库存stock_id = " + stock_id);
							log.error(e.getMessage());
							e.printStackTrace();
						}
						TabCustomerModel tcsModel = new TabCustomerModel();
						tcsModel.setCustomer_id(customer_id);
						TabCustomer tcs = tabcustomerservice.queryBycustomerid(tcsModel);// 查询客户出库信息

						TabStockModel model = new TabStockModel();
						model.setCustomer_id(customer_id);
						List<TabStock> dataList2 = tabStockService.queryAllByList(model);// 获取出库后当前客户的库存信息
						for (TabStock ts : dataList2) {
							if (null == ts.getGood_volume()) {
								ts.setGood_volume("0");
							}
							if (null == ts.getMarket_prices()) {
								ts.setMarket_prices(new BigDecimal(0));
							}
							if (null == ts.getPledge_multiplier()) {
								ts.setPledge_multiplier(new BigDecimal(0));
							}
							marketprice += Float.parseFloat(ts.getGood_volume().toString())
									* Float.parseFloat(ts.getMarket_prices().toString());// 市场价格
							plmarketprice += Float.parseFloat(ts.getGood_volume().toString())
									* Float.parseFloat(ts.getMarket_prices().toString())// 市场折后价值
									* Float.parseFloat(ts.getPledge_multiplier().toString());
						}
						// 得到锁止线--判断锁止线,如果过期就取锁止线,没有过期就取临时锁止线
						if (null == tcs.getBorrow_balance()) {
							tcs.setBorrow_balance(new BigDecimal(0));// 借款金额
						}
						if (null == tcs.getGuarant_balance()) {
							tcs.setGuarant_balance(new BigDecimal(0));// 为他人担保金额
						}
						if (null == tcs.getRc_guarant_balance()) {
							tcs.setRc_guarant_balance(new BigDecimal(0));// 接受担保金额
						}
						lock_line = tcs.getBorrow_balance().add(tcs.getGuarant_balance())
								.subtract(tcs.getRc_guarant_balance()).doubleValue();
						if (null != tcs.getTemporary_lock_line() && !"".equals(tcs.getTemporary_lock_line())) {
							if (null != tcs.getStart_time() && !"".equals(tcs.getStart_time().toString())
									&& null != tcs.getEnd_time() && !"".equals(tcs.getEnd_time().toString())) {
								String stime = tcs.getStart_time().substring(0, 19);
								String etime = tcs.getEnd_time().substring(0, 19);
								if (nowtime.compareTo(stime) > 0) {
									if (nowtime.compareTo(etime) < 0) {
										lock_line = Double.parseDouble(tcs.getTemporary_lock_line().toString());
									}
								}
							}

						}
						// 是否促发短信

						SysUser user = SessionUtils.getUser(request);
						try {
							Map<String, Object> params = new HashMap<String, Object>();
							List<AlertConfig> dataList = alertConfigService.queryByAll(params);// 得到需要发送短信的配置文件，包括接收者，内容
							if (tcs.getCredit_limit() == null) {
								tcs.setCredit_limit(new BigDecimal(0));
							}

							for (AlertConfig ac : dataList) {
								if (ac.getId() == 1) {
									a1.setAlert_condition(ac.getAlert_condition());
									a1.setMsg_content(ac.getMsg_content());
									a1.setMsg_status(ac.getMsg_status());
									a1.setMsg_with(ac.getMsg_with());
									a1.setNotice_type(ac.getNotice_type());
									a1.setWcmr_tel(ac.getWcmr_tel());
								}
								if (ac.getId() == 2) {
									a2.setAlert_condition(ac.getAlert_condition());
									a2.setMsg_content(ac.getMsg_content());
									a2.setMsg_status(ac.getMsg_status());
									a2.setMsg_with(ac.getMsg_with());
									a2.setNotice_type(ac.getNotice_type());
									a2.setWcmr_tel(ac.getWcmr_tel());
								}
								if (ac.getId() == 3) {
									a3.setAlert_condition(ac.getAlert_condition());
									a3.setMsg_content(ac.getMsg_content());
									a3.setMsg_status(ac.getMsg_status());
									a3.setMsg_with(ac.getMsg_with());
									a3.setNotice_type(ac.getNotice_type());
									a3.setWcmr_tel(ac.getWcmr_tel());
								}
							}
							if (user == null) {
								user = sysUserService.queryById(1);
							}
							AlertDaily bean = new AlertDaily();

							// 市场价低于锁止线发送短信
							if (plmarketprice < lock_line) {
								if (a3.getMsg_status() == 1) {
									// SendMessage.sendSmsToClient("24657",
									// tcs.getTelephone(),
									// String.valueOf(tcs.getCustomer_name()));
									// SendMessage.SendMEssage(a3.getMsg_with(),
									// tcs.getTelephone());//客户
								}
								if (a3.getMsg_status() == 2) {
									sendMessage.sendSmsToClient("24657", a3.getWcmr_tel(),
											String.valueOf(tcs.getCustomer_name()) + "," + tcs.getTelephone());
								}

								if (a3.getMsg_status() == 3) {
									// new
									// SendMessage().SendMEssage(a2.getAlert_condition(),
									// telephone);
									sendMessage.sendSmsToClient("24657", a3.getWcmr_tel(),
											String.valueOf(tcs.getCustomer_name()) + "," + tcs.getTelephone());
									// SendMessage.sendSmsToClient("24657",
									// tcs.getTelephone(),
									// String.valueOf(tcs.getCustomer_name()));
									// SendMessage.SendMEssage(a3.getMsg_with(),
									// tcs.getTelephone());
								}
								bean.setAlert_content("客户:" + tcs.getCustomer_name() + "库存量过低，低于锁止线，请注意补充库存.");
								bean.setAlert_time(new Date());
								bean.setDeal_status(0);
								bean.setDeal_with(user.getUsr_name());
								this.recordMessage(bean);
							}
						} catch (Throwable e) {
							log.error("风控系统端发送预警短信失败！");
							e.printStackTrace();
						}
					} catch (Exception e) {
						log.error("操作异常", e);
						return JsonResponse.fail("出错");
					}
				}
				return JsonResponse.success();
			}
			if (updatetype.equals("1")) { // 新增库存
				try {
					for (TabStock tabStock : goodsLlist) {
						tabStockService.add(tabStock);
					}
					log.info("风控系统端同步新增库存成功！");
					return JsonResponse.success();
				} catch (Exception e) {
					log.error("风控系统端同步新增库存信息失败！");
					e.printStackTrace();
					return JsonResponse.fail("风控系统端同步新增库存信息失败！");
				}
			}
			return JsonResponse.success();
		} else {
			log.error("风控系统端更新库存出错！");
			return JsonResponse.fail("风控系统端更新库存出错！");
		}

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
		List<CustomerBean> lhmap = new ArrayList<CustomerBean>();

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
		if (StringUtil.isEmpty(data)) {
			log.error("风控系统端获取仓库接口的客户信息失败！url = " + url);
		}
		JSONObject jsonObject = new JSONObject(data);
		String resultText = jsonObject.get("resultText").toString();

		// JSONObject jsonObject_customer_list =
		// JSONObject.parseObject(resultText);
		JSONObject jsonObject_customer_list = new JSONObject(resultText);
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

			}
		}
		// 比较如果客户不存在则删除
		if (null != tcs && tcs.size() > 0 && lhmap.size() > 0) {
			Set<Integer> customer_id_set = new HashSet<Integer>(); // 仓库系统客户id的HashSet集合
			for (int i = 0; i < lhmap.size(); i++) {
				CustomerBean bean = lhmap.get(i);
				customer_id_set.add(bean.getCustomer_id());

				getInterFaceStockList(bean.getCustomer_id(), request);// 更新同步客户库存
			}
			for (TabCustomer tcu : tcs) {
				Integer customer_id = tcu.getCustomer_id();
				if (!customer_id_set.contains(customer_id)) {
					tabcustomerservice.delete(customer_id);
				}
				getInterFaceStockList(customer_id, request);// 更新同步客户库存
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
		List<TabStock> lhmap = new ArrayList<TabStock>();
		if (null == SessionUtils.getUser(request)) {
			usrid = 0;
		} else {
			usrid = SessionUtils.getUser(request).getId();
		}

		String url = getStockInfoInterface + "?usr_id=" + usrid + "&customer_id=" + customer_id;
		String data = sendPostRequest(url);
		if (StringUtil.isEmpty(data)) {
			log.error("风控系统端获取仓库客户的库存信息失败！url =" + url);
		}
		// JSONObject jsonObject = JSONObject.parseObject(data);
		JSONObject jsonObject = new JSONObject(data);
		String resultText = jsonObject.get("resultText").toString();

		// JSONObject jsonObject_customer_list =
		// JSONObject.parseObject(resultText);
		JSONObject jsonObject_customer_list = new JSONObject(resultText);
		String stock_list = jsonObject_customer_list.get("stock_list").toString();
		Gson gson = new Gson();
		List<TabStock> stockList = gson.fromJson(stock_list, new TypeToken<List<TabStock>>() {
		}.getType());
		lhmap = stockList;

		if (lhmap.size() > 0) {
			for (int i = 0; i < lhmap.size(); i++) {
				TabStock bean = lhmap.get(i);
				if (null != bean.getArea_name()) {
					tskModel.setArea_name(bean.getArea_name());
				}
				if (null != bean.getSpace_name()) {
					tskModel.setSpace_name(bean.getSpace_name());
				}
				if (null != bean.getGood_name()) {
					tskModel.setGood_name(bean.getGood_name());
				}
				if (null != bean.getGood_place() && !"".equals(bean.getGood_place())) {
					tskModel.setGood_place(bean.getGood_place());
				}
				if (!"".equals(bean.getGood_level())) {
					tskModel.setGood_level(bean.getGood_level());
				}
				if (null != bean.getGood_size() && !"".equals(bean.getGood_size())) {
					tskModel.setGood_size(bean.getGood_size());
				}
				if (null != bean.getGood_volume() && !"".equals(bean.getGood_volume())) {
					tskModel.setGood_volume(bean.getGood_volume());
				}
				if (null != bean.getGood_weight() && !"".equals(bean.getGood_weight())) {
					tskModel.setGood_weight(bean.getGood_weight());
				}
				/*
				 * if (null != bean.getLast_check_time() &&
				 * !"".equals(bean.getLast_check_time().toString())) {
				 * SimpleDateFormat fmt = new SimpleDateFormat(
				 * "yyyy-MM-dd HH:mm:ss"); Long ct =
				 * Long.parseLong(bean.getLast_check_time().toString()); String
				 * time = fmt.format(ct); tskModel.setCheck_time(time); }
				 */
				if (null != bean.getPut_time() && !"".equals(bean.getPut_time().toString())) {
					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long pt = Long.parseLong(bean.getPut_time().toString());
					String time = fmt.format(pt);
					Date date = fmt.parse(time);
					tskModel.setPut_success_time(date);
				}
				if (null != bean.getStock_id()) {
					tskModel.setStock_id(bean.getStock_id());
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
		// 比较如果本地库存表不存在，则删除
		tskList = tabStockService.queryAllByList(tskm);

		if (null != tskList && tskList.size() > 0 && lhmap.size() > 0) {
			Set<Integer> stock_id_set = new HashSet<Integer>(); // 仓库系统库存id的HashSet集合
			for (int i = 0; i < lhmap.size(); i++) {
				TabStock bean = lhmap.get(i);
				stock_id_set.add(bean.getStock_id());
			}
			for (TabStock stock : tskList) {
				Integer stock_id = stock.getStock_id();
				if (!stock_id_set.contains(stock_id)) {
					tabStockService.delete(stock_id);
				}
			}
		}
	}

	/**
	 * 仓库系统得到链金所调用,获得借款金额borrow_balance
	 * 
	 * @param userId
	 * @param request
	 * @return
	 * @TODO 目前接口是一个一个返回值，后期可以考虑批量返回值，本地的批量更新也可以暂时先做。
	 */
	@RequestMapping("getChainGold")
	public void getChainGold(HttpServletRequest request) {
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
						if (!"".equals(data)) {
							JSONObject jsonObject = new JSONObject(data);
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

	/**
	 * @param cutomerId
	 * @throws Exception
	 * @author wang_xiao_long
	 * @description 根据customer_id获取借款金额
	 */
	public void updateBorrowSumFromChainGold(Integer cutomerId) throws Exception {

		TabCustomerModel tabCustormerModel = new TabCustomerModel();
		tabCustormerModel.setCustomer_id(cutomerId);
		TabCustomer tabCutomer = tabcustomerservice.queryBycustomerid(tabCustormerModel);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_phone", tabCutomer.getTelephone());
		String param = Tools.assembleParams(paramMap);
		// 调用接口
		String data = HttpRequestUtil.sendPost(getChainGold, param);
		if (!StringUtil.isEmpty(data)) {
			com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(data);
			if (WebServiceConstant.CODE_SUCCESS == jsonObject.getIntValue("code")) {
				String borrow_balance = jsonObject.getString("total");
				tabCutomer.setBorrow_balance(new BigDecimal(borrow_balance));
				tabcustomerservice.update(tabCutomer);
			} else {
				tabCutomer.setBorrow_balance(new BigDecimal(0));
				tabcustomerservice.update(tabCutomer);
			}
		} else {
			ErrorDailyModel tb = new ErrorDailyModel();
			tb.setError_content("获取客户借款金额出错");
			tabcustomerservice.adderrordaily(tb);
			throw new RuntimeException("获取客户借款金额出错");
		}

	}

	/**
	 * 得到预警配置信息
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("getAlertMessage")
	@ResponseBody
	public JsonResponse getAlertMessage(HttpServletRequest request) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			;
			Map<String, Object> fiterMap = new HashMap<String, Object>();
			List<Map<String, Object>> resultText = new ArrayList<Map<String, Object>>();
			// params.put("startRow", 0);
			// params.put("rows", 10);
			List<AlertConfig> dataList = alertConfigService.queryByAll(params);
			for (AlertConfig ac : dataList) {
				fiterMap = new HashMap<String, Object>();
				fiterMap.put("alert_condition", ac.getAlert_condition());
				fiterMap.put("id", ac.getId());
				String[] tel = ac.getWcmr_tel().split(",");
				if (ac.getMsg_status() == 1) {
					fiterMap.put("received_type", "客户");
				}
				if (ac.getMsg_status() == 2) {
					fiterMap.put("received_type", "风控");
				}
				if (ac.getMsg_status().toString().equals("3")) {
					fiterMap.put("received_type", "客户/风控");
				}
				fiterMap.put("received_type_value", ac.getMsg_status().toString());

				fiterMap.put("risk_telephone", ac.getWcmr_tel());
				resultText.add(fiterMap);

			}

			return JsonResponse.success().put("alert_list", resultText);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取信息出错", e);
			return JsonResponse.fail("查询出错");
		}
	}

	/**
	 * 记录发送短信信息
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	public void recordMessage(AlertDaily bean) {
		try {
			alertDailyService.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
