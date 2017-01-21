$package('YiYa.login');
YiYa.login = function(){
	return {
		toLogin:function(){
			try{
				var form = $("#loginForm");
				if(form.form('validate')){
					YiYa.progress('请稍后','加载中...');
					YiYa.submitForm(form,function(data){
						YiYa.closeProgress();
						YiYa.login.loadVrifyCode();//刷新验证码
						if(data.success){
					 		window.location= "main.shtml";
				        }else{
				        	
//				       	   YiYa.alert('提示',data.msg,'error');  
							layer.msg(data.msg,function(){
								
							});
				        }
					});
				}
			}catch(e){
				
			}
			return false;
		},
		loadVrifyCode:function(){//刷新验证码
			var _url = "ImageServlet?time="+new Date().getTime();
			$(".code-img").attr('src',_url);
		},
		init:function(){
			if(window.top != window.self){
				window.top.location =  window.self.location;
			}
			//验证码图片绑定点击事件
			$(".code-img").click(YiYa.login.loadVrifyCode);
			
			var form = $("#loginForm");
			form.submit(YiYa.login.toLogin);
		}
	}
}();

$(function(){
	YiYa.login.init();
});		