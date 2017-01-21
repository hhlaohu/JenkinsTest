$package('YiYa.modelRule');
YiYa.modelRule = function(){
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
			//获取规则集下拉项
			YiYa.ajaxJson('getRuleSetData.do','',function(data){
				var data1;
				data1 = [];
				$.each(data, function(i,item){
					data1.push({"text":item.rule_set_name, "value":item.rule_set_id});
				});
				$("#view_rule_set_id").combobox("loadData", data1);
			});	
			//设值
			$("#view_scoring_rule_id").val(row.scoring_rule_id);
			$("#view_rule_name").val(row.rule_name);
			$("#view_rule_code").val(row.rule_code);
			$("#view_score_value").val(row.score_value);
			$("#view_rule_set_id").combobox({disabled:true}); 
			$("#view_rule_set_id").combobox('setValue', row.rule_set_id);
			
			//新增评分模型
			$("#btn-addModelValue").click(function(){
				$("#value-win").form('clear');
				$("#value-win").window('open');
				if ($("#dictionary_value_id_TR").is(':visible'))
				{
					$("#dictionary_value_id_TR").hide();
				}
				if ($("#area_TR").is(':visible'))
				{
					$("#area_TR").hide();
				}
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
				
				$("#unite_value").combobox('setValue', 0);
				$("#btn-model-value-submit").linkbutton({disabled:false});
				//修改按钮隐藏
				document.getElementById("btn-model-value-update").style.display ='none';
				document.getElementById("btn-model-value-submit").style.display =''; 
			});
			
			//保存评分模型
			$("#btn-model-value-submit").click(function(){
				saveModelValue();
			});	
			//修改评分模型
			$("#btn-model-value-update").click(function(){
				saveModelValue();
			});
			//关闭
			$("#btn-model-value-cancel").click(function()
			{
				$("#value-win").dialog('close');
			});
			
			
		//设置字段onchange事件
		$("#scoring_field_id").combobox({
			onChange: function (newValue,oldValue) 
		{
			    YiYa.ajaxJson('getFieldsInfo.do', 'scoring_field_id='+newValue,function(data)
				{
			    	//是枚举类型字段，加载并显示字典值下拉框
					if( null != data)
					{
						//不关联
						if (data.is_relational_table == 0)
						{
							$("#dictionary_value_id_TR").show();
							$("#area_TR").hide();
							var data1;
							data1 = [];
							data1.push({"text":"---请选择---", "value":0, "selected":true});
							$.each(data.dictionaryValueList, function(i,item){
								data1.push({"text":item.dictionary_value_name, "value":item.dictionary_value_id});
							});
							$("#dictionary_value_id").combobox("loadData", data1);
						}
						//关联
						else if (data.is_relational_table == 1)
						{
							$("#dictionary_value_id_TR").hide();
							$("#area_TR").show();
							var data1;
							data1 = [];
							data1.push({"text":"---请选择---", "value":0, "selected":true});
							$.each(data.provinceList, function(i,item){
								data1.push({"text":item.area_name, "value":item.area_id});
							});
							$("#province_id").combobox("loadData", data1);
						}
						else
						{
							$("#dictionary_value_id_TR").hide();
							$("#area_TR").hide();
						}	
					}
				});
		}
	});			
		

		//设置省下拉框onchange事件
		$("#province_id").combobox({
			onChange: function (newValue,oldValue) 
		{
				YiYa.ajaxJson('getAreaSelectData.do','area_deep=2&area_parent_id='+newValue,function(data){
					var data1;
					data1 = [];
					data1.push({"text":"---请选择---", "value":0, "selected":true});
					$.each(data, function(i,item){
						data1.push({"text":item.area_name, "value":item.area_id});
					});
					$("#city_id").combobox("loadData", data1);
				});	
				
		}});	
		
		//设置省下拉框onchange事件
		$("#city_id").combobox({
			onChange: function (newValue,oldValue) 
		{
				YiYa.ajaxJson('getAreaSelectData.do','area_deep=3&area_parent_id='+newValue,function(data){
					var data1;
					data1 = [];
					data1.push({"text":"---请选择---", "value":0, "selected":true});
					$.each(data, function(i,item){
						data1.push({"text":item.area_name, "value":item.area_id});
					});
					$("#area_id").combobox("loadData", data1);
				});	
				
		}});
		
			_this.showModelRuleValue(row.scoring_rule_id);
		},
		//新增评分模型Value列表
		showModelRuleValue:function(scoring_rule_id){
			$('#model-rule-value-data-list').datagrid({
				width: 'auto',  
				height:$(window).height()*0.3,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'modelValueList.do',
			    queryParams:{  
                    'search_rule_id' : scoring_rule_id,  
                },
	   			columns:[[
							{field:'score_id',title:'记录id',width:50,sortable:true,hidden:true},
							{field:'unite_value',title:'联合条件',width:80,sortable:true,align:'center',
								formatter:function(value,row,index){
									var html = "";
									if (value == 1)
										html = "并且";
									if (value == 2)
										html = "或者";
									return html;
								}
							},
							{field:'field_name',title:'字段名称',width:250,sortable:true,align:'center'},
							{field:'upper_limit',title:'上限',width:80,sortable:true,align:'center'},
							{field:'lower_limit',title:'下限',width:80,sortable:true,align:'center'},
							{field:'score_value',title:'得分',width:80,sortable:true,align:'center'},
							{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
							{field:'edit',title:'管理操作',width:140,align:'center',sortable:true,
								formatter:function(value,row,index){
								var html = "<a href='#' onclick='editModelValue("+index+")'>修改 | </a>";
									html +=" ";
									html +="<a href='#' onclick='deleteModelValue("+index+")'>删除</a>";
								return html;
							}}
					]],
			});
		},
		initForm:function(){
			$("#btn-model-rule-submit").click(function()
			{	
				saveModelRule();
			});
			
			$("#btn-model-rule-update").click(function()
			{
				saveModelRule();
			});
			
			$("#btn-model-rule-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
			$("#btn-view-model-rule-cancel").click(function()
			{
				$("#view-win").dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'modelRuleList.do',
	   			columns:[[
						{field:'scoring_rule_id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'rule_name',title:'规则名称',width:180,sortable:true,align:'center'},
						{field:'rule_code',title:'规则编码',width:280,sortable:true,align:'center'},
						{field:'rule_set_name',title:'业务规则集',width:300,sortable:true,align:'center'},
						{field:'score_value',title:'得分',width:100,sortable:true,align:'center'},
						{field:'rule_desc',title:'规则描述',width:350,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:330,align:'center',sortable:true,
							formatter:function(value,row,index){
								var html = "";
							if (row.is_active == 1)
							{
								html += "<a href='#' onclick='editModelRule("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteModelRule("+index+")'>删除</a>";
								html +=" | ";
								html +="<a href='#' onclick='deActiveRule("+index+")'>去激活</a>";
								html +=" | ";
								html +="<a href='#' onclick='YiYa.modelRule.setRuleValue("+index+")'>设置评分</a>";
							}
							if (row.is_active == 0)
							{
								html +="<a href='#' onclick='activeRule("+index+")'>激活</a>";
							}	
							
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增评分规则',btnType:'add',handler:function(){
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
								
								YiYa.ajaxJson('getRuleTypeData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.rule_type_name, "value":item.rule_type_id});
									});
									$("#rule_type_id").combobox("loadData", data1);
								});
								
								$("#btn-model-rule-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-model-rule-update").style.display ='none';
								document.getElementById("btn-model-rule-submit").style.display =''; 
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
				url     : "saveModelRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {scoring_rule_id:row.scoring_rule_id,is_active:1},
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
				url     : "saveModelRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {scoring_rule_id:row.scoring_rule_id,is_active:0},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "去激活成功",'info');
				},
			});
		}
	});
}

function deleteModelRule(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除该规则吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteModelRule.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {scoring_rule_id:row.scoring_rule_id},
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
function editModelRule(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	//获取规则集下拉项
	YiYa.ajaxJson('getRuleSetData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_set_name, "value":item.rule_set_id});
		});
		$("#rule_set_id").combobox("loadData", data1);
	});	
	
	YiYa.ajaxJson('getRuleTypeData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.rule_type_name, "value":item.rule_type_id});
		});
		$("#rule_type_id").combobox("loadData", data1);
	});
	$("#btn-model-rule-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-model-rule-update").style.display ='';
	document.getElementById("btn-model-rule-submit").style.display ='none'; 
	//设值
	$("#scoring_rule_id").val(row.scoring_rule_id);
	$("#rule_name").val(row.rule_name);
	$("#rule_code").val(row.rule_code);
	$("#rule_desc").val(row.rule_desc);
	$("#rule_set_id").combobox('setValue', row.rule_set_id);
	$("#rule_type_id").combobox('setValue', row.rule_type_id);
	$("#score_value").val(row.score_value);
}

function saveModelRule()
{
	var scoring_rule_id = $("#scoring_rule_id").val();
	var rule_name = $("#rule_name").val();
	var rule_code = $("#rule_code").val();
	var rule_desc = $("#rule_desc").val();
	var rule_set_id = $("#rule_set_id").combobox('getValue');
	var score_value = $("#score_value").val();
	var rule_type_id = $("#rule_type_id").combobox('getValue');
	
	if(rule_name =='')
	{
		$.messager.alert('提示:','请填写模型规则名称','error'); 
		return false;
	}
	if(rule_code =='')
	{
		$.messager.alert('提示:','请填写模型规则代码','error'); 
		return false;
	}
	if(rule_set_id == 0)
	{
		$.messager.alert('提示:','请选择业务规则集','error'); 
		return false;
	}
	if(score_value == '')
	{
		score_value = 0;
	}else{
		var t = parseFloat(score_value);
	    if(isNaN(t))
	    {
	    	$.messager.alert('提示:','请输入正确的得分','error'); 
			return false;
	    }
	}
	if(rule_type_id == 0)
	{
		$.messager.alert('提示:','请选择规则业务分类','error'); 
		return false;
	}
	var param = 'scoring_rule_id='+ scoring_rule_id + 
				'&rule_name=' + rule_name + 
				'&rule_code=' + rule_code + 
				'&rule_set_id=' + rule_set_id + 
				'&rule_type_id=' + rule_type_id + 
				'&score_value=' + score_value +
				'&rule_desc=' + rule_desc;
	
	if ($("#btn-model-rule-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-model-rule-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveModelRule.do', param,function(addData)
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
				$("#btn-model-rule-submit").linkbutton({disabled:false});
			});
	}

}

function saveModelValue()
{
	var score_id = $("#score_id").val();
	var scoring_rule_id = $("#view_scoring_rule_id").val();
	var scoring_field_id = $("#scoring_field_id").combobox('getValue');
	var upper_limit = $("#upper_limit").val();
	var lower_limit = $("#lower_limit").val();
	var score_value = $("#score_value_").val();
	var unite_value = $("#unite_value").combobox('getValue');
	
	if(scoring_field_id == 0)
	{
		$.messager.alert('提示:','请选择字段','error'); 
		return false;
	}
	if(upper_limit == '')
	{
		$.messager.alert('提示:','请输入最大值','error'); 
		return false;
	}
	if(lower_limit == '')
	{
		lower_limit = 0;
	}
	if(score_value == '')
	{
		score_value = 0;
	}else{
	    var t = parseFloat(score_value);
	    if(isNaN(t))
	    {
	    	$.messager.alert('提示:','请输入正确的得分','error'); 
			return false;
	    }
	}
//	if(unite_value == 0)
//	{
//		$.messager.alert('提示:','请选择联合条件','error'); 
//		return false;
//	}
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
					$("#value-win").window("close");
					$("#model-rule-value-data-list").datagrid("reload");
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

function editModelValue(index){
	$("#value-win").window("open");
	$("#valueForm").resetForm();
	var row = $("#model-rule-value-data-list").datagrid("getRows")[index];
	//获取字段下拉项(规则，字段)
	YiYa.ajaxJson('getAllFieldsData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.field_name, "value":item.scoring_field_id});
		});
		$("#scoring_field_id").combobox("loadData", data1);
	});		
	$("#btn-model-value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-model-value-update").style.display ='';
	document.getElementById("btn-model-value-submit").style.display ='none'; 
	
    YiYa.ajaxJson('getFieldsInfo.do', 'scoring_field_id='+row.scoring_field_id,function(data)
	{
    	//是枚举类型字段，加载并显示字典值下拉框
		if( null != data)
		{
			//不关联
			if (data.is_relational_table == 0)
			{
				$("#dictionary_value_id_TR").show();
				$("#area_TR").hide();
				var data1;
				data1 = [];
				data1.push({"text":"---请选择---", "value":0, "selected":true});
				$.each(data.dictionaryValueList, function(i,item){
					data1.push({"text":item.dictionary_value_name, "value":item.dictionary_value_id});
				});
				$("#dictionary_value_id").combobox("loadData", data1);
			}
			//关联
			else if (data.is_relational_table == 1)
			{
				$("#dictionary_value_id_TR").hide();
				$("#area_TR").show();
				var data1;
				data1 = [];
				data1.push({"text":"---请选择---", "value":0, "selected":true});
				$.each(data.provinceList, function(i,item){
					data1.push({"text":item.area_name, "value":item.area_id});
				});
				$("#province_id").combobox("loadData", data1);
			}
			else
			{
				$("#dictionary_value_id_TR").hide();
				$("#area_TR").hide();
			}	
		}
	});
	
	
	//设值
	$("#score_id").val(row.score_id);
	$("#scoring_field_id").combobox('setValue', row.scoring_field_id);
	$("#upper_limit").val(row.upper_limit);
	$("#lower_limit").val(row.lower_limit);
	$("#score_value_").val(row.score_value);
	$("#unite_value").combobox('setValue', row.unite_value);
}

function deleteModelValue(index)
{
	var row = $("#model-rule-value-data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteModelValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {score_id:row.score_id},
				success : function(da){
					$("#model-rule-value-data-list").datagrid("reload");
					YiYa.alert('提示', "删除成功",'info');
				},
			});
		}
	});
}

//增加字典值，设置最大值
function addDictionaryValue()
{
	var dictionary_value_id = $('#dictionary_value_id').combobox('getValue')
	var upper_limit = $("#upper_limit").val();
	var html = "";
	if ( upper_limit == '')
	{
		html += "|";
	}
	else
	{
		html += upper_limit;
	}
	if ( null == dictionary_value_id || dictionary_value_id == 0)
	{
		return;
	}	
    YiYa.ajaxJson('getKeyValue.do', 'dictionary_value_id='+dictionary_value_id,function(data)
	{
    	if ( null != data)
    	{
        	
        	html += data.result.dictionary_value_key + "|";
    	}
    	//设置最大值
    	$("#upper_limit").val(html);
	});
}

function addAreaKeyValue()
{
	var province_id = $("#province_id").combobox('getValue');
	var city_id = $("#city_id").combobox('getValue');
	var area_id = $("#area_id").combobox('getValue');
	var upper_limit = $("#upper_limit").val();
	var html = "";
	if ( upper_limit == '')
	{
		html += "|";
	}
	else
	{
		html += upper_limit;
	}	
	//选择了区
	if (area_id !=0 )
	{
		html += area_id + "|";
		//设置最大值
		$("#upper_limit").val(html);
	}
	//选择了市,没有区
	if (city_id !=0 )
	{
		if (area_id == 0)
		{
			html += city_id + "|";
		}	
		//设置最大值
		$("#upper_limit").val(html);
	}
	//选择了省,没有市，区
	if (province_id !=0 )
	{
		if (city_id == 0 && area_id== 0)
		{
			html += province_id + "|";
		}
		//设置最大值
		$("#upper_limit").val(html);
	}	

}


$(function(){
	YiYa.modelRule.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		