<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/base.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <style type="text/css">
      .datagrid-toolbar{display:none;}
   </style>
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">客户:</label>
 	 	    <select class="easyui-combobox" name="customer_id" style="width:150px;line-height: 22px;height: 22px;"  id="pt_customer_id">
 	 	    	<option value="">全部</option>
 	 	    	<c:forEach var="item" items="${dataList}">
 	 	    		<option value="${item.customer_id}">${item.customer_name}</option>
 	 	    	</c:forEach>
 	 	    </select>
        </p>
    
        <p class="ui-fields">
 	 	    <label class="ui-label">客户类型:</label>
 	 	    <select class="easyui-combobox" name="customer_type" style="width:150px;line-height: 22px;height: 22px;" id="customer_type">
 	 	    	<option value="">全部</option>	
 	 	    	<option value="0">融资客户</option>
 	 	    	<option value="1">授信客户</option>
 	 	    	<option value="2">一般客户</option>
 	 	    </select>
        </p>
    
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>&nbsp;&nbsp;
         <a href="#" id="btn-bcrz" class="easyui-linkbutton" iconCls="icon-tip" style="float: right">报错日志</a>&nbsp;&nbsp;
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <form id="listForm" method="post">
     <table id="data-list"></table>
     </form>
     
     
     
       <!-- 库存表获取开始 -->
     <div style="display:none">
     <div id="editstock-win" class="easyui-dialog" title="库存信息" buttons="#kcmessage" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:980px;height:600px;overflow-x:hidden;">  
     	<form id="editeditstockForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="stock_customer_id" id="stock_customer_id">
     		 
     		 <div class="ftitle">客户信息</div>
     		 	<table width="100%">
   				 	<tr>
    				     <td>
					     <table id="borrowCheckRecord_data_list" class="tbBaseInfo5" width="90%"> 
					            <tr>
					            	<th>客户姓名：</th>
					            	<td>
			                               <p class="easyui-validatebox member-input" type="text" id="stock_customer_name" name="stock_customer_name"></p>
			                        </td>
			                        <th>联系电话：</th>
					            	<td>
			                               <p class="easyui-validatebox member-input" type="text" id="stock_tel" name="stock_tel"></p>
			                        </td>
					            </tr>
						     <tr>
					            	<th>联系地址：</th>
					            	<td>
			                               <p class="easyui-validatebox member-input" type="text" id="stock_addr" name="stock_addr"></p>
			                        </td>
			                        <th>风控备注：</th>
					            	<td>
			                               <p class="easyui-validatebox member-input" type="text" id="fk_bzxx" name="fk_bzxx"></p>
			                        </td>						     
						     </tr>
						     <tr>
						                <td align="right">
                                        	<a href="#" id="btn-customernoteadd-cancel" class="easyui-linkbutton" iconCls="icon-add" onclick="getcustomernote()">新增备注</a>
                                        </td>
                                        <td align="left">
                                        	<a href="#" id="btn-customernoteasearch-cancel" class="easyui-linkbutton" iconCls="icon-search" onclick="getcustomernotemore()">查看更多</a>
                                        </td>
						     </tr>					     
					     </table>
					     </td>
					</tr>
				</table>

     		 <div class="ftitle">客户库存</div> 
     		 <div id="searchPanel" >  
 	 		
 	  	 <p class="ui-fields">
 	  		<input class="hidden" type="text" name="customer_id">
            <label class="ui-label">商品名: </label><input name="good_name" id="good_name" class="easyui-box ui-text" placeholder="请输入商品名" style="width:100px;color:rgb(85, 84, 84);">
        </p>
         <p class="ui-fields">
            <label class="ui-label">商品产地 : </label><input name="good_place" id="good_place" class="easyui-box ui-text" placeholder="请输入商品产地" style="width:100px;color:rgb(85, 84, 84);">
        </p>
        <p class="ui-fields">
            <label class="ui-label">商品等级: </label>
               <select class="easyui-combobox" name="good_level" id="good_level" data-options="required:true,width:150">
	                    	<option value="" selected="selected">请选择</option>
	                    	<option value="1">顶级</option>
		                	<option value="2">普一</option>
		                	<option value="3">普二</option>
		                	<option value="4">统材</option>
	            </select>
        </p>
         <p class="ui-fields">
            <label class="ui-label">商品规格: </label><input name="good_size" id="good_size" class="easyui-box ui-text" placeholder="请输入商品规格" style="width:100px;color:rgb(85, 84, 84);">
        </p>
       <p class="ui-fields">
    	   <label class="ui-label">入库成功时间: </label>
    	       <input id="start_put_time" class="easyui-datetimebox" type="text" name="start_put_time">
			    <label>到:</label>  
			    <input id="end_put_time" class="easyui-datetimebox" type="text" name="end_put_time">
        </p> 
        <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchTabStock()">查询</a>
      
     </div> 
     		 <table>
							<tr>
								<td>
									<table id="editstockdata-list" style="width:930px"></table>
								</td>
							</tr>
						</br>
						
						<table class="tbBaseInfo"  style="width:930px">
			     		 <tr cols="4">
			     		 	<th align="left">总体积(立方米)：</th>
			     		 	<td>
			     		 	<label id="stock_totalvolume"></label>
			     		 	</td>
			     		 	
				     		<th align="left">库存商品市场总价：</th>
				     		<td>
				     		<label id="stock_totalmarketprice"></label>
				     		</td>
				     		<th align="left">库存商品折后总价：</th>
				     		<td>
				     		<label id="stock_zh_totalmarketprice"></label>
				     		</td>
                       	</tr>
                        <tr>
	                       	<th align="left">顶级(立方米)： </th>
	                       	<td><label id="stock_topvolume"></label></td>
		     		 		<th align="left">普一(立方米)：</th>
	                       	<td><label id="stock_onevolume"></label></td>
	                       	<th align="left">普二(立方米)：</th>
		     		 		<td><label id="stock_twovolume"></label></td>
		     		 		<th align="left">统材(立方米)：</th>
		     		 		<td><label id="stock_materialvolume"></label></td>
		     		 		</th>
                        </tr>
                   </table></br>
	         <div id="kcmessage" class="dialog-button">
	     
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editstock-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 库存表获取结束 -->
  	 
  	   <!-- 库存表详细新依据仓号开始 -->
     <div style="display:none">
     <div id="stockdetail-win" class="easyui-dialog" title="库存商品信息" buttons="#stock_detail_button" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:830px;height:600px;overflow-x:hidden;">  
     	<form id="stockdetailForm" class="ui-form" method="post">  
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->
     		 
     		  <table>
	     		 <tr>
		     		<th align="left"><label id="stock_detaile_customer_name"></label>-</th>
		     		<th align="left"><label id="stock_detaile_area_name"></label>-</th>
		     		<th align="left"><label id="stock_detaile_space_name"></label></th>
                        </tr>
                   </table>
                    <div class="ftitle"></div>
     		 <table>
	     		 <tr>
		     		 <td>
                        <table id="stockdetail-list"></table>
                     </td>
                 </tr>
             </table>
	         <div id="stock_detail_button" class="dialog-button">
	     
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#stockdetail-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 库存表详细新依据仓号开始结束 -->
     
      <!-- 操作日志开始 -->
     <div style="display:none">
     <div id="editoperator-win" class="easyui-dialog" title="操作日志" buttons="#operation_log" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:830px;height:600px;overflow-x:hidden;">  
     	<form id="editoperatorForm" class="ui-form" method="post">  
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->
     		 <table>
	     		 <tr>
		     		 <td>
                        <table id="operatordata-list"></table>
                     </td>
                 </tr>
             </table>
	         <div id="operation_log" class="dialog-button" >
	     
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editoperator-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 操作日志结束 -->
     
     
     
     <!-- 错误日志开始 -->
     <div style="display:none">
     <div id="editerror-win" class="easyui-dialog" title="报错日志" buttons="#editErrorPutgood" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:750px;height:480px;">  
     	<form id="editerrorForm" class="ui-form" method="post">  
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->
     		 <table>
	     		 <tr>
		     		 <td>
                         <table id="errordata-list"></table>
                     </td>
                 </tr>
             </table>
	         <div id="editErrorPutgood" class="dialog-button" style="background-color: white">
	     
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editerror-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 错误日志结束 -->
  	 
  	 
  	  <!--  风控备注客户信息编辑开始-->
  	 <!-- Edit Form -->
     <div style="display:none">
     <div id="fkkhxxedit-win" class="easyui-dialog" title="匹配编辑" buttons="#edit_match" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:760px;height:390px;">  
     	<form id="fkkhxxeditForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="fk_stock_id" id="fk_stock_id">
     		 <input class="hidden" type="text" name="fk_customer_id" id="fk_customer_id">
     		<!--  <input class="hidden" type="text" name="putstock_id"> -->
     		 <table>
	     		 <tr>
		     		 <td>  <div class="ftitle">匹配编辑</div>
                                <table id="tbGoodsInfo" class="tbBaseInfo" >
                               
                                 <tr>
                                        <th align="center" style="text-align: center;width: 200px">类目</th>
                                       <th align="center" style="text-align: center;width: 200px">仓库录入</th>
                                       <td align="center" >风控备注</td>
                                    </tr>
                                    
                                     <tr>
                                        <th align="center" style="text-align: center;">货物名称</th>
                                        <th align="center" style="text-align: center;"><label id="fkname"></label></th>
                                       <td align="center"><select  name="good_name_comment" class="easyui-combobox" style="width: 250px;border-bottom: 0px solid #f5f5f5;" id="good_name_comment">
 	 	    	                                    <option value="">全部</option>	
 	 	    	                                    
 	 	    	                          <c:forEach var="item" items="${goodList}">
 	 	    		                           <option value="${item.pz_good_name}">${item.pz_good_name}</option>
 	 	    	                        </c:forEach>
                                                     </select></td>
                                    </tr>
                                    
                                     <tr>
                                        <th align="center" style="text-align: center;">产地</th>
                                        <th align="center" style="text-align: center;"><label id="fkplace"></label></th>
                                       <td align="center"><select  name="good_place_comment" class="easyui-combobox" style="width: 250px;border-bottom: 0px solid #f5f5f5;" id="good_place_comment">
 	 	    	                                     <option value="2468">全部</option>	
 	 	    	                                    
 	 	    	                         <c:forEach var="list" items="${listP}">
            		                <option value="${list.pz_good_place}">${list.pz_good_place}</option>
            	                       </c:forEach>	
                                                     </select></td>
                                    </tr>
                                    
                                     <tr>
                                        <th align="center" style="text-align: center;">等级</th>
                                        <th align="center" style="text-align: center;"><label id="fklevel"></label></th>
                                       <td align="center"><select  name="good_level_comment"  class="easyui-combobox"  style="width: 250px;border-bottom: 0px solid #f5f5f5;" id="good_level_comment">
 	 	    	                                     <option value="2468">全部</option>	
 	 	    	                            <option value="1">顶级</option>
 	 	    	                             <option value="2">普一</option>
 	 	    	                              <option value="3">普二</option>	
 	 	    	                               <option value="4">统材</option>
                                                     </select></td>
                                    </tr>
                                    
                                    <tr>
                                        <th align="center" style="text-align: center;">规格</th>
                                       <th align="center" style="text-align: center;"><label id="fksize"></label></th>
                                       <td align="center"><select  name="good_size_comment" class="easyui-combobox"  style="width: 250px;border-bottom: 0px solid #f5f5f5;" id="good_size_comment">
 	 	    	                                    <option value="2468">全部</option>	
 	 	    	                                    
 	 	    	                          <c:forEach var="list" items="${listSC}">
            		                      <option value="${list.spec_id}">${list.spec_name}</option>
            	                             </c:forEach>
                                                     </select></td>
                                    </tr>
                                  
                                </table>
                            </td>
                        </tr>
                   </table>
                   </br>
	         <div id="edit_match" class="dialog-button" style="background-color: white">
	         <a href="#" id="btn-fklsszx-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-lsszx-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#fkkhxxedit-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!--   风控备注信息编辑结束-->
  	 <!--  客户信息编辑开始-->
  	 <!-- Edit Form -->
     <div style="display:none">
     <div id="khxxedit-win" class="easyui-dialog" title="信息编辑" buttons="#xxbj" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:400px;height:400px;">  
     	<form id="khxxeditForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="customer_id">
     		<!--  <input class="hidden" type="text" name="putstock_id"> -->
     		 <table>
	     		 <tr>
		     		 <td>
                                <table id="tbGoodsInfo" class="tbBaseInfo" width="100%">
                                <div class="ftitle">信息编辑</div> 
                                    <tr>
                                        <th align="left">客户姓名：</th>
                                        <td align="left">
                                        <input   type="text" class="easyui-validatebox" id="customer_name" name="customer_name"  readonly="readonly">
                                        </input>
                                        </td>
                                       
                                    </tr>
                                    
                                    <tr>
                                        <th align="left">授信额度：</th>
                                        <td align="left">
                                        <input id="good_id" class="easyui-validatebox" type="text" name="credit_limit">
                                        </td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        <th align="left">临时锁止线：</th>
                                        <td align="left">
                                       <input id="temporary_lock_line" class="easyui-validatebox" type="text" name="temporary_lock_line">
                                        </td>
                                      
                                    </tr>
                                    <tr>
                                        <th align="left">临时锁止开始时间：</th>
                                        <td align="left">
                                        <input id="start_time" class="easyui-datetimebox" type="text" name="start_time" >
                                        </td>
                                      
                                    </tr>
                                    <tr>
                                        <th align="left">临时锁止结束时间：</th>
                                        <td align="left">
                                        <input id="end_time" class="easyui-datetimebox" type="text" name="end_time">
                                        </td>
                                        
                                    </tr>
                                </table>
                            </td>
                        </tr>
                         <tr>
                                        <th align="left"><font color="red">(*无设置开始时间和结束时间，临时锁止线将视为无效)</font></th>
                                     
                                        
                                    </tr>
                   </table>
                   </br>
	         <div id="xxbj" class="dialog-button">
	         <a href="#" id="btn-lsszx-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-lsszx-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#khxxedit-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!--  客户信息编辑结束-->
  	 
  	      <!-- 担保金额开始 -->
     <div style="display:none">
     <div id="dbje-win" class="easyui-dialog" title="担保金额信息" buttons="#adddbje" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:700px;height:600px;overflow-x:hidden;">  
     	<form id="dbjeForm" class="ui-form" method="post">  
     	<input class="dbr_id" type="hidden" name="dbr_id">
     	<input class="dbr_name" type="hidden" name="dbr_name">
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->
     		 <table>
     		 <tr>
     		 <th align="left"><label id="dbrname" style="color:red"></label></th>
                                        <td align="left">
                                      为他人担保总金额：<label id="wtrdbje"></label>
                                        </td> 
                                       &nbsp;&nbsp;&nbsp;
                                        <td align="left">
                                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 接受担保总金额：<label id="jsdbje"></label>
                                        </td>
     		  </tr>
     		 </table>
     		 
     		 <table>
	     		 <tr>
		     		 <td>
                         <table id="dbjedata-list"></table>
                      </td>
                 </tr>
             </table>
             </br>
                   
                   <table>
	     		  <th align="left">为他人担保金额：</th>
                                        <td align="left">
                                        <input id="db_money" class="easyui-validatebox" type="text" name="db_money" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')">
                                        </td>
                                        
                 <th align="left">被担保人：</th>
                 <td align="left">
                <select class="easyui-combobox" id="bdbr_id" name="bdbr_id" style="width: 150px" >

                <c:forEach var="item" items="${dataList}">
 	 	    		<option value="${item.customer_id}">${item.customer_name}</option>
 	 	    	</c:forEach>
                 </select> 
                 <input class="bdbr_name" type="hidden" name="bdbr_name">
                   </td>
                      
                   </table></br></br>
	         <div id="adddbje" class="dialog-button" >
	     <a href="#" id="btn-dbje-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dbje-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 担保金额结束 -->
  	   <!-- 担保金额修改开始 -->
     <div style="display:none">
     <div id="dbjeupdate-win" class="easyui-dialog" title="担保金额信息" buttons="#editdbje" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:720px;height:260px;">  
     	<form id="dbjeupdateForm" class="ui-form" method="post">  
     	<input class="dbr_id" type="hidden" name="dbr_id">
     	 <input class="bdbr_id" type="hidden" name="bdbr_id">
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->

     		 
                   
                   <table>
                   <div class="ftitle">担保信息修改</div> 
                   <tr>
	     		  <th align="left">担保人：</th>
                                        <td align="left">
                                         <label id="updateForm-dbrname"></label>
                                        </td>
                                        
                 <th align="left">被担保人：</th>
                 <td align="left">
                <label id="updateForm-bdbrname"></label>
                   </td></tr>
                      <tr>
                      </tr><tr>
                      </tr>
                       <tr>
	     		  <th align="left">担保金额：</th>
                                        <td align="left">
                                         <input  class="easyui-validatebox" type="text" name="db_money" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')">
                                        </td>
                                        
                 <th align="left"></th>
                 <td align="left">
              
                   </td></tr>
                   </table></br>
	         <div class="dialog-button" id="editdbje" >
	     <a href="#" id="btn-dbjeupdate-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-error-cancels" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dbjeupdate-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 担保金额修改结束 -->
  	 	  <!-- 客户备注信息查看详情结束 -->
     <div style="display:none">
     <div id="customernotemore-win" class="easyui-dialog" title="备注信息" buttons="#bzxx" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:980px;height:540px;overflow-x:hidden;">  
     	<form id="customernotemoreForm" class="ui-form" method="post">  
     	<input class="dbr_id" type="hidden" name="note_customer_id">

     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->

              <table id="customernotemoredata-list"></table>

              </br>
                   
                 
	    <div id="bzxx" class="dialog-button" >

	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#customernotemore-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!--客户备注信息查看详情结束 -->
  	  <!-- 客户备注信息开始 -->
     <div style="display:none">
     <div id="customernote-win" class="easyui-dialog" title="备注信息" buttons="#addbz" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:980px;height:520px;overflow-x:hidden;">  
     	<form id="customernoteForm" class="ui-form" method="post">  
     	<input class="dbr_id" type="hidden" name="note_customer_id">

     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->
 
     		 
     		 <table>
	     		 <tr>
		     		 <td>
                                 <table id="customernotedata-list"></table>
                            </td>
                        </tr>
                   </table>
                   </br>
                   
                   <table>
	     		  <th align="left">备注信息：</th>
                                        <td align="left">
                                       <textarea rows="6" cols="60" name="note_content" class="dbr_id" id="note_content">
                                   
                                        </textarea>
                                        </td>
                                        
              
                      
                   </table></br></br>
	         <div id="addbz" class="dialog-button" >
	     <a href="#" id="btn-add-customernote" class="easyui-linkbutton" iconCls="icon-ok" onclick="addcustomernote()">增加</a>
	         <a href="#" id="btn-error-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#customernote-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!--客户备注信息结束 -->
  	 	   <!-- 客户备注信息修改开始 -->
     <div style="display:none">
     <div id="noteupdate-win" class="easyui-dialog" title="客户备注信息" buttons="#xgkhbz" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:670px;height:300px;">  
     	<form id="noteupdateForm" class="ui-form" method="post">  
     	<input class="dbr_id" type="hidden" name="update_note_id" id="update_note_id">
           <input class="dbr_id" type="hidden" name="update_customer_id" id="update_customer_id">
     		 <!-- <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">-->

     		   <div class="ftitle">客户备注信息修改</div> 
     		 
                   
                   <table>
                                    <tr>
	     		  	  <th align="left">备注信息：</th>
                                        <td align="left">
                                       <textarea rows="6" cols="80" name="note_content" class="dbr_id" id="update_note_content">
                                   
                                        </textarea>

                   </td></tr>
                   </table></br>
	         <div  class="dialog-button" id="xgkhbz">
	     <a href="#" id="btn-updatenote-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-error-cancels" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#noteupdate-win').window('close');">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 <!-- 客户备注信息修改结束 -->
     <!-- Edit Form -->
     <div style="display:none">
     <div id="edit-win" class="easyui-dialog" title="入库商品管理" buttons="#editPutgood_manage" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:600px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="customer_id">
     		 <input class="hidden" type="text" name="putstock_id">
     		 <table>
	     		 <tr>
		     		 <td>
                                <table id="tbGoodsInfo" class="tbBaseInfo" width="100%">
                                <div class="ftitle">入库商品信息</div> 
                                    <tr>
                                        <th align="left">仓号(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <select class="easyui-combobox" id="area_id" name="area_id" data-options="width:150,required:true,missingMessage:'仓号不能为空.'">
                                        </select>
                                        </td>
                                        <th align="left">仓位(<font color="red">*</font>)：</th>
                                        <td align="left">
                                            <select class="easyui-combobox" id="space_id" name="space_id" data-options="width:150,required:true,missingMessage:'仓位不能为空.'">
                   							</select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th align="left">商品名(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <input id="good_id" class="easyui-combobox" type="text" name="good_id">
                                        </td>
                                        <th align="left">商品产地：</th>
                                        <td align="left">
                                            <input id="good_place" class="easyui-validatebox" type="text" name="good_place">
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <th align="left">商品等级(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <select class="easyui-combobox" name="good_level" id="good_level" style="width:150px;">
							              
							             	<option value="1">1</option>
							             	<option value="2">2</option>
							             	<option value="3">3</option>
							             </select>
                                        </td>
                                        <th align="left">商品尺寸：</th>
                                        <td align="left">
                                            <input id="good_size" class="easyui-validatebox" type="text" name="good_size">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th align="left">数量(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <input id="good_number" class="easyui-validatebox" type="text" name="good_number" required="required">
                                        </td>
                                        <th align="left">体积：(<font color="red">*立方米</font>)</th>
                                        <td align="left">
                                            <input id="good_volume" class="easyui-validatebox" type="text" name="good_volume" required="required">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th align="left">重量：</th>
                                        <td align="left">
                                        <input id="good_weight" class="easyui-validatebox" type="text" name="good_weight">
                                        </td>
                                        <th align="left">添加次数：</th>
                                        <td align="left">
                                        <input id="good_number_time" class="easyui-validatebox" type="text" value="1" name="good_number_time"  onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="5"  >
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                   </table>
	         <div id="editPutgood_manage" class="dialog-button" >
	         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	         </div>
     	</form>
  	 </div> 
  	 
  	 <div style="display:none">
     <div id="editPutStock-Win" class="easyui-dialog" buttons="#editPutStock" title="入库单管理" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:900px;height:600px;overflow-x:hidden;">  
     	<form id="editPutStockForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="rkdputstock_id" id="rkdputstock_id">
     		 <input class="hidden" type="text" name="putStockRecord.customer_id">
     		 <table width="100%">
	     		 <tr>
		     		 <td>
             
                                <div class="ftitle">入库信息</div> 
                                <table id="tbRecordInfo" class="tbBaseInfo" width="100%">
                                    <tr>
                                        <th align="left">制单员(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <input id="producer" class="easyui-validatebox" type="text" name="producer">
                                        </td>
                                        <th align="left">复核人(<font color="red">*</font>)：</th>
                                        <td align="left" style="margin-left:50px;">
                                            <input id="checker" class="easyui-validatebox" type="text" name="checker">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th align="left">送货人(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <input id="sender" class="easyui-validatebox" type="text" name="sender">
                                        </td>
                                        <th align="left">客户姓名：</th>
                                        <td align="left">
                                         
 	 	                           <select class="easyui-combobox" id="customer_id" name="customer_id" style="width:150px;">
 	 	    	                        <option value="">全部</option>
 	 	    	                     <c:forEach var="item" items="${customers}">
 	 	    	                     	<option value="${item.customer_id}">${item.customer_name}</option>
 	 	                                   	</c:forEach>
 	 	                                    </select>
                                      
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <th align="left">租用类型(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <select class="easyui-combobox" name="lease_type" id="lease_type" style="width:150px">
						
							             	<option value="0" selected="selected">日租</option>
							             	<option value="1">月租</option>
							            </select>
                                        </td>
	                                     <th align="left">日租费用(<font color="red">*</font>)：</th>
					                     <td align="left">
					                     <input id="daily" class="easyui-validatebox" type="text" name="daily">&nbsp;<span>(元/平/日)</span>
					                     </td>
                                    </tr>
                                    <tr>
                                        <th align="left">提单号：</th>
                                        <td align="left">
                                            <input id="good_bill" class="easyui-validatebox" type="text" name="good_bill">
                                        </td>
                                        <th align="left">送货车号：</th>
                                        <td align="left">
                                        <input id="car_numbers" class="easyui-validatebox" type="text" name="car_numbers">
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                 
                    <tr>
                    <td>
                   		 <table id="tbRoleInfo2" width="100%">
		                 <div class="ftitle">入库商品信息</div>  
		                 <input id="btn-addPutStockGoods" type="button" style="width:80px;height:26px;" value="新增"/>&nbsp;&nbsp;
					     <input id="btn-delPutStockGoods" type="button" style="width:80px;height:26px;" value="删除"/>&nbsp;&nbsp;
					      <input id="btn-plrkGoods" type="button" style="width:80px;height:26px;" value="批量增加"/>&nbsp;&nbsp;
			                <div id="putStockGoodsDiv" style="margin-top:16px;">
							    <form id="putStockGoodsForm" method="post">
							     	<table id="putStockGoods-data-list"></table>
							    </form>
							</div>	
			         	 </div>
			         	 </table>
                    </td>
                    </tr>
                    </table>
     	</form>	
     	<!--  总计   -->
     	<div style="padding:2px 5px 6px 5px">
     	    <table id="tbInfoTotal" class="tbBaseInfo">
                 <tr>
                     <p align="left">总计：</p>
                     <th align="left" style="width: 90px">商品总体积：</th>
                     <td align="left"  style="margin-left:50px;">
                     <input id="total_volume" class="easyui-validatebox" type="text" name="total_volume">&nbsp;<span>(立方米)</span>
                     </td>
                     <th align="left">商品总重量：</th>
                     <td align="left" style="margin-left:50px;">
                         <input id="total_weight" class="easyui-validatebox" type="text" name="total_weight">&nbsp;<span>(kg)</span>
                     </td> 
                         <th align="left">总包数：</th>
                    <td align="left">
                        <input id="totalGoodsCount" class="easyui-validatebox" type="text" name="totalGoodsCount">
                    </td>
                 </tr>
                

             </table>
     	</div>
     	
     	<div id="editPutStock" class="dialog-button">
	         <a href="#" id="btn-goodtj" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         	  <a href="#" id="btn-putStockPrint" class="easyui-linkbutton" iconCls="icon-print">打印入库单</a>
	         <a href="#" id="btn-cancel" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
         
	    </div>
	    
	    
  	 </div> 
  	
</div>


   <div style="display:none">
     <div id="pledit-win" class="easyui-dialog" title="批量商品入库" buttons="#editPutgood" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:400px;height:220px;">  
     	<form id="pleditForm" class="ui-form" method="post">  
     		<!--   <input class="hidden" type="text" name="customer_id">-->
     		 <input class="hidden" type="text" id="pl_putstock_id">
     		 <table>
	     		 <tr>
		     		 <td>
                                <table id="tbGoodsInfo" class="tbBaseInfo" width="100%">
                                <div class="ftitle">入库商品数量</div> 
                                    <tr>
                                        <th align="left">入库商品数量(<font color="red">*</font>)：</th>
                                        <td align="left">
                                        <input id="pl_number" class="easyui-validatebox" type="text" name="pl_number"  maxlength="5" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'')">&nbsp;<span></span>
                                        </td>
                                 
                                    </tr>
                                   
                                </table>
                            </td>
                        </tr>
                   </table>
	         <div id="editPutgood" class="dialog-button">
	         <a href="#" id="btn-good-plrk" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	         <a href="#" id="btn-good-plrkclose" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	         </div>
     	</form>
  	 </div> 

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/tabcustomer/tabcustomer.js"></script>

  </body>
</html>
