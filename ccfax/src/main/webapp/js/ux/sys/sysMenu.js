$package('YiYa.sysMenu');

YiYa.sysMenu = function(){
	var _box = null;
	var _this = {
		add_win : $("#add_win"),
		addForm:function(){
			return $("#addForm");
		},
		initForm:function(){
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
					{field:'parentName',title:'父级菜单',align:'center',width:120,sortable:true},
					{field:'name',title:'菜单名称',align:'center',width:120,sortable:true},
					{field:'url',title:'系统url',align:'center',width:220,sortable:true},
					{field:'menuLevel',title:'菜单层级',align:'center',width:80,sortable:true,
						formatter:function(value,row,index){
							if(value == 1){
								return "1级";
							}
							if(value == 2){
								return "2级";
							}
					}},
					{field:'actions',title:'注册Action按钮',align:'center',width:220,sortable:true},
					{field:'createTime',title:'创建时间',align:'center',width:180,sortable:true},
					{field:'updateTime',title:'修改时间',align:'center',width:180,sortable:true},
					{field:'childMenus',title:'子菜单',align:'center',width:120,align:'center',formatter:function(value,row,index){
						var html ="<a href='#' onclick='YiYa.sysMenu.toList("+row.id+")'>子菜单管理("+row.subCount+")</a>";
						return html;
					}}
				]],
				toolbar:[
							{id:'btnadd',text:'新增',btnType:'add',handler:function(){
								_this.add_win.window("open");
							}},
							{id:'btndelete',text:'删除',btnType:'remove',handler:function(){
								var selected = _box.utils.getCheckedRows();	
								_box.handler.remove();
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

function submitSysMenu(){
	var queryParam = $("#addForm").serializeObject();//序列化表单对象
	if(!queryParam.name){
		$.messager.alert('提示:','菜单名称不能为空','error'); 
		return false;
	}
	if(!queryParam.url){
		$.messager.alert('提示','系统url不能为空','error');
		return false;
	}
	var dataArray={
			'id':queryParam["id"],
			'name':queryParam["name"],
			'url':queryParam["url"],
			'menuLevel':queryParam["menuLevel"],
			'actions':queryParam["actions"]
	};
	$.ajax({
		url     : 'addSysMenu.do',
		type    : "POST",
		cache   : false,
		dataType: 'json',
		data 	: queryParam,
		success : function(data){
			$("#add_win").window("close",true);
			$("#data-list").datagrid('reload',queryParam);
			YiYa.alert('提示', "添加成功");
		}
	});
}

function closeSysMenu(){
	$("#add_win").window('close', true);
}


$(function(){
	YiYa.sysMenu.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		