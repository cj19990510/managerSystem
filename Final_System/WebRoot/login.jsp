<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<link href="css/jquery.idcode.css" type="text/css" rel="stylesheet">
<script src="js/jquery.idcode.js"></script>
	<script>
		$(document).ready(function() {
			$.idcode.setCode(); //加载生成验证码方法
			$("form").submit(function() {
		
				var IsBy = $.idcode.validateCode() //调用返回值，返回值结果为true或者false
				if (!IsBy) {
					alert("验证码错误，请注意大小写")
					return false;
				}
			})
			$("#idcode").click(function(){
			    $.idcode.setCode();
			})
		})
	</script>
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
								id="Txtidcode" class="txtVerification"> <span
								id="idcode" class="image"></span> <!-- class="image" id="randCode" /> -->
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
</script>

</html>
