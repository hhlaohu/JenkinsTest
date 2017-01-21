$package('YiYa.tabAffiliateRule');
YiYa.tabAffiliateRule = function(){
	var _box = null;
	var _this = {
		initForm:function(){
			
		},	
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
  				idField:"affiliate_rule_id",
  				singleSelect:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'affiliate_rule_id',checkbox:true},
						{field:'rule_code',title:'规则代码',align:'center',width:200,sortable:true},
						{field:'rule_name',title:'规则名称',align:'center',width:200,sortable:true},
						{field:'rule_desc',title:'规则描述',align:'center',width:180,sortable:true},
						{field:'add_time',title:'添加时间',align:'center',width:200,sortable:true},
						{field:'add_usr_name',title:'添加人',align:'center',width:200,sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
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
	YiYa.tabAffiliateRule.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		