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
            	<c:forEach var="item" items="${antiFraudRuleList}">
			 	 	<option value="${item.anti_fraud_rule_id}">${item.rule_name}</option>
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
     <div id="edit-win" class="easyui-dialog" title="反欺诈模型Value管理" buttons="#edit_antiFraudValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="anti_fraud_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
     			<tr style="height:30px;">
     				<th align="right" style="width:80px">业务规则：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="anti_fraud_rule_id" name="anti_fraud_rule_id" style="width:200px;">
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
     				<th align="right" style="width:100px">命中条件：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="hit_condition" name="hit_condition" style="width:200px;">
     						<option value="0" selected="selected">---请选择---</option>
			                <option value="1">大于</option>
			             	<option value="2">大于等于</option>
			             	<option value="3">等于</option>
			             	<option value="4">小于</option>
			             	<option value="5">小于等于</option>
			             	<option value="6">不等于</option>
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
           	    <tr style="height:30px;">
     				<th align="right" style="width:100px">命中value：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="hit_value" id="hit_value" maxlength="64" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:100px">联合条件：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="unite_value" name="unite_value" style="width:200px;">
     						<option value="0" selected="selected">---请选择---</option>
			                <option value="1">并且</option>
			             	<option value="2">或者</option>
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>     			     			     			
     			</table>
	         </div>
	          <div id="edit_antiFraudValue" class="dialog-button">
	          <a href="#" id="btn-anti-fraud-value-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-anti-fraud-value-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-anti-fraud-value-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
</div>  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoring/antiFraudModelValue.js"></script>
  </body>
</html>
