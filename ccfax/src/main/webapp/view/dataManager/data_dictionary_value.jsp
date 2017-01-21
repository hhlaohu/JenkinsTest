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
            <label class="ui-label">数据字典value名称: </label>
            <input name="dictionary_value_name" class="easyui-box ui-text" style="width:100px;">
        </p>
 	  	<p class="ui-fields">
            <label class="ui-label">数据字典value键值: </label>
            <input name="dictionary_value_key" class="easyui-box ui-text" style="width:100px;">
        </p>
 	  	<p class="ui-fields">
            <label class="ui-label">数据字典类型: </label>
            <select name="dictionary_type_id" style="width:200px;">
 	 	    	<option value="" selected="selected">请选择类型</option>
 	 	    	<c:forEach var="item" items="${list}">
					<option value="${item.dictionary_type_id}">${item.dictionary_type_name}</option>
				</c:forEach>
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
     <div id="edit-win" class="easyui-dialog" buttons="#editBtn" title="详情" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:250px;">
     		<br>
     		<input class="hidden" id="dictionary_value_id">
     		<div style="padding:10px;">
     			<table width="100%" class="tbBaseInfo">
	     			<tr>
	     				<th align="left">数据字典类型名称：</th>
	     				<td align="left">
	     					<select id="dictionary_type_id" style="width:200px;">
	     						<option value="">请选择类型</option>
				 	 	    	<c:forEach var="item" items="${list}">
									<option value="${item.dictionary_type_id}">${item.dictionary_type_name}</option>
								</c:forEach>
				 	 	    </select>
						</td>
	     			</tr>
	     			<tr>
	     				<th align="left">数据字典value名称：</th>
	     				<td align="left"><input id="dictionary_value_name" class="easyui-box ui-text" style="width:200px;"></td>
	     			</tr>
	     			<tr>
	     				<th align="left">数据字典value的键值：</th>
	     				<td align="left"><input id="dictionary_value_key" class="easyui-numberbox" style="width:200px;"></td>
	     			</tr>
	     		</table>
     		</div>
     		
     	 <div id="editBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">保存</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>  
        </div>
  	 </div> 
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/dataManager/data_dictionary_value.js"></script>

 </body>
</html>
