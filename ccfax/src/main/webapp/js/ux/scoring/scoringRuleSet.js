$package('YiYa.scoringRuleSet');
YiYa.scoringRuleSet = function(){
	var _box = null;
	var _this = {
		listForm:$("#listForm"),
		editForm:function(){
			return $("#editForm");
		},
		editWin:function(){
			return $("#edit-win");
		},
		initForm:function(){
			$("#btn-rule-set-submit").click(function()
			{	
				saveRuleSet();
			});
			
			$("#btn-rule-set-update").click(function()
			{
				saveRuleSet();
			});
			
			$("#btn-rule-set-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
			$("#btn-view-model-rule-cancel").click(function()
			{
				$("#view-win").dialog('close');

			});
		},
		//设置评分，弹出窗口
		setRuleQuota:function(index){
			$("#view-win").window("open");
			$("#viewForm").resetForm();
			var row = $("#data-list").datagrid("getRows")[index];
			//设值
			$("#view_rule_set_name").val(row.rule_set_name);
			$("#view_rule_set_id").val(row.rule_set_id);
			
			//新增评分模型
			$("#btn-addQuotaValue").click(function(){
				$("#value-win").form('clear');
				$("#value-win").window('open');
				
				$("#btn-quota-value-submit").linkbutton({disabled:false});
				//修改按钮隐藏
				document.getElementById("btn-quota-value-update").style.display ='none';
				document.getElementById("btn-quota-value-submit").style.display =''; 
			});
			
			//保存评分模型
			$("#btn-quota-value-submit").click(function(){
				saveQuotaValue();
			});	
			//修改评分模型
			$("#btn-quota-value-update").click(function(){
				saveQuotaValue();
			});
			//关闭
			$("#btn-quota-value-cancel").click(function()
			{
				$("#value-win").dialog('close');
			});
			_this.showRuleQuotaValue(row.rule_set_id);
		},
		//新增评分模型Value列表
		showRuleQuotaValue:function(rule_set_id){
			$('#model-quota-value-data-list').datagrid({
				width: 'auto',  
				height:$(window).height()*0.3,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'quotaValueList.do',
			    queryParams:{  
                    'rule_set_id' : rule_set_id,  
                },
	   			columns:[[
							{field:'quota_id',title:'额度id',width:50,sortable:true,hidden:true},
							{field:'rule_set_id',title:'规则集id',width:50,sortable:true,hidden:true},
							{field:'max_score',title:'得分上限',width:80,sortable:true,align:'center'},
							{field:'min_score',title:'得分下限',width:80,sortable:true,align:'center'},
							{field:'max_quota',title:'额度上限',width:80,sortable:true,align:'center'},
							{field:'min_quota',title:'额度下限',width:80,sortable:true,align:'center'},
							{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
							{field:'edit',title:'管理操作',width:140,align:'center',sortable:true,
								formatter:function(value,row,index){
								var html = "<a href='#' onclick='editQuotaValue("+index+")'>修改 | </a>";
									html +=" ";
									html +="<a href='#' onclick='deleteQuotaValue("+index+")'>删除</a>";
								return html;
							}}
					]],
			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'ruleSetList.do',
	   			columns:[[
						{field:'rule_set_id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'rule_set_type_name',title:'规则集业务分类',width:250,sortable:true,align:'center'},
						{field:'rule_set_name',title:'规则集名称',width:350,sortable:true,align:'center'},
						{field:'upper_amount',title:'金额下限',width:150,sortable:true,align:'center'},
						{field:'lower_amount',title:'金额上限',width:150,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:180,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:250,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='editRuleSet("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteRuleSet("+index+")'>删除</a>";
								html +=" | ";
								html +="<a href='#' onclick='YiYa.scoringRuleSet.setRuleQuota("+index+")'>设置得分对应的额度</a>";
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增规则集',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								YiYa.ajaxJson('getRuleSetType.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.rule_set_type_name, "value":item.rule_set_type_id});
									});
									$("#rule_set_type_id").combobox("loadData", data1);
								});
								
								$("#btn-rule-set-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-rule-set-update").style.display ='none';
								document.getElementById("btn-rule-set-submit").style.display =''; 
							}}
						]
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();



function deleteRuleSet(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除该规则集吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteRuleSet.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {rule_set_id:row.rule_set_id},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "删除成功",'info');
				},
			});
		}
	});
}


/**
 * 编辑赋值
 * @param index
 */
function editRuleSet(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	
	YiYa.ajaxJson('getRuleSetType.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_set_type_name, "value":item.rule_set_type_id});
		});
		$("#rule_set_type_id").combobox("loadData", data1);
	});
	
	$("#btn-rule-set-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-rule-set-update").style.display ='';
	document.getElementById("btn-rule-set-submit").style.display ='none'; 
	//设值
	$("#rule_set_id").val(row.rule_set_id);
	$("#rule_set_name").val(row.rule_set_name);
	$("#rule_set_type_id").combobox('setValue', row.rule_set_type_id);
	$("#upper_amount").val(row.upper_amount);
	$("#lower_amount").val(row.lower_amount);
}

function saveRuleSet()
{
	var rule_set_id = $("#rule_set_id").val();
	var rule_set_name = $("#rule_set_name").val();
	var rule_set_type_id = $("#rule_set_type_id").combobox('getValue');
	var upper_amount = $("#upper_amount").val();
	var lower_amount = $("#lower_amount").val();
	

	if(rule_set_type_id == 0)
	{
		$.messager.alert('提示:','请选择规则集业务分类','error'); 
		return false;
	}
	if(rule_set_name =='')
	{
		$.messager.alert('提示:','请填写规则集名称','error'); 
		return false;
	}
	if(upper_amount =='')
	{
		$.messager.alert('提示:','请填写金额下限','error'); 
		return false;
	}
	if(lower_amount =='')
	{
		$.messager.alert('提示:','请填写金额上限','error'); 
		return false;
	}
	if (! /^\d+(\.\d{1,2})?$/.test(upper_amount))
	{
		$.messager.alert('提示:','只能输入数字，小数点后只能保留两位','error'); 
		return false;
	}	
	if (! /^\d+(\.\d{1,2})?$/.test(lower_amount))
	{
		$.messager.alert('提示:','只能输入数字，小数点后只能保留两位','error'); 
		return false;
	}	
	if (lower_amount <= upper_amount)
	{
		$.messager.alert('提示:','金额上限不能比下限小','error'); 
		return false;
	}	
	
	var param = 'rule_set_id='+ rule_set_id + 
				'&rule_set_name=' + rule_set_name +
				'&rule_set_type_id=' + rule_set_type_id +
				'&upper_amount=' + upper_amount +
				'&lower_amount=' + lower_amount ;
	
	if ($("#btn-rule-set-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-rule-set-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveRuleSet.do', param,function(addData)
			{
				if(addData.success)
				{
					$("#edit-win").window("close");
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', '保存成功','info');
				}
				else
				{
					YiYa.alert('提示', addData.msg,'error');
				}
				$("#btn-rule-set-submit").linkbutton({disabled:false});
			});
	}

}

function editQuotaValue(index){
	$("#value-win").window("open");
	$("#valueForm").resetForm();
	var row = $("#model-quota-value-data-list").datagrid("getRows")[index];
	$("#btn-quota-value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-quota-value-update").style.display ='';
	document.getElementById("btn-quota-value-submit").style.display ='none'; 
	//设值
	$("#quota_id").val(row.quota_id);
	$("#min_score").val(row.min_score);
	$("#max_score").val(row.max_score);
	$("#min_quota").val(row.min_quota);
	$("#max_quota").val(row.max_quota);
}

function deleteQuotaValue(index)
{
	var row = $("#model-quota-value-data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteQuotaValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {quota_id:row.quota_id},
				success : function(da){
					$("#model-quota-value-data-list").datagrid("reload");
					YiYa.alert('提示', "删除成功",'info');
				},
			});
		}
	});
}

function saveQuotaValue()
{
	var quota_id = $("#quota_id").val();
	var rule_set_id = $("#view_rule_set_id").val();
	var min_quota = $("#min_quota").val();
	var max_quota = $("#max_quota").val();
	var min_score = $("#min_score").val();
	var max_score = $("#max_score").val();
	if(quota_id == ''){
		quota_id = 0;
	}
	
	if(min_quota == '')
	{
		min_quota = 0;
	}else{
	    var t = parseFloat(min_quota);
	    if(isNaN(t))
	    {
	    	$.messager.alert('提示:','请输入正确的额度最小值','error'); 
			return false;
	    }
	}
	if(max_quota == '')
	{
		max_quota = 0;
	}else{
		var t = parseFloat(max_quota);
		if(isNaN(t))
		{
			$.messager.alert('提示:','请输入正确的额度最大值','error'); 
			return false;
		}
	}
	if(max_score == '')
	{
		max_score = 0;
	}else{
		var t = parseFloat(max_score);
		if(isNaN(t))
		{
			$.messager.alert('提示:','请输入正确的得分最大值','error'); 
			return false;
		}
	}
	if(min_score == '')
	{
		min_score = 0;
	}else{
		var t = parseFloat(min_score);
		if(isNaN(t))
		{
			$.messager.alert('提示:','请输入正确的得分最小值','error'); 
			return false;
		}
	}
	var param = 'quota_id='+ quota_id + 
				'&rule_set_id=' + rule_set_id +
				'&min_score=' + min_score +
				'&max_score=' + max_score +
				'&max_quota=' + max_quota +
				'&min_quota=' + min_quota;
	
	if ($("#btn-quota-value-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-quota-value-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveQuotaValue.do', param,function(addData)
			{
				if(addData.success)
				{
					$("#value-win").window("close");
					$("#model-quota-value-data-list").datagrid("reload");
					YiYa.alert('提示', '保存成功','info');
				}
				else
				{
					YiYa.alert('提示', addData.msg,'error');
				}
				$("#btn-quota-value-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.scoringRuleSet.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		