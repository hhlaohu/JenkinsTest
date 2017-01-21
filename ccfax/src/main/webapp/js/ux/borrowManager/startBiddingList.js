$package('YiYa.startBiddingList');
YiYa.startBiddingList = function(){
	var _box = null;
	var _this = {
		initForm:function(){
			$("#startBiddingBtn").click(function(e){
				var borrow_uid = $("#usrid").val();
				var borrow_money = $.trim($("#borrow_money").val());
				var borrow_interest_rate = $.trim($("#borrow_interest_rate").val());
				var jiaxi_rate = $.trim($("#jiaxi_rate").val());
				var borrow_use = $.trim($("#borrow_use").val());
				var borrow_use_desc = $("#borrow_use").find("option:selected").text();
				var borrow_duration = $.trim($("#borrow_duration").val());
				var borrow_min = $.trim($("#borrow_min").val());
				var borrow_max = $.trim($("#borrow_max").val());
				var collect_day = $.trim($("#collect_day").val());
				var repayment_type = $.trim($("#repayment_type").val());
				var product_type = $("#product_type").combobox("getValue");
				var danbao = $.trim($("#danbao").val());
				var colligate = $.trim($("#colligate").val());
				var vouch_money = $.trim($("#vouch_money").val());
				var borrow_name = $.trim($("#borrow_name").val());
				var bidding_pwd = $.trim($("#bidding_pwd").val());
				var test;
				if($("#test").attr("checked")){
					test = 1;	
				}else{
					test = 0;
				}
				var byTheDay;
				if($("#byTheDay").attr("checked")){
					byTheDay = true;	
				}else{
					byTheDay = false;
				}
				if(borrow_money == ""){
					alert("借款金额不能为空");
					return;
				}
				if(borrow_interest_rate == ""){
					alert("利率不能为空");
					return;
				}
				if(borrow_use == ""){
					alert("借款用途不能为空");
					return;
				}
				if(borrow_duration == ""){
					alert("借款期限不能为空");
					return;
				}
				if(borrow_min == ""){
					alert("最低投标金额不能为空");
					return;
				}
				if(collect_day == ""){
					alert("标的有效时间不能为空");
					return;
				}
				if(repayment_type == ""){
					alert("还款方式不能为空");
					return;
				}
				if(product_type == ""){
					alert("产品类型不能为空");
					return;
				}
				if(colligate == ""){
					alert("平台综合服务费不能为空");
					return;
				}
				if(danbao != "" && vouch_money == ""){
					alert("担保费用不能为空");
					return;
				}
				if(borrow_interest_rate < 0.05 || borrow_interest_rate > 24){
					alert("利率范围应该限制为0.05%-24%");
					return;
				}
				
                var borrow_infoEditor = CKEDITOR.instances["borrow_info"];
                var borrow_info = borrow_infoEditor.getData();
				
				if($.trim(borrow_infoEditor.getData()) == ""){
					alert("项目阐述不能为空");
					return;
				}
				
				var warehousingEditor = CKEDITOR.instances["warehousing"];
				var warehousing = warehousingEditor.getData();
				var updata = "";
				$("#picTd").find("img").each(function(){
					updata += ($(this).attr("src")+"|");
				});
				var dataArray={
						'borrow_uid':borrow_uid,
						'borrow_money':borrow_money,
						'borrow_interest_rate':borrow_interest_rate,		
						'borrow_use':borrow_use,
						'borrow_duration':borrow_duration,
						'borrow_min':borrow_min,
						'borrow_max':borrow_max,
						'collect_day':collect_day,
						'repayment_type':repayment_type,
						'product_type':product_type,
						'danbao':danbao,
						'colligate':colligate,
						'vouch_money':vouch_money,
						'borrow_name':borrow_name,
						'borrow_info':borrow_info,
						'warehousing':warehousing,
						'updata':updata,
						'byTheDay':byTheDay,
						'jiaxi_rate':jiaxi_rate,
						'test':test,
						'bidding_pwd':bidding_pwd,
						'borrow_use_desc':borrow_use_desc
				};
				setTimeout(function(){
					$("#startBiddingBtn").removeAttr("disabled");
				}, 5000);
				$("#startBiddingBtn").attr("disabled","disabled");
				$.ajax({										
					url     : "../borrowList/setBiddingInf.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
						if(data.code==0){
							alert("发标成功");
							window.location.href = config.siteurl+"/borrowList/startBiddingList.shtml";
						}else{
							alert("发标失败,原因："+data.msg);
						}
					},
				});
			});
			
			//初始化collect_day数据源
			for(var i=0;i<31;i++){
				if(i==0){
					$("#collect_day").append("<option value=''>--请选择--</option>");
				}else{
					$("#collect_day").append("<option value='"+i+"'>"+i+"天</option>");	
				}
			}
			
			$("#byTheDay").click(function(){
				if($("#byTheDay").attr("checked")){
					$("#borrow_duration").empty();
					for(var i=0;i<181;i++){
						if(i==0){
							$("#borrow_duration").append("<option value=''>--请选择--</option>");
						}else{
							$("#borrow_duration").append("<option value='"+i+"'>"+i+"天</option>");	
						}
					}
					$("#repayment_type").val("1");
					$("#repayment_type").attr("disabled","disabled");
				}else{
					$("#borrow_duration").empty();
					for(var i=0;i<13;i++){
						if(i==0){
							$("#borrow_duration").append("<option value=''>--请选择--</option>");
						}else{
							$("#borrow_duration").append("<option value='"+i+"'>"+i+"月</option>");	
						}
					}
					$("#repayment_type").val("");
					$("#repayment_type").removeAttr("disabled");
				}
			});
		},	
		//发布借款
		startBidding:function(usrid,is_vip,id_status,company_status,user_regtype){
			
			if(is_vip==0){
				alert("该用户不是借款人身份，无法发布借款");
				return;
			}
			
			if(user_regtype == 1){
				if(id_status==0){
					alert("该用户还没有进行实名认证，无法发布借款");
					return;
				}
			}else if(user_regtype == 2){
				if(company_status != 3){
					alert("该企业还没有进行实名认证，无法发布借款");
					return;
				}
			}
			
			$("#searchPanel").hide();
			$("#listForm").hide();
			$("#startBiding-win").show();
			$("#usrid").val(usrid);
			$.getScript(config.siteurl + "/js/ux/borrowManager/borrow_manager_upload.js");
		},
		//提升为借款人
		transferToVip:function(usrid,is_vip,id_status,company_status,user_regtype){
			if(is_vip==1){
				alert("该用户已经是借款人");
				return;
			}
			if(user_regtype == 1){
				if(id_status==0){
					alert("该用户还没有进行实名认证，无法提升为借款人");
					return;
				}
			}else if(user_regtype == 2){
				if(company_status != 3){
					alert("该企业还没有进行实名认证，无法提升为借款人");
					return;
				}
			}
			
			$.ajax({										
				url     : "../borrowList/setMemberToVip.do",
				type    : "POST",
				cache   : false,
				data 	: {"is_vip":1,"usrid":usrid},
				success : function(data){
					if(data.code==0){
						alert("操作成功");
						$("#data-list").datagrid('reload',{});
					}else{
						alert("操作失败,原因："+data.msg);
					}
				},
			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
  				singleSelect:true,
	   			url:'getMemberList.do',
	   			columns:[[
	   			        {field:'usrid',checkbox:true}, 
						{field:'is_vip',title:'身份',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							if(value == 0){
								return "投资人";
							}else if(value == 1){
								return "投资人/借款人";
							}
						}},
						{field:'user_name',title:'用户名',align:'center',width:120,sortable:true},
						{field:'user_phone',title:'手机号',align:'center',width:120,sortable:true},
						{field:'real_name',title:'真实姓名',align:'center',width:120,sortable:true},
						{field:'user_regtype',title:'会员类型',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							if(value == 1){
								return "个人";
							}else if(value == 2){
								return "企业";
							}
						}},
						{field:'reg_time_date',title:'注册时间',align:'center',width:140,sortable:true},
						{field:'id_status',title:'个人身份验证状态',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							  if(row.user_regtype == 2){
								 return "";
							  }
							  if(value == 0){
								  return "未认证";
							  }else if(value == 1){
								  return "已认证";
							  }
						}},
						{field:'company_status',title:'企业身份验证状态',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							  if(row.user_regtype == 1){
								 return "";
							  }
							  if(value == 0){
								  return "未认证";
							  }else if(value == 1){
								  return "审核中";
							  }else if(value == 3){
								  return "已认证";
							  }else if(value == 4){
								  return "审核失败";
							  }
						}},
						{field:'putStockList',title:'操作',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							html +="<a href='#' onclick='YiYa.startBiddingList.transferToVip("+row.usrid+","+row.is_vip+","+row.id_status+","+row.company_status+","+row.user_regtype+")'>提升为借款人</a> | ";
							
							html +="<a href='#' onclick='YiYa.startBiddingList.startBidding("+row.usrid+","+row.is_vip+","+row.id_status+","+row.company_status+","+row.user_regtype+")'>发布借款</a>";
							return html;
						}}
				]],
			    onLoadSuccess: function(data) { 
					
			    },
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
	YiYa.startBiddingList.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});