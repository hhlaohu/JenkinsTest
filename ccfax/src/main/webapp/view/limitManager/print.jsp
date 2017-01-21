<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分期客户风控评分报告</title>
<script language="javascript" src="${msUrl}/js/LodopFuncs.js"></script>
<style type="text/css">
*{margin:0;padding:0;}
body{font:16px/25px '\5FAE\8F6F\96C5\9ED1','\5b8b\4f53',arial,tahoma, Srial, helvetica, sans-serif;}

hr{margin:20px 0;border:none 0;border-bottom:dashed 2px #333;}
h2, caption{line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;}
h3{line-height:35px;padding:0 20px;font-size:16px;font-weight:normal;text-align:left;color:#333;}
td, th{padding:5px 10px;}
.mid{width:1000px;margin:10px auto;}
.mt10{margin-top:10px;}
.mt20{margin-top:20px;}
.mb10{margin-bottom:10px;}
.contact{margin-top:10px;padding-top:10px;border-top:solid 1px #dedede;}
.contact p, .blacklist p{padding-left:50px;font-size:16px;margin-top:20px;}
.contact span{display:inline-block;width:33%;}
</style>
</head>
<body style="text-align:center;margin:0;padding:0;font:16px/25px '\5FAE\8F6F\96C5\9ED1','\5b8b\4f53',arial,tahoma, Srial, helvetica, sans-serif;">
<p align="center">
		<a href="javascript:prn1_preview()">打印预览</a>&nbsp;&nbsp;&nbsp;
		<a href="javascript:prn1_print()">直接打印</a>
	</p>
<form id="form1">
<h1 style="line-height:60px;margin:0;padding:0;font-size:36px;font-weight:normal;text-align:center;">分期客户风控评分报告</h1>
<div style="margin:10px auto;text-align: left;">
	<table width="96%" style="border-spacing:0;border-collapse:collapse;">
        <tbody>
            <tr>
            	<td width="70%" style="padding:5px 10px;font-size:14px;">编号：${scoreReport.order_sn}</td>
                <td style="padding:5px 10px;font-size:14px;">贷款用途：${scoreReport.store_type_name}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;">查询用户：${scoreReport.borrower_usrname}</td>
                <td style="padding:5px 10px;font-size:14px;">查询时间：${scoreReport.create_time_str}</td>
            </tr>
        </tbody>
    </table>
    <hr style="margin:20px 0;border:none 0;border-bottom:dashed 2px #333;">
    <table width="96%" style="border-spacing:0;border-collapse:collapse;text-align: left;">
        <caption style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">一：客户基本信息</caption>
        <tbody>
            <tr>
            	<td width="4%"></td>
            	<td width="40%" style="padding:5px 10px;font-size:14px;">姓名：${scoreReport.borrower_usrname}</td>
                <td style="padding:5px 10px;font-size:14px;">身份证号：${scoreReport.borrower_id_card}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">手机：${scoreReport.borrower_mobile_phone}</td>
                <td style="padding:5px 10px;font-size:14px;">银行卡：${scoreReport.bank_id}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">学历：${scoreReport.diploma}</td>
                <td style="padding:5px 10px;font-size:14px;">个人年收入：${scoreReport.income}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">住址：${scoreReport.register_place}</td>
                <td style="padding:5px 10px;font-size:14px;">是否本地户籍：${scoreReport.local_register_place}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">单位名称：${scoreReport.com_name}</td>
                <td style="padding:5px 10px;font-size:14px;">单位行业：${scoreReport.industry}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">职位：${scoreReport.profession_level}</td>
                <td style="padding:5px 10px;font-size:14px;">本单位工作时间：${scoreReport.cur_hire_duration}</td>
            </tr>
            <tr>
            	<td style="padding:5px 10px;font-size:14px;"></td>
            	<td style="padding:5px 10px;font-size:14px;">住房状态：${scoreReport.house_type}</td>
                <td style="padding:5px 10px;font-size:14px;">固定资产：${scoreReport.fixed_assets}</td>
            </tr>
        </tbody>
    </table>
    <div style="margin-top:10px;padding-top:10px;border-top:solid 1px #dedede;width: 94%;" >
        <h3 style="line-height:35px;padding:0 20px;font-size:16px;font-weight:normal;text-align:left;color:#333;">联系人信息：</h3>
        <div style="padding-left:50px;text-align:left;">
	        <table width="80%" style="border-spacing:0;border-collapse:collapse;">
	        	<tr>
	        		<td style="padding:5px 10px;font-size:14px;">姓名</td>
	        		<td style="padding:5px 10px;font-size:14px;">关系</td>
	        		<td style="padding:5px 10px;font-size:14px;">电话</td>
        		</tr>
	        	<c:forEach var="item" items="${scoringReportBondsmaninfs}">
	        		<tr>
		        		<td style="padding:5px 10px;font-size:14px;">${item.rel_usrname}</td>
		        		<td style="padding:5px 10px;font-size:14px;">${item.relation}</td>
		        		<td style="padding:5px 10px;font-size:14px;">${item.rel_mobile_phone}</td>
	        		</tr>
	        	</c:forEach>
	        </table>
        </div>
    </div>
    <div style="margin-top:20px;width: 94%;text-align:left;" >
    	<h2 style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">二：平台黑名单查询 </h2>
        <c:forEach var="item" items="${blacklistReportLists}">
       		<p style="padding-left:50px;">${item.blacklist_type}：${item.is_hit_str}</p>
       	</c:forEach>
    </div>
    <table width="96%" style="border-spacing:0;border-collapse:collapse;margin-top:20px">
        <caption style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">三：第三方反欺诈信息查询</caption>
        <thead>
        	<tr>
            	<th width="15%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">规则ID</th>
                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">规则名称</th>
                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">描述</th>
                <th width="15%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">结果</th>
                <th width="15%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">是否命中</th>
                <th width="15%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">数据源</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${antiFraudReportLists}">
        		<tr>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.anti_fraud_rule_code}</td>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.anti_fraud_rule_name}</td>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.anti_fraud_rule_desc}</td>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.gather_field_remark}</td>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.is_hit_str}</td>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.gather_type_name}</td>
        		</tr>
        	</c:forEach>
    	</tbody>
    </table>
    <table width="96%" style="border-spacing:0;border-collapse:collapse;margin-top:20px">
        <caption style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">四：信用评分部分</caption>
        <thead>
        	<tr>
            	<th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分规则ID</th>
                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分项</th>
                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">采集字段值</th>
                <th width="10%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">得分</th>
                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">备注</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${scoreReportLists1}">
        		<tr>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_rule_code}</td>
	            	<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_field_name_ch}</td>
	                <td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.gather_field_value}</td>
	               	<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.score}</td>
	                <td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_field_desc}</td>
        		</tr>
        	</c:forEach>
    	</tbody>
    </table>
    <p style="margin-top:10px;">得分总计：${scoreReport.sum_score}分</p>
    <p>建议授信额度：${scoreReport.scoring_quota}元</p>
    <table width="96%" style="border-spacing:0;border-collapse:collapse;margin-top:20px">
        <caption style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">五：客户还款实力</caption>
        <thead>
        	<tr>
            	<th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分规则ID</th>
                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分项</th>
                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">采集字段值</th>
                <th width="10%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">得分</th>
                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">备注</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${scoreReportLists2}">
        		<tr>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_rule_code}</td>
	            	<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_field_name_ch}</td>
	                <td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.gather_field_value}</td>
	               	<td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.score}</td>
	                <td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.scoring_field_desc}</td>
        		</tr>
        	</c:forEach>
    	</tbody>
    </table>
    <h2 style="line-height:35px;margin-top:20px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">还款能力总结：</h2>
    <div style="padding:5px 0;width: 94%;">
    	<p class="text-indent:2em;">${scoreReport.refund_verdict}</p>
    	<br><br>
        <p style="padding:10px 0 0 75%;">评判人：${scoreReport.umpire}</p>
    </div>
    <table width="96%" style="border-spacing:0;border-collapse:collapse;margin-top:20px">
        <caption style="line-height:35px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">六：补充查询部分</caption>
        <thead>
        	<tr>
            	<th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">规则ID</th>
                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">规则名称</th>
                <th width="30%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">描述</th>
                <th style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">结果</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${affiliateRules}">
        		<tr>
	        		<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.rule_code}</td>
            	<td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.rule_name}</td>
                <td style="font-size:14px;border:solid 1px #666;text-align:left;">${item.rule_desc}</td>
                <td style="font-size:14px;border:solid 1px #666;text-align:center;">${item.remark}</td>
        		</tr>
        	</c:forEach>
    	</tbody>
    </table>
    <h2 style="line-height:35px;margin-top:20px;padding:0 10px;font-size:18px;font-weight:normal;text-align:left;color:#333;">结论：</h2>
    <div style="padding:5px 0;width: 94%;">
    	<p class="text-indent:2em;">${scoreReport.first_trial_verdict}</p>
    	<br><br>
        <p style="padding:10px 0 0 75%;">初审人：${scoreReport.first_person}</p>
    </div>
    <div style="margin-top:20px;padding:5px 0;width: 94%;">
    	<p class="text-indent:2em;">${scoreReport.recheck_verdict}</p>
    	<br><br>
        <p style="padding:10px 0 0 75%;">复审人：${scoreReport.recheck_person}</p>
    </div>
    <div style="margin-top:20px;padding:5px 0;width: 94%;">
    	<p class="text-indent:2em;">${scoreReport.last_trial_verdict}</p>
    	<br><br>
        <p style="padding:10px 0 0 75%;">终审人：${scoreReport.last_person}</p>
    </div>
</div>
</form>
	
	<script type="text/javascript">
		var LODOP; //声明为全局变量 
		function prn1_preview() {
			CreateOneFormPage();
			LODOP.PREVIEW();
		};
		function prn1_print() {
			CreateOneFormPage();
			LODOP.PRINT();
		};
		function prn1_printA() {
			CreateOneFormPage();
			LODOP.PRINTA();
		};
		function CreateOneFormPage() {
			LODOP = getLodop('${msUrl}');
			LODOP.PRINT_INIT("打印表单");
			LODOP.SET_PRINT_PAGESIZE(1,"215mm","279mm","CreateCustomPage");
			LODOP.SET_PRINT_STYLE("FontSize", 18);	
			LODOP.ADD_PRINT_HTM("5mm", "0%", "100%", "250mm", document
			.getElementById("form1").innerHTML);
		};
	</script>
</body>
</html>
