$package('YiYa.dDVManager');
YiYa.dDVManager = function(){
	var _box = null;
	var _this = {
		editWin:function(){
			return $("#edit-win");
		},
		initForm:function(){
			var oper = 1;
			$("#btn-submit").click(function(){
				if(oper == 2){
					YiYa.alert('提示', '正在操作，请稍后', 'error');
					return ;
				}
				var dictionary_value_id = $("#dictionary_value_id").val();
				var dictionary_type_id = $("#dictionary_type_id").val();
				var dictionary_value_name = $("#dictionary_value_name").val();
				var dictionary_value_key = $("#dictionary_value_key").val();
				if (dictionary_type_id == '') {
					YiYa.alert('提示', '请选择类型', 'error');
					return ;
				}
				if (dictionary_value_name == '') {
					YiYa.alert('提示', '请输入数据字典value名称', 'error');
					return ;
				}
				if (dictionary_value_key == '') {
					YiYa.alert('提示', '请输入数据字典value的键值', 'error');
					return ;
				}
				var param = "dictionary_value_id=" + dictionary_value_id +
							"&dictionary_type_id=" + dictionary_type_id+
							"&dictionary_value_name=" + dictionary_value_name+
							"&dictionary_value_key=" + dictionary_value_key;
				YiYa.confirm('提示', '确定保存？', function(r){
					oper = 2;
					if(r){
						YiYa.ajaxJson('saveOrUpdateValue.do', param, function(data){
							if(data.flag){
								_this.editWin().dialog('close');
								var param = $("#searchForm").serializeObject();
								$("#data-list").datagrid('reload',param);
							}else{
								YiYa.alert('提示', data.msg,'error');
							}
						});
					}
					oper = 1;
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
  				singleSelect:true,
	   			url:'dDVDataList.do',
	   			columns:[[
	   			        {field:'dictionary_type_id',hidden:true}, 
	   			        {field:'dictionary_value_id',checkbox:true}, 
						{field:'dictionary_type_name',title:'数据字典类型名称',align:'center',width:200,sortable:true},
						{field:'dictionary_value_name',title:'数据字典value名称',align:'center',width:200,sortable:true},
						{field:'dictionary_value_key',title:'数据字典value的键值',align:'center',width:200,sortable:true},
						{field:'add_time',title:'操作时间',align:'center',width:150,sortable:true},
						{field:'add_usr_name',title:'操作人',align:'center',width:120,sortable:true},
						{field:'Str',title:'操作',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							html ="<a href='#' onclick='YiYa.dDVManager.updateDDV("+index+")'>编辑</a>" +
							" | " +
							"<a href='#' onclick='YiYa.dDVManager.deleteDDV("+row.dictionary_value_id+")'>删除</a>";
							return html;
						}}
				]],
				toolbar:[{id:'btnadd',text:'新增',btnType:'add',iconCls:'icon-add',handler:function(){
					$("#dictionary_value_id").val(0);
					$("#dictionary_value_name").val('');
					$("#dictionary_value_key").val('');
					$("#dictionary_type_id").val('');
					_this.editWin().window('open');
				}}]
			}
		},
		deleteDDV:function(dictionary_value_id){
			YiYa.confirm('提示', '确定删除？', function(r){
				if(r){
					YiYa.ajaxJson('deleteDDV.do', 'dictionary_value_id='+dictionary_value_id,function(data){
						if(data.flag){
							var param = $("#searchForm").serializeObject();
							$("#data-list").datagrid('reload',param);
						}else{
							YiYa.alert('提示', data.msg,'error');
						}
					});
				}
			});
		},
		updateDDV:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			$("#dictionary_value_id").val(row.dictionary_value_id);
			$("#dictionary_value_name").val(row.dictionary_value_name);
			$("#dictionary_value_key").val(row.dictionary_value_key);
			$("#dictionary_type_id").val(row.dictionary_type_id);
			_this.editWin().window('open');
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	YiYa.dDVManager.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});
