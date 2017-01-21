$package('YiYa.creditCheck');
YiYa.creditCheck = function(){
	var _box = null;
	var _this = {
		initForm:function(){
			$("#checkApply-win").hide();
			$("#checkRecord-cancel").click(function(){
				$("#checkRecord-win").window("close");
				$("#listForm").show();
				$("#data-list").datagrid('reload');
			});
			$("#applyRecord-cancel").click(function(){
				$("#applyRecord-win").window("close");
				$("#listForm").show();
				$("#data-list").datagrid('reload');
			});
			$("#currentOperator-cancel").click(function(){
				$("#currentOperator-win").window("close");
				$("#listForm").show();
				$("#data-list").datagrid('reload');
			});
			
			//绑定标签页点击事件
			$(".tab_menu li:eq(1)").click(function(){
				$("#scoringReport").show();
				queryScoringList($("#usrid").val(),false);
			});
			
			$("#updateCheckLog").click(function(){
				var usrinf_id = $("#usrinf_id").val();
	        	var check_result = $("input[name='check_result']:checked").val();//审核状态
	        	var applyfor_limit = $("#applyfor_limit").val();//初审额度
	        	var second_check_loan_limit = $("#second_check_loan_limit").val();//复审额度
	        	var loan_limit = $("#loan_limit").val();//终审额度
	        	var check_remark = $("#check_remark").val();//审核意见
	        	var user_name = $("#user_name").val();//审核人
	        	var limit_validity_time = $("#limit_validity_time").datetimebox('getValue');
	        	
	        	if(check_result=="" || typeof(check_result) == "undefined"){
	        		alert("请选择审核结果！");
	        		return;
	        	}
	    
	        	if(check_result==3 || check_result==4 || check_result==5 || 
	        		 check_result==6 || check_result==7 || check_result==8 ||
	        		 check_result==9){
	        		//初审通过、复审通过、终审通过时需要检验两者的必输性
	        		if(check_result==3){
	        			if(applyfor_limit=="" || typeof(applyfor_limit)=="undefined"){
			        		alert("请输入授信额度！");
			        		return;
			        	}
	        			if(limit_validity_time=="" || typeof(limit_validity_time)=="undefined"){
			        		alert("请输入额度有效期！");
			        		return;
			        	}
	        			
	        		}
	        		if(check_result==5){
	        			if(second_check_loan_limit=="" || typeof(second_check_loan_limit)=="undefined"){
			        		alert("请输入授信额度！");
			        		return;
			        	}
	        			if(limit_validity_time=="" || typeof(limit_validity_time)=="undefined"){
			        		alert("请输入额度有效期！");
			        		return;
			        	}
	        		}
	        		if(check_result==8){
	        			if(loan_limit=="" || typeof(loan_limit)=="undefined"){
			        		alert("请输入授信额度！");
			        		return;
			        	}
	        			if(limit_validity_time=="" || typeof(limit_validity_time)=="undefined"){
			        		alert("请输入额度有效期！");
			        		return;
			        	}
	        		}
		        	if(check_remark=="" || typeof(check_remark)=="undefined"){
		        		alert("请输入审核意见,限制50字！");
		        		return;
		        	}else if(check_remark!=""&&(strlen(check_remark)>50)){
		        		alert("审核意见超过限制的50字，请重新输入");
		        		return;
		        	}
	        	}
	        	
	        	if(limit_validity_time!="" && typeof(limit_validity_time)!="undefined"){
	        		limit_validity_time = limit_validity_time+" 00:00:00";
	        	}
	        	
	        	var dataArray={
						'usrinf_id':usrinf_id,
						'check_result':check_result,
						'applyfor_limit':applyfor_limit,		
						'loan_limit':loan_limit,
						'second_check_loan_limit':second_check_loan_limit,
						'limit_validity_time':limit_validity_time,		
						'check_remark':check_remark,
						'user_name':user_name	
				};
				$.ajax({										
					url     : "../creditCheck/updateCheckLog.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
						if(data.msg==0){
							alert("请输入授信额度！");
							$('#checkLog_detail_list').datagrid('reload');
							return false;
						}
						if(data.msg==1){
							alert("复审额度不能大于初审额度！");
							$('#checkLog_detail_list').datagrid('reload');
							return false;
						}
						if(data.msg==7){
							alert("额度有效期不能小于当前时间！");
							$('#checkLog_detail_list').datagrid('reload');
							return false;
						}
						if(data.msg==2){
							alert("审核失败！");
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
							return false;
						}
						if(data.msg==4){
							alert("退回初审！"); 
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
							return false;
						}
						if(data.msg==10){
							alert("退回复审！"); 
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
							return false;
						}
						if(data.msg==5){
							alert("初审不通过！");
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
							return false;
						}
						if(data.msg==6){
							alert("复审不通过！");
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
							return false;
						}
						if(data.msg==3){
							alert("审核通过！");
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
						}
						if(data.msg==8){
							alert("终审额度不能大于复审额度");
							$('#checkLog_detail_list').datagrid('reload');
							return false;
						}
						if(data.msg==9){
							alert("终审不通过");
							window.location.href = config.siteurl+"/creditCheck/list.shtml"; 
						}
						
					},
				});
			});
			
			//手动保存审核日志备注1
			$("#saveCheckLogComment").click(function(){
				var usrinf_id = $("#usrinf_id").val();
	        	var check_result = 10;//10表示审核操作“增加备注”
	        	var check_remark = $("#checkLogComment").val();//审核意见
	        	if($.trim(check_remark) == ''){
	        		alert("备注不能为空");
	        		return;
	        	}
	        	var dataArray={
						'usrinf_id':usrinf_id,
						'check_result':check_result,
						'check_remark':check_remark
				};
				$.ajax({										
					url     : "../creditCheck/saveCheckLog.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
                       if(data.code==0){
                    	   $("#checkLog_detail_list").datagrid('reload');
                    	   alert("保存成功");
                       }						
					},
				});
			});
			
			//手动保存审核日志备注2
			$("#saveCheckLogComment2").click(function(){
				var usrinf_id = $("#checkLogComment2_usrinf_id").val();
	        	var check_result = 10;//10表示审核操作“增加备注”
	        	var check_remark = $("#checkLogComment2").val();//审核意见
	        	if($.trim(check_remark) == ''){
	        		alert("备注不能为空");
	        		return;
	        	}
	        	var dataArray={
						'usrinf_id':usrinf_id,
						'check_result':check_result,
						'check_remark':check_remark
				};
				$.ajax({										
					url     : "../creditCheck/saveCheckLog.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
                       if(data.code==0){
                    	   $("#checkRecord_data_list").datagrid('reload');
                    	   alert("保存成功");
                       }						
					},
				});
			});
		},
		//审核
		checkApply:function(usrinf_id,check_flag,applyfor_limit,second_check_loan_limit,limit_validity_time,param){
			$("#searchPanel").hide();
			$("#listForm").hide();
			$("#applyRecord-win").window("close");
			$("#checkRecord-win").window("close");
			$("#checkApply-win").show();
			$("#query_checkApply-win").show();
			
			if(param==100){//当点击查看的时候,显示补充资料的数据
				$("#query_tabUsrComplementPic").show();
			}else{
				$("#edit_tabUsrComplementPic").show();
			}
			//初审的时候隐藏复审、终审
			if(check_flag==1){
				$("#checkApply_type").text("初审");
				$("#second_checked").hide();
				$("#final_checked").hide();
			}
			//复审的时候隐藏初审、终审
			if(check_flag==3){
				$("#checkApply_type").text("复审");
				$("#first_checked").hide();
				$("#final_checked").hide();
				var strtime = limit_validity_time.substring(0,10);//截取时分秒
				$('#limit_validity_time').datebox('setValue', strtime);//额度有效期显示
				var check_result =  $("input[name='check_result']:checked").val("");//初审通过后清空初审的状态
				$('#applyfor_limit').numberbox('setValue', applyfor_limit);
				//显示初审时的授信额度
				$('#second_check_loan_limit').numberbox('setValue', applyfor_limit);//初审额度,设置在复审框上
				
			}
			
			//终审的时候隐藏初审、复审
			if(check_flag==5){
				$("#checkApply_type").text("终审");
				$("#first_checked").hide();
				$("#second_checked").hide();
				var strtime = limit_validity_time.substring(0,10);//截取时分秒
				$('#limit_validity_time').datebox('setValue', strtime);//额度有效期显示
				var check_result =  $("input[name='check_result']:checked").val("");//初审通过后清空初审的状态
				//为了日志的展示
				$('#applyfor_limit').numberbox('setValue', applyfor_limit);
				$('#second_check_loan_limit').numberbox('setValue', second_check_loan_limit);
				$('#loan_limit').numberbox('setValue', second_check_loan_limit);//复审额度,设置在终审框上
				
			}
			
			//回显数据
			YiYa.ajaxJson('../userManager/userFindUsrInfo_2.do', {'usrinf_id':usrinf_id},function(data){
				if(data.success){
				    $.getScript(config.siteurl + "/images/upload/upload.js");
				    //给usrid赋值
				    $("#usrid").val(data.tabUsrinf.usrid);
				    //基本信息赋值
				    setBaseInfo(data);
					//身份证信息赋值
				    setCreditCardPic(data);
				    //联系人赋值
				    setRelation(data,1);
					//其它增信资料赋值
					setOtherPic(data);
					//补充资料赋值
					setComplementInfo(data);
					//小视科技资料显示
					setXiaoShiInfo(data);
					//属性的可编辑性控制
				    setDisabled(false);
				}	
			}); 
                                                                                                                                                                                                                                                                                 
			//审核日志列表   
			$('#checkLog_detail_list').datagrid({
				width: 940,  
//                height:'auto',     
				height:400,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'checkLog_dataList.do',
			    queryParams:{  
			    	'usrinf_id' : usrinf_id
                },
			    columns:[[
					{field:'operate_time',title:'操作时间',align:'center',width:150},
			        {field:'operator',title:'操作人',align:'center',width:120},
					{field:'check_result',title:'审核结果',align:'center',width:120,formatter:function(value,row,index){
						if(value == 0){
							return "初始状态";
						}else if(value == 1){
							return "未审核";
//							return "退回初审";
						}else if(value == 2){
							return "初审不通过";
						}else if(value == 3){
							return "初审通过";
						}else if(value == 4){
							return "复审不通过";
						}else if(value == 5){
							return "复审通过";
						}else if(value == 6){
							return "退回初审";
						}else if(value == 7){
							return "终审不通过";
						}else if(value == 8){
							return "终审通过";
						}else if(value == 9){
							return "退回复审";
						}else if(value == 10){
							return "备注";
						}
					}},
					{field:'applyfor_limit',title:'申请授信额度',align:'center',width:120},
					{field:'second_check_loan_limit',title:'复审额度',align:'center',width:120},
					{field:'loan_limit',title:'终审额度',align:'center',width:120},
					{field:'check_remark',title:'审核意见',align:'center',width:180,formatter:function(value,row,index){
						var html = "<div style='overflow:auto;vertical-align:middle'>"+value+"</div>";
						return html;
					}},
			    ]],

			});
			
		},
		//当前审批人员 
		currentOperator:function(buttonId){
			$("#checkApply-win").hide();
			
			
			var $win;
		    $win = $('#currentOperator-win').window({
		            width: 720,
		            height: 520,
		            top:($(window).height() - 350) * 0.5,   
		            left:($(window).width() - 680) * 0.5,
		            shadow: true,
		            modal:true,
		            iconCls:'icon-add',
		      closed:true,
		      minimizable:false,
		      maximizable:false,
		      collapsible:false
		         });
		    
		    $win.window('open');
			
			
			$('#currentOperator_data_list').datagrid({
				width: 'auto',  
				height:$(window).height()*0.55,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'getSysUsersByButtonId.do',
			    queryParams:{  
                    'buttonId' : buttonId
                },
			    columns:[[
					{field:'real_name',title:'姓名',align:'center',width:700},
			    ]],

			});
			
		},
		//申请记录
		applyRecord:function(usrinf_id){
			$("#checkApply-win").hide();
			$("#applyRecord-win").window("open");
			$('#applyRecord_data_list').datagrid({
				width: 'auto',  
//                height:'auto',     
				height:$(window).height()*0.55,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'applyRecord_dataList.do',
			    queryParams:{  
                    'usrinf_id' : usrinf_id
                },
			    columns:[[
					{field:'apply_time',title:'申请时间',align:'center',width:150},
					{field:'check_result',title:'审核结果',align:'center',width:120,formatter:function(value,row,index){
						if(value == 0){
							return "初始状态";
						}else if(value == 1){
							return "未审核";
						}else if(value == 2){
							return "初审不通过";
						}else if(value == 3){
							return "初审通过";
						}else if(value == 4){
							return "复审不通过";
						}else if(value == 5){
							return "复审通过";
						}else if(value == 6){
							return "退回初审";
						}else if(value == 7){
							return "终审不通过";
						}else if(value == 8){
							return "终审通过";
						}else if(value == 9){
							return "退回复审";
						}
					}},
					{field:'applyfor_limit',title:'授信额度',align:'center',width:120},
					{field:'check_remark',title:'审核意见',align:'center',width:180},
			    ]],

			});
			
		},
		//审核日志
		checkRecord:function(usrinf_id){
			$("#checkApply-win").hide();
			$("#checkRecord-win").window("open");
			$("#checkLogComment2_usrinf_id").attr("value",usrinf_id);
			$('#checkRecord_data_list').datagrid({
				width: 940,  
//                height:'auto',     
				height:300,
                striped: true,
                pagination: true,
                singleSelect:true,//仅支持单选
			    url:'checkLog_dataList.do',
			    queryParams:{  
			    	'usrinf_id' : usrinf_id
                },
			    columns:[[
					{field:'operate_time',title:'操作时间',align:'center',width:150},
			        {field:'operator',title:'操作人',align:'center',width:100},
					{field:'check_result',title:'审核结果',align:'center',width:120,formatter:function(value,row,index){
						if(value == 0){
							return "初始状态";
						}else if(value == 1){
							return "未审核";
//							return "退回初审";
						}else if(value == 2){
							return "初审不通过";
						}else if(value == 3){
							return "初审通过";
						}else if(value == 4){
							return "复审不通过";
						}else if(value == 5){
							return "复审通过";
						}else if(value == 6){
							return "退回初审";
						}else if(value == 7){
							return "终审不通过";
						}else if(value == 8){
							return "终审通过";
						}else if(value == 9){
							return "退回复审";
						}else if(value == 10){
							return "备注";
						}
					}},
					{field:'applyfor_limit',title:'申请授信额度',align:'center',width:120},
					{field:'second_check_loan_limit',title:'复审额度',align:'center',width:120},
					{field:'loan_limit',title:'终审额度',align:'center',width:120},
					{field:'check_remark',title:'审核意见',align:'center',width:180,formatter:function(value,row,index){
						var html = "<div style='overflow:auto;vertical-align:middle'>"+value+"</div>";
						return html;
					}},
			    ]],

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
				url      : "../userManager/queryzhengxin_info.do",
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
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'usrid',title:'用户ID',align:'center',width:120,sortable:true},
						{field:'usrname',title:'真实姓名',align:'center',width:120,sortable:true},
						{field:'mobile_phone',title:'手机号',align:'center',width:120,sortable:true},
						{field:'applyfor_time',title:'申请授信时间',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							var html = "";
							html = row.applyfor_time;
							if(html!=null && html!=""){
								html = html.substring(0,10);
							}
							return html;
						}},
						{field:'check_flag',title:'状态',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							if(value == 0){
								return "初始状态";
							}else if(value == 1){
								return "待初审";
							}else if(value == 2){
								return "初审不通过";
							}else if(value == 3){
								return "待复审";
							}else if(value == 4){
								return "复审不通过";
							}else if(value == 5){
								return "复审通过";
							}else if(value == 7){
								return "终审不通过";
							}else if(value == 8){
								return "终审通过";
							}
						}},
						{field:'loan_limit',title:'授信额度',align:'center',width:120,sortable:true},
						{field:'limit_validity_time',title:'当前额度有效期',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							var html = "";
							html = row.limit_validity_time;
							if(html!=null && html!=""){
								html = html.substring(0,10);
							}
							return html;
						}},
						{field:'putStockList',title:'审核操作',width:250,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							var applyfor_limit=0.00;
							var second_check_loan_limit=0.00;
							if(row.applyfor_limit!=null&&typeof(row.applyfor_limit) != "undefined"){
								applyfor_limit = row.applyfor_limit;
							}
							if(row.second_check_loan_limit!=null&&typeof(row.second_check_loan_limit) != "undefined"){
								second_check_loan_limit = row.second_check_loan_limit;
							}
							if(row.first_veriy_auth){//初审权限
								if(row.check_flag==1){//可以进入初审
									html +="<a href='#' onclick='YiYa.creditCheck.checkApply("+row.usrinf_id+","+row.check_flag+","+applyfor_limit+","+second_check_loan_limit+")'>初审</a> | ";
								}
							}
							if(row.second_veriy_auth){//复审权限
							    if(row.check_flag==3){ //可以进入复审
									html +="<a href='#' onclick='YiYa.creditCheck.checkApply("+row.usrinf_id+","+row.check_flag+","+applyfor_limit+","+second_check_loan_limit+",\""+row.limit_validity_time+"\","+100+")'>复审</a> | ";
								}
							}
							if(row.final_veriy_auth){//终审权限
							    if(row.check_flag==5){ //可以进入复审终审
									html +="<a href='#' onclick='YiYa.creditCheck.checkApply("+row.usrinf_id+","+row.check_flag+","+applyfor_limit+","+second_check_loan_limit+",\""+row.limit_validity_time+"\","+100+")'>终审</a> | ";
								}
							}
							
							if(row.credit_info_veriy_auth){
								html +="<a href='#' onclick='YiYa.creditCheck.zhengxin_info("+row.usrinf_id+")'>征信资料</a> | ";
							}
							html +="<a href='#' onclick='YiYa.creditCheck.applyRecord("+row.usrinf_id+")'>申请记录</a> |";
							html +="<a href='#' onclick='YiYa.creditCheck.checkRecord("+row.usrinf_id+")'>审核日志</a> |";
							if(row.check_flag==1){
								//初审按钮ID为28
								html +="<a href='#' onclick='YiYa.creditCheck.currentOperator("+28+")'>当前审批人员</a> | ";
							}else if(row.check_flag==3){
								//复审按钮ID为34
								html +="<a href='#' onclick='YiYa.creditCheck.currentOperator("+34+")'>当前审批人员</a> | ";
							}else if(row.check_flag==5){
								//终审按钮ID为36
								html +="<a href='#' onclick='YiYa.creditCheck.currentOperator("+36+")'>当前审批人员</a> | ";
							}
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

$(function(){
	YiYa.creditCheck.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		