<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
            <label class="ui-label">货物名称: </label>.
            <select class="easyui-combobox" name="pz_good_name" id="pz_good_name" style="width:150px;">
            	<option value="">全部</option>
            	<c:forEach var="list" items="${listPG}">
            		<option value="${list.pz_good_name}">${list.pz_good_name}</option>
            	</c:forEach>
            </select>
        </p>
        <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查 询</a>
        &nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="pz_addfile" id="pz_addfile" class="easyui-linkbutton"  iconCls="icon-add">批量导入</a>
      </form>  
   </div>
	
	
     <!-- 批量导入Start -->
	 <div style="display:none;">
		<div id="batchAdd" class="easyui-dialog" title="批量导入" buttons="#addFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:300px;height:160px;">  
			<form  id="batchAddForm" method="post" enctype="multipart/form-data" style="margin:25px 0px 0px 0" >  
				<input type="file" name="file" id="del_file" style="width:190px; margin:0px 10px 0px 20px; border:1px solid #ccc" /> 
				<input type="button" id="btn_form" value="导入" style="width:40px;" />
			</form> 
		</div>
	</div>
    <!-- 批量导入End -->
       
     
     <!-- DataList  -->
     <div id="tabPzGood">
	     <form id="listForm" method="post">
	     <table id="data-list"></table>
	     </form>
     </div>
	
	 
      <!--按货物名称查询的List-->
     <div id="tabPzGood2" style="display:none">  
	     <form id="listForm2" method="post">
	     <table id="data-list2"></table>
	     </form>
     </div>
	
	<!-- 规格管理页面Start -->
	 <div style="display:none">
		 <!-- <div class="easyui-dialog" title="规格管理" buttons="#kcmessage" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:815px;height:700px;"> -->  
		  <div  id="specConfigwin"  class="easyui-dialog" title="规格管理" buttons="#addFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:700px;height:450px;">
	     		   <form id="specConfigForm"  class="ui-form" method="post">
	     			<table id="specConfig-list"></table>
	     			</form>
		  </div>
  	 </div> 
    <!--规格管理页面End -->
    
    <!-- 添加规格管理Start -->
     <div style="display:none;">
	  	 <div id="AddSpecConfig" class="easyui-dialog" title="规格管理" buttons="#specConfigBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:350px;">  
	     	<form id="addSpecConfigForm" class="ui-form" method="post">  
	     		  <div class="ui-edit">
		     	   <div class="ftitle">规格新增</div>    
		           <div class="fitem">  
		               <label>规格:</label>  
		               <input class="easyui-validatebox" type="text" name="spec_name" id="spec_name"/>
		           </div>
		          
		           <div class="fitem">  
		               <label>规格类别:</label>  
		               <select class="easyui-combobox" name="spec_type" id="spec_type" data-options="required:true,width:150">
	                    	<option value="" selected="selected">请选择</option>
	                    	<option value="0">A</option>
	                    	<option value="1">B</option>
	                    	
	                   	</select>
		           </div> 
		            <div class="fitem">  
		               <label>开始:</label>  
		               <input class="easyui-validatebox"  type="text" name="value_begin" id="value_begin" data-options="required:true" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')"/>
		           </div>
		            <div class="fitem">  
		               <label>结束:</label>  
		               <input class="easyui-validatebox"  type="text" name="value_end" id="value_end" data-options="required:true" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')"/>
		           </div>
		         </div>
		         <div id="specConfigBtn" class="dialog-button">
		            <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitSpecConfig()">保存</a>
		         	<a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#AddSpecConfig').window('close',true)">关闭</a>
	     		 </div>
	     	</form>
	  	 </div> 
	  	</div>
     <!-- 添加规格管理End -->
   
    
     <!-- 修改规格管理Start -->
     <div style="display:none;">
	  	 <div id="ModifySpecConfig" class="easyui-dialog" title="规格管理" buttons="#specConfigBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:350px;">  
	     	<form id="ModifySpecConfigForm" class="ui-form" method="post">  
	     		  <div class="ui-edit">
		     	   <div class="ftitle">修改规格管理信息</div>
		     	   <input class="hidden" type="text" id="spec_id" name="spec_id">
		           <div class="fitem">  
		               <label>规格:</label>  
		               <input class="easyui-validatebox" type="text" name="spec_name" id="spec_name"/>
		           </div>
		          
		           <div class="fitem">  
		               <label>规格类别:</label>  
		               <select class="easyui-combobox" name="spec_type" id="update_spec_type" data-options="required:true,width:150">
	                    	<option value="" selected="selected">请选择</option>
	                    	<option value="0">A</option>
	                    	<option value="1">B</option>
	                    	
	                   	</select>
		           </div> 
		            <div class="fitem">  
		               <label>开始:</label>  
		               <input class="easyui-validatebox"  type="text" name="value_begin" id="value_begin" data-options="required:true" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')"/>
		           </div>
		            <div class="fitem">  
		               <label>结束:</label>  
		               <input class="easyui-validatebox"  type="text" name="value_end" id="value_end" data-options="required:true" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')"/>
		           </div>
		         </div>
		         <div id="specConfigBtn" class="dialog-button">
		            <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="updateSpecConfig()">保存</a>
		         	<a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ModifySpecConfig').window('close',true)">关闭</a>
	     		 </div>
	     	</form>
	  	 </div> 
	  	</div>
     <!-- 修改规格管理End -->
     
  	 <!-- 添加配置管理信息Start-->
  	 <div style="display:none;">
	  	 <div id="Addwin" class="easyui-dialog" title="添加商品" buttons="#addFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:350px;">  
	     	<form id="addForm" class="ui-form" method="post">  
	     		  <div class="ui-edit">
		     	   <div class="ftitle">商品信息</div>    
		           <div class="fitem">  
		               <label>货物名称:</label>  
		               <input class="easyui-validatebox" type="text" name="pz_good_name" id="pz_good_name"/>
		           </div>
		           <div class="fitem">  
		               <label>产地:</label>  
		               <select class="easyui-combobox" name="pz_good_place" id="pz_good_place" data-options="required:true,width:150">
	                    		<option value="2468">全部</option>
            	<c:forEach var="list" items="${listP}">
            		<option value="${list.pz_good_place}">${list.pz_good_place}</option>
            	</c:forEach>
	                   	</select>
		           </div> 
		           <div class="fitem">  
		               <label>等级:</label>  
		               <select class="easyui-combobox" name="pz_good_level" id="pz_good_level" data-options="required:true,width:150">
		               <option value="2468" selected="selected">全部</option>
	                    	<option value="1" selected="selected">顶级</option>
	                    	<option value="2">普一</option>
	                    	<option value="3">普二</option>
	                    	<option value="4">统材</option>
	                   	</select>
		           </div> 
		             <div class="fitem">  
		               <label>规格:</label>  
		               <select class="easyui-combobox" name="pz_good_size" id="pz_good_size" data-options="required:true,width:150">
	                    		<option value="0">全部</option>
            	<c:forEach var="list" items="${listSC}">
            		<option value="${list.spec_id}">${list.spec_name}</option>
            	</c:forEach>
	                   	</select>
		           </div> 
		             <div class="fitem">  
		               <label>计量单位:</label>  
		               <select class="easyui-combobox" name="unit" id="unit" data-options="required:true,width:150">
	                    	<option value="立方米" selected="selected">立方米</option>
	                    	<option value="吨">吨</option>
	                   	</select>
		           </div> 
		            <div class="fitem">  
		               <label>市场指导价:</label>  
		               <input class="easyui-numberbox"  type="text" name="market_prices" id="market_prices" data-options="precision:2"/>
		           </div>
		            <div class="fitem">  
		               <label>质押系数:</label>  
		               <input class="easyui-numberbox"  type="text" name="pledge_multiplier" id="pledge_multiplier" data-options="precision:2"/>
		           </div>
		         </div>
		         <div id="addFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitPzGood()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#Addwin').window('close',true)">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
	  	</div>
	  	<!-- 添加配置管理信息End -->
  	
  	 <!-- 修改配置管理信息Start-->
  	 <div style="display:none;">
	  	 <div id="ModifyWin" class="easyui-dialog" title="修改信息" buttons="#editAreaFormBtn" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:350px;">  
	     	<form id="modifyPzGoodForm" class="ui-form" method="post">  
	     		 <div class="ui-edit">
		     	   <div class="ftitle">修改配置管理信息</div>
		     	   <input class="hidden" type="text" id="pz_id" name="pz_id">
		           <div class="fitem">  
		               <label>货物名称:</label>  
		               <input class="easyui-validatebox" type="text" name="pz_good_name" id="update_pz_good_name"/>
		           </div>
		           <div class="fitem">  
		               <label>产地:</label>  
		               <select class="easyui-combobox" name="pz_good_place" id="update_pz_good_place" data-options="required:true,width:150">
	                           		<option value="2468">全部</option>
            	<c:forEach var="list" items="${listP}">
            		<option value="${list.pz_good_place}">${list.pz_good_place}</option>
            	</c:forEach>
	                   	</select>
		           </div> 
		           <div class="fitem">  
		               <label>等级:</label>  
		               <select class="easyui-combobox" name="pz_good_level" id="update_pz_good_level" data-options="required:true,width:150">
		                		<option value="2468">全部</option>
	                    	<option value="1" selected="selected">顶级</option>
	                    	<option value="2">普一</option>
	                    	<option value="3">普二</option>
	                    	<option value="4">统材</option>
	                   	</select>
		           </div> 
		             <div class="fitem">  
		               <label>规格:</label>  
		               <select class="easyui-combobox" name="pz_good_size" id="update_pz_good_size" data-options="required:true,width:150">
	                    	       		<option value="0">全部</option>
            	<c:forEach var="list" items="${listSC}">
            		<option value="${list.spec_id}">${list.spec_name}</option>
            	</c:forEach>
	                   	</select>
		           </div> 
		             <div class="fitem">  
		               <label>计量单位:</label>  
		               <select class="easyui-combobox" name="unit" id="update_unit" data-options="required:true,width:150">
	                    	<option value="立方米" selected="selected">立方米</option>
	                    	<option value="吨">吨</option>
	                   	</select>
		           </div> 
		            <div class="fitem">  
		               <label>市场指导价:</label>  
		               <input class="easyui-numberbox" type="text" name="market_prices" id="update_market_prices" data-options="precision:2"/>
		           </div>
		            <div class="fitem">  
		               <label>质押系数:</label>  
		               <input class="easyui-numberbox" type="text" name="pledge_multiplier" id="update_pledge_multiplier" data-options="precision:2"/>
		           </div>
		         </div>
		         <div id="editAreaFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" onclick="updatePzGood()">保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ModifyWin').window('close', true)">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
  	 </div>
	 <!-- 修改配置管理信息End-->
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/fk/pzGood.js"></script>

<script type="text/javascript" language="javascript">    
      
    </script>
    
<script type="text/javascript">
$(function(){
	$("#pz_addfile").click(function(){
			$("#batchAdd").window('open');
			$("#btn_form").click(function(){
				$("#batchAddForm").form('submit',{ //EasyUI ajax提交 
					url : 'importExcelFile.do', 
					type: 'post',
					dataType:'json',
					success : function(result) { 
					    var data = eval('(' + result + ')'); //将返回的数据转换成Json对象  
						$("#batchAdd").window('close', true);
						if(data.msg=="0"){
							 $("#data-list").datagrid('reload');
							 $.messager.confirm("提示","导入数据失败",function(flag){
		                 	 		if(flag){
		                  			window.location.href=window.location.href;
		                 			 }
		                 	 });
							 return false;
                     	}
                     	if(data.msg=="3"){
						     $("#data-list").datagrid('reload');
							 $.messager.confirm("提示","请导入Excel文件",function(flag){
		                 	 		if(flag){
		                  			window.location.href=window.location.href;
		                 			 }
		                 	 });
							 return false;
                     	}
                     	if(data.msg=="4"){
							 $("#data-list").datagrid('reload');
							 $.messager.confirm("提示","无法读取后缀名为.xlsx的文件",function(flag){
		                 	 		if(flag){
		                  			window.location.href=window.location.href;
		                 			 }
		                 	 });
							 return false;
                     	}
                     	else{
                    	 	 $("#data-list").datagrid('reload');
                    	 	  $.messager.confirm("提示","导入数据成功",function(flag){
		                 	 		if(flag){
		                  			window.location.href=window.location.href;
		                 			 }
		                 	 });
                     	} 
                     	return false;
					} 
					
				}); 
			
			});
			
		});
		
	});
</script>
  </body>
</html>
