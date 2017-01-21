<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/view/resource.jsp"%>
<link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${msUrl}/css/user_login.css">
<style type="text/css">
.datagrid-toolbar {
	display: none;
}

* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a, img {
	border: 0;
}

body {
	background: #fff;
	height: 100%;
	font: normal normal 14px/24px "Microsoft yahei", Arial;
	padding-bottom: 30px;
}

a {
	color: #333;
	text-decoration: none;
}

a:hover {
	color: #093;
	text-decoration: none;
}

#title {
	width: 300px;
	margin: 3% auto 0;
}

#title h2 {
	font-size: 18px;
}

#wrapper {
	width: 100%;
	height: 100%;
	margin: 0 auto;
	background: #fff;
	border: 1px solid #a3a3a3;
	padding: 20px 20px 50px;
	border-radius: 5px;
	-moz-border-radius: 5px;
}

/* box */
.box {
	float: left;
	width: 100%;
	height: 36px;
	background: #fff;
	border: 1px solid #d3d3d3;
}

.tab_menu {
	float: left;
	overflow: hidden;
}

.tab_menu li {
	width: 100px;
	float: left;
	height: 36px;
	line-height: 36px;
	color: #000;
	background: #D4D4D4;
	text-align: center;
	cursor: pointer;
}

.tab_menu li.current {
	color: #333;
	background: #eee;
}

.tab_menu li a {
	color: #fff;
	text-decoration: none;
}

.tab_menu li.current a {
	color: #333;
}

.tab_box {
	padding: 20px;
}

.tab_box li {
	height: 28px;
	line-height: 28px;
	overflow: hidden;
}

.tab_box li span {
	margin: 0 5px 0 0;
	font-family: "Microsoft yahei";
	font-size: 14px;
	font-weight: 400;
	color: #ddd;
}

.tab_box .hide {
	display: none;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-top: 10px;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.subtotal {
	font-weight: bold;
} /*合计单元格样式*/
.list li.cf {
	min-height: 30px;
	line-height: 30px;
	padding: 10px 0 10px 150px;
}

.list .handle {
	padding: 10px 0;
	display: inline;
	width: 100%;
	margin-left: -100px;
	text-align: right;
	color: #333;
}

.list .handle span {
	margin: 0 5px 0 5px;
	font-family: "Microsoft yahei";
	font-size: 14px;
	font-weight: 400;
	color: #666;
}
</style>
</head>
<body>
	<div style="width: 100%; margin: 30px auto; padding: 30px; font-size: 14px;">
		
		<div style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
			<label><b>1.姓名身份证号照片比对：</b></label>
			启用:<input type="radio" id="id_name_face1" name="id_name_face"  value="1" />&nbsp;&nbsp;
			关闭:<input type="radio" id="id_name_face2" name="id_name_face" />&nbsp;&nbsp;
			通过分数设置:&nbsp; <input id="score_standard" class="easyui-numberbox" style="height:30px;width:100px"/>
		</div>
		
		<div style="width: 100%; margin: 5px auto; padding: 5px; font-size: 14px;">
			<label><b>2.人体动态验证：</b></label>
			启用:<input type="radio" id="check_alive1" name="check_alive"  value="1" />&nbsp;&nbsp;&nbsp;&nbsp;
			关闭:<input type="radio" id="check_alive2" name="check_alive" />&nbsp;&nbsp;
		</div>
		
		<input id="confirmConfig" class="btn-primary" value="确认" type="button" >
		

	</div>




	<div class="scroll-top"></div>


<script type="text/javascript" src="${msUrl}/js/commons/jquery.tabs.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/xiaoshi/xiaoshi.js"></script>
</body>

</html>
