$package('YiYa.DebtBorrow');
YiYa.DebtBorrow = function(){
	var _box = null;
	var _this = {
		editWin:function(){
			return $("#edit-win");
		},
		editWin1:function(){
			return $("#borrowCheckRecord-win");
		},
		initForm:function(){
			var oper = 1;
			$("#btn-submit").click(function(){
				if(oper == 2){
					YiYa.alert('提示', '正在操作，请稍后', 'error');
					return ;
				}
				var borrow_id = $("#borrow_id").val();
				var remark = $("#remark").val();
				var borrow_status = 0;
				if($("#tongguo").attr("checked") == "checked"){
					borrow_status = 1;
				}
				if($("#butongguo").attr("checked") == "checked"){
					borrow_status = 2;
				}
				if(borrow_status == 0){
					alert("请选择通过或者不通过");
					return;
				}
				var param = "borrow_id=" + borrow_id +
							"&remarks=" + remark+
							"&borrow_status=" + borrow_status;
				YiYa.confirm('提示', '确定保存？', function(r){
					oper = 2;
					if(r){
						YiYa.ajaxJson('review_debt_borrow_info.do', param, function(data){
							if(data.code == 0){
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
	   			url:'debtDataList.do',
	   			columns:[[
						{field:'check_remark_dataList',hidden:true}, 
						{field:'borrow_id',title:'标id',align:'center',width:50,sortable:true},
						{field:'user_name',title:'转让人',align:'center',width:100,sortable:true},
						{field:'borrow_name',title:'项目名称',align:'center',width:200,sortable:true},
						{field:'investor_capital',title:'投资金额',align:'center',width:100,sortable:true},
						{field:'borrow_interest_rate',title:'预期年化收益率',align:'center',width:150,sortable:true},
						{field:'collect_total',title:'待收期数/天数',align:'center',width:150,sortable:true},
						{field:'tran_total',title:'转让期数/天数',align:'center',width:150,sortable:true},
						{field:'total',title:'总期数/天数',align:'center',width:150,sortable:true},
						{field:'captial',title:'待收本金',align:'center',width:100,sortable:true},
						{field:'collect_interest',title:'待收利息',align:'center',width:100,sortable:true},
						{field:'totalmoney',title:'债权价值',align:'center',width:100,sortable:true},
						{field:'tran_price',title:'转让价格',align:'center',width:100,sortable:true},
						{field:'debt_rate',title:'折价率',align:'center',width:100,sortable:true},
						{field:'debt_addtime',title:'提交时间',align:'center',width:150,sortable:true},
						{field:'borrow_status',title:'当前状态',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							if (value == 0) {
								return "待审核";
							} else if (value == 1) {
								return "出售中";
							} else if (value == 2) {
								return "审核未通过";
							} else if (value == 3 || value == 4 || value == 5) {
								return "已撤销";
							} else if (value == 6) {
								return "已成功";
							} else {
								return "未知状态";
							}
						}},
						{field:'Str',title:'操作',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							if (row.borrow_status == 0) {
								html ="<a href='#' onclick='YiYa.DebtBorrow.check_debt("+index+")'>审核</a> | ";
							}
							html = html + "<a href='#' onclick='YiYa.DebtBorrow.remark_desc("+index+")'>查看</a>";
							return html;
						}}
				]],
				toolbar:['']
			}
		},
		check_debt:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			$("#borrow_id").val(row.borrow_id);
			$("#tongguo").removeAttr("checked");
			$("#butongguo").removeAttr("checked");
			$("#remark").val('');
			_this.editWin().window('open');
		},
		remark_desc:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			var array = row.check_remark_dataList;
			var html = "<tr><td><table id='borrowCheckRecord_data_list' class='tbBaseInfo5' width='98%'><tr><td><p class='easyui-validatebox member-input' type='text' >时间</p></td><td><p class='easyui-validatebox member-input' type='text' >动态</p></td></tr></table></td></tr>";
			$.each($(row.check_remark_dataList),function(i,data){
				html += '<tr>'+
				'    				     <td>'+
				'					     <table id="borrowCheckRecord_data_list" class="tbBaseInfo5" width="98%"> '+
				'					        <tr>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.time+'</p>'+
				'			                        </td>						     '+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.info+'</p>'+
				'			                        </td>					     '+
				'						     </tr>						     '+
				'					     </table>'+
				'					     </td>'+
				'					</tr>';
			});
			if(html == ""){
				html = "<div style='text-align:center'><p style='font-size:20px'>暂无操作记录<p></div>"
			}
			$("#borrowCheckRecordTable").empty();
			$("#borrowCheckRecordTable").append(html);
			_this.editWin1().window('open');
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
	YiYa.DebtBorrow.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});
