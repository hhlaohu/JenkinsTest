<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="${msUrl}/css/lanrenzhijia.css" type="text/css" rel="stylesheet" />
<style type="text/css">
table{border-collapse:separate;border-spacing:10px;} 
.acli{}
.acli1{}
</style>
</head>
<body>
<div style="padding: 20px;">
	<a href="#" onClick="javascript :history.back(-1);">返回</a>
<%
Object code = request.getAttribute("code");
if(!"0".equals(code.toString())){
%>
<br>
${msg}
<%
}else{
%>
<br><br>
<h3>客户基本信息部分</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="40%">*姓名：${loanDesc.uname}</td>
			<td>*手机：${loanDesc.phone}</td>
		</tr>
		<tr>
			<td>*身份证号：${loanDesc.idcard}</td>
			<td>*婚姻状况：${loanDesc.marray}</td>
		</tr>
		<tr>
			<td>*学历：${loanDesc.xueli}</td>
			<td>*个人年收入：${loanDesc.income}</td>
		</tr>
		<tr>
			<td>*户籍地址：${loanDesc.province}${loanDesc.city}${loanDesc.area}</td>
			<td>*拥有固定资产：${loanDesc.asset}</td>
		</tr>
		<tr>
			<td>*银行卡号：${loanDesc.bankcard}</td>
			<td>*住房状态：${loanDesc.zhufang}</td>
		</tr>
		<tr>
			<td>*现工作单位时间：${loanDesc.work_time}</td>
			<td>*所属行业：${loanDesc.work}</td>
		</tr>
		<tr>
			<td colspan="2">*职称：${loanDesc.position}</td>
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
		<c:forEach items="${contacts}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.relation}</td>
				<td>${item.phone}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<br>
<h3>身份证信息</h3>
<div style="padding: 20px;">
手持身份证正面照<br><br>
<a class="acli" href="${loanDesc.handcard_pic_m}">
	<img alt="缺失" src="${loanDesc.handcard_pic_s}">
</a>
<br><br>
身份证<br><br>
<a class="acli" href="${loanDesc.id_card_front_pic_m}">
	<img alt="缺失" src="${loanDesc.id_card_front_pic_s}">
</a>
<a class="acli" href="${loanDesc.id_card_reverse_pic_m}">
	<img alt="缺失" src="${loanDesc.id_card_reverse_pic_s}">
</a>
</div>
<br>
<h3>申请借款信息</h3>
<div style="padding: 20px;">
	<table width="20%">
		<tr>
			<td>渠道：${loanDesc.qudao}</td>
		</tr>
		<tr>
			<td>借款用途：${loanDesc.purpose}</td>
		</tr>
		<tr>
			<td>借款金额：${loanDesc.amount}</td>
		</tr>
		<tr>
			<td>借款时长：${loanDesc.deadline}</td>
		</tr>
	</table>
</div>
<br>
<h3>征信报告</h3>
<div style="padding: 20px;">
	<c:forEach items="${zhengxinPicList}" var="item">
		<a class="acli" href="${item.m_pic}">
			<img alt="缺失" src="${item.s_pic}">
		</a>
	</c:forEach>
</div>
<br>
<h3>银行流水</h3>
<div style="padding: 20px;">
	<c:forEach items="${bankstatePicList}" var="item">
		<a class="acli" href="${item.m_pic}">
			<img alt="缺失" src="${item.s_pic}">
		</a>
	</c:forEach>
</div>
<%
}
%>
</div>
</body>
<script src="${msUrl}/js/jquery.min.js"></script>
<script src="${msUrl}/js/jquery.imgbox.pack.js"></script>
<script>
$(function(){
	$(".acli").imgbox();
	$(".acli1").imgbox({
		'speedIn'		: 0,
		'speedOut'		: 0,
		'alignment'		: 'center',
		'overlayShow'	: true,
		'allowMultiple'	: false
	});
});
</script>
</html>
