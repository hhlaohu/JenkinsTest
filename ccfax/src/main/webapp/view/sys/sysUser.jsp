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
            <label class="ui-label">用户名: </label><input name="usr_name" class="easyui-box ui-text">
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
     <div id="edit-win" class="easyui-dialog" title="用户管理" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:330px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="id">
     		 <input class="hidden" name="deleted">
     		 <div class="ui-edit">
	     	   <div class="ftitle">用户信息</div>    
	           <div class="fitem">  
	               <label>用户名:</label>  
	               <input class="easyui-validatebox" type="text" name="usr_name" data-options="required:true,missingMessage:'账号不能为空.',validType:'length[1,20]'">
	           </div>
	           <div class="fitem">  
	               <label>密码:</label> 
	               <input class="easyui-validatebox"  data-options="required:true,missingMessage:'密码不能为空.'" type="password" name="usr_pass" > 
	           </div>
	           <div class="fitem">  
	               <label>真实姓名:</label>  
	               <input class="easyui-validatebox" type="text" name="real_name"  maxlength="20">
	           </div>
	             <div class="fitem">  
	               <label>电话号码:</label>  
	               <input class="easyui-validatebox" type="text" name="tel">
	           </div>
	            <div class="fitem">  
	               <label>状态:</label>  
	               <select class="easyui-combobox" name="state" data-options="required:true,width:150">
                    	<option value="0" selected="selected">可用</option>
                    	<option value="1">禁用</option>
                   	</select>
	           </div>
	            <div class="fitem">  
	               <label>是否发送短信:</label>  
	               <select class="easyui-combobox" name="is_send_message" data-options="required:true,width:150">
                    	<option value="0">否</option>
                    	<option value="1">是</option>
                   	</select>
	           </div>  
	         </div>
     	</form>
  	 </div> 
  	 
  	 <!-- Edit Password Form -->
     <div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="修改密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">
     	<form id="pwdForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
	     	   <div class="ftitle">用户信息</div>    
	           <div class="fitem">  
	               <label>用户名:</label>  
	               <input class="easyui-validatebox" type="text" readonly="readonly" name="usr_name" data-options="required:true,validType:'length[1,20]'">
	           </div>  
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox" data-options="required:true"/>
	           </div>
	            <div class="fitem">  
	               <label>新密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" data-options="required:true,validType:'length[6,20]'" />
	           </div> 
	           <div class="fitem">  
	               <label>重复密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	</form>
     	 <div id="editPwdbtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">取消</a>  
        </div>
  	 </div> 
  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/sys/sysUser.js"></script>
  </body>
</html>
