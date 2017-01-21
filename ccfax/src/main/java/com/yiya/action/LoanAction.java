package com.yiya.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.JiekuanContact;
import com.yiya.bean.Loan;
import com.yiya.bean.LoanDesc;
import com.yiya.bean.SysRoleRel;
import com.yiya.bean.SysUser;
import com.yiya.model.LoanModel;
import com.yiya.model.ParameterMap;
import com.yiya.service.SysRoleRelService;
import com.yiya.utils.HtmlUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.SessionUtils;
import com.yiya.utils.URLUtils;

/**
 * 风控借款控制类
 * @Company tesu
 * @author lifaqiu
 * @date 2017-1-10
 */
@Controller
@RequestMapping("/loan") 
public class LoanAction extends BaseAction{
	
	private final static Logger log= Logger.getLogger(LoanAction.class);
	
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		
		Map<String,Object> context = getRootMap();
		
		return forword("loan/list",context); 
	}
	
	@RequestMapping("/viewPersonInfo") 
	public ModelAndView viewPersonInfo(int id,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		context.put("code", "0");
		context.put("msg", "");
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("id", id);
		LoanDesc loanDesc = new LoanDesc();
		List<JiekuanContact> contacts = new ArrayList<JiekuanContact>();
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("get_persion_info_url"), parameterMap.createLinkString(true));
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				JSONObject persionData_temp = JSONObject.parseObject(jsonObject.get("persionData").toString());
				JSONArray contactList_temp = JSONArray.parseArray(jsonObject.getString("contactList").toString());
				
				loanDesc.setUname(persionData_temp.getString("uname"));
				loanDesc.setPhone(persionData_temp.getString("phone"));
				loanDesc.setIdcard(persionData_temp.getString("idcard"));
				loanDesc.setMarray(persionData_temp.getString("marray"));
				loanDesc.setXueli(persionData_temp.getString("xueli"));
				loanDesc.setIncome(persionData_temp.getString("income"));
				loanDesc.setProvince(persionData_temp.getString("province"));
				loanDesc.setCity(persionData_temp.getString("city"));
				loanDesc.setArea(persionData_temp.getString("area"));
				loanDesc.setAsset(persionData_temp.getString("asset"));
				loanDesc.setBankcard(persionData_temp.getString("bankcard"));
				loanDesc.setZhufang(persionData_temp.getString("zhufang"));
				loanDesc.setWork(persionData_temp.getString("work"));
				loanDesc.setWork_time(persionData_temp.getString("work_time"));
				loanDesc.setPosition(persionData_temp.getString("position"));
				
				loanDesc.setHandcard_pic(persionData_temp.getString("handcard_pic"));
				loanDesc.setId_card_front_pic(persionData_temp.getString("id_card_front_pic"));
				loanDesc.setId_card_reverse_pic(persionData_temp.getString("id_card_reverse_pic"));
				
				loanDesc.setQudao(persionData_temp.getString("qudao"));
				loanDesc.setPurpose(persionData_temp.getString("purpose"));
				loanDesc.setAmount(persionData_temp.getBigDecimal("amount"));
				loanDesc.setDeadline(persionData_temp.getString("deadline"));
				
				loanDesc.setZhengxin_pic(persionData_temp.getString("zhengxin_pic"));
				loanDesc.setBank_state(persionData_temp.getString("bank_state"));
				
				for (Object object : contactList_temp) {
					JSONObject jObject = (JSONObject)object;
					JiekuanContact contact = new JiekuanContact();
					contact.setName(jObject.getString("name"));
					contact.setPhone(jObject.getString("phone"));
					contact.setRelation(jObject.getString("relation"));
					contacts.add(contact);
				}
				
				// 处理图片
				String handcard_pic = loanDesc.getHandcard_pic();
				if (handcard_pic != null) {
					JSONObject h = JSONObject.parseObject(handcard_pic);
					loanDesc.setHandcard_pic_s(URLUtils.get("ccfax_url") + h.getString("s_pic"));
					loanDesc.setHandcard_pic_m(URLUtils.get("ccfax_url") + h.getString("m_pic"));
				}
				String id_card_front_pic = loanDesc.getId_card_front_pic();
				if (id_card_front_pic != null) {
					JSONObject h = JSONObject.parseObject(id_card_front_pic);
					loanDesc.setId_card_front_pic_s(URLUtils.get("ccfax_url") + h.getString("s_pic"));
					loanDesc.setId_card_front_pic_m(URLUtils.get("ccfax_url") + h.getString("m_pic"));
				}
				String id_card_reverse_pic = loanDesc.getId_card_reverse_pic();
				if (id_card_front_pic != null) {
					JSONObject h = JSONObject.parseObject(id_card_reverse_pic);
					loanDesc.setId_card_reverse_pic_s(URLUtils.get("ccfax_url") + h.getString("s_pic"));
					loanDesc.setId_card_reverse_pic_m(URLUtils.get("ccfax_url") + h.getString("m_pic"));
				}
				List<Map<String, String>> zhengxinPicList = new ArrayList<Map<String,String>>();
				List<Map<String, String>> bankstatePicList = new ArrayList<Map<String,String>>();
				String zhengxin_pic = loanDesc.getZhengxin_pic();
				if (zhengxin_pic != null) {
					JSONArray array = JSONArray.parseArray(zhengxin_pic);
					for (Object object : array) {
						JSONObject p = (JSONObject)object;
						Map<String, String> map = new HashMap<String, String>();
						map.put("s_pic", URLUtils.get("ccfax_url") + p.getString("s_pic"));
						map.put("m_pic", URLUtils.get("ccfax_url") + p.getString("m_pic"));
						zhengxinPicList.add(map);
					}
				}
				String bank_state = loanDesc.getBank_state();
				if (bank_state != null) {
					JSONArray array = JSONArray.parseArray(bank_state);
					for (Object object : array) {
						JSONObject p = (JSONObject)object;
						Map<String, String> map = new HashMap<String, String>();
						map.put("s_pic", URLUtils.get("ccfax_url") + p.getString("s_pic"));
						map.put("m_pic", URLUtils.get("ccfax_url") + p.getString("m_pic"));
						bankstatePicList.add(map);
					}
				}
				context.put("zhengxinPicList", zhengxinPicList);
				context.put("bankstatePicList", bankstatePicList);
			}else {
				context.put("code", "-1");
				context.put("msg", jsonObject.get("msg"));
			}
		} catch (Exception e) {
			log.info("调用4.3.23 修改借款状态出错:" + e.getMessage());
			context.put("code", "-1");
			context.put("msg", "调用4.3.23 修改借款状态出错:" + e.getMessage());
		}
		
		context.put("loanDesc", loanDesc);
		context.put("contacts", contacts);
		return forword("loan/viewPersonInfo",context); 
	}
	
	@RequestMapping("/viewCompanyInfo") 
	public ModelAndView viewCompanyInfo(int id,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		context.put("code", "0");
		context.put("msg", "");
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("id", id);
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("get_company_info_url"), parameterMap.createLinkString(true));
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				JSONObject companyData_temp = JSONObject.parseObject(jsonObject.get("companyData").toString());
				JSONObject loanData_temp = JSONObject.parseObject(jsonObject.get("loanData").toString());
				context.put("loanData", loanData_temp);
				context.put("companyData_temp", companyData_temp);
				
				List<String> pics = new ArrayList<String>();
				if (companyData_temp.containsKey("zizhi")) {
					JSONArray array = JSONArray.parseArray(companyData_temp.get("zizhi").toString());
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {
							String pic = array.getString(i);
							if (pic != null) {
								pic = URLUtils.get("ccfax_url") + pic;
								pics.add(pic);
							}
						}
					}
				}
				context.put("pics", pics);
			}else {
				context.put("code", "-1");
				context.put("msg", jsonObject.get("msg"));
			}
		} catch (Exception e) {
			log.info("调用4.3.23 修改借款状态出错:" + e.getMessage());
			context.put("code", "-1");
			context.put("msg", "调用4.3.23 修改借款状态出错:" + e.getMessage());
		}
		
		return forword("loan/viewCompanyInfo",context); 
	}

	@RequestMapping("/loanset") 
	public ModelAndView loanset(HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		context.put("code", "0");
		context.put("msg", "");
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("number", 1007);
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("get_loan_value_url"), parameterMap.createLinkString(true));
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				context.put("loan_value", jsonObject.get("loan_value").toString());
			}else {
				context.put("code", "-1");
				context.put("msg", jsonObject.get("msg"));
			}
		} catch (Exception e) {
			log.info("调用4.3.24 获取每日借款笔数限额出错:" + e.getMessage());
			context.put("code", "-1");
			context.put("msg", "调用4.3.24 获取每日借款笔数限额出错:" + e.getMessage());
		}
		
		return forword("loan/loanset",context); 
	}
	
	@RequestMapping("/update_loan_value") 
	public void update_loan_value(String loan_value,HttpServletResponse response) throws Exception{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		Integer lv = null;
		try {
			lv = Integer.parseInt(loan_value);
		} catch (Exception e) {
			jsonMap.put("code", "-1");
			jsonMap.put("msg", "请输入正确的笔数");
			HtmlUtil.writerJson(response, jsonMap);
			return ;
		}
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("number", 1007);
		parameterMap.put("loan_value", loan_value);
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("update_loan_value_url"), parameterMap.createLinkString(true));
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				jsonMap.put("code", "0");
				jsonMap.put("msg", "");
			}else {
				jsonMap.put("code", "-1");
				jsonMap.put("msg", jsonObject.get("msg"));
			}
		} catch (Exception e) {
			log.info("调用4.3.25 修改每日借款笔数限额出错:" + e.getMessage());
			jsonMap.put("code", "-1");
			jsonMap.put("msg", "调用4.3.25 修改每日借款笔数限额出错:" + e.getMessage());
		}
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void dataList(LoanModel model,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		boolean deal = false;
		SysUser sysUser = SessionUtils.getUser(request);
		List<SysRoleRel> SysRoleRelList = sysRoleRelService.queryByObjId(sysUser.getId(), 1); // 根据用户id查找角色和权限
		for (SysRoleRel sysRoleRel : SysRoleRelList) {
			Integer roleId = sysRoleRel.getRoleId();
			List<SysRoleRel> buttonRelsList = sysRoleRelService.queryByRoleId(roleId, 2); // 根据用户角色查找是否有审核权限
			for (SysRoleRel buttonRels : buttonRelsList) {
				if (buttonRels.getObjId() == 59) {
					deal = true;
					break;
				}
			}
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("pageNo", model.getPager().getPageId());
		parameterMap.put("pageSize", model.getPager().getPageSize());
		if (model.getUser_type() != null) {			
			parameterMap.put("user_type", model.getUser_type());
		}
		if (model.getStatus() != null) {			
			parameterMap.put("status", model.getStatus());
		}
		if (model.getUname() != null && !"".equals(model.getUname())) {
			parameterMap.put("uname", model.getUname());
		}
		if (model.getIdcard() != null && !"".equals(model.getIdcard())) {
			parameterMap.put("idcard", model.getIdcard());
		}
		if (model.getPhone() != null && !"".equals(model.getPhone())) {
			parameterMap.put("phone", model.getPhone());
		}
		if (model.getUid() != null && !"".equals(model.getUid())) {
			parameterMap.put("uid", model.getUid());
		}
		List<Loan> dataList = new ArrayList<Loan>();
		int total = 0;
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("get_loan_list_url"), parameterMap.createLinkString(true));
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if ("0".equals(jsonObject.get("code").toString())) {
				JSONArray array = JSONArray.parseArray(jsonObject.get("dataList").toString());
				if (array != null && array.size() > 0) {
					for (Object object : array) {
						JSONObject jsonObject2 = (JSONObject)object;
						Loan loan = new Loan();
						loan.setAddtime(jsonObject2.getDate("addtime"));
						loan.setAmount(jsonObject2.getBigDecimal("amount"));
						loan.setId(jsonObject2.getInteger("id"));
						loan.setIdcard(jsonObject2.getString("idcard"));
						loan.setPhone(jsonObject2.getString("phone"));
						loan.setStatus(jsonObject2.getInteger("status"));
						loan.setUid(jsonObject2.getInteger("uid"));
						loan.setUname(jsonObject2.getString("uname"));
						loan.setUser_type(jsonObject2.getInteger("user_type"));
						loan.setDeal(deal);
						dataList.add(loan);
					}
				}
			}
			total = jsonObject.getIntValue("record_total");
		} catch (Exception e) {
			log.info("调用4.3.22借款申请列表出错:" + e.getMessage());
			dataList = new ArrayList<Loan>();
		}
		jsonMap.put("total", total);
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/updateStatus") 
	public void updateStatus(int id, HttpServletResponse response) throws Exception
	{
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.put("id", id);
		parameterMap.put("status", 1);
		
		try {
			String result = HttpRequestUtil.sendPost(URLUtils.get("update_loan_status_url"), parameterMap.createLinkString(true));
			log.info(result);
			HtmlUtil.writerJson(response, result);
		} catch (Exception e) {
			log.info("调用4.3.23 修改借款状态出错:" + e.getMessage());
			jsonMap.put("code", -1);
			jsonMap.put("msg", "调用4.3.23 修改借款状态出错");
			HtmlUtil.writerJson(response, jsonMap);
		}
	}
}
