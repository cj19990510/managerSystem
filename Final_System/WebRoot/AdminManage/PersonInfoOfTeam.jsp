<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<html>
	<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="../standby/h-ui.admin/css/style.css" />
	<title>竞赛信息管理</title>
	</head>
	<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 竞赛信息管理<span class="c-gray en">&gt;</span> 队伍管理<span class="c-gray en">&gt;</span> 队伍详细信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a  class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 队伍详细信息</a></span> <span class="r"><strong>提示：点击  学生姓名   可查看学生详细信息</strong></span> </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="70">ID</th>
						<th width="200">比赛名称</th>
						<th width="200">队伍名称</th>
						<th width="120">队员名称</th>
						<th>是否通过审核</th>
						<th>审核时间</th>
						<th>操作</th>
						
						
					</tr>
				</thead>
				<tbody>
				 <s:iterator value="#session.PersonOfTeamInfo" var="PersonOfTeamInfo"> 
					<tr class="text-c">
						<td><input name="" type="checkbox" value=""></td>
						<td><s:property value="#PersonOfTeamInfo.CId" /></td>
						<td><s:property value="#PersonOfTeamInfo.CContestName" /></td>
						<td><s:property value="#PersonOfTeamInfo.CTeamName" /></td>
						<td class="text-l"><s:property value="#PersonOfTeamInfo.CStuName" /></td>
						<td class="text-l"><s:property value="#PersonOfTeamInfo.CChecked" /></td>
						<td class="text-l"><s:property value="#PersonOfTeamInfo.CCheckedTime" /></td>
						<td class="text-l">
						<s:if test="#PersonOfTeamInfo.CChecked=='通过审核'"><a href="AdminUnThroughCheckedTeamByWorkId.action?works.CId=<s:property value="#PersonOfTeamInfo.CId" />&works.CTeamName=<s:property value="#PersonOfTeamInfo.CTeamName" />&works.CContestName=<s:property value="#PersonOfTeamInfo.CContestName"/>&works.CCheckedTeacherName=<s:property value="#manageMessage.CName"/>">驳回审核</a></s:if>
						<s:if test="#PersonOfTeamInfo.CChecked=='未通过'"><a href="AdminThroughCheckedTeamByWorkId.action?works.CId=<s:property value="#PersonOfTeamInfo.CId" />&works.CTeamName=<s:property value="#PersonOfTeamInfo.CTeamName" />&works.CContestName=<s:property value="#PersonOfTeamInfo.CContestName" />&works.CCheckedTeacherName=<s:property value="#manageMessage.CName"/>">通过审核</a></s:if>
						
						</td>					
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../standby/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="../standby/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
	
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script> 
	<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
		]
	});
	
	function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
	</script>
	</body>
	</html>


