$package('YiYa.scoringGatherField');
YiYa.scoringGatherField = function(){
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
				$("#btn-submit").click(function(){
					var gather_field_id = $("#gather_field_id").val();
					var field_name = $("#field_name").val();
					var is_enable = $('input[name="is_enable"]:checked').val();//是否使用
					var gather_type_id =  $("#gather_type_id").combobox('getValue');
					var field_desc = $("#field_desc").val();
					
					if(field_name == '')
					{
						$.messager.alert('提示:','请输入字段名','error'); 
						return false;
					}
					if(gather_type_id == 0)
					{
						$.messager.alert('提示:','请选择字段来源分类','error'); 
						return false;
					}
					
					var param = 'gather_field_id='+ gather_field_id + 
								'&field_name=' + field_name +
								'&is_enable=' + is_enable +
								'&gather_type_id=' + gather_type_id +
								'&field_desc=' + field_desc;
					
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
					});
				});
				$("#btn-close").click(function(){
					_this.editWin().dialog('close');
				});
			},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
  				idField:'gather_field_id',
	   			url:'dataList.do',
	   			columns:[[
						{field:'gather_field_id',width:50,sortable:true,hidden:true},
						{field:'field_name',title:'字段名',align:'center',width:200,sortable:true},
						{field:'field_desc',title:'字段描述',align:'center',width:200,sortable:true},
						{field:'gather_type_name',title:'字段来源分类',align:'center',width:120,sortable:true},
						{field:'add_time',title:'创建时间',align:'center',width:180,sortable:true},
						{field:'sys_usr_name',title:'管理员',align:'center',width:120,sortable:true},
						{field:'edit',title:'操作',width:200,align:'center',sortable:true,
							formatter:function(value,row,index){
								var html = "";
							if (row.is_enable == 1)
							{
								html += "<a href='#' onclick='editGatherField("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteGatherField("+index+")'>删除</a>";
								html +=" | ";
								html +="<a href='#' onclick='deActiveGatherField("+index+")'>不使用</a>";
							}
							if (row.is_enable == 0)
							{
								html +="<a href='#' onclick='activeGatherField("+index+")'>使用</a>";
							}	
							return html;
						}}
				]],
//				toolbar:[
//					{id:'btnadd',text:'新增',btnType:'add'},
//					{id:'btnedit',text:'修改',btnType:'edit'},
//					{id:'btndelete',text:'删除',btnType:'remove',handler:function(){
//						var selected = _box.utils.getCheckedRows();
//						if ( _box.utils.checkSelectOne(selected)){
//								_box.handler.remove();
//						}
//					}}
//				]
				toolbar:[{id:'btnadd',text:'新增',btnType:'add',iconCls:'icon-add',handler:function(){
					_this.editForm().resetForm(); 
					$("#field_name").val('');
					$("#field_desc").val('');
					$("#gather_type_id").combobox('setValue', 0);
					_this.editWin().dialog('open');
				}}]
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
 * 激活（0:不使用，1：使用）
 * @param index
 */
function activeGatherField(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要激活该采集字段吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "save.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {gather_field_id:row.gather_field_id,is_enable:1},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "激活成功",'info');
				},
			});
		}
	});
}


/**
 * 去激活（0:不使用，1：使用）
 */
function deActiveGatherField(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定去激活该采集字段吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "save.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {gather_field_id:row.gather_field_id,is_enable:0},
				success : function(da){
					$("#data-list").datagrid("reload");
					YiYa.alert('提示', "去激活成功",'info');
				},
			});
		}
	});
}


function editGatherField(index)
{
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	
	$("#gather_field_id").val(row.gather_field_id);
	$("#field_name").val(row.field_name);
	$("[value='" + row.is_enable + "']").attr("checked", true);
	$("#gather_type_id").combobox('setValue', row.gather_type_id);
	$("#field_desc").val(row.field_desc);
}

function deleteGatherField(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	YiYa.confirm('提示', '确定删除？', function(r){
		if(r){
			YiYa.ajaxJson('delete.do', 'gather_field_id='+row.gather_field_id,function(data){
				if(data.success)
				{
					$("#data-list").datagrid("reload");
				}
				else
				{
					YiYa.alert('提示', data.msg,'error');
				}
			});
		}
	});
}



$(function(){
	YiYa.scoringGatherField.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		