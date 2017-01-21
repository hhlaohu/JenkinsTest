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
            <label class="ui-label">规则名: </label>
            <input name="search_rule_name" id="search_rule_name" class="easyui-box ui-text" style="width:150px;">
        </p>
        <p class="ui-fields">
            <label class="ui-label">激活状态: </label>
       		<select class="easyui-combobox" name="is_active" id="is_active" style="width:120px;">
              	<option value="1">激活</option>
           		<option value="0">未激活</option>
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
     <div id="edit-win" class="easyui-dialog" title="反欺诈规则管理" buttons="#edit_antiFraudRule" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:310px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="anti_fraud_rule_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right"style="width:100px">规则名称：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="rule_name" id="rule_name" maxlength="64" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">规则代码：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="rule_code" id="rule_code" maxlength="32" style="width:200px">
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">业务规则集：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="rule_set_id" name="rule_set_id" style="width:200px;">
			 	 	   	</select>
     					<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:100px;">
     				<th align="right" style="width:100px">规则描述：</th>
     				<td align="left">
     				<textarea style="height:80px;width:260px;"  id="rule_desc" name="rule_desc" cols="20" rows="8"> </textarea>
     				</td>
     			</tr>
     			</table>
	         </div>
	          <div id="edit_antiFraudRule" class="dialog-button">
	          <a href="#" id="btn-anti-fraud-rule-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-anti-fraud-rule-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-anti-fraud-rule-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
  	 
  	   <div id="view-win" class="easyui-dialog" title="评分管理" buttons="#edit_antiFraudRule" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:1000px;height:580px;">  
     	<form id="viewForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="view_anti_fraud_rule_id">
     		<table width="100%">
	     	<tr>
	     	<td>
	     	   <div class="ui-edit">
	     	   <div class="ftitle">规则信息</div>
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right"style="width:80px">规则名称：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="view_rule_name" id="view_rule_name" maxlength="64" style="width:230px" readonly="readonly">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:80px">规则代码：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="view_rule_code" id="view_rule_code" maxlength="32" style="width:230px" readonly="readonly">
     				</td>
     			</tr>
     			</table>
	         </div>
	     	</td>
	     	</tr>
	     	
	     	<tr><td>
            <div class="ui-edit">
            	<div class="ftitle">评分模型Value信息</div>
	            	<table width="100%">
	            	<tr><td>
	            			<input id="btn-addModelValue" type="button" style="width:80px;height:26px;" value="新增"/>&nbsp;&nbsp;
	            	</td></tr>
	            	</table>
	            	<!-- 评分模型Value列表 -->
	            	<div id="valueListDiv" style="margin-top:10px;">
	            	<form id="antiFraudRuleValue" method="post">
		    			<table id="anti-fraud-value-data-list"></table>
		    		</form>
		    		</div>
            	</div>
            </td></tr>
	     	</table>

	          <div id="edit_antiFraudRule" class="dialog-button">
		      <a href="#" id="btn-view-anti-fraud-rule-cancel" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
	          </div>
     	</form>
  	 </div>
  	 
  	 <div id="value-win" class="easyui-dialog" title="反欺诈模型Value管理" buttons="#edit_antiFraudValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:250px;">
  	      	<form id="valueForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="anti_fraud_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
  	     	   <tr style="height:30px;">
     				<th align="right" style="width:100px">联合条件：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="unite_value" name="unite_value" style="width:200px;">
     						<option value="0" selected="selected">---请选择---</option>
			                <option value="1">并且</option>
			             	<option value="2">或者</option>
			 	 	   	</select>
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
<script type="text/javascript" src="${msUrl}/js/ux/scoring/antiFraudModelRule.js"></script>
  </body>
</html>
