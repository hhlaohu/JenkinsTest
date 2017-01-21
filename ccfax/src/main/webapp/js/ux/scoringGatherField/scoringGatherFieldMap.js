$package('YiYa.scoringGatherFieldMap');
YiYa.scoringGatherFieldMap = function(){
	var _box = null;
	var _this = {
		initForm:function(){
			
		  $("#scoringFieldSelect").combobox({
			  groupField:'field_name_ch',
			  onSelect:function(rec){
				  var field_name_ch = $("option[value='"+rec.value+"']").attr("field_name_ch"); 
				  $("#field_name_ch_span").html(field_name_ch);
			  }
		  });
		  
		  $('#gahterTypeSelect').combobox({
			  onSelect:function(rec){
				  $('#gatherFieldSelect').combobox('clear');
				  var url = '../scoringGatherField/queryByCondition.do?gather_type_id='+rec.value;
		            $('#gatherFieldSelect').combobox('reload', url);
			  }
		  });
		  
		  $('#gatherFieldSelect').combobox({
			  url:"../scoringGatherField/queryByCondition.do?gather_type_id=0",
			  valueField: 'gather_field_id',
		      textField: 'field_name'
		  });
		  
		},	
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'scoring_field_id',title:'scoring_field_id',align:'center',width:200,sortable:true,hidden:true},
						{field:'gather_field_id',title:'gather_field_id',align:'center',width:200,sortable:true,hidden:true},
						{field:'gather_type_id',title:'gather_type_id',align:'center',width:200,sortable:true,hidden:true},
						{field:'scoring_field_name',title:'评分字段名',align:'center',width:200,sortable:true},
						{field:'scoring_field_name_ch',title:'评分字段中文名',align:'center',width:200,sortable:true},
						{field:'scoring_field_desc',title:'评分字段中文描述',align:'center',width:120,sortable:true},
						{field:'gather_field_name',title:'采集字段名',align:'center',width:180,sortable:true},
						{field:'gather_field_desc',title:'采集字段描述',align:'center',width:80,sortable:true},
						{field:'gather_type_name',title:'字段来源分类',align:'center',width:120,sortable:true},
						{field:'sys_usr_name',title:'添加人',align:'center',width:120,sortable:true},
						{field:'add_time',title:'添加时间',align:'center',width:200,sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'新增映射',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
								_box.handler.remove();
						}
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

$(function(){
	YiYa.scoringGatherFieldMap.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		