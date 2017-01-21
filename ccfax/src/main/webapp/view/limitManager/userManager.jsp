<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*,java.io.*"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/viewer.min.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/webuploader.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
   
   <style type="text/css">
.datagrid-toolbar{display:none;}

* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a, img {
	border: 0;
}


.tab_menu {
	float: left;
	overflow: hidden;
}

.tab_menu li {
	width: 100px;
	float: left;
	height: 36px;
	line-height: 36px;
	color: #000;
	background: #D4D4D4;
	text-align: center;
	cursor: pointer;
}

.tab_menu li.current {
	color: #333;
	background: #eee;
}

.tab_menu li a {
	color: #fff;
	text-decoration: none;
}

.tab_menu li.current a {
	color: #333;
}

.tab_box {
	padding: 20px;
}

.tab_box li {
	height: 28px;
	line-height: 28px;
	overflow: hidden;
}

.tab_box li span {
	margin: 0 5px 0 0;
	font-family: "Microsoft yahei";
	font-size: 14px;
	font-weight: 400;
	color: #ddd;
}

.tab_box .hide {
	display: none;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-top: 10px;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.subtotal {
	font-weight: bold;
} /*合计单元格样式*/
.list li.cf {
	min-height: 30px;
	line-height: 30px;
	padding: 10px 0 10px 150px;
}

.list .handle {
	padding: 10px 0;
	display: inline;
	width: 100%;
	margin-left: -100px;
	text-align: right;
	color: #333;
}

.list .handle span {
	margin: 0 5px 0 5px;
	font-family: "Microsoft yahei";
	font-size: 14px;
	font-weight: 400;
	color: #666;
}

body {
	background: #fff;
	height: 100%;
	font: normal normal 14px/24px "Microsoft yahei", Arial;
	padding-bottom: 30px;
}
      
     
   </style>
  </head>
  
 <body>
	
   <div>
	<!-- Search panel start -->
 	 <div id="searchPanel" class="easyui-panel ui-search-panel" title="" data-options="striped: true,collapsible:true,iconCls:'icon-search'">  
 	 <form id="searchForm">
 	  	 <p class="ui-fields">
            <label class="ui-label">用户ID: </label><input name="usrid" id="yhid" class="easyui-box ui-text" placeholder="请输入用户ID" style="width:150px;color:rgb(85, 84, 84);">
        </p>
         <p class="ui-fields">
            <label class="ui-label">姓名: </label><input name="usrname" id="xm" class="easyui-box ui-text" placeholder="请输入姓名" style="width:150px;color:rgb(85, 84, 84);">
        </p>
        <p class="ui-fields">
            <label class="ui-label">手机号: </label><input name="mobile_phone" id="sjh" class="easyui-box ui-text" placeholder="请输入手机号" style="width:150px;color:rgb(85, 84, 84);">
        </p>
         <p class="ui-fields">
            <label class="ui-label">身份证号: </label><input name="id_card" id="sfzh" class="easyui-box ui-text" placeholder="请输入身份证号" style="width:150px;color:rgb(85, 84, 84);">
        </p>
        <p class="ui-fields">
    	    <label>状态:</label>  
            <select name="is_loan" data-options="width:150">
                	<option value="" selected="selected">全部</option>
                	<option value="0">冻结</option>
                	<option value="1">正常</option>
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

     	<!-- 额度冻结Start -->
     	 <div style="display:none;">
	  	 <div id="modify_win" class="easyui-dialog" title="额度冻结" buttons="#editAreaFormBtn" data-options="closed:true,iconCls:'',modal:true" style="width:555px;height:300px;">  
	     	<form id="updateLimitForm" class="ui-form" method="post">  
	     		 <div class="ui-edit">
		         <div class="fitem">  
		              <span class="tip_info"> 冻结后，用户将不能使用剩余额度，请认真填写备注:</span>
		               <textarea rows="10" cols="80"  id="freeze_remark" name="freeze_remark" style="margin-top: 10px;"></textarea>
		           </div>
		         </div>
		         <div id="editAreaFormBtn" class="dialog-button">
		         <a href="#" id="btn-good-submit" class="easyui-linkbutton" iconCls="icon-ok" >保存</a>
		         <a href="#" id="btn-good-cancel" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#modify_win').window('close', true)">关闭</a>
		         </div>
	     	</form>
	  	 </div> 
	  	</div>
	  	<!-- 额度冻结End -->
  	 
  	 
  <!------------------------------------用户信息查看页面-------------------------------------->	 
   <div id="checkApply-win" style="padding: 20px; display:none" class="box demo2">
      <!--页头标签部分-->
       <ul class="tab_menu" id="tab_menu">
			<li class="current">用户注册信息</li>
			<li>评分报告列表</li>
			<li>借款历史</li>
	   </ul>
	
	<div class="tab_box" id="tab_box">
	
		<!--用户注册信息部分-->
		  <div style="width: 100%;padding: 10px;font-size: 14px;overflow:hidden;" id="tabUsrinfo">
		     <input type="hidden" name="usrid" id="usrid">
		     <input class="hidden" type="text" id="usrinf_id" name="usrinf_id">
		     <div class="ftitle">用户注册信息:</div>
			<table>
				<tr>
					<td>
						<table class="tbBaseInfo2" width="100%">

							<tr>
								<th align="left">姓名：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="usrname"
										name="usrname" data-options="width:150"></p>
								</td>
							</tr>
							
							<tr>
								<th align="left">身份证号：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="id_card"
										name="id_card" data-options="width:150"></p>
								</td>
							</tr>

							<tr>
								<th align="left">手机号码：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="mobile_phone"
										name="mobile_phone" data-options="width:150"></p>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		    </div>
		    
		 <!--评分报告列表部分-->
		 <div class="hide">
			<%@include file="/view/limitManager/scoringReport.jsp" %>
        </div>
        
         <!--借款历史-->
		 <div class="hide">
		 <%@include file="/view/limitManager/user_borrow_info.jsp"%>
		 </div>
  </div>
  
  	<div class="clear"></div>
</div>

  <!-- 征信资料展示  -->
     <div id="zhengxin_info-win" style="padding: 10px; display:none">
     	<div class="crumb-wrap">
	        <div class="crumb-list"><i class="icon-font"></i>&nbsp;<span class="crumb-name">征信资料</span>
	        <a class="btn-back" href="javascript:window.location.href='${msUrl}/userManager/list.shtml'">返回</a>
	        </div>
    	</div>	
		<div id="zhengxin_Info" class="tbBaseInfo3" style="margin-top:30px;">
				<div id="zhengxinInfo">
 				<iframe id="pdf_url" src="" frameborder="0" style="width: 1000px; height: 1000px;">
                </iframe> 
		</div>
		</div>
     </div>
</div>
<div class="scroll-top"></div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.tabs.js"></script>
<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/limitManager/tabusrinf_common.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/limitManager/scoringReport.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/limitManager/user_borrow_info.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/limitManager/userManager.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.lazyload.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/viewer-jquery.min.js"></script>


<script type="text/javascript">
	$(function() {
		$('.demo2').Tabs({
			event : 'click'
		});
		$("img").lazyload({
			effect : "fadeIn"
		});
		$('#idCardShow').viewer();
	});
</script>
</body>
</html>
