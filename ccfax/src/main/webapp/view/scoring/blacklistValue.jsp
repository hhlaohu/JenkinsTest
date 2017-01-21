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
 	 	    <label class="ui-label">黑名单值:</label>
 	 	    <input name="search_blacklist_value" id="search_blacklist_value" class="easyui-box ui-text" style="width:150px;">
        </p>
        <p class="ui-fields">
            <label class="ui-label">激活状态: </label>
       		<select class="easyui-combobox" name="is_active" id="is_active" style="width:120px;">
              	<option value="1">激活</option>
           		<option value="0">未激活</option>
             </select>
        </p>
         <p class="ui-fields">
	        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;
        </p>
      </form>  
     </div>
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
     

     <!-- Edit Form -->
     <div style="display:none">
     <div id="edit-win" class="easyui-dialog" title="黑名单管理" buttons="#edit_blacklist_value" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:220px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" id="id">
     		 <div class="ui-edit">
  	     	   <table width="100%">
     			<tr style="height:50px;">
     				<td align="right"style="width:100px">黑名单类型：</td>
     				<td align="left">
  	     	    	 	    <select class="easyui-combobox" id="blacklist_type_id" name="blacklist_type_id" style="width:200px;">
			 	 	   		 </select>
			 	 	   		 <span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:50px;">
     				<td align="right"style="width:100px">黑名单值：</td>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="blacklist_value" id="blacklist_value" maxlength="64" style="width:300px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>

     			</table>
	         </div>
	          <div id="edit_blacklist_value" class="dialog-button">
	          <a href="#" id="btn-blacklist_value-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-blacklist_value-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-blacklist_value-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoring/blacklistValue.js"></script>
  </body>
</html>
