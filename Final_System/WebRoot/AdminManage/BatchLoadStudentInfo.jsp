<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<html>
	<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="lib/html5shiv.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="../standby/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>学生信息管理</title>
	</head>
	<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生信息管理  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			<form class="Huiform" action="BatchLoadStudentInformation"  method="post" enctype="multipart/form-data">
				<!--  <input type="text" placeholder="分类名称" value="" class="input-text" style="width:120px">
				-->
				
				<span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly style="width:200px"/>
				<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe600;</i> 选择文件</a>
				<input type="file" multiple name="upload" class="input-file"/>
				</span> 
				<!--
				<span class="select-box" style="width:150px">
				<select class="select" name="brandclass" size="1">
					<option value="1" selected>国内品牌</option>
					<option value="0">国外品牌</option>
				</select>
				-->
				</span><button type="submit" class="btn btn-success" id="" name="" onClick="picture_colume_add(this);"><i class="Hui-iconfont">&#xe642;</i> 确认上传</button>
			</form>
		</div>

		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="70">学生学号</th>
						<th width="80">学生姓名</th>
						<th width="200">所属专业</th>
						<th width="120">QQ号码</th>
						<th>学生毕业跟踪</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				 <s:iterator value="#session.AdminGetAllStudentInfo" var="AdminGetAllStudentInfo"> 
					<tr class="text-c">
						<td><input name="" type="checkbox" value=""></td>
						<td><s:property value="#AdminGetAllStudentInfo.CStuId" /></td>
						<td><s:property value="#AdminGetAllStudentInfo.CName" /></td>
						<td><s:property value="#AdminGetAllStudentInfo.CClass" /></td>
						<td class="text-l"><s:property value="#AdminGetAllStudentInfo.CQq" /></td>
						<td class="text-l"><s:property value="#AdminGetAllStudentInfo.CWorkunitOrSchool" /></td>
						<td class="f-14 product-brand-manage"><a title="编辑" href="javascript:;" onclick="member_edit('编辑','AlterContestInfo.jsp','4','','510')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"  href="AdminDeleteStudentInfo.action?student.CId=<s:property value="#AdminGetAllStudentInfo.CId" />" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../standby/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="../standby/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
	
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script> 
	<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
		]
	});
	function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
	</script>
	</body>
	</html>
}

