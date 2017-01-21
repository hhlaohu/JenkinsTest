$package('YiYa.main');

YiYa.main = function(){
	return {
		treeSelect:function(){
			var _this = $(this);
			var title=_this.text();
			var url=_this.attr('href');
			YiYa.main.addTab(title,url);
			$("#checkDialog").dialog('close');
			return false;
		},
		treeInit:function(){
			var  $items =  $('#tree-box').find(".menu-item");
			$items.bind('click',this.treeSelect);
		},
		addTab:function(_title,_url){
			var boxId = '#tab-box';
			if($(boxId).tabs('exists',_title) ){
				var tab = $(boxId).tabs('getTab',_title);
				var index = $(boxId).tabs('getTabIndex',tab);
				$(boxId).tabs('select',index);
				if(tab && tab.find('iframe').length > 0){  
					 var _refresh_ifram = tab.find('iframe')[0];  
				     _refresh_ifram.contentWindow.location.href=_url;  
			    } 
			}else{		
				var _content ="<iframe scrolling='auto' frameborder='0' src='"+_url+"' style='width:100%; height:100%'></iframe>";
				$(boxId).tabs('add',{
					    title:_title,
					    content:_content,
					    closable:true});
				
			}
		},
		menuHover:function(){
			//菜单鼠标进入效果
//			$('.menu-item').hover(
//				function () {
//					$(this).stop().animate({ paddingLeft: "35px" }, 200,function(){
//						$(this).addClass("orange");
//					});
//				}, 
//				function () {
//					$(this).stop().animate({ paddingLeft: "25px" },function(){
//						$(this).removeClass("orange");
//					});
//				}
//			);
		},
		modifyPwd:function(){
			var pwdForm = $("#pwdForm");
			if(pwdForm.form('validate')){
				var parentId =$('#search_parentId').val();
				$("#edit_parentId").val(parentId)
				YiYa.saveForm(pwdForm,function(data){
					$('#modify-pwd-win').dialog('close');
				    pwdForm.resetForm();
				});
			 }
		},
		init:function(){
			this.treeInit();
			this.menuHover();
			
			//修改密码绑定事件
			$('.modify-pwd-btn').click(function(){
				$('#modify-pwd-win').dialog('open');
			});
			$('#btn-pwd-close').click(function(){
				$('#modify-pwd-win').dialog('close');
			});
			
			$.ajax({										
				url     : "getCheckToDo.do",
				type    : "GET",
				cache   : false,	
				success : function(data){
				   if(data.code==0){
					   var limitToCheckNum = data.resultText.limitToCheckNum;
					   var borrowCheckTodoNum = data.resultText.borrowCheckTodoNum;
					   if(limitToCheckNum == 0){
						   $("#limitCheck").hide();   
					   }else{
						   $('#limitCheckNum').html(limitToCheckNum);
					   }
					   if(borrowCheckTodoNum == 0){
						   $("#borrowCheck").hide();
					   }else{
						   $('#borrowCheckNum').html(borrowCheckTodoNum);
					   }
					   
					   if(limitToCheckNum==0 && borrowCheckTodoNum==0 ){
						   $("#noneCheck").show();
					   }
					   
					   $('#limitCheckNum').click(function(){
						   YiYa.main.addTab("额度审批","creditCheck/list.shtml");
						   $("#checkDialog").dialog('close');
					   });
					   $('#borrowCheckNum').click(function(){
						   YiYa.main.addTab("借款列表","borrowList/list.shtml");
						   $("#checkDialog").dialog('close');
					   });
					   $("#checkDialog").dialog('open');
				   }else{
					   YiYa.alert("提示","查询待审核事项失败，原因："+data.msg,"info");
				   }
				}
			});
		}
	};
}();

$(function(){
	YiYa.main.init();
	//默认隐藏左边菜单导航
//	$(".layout-button-left").live("click",function(){ 
//    }); 
//    $(".layout-button-left").click();
});		