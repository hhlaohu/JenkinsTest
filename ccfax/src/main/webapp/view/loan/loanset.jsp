<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <%@include file="/view/resource.jsp" %>
<style type="text/css">
table{border-collapse:separate;border-spacing:10px;} 
</style>
</head>
<body>
<div style="padding: 20px;">
<%
Object code = request.getAttribute("code");
if(!"0".equals(code.toString())){
%>
<br>
${msg}
<%
}else{
%>

<div style="padding: 20px;">
	单日允许申请借款笔数：<input width="100px" height="20px" id="loan_value" type="text" value="${loan_value}">
	<input type="button" value="保存" onclick="save()">
</div>
<%
}
%>
</body>
<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script>
function save(){
	var loan_value = $("#loan_value").val();
	YiYa.confirm('提示', '确定修改？', function(r){
		if(r){
			
			YiYa.ajaxJson('update_loan_value.do', "loan_value="+loan_value, function(data){
				if(data.code == 0){
					location.href='loanset.shtml';
				}else{
					YiYa.alert('提示', data.msg, 'error');
				}
			});
		}
	});
}
</script>
</html>
