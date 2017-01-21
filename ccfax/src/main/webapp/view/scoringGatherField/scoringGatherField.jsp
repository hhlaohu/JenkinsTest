<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
            <label class="ui-label">字段来源分类: </label><input name="gather_type_id" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">字段名:  </label><input name="field_name" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">使用状态: </label>
       		<select class="easyui-combobox" name="is_enable" id="is_enable" style="width:120px;">
           		<option value="9">全部</option>
              	<option value="1">使用</option>
           		<option value="0">不使用</option>
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

<div style="display:none">
     <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="采集字段管理" buttons="#editBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:310px;">  
     	<form id="editForm" class="ui-form" method="post">
     	 <input  class="hidden" type="text" id="gather_field_id">  
     		 <div class="ui-edit">
     		  <table width="100%">
     		   <tr style="height:30px;">
     				<td align="right"style="width:100px">字段名：</td>
     				<td align="left">
						<input class="easyui-validatebox" type="text" name="field_name" id="field_name" data-options="required:true" style="width:250px">
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<td align="right">使用开关：</td>
     				<td align="left">
     					<label><input name="is_enable" type="radio" value="1" />使用 </label> &nbsp;&nbsp;
						<label><input name="is_enable" type="radio" value="0" checked/>不使用 </label> &nbsp;&nbsp;
     				</td>
	     		</tr>
     			<tr style="height:30px;">
     				<td align="right"style="width:100px">字段来源分类：</td>
     				<td align="left">
     					<select class="easyui-combobox" name="gather_type_id" id="gather_type_id" data-options="required:true" style="width:250px">
	                    	<option value="0" selected="selected">---请选择---</option>
	                    	<c:forEach var="list" items="${gatherTypeList}">
	            		      <option value="${list.gather_type_id}">${list.gather_type_name}</option>
	            	        </c:forEach>
                   		</select>
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<td align="right"style="width:100px">字段描述：</td>
     				<td align="left">
						<textarea style="height:100px;width:260px;"  id="field_desc" name="field_desc" cols="20" rows="8"> </textarea>
     				</td>
     			</tr>
     		  </table>
	         </div>
     	</form>
     	 <div id="editBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">保存</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>  
        </div>
  	 </div> 
</div>  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoringGatherField/scoringGatherField.js"></script>
  </body>
</html>
