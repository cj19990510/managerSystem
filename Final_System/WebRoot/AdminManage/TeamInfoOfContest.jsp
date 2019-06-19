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
	<script type="text/javascript">
    function base64 (content) {
       return window.btoa(unescape(encodeURIComponent(content)));         
    }
    /*
    *@tableId: table??Id
    *@fileName: ?????excel?????????????????????????????д??
    */
    function tableToExcel(tableID,fileName){
        var table = document.getElementById(tableID);
      var excelContent = table.innerHTML;
      var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
      excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
      excelFile += "<body><table>";
      excelFile += excelContent;
      excelFile += "</table></body>";
      excelFile += "</html>";
      var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
      var a = document.createElement("a");
      a.download = fileName+".xls";
      a.href = link;
      a.click();
    }
</script>
	</head>
	<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 竞赛信息管理 <span class="c-gray en">&gt;</span> 队伍管理<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a  class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 队伍信息</a>  <a href="AdminGetAllPersonOfContestByContestName.action?works.CContestName=<s:property value="#session.contestNameprocess"/>" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 查看所有人员信息</a></span> <span class="r"><strong>提示：点击  队伍名称   可查看对应队伍成员</strong></span> </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-sort" id="batchloadInfo">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="70">ID</th>
						<th width="200">比赛名称</th>
						<th width="200">队伍名称</th>
						<th width="120">队长名称</th>
						<th>是否通过审核</th>
						<th>审核时间</th>
						
					</tr>
				</thead>
				<tbody>
				 <s:iterator value="#session.AdminGetTeamInfoByContestName" var="AdminGetTeamInfoByContestName"> 
					<tr class="text-c">
						<td><input name="" type="checkbox" value=""></td>
						<td><s:property value="#AdminGetTeamInfoByContestName.CId" /></td>
						<td><s:property value="#AdminGetTeamInfoByContestName.CContestName" /></td>
						<td><a href="AdminGetPersonOfTeamByContestName.action?works.CContestName=<s:property value="#AdminGetTeamInfoByContestName.CContestName"/>&&works.CTeamName=<s:property value="#AdminGetTeamInfoByContestName.CTeamName"/>"><s:property value="#AdminGetTeamInfoByContestName.CTeamName" /></a></td>
						<td class="text-l"><s:property value="#AdminGetTeamInfoByContestName.CStuName" /></td>
						<td class="text-l"><s:property value="#AdminGetTeamInfoByContestName.CChecked" /></td>
						<td class="text-l"><s:property value="#AdminGetTeamInfoByContestName.CCheckedTime"/></td>
						</tr>
					</s:iterator>
			</tbody>
			</table>
			
			<button  class="btn btn-primary upload-btn" type="button" onclick="tableToExcel('batchloadInfo','data')">导出Excel表格</button>
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


