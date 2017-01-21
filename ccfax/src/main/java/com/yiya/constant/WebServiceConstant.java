package com.yiya.constant;

/**
 * @author Administrator
 * @data 2016年8月9日
 * @description 常量类
 */
public class WebServiceConstant {
	
	/**接口调用成功返回值*/
    public static final int CODE_SUCCESS = 0;
    
	/**接口调用失败返回值*/
    public static final int CODE_FAIL = -1;
    
    /**接口返回超时*/
    public static final int CODE_FAIL_TIMEOUT = -2;
    
    /**接口返回详情信息key值*/
    public static final String MESSAGE = "msg";
    
    /**借款状态待审核*/
    public static final Integer BORROW_STATUS_CHECK_TODO = 0;
    
    /**借款状态初审核失败*/
    public static final Integer BORROW_STATUS_CHECK_FAIL = 1;
    
    /**借款状态审核通过*/
    public static final Integer BORROW_STATUS_CHECK_SUCCESS = 2;
    
    /**标的审核状态：全部*/
	public static final Integer BORROW_STATUS_ALL = 3;
    
    /**额度状态未审核*/
    public static final Integer CHECK_FLAG_NOT_CHECK = 1;
    
    /**关联用户表sys_role类型*/
    public static final Integer RELATION_SYS_ROLE = 1;
    
    /**关联按钮类型*/
    public static final Integer RELATION_SYS_BTN = 2;
    
    /**图片未打码*/
    public static final Integer PIC_NOT_MOSAIC = 0;
    
    /**图片打过码*/
    public static final Integer PIC_MOSAIC = 1;
    
    /**开通分期类型乐购*/
    public static final String LE_GOU = "0";
    
    /**开通分期类型乐装*/
    public static final String LE_ZHUANG = "1";
    
    /**额度状态操作初始状态：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_INITIAL = "0";
	
	/**额度状态操作待审核：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_TO_AUDIT = "1";
	
	/**额度状态操作初审不通过：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_FIRST_NOT_PASS = "2";
	
	/**额度状态操作待复审（即初审通过）：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_TO_SECOND_AUDIT = "3";
	
	/**额度状态操作复审不通过：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_SECOND_NOT_PASS = "4";
	
	/**额度状态操作复审通过：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_SECOND_PASS = "5";
	
	/**额度状态操作退回初审：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_BACK_TO_FIRST_PASS = "6";	
	
	/**额度状态操作终审不通过：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_FINAL_NOT_PASS = "7";
	
	/**额度状态操作终审通过：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_FINAL__PASS = "8";
	
	/**额度状态操作退回复审：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_BACK_TO_SECOND__PASS = "9";
	
	/**额度状态操作备注：与CHECK_FLAG不同，主要用于显示*/
	public static final String CHECK_RESULT_COMMENT = "10";
	
	/**额度状态初始状态*/
	public static final Integer CHECK_FLAG_INITIAL = 0;
	
	/**额度状态待初审*/
	public static final Integer CHECK_FLAG_TO_AUDIT = 1;
	
	/**额度状态初审不通过*/
	public static final Integer CHECK_FLAG_FIRST_NOT_PASS = 2;
	
	/**额度状态初审通过*/
	public static final Integer CHECK_FLAG_FIRST_PASS = 3;
	
	/**额度状态复审不通过*/
	public static final Integer CHECK_FLAG_SECOND_NOT_PASS = 4;
	
	/**额度状态复审通过*/
	public static final Integer CHECK_FLAG_SECOND_PASS = 5;
	
	/**额度状态终审不通过*/
	public static final Integer CHECK_FLAG_FINAL_NOT_PASS = 7;
	
	/**额度状态终审通过*/
	public static final Integer CHECK_FLAG_FINAL_PASS = 8;
	
	/**账户被冻结,不能使用*/
	public static final Integer ACCOUNT_FREEZED = 0;
	
	/**账户未冻结，能使用*/
	public static final Integer ACCOUNT_NOT_FREEZED = 1;
	
	/**产品类型为1,活体检测*/
	public static final int PRODUCT_TYPE_CHECK_ALIVE = 1;
	
	/**产品类型为2,姓名身份证号照片比对*/
	public static final int PRODUCT_TYPE_ID_CARD_CHECK = 2;
	
	/**征信资料在sys_menu_btn表中的ID*/
	public static final Integer CREDI_INFO_OBJ_ID = 35;
	
	/**小视科技身份证号姓名图像对比调用接口失败*/
	public static final Integer XIAO_SHI_ID_NAME_FACE_RESULT_FAIL = -1;
	
	/**小视科技身份证号姓名图像对比调用接口成功，且人像对比有分数*/
	public static final Integer XIAO_SHI_ID_NAME_FACE_RESULT_SCORE = 1;
	
	/**小视科技身份证号姓名图像对比调用接口成功，且身份证号和姓名不匹配*/
	public static final Integer XIAO_SHI_ID_NAME_FACE_RESULT_NOT_MATCH = 3;
	
	/**额度初审按钮ID*/
	public static final Integer FIRST_VERIFY_BUTTON_ID = 28;
	
	/**额度复审按钮ID*/
	public static final Integer SECOND_VERIFY_BUTTON_ID = 34;
	
	/**额度终审按钮ID*/
	public static final Integer FINAL_VERIFY_BUTTON_ID = 36;
	
	/**借款审核按钮ID*/
	public static final Integer BORROW_CHECK_BUTTON_ID = 30;
	
	/**用户发送短信开关打开*/
	public static final Integer IS_SEND_MESSAGE_OPEN = 1;
	
	/**激活*/
	public static final Integer IS_ACTIVATE_TRUE = 1;
	
	/**未激活*/
	public static final Integer IS_ACTIVATE_FALSE = 0;
	
	/**额度可用*/
	public static final Integer IS_LOAN_TRUE = 1;
	
	/**额度冻结*/
	public static final Integer IS_LOAN_FALSE = 0;
	
	/**借款用途乐购*/
	public static final String BORROW_USE_LE_GOU = "4";
	
	/**借款用途乐装*/
	public static final String BORROW_USE_LE_ZHUANG = "8";
	
	/**信用千金用途*/
	public static final String BORROW_USE_CREDIT_WORTH_MONEY = "9";
	
	/**上上签个人用户*/
	public static final String USER_TYPE_PERSONAL = "1";
	
	/**上上签企业用户*/
	public static final String USER_TYPE_COMPANY = "2";
	
	/**上上签返回成功码*/
	public static final String SHANG_SHAGN_QIAN_SUCCESS_CODE = "100000";
    
	/**字段值类型 整型*/
	public static final Integer FIELD_VALUE_TYPE_INTEGER = 1;
	
	/**字段值类型 字符型*/
	public static final Integer FIELD_VALUE_TYPE_STRING = 2;
	
	/**字段值类型 布尔型*/
	public static final Integer FIELD_VALUE_TYPE_BOOLEAN = 3;
	
	/**字段值类型 浮点型*/
	public static final Integer FIELD_VALUE_TYPE_FLOAT = 4;
	
	/**字段值类型 枚举型*/
	public static final Integer FIELD_VALUE_TYPE_ENUM = 5;
	
	/**还款方式，按天计息，一次性还本付息*/
	public static final int REPAYMENT_TYPE_BY_DAY = 1;
	
	/**等额本息*/
	public static final int REPAYMENT_TYPE_AVERAGE_CAPITAL_PLUS_INTEREST = 2;
	
	/**按季分期还款*/
	public static final int REPAYMENT_TYPE_BY_QUATER = 3;
	
	/**每月还息，到期还本*/
	public static final int REPAYMENT_TYPE_INTETREST_FIRST_CAPITAL_LATER = 4;
	
	/**等额本金*/
	public static final int REPAYMENT_TYPE_EQUAL_CAPITAL_NO_INTEREST = 7;
	
	/**计息方式 按月*/
	public static final int INTEREST_MODE_BY_MONTH = 0;
	
	/**计息方式 按天*/
	public static final int INTEREST_MODE_DAY = 1;
	
	/**计息方式 按季度*/
	public static final int INTEREST_MODE_QUATER = 2;
	
	/**跳转到标的审核页面*/
	public static final String HREF_TYPE_CHECK = "1";
	
	/**跳转到标的修改页面*/
	public static final String HREF_TYPE_MODIFY = "2";
	
	/**百融成功返回CODE*/
	public static final String BAI_RONG_SUCCESS_CODE = "600000";
	
	/**百融子产品 匹配返回成功标识*/
	public static final String BAI_RONG_FLAG_SUCCESS= "1";
	
	/**数据源类型百融*/
	public static final String SOURCE_BAI_RONG = "百融";
	
	/**数据源类型前端采集*/
	public static final String SOURCE_USER = "前端采集";
	
	/**数据源类型百融*/
	public static final String SOURCE_SHU_ZUN = "数尊";
	
	/**申请贷款额度标志未申请额度*/
	public static final Byte APPLYFO_FLAG_NOT_APPLY = 0;
	
	/**菜单中文名称 用户管理*/
	public static final String MENU_NAME_USER_MANAGER= "用户管理";
	
	/**按钮中文名称 资料处理*/
	public static final String BTN_NAME_INFO_HANDLE= "资料处理";
	
	/**评分报告权限ID*/
	public static final String SCORING_REPORT_AUTH = "评分报告修改";
	
	/**用代付卡支付*/
	public static final String PAY_BY_BANK_CARD = "1";
	
	/**订单状态资料提交中*/
	public static final Integer ORDER_STATUS_INFO_SUBMIT = 0;
	
	/**订单状态待审核*/
	public static final Integer ORDER_STATUS_TO_AUDIT = 1;
	
	/**订单状态待还款*/
	public static final Integer ORDER_STATUS_TO_REPAY = 2;
	
	/**订单状态还款中*/
	public static final Integer ORDER_STATUS_REPAYING = 3;
	
	/**订单状态还款完成*/
	public static final Integer ORDER_STATUS_REPAY_COMPLISH = 4;
	
	/**订单状态审核失败*/
	public static final Integer ORDER_STATUS_CHECK_FAIL = 5;
	
	/**订单状态无效*/
	public static final Integer ORDER_STATUS_NOT_VALID = 7;
	
	/**订单类型：旅游订单*/
	public static final Integer OREDER_TYPE_TOURIST = 0;
	
	/**订单类型：家具*/
	public static final Integer OREDER_TYPE_FURNITURE = 1;
	
	/**订单类型：家装*/
	public static final Integer OREDER_TYPE_DECORATION = 2;
	
	/**短信通道5*/
	public static final String SHORT_MESSAGE_CHANEL_5 = "5";
	
	/**字典type_code 行业Industry*/
	public static final String DICTIONARY_TYPE_CODE_INDUSTRY = "tszd_7";
	
	/**照片类型--身份证正面照片*/
	public static final String PIC_TYPE_IDCARD_FRONT = "6";
	
	/**照片类型--身份证反面照片*/
	public static final String PIC_TYPE_IDCARD_REVERSE = "7";
	
	/**照片类型--身份证手持照片*/
	public static final String PIC_TYPE_IDCARD_WITH = "8";
	
	/**照片类型--打码照片*/
	public static final String PIC_TYPE_MOSAIC = "10";
	
	/**规则集业务分类--秒赊*/
	public static final Integer TAB_RULE_SET_TYPE_MIAO_SHE = 1;
	
	/**订单来源秒赊*/
	public static final Integer ORDER_SOURCE_MIAO_SHE = 0;
	
	/**提交订单步骤*/
	public static final Byte SUBMIT_STEP_CREATE = 0;
	
	/**提交身份认证*/
	public static final Byte SUBMIT_STEP_ID_CARD = 1;
	
	/**活体检测通过*/
	public static final Byte SUBMIT_STEP_CHECK_ALIVE = 2;
	
	/**提交信息认证*/
	public static final Byte SUBMIT_STEP_IDENTITY = 3;
	
	/**提交分期资料认证，并生成合同*/
	public static final Byte SUBMIT_STEP_CONTRACT = 4;
	
	/**提交手机通讯录、短信等私人资料，提交私人资料后认为该订单提交完成*/
	public static final Byte SUBMIT_STEP_FINAL = 5;
	
	/**订单初审权限按钮*/
	public static final Integer ORDER_CHECK_FIRST_ID = 60;
	
	/**运行环境正式服*/
	public static final String RUNTIME_ENVIRONMENT = "produce";
	
}
