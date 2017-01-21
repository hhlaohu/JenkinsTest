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
            <label class="ui-label">角色名称:</label> 
            <input name="roleName" class="easyui-box ui-text">
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
     <div id="edit-win" class="easyui-dialog" title="角色管理" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:520px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="id">
     		 <div class="ui-edit">
	     	   <div class="ftitle">角色信息</div>    
	           <div class="fitem">  
	               <label>角色名:</label>  
	               <input class="easyui-validatebox" type="text" name="roleName" data-options="required:true,validType:'length[1,20]'">
	           </div>  
	           <div class="fitem">  
	               <label>状态:</label>  
	               <select class="easyui-combobox" name="state" data-options="required:true,width:150">
                    	<option value="0" selected="selected">可用</option>
                    	<option value="1">禁用</option>
                   	</select>
	           </div>  
	            <div class="fitem" style="">  
	               <label>权限项:</label>
	               <div style="border: 1px solid #A4BED4; width:230px;height:200px;margin-left: 105px ;overflow: auto; ">  
	               	<ul id="menu-tree"  >
	               	</ul>
	               </div>
	           </div>
	           <div class="fitem">  
	               <label>角色描述:</label>  
	               <input class="easyui-validatebox" id="descr" name="descr" >
	           </div>
	         </div>
     	</form>
  	 </div> 
  
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/sys/sysRole.js"></script>
  </body>
</html>
