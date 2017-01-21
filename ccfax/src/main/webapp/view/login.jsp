<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>特速风控后台管理系统</title>
		<style type="text/css">
			body,div,h2,h3,ul,li{margin:0;padding:0;}
			body{min-height:600px;font:14px/20px '\5FAE\8F6F\96C5\9ED1','\5b8b\4f53',arial,tahoma, Srial, helvetica, sans-serif;background:url(images/bg.jpg) no-repeat center top #272f3d;}
			.cf{*zoom:1;}
			.cf:after, .cf:before{display:block;height:0;line-height:0;font-size: 0;clear:both;visibility:hidden;content:".";}
			.wraper{position:relative;width:1000px;margin:0 auto;padding:75px 0;}
			.logo{width:156px;height:56px;background:url(images/logo.png) no-repeat center left;}
			.woodpecker{width:550px;height:112px;margin-top:40px;color:#fff;background:url(images/woodpecker.png) no-repeat center left;}
			.loginbar{position:absolute;top:200px;right:0;width:320px;height:340px;color:#fff;background-color:rgba(0,0,0,.56)}
			.loginbar h3{padding:15px 40px;font-weight:normal;font-size:16px;border-bottom:solid 2px #88b8dd;}
			.loginbar ul{padding:30px 0 0 40px;}
			.loginbar li{margin:10px 0;list-style-type:none;}
			.loginbar .ic{float:left;width:40px;height:40px;background-image:url(images/ic.png);background-repeat:no-repeat;background-color:#aaa;}
			.loginbar .inp{float:left;width:180px;height:20px;padding:10px;font:14px/18px '\5FAE\8F6F\96C5\9ED1','\5b8b\4f53',arial,tahoma, Srial, helvetica, sans-serif;colpr:#666;border:none;background-color:#fff;}
			.loginbar .short{width:70px;}
			.loginbar .code-img{float:left;margin-left:10px;}
			.loginbar .btn{width:240px;line-height:19px;margin-top:20px;padding:10px 0;font-size:16px;color:#fff;text-align:center;border-radius:6px;background-color:#04abe5;cursor:pointer; border:none 0;}
			.ic-username{background-position:center 0;} 
			.ic-password{background-position:center -40px;} 
			.ic-code{background-position:center -80px;} 
		</style>
		<%@include file="/view/resource.jsp" %>
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
	</head>
	
	<body>
		<img src="images/bg.jpg" style="width: 100%;height: 100%; position: absolute; z-index:-999;">
		<img src="images/logo.png" style="position: absolute; z-index:-999;padding-top: 100px;padding-left: 400px">
		<img src="images/woodpecker.png" style="position: absolute; z-index:-999;padding-top: 200px;padding-left: 200px">
		<div class="wraper">
		<form id="loginForm" action="toLogin.do" method="post" class="loginbar" autocomplete="off">
			<h3>特速风控管理系统</h3>
			<ul>
		         <li class="cf">
	            	<label class="ic ic-username" for="username"></label>
	                <input type="text" id="usr_name" name="usr_name" class="inp" placeholder="用户名" maxlength="32" onfocus="this.value = '';" />
                </li>
				<li class="cf">
	            	<label class="ic ic-password" for="password"></label>
	                <input type="password" id="usr_pass" name="usr_pass" class="inp" placeholder="密码" maxlength="16" onfocus="this.value = '';" />
                </li>            
				<li class="cf">
	            	<label class="ic ic-code" for="code"></label>
	                <input type="text" id="verifyCode" name="verifyCode" class="inp short" placeholder="验证码" maxlength="4" />
	                <img class="code-img" width="100" height="40" title="点击刷新验证码" src="ImageServlet?time=new Date().getTime()" />
                </li>	
                <li><input type="submit" class="btn" value="登 录" onfocus="this.blur();" /></li>
			</ul>
		</form>
	  </div>
	</body>
	<script type="text/javascript" src="${msUrl}/js/ux/login.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#usr_name").focus();
 			$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#btn-submit").trigger("click");
			  }
			}); 
			$("#btn-submit").click(function(){
				var username = $("#usr_name").val();
				var password = $("#usr_pass").val();
				var verifyCode = $("#verifyCode").val();
				if(username==""||username==null||username=="请输入用户名"){
					layer.msg('请输入用户名！',function(){

					});
					$('#usr_name').focus();  
					return;
				}else if(password==""||password==null||password=="请输入密码"){
					layer.msg('请输入密码！',function(){

					});
					$('#usr_pass').focus();  
					return;
				}else if(verifyCode==""||verifyCode==null){
					layer.msg('请输入验证码！',function(){

					});
					$('#verifyCode').focus();
					return;
				}else{
				  $("#loginForm").submit();
				}
			});
		});
	</script>
</html>
