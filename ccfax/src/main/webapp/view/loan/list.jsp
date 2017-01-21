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
 	 	    <label class="ui-label">ID:</label>
 	 	    <input name="uid" id="uid" class="easyui-box ui-text" style="width:120px;">
        </p>
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">手机号:</label>
 	 	    <input name="phone" id="phone" class="easyui-box ui-text" style="width:120px;">
        </p>
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">身份证:</label>
 	 	    <input name="idcard" id="idcard" class="easyui-box ui-text" style="width:120px;">
        </p>
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">姓名:</label>
 	 	    <input name="uname" id="uname" class="easyui-box ui-text" style="width:120px;">
        </p>
        <p class="ui-fields">
		     <label>类型:</label>  
             <select class="easyui-combobox" name="user_type" id="user_type" style="width:120px;">
                <option value="" selected="selected">请选择</option>
             	<option value="1">个人</option>
             	<option value="2">企业</option>
             </select>
 	 	</p>
        <p class="ui-fields">
		     <label>状态:</label>  
             <select class="easyui-combobox" name="status" id="status" style="width:120px;">
                <option value="" selected="selected">请选择</option>
             	<option value="0">待处理</option>
             	<option value="1">已处理</option>
             </select>
 	 	</p>
 	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
<script type="text/javascript" src="${msUrl}/js/ux/loan/list.js?timestamp="<%=new Date().getTime() %>></script>
  </body>
</html>
