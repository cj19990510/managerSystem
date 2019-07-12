<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit">
		<title>课程管理</title>
		<link rel="stylesheet" type="text/css" href="css/contest_css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/contest_css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="css/contest_css/common.css">
		<link rel="stylesheet" type="text/css" href="css/contest_css/examMng/core.css">
		<link rel="stylesheet" href="css/contest_css/examMng.css" />
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../../js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->
				
		<script type="text/javascript">
			window.jQuery || document.write("<script src='js/jquery-1.8.2.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript" src="js/contest_js/respond.js"></script>
		<script type="text/javascript" src="js/contest_js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/contest_js/nav.js"></script>
		<script type="text/javascript" src="js/contest_js/jquery.selectlist.js" ></script>
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
		
		
		  <s:set name="StudentGetSingleContest" value="#session.StudentGetSingleContest"></s:set>
		<!--body begin-->
		<form>
		<div class="main-container">
			<div class="container body-box" style="width:980px;height:670px;" >  <!-- 大背景框 大小 -->
				<div class="info-add-box">竞赛信息：</div>
				<div class="content-box" style="width:980px;height:430px;">
					<div class="overflow" style="width:980px;height:430px;">
						<div class="col-lg-10 col-md-10" style="padding:0;width:570px;"><!-- 文本框 的大小 -->
						
						<div class="input-group input-group-lg tk-title">
								<span class="input-group-addon" id="sizing-addon1">&nbsp;&nbsp;&nbsp;竞赛名称</span>
								<input value="<s:property value="#StudentGetSingleContest.CName"/>"  readonly  unselectable="on" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon1" onblur="tijiao(this)">
							</div>
							
							<div class="input-group input-group-lg tk-title">
								<span class="input-group-addon" id="sizing-addon1">&nbsp;&nbsp;竞赛级别&nbsp;</span>
								<input value="<s:property value="#StudentGetSingleContest.CLevel"/>" readonly  unselectable="on"  type="text" class="form-control" placeholder="" aria-describedby="sizing-addon1" onblur="tijiao(this)">
							</div>
							
							<div class="input-group input-group-lg tk-title">
								<span class="input-group-addon" id="sizing-addon1">&nbsp;&nbsp;主办方&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<input value="<s:property value="#StudentGetSingleContest.CSponsorUnit"/>" readonly  unselectable="on" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon1" onblur="tijiao(this)">
							</div>
							
							<div class="input-group input-group-lg tk-title">
								<span class="input-group-addon" id="sizing-addon1">&nbsp;&nbsp;举办方&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<input value="<s:property value="#StudentGetSingleContest.COrganizerUnit"/>" readonly  unselectable="on" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon1" onblur="tijiao(this)">
							</div>
							
							<div class="input-group input-group-lg tk-title tk-introduction">
								<span class="input-group-addon" id="sizing-addon1">&nbsp;竞赛简介&nbsp;&nbsp;</span>
								<textarea  type="text" class="form-control" placeholder="" readonly  unselectable="on" aria-describedby="sizing-addon1" onblur="tijiao(this)"><s:property value="#StudentGetSingleContest.CIntroduction"/></textarea>
							</div>
						</div>
						
						<div class="col-lg-2 col-md-2" style="padding-right:0; height:100px;" >
							<a href="javascript:file_upload.click()">
								<img onclick="prewImg(this)" style="height:320px;;width:350px;" src="<s:property value="#StudentGetSingleContest.CPicture"/>">
								
							</a>
						</div>	
						
						</div>
					<div class="line-bottom"></div>
					<div class="tipbox">
						<span class="tip">提示：</span>
						<span>详细信息请见赛事官网</span>
					</div>
					
					
				
				</div>
			</div>
		</div>
		</form>
		<!--body end-->
		
		<!--不能为空-->
		<div id="baocun" class="modal fade" tabindex="-1">
		    <div class="modal-dialog" style="width: 300px">
		        <div class="modal-content">
		        	<!--不能为空header开始-->
		            <div class="modal-header">
		                <div class="table-header border-top-radius">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
		                        <span class="white">&times;</span>
		                    </button>
		                    	&nbsp;
		                </div>
		            </div>
		        	<!--删除header结束-->
		        	<!--删除body开始-->
		            <div class="modal-body">
		            	<div class="text-center">
		            		不能为空
		                </div>
		            </div>
		        	<!--删除body结束-->
		        	<!--删除footer开始-->
		            <div class="modal-footer">
		            	<button class="btn btn-sm btn-success" data-dismiss="modal" id="sure-close">
		                    <i class="icon-ok"></i>确定
		                </button>
		                <button class="btn btn-sm btn-danger" data-dismiss="modal">
		                    <i class="icon-remove"></i>取消
		                </button>
		            </div>
		        	<!--删除footer结束-->
		        </div>
		    </div>
		</div>
		<!--不能为空-->
		
	
		
		<script>
			var nums = 0;
			$(function() {
				$('#itemDate').selectlist({
					zIndex: 10,
					height: 60,
					onChange: null
			});	
			})			
			
			$(document).ready(function(){
				nums = $(".main-container .info-add").length;
				footer_position();
				//当浏览器窗口大小改变时，设置显示内容的高度  
				$(window).resize(function(){
					footer_position();
				});
			});
			function footer_position(){
				var winHeight = $(window).height();
				var myHeight = winHeight-60-82-20;
				//alert(myHeight+"-"+$(".main").height());
				if($(".main-container").height() <= myHeight){
					$(".kw-footer").css("position","fixed");
					$(".kw-footer").css("bottom","0");
					$(".main-container").css("min-height",myHeight+"px");
				}else{
					$(".kw-footer").css("position","initial");
				}
			}
		</script>
		
	</body>
</html>
