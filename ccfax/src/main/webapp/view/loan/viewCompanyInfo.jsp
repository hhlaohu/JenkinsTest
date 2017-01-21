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
<h3>企业基本信息</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="15%" align="right">公司名称：</td>
			<td>${companyData_temp.company_name}</td>
		</tr>
		<tr>
			<td align="right">企业地址：</td>
			<td>${companyData_temp.address}</td>
		</tr>
		<tr>
			<td align="right">执照号：</td>
			<td>${companyData_temp.license_no}</td>
		</tr>
		<tr>
			<td align="right">执照过期时间：</td>
			<td>${companyData_temp.license_expire_date}</td>
		</tr>
		<tr>
			<td align="right">营业执照地址：</td>
			<td>${companyData_temp.license_address}</td>
		</tr>
		<tr>
			<td align="right">营业范围：</td>
			<td>${companyData_temp.business_scope}</td>
		</tr>
		<tr>
			<td align="right">企业简介：</td>
			<td>${companyData_temp.summary}</td>
		</tr>
		<tr>
			<td align="right">企业组织机构代码：</td>
			<td>${companyData_temp.organization_no}</td>
		</tr>
		<tr>
			<td align="right">企业资质：</td>
			<td>
				<c:forEach items="${pics}" var="item">
					<a class="acli" href="${item}">
						<img width="150px" height="150px" alt="缺失" src="${item}">
					</a>
					&nbsp;&nbsp;
				</c:forEach>
			</td>
		</tr>
	</table>
</div>
<br>
<h3>企业银行账号信息</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="15%" align="right">银行名称：</td>
			<td>${companyData_temp.bank_name}</td>
		</tr>
		<tr>
			<td align="right">银行卡号：</td>
			<td>${companyData_temp.bank_num}</td>
		</tr>
		<tr>
			<td align="right">开户行：</td>
			<td>${companyData_temp.bank_province}-${companyData_temp.bank_city}</td>
		</tr>
		<tr>
			<td align="right"></td>
			<td>${companyData_temp.bank_address}</td>
		</tr>
	</table>
</div>
<br>
<h3>企业联系方式</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="15%" align="right">企业法定代表人：</td>
			<td>${companyData_temp.legal_person}</td>
		</tr>
		<tr>
			<td align="right">企业电话：</td>
			<td>${companyData_temp.telephone}</td>
		</tr>
		<tr>
			<td align="right">法人手机号码：</td>
			<td>${companyData_temp.legal_person_phone}</td>
		</tr>
		<tr>
			<td align="right">企业邮箱：</td>
			<td>${companyData_temp.email}</td>
		</tr>
		<tr>
			<td align="right">企业法人证件号码</td>
			<td>${companyData_temp.cert_no}</td>
		</tr>
	</table>
</div>
<br>
<h3>经办人联系方式</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="15%" align="right">经办人姓名：</td>
			<td>${companyData_temp.agent_name}</td>
		</tr>
		<tr>
			<td align="right">经办人手机：</td>
			<td>${companyData_temp.agent_mobile}</td>
		</tr>
		<tr>
			<td align="right">经办人身份证：</td>
			<td>${companyData_temp.alicense_no}</td>
		</tr>
	</table>
</div>
<br>
<h3>申请借款信息</h3>
<div style="padding: 20px;">
	<table width="80%">
		<tr>
			<td width="15%" align="right">渠道：</td>
			<td>${loanData.qudao}</td>
		</tr>
		<tr>
			<td align="right">借款用途：</td>
			<td>${loanData.purpose}</td>
		</tr>
		<tr>
			<td align="right">借款金额：</td>
			<td>${loanData.amount}</td>
		</tr>
		<tr>
			<td align="right">借款时长：</td>
			<td>${loanData.deadline}</td>
		</tr>
	</table>
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
