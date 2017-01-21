$package('YiYa.Loan');
YiYa.Loan = function(){
	
	var _box = null;
	var _this = {
		listForm:$("#listForm"),
		initForm:function(){
			
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',title:'借款编号',width:80,sortable:true,hidden:true},
						{field:'user_type',title:'',width:80,sortable:true,hidden:true},
						{field:'status',title:'',width:80,sortable:true,hidden:true},
						{field:'uid',title:'用户ID',width:100,sortable:false,align:'center'},
						{field:'phone',title:'手机号',width:100,sortable:false,align:'center'},
						{field:'user_type_',title:'用户类型',width:100,sortable:false,align:'center'},
						{field:'uname',title:'姓名',width:100,sortable:false,align:'center'},
						{field:'idcard',title:'经办人身份证号',width:150,sortable:false,align:'center'},
						{field:'addtime_',title:'申请时间',width:150,sortable:false,align:'center'},
						{field:'amount',title:'申请借款金额',width:100,sortable:false,align:'center'},
						{field:'status_',title:'当前状态',width:100,sortable:false,align:'center'},
						{field:'edit',title:'操作',width:120,sortable:false,align:'center',
							formatter:function(value,row,index){
							var html = "";
							if(row.user_type == 1){
								html +="<a href='#' onclick='YiYa.Loan.viewPersonInfo("+row.id+")'>查看</a>";
							}
							if(row.user_type == 2){
								html +="<a href='#' onclick='YiYa.Loan.viewCompanyInfo("+row.id+")'>查看</a>";
							}
							if(row.status == 0 && row.deal){
								html +=" | <a href='#' onclick='YiYa.Loan.updateStatus("+row.id+")'>处理</a>";
							}
							return html;
						}}
				]],
				toolbar:['']
			}
		},
		viewPersonInfo:function(id){
			location.href='viewPersonInfo.shtml?id='+id;
		},
		viewCompanyInfo:function(id){
			location.href='viewCompanyInfo.shtml?id='+id;
		},
		updateStatus:function(id){
			YiYa.confirm('提示', '该借款是否已发标或拒绝借款？', function(r){
				if(r){
					YiYa.ajaxJson('updateStatus.do', "id="+id, function(data){
						if(data.code == 0){
							var param = $("#searchForm").serializeObject();
							$("#data-list").datagrid('reload',param);
						}else{
							YiYa.alert('提示', data.msg, 'error');
						}
					});
				}
			});
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
	YiYa.Loan.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		