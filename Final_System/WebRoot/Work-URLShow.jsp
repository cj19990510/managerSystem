<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="standby/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="standby/h-ui.admin/css/style.css" />
<title>浏览记录</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i><a href="body.jsp">首页</a> <span class="c-gray en">&gt;</span> 优秀作品URL展示列表  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	
	<!--  <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	-->
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
			
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="80">竞赛ID</th>
					<th width="80">竞赛名称</th>
					<th width="90">队伍名称</th>
					<th width="100">队长名称</th>
					<th width="130">所获奖项</th>
					<th>系统演示URL</th>
					<th width="60">操作</th>
				</tr>
				</thead>
			<tbody>
			 <s:iterator value="#session.studentAllWorks" var="studentAllWorks"> 
				<tr class="text-c">
					<td><input type="checkbox" value="1" name=""></td>
					<td><s:property value="#studentAllWorks.CId" /></td>
					<td><a href="StudentGetSingleContest.action?contest.CName=<s:property value="#studentAllWorks.CContestName"/>&&student.CName=pass"><s:property value="#studentAllWorks.CContestName" /></a></td>
					<td><s:property value="#studentAllWorks.CTeamName" /></td>
					<td><s:property value="#studentAllWorks.CStuName" /></td>
					<td><s:property value="#studentAllWorks.CPrize" /></td>
					<a><td class="text-l"><s:property value="#studentAllWorks.CWorksShow" /></td></a>
					<!-- <td class="f-14"><a title="删除" href="javascript:;" onclick="user_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				      -->
				     <td class="f-14"><a href="<s:property value="#studentAllWorks.CWorksShow"/>" target="_blank">访问作品URL</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				     
				</tr>
				</s:iterator>
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