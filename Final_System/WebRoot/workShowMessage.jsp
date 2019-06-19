<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
<link href="umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
window.UMEDITOR_HOME_URL = 'umeditor/';  // 请换成绝对路径
</script>
<script type="text/javascript" src="js/umeditor.config.js"></script>
<script type="text/javascript" src="js/editor_api.js"></script>
<script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
<title>比赛总结</title>
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
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
      <s:set name="studentSingleWork" value="#session.studentSingleWork"></s:set>
      <form  method="post">
    	<div id="main">
            <h2 class="subfild">
            	<span>比赛结果</span>
            </h2>
            <div class="subfild-content base-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>比赛名称</label>
                	<div class="kv-item-content">
                    	<input type="text" placeholder="暂无信息" readonly  unselectable="on" name="workMessage.CContestName" value="<s:property value="#studentSingleWork.CContestName"/>" />
                    	
                    </div>
                    <span class="kv-item-tip"></span>
                    <span class="kv-item-tip"><img onclick="prewImg(this)"  width="200px" height="180px" alt="" src="<s:property value="#studentSingleWork.CAwardCertificate"/>">
                    <span class="kv-item-tip"><img onclick="prewImg(this)"  width="200px" height="180px" alt="" src="<s:property value="#studentSingleWork.CTeamPicture"/>">
                   
                    </span>
                    	
                </div>
                <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>队长名称</label>
                	<div class="kv-item-content">
                    	<input type="text"  readonly  unselectable="on" name="workMessage.CStuName" placeholder="暂无信息" value="<s:property value="#studentSingleWork.CStuName"/>" />
                    </div>
                    <span class="kv-item-tip"></span>
                </div>
                <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>队伍名称</label>
                	<div class="kv-item-content">
                    	<input type="text" readonly  unselectable="on" placeholder="暂无信息" name="workMessage.CTeamName" value="<s:property value="#studentSingleWork.CTeamName"/>" />
                    </div>
                    <span class="kv-item-tip"></span>
                </div>
                
                 <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>所获奖项</label>
                	<div class="kv-item-content">
                    	<input type="text" placeholder="暂无信息" readonly  unselectable="on" name="workMessage.CPrize" value="<s:property value="#studentSingleWork.CPrize"/>" />
                    </div>
                    <span class="kv-item-tip"></span>
                    </div>
            </div>
            
             <h2 class="subfild">
            	<span>作品交流</span>
            </h2>
            
             <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>展示地址</label>
                	<div class="kv-item-content">
                    	<input type="text" placeholder="暂无信息" readonly  unselectable="on" name="workMessage.CWorksShow" value="<s:property value="#studentSingleWork.CWorksShow"/>" />
                    </div>
                    <span class="kv-item-tip"></span>
                </div>
                 <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>保存地址</label>
                	<div class="kv-item-content">
                    	<input type="text" placeholder="暂无信息"  readonly  unselectable="on" name="workMessage.CWorksAddress" value="<s:property value="#studentSingleWork.CWorksAddress"/>" />
                    </div>
                    <span class="kv-item-tip">请不要随意泄露作品地址信息</span>
                </div>
                
                <div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>保存地址密码</label>
                	<div class="kv-item-content">
                    	<input type="text" placeholder="暂无信息" readonly  unselectable="on" name="workMessage.CWorksPasswd" value="<s:property value="#studentSingleWork.CWorksPasswd"/>" />
                    </div>
                    <span class="kv-item-tip">请不要泄露密码，仅供本校参赛学生使用</span>
                </div>
            
            </br>
            <h2 class="subfild">
            	<span>经验交流</span>
            </h2>
            
            <div class="subfild-content remarkes-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>参赛心得</label>
                	<div class="kv-item-content">
                    	<textarea placeholder="文章内容" id="content"  disabled="disabled" style="width:800px;height:240px;" name="workMessage.CExperience"><s:property value="#studentSingleWork.CExperience"/></textarea>
                    </div>
                </div>
            </div>
            
         
            </div>
        </form>
    </div>
</div>
</body>

<script type="text/javascript">
	$('select').select();
	showRemind('input[type=text],textarea','color5');
	UM.getEditor('content');
</script>
</html>
