<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
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
            <label class="ui-label">用户ID:&nbsp;&nbsp;&nbsp; </label><input id="yhid" name="borrow_uid" class="easyui-box ui-text" placeholder="请输入用户ID" style="width:150px;color:rgb(85, 84, 84);">
        </p>
         <p class="ui-fields">
            <label class="ui-label">标号ID: </label>
            <input id="bhid" name="bidding_id" class="easyui-box ui-text"  onkeypress="return event.keyCode>=48&&event.keyCode<=57" onpaste="return !clipboardData.getData(\'text\').match(/\D/)" ondragenter="return false"
            placeholder="请输入标号ID" style="width:150px;color:rgb(85, 84, 84);">
        </p>
        <p class="ui-fields">
    	    <label>借款种类:</label>  
            <select name="product_type" class="easyui-combobox"
                   data-options="
			     valueField: 'dictionary_value_key',
                             textField: 'dictionary_value_name',
			     url:'${msUrl}/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type'
			   ">
            </select>
        </p>
       
        <p class="ui-fields">
	        <label>发标时间:</label>  
		    <input id="add_time_start_time" class="easyui-datetimebox" type="text" name="add_time_start_time">
		    <label>--</label>  
		    <input id="add_time_end_time" class="easyui-datetimebox" type="text" name="add_time_end_time">
	    </p>
	    
	    <p class="ui-fields">
          <label class="ui-label">审核状态: </label>
          	    <select name="borrow_status" data-options="required:true,width:150">
	           			<option value="3">全部</option>
	                	<option value="0">待审核</option>
	                	<option value="1">初审失败</option>
	                	<option value="2">初审通过</option>
	                	<option value="8">已审核未发标</option>
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
     
     <!-- 查看会员资料  -->
     <div style="display:none">
     <div id="memberInfo-win" class="easyui-dialog" title="用户详细信息" buttons="#memberButton" data-options="closed:true,iconCls:'icon-view',modal:true" style="width:800px;height:450px;overflow-x:hidden;">  
     	<form id="memberInfoForm" class="ui-form" method="post">  
            	<table width="100%">
   				 <tr>
    				 <td>
                             <div class="member_pic">
                             	<img id="id_card_front" src="../images/member2.png" style="width:30px;height:30px;margin-left:10px; "/>	
                             	<span style="line-height:30px;position:absolute;margin:auto 5px;">会员资料</span>
                             </div> 
                             <table id="tbCustomerInfo" class="tbBaseInfo4" width="100%">
                                 <tr>
                                     <th ><span style="color:#0081c2;font-weight:bolder">用户名：</span></th>
                                     <td >
                                      <p class="easyui-validatebox member-input" type="text" id="borrow_userName" name="borrow_userName"></p>
                                     </td>
                                     <th ><span style="color:#0081c2;font-weight:bolder">认证情况：</span></th>
                                     <td >
                                         <span id="vip_ifExist">
                                     	 	<img id="vip_front" src="../images/vip.png" title="VIP会员" style="width:30px;height:30px;cursor:pointer;"/>	
                                     	 </span>
                                     	 <span id="id_card_ifExist">
                                     	 	<img id="id_card_front" src="../images/id_card.png" title="实名认证" style="width:30px;height:30px;cursor:pointer;"/>	
                                     	 </span>
                                     	 <span id="phone_ifExist">
                                     	 	<img id="phone_front" src="../images/phone_o.png" title="手机认证" style="width:30px;height:30px; cursor:pointer;"/>	
                                     	 </span>
                                     	 <span id="email_ifExist">
                                     	 	<img id="email_front" src="../images/email.png" title="邮箱认证" style="width:30px;height:30px; cursor:pointer;"/>
                                     	 </span>

                                     </td>
                                 </tr>
                                 <tr>
                                     <th align="left">用户类型：</th>
					                 <td align="left">
					                    	<p class="easyui-validatebox member-input" type="text" id="user_regtype" name="user_regtype"></p>
					                 </td>
                                     <th align="left">身份：</th>
                                     <td align="left">
                                         <p class="easyui-validatebox member-input" type="text" id="is_vip" name="is_vip"></p>
                                     </td>
                                 </tr>
                                 <tr>
                                     <th align="left">推荐人：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="recommend_name" name="recommend_name"></p>
                                     </td>
                                     <th align="left">所属客服：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="customer_services" name="customer_services"></p>
                                     </td>

                                 </tr>
                                 <tr>
                                     <th align="left">真实姓名：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="real_name" name="real_name"></p>
                                     </td>
                                     <th align="left">冻结账号：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="salesman" name="salesman"></p>
                                     </td>                                     
                                 </tr>
                                 <tr>
                                     <th align="left">身份证号：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="idcard" name="idcard"></p>
                                     </td>
                                     <th align="left">认证邮箱：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="user_email" name="user_email"></p>
                                     </td>                                     
                                 </tr> 
                                 <tr>
                                     <th align="left">手机号：</th>
                                     <td align="left">
                                     	<p class="easyui-validatebox member-input" type="text" id="user_phone" name="user_phone"></p>
                                     </td>
                                 </tr>                                                                   
                             </table>
                         </td>
                     </tr>
                 </table>
     		</form>
     	 <div id="memberButton" >
        	 <a href="#" id="memberInfo-cancel" class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
         </div>
  	 </div> 
  	 </div>
     <!-- 查看审核记录  -->
     <div style="display:none">
	     <div id="borrowCheckRecord-win" style="width:800px;height:400px;" buttons="#borrowCheckRecordButton" class="easyui-dialog" title="审核记录 " data-options="closed:true,iconCls:'icon-select',modal:true">
	     	 <input class="hidden" type="text" id="deal_user" name="deal_user" value="${user.id}">
		     <form id="borrowCheckRecordForm" method="post">
		         <table width="100%" id="borrowCheckRecordTable">
   				 	
				</table>
		     </form>
	     	 <div id="borrowCheckRecordButton" >
	        	 <a href="#" id="borrowCheckRecord-cancel" class="easyui-linkbutton" iconCls="icon-cancel">返回</a>
	         </div>
	     </div> 
	 </div>
	 
	 <!--修改发标时间-->
	<div style="display:none">
	     <div id="modifyAddTime-win" style="width:750px;height:350px;" buttons="#modifyAddTimeButton" class="easyui-dialog" title="修改发标时间" data-options="closed:true,iconCls:'icon-select',modal:true">
	     	<input type="hidden" id="bidding-id" />
	     	<input type="hidden" id="check-remark" />
	     	<div style="padding-left:100px;padding-top:10px">
	     	  <label style="padding: 5px;padding-right:30px" >原发布时间:&nbsp;&nbsp;&nbsp; </label>
	     	  <label style="padding: 5px" id="orignal-addTime"/>
	     	</div>
	     	
	     	<div style="padding-left:100px;padding-top:30px" id="new-add-time-div">
	     	  <label style="padding: 5px;padding-right:30px" >新发布时间:&nbsp;&nbsp;&nbsp; </label>
	     	  <input id="new-add-time" class="easyui-datetimebox" type="text" name="new-add-time">
	     	</div>
	     	
	     	<div style="padding-top:15px">
	     	  <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
	     	</div>
	     	
	     	<div style="padding-left:100px;padding-top:30px">
	     	 <div>
	     	 
	     	 </div>
	     	  <input id="isCancel" type="checkbox" name="isCancel" />
	     	  <label style="padding-right:30px">取消发布</label>
	     	  <label>取消发布后不可还原，该借款为未通过状态，全木行订单状态为已关闭</label>
	     	</div>
	     	
	     	
	     	<div style="padding-left:100px;padding-top:20px">
	     	  <textarea id = "cancelReason" class="J_Comment_Content" cols="80" rows="5" > </textarea>
	     	
	     	</div>
	     	
	     <div id="modifyAddTimeButton" style="text-align:center;">
	        
	        <a href="javascript:void(0)" class="easyui-linkbutton" id="confirmModifyAddTime">确定</a>
	        <a href="javascript:void(0)" id="modifyAddTime-cancel" class="easyui-linkbutton">取消</a>
	     </div>
	     
	     </div>
	 </div>
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/borrowList.js"></script>
<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>

 </body>
</html>
