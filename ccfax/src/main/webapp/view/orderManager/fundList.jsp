<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">用户ID:</label>
 	 	    <input name="borrow_uid" class="easyui-box ui-text" style="width:120px;">
        </p>
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">借款人:</label>
 	 	    <input name="borrower_usrname" class="easyui-box ui-text" style="width:120px;">
        </p>
 	 	
        <p class="ui-fields">
		     <label>类型:</label>  
             <select class="easyui-combobox" name="order_type" style="width:120px;">
                <option value="" selected="selected">请选择</option>
             	<c:forEach items="${dataList}" var="item">
                	<option value="${item.order_type}">${item.name}</option>
             	</c:forEach>
             </select>
 	 	</p>
        <p class="ui-fields">
		     <label>资金渠道:</label>  
             <select class="easyui-combobox" name="order_allot" style="width:120px;">
                <option value="" selected="selected">请选择</option>
                <option value="0">未分配</option>
                <option value="1">p2p平台融资</option>
                <option value="2">自有资金</option>
                <option value="3">银行资金</option>
             </select>
 	 	</p>
        <p class="ui-fields">
 	 	    <label class="ui-label">订单号:</label>
 	 	    <input name="order_sn" class="easyui-box ui-text" style="width:150px;">
        </p>
        <p class="ui-fields">
	        <label>提交时间:</label>  
		    <input class="easyui-datetimebox" type="text" name="start_time_str">
		    <label>--</label>  
		    <input class="easyui-datetimebox" type="text" name="end_time_str">
	    </p>
 	 	&nbsp;&nbsp;
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>&nbsp;&nbsp;
      </form>  
     </div>
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     	<table id="data-list"></table>
     </form>
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/orderManager/fundList.js?timestamp="<%=new Date().getTime() %>></script>
  </body>
</html>
