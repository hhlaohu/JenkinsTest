$package('YiYa.OrderManager');
YiYa.OrderManager = function(){
	
	var _box = null;
	var _this = {
		listForm:$("#listForm"),
		initForm:function(){
			
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'fundDataList.do',
	   			columns:[[
						{field:'usr_order_id',title:'',width:80,sortable:true,hidden:true},
						{field:'borrow_uid',title:'用户ID',width:100,sortable:false,align:'center'},
						{field:'borrower_usrname',title:'借款人',width:100,sortable:false,align:'center'},
						{field:'store_type_name',title:'类型',width:100,sortable:false,align:'center'},
						{field:'order_sn',title:'订单号',width:200,sortable:false,align:'center'},
						{field:'create_time',title:'提交时间',width:150,sortable:false,align:'center'},
						{field:'order_money',title:'借款金额',width:100,sortable:false,align:'center'},
						{field:'amortization_cnt',title:'借款期限',width:100,sortable:false,align:'center',
							formatter:function(value,row,index){
								return value+"个月";
							}},
						{field:'interest_type_',title:'还款方式',width:100,sortable:false,align:'center'},
						{field:'order_allot_',title:'资金渠道',width:100,sortable:false,align:'center'},
						{field:'edit',title:'操作',width:120,sortable:false,align:'center',
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='YiYa.OrderManager.viewOrder("+row.usr_order_id+")'>查看</a>";
							if(row.check_status == 3 && row.allot){
								html +=" | <a href='#' onclick='YiYa.OrderManager.allot("+row.usr_order_id+")'>分配</a>";
							}
							return html;
						}}
				]],
				toolbar:['']
			}
		},
		viewOrder:function(usr_order_id){
			location.href='viewOrderAllotById.shtml?allot=0&usr_order_id='+usr_order_id;
		},
		allot:function(usr_order_id){
			location.href='viewOrderAllotById.shtml?allot=1&usr_order_id='+usr_order_id;
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function()
{
	YiYa.OrderManager.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});	