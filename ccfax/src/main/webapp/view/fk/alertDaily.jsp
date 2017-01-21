<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	  <form id="searchForm">
 	   <p class="ui-fields">
        <label>警告时间:</label>  
	    <input id="alert_time_start" class="easyui-datetimebox" type="text" name="alert_time_start">
	    <label>到:</label>  
	    <input id="alert_time_end" class="easyui-datetimebox" type="text" name="alert_time_end">
	    </p>
 	  	
 	 	<p class="ui-fields">
		     <label>处理状态:</label>  
             <select class="easyui-combobox" name="deal_status" id="deal_status" data-options="required:true,width:150">
             	<option value="" selected="selected">请选择</option>
               	<option value="0">跟进</option>
               	<option value="1">待处理</option>
               	<option value="2">已解决</option>
            </select>
 	 	</p>
 	 	 <p class="ui-fields">
 	 	    <label class="ui-label">处理人:</label>
 	 	    <input name="deal_with" id="deal_with" class="easyui-box ui-text" placeholder="请输入处理人" >
        </p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     
     <!-- DataList  -->
     <div id="tabPzGood"> 
	     <form id="listForm" method="post">
	     <table id="data-list"></table>
	     </form>
     </div>
     
     
  	 <!-- 预警信息Start-->
  	 <div style="display:none;">
	  	 <div id="Addwin" class="easyui-dialog" title="添加预警日志" buttons="#addFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
	     	<form id="addForm" class="ui-form" method="post">  
	     		  <div class="ui-edit">
		     	   <div class="ftitle">预警信息</div>    
		           <div class="fitem">  
		               <label>警告时间:</label>  
		                 <input id="alert_time" class="easyui-datetimebox" type="text" name="alert_time">
		           </div>
		           <div class="fitem">  
		               <label>问题:</label>  
		                <input class="easyui-validatebox ui-text" type="text" name="alert_content" id="alert_content" style="width:180px;"/>	
		           </div> 
		           <div class="fitem">  
		               <label>处理状态:</label>  
		               <select class="easyui-combobox" name="deal_status" id="deal_status" style="width:180px;">
	                    	<option value="0" selected="selected">跟进</option>
	                    	<option value="1">待处理</option>
	                    	<option value="2">已解决</option>
	                   	</select>
		           </div> 
		             <div class="fitem">  
		               <label>处理人:</label>  
		                <input class="easyui-validatebox ui-text" type="text" name="deal_with" id="deal_with" style="width:180px;"/>	
		           </div> 
		           <div class="fitem">  
		               <label>处理时间:</label>  
		                 <input id="deal_time" class="easyui-datetimebox" type="text" name="deal_time">
		           </div>
		         </div>
		         <div id="addFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitAlertDaily()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeAlertDaily()">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
	  	</div>
	  	<!--  预警信息End -->
  	
  	<!-- 修改预警中心信息Start-->
  	 <div style="display:none;">
	  	 <div id="ModifyAlertConfigWin" class="easyui-dialog" title="修改信息" buttons="#editAreaFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
	     	<form id="modifyAlertDailyForm" class="ui-form" method="post">  
	     		 <div class="ui-edit">
		     	   <div class="ftitle">修改预警中心信息</div>
		     	   <input class="hidden" type="text" id="alert_id" name="alert_id">
		           <div class="fitem">  
		               <label>处理状态:</label>  
		               <select class="easyui-combobox" name="deal_status" id="my_deal_status" data-options="required:true,width:150">
	                    	<option value="0" selected="selected">跟进</option>
	                    	<option value="1">待处理</option>
	                    	<option value="2">已解决</option>
	                   	</select>
		           </div> 
		         </div>
		         <div id="editAreaFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="modifyAlertDaily()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeAlertDaily2()">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
  	 </div>
	 <!-- 修改预警中心信息End-->
  	
  	
  	
  	
  	<!-- 预警配置Start -->
  	<div style="display:none">
     <div id="alertConfig_Win" class="easyui-dialog" buttons="#editPutStock" title="预警配置" data-options="closed:true,iconCls:'icon-view',modal:true,closable: true,modal:true" style="width:1000px;height:480px;">  
     	 <form id="alertConfigForm" method="post">
			<table id="alertConfig-data-list"></table>
		<div id="editPutStock" class="dialog-button">
		      <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeAlertConfig()">关闭</a>
	    </div>
	     </form>
  		</div>
  	</div>
	<!-- 预警配置End -->
  	
  	 <!-- 修改预警配置信息Start-->
  	 <div style="display:none;">
	  	 <div id="ModifyWin" class="easyui-dialog" title="修改信息" buttons="#editAreaFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
	     	<form id="modifyAlertConfigForm" class="ui-form" method="post">  
	     		 <div class="ui-edit">
		     	   <div class="ftitle">修改预警配置信息</div>
		     	   <input class="hidden" type="text" id="id" name="id">
		           <!-- <div class="fitem">  
		               <label>预警条件:</label>  
		               <input class="easyui-validatebox" type="text" name="alert_condition" id="alert_condition"/>
		           </div> -->
		           <div class="fitem">  
		               <label>消息接收人:</label>  
		               <select class="easyui-combobox" name="msg_status" id="msg_status" data-options="required:true,width:150">
	                    	<option value="1" selected="selected">客户</option>
	                    	<option value="2">风控</option>
	                    	<option value="3">客户/风控</option>
	                   	</select>
		           </div> 
		        </br> 
		            <div class="fitem">  
		             <!--  <label>短信内容:</label>  
		              <!--  <textarea name="msg_content" style="width:200px;height:80px;"></textarea> -->
		                  <!--  <input class="easyui-validatebox" type="text" name="msg_content" id="msg_content"/>-->
		                  
		                  <label style="width:118px;margin-left:-18px;">风控信息接收人电话:</label>  
		                     <input class="easyui-validatebox" type="text" name="wcmr_tel" id="wcmr_tel" maxlength="12" />
		        
		           </div>
		           <div class="fitem">  
		             <!--  <label>短信内容:</label>  -->
		             
		             
		        
		             
		               
		           </div>
		         </div>
		         <div id="editAreaFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="modifyAlertConfig()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeAlertConfig2()">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
  	 </div>
	 <!-- 修改预警配置信息End-->
  	
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/fk/alertDaily.js"></script>
  </body>
</html>
