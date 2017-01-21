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
     <div id="edit-win" class="easyui-dialog" title="评分规则管理" buttons="#edit_modelRule" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="scoring_rule_id">
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
     			<tr style="height:30px;">
     				<th align="right" style="width:100px">得分：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="score_value" id="score_value" maxlength="64" style="width:200px">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:100px">规则业务分类：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="rule_type_id" name="rule_type_id" style="width:200px;">
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
	          <div id="edit_modelRule" class="dialog-button">
	          <a href="#" id="btn-model-rule-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		      <a href="#" id="btn-model-rule-update" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
		      <a href="#" id="btn-model-rule-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	          </div>
     	</form>
  	 </div> 
  	 
  	 <div id="view-win" class="easyui-dialog" title="评分管理" buttons="#edit_modelRule" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:950px;height:630px;">  
     	<form id="viewForm" class="ui-form" method="post">  
     	<input class="hidden" type="text" id="view_scoring_rule_id">
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
     			<tr style="height:30px;">
     				<th align="right"style="width:80px">得分：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="view_score_value" id="view_score_value" maxlength="32" style="width:230px" readonly="readonly">
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<th align="right"style="width:80px">业务规则集：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="view_rule_set_id" name="view_rule_set_id" style="width:230px;">
			 	 	   	</select>
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
	            	<form id="modelRuleValue" method="post">
		    			<table id="model-rule-value-data-list"></table>
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
  	 
  	 
	<div id="value-win" class="easyui-dialog" title="评分模型" buttons="#edit_modelValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:650px;height:480px;">  
     	<form id="valueForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" id="score_id">
     		 <div class="ui-edit">
  	     	   <table width="100%" class="tbBaseInfo">
  	     	   <tr style="height:50px;">
     				<th align="right" style="width:80px">联合条件：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="unite_value" name="unite_value" style="width:200px;">
     						<option value="0">---请选择---</option>
			                <option value="1">并且</option>
			             	<option value="2">或者</option>
			 	 	   	</select>
     				</td>
     			</tr>  
     			<tr style="height:50px;">
     				<th align="right" style="width:80px">字段：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="scoring_field_id" name="scoring_field_id" style="width:200px;">
			 	 	   	</select>
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:50px;display:none;" id="dictionary_value_id_TR">
     				<th align="right" style="width:80px">字典值：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="dictionary_value_id" name="dictionary_value_id" style="width:200px;">
			 	 	   	</select>&nbsp;&nbsp;&nbsp;
			 	 	   	<a href="#" id="dictionary_value_add" class="easyui-linkbutton" onclick="addDictionaryValue()">增加</a>
     				</td>
     			</tr>
     			<tr style="height:50px;display:none;" id="area_TR">
     				<th align="right" style="width:80px">字典值：</th>
     				<td align="left">
     					<select class="easyui-combobox" id="province_id" name="province_id" style="width:100px;">
			 	 	   	</select>&nbsp;&nbsp;&nbsp;
			 	 	   	<select class="easyui-combobox" id="city_id" name="city_id" style="width:100px;">
			 	 	   	</select>&nbsp;&nbsp;&nbsp;
			 	 	   	<select class="easyui-combobox" id="area_id" name="area_id" style="width:100px;">
			 	 	   	</select>&nbsp;&nbsp;&nbsp;
			 	 	   	<a href="#" id="area_add" class="easyui-linkbutton" onclick="addAreaKeyValue()">增加</a>
     				</td>
     			</tr>
           	    <tr style="height:60px;">
     				<th align="right" style="width:80px">最小值：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="lower_limit" id="lower_limit" maxlength="64" style="width:400px;">
     					<br>
     					<span style="color:red;">*如果字段类型是字符串或者枚举，可以不填最小值</span>
     				</td>
     			</tr>
     			<tr style="height:60px;">
     				<th align="right" style="width:80px">最大值：</th>
     				<td align="left">
     					<!--<input class="easyui-validatebox" type="text" name="upper_limit" id="upper_limit" maxlength="256" style="width:400px;height:60px;">  -->
     					<textarea style="height:80px;width:400px;"  id="upper_limit" name="upper_limit" cols="20" rows="8"> </textarea>
     					<br>
     					<span style="color:red;">*如果字段类型是字符串或者枚举，只需填这个最大值</span>
     				</td>
     			</tr>
     			<tr style="height:50px;">
     				<th align="right" style="width:80px">得分：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="score_value_" id="score_value_" maxlength="64" style="width:400px">
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
<script type="text/javascript" src="${msUrl}/js/ux/scoring/scoringModelRule.js"></script>
  </body>
</html>
