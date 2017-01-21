<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/webuploader.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/viewer.min.css" />
   <script type="text/javascript" src="${msUrl}/js/commons/viewer-jquery.min.js"></script>
   <script type="text/javascript" src="${msUrl}/ckeditor/ckeditor.js"></script>
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
            <label class="ui-label">真实姓名:&nbsp;&nbsp;&nbsp; </label>
            <input name="real_name" class="easyui-box ui-text" style="width:150px;color:rgb(85, 84, 84);">
        </p>
         <p class="ui-fields">
            <label class="ui-label">手机号码 </label>
            <input name="user_phone" class="easyui-box ui-text" 
              style="width:150px;color:rgb(85, 84, 84);">
        </p>
        <p class="ui-fields">
    	    <label>是否VIP</label>  
            <select name="is_vip" data-options="required:true,width:150">
           	   <option value="0">所有人</option>
           	   <option value="1">借款人</option>
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
     
     <div id="startBiding-win" style="padding: 20px; display: none">
         
         <div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>&nbsp;<span class="crumb-name">发标管理</span><span
						class="crumb-step">&gt;</span><span class="crumb-name">发布借款</span>
					<a class="btn-back"
						href="javascript:window.location.href='${msUrl}/borrowList/startBiddingList.shtml'">返回</a>
				</div>
			</div>
			
         <div style="width: 100%; padding: 10px; font-size: 14px; overflow: hidden;">
            <form id="startBiddingForm" class="ui-form">
              
              <input class="hidden" type="text" id="usrid" name="usrid">
            
               <table>
                 <tr>
                    <td>
                      <table class="tbBaseInfo2" width="100%" >
                                       
                        <tr>
							<th align="left">借款总金额<span style="color:Red">*</span>：</th>
							<td align="left">
								<input id="borrow_money" class="easyui-numberbox" data-options="precision:2" 
								style="height:30px"/>
							</td>
							<th align="left">年利率<span style="color:Red">*</span>：</th>
							<td align="left">
								<input id="borrow_interest_rate" class="easyui-numberbox" data-options="precision:2" 
								  style="height:30px;width:100px"/>&nbsp %
								<span style="color:Red;font-size:12px">(利率范围：0.05%-24%)</span>
							</td>
						</tr>
						
						 <tr>
							<th align="left">借款用途<span style="color:Red">*</span>：</th>
							<td align="left">
							   <select id="borrow_use" style="height:30px;width:157px;">
							     	<option value="">--请选择--</option>
							     	<option value="1">短期周转</option>
					              	<option value="2">生意周转</option>
					              	<option value="3">生活周转</option>
					              	<option value="4">购物消费</option>
					              	<option value="5">不提现借款</option>
					              	<option value="6">创业借款</option>
					              	<option value="7">其它借款</option>
					              	<option value="8">装修借款</option>
					              	<option value="9">信用千金</option>
							   </select>
							</td>
							<th align="left">借款期限<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="borrow_duration"  style="height:30px;width:157px;">
								   <option value="">--请选择--</option>
							     	<option value="1">1个月</option>
					              	<option value="2">2个月</option>
					              	<option value="3">3个月</option>
					              	<option value="4">4个月</option>
					              	<option value="5">5个月</option>
					              	<option value="6">6个月</option>
					              	<option value="7">7个月</option>
					              	<option value="8">8个月</option>
					              	<option value="9">9个月</option>
					              	<option value="10">10个月</option>
					              	<option value="11">11个月</option>
					              	<option value="12">12个月</option>
								</select>
								 <input id="byTheDay" type="checkbox" style="width:15px;height:15px;margin-left:10px;" /> 按天
							</td>
						</tr>
						
						 <tr>
							<th align="left">最低投标金额<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="borrow_min" style="height:30px;width:157px;">
								    <option value="">--请选择--</option>
							     	<option value="50">50</option>
					              	<option value="100">100</option>
					              	<option value="200">200</option>
					              	<option value="300">300</option>
					              	<option value="500">500</option>
					              	<option value="1000">1000</option>
					              	<option value="2000">2000</option>
					              	<option value="3000">3000</option>
					              	<option value="4000">4000</option>
					              	<option value="5000">5000</option>
					              	<option value="10000">10000</option>
								</select>
							</td>
							<th align="left">最多投标金额：</th>
							<td align="left">
								<select id="borrow_max" style="height:30px;width:157px;">
								    <option value="">--没有限制--</option>
							     	<option value="1500">1500</option>
					              	<option value="2000">2000</option>
					              	<option value="3000">3000</option>
					              	<option value="4000">4000</option>
					              	<option value="5000">5000</option>
					              	<option value="6000">6000</option>
					              	<option value="10000">10000</option>
								</select>
							</td>
						 </tr>
						
						 <tr>
							<th align="left">有效时间<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="collect_day" style="height:30px;width:157px;">
								</select>
							</td>
							<th align="left">还款方式<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="repayment_type" style="height:30px;width:157px;">
								    <option value="">--请选择--</option>
							     	<option value="1">按天计息，一次性还本付息</option>
					              	<option value="2">等额本息</option>
					              	<option value="3">按季分期还款</option>
<!-- 					              	<option value="4">每月还息到期还本</option> -->
<!-- 					              	<option value="5">一次性还款</option> -->
<!-- 					              	<option value="6">利息复投</option> -->
					              	<option value="7">等额本金</option>
								</select>
							</td>
						</tr>
						 <tr>
							<th align="left">产品类型<span style="color:Red">*</span>：</th>
							<td align="left">
								<select id="product_type" style="height:30px;width:157px;" class="easyui-combobox" 
								   data-options="
								     valueField: 'dictionary_value_key',
	                                 textField: 'dictionary_value_name',
								     url:'${msUrl}/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type'
								 ">
								   
								</select>
							</td>
							<th align="left">担保公司：</th>
							<td align="left">
								<select id="danbao" style="height:30px;width:157px;">
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
								<input id="colligate"  class="easyui-numberbox" data-options="precision:2" 
								style="height:30px"/>
							</td>
							
							<th align="left">加息率：</th>
							<td align="left" >
								<input id="jiaxi_rate"  class="easyui-numberbox" data-options="precision:2" 
								style="height:30px"/>
							</td>
						</tr>
						
						 <tr>
							<th align="left">担保公司服务费：</th>
							<td align="left">
								<input id="vouch_money" class="easyui-numberbox" data-options="precision:2" 
								style="height:30px"/>
							</td>
							
							<th align="left">投标密码：</th>
							<td align="left">
								<input id="bidding_pwd" style="height:30px;width:150px"/>
							</td>
						</tr>
						
						 <tr>
							<th align="left">标题<span style="color:Red">*</span>：</th>
							<td align="left" colspan="4">
								<input id="borrow_name" style="height:30px;width:150px"/>
							</td>
						</tr>
						
						<tr>
							<th align="left">是否是测试标<span style="color:Red">*</span>：</th>
							<td align="left" colspan="4">
								<input id="test" type="checkbox" style="height:30px;width:40px;float:left"/>
							</td>
						</tr>
						
						 <tr>
							<th align="left">货物入仓单</th>
							<td align="left" colspan="4">
							   <textarea id="warehousing" name="warehousing"></textarea>
							   <script type="text/javascript">CKEDITOR.replace("warehousing")</script>
							</td>
						</tr>
						
						<tr>
							<th align="left">项目阐述<span style="color:Red">*</span></th>
							<td align="left" colspan="4">
							   <textarea name="borrow_info" id="borrow_info"></textarea>
							   <script type="text/javascript">CKEDITOR.replace("borrow_info")</script>
							</td>
						</tr>
						
						<tr>
						    <th align="left">商品图片</th>
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
						    <th align="left">图片预览</th>
							<td align="left" colspan="4" id="picTd">
						     
							</td>
						</tr>
						
                      </table>
                    </td>                 
                 </tr>
               </table>
            </form>
         </div>
         
         <div style="margin:10px 300px;width:300px;">
			 	<input id="startBiddingBtn" class="btn-primary" value="确定" type="button" >
			</div>
     </div>
	 
</div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/borrowManager/startBiddingList.js"></script>
 </body>
</html>
