package com.yiya.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.bean.AntiFraudReportList;
import com.yiya.bean.BlacklistReportList;
import com.yiya.bean.Bondsmaninf;
import com.yiya.bean.OrderBean;
import com.yiya.bean.ScoreBean;
import com.yiya.bean.ScoreReport;
import com.yiya.bean.ScoreReportList;
import com.yiya.bean.ScoringReportBondsmaninf;
import com.yiya.bean.SysUser;
import com.yiya.bean.TabAreaBean;
import com.yiya.service.OrderService;
import com.yiya.service.ScoreService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.SessionUtils;

/**
 * 风控评分控制类
 * @author lifaqiu
 * @date 2016-11-11
 */
@Controller
@RequestMapping("/score") 
public class ScoreAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(ScoreAction.class);
	
	@Autowired
	private ScoreService<ScoreBean> scoreService;
	@Autowired(required = false)
	private OrderService<OrderBean> orderService;
	
	/**
	 * 反欺诈验证接口
	 * @param usrid
	 * @param mobile_phone
	 * @param id_no
	 * @param bank_no
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/anti_fraud_verification") 
	public void anti_fraud_verification(Integer rule_set_id,Integer usrid, String mobile_phone, String id_no, String bank_no, String real_name, HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if (rule_set_id == null) {
			rule_set_id = 0;
		}
		if (usrid == null) {
			jsonMap.put("code", -2);
			jsonMap.put("msg", "平台统一usrid(必填)");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		
		if (mobile_phone != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("mobile_phone", mobile_phone);
			param.put("is_active", 1);
			List<Map<String, Object>> dataList = scoreService.findBlacklistValue(param);
			if (dataList != null && dataList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				StringBuffer temp = new StringBuffer();
				for (Map<String, Object> map : dataList) {
					String blacklist_type = map.containsKey("blacklist_type") ? map.get("blacklist_type").toString() : "";
					String blacklist_value = map.containsKey("blacklist_value") ? map.get("blacklist_value").toString() : "";
					temp.append(blacklist_type).append(":").append(blacklist_value);
					temp.append(",");
				}
				String str = temp.toString();
				str = str.substring(0, str.length() - 1);
				sb.append("(").append(str).append(")");
				sb.append("在黑名单中");
				
				jsonMap.put("code", 0);
				jsonMap.put("msg", sb.toString());
				HtmlUtil.writerJson(response, jsonMap);
				return ;
			}
		}
		if (id_no != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id_no", id_no);
			param.put("is_active", 1);
			List<Map<String, Object>> dataList = scoreService.findBlacklistValue(param);
			if (dataList != null && dataList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				StringBuffer temp = new StringBuffer();
				for (Map<String, Object> map : dataList) {
					String blacklist_type = map.containsKey("blacklist_type") ? map.get("blacklist_type").toString() : "";
					String blacklist_value = map.containsKey("blacklist_value") ? map.get("blacklist_value").toString() : "";
					temp.append(blacklist_type).append(":").append(blacklist_value);
					temp.append(",");
				}
				String str = temp.toString();
				str = str.substring(0, str.length() - 1);
				sb.append("(").append(str).append(")");
				sb.append("在黑名单中");
				
				jsonMap.put("code", 0);
				jsonMap.put("msg", sb.toString());
				HtmlUtil.writerJson(response, jsonMap);
				return ;
			}
		}
		if (bank_no != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("bank_no", bank_no);
			param.put("is_active", 1);
			List<Map<String, Object>> dataList = scoreService.findBlacklistValue(param);
			if (dataList != null && dataList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				StringBuffer temp = new StringBuffer();
				for (Map<String, Object> map : dataList) {
					String blacklist_type = map.containsKey("blacklist_type") ? map.get("blacklist_type").toString() : "";
					String blacklist_value = map.containsKey("blacklist_value") ? map.get("blacklist_value").toString() : "";
					temp.append(blacklist_type).append(":").append(blacklist_value);
					temp.append(",");
				}
				String str = temp.toString();
				str = str.substring(0, str.length() - 1);
				sb.append("(").append(str).append(")");
				sb.append("在黑名单中");
				
				jsonMap.put("code", 0);
				jsonMap.put("msg", sb.toString());
				HtmlUtil.writerJson(response, jsonMap);
				return ;
			}
		}
		if (real_name != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("real_name", real_name);
			param.put("is_active", 1);
			List<Map<String, Object>> dataList = scoreService.findBlacklistValue(param);
			if (dataList != null && dataList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				StringBuffer temp = new StringBuffer();
				for (Map<String, Object> map : dataList) {
					String blacklist_type = map.containsKey("blacklist_type") ? map.get("blacklist_type").toString() : "";
					String blacklist_value = map.containsKey("blacklist_value") ? map.get("blacklist_value").toString() : "";
					temp.append(blacklist_type).append(":").append(blacklist_value);
					temp.append(",");
				}
				String str = temp.toString();
				str = str.substring(0, str.length() - 1);
				sb.append("(").append(str).append(")");
				sb.append("在黑名单中");
				
				jsonMap.put("code", 0);
				jsonMap.put("msg", sb.toString());
				HtmlUtil.writerJson(response, jsonMap);
				return ;
			}
		}
		int anti_fraud_rule_id = 0;
		String rule_name = null;
		boolean is_hit = false;
		// 查询出所有反欺诈规则
		List<Map<String, Object>> antiFraudRuleList = scoreService.getAntiFraudRuleList(rule_set_id);
		if (antiFraudRuleList != null && antiFraudRuleList.size() > 0) {
			for (Map<String, Object> map : antiFraudRuleList) {
				anti_fraud_rule_id = Integer.parseInt(map.get("anti_fraud_rule_id").toString());
				rule_name = map.containsKey("rule_name") ? map.get("rule_name").toString():"";
				// 查找出反欺诈模型value
				List<Map<String, Object>> antiFraudValueList = scoreService.getAntiFraudValueList(anti_fraud_rule_id);
				if (antiFraudValueList != null && antiFraudValueList.size() > 0) {
					boolean is_first = true;
					List<Boolean> resultBoolean = new ArrayList<Boolean>();
					for (Map<String, Object> map2 : antiFraudValueList) {
						boolean flag = false;
						// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
						int field_value_type = Integer.parseInt(map2.get("field_value_type").toString());
						// 命中值
						String hit_value = map2.containsKey("hit_value") ? map2.get("hit_value").toString() : "";
						//1:大于,2:大于等于,3:等于,4:小于,5:小于等于，6：不等于
						int hit_condition = Integer.parseInt(map2.get("hit_condition").toString());
						
						int scoring_field_id = Integer.parseInt(map2.get("scoring_field_id").toString());
						//根据scoring_field_id在scoring_gather_field_map找出gather_field_id和gather_type_id
						Map<String, Object> scoringGatherFieldMap = scoreService.findScoringGatherFieldMap(scoring_field_id);
						if (scoringGatherFieldMap != null) {
							int gather_field_id = Integer.parseInt(scoringGatherFieldMap.get("gather_field_id").toString());
							Map<String, Object> paramMap = new HashMap<String, Object>();
							paramMap.put("gather_field_id", gather_field_id);
							paramMap.put("usrid", usrid);
							Map<String, Object> gatherValue = scoreService.findGatherValue(paramMap);
							if (gatherValue != null) {
								String gather_field_value = gatherValue.containsKey("gather_field_value") ? gatherValue.get("gather_field_value").toString() : "";
								// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
								switch (field_value_type) {
								case 0:
									if (gather_field_value.equals(hit_value)) {
										flag = true;
									}
									break;
								case 1:
									try {
										int hit_value_i = Integer.parseInt(hit_value);
										int gather_field_value_i = Integer.parseInt(gather_field_value);
										//1:大于,2:大于等于,3:等于,4:小于,5:小于等于
										if (hit_condition == 1) {
											if (gather_field_value_i > hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 2) {
											if (gather_field_value_i >= hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 3) {
											if (gather_field_value_i == hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 4) {
											if (gather_field_value_i < hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 5) {
											if (gather_field_value_i <= hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 6) {
											if (gather_field_value_i != hit_value_i) {
												flag = true;
											}
										}
									} catch (Exception e) {
										flag = false;
									}
									break;
								case 2:
									try {
										float hit_value_f = Float.parseFloat(hit_value);
										float gather_field_value_f = Float.parseFloat(gather_field_value);
										BigDecimal b1 = new BigDecimal(hit_value_f);  
										BigDecimal b2 = new BigDecimal(gather_field_value_f);  
										hit_value_f = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
										gather_field_value_f = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
										//1:大于,2:大于等于,3:等于,4:小于,5:小于等于
										if (hit_condition == 1) {
											if (gather_field_value_f > hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 2) {
											if (gather_field_value_f >= hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 3) {
											if (gather_field_value_f == hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 4) {
											if (gather_field_value_f < hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 5) {
											if (gather_field_value_f <= hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 6) {
											if (gather_field_value_f != hit_value_f) {
												flag = true;
											}
										}
									} catch (Exception e) {
										flag = false;
									}
									break;
								case 3:
									if (gather_field_value.equals(hit_value)) {
										flag = true;
									}
									break;

								default:
									break;
								}
							}
						}
						resultBoolean.add(flag);
						if (!is_first) {
							//联合条件，枚举类型（1与和2或），同一个规则下多个条件做联合查询
							try {
								int unite_value = Integer.parseInt(map2.get("unite_value").toString());
								if (unite_value == 1) {
									for (int i = 0; i < resultBoolean.size(); i++) {
										if (!resultBoolean.get(i)) {
											resultBoolean.clear();
											resultBoolean.add(false);
											break;
										}
									}
								}else if(unite_value == 2) {
									for (int i = 0; i < resultBoolean.size(); i++) {
										if (resultBoolean.get(i)) {
											resultBoolean.clear();
											resultBoolean.add(true);
											break;
										}
									}
								}else {
									resultBoolean.clear();
									resultBoolean.add(false);
								}
							} catch (Exception e) {
								resultBoolean.clear();
								resultBoolean.add(false);
							}
						}
						is_first = false;
					}
					if (resultBoolean.get(0)) {
						is_hit = true;
						break;
					}
				}
			}
		}
		if (is_hit) {
			jsonMap.put("code", 0);
			jsonMap.put("msg", "反欺诈规则名称" + rule_name + "(" + anti_fraud_rule_id + ")");
		}else {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "未命中");
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 4.1.29 生成评分报告
	 * @param usrid
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/create_score_report") 
	public void create_score_report(String store_type_name,String order_sn,Integer usr_order_id,Integer usrid, Integer rule_set_id, Integer add_usr_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.debug("==================开始生成评分报告===================");
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if (add_usr_id == null) {
			SysUser user2 = SessionUtils.getUser(request);
			if (user2 != null) {
				add_usr_id = user2.getId();
			}else {
				add_usr_id = 0;
			}
		}
		if (store_type_name == null) {
			store_type_name = "";
		}
		if (order_sn == null) {
			order_sn = "";
		}
		if (usr_order_id == null) {
			usr_order_id = 0;
		}
		if (usrid == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "平台统一usrid(必填)");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		
		if (rule_set_id == null || rule_set_id == 0) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "订单没有选择规则集");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		
		/**
		 * 处理反欺诈和黑名单
		 */
		Map<String, String> userMap = scoreService.findUserInfo(usrid);
		if (userMap == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "用户不存在");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ScoreReport scoreReport = null;
		try {
			// 生成规则集报告
			scoreReport = dealRole(rule_set_id, add_usr_id, usrid,order_sn,store_type_name,usr_order_id);
		} catch (Exception e) {
			log.debug("生成规则集报告出错：" + e.getMessage());
		}

		// 生成反欺诈和黑名单报告
		scoreReport = dealBackUser(rule_set_id,userMap, scoreReport, usrid, add_usr_id,order_sn,store_type_name,usr_order_id);
		if (scoreReport == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "生成报告失败");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (!"".equals(order_sn)) {
			orderService.updateOrderHaveScoringReport(order_sn);
		}
		log.debug("==================结束生成评分报告===================");
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	private ScoreReport dealRole(Integer rule_set_id, int add_usr_id, int usrid,String order_sn,String store_type_name,int usr_order_id) throws Exception {
		// 根据规则集名称查找所有评分模型规则定义
		List<Map<String, Object>> ruleList = scoreService.findAllRules(rule_set_id);
		if (ruleList == null || ruleList.isEmpty()) {
			
			return null;
		}
		
		List<Map<String, Object>> reportList = new ArrayList<Map<String,Object>>();
//		log.debug("ruleList=" + JSONUtil.toJSONString(ruleList));
		float sum_score = 0.00f;
		// 循环所有评分模型规则定义
		for (Map<String, Object> ruleMap : ruleList) {
			int scoring_rule_id = ruleMap.containsKey("scoring_rule_id")?Integer.parseInt(ruleMap.get("scoring_rule_id").toString()):0;
			String rule_code = ruleMap.containsKey("rule_code")?ruleMap.get("rule_code").toString():"";
			String rule_name = ruleMap.containsKey("rule_name")?ruleMap.get("rule_name").toString():"";
			String rule_desc = ruleMap.containsKey("rule_desc")?ruleMap.get("rule_desc").toString():"";
			String rule_type_id = ruleMap.containsKey("rule_type_id")?ruleMap.get("rule_type_id").toString():"0";
			
			Map<String, Object> reportMap = new HashMap<String, Object>();
			reportMap.put("scoring_rule_id", scoring_rule_id);
			reportMap.put("scoring_rule_code", rule_code);
			reportMap.put("scoring_rule_name", rule_name);
			reportMap.put("scoring_rule_desc", rule_desc);
			reportMap.put("rule_type_id", rule_type_id);
			reportMap.put("flag", false);

			float score_value = ruleMap.containsKey("score_value")?Float.parseFloat(ruleMap.get("score_value").toString()):0.00f;
			BigDecimal bigDecimal = new BigDecimal(score_value);
			bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			score_value = bigDecimal.floatValue();
			if (score_value == 0 || score_value == 0.00f) {
				float score_model_value = get_model_score(scoring_rule_id, usrid, reportMap);
				BigDecimal bg = new BigDecimal(score_model_value);
				bg = bg.setScale(2, BigDecimal.ROUND_HALF_UP);
				score_model_value = bg.floatValue();
				sum_score += score_model_value;
			}else {
				boolean is_get_score = is_get_score(scoring_rule_id, usrid, reportMap);
				if (is_get_score) {
					reportMap.put("flag", is_get_score);
					BigDecimal bd = new BigDecimal(score_value);
					bd.setScale(2, BigDecimal.ROUND_HALF_UP);
					reportMap.put("score", bd.toString());
					sum_score += score_value;
				}
			}
			
			reportList.add(reportMap);
		}
		
		return createReport(rule_set_id, usrid, add_usr_id, sum_score, reportList, order_sn, store_type_name, usr_order_id);
	}

	private ScoreReport dealBackUser(int rule_set_id,Map<String, String> userMap, ScoreReport scoreReport, Integer usrid, int add_usr_id,String order_sn,String store_type_name,int usr_order_id) {
		Date create_time = null;
		if (scoreReport == null) {
			create_time = new Date();
			scoreReport = scoreService.findUserScore(usr_order_id);
			if (scoreReport == null) {
				scoreReport = new ScoreReport();
			}
			scoreReport.setUsr_order_id(usr_order_id);
			scoreReport.setOrder_sn(order_sn);
			scoreReport.setStore_type_name(store_type_name);
			scoreReport.setAdd_usr_id(add_usr_id);
			scoreReport.setCreate_time(create_time);
			scoreReport.setSum_score(new BigDecimal(0.00));
			scoreReport.setUsrid(usrid);
			scoreReport.setScoring_quota(new BigDecimal(0.00));
			scoreReport.setReport_id(null);
			String register_place = scoreReport.getRegister_place();
			String register_place_ = "";
			if (register_place != null && !"0".equals(register_place)) {
				TabAreaBean tabAreaBean = scoreService.findTabAreaBeanByAreaId(Integer.parseInt(register_place));
				while (tabAreaBean != null) {
					String area_name = tabAreaBean.getArea_name();
					if (area_name != null) {
						register_place_ = area_name + register_place_;
					}
					Integer area_parent_id = tabAreaBean.getArea_parent_id();
					if (area_parent_id != null && area_parent_id != 0) {
						tabAreaBean = scoreService.findTabAreaBeanByAreaId(area_parent_id);
					}else {
						tabAreaBean = null;
					}
				}
			}
			scoreReport.setRegister_place_(register_place_);
			
			try {
				scoreService.addScoreReport(scoreReport);
			} catch (Exception e) {
				log.debug("生成评分报告出错 " + e.getMessage());
				return null;
			}
			// 评分报告担保人
			List<Bondsmaninf> bondsmaninfs = scoreService.findBondsmaninfList(usr_order_id);
			if (bondsmaninfs != null && !bondsmaninfs.isEmpty()) {
				List<ScoringReportBondsmaninf> scoringReportBondsmaninfs = new ArrayList<ScoringReportBondsmaninf>();
				for (Bondsmaninf bondsmaninf : bondsmaninfs) {
					ScoringReportBondsmaninf scoringReportBondsmaninf = new ScoringReportBondsmaninf();
					scoringReportBondsmaninf.setRel_mobile_phone(bondsmaninf.getRel_mobile_phone());
					scoringReportBondsmaninf.setRel_usrname(bondsmaninf.getRel_usrname());
					scoringReportBondsmaninf.setRelation(bondsmaninf.getRelation_());
					scoringReportBondsmaninf.setReport_id(scoreReport.getReport_id());
					scoringReportBondsmaninfs.add(scoringReportBondsmaninf);
				}
				scoreService.addScoringReportBondsmaninf(scoringReportBondsmaninfs);
			}
		}
		create_time = scoreReport.getCreate_time();
		int report_id = scoreReport.getReport_id();
		
		String mobile_phone = userMap.containsKey("mobile_phone")?userMap.get("mobile_phone"):null;
		String id_no = userMap.containsKey("id_card")?userMap.get("id_card"):null;
		String bank_no = userMap.containsKey("bank_id")?userMap.get("bank_id"):null;
		String real_name = userMap.containsKey("usrname")?userMap.get("usrname"):null;
		String mobile_imei = userMap.containsKey("mobile_imei")?userMap.get("mobile_imei"):null;
		String mobile_idfa = userMap.containsKey("mobile_idfa")?userMap.get("mobile_idfa"):null;
		
		List<BlacklistReportList> blacklistReportLists = new ArrayList<BlacklistReportList>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		if (mobile_imei != null || mobile_idfa != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("mobile_imei", mobile_imei);
			param.put("mobile_idfa", mobile_idfa);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "设备ID");
				String blacklist_value = null;
				boolean flag = false;
				if (mobile_imei != null) {
					flag = true;
					blacklist_value = mobile_imei;
				}
				if (mobile_idfa != null) {
					if (flag) {
						blacklist_value = blacklist_value + " | " + mobile_idfa;
					}else {
						blacklist_value = mobile_idfa;
					}
				}
				map.put("blacklist_value", blacklist_value);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (usrid != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("usrid", usrid);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "申请授信商户ID");
				map.put("blacklist_value", usrid);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (mobile_phone != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("mobile_phone", mobile_phone);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "手机号码");
				map.put("blacklist_value", mobile_phone);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (id_no != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id_no", id_no);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "身份证信息");
				map.put("blacklist_value", id_no);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (bank_no != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("bank_no", bank_no);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "银行卡号");
				map.put("blacklist_value", bank_no);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (real_name != null) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("real_name", real_name);
			param.put("is_active", 1);
			List<Map<String, Object>> tempList = scoreService.findBlacklistValue(param);
			if (tempList != null && tempList.size() > 0) {
				for (Map<String, Object> map : tempList) {
					map.put("is_hit", "1");
				}
			}else {
				tempList = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("is_hit", "0");
				map.put("blacklist_type", "姓名");
				map.put("blacklist_value", real_name);
				tempList.add(map);
			}
			dataList.addAll(tempList);
		}
		if (dataList != null && dataList.size() > 0) {
			for (Map<String, Object> map : dataList) {
				String blacklist_type = map.containsKey("blacklist_type") ? map.get("blacklist_type").toString() : "";
				String blacklist_value = map.containsKey("blacklist_value") ? map.get("blacklist_value").toString() : "";
				String is_hit = map.containsKey("is_hit") ? map.get("is_hit").toString() : "0";
				
				BlacklistReportList blacklistReportList = new BlacklistReportList();
				blacklistReportList.setBlacklist_type(blacklist_type);
				blacklistReportList.setBlacklist_value(blacklist_value);
				blacklistReportList.setReport_id(report_id);
				blacklistReportList.setIs_hit(Integer.parseInt(is_hit));
				blacklistReportLists.add(blacklistReportList);
			}
			try {
				scoreService.addBlacklistReportLists(blacklistReportLists);
			} catch (Exception e) {
				log.debug("增加黑名单报告出错: " + e.getMessage());
			}
		}
		
		List<AntiFraudReportList> antiFraudReportLists = new ArrayList<AntiFraudReportList>();
		
		// 查询出所有反欺诈规则
		List<Map<String, Object>> antiFraudRuleList = scoreService.getAntiFraudRuleList(rule_set_id);
		if (antiFraudRuleList != null && antiFraudRuleList.size() > 0) {
			for (Map<String, Object> map : antiFraudRuleList) {
				int anti_fraud_rule_id = Integer.parseInt(map.get("anti_fraud_rule_id").toString());
				String anti_fraud_rule_name = map.containsKey("rule_name") ? map.get("rule_name").toString():"";
				String anti_fraud_rule_code = map.containsKey("rule_code") ? map.get("rule_code").toString():"";
				String anti_fraud_rule_desc = map.containsKey("rule_desc") ? map.get("rule_desc").toString():"";
				
				int scoring_field_id = 0;
				String scoring_field_name = null;
				String scoring_field_name_ch = null;
				String scoring_field_desc = null;
				
				String gather_field_value = null;
				String gather_field_remark = null;
				String gather_type_name = null;
				
				// 查找出反欺诈模型value
				List<Map<String, Object>> antiFraudValueList = scoreService.getAntiFraudValueList(anti_fraud_rule_id);
				if (antiFraudValueList != null && antiFraudValueList.size() > 0) {
					boolean is_first = true;
					List<Boolean> resultBoolean = new ArrayList<Boolean>();
					for (Map<String, Object> map2 : antiFraudValueList) {
						boolean flag = false;
						// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
						int field_value_type = Integer.parseInt(map2.get("field_value_type").toString());
						// 命中值
						String hit_value = map2.containsKey("hit_value") ? map2.get("hit_value").toString() : "";
						//1:大于,2:大于等于,3:等于,4:小于,5:小于等于，6：不等于
						int hit_condition = Integer.parseInt(map2.get("hit_condition").toString());
						
						scoring_field_id = Integer.parseInt(map2.get("scoring_field_id").toString());
						scoring_field_name = map2.containsKey("scoring_field_name") ? map2.get("scoring_field_name").toString():"";
						scoring_field_name_ch = map2.containsKey("scoring_field_name_ch") ? map2.get("scoring_field_name_ch").toString():"";
						scoring_field_desc = map2.containsKey("scoring_field_desc") ? map2.get("scoring_field_desc").toString():"";
						
						//根据scoring_field_id在scoring_gather_field_map找出gather_field_id和gather_type_id
						Map<String, Object> scoringGatherFieldMap = scoreService.findScoringGatherFieldMap(scoring_field_id);
						if (scoringGatherFieldMap != null) {
							int gather_field_id = Integer.parseInt(scoringGatherFieldMap.get("gather_field_id").toString());
							Map<String, Object> paramMap = new HashMap<String, Object>();
							paramMap.put("gather_field_id", gather_field_id);
							paramMap.put("usrid", usrid);
							Map<String, Object> gatherValue = scoreService.findGatherValue(paramMap);
							if (gatherValue != null) {
								gather_field_value = gatherValue.containsKey("gather_field_value") ? gatherValue.get("gather_field_value").toString() : "";
								gather_field_remark = gatherValue.containsKey("gather_field_remark") ? gatherValue.get("gather_field_remark").toString() : "";
								gather_type_name = gatherValue.containsKey("gather_type_name") ? gatherValue.get("gather_type_name").toString() : "";
								// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
								switch (field_value_type) {
								case 0:
									if (gather_field_value.equals(hit_value)) {
										flag = true;
									}
									break;
								case 1:
									try {
										int hit_value_i = Integer.parseInt(hit_value);
										int gather_field_value_i = Integer.parseInt(gather_field_value);
										//1:大于,2:大于等于,3:等于,4:小于,5:小于等于
										if (hit_condition == 1) {
											if (gather_field_value_i > hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 2) {
											if (gather_field_value_i >= hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 3) {
											if (gather_field_value_i == hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 4) {
											if (gather_field_value_i < hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 5) {
											if (gather_field_value_i <= hit_value_i) {
												flag = true;
											}
										}else if (hit_condition == 6) {
											if (gather_field_value_i != hit_value_i) {
												flag = true;
											}
										}
									} catch (Exception e) {
										flag = false;
									}
									break;
								case 2:
									try {
										float hit_value_f = Float.parseFloat(hit_value);
										float gather_field_value_f = Float.parseFloat(gather_field_value);
										BigDecimal b1 = new BigDecimal(hit_value_f);  
										BigDecimal b2 = new BigDecimal(gather_field_value_f);  
										hit_value_f = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
										gather_field_value_f = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
										//1:大于,2:大于等于,3:等于,4:小于,5:小于等于
										if (hit_condition == 1) {
											if (gather_field_value_f > hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 2) {
											if (gather_field_value_f >= hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 3) {
											if (gather_field_value_f == hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 4) {
											if (gather_field_value_f < hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 5) {
											if (gather_field_value_f <= hit_value_f) {
												flag = true;
											}
										}else if (hit_condition == 6) {
											if (gather_field_value_f != hit_value_f) {
												flag = true;
											}
										}
									} catch (Exception e) {
										flag = false;
									}
									break;
								case 3:
									if (gather_field_value.equals(hit_value)) {
										flag = true;
									}
									break;

								default:
									break;
								}
							}
						}
						resultBoolean.add(flag);
						if (!is_first) {
							//联合条件，枚举类型（1与和2或），同一个规则下多个条件做联合查询
							try {
								int unite_value = Integer.parseInt(map2.get("unite_value").toString());
								if (unite_value == 1) {
									for (int i = 0; i < resultBoolean.size(); i++) {
										if (!resultBoolean.get(i)) {
											resultBoolean.clear();
											resultBoolean.add(false);
											break;
										}
									}
								}else if(unite_value == 2) {
									for (int i = 0; i < resultBoolean.size(); i++) {
										if (resultBoolean.get(i)) {
											resultBoolean.clear();
											resultBoolean.add(true);
											break;
										}
									}
								}else {
									resultBoolean.clear();
									resultBoolean.add(false);
								}
							} catch (Exception e) {
								resultBoolean.clear();
								resultBoolean.add(false);
							}
						}
						is_first = false;
					}
					AntiFraudReportList antiFraudReportList = new AntiFraudReportList();
					if (resultBoolean.get(0)) {
						antiFraudReportList.setIs_hit(1);
					}else {
						antiFraudReportList.setIs_hit(0);
					}
					antiFraudReportList.setScoring_field_desc(scoring_field_desc);
					antiFraudReportList.setScoring_field_id(scoring_field_id);
					antiFraudReportList.setScoring_field_name(scoring_field_name);
					antiFraudReportList.setScoring_field_name_ch(scoring_field_name_ch);
					antiFraudReportList.setAnti_fraud_rule_code(anti_fraud_rule_code);
					antiFraudReportList.setAnti_fraud_rule_desc(anti_fraud_rule_desc);
					antiFraudReportList.setAnti_fraud_rule_id(anti_fraud_rule_id);
					antiFraudReportList.setAnti_fraud_rule_name(anti_fraud_rule_name);
					antiFraudReportList.setCreate_time(create_time);
					antiFraudReportList.setGather_field_remark(gather_field_remark);
					antiFraudReportList.setGather_field_value(gather_field_value);
					antiFraudReportList.setReport_id(report_id);
					antiFraudReportList.setGather_type_name(gather_type_name);
					antiFraudReportLists.add(antiFraudReportList);
				}
			}
		}
		if (antiFraudReportLists.size() > 0) {
			scoreService.addAntiFraudReportLists(antiFraudReportLists);
		}
		
		return scoreReport;
	}

	/**
	 * 4.1.16评分接口
	 * @param usrid
	 * @param rule_set_id
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/get_score")
	public void get_score(Integer usrid, Integer rule_set_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		if (usrid == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "平台统一usrid(必填)");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		if (rule_set_id == null) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "规则集id(必填)");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		// 根据规则集名称查找所有评分模型规则定义
		List<Map<String, Object>> ruleList = scoreService.findAllRules(rule_set_id);
		if (ruleList == null || ruleList.isEmpty()) {
			jsonMap.put("code", -1);
			jsonMap.put("msg", "根据规则集id（" + rule_set_id + "）查询不到评分模型规则定义");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		
		List<Map<String, Object>> reportList = new ArrayList<Map<String,Object>>();
		
		float sum_score = 0.00f;
//		log.debug("ruleList=" + JSONUtil.toJSONString(ruleList));
		// 循环所有评分模型规则定义
		for (Map<String, Object> ruleMap : ruleList) {
			int scoring_rule_id = ruleMap.containsKey("scoring_rule_id")?Integer.parseInt(ruleMap.get("scoring_rule_id").toString()):0;
			String rule_code = ruleMap.containsKey("rule_code")?ruleMap.get("rule_code").toString():"";
			String rule_name = ruleMap.containsKey("rule_name")?ruleMap.get("rule_name").toString():"";
			String rule_desc = ruleMap.containsKey("rule_desc")?ruleMap.get("rule_desc").toString():"";
			
			Map<String, Object> reportMap = new HashMap<String, Object>();
			reportMap.put("scoring_rule_id", scoring_rule_id);
			reportMap.put("scoring_rule_code", rule_code);
			reportMap.put("scoring_rule_name", rule_name);
			reportMap.put("scoring_rule_desc", rule_desc);
			
			float score_value = ruleMap.containsKey("score_value")?Float.parseFloat(ruleMap.get("score_value").toString()):0.00f;
			BigDecimal bigDecimal = new BigDecimal(score_value);
			bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			score_value = bigDecimal.floatValue();
			if (score_value == 0 || score_value == 0.00f) {
				float score_model_value = get_model_score(scoring_rule_id, usrid, reportMap);
				BigDecimal bg = new BigDecimal(score_model_value);
				bg = bg.setScale(2, BigDecimal.ROUND_HALF_UP);
				score_model_value = bg.floatValue();
				sum_score += score_model_value;
			}else {
				boolean is_get_score = is_get_score(scoring_rule_id, usrid, reportMap);
				if (is_get_score) {
					reportMap.put("flag", is_get_score);
					BigDecimal bd = new BigDecimal(score_value);
					bd.setScale(2, BigDecimal.ROUND_HALF_UP);
					reportMap.put("score", bd.toString());
					sum_score += score_value;
				}
			}
			
			reportList.add(reportMap);
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rule_set_id", rule_set_id);
		paramMap.put("sum_score", sum_score);
		Map<String, Object> quotaMap = scoreService.findQuota(paramMap);
		String quota_min_amount = "0.00";
		String quota_max_amount = "0.00";
		if (quotaMap != null) {
			quota_min_amount = quotaMap.get("min_quota").toString();
			quota_max_amount = quotaMap.get("max_quota").toString();
		}
		jsonMap.put("code", 0);
		jsonMap.put("sum_score", sum_score);
		jsonMap.put("quota_min_amount", quota_min_amount);
		jsonMap.put("quota_max_amount", quota_max_amount);
		jsonMap.put("msg", "");
		
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 生成用户评分报告
	 * @param usrid
	 * @param reportList
	 * @throws JSONException 
	 */
	private ScoreReport createReport(int rule_set_id, int usrid, int add_usr_id, float sum_score, List<Map<String, Object>> reportList,String order_sn,String store_type_name,int usr_order_id) throws Exception{
		String rule_set_name = scoreService.findRuleSetName(rule_set_id);
//		log.debug("ruleList=" + JSONUtil.toJSONString(reportList));
		if (rule_set_name == null) {
			rule_set_name = "";
		}
		Date create_time = new Date();
		ScoreReport scoreReport = scoreService.findUserScore(usr_order_id);
		if (scoreReport == null) {
			scoreReport = new ScoreReport();
		}
		scoreReport.setUsr_order_id(usr_order_id);
		scoreReport.setOrder_sn(order_sn);
		scoreReport.setStore_type_name(store_type_name);
		scoreReport.setAdd_usr_id(add_usr_id);
		scoreReport.setCreate_time(create_time);
		scoreReport.setSum_score(new BigDecimal(sum_score));
		scoreReport.setUsrid(usrid);
		scoreReport.setReport_id(null);
		String register_place = scoreReport.getRegister_place();
		String register_place_ = "";
		if (register_place != null && !"0".equals(register_place)) {
			TabAreaBean tabAreaBean = scoreService.findTabAreaBeanByAreaId(Integer.parseInt(register_place));
			while (tabAreaBean != null) {
				String area_name = tabAreaBean.getArea_name();
				if (area_name != null) {
					register_place_ = area_name + register_place_;
				}
				Integer area_parent_id = tabAreaBean.getArea_parent_id();
				if (area_parent_id != null && area_parent_id != 0) {
					tabAreaBean = scoreService.findTabAreaBeanByAreaId(area_parent_id);
				}else {
					tabAreaBean = null;
				}
			}
		}
		scoreReport.setRegister_place_(register_place_);
		
		BigDecimal scoring_quota = null;
		Map<String, Object> quotaMap = scoreService.findScoreQuotaMap(sum_score);
		if (quotaMap != null) {
			try {
				BigDecimal min_quota = quotaMap.containsKey("min_quota")?new BigDecimal(quotaMap.get("min_quota").toString()):new BigDecimal(0.00);
				BigDecimal max_quota = quotaMap.containsKey("max_quota")?new BigDecimal(quotaMap.get("max_quota").toString()):new BigDecimal(0.00);
				scoring_quota = min_quota.add(max_quota);
				scoring_quota = scoring_quota.divide(new BigDecimal(2));
				scoring_quota = scoring_quota.setScale(2, BigDecimal.ROUND_HALF_UP);
			} catch (Exception e) {
				scoring_quota = new BigDecimal(0.00);
			}
		}else {
			scoring_quota = new BigDecimal(0.00);
		}
		scoreReport.setScoring_quota(scoring_quota);
		try {
			scoreService.addScoreReport(scoreReport);
		} catch (Exception e) {
			log.debug("生成评分报告出错 " + e.getMessage());
			return null;
		}
		if (scoreReport.getReport_id() != null && reportList.size() > 0) {
			int report_id = scoreReport.getReport_id();
			// 评分报告担保人
			List<Bondsmaninf> bondsmaninfs = scoreService.findBondsmaninfList(usr_order_id);
			if (bondsmaninfs != null && !bondsmaninfs.isEmpty()) {
				List<ScoringReportBondsmaninf> scoringReportBondsmaninfs = new ArrayList<ScoringReportBondsmaninf>();
				for (Bondsmaninf bondsmaninf : bondsmaninfs) {
					ScoringReportBondsmaninf scoringReportBondsmaninf = new ScoringReportBondsmaninf();
					scoringReportBondsmaninf.setRel_mobile_phone(bondsmaninf.getRel_mobile_phone());
					scoringReportBondsmaninf.setRel_usrname(bondsmaninf.getRel_usrname());
					scoringReportBondsmaninf.setRelation(bondsmaninf.getRelation_());
					scoringReportBondsmaninf.setReport_id(report_id);
					scoringReportBondsmaninfs.add(scoringReportBondsmaninf);
				}
				scoreService.addScoringReportBondsmaninf(scoringReportBondsmaninfs);
			}
			
			List<ScoreReportList> dataList = new ArrayList<ScoreReportList>();
			for (Map<String, Object> map : reportList) {
				boolean flag = Boolean.parseBoolean(map.get("flag").toString());
				if (flag) {
					ScoreReportList scoreReportList = new ScoreReportList();
					
					String scoring_field_id = map.containsKey("scoring_field_id")?map.get("scoring_field_id").toString():"0";
					String scoring_field_name = map.containsKey("scoring_field_name")?map.get("scoring_field_name").toString():"";
					String scoring_field_name_ch = map.containsKey("scoring_field_name_ch")?map.get("scoring_field_name_ch").toString():"";
					String scoring_field_desc = map.containsKey("scoring_field_desc")?map.get("scoring_field_desc").toString():"";
					String scoring_rule_id = map.containsKey("scoring_rule_id")?map.get("scoring_rule_id").toString():"0";
					String scoring_rule_code = map.containsKey("scoring_rule_code")?map.get("scoring_rule_code").toString():"";
					String scoring_rule_name = map.containsKey("scoring_rule_name")?map.get("scoring_rule_name").toString():"";
					String scoring_rule_desc = map.containsKey("scoring_rule_desc")?map.get("scoring_rule_desc").toString():"";
					String gather_field_value = map.containsKey("gather_field_value")?map.get("gather_field_value").toString():"";
					String gather_field_remark = map.containsKey("gather_field_remark")?map.get("gather_field_remark").toString():"";
					String rule_type_id = map.containsKey("rule_type_id")?map.get("rule_type_id").toString():"0";
					
					scoreReportList.setRule_set_id(rule_set_id);
					scoreReportList.setRule_set_name(rule_set_name);
					scoreReportList.setCreate_time(create_time);
					scoreReportList.setReport_id(report_id);
					scoreReportList.setScore(new BigDecimal(map.get("score").toString()));
					scoreReportList.setScoring_field_desc(scoring_field_desc);
					scoreReportList.setScoring_field_id(Integer.parseInt(scoring_field_id));
					scoreReportList.setScoring_field_name(scoring_field_name);
					scoreReportList.setScoring_field_name_ch(scoring_field_name_ch);
					scoreReportList.setScoring_rule_code(scoring_rule_code);
					scoreReportList.setScoring_rule_desc(scoring_rule_desc);
					scoreReportList.setScoring_rule_id(Integer.parseInt(scoring_rule_id));
					scoreReportList.setScoring_rule_name(scoring_rule_name);
					scoreReportList.setGather_field_value(gather_field_value);
					scoreReportList.setGather_field_remark(gather_field_remark);
					scoreReportList.setRule_type_id(Integer.parseInt(rule_type_id));
					
					dataList.add(scoreReportList);
				}
			}
			if (dataList.size() > 0) {
				scoreService.addScoreReportList(dataList);
			}
		}
		return scoreReport;
	}

	/**
	 * 根据评分规则Id和usrid查找是否命中得分
	 * @param scoring_rule_id
	 * @param usrid
	 * @return
	 * @throws JSONException 
	 */
	private float get_model_score(int scoring_rule_id, int usrid, Map<String, Object> reportMap) throws JSONException {
		reportMap.put("flag", false);
		float score_model_value = 0.00f;
		// 根据scoring_rule_id在评分模型value表（scoring_model_value）查找所有记录
		List<Map<String, Object>> valueList = scoreService.findAllRuleValues(scoring_rule_id);
//		log.debug("valueList=" + JSONUtil.toJSONString(valueList));
		if (valueList != null && !valueList.isEmpty()) {
			for (Map<String, Object> valueMap : valueList) {
				boolean flag = false;
				int scoring_field_id = valueMap.containsKey("scoring_field_id")?Integer.parseInt(valueMap.get("scoring_field_id").toString()):0;
				String field_name = valueMap.containsKey("field_name")?valueMap.get("field_name").toString():"";
				String field_name_ch = valueMap.containsKey("field_name_ch")?valueMap.get("field_name_ch").toString():"";
				String field_desc = valueMap.containsKey("field_desc")?valueMap.get("field_desc").toString():"";
				
				reportMap.put("scoring_field_id", scoring_field_id);
				reportMap.put("scoring_field_name", field_name);
				reportMap.put("scoring_field_name_ch", field_name_ch);
				reportMap.put("scoring_field_desc", field_desc);
				
				float score_value = valueMap.containsKey("score_value")?Float.parseFloat(valueMap.get("score_value").toString()):0.00f;
				int field_value_type = valueMap.containsKey("field_value_type")?Integer.parseInt(valueMap.get("field_value_type").toString()):0;
				int is_combined = valueMap.containsKey("is_combined")?Integer.parseInt(valueMap.get("is_combined").toString()):0;
				// 要比较的上下限
				String upper_limit = valueMap.containsKey("upper_limit")?valueMap.get("upper_limit").toString():"";
				String lower_limit = valueMap.containsKey("lower_limit")?valueMap.get("lower_limit").toString():"";
				//采集到的数据值
				String gather_field_value = null;
				//字段类型（0：非组合字段，1：组合字段）
				if (is_combined == 0) {
					Map<String, Object> gatherValueMap = getGatherFieldValueWith1(usrid, scoring_field_id);
					if (gatherValueMap != null) {
						gather_field_value = gatherValueMap.containsKey("gather_field_value") ? gatherValueMap.get("gather_field_value").toString() : "";
						String gather_field_remark = gatherValueMap.containsKey("gather_field_remark") ? gatherValueMap.get("gather_field_remark").toString() : "";
						reportMap.put("gather_field_value", gather_field_value);
						reportMap.put("gather_field_remark", gather_field_remark);
					}else {
						reportMap.put("gather_field_value", "");
						reportMap.put("gather_field_remark", "");
					}
				}else if (is_combined == 1){
					reportMap.put("gather_field_value", "");
					reportMap.put("gather_field_remark", "");
					gather_field_value = getGatherFieldValueWith2(field_value_type, usrid, valueMap);
				}
				
				if (gather_field_value != null && !"".equals(gather_field_value)) {
					// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
					switch (field_value_type) {
					case 0:
						if (gather_field_value.equals(upper_limit)) {
							flag = true;
							score_model_value = score_value;
						}
						break;
					case 1:
						try {
							int upper_limit_i = Integer.parseInt(upper_limit);
							int lower_limit_i = Integer.parseInt(lower_limit);
							int gather_field_value_i = Integer.parseInt(gather_field_value);
							if (lower_limit_i <= gather_field_value_i && gather_field_value_i < upper_limit_i) {
								flag = true;
								score_model_value = score_value;
							}
						} catch (Exception e) {
							flag = false;
						}
						break;
					case 2:
						try {
							float upper_limit_f = Float.parseFloat(upper_limit);
							float lower_limit_f = Float.parseFloat(lower_limit);
							float gather_field_value_f = Float.parseFloat(gather_field_value);
							BigDecimal b = new BigDecimal(upper_limit_f);  
							BigDecimal b1 = new BigDecimal(lower_limit_f);  
							BigDecimal b2 = new BigDecimal(gather_field_value_f);  
							upper_limit_f = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							lower_limit_f = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							gather_field_value_f = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							if (lower_limit_f <= gather_field_value_f && gather_field_value_f < upper_limit_f) {
								flag = true;
								score_model_value = score_value;
							}
						} catch (Exception e) {
							flag = false;
						}
						break;
					case 3:
						if (gather_field_value.equals(upper_limit)) {
							flag = true;
							score_model_value = score_value;
						}else {
							gather_field_value = "|" + gather_field_value + "|";
							if (upper_limit.contains(gather_field_value)) {
								flag = true;
								score_model_value = score_value;
							}
						}
						break;

					default:
						break;
					}
				}else {
					if (upper_limit.equals(lower_limit) && lower_limit.equals("0") && upper_limit.equals("0")) {
						flag = true;
						score_model_value = score_value;
					}
				}
				if (flag) {
					reportMap.put("flag", flag);
					BigDecimal bd = new BigDecimal(score_model_value);
					bd.setScale(2, BigDecimal.ROUND_HALF_UP);
					reportMap.put("score", bd.toString());
					break;
				}
			}
		}
		return score_model_value;
	}
	
	/**
	 * 根据评分规则Id和usrid查找是否命中得分
	 * @param scoring_rule_id
	 * @param usrid
	 * @return
	 * @throws JSONException 
	 */
	private boolean is_get_score(int scoring_rule_id, int usrid, Map<String, Object> reportMap) throws JSONException {
		// 根据scoring_rule_id在评分模型value表（scoring_model_value）查找所有记录
		List<Map<String, Object>> valueList = scoreService.findAllRuleValues(scoring_rule_id);
//		log.debug("valueList=" + JSONUtil.toJSONString(valueList));
		List<Boolean> resultBoolean = new ArrayList<Boolean>();
		if (valueList != null && !valueList.isEmpty()) {
			boolean is_first = true;
			for (Map<String, Object> valueMap : valueList) {
				boolean flag = false;
				int scoring_field_id = valueMap.containsKey("scoring_field_id")?Integer.parseInt(valueMap.get("scoring_field_id").toString()):0;
				String field_name = valueMap.containsKey("field_name")?valueMap.get("field_name").toString():"";
				String field_name_ch = valueMap.containsKey("field_name_ch")?valueMap.get("field_name_ch").toString():"";
				String field_desc = valueMap.containsKey("field_desc")?valueMap.get("field_desc").toString():"";
				
				reportMap.put("scoring_field_id", 0);
				reportMap.put("scoring_field_name", "");
				reportMap.put("scoring_field_name_ch", "");
				reportMap.put("scoring_field_desc", "");
				
				int field_value_type = valueMap.containsKey("field_value_type")?Integer.parseInt(valueMap.get("field_value_type").toString()):0;
				int is_combined = valueMap.containsKey("is_combined")?Integer.parseInt(valueMap.get("is_combined").toString()):0;
				// 要比较的上下限
				String upper_limit = valueMap.containsKey("upper_limit")?valueMap.get("upper_limit").toString():"";
				String lower_limit = valueMap.containsKey("lower_limit")?valueMap.get("lower_limit").toString():"";
				//采集到的数据值
				String gather_field_value = null;
				//字段类型（0：非组合字段，1：组合字段）
				if (is_combined == 0) {
					Map<String, Object> gatherValueMap = getGatherFieldValueWith1(usrid, scoring_field_id);
					if (gatherValueMap != null) {
						gather_field_value = gatherValueMap.containsKey("gather_field_value") ? gatherValueMap.get("gather_field_value").toString() : "";
						String gather_field_remark = gatherValueMap.containsKey("gather_field_remark") ? gatherValueMap.get("gather_field_remark").toString() : "";
						reportMap.put("gather_field_value", "");
						reportMap.put("gather_field_remark", "");
					}else {
						reportMap.put("gather_field_value", "");
						reportMap.put("gather_field_remark", "");
					}
				}else if (is_combined == 1){
					reportMap.put("gather_field_value", "");
					reportMap.put("gather_field_remark", "");
					gather_field_value = getGatherFieldValueWith2(field_value_type, usrid, valueMap);
				}
				if (gather_field_value != null && !"".equals(gather_field_value)) {
					// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
					switch (field_value_type) {
					case 0:
						if (gather_field_value.equals(upper_limit)) {
							flag = true;
						}
						break;
					case 1:
						try {
							int upper_limit_i = Integer.parseInt(upper_limit);
							int lower_limit_i = Integer.parseInt(lower_limit);
							int gather_field_value_i = Integer.parseInt(gather_field_value);
							if (lower_limit_i <= gather_field_value_i && gather_field_value_i < upper_limit_i) {
								flag = true;
							}
						} catch (Exception e) {
							flag = false;
						}
						break;
					case 2:
						try {
							float upper_limit_f = Float.parseFloat(upper_limit);
							float lower_limit_f = Float.parseFloat(lower_limit);
							float gather_field_value_f = Float.parseFloat(gather_field_value);
							BigDecimal b = new BigDecimal(upper_limit_f);  
							BigDecimal b1 = new BigDecimal(lower_limit_f);  
							BigDecimal b2 = new BigDecimal(gather_field_value_f);  
							upper_limit_f = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							lower_limit_f = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							gather_field_value_f = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();  
							if (lower_limit_f <= gather_field_value_f && gather_field_value_f < upper_limit_f) {
								flag = true;
							}
						} catch (Exception e) {
							flag = false;
						}
						break;
					case 3:
						if (gather_field_value.equals(upper_limit)) {
							flag = true;
						}else {
							gather_field_value = "|" + gather_field_value + "|";
							if (upper_limit.contains(gather_field_value)) {
								flag = true;
							}
						}
						break;
						
					default:
						break;
					}
				}else {
					if (upper_limit.equals(lower_limit) && lower_limit.equals("0") && upper_limit.equals("0")) {
						flag = true;
					}
				}
				resultBoolean.add(flag);
				if (!is_first) {
					try {
						//联合条件，枚举类型（1与和2或），同一个规则下多个条件做联合查询
						int unite_value = Integer.parseInt(valueMap.get("unite_value").toString());
						if (unite_value == 1) {
							for (int i = 0; i < resultBoolean.size(); i++) {
								if (!resultBoolean.get(i)) {
									resultBoolean.clear();
									resultBoolean.add(false);
									break;
								}
							}
						}else if(unite_value == 2) {
							for (int i = 0; i < resultBoolean.size(); i++) {
								if (resultBoolean.get(i)) {
									resultBoolean.clear();
									resultBoolean.add(true);
									break;
								}
							}
						}else {
							resultBoolean.clear();
							resultBoolean.add(false);
						}
					} catch (Exception e) {
						resultBoolean.clear();
						resultBoolean.add(false);
					}
				}
				is_first = false;
			}
		}
		return resultBoolean.size() > 0 ? resultBoolean.get(0) : false;
	}

	/**
	 * 获取采集字段值
	 * @param usrid
	 * @param scoring_field_id
	 * @return
	 * @throws JSONException
	 */
	private Map<String, Object> getGatherFieldValueWith1(int usrid, int scoring_field_id) throws JSONException{
		//String gather_field_value = null;
		//根据scoring_field_id在scoring_gather_field_map找出gather_field_id
		Map<String, Object> scoringGatherFieldMap = scoreService.findScoringGatherFieldMap(scoring_field_id);
//		log.debug("scoringGatherFieldMap=" + JSONUtil.toJSONString(scoringGatherFieldMap));
		if (scoringGatherFieldMap != null) {
			int gather_field_id = Integer.parseInt(scoringGatherFieldMap.get("gather_field_id").toString());
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gather_field_id", gather_field_id);
			paramMap.put("usrid", usrid);
			Map<String, Object> gatherValue = scoreService.findGatherValue(paramMap);
//			log.debug("gatherValue=" + JSONUtil.toJSONString(gatherValue));
			return gatherValue;
//			//采集到的数据值
//			if (gatherValue != null) {
//				gather_field_value = gatherValue.containsKey("gather_field_value") ? gatherValue.get("gather_field_value").toString() : "";
//			}
		}
		return null;
	}
	
	/**
	 * 获取采集字段值
	 * @param field_value_type
	 * @param usrid
	 * @param valueMap
	 * @return
	 */
	private String getGatherFieldValueWith2(int field_value_type, int usrid, Map<String, Object> valueMap){
		int combined_field_id_1 = valueMap.containsKey("combined_field_id_1")?Integer.parseInt(valueMap.get("combined_field_id_1").toString()):0;
		int combined_field_id_2 = valueMap.containsKey("combined_field_id_2")?Integer.parseInt(valueMap.get("combined_field_id_2").toString()):0;
		String combined_operate = valueMap.containsKey("combined_operate")?valueMap.get("combined_operate").toString():"";
		String gather_field_value = null;
		String gather_field_value1 = null;
		String gather_field_value2 = null;
		if (combined_field_id_1 != 0 && combined_field_id_2 != 0) {
			Map<String, Object> combinedFieldValueMap1 = scoreService.findCombinedFieldValueMap(combined_field_id_1);
			int is_combined1 = 0;
			if (combinedFieldValueMap1 != null) {
				is_combined1 = combinedFieldValueMap1.containsKey("is_combined")?Integer.parseInt(combinedFieldValueMap1.get("is_combined").toString()):0;
			}
			if (is_combined1 == 1) {
				int field_value_type1 = combinedFieldValueMap1.containsKey("field_value_type")?Integer.parseInt(combinedFieldValueMap1.get("field_value_type").toString()):0;
				gather_field_value1 = getGatherFieldValueWith2(field_value_type1,usrid,combinedFieldValueMap1);
			}else {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("scoring_field_id", combined_field_id_1);
				paramMap.put("usrid", usrid);
				//采集到的数据值
				gather_field_value1 = scoreService.getgatherFieldValue(paramMap);
				if (gather_field_value1 != null) {
					Map<String, Object> combinedFieldValueMap2 = scoreService.findCombinedFieldValueMap(combined_field_id_2);
					int is_combined2 = 0;
					if (combinedFieldValueMap2 != null) {
						is_combined2 = combinedFieldValueMap2.containsKey("is_combined")?Integer.parseInt(combinedFieldValueMap2.get("is_combined").toString()):0;
					}
					if (is_combined2 == 1) {
						int field_value_type2 = combinedFieldValueMap2.containsKey("field_value_type")?Integer.parseInt(combinedFieldValueMap2.get("field_value_type").toString()):0;
						gather_field_value2 = getGatherFieldValueWith2(field_value_type2,usrid,combinedFieldValueMap2);
					}else {
						paramMap.clear();
						paramMap.put("usrid", usrid);
						paramMap.put("scoring_field_id", combined_field_id_2);
						gather_field_value2 = scoreService.getgatherFieldValue(paramMap);
					}
				}
			}
		}
		if (gather_field_value1 != null && gather_field_value2 != null) {
			// 命中值类型 0：字符串，1：整型，2：浮点型（2位小数），3：枚举等
			if (field_value_type == 1) {
				try {
					int gather_field_value1_i = Integer.parseInt(gather_field_value1);
					int gather_field_value2_i = Integer.parseInt(gather_field_value2);
					if (combined_operate.equals("+")) {
						int temp = gather_field_value1_i + gather_field_value2_i;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("-")) {
						int temp = gather_field_value1_i - gather_field_value2_i;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("*")) {
						int temp = gather_field_value1_i * gather_field_value2_i;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("/") && gather_field_value2_i != 0) {
						int temp = gather_field_value1_i / gather_field_value2_i;
						gather_field_value = String.valueOf(temp);
					}
				} catch (Exception e) {
					
				}
			}else if (field_value_type == 2) {
				try {
					float gather_field_value1_f = Float.parseFloat(gather_field_value1);
					float gather_field_value2_f = Float.parseFloat(gather_field_value2);
					if (combined_operate.equals("+")) {
						float temp = gather_field_value1_f + gather_field_value2_f;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("-")) {
						float temp = gather_field_value1_f - gather_field_value2_f;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("*")) {
						float temp = gather_field_value1_f * gather_field_value2_f;
						gather_field_value = String.valueOf(temp);
					}else if (combined_operate.equals("/") && gather_field_value2_f != 0.00f) {
						float temp = gather_field_value1_f / gather_field_value2_f;
						gather_field_value = String.valueOf(temp);
					}
				} catch (Exception e) {
					
				}
			}
		}

		return gather_field_value;
	}
}
