<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/index.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>

<title>Body Web</title>
</head>
<script>
	/*$(window).load(function() {
		$.ajax({
			type : "get",
			url : "MainDemoShow.action",
			async : false,
		});
	})*/
</script>
<body>
 <s:set name="studentMessage" value="#session.studentMessage"></s:set>
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
    	<div id="main">
            <ul class="nav-list ue-clear">
            	<li class="nav-item desk">
                	<a href="StudentGetCurrentContestAndTeacherInfo.action?student.CName=<s:property value="#studentMessage.CName"/>" >
                        <p class="icon"></p>
                        <p class="title">报名参赛</p>
                    </a>
                </li>
                <li class="nav-item news">
                	<a>
                        <p class="icon"></p>
                        <p class="title">新闻资讯</p>
                    </a>
                </li>
                <li class="nav-item notice">
                	<a>
                        <p class="icon"></p>
                        <p class="title">公告通知</p>
                    </a>
                </li>
                
                 <li class="nav-item logs">
                	<a>
                        <p class="icon"></p>
                        <p class="title">交流讨论</p>
                    </a>
                </li>
               
                 <li class="nav-item fav">
                	<a href="StudentGetAllWorkInfo.action?student.CName=<s:property value="#studentMessage.CName"/>" >
                        <p class="icon"></p>
                        <p class="title">优秀作品</p>
                    </a>
                </li>
                <li class="nav-item plan">
                	<a href="StudentGetExperience.action?student.CName=<s:property value="#studentMessage.CName"/>">
                        <p class="icon"></p>
                        <p class="title">经验分享</p>
                    </a>
                </li>
                 
                <li class="nav-item contacts">
                	<a href="StudentGetAllFormalStudentMessage.action?student.CName=<s:property value="#studentMessage.CName"/>">
                        <p class="icon"></p>
                        <p class="title">通讯录</p>
                    </a>
                </li>
                
                <!-- 
                <li class="nav-item mail">
                	<a href="index.html">
                        <p class="icon"></p>
                        <p class="title">我的邮件</p>
                    </a>
                </li>
                 -->
               
                <li class="nav-item dosthings">
                	<a>
                        <p class="icon"></p>
                        <p class="title">报名截止</p>
                    </a>
                </li>
              
                
                <li class="nav-item browser">
                	<a href="ContestSeries.jsp">
                        <p class="icon"></p>
                        <p class="title">Echarts</p>
                       
                    </a>
                </li> 
            </ul>
            
            <ul class="content-list">
            	<li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">数据统计</span>
                        
                    </h2>
                    <div class="content-bd" id="echarts_test">
                    	
                    </div>
                </li>
                <li class="content-item dothings">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">国家级比赛</span>
                    </h2>
                    
                   
                    <div class="content-bd">
                    	<ul class="content-list things">
                    	 <s:iterator value="#session.MainDemoNationalContestInfo" var="MainDemoNationalContestInfo"> 
                               <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="StudentGetSingleContest.action?contest.CName=<s:property value="#MainDemoNationalContestInfo.CName"/>&&student.CName=<s:property value="#studentMessage.CName"/>"><s:property value="#MainDemoNationalContestInfo.CName" /></a>
                              </li>
                          </s:iterator>
                        </ul>
                    </div>
                </li>
                <li class="content-item richeng">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">省级比赛</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                    	  <s:iterator value="#session.MainDemoProvincinalContestInfo" var="MainDemoProvincinalContestInfo"> 
                             <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="StudentGetSingleContest.action?contest.CName=<s:property value="#MainDemoProvincinalContestInfo.CName" />&&student.CName=<s:property value="#studentMessage.CName"/>" ><s:property value="#MainDemoProvincinalContestInfo.CName" /></a>
                             </li>
                        </s:iterator>
                          </ul>
                    </div>
                </li>
                
                <li class="content-item system">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">数据统计</span>
                    </h2>
                    <div class="content-bd">
                    	<img src="img/skin_/pic2.png" />
                    </div>
                </li>
                
                
                <li class="content-item news">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">新闻资讯</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                    	 <s:iterator value="#session.MainDemoNewsInfo" var="MainDemoNewsInfo"> 
                    	 <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="<s:property value="#MainDemoNewsInfo.CNewsUrl" />" target="_blank"><s:property value="#MainDemoNewsInfo.CNewsName" /></a>
                            </li>
                    	 </s:iterator>
                    	  </ul>
                    </div>
                </li>
                
                
                
                <li class="content-item news">
                	<h2 class="content-hd">
                    	<span class="opt">
                        	<span class="refresh" title="刷新"></span>
                            <span class="setting" title="设置"></span>
                            <span class="report" title="导出"></span>
                            <span class="close" title="关闭"></span>
                        </span>
                    	<span class="title">讨论交流</span>
                    </h2>
                    <div class="content-bd">
                    	<ul class="content-list things">
                        	<li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">肖鹏学长经验交流</a>
                                
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">2019年第八届软件杯，请进！</a>
                            </li>
                            <li class="content-list-item">
                            	<i class="icon"></i>
                                <a href="javascript:;">抱团参赛 服务外包~</a>
                            </li>
                           
                        </ul>
                    </div>
                    
                    </li>
            </ul>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
	var minwidth = 282;
	resizeWidth();
	$(top.window).resize(function(e) {
       resizeWidth();
    });
	$(function() {
		$( ".content-list" ).sortable({
		  revert: true,
		  handle:'h2'
		});
		
	});
	
function resizeWidth (){
	if($('#main').width() / 3 < minwidth){
		$('.content-item').width(($('#main').width() / 2) - 15);
	}else{
		$('.content-item').width(($('#main').width() / 3) - 15);	
	}
		
}
</script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('echarts_test')); 
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['计科'],
                        data:['医信']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : ["2013","2014","2015","2016","2017","2018"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    grid: [{
                      top:"10px",
                      left:"10px",
                      right:"15px",
                      bottom:"50px"
                  }],

                    series : [
                        {
                            "name":"计科",
                            "type":"bar",
                            "data":[5, 8, 15, 16, 18, 11]
                        },
                        {
                            "name":"医信",
                            "type":"bar",
                            "data":[2, 3, 8, 12, 15, 13]
                        }
                       
                    ]
                };
        
                // 为echarts对象加载数据 
                    
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    </script>
   
</html>
