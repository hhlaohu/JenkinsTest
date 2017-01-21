$package('YiYa.antiFraudModelRule');
YiYa.antiFraudModelRule = function(){
	var _box = null;
	var _this = {
		listForm:$("#listForm"),
		editForm:function(){
			return $("#editForm");
		},
		editWin:function(){
			return $("#edit-win");
		},
		
		//设置评分，弹出窗口
		setRuleValue:function(index){
			$("#view-win").window("open");
			$("#viewForm").resetForm();
			var row = $("#data-list").datagrid("getRows")[index];
			//设值
			$("#view_anti_fraud_rule_id").val(row.anti_fraud_rule_id);
			$("#view_rule_name").val(row.rule_name);
			$("#view_rule_code").val(row.rule_code);
			
			//新增评分模型
			$("#btn-addModelValue").click(function(){
				$("#value-win").form('clear');
				$("#value-win").window('open');		
				
				//获取字段下拉项
				YiYa.ajaxJson('getAllFieldsData.do','',function(data){
					var data1;
					data1 = [];
					data1.push({"text":"---请选择---", "value":0, "selected":true});
					$.each(data, function(i,item){
						data1.push({"text":item.field_name, "value":item.scoring_field_id});
					});
					$("#scoring_field_id").combobox("loadData", data1);
				});	
				//默认值
				$("#hit_condition").combobox('setValue', 0);
				$("#unite_value").combobox('setValue', 0);
				
				$("#btn-anti-fraud-value-submit").linkbutton({disabled:false});
				//修改按钮隐藏
				document.getElementById("btn-anti-fraud-value-update").style.display ='none';
				document.getElementById("btn-anti-fraud-value-submit").style.display =''; 
			});
			
			//保存
			$("#btn-anti-fraud-value-submit").click(function()
			{	
				saveAntiFraudValue();
			});
				
			//修改
			$("#btn-anti-fraud-value-update").click(function()
			{
				saveAntiFraudValue();
			});
			
			//关闭
			$("#btn-anti-fraud-value-cancel").click(function()
			{
				$("#value-win").dialog('close');
			});

			//列表展示
			_this.showModelRuleValue(row.anti_fraud_rule_id);
		},
		
		//新增评分模型Value列表
		showModelRuleValue:function(anti_fraud_rule_id){
			$('#anti-fraud-value-data-list').datagrid({
				width: 'auto',  
				height:$(window).height()*0.3,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'antiFraudValueList.do',
			    queryParams:{  
                    'search_rule_id' : anti_fraud_rule_id,  
                },
	   			columns:[[
							{field:'anti_fraud_id',title:'记录id',width:50,sortable:true,hidden:true},
							{field:'unite_value',title:'联合条件',width:150,sortable:true,align:'center',
								formatter:function(value,row,index){
									var html = "";
									if (value == 1)
										html = "并且";
									if (value == 2)
										html = "或者";
									return html;
								}
							},
							{field:'field_name',title:'字段名称',width:152,sortable:true,align:'center'},
							{field:'hit_condition',title:'命中条件',width:150,sortable:true,align:'center',
								formatter:function(value,row,index){
									var html = "";
									if (value == 1)
										html = "大于";
									if (value == 2)
										html = "大于等于";
									if (value == 3)
										html = "等于";
									if (value == 4)
										html = "小于";
									if (value == 5)
										html = "小于等于";
									if (value == 6)
										html = "不等于";
									return html;
								}	
							},
							{field:'hit_value',title:'命中value',width:150,sortable:true,align:'center'},
							{field:'add_time',title:'添加时间',width:180,sortable:true,align:'center'},
							{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
								formatter:function(value,row,index){
								var html = "<a href='#' onclick='editAntiFraudValue("+index+")'>修改 | </a>";
									html +=" ";
									html +="<a href='#' onclick='deleteAntiFraudValue("+index+")'>删除</a>";
								return html;
							}}
					]],
			});
		},
		initForm:function(){
			$("#btn-anti-fraud-rule-submit").click(function()
			{	
				saveAntiFraudRule();
			});
			
			$("#btn-anti-fraud-rule-update").click(function()
			{
				saveAntiFraudRule();
			});
			
			$("#btn-anti-fraud-rule-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
			$("#btn-view-anti-fraud-rule-cancel").click(function()
			{
				$("#view-win").dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'antiFraudRuleList.do',
	   			columns:[[
						{field:'anti_fraud_rule_id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'rule_name',title:'规则名称',width:200,sortable:true,align:'center'},
						{field:'rule_code',title:'规则编码',width:300,sortable:true,align:'center'},
						{field:'rule_set_name',title:'业务规则集',width:300,sortable:true,align:'center'},
						{field:'rule_desc',title:'规则描述',width:350,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:300,align:'center',sortable:true,
							formatter:function(value,row,index){
								var html ="";
							if (row.is_active == 1)
							{
								html += "<a href='#' onclick='editAntiFraudRule("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteAntiFraudRule("+index+")'>删除</a>";
								html +=" | ";
								html +="<a href='#' onclick='deActiveRule("+index+")'>去激活</a>";
								html +=" | ";
								html +="<a href='#' onclick='YiYa.antiFraudModelRule.setRuleValue("+index+")'>设置评分</a>";
							}
							if (row.is_active == 0)
							{
								html +="<a href='#' onclick='activeRule("+index+")'>激活</a>";
							}	
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增规则',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								//获取字段下拉项
								YiYa.ajaxJson('getRuleSetData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.rule_set_name, "value":item.rule_set_id});
									});
									$("#rule_set_id").combobox("loadData", data1);
								});	
								
								$("#btn-anti-fraud-rule-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-anti-fraud-rule-update").style.display ='none';
								document.getElementById("btn-anti-fraud-rule-submit").style.display =''; 
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


/**
 * 激活（0未激活，1已激活）
 * @param index
 */
function activeRule(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要激活该规则吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "saveAntiFraudRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {anti_fraud_rule_id:row.anti_fraud_rule_id,is_active:1},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "激活成功",'info');
				},
			});
		}
	});
}

/**
 * 去激活（0未激活，1已激活）
 */
function deActiveRule(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定去激活该规则吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "saveAntiFraudRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {anti_fraud_rule_id:row.anti_fraud_rule_id,is_active:0},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "去激活成功",'info');
				},
			});
		}
	});
}

function deleteAntiFraudRule(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除该规则吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteAntiFraudRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {anti_fraud_rule_id:row.anti_fraud_rule_id},
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
function editAntiFraudRule(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	//获取字段下拉项
	YiYa.ajaxJson('getRuleSetData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_set_name, "value":item.rule_set_id});
		});
		$("#rule_set_id").combobox("loadData", data1);
	});	
	
	$("#btn-anti-fraud-rule-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-anti-fraud-rule-update").style.display ='';
	document.getElementById("btn-anti-fraud-rule-submit").style.display ='none'; 
	//设值
	$("#anti_fraud_rule_id").val(row.anti_fraud_rule_id);
	$("#rule_name").val(row.rule_name);
	$("#rule_code").val(row.rule_code);
	$("#rule_set_id").combobox('setValue', row.rule_set_id);
	$("#rule_desc").val(row.rule_desc);
}

function saveAntiFraudRule()
{
	var anti_fraud_rule_id = $("#anti_fraud_rule_id").val();
	var rule_name = $("#rule_name").val();
	var rule_code = $("#rule_code").val();
	var rule_desc = $("#rule_desc").val();
	var rule_set_id = $("#rule_set_id").combobox('getValue');
	
	if(rule_name =='')
	{
		$.messager.alert('提示:','请填写反欺诈规则名称','error'); 
		return false;
	}
	if(rule_code =='')
	{
		$.messager.alert('提示:','请填写反欺诈规则代码','error'); 
		return false;
	}
	if(rule_set_id == 0)
	{
		$.messager.alert('提示:','请选择业务规则集','error'); 
		return false;
	}
	var param = 'anti_fraud_rule_id='+ anti_fraud_rule_id + 
				'&rule_name=' + rule_name + 
				'&rule_code=' + rule_code + 
				'&rule_set_id=' + rule_set_id + 
				'&rule_desc=' + rule_desc;
	
	if ($("#btn-anti-fraud-rule-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-anti-fraud-rule-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveAntiFraudRule.do', param,function(addData)
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
				$("#btn-anti-fraud-rule-submit").linkbutton({disabled:false});
			});
	}

}


function deleteAntiFraudValue(index)
{
	var row = $("#anti-fraud-value-data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteAntiFraudValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {anti_fraud_id:row.anti_fraud_id},
				success : function(da){
					$("#anti-fraud-value-data-list").datagrid("reload");
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
function editAntiFraudValue(index){
	$("#value-win").window("open");
	$("#valueForm").resetForm();
	var row = $("#anti-fraud-value-data-list").datagrid("getRows")[index];
	//获取字段下拉项(规则，字段)
	YiYa.ajaxJson('getAllFieldsData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.field_name, "value":item.scoring_field_id});
		});
		$("#scoring_field_id").combobox("loadData", data1);
	});		
	
	$("#btn-anti-fraud-value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-anti-fraud-value-update").style.display ='';
	document.getElementById("btn-anti-fraud-value-submit").style.display ='none'; 
	//设值
	$("#anti_fraud_id").val(row.anti_fraud_id);
	$("#scoring_field_id").combobox('setValue', row.scoring_field_id);
	$("#hit_condition").combobox('setValue', row.hit_condition);
	$("#hit_value").val(row.hit_value);
	$("#unite_value").combobox('setValue', row.unite_value);
}

function saveAntiFraudValue()
{
	var anti_fraud_id = $("#anti_fraud_id").val();
	var anti_fraud_rule_id = $("#view_anti_fraud_rule_id").val();
	var scoring_field_id = $("#scoring_field_id").combobox('getValue');
	var hit_value = $("#hit_value").val();
	var hit_condition = $("#hit_condition").combobox('getValue');
	var unite_value = $("#unite_value").combobox('getValue');
	if(scoring_field_id == 0)
	{
		$.messager.alert('提示:','请选择字段','error'); 
		return false;
	}
	if(hit_condition == 0)
	{
		$.messager.alert('提示:','请选择命中条件','error'); 
		return false;
	}
	if(hit_value == '')
	{
		$.messager.alert('提示:','请输入命中value','error'); 
		return false;
	}

//	if(unite_value == 0)
//	{
//		$.messager.alert('提示:','请选择联合条件','error'); 
//		return false;
//	}
	var param = 'anti_fraud_id='+ anti_fraud_id + 
				'&anti_fraud_rule_id=' + anti_fraud_rule_id +
				'&scoring_field_id=' + scoring_field_id +
				'&hit_condition=' + hit_condition +
				'&hit_value=' + hit_value +
				'&unite_value=' + unite_value;
	
	if ($("#btn-anti-fraud-value-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-anti-fraud-value-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveAntiFraudValue.do', param,function(addData)
			{
				if(addData.success)
				{
					$("#value-win").window("close");
					$("#anti-fraud-value-data-list").datagrid("reload");
					YiYa.alert('提示', '保存成功','info');
				}
				else
				{
					YiYa.alert('提示', addData.msg,'error');
				}
				$("#btn-anti-fraud-value-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.antiFraudModelRule.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		