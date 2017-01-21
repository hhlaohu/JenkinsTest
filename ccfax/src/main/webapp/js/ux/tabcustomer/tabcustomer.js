$package('YiYa.tabcustomer');
YiYa.tabcustomer = function(){
//设置客户下拉选项可编辑，可模糊查询
	
	$('#customer_id').combobox({ 
		editable:true
		}); 
	
	$('#pt_customer_id').combobox({ 
		editable:true
		});
	
	$('#good_level_comment').combobox({ 
		editable:false
		});
	
	var _box = null;
	var goods_id = 0;
	var stock_id = 0;
	var _this = {
		/*editForm:function(){
			return $("#editForm");
		},
		editWin:function(){
			return $("#edit-win");
		},
		editPutStockForm:function(){
			return $("#editPutStockForm");
		},
		editPutStockWin:function(){
			return $("#editPutStock-Win");
		},
		pleditWin:function(){
			return $("#pledit-win");
		},
		pleditForm:function(){
			return $("#pleditForm");
		},*/
		editPutStockFormAction:'save.do',
		getRecordId:'getRecordId.do',
		
		
		//删除商品
		deleteGoods:function(putstock_goods_id,putstock_id){
			goods_id = putstock_goods_id;
			stock_id = putstock_id;
			$("#btn-delPutStockGoods").click(function(result){
				deletePutStockGoods(goods_id,stock_id);
				$(this).dialog('destroy');
			});
			
			$("#btn-plrkGoods").click(function(result){
				//btn-good-plrk(goods_id,stock_id);
				
				_this.pleditForm().form('clear');
				$("#pl_putstock_id").val(stock_id);
				_this.pleditWin().window('open');
				//$(this).dialog('destroy');
			});
		},
		
///
		
	
		
		//putstolist end
		initCombox:function(){
			//获取仓号仓位的联动下拉列表
			$("#area_id").combobox({
				editable: false,
				valueField:'areaId',
				textField:'areaName',
				url:'loadAreaList.do',
				formatter:function(row){
					var opts = $(this).combobox('options');
					return row[opts.textField];
				},
				onSelect:function(record){
					$('#space_id').combobox({
						editable: false,
		                valueField: 'spaceId',
		                textField: 'spaceName',
		                url:'loadSpaceList.do?area_id='+record.areaId,
						onLoadSuccess:function(){
							var data = $('#space_id').combobox('getData');
							$("#space_id ").combobox('select',data[0].spaceId);
						}
		            });
				},
				onLoadSuccess:function(){
					var data = $('#area_id').combobox('getData');
					$("#area_id ").combobox('select',data[0].areaId);
				}

			});
			
			//获取商品下拉列表
			$("#good_id").combobox({
				editable: false,
				url:'loadGoodList.do',
//				multiple:true,是否允许多选
				valueField:'good_id',
				textField:'good_name',
				formatter:function(row){
					var opts = $(this).combobox('options');
					return row[opts.textField];
				},
				onLoadSuccess:function(){
					var data = $('#good_id').combobox('getData');
					$("#good_id ").combobox('select',data[0].good_id);
				}
			});
		},
	
		config:{
  			dataGrid:{
  				title:'',
	   			url:'dataList.do',
	   			striped:true,
	   			columns:[[
						//{field:'id',checkbox:true},
						{field:'customer_name',title:'客户姓名',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html ="<a href='#' onclick='getstock("+index+")'>"+value+"</a> ";
							
							//var html ="<a href='#' onclick='editdd("+index+")'>修改</a>";
							return html;
						}},
						{field:'customer_type',title:'客户类型',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html='';
							if(value==0)
							{
								html+='融资客户';
							}
							if(value==1){
								html+='授信客户';
							}
							if(value==2){
								html+='一般客户';
							}
							return html;
						}},
						{field:'credit_limit',title:'授信额度',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;							
							if(typeof(value)=='undefined'||null==value||value==''){
								html=0;
							}
							return html;
						}},
						{field:'break_Stock_value',title:'商品库存折扣总价',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;							
							if(typeof(value)=='undefined'||null==value||value==''){
								html=0;
							}
							return html;
						}},
						{field:'borrow_balance',title:'借款金额',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;				
							if(typeof(value)=='undefined'||null==value||value==''){
								html=0;
							}
							return html;
						}},
						{field:'guarant_balance',title:'为他人担保金额',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;		
							if(typeof(value)=='undefined'||null==value||value==''){
								html=0;
							}
							return html;
						}},
						{field:'rc_guarant_balance',title:'接受担保金额',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;
							if(typeof(value)=='undefined'||null==value||value==''){
								html=0;
							}
							return html;
						}},
						{field:'lock_line',title:'锁止线',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html=value;
						    html=row.borrow_balance+row.guarant_balance-row.rc_guarant_balance;
							return html;
						}},
						{field:'temporary_lock_line',title:'临时锁止线',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html =value;
							if(html==0){
								//alert(html);
								return html;
							}
								
                               if(html==null||html==''){
                            	   html='';
                            	   return html;
                               }
							
							
							if(null==row.start_time||''==row.start_time){
								
								html=value+"<font color='red'>(请设置开始时间)</font>";
							}
							else if(null==row.end_time||''==row.end_time){
								html=value+"<font color='red'>(请设置结束时间时间)</font>";
							}
							
							if(null!=row.start_time&&''!=row.start_time){
								if(null!=row.end_time&&''!=row.end_time){
									if(compareDate(row.start_time,row.end_time)){
										html=value+"<font color='red'>(已过期)</font>";
									}
								}
							}
							
							
							return html;
						}},
						{field:'start_time',title:'临时锁止开始时间',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html =value;
							if(row.temporary_lock_line==0){
								return html;
							}
							if(null==row.temporary_lock_line||''==row.temporary_lock_line){
								html='';
							}
							return html;
						}},
						{field:'end_time',title:'临时锁止结束时间',width:150,align:'center',sortable:true,formatter:function(value,row,index){
							var html =value;
							if(row.temporary_lock_line==0){
								return html;
							}
							if(null==row.temporary_lock_line||''==row.temporary_lock_line){
								html='';
							}
							return html;
						}},
						/*{field:'stock_value',title:'库存商品市值',width:150,align:'center',sortable:true},
						{field:'break_Stock_value',title:'库存商品折后价值',width:150,align:'center',sortable:true},*/
						{field:'putStockList',title:'操作',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html ="<a href='#' onclick='getbj("+index+")'>编辑</a> ";
							
							//var html ="<a href='#' onclick='editdd("+index+")'>修改</a>";
							return html;
						}},
						{field:'dbjebj',title:'担保金额编辑',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html ="<a href='#' onclick='dbjebj("+index+")'>编辑</a> ";
						
							//var html ="<a href='#' onclick='editdd("+index+")'>修改</a>";
							return html;
						}},
						{field:'operatordaill',title:'操作日志',width:120,align:'center',sortable:true,formatter:function(value,row,index){
							var html ="<a href='#' onclick='getOperdaily("+row.customer_id+")'>查看</a> ";				
							//var html ="<a href='#' onclick='editdd("+index+")'>修改</a>";
							return html;
						}}
				]],
				toolbar:[''],
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
//			layer.load(0,{time:2*1000});
		}
	}
	return _this;
}();



$(function(){
	YiYa.tabcustomer.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});

function compareDate(date1,date2){  
	var nowdate = getNowFormatDate().toString(); 
	var oDate1 = date1.toString().substring(0,19);       
	var oDate2 = date2.toString().substring(0,19);

	if(nowdate.localeCompare(oDate1)){
	  if(nowdate.localeCompare(oDate2)<1){
		 return false;  //临时锁止线已过期
	  }
	}
	return true;
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    
    var h=date.getHours();
    if (h >= 1 && h <= 9) {
        h = "0" + h;
    }
    var m=date.getMinutes();
    if (m >= 1 && m <= 9) {
        m = "0" + m;
    }
    var s=date.getSeconds();
    if (s >= 1 && s <= 9) {
        s = "0" + s;
    }
    
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + h + seperator2 + m
           + seperator2 + s;
    return currentdate;
} 
//删除客户备注信息
function deletnote(index){
	var row = $("#customernotedata-list").datagrid("getRows")[index];
	var note_id=row.note_id;
	var customer_id=row.customer_id;
	var dataArray={
			'note_id':note_id,
			'customer_id':customer_id
	};
	$.messager.confirm("提示","确定删除该条信息吗？",function(flag){
		if(flag){
			YiYa.ajaxJson("deletenote.do",dataArray,function(result){
					if(result.msg==1){
						YiYa.alert('提示', '操作成功');		  
						$("#customernotedata-list").datagrid('reload');
						document.getElementById("fk_bzxx").innerText=result.fkbzxx;
					}else{
						YiYa.alert('提示', '操作失败，请与管理员取得联系');
					} 
		});
	}
});
	
}
//删除客户备注信息

//修改客户备注信息

$("#btn-updatenote-submit").click(function(){
	var note_id=document.getElementById("update_note_id").value;
	var note_content=document.getElementById("update_note_content").value;
	var customer_id=document.getElementById("update_customer_id").value;
	
	var dataArray={
		    'customer_id':customer_id,
			'note_id':note_id,
			'note_content':note_content

	};
	
	YiYa.ajaxJson("updatenote.do",dataArray,function(result){
		  if(result.msg==1){
			  YiYa.alert('提示', '操作成功');
			  
			  $("#customernotedata-list").datagrid('reload');
			  document.getElementById("fk_bzxx").innerText=result.fkbzxx;
			  $("#noteupdate-win").window('close');
		  }else{
			  YiYa.alert('提示', '操作失败，请与管理员取得联系');
		  } 
	});
	});

function updatnote(index){
	$("#noteupdateForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#noteupdate-win").window('open');
	var row = $("#customernotedata-list").datagrid("getRows")[index];
	//$("#customer_id").combobox('select',''); 
	var note_id=row.note_id;
	document.getElementById("update_note_id").value=note_id;
	document.getElementById("update_note_content").value=row.note_content;
	document.getElementById("update_customer_id").value=row.customer_id;


}
//修改客户备注信息
//增加客户备注信息
function addcustomernote(){

	//$("#customer_id").combobox('select',''); 
	var customer_id=document.getElementById("stock_customer_id").value;
	var note_content=document.getElementById("note_content").value;	
	var dataArray={
			'customer_id':customer_id,
			'note_content':note_content

	};
	
	YiYa.ajaxJson("addnote.do",dataArray,function(result){
		  if(result.msg==1){
			  YiYa.alert('提示', '操作成功');
			  $("#customernotedata-list").datagrid('reload');
			  document.getElementById("note_content").value='';
			  document.getElementById("fk_bzxx").innerText=result.fkbzxx;
		  }else{
			  YiYa.alert('提示', '操作失败，请与管理员取得联系');
		  } 
	});
}
//增加客户备注信息
//获取客户备注信息
function getcustomernote(){
	$("#customernoteForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#customernote-win").window('open');
	var customer_id=document.getElementById("stock_customer_id").value;
	$('#customernotedata-list').datagrid({
		width: $(window).width()*0.55,
//     height:'auto',     
		height:$(window).height()*0.30,
     striped: true,
     pagination: true,
     singleSelect:true,                           
	    url:'getcustomernote.do',
	    queryParams:{  
         'customer_id' :customer_id   
    },
	    columns:[[
			{field:'note_time',title:'时间',align:'center',width:150},
	        {field:'note_content',title:'内容',align:'center',width:400},
			{field:'note_person',title:'备注人',align:'center',width:150},
			{field:'cz',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				 var html='';
				
		
					 html+="<a href='#' onclick='updatnote("+index+")'>修改</a> | ";
					 html+="<a href='#' onclick='deletnote("+index+")'>删除</a>";
				 return html;
			}}
	    ]],

	    onCheck:function(rowIndex,rowData){ 
 		if(rowData){
 			
 		}
	    },
	    onLoadSuccess:function(result){
	    }
	});
}
function getcustomernotemore(){
	$("#customernotemoreForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#customernotemore-win").window('open');
	var customer_id=document.getElementById("stock_customer_id").value;
	$('#customernotemoredata-list').datagrid({
		width: $(window).width()*0.55,
//     height:'auto',     
		height:$(window).height()*0.48,
     striped: true,
     pagination: true,
     singleSelect:true,                           
	    url:'getcustomernote.do',
	    queryParams:{  
         'customer_id' :customer_id   
    },
	    columns:[[
			{field:'note_time',title:'时间',align:'center',width:150},
	        {field:'note_content',title:'内容',align:'center',width:660},
			{field:'note_person',title:'备注人',align:'center',width:100}
		/*	{field:'cz',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				 var html='';
				
		
					 html+="<a href='#' onclick='updatnote("+index+")'>详情</a>  ";
				 return html;
			}}*/
	    ]],

	    onCheck:function(rowIndex,rowData){ 
 		if(rowData){
 			
 		}
	    },
	    onLoadSuccess:function(result){
	    }
	});
}
//获取客户备注信息结束

//风控备注信息开始

$("#btn-fklsszx-submit").click(function(){
	var stock_id=document.getElementById("fk_stock_id").value;
	var customer_id=document.getElementById("fk_customer_id").value;
	
	//var good_name_comment=document.getElementById("good_name_comment").options[selectIndex].text;//选中的文本
	//var good_name_comment2= document.getElementById("good_name_comment").options[selectIndex].value; //选中的值
	var good_name_comment=$('#good_name_comment').combobox('getValue');
	var good_place_comment=$('#good_place_comment').combobox('getValue');//选中的值
	var good_size_comment=$('#good_size_comment').combobox('getValue');//选中的值
	var good_level_comment=$('#good_level_comment').combobox('getValue');//选中的值
	var dataArray={
		    'customer_id':customer_id,
			'stock_id':stock_id,
			'good_name_comment':good_name_comment,
			'good_place_comment':good_place_comment,
			'good_size_comment':good_size_comment,
			'good_level_comment':good_level_comment

	};
	
	YiYa.ajaxJson("updatefkcomment.do",dataArray,function(result){
		  if(result.msg==1){
			  YiYa.alert('提示', '操作成功');
			  
			  $("#editstockdata-list").datagrid('reload');
			  document.getElementById("fk_bzxx").innerText=result.fkbzxx;
			  $("#fkkhxxedit-win").window('close');
		  }else{
			  YiYa.alert('提示', '操作失败，请与管理员取得联系');
		  } 
	});
	});
function fkxxbj(stockid,customer_id,good_name,good_place,good_level,good_size,good_name_comment,good_place_comment,good_level_comment,good_size_comment){
	
	$("#fkkhxxedit-win").window('open');
	document.getElementById("fkname").innerText=good_name;
	document.getElementById("fkplace").innerText=good_place;
	document.getElementById("fklevel").innerText=good_level;
	document.getElementById("fksize").innerText=good_size;
	document.getElementById("fk_stock_id").value=stockid;
	document.getElementById("fk_customer_id").value=customer_id;
	$("#good_name_comment").combobox('setValue',good_name_comment); 
	$("#good_place_comment").combobox('setValue',good_place_comment);  
	$("#good_level_comment").combobox('setValue',good_level_comment);  
	$("#good_size_comment").combobox('setValue',good_size_comment);  
}

function fkxxbjtwo(index){
	
	$("#fkkhxxedit-win").window('open');
	var row = $("#editstockdata-list").datagrid("getRows")[index];
	document.getElementById("fkname").innerText=row.good_name;
	document.getElementById("fkplace").innerText=row.good_place;
	document.getElementById("fklevel").innerText=row.good_level;
	document.getElementById("fksize").innerText=row.good_size;
	document.getElementById("fk_stock_id").value=row.stock_id;
	document.getElementById("fk_customer_id").value=row.customer_id;
	$("#good_name_comment").combobox('setValue',row.good_name_comment); 
	$("#good_place_comment").combobox('setValue',row.good_place_comment);  
	$("#good_level_comment").combobox('setValue',row.good_level_comment);  
	$("#good_size_comment").combobox('setValue',row.good_size_comment);  
	
}
//风控备注信息结束

//获取仓号库存列表
function stockdetail(index){
	//$("#stockdetailForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#stockdetail-win").window('open');
 
	var row = $("#editstockdata-list").datagrid("getRows")[index];
	
	document.getElementById("stock_detaile_area_name").innerText=row.area_name;
	document.getElementById("stock_detaile_space_name").innerText=row.space_name;
	$('#stockdetail-list').datagrid({
		pageNumber:1,
		pageSize:10,
		width: $(window).width()*0.45,
		height:$(window).height()*0.48,
	    striped: true,
	    pagination: true,
	    singleSelect:true,                           
	    url:'getstockdetail.do',
	    queryParams:{  
       'customer_id' :row.customer_id,
       'area_name' :row.area_name,
       'space_name' :row.space_name
  },
	    columns:[[
			{field:'good_name',title:'商品名',align:'center',width:140},
			{field:'good_place',title:'商品产地',align:'center',width:140},
			{field:'good_level',title:'商品等级',align:'center',width:140,formatter:function(value,row,index){		
			    var	html=value;
			    if(html==1){
			    	html='顶级';
			    }
			    if(html==2){
			    	html='普一';
			    }
			    if(html==3){
			    	html='普二';
			    }
			    if(html==4){
			    	html='统材';
			    }
			    return html;
			}},
			{field:'good_size',title:'商品规格',align:'center',width:140},
			{field:'good_volume',title:'体积(立方米)',align:'center',width:140},
			{field:'good_weight',title:'重量（kg）',align:'center',width:140},
			{field:'market_prices',title:'市场指导价',align:'center',width:140},
			{field:'pledge_multiplier',title:'质押系数',align:'center',width:140},
			{field:'lump_sum',title:'折后总价',align:'center',width:140,formatter:function(value,row,index){
				
			    var	html=row.good_volume*row.market_prices*row.pledge_multiplier;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'market_total_price',title:'市场总价',align:'center',width:140,formatter:function(value,row,index){

			    var	html=row.good_volume*row.market_prices;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'put_success_time',title:'入库成功时间',align:'center',width:140},
		
	    ]],
	    onLoadSuccess:function(result){
	  document.getElementById("stock_detaile_customer_name").innerText=result.Cname;
	    }
	});
}
//获取仓号库存列表结束
//获取库存列表
function getstock(index){
	$("#editstockForm").form('clear');
	$("#good_name").val("");//清空表单值
	$("#good_place").val("");
	$("#good_level").combobox('select',''); 
	$("#good_size").val("");
	$('#start_put_time').datetimebox('setValue', '');
	$('#end_put_time').datetimebox('setValue', '');
	
	$("#editstock-win").window('open');

   
	var row = $("#data-list").datagrid("getRows")[index];
	document.getElementById("stock_customer_name").innerText=row.customer_name;
	document.getElementById("stock_tel").innerText=row.telephone;
	document.getElementById("stock_addr").innerText=row.address;
	var customer_id=row.customer_id;
	$('#editstockdata-list').datagrid({
//		width: '100%',
//     height:'auto',
		pageNumber:1,
		pageSize:10,
		height:$(window).height()*0.45,
     striped: true,
     pagination: true,
     singleSelect:true,                           
	    url:'getstock.do',
	    queryParams:{  
         'customer_id' :customer_id
      
    },
	    columns:[[{field:'id',checkbox:true},
			{field:'area_name',title:'仓号',align:'center',width:140,formatter:function(value,row,index){
			
			 var html='';
				 html+="<a href='#' onclick='stockdetail("+index+")'>"+value+"</a>";
				
			 return html;
		}},
	        {field:'space_name',title:'仓位',align:'center',width:140,formatter:function(value,row,index){
			
			 var html='';
				 html+="<a href='#' onclick='stockdetail("+index+")'>"+value+"</a>";
				
			 return html;
		}},
			{field:'good_name',title:'商品名',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    if(null!=row.good_name_comment&&row.good_name_comment!=''){
		    	html=value+"<font color='red'>("+row.good_name_comment+")</font>";
		    }
		    return html;
		}},
			{field:'good_place',title:'商品产地',align:'center',width:140,formatter:function(value,row,index){
		    var	html=value;
		    var gpc=row.good_place_comment;
		    if(null!=row.good_place_comment&&row.good_place_comment!=''){
		    	if(2468==gpc){
		    		gpc='全部';
		    	}
		    	html=value+"<font color='red'>("+gpc+")</font>";
		    }
		    return html;
		}},
			{field:'good_level',title:'商品等级',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    if(html==1){
		    	html='顶级';
		    }
		    if(html==2){
		    	html='普一';
		    }
		    if(html==3){
		    	html='普二';
		    }
		    if(html==4){
		    	html='统材';
		    }
		    var level=row.good_level_comment
		    if(level==1){
		    	level='顶级';
		    }
		    if(level==2){
		    	level='普一';
		    }
		    if(level==3){
		    	level='普二';
		    }
		    if(level==4){
		    	level='统材';
		    }
		    if(null!=row.good_level_comment&&row.good_level_comment!=0){
		    	if(2468==level){
		    		level='全部';
		    	}
		    	html=html+"<font color='red'>("+level+")</font>";
		    }
		    return html;
		}},
			{field:'good_size',title:'商品规格',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    var gsc = row.good_size_comment;
		    if(null!=row.good_size_comment&&row.good_size_comment!=''){
		    	if(0==gsc){
		    		gsc='全部';
		    		html=value+"<font color='red'>("+gsc+")</font>";
		    	}else{
		    		html = value + "<font color='red'>(" + row.good_size_comment_spec_name + ")</font>";
		    	}
		    	
		    }
		    return html;
		}},
			{field:'good_volume',title:'体积',align:'center',width:140},
			{field:'good_weight',title:'重量',align:'center',width:140},
			{field:'business_pag_no',title:'包号',align:'center',width:140},
			{field:'market_prices',title:'市场指导价',align:'center',width:140},
			{field:'pledge_multiplier',title:'质押系数',align:'center',width:140},
			{field:'lump_sum',title:'折后总价',align:'center',width:140,formatter:function(value,row,index){
				
			    var	html=row.good_volume*row.market_prices*row.pledge_multiplier;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'market_total_price',title:'市场总价',align:'center',width:140,formatter:function(value,row,index){

			    var	html=row.good_volume*row.market_prices;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'put_success_time',title:'入库成功时间',align:'center',width:140},
			{field:'cz',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				
				 var html='';
					 html+="<a href='#' onclick='fkxxbjtwo("+index+")'>修改</a>";
					
				 return html;
			}}
	    ]],
	    toolbar:[{id:'edit',text:'修改',btnType:'edit',iconCls:'icon-edit',handler:function(){

	    	var selected =$('#editstockdata-list').datagrid("getSelections");
			var stockid=selected[0].stock_id;
			var customer_id=selected[0].customer_id;
			var good_name=selected[0].good_name;
			var good_place=selected[0].good_place;
			var good_level=selected[0].good_level;
			var good_size=selected[0].good_size;
			
			var good_name_comment=selected[0].good_name_comment;
			var good_place_comment=selected[0].good_place_comment;
			var good_level_comment=selected[0].good_level_comment;
			var good_size_comment=selected[0].good_size_comment;
			
			fkxxbj(stockid,customer_id,good_name,good_place,good_level,good_size,good_name_comment,good_place_comment,good_level_comment,good_size_comment);
				/*_this.editPwdForm().resetForm();
				_this.editPwdForm().find("input[name='id']").val(selected[0].id);
				_this.editPwdForm().find("input[name='usr_name']").val(selected[0].usr_name);
				_this.editPwdWin().window('open'); */
			
	    }}],
	    onCheck:function(rowIndex,rowData){ 
 		if(rowData){
 			
 		}
	    },
	    onLoadSuccess:function(result){
	    	document.getElementById("stock_customer_name").innerText=row.customer_name;
	    	document.getElementById("stock_tel").innerText=row.telephone;
	    	document.getElementById("stock_addr").innerText=row.address;
	    	document.getElementById("stock_customer_id").value=row.customer_id;
	    	document.getElementById("fk_bzxx").innerText=result.fkbzxx;
	    	if(result.topvolume!=0){
	    		document.getElementById("stock_topvolume").innerText= result.topvolume;
	    	}else{
	    		document.getElementById("stock_topvolume").innerText='';
	    	}
	    	if(result.onevolume!=0){
	    		document.getElementById("stock_onevolume").innerText= result.onevolume;
	    	}else{
	    		document.getElementById("stock_onevolume").innerText='';
	    	}
	    	if(result.twovolume!=0){
	    		document.getElementById("stock_twovolume").innerText= result.twovolume;
	    	}else{
	    		document.getElementById("stock_twovolume").innerText='';
	    	}
	    	if(result.materialvolume!=0){
	    		document.getElementById("stock_materialvolume").innerText= result.materialvolume;
	    	}else{
	    		document.getElementById("stock_materialvolume").innerText='';
	    	}
	    	document.getElementById("stock_totalvolume").innerText=result.totalvolume.toFixed(4);
	    	document.getElementById("stock_totalmarketprice").innerText=result.marketprice.toFixed(2);
	    	document.getElementById("stock_zh_totalmarketprice").innerText=result.plmarketprice.toFixed(2);
	    }
	});
}

 function getNumber(num){
  num= Math.round(num*1000)/1000;
  return num;
 }
 
//获取库存列表结束
//操作日志促发事件
function getOperdaily(customer_id){
	$("#editoperatorForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#editoperator-win").window('open');
	$('#operatordata-list').datagrid({
		width: $(window).width()*0.45,
//        height:'auto',     
		height:$(window).height()*0.70,
        striped: true,
        pagination: true,
        singleSelect:true,
	    url:'getOperatorDaily.do',
	    queryParams:{  
            'customer_id' :customer_id, 
         
       },
	    columns:[[


			{field:'operator_content',title:'操作内容',align:'center',width:620},
	        {field:'operator_time',title:'操作时间',align:'center',width:150},
			{field:'operator',title:'操作人',align:'center',width:140}
			
	    ]],

	    onCheck:function(rowIndex,rowData){ 
    		if(rowData){
    			//var putstock_goods_id = rowData.putstock_goods_id;
    			//var putstock_id = rowData.putstock_id;
    			//_this.deleteGoods(putstock_goods_id,putstock_id);
    		}
	    },
	    onLoadSuccess:function(result){

	    }
	});
	
}
//操作日志结束事件
//担保金额促发事件

function dbjebj(index){
	var row = $("#data-list").datagrid("getRows")[index];
	$("#dbjeForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#dbje-win").window('open');

	$("#dbjeForm").find("input[name='dbr_id']").val(row.customer_id);
	$("#dbjeForm").find("input[name='dbr_name']").val(row.customer_name);
	//lert($("#dbjeForm").find("input[name='dbr_name']").val());
	document.getElementById("dbrname").innerText=$("#dbjeForm").find("input[name='dbr_name']").val();
	$('#dbjedata-list').datagrid({
		width: $(window).width()*0.37,
//        height:'auto',     
		height:$(window).height()*0.4,
        striped: true,
        pagination: true,
        singleSelect:true,
	    url:'getdbje.do',
	    queryParams:{  
            'dbr_id' :row.customer_id,  
           'bdbr_id':row.customer_id  
       },
	    columns:[[


			{field:'dbr_name',title:'担保人',align:'center',width:160},
	        {field:'bdbr_name',title:'被担保人',align:'center',width:160},
			{field:'db_money',title:'担保金额',align:'center',width:160},
			{field:'cz',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				 var html='';
				
			
					 html+="<a href='#' onclick='updatedbje("+index+")'>修改</a> | ";
					 html+="<a href='#' onclick='deletedbje("+index+")'>删除</a>  ";
				 return html;
			}}
	    ]],

	    onCheck:function(rowIndex,rowData){ 
    		if(rowData){
    			//var putstock_goods_id = rowData.putstock_goods_id;
    			//var putstock_id = rowData.putstock_id;
    			//_this.deleteGoods(putstock_goods_id,putstock_id);
    		}
	    },
	    onLoadSuccess:function(result){
	         document.getElementById("wtrdbje").innerText=result.wtrdbje;
	         document.getElementById("jsdbje").innerText=result.jsrdbje;
	    }
	});
	
}
//
$("#btn-dbjeupdate-submit").click(function(){

    var dbmoeney= $("#dbjeupdateForm").find("input[name='db_money']").val();
    if(null==dbmoeney||dbmoeney==''){
    	YiYa.alert('提示', '为他人担保金额不能为空！');
    	return false;
    }
   
    //alert($("#dbjeForm").find("input[name='bdbr_name']").val());
	$.messager.confirm("提示","确定提交信息吗？",function(flag){
		if(flag){
			//var customer_id = $("#editPutStockForm").find("input[name='putStockRecord.customer_id']").val();
			$("#dbjeupdateForm").attr('action','updatedbje.do');
			YiYa.saveForm($("#dbjeupdateForm"),function(data){
				$("#dbjedata-list").datagrid('reload');
				$("#data-list").datagrid('reload');
			});
			$("#dbjedata-list").datagrid('reload');
			$('#dbjeupdate-win').window('close');
		}
	});
});

function deletedbje(index){
	var row = $("#dbjedata-list").datagrid("getRows")[index];
	var dbr_name=row.dbr_name;
	var bdbr_name=row.bdbr_name;
	var db_id=row.db_id;
	var dbr_id=row.dbr_id;
	var db_money=row.db_money;
	$.messager.confirm("提示","确定删除该条担保信息吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "deletedbje.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {db_id:db_id,dbr_name:dbr_name,bdbr_name:bdbr_name,dbr_id:dbr_id,db_money:db_money},
				success : function(data){
					if(data.msg==1)
					{ YiYa.alert('提示', '操作成功');
						$("#dbjedata-list").datagrid('reload');	
						$("#data-list").datagrid('reload');
					}else{
						YiYa.alert('提示', '操作失败');
					}
				},
			});
			
		}
	});
	
}


 function updatedbje(index){
	 
	$("#dbjeupdateForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#dbjeupdate-win").window('open');
	var row = $("#dbjedata-list").datagrid("getRows")[index];
	$("#dbjeupdateForm").find("input[name='dbr_id']").val(row.dbr_id);
	$("#dbjeupdateForm").find("input[name='bdbr_id']").val(row.bdbr_id);
	$("#dbjeupdateForm").find("input[name='db_money']").val(row.db_money);
	 document.getElementById("updateForm-dbrname").innerText=row.dbr_name;
     document.getElementById("updateForm-bdbrname").innerText=row.bdbr_name;
	
}
$("#btn-dbje-submit").click(function(){
    var dbr_id=$("#dbjeForm").find("input[name='dbr_id']").val();
    var bid=$("#bdbr_id").combobox('getValue');
    var bname=$("#bdbr_id").combobox('getText');
    var judgeout=0;
    
     $("#bdbr_id option").map(function(){
    	var select_id=$(this).val();
    	var select_text=$(this).text();
    	if(select_id==bid&&select_text==bname){
    		judgeout+=1;
    		
    	}else{
    	
    	}	
       }
    );
 
     if(judgeout==0){
     	YiYa.alert('提示', '客户不存在，请重新选择！');
     	return false;
     }
     
    var dbmoeney= $("#dbjeForm").find("input[name='db_money']").val();
    if(null==dbmoeney||dbmoeney==''){
    	YiYa.alert('提示', '为他人担保金额不能为空！');
    	return false;
    }
    $("#dbjeForm").find("input[name='bdbr_name']").val(bname);
    //alert($("#dbjeForm").find("input[name='bdbr_name']").val());
    if(dbr_id==bid){
    	YiYa.alert('提示', '担保人和被担保人不能是同一个人');
    	return false;
    }
    if(null==bid||bid==''){
    	YiYa.alert('提示', '被担保人不能为空');
    	return false;
    }
	$.messager.confirm("提示","确定提交信息吗？",function(flag){
		if(flag){
			//var customer_id = $("#editPutStockForm").find("input[name='putStockRecord.customer_id']").val();
			$("#dbjeForm").attr('action',"adddbje.do");
			YiYa.saveForm($("#dbjeForm"),function(data){
				$("#dbjedata-list").datagrid('reload');
				$("#data-list").datagrid('reload');
			});
			$("#dbjedata-list").datagrid('reload');
			$("#dbjeForm").find("input[name='db_money']").val('');
		
		}
	});
});
//担保金额促发事件结束

//编辑按钮促发事件
function getbj(index){
	$("#khxxeditForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#khxxedit-win").window('open');
	var row = $("#data-list").datagrid("getRows")[index];
	$("#khxxeditForm").find("input[name='customer_id']").val(row.customer_id);
	$("#khxxeditForm").find("input[name='customer_name']").val(row.customer_name);
	$("#khxxeditForm").find("input[name='credit_limit']").val(row.credit_limit);
	$("#khxxeditForm").find("input[name='temporary_lock_line']").val(row.temporary_lock_line);
	if(null!=row.temporary_lock_line||row.temporary_lock_line!=''||row.temporary_lock_line!=0){
		$("#start_time").datetimebox('setValue', row.start_time);
		$("#end_time").datetimebox('setValue', row.end_time);
	}
	
}

$("#btn-lsszx-submit").click(function(){
	$.messager.confirm("提示","确定保存提交吗？",function(flag){
		if(flag){
			//var customer_id = $("#editPutStockForm").find("input[name='putStockRecord.customer_id']").val();
			$("#khxxeditForm").attr('action',"update.do");
			YiYa.saveForm($("#khxxeditForm"),function(data){
				$("#data-list").datagrid('reload');
			});
			$("#data-list").datagrid('reload');
			$("#khxxedit-win").window('close');
		}
	});
});
//编辑按钮促发事件结束
//报错日志按钮促发事件
$("#btn-bcrz").click(function(){
	$("#editerrorForm").form('clear');
	//$("#customer_id").combobox('select',''); 
	$("#editerror-win").window('open');
	$('#errordata-list').datagrid({
		width: 700,
//        height:'auto',     
		height:$(window).height()*0.4,
        striped: true,
        pagination: true,
        singleSelect:true,
	    url:'geterrorlist.do',
	  //  queryParams:{  
        //    'customer_id' : customer_id,  
      //      'putstock_id':putstock_id  
      //  },
	    columns:[[
	        
			{field:'error_customer_name',title:'客户姓名',align:'center',width:100},
	        {field:'error_telephone',title:'联系电话',align:'center',width:100},
			{field:'error_content',title:'报错内容',align:'center',width:180},
			{field:'error_status',title:'处理状态',align:'center',width:100,formatter:function(value,row,index){
				 var html='';
				 if(row.error_status==0){
					 html+="待处理";
				 }else{
					 html+="已处理";
				 }
				 return html;
			}},
			{field:'error_deal_with',title:'处理人',align:'center',width:100},
			{field:'eer',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				 var html='';
				 if(row.error_status==0){
			
					 html+="<a href='#' onclick='errordeak("+row.error_id+")'>已处理</a>";
				 }
				 html+="    <a href='#' onclick='deleteerror("+row.error_id+")'>删除</a>";
				 return html;
			}}
	    ]],

	    onCheck:function(rowIndex,rowData){ 
    		if(rowData){
    			var putstock_goods_id = rowData.putstock_goods_id;
    			var putstock_id = rowData.putstock_id;
    			_this.deleteGoods(putstock_goods_id,putstock_id);
    		}
	    },
	    onLoadSuccess:function(result){
	
	    
	    }
	});
});
//报错日志按钮促发事件结束

function errordeak(error_id){
	$.messager.confirm("提示","确定该异常已处理吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "updateerrorstatus.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {error_id:error_id},
				success : function(data){
					if(data.msg==1)
					{ YiYa.alert('提示', '操作成功');
						$("#errordata-list").datagrid('reload');	
					}else{
						YiYa.alert('提示', '操作失败');
					}
				},
			});
		}else{
			return false;
		}
	});
}


//报错日志按钮促发事件结束

function deleteerror(error_id){
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url     : "" +
						"deleteerror.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {error_id:error_id},
				success : function(data){
					if(data.msg==1)
					{ YiYa.alert('提示', '操作成功');
						$("#errordata-list").datagrid('reload');	
					}else{
						YiYa.alert('提示', '操作失败');
					}
				},
			});
		}else{
			return false;
		}
	});
}

function deletePutStockGoods(putstock_goods_id,putstock_id)
{
	$.messager.confirm("提示","确定要删除商品？",function(flag){
		if(flag){
			$.ajax({										
				url     : "delete.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {id:putstock_goods_id},
				success : function(data){
					if(data){
						var param = $("#putStockGoodsForm").serializeObject();
						param.putstock_id = putstock_id;
						$("#putStockGoods-data-list").datagrid('reload',param);
						$("#total_volume").val(data.total_volume);
						$("#total_weight").val(data.total_weight);
						$(this).dialog('destroy');
					}
				},
			});
		}else{
			return false;
		}
	});
}

//批量入库商品
$("#btn-good-plrk").click(function(){
	
	var pl_putstock_id=$("#pl_putstock_id").val();
	var pl_number=$("#pl_number").val();
	if(pl_number==null||pl_number==''||pl_number==0){
		 YiYa.alert('提示', '入库商品数量不得为空或为0');
		 return;
	}
	$.messager.confirm("提示","确定要入库商品？",function(flag){
		if(flag){
			$.ajax({										
				url     : "plrk.do",
				type    : "POST",
				cache   : false,
				dataType : 'json',
				data 	: {id:pl_putstock_id,number:pl_number},
				success : function(data){
					if(data){
						var param = $("#pleditForm").serializeObject();
						param.putstock_id = pl_putstock_id;
						$("#putStockGoods-data-list").datagrid('reload',param);
						//$("#total_volume").val(data.total_volume);
						//$("#total_weight").val(data.total_weight);
						$("#pledit-win").window('close', true);
					}
				},
			});
		}else{
			return false;
		}
	});
	
	
});


function searchTabStock(){
	var queryParam = $("#editeditstockForm").serializeObject();
	var dataArray={
			'customer_id':queryParam.stock_customer_id,
			'good_name':queryParam.good_name,
			'good_place':queryParam.good_place,
			'good_level':queryParam.good_level,
			'good_size':queryParam.good_size,
			'start_put_time':queryParam.start_put_time,
			'end_put_time':queryParam.end_put_time
	};
	
	
	$('#editstockdata-list').datagrid({
		height:$(window).height()*0.45,
	    striped: true,
	    pagination: true,
	    pageNumber:1,
	    pageSize:10,
	    singleSelect:true,                           
	    url:'getstock.do',
	    queryParams:dataArray,
	    columns:[[{field:'id',checkbox:true},
			{field:'area_name',title:'仓号',align:'center',width:140,formatter:function(value,row,index){
			
			 var html='';
				 html+="<a href='#' onclick='stockdetail("+index+")'>"+value+"</a>";
				
			 return html;
		}},
	        {field:'space_name',title:'仓位',align:'center',width:140,formatter:function(value,row,index){
			
			 var html='';
				 html+="<a href='#' onclick='stockdetail("+index+")'>"+value+"</a>";
				
			 return html;
		}},
			{field:'good_name',title:'商品名',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    if(null!=row.good_name_comment&&row.good_name_comment!=''){
		    	html=value+"<font color='red'>("+row.good_name_comment+")</font>";
		    }
		    return html;
		}},
			{field:'good_place',title:'商品产地',align:'center',width:140,formatter:function(value,row,index){
		    var	html=value;
		    var gpc=row.good_place_comment;
		    if(null!=row.good_place_comment&&row.good_place_comment!=''){
		    	if(2468==gpc){
		    		gpc='全部';
		    	}
		    	html=value+"<font color='red'>("+gpc+")</font>";
		    }
		    return html;
		}},
			{field:'good_level',title:'商品等级',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    if(html==1){
		    	html='顶级';
		    }
		    if(html==2){
		    	html='普一';
		    }
		    if(html==3){
		    	html='普二';
		    }
		    if(html==4){
		    	html='统材';
		    }
		    var level=row.good_level_comment
		    if(level==1){
		    	level='顶级';
		    }
		    if(level==2){
		    	level='普一';
		    }
		    if(level==3){
		    	level='普二';
		    }
		    if(level==4){
		    	level='统材';
		    }
		    if(null!=row.good_level_comment&&row.good_level_comment!=0){
		    	if(2468==level){
		    		level='全部';
		    	}
		    	html=html+"<font color='red'>("+level+")</font>";
		    }
		    return html;
		}},
			{field:'good_size',title:'商品规格',align:'center',width:140,formatter:function(value,row,index){
			
		    var	html=value;
		    var gsc = row.good_size_comment;
		    if(null!=row.good_size_comment&&row.good_size_comment!=''){
		    	if(0==gsc){
		    		gsc='全部';
		    		html=value+"<font color='red'>("+gsc+")</font>";
		    	}else{
		    		html = value + "<font color='red'>(" + row.good_size_comment_spec_name + ")</font>";
		    	}
		    	
		    }
		    return html;
		}},
			{field:'good_volume',title:'体积',align:'center',width:140},
			{field:'good_weight',title:'重量',align:'center',width:140},
			{field:'business_pag_no',title:'包号',align:'center',width:140},
			{field:'market_prices',title:'市场指导价',align:'center',width:140},
			{field:'pledge_multiplier',title:'质押系数',align:'center',width:140},
			{field:'lump_sum',title:'折后总价',align:'center',width:140,formatter:function(value,row,index){
				
			    var	html=row.good_volume*row.market_prices*row.pledge_multiplier;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'market_total_price',title:'市场总价',align:'center',width:140,formatter:function(value,row,index){

			    var	html=row.good_volume*row.market_prices;
			    html=toDecimal(html);
			    if(null==html||''==html)
			    	html='';
			    return html;
			}},
			{field:'put_success_time',title:'入库成功时间',align:'center',width:140},
			{field:'cz',title:'操作',align:'center',width:100,formatter:function(value,row,index){
				
				 var html='';
					 html+="<a href='#' onclick='fkxxbjtwo("+index+")'>修改</a>";
					
				 return html;
			}}
	    ]],
	    toolbar:[{id:'edit',text:'修改',btnType:'edit',iconCls:'icon-edit',handler:function(){

	    	var selected =$('#editstockdata-list').datagrid("getSelections");
			var stockid=selected[0].stock_id;
			var customer_id=selected[0].customer_id;
			var good_name=selected[0].good_name;
			var good_place=selected[0].good_place;
			var good_level=selected[0].good_level;
			var good_size=selected[0].good_size;
			
			var good_name_comment=selected[0].good_name_comment;
			var good_place_comment=selected[0].good_place_comment;
			var good_level_comment=selected[0].good_level_comment;
			var good_size_comment=selected[0].good_size_comment;
			
			fkxxbj(stockid,customer_id,good_name,good_place,good_level,good_size,good_name_comment,good_place_comment,good_level_comment,good_size_comment);
				_this.editPwdForm().resetForm();
				_this.editPwdForm().find("input[name='id']").val(selected[0].id);
				_this.editPwdForm().find("input[name='usr_name']").val(selected[0].usr_name);
				_this.editPwdWin().window('open'); 
			
	    }}],
	});
}


