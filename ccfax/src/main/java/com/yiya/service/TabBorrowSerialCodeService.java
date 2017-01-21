/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月8日
 * @description
 */
package com.yiya.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yiya.bean.TabBorrowSerialCode;
import com.yiya.bean.TabBorrowSerialCodeExample;
import com.yiya.bean.TabUsrOrder;
import com.yiya.bean.TabUsrinf2;
import com.yiya.constant.WebServiceConstant;
import com.yiya.mapper.TabBorrowSerialCodeMapper;
import com.yiya.model.TabBorrowInfoModel;
import com.yiya.utils.DateUtil;
import com.yiya.utils.HttpRequestUtil;
import com.yiya.utils.StringUtil;

/**
 * @author frank_wang[JackLikeYou2016@gmail.com]
 * @date 2016年12月8日
 * @description
 */
@Service
public class TabBorrowSerialCodeService implements InitializingBean, ApplicationContextAware {

	private final static Logger log = Logger.getLogger(TabBorrowSerialCodeService.class);

	@Autowired
	private TabBorrowSerialCodeMapper mapper;

	@Value("${findStoreTypeDescByStoreTypeId}")
	private String findStoreTypeDescByStoreTypeIdUrl;

	private ApplicationContext context;

	private DataManagerService dataManagerService;

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description
	 */
	public void insert(TabBorrowSerialCode tabBorrowSerialCode) {

		if (null == tabBorrowSerialCode) {
			return;
		}
		mapper.insert(tabBorrowSerialCode);
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月8日
	 * @description
	 */
	public void updateSelective(TabBorrowSerialCode tabBorrowSerialCode) {

		if (tabBorrowSerialCode == null) {
			return;
		}
		TabBorrowSerialCodeExample example = new TabBorrowSerialCodeExample();
		// example.createCriteria().adn
		//
		// mapper.updateByExampleSelective(record, example)
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月9日
	 * @description 根据订单类型查询最后插入的记录
	 * @return TabBorrowSerialCode
	 */
	public TabBorrowSerialCode selectLastCodeByBorrowType(Integer borrow_type) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("borrow_type", borrow_type);
		TabBorrowSerialCode tabBorrowSerialCode = mapper.selectLastCodeByBorrowType(map);
		return tabBorrowSerialCode;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月9日
	 * @description 根据订单类型获取最后的流水号,由于时间紧迫，先用最土的方法。
	 * @return
	 */
	public synchronized String getLastSerialCodeByBorrowType(Integer orderType) {

		TabBorrowSerialCode tabBorrowSerialCode = selectLastCodeByBorrowType(orderType);
		String tempCode = "";
		// 当前时间年月日字符串
		String currentDate = DateUtil.convertDateToYearMonthDay(new Date());
		// 截取后六位
		currentDate = currentDate.substring(2);
		// 如果为空，则插入数据
		if (tabBorrowSerialCode == null) {
			insert(new TabBorrowSerialCode(orderType.byteValue(), 1, new Date()));
			return currentDate + "0001";
		}
		// 数据库中最后日期的字符串
		String oldDate = DateUtil.convertDateToYearMonthDay(tabBorrowSerialCode.getcreate_time());
		// 如果当前时间日期大于数据库日期，则应该重新至为1
		if (Integer.valueOf(currentDate).intValue() > Integer.valueOf(oldDate).intValue()) {
			insert(new TabBorrowSerialCode(orderType.byteValue(), 1, new Date()));
			return currentDate + "0001";
		}
		int value = tabBorrowSerialCode.getSerial_code().intValue() + 1;
		if (value < 10) {
			tempCode = "000" + value;
			insert(new TabBorrowSerialCode(orderType.byteValue(), value, new Date()));
			return currentDate + tempCode;
		}
		if (value >= 10 || value < 100) {
			tempCode = "00" + value;
			insert(new TabBorrowSerialCode(orderType.byteValue(), value, new Date()));
			return currentDate + tempCode;
		}
		if (value >= 100 || value < 1000) {
			tempCode = "0" + value;
			insert(new TabBorrowSerialCode(orderType.byteValue(), value, new Date()));
			return currentDate + tempCode;
		}
		insert(new TabBorrowSerialCode(orderType.byteValue(), value, new Date()));
		return currentDate + tempCode;
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月9日
	 * @description 生成标的标题
	 * @return
	 */
	public String produceBorrowTitle(Integer orderType) {
		
		return "分期购" + getLastSerialCodeByBorrowType(orderType) + "期";
	}

	/**
	 * @author frank_wang[JackLikeYou2016@gmail.com]
	 * @date 2016年12月29日
	 * @description 生成项目信息
	 * @param request
	 * @param tabUsrinf
	 * @return
	 * @throws Exception 
	 */
	public String produceBorrowInfo(HttpServletRequest request,String type,TabUsrOrder tabUsrOrder) throws Exception {

		String path = request.getSession().getServletContext().getRealPath("/") + "files/borrow_info.html";
		try {
			Document doc = Jsoup.parse(new File(path), "UTF-8");
			// 插入身份证号
			Element idCardElement = doc.getElementById("id_card");
			String idcard = tabUsrOrder.getBorrower_id_card();
			idCardElement.html(idcard.substring(0, 2)+"**************"+idcard.substring(idcard.length()-2));
			// 插入用户名,判断性别
			Elements borrowNameSet = doc.getElementsByClass("borrow_name");
			Iterator<Element> iterator = borrowNameSet.iterator();
			while (iterator.hasNext()) {
				Element tempElement = iterator.next();
				tempElement.html(tabUsrOrder.getBorrower_usrname().substring(0, 1)+("0".equals(tabUsrOrder.getSex().toString())?"先生":"女士"));
			}
			// 插入职业
			Elements professionSet = doc.getElementsByClass("profession");
			Iterator<Element> professionIterator = professionSet.iterator();
			while (professionIterator.hasNext()) {
				Element tempElement = professionIterator.next();
				Integer industry = tabUsrOrder.getIndustry();
				tempElement.html(StringUtils.trim(dataManagerService.getDictionaryValueNameBykey(WebServiceConstant.DICTIONARY_TYPE_CODE_INDUSTRY, industry)));
			}
			//插入借款金额
			Elements borrowMoneySet = doc.getElementsByClass("borrow_money");
			Iterator<Element> borrowMoneyIterator = borrowMoneySet.iterator();
			while (borrowMoneyIterator.hasNext()) {
				Element tempElement = borrowMoneyIterator.next();
				tempElement.html(tabUsrOrder.getOrder_money().toString()+"元");
			}
			//插入借款期限
			Elements borrowDurationSet = doc.getElementsByClass("borrow_duration");
			Iterator<Element> borrowDurationIterator = borrowDurationSet.iterator();
			while (borrowDurationIterator.hasNext()) {
				Element tempElement = borrowDurationIterator.next();
				tempElement.html(tabUsrOrder.getBorrow_duration().toString()+"个月");
			}
			//插入借款利率
			Element borrowInterestRate = doc.getElementById("borrow_interest_rate");
			borrowInterestRate.html(tabUsrOrder.getBorrow_interest_rate().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			//插入前缀type
			Element typeElement = doc.getElementById("type");
			typeElement.html(type==null?"":type);
			//插入申请时间
			Element timeElement = doc.getElementById("time");
			timeElement.html(DateUtil.dateTypeToString(new Date(), "yyyy")+"年"+DateUtil.dateTypeToString(new Date(), "MM")+"月"
					+DateUtil.dateTypeToString(new Date(), "dd")+"日");
			return doc.toString();
		} catch (IOException e) {
			e.printStackTrace();
			log.info("解析html文件失败");
		}catch (Exception e) {
			e.printStackTrace();
			log.info("风控生成项目信息失败");
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		dataManagerService = context.getBean("dataManagerService", DataManagerService.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		
		this.context = context;
	}

}
