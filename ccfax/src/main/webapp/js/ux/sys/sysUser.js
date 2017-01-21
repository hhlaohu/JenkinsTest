$package('YiYa.sysUser');
YiYa.sysUser = function(){
	var _box = null;
	var _this = {
		updatePwdAction:'updatePwd.do',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				YiYa.saveForm(_this.editPwdForm(),function(data){
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				_this.savePwd();
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('确定','确定关闭窗口?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'usr_name',title:'用户名',align:'center',width:120,sortable:true},
						{field:'real_name',title:'真实姓名',align:'center',width:120,sortable:true},
						{field:'state',title:'状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
						{field:'createTime',title:'创建时间',align:'center',width:180,sortable:true},
						{field:'loginCount',title:'登录总次数',align:'center',width:80,sortable:true},
						{field:'loginTime',title:'最后登录时间',align:'center',width:180,sortable:true},
						{field:'is_send_message',title:'是否发送短信',align:'center',width:180,sortable:true,formatter:function(value,row,index){
							if(value == 0){
								return "否";
							}
							if(value == 1){
								return "是";
							}
							return value;
					    }}
				]],
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btnedit',text:'修改密码',btnType:'editPwd',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='id']").val(selected[0].id);
								_this.editPwdForm().find("input[name='usr_name']").val(selected[0].usr_name);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id:'btndelete',text:'删除',btnType:'remove',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
							if(selected[0].id==1&&selected[0].usr_name=="admin"||selected[0].superAdmin==1){
								YiYa.alert('提示',"超级管理员不允许删除.",'warning');
							}else{
								_box.handler.remove();
							}
						}
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

$(function(){
	YiYa.sysUser.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		