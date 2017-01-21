$package('YiYa.scoringConfig');
YiYa.scoringConfig = function(){
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
			$("#btn-model-type-submit").click(function()
			{	
				saveModelType();
			});
			
			$("#btn-model-type-update").click(function()
			{
				saveModelType();
			});
			
			$("#btn-model-type-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'modelTypeList.do',
	   			columns:[[
						{field:'field_type_id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'field_type_name',title:'字段类型名',width:200,sortable:true,align:'center'},
						{field:'field_type_desc',title:'字段描述',width:350,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:150,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='editModelType("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteModelType("+index+")'>删除</a>";
//								html +=" ";
//								html +="<a href='#' onclick='setModelField("+index+")'>设置字段</a>";
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增字段类型',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								$("#btn-model-type-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-model-type-update").style.display ='none';
								document.getElementById("btn-model-type-submit").style.display =''; 
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


function setModelField(index)
{   
	var row = $("#data-list").datagrid("getRows")[index];
	location.href = 'modelFieldPage.shtml?sel_field_type_id=' + row.field_type_id;
}



function deleteModelType(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","删除该类型则其下面所有字段将被删除，确定要删除该字段类型吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "delete.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {field_type_id:row.field_type_id},
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
function editModelType(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	$("#btn-model-type-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-model-type-update").style.display ='';
	document.getElementById("btn-model-type-submit").style.display ='none'; 
	//设值
	$("#field_type_id").val(row.field_type_id);
	$("#field_type_name").val(row.field_type_name);
	$("#field_type_desc").val(row.field_type_desc);
}

function saveModelType()
{
	var field_type_id = $("#field_type_id").val();
	var field_type_name = $("#field_type_name").val();
	var field_type_desc = $("#field_type_desc").val();
	
	if(field_type_name =='')
	{
		$.messager.alert('提示:','请填写字段类型名','error'); 
		return false;
	}
	
	var param = 'field_type_id='+ field_type_id + 
				'&field_type_name=' + field_type_name + 
				'&field_type_desc=' + field_type_desc;
	
	if ($("#btn-model-type-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-model-type-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('save.do', param,function(addData)
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
				$("#btn-model-type-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.scoringConfig.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		