<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <%@include file="/view/resource.jsp" %>
<link href="${msUrl}/css/lanrenzhijia.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
td, th {
    padding: 10px;
}
.acli{}
.tab_menu {
	float: left;
	overflow: hidden;
}
</style>
</head>
<body>
<input type="hidden" id="usr_order_id" value="${usr_order_id}">
<input type="hidden" id="is_check" value="${is_check}">
<div style="padding: 20px;">
	<ul class="nav nav-pills">
		<li id="li1" class="active"><a href="#">订单审核</a></li>
		<li id="li2"><a href="#">借款资料</a></li>
		<li id="li3"><a href="#">评分报告</a></li>
	</ul>
	<!-- 订单审核div开始 -->
	<div id="main1" style="padding:30px;">
		<h3>订单信息</h3>
		<table width="80%" border="1">
			<tr>
				<td align="center">订单号</td>
				<td align="center">订单时间</td>
				<td align="center">分期金额</td>
				<td align="center">分期期数</td>
				<td align="center">月供</td>
				<td align="center">操作</td>
			</tr>
			<tr>
				<td align="center">${borrowUserOrder.order_sn}</td>
				<td align="center">${borrowUserOrder.create_time}</td>
				<td align="center">${borrowUserOrder.order_money}</td>
				<td align="center">${borrowUserOrder.amortization_cnt}</td>
				<td align="center">${borrowUserOrder.amortization_money}</td>
				<td align="center"><a href="#">查看合同</a></td>
			</tr>
		</table>
		<h3>商家信息</h3>
		<table width="80%" border="1">
			<tr>
				<td align="center">商家ID</td>
				<td align="center">门店名称</td>
				<td align="center">联系人</td>
				<td align="center">电话</td>
				<td align="center">地址</td>
			</tr>
			<tr>
				<td align="center">${borrowUserOrder.store_uid}</td>
				<td align="center">${borrowUserOrder.store_name}</td>
				<td align="center">${borrowUserOrder.store_contract}</td>
				<td align="center">${borrowUserOrder.store_tel}</td>
				<td align="center"></td>
			</tr>
		</table>
		<h3>借款人信息</h3>
		<table width="80%" border="1">
			<tr>
				<td align="center">用户ID</td>
				<td align="center">借款人</td>
				<td align="center">手机号</td>
				<td align="center">证件号</td>
				<td align="center">操作</td>
			</tr>
			<tr>
				<td align="center">${borrowUserOrder.borrow_uid}</td>
				<td align="center">${borrowUserOrder.borrower_usrname}</td>
				<td align="center">${borrowUserOrder.borrower_mobile_phone}</td>
				<td align="center">${borrowUserOrder.borrower_id_card}</td>
				<td align="center">
					<a href="#" onclick="viewBorrowInfo()">查看借款资料</a>
				</td>
			</tr>
		</table>
		<%
			Object is_check = request.getAttribute("is_check");
			if(!"1".equals(is_check.toString())){
		%>
		<h3>审核日志</h3>
		<table width="80%" border="1">
			<tr>
				<td align="center" width="20%">时间</td>
				<td align="center">操作人</td>
				<td align="center">结果</td>
				<td align="center">意见</td>
			</tr>
			<c:forEach items="${tabOrderCheckLogs}" var="item">
				<tr>
					<td align="center">${item.deal_time_}</td>
					<td align="center">${item.deal_user}</td>
					<td align="center">${item.check_result}</td>
					<td align="left">${item.check_remark}</td>
				</tr>
			</c:forEach>
		</table>
		<%
			}
		%>
		<%
			if("1".equals(is_check.toString())){
		%>
			<hr style="width:80%;height:2px;border:none;border-top:2px dotted #185598;" />
			<form id="orderForm">
				<input type="hidden" value="${is_check}" name="is_check">
				<input type="hidden" value="${borrowUserOrder.usr_order_id}" name="usr_order_id">
				<table width="80%">
					<tr>
						<td align="center">订单初审</td>
						<td align="left">
							<input checked="checked" type="radio" value="1" name="check_status">通过
							<input type="radio" value="4" name="check_status">不通过
						</td>
					</tr>
					<tr>
						<td align="center">审核意见</td>
						<td align="left">
							<textarea rows="10" cols="50" name="check_remark"></textarea>
						</td>
					</tr>
					<tr>
						<td align="center"></td>
						<td align="left">
							<input onclick="submitForm()" type="button" value="提交" style="padding:10 30 10 30;">
						</td>
					</tr>
				</table>
			</form>
		<%
			}else if("2".equals(is_check.toString())){
		%>
			<hr style="width:80%;height:2px;border:none;border-top:2px dotted #185598;" />
			<form id="orderForm">
				<input type="hidden" value="${is_check}" name="is_check">
				<input type="hidden" value="${borrowUserOrder.usr_order_id}" name="usr_order_id">
				<table width="80%">
					<tr>
						<td align="center">订单复审</td>
						<td align="left">
							<input checked="checked" type="radio" value="2" name="check_status">通过
							<input type="radio" value="5" name="check_status">不通过
						</td>
					</tr>
					<tr>
						<td align="center">审核意见</td>
						<td align="left">
							<textarea rows="10" cols="50" name="check_remark"></textarea>
						</td>
					</tr>
					<tr>
						<td align="center"></td>
						<td align="left">
							<input onclick="submitForm()" type="button" value="提交" style="padding:10 30 10 30;">
						</td>
					</tr>
				</table>
			</form>
		<%	
			}else if("3".equals(is_check.toString())){
		%>
			<hr style="width:80%;height:2px;border:none;border-top:2px dotted #185598;" />
			<form id="orderForm">
				<input type="hidden" value="${is_check}" name="is_check">
				<input type="hidden" value="${borrowUserOrder.usr_order_id}" name="usr_order_id">
				<table width="80%">
					<tr>
						<td align="center">订单终审</td>
						<td align="left">
							<input checked="checked" type="radio" value="3" name="check_status">通过
							<input type="radio" value="6" name="check_status">不通过
						</td>
					</tr>
					<tr>
						<td align="center">审核意见</td>
						<td align="left">
							<textarea rows="10" cols="50" name="check_remark"></textarea>
						</td>
					</tr>
					<tr>
						<td align="center"></td>
						<td align="left">
							<input onclick="submitForm()" type="button" value="提交" style="padding:10 30 10 30;">
						</td>
					</tr>
				</table>
			</form>
		<%	
			}
		%>
	</div>
	<!-- 订单审核div结束 -->
	
	<!-- 借款资料div开始 -->
	<div id="main2" style="padding:30px;">
		<h3>客户基本信息部分</h3>
		<div style="padding: 20px;">
			<table width="80%">
				<tr>
					<td width="40%">*姓名：${borrowUserOrder.borrower_usrname}</td>
					<td>*手机：${borrowUserOrder.borrower_mobile_phone}</td>
				</tr>
				<tr>
					<td>*身份证号：${borrowUserOrder.borrower_id_card}</td>
					<td>*婚姻状况：${borrowUserOrder.marital_}</td>
				</tr>
				<tr>
					<td>*学历：${borrowUserOrder.diploma_}</td>
					<td>*个人年收入：${borrowUserOrder.income_}</td>
				</tr>
				<tr>
					<td>*户籍地址：${borrowUserOrder.register_place_}</td>
					<td>*拥有固定资产：${borrowUserOrder.fixed_assets_}</td>
				</tr>
				<tr>
					<td>*银行卡号：${borrowUserOrder.bank_id}</td>
					<td>*住房状态：${borrowUserOrder.house_type_}</td>
				</tr>
				<tr>
					<td>*现工作单位时间：${borrowUserOrder.cur_hire_duration_}</td>
					<td>*所属行业：${borrowUserOrder.industry_}</td>
				</tr>
				<tr>
					<td colspan="2">*职称：${borrowUserOrder.profession_level_}</td>
				</tr>
			</table>
		</div>
		<br>
		<h3>联系人信息</h3>
		<div style="padding: 20px;">
			<table width="40%">
				<tr>
					<td>姓名</td>
					<td>关系</td>
					<td>手机</td>
				</tr>
				<c:forEach items="${tabOrderBondsmaninfs}" var="item">
					<tr>
						<td>${item.rel_usrname}</td>
						<td>${item.relation_}</td>
						<td>${item.rel_mobile_phone}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<h3>身份证信息</h3>
		<div style="padding: 20px;">
			手持身份证正面照<br><br>
			<a class="acli" href="${borrowUserOrder.with_id_card_pic}">
				<img width="200px;" height="200px;" alt="缺失" src="${borrowUserOrder.with_id_card_pic}">
			</a>
			<br><br>
			身份证<br><br>
			<a class="acli" href="${borrowUserOrder.id_card_front_pic}">
				<img width="200px;" height="200px;" alt="缺失" src="${borrowUserOrder.id_card_front_pic}">
			</a>
			<a class="acli" href="${borrowUserOrder.id_card_reverse_pic}">
				<img width="200px;" height="200px;" alt="缺失" src="${borrowUserOrder.id_card_reverse_pic}">
			</a>
		</div>
		<br>
		<h3>场景资料</h3>
		<div style="padding: 20px;">
			<h4>${borrowUserOrder.store_type_name}分期</h4>
			<div style="padding: 20px;">
				<table width="50%">
					<tr>
						<td>订单号：${borrowUserOrder.order_sn}</td>
						<td>商家联系人：${borrowUserOrder.store_contract}</td>
					</tr>
					<tr>
						<td>商家名称：${borrowUserOrder.store_name}</td>
						<td>联系人手机：${borrowUserOrder.store_tel}</td>
					</tr>
					<tr>
						<td>分期金额：${borrowUserOrder.order_money}元</td>
						<td>期数：${borrowUserOrder.amortization_cnt}期</td>
					</tr>
					<tr>
						<td colspan="2">月供：${borrowUserOrder.amortization_money}</td>
					</tr>
					<tr>
						<td colspan="2">住房情况：${borrowUserOrder.house_type_}</td>
					</tr>
					<tr>
						<td colspan="2">固定资产：${borrowUserOrder.fixed_assets_}</td>
					</tr>
				</table>
				<br>
				<div style="padding:10px;">
					图片资料
					<br><br>
					<c:forEach items="${pics}" var="item">
						<a class="acli" href="${item}">
							<img width="200px;" height="200px;" alt="缺失" src="${item}">
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<br>
		<h3>人体动态验证信息</h3>
		<div style="padding: 20px;">
			<table width="40%">
				<tr>
					<td>姓名：${borrowUserOrder.borrower_usrname}</td>
				</tr>
				<tr>
					<td>身份证号：${borrowUserOrder.borrower_id_card}</td>
				</tr>
			</table>
			<div style="padding:10px;">
				动态验证随机抽取照片
				<br><br>
				<a class="acli" href="${borrowUserOrder.check_alive_pic}">
					<img width="200px;" height="200px;" alt="缺失" src="${borrowUserOrder.check_alive_pic}">
				</a>
			</div>
			<table width="40%">
				<tr>
					<td>活体验证结果：${borrowUserOrder.xiaoshi_check_alive_result_}</td>
				</tr>
				<tr>
					<td>人像对比结果：${borrowUserOrder.xiaoshi_id_card_check_result}</td>
				</tr>
			</table>
			<div style="padding:10px;">
				<p>1: 身份证号与姓名匹配，且比对成功</p>
				<p>2: 身份证核查成功，但人脸比对失败</p>
				<p>3: 身份证号与姓名不匹配</p>
				<p>4: 身份证号不存在</p>
				<p>-1: 异常情况</p>
			</div>
			<table width="40%">
				<tr>
					<td>状态描述信息：${borrowUserOrder.xiaoshi_id_card_check_msg}</td>
				</tr>
				<tr>
					<td>小视科技会话号：${borrowUserOrder.xiaoshi_id_card_check_guid}</td>
				</tr>
				<tr>
					<td>比对分值：${borrowUserOrder.xiaoshi_id_card_check_score}</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 借款资料div结束 -->
	
	<!-- 评分报告div开始 -->
	<div id="main3" style="padding:30px;width: 70%;">
		<div align="left"><a style="font-size: 20px;color: red;" href="../userManager/printReport.do?report_id=${scoreReport.report_id}" target="_blank">打印预览</a></div>
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
		    <div style="margin-top:10px;padding-top:10px;border-top:solid 1px #dedede;width: 96%;" >
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
		    <div style="margin-top:20px;width: 96%;text-align:left;" >
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
		            	<th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分规则ID</th>
		                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分项</th>
		                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">采集字段值</th>
		                <th width="10%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">得分</th>
		                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">备注</th>
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
		            	<th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分规则ID</th>
		                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">评分项</th>
		                <th width="25%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">采集字段值</th>
		                <th width="10%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">得分</th>
		                <th width="20%" style="padding:5px 10px;font-size:16px;font-weight:normal;background-color:#f5f5f5;border:solid 1px #666;text-align:center;">备注</th>
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
		    <div style="padding:5px 0;width: 96%;">
		    	<form id="umpireForm">
		    		<input type="hidden" value="${scoreReport.report_id}" name="report_id">
			    	<p class="text-indent:2em;">
			    		<textarea rows="5" cols="145" name="refund_verdict">${scoreReport.refund_verdict}</textarea>
			    	</p>
			        <p>评判人：<input name="umpire" type="text" value="${scoreReport.umpire}"></p>
		   			<p>
			    		<input onclick="submitUmpireForm()" type="button" value="保存" style="padding:2 5 2 5;">
			    	</p>
		   		</form>
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
		    <div style="padding:5px 0;width: 96%;">
		        <form id="firstPersonForm">
		        	<input type="hidden" value="${scoreReport.report_id}" name="report_id">
			    	<p class="text-indent:2em;">
			    		<textarea rows="5" cols="145" name="first_trial_verdict">${scoreReport.first_trial_verdict}</textarea>
			    	</p>
			        <p>初审人：<input name="first_person" type="text" value="${scoreReport.first_person}"></p>
		   			<p>
			    		<input onclick="submitFirstPersonForm()" type="button" value="保存" style="padding:2 5 2 5;">
			    	</p>
		   		</form>
		    </div>
		    <div style="margin-top:20px;padding:5px 0;width: 96%;">
		        <form id="recheckForm">
		        	<input type="hidden" value="${scoreReport.report_id}" name="report_id">
			    	<p class="text-indent:2em;">
			    		<textarea rows="5" cols="145" name="recheck_verdict">${scoreReport.recheck_verdict}</textarea>
			    	</p>
			        <p>复审人：<input name="recheck_person" type="text" value="${scoreReport.recheck_person}"></p>
		   			<p>
			    		<input onclick="submitRecheckForm()" type="button" value="保存" style="padding:2 5 2 5;">
			    	</p>
		   		</form>
		    </div>
		    <div style="margin-top:20px;padding:5px 0;width: 96%;">
		        <form id="lastForm">
		        	<input type="hidden" value="${scoreReport.report_id}" name="report_id">
			    	<p class="text-indent:2em;">
			    		<textarea rows="5" cols="145" name="last_trial_verdict">${scoreReport.last_trial_verdict}</textarea>
			    	</p>
			        <p>终审人：<input name="last_person" type="text" value="${scoreReport.last_person}"></p>
		   			<p>
			    		<input onclick="submitLastForm()" type="button" value="保存" style="padding:2 5 2 5;">
			    	</p>
		   		</form>
		    </div>
		</div>
	</div>
	<!-- 评分报告div结束 -->
</div>
<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script src="${msUrl}/js/jquery.min.js"></script>
<script src="${msUrl}/js/jquery.imgbox.pack.js"></script>
<script>
$(function(){
	var have_scoring_report = '${borrowUserOrder.have_scoring_report}';
	$(".acli").imgbox();
	
	$("#main2").hide();
	$("#main3").hide();
	
	$("#li1").click(function(){
		$(this).addClass("active");
		$("#li2").removeClass("active");
		$("#li3").removeClass("active");
		$("#main1").show();
		$("#main2").hide();
		$("#main3").hide();
	});
	$("#li2").click(function(){
		$(this).addClass("active");
		$("#li1").removeClass("active");
		$("#li3").removeClass("active");
		$("#main2").show();
		$("#main1").hide();
		$("#main3").hide();
	});
	$("#li3").click(function(){
		if(have_scoring_report == 0){
			alert('还未生成评分报告');
		}else{
			$(this).addClass("active");
			$("#li2").removeClass("active");
			$("#li1").removeClass("active");
			$("#main3").show();
			$("#main2").hide();
			$("#main1").hide();
		}
	});
});
function viewBorrowInfo(){
	$("#li2").addClass("active");
	$("#li1").removeClass("active");
	$("#li3").removeClass("active");
	$("#main2").show();
	$("#main1").hide();
	$("#main3").hide();
}
function submitForm(){
	$.ajax({  
	    type: "POST",  
	    url:"updateCheckStatus.do",  
	    data:$('#orderForm').serialize(),// 序列化表单值  
	    async: false,  
	    error: function(request) {  
	        alert('Connection error');
	    },  
	    success: function(data) { 
	     	var json = eval('(' + data + ')');
	        if(json.code == 0){
	        	location.href='orderList.shtml';
	        }else{
	        	alert(json.msg);
	        }
	    }  
	});  
}
function submitUmpireForm(){
	var usr_order_id = $('#usr_order_id').val();
	var is_check = $('#is_check').val();
	$.ajax({  
	    type: "POST",  
	    url:"updateUmpire.do",  
	    data:$('#umpireForm').serialize(),// 序列化表单值  
	    async: false,  
	    error: function(request) {  
	        alert('Connection error');
	    },  
	    success: function(data) { 
	     	var json = eval('(' + data + ')');
	        if(json.code == 0){
	        	location.href='viewOrderById.shtml?usr_order_id='+usr_order_id+'&is_check='+is_check;
	        }else{
	        	alert(json.msg);
	        }
	    }  
	});  
}
function submitFirstPersonForm(){
	var usr_order_id = $('#usr_order_id').val();
	var is_check = $('#is_check').val();
	$.ajax({  
	    type: "POST",  
	    url:"updateFirstPerson.do",  
	    data:$('#firstPersonForm').serialize(),// 序列化表单值  
	    async: false,  
	    error: function(request) {  
	        alert('Connection error');
	    },  
	    success: function(data) { 
	     	var json = eval('(' + data + ')');
	        if(json.code == 0){
	        	location.href='viewOrderById.shtml?usr_order_id='+usr_order_id+'&is_check='+is_check;
	        }else{
	        	alert(json.msg);
	        }
	    }  
	});  
}
function submitRecheckForm(){
	var usr_order_id = $('#usr_order_id').val();
	var is_check = $('#is_check').val();
	$.ajax({  
	    type: "POST",  
	    url:"updateRecheck.do",  
	    data:$('#recheckForm').serialize(),// 序列化表单值  
	    async: false,  
	    error: function(request) {  
	        alert('Connection error');
	    },  
	    success: function(data) { 
	     	var json = eval('(' + data + ')');
	        if(json.code == 0){
	        	location.href='viewOrderById.shtml?usr_order_id='+usr_order_id+'&is_check='+is_check;
	        }else{
	        	alert(json.msg);
	        }
	    }  
	});  
}
function submitLastForm(){
	var usr_order_id = $('#usr_order_id').val();
	var is_check = $('#is_check').val();
	$.ajax({  
	    type: "POST",  
	    url:"updateLast.do",  
	    data:$('#lastForm').serialize(),// 序列化表单值  
	    async: false,  
	    error: function(request) {  
	        alert('Connection error');
	    },  
	    success: function(data) { 
	     	var json = eval('(' + data + ')');
	        if(json.code == 0){
	        	location.href='viewOrderById.shtml?usr_order_id='+usr_order_id+'&is_check='+is_check;
	        }else{
	        	alert(json.msg);
	        }
	    }  
	});  
}
</script>

</body>
</html>
