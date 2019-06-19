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
 
          
    <form id="my-form" action="StudentAlterSelfInfo" method="post" enctype="multipart/form-data" >
    <section name="我的信息">
          <input name="student.CId"  type="hidden" value="<s:property value="#studentMessage.CId"></s:property>" />
          <input name="student.CPasswd"  type="hidden" value="<s:property value="#studentMessage.CPasswd"></s:property>" />
          <input name="student.CIdentityCard"  type="hidden" value="<s:property value="#studentMessage.CIdentityCard"></s:property>" />
          <div><label>学号:</label> <input name="student.CStuId" type="text" readonly  unselectable="on" value="<s:property value="#studentMessage.CStuId"></s:property>" /></div>
          <div><label>姓名:</label> <input name="student.CName"  type="text" readonly  unselectable="on" value="<s:property value="#studentMessage.CName"></s:property>" /></div>
         <div><label>班级:</label><input name="student.CClass" type="text"  value="<s:property value="#studentMessage.CClass"></s:property>" /></div>
          <div><label>电话:</label><input name="student.CPhone" type="text"  value="<s:property value="#studentMessage.CPhone"></s:property>" /></div>
          <div><label>QQ:</label><input name="student.CQq" type="text"  value="<s:property value="#studentMessage.CQq"></s:property>" /></div>
          <div><label>Email:</label><input name="student.CMail" data-ideal="required email" type="email"  value="<s:property value="#studentMessage.CMail"></s:property>" /></div>
          <div><label>就业情况:</label><input name="student.CWorkunitOrSchool" type="text"  value="<s:property value="#studentMessage.CWorkunitOrSchool"></s:property>" /></div>
          <div><label>证件修改:</label><input type="file"  name="upload" /></div>
          </br></br></br></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <span class="kv-item-tip" style="left:3200px; padding-left: 0px;"><img onclick="prewImg(this)"  width="300px" height="280px" alt="" src="<s:property value="#studentMessage.CIdentityCard"></s:property>">
           </br></br>&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp; <span> 证件照片</span>
  </section>
  
  <a href="StudentAlterPasswd.jsp">
  修改个人密码
  </a>
  
    
     <div><hr/></div>
       <center>
       <div>
        <button type="submit">修改</button>
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
<div style="text-align:center;">
<p>湖中大信息科学与工程学院<a href="http://www.hnucm.edu.cn/info/1041/1086.htm" target="_blank" title="">友情链接</a> - Collect from Asadal</p>
</div>
</body>
</html>