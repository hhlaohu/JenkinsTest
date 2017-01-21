<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/view/resource.jsp"%>
<link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${msUrl}/css/webuploader.css" />
<link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${msUrl}/css/user_login.css">

 <style type="text/css">
      .datagrid-toolbar{display:none;}
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
</style>


</head>
<body>
	<div class="warp easyui-panel" data-options="border:false">
		<!-- Search panel start -->
		<div id="searchPanel" class="easyui-panel ui-search-panel" title=""
			data-options="striped: true,collapsible:true,iconCls:'icon-search'">
			<form id="searchForm" name="searchForm">
				<input type="hidden" name="usrinf_id" id="usrinf_id"> <input
					class="hidden" type="text" id="user_name" name="user_name"
					value="${user.real_name}">
				<p class="ui-fields">
					<label class="ui-label">用户ID: </label><input name="usrid" id="yhid"
						class="easyui-box ui-text" placeholder="请输入用户ID"
						style="width: 150px; color: rgb(85, 84, 84);">
				</p>
				<p class="ui-fields">
					<label class="ui-label">姓名: </label><input name="usrname" id="xm"
						class="easyui-box ui-text" placeholder="请输入姓名"
						style="width: 150px; color: rgb(85, 84, 84);">
				</p>
				<p class="ui-fields">
					<label class="ui-label">手机号: </label><input name="mobile_phone"
						id="sjh" class="easyui-box ui-text" placeholder="请输入手机号"
						style="width: 150px; color: rgb(85, 84, 84);">
				</p>
				<p class="ui-fields">
					<label>状态:</label> <select name="check_flag"
						data-options="required:true,width:150">
						<option value="" selected="selected">全部</option>
						<option value="1">待审核</option>
						<option value="2">初审不通过</option>
						<option value="3">初审通过</option>
						<option value="4">复审不通过</option>
						<option value="5">复审通过</option>
						<option value="7">终审不通过</option>
						<option value="8">终审通过</option>
					</select>
				</p>
				<p class="ui-fields">
					<label>申请时间:</label> <input id="applyfor_time_start"
						class="easyui-datetimebox" type="text" name="applyfor_time_start">
					<label>到:</label> <input id="applyfor_time_end"
						class="easyui-datetimebox" type="text" name="applyfor_time_end">
				</p>
				<a href="#" id="btn-search" class="easyui-linkbutton"
					iconCls="icon-search">查询</a>
			</form>
		</div>
		<!--  Search panel end -->

		<!-- DataList  -->
		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>

		<div id="checkApply-win" style="padding: 20px; display: none" class="box demo2">
			
				<!--页头标签部分-->
	       <ul class="tab_menu" id="tab_menu">
				<li class="current">授信审核</li>
				<li>评分报告列表</li>
		   </ul>
			
		<div class="tab_box" id="tab_box">
		
		   <div>
		    <input type="hidden" name="usrid" id="usrid">
			<%@include file="/view/limitManager/tab_user_info.jsp" %>
				
				<!-- 编辑补充资料显示框 -->
					<div id="edit_tabUsrComplementPic" style="display: none;">
						<div class="ftitle">补充资料:</div>
						<div id="uploader">
							<div class="queueList">
								<div id="dndArea" class="placeholder">
									<!-- <img width="180" height="115" class="js-pic" style="cursor: pointer;" data-rel="/tsfkxt/upload/test.jpg" src="/tsfkxt/upload/test.jpg"> -->
									<div id="filePicker"></div>
									<p>或将照片拖到这里，单次最多可选300张</p>
								</div>
							</div>
							<div class="statusBar" style="display: none;">
								<div class="progress">
									<span class="text">0%</span> <span class="percentage"></span>
								</div>
								<div class="info"></div>
								<div class="btns">
									<div id="filePicker2"></div>
									<div class="uploadBtn">开始上传</div>
								</div>
							</div>
						</div>
					</div>


				<div class="ftitle">审核情况:</div>
				<form id="checkForm_info" method="post">
					<input type="hidden" name="usrinf_id" id="usrinf_id">
					<table>
						<!-- 初审 -->
						<div id="first_checked">
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">审核结果：</label>
								<input type="radio" id="check_result" name="check_result"
									value="3" checked="true" />通过&nbsp;&nbsp; <input type="radio"
									id="check_result2" name="check_result" value="2" />不通过

							</div>
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">授信额度(<font
									color="red">*</font>)：
								</label> <input id="applyfor_limit" name="applyfor_limit"
									class="easyui-numberbox" style="width: 200px; height: 26px;"
									data-options="precision:2">&nbsp;元
							</div>
						</div>

						<!-- 复审 -->
						<div id="second_checked">
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">审核结果：</label>
								<input type="radio" id="check_result3" name="check_result"
									value="5" />通过&nbsp;&nbsp; <input type="radio"
									id="check_result4" name="check_result" value="4" />不通过
								<!--原程序逻辑退回初审值为1，为了区分退回初审和待初审，将退回初审的值改为6-->
								<input type="radio" id="check_result5" name="check_result"
									value="6" />退回初审
							</div>
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">授信额度(<font
									color="red">*</font>)：
								</label> <input id="second_check_loan_limit"
									name="second_check_loan_limit" class="easyui-numberbox"
									style="width: 200px; height: 26px;" data-options="precision:2">&nbsp;元
							</div>
						</div>

						<!-- 终审 -->
						<div id="final_checked">
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">审核结果：</label>
								<input type="radio" id="check_result8" name="check_result"
									value="8" />通过&nbsp;&nbsp; <input type="radio"
									id="check_result7" name="check_result" value="7" />不通过
								<!--退回复审本质上的状态是初审通过待复审-->
								<input type="radio" id="check_result9" name="check_result"
									value="9" />退回复审
							</div>
							<div class="fitem" style="margin-top: 30px;">
								<label style="text-align: left; margin-left: 20px;">授信额度(<font
									color="red">*</font>)：
								</label> <input id="loan_limit" name="loan_limit"
									class="easyui-numberbox" style="width: 200px; height: 26px;"
									data-options="precision:2">&nbsp;元
							</div>
						</div>

						<div class="fitem" style="margin-top: 30px;">
							<label style="text-align: left; margin-left: 20px;">额度有效期至：</label>
							<input id="limit_validity_time" class="easyui-datebox"
								type="text" name="limit_validity_time" style="width: 200px;"
								editable="false">
						</div>
						<div class="fitem" style="margin-top: 30px;">
							<label style="text-align: left; margin-left: 20px;">审核意见(<font
								color="red">*</font>)：
							</label>
							<textarea rows="6" cols="80" class="J_Comment_Content"
								id="check_remark" name="check_remark"
								placeholder="请输入审核意见,限制50字..."></textarea>
						</div>
					</table>

					<div style="margin: 10px 300px; width: 300px;">
						<input id="updateCheckLog" class="btn-primary" value="确认"
							type="button">
					</div>
				</form>


			<div class="ftitle">审核日志:</div>
				<div>
				   <div>
				      <div class="label">备注：</div>
				      <input type="hidden" id="checkLogComment2_usrinf_id">
						<textarea rows="12" cols="120"  id="checkLogComment"
						style="margin: 10px; padding: 10px; float:left">
				    
				 
				        </textarea>
				   </div>
				   <div style="padding:70px">
				     <input id="saveCheckLogComment" class="btn-primary3" value="保存" type="button">
				   </div>
				</div>
				<form id="checkLogForm_detail" method="post"
					style="margin-bottom: 10px; padding: 10px;">
					<table id="checkLog_detail_list"></table>
				</form>
		  </div>
		
		   <!--评分报告列表部分-->
		 <div class="hide">
			<%@include file="/view/limitManager/scoringReport.jsp" %>
         </div>
		  
	 	</div>
		
		<div class="clear"></div>
	</div>

	<!-- 当前审批人员展示 -->
	<div id="currentOperator-win" style="width: 770px; height: 550px;"
		class="easyui-dialog" buttons="#applyRecordButton" title="当前审批人员"
		data-options="closed:true,iconCls:'icon-select',modal:true">
		<form id="currentOperatorForm" method="post">
			<table id="currentOperator_data_list"></table>
		</form>
		<div id="currentOperatorButton" class="dialog-button">
			<a href="#" id="currentOperator-cancel" class="easyui-linkbutton"
				iconCls="icon-cancel">关闭</a>
		</div>
	</div>

	<!-- 申请记录  -->
	<div id="applyRecord-win" style="width: 850px; height: 550px;"
		class="easyui-dialog" buttons="#applyRecordButton" title="申请记录"
		data-options="closed:true,iconCls:'icon-select',modal:true">
		<form id="applyRecordForm" method="post">
			<table id="applyRecord_data_list"></table>
		</form>
		<div id="applyRecordButton" class="dialog-button">
			<a href="#" id="applyRecord-cancel" class="easyui-linkbutton"
				iconCls="icon-cancel">关闭</a>
		</div>
	</div>

	<!-- 审核日志  -->
	<div id="checkRecord-win" style="width: 960px; height: 700px;"
		class="easyui-dialog" buttons="#checkRecordButton" title="审核日志"
		data-options="closed:true,iconCls:'icon-select',modal:true">
		<div>
			   <div>
			      <div class="label">备注：</div>
					<textarea rows="12" cols="120"  id="checkLogComment2"
					style="margin: 10px; padding: 10px;">
			        </textarea>
			   </div>
			   <div style="padding: 10px">
			     <input id="saveCheckLogComment2" class="btn-primary3" value="保存" type="button">
			   </div>
		</div>
		
		<form id="checkRecordForm" method="post">
			<table id="checkRecord_data_list"></table>
		</form>
		<div id="checkRecordButton" class="dialog-button">
			<a href="#" id="checkRecord-cancel" class="easyui-linkbutton"
				iconCls="icon-cancel">关闭</a>
		</div>
	</div>

	<!-- 征信资料展示  -->
	<div id="zhengxin_info-win" style="padding: 10px; display: none">
		<div class="crumb-wrap">
			<div class="crumb-list">
				<i class="icon-font"></i>&nbsp;<span class="crumb-name">征信资料</span><span
					class="crumb-step">&gt;</span><span id="zhengxin_type"
					class="crumb-name"></span> <a class="btn-back"
					href="javascript:window.location.href='${msUrl}/creditCheck/list.shtml'">返回</a>
			</div>
		</div>
		<div id="zhengxin_Info" class="tbBaseInfo3" style="margin-top: 30px;">
			<div id="zhengxinInfo">
				<iframe id="pdf_url" src="" frameborder="0"
					style="width: 1000px; height: 1000px;" frameborder="0"
					scrolling="no"> </iframe>
			</div>
		</div>
	</div>
	<div class="scroll-top"></div>

	<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
	<script type="text/javascript" src="${msUrl}/js/commons/jquery.tabs.js"></script>
	<script type="text/javascript" src="${msUrl}/js/ux/limitManager/tabusrinf_common.js"></script>
	<script type="text/javascript" src="${msUrl}/js/ux/limitManager/scoringReport.js"></script>
	<script type="text/javascript" src="${msUrl}/js/ux/limitManager/creditCheck.js"></script>
	<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
	<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
	<script type="text/javascript" src="${msUrl}/js/commons/jquery.lazyload.js"></script>
	<script type="text/javascript">
		$(function() {
			if ($.trim($("#yhid").val()) == '') {
				$("#yhid").css("color", '#AAA9A9');
			}
			if ($.trim($("#xm").val()) == '') {
				$("#xm").css("color", '#AAA9A9');
			}
			if ($.trim($("#sjh").val()) == '') {
				$("#sjh").css("color", '#AAA9A9');
			}
			
			$('.demo2').Tabs({
				event : 'click'
			});
			
			$("img").lazyload({
				effect : "fadeIn"
			});
		});

		function goBack() {
			window.history.go(-1);
		}
	</script>

</body>
</html>
