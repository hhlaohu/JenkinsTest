package com.yiya.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.ErrorDaily;
import com.yiya.bean.TabCustomer;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.TabCustomerMapper;
import com.yiya.model.ErrorDailyModel;
import com.yiya.model.TabCustomerModel;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.StringUtil;
import com.yiya.utils.Tools;


@Service("tabCustomerService")
public class TabCustomerService<T> extends BaseService<T> {

	private final static Logger log = Logger.getLogger(TabCustomerService.class);

	@Value("${getBorrowListFormChainGold}")
	private String getBorrowList;

	@Autowired
	private TabCustomerMapper<T> mapper;

	public TabCustomerMapper<T> getMapper() {
		return mapper;
	}

	public List<TabCustomer> queryByList(TabCustomerModel tb) {
		return mapper.queryByList(tb);
	}

	public List<ErrorDaily> queryErrorDaily(ErrorDailyModel tb) {
		return mapper.queryErrorDaily(tb);
	}

	public int queryErrorDailyCount(ErrorDailyModel tb) {
		return mapper.queryErrorDailyCount(tb);
	}

	public void errorStatusUp(ErrorDailyModel tb) {
		mapper.errorStatusUp(tb);
	}

	public void deleteerror(ErrorDailyModel tb) {
		mapper.deleteerror(tb);
	}

	public void adderrordaily(ErrorDailyModel tb) {
		mapper.adderrordaily(tb);
	}
	
	public void batchInsertErrorDaily(List<ErrorDailyModel> list){
		if(list.isEmpty()){
			return;
		}
        mapper.batchInsertErrorDaily(list);		
	}

	public void updateborrow(TabCustomer tb) {
		mapper.updateborrow(tb);
	}

	public void update(TabCustomerModel model) {
		mapper.update(model);
	}

	public TabCustomer queryBycustomerid(TabCustomerModel tb) {
		return mapper.queryBycustomerid(tb);
	}

	public List<TabCustomer> queryAllList(TabCustomerModel tb) {
		return mapper.queryAllList(tb);
	}

	public void updatelockline(TabCustomerModel model) {
		mapper.updatelockline(model);
	}

	/**
	 * @author wang_xiao_long
	 * @data 2016年8月12日
	 * @description 批量更新
	 * @param list
	 */
	public void batchUpdateTabCustomer(List<TabCustomer> list) {
		mapper.batchUpdateTabCustomer(list);
	}

	/**
	 * @author wang_xiao_long
	 * @data 2016年8月12日
	 * @description 从链金所批量获取借款金额并异步批量更新
	 */
	public Map<String, Object> getBorrowSumFromChainGoldInbulk(List<TabCustomer> tabCustomerList) {
		StringBuilder telephoneList = new StringBuilder();
		Set<TabCustomer> originalSet = new HashSet<TabCustomer>(tabCustomerList);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if (null != tabCustomerList && tabCustomerList.size() > 0) {
			for (TabCustomer customer : tabCustomerList) {
				telephoneList.append(customer.getTelephone()).append(",");
			}
			telephoneList.deleteCharAt(telephoneList.length() - 1);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("user_phone", telephoneList.toString());
			String param = Tools.assembleParams(paramMap);
			log.info("方法getBorrowSumFromChainGoldInbulk调用链金所请求参数："+param);
			//调用外系统接口
			String data = HttpRequestUtil.sendPost(getBorrowList, param);
			log.info("方法getBorrowSumFromChainGoldInbulk调用链金返回结果："+data);
			if (StringUtil.isEmpty(data)) {
				throw new RuntimeException("方法getBorrowSumFromChainGoldInbulk调用链金所请求失败,http连接无返回值");
			}
			//封装结果
			JSONObject result = JSONObject.parseObject(data);
			
			List<TabCustomer> listToUpdate = new ArrayList<TabCustomer>();
			List<ErrorDailyModel> errorList = new ArrayList<ErrorDailyModel>();
			if (result.getIntValue("code") == WebServiceConstant.CODE_SUCCESS) {
				String borrowListJson = result.getString("borrow_list");
				List<Map> mapList = JSONObject.parseArray(borrowListJson, Map.class);
				Set<TabCustomer> resultSet = new HashSet<TabCustomer>();
				for (Map map : mapList) {
					String userPhone = (String)map.get("user_phone");
					BigDecimal totoal = new BigDecimal((String)map.get("total"));
					resultMap.put(userPhone, totoal);
					TabCustomer customer = new TabCustomer();
					customer.setTelephone(userPhone);
					customer.setBorrow_balance(totoal);
					resultSet.add(customer);
				}
				//剔除掉返回的数据,剩下的数据就是根据电话号码未取到的客户借款金额
				originalSet.removeAll(resultSet);
				listToUpdate = new ArrayList<TabCustomer>(resultSet);
				if(originalSet.size() > 0){
					//未取到借款金额list
					List<TabCustomer> customerList = new ArrayList<TabCustomer>(originalSet);
					for(TabCustomer customer:customerList){
						//未取到借款金额的borrow_balance设为0，同时记录到error_daily表中;
						customer.setBorrow_balance(new BigDecimal(0));
						listToUpdate.add(customer);
						resultMap.put(customer.getTelephone(), new BigDecimal(0));
						ErrorDailyModel error = new ErrorDailyModel();
						error.setError_customer_name(customer.getCustomer_name());
						error.setError_telephone(customer.getTelephone());
						error.setError_content("根据电话号码未获取到借款金额");
						errorList.add(error);
					}
				}
				
			}else{
				log.error("方法getBorrowSumFromChainGoldInbulk调用链金所请求失败，返回code:-1,message:"+result.getString("message"));
				for(TabCustomer tempTabCustomer:tabCustomerList){
					//未取到借款金额的borrow_balance设为0，同时记录到error_daily表中;
					tempTabCustomer.setBorrow_balance(new BigDecimal(0));
					listToUpdate.add(tempTabCustomer);
					resultMap.put(tempTabCustomer.getTelephone(), new BigDecimal(0));
					ErrorDailyModel error = new ErrorDailyModel();
					error.setError_customer_name(tempTabCustomer.getCustomer_name());
					error.setError_telephone(tempTabCustomer.getTelephone());
					error.setError_content("根据电话号码未获取到借款金额");
					errorList.add(error);
				}
			}
			//异步更新数据
			asynChronizeUpdate(listToUpdate,errorList);
			return resultMap;
		}
       return null;
	}
	
	/**
	 * @author 异步更新数据
	 * @data 2016年8月12日
	 * @description
	 */
	public void asynChronizeUpdate(final List<TabCustomer> listToUpdate,final List<ErrorDailyModel> errorList){
		 
		new Thread(new Runnable() {
			@Override
			public void run() {
				batchInsertErrorDaily(errorList);
				batchUpdateTabCustomer(listToUpdate);
			}
		}).start();
	}

}
