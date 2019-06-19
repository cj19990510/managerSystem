<!--_meta 作为公共模版分离出去-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<!--/meta 作为公共模版分离出去-->

<title>基本设置</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span>
	学生管理
	<span class="c-gray en">&gt;</span>
	添加学生信息
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="AdminAddSingleStudentInfo" method="post" enctype="multipart/form-data">
		<div id="tab-system" class="HuiTab">
			<div class="tabBar cl">
				<span>学生基本信息</span>
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						学生学号：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentID" placeholder="" name="student.CStuId" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						学生姓名：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentName" placeholder="" name="student.CName" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						所属专业：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentClass" placeholder="" name="student.CClass" value="" class="input-text">
					</div>
				</div>
				
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						学生证件：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="file"  name="upload"  class="input-text">
					</div>
				</div>
				
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						QQ号码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentQQ" placeholder="" name="student.CQq" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						电话号码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentTel" placeholder="" name="student.CPhone" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">
						<span class="c-red">*</span>
						邮箱地址：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentEmail" placeholder="" name="student.CMail" value="" class="input-text">
					</div>
				</div>
				
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">学生信息跟踪：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="studentWork" placeholder="" name="student.CWorkunitOrSchool" value="" class="input-text">
					</div>
				</div>
			
			
			
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">允许访问后台的IP列表：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<textarea class="textarea" name="" id=""></textarea>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">后台登录失败最大次数：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="5" id="" name="" >
					</div>
				</div>
			</div>
			<div class="tabCon">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">邮件发送模式：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text"  class="input-text" value="" id="" name="">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">SMTP服务器：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">SMTP 端口：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="25" id="" name="" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">邮箱帐号：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="5" id="emailName" name="emailName" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">邮箱密码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="password" id="email-password" value="" class="input-text">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">收件邮箱地址：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" id="email-address" value="" class="input-text">
					</div>
				</div>
			</div>
			<div class="tabCon">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onmouseover="cheInput()" onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../standby/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../standby/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#tab-system").Huitab({
		index:0
	});
});
</script>
<script>
function cheInput(){
    var studentID = document.getElementById('studentID');
    var studentName = document.getElementById('studentName');
    var studentClass = document.getElementById('studentClass');
    var studentQQ = document.getElementById('studentQQ');
    var studentTel = document.getElementById('studentTel');
    var studentEmail = document.getElementById('studentEmail');
    var studentWork = document.getElementById('studentWork');
    if(studentID.value.length==0){
    alert("学生ID--不能为空");
    }
    if(studentName.value.length==0){
    alert("学生姓名--不能为空");
    }
    if(studentClass.value.length==0){
    alert("学生专业--不能为空");
    }
    if(studentQQ.value.length==0){
    alert("学生QQ--不能为空");
    }
    if(studentTel.value.length==0){
    alert("学生电话--不能为空");
    }
    if(studentEmail.value.length==0){
    alert("邮箱地址--不能为空");
    }
    if(studentWork.value.length==0){
    alert("毕业信息--不能为空");
    }
    

}
</script>
</body>
</html>
