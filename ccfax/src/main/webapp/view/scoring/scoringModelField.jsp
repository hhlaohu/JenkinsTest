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
 	 	    <label class="ui-label">字段名:</label>
 	 	    <input name="search_field_name" id="search_field_name" class="easyui-box ui-text" style="width:150px;">
        </p>
         <p class="ui-fields">
	        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;
	        <!--<a href="#" id="btn-back" class="easyui-linkbutton" iconCls="icon-back">返回字段类型管理</a>  -->
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
     <div id="edit-win" class="easyui-dialog" title="字段管理" buttons="#edit_model_field" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:550px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" id="scoring_field_id">
     		 <input class="hidden" id="field_name_temp">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right"style="width:100px">字段名：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="field_name" id="field_name" maxlength="64" style="width:300px"  onkeyup="value=value.replace(/[\u4E00-\u9FA5]/g,'')">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">字段中文名：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="field_name_ch" id="field_name_ch" maxlength="64" style="width:300px">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">业务分类：</th>
     				<td align="left">
  	     	    	 	    <select class="easyui-combobox" id="field_type_id" name="field_type_id" style="width:200px;">
			 	 	    		<!--<c:forEach var="item" items="${modelTypeList}">
			 	 	    		<option value="${item.field_type_id}">${item.field_type_name}</option>
			 	 	    		</c:forEach>-->
			 	 	   		 </select>
			 	 	   		 <span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">字段值类型：</th>
     				<td align="left">
		               <select class="easyui-combobox" name="field_value_type" id="field_value_type" style="width:200px;">
		               		<option value="9">---请选择---</option>
			                <option value="0">字符串</option>
			             	<option value="1">整型</option>
			             	<option value="2">浮点型（2位小数）</option>
			             	<option value="3">枚举</option>
	                   	</select>
	                   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;display:none;" id="dictionary_type_TR">
     				<th align="right"style="width:100px">数据字典类型：</th>
     				<td align="left">
		               <select class="easyui-combobox" name="dictionary_type_id" id="dictionary_type_id" style="width:200px;">
	                   	</select>
	                   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">字段类型：</th>
     				<td align="left">
							<label><input name="is_combined" type="radio" value="1" />组合字段 </label> &nbsp;&nbsp;
							<label><input name="is_combined" type="radio" value="0" />非组合字段 </label> &nbsp;&nbsp;
							<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;display:none;" id="field_id_1">
     				<th align="right"style="width:100px">组合字段一：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="combined_field_id_1" name="combined_field_id_1" style="width:200px;">
			 	 	    		<!-- <option value="000000">---请选择---</option>
			 	 	    		<c:forEach var="item" items="${modelFieldList}">
			 	 	    		<option value="${item.scoring_field_id}">${item.field_name}</option>
			 	 	    		</c:forEach> -->
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;display:none;" id="field_id_2">
     				<th align="right"style="width:100px">组合字段二：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="combined_field_id_2" name="combined_field_id_2" style="width:200px;">
			 	 	    		<!--<option value="000000">---请选择---</option>
			 	 	    		<c:forEach var="item" items="${modelFieldList}">
			 	 	    		<option value="${item.scoring_field_id}">${item.field_name}</option>
			 	 	    		</c:forEach> -->
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;display:none;" id="operate">
     				<th align="right"style="width:100px">运算符：</th>
     				<td align="left">
		               <select class="easyui-combobox" name="combined_operate" id="combined_operate" style="width:200px;">
		               		<option value="0">---请选择---</option>
			                <option value="1">+</option>
			             	<option value="-">-</option>
			             	<option value="*">*</option>
			             	<option value="/">/</option>
	                   	</select>
	                   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:150px;">
     				<th align="right" style="width:100px">字段描述：</th>
     				<td align="left">
     				<textarea style="height:130px;width:300px;"  id="field_desc" name="field_desc" cols="20" rows="8"> </textarea>
     				</td>
     			</tr>
     			</table>
	         </div>
	          <div id="edit_model_field" class="dialog-button">
	          <a href="#" id="btn-model_field-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-model_field-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-model_field-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoring/scoringModelField.js"></script>
  </body>
</html>
