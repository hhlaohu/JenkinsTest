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
	   			url:'orderDataList.do',
	   			columns:[[
						{field:'usr_order_id',title:'',width:80,sortable:true,hidden:true},
						{field:'check_status',title:'',width:80,sortable:true,hidden:true},
						{field:'rule_set_id',title:'',width:80,sortable:true,hidden:true},
						{field:'add_usr_id',title:'',width:80,sortable:true,hidden:true},
						{field:'borrow_uid',title:'用户ID',width:100,sortable:false,align:'center'},
						{field:'borrower_mobile_phone',title:'手机号',width:120,sortable:false,align:'center'},
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
						{field:'check_status_',title:'状态',width:100,sortable:false,align:'center'},
						{field:'order_allot_',title:'资金渠道',width:100,sortable:false,align:'center'},
						{field:'edit',title:'操作',width:200,sortable:false,align:'center',
							formatter:function(value,row,index){
							var html = "<a href='#' onclick='YiYa.OrderManager.viewOrder("+row.usr_order_id+")'>查看</a>";
							if(row.check_status == 0 && row.check_1){
								html +=" | <a href='#' onclick='YiYa.OrderManager.check_1("+row.usr_order_id+")'>初审</a>";
							}
							if(row.check_status == 1 && row.check_2){
								html +=" | <a href='#' onclick='YiYa.OrderManager.check_2("+row.usr_order_id+")'>复审</a>";
							}
							if(row.check_status == 2 && row.check_3){
								html +=" | <a href='#' onclick='YiYa.OrderManager.check_3("+row.usr_order_id+")'>终审</a>";
							}
							if(row.have_scoring_report == 0 && row.createReport){
								html +=" | <a href='#' onclick='YiYa.OrderManager.createReport("+index+")'>生成报告</a>";
							}
							return html;
						}}
				]],
				toolbar:['']
			}
		},
		createReport:function(index){
			var row = $("#data-list").datagrid("getRows")[index];//获取列表对应的值
			var row1 = $('#data-list').datagrid('getSelected');
			if(row1 == null){
				alert('请选择要生成报告的订单行');
				return ;
			}
			var usrid = row.borrow_uid;
			var rule_set_id = row.rule_set_id;
			var store_type_name = row.store_type_name;
			var add_usr_id = row.add_usr_id;
			var order_sn = row.order_sn;
			var usr_order_id = row.usr_order_id;
			
			var param = 'usrid='+usrid+
						'&rule_set_id='+rule_set_id+
						'&store_type_name='+store_type_name+
						'&add_usr_id='+add_usr_id+
						'&order_sn='+order_sn+
						'&usr_order_id='+usr_order_id;
			
			YiYa.confirm('提示', '确定生成评分报告？', function(r){
				if(r){

				 $('body').block( {  
				        message : "<div style='top:100px;height:50px;vertical-align:middle' ><h1>正在生成报告，请稍候……</h1></div>",  
				        css : {  
				            border : '3px solid khaki'  
				        }  
				    });
					YiYa.ajaxJson('../score/create_score_report.do', param, function(data){
						// 数据加载完毕，取消等待画面的遮罩效果  
				        $.unblockUI(); 
						if(data.code == 0){
							YiYa.alert('提示', '生成报告成功', 'info');
							var param = $("#searchForm").serializeObject();
							$("#data-list").datagrid('reload',param);
						}else{
							YiYa.alert('提示', data.msg, 'error');
						}
					});
				}
			});
		},
		viewOrder:function(usr_order_id){
			location.href='viewOrderById.shtml?is_check=0&usr_order_id='+usr_order_id;
		},
		check_1:function(usr_order_id){
			location.href='viewOrderById.shtml?is_check=1&usr_order_id='+usr_order_id;
		},
		check_2:function(usr_order_id){
			location.href='viewOrderById.shtml?is_check=2&usr_order_id='+usr_order_id;
		},
		check_3:function(usr_order_id){
			location.href='viewOrderById.shtml?is_check=3&usr_order_id='+usr_order_id;
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