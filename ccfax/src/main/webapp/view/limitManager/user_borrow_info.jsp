<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <%-- <link rel="stylesheet" type="text/css" href="${msUrl}/css/viewer.min.css" />
   <script type="text/javascript" src="${msUrl}/js/commons/viewer-jquery.min.js"></script> --%>
</head>

<body>
   
    <div id="userBorrowInfo" style="margin-top: 30px;display: none;">
       <form id="userBorrowInfoForm" method="post" style="margin-top: 10px">
			<table id="userBorrowInfoList"></table>
	    </form>
	 
	 <div id="borrowDetail" style="display:none;padding-top:20px" >   
	 
	   <p style="font-size: 30;font-weight: bold;text-align:center;width:1115px" id="order_title"></p>
	  
	  <div id="tabUserinfoJsp">
	    <%@include file="/view/limitManager/tab_user_info.jsp" %>
	   </div> 
	    
	   <div id="borrowInfo" style="display: none">
	       <div class="ftitle">场景资料</div>
	       <div style="text-align:left;font-size: 15;font-weight: bold" id="biddingPrefix"></div>
	       <table>
	          <tr>
                 <td>
                 	<table class="tbBaseInfo2" width="100%">
                 	   <tr>
							<th align="left">订单号：</th>
							<td align="left">
								<p  id="order_sn"
									name="order_sn" data-options="width:150"></p>
							</td>
							<th align="left">商家联系人：</th>
							<td align="left"><p class="easyui-validatebox member-input" id="store_contract"
									name="store_contract" data-options="width:150"></p></td>
					 </tr>
					  <tr>
							<th align="left">商家名称：</th>
							<td align="left">
								<p class="easyui-validatebox member-input" id="store_name"
									name="store_name" data-options="width:150"></p>
							</td>
							<th align="left">联系人手机号：</th>
							<td align="left"><p class="easyui-validatebox member-input" id="store_tel"
									name="store_tel" data-options="width:150"></p></td>
					 </tr>
					 <tr>
							<th align="left">分期金额：</th>
							<td align="left">
								<p class="easyui-validatebox member-input" id="order_money"
									name="order_money" data-options="width:150"></p>
							</td>
							<th align="left">期数：</th>
							<td align="left"><p class="easyui-validatebox member-input" id="amortization_cnt"
									name="amortization_cnt" data-options="width:150"></p>
						   </td>
					 </tr>
					  <tr>
							<th align="left">月供：</th>
							<td align="left" colspan="4">
								<p class="easyui-validatebox member-input" id="amortization_money"
									name="amortization_money" data-options="width:150"></p>
							</td>
					 </tr>
					   <tr>
							<th align="left">分期资料：</th>
							<td align="left" colspan="4">
								<div id="order_pic">
								
								</div>
							</td>
					 </tr>
                 	</table>          
	             </td>
	          </tr>
	       </table>
	   </div> 
	
	   </div>
	   
	   
	   
	   
	   
    </div>
</body>
</html>