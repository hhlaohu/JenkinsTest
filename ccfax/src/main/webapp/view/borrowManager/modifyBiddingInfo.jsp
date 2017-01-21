<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/viewer.min.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/webuploader.css" />
   <script type="text/javascript" src="${msUrl}/ckeditor/ckeditor.js"></script>
   <script type="text/javascript" src="${msUrl}/js/commons/viewer-jquery.min.js"></script>
   <style type="text/css">
      .datagrid-toolbar{display:none;}
   </style>
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
     
     <div id="startBiding-win" style="padding: 20px;">
         
         <div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>&nbsp;<span class="crumb-name">标的审核</span><span
						class="crumb-step">&gt;</span><span class="crumb-name">修改标的信息</span>
					<a class="btn-back"
						href="javascript:window.location.href='${msUrl}/borrowList/list.shtml'">返回</a>
				</div>
			</div>
			
         <div style="width: 100%; padding: 10px; font-size: 14px; overflow: hidden;">
            <form id="startBiddingForm" class="ui-form">
              
              <input class="hidden" type="text" id="bidding_id" name="bidding_id" value="${tabBorrowInfo.bidding_id}">
              <input class="hidden" type="text" id="usrid" name="usrid" value="${tabBorrowInfo.borrow_uid}">
              
               <table>
                 <tr>
                    <td>
                      <table class="tbBaseInfo2" width="100%" >
                        <tr>
							<th align="left">借款总金额<span style="color:Red">*</span>：</th>
							<td align="left">
								<input id="borrow_money" class="easyui-numberbox" data-options="precision:2" value="${tabBorrowInfo.borrow_money}" 
								style="height:30px"/>
							</td>
							<th align="left">年利率<span style="color:Red">*</span>：</th>
							<td align="left">
								<input id="borrow_interest_rate" class="easyui-numberbox" data-options="precision:2" value="${tabBorrowInfo.borrow_interest_rate}" 
								  style="height:30px;width:100px"/>&nbsp %
								<span style="color:Red;font-size:12px">(利率范围：0.05%-24%)</span>
							</td>
						</tr>
						
						 <tr>
							<th align="left">借款用途<span style="color:Red">*</span>：</th>
							<td align="left">
							   <select style="height:30px;width:157px;" id="borrow_use" name="borrow_use" disabled="disabled">
				                	<c:if test="${tabBorrowInfo.borrow_use==1}"><option value="1">短期周转</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==2}"><option value="2">生意周转</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==3}"><option value="3">生活周转</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==4}"><option value="4">购物消费</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==5}"><option value="5">不提现借款</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==6}"><option value="6">创业借款</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==7}"><option value="7">其它借款</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==8}"><option value="8">装修借款</option></c:if>
				                	<c:if test="${tabBorrowInfo.borrow_use==9}"><option value="9">信用千金</option></c:if>
					            </select>
							   
							</td>
							<th align="left">借款期限<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="borrow_duration"  style="height:30px;width:157px;">
								   <option value="">--请选择--</option>
								   
								   <c:if test="${tabBorrowInfo.repayment_type!=1}">
								     <c:forEach var="x" begin="1" end="12">
									  <option value="${x}" <c:if test="${x==tabBorrowInfo.borrow_duration}">selected="selected"</c:if> >${x}个月</option> 
								   </c:forEach>
								   </c:if>
								   
								   <c:if test="${tabBorrowInfo.repayment_type==1}">
								      <c:forEach var="x" begin="1" end="180">
									  <option value="${x}" <c:if test="${x==tabBorrowInfo.borrow_duration}">selected="selected"</c:if> >${x}天</option> 
								   </c:forEach>
								   </c:if>
								   
								</select>
								 <input id="byTheDay" type="checkbox" disabled="disabled" style="width:15px;height:15px;margin-left:10px;" <c:if test="${tabBorrowInfo.repayment_type==1}">checked="checked"</c:if> /> 按天
							</td>
						</tr>
						
						 <tr>
							<th align="left">最低投标金额<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="borrow_min" style="height:30px;width:157px;" disabled="disabled"> 
								    <c:if test="${tabBorrowInfo.borrow_min==50}"><option value="50">50</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==100}"><option value="100">100</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==200}"><option value="200">200</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==300}"><option value="300">300</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==500}"><option value="500">500</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==1000}"><option value="1000">1000</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==2000}"><option value="2000">2000</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==3000}"><option value="3000">3000</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==4000}"><option value="4000">4000</option></c:if>
							        <c:if test="${tabBorrowInfo.borrow_min==5000}"><option value="5000">5000</option></c:if>
								</select>
							</td>
							<th align="left">最多投标金额：</th>
							<td align="left">
								<select id="borrow_max" style="height:30px;width:157px;" disabled="disabled">
								    <c:if test="${tabBorrowInfo.borrow_max==1500}"><option value="1500">1500</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==2000}"><option value="2000">2000</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==3000}"><option value="3000">3000</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==4000}"><option value="4000">4000</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==5000}"><option value="5000">5000</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==6000}"><option value="6000">6000</option></c:if>
								    <c:if test="${tabBorrowInfo.borrow_max==10000}"><option value="10000">10000</option></c:if>
								</select>
							</td>
						 </tr>
						
						 <tr>
							<th align="left">有效时间<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="collect_day" style="height:30px;width:157px;">
								    <option value="">--请选择--</option>
								    <c:forEach var="x" begin="1" end="30">
									  <option value="${x}" <c:if test="${x==tabBorrowInfo.collect_day}">selected="selected"</c:if> >${x}天</option> 
								    </c:forEach>
								</select>
							</td>
							<th align="left">还款方式<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="repayment_type" style="height:30px;width:157px;" disabled="disabled">
								    <c:if test="${tabBorrowInfo.repayment_type==1}"><option value="1">按天计息，一次性还本付息</option></c:if>
				                	<c:if test="${tabBorrowInfo.repayment_type==2}"><option value="2">等额本息</option></c:if>
				                	<c:if test="${tabBorrowInfo.repayment_type==3}"><option value="3">按季分期还款</option></c:if>
				                	<c:if test="${tabBorrowInfo.repayment_type==4}"><option value="4">每月还息到期还本</option></c:if>
				                	<c:if test="${tabBorrowInfo.repayment_type==5}"><option value="5">一次性还款</option></c:if>
				                	<c:if test="${tabBorrowInfo.repayment_type==7}"><option value="7">等额本金</option></c:if>
								</select>
							</td>
						</tr>
						 <tr>
							<th align="left">产品类型<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="product_type" style="height:30px;width:157px;" disabled="disabled" class="easyui-combobox" 
								    data-options="
								     valueField: 'dictionary_value_key',
	                                 textField: 'dictionary_value_name',
								     url:'${msUrl}/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type',
								     value:${tabBorrowInfo.product_type}
								 "
								>
								
								</select>
							</td>
							<th align="left">担保公司：</th>
							<td align="left">
								<select id="danbao" style="height:30px;width:157px;" disabled="disabled">
								    <option value="">无担保机构</option>
									<c:forEach var="list" items="${companyList}">
				          		      <option value="${list.uid}">${list.company_name}</option>
				          	        </c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<th align="left">平台综合服务费<span style="color:Red">*</span>：</th>
							<td align="left" >
								<input id="colligate"  class="easyui-numberbox" data-options="precision:2"  value="${tabBorrowInfo.colligate}"
								style="height:30px"/>
							</td>
							
							<th align="left">加息率：</th>
							<td align="left">
								<input id="jiaxi_rate"  class="easyui-numberbox" data-options="precision:2"  value="${tabBorrowInfo.jiaxi_rate}"
								style="height:30px"/>
							</td>
						</tr>
						
						 <tr>
						
							<th align="left">担保公司服务费：</th>
							<td align="left" colspan="4">
								<input id="vouch_money" class="easyui-numberbox" data-options="precision:2"   
								value="${tabBorrowInfo.vouch_money}"
								style="height:30px" readonly="readonly"/>
							</td>
						</tr>
						
						 <tr>
							<th align="left">标题<span style="color:Red">*</span>：</th>
							<td align="left" colspan="4">
								<input id="borrow_name" style="height:30px;width:150px"  value="${tabBorrowInfo.borrow_name}"/>
							</td>
						</tr>
						
						<tr>
							<th align="left">是否是测试标<span style="color:Red">*</span>：</th>
							<td align="left" colspan="4">
								<input id="test" type="checkbox" style="height:30px;width:40px;float:left"
								<c:if test="${1==tabBorrowInfo.test}"> checked="checked" </c:if> />
							</td>
						</tr>
						
						 <tr>
							<th align="left">货物入仓单</th>
							<td align="left" colspan="4">
							   <textarea id="warehousing" name="warehousing">${tabBorrowInfo.warehousing}</textarea>
							   <script type="text/javascript">CKEDITOR.replace("warehousing")</script>
							</td>
						</tr>
						
						<tr>
							<th align="left">项目阐述<span style="color:Red">*</span></th>
							<td align="left" colspan="4">
							   <textarea name="borrow_info" id="borrow_info">${tabBorrowInfo.borrow_info}</textarea>
							   <script type="text/javascript">CKEDITOR.replace("borrow_info")</script>
							</td>
						</tr>
						
                        <tr>
						    <th align="left">添加商品图片</th>
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
                              <th align="left">商品图片：</th>
	                          <td align="left" colspan="4" id="picTd">
								  <c:forEach items="${picList}" var="pic" >
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
						
                      </table>
                    </td>                 
                 </tr>
               </table>
            </form>
         </div>
         
         <div style="margin:10px 300px;width:300px;">
			 	<input id="modifyBiddingInfo" class="btn-primary" value="确定" type="button" >
			</div>
     </div>
	 
</div>


<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/modifyBiddingInfo.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.lazyload.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.tabs.js"></script>
<script type="text/javascript">
$(function(){
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
