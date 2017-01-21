$package('YiYa.borrowManager');
YiYa.borrowManager = function(){
	var _box = null;
	var _this = {
			initForm:function(){
				$("#borrowCheckRecord-cancel").click(function(){
					$("#borrowCheckRecord-win").window("close");
				});
				$("#memberInfo-cancel").click(function(){
					$("#memberInfo-win").window("close");
				});
				$("#updateBiddingBack").click(function(){
					$("#updateBidding-win").window("close");
				});
				$("#modifyAddTime-cancel").click(function(){
					$("#modifyAddTime-win").window("close");
				});

				$("#isCancel").click(function(){
					if($('#isCancel').attr('checked')){
						$('#new-add-time').add("#new-add-time-div .validatebox-text").attr('disabled','disabled');
						$("#new-add-time-div .combo-arrow").hide();
					}else{
						$('#new-add-time').add("#new-add-time-div .validatebox-text").removeAttr('disabled');
						$("#new-add-time-div .combo-arrow").show();
					}
				});
			
				$("#btn-search-store").click(function(){
					btn_search_store();
				});
				
				$("#is_tocard2").click(function(){
					var usrid = $("#borrow_uid").val();
					var param = "usrid="+usrid;
					 YiYa.ajaxJson('../borrowList/isBindBankCard.do', param,function(data)
						{
							if(data.code==-1)
							{
								YiYa.alert('提示', "借款人没有绑卡，请通知用户去新浪帮卡",'info');
								$("#is_tocard").attr("checked","checked");
								return;
							}
						});
				});
				
		
			//修改或取消发标
			$("#confirmModifyAddTime").click(function(){
				
				var param = new Object();
				param.new_add_time = $('#new-add-time').datetimebox('getValue');
				param.bidding_id = $('#bidding-id').text();
				param.check_remark = $.trim($("#cancelReason").val());
				
				
				if(!$('#isCancel').attr('checked')){
					//修改发标
					if($.trim($('#new-add-time').datetimebox('getValue')) == ""){
						YiYa.alert("提示","新发布时间不能为空","info");
						return;
					}
					var currentTime = new Date();
					var newAddTime = new Date($('#new-add-time').datetimebox('getValue').replace("-", "/"));
					
					if( newAddTime  < currentTime){
						YiYa.alert("提示","不能小于当前系统时间","info");
						return;
					}
					
					$.ajax({										
						url     : "../borrowList/modifyBiddingTime.do",
						type    : "POST",
						cache   : false,	
						data	: param,
						success : function(data){
						   if(data.code==0){
							   YiYa.alert("提示","修改成功","info");  
							   $("#modifyAddTime-win").window("close");
							   $("#data-list").datagrid("reload",{});
						   }else{
							   YiYa.alert("提示",data.msg,"info");
						   }
						}
					});
				}else{//取消发标
					if($.trim($("#cancelReason").val()) == ""){
						YiYa.alert("提示","原因不能为空","info");
						return;
					}
					$.ajax({										
						url     : "../borrowList/cancelBidding.do",
						type    : "POST",
						cache   : false,	
						data	: param,
						success : function(data){
						   if(data.code==0){
							   YiYa.alert("提示","成功取消","info");  
							   $("#modifyAddTime-win").window("close");
							   $("#data-list").datagrid("reload",{});
						   }else{
							   YiYa.alert("提示","无法取消，原因："+data.msg,"info");
						   }
						}
					});
					
				}
			});
			
        	$.each($("input[name=borrow_status]"), function(index) {
       	     //这里就是对单选按钮的单击事件，需要一个each，遍历出所有的radio,然后对每个radio绑定一个click
       	      $(this).click(function() {
       	    	  if(this.value == 1) {
       	    		  $("#add_time").datetimebox({ disabled: true });
       	    	  }else if (this.value == 2){
       	        	  $("#add_time").datetimebox({ disabled: false });
       	    	  }
       	      });
        	});
        	
        	//绑定图片下载按钮点击事件
        	$("#downloadOrderPic").click(function(){
        		var order_sn = $("#order_id").val();
        		var dataArray = {'order_sn':order_sn};
                YiYa.ajaxJson('../borrowList/getUserOrderPicUrl.do',dataArray,function(data){
                	if(data.code == 0){
                		var picPath = data.resultText.picPath;
                		var picArray = picPath.split("|");
                		window.location.href='../file/downloadFile.do?urlString='+picArray; //下载基本类型图片
					}else{
						alert("订单照片不存在");
					}
				}); 
        	});
        	
			//绑定借款审核按钮点击事件
			$("#updateBiddingStatus").click(function(){
				var deal_user = $("#deal_user").val(); //标的审核人id
				var borrow_uid = $("#borrow_uid").val();
				var bidding_id = $("#bidding_id").val();
	        	var borrow_status = $("#biddingForm_info input[name='borrow_status']:checked").val();
	        	var is_tocard = $("#biddingForm_info input[name='is_tocard']:checked").val();
	        	var check_remark = $.trim($("#check_remark").val());
	        	var product_type = $("input[name=product_type]").val();
	        	var order_id = $("#order_id").val();
	        	var borrowInfoEditor = CKEDITOR.instances["borrow_info"];
				var borrow_info = borrowInfoEditor.getData();
	        	var add_time = $("#add_time").datetimebox('getValue');
	        	var borrow_use = $("#borrow_use").val();
	        	//打码图片
	        	var add_image_list = "";
				$("#picTd").find("img").each(function(){
					add_image_list += ($(this).attr("src")+"|");
				});
	        	
				//必输项校验
				//分期购校验是否上传了打码图片
	        	if(product_type == 5 && add_image_list == "" && borrow_status == 2){
	        		YiYa.alert('提示',"请上传打码图片",'info');
	        		return;
	        	}
	        	if(borrow_status==2&&add_time==""){
	        		YiYa.alert('提示',"请设置发标时间！",'info');
	        		return;
	        	}
	        	if(check_remark==""){
	        		YiYa.alert('提示',"请输入审核意见,限制50字！",'info');
	        		return;
	        	}else if(check_remark!=""&&(strlen(check_remark)>100)){
	        		YiYa.alert('提示',"审核意见超过限制的50字，请重新输入！",'info');
	        		return;
	        	}
	        	var dataArray={
						'bidding_id':bidding_id,
						'borrow_status':borrow_status,
						'add_time':add_time,		
						'deal_user':deal_user,
						'check_remark':check_remark,
						'order_id':order_id,
						'borrow_uid':borrow_uid,
						'borrow_info':borrow_info,
						'borrow_use':borrow_use,
						'is_tocard':is_tocard,
						'add_image_list':add_image_list
				};
				$.ajax({										
					url     : "../borrowList/setBiddingStatus.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
						if(data.code==0){
							alert("操作成功");
							window.location.href = config.siteurl+"/borrowList/list.shtml";
						}else{
							YiYa.alert('提示',data.msg,'info');
						}
					},
				});
			});

//---------------------------------------------------------标签显示初始化-------------------------------------------
			//显示订单详情
			$(".tab_menu li:eq(1)").click(function(){
				var order_id = $("#order_id").val();
				$("#borrowDetail").appendTo("#applyInfoDiv");
				 YiYa.ajaxJson('../userManager/getOrderPicByOrderSn.do', {'order_sn':order_id},function(data){
				      if(data.success){
				    	  $("#order_pic").html("<div id='order_pic_div'></div>");
				    	  $.each(data.picList,function(i,data){
				    		  $("#order_pic_div").append("<img src='"+data.pic_addr +"' style='cursor: pointer; width: 180px; height: 150px;' />");
				    	  });
				    	  $("#biddingPrefix").html(data.bidprefix);
				    	  $('#order_pic_div').viewer();
				    	  $("#borrowInfo").show();
				    	  $("#borrowDetail").show();
				    	  setOrderInfo(data.tabUsrOrder);
				    	  setUsrinfo(null, order_id);
				      }
					});
			});
			//显示评分报告
			$(".tab_menu li:eq(3)").click(function(){
				$("#scoringReport").show();
				queryScoringList($("#usrid").val(),false);
			});
			//显示借款信息
			$(".tab_menu li:eq(4)").click(function(){
				$("#userBorrowInfo").show();
				$("#borrowDetail").hide();
				getUsrOrderList($("#usrid").val());
			});
		},
		//审核
		checkBorrow:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			if (row){
				var borrow_type = row.borrow_type;
				var check_remark = row.check_remark;
				var order_id = row.order_id;
				var borrow_info = row.borrow_info;
				var borrow_interest = row.borrow_interest;//每期手续费
				var borrow_duration = row.borrow_duration;//借款期限
				var warehousing =row.warehousing;
				var borrow_uid = row.borrow_uid;
				var total_borrow_interest;
				if(null==borrow_interest){
					borrow_interest=0;
				}
				if(null==borrow_duration){
					borrow_duration = 0;
				}
				total_borrow_interest = borrow_interest*borrow_duration;//总手续费
				if(null==borrow_type||typeof(borrow_type) == "undefined"){
					borrow_type="";
				}
				if(null==check_remark||typeof(user_type) == "undefined"){
					check_remark="";
				}
				if(null==order_id||typeof(order_id) == "undefined"){
					order_id="";
				}
				if(null==borrow_info||typeof(borrow_info) == "undefined"){
					borrow_info="";
				}
				if(null==warehousing||typeof(warehousing) == "undefined"){
					warehousing = "";
				}
				YiYa.ajaxJson('../borrowList/getCreditInformation.do', {'borrow_uid':row.borrow_uid},function(data){
					var credit_report_pic="";
					if(data.code == 0&&data.resultText.credit_report_pic!=null&&data.resultText.credit_report_pic!="null"){
						credit_report_pic = data.resultText.credit_report_pic;
					 }
					window.location.href='borrowCheck.shtml?bidding_id='+row.bidding_id +'&borrow_uid='+ row.borrow_uid+'&hrefType=1';
					});
			}else{
				YiYa.alert('提示',"请选择要审核的行!",'info');
			}
		},
        //跳转至标的信息修改页面
		modifyBiddingInfo:function(index){
			var row = $("#data-list").datagrid("getRows")[index];
			window.location.href='borrowCheck.shtml?bidding_id='+row.bidding_id 
			+'&borrow_uid='+ row.borrow_uid + '&hrefType=2';
		},
		//查看
		showDetail:function(index){
			$("#borrowCheckRecord-win").window("open");
			var row = $("#data-list").datagrid("getRows")[index];
			var array = row.check_remark_dataList;
			var html = "";
			$.each($(row.check_remark_dataList),function(i,data){
				html += '<tr>'+
				'    				     <td>'+
				'					     <table id="borrowCheckRecord_data_list" class="tbBaseInfo5" width="98%"> '+
				'					            <tr>'+
				'					            	<th>处理时间：</th>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.deal_time_date+'</p>'+
				'			                        </td>'+
				'					            </tr>'+
				'						     <tr>'+
				'						     		<th>操作人：</th>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.deal_user+'</p>'+
				'			                        </td>'+
				'						     </tr>'+
				'						      <tr>'+
				'						     		<th>操作： </th>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text">'+data.operation+'</p>'+
				'			                        </td>'+
				'						     </tr>'+
				'						     <tr>'+
				'					            	<th>发标时间：</th>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.borrow_add_time_date+'</p>'+
				'			                        </td>						     '+
				'						     </tr>'+
				'						     <tr>'+
				'						            <th>处理意见： </th>'+
				'					            	<td>'+
				'			                               <p class="easyui-validatebox member-input" type="text" >'+data.deal_info+'</p>'+
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
		},
		//修改
		modifyAddTime:function(bidding_id,original_add_time,check_remark){
			$("#orignal-addTime").text(original_add_time);
			$("#bidding-id").text(bidding_id);
			$("#check-remark").text(check_remark);
			$("#modifyAddTime-win").window("open");
			
		},
		//会员资料
		showMemberInfo:function(usrid,borrow_realname,loan_useble){
			$.ajax({										
				url     : "../borrowList/getUsrccfaxInf.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {'usrid':usrid},
				success : function(result){
					if(result.code==0){
						$("#memberInfo-win").window("open");
						var data = result.resultText;
						$("#borrow_userName").text(borrow_realname);
						$("#loan_useble").text(loan_useble);
						var user_regtype_desc;
						if(data.usrccfaxInf.user_regtype==1){
							user_regtype_desc = "个人";
						}else if(data.usrccfaxInf.user_regtype==2){
							user_regtype_desc = "企业";
						}else{
							user_regtype_desc ="";
						}
						$("#user_regtype").text(user_regtype_desc);
						
						var is_vip_desc;
						if(data.usrccfaxInf.is_vip==0){
							is_vip_desc = "投资人";
						}else if(data.usrccfaxInf.is_vip==1){
							is_vip_desc = "借款人";
						}else{
							is_vip_desc ="";
						}
						$("#is_vip").text(is_vip_desc);
						$("#recommend_name").text(data.usrccfaxInf.recommend_name);
						$("#real_name").text(data.usrccfaxInf.real_name);
						var idcard = data.usrccfaxInf.idcard;
						var user_email = data.usrccfaxInf.user_email;
						var user_phone = data.usrccfaxInf.user_phone;
						var user_type = data.usrccfaxInf.user_type;
						if(idcard==""||typeof(idcard) == "undefined"){
							idcard=="";
							$("#id_card_ifExist").hide();
						}else{
							$("#id_card_ifExist").show();
						}
						if(user_email==""||typeof(user_email) == "undefined"){
							user_email=="";
							$("#email_ifExist").hide();
						}else{
							$("#email_ifExist").show();
						}
						if(user_phone==""||typeof(user_phone) == "undefined"){
							user_phone=="";
							$("#phone_ifExist").hide();
						}else{
							$("#phone_ifExist").show();
						}
						if(user_type==""||user_type=="1"||typeof(user_type) == "undefined"){
							$("#vip_ifExist").hide();
						}else{
							$("#vip_ifExist").show();
						}
						$("#idcard").text(idcard);
						$("#user_email").text(user_email);
						$("#user_phone").text(user_phone);
					}else{
						YiYa.alert('提示',result.msg,'info');
						
					}
				},
			});
			
			
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
  				singleSelect:true,
	   			url:'dataList.do',
	   			columns:[[
	   			        {field:'id',checkbox:true}, 
						{field:'borrow_uid',title:'用户ID',align:'center',width:120,sortable:true},
						{field:'borrow_realname',title:'借款人',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							var html = "";
							html +="<a href='#' onclick='YiYa.borrowManager.showMemberInfo("+row.borrow_uid+",\""+row.borrow_realname+"\",\""+row.loan_useble+"\")'>"+row.borrow_realname+"</a>";
							return html;
						}},
						{field:'tmpbidding_id',title:'标号名',align:'center',width:120,sortable:true},
						{field:'bidding_id',title:'标号ID',align:'center',width:120,sortable:true},
						{field:'product_type',title:'借款种类',align:'center',width:80,sortable:true,formatter:function(value,row,index){
							if(value == 1){
								return "提单质押";
							}else if(value == 2){
								return "提单转现货";
							}else if(value == 3){
								return "现货";
							}else if(value == 4){
								return "生产金融";
							}else if(value == 5){
								return "分期购";
							}else if(value == 6){
								return "信金链";
							}else if(value == 7){
								return "优金链";
							}else if(value == 8){
								return "保金链";
							}
						}},
						{field:'borrow_name',title:'借款名称',align:'center',width:180,sortable:true},
						{field:'borrow_money',title:'借款金额',align:'center',width:120,sortable:true},
						{field:'deal_time_descDate',title:'提交时间',align:'center',width:150,sortable:true},
						{field:'borrow_duration_txt',title:'借款期限',align:'center',width:80,sortable:true},
						{field:'borrow_interest',title:'每期手续费(元)',align:'center',width:120,sortable:true},
						{field:'repayment_type',title:'还款方式',align:'center',width:180,sortable:true,formatter:function(value,row,index){
							if(value == 1){
								return "按天计息，一次性还本付息";
							}else if(value == 2){
								return "等额本息";
							}else if(value == 3){
								return "按季分期还款";
							}else if(value == 4){
								return "每月还息到期还本";
							}else if(value == 5){
								return "一次性还款";
							}else if(value == 6){
								return "利息复投";
							}else if(value == 7){
								return "等额本金";
							}else{
								return "";
							}
						}},
						{field:'add_time_descDate',title:'发标时间',align:'center',width:150,sortable:true},
						{field:'borrow_status',title:'审核状态',width:80,align:'center',sortable:true,formatter:function(value,row,index){
							if(value == 0){
								return "待审核";
							}else if(value == 1){
								return "初审失败";
							}else if(value == 2){
								return "初审通过";
							}else if(value == 4){
								return "满标";
							}else if(value == 5){
								return "复审失败";
							}else if(value == 6){
								return "复审成功";
							}else if(value == 7){
								return "还款完成";
							}else if(value == 8){
								return "已初审未发标";
							}
						}},
						{field:'putStockList',title:'操作',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html = "";
							var borrow_type = row.borrow_type;
							var check_remark = row.check_remark;
							var order_id = row.order_id;
							var borrow_info = row.borrow_info;
							var borrow_interest = row.borrow_interest;
							var borrow_use = row.borrow_use;
							if(null==borrow_interest){
								borrow_interest="";
							}
							if(null==borrow_type||typeof(borrow_type) == "undefined"){
								borrow_type="";
							}
							if(null==check_remark||typeof(check_remark) == "undefined"){
								check_remark="";
							}
							if(null==order_id||typeof(order_id) == "undefined"){
								order_id="";
							}
							if(null==borrow_info){
								borrow_info="";
							}
							if(row.veriy_auth&&row.borrow_status==0){
								html +="<a href='#' onclick='YiYa.borrowManager.checkBorrow("+index+")'>审核</a> | ";
							}
							if(row.modify_bidding_auth&&row.borrow_status==0){
								if(row.borrow_use != 9 && row.borrow_use != 4 && row.borrow_use != 8){
									html +="<a href='#' onclick='YiYa.borrowManager.modifyBiddingInfo("+index+")'>修改发标信息</a> | ";
								}
							}
							html +="<a href='#' onclick='YiYa.borrowManager.showDetail("+index+")'>查看</a>";
							//修改发标时间，分期购独有
							if(row.veriy_auth && row.borrow_status==8){
								html +="<a href='#' onclick='YiYa.borrowManager.modifyAddTime(\""+row.bidding_id+"\",\""+row.add_time_descDate+"\",\""+row.check_remark+"\")'>  | 修改发标时间</a>";
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
	YiYa.borrowManager.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});

//获取购买记录里的所有店铺
function initStore_name(){
	$("#store").combobox({
		editable: true,
		url:'../borrowList/getOrderStoreList.do',
		valueField:'store_id',
		textField:'store_name',
		formatter:function(row){
			var opts = $(this).combobox('options');
			return row[opts.textField];
		}
	});
}

//显示购买记录页面
function showPurchaseRecordPage(borrow_uid,store_id){
//	var order_id = $("#orderId").val();
//	var order_id="1608190550399534";
//	var store_id="150";
//	var store_id = $('#store').combobox('getValue');
	$('#buyGoodsList').datagrid({
		width: $(window).width()*0.8,
		height:$(window).height()*0.6,
        striped: true,
        pagination: true,
	    url:'../borrowList/purchaseRecord.do',
	    queryParams:{  
	    	'borrow_uid':borrow_uid,
	    	'store_id':store_id
        },
		columns:[[
					{field:'borrow_uid',title:'用户ID',align:'center',hidden:true},
					{field:'goods_id',title:'商品id',align:'center',hidden:true},
					{field:'test',title:'商品名',align:'center',width:350,sortable:true,formatter:function(value,row,index){
						html ="               <div style='float:left'>"+
						"                       <img class='div_show_img js-showImg' data-rel='"+row.goods_image_url+"' src='"+row.goods_image_url+"'style='cursor: pointer;width:100px; height:100px;display: inline;' original='../images/grey.gif'/>"+
						"                     </div>"+
						"                     <div style='display:block;text-align:left;padding-top:15px'>  "+
						"                      	<span style='display:block'>"+row.goods_name+"</span>"+
						"                      	<span style='display:block;padding-top:10px'>规格:&nbsp&nbsp"+row.goods_spec_desc+"</span>"+
						"                      	<span style='display:block;padding-top:10px'>单价:&nbsp&nbsp"+row.goods_price+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"x"+row.goods_num+"</span>"+
						"                     </div>";
						return html;
					}},
//					{field:'goods_num',title:'数量',align:'center',width:120,sortable:true},
//					{field:'goods_price',title:'单价(元)',align:'center',width:120,sortable:true},
					/*{field:'spec_name_desc',title:'规格',align:'center',width:120,sortable:true},*/
//					{field:'goods_spec_desc',title:'规格值',align:'center',width:120,sortable:true},
					{field:'gc_name',title:'类目',align:'center',width:180,sortable:true},
					{field:'material',title:'材质',align:'center',width:120,sortable:true},
					{field:'store_name',title:'店铺',align:'center',width:150,sortable:true},
					{field:'add_time_desc',title:'下单时间',align:'center',width:150,sortable:true},
					{field:'goods_total_price',title:'总价(元)',align:'center',width:120,sortable:true},
					{field:'payment_name',title:'支付类型',align:'center',width:112,sortable:true}
		]],
		onLoadSuccess: function(data){
			if(data.total==0){
				return;
			}
        }

	});
}

//指定列求和
function compute(colName) {
    var rows = $('#buyOrderList').datagrid('getRows');
    if(rows.length>0){
    	var total = 0;
    	if(colName=="shipping_fee"){
    		total = parseFloat(rows[0][colName]);
    		return total.toFixed(2);
    	}else{
    		for (var i = 0; i < rows.length; i++) {
    			total += parseFloat(rows[i][colName]);
    		}
    	}
    	return total.toFixed(2);
    }else{
    	return 0;
    }
}

//查询同一店铺购买的同类商品
function btn_search_store(){
	var store_id = $('#store').combobox('getValue');
	var borrow_uid = $("#borrow_uid").val();
//	$("#buyGoodsList").datagrid('reload');
	if(store_id==""){
		alert("请选择店铺！");
		return;
	}
	showPurchaseRecordPage(borrow_uid,store_id);
	
}
