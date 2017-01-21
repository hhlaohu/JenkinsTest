$package('YiYa.alertDaily');
YiYa.alertDaily = function(){
	var _box = null;
	var _this = {
			listForm:$("#listForm"),
			addAlertDaily:$("#Addwin"),
			addForm:function(){
				return $("#addForm");
			},
			
			alertConfig_win:$("#alertConfig_Win"),
			
			initForm:function(){

			},
		    savePwd:function(){
				if(_this.editPwdForm().form('validate')){
					_this.editPwdForm().attr('action',_this.updatePwdAction);
					YiYa.saveForm(_this.editPwdForm(),function(data){
						_this.editPwdWin().dialog('close');
					});
				 }
		    },
			
		   
		  
		    
			config:{
	  			dataGrid:{
	  				title:'',
		   			url:'dataList.do',
	                striped: true,
	                pagination: true,
	                height: 'auto',
		   			columns:[[
							{field:'alert_id',title:'序号',align:'center',width:60,sortable:true,hidden:true},
							{field:'alert_time',title:'警告时间',align:'center',width:160,sortable:true},
							{field:'alert_content',title:'问题',align:'center',width:420,sortable:true},
							{field:'deal_status',title:'处理状态',align:'center',width:80,sortable:true,
								formatter:function(value,row,index){
									if(value==0){
										return "跟进";
									}
									if(value==1){
										return "待处理";
									}
									if(value==2){
										return "已解决";
									}
							}},
							{field:'deal_with',title:'处理人',align:'center',width:80,sortable:true},
							{field:'deal_time',title:'处理时间',align:'center',width:160,sortable:true},
							{field:'pzGoodList',title:'操作',align:'center',width:100,sortable:true,formatter:function(value,row,index){
								var html ="<a href='#' onclick='updateAlertDaily("+index+")'>修改</a>";
		                    	
								return html;
								
							}}
					]],
					toolbar:[
						{id:'btnaddss',text:'新增',iconCls:'icon-add',handler:function(){
							_this.addAlertDaily.window("open");
						}},
						{id:'btnadds2',text:'预警配置',iconCls:'icon-add',handler:function(){
							_this.alertConfig_win.window("open");
						
									$('#alertConfig-data-list').datagrid({
									/*	width: 'auto',  
										height:$(window).height()*0.3,
						                striped: true,
						                pagination: true,
									    url:'alertConfigList.do',
									    */
										title:'',
							   			url:'dataList.do',
							   			width: $(window).width()*0.57,
//							   			height:'auto',     
							   			height:$(window).height()*0.45,
						                striped: true,
						                pagination: true,
						          
						                url:'alertConfigList.do',
									    columns:[[
								   			      

									       {field:'id',title:'序号',align:'center',width:60,sortable:true},
									        {field:'alert_condition',title:'预警条件',align:'center',width:218},
									        {field:'msg_status',title:'消息接收人',align:'center',width:92,sortable:true,
									        	formatter:function(value,row,index){
												if(value==1){
													return "客户";
												}
												if(value==2){
													return "风控";
												}
												if(value==3){
													return "客户/风控";
												}
									        }},
									        {field:'msg_with',title:'风控消息接收',align:'center',width:92},
									        {field:'wcmr_tel',title:'风控消息接收人电话',align:'center',width:192},
											{field:'notice_type',title:'通知方式',align:'center',width:92, sortable:true,
									        	formatter:function(value,row,index){
													if(value==1){
														return "短信";
													}
											}},
											{field:'msg_content',title:'短信内容',align:'center',width:340},
											{field:'updateAlertConfig',title:'操作',align:'center',width:85,sortable:true,formatter:function(value,row,index){
												var html ="<a href='#' onclick='updateAlertConfig("+index+")'>修改</a>";
												return html;
											}}
									    ]],
									
									});
							    
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

/**添加预警中心信息**/
function submitAlertDaily(){	
	//提交
		var queryParam = $("#addForm").serializeObject();//序列化表单对象
		$.ajax({										
			url     : "addAlertDaily.do",
			type    : "POST",
			cache   : false,
			dataType : 'json',
			data 	: queryParam,
			success : function(da){
				$("#Addwin").window('close', true);
				$("#data-list").datagrid('reload',queryParam);
				YiYa.alert('提示', "添加成功");
			},
		});
}


/**修改预警中心信息**/
function updateAlertDaily(index){
	$("#ModifyAlertConfigWin").window("open");
	var row = $("#data-list").datagrid("getRows")[index];//获取列表对应的值
	$("#modifyAlertDailyForm").find("input[name='alert_id']").val(row.alert_id);
	$("#my_deal_status").combobox('setValue',row.deal_status);  
}


/**保存预警中心信息**/
function modifyAlertDaily(){
	var queryParam = $("#modifyAlertDailyForm").serializeObject();
	var dataArray={
			'alert_id':queryParam["alert_id"],
			'deal_status':queryParam["deal_status"],
	};
	$.ajax({
		url      :'updateAlertDaily.do',
		type     :'post',
		cache    : false,
		dataType :'json',
		data     :queryParam,
		success  :function(data){
			$("#ModifyAlertConfigWin").window("close",true);
			$("#data-list").datagrid('reload',queryParam);
			YiYa.alert('提示', "修改成功");
		}
	});
}

/**修改预警配置信息**/
function updateAlertConfig(index){
	$("#ModifyWin").window("open");
	var row = $("#alertConfig-data-list").datagrid("getRows")[index];//获取列表对应的值
	$("#modifyAlertConfigForm").find("input[name='id']").val(row.id);
	//$("#msg_status").combobox('setValue',row.msg_status);  
	$("#modifyAlertConfigForm").find("input[name='wcmr_tel']").val(row.wcmr_tel);
	$("#modifyAlertConfigForm").find("input[name='msg_content']").val(row.msg_content);
}


/**保存预警配置信息**/
function modifyAlertConfig(){
	var queryParam = $("#modifyAlertConfigForm").serializeObject();
	var dataArray={
			'id':queryParam["id"],
			'msg_status':queryParam["msg_status"],
	};
	$.ajax({
		url      :'updateAlertConfig.do',
		type     :'post',
		cache    : false,
		dataType :'json',
		data     :queryParam,
		success  :function(data){
			$("#ModifyWin").window("close",true);
			$("#alertConfig-data-list").datagrid('reload',queryParam);
			YiYa.alert('提示', "修改成功");
		}
	});
}

/**关闭预警中心信息窗口**/
function closeAlertDaily(){
	$("#Addwin").window('close', true);
}


/**关闭修改预警中心信息窗口**/
function closeAlertDaily2(){
	$("#ModifyAlertConfigWin").window('close', true);
}

/**关闭预警配置信息窗口**/
function closeAlertConfig(){
	$("#alertConfig_Win").window('close', true);
}

/**关闭修改预警配置信息窗口**/
function closeAlertConfig2(){
	$("#ModifyWin").window('close', true);
}

$(function(){
	YiYa.alertDaily.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		