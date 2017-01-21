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
            <label class="ui-label">规则代码: </label><input name="rule_code" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">规则名称: </label><input name="rule_name" class="easyui-box ui-text">
        </p>
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
     
      <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="数据字段管理" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:450px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">
     	  <input class="hidden" type="text" name="affiliate_rule_id"> 
           <div class="ui-edit">
     		  <table width="100%">
     		   <tr style="height:30px;">
     				<td align="right"style="width:100px">规则代码：</td>
     				<td align="left">
						<input class="easyui-validatebox" type="text" name="rule_code" id="rule_code" data-options="required:true" style="width:250px">
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<td align="right"style="width:100px">规则名称：</td>
     				<td align="left">
						<input class="easyui-validatebox" type="text" name="rule_name" id="rule_name" data-options="required:true" style="width:250px">
			 	 	   	<span style="color:red;">*</span>
     				</td>
     			</tr>
     			<tr style="height:30px;">
     				<td align="right"style="width:100px">规则描述：</td>
     				<td align="left">
						<textarea style="height:100px;width:260px;"  id="rule_desc" name="rule_desc" cols="20" rows="8"> </textarea>
     				</td>
     			</tr>
     		  </table>
	         </div>		 
     	</form>
  	 </div> 
  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/tabAffiliateRule/tabAffiliateRule.js"></script>
  </body>
</html>
