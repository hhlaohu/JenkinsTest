$package('YiYa.antiFraudModelValue');
YiYa.antiFraudModelValue = function(){
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
			$("#btn-anti-fraud-value-submit").click(function()
			{	
				saveAntiFraudValue();
			});
			
			$("#btn-anti-fraud-value-update").click(function()
			{
				saveAntiFraudValue();
			});
			
			$("#btn-anti-fraud-value-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'antiFraudValueList.do',
	   			columns:[[
						{field:'anti_fraud_id',title:'记录id',width:50,sortable:true,hidden:true},
						{field:'rule_name',title:'规则名称',width:350,sortable:true,align:'center'},
						{field:'field_name',title:'字段名称',width:150,sortable:true,align:'center'},
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
						{field:'add_time',title:'添加时间',width:180,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='editAntiFraudValue("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteAntiFraudValue("+index+")'>删除</a>";
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增模型Value',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								//获取字段下拉项(规则，字段)
								YiYa.ajaxJson('getFieldsData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.field_name, "value":item.scoring_field_id});
									});
									$("#scoring_field_id").combobox("loadData", data1);
								});		
								YiYa.ajaxJson('getAntiFraudRulesData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.rule_name, "value":item.anti_fraud_rule_id});
									});
									$("#anti_fraud_rule_id").combobox("loadData", data1);
								});	
								//默认值
								$("#hit_condition").combobox('setValue', 0);
								$("#unite_value").combobox('setValue', 0);
								$("#btn-anti-fraud-value-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-anti-fraud-value-update").style.display ='none';
								document.getElementById("btn-anti-fraud-value-submit").style.display =''; 
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



function deleteAntiFraudValue(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteAntiFraudValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {anti_fraud_id:row.anti_fraud_id},
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
function editAntiFraudValue(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	//获取字段下拉项(规则，字段)
	YiYa.ajaxJson('getFieldsData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.field_name, "value":item.scoring_field_id});
		});
		$("#scoring_field_id").combobox("loadData", data1);
	});		
	YiYa.ajaxJson('getAntiFraudRulesData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_name, "value":item.anti_fraud_rule_id});
		});
		$("#anti_fraud_rule_id").combobox("loadData", data1);
	});	
	
	$("#btn-anti-fraud-value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-anti-fraud-value-update").style.display ='';
	document.getElementById("btn-anti-fraud-value-submit").style.display ='none'; 
	//设值
	$("#anti_fraud_id").val(row.anti_fraud_id);
	$("#anti_fraud_rule_id").combobox('setValue', row.anti_fraud_rule_id);
	$("#scoring_field_id").combobox('setValue', row.scoring_field_id);
	$("#hit_condition").combobox('setValue', row.hit_condition);
	$("#hit_value").val(row.hit_value);
	$("#unite_value").combobox('setValue', row.unite_value);
}

function saveAntiFraudValue()
{
	var anti_fraud_id = $("#anti_fraud_id").val();
	var anti_fraud_rule_id = $("#anti_fraud_rule_id").combobox('getValue');
	var scoring_field_id = $("#scoring_field_id").combobox('getValue');
	var hit_value = $("#hit_value").val();
	var hit_condition = $("#hit_condition").combobox('getValue');
	var unite_value = $("#unite_value").combobox('getValue');
	if(anti_fraud_rule_id == 0)
	{
		$.messager.alert('提示:','请选择规则','error'); 
		return false;
	}
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

	if(unite_value == 0)
	{
		$.messager.alert('提示:','请选择联合条件','error'); 
		return false;
	}
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
					$("#edit-win").window("close");
					$("#data-list").datagrid("reload");
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
	YiYa.antiFraudModelValue.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		