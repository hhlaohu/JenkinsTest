<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
            <label class="ui-label">数据字典类型名称: </label>
            <input name="dictionary_type_name" class="easyui-box ui-text" style="width:100px;">
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
     <!-- Edit Password Form -->
     <div id="edit-win" class="easyui-dialog" buttons="#editBtn" title="详情" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:450px;height:250px;">
     		<br>
     		<input class="hidden" id="dictionary_type_id">
     		<div style="padding:10px;">
     			<table width="100%" class="tbBaseInfo">
	     			<tr style="height:30px;">
	     				<th align="left">数据字典类型名称：</th>
	     				<td align="left"><input id="dictionary_type_name" class="easyui-box ui-text" style="width:200px;" maxlength="32">
	     				<span style="color:red;">*</span>
	     				</td>
	     			</tr>
	     			<tr style="height:30px;display:none;" id="dictionary_type_code_TR">
	     				<th align="left">数据字典编号：</th>
	     				<td align="left"><label id="dictionary_type_code"></label>
	     				</td>
	     			</tr>
	     			<tr style="height:30px;">
	     				<th align="left">是否关联外部表：</th>
	     				<td align="left">
	     					<label><input name="is_relational_table" type="radio" value="1" />关联 </label> &nbsp;&nbsp;
							<label><input name="is_relational_table" type="radio" value="0" checked/>不关联 </label> &nbsp;&nbsp;
	     				</td>
	     			</tr>
	     			<tr style="height:30px;">
	     				<th align="left">关联外部表名：</th>
	     				<td align="left"><input id="relational_table_name" class="easyui-box ui-text" style="width:200px;" maxlength="64"></td>
	     			</tr>
	     		</table>
     		</div>
     		
     	 <div id="editBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">保存</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>  
        </div>
  	 </div> 
     
     
      <div id="view-win" class="easyui-dialog" title="数据字典管理" buttons="#edit_dataValue" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:960px;height:550px;">  
     	<form id="viewForm" class="ui-form" method="post">  
     	<input class="hidden" type="text" id="view_dictionary_type_id">
     	   <table width="100%">
	     	<tr>
	     	<td>
	     	<div class="ui-edit">
     		 <div class="ftitle">数据字典信息</div>
  	     	   <table width="100%" class="tbBaseInfo">
           	    <tr style="height:30px;">
     				<th align="right"style="width:80px">数据字典类型：</th>
     				<td align="left">
     					<input class="easyui-validatebox" type="text" name="view_dictionary_type_name" id="view_dictionary_type_name" maxlength="64" style="width:230px" readonly="readonly">
     				</td>
     			</tr>
     			</table>
	         </div>
	     	</td>
	     	</tr>
	     	
	     	<tr><td>
            <div class="ui-edit">
            	<div class="ftitle">数据字典Value信息</div>
	            	<table width="100%">
	            	<tr><td>
	            			<input id="btn-addDataValue" type="button" style="width:80px;height:26px;" value="新增"/>&nbsp;&nbsp;
	            	</td></tr>
	            	</table>
	            	<!-- 评分模型Value列表 -->
	            	<div id="valueListDiv" style="margin-top:10px;">
	            	<form id="dictionaryValue" method="post">
		    			<table id="data-dictionary-value-data-list"></table>
		    		</form>
		    		</div>
            	</div>
            </td></tr>
		   </table>

	          <div id="edit_dataValue" class="dialog-button">
		      <a href="#" id="btn-view-data-value-cancel" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
	          </div>
     	</form>
  	 </div> 
  	 
  	 
  	 <div id="value-win" class="easyui-dialog" buttons="#editBtn" title="详情" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:450px;height:200px;">
     	<br>
     	<input class="hidden" id="dictionary_value_id">
     		<div style="padding:10px;">
     			<table width="100%" class="tbBaseInfo">
	     			<tr style="height:30px;">
	     				<th align="left">数据字典value名称：</th>
	     				<td align="left"><input id="dictionary_value_name" class="easyui-box ui-text" style="width:200px;">
	     				<span style="color:red;">*</span></td>
	     			</tr>
	     			<tr style="height:30px;">
	     				<th align="left">数据字典value的键值：</th>
	     				<td align="left"><input id="dictionary_value_key" class="easyui-numberbox" style="width:200px;">
	     				<span style="color:red;">*</span></td>
	     			</tr>
	     		</table>
     		</div>
     		
     	 <div id="editBtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-dictionary-value-submit" onclick="saveDDV()">保存</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-dictionary-value-cancel">取消</a>  
        </div>
  	 </div> 
</div>  	 
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/dataManager/data_dictionary_type.js"></script>

 </body>
</html>
