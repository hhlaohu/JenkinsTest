$package('YiYa.scoringModelValue');
YiYa.scoringModelValue = function(){
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
			$("#btn-model-value-submit").click(function()
			{	
				saveModelValue();
			});
			
			$("#btn-model-value-update").click(function()
			{
				saveModelValue();
			});
			
			$("#btn-model-value-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'modelValueList.do',
	   			columns:[[
						{field:'score_id',title:'记录id',width:50,sortable:true,hidden:true},
						{field:'rule_name',title:'规则名称',width:350,sortable:true,align:'center'},
						{field:'field_name',title:'字段名称',width:150,sortable:true,align:'center'},
						{field:'upper_limit',title:'上限',width:150,sortable:true,align:'center'},
						{field:'lower_limit',title:'下限',width:150,sortable:true,align:'center'},
						{field:'score_value',title:'得分',width:150,sortable:true,align:'center'},
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
							var html = "<a href='#' onclick='editModelValue("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteModelValue("+index+")'>删除</a>";
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
								YiYa.ajaxJson('getRulesData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.rule_name, "value":item.scoring_rule_id});
									});
									$("#scoring_rule_id").combobox("loadData", data1);
								});	
								$("#unite_value").combobox('setValue', 0);
								$("#btn-model-value-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-model-value-update").style.display ='none';
								document.getElementById("btn-model-value-submit").style.display =''; 
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



function deleteModelValue(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteModelValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {score_id:row.score_id},
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
function editModelValue(index){
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
	YiYa.ajaxJson('getRulesData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_name, "value":item.scoring_rule_id});
		});
		$("#scoring_rule_id").combobox("loadData", data1);
	});	
	
	$("#btn-model-value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-model-value-update").style.display ='';
	document.getElementById("btn-model-value-submit").style.display ='none'; 
	//设值
	$("#score_id").val(row.score_id);
	$("#scoring_rule_id").combobox('setValue', row.scoring_rule_id);
	$("#scoring_field_id").combobox('setValue', row.scoring_field_id);
	$("#upper_limit").val(row.upper_limit);
	$("#lower_limit").val(row.lower_limit);
	$("#score_value").val(row.score_value);
	$("#unite_value").combobox('setValue', row.unite_value);
}

function saveModelValue()
{
	var score_id = $("#score_id").val();
	var scoring_rule_id = $("#scoring_rule_id").combobox('getValue');
	var scoring_field_id = $("#scoring_field_id").combobox('getValue');
	var upper_limit = $("#upper_limit").val();
	var lower_limit = $("#lower_limit").val();
	var score_value = $("#score_value").val();
	var unite_value = $("#unite_value").combobox('getValue');
	
	if(scoring_rule_id == 0)
	{
		$.messager.alert('提示:','请选择规则','error'); 
		return false;
	}
	if(scoring_field_id == 0)
	{
		$.messager.alert('提示:','请选择字段','error'); 
		return false;
	}
	if(upper_limit == '')
	{
		$.messager.alert('提示:','请输入上限','error'); 
		return false;
	}
	if(lower_limit == '')
	{
		$.messager.alert('提示:','请输入下限','error'); 
		return false;
	}
	if(score_value == '')
	{
		$.messager.alert('提示:','请输入得分','error'); 
		return false;
	}
	if(unite_value == 0)
	{
		$.messager.alert('提示:','请选择联合条件','error'); 
		return false;
	}
	var param = 'score_id='+ score_id + 
				'&scoring_rule_id=' + scoring_rule_id +
				'&scoring_field_id=' + scoring_field_id +
				'&upper_limit=' + upper_limit +
				'&lower_limit=' + lower_limit +
				'&score_value=' + score_value +
				'&unite_value=' + unite_value;
	
	if ($("#btn-model-value-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-model-value-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveModelValue.do', param,function(addData)
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
				$("#btn-model-value-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.scoringModelValue.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		