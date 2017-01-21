<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
       <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	 <form id="searchForm">
 	  	<p class="ui-fields">
            <label class="ui-label">标号ID: </label>
            <input name="borrow_id" class="easyui-box ui-text" style="width:100px;">
        </p>
 	  	<p class="ui-fields">
            <label class="ui-label">转让人: </label>
            <input name="user_name" class="easyui-box ui-text" style="width:100px;">
        </p>
 	  	<p class="ui-fields">
            <label class="ui-label">提交时间: </label>
            <input class="easyui-datetimebox" type="text" name="start_time">
 	 	   	 到
 	 	   	<input class="easyui-datetimebox" type="text" name="end_time">
        </p>
 	  	<p class="ui-fields">
            <label class="ui-label">当前状态: </label>
            <select name="borrow_status" style="width:200px;">
 	 	    	<option value="7" selected="selected">全部</option>
 	 	    	<option value="0">待审核</option>
 	 	    	<option value="1">出售中</option>
 	 	    	<option value="2">审核未通过</option>
 	 	    	<option value="3">已撤销</option>
 	 	    	<option value="6">已成功</option>
 	 	    </select>
        </p>
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
     
     <!-- Edit Password Form -->
     <div id="edit-win" class="easyui-dialog" buttons="#editBtn" title="债权初审" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:250px;">
     		<br>
     		<input class="hidden" id="borrow_id">
     		<div style="padding:10px;">
     			<table width="100%" class="tbBaseInfo">
	     			<tr>
	     				<th align="left">是否通过：</th>
	     				<td align="left">
	     					<input type="radio" name="type_" id="tongguo"/>通过
                			<input type="radio" name="type_" id="butongguo"/>不通过
                		</td>
	     			</tr>
	     			<tr>
	     				<th align="left">审核处理意见：</th>
	     				<td align="left">
	     					<textarea name="remark" id="remark" style="width:200px;height:80px;">
               				</textarea>
	     				</td>
	     			</tr>
	     		</table>
     		</div>
     		
     	 <div id="editBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>  
        </div>
  	 </div> 
     
    <!-- 查看审核记录  -->
     <div style="display:none">
	     <div id="borrowCheckRecord-win" style="width:800px;height:400px;" buttons="#borrowCheckRecordButton" class="easyui-dialog" title="审核记录 " data-options="closed:true,iconCls:'icon-select',modal:true">
	     	  <table width="100%" id="borrowCheckRecordTable">
   				 	
				</table>
	     </div> 
	 </div>
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/debtList.js"></script>

 </body>
</html>
