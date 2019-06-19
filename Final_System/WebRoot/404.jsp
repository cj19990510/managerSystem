<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">

<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<link rel="stylesheet" type="text/css"  href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"  href="standby/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"  href="standby/h-ui.admin/css/H-ui.admin.css" />
<title>404页面</title>
</head>
<body>
<section class="container-fluid page-404 minWP text-c">
	<p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
		<span class="va-m"> 404</span>
	</p>
	<p class="error-description">不好意思，您访问的页面不存在~</p>
	<p class="error-info">您可以：
		<a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a>
		<span class="ml-20">|</span>
		<a href="main.jsp" class="c-primary ml-20" target="_top">去首页 &gt;</a>
	</p>
</section>
</body>
</html>