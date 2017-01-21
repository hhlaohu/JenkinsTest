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
            <label class="ui-label">评分字段名: </label><input name="scoring_field_name" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">评分字段中文名: </label><input name="scoring_field_name_ch" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">采集字段名: </label><input name="gather_field_name" class="easyui-box ui-text">
        </p>
        <p class="ui-fields">
            <label class="ui-label">采集字段来源: </label>
            <select name="gather_type_id" class="easyui-box ui-text">
              <option value="">--全部--</option>
              <c:forEach var="list" items="${gatherTypeList}">
            		      <option value="${list.gather_type_id}">${list.gather_type_name}</option>
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

     <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="数据字段管理" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:220px;">  
     	<form id="editForm" class="ui-form" method="post">
     	<input class="hidden" type="text" name="id"> 
     		 <div class="ui-edit">
	           <div class="fitem">  
	               <label>评分字段名:</label>  
	               <select id="scoringFieldSelect" class="easyui-combobox" name="scoring_field_id" data-options="required:true,width:250">
	                 <option value="">---请选择---</option>
	                 <c:forEach var="list" items="${scoringFieldList}">
            		      <option value="${list.scoring_field_id}" field_name_ch="${list.field_name_ch}">${list.field_name}</option>
            	        </c:forEach>
	               </select>
	           </div>
	           <div class="fitem">  
	               <label>评分字段中文名:</label> 
	                 <span id="field_name_ch_span"></span> 
	           </div>
	           
	           <div class="fitem">  
	               <label>采集字段来源:</label> 
	                 <select id="gahterTypeSelect" class="easyui-combobox" name="gather_type_id"  data-options="required:true,width:250">
                        <option value="">--全部--</option>
                         <c:forEach var="list" items="${gatherTypeList}">
            		      <option value="${list.gather_type_id}">${list.gather_type_name}</option>
            	        </c:forEach>
                     </select>
	           </div>
	           
	            <div class="fitem">  
	               <label>采集字段:</label> 
	                 <select id="gatherFieldSelect" class="easyui-combobox" name="gather_field_id" data-options="required:true,width:250">
	                </select> 
	           </div>
	           
	           
	         </div>
     	</form>
  	 </div> 
  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/scoringGatherField/scoringGatherFieldMap.js"></script>
  </body>
</html>
