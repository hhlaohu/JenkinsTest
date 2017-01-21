<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/view/resource.jsp"%>
<link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${msUrl}/css/viewer.min.css" />
<link rel="stylesheet" type="text/css" href="${msUrl}/css/webuploader.css" />
<link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
<script type="text/javascript" src="${msUrl}/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/viewer-jquery.min.js"></script>
<style type="text/css">
.datagrid-toolbar {
	display: none;
}

* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a, img {
	border: 0;
}

body {
	background: #fff;
	height: 100%;
	font: normal normal 14px/24px "Microsoft yahei", Arial;
	padding-bottom: 30px;
}

a {
	color: #333;
	text-decoration: none;
}

a:hover {
	color: #093;
	text-decoration: none;
}

#title {
	width: 300px;
	margin: 3% auto 0;
}

#title h2 {
	font-size: 18px;
}

#wrapper {
	width: 100%;
	height: 100%;
	margin: 0 auto;
	background: #fff;
	border: 1px solid #a3a3a3;
	padding: 20px 20px 50px;
	border-radius: 5px;
	-moz-border-radius: 5px;
}

/* box */
.box {
	float: left;
	width: 100%;
	height: 36px;
	background: #fff;
	border: 1px solid #d3d3d3;
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
</style>
</head>
<body>

	<div id="updateBidding-win" style="padding: 20px; width: 96%;">
		<div class="warp" data-options="border:false">

            <input type="hidden" name="usrid" id="usrid" value="${tabBorrowInfo.borrow_uid}">

			<div style="padding-bottom: 20px">
				<span style="font-size: 25px">${tabBorrowInfo.borrow_name}</span>
			</div>
			
			<div class="box demo2">
				<ul class="tab_menu">
					<li class="current">标的信息审核</li>
					<c:if test="${tabBorrowInfo.borrow_use==9}">
					<li id="orderInfoLi">订单详情</li>
					<li>第三方征信资料</li>
					<li ="scoringReportLi">评分报告列表</li>
					<li id="borrowHistoryLi">借款历史</li>
					</c:if>
				</ul>
				<div class="tab_box">
					<div id="checkInfo"
						style="width: 100%; margin: 10px auto; padding: 10px; font-size: 14px;">
						<form id="biddingForm_info" method="post">
							<!-- 标的审核人id -->
							<input class="hidden" type="text" id="deal_user" name="deal_user" value="${user.id}"> 
							<input class="hidden" type="text" id="bidding_id" name="bidding_id" value="${tabBorrowInfo.bidding_id}"> 
							<input class="hidden" type="text" id="order_id" name="order_id" value="${tabBorrowInfo.order_id}"> 
							<input class="hidden" type="text" id="borrow_uid" name="borrow_uid" value="${tabBorrowInfo.borrow_uid}"> 
							<input class="hidden" type="text" id="borrow_use" name="borrow_use" value="${tabBorrowInfo.borrow_use}">
							<table>
								<tr>
									<td>
										<table class="tbBaseInfo3" width="100%">
										<c:if test="${tabBorrowInfo.borrow_use==9}">
										    <tr>
												<th align="left">订单号：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input" 
													value="${tabBorrowInfo.order_id}"
													readonly="readonly"></input></td>
											</tr>
										</c:if>
											<tr>
												<th align="left">借款标题：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input" id="borrow_name"
													name="borrow_name" value="${tabBorrowInfo.borrow_name}"
													readonly="readonly"></input></td>
											</tr>
											<tr>
												<th align="left">借款金额：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input" id="borrow_money"
													name="borrow_money" value="${tabBorrowInfo.borrow_money}"
													readonly="readonly"></input></td>
											</tr>
											<tr>
												<th align="left">借款类型：</th>
												<td align="left">
												<select class="easyui-combobox" name="product_type" disabled="disabled"
												  data-options="
													     valueField: 'dictionary_value_key',
						                                 textField: 'dictionary_value_name',
													     url:'${msUrl}/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type',
													     value:${tabBorrowInfo.product_type}"
   												  >
												</select></td>
											</tr>
											<tr>
												<th align="left">借款标分类：</th>
												<td align="left"><c:choose>
														<c:when test="${tabBorrowInfo.borrow_type==1}">
															<p class="easyui-validatebox borrow-input"
																id="borrow_type" name="borrow_type" readonly="readonly"
																style="float: left; line-height: 24px;">信用标</p>
														</c:when>
														<c:when test="${tabBorrowInfo.borrow_type==2}">
															<p class="easyui-validatebox borrow-input"
																id="borrow_type" name="borrow_type" readonly="readonly"
																style="float: left; line-height: 24px;">担保标</p>
														</c:when>
														<c:otherwise>
															<p class="easyui-validatebox borrow-input"
																id="borrow_type" name="borrow_type" readonly="readonly"></p>
														</c:otherwise>
													</c:choose></td>
											</tr>

											<tr>
												<th align="left">借款用途：</th>
												<td align="left"><select
													class="easyui-combobox borrow-input" name="borrow_use"
													disabled="disabled">
														<c:if test="${tabBorrowInfo.borrow_use==1}">
															<option value="1">短期周转</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==2}">
															<option value="2">生意周转</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==3}">
															<option value="3">生活周转</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==4}">
															<option value="4">购物消费</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==5}">
															<option value="5">不提现借款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==6}">
															<option value="6">创业借款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==7}">
															<option value="7">其它借款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==8}">
															<option value="8">装修借款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.borrow_use==9}">
															<option value="9">信用千金</option>
														</c:if>
												</select></td>
											</tr>
											<tr>
												<th align="left">借款期限：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input"
													id="borrow_duration" name="borrow_duration"
													value="${tabBorrowInfo.borrow_duration_txt}"
													readonly="readonly"></input></td>
											</tr>
											<tr>
												<th align="left">年化利率：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input"
													id="borrow_interest_rate" name="borrow_interest_rate"
													value="${tabBorrowInfo.borrow_interest_rate}%"
													readonly="readonly"></input></td>
											</tr>
									    <c:if test="${tabBorrowInfo.product_type != 5}">
											<tr>
												<th align="left">加息率：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input"
													id=jiaxi_rate name="jiaxi_rate"
													value="${tabBorrowInfo.jiaxi_rate}%"
													readonly="readonly"></input></td>
											</tr>
											</c:if>
											<tr>
												<th align="left">还款方式：</th>
												<td align="left"><select
													class="easyui-combobox borrow-input" name="repayment_type"
													disabled="true">
														<c:if test="${tabBorrowInfo.repayment_type==1}">
															<option value="1">按天计息，一次性还本付息</option>
														</c:if>
														<c:if test="${tabBorrowInfo.repayment_type==2}">
															<option value="2">等额本息</option>
														</c:if>
														<c:if test="${tabBorrowInfo.repayment_type==3}">
															<option value="3">按季分期还款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.repayment_type==4}">
															<option value="4">每月还息到期还本</option>
														</c:if>
														<c:if test="${tabBorrowInfo.repayment_type==5}">
															<option value="5">一次性还款</option>
														</c:if>
														<c:if test="${tabBorrowInfo.repayment_type==7}">
															<option value="7">等额本金</option>
														</c:if>
												</select></td>
											</tr>

											<c:if test="${tabBorrowInfo.product_type==5}">
												<tr>
													<th align="left">每期手续费:</th>
													<td align="left"><input
														class="easyui-validatebox borrow-input"
														id="borrow_interest" name="borrow_interest"
														value="${tabBorrowInfo.borrow_interest}" readonly="{}"></input>
													</td>
												</tr>
											</c:if>

											<tr>
												<th align="left">项目阐述：</th>
												<td align="left"><textarea id="borrow_info"
														name="borrow_info" disabled="disabled">${tabBorrowInfo.borrow_info}</textarea>
													<script type="text/javascript">
														CKEDITOR
																.replace("borrow_info")
													</script>
												</td>
											</tr>
											<c:if test="${tabBorrowInfo.product_type != 5}">
												<tr>
													<th align="left">货物入仓单：</th>
													<td align="left"><textarea id="warehousing"
															name="warehousing" disabled="disabled">${tabBorrowInfo.warehousing}</textarea>
														<script type="text/javascript">
															CKEDITOR
																	.replace("warehousing")
														</script>
													</td>
												</tr>
											</c:if>
											<tr>
												<th align="left">是否允许自动投标：</th>
												<td align="left">
													<!-- <p class="easyui-validatebox borrow-input" id="can_auto" name="can_auto"></p> -->
													<c:if test="${tabBorrowInfo.can_auto==0}">
														<input type="radio" id="can_auto" name="can_auto"
															value="0" checked="true" />否</c:if>&nbsp;&nbsp; <c:if
														test="${tabBorrowInfo.can_auto==1}">
														<input type="radio" id="can_auto2" name="can_auto"
															value="1" checked="true" />是</c:if>
												</td>
											</tr>
											<tr>
												<th align="left">募集时间（天）：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input" id="collect_day"
													name="collect_day" value="${tabBorrowInfo.collect_day}"
													readonly="readonly"></input></td>
											</tr>

											<tr>
												<th align="left">最多投标总额：</th>
												<td align="left"><input
													class="easyui-validatebox borrow-input" id="borrow_max"
													name="borrow_max" value="${tabBorrowInfo.borrow_max}"
													readonly="readonly"></input></td>
											</tr>
											
                                           <!------------------如果不是分期购则显示以下信息------------------------------------------->
											<c:if test="${tabBorrowInfo.product_type != 5}">

												<tr>
													<th align="left">最低投标金额：</th>
													<td align="left"><input
														class="easyui-validatebox borrow-input" id="borrow_min"
														name="borrow_min" value="${tabBorrowInfo.borrow_min}"
														readonly="readonly"></input></td>
												</tr>

												<tr>
													<th align="left">担保公司名称：</th>
													<td align="left"><input
														class="easyui-validatebox borrow-input" id="danbao_company_name"
														name="danbao_company_name" value="${tabBorrowInfo.danbao_company_name}"
														readonly="readonly"></input></td>
												</tr>

												<tr>
													<th align="left">担保公司服务费</th>
													<td align="left"><input
														class="easyui-validatebox borrow-input" id="vouch_money"
														name="vouch_money" value="${tabBorrowInfo.vouch_money}"
														readonly="readonly"></input></td>
												</tr>

												<tr>
													<th align="left">商品图片：</th>
													<td align="left">
														<div id="div_show">
															<c:forEach items="${picList}" var="pic">
																<img src="${pic}"
																	style='cursor: pointer; width: 180px; height: 150px;' />
															</c:forEach>
														</div>
													</td>
												</tr>

												<tr>
													<th align="left">综合服务费（元）：</th>
													<td align="left"><input
														class="easyui-validatebox borrow-input" id="colligate"
														name="colligate" value="${tabBorrowInfo.colligate}"></input>
													</td>
												</tr>

											</c:if>

											<tr>
												<th align="left">是否通过初审：</th>
												<td align="left"><input type="radio" id="borrow_status"
													name="borrow_status" value="2" checked="checked" />通过&nbsp;&nbsp;
													<input type="radio" id="borrow_status2"
													name="borrow_status" value="1" />不通过</td>
											</tr>
											<tr>
												<th align="left">是否代付卡：</th>
												<td align="left"><input type="radio" id="is_tocard"
													name="is_tocard" value="0" checked="checked" />代付余额&nbsp;&nbsp;
													<input type="radio" id="is_tocard2"
													name="is_tocard" value="1" />代付卡</td>
											</tr>
											<tr>
												<th align="left">设置发布时间：</th>
												<td align="left"><input id="add_time"
													class="easyui-datetimebox" type="text" name="add_time"
													style="width: 200px;" editable="false"></td>
											</tr>
											<tr>
												<th align="left">初审处理意见：</th>
												<td align="left"><textarea rows="6" cols="100"
														class="J_Comment_Content" id="check_remark"
														name="check_remark" placeholder="请输入审核意见,限制50字...">${tabBorrowInfo.check_remark}</textarea>
												</td>
											</tr>
								<!--如果是分期购则显示------------------------------------->
									<c:if test="${tabBorrowInfo.product_type == 5}">
											<tr>
												<th align="left">订单图片资料下载：</th>
												<td align="left">
												<a  href="javascript:void(0)" class="button button-primary button-rounded button-small" id="downloadOrderPic">下载</a>
												</td>
											</tr>
											<tr>
												<th align="left">打码资料图片上传：</th>
												<td align="left" colspan="4">
											      <div id="uploader">
												        <div class="queueList">
												            <div id="dndArea" class="placeholder">
												                <div id="filePicker"></div>				            				            
												            </div>
												        </div>
												        <div class="statusBar" style="display:none;">
												            <div class="progress">
												                <span class="text">0%</span>
												                <span class="percentage"></span>
												            </div>
												            <div class="info"></div>
												            <div class="btns">
												                <div id="filePicker2"></div>
												                <div class="uploadBtn">开始上传</div>
												            </div>
												        </div>
						 				            </div>
							                     </td>
											</tr>
											<tr>
											    <th align="left">打码资料图片预览</th>
												<td align="left" colspan="4" id="picTd">
													  <c:forEach items="${mosaicList}" var="pic" >
										       	           <div class='div_show'>
															      <div class='div_show_img js-showImg' style='text-align:center'>
															        <img src="${pic}" style='cursor: pointer;width:180px; height:130px;'/>
															        <a class='leftMove' style='font-size: 12px'  href='javascript:void(0)'>左移</a>&nbsp&nbsp
															        <a class='rightMove' style='font-size: 12px'  href='javascript:void(0)'>右移</a>&nbsp&nbsp
															        <a class="deletePic" style="font-size: 12px"  href="javascript:void(0)">删除</a>
															      </div>
															    </div>
										               </c:forEach>
													
												</td>
										    </tr>
										 </c:if>
										</table>
									</td>
								</tr>
							</table>
						</form>
						<div style="margin: 10px 300px; width: 300px;">
							<input id="updateBiddingStatus" class="btn-primary" value="确认"
								type="button"> <a class="btn-primary2"
								href="javascript:window.location.href='${msUrl}/borrowList/list.shtml'">返回</a>
						</div>
					</div>
					<!--  订单详情 -->
					<div class="hide" id="applyInfoDiv">
						
					</div>
					<!--------------------------------------------- 第三方征信资料 ---------->
			
					<div class="hide">
						<div style="margin-top: 30px; padding-top: 30px; text-align: left">
							<c:choose>
								<c:when
									test="${tabBorrowInfo.credit_report_pic != null && tabBorrowInfo.credit_report_pic != '' }">
									<iframe src="${tabBorrowInfo.credit_report_pic}#zoom=120"
										style="width: 1000px; height: 1000px"> </iframe>
								</c:when>
								<c:otherwise>
									<h1 style="font-size: 20px">暂无征信资料</h1>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					
					<!------------------------------------报告评分列表---------------------------------->
					 <div class="hide">
						<%@include file="/view/limitManager/scoringReport.jsp" %>
			        </div>
                    
                    <!--借款信息-->
					<div class="hide">
					 <%@include file="/view/limitManager/user_borrow_info.jsp"%>
					</div>
				
				</div>
			</div>
		</div>
	</div>
	<div class="scroll-top"></div>


	<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
	<script type="text/javascript" src="${msUrl}/js/commons/jquery.tabs.js"></script>
	<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
	<script type="text/javascript" src="${msUrl}/js/ux/limitManager/tabusrinf_common.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/limitManager/scoringReport.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/limitManager/user_borrow_info.js"></script>
	<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/borrowList.js"></script>
	<c:if test="${tabBorrowInfo.product_type == 5}">
	<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/borrow_manager_upload.js"></script>
	</c:if>
	<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
	<script type="text/javascript" src="${msUrl}/js/commons/jquery.lazyload.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$('.demo2').Tabs({
				event : 'click'
			});
			$("img").lazyload({
				effect : "fadeIn"
			});
			//图片查看容器初始化
			$('#div_show').viewer();
			$('#idCardShow').viewer();
			
			//图片绑定左移事件
			$(".div_show .leftMove").click(function(){
				var pre =$(this).parent().parent().prev();  //获取按钮的父元素
		        pre.insertAfter($(this).parent().parent());
			 });
			//图片绑定右移事件
			$(".div_show .rightMove").click(function(){
		        var pre =$(this).parent().parent().next();  //获取按钮的父元素
		   	    $(pre).insertBefore($(this).parent().parent());
			 });
			//图片删除事件
			$(".deletePic").each(function(){
     			 $(this).unbind("click");
     			 $(this).click(function(){
     				$(this).parent().parent().remove();
     			 });
     		  });
			
		});
	</script>
</body>

</html>
