<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${msUrl}/ckeditor/ckeditor.js"></script>

</head>

<body>
   <div id="scoringReport" style="margin-top: 30px;">
      <!--报告ID-->
      <input class="hidden" id="report_id">
	   <form id="scoringReportForm" method="post"style="margin-top: 10px">
			<table id="scoringReportList"></table>
	    </form>
		<div style="display:none;margin-top: 20px" id="reportDetail">
		   <p style="font-size: 30;font-weight: bold;text-align:center;width:1115px" id="report_title"></p>
           <!-------------------------反欺诈----------------------------->
          <div class="ftitle">反欺诈部分:</div>
             <span style="font-size: 14;font-weight: bold;text-align: left">1.公司黑名单（命中）</span>
             <form id="blackListForm" method="post"
			style="margin-top: 10px">
			<table id="blackList"></table>
		  </form>
           <!-------------------------反欺诈部分------------------------------>
           <div style="margin-top: 20px">
              <span style="font-size: 14;font-weight: bold;text-align: left;">2.反欺诈规则（命中）</span>
           </div>
             <form id="antiFraudForm" method="post"
			style="margin-top: 10px">
			<table id="antiFraudList"></table>
		  </form>
		  <!-------------------------信用评分具体项部分------------------------------>
           <div style="margin-top: 20px">
              <span style="font-size: 14;font-weight: bold;text-align: left;">3.信用评分</span>
           </div>
           <form id="scoringReportDetailForm" method="post"
			style="margin-top: 10px">
			<table id="scoringReportDetail"></table>
		  </form>
		    <!-------------------------手工查询部分附属规则------------------------------>
           <div style="margin-top: 20px">
              <span style="font-size: 14;font-weight: bold;text-align: left;">4.附属规则部分</span>
           </div>
           <div style="padding-top: 5px">
              <a  href="javascript:void(0)" 
              class="button button-primary button-rounded button-small" id="addAffiliateRule">新增</a>           
           </div>
                  
           <form id="tabAffiliateRulListForm" method="post"
			style="margin-top: 10px">
			<table id="tabAffiliateRuleList"></table>
		  </form>
		  
		  
		  <!--综合评分-->
		  <div style="margin-top: 10px;display: block;">
		     <span style="font-size: 14;font-weight: bold;text-align: left;">综合评分：</span>
		     <span style="font-size: 14;font-weight: bold;color: red;" id="comprehensiveScore"></span>  
		  </div> 
		  <div style="margin-top: 10px;display: block;">
		     <span style="font-size: 14;font-weight: bold;text-align: left;">参考额度：</span>
		     <span style="font-size: 14;font-weight: bold; color: red" id="referingCredit"></span>  
		  </div> 
		  
		  <!--还款能力总结-->
		  <div style="margin-top: 20px">
		     <span style="font-size: 14;font-weight: bold;text-align: left;">5.还款能力总结</span>
		     <div style="padding-top: 10px">
		       <p>
                <span style="font-size: 12;font-weight: bold;text-align: left;padding-left: 20px">评判人：</span>
                <input name="umpire" id="umpire" style="font-size: 12;font-weight: bold;text-align: left;color: red">
               </p>
		     </div>
		     <div style="padding-top: 5px">
              <div  style="padding-left:20px;width: 1280px">
                <textarea id="refund_verdict" name="refund_verdict" ></textarea>
				<script type="text/javascript">
					CKEDITOR.replace("refund_verdict")
				</script>
              </div>
             </div>
           <div style="padding-top: 5px;padding-left: 20px">
              <a  href="javascript:void(0)" 
              class="button button-primary button-rounded button-small" id="refundVerdictSave">保存</a>           
           </div>
		  
		  </div>
		  
		  
		  
		   <!-------------------------结论------------------------------>
		 <div style="margin-top: 20px">
              <span style="font-size: 14;font-weight: bold;text-align: left;">6.结论</span>
          <!--初审结论-->
          <div style="padding-top: 10px">
              <p>
                <span style="font-size: 12;font-weight: bold;text-align: left;padding-left: 20px">初审人：</span>
                <input name="first_person" id="first_person" style="font-size: 12;font-weight: bold;text-align: left;color: red">
              </p>
            <div style="padding-top: 5px">
              <div  style="padding-left:20px;width: 1280px">
                <textarea id="first_trial_verdict" name="first_trial_verdict" ></textarea>
				<script type="text/javascript">
					CKEDITOR.replace("first_trial_verdict")
				</script>
              </div>
             </div>
           <div style="padding-top: 5px;padding-left: 20px">
              <a  href="javascript:void(0)" 
              class="button button-primary button-rounded button-small" id="firstConclusionSave">保存</a>           
           </div>
        </div>
        
        <!--复审结论-->
          <div style="padding-top: 10px">
              <p>
                <span style="font-size: 12;font-weight: bold;text-align: left;padding-left: 20px">复审人：</span>
                <input name="recheck_person" id="recheck_person" style="font-size: 12;font-weight: bold;text-align: left;color: red">
              </p>
            <div style="padding-top: 5px">
              <div  style="padding-left:20px;width: 1280px">
                <textarea id="recheck_verdict" name="recheck_verdict" ></textarea>
				<script type="text/javascript">
					CKEDITOR.replace("recheck_verdict")
				</script>
              </div>
             </div>
            <div style="padding-top: 5px;padding-left: 20px">
              <a  href="javascript:void(0)" 
              class="button button-primary button-rounded button-small" id="secondConclusionSave">保存</a>           
           </div>
        </div>
        
         <!--终审结论-->
          <div style="padding-top: 10px">
              <p>
                <span style="font-size: 12;font-weight: bold;text-align: left;padding-left: 20px">终审人：</span>
                <input name="last_person" id="last_person" style="font-size: 12;font-weight: bold;text-align: left;color: red">
              </p>
            <div style="padding-top: 5px;">
              <div  style="padding-left:20px;width: 1280px">
                <textarea id="last_trial_verdict" name="last_trial_verdict" ></textarea>
				<script type="text/javascript">
					CKEDITOR.replace("last_trial_verdict")
				</script>
              </div>
             </div>
            <div style="padding-top: 5px;padding-left: 20px">
              <a  href="javascript:void(0)" 
              class="button button-primary button-rounded button-small" id="finalConclusionSave">保存</a>           
           </div>
        </div>
        
       </div>
	</div>
		
	<!---------------信用评分报告具体项部分修改页面-------------------------->
		<div style="display:none">
		     <div id="scoring_edit_win" class="easyui-dialog" title="修改评分字段值"  data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:250px;">  
		     	<form id="editForm" class="ui-form" method="post">  
		     		 <input class="hidden" id="scoringReportDetailId">
		     		 <div class="ui-edit">
		  	     	   <table width="100%" class="tbBaseInfo">
		           	    <tr style="height:30px;">
		     				<th align="right"style="width:100px">字段英文名：</th>
		     				<td align="left">
		     					<input class="easyui-validatebox" type="text" name="scoring_field_name" 
		     					id="scoring_field_name" maxlength="64" style="width:300px;" disabled="disabled">
		     				</td>
		     			</tr>
		     			<tr style="height:30px;">
		     				<th align="right"style="width:100px">字段采集值：</th>
		     				<td align="left">
		     					<input class="easyui-validatebox" type="text" name="gather_field_value" id="gather_field_value"
		     					 maxlength="64" style="width:300px">
		     				</td>
		     			</tr>
		     			</table>
			         </div>
		         <div style="text-align: center; padding-top: 20px" >
		            <a href="#" id="scoringReportDetailSave" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			        <a href="#" id="scoringEditWinClose" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		         </div>
		     	</form>
		  	 </div> 
		</div>
		
		<!---------------附属规则部分修改页面-------------------------->
		<div style="display:none">
		     <div id="affiliateEditWin" class="easyui-dialog" title="编辑附属规则"  data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:250px;">  
		     	<form id="editAffiliateForm" class="ui-form" method="post">  
		     		 <input class="hidden" id="tabAffiliateRuleReportListId">
		     		 <div class="ui-edit">
		  	     	   <table width="100%" class="tbBaseInfo">
		           	    <tr style="height:30px;">
		     				<th align="right"style="width:100px">规则名称：</th>
		     				<td align="left">
		     				<select class="easyui-combobox"
									name="rule_name" id="rule_name">
								</select>
		     				</td>
		     			</tr>
		     			<tr style="height:30px;">
		     				<th align="right"style="width:100px">结果：</th>
		     				<td align="left">
		     					<input class="easyui-validatebox" type="text" name="remark" id="remark"
		     					 maxlength="64" style="width:300px">
		     				</td>
		     			</tr>
		     			</table>
			         </div>
		         <div style="text-align: center; padding-top: 20px" >
		            <a href="#" id="tabAffiliateRuleReportListSave" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
			        <a href="#" id="tabAffiliateRuleReportListEditWinClose" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
		         </div>
		     	</form>
		  	 </div> 
		</div>
	
	</div>
</body>
</html>