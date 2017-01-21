$package('YiYa.userManager');
YiYa.userManager = function(){
	var _box = null;
	var editFlag = false;
	var _this = {
		listForm:$("#listForm"),

		initForm:function(){
			
			//绑定标签页点击事件
			$(".tab_menu li:eq(0)").click(function(){
				setUsrinfo($("#usrinf_id").val(), null);
			});
			
			$(".tab_menu li:eq(1)").click(function(){
				$("#scoringReport").show();
				queryScoringList($("#usrid").val());
			});
			$(".tab_menu li:eq(2)").click(function(){
				$("#userBorrowInfo").show();
				$("#borrowDetail").hide();
				getUsrOrderList($("#usrid").val());
			});
			
			//生成报告点击事件，弹窗
			$("#btnCreateScoringReport").click(function(){
				//当存在下拉滚动条时，如果不做处理，弹窗位置会不准确。下面方法的处理是使弹窗位置根据某个按钮的位置进行显示
				var top = $("#createScoringReport").offset().top + 30;
				var left = $("#createScoringReport").offset().left + 100;
				$('#selectRulesSet-win').window('open').window('resize',{top: top,left:left});;
				$('#rulesListTable').datagrid({
	                striped: true,
	                pagination: false,
	                rownumbers:false,
	                singleSelect:true,//仅支持单选
				    url:'../scoringConfig/getRuleSetData.do',
				    columns:[[
                            {field:'rule_set_id',title:'规则集id',align:'center',hidden:true},
					        {field:'rule_set_name',title:'规则集名称',align:'center',width:$('#rulesListTable').width()*0.7},
			                {field:'putStockList',title:'操作',align:'center',width:$('#rulesListTable').width()*0.29,
					        formatter:function(value,row,index){
							var html = "";
							html +="<a href='#' onclick='YiYa.userManager.confirmRule("+index+")'>确认</a>";
							return html;
						    }}
				    ]],
				});
			});
		},
		
		//查看用户信息
		queryUserManager:function(usrinf_id,type){
			//如果是编辑页面，则设置用户信息页面为可编辑的
			if(type == 2){
				YiYa.userManager.editFlag = true;
			}
			$("#usrinf_id").val(usrinf_id);
			$("#query_tabUsrComplementPic").hide();
			$("#edit_tabUsrComplementPic").hide();
			$("#searchPanel").hide();
			$("#listForm").hide();
			$("#checkApply-win").show();
			$("#query_tabUsrComplementPic").show();
		
			//回显数据
			setUsrinfo(usrinf_id, null);
		},
		
		//确认规则集并且生成报告
		confirmRule:function(index){
			var row = $("#rulesListTable").datagrid("getRows")[index];
			var rule_set_id = row.rule_set_id;
			var usrid = $("#usrid").val();
			var dataArray={
					'usrid':usrid,
					'rule_set_id':rule_set_id
			};
			 $('body').block( {  
			        message : "<div style='top:100px;height:50px;vertical-align:middle' ><h1>正在生成报告，请稍候……</h1></div>",  
			        css : {  
			            border : '3px solid khaki'  
			        }  
			    });
			$.ajax({										
				url      : "../score/create_score_report.do",
				type     : "POST",
				cache    : false,
				dataType : 'json',
				data 	 : dataArray,
				complete : function() {  
		            // 数据加载完毕，取消等待画面的遮罩效果  
		           $.unblockUI(); 
		        }, 
				success  : function(data){
					  alert("生成报告成功");
					  $("#selectRulesSet-win").window("close");
				},
			});
		},
		
		//征信资料
		zhengxin_info:function(usrinf_id){
			$("#searchPanel").hide();
			$("#listForm").hide();
			$("#checkLog-win").window("close");
			$("#applyRecord-win").window("close");
			
			var dataArray={
					'usrinf_id':usrinf_id,
			};
			$.ajax({										
				url      : "queryzhengxin_info.do",
				type     : "POST",
				cache    : false,
				dataType : 'json',
				data 	 : dataArray,
				success  : function(data){
							if(data.msg==1){
								$("#zhengxin_info-win").show();
								$("#zhengxinInfo").text("无征信资料");
							}else{
								$("#zhengxin_info-win").show();
								document.getElementById("pdf_url").src=data.tabUsrinf.credit_report_pic;
							}
				},
			});
		},
		
		//资料处理
		info_handle:function(usrinf_id){
			window.location.href="info_handle.shtml?usrinf_id="+usrinf_id;
		},
			
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
	   			        {field:'id',checkbox:false,hidden:true},
						{field:'usrid',title:'用户ID',align:'center',width:80,sortable:true},
						{field:'usrname',title:'真实姓名',align:'center',width:120,sortable:true},
						{field:'mobile_phone',title:'手机号',align:'center',width:120,sortable:true},
						{field:'id_card',title:'身份证号',align:'center',width:150,sortable:true},
						{field:'credit_time',title:'授信时间',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							var html = "";
							html = row.credit_time;
							if(html!=null && html!=""){
								html = html.substring(0,10);
							}
							return html;
						}},
						{field:'loan_limit',title:'信用总额度',align:'center',width:120,sortable:true},
						{field:'loan_useble',title:'当前剩余额度',align:'center',width:120,sortable:true},
						{field:'limit_validity_time',title:'额度有效期',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							var html = "";
							html = row.limit_validity_time;
							if(html!=null && html!=""){
								html = html.substring(0,10);
							}
							return html;
						}},
						{field:'is_loan',title:'额度状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 0){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 1){
								return "正常";
							}
							if(value == 0){
								return "冻结";
							}
						}},
						{field:'putStockList',title:'操作',width:250,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							html +="<a href='#' onclick='YiYa.userManager.queryUserManager("+row.usrinf_id+",1"+")'>查看</a> | ";
							if(row.is_loan == 0){
								html +="<a href='#' onclick='enabledLimit("+index+")'>启用</a> | ";
							}
							if(row.is_loan == 1){
								html +="<a href='#' onclick='disabledLimit("+index+")'>冻结</a> | ";
							}
							
							html +="<a href='#' onclick='YiYa.userManager.zhengxin_info("+row.usrinf_id+")'>征信资料</a> | ";
							html +="<a href='#' onclick='YiYa.userManager.queryUserManager("+row.usrinf_id+",2"+")'>编辑</a> | ";
							return html;
						}}
				]],
				toolbar:['']
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


$("#btnSave").click(function(){
	var queryParam = $("#checkApplyForm").serializeObject();
	
	//单独封装联系人
	var tabBondsmaninfArray = new Array();
	$('#tabBondsmaninf_tab1').find('tr').each(function () {
		 var object = new Object();
         $(this).find('td >input').each(function () {  
        	 object[$(this).attr('id')] = $(this).val();
         })  ;
         $(this).find('td select').each(function () {  
        	 object[$(this).attr('id')] = $(this).combobox("getValue");
         })  ;
         $(this).find('div input').each(function () {  
        	 object[$(this).attr('id')] = $(this).val();
         });
         tabBondsmaninfArray.push(object);
     });
	
	$.ajax({										
		url      : "saveUserManager.do",
		type     : "POST",	
		cache    : false,
		dataType : 'json',
		data 	 : {"bondsmaninfList":JSON.stringify(tabBondsmaninfArray),"usrinfo":JSON.stringify(queryParam)},
		success  : function(data){
				if(data.msg==0){
					alert("联系人手机格式不正确");
					return false;
				}
				if(data.msg==1){
					alert("授信资料修改成功");
					window.location.href = config.siteurl+"/userManager/list.shtml"; 
					return false;
				}else{
					alert("授信资料修改失败");
				}
		},
	});
});
	


/**额度启用**/
function enabledLimit(index){
	var row = $("#data-list").datagrid("getRows")[index];//获取列表对应的值
	var dataArray={
			'usrinf_id':row.usrinf_id,
	};
	$.messager.confirm("额度启用","是否启用该用户额度？",function(flag){
		if(flag){
			$.ajax({										
				url      : "updateLimitStatus.do",
				type     : "POST",
				cache    : false,
				dataType : 'json',
				data 	 : dataArray,
				success  : function(da){
							YiYa.alert('提示', "启用成功");
							$("#data-list").datagrid('reload');
				},
			});
		}
	});
}

/**额度冻结**/
function disabledLimit(index){
	$("#modify_win").window("open");
	$("#btn-good-submit").click(function(){
		var queryParam = $("#updateLimitForm").serializeObject();
		if(!queryParam.freeze_remark){
			$.messager.alert('提示:','备注内容不能为空','error'); 
			return false;
		}
		var row = $("#data-list").datagrid("getRows")[index];
		var dataArray={
				'usrinf_id':row.usrinf_id,
				'freeze_remark':queryParam["freeze_remark"],
		};
		$.ajax({										
			url      : "updateLimitStatus.do",
			type     : "POST",
			cache    : false,
			dataType : 'json',
			data 	 : dataArray,
			success  : function(da){
						$("#modify_win").window('close', true);
						YiYa.alert('提示', "提交成功");
						$("#data-list").datagrid('reload');
			},
		});
	});
}


$(function(){
	YiYa.userManager.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		