<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>报名参赛页面</title>
<link href="css/normalize.css" rel="stylesheet"/>
<link href="css/jquery-ui.css" rel="stylesheet"/>
<link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
<link rel="stylesheet" type="text/css" href="standby/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/style.css" />
<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:6px 0 0 0;}
#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:32px;box-shadow:0 0 0px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>
<script type="text/javascript">
function prewImg(imgEle){
	$(".back").css("display","block");
	$("#prewImg").attr("src",$(imgEle).attr("src"));
}
function canclePrew(){
	$(".back").css("display","none");
	$("#prewImg").attr("src","")
}
</script>
<style>
.back {
	display: none;
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1000;
	filter: alpha(opacity = 70);
	text-align: center;
}
 
.center {
	width: 80%;
	margin: 5% auto;
	z-index: 1001;
	height: 80%;
	width: 80%;
	margin: 5% auto;
}
</style>

</head>
<body>
<div class="back" onclick="canclePrew()">
<div class="center">
<img alt="" src="" width="60%" height="100%" id="prewImg">
</div>
</div>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i><a href="body.jsp">首页</a> <span class="c-gray en">&gt;</span> 个人中心  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:0px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="row">

  <div class="eightcol last">

    <!-- Begin Form -->
    <s:set name="studentMessage" value="#session.studentMessage"></s:set>
 
          
    <form id="my-form" action="StudentAlterPasswd" method="post" target="_top">
   <section name="2.修改密码">
           <div><label>学生学号:</label> <input name="student.CStuId"  readonly  unselectable="on"  type="text"  value="<s:property value="#studentMessage.CStuId"/>" /></div>
           <div><label>请输入旧密码:</label> <input name="student.CPasswd" id="studentOldPasswd" type="password" /></div>
          <div><label>请输入新密码:</label> <input name=""  id="studentNewPasswd1" type="password" /></div>
          <div><label>请确认新密码:</label><input name="newPasswd"  id="studentNewPasswd2" type="password"/></div>
          
    </section>
    
     <div><hr/></div>
       <center>
       <div>
        <button onmouseover="cheInput()" type="submit">确认修改</button>
        <button id="reset" type="button">重置</button>
      </div>
      </center>
       </form>
  <!-- End Form -->

  </div>

</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript">
var options = {

	onFail: function(){
		alert( $myform.getInvalid().length +'å¤  éæ³å­æ®µ. Please check it.' )
	},

	inputs: {
		'password': {
			filters: 'required pass',
		},
		'username': {
			filters: 'required username',
			data: {
			//ajax: { url:'validate.php' }
			}
		},
		'file': {
			filters: 'extension',
			data: { extension: ['jpg'] }
		},
		'comments': {
			filters: 'min max',
			data: { min: 50, max: 200 }
		},
		'states': {
			filters: 'exclude',
			data: { exclude: ['default'] },
			errors : {
				exclude: 'éæ©å½ç±.'
			}
		},
		'langs[]': {
			filters: 'min max',
			data: { min: 2, max: 3 },
			errors: {
				min: 'Check at least <strong>2</strong> options.',
				max: 'No more than <strong>3</strong> options allowed.'
			}
		}
	}
	
};

var $myform = $('#my-form').idealforms(options).data('idealforms');

$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});

$myform.focusFirst();
</script>
<script>
function cheInput(){
    var studentOldPasswd = document.getElementById('studentOldPasswd');
    var studentNewPasswd1 = document.getElementById('studentNewPasswd1');
    var studentNewPasswd2 = document.getElementById('studentNewPasswd2');

   
    if(studentOldPasswd.value.length==0){
    alert("studentOldPasswd--不能为空");
    }
    if(studentNewPasswd1.value.length==0){
    alert("studentNewPasswd1--不能为空");
    }
    if(studentNewPasswd2.value.length==0){
    alert("studentNewPasswd2--不能为空");
    }
    if(studentNewPasswd2.value==studentNewPasswd1.value){
    }else{
    alert("两次密码不一致");
    }

}
</script>
<div style="text-align:center;">
</div>
</body>
</html>