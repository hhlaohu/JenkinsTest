$package('YiYa.blacklistValue');
YiYa.blacklistValue = function(){
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
			$("#btn-blacklist_value-submit").click(function()
			{	
				saveBlacklistValue();
			});
			
			$("#btn-blacklist_value-update").click(function()
			{
				saveBlacklistValue();
			});
			
			$("#btn-blacklist_value-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'blacklistTypeValue.do',
	   			columns:[[
						{field:'id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'blacklist_type',title:'黑名单类型',width:180,sortable:true,align:'center'},
						{field:'blacklist_value',title:'黑名单值',width:450,sortable:true,align:'center'},
						{field:'is_active',title:'激活状态',width:150,sortable:true,align:'center',
							formatter:function(value,row,index){
								var html ="";
								if (value == 1)
									html = "激活";
								if (value == 0)
									html = "未激活";
								return html;
							}
						},
						{field:'add_time',title:'添加时间',width:180,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
							formatter:function(value,row,index){
								var html = "";
								if (row.is_active == 1)
								{
								    html += "<a href='#' onclick='editBlacklistValue("+index+")'>修改 | </a>";
									html +=" ";
									html +="<a href='#' onclick='deleteBlacklistValue("+index+")'>删除</a>";
									html +=" | ";
									html +="<a href='#' onclick='deActiveValue("+index+")'>去激活</a>";
								}
								if (row.is_active == 0)
								{
									html +="<a href='#' onclick='activeValue("+index+")'>激活</a>";
								}
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增黑名单',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								
								//获取类型下拉项
								YiYa.ajaxJson('getBlacklistTypeData.do','',function(data){
									var data1;
									data1 = [];
									data1.push({"text":"---请选择---", "value":0, "selected":true});
									$.each(data, function(i,item){
										data1.push({"text":item.blacklist_type, "value":item.id});
									});
									$("#blacklist_type_id").combobox("loadData", data1);
								});	
								
								$("#btn-blacklist_value-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-blacklist_value-update").style.display ='none';
								document.getElementById("btn-blacklist_value-submit").style.display =''; 
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
function activeValue(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要激活该黑名单吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "saveBlacklistValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {id:row.id,is_active:1},
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
function deActiveValue(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定去激活该黑名单吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "saveBlacklistValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {id:row.id,is_active:0},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "去激活成功",'info');
				},
			});
		}
	});
}



function deleteBlacklistValue(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteBlacklistValue.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {id:row.id},
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
function editBlacklistValue(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	//获取类型下拉项
	YiYa.ajaxJson('getBlacklistTypeData.do','',function(data){
		var data1;
		data1 = [];
		$.each(data, function(i,item){
			data1.push({"text":item.blacklist_type, "value":item.id});
		});
		$("#blacklist_type_id").combobox("loadData", data1);
	});	
	$("#btn-blacklist_value-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-blacklist_value-update").style.display ='';
	document.getElementById("btn-blacklist_value-submit").style.display ='none'; 
	//设值
	$("#id").val(row.id);
	$("#blacklist_value").val(row.blacklist_value);
	$("#blacklist_type_id").combobox('setValue', row.blacklist_type_id);
}

function saveBlacklistValue()
{
	var id = $("#id").val();
	var blacklist_value = $("#blacklist_value").val();
	var blacklist_type_id = $("#blacklist_type_id").combobox('getValue');
	
	if(blacklist_type_id == 0)
	{
		$.messager.alert('提示:','请选择黑名单类型','error'); 
		return false;
	}
	
	if(blacklist_value =='')
	{
		$.messager.alert('提示:','请填写黑名单值','error'); 
		return false;
	}
	
	var param = 'id='+ id + 
				'&blacklist_value=' + blacklist_value + 
				'&blacklist_type_id=' + blacklist_type_id ;
	
	if ($("#btn-blacklist_value-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-blacklist_value-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveBlacklistValue.do', param,function(addData)
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
				$("#btn-blacklist_value-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.blacklistValue.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		