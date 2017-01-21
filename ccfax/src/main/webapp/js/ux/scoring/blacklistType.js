$package('YiYa.blacklistType');
YiYa.blacklistType = function(){
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
			$("#btn-blacklist_type-submit").click(function()
			{	
				saveBlacklistType();
			});
			
			$("#btn-blacklist_type-update").click(function()
			{
				saveBlacklistType();
			});
			
			$("#btn-blacklist_type-cancel").click(function()
			{
				_this.editWin().dialog('close');

			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'blacklistTypeList.do',
	   			columns:[[
						{field:'id',title:'记录id',width:80,sortable:true,hidden:true},
						{field:'blacklist_type',title:'黑名单类型名称',width:450,sortable:true,align:'center'},
						{field:'add_time',title:'添加时间',width:180,sortable:true,align:'center'},
						{field:'edit',title:'管理操作',width:160,align:'center',sortable:true,
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='editBlacklistType("+index+")'>修改 | </a>";
								html +=" ";
								html +="<a href='#' onclick='deleteBlacklistType("+index+")'>删除</a>";
							return html;
						}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增',btnType:'add',handler:function(){
								_this.editWin().dialog('open');
								_this.editForm().resetForm(); 
								$("#btn-blacklist_type-submit").linkbutton({disabled:false});
								//修改按钮隐藏
								document.getElementById("btn-blacklist_type-update").style.display ='none';
								document.getElementById("btn-blacklist_type-submit").style.display =''; 
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



function deleteBlacklistType(index)
{
	var row = $("#data-list").datagrid("getRows")[index];
	$.messager.confirm("提示","确定要删除该类型吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deleteBlacklistType.do",
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
function editBlacklistType(index){
	$("#edit-win").window("open");
	$("#editForm").resetForm();
	var row = $("#data-list").datagrid("getRows")[index];
	$("#btn-blacklist_type-submit").linkbutton({disabled:false});
	//新增按钮隐藏
	document.getElementById("btn-blacklist_type-update").style.display ='';
	document.getElementById("btn-blacklist_type-submit").style.display ='none'; 
	//设值
	$("#id").val(row.id);
	$("#blacklist_type").val(row.blacklist_type);
}

function saveBlacklistType()
{
	var id = $("#id").val();
	var blacklist_type = $("#blacklist_type").val();
	
	if(blacklist_type =='')
	{
		$.messager.alert('提示:','请填类型名称','error'); 
		return false;
	}
	
	var param = 'id='+ id + 
				'&blacklist_type=' + blacklist_type ;
	
	if ($("#btn-blacklist_type-submit").linkbutton('options').disabled == false) 
	{
		$("#btn-blacklist_type-submit").linkbutton({disabled:true});
	    YiYa.ajaxJson('saveBlacklistType.do', param,function(addData)
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
				$("#btn-blacklist_type-submit").linkbutton({disabled:false});
			});
	}

}

$(function(){
	YiYa.blacklistType.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		