$(function(){
	//初始化下拉列表数据源
	 $('#marital').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_2",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#diploma').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_1",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#sex').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_3",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#local_register_place').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_6",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#industry').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_7",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#income').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_10",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#house_type').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_11",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#fixed_assets').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_12",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#employment').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_33",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#cur_hire_duration').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_9",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#schooling_system').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_34",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 $('#profession_level').combobox({
		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_8",
		  valueField: 'dictionary_value_key',
	      textField: 'dictionary_value_name',
	      disabled:true 
	  });
	 
	 $('#province').combobox({
		  url:"../tabArea/queryListByAreaDeep.do?areaDeep=1",
		  valueField: 'area_id',
	      textField: 'area_name',
	      disabled:true ,
	      onSelect:function(rec){
			  $('#city').combobox('clear');
			  var url = '../tabArea/queryListByParentId.do?parent_id='+rec.area_id;
	          $('#city').combobox('reload', url);
		  }
	  });
	 
	 $('#city').combobox({
		  url:"../tabArea/queryListByAreaDeep.do?areaDeep=2",
		  valueField: 'area_id',
	      textField: 'area_name',
	      disabled:true,
	      onSelect:function(rec){
			  $('#county').combobox('clear');
			  var url = '../tabArea/queryListByParentId.do?parent_id='+rec.area_id;
	          $('#county').combobox('reload', url);
		  }
	  });
	 
	 $('#county').combobox({
		  url:"../tabArea/queryListByAreaDeep.do?areaDeep=3",
		  valueField: 'area_id',
	      textField: 'area_name',
	      disabled:true 
	  });
	 
	 
	 
	 
});	

/**给基本信息块赋值**/
function setBaseInfo(data){
	$("#usrid").val(data.tabUsrinf.usrid);
	$("#borrower_usrname").text(data.tabUsrinf.borrower_usrname);
	$("#sex").combobox('setValue', data.tabUsrinf.sex);
	$("#age").text(data.tabUsrinf.age);
	$("#borrower_mobile_phone").text(data.tabUsrinf.borrower_mobile_phone);
	$("#borrower_id_card").text(data.tabUsrinf.borrower_id_card);
	$("#marital").combobox('setValue', data.tabUsrinf.marital);
	$("#province").combobox('setValue', data.tabUsrinf.area_province);
	$("#city").combobox('setValue', data.tabUsrinf.area_city);
	$("#county").combobox('setValue', data.tabUsrinf.area_county);
	$("#local_register_place").combobox('setValue', data.tabUsrinf.local_register_place);
	$("#diploma").combobox('setValue', data.tabUsrinf.diploma);
	$("#bank_id").val(data.tabUsrinf.bank_id);
	$("#income").combobox('setValue', data.tabUsrinf.income);
	$("#house_type").combobox('setValue', data.tabUsrinf.house_type);
	$("#fixed_assets").combobox('setValue', data.tabUsrinf.fixed_assets);
	$("#employment").combobox('setValue', data.tabUsrinf.employment);
	$("#industry").combobox('setValue', data.tabUsrinf.industry);
	$("#com_name").val(data.tabUsrinf.com_name);
	$("#profession_level").combobox('setValue', data.tabUsrinf.profession_level);
	$("#cur_hire_duration").combobox('setValue', data.tabUsrinf.cur_hire_duration);
	$("#schooling_system").combobox('setValue', data.tabUsrinf.schooling_system);
	$("#graduate_school").val(data.tabUsrinf.graduate_school);
	$("#repaying_source").val(data.tabUsrinf.repaying_source);
	$("#usrinf_id").text(data.tabUsrinf.usrinf_id);
	$("#checkForm_info").find("input[name='usrinf_id']").val(data.tabUsrinf.usrinf_id);
	$("#applyfor_limit").text(data.tabUsrinf.applyfor_limit);
	$("#contract_number").val(data.tabUsrinf.contract_number);
}

//身份证图片显示
function setCreditCardPic(data){
	$("#id_card_front").attr("src",data.tabUsrinf.id_card_front_pic);
	$("#id_card_reverse_pic").attr("src",data.tabUsrinf.id_card_reverse_pic);
	$("#id_card_with").attr("src",data.tabUsrinf.with_id_card_pic);
}

//联系人信息赋值
function setRelation(data,flag){
	var tabBondsmaninf_List = data.tabBondsmaninf_List;
	if(tabBondsmaninf_List!=null&&tabBondsmaninf_List.length>0){
		$("#tabBondsmaninf_tab").text("");
		var array = new Array();
		if(!flag){
			$.each(tabBondsmaninf_List, function(i, n) {
				var tbBody = "";
				tbBody += "<tr><th align='left'>姓名：</th><td align='left'><input class='easyui-validatebox' type='text' id='rel_usrname' name='rel_usrname' disabled='disabled' value='"+n.rel_usrname+"'/>"+ 
				"</td>" + "<th align='left'>关系：</th><td align='left'><select class='easyui-combobox' name='relation' data-options='required:true,width:150' id='relation' disabled='disabled'  />"+ 
				"</td>" + "<th align='left'>手机号码：</th><td align='left'><input class='easyui-validatebox' type='text' disabled='disabled' id='rel_mobile_phone' name='rel_mobile_phone' value='"+n.rel_mobile_phone+"'/></td>" +
				"<th align='left' class='hidden'>id：</th><td align='left' class='hidden'><input class='hidden' type='text' id='id' name='rel_usrname' value='"+n.id+"'/></td>"+
						"</tr>;"
				$("#tabBondsmaninf_tab").append(tbBody);
				array.push(n.relation);
			});
		}else{
			$.each(tabBondsmaninf_List, function(i, n) {
				var tbBody = "";
				tbBody += "<tr><th align='left'>姓名：</th><td align='left'><input class='easyui-validatebox' type='text' id='rel_usrname' name='rel_usrname' value='"+n.rel_usrname+"'/>"+ 
				"</td>" + "<th align='left'>关系：</th><td align='left'><select class='easyui-combobox' name='relation' data-options='required:true,width:150' id='relation' />"+ 
				"</td>" + "<th align='left'>手机号码：</th><td align='left'><input class='easyui-validatebox' type='text' id='rel_mobile_phone' name='rel_mobile_phone' value='"+n.rel_mobile_phone+"'/></td>" +
				"<th align='left' class='hidden'>id：</th><td align='left' class='hidden'><input class='hidden' type='text' id='id' name='rel_usrname' value='"+n.id+"'/></td>"+
						"</tr>;"
				$("#tabBondsmaninf_tab").append(tbBody);
				array.push(n.relation);
			});
		}
	    $("#tabBondsmaninf_tab select").each(function(i,n){
	    	 $(this).combobox({
	    		  url:"../dataManager/getDDVListByTypeCode.do?typeCode=tszd_35",
				  valueField: 'dictionary_value_key',
			      textField: 'dictionary_value_name',
			      value:array[i]
			  });
	    }); 
	}else{
		$("#tabBondsmaninf_tab").text("无直系亲属信息！");
	}
}

//小视活体产品显示
function setXiaoShiInfo(data){
	//活体验证信息
	if(data.tabUsrinf.xiaoshi_check_alive_result == null){
		$("#faceDiv").hide();
	}else{
		$("#faceDiv").show();
		$("#check_alive_name").text(data.tabUsrinf.borrower_usrname);
		$("#check_alive_id_card").text(data.tabUsrinf.borrower_id_card);
		$("#check_alive_pic").attr("src",data.tabUsrinf.check_alive_pic);
		$("#xiaoshi_check_alive_result").text(data.tabUsrinf.xiaoshi_check_alive_result==0?"通过":"不通过");
		if(data.tabUsrinf.xiaoshi_id_card_check_result != null){
			$("#xiaoshi_id_card_check_result").text(data.tabUsrinf.xiaoshi_id_card_check_result);	
		}
		if(data.tabUsrinf.xiaoshi_id_card_check_msg != null){
			$("#xiaoshi_id_card_check_msg").text(data.tabUsrinf.xiaoshi_id_card_check_msg);	
		}
		if(data.tabUsrinf.xiaoshi_id_card_check_guid != null){
			$("#xiaoshi_id_card_check_guid").text(data.tabUsrinf.xiaoshi_id_card_check_guid);	
		}
		if(data.tabUsrinf.xiaoshi_id_card_check_score != null){
			$("#xiaoshi_id_card_check_score").text(data.tabUsrinf.xiaoshi_id_card_check_score);	
		}
	}
}


//设置可编辑属性
function setDisabled(editFlag){
	if(editFlag){
		$("#marital").combobox('enable');
		$("#province").combobox('enable');
		$("#city").combobox('enable');
		$("#county").combobox('enable');
		$("#local_register_place").combobox('enable');
		$("#diploma").combobox('enable');
		$("#bank_id").removeAttr("disabled");
		$("#income").combobox('enable');
		$("#house_type").combobox('enable');
		$("#fixed_assets").combobox('enable');
		$("#employment").combobox('enable');
		$("#com_name").removeAttr('disabled');
		$("#industry").combobox('enable');
		$("#profession_level").combobox('enable');
		$("#cur_hire_duration").combobox('enable');
		$("#schooling_system").combobox('enable');
		$("#graduate_school").removeAttr("disabled");
		$("#repaying_source").removeAttr("disabled");
	}else{
		$("#marital").combobox('disable');
		$("#province").combobox('disable');
		$("#city").combobox('disable');
		$("#county").combobox('disable');
		$("#local_register_place").combobox('disable');
		$("#diploma").combobox('disable');
		$("#bank_id").attr('disabled','disabled');
		$("#income").combobox('disable');
		$("#house_type").combobox('disable');
		$("#fixed_assets").combobox('disable');
		$("#employment").combobox('disable');
		$("#com_name").attr('disabled','disabled');
		$("#industry").combobox('disable');
		$("#profession_level").combobox('disable');
		$("#cur_hire_duration").combobox('disable');
		$("#schooling_system").combobox('disable');
		$("#graduate_school").attr('disabled','disabled');
		$("#repaying_source").attr('disabled','disabled');
	}
}