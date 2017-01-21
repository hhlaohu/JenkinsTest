

//查询订单相关信息
function getUsrOrderList(usrid){
	$('#userBorrowInfoList').datagrid({
		width: 1305,
		height:360,
        striped: true,
        rownumbers:false,
        pagination: false,
        singleSelect: true,
	    url:'../userManager/getOrderListByUsrid.do',
	    queryParams:{  
	    	'borrow_uid':usrid
        },
		columns:[[
                    {field:'store_contract',title:'商家联系人',align:'center',hidden:true},
                    {field:'store_tel',title:'商家电话',align:'center',hidden:true},
                    {field:'store_name',title:'商家名称',align:'center',hidden:true},
                    {field:'amortization_money',title:'每期还款',align:'center',hidden:true},
                    {field:'order_sn',title:'订单号',align:'center',width:1300/6},
					{field:'create_time',title:'申请时间',align:'center',width:1300/6},
					{field:'order_source',title:'渠道',align:'center',width:1300/6,formatter:function(value,row,index){
                        if(value == 0){
                        	return "秒赊";
                        }else if(value == 1){
                        	return "链金所";
                        }
						return value;
					}},
					{field:'order_money',title:'借款金额',align:'center',width:1300/6,sortable:true},
					{field:'amortization_cnt',title:'借款时长',align:'center',width:1300/6,sortable:true,formatter:function(value,row,index){
                         return value+"个月";							
					}},
					{field:'putStockList',title:'操作',align:'center:',width:1300/6,formatter:function(value,row,index){
						 var html = "<a href='#' style='color:blue' onclick='checkOrderInfo("+index+")'>查看</a>";
                         return html;							
					}}
		]],
		onLoadSuccess: function(data){
			if(data.total==0){
				return;
			}
        }
	});
}


//查看订单信息
function checkOrderInfo(index){
	  var row = $("#userBorrowInfoList").datagrid("getRows")[index];
	  $("#borrowDetail").insertAfter("#userBorrowInfoForm");
	  $("#borrowDetail").show();
	  $("#order_title").html("订单号："+ row.order_sn);
	  //如果是来自秒赊，则查询订单信息
	  if(row.order_source==0){
		  YiYa.ajaxJson('../userManager/getOrderPicByOrderSn.do', {'order_sn':row.order_sn},function(data){
		      if(data.success){
		    	  $("#order_pic").html("<div id='order_pic_div'></div>");
		    	  $.each(data.picList,function(i,data){
		    		  $("#order_pic_div").append("<img src='"+data.pic_addr +"' style='cursor: pointer; width: 180px; height: 150px;' />");
		    	  });
		    	  $("#biddingPrefix").html(data.bidprefix);
		    	  $('#order_pic_div').viewer();
		    	  $("#borrowInfo").show();
		    	  setOrderInfo(row);
		      }
			});
	  }else{
		  $("#borrowInfo").hide();
	  }
	  setUsrinfo(null, row.order_sn);
}

//给订单信息模块赋值
function setOrderInfo(row){
	$("#order_sn").html(row.order_sn);
	$("#store_contract").html(row.store_contract);
	$("#store_tel").html(row.store_tel);
	$("#store_name").html(row.store_name);
	$("#order_money").html(row.order_money+"元");
	$("#amortization_money").html(row.amortization_money);
	$("#amortization_cnt").html(row.amortization_cnt+"个月");
}

/**给用户基本信息页面赋值*/
function setUsrinfo(usrinf_id,orderid){
	
	if(usrinf_id != null){
		//回显数据
		YiYa.ajaxJson('userFindUsrInfo_2.do', {'usrinf_id':usrinf_id},function(data){
			if(data.success){
				$("#usrid").val(data.tabUsrinf.usrid);
				$("#usrname").html(data.tabUsrinf.usrname);
				$("#id_card").html(data.tabUsrinf.id_card);
				$("#mobile_phone").html(data.tabUsrinf.mobile_phone);
			}
		}); 
		
	}else{
		//回显数据
		YiYa.ajaxJson('../userManager/getUserInfoRelateOrder.do', {'order_id':orderid},function(data){
			if(data.success){
				//基本信息赋值
			    setBaseInfo(data);
				//身份证信息赋值
			    setCreditCardPic(data);
			    //联系人赋值
			    setRelation(data,false);
				//小视科技资料显示
				setXiaoShiInfo(data);
				//属性的可编辑性控制
			    setDisabled(false);
			  }
			});
	}
}