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
            <label class="ui-label">规则集名称: </label>
            <input name="set_name" id="set_name" class="easyui-box ui-text" style="width:150px;">
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
	     <div id="edit-win" class="easyui-dialog" title="规则集管理" buttons="#edit_ruleSet" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:240px;">  
	     	<form id="editForm" class="ui-form" method="post">  
	     		 <input class="hidden" type="text" id="rule_set_id">
	     		 <div class="ui-edit">
	  	     	   <table width="100%" >
	  	     	   <tr style="height:30px;">
	     				<td align="right"style="width:100px">规则集业务分类：</td>
	     				<td align="left">
	     					<select class="easyui-combobox" id="rule_set_type_id" name="rule_set_type_id" style="width:250px;">
			 	 	   		</select>
	     					<span style="color:red;">*</span>
	     				</td>
	     			</tr>
	           	    <tr style="height:30px;">
	     				<td align="right"style="width:100px">规则集名称：</td>
	     				<td align="left">
	     					<input class="easyui-validatebox" type="text" name="rule_set_name" id="rule_set_name" maxlength="16" style="width:250px">
	     					<span style="color:red;">*</span>
	     				</td>
	     			</tr>
	     			<tr style="height:30px;">
	     				<td align="right"style="width:100px">金额下限：</td>
	     				<td align="left">
	     					<input class="easyui-validatebox" type="text" name="upper_amount" id="upper_amount" onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="18" style="width:250px">
	     					<span style="color:red;">*</span>
	     				</td>
	     			</tr>
	     			<tr style="height:30px;">
	     				<td align="right"style="width:100px">金额上限：</td>
	     				<td align="left">
	     					<input class="easyui-validatebox" type="text" name="lower_amount" id="lower_amount" onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="18" style="width:250px">
	     					<span style="color:red;">*</span>
	     				</td>
	     			</tr>
	     			</table>
		         </div>
		          <div id="edit_ruleSet" class="dialog-button">
		          <a href="#" id="btn-rule-set-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			      <a href="#" id="btn-rule-set-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
			      <a href="#" id="btn-rule-set-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		          </div>
	     	</form>
	  	 </div> 

	<div id="view-win" class="easyui-dialog" title="规则集额度管理" buttons="#edit_modelRule" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:800px;height:580px;">  
     	<form id="viewForm" class="ui-form" method="post">  
     	<input class="hidden" type="text" id="view_rule_set_id">
     	   <table width="100%">
	     	<tr>
	     	<td>
	     	<div class="ui-edit">
     		 <div class="ftitle">规则集信息</div>
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right"style="width:80px">业务规则集名称：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="view_rule_set_name" id="view_rule_set_name" maxlength="64" style="width:230px" readonly="readonly">
     				</td>
     			</tr>
     			</table>
	         </div>
	     	</td>
	     	</tr>
	     	
	     	<tr><td>
            <div class="ui-edit">
            	<div class="ftitle">规则集额度信息</div>
	            	<table width="100%">
	            	<tr><td>
	            			<input id="btn-addQuotaValue" type="button" style="width:80px;height:26px;" value="新增"/>&nbsp;&nbsp;
	            	</td></tr>
	            	</table>
	            	<div id="valueListDiv" style="margin-top:10px;">
	            	<form id="modelRuleValue" method="post">
		    			<table id="model-quota-value-data-list"></table>
		    		</form>
		    		</div>
            	</div>
            </td></tr>
		   </table>

	          <div id="edit_modelRule" class="dialog-button">
		      <a href="#" id="btn-view-model-rule-cancel" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
	          </div>
     	</form>
  	 </div> 
  	 
  	 <div id="value-win" class="easyui-dialog" title="得分额度" buttons="#edit_modelValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:470px;height:300px;">  
     	<form id="valueForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="quota_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right" style="width:50px">得分最小值：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="min_score" id="min_score" maxlength="64" style="width:200px">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:50px">得分最大值：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="max_score" id="max_score" maxlength="64" style="width:200px">
     				</td>
     			</tr>		     			     			
           	    <tr style="height:30px;">
     				<th align="right" style="width:50px">额度最小值：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="min_quota" id="min_quota" maxlength="64" style="width:200px">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right" style="width:50px">额度最大值：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="max_quota" id="max_quota" maxlength="64" style="width:200px">
     				</td>
     			</tr>		     			     			
     			</table>
	         </div>
	          <div id="edit_modelValue" class="dialog-button">
	          <a href="#" id="btn-quota-value-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-quota-value-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-quota-value-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
  	 </div> 	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoring/scoringRuleSet.js"></script>
  </body>
</html>
