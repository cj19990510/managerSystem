﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/login.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/jquerysession.js"></script>
<title>学科竞赛管理系统登录</title>
</head>

<body>
	<div id="container">
		<div id="bd">
			<div id="main">
				<div class="login-box">
					<div id="logo"></div>
					<h1></h1>
					<form action="StudentLogin" method="post" target="_top">
						<div class="input username" id="username">
							<label for="userName">用户名</label> <span></span> <input
								type="text" id="userName" name="student.CStuId" />
						</div>
						<div class="input psw" id="psw">
							<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label> <span></span>
							<input type="password" id="password" name="student.CPasswd" />
						</div>
						<div class="input validate" id="validate">
							<label for="valiDate">验证码</label> <input type="text"
								id="valiDate" name="randCode" /> <img src="getRandCode"
								class="image" id="randCode" />
						</div>
						<div class="styleArea"></div>
						<div id="btn" class="loginButton">
							<input type="submit" class="button" id="login" value="登录" />
						</div>
					</form>
				</div>
			</div>
			<div id="ft">CopyRight&nbsp;2019&nbsp;&nbsp;版权所有&nbsp;&nbsp;湖南中医药大学
				信息科学与工程学院&nbsp;&nbsp;</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
		var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
	});
	$("#randCode").click(function(e) {

		parent.location.reload()
	})
	//登录
	/*
		$("#login").click(function(e) {
	 var name=$("#username").val();
	 var psw=$("#password").val();
	 var randCode=$("#valiDate").val();
		$.post("StudentLogin",{"student.CStuId":name,"student.CPasswd":psw,"randCode":randCode},function(result)
	 {
	 alert(result);
	 if(result=="1"){
	 alert("验证码输入错误");
	 }
	 else if(result=="2")
	 {
	 alert("账号或者密码输入错误");
	 }
	 	 })
	 
	})
	*/
</script>

</html>
