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
<script type="text/javascript" src="js/global.js"></script>
<title>湖中大信科院学科竞赛管理系统</title>
<style>
.marquee {
	width: 100%;
	height: 50px;
	align-items: center;
	color: #3A3A3A;
	background-color: #b3effe;
	display: flex;
	box-sizing: border-box;
}

.marquee_title {
	padding: 0 20px;
	height: 30px;
	font-size: 14px;
	border-right: 1px solid #d8d8d8;
	align-items: center;
}

.marquee_box {
	display: block;
	position: relative;
	width: 60%;
	height: 30px;
	overflow: hidden;
}

.marquee_list {
	display: block;
	position: absolute;
	top: 0;
	left: 0;
}

.marquee_top {
	transition: all 0.5s;
	margin-top: -30px
}

.marquee_list li {
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	padding-left: 20px;
}

.marquee_list li span {
	padding: 0 2px;
}

.red {
	color: #FF0101;
}
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

			<div class="vueBox">
				<div class="marquee">
					<div class="marquee_title">
						<span>最新消息</span>
					</div>
					<div class="marquee_box">
						<ul class="marquee_list" :class="{marquee_top:animate}">
							<li v-for="(item, index) in marqueeList"><span>{{item.name}}</span>
								<span>在</span> <span class="red"> {{item.city}}</span> <span>获得</span>
								<span class="red"> {{item.amount}}</span> <span>奖</span></li>
						</ul>
					</div>
				</div>
			</div>

			<script type="text/javascript" src="js/vue.min.js"></script>
			<script type="text/javascript">
				const vm = new Vue({
					el : ".vueBox",
					data : {
						animate : false,
						marqueeList : [
							{
								name : '恭喜我院 枸杞泡咖啡队',
								city : '第十届中国大学生服务外包创新创业大赛',
								amount : '全国一等'
							},
							{
								name : '恭喜我院 第三教学楼',
								city : '第十届中国大学生服务外包创新创业大赛',
								amount : '全国一等'
							},
							{
								name : '恭喜我院 无锡观光团',
								city : '第十届中国大学生服务外包创新创业大赛',
								amount : '全国二等'
							},
							{
								name : '我校  ACM一队 ',
								city : '第三届全国中医药院校大学生程序设计竞赛 ',
								amount : '一等'
							},
							{
								name : '我院学子',
								city : '省第二届大学生网络安全技能竞赛中斩获佳绩',
								amount : '湖南省二等'
							}
						]
					},
					created : function() {
						setInterval(this.showMarquee, 2000);
					},
					methods : {
						showMarquee : function() {
							this.animate = true;
							setTimeout(() => {
								this.marqueeList.push(this.marqueeList[0]);
								this.marqueeList.shift();
								this.animate = false;
							}, 500)
						},
					}
				});
			</script>


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
