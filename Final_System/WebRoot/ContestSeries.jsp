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
<link rel="stylesheet" type="text/css" href="standby/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>浏览记录</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i><a href="body.jsp">首页</a> <span class="c-gray en">&gt;</span> 比赛系列  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	
	<!--  <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	-->
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
			
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="70">竞赛ID</th>
					<th width="50">竞赛名称</th>
					<th width="130">竞赛级别</th>
					<th width="90">主办方</th>
					<th width="100">承办方</th>
				    <th width="100">功能介绍</th>
				   
				</tr>
				</thead>
			<tbody>

				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛8</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=湖南省大学生计算机程序设计竞赛">湖南省大学生计算机程序设计竞赛</a></td>
					<td>省部级</td>
					<td>湖南省教育厅</td>
					<td>省内各大高校</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=湖南省大学生计算机程序设计竞赛">提供系列赛Echarts显示</a></td>
				</tr>
				
				 <tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛9</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=全国中医药院校程序设计竞赛">全国中医药院校程序设计竞赛</a></td>
					<td>全国中医药院校联赛</td>
					<td>中国中医药信息研究会、中国中医药信息研究会信息教育分会</td>
					<td>各省中医药大学</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=全国中医药院校程序设计竞赛">提供系列赛Echarts显示</a></td>
			</tr>
			
				 <tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛7</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=“中国软件杯”大学生软件设计大赛">“中国软件杯”大学生软件设计大赛</a></td>
					<td>国家级</td>
					<td>工业和信息化部、教育部、江苏省人民政府</td>
					<td>江苏省人民政府</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=“中国软件杯”大学生软件设计大赛">提供系列赛Echarts显示</a></td>
				 </tr>
				 
				 
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛6</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生服务外包创新创业大赛">中国大学生服务外包创新创业大赛</a></td>
					<td>国家级</td>
					<td>教育部、商务部</td>
					<td>江苏省无锡市政府</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生服务外包创新创业大赛">提供系列赛Echarts显示</a></td>
				</tr>
				
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛5</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=蓝桥杯全国软件和信息技术专业人才大赛">蓝桥杯全国软件和信息技术专业人才大赛</a></td>
					<td>国家级、省部级</td>
					<td>工业和信息化部</td>
					<td>各省份</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=蓝桥杯全国软件和信息技术专业人才大赛">提供系列赛Echarts显示</a></td>
				</tr>
				
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛1</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=ACM-ICPC">ACM-ICPC</a></td>
					<td>国际级、洲际级</td>
					<td>ACM竞赛的总部设在位于美国德克萨斯州的贝勒大学</td>
					<td>各国</td>
				<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=ACM-ICPC">提供系列赛Echarts显示</a></td>
				</tr>
				
				
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛2</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生计算机设计大赛">中国大学生计算机设计大赛</a></td>
					<td>国家级</td>
					<td>中国大学生程序设计竞赛组委会</td>
					<td>各省份</td>
				<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生计算机设计大赛">提供系列赛Echarts显示</a></td>
				</tr>
				
				
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛3</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生程序设计竞赛">中国大学生程序设计竞赛</a></td>
					<td>国家级</td>
					<td>中国大学生程序设计竞赛协会主办</td>
					<td>各省份</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国大学生程序设计竞赛">提供系列赛Echarts显示</a></td>
			</tr>
				
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td>系列赛4</td>
					<td><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国高校计算机大赛-团体程序设计天梯赛">中国高校计算机大赛-团体程序设计天梯赛</a></td>
					<td>国家级</td>
					<td>教育部高等学校计算机类专业教学指导委员会</td>
					<td>各省份</td>
					<td class="text-l"><a  target="_blank" href="EchartsGetContestSeriesName.action?echartsParameter=中国高校计算机大赛-团体程序设计天梯赛">提供系列赛Echarts显示</a></td>
			</tr>
		
			</tbody>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
});

/*用户-删除*/
function user_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script>
</body>
</html>