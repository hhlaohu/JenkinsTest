<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body>
<div class="warp easyui-panel"  data-options="border:false">
  	 <!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">   
 	 <form id="searchForm">
 	 	<input class="hidden" id='search_parentId' name="parentId">
 	 	<p class="ui-fields">
            <label class="ui-label">菜单名称:</label> 
            <input name="name" class="easyui-box ui-text" style="width:100px;">
        </p>
        <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
   
<!--      Edit Win&From
     <div id="edit_win" class="easyui-dialog" title="菜s管理" data-options="closed:true,iconCls:'icon-save',modal:true"  style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post"> 
     	 隐藏文本框
     	 <input class="hidden" name="id">
     	 <input class="hidden" name="deleted">
    	 <input class="hidden" name="parentId" id='edit_parentId'>
    	 <div class="easyui-panel" border='false' style="width:450px;height: 350px;">  
	        <div class="easyui-layout" data-options="fit:true">  
	            <div data-options="region:'north',split:true" style="height:185px;padding:10px">  
	               <div class="ftitle">菜单信息</div>    
		           <div class="fitem">  
		               <label>菜单名称:</label>  
		               <input class="easyui-validatebox" type="text" name="name" data-options="required:true">
		           </div>  
		           <div class="fitem">  
		               <label>URL:</label>  
		               <input type="text" name="url"></input>
		           </div>  
		           <div class="fitem">  
		               <label>排序:</label>  
		               <input class="easyui-numberbox" type="text" value="0" name="rank" data-options="required:true,min:0,max:999">
		           </div> 
		           <div class="fitem">  
		               <label>Actions:</label>  
		               <input class="easyui-validatebox" type="text" name="actions" >
		               <span>注册的Action.按"|"分隔</span>
		           </div> 
	            </div>
	        <div data-options="region:'center'">  
	              	<div id="toolbar">  
				        <a href="javascript:void(0)" id='addLine_btn' class="easyui-linkbutton" iconCls="icon-add" plain="true" >新增</a>  
				        <a href="javascript:void(0)" id='addDefLine_btn'class="easyui-linkbutton" iconCls="icon-add" plain="true" >默认新增</a>
				        <a href="javascript:void(0)" id='delAllLine_btn'class="easyui-linkbutton" iconCls="icon-remove" plain="true" >全部删除</a>  
				    </div>  
				    
	            </div> 
	         </div>
	       </div>
     	</form>
  	 </div>
</div> -->

<div style="display:none;">
	  	 <div id="add_win" class="easyui-dialog" title="添加仓号" buttons="#addFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
	     <form id="addForm" class="ui-form" method="post"> 
     	 <!-- 隐藏文本框 -->
     	 <input class="hidden" name="id">
     	 <input class="hidden" name="deleted">
    	 <input class="hidden" name="parentId" id='edit_parentId'>
	     <div class="ui-edit">
		     	   <div class="ftitle">商品信息</div>  
		     	    <div class="fitem">  
		                <label>父级菜单:</label>  
	                    <select class="easyui-combobox" name="parentId" id="parentId" data-options="required:true,width:135">
		                   <option value=""></option>
		                   <c:forEach var="list" items="${dataList}">
		                   <option value="${list.id}">${list.name}</option>
		                   </c:forEach>
	                    </select>
		           </div>  
		           <div class="fitem">  
		                 <label>菜单名称:</label>  
		               <input class="easyui-validatebox" type="text" name="name"  id="name" data-options="required:true">
		           </div>
		            <div class="fitem">  
		               <label>系统URL:</label>  
		               <input type="text" name="url"></input>
		           </div>  
		             <div class="fitem">  
		               <label>菜单层级:</label>  
		             	 <select  class="easyui-combobox"  name="menuLevel" data-options="required:true,width:135">
						<option value="1">1级</option>
						<option value="2">2级</option>
						</select>
		           </div>  
		           <div class="fitem">  
		               <label>Actions:</label>  
		               <input class="easyui-validatebox" type="text" name="actions" id="actions" >
		           </div> 
		         <div id="addFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitSysMenu()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeSysMenu()">关闭</a>
		         </div>
		    </div>
	     	</form>
	  	 </div> 
	  	</div>
	  	<!-- 添加配置管理信息End -->

  <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
  <script type="text/javascript" src="${msUrl}/js/ux/sys/sysMenu.js"></script>
  
  </script>
  </body>
</html>
		         