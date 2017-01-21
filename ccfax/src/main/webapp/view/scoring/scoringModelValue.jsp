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
            <label class="ui-label">规则: </label>
            <select class="easyui-combobox" id="search_rule_id" name="search_rule_id" style="width:200px;">
            	<option value="" selected="selected">---请选择---</option>
            	<c:forEach var="item" items="${modelRuleList}">
			 	 	<option value="${item.scoring_rule_id}">${item.rule_name}</option>
			 	 </c:forEach>
			</select>
        </p>
        <p class="ui-fields">
            <label class="ui-label">字段: </label>
            <select class="easyui-combobox" id="search_field_id" name="search_field_id" style="width:130px;">
           		 <option value="" selected="selected">---请选择---</option>
                 <c:forEach var="item" items="${modelFieldList}">
			 	 	<option value="${item.scoring_field_id}">${item.field_name}</option>
			 	 </c:forEach>
			</select>
        </p>
        <p class="ui-fields"><a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a></p>
     	 </form>  
     </div>
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
     

     <!-- Edit Form -->
<div style="display:none">
     <div id="edit-win" class="easyui-dialog" title="评分模型Value管理" buttons="#edit_modelValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="score_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
     			<tr style="height:30px;">
     				<th align="right" style="width:80px">业务规则：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="scoring_rule_id" name="scoring_rule_id" style="width:200px;">
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:100px">字段：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="scoring_field_id" name="scoring_field_id" style="width:200px;">
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:100px">上限：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="upper_limit" id="upper_limit" maxlength="64" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
           	    <tr style="height:30px;">
     				<th align="right" style="width:100px">下限：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="lower_limit" id="lower_limit" maxlength="64" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
           	    <tr style="height:30px;">
     				<th align="right" style="width:100px">得分：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="score_value" id="score_value" maxlength="64" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:100px">联合条件：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="unite_value" name="unite_value" style="width:200px;">
     						<option value="0">---请选择---</option>
			                <option value="1">并且</option>
			             	<option value="2">或者</option>
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>     			     			     			
     			</table>
	         </div>
	          <div id="edit_modelValue" class="dialog-button">
	          <a href="#" id="btn-model-value-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-model-value-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-model-value-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
</div>  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoring/scoringModelValue.js"></script>
  </body>
</html>
