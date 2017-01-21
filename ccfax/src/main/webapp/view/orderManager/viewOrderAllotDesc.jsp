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
<input type="hidden" id="allot" value="${allot}">
<div style="padding: 20px;">
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
			</tr>
			<tr>
				<td align="center">${borrowUserOrder.borrow_uid}</td>
				<td align="center">${borrowUserOrder.borrower_usrname}</td>
				<td align="center">${borrowUserOrder.borrower_mobile_phone}</td>
				<td align="center">${borrowUserOrder.borrower_id_card}</td>
			</tr>
		</table>
		<%
			Object allot = request.getAttribute("allot");
			if(!"1".equals(allot.toString())){
		%>
		<h3>操作日志</h3>
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
			if("1".equals(allot.toString())){
		%>
			<hr style="width:80%;height:2px;border:none;border-top:2px dotted #185598;" />
			<form id="orderForm">
				<input type="hidden" value="${borrowUserOrder.usr_order_id}" name="usr_order_id">
				<table width="80%">
					<tr>
						<td align="center">资金分配</td>
						<td align="left">
							<input checked="checked" type="radio" value="1" name="order_allot">P2P资金
							<input type="radio" value="2" name="order_allot">自有资金
							<input type="radio" value="3" name="order_allot">银行资金
						</td>
					</tr>
					<tr>
						<td align="center">备注</td>
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
</div>
<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script>
function submitForm(){
	$.ajax({  
	    type: "POST",  
	    url:"updateOrderAllot.do",  
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
</script>

</body>
</html>
