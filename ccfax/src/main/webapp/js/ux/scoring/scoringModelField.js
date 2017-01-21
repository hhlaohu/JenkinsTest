$package('YiYa.scoringField');
YiYa.scoringField = function(){
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
			//返回列表
			$("#btn-back").click(function()
			{	
				location.href = 'modelTypePage.shtml';
			});
			$("#btn-model_field-submit").click(function()
			{	
				saveModelField();
			});
			
			$("#btn-model_field-update").click(function()
			{
				saveModelField();
			});
			
			$("#btn-model_field-cancel").click(function()
			{
				_this.editWin().dialog('close');
			});
			//租户类型选中事件
			$(":radio").click(function(){
				    //组合
				    if ($(this).val() == 1)
				    {
				    	$("#field_id_1").show();
				    	$("#field_id_2").show();
				    	$("#operate").show();
				    }
				    else
				    {
				    	$("#field_id_1").hide();
				    	$("#field_id_2").hide();
				    	$("#operate").hide();
				    }	
			});
			
			//设置onchange事件
			$("#field_value_type").combobox({
				onChange: function (newValue,oldValue) 
			{
					//枚举类型
		            if (newValue == 3)
		            {
		            	$("#dictionary_type_TR").show();//数据字典类型
		            }
		            else
		            {
		            	$("#dictionary_type_TR").hide();
		            	$("#dictionary_type_id").combobox('setValue', 0);
		            }
			}
		});			
			
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'modelFieldList.do',
	   			columns:[[
						{field:'scoring_field_id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'field_type_name',title:'字段类型',width:180,sortable:true,align:'center'},
						{field:'field_name',title:'字段名',width:180,sortable:true,align:'center'},
						{field:'field_name_ch',title:'字段中文名',width:200,sortable:true,align:'center'},
						{field:'field_value_type',title:'字段值类型',width:150,align:'center',sortable:true,
							formatter:function(value,row,index){
								var html = "";
								if (value == 0)
								{
									html = "字符串";
								}	
								else if (value == 1)
								{
									html = "整型";
								}
								else if (value == 2)
								{
									html = "浮点型（2位小数）";
								}	
								else if (value == 3)
								{
									html = "枚举";
								}	
								else
								{
									html = "其他";
								}	
								return html;
						}},
						{field:'is_combined',title:'组合类型',width:120,sortable:true,align:'center',
							formatter:function(value,row,index){
								var html = "";
								if (value == 0)
								{
									html = "非组合";
								}	
								if (value == 1)
								{
									html = "组合";
								}
	
								return html;	
						}},
						{field:'field_desc',title:'字段描述',width:350,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='editModelField("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteModelField("+index+")'>删除</a>";
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增字段',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								//设置分类选中值，不可编辑
								$("#field_value_type").combobox('setValue',9);
								$("#combined_operate").combobox('setValue',0);
								$(":radio").attr("checked", false);
						    	$("#field_id_1").hide();
						    	$("#field_id_2").hide();
						    	$("#operate").hide();
								//获取字段类型下拉项
								YiYa.ajaxJson('getFieldTypeData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.field_type_name, "value":item.field_type_id});
									});
									$("#field_type_id").combobox("loadData", data1);
								});	
						    	
								//获取字段(非组合，整形)下拉项
								YiYa.ajaxJson('getFieldsData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.field_name, "value":item.scoring_field_id});
									});
									$("#combined_field_id_1").combobox("loadData", data1);
									$("#combined_field_id_2").combobox("loadData", data1);
								});	
								
								//获取数据字典类型下拉项
								YiYa.ajaxJson('getDictionaryTypeData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.dictionary_type_name, "value":item.dictionary_type_id});
									});
									$("#dictionary_type_id").combobox("loadData", data1);
								});	
								
								$("#btn-model_field-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-model_field-update").style.display ='none';
								document.getElementById("btn-model_field-submit").style.display =''; 
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

function deleteModelField(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要该字段吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteField.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {scoring_field_id:row.scoring_field_id},
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
function editModelField(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	$("#btn-model_field-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-model_field-update").style.display ='';
	document.getElementById("btn-model_field-submit").style.display ='none'; 
	//获取字段类型下拉项
	YiYa.ajaxJson('getFieldTypeData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.field_type_name, "value":item.field_type_id});
		});
		$("#field_type_id").combobox("loadData", data1);
	});	
	
	//获取字段下拉项
	YiYa.ajaxJson('getFieldsData.do','field_value_type=1',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.field_name, "value":item.scoring_field_id});
		});
		$("#combined_field_id_1").combobox("loadData", data1);
		$("#combined_field_id_2").combobox("loadData", data1);
	});	
	
	//获取数据字典类型下拉项
	YiYa.ajaxJson('getDictionaryTypeData.do','',function(data){
		var data1;
		data1 = [];
		data1.push({"text":"---请选择---", "value":0});
		$.each(data, function(i,item){
			data1.push({"text":item.dictionary_type_name, "value":item.dictionary_type_id});
		});
		$("#dictionary_type_id").combobox("loadData", data1);
	});	
	
	
	//设值
	$("#scoring_field_id").val(row.scoring_field_id);
	$("#field_type_id").combobox('setValue', row.field_type_id);
	$("#field_name").val(row.field_name);
	$("#field_name_temp").val(row.field_name);
	$("#field_name_ch").val(row.field_name_ch);
	$("#field_value_type").combobox('setValue', row.field_value_type);
	$("#dictionary_type_id").combobox('setValue', row.dictionary_type_id);
	$("#field_desc").val(row.field_desc);
	$("#combined_field_id_1").combobox('setValue', row.combined_field_id_1);
	$("#combined_field_id_2").combobox('setValue', row.combined_field_id_2);
	$("#combined_operate").combobox('setValue', row.combined_operate);
	$("[value='" + row.is_combined + "']").attr("checked", true);
    //组合
    if (row.is_combined == 1)
    {
    	$("#field_id_1").show();
    	$("#field_id_2").show();
    	$("#operate").show();
    }
    else
    {
    	$("#field_id_1").hide();
    	$("#field_id_2").hide();
    	$("#operate").hide();
    }
}

function saveModelField()
{
	var field_type_id =  $("#field_type_id").combobox('getValue');
	var scoring_field_id = $("#scoring_field_id").val();
	var field_name = $("#field_name").val();
	var field_name_temp = $("#field_name_temp").val();
	var field_name_ch = $("#field_name_ch").val();
	var field_desc = $("#field_desc").val();
	var field_value_type = $("#field_value_type").combobox('getValue');
	var dictionary_type_id = $("#dictionary_type_id").combobox('getValue');
	
	var is_combined = $('input[name="is_combined"]:checked').val();//组合类型
	var combined_operate = $("#combined_operate").combobox('getValue');//运算符
	var combined_field_id_1 = $("#combined_field_id_1").combobox('getValue');//组合字段1
	var combined_field_id_2 = $("#combined_field_id_2").combobox('getValue');//组合字段2
	
	if(field_name =='')
	{
		$.messager.alert('提示:','请填写字段名','error'); 
		return false;
	}
	if (/[\u4E00-\u9FA5]/i.test(field_name))
	{
		$.messager.alert('提示:','字段名不能输入中文','error'); 
		return false;
	}	
	if(/^([0-9])*$/.test(field_name)){
		$.messager.alert('提示:','字段名不能全是数字','error'); 
		return false;
	}
	if(field_type_id == 0)
	{
		$.messager.alert('提示:','请选择业务分类','error'); 
		return false;
	}
	if(field_value_type == 9)
	{
		$.messager.alert('提示:','请选择字段值类型','error'); 
		return false;
	}
	if(field_value_type == 3 && dictionary_type_id == 0)
	{
		$.messager.alert('提示:','请选择数据字典类型','error'); 
		return false;
	}
	if (is_combined == '' || is_combined == undefined)
	{
		$.messager.alert('提示:','请选择组合类型','error'); 
		return false;
	}
	//组合类型
	if (is_combined == 1)
	{
		if (combined_field_id_1 == 0 || combined_field_id_2 == 0)
		{
			$.messager.alert('提示:','请选择组合字段','error'); 
			return false;
		}
		if ( combined_operate == 0)
		{
			$.messager.alert('提示:','请选择运算符','error'); 
			return false;
		}	
	}	
	var param = 'field_type_id='+ field_type_id + 
				'&scoring_field_id=' + scoring_field_id + 
				'&field_name=' + field_name + 
				'&field_name_ch=' + field_name_ch + 
				'&field_desc=' + field_desc +
				'&field_value_type=' + field_value_type +
				'&dictionary_type_id=' + dictionary_type_id +
				'&is_combined=' + is_combined + 
				'&combined_operate=' + combined_operate + 
				'&combined_field_id_1=' + combined_field_id_1 +
				'&combined_field_id_2=' + combined_field_id_2 +
				'&field_name_temp=' + field_name_temp;
				
	if ($("#btn-model_field-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-model_field-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveField.do', param,function(addData)
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
				$("#btn-model_field-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.scoringField.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		