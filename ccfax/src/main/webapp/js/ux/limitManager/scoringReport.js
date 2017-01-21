function checkScoringReport(index){
	$("#reportDetail").show();
	var row = $("#scoringReportList").datagrid("getRows")[index];
    //赋值
	$("#report_id").val(row.report_id);
    $("#report_title").html("分期客户风控评分报告"+row.create_time);
    //根据表标志是否隐藏
    var flag = $("#scoring_report_auth").val();
    if(!flag){
    	$("#addAffiliateRule").hide();
    }
    //初始化黑名单列表
    $('#blackList').datagrid({
		width: 1300,
		height:360,
        striped: true,
        rownumbers:true,
        pagination: false,
	    url:'../tabBlacklistReportList/getBlackListReportListByReportId.do',
	    queryParams:{  
	    	'report_id':row.report_id
        },
		columns:[[
					{field:'blacklist_type',title:'黑名单类型',align:'center',width:500},
					{field:'blacklist_value',title:'黑名单值',align:'center',width:500},
					{field:'is_hit',title:'是否命中',align:'center',width:260,
						formatter:function(value,row,index){
							if(value == 1){
							   return "命中";	
							}else if(value == 0){
								return "未命中";
							}
							return value;
						}
					}
		]],
		onLoadSuccess: function(data){
        }
	});
    //初始化反欺诈列表
	$('#antiFraudList').datagrid({
		width: 1300,
		height:360,
        striped: true,
        rownumbers:true,
        pagination: true,
	    url:'../tabAntiFraudReportList/getAntiFraudReportListByReportId.do',
	    queryParams:{  
	    	'report_id':row.report_id
        },
		columns:[[
					{field:'anti_fraud_rule_code',title:'规则代码',align:'center',width:190},
					{field:'anti_fraud_rule_name',title:'规则名称',align:'center',width:190},
					{field:'anti_fraud_rule_desc',title:'规则描述',align:'center',width:190},
					{field:'scoring_field_name',title:'字段英文名',align:'center',width:190},
					{field:'scoring_field_name_ch',title:'字段中文名',align:'center',width:190},
					{field:'gather_field_value',title:'采集字段值',align:'center',width:190},
					{field:'is_hit',title:'是否命中',align:'center',width:106}
		]],
		onLoadSuccess: function(data){
        }
	});
	
	//评分字段详细信息展示
	$('#scoringReportDetail').datagrid({
		width: 1300,
		height:360,
        striped: true,
        rownumbers:true,
        pagination: true,
	    url:'../tabScoringReportList/getScoringReportListByReportId.do',
	    queryParams:{  
	    	'report_id':row.report_id
        },
		columns:[[
                    {field:'id',checkbox:false,hidden:true},
                    {field:'rule_set_name',title:'规则集名称',align:'center',width:136},
                    {field:'scoring_rule_code',title:'规则代码',align:'center',width:136},
					{field:'scoring_rule_name',title:'规则名称',align:'center',width:136},
					{field:'scoring_rule_desc',title:'规则描述',align:'center',width:136},
					{field:'scoring_field_name',title:'字段英文名',align:'center',width:136},
					{field:'scoring_field_name_ch',title:'字段中文名',align:'center',width:136},
					{field:'gather_field_value',title:'采集字段值',align:'center',width:126},
					{field:'score',title:'得分',align:'center',width:110},
					{field:'putStockList',title:'管理操作',width:180,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "";
							if(flag){
								html = "<a href='javascript:void(0)' onclick='editScoringReportModelField("+index+")'>修改 </a>";	
							}
							return html;
						}}
		]]
	});
	
	//初始化评分报告附属规则部分
	$('#tabAffiliateRuleList').datagrid({
		width: 1300,
		height:360,
        striped: true,
        rownumbers:true,
        pagination: true,
	    url:'../tabAffiliateRuleReportList/dataList.do',
	    queryParams:{  
	    	'report_id':row.report_id
        },
    	columns:[[
					{field:'id',checkbox:true},
					{field:'report_id',title:'report_id',align:'center',width:250,sortable:true,hidden:true},
					{field:'affiliate_rule_id',title:'affiliate_rule_id',align:'center',width:250,sortable:true,hidden:true},
					{field:'rule_code',title:'规则代码',align:'center',width:250,sortable:true},
					{field:'rule_name',title:'规则名称',align:'center',width:250,sortable:true},
					{field:'rule_desc',title:'规则描述',align:'center',width:250,sortable:true},
					{field:'remark',title:'结果',align:'center',width:250,sortable:true},
					{field:'putStockList',title:'操作',width:210,align:'center',sortable:true,
						formatter:function(value,row,index){
						var html = "";
						if(flag){
							html = "<a href='javascript:void(0)' onclick='editAffiliateRule("+index+")'>修改|</a>";
							html += "<a href='javascript:void(0)' onclick='deleteAffiliateRule("+index+")'>删除 </a>";
						}
						return html;
					}}
			]]
	});
	
	//反显
	$("#comprehensiveScore").html(row.sum_score);
	$("#referingCredit").html(row.scoring_quota);
	$("#umpire").val(row.umpire);
	$("#first_person").val(row.first_person);
	$("#recheck_person").val(row.recheck_person);
	$("#last_person").val(row.last_person);
	var first_trial_verdictEditor = CKEDITOR.instances["first_trial_verdict"];
	var first_trial_verdict = first_trial_verdictEditor.setData(row.first_trial_verdict);
	
	var recheck_verdictEditor = CKEDITOR.instances["recheck_verdict"];
	var recheck_verdict = recheck_verdictEditor.setData(row.recheck_verdict);
	
	var last_trial_verdictEditor = CKEDITOR.instances["last_trial_verdict"];
	var last_trial_verdict = last_trial_verdictEditor.setData(row.last_trial_verdict);
	
	var refund_verdictEditor = CKEDITOR.instances["refund_verdict"];
	var refund_verdict = refund_verdictEditor.setData(row.refund_verdict);
	
	
	//初始化规则名称数据源
	 $('#rule_name').combobox({
		 url:'../tabAffiliateRule/getAllRules.do',
		 valueField:'affiliate_rule_id',
	     textField:'rule_name',
	     width:300
	  });
	
	//评分字段修改页面关闭按钮点击事件
	$("#scoringEditWinClose").click(function(){
		$("#scoring_edit_win").window("close");
	});
	
	//评分字段修改页面保存按钮点击事件
	$("#scoringReportDetailSave").click(function(){
		
		var param = 'id='+ $("#scoringReportDetailId").val() + 
		'&gather_field_value=' + $("#gather_field_value").val();
		
		 YiYa.ajaxJson('../tabScoringReportList/modifyDetail.do', param,function(data)
			{
				if(data.success)
				{
					$("#scoring_edit_win").window("close");
					$("#scoringReportDetail").datagrid("reload");
					YiYa.alert('提示', '保存成功','info');
				}
				else
				{
					YiYa.alert('提示', data.msg,'error');
				}
			});
	});
	
	//绑定附属规则增加按钮事件
	
	$("#addAffiliateRule").click(function(){
		
		//由于页面存在很长的下拉滚动条，弹窗的时候需要重新定位
		var top = $("#tabAffiliateRuleList").offset().top+100;
		var left = $("#tabAffiliateRuleList").offset().left + 300;
		$("#editAffiliateForm").resetForm();
		$('#affiliateEditWin').window('open').window('resize',{top: top,left:left});
		//设置可编辑属性
		 $("#rule_name").combobox('enable');
	});
	
	//附属规则修改页面关闭按钮点击事件
	$("#tabAffiliateRuleReportListEditWinClose").click(function(){
		$("#affiliateEditWin").window("close");
	});
	
	//附属规则修改页面保存按钮点击事件
	$("#tabAffiliateRuleReportListSave").click(function(){
		
		var param = 'id='+ $("#tabAffiliateRuleReportListId").val() + '&affiliate_rule_id=' + $("#rule_name").combobox('getValue')
		+'&report_id='+$("#report_id").val()+'&remark=' + $("#remark").val();
		
		 YiYa.ajaxJson('../tabAffiliateRuleReportList/save.do', param,function(data)
			{
				if(data.success)
				{
					$("#affiliateEditWin").window("close");
					$("#tabAffiliateRuleList").datagrid("reload");
					YiYa.alert('提示', data.msg,'info');
				}
				else
				{
					YiYa.alert('提示', data.msg,'error');
				}
			});
	});
	
	//还款能力总结保存按钮点击事件
	$("#refundVerdictSave").click(function(){
		var refund_verdictEditor = CKEDITOR.instances["refund_verdict"];
		var refund_verdict = refund_verdictEditor.getData();
		var param = 'report_id='+ $("#report_id").val() + '&refund_verdict=' + refund_verdict
		            +'&umpire='+$("#umpire").val();
		YiYa.ajaxJson('../tabScoringReport/update.do', param,function(data)
			{
			  alert(data.msg);
			});
	});
	
	
	//初审结论保存按钮点击事件
	$("#firstConclusionSave").click(function(){
		var first_trial_verdictEditor = CKEDITOR.instances["first_trial_verdict"];
		var first_trial_verdict = first_trial_verdictEditor.getData();
		var param = 'report_id='+ $("#report_id").val() + '&first_trial_verdict=' + first_trial_verdict
		            +'&first_person='+$("#first_person").val();
		YiYa.ajaxJson('../tabScoringReport/update.do', param,function(data)
			{
			  alert(data.msg);
			});
	});
	
	//复审结论保存按钮点击事件
	$("#secondConclusionSave").click(function(){
		var recheck_verdictEditor = CKEDITOR.instances["recheck_verdict"];
		var recheck_verdict = recheck_verdictEditor.getData();
		var param = 'report_id='+ $("#report_id").val() + '&recheck_verdict=' + recheck_verdict
		+'&recheck_person='+$("#recheck_person").val();
		YiYa.ajaxJson('../tabScoringReport/update.do', param,function(data)
			{
			  alert(data.msg);
			});
	});
	
	//终审结论保存按钮点击事件
	$("#finalConclusionSave").click(function(){
		var last_trial_verdictEditor = CKEDITOR.instances["last_trial_verdict"];
		var last_trial_verdict = last_trial_verdictEditor.getData();
		var param = 'report_id='+ $("#report_id").val() + '&last_trial_verdict=' + last_trial_verdict
		+'&last_person='+$("#last_person").val();
		YiYa.ajaxJson('../tabScoringReport/update.do', param,function(data)
			{
			  alert(data.msg);
			});
	});
}

//显示评分报告列表
function queryScoringList(usrid,flag){
	$('#scoringReportList').datagrid({
		width: 1300,
		height:360,
        striped: true,
        rownumbers:true,
        pagination: true,
        singleSelect: true,
	    url:'../tabScoringReport/dataList.do',
	    queryParams:{  
	    	'usrid':usrid
        },
		columns:[[
					{field:'report_id',title:'报告ID',align:'center',hidden:true},
					{field:'usrid',title:'用户id',align:'center',hidden:true},
					{field:'sum_score',title:'总得分',align:'center',width:315,sortable:true},
					{field:'scoring_quota',title:'评分额度',align:'center',width:315,sortable:true},
					{field:'refund_verdict',title:'还款能力结论',align:'center',hidden:true},
					{field:'umpire',title:'评判人',align:'center',hidden:true},
					{field:'first_trial_verdict',title:'初审结论',align:'center',hidden:true,sortable:true},
					{field:'first_person',title:'初审人',align:'center',sortable:true,hidden:true},
					{field:'recheck_verdict',title:'复审结论',align:'center',hidden:true,hidden:true},
					{field:'recheck_person',title:'复审人',align:'center',hidden:true,hidden:true},
					{field:'last_trial_verdict',title:'终审结论',align:'center',hidden:true,sortable:true},
					{field:'last_person',title:'终审人',align:'center',sortable:true,hidden:true},
					{field:'create_time',title:'创建时间',align:'center',width:315,sortable:true},
					{field:'putStockList',title:'操作',align:'center:',width:315,formatter:function(value,row,index){
						//TODO
						 var html = "<a href='#' style='color:blue' onclick='checkScoringReport("+index+")'>查看信用报告</a>";
						 html = html + " | <a href='../userManager/printReport.do?report_id="+row.report_id+"' target='_blank' style='color:blue'>打印预览</a>";
                         return html;							
					}}
		]],
		onLoadSuccess: function(data){
			if(data.total==0){
				return;
			}
        }
	});
}


/**
 * 评分报告详细部分编辑页面赋值
 * @param index
 */
function editScoringReportModelField(index){
	
	//由于页面存在很长的下拉滚动条，弹窗的时候需要重新定位
	var top = $("#scoringReportDetail").offset().top+100;
	var left = $("#scoringReportDetail").offset().left + 300;
	$('#scoring_edit_win').window('open').window('resize',{top: top,left:left});;
	$("#editForm").resetForm();
	var row = $("#scoringReportDetail").datagrid("getRows")[index];
	//设值
	$("#scoringReportDetailId").val(row.id);
	$("#scoring_field_name").val(row.scoring_field_name);
	$("#gather_field_value").val(row.gather_field_value);
}

/**
 * 修改按钮 附属规则
 * @param index
 */
function editAffiliateRule(index){
  
  //由于页面存在很长的下拉滚动条，弹窗的时候需要重新定位
  var top = $("#tabAffiliateRuleList").offset().top+100;
  var left = $("#tabAffiliateRuleList").offset().left + 300;
  $('#affiliateEditWin').window('open').window('resize',{top: top,left:left});
  $("#editAffiliateForm").resetForm();
  var row = $("#tabAffiliateRuleList").datagrid("getRows")[index];
  //设值
  $("#tabAffiliateRuleReportListId").val(row.id);
  $("#rule_name").combobox('setValue',row.affiliate_rule_id);
  $("#remark").val(row.remark);
  //设置可编辑属性
  $('#rule_name').combobox('disable');
}


/**
 * 删除按钮 附属规则
 * @param index
 */
function deleteAffiliateRule(index){
	
	var row = $("#tabAffiliateRuleList").datagrid("getRows")[index];
	var param = 'id='+ row.id;
	
	 YiYa.ajaxJson('../tabAffiliateRuleReportList/delete.do', param,function(data)
		{
			if(data.success)
			{
				$("#affiliateEditWin").window("close");
				$("#tabAffiliateRuleList").datagrid("reload");
				alert("删除成功");
			}
			else
			{
				YiYa.alert('提示', data.msg,'error');
			}
		});
	
}