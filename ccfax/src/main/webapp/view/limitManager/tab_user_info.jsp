<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form id="checkApplyForm" class="ui-form" method="post">
		<input type="hidden" name="scoring_report_auth" id="scoring_report_auth">
		<div id="query_checkApply-win">

			<div class="ftitle">个人信息:</div>
			<table>
				<tr>
					<td>
						<table class="tbBaseInfo2" width="100%">

							<tr>
								<th align="left">姓名：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="borrower_usrname"
										name="borrower_usrname" data-options="width:150"></p>
								</td>
								<th align="left">性别：</th>
								<td align="left"><select class="easyui-combobox" name="sex"
									id="sex" data-options="required:true,width:200">
								</select></td>
							</tr>

							<tr>
								<th align="left">年龄：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="age" name="age"
										data-options="width:150"></p>
								</td>
								<th align="left">手机号码：</th>
								<td align="left">
									<p class="easyui-validatebox member-input" id="borrower_mobile_phone"
										name="borrower_mobile_phone" data-options="width:150"></p>
								</td>
							</tr>

							<tr>
								<th align="left">身份证号：</th>
								<td align="left">
									<p id="borrower_id_card" class="easyui-validatebox member-input"
										type="text" name="borrower_id_card" data-options="width:150"
										style="color: #0081c2; font-weight: bolder"></p>
								</td>
								<th align="left">婚姻状态：</th>
								<td align="left"><select class="easyui-combobox"
									name="marital" id="marital"
									data-options="required:true,width:200">
								</select></td>
							</tr>
							<tr>
								<th align="left">籍贯：</th>
								<td align="left" colspan="4">省：<select
									class="easyui-combobox" name="province" id="province"
									data-options="required:true,width:200">
								</select>&nbsp&nbsp 市：<select class="easyui-combobox" name="city"
									id="city" data-options="required:true,width:200">
								</select>&nbsp&nbsp 县： <select class="easyui-combobox" name="county"
									id="county" data-options="required:true,width:200">
								</select>
								</td>
							</tr>
							<tr>
								<th align="left">是否本地户籍：</th>
								<td align="left"><select class="easyui-combobox"
									name="local_register_place" id="local_register_place"
									data-options="required:true,width:200">
								</select></td>
								<th align="left">学历：</th>
								<td align="left"><select class="easyui-combobox"
									name="diploma" id="diploma"
									data-options="required:true,width:200">
								</select></td>
							</tr>

							<tr>
								<th align="left">银行卡号：</th>
								<td align="left"><input class="easyui-validatebox" style="width:200px"
									type="text" name="bank_id" id="bank_id" disabled="disabled" />
								</td>
								<th align="left">个人年收入：</th>
								<td align="left"><select class="easyui-combobox"
									name="income" id="income"
									data-options="required:true,width:200">
								</select></td>
							</tr>


							<tr>
								<th align="left">住房状态：</th>
								<td align="left"><select class="easyui-combobox"
									name="house_type" id="house_type"
									data-options="required:true,width:200">
								</select></td>
								<th align="left">固定资产：</th>
								<td align="left"><select class="easyui-combobox"
									name="fixed_assets" id="fixed_assets"
									data-options="required:true,width:200">
								</select></td>
							</tr>

							<tr>
								<th align="left">就业状态：</th>
								<td align="left"><select class="easyui-combobox"
									name="employment" id="employment"
									data-options="required:true,width:200">
								</select></td>
								<th align="left">单位名称：</th>
								<td align="left"><input class="easyui-validatebox" style="width:200px"
									type="text" name="com_name" id="com_name" disabled="disabled" />
								</td>
							</tr>

							<tr>
								<th align="left">所处行业：</th>
								<td align="left"><select class="easyui-combobox"
									name="industry" id="industry"
									data-options="required:true,width:200">
								</select></td>
								<th align="left">职位：</th>
								<td align="left"><select class="easyui-combobox"
									name="profession_level" id="profession_level"
									data-options="required:true,width:200">
								</select></td>
							</tr>

							<tr>
								<th align="left">现单位工作时间：</th>
								<td align="left"><select class="easyui-combobox"
									name="cur_hire_duration" id="cur_hire_duration"
									data-options="required:true,width:200">
								</select></td>
								<th align="left">学制：</th>
								<td align="left"><select class="easyui-combobox"
									name="schooling_system" id="schooling_system"
									data-options="required:true,width:200">
								</select></td>
							</tr>

							<tr>
								<th align="left">毕业学校：</th>
								<td align="left"><input class="easyui-validatebox" style="width:200px"
									type="text" name="graduate_school" id="graduate_school"
									disabled="disabled" /></td>
								<th align="left">还款来源：</th>
								<td align="left"><input class="easyui-validatebox" style="width:200px"
									type="text" name="repaying_source" id="repaying_source"
									disabled="disabled" /></td>
							</tr>
							
							<tr>
								<th align="left">旅游合同编号：</th>
								<td align="left"><input class="easyui-validatebox" style="width:200px"
									type="text" name="contract_number" id="contract_number"
									disabled="disabled" /></td>
							</tr>
							<tr>
								<th align="left">身份证照片：</th>
								<td align="left" colspan="4">
								<div id="idCardShow">
								 <img id="id_card_front" style='cursor: pointer; width: 180px; height: 150px;' />
								 <img id="id_card_reverse_pic" style='cursor: pointer; width: 180px; height: 150px;' />
								 <img id="id_card_with" style='cursor: pointer; width: 180px; height: 150px;' />
								</div>
								</td>
							</tr>

						</table>
					</td>
				</tr>
			</table>
		  <div class="tabBondsmaninfInfo">
			<div class="ftitle">其它信息:</div>
			<span>直系亲属联系人电话:</span>
			<table>
				<tr>
					<td>
						<table id="tabBondsmaninf_tab" class="tbBaseInfo2" width="100%">
						</table>
					</td>
				</tr>
			</table>
          </div>
		</div>
		<div id="div_btnSave" style="margin: 0px 0px 0px 469px; display: none;">
			<input id="btnSave" type="button" value="保 存" class="btn_userManager">
		</div>
	</form>

	<div id="faceDiv" class="faceDiv">
		<div class="ftitle">人体动态验证信息</div>
		<div
			style="width: 100%; margin: 10px auto; padding: 10px; font-size: 14px;">
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>姓名：</b></label> <span id="check_alive_name"></span>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>身份证号：</b></label> <span id="check_alive_id_card"></span>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>动态验证随机抽取照片:</b></label>
				<div class="js-showImg">
					<img id="check_alive_pic"
						style="cursor: pointer; width: 180px; height: 115px; padding: 10px;" />
				</div>
			</div>
			<hr
				style="height: 1px; border: none; border-top: 1px dashed #0066CC;" />
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>活体验证结果：</b></label> <span id="xiaoshi_check_alive_result"></span>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>人像对比结果：</b></label> <span
					id="xiaoshi_id_card_check_result"></span>
				<p style="padding: 5px">1: 身份证号与姓名匹配，且比对成功</p>
				<p style="padding: 5px">2: 身份证核查成功，但人脸比对失败</p>
				<p style="padding: 5px">3: 身份证号与姓名不匹配</p>
				<p style="padding: 5px">4: 身份证号不存在</p>
				<p style="padding: 5px">-1: 异常情况</p>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>状态描述信息：</b></label> <span id="xiaoshi_id_card_check_msg"></span>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>小视科技会话号：</b></label> <span id="xiaoshi_id_card_check_guid"></span>
			</div>
			<div
				style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
				<label><b>比对分值：</b></label> <span id="xiaoshi_id_card_check_score"></span>
			</div>
		</div>
	</div>
	<!--生成评分报告按钮-->
	<div id="createScoringReport" style="display: none;">
	<div class="ftitle">生成评分报告:</div>
			<input id="btnCreateScoringReport" type="button" value="生成评分报告" class="btn_userManager">
		</div>
	 <!--点击生成评分报告按钮弹窗，选择规则集  -->
    <div style="display:none">
	     <div id="selectRulesSet-win" 
	     class="easyui-dialog"  title="选择规则集 "  style="width:800px;height:400px;"  data-options="closed:true,iconCls:'icon-select',modal:false">
		     <form id="rulesListForm" method="post" style="width:100%;height:100%">
		         <table width="100%" height = "100%" id="rulesListTable">
   				 	
				</table>
		     </form>
	     </div> 
	 </div>	
		
 </body>
</html>