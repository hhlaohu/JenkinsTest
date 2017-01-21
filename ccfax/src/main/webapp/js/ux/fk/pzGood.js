$package('YiYa.pzGood');
YiYa.pzGood = function(){
	
	$('#pz_good_place').combobox({ //在select选项卡中可以编辑添加信息
		editable:true
		}); 
	$('#pz_good_name').combobox({ 
		editable:true
		})
	$('#pz_good_level').combobox({ 
		editable:true
		}); 
	$('#pz_good_size').combobox({ 
		editable:true
		}); 
	$('#unit').combobox({ 
		editable:true
		}); 
	$("#tabPzGood2").hide();//隐藏按货物名称查询的form表单
	var _box = null;
	var _this = {
			listForm:$("#listForm"),
			addArea:$("#Addwin"),
			addForm:function(){
				return $("#addForm");
			},
			initForm:function(){
			},
			specConfigwin:$("#specConfigwin"),
			specConfigForm:function(){
				return $("#specConfigForm");
			},
			AddSpecConfig:$("#AddSpecConfig"),
			addSpecConfigForm:function(){
				return $("#addSpecConfigForm");
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
                pageSize:20,
                height: 'auto',
	   			columns:[[
					
						{field:'pz_good_name',title:'货物名称',align:'center',width:120,sortable:true},
						{field:'pz_good_place',title:'产地',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							if(value == 2468){
								return "全部";
							}
						return value;
					}},
						{field:'pz_good_level',title:'等级',width:80,align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "顶级";
								}else if(value == 2){
									return "普一";
								}else if(value==3){
									return "普二";
								}else if(value==4){
									return "统材";
								}else if(value==2468){
									return "全部";
								}
						}},
						{field:'pz_good_size',title:'规格',align:'center',width:80,sortable:true,formatter:function(value,row,index){
							if(value == 0){
								return "全部";
							}
							if(value == row.pz_good_size){
								return row.spec_name;
							}
						return value;
					}},
						{field:'market_prices',title:'市场指导价',align:'center',width:80,sortable:true},
						{field:'unit',title:'计量单位',align:'center',width:120,sortable:true},
						{field:'pledge_multiplier',title:'质押系数',align:'center',width:120,sortable:true},
						{field:'pzGoodList',title:'编辑操作',align:'center',width:180,sortable:true,formatter:function(value,row,index){
							var html ="<a href='#' onclick='pzGoodModify("+index+")'>编辑</a> | ";
							html +="<a href='#' onclick='pzGoodDelete("+index+")'>删除</a> ";
							return html;
							
						}}
				]],
				toolbar:[
					{id:'btnaddss',text:'新增',iconCls:'icon-add',handler:function(){
						_this.addArea.window("open");
					}},
					{id:'btnaddss',text:'规格管理',iconCls:'icon-add',handler:function(){
						_this.specConfigwin.window("open");
						$('#specConfig-list').datagrid({
							//width: $(window).width()*0.45,
							  height:'auto',     
							//height:$(window).height()*0.45,
						   striped: true,
						   pagination: true,
						   singleSelect:true,                           
						   url:'getSpecConfigList.do',
						    columns:[[
								{field:'spec_name',title:'规格',align:'center',width:110},
								{field:'spec_type',title:'类别',align:'center',width:110,sortable:true,formatter:function(value,row,index){
									if(value == 0){
										return "A";
									}
									if(value == 1){
										return "B";
									}
								}},
								{field:'value_begin',title:'开始',align:'center',width:110},
								{field:'value_end',title:'结束',align:'center',width:110},
								{field:'pzGoodList',title:'操作',align:'center',width:110,sortable:true,formatter:function(value,row,index){
									var html ="<a href='#' onclick='specConfigModify("+index+")'>编辑</a>";
									return html;
									
								}}
							
						    ]],
						    toolbar:[
									{id:'btnaddss',text:'新增',iconCls:'icon-add',handler:function(){
										_this.AddSpecConfig.window("open");
									}}
							]
						 
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

/**添加配置管理信息**/
function submitPzGood(){	
	//提交
		var queryParam = $("#addForm").serializeObject();//序列化表单对象
		if(!queryParam.pz_good_name){
			$.messager.alert('提示:','货物名称不能为空','error'); 
			return false;
		}
		if(!queryParam.pz_good_place){
			$.messager.alert('提示:','产地不能为空','error'); 
			return false;
		}
		if(!queryParam.pz_good_level){
			$.messager.alert('提示:','等级不能为空','error'); 
			return false;
		}
		if(!queryParam.pz_good_size){
			$.messager.alert('提示:','规格不能为空','error'); 
			return false;
		}
		if(queryParam.market_prices<0){
			$.messager.alert('提示:','市场指导价格不能小于0','error'); 
			return false;
		}
		if(!queryParam.market_prices){
			$.messager.alert('提示:','市场指导价格不能为空','error'); 
			return false;
		}
		if(!queryParam.pledge_multiplier){
			$.messager.alert('提示:','质押乘数不能为空','error'); 
			return false;
		}
		if(queryParam.pledge_multiplier<0){
			$.messager.alert('提示:','质押乘数不能小于0','error'); 
			return false;
		}
		if(!queryParam.unit){
			$.messager.alert('提示:','计量单位不能为空','error'); 
			return false;
		}
		var dataArray={
				'pz_good_name':queryParam["pz_good_name"],
				'pz_good_place':queryParam["pz_good_place"],
				'pz_good_level':queryParam["pz_good_level"],
				'pz_good_size':queryParam["pz_good_size"],
				'market_prices':queryParam["market_prices"],
				'pledge_multiplier':queryParam["pledge_multiplier"],
				'unit':queryParam["unit"]
		};
		$.ajax({										
			url     : "addPzGood.do",
			type    : "POST",
			cache   : false,
			dataType : 'json',
			data 	: queryParam,
			success : function(da){
				if(da.msg==1){
					YiYa.alert('提示', "数据冲突,请重新添加");
					return false;
				}
				if(da.msg==2){
					YiYa.alert('提示', "规格互斥,请重新添加");
					return false;
				}
				if(da.msg==3){
					YiYa.alert('提示', "该商品存在产地为全部的数据，产地只能为全部");
					return false;
				}
				if(da.msg==4){
					YiYa.alert('提示', "该商品存在等级为全部的数据，等级只能为全部");
					return false;
				}
				if(da.msg==5){
					YiYa.alert('提示', "该商品存在规格为全部的数据，规格只能为全部");
					return false;
				}
				if(da.msg==6){
					YiYa.alert('提示', "数据已经存在,请重新添加");
					return false;
				}
				if(da.msg==0){
					$("#Addwin").window('close', true);
					$("#data-list").datagrid('reload',queryParam);
					YiYa.alert('提示', "添加成功");
				}
			},
		});
}

/**修改配置管理信息**/
function pzGoodModify(index){
	$("#ModifyWin").window("open");
	var row = $("#data-list").datagrid("getRows")[index];//获取列表对应的值
	$("#modifyPzGoodForm").find("input[name='pz_id']").val(row.pz_id);
	$("#modifyPzGoodForm").find("input[name='pz_good_name']").val(row.pz_good_name);
	
	$("#update_pz_good_place").combobox('setValue',row.pz_good_place);  
	$("#update_pz_good_level").combobox('select',row.pz_good_level);  
	$("#update_pz_good_size").combobox('select',row.pz_good_size);  
	
	$('#update_market_prices').numberbox('setValue', row.market_prices);
	$("#update_unit").combobox('select',row.unit);  
	$('#update_pledge_multiplier').numberbox('setValue', row.pledge_multiplier);
}


/**修改配置管理信息--修改按钮**/
function updatePzGood(){
	var queryParam = $("#modifyPzGoodForm").serializeObject();
	if(!queryParam.pz_good_name){
		$.messager.alert('提示:','货物名称不能为空','error'); 
		return false;
	}
	if(!queryParam.pz_good_place){
		$.messager.alert('提示:','产地不能为空','error'); 
		return false;
	}
	if(!queryParam.pz_good_level){
		$.messager.alert('提示:','等级不能为空','error'); 
		return false;
	}
	if(!queryParam.pz_good_size){
		$.messager.alert('提示:','规格不能为空','error'); 
		return false;
	}
	if(queryParam.market_prices<0){
		$.messager.alert('提示:','市场指导价格不能小于0','error'); 
		return false;
	}
	if(!queryParam.market_prices){
		$.messager.alert('提示:','市场指导价格不能为空','error'); 
		return false;
	}
	if(!queryParam.pledge_multiplier){
		$.messager.alert('提示:','质押乘数不能为空','error'); 
		return false;
	}
	if(queryParam.pledge_multiplier<0){
		$.messager.alert('提示:','质押乘数不能小于0','error'); 
		return false;
	}
	if(!queryParam.unit){
		$.messager.alert('提示:','计量单位不能为空','error'); 
		return false;
	}
	var dataArray={
			'pz_id':queryParam["pz_id"],
			'pz_good_name':queryParam["pz_good_name"],
			'pz_good_place':queryParam["pz_good_place"],
			'pz_good_level':queryParam["pz_good_level"],
			'pz_good_size':queryParam["pz_good_size"],
			'market_prices':queryParam["market_prices"],
			'pledge_multiplier':queryParam["pledge_multiplier"],
			'unit':queryParam["unit"]
	};
	$.ajax({										
		url      : "updatePzGood.do",
		type     : "POST",	
		cache    : false,
		dataType : 'json',
		data 	 : queryParam,
		success  : function(da){
			if(da.msg==1){
				YiYa.alert('提示', "数据冲突,请重新编辑");
				return false;
			}
			if(da.msg==2){
				YiYa.alert('提示', "规格互斥,请重新编辑");
				return false;
			}
			if(da.msg==3){
				YiYa.alert('提示', "该商品存在产地为全部的数据，产地只能为全部");
				return false;
			}
			if(da.msg==4){
				YiYa.alert('提示', "该商品存在等级为全部的数据，等级只能为全部");
				return false;
			}
			if(da.msg==5){
				YiYa.alert('提示', "该商品存在规格为全部的数据，规格只能为全部");
				return false;
			}
			if(da.msg==6){
				YiYa.alert('提示', "数据已经存在,请重新添加");
				return false;
			}
			if(da.msg==0){
				$("#ModifyWin").window('close', true);
				$("#data-list").datagrid('reload',queryParam);
				YiYa.alert('提示', "修改成功");
			}
	
		},
	});
}

/**删除配置管理信息**/
function pzGoodDelete(index){
	var row = $("#data-list").datagrid("getRows")[index];//获取列表对应的值
	$("#modifyPzGoodForm").find("input[name='pz_id']").val(row.pz_id);
	var dataArray={
			'pz_id':row.pz_id
	};
	$.messager.confirm("提示","确定要删除吗？",function(flag){
		if(flag){
			$.ajax({										
				url      : "deletePzGood.do",
				type     : "POST",
				cache    : false,
				dataType : 'json',
				data 	 : dataArray,
				success  : function(da){
					$("#ModifyWin").window('close', true);
					$("#data-list").datagrid('reload');
					YiYa.alert('提示', "删除成功");
				},
			});
		}
	});
}
	
	


/**按货物名称查询**/
$("#btn-search").click(function(){
		listForm2:$("#listForm2");
		var queryParam = $("#searchForm").serializeObject();
		var dataArray = {'pz_good_name':queryParam["pz_good_name"]};//获取选项框的值
		$("#tabPzGood2").show();//显示查询信息
		$('#data-list2').datagrid({
		striped: true,
	    pagination:true,
		url:'queryPzGoodName.do',
		queryParams:queryParam, 
		columns:[[
				{field:'pz_id',title:'序号',align:'center',width:60,sortable:true},
				{field:'pz_good_name',title:'货物名称',align:'center',width:120,sortable:true},
				{field:'pz_good_place',title:'产地',align:'center',width:120,sortable:true,formatter:function(value,row,index){
					if(value == 2468){
						return "全部";
					}
				return value;
				}},
					{field:'pz_good_level',title:'等级',width:80,align:'center',sortable:true,
						formatter:function(value,row,index){
						if(value == 1){
							return "顶级";
						}else if(value == 2){
							return "普一";
						}else if(value==3){
							return "普二";
						}else if(value==4){
							return "统材";
						}else if(value==2468){
							return "全部";
						}
					}},
					{field:'pz_good_size',title:'规格',align:'center',width:80,sortable:true,formatter:function(value,row,index){
						if(value == 0){
							return "全部";
						}
						if(value == row.pz_good_size){
							return row.spec_name;
						}
					return value;
				}},
					{field:'market_prices',title:'市场指导价',align:'center',width:80,sortable:true},
					{field:'unit',title:'计量单位',align:'center',width:120,sortable:true},
					{field:'pledge_multiplier',title:'质押系数',align:'center',width:120,sortable:true}
			]],
			
	});
	$("#tabPzGood").hide();//隐藏所有列表信息
});


/**添加规格管理**/
function submitSpecConfig(){
		var queryParam = $("#addSpecConfigForm").serializeObject();//序列化表单对象
		if(queryParam.spec_type==0){
			if(!queryParam.spec_name){
				$.messager.alert('提示:','规格不能为空','error'); 
				return false;
			}
			if(!queryParam.spec_type){
				$.messager.alert('提示:','规格类别不能为空','error'); 
				return false;
			}
		}
		if(queryParam.spec_type==1){
			if(!queryParam.spec_name){
				$.messager.alert('提示:','规格不能为空','error'); 
				return false;
			}
			if(!queryParam.spec_type){
				$.messager.alert('提示:','规格类别不能为空','error'); 
				return false;
			}
			if(!queryParam.value_begin){
				$.messager.alert('提示:','开始不能为空','error'); 
				return false;
			}
			if(!queryParam.value_end){
				$.messager.alert('提示:','结束不能为空','error'); 
				return false;
			}
		}
		var dataArray={
				'spec_name':queryParam["spec_name"],
				'spec_type':queryParam["spec_type"],
				'value_begin':queryParam["value_begin"],
				'value_end':queryParam["value_end"]
		};
		$.ajax({										
			url     : "addSpecConfig.do",
			type    : "POST",
			cache   : false,
			dataType : 'json',
			data 	 : queryParam,
			success : function(data){
				if(data.msg==0){
					YiYa.alert('提示', "A类中开始与结束不能有值!");
					return false;
				}
				if(data.msg==1){
					YiYa.alert('提示', "该规格数据已存在,请重新添加!");
					return false;
				}
				$("#AddSpecConfig").window('close', true);
				$("#specConfig-list").datagrid('reload');
				YiYa.alert('提示', "添加成功");
				window.location.reload();
			},
		});
}

/**修改规格管理信息**/
function specConfigModify(index){
	$("#ModifySpecConfig").window("open");
	var row = $("#specConfig-list").datagrid("getRows")[index];//获取列表对应的值
	$("#ModifySpecConfigForm").find("input[name='spec_id']").val(row.spec_id);
	$("#ModifySpecConfigForm").find("input[name='spec_name']").val(row.spec_name);
	$("#ModifySpecConfigForm").find("input[name='value_begin']").val(row.value_begin);
	$("#ModifySpecConfigForm").find("input[name='value_end']").val(row.value_end);
	$("#update_spec_type").combobox('setValue',row.spec_type);  
}

/**修改配置管理信息--修改按钮**/
function updateSpecConfig(){
	var queryParam = $("#ModifySpecConfigForm").serializeObject();
	if(queryParam.spec_type==0){
		if(!queryParam.spec_name){
			$.messager.alert('提示:','规格不能为空','error'); 
			return false;
		}
		if(!queryParam.spec_type){
			$.messager.alert('提示:','规格类别不能为空','error'); 
			return false;
		}
	}
	if(queryParam.spec_type==1){
		if(!queryParam.spec_name){
			$.messager.alert('提示:','规格不能为空','error'); 
			return false;
		}
		if(!queryParam.spec_type){
			$.messager.alert('提示:','规格类别不能为空','error'); 
			return false;
		}
		if(!queryParam.value_begin){
			$.messager.alert('提示:','开始不能为空','error'); 
			return false;
		}
		if(!queryParam.value_end){
			$.messager.alert('提示:','结束不能为空','error'); 
			return false;
		}
	}
	var dataArray={
			'spec_id':queryParam["spec_id"],
			'spec_name':queryParam["spec_name"],
			'spec_type':queryParam["spec_type"],
			'value_begin':queryParam["value_begin"],
			'value_end':queryParam["value_end"]
	};
	$.ajax({										
		url      : "updateSpecConfig.do",
		type     : "POST",
		cache    : false,
		dataType : 'json',
		data 	 : queryParam,
		success : function(data){
			if(data.msg==0){
				YiYa.alert('提示', "A类中开始与结束不能有值!");
				return false;
			}
			if(data.msg==1){
				YiYa.alert('提示', "该规格数据已存在,请重新编辑!");
				return false;
			}
			$("#ModifySpecConfig").window('close', true);
			$("#specConfig-list").datagrid('reload');
			YiYa.alert('提示', "修改成功");
		},
	});
}

$(function(){
	YiYa.pzGood.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		