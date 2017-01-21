$package('YiYa.dDTManager');
YiYa.dDTManager = function(){
	var _box = null;
	var _this = {
		editWin:function(){
			return $("#edit-win");
		},
		//设置字段值，弹出窗口
		setDataValue:function(index){
			$("#view-win").window("open");
			$("#viewForm").resetForm();
			var row = $("#data-list").datagrid("getRows")[index];
			//设值
			$("#view_dictionary_type_id").val(row.dictionary_type_id);
			$("#view_dictionary_type_name").val(row.dictionary_type_name);
			
			//新增字典value
			$("#btn-addDataValue").click(function(){
				$("#value-win").form('clear');
				$("#value-win").window('open');
				$("#dictionary_value_id").val(0);
			});
			
			//关闭
			$("#btn-dictionary-value-cancel").click(function()
			{
				$("#value-win").dialog('close');
			});
			_this.showDataDictionaryValue(row.dictionary_type_id);
		},
		//新增数据字典Value列表
		showDataDictionaryValue:function(dictionary_type_id){
			$('#data-dictionary-value-data-list').datagrid({
				width: 'auto',  
				height:$(window).height()*0.3,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'dDVDataList.do',
			    queryParams:{  
                    'dictionary_type_id' : dictionary_type_id,  
                },
	   			columns:[[
		   			        {field:'dictionary_type_id',hidden:true}, 
							{field:'dictionary_value_name',title:'数据字典value名称',align:'center',width:250,sortable:true},
							{field:'dictionary_value_key',title:'数据字典value的键值',align:'center',width:215,sortable:true},
							{field:'add_time',title:'操作时间',align:'center',width:150,sortable:true},
							{field:'add_usr_name',title:'操作人',align:'center',width:120,sortable:true},
							{field:'Str',title:'操作',width:150,align:'center',sortable:true,formatter:function(value,row,index){
								var html = "";
								html ="<a href='#' onclick='updateDDV("+index+")'>编辑</a>" +
								" | " +
								"<a href='#' onclick='deleteDDV("+row.dictionary_value_id+")'>删除</a>";
								return html;
							}}
					]],
			});
		},
		initForm:function(){
			var oper = 1;
			$("#btn-submit").click(function(){
				if(oper == 2){
					YiYa.alert('提示', '正在操作，请稍后', 'error');
					return ;
				}
				var dictionary_type_id = $("#dictionary_type_id").val();
				var dictionary_type_name = $("#dictionary_type_name").val();
				var is_relational_table =  $('input[name="is_relational_table"]:checked').val();//是否关联
				var relational_table_name = $("#relational_table_name").val();
				if (dictionary_type_name == '') {
					YiYa.alert('提示', '请输入数据字典类型名称', 'error');
					return ;
				}
				if (is_relational_table == 1 && relational_table_name == '')
				{
					YiYa.alert('提示', '请输入关联外部表名', 'error');
					return ;
				}	
				var param = "dictionary_type_id=" + dictionary_type_id +
							"&dictionary_type_name=" + dictionary_type_name + 
							"&is_relational_table=" + is_relational_table + 
							"&relational_table_name=" + relational_table_name ;
				YiYa.confirm('提示', '确定保存？', function(r){
					oper = 2;
					if(r){
						YiYa.ajaxJson('saveOrUpdateType.do', param, function(data){
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
			$("#btn-view-data-value-cancel").click(function()
			{
				$("#view-win").dialog('close');
			});
			
			$(":radio").click(function(){
			    //不关联
			    if ($(this).val() == 0)
			    {
			    	$("#relational_table_name").val('');
			    }
		});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
  				singleSelect:true,
	   			url:'dDTDataList.do',
	   			columns:[[
	   			        {field:'dictionary_type_id',checkbox:true}, 
						{field:'dictionary_type_name',title:'数据字典类型名称',align:'center',width:200,sortable:true},
						{field:'dictionary_type_code',title:'数据字典编号',align:'center',width:200,sortable:true},
						{field:'is_relational_table',title:'是否关联外部表',align:'center',width:200,sortable:true,
							formatter:function(value,row,index){
								var html = "";
								if (value == 0)
								{
									html = "不关联";
								}	
								if (value == 1)
								{
									html = "关联";
								}
								return html;
						}},	
						{field:'relational_table_name',title:'关联外部表名',align:'center',width:200,sortable:true},
						{field:'add_time',title:'操作时间',align:'center',width:150,sortable:true},
						{field:'add_usr_name',title:'操作人',align:'center',width:120,sortable:true},
						{field:'Str',title:'操作',width:250,align:'center',sortable:true,formatter:function(value,row,index){
							var html;
							html ="<a href='#' onclick='YiYa.dDTManager.updateDDT("+index+")'>编辑</a>" +
							" | " +
							"<a href='#' onclick='YiYa.dDTManager.deleteDDT("+row.dictionary_type_id+")'>删除</a>";
							if (row.is_relational_table == 0)
							{
								html += " | " ;
								html += "<a href='#' onclick='YiYa.dDTManager.setDataValue("+index+")'>设置字典值</a>";
							}	
							
							return html;
						}}
				]],
				toolbar:[{id:'btnadd',text:'新增',btnType:'add',iconCls:'icon-add',handler:function(){
					$("#dictionary_type_id").val(0);
					$("#dictionary_type_name").val('');
					$("#relational_table_name").val('');
					$("#dictionary_type_code_TR").hide();
					_this.editWin().window('open');
				}}]
			}
		},
		deleteDDT:function(dictionary_type_id){
			YiYa.confirm('提示', '确定删除？', function(r){
				if(r){
					YiYa.ajaxJson('deleteDDT.do', 'dictionary_type_id='+dictionary_type_id,function(data){
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
		updateDDT:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			$("#dictionary_type_code_TR").show();
			$("#dictionary_type_id").val(row.dictionary_type_id);
			$("#dictionary_type_name").val(row.dictionary_type_name);
			$("#dictionary_type_code").html(row.dictionary_type_code);
			$("[value='" + row.is_relational_table + "']").attr("checked", true);
			$("#relational_table_name").val(row.relational_table_name);
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


//保存数据字典value
function saveDDV()
{
	var dictionary_value_id = $("#dictionary_value_id").val();
	var dictionary_type_id = $("#view_dictionary_type_id").val();
	var dictionary_value_name = $("#dictionary_value_name").val();
	var dictionary_value_key = $("#dictionary_value_key").val();
	
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
		if(r){
			YiYa.ajaxJson('saveOrUpdateValue.do', param, function(data){
				if(data.flag)
				{
					$("#value-win").window("close");
					$("#data-dictionary-value-data-list").datagrid('reload');
				}else{
					YiYa.alert('提示', data.msg,'error');
				}
			});
		}
	});
}

//修改数据字典value
function updateDDV(index)
{
	$("#value-win").form('clear');
	$("#value-win").window('open');
	var row = $("#data-dictionary-value-data-list").datagrid("getRows")[index];
	$("#dictionary_value_id").val(row.dictionary_value_id);
	$("#dictionary_value_name").val(row.dictionary_value_name);
	$("#dictionary_value_key").val(row.dictionary_value_key);
}

//删除数据字典value
function deleteDDV(dictionary_value_id)
{
	YiYa.confirm('提示', '确定删除？', function(r){
		if(r){
			YiYa.ajaxJson('deleteDDV.do', 'dictionary_value_id='+dictionary_value_id,function(data){
				if(data.flag){
					$("#data-dictionary-value-data-list").datagrid('reload');
				}else{
					YiYa.alert('提示', data.msg,'error');
				}
			});
		}
	});
}

$(function(){
	YiYa.dDTManager.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});
