<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/main.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
   function autoScroll(obj){
      $(obj).find('ul').animate({
         marginTop: '-2.8rem'
      },1000,function(){
         $(this).css({marginTop : "0px"});
         var li  =$("#new_ul").children().first().clone()
         $("#new_ul li:last").after(li);
         $("#new_ul li:first").remove();
      })
   }
   $(function(){
      setInterval('autoScroll("#news")',2000);
   }) 
</script>
<script type="text/javascript" src="js/global.js"></script>
<title>湖中大信科院学科竞赛管理系统</title>
<style>
</style>

</head>

<body>
	<div id="container">
		<div id="hd">
			<div class="hd-top">
				<h5 class="logo"></h5>
				<s:set name="studentMessage" value="#session.studentMessage"></s:set>

				<div class="setting ue-clear">
					<ul class="setting-main ue-clear">
						<li><a href="main.jsp">欢迎使用</a></li>
						<li><a href="StudentCenter.jsp" target="mainIframe"><s:property
									value="#studentMessage.CName" />同学</a></li>
						<li><a
							href="Student_Leader_GetAllWorkInfo.action?workMessage.CStuName=<s:property value="#studentMessage.CName"/>"
							target="mainIframe">我的作品</a></li>
						<li><a
							href="StudentGetSelfAttendContest.action?student.CName=<s:property value="#studentMessage.CName"/>"
							target="mainIframe">参赛记录</a></li>
						<li><a href="javascript:;" class="close-btn exit"></a>Exit</li>
					</ul>
				</div>
			</div>
			<br />
			<div id="news"
				style="background-color:white;height:
			2.0rem;overflow:hidden;line-height:40px;">
				<ul style="margin-top:0!important;margin-left: 20px" id="new_ul">
					<li><a href="#">恭喜无锡观光团在第十届服务外包大赛中获得全国二等奖</a></li>
					<li><a href="#">恭喜第三栋教学楼在第十届服务外包大赛中获得全国二等奖</a></li>
					<li><a href="#">恭喜无锡观光团在第十届服务外包大赛中获得全国二等奖</a></li>
					<li><a href="#">恭喜我校在ICCP女生专场中获得我校第一枚ACM金奖</a></li>
				</ul>
			</div>

		</div>

	</div>

	<!-- 中间部分 主体 -->
	<div id="bd">
		<iframe width="100%" height="100%" id="mainIframe" src="body.jsp"
			frameborder="0" name="mainIframe"></iframe>
	</div>

	<!-- 结束部分  -->
	<div id="ft" class="ue-clear">
		<div class="ft1 ue-clear">
			<i class="ft-icon1"></i> <span>湖南中医药大学 信息科学与工程学院 <a
				href="http://xxgc.hnucm.edu.cn/" target="_blank" title="">网址</a>
				友情链接&nbsp; <a href="http://www.hnucm.edu.cn/" title="网页模板"
				target="_blank"></a></span> <em><a href="http://www.hnucm.edu.cn/"
				target="_blank">more</a></em>
		</div>
		<div class="ft2 ue-clear">
			<span>By Asadal&nbsp;&nbsp;&nbsp;</span> <em>V1.0 2019</em>

		</div>
	</div>
	</div>

	<div class="exitDialog">
		<div class="content">
			<div class="ui-dialog-icon"></div>
			<div class="ui-dialog-text">
				<p class="dialog-content">你确定要退出系统？</p>
				<p class="tips">如果是请点击“确定”，否则点“取消”</p>

				<div class="buttons">
					<input type="button" class="button long2 ok" value="确定" /> <input
						type="button" class="button long2 normal" value="取消" />
				</div>
			</div>

		</div>
	</div>

	<div class="opt-panel user-opt" style="top:52px;left:330px;">
		<ul>
			<li><a class="text">用户资料</a></li>
			<li><a class="text">短消息<span class="num">(2)</span></a></li>
			<li><a class="text">资料信息</a></li>
			<li><a class="text">注销</a></li>
			<li><a class="text">自定义</a></li>
		</ul>
		<div class="opt-panel-tl"></div>
		<div class="opt-panel-tc"></div>
		<div class="opt-panel-tr"></div>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bl"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
		<div class="opt-panel-arrow"></div>
	</div>

	<div class="opt-panel skin-opt" style="top:36px;right:157px;">
		<ul class="ue-clear">
			<li attr-color="#0f8dc7"></li>
			<li attr-color="#1ea4a9"></li>
			<li attr-color="#eb7f00"></li>
			<li attr-color="#ed0f04"></li>
			<li attr-color="#f24b39"></li>
			<li attr-color="#ed0f04"></li>
			<li attr-color="#eb7f00"></li>
			<li attr-color="#ed0f04"></li>
			<li attr-color="#1ea4a9"></li>
		</ul>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bl"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
	</div>



</body>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript">
	$("#bd").height($(window).height() - $("#hd").outerHeight() - 26);

	$(window).resize(function(e) {
		$("#bd").height($(window).height() - $("#hd").outerHeight() - 26);

	});

	$('.exitDialog').Dialog({
		title : '提示信息',
		autoOpen : false,
		width : 400,
		height : 200
	});

	$('.exit').click(function() {
		$('.exitDialog').Dialog('open');
	});

	$('.exitDialog input[type=button]').click(function(e) {
		$('.exitDialog').Dialog('close');

		if ($(this).hasClass('ok')) {
			window.location.href = "login.html"	;
		}
	});

	(function() {
		var totalWidth = 0,
			current = 1;

		$.each($('.nav').find('li'), function() {
			totalWidth += $(this).outerWidth();
		});

		$('.nav').width(totalWidth);

		function currentLeft() {
			return -(current - 1) * 93;
		}

		$('.nav-btn a').click(function(e) {
			var tempWidth = totalWidth - (Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width());
			if ($(this).hasClass('nav-prev-btn')) {
				if (parseInt($('.nav').css('left').split('p')[0]) < 0) {
					current--;
					Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({
						'left' : currentLeft()
					}, 200) : $('.nav').animate({
						'left' : 0
					}, 200);
				}
			} else {

				if (tempWidth > 0) {

					current++;
					tempWidth > 93 ? $('.nav').animate({
						'left' : currentLeft()
					}, 200) : $('.nav').animate({
						'left' : $('.nav').css('left').split('p')[0] - tempWidth
					}, 200);
				}
			}
		});



		$.each($('.skin-opt li'), function(index, element) {
			if ((index + 1) % 3 == 0) {
				$(this).addClass('third');
			}
			$(this).css('background', $(this).attr('attr-color'));
		});

		$('.setting-skin').click(function(e) {
			$('.skin-opt').show();
		});

		$('.skin-opt').click(function(e) {
			if ($(e.target).is('li')) {
				alert($(e.target).attr('attr-color'));
			}
		});

		$('.hd-top .user-info .more-info').click(function(e) {
			$(this).toggleClass('active');
			$('.user-opt').toggle();
		});

		$('.logo-icon').click(function(e) {
			$(this).toggleClass('active');
			$('.system-switch').toggle();
		});

		hideElement($('.user-opt'), $('.more-info'), function(current, target) {

			$('.more-info').removeClass('active');
		});

		hideElement($('.skin-opt'), $('.switch-bar'));

		hideElement($('.system-switch'), $('.logo-icon'), function(current, target) {

			$('.logo-icon').removeClass('active');
		});
	})();
</script>
</html>
