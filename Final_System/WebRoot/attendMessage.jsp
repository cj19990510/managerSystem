<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />


<title>报名信息查询</title>
</head>

<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <div class="kv-item ue-clear">
                        <label>选择时间：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">自定义</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" placeholder="开始时间" />
                                <span class="division"></span>
                                <input type="text" placeholder="结束时间" />
                            </span>
                        </div>
                    </div>
                    <div class="kv-item ue-clear">
                        <label>选择类型:</label>
                        <div class="kv-item-content">
                            <select>
                                <option>全部</option>
                                <option>全部</option>
                                <option>全部</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="search-button">
                	<input class="button" type="button" value="搜索一下" />
                </div>
             </div>
             
            <div class="table">
            	<div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	<label>排序：</label>
                            <span class="name">
                            	<i class="icon"></i>
                                <span class="text">名称</span>
                            </span>
                        </span>
                        
                        <i class="list"></i>
                        <i class="card"></i>
                    </span>
                	<span class="optarea">
                        <a href="javascript:;" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:;" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>
                        
                        <a href="javascript:;" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>
                        
                        <a href="javascript:;" class="config">
                            <i class="icon"></i>
                            <span class="text">配置</span>
                        </a>
                    </span>
                </div>
                
                <div class="grid"></div>
                
                <div class="pagination"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
	$('select').select();
	var head = [{
				label: 'ID',
				width: 100,
				sortable: 'default',
				name: 'id'	
			},{
				label:'学生姓名',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
				label:'专业',
				width:150	
			},{
				label: '联系电话',
				width: 150	
			},{
				label: '报名比赛',
				minWidth: 200	
			},{
				label: '报名日期',
				width: 120	
			},{
				label: '是否审核',
				width:100	
			}];
			
	var oper = [{label:'删除',onclick:function(){
						alert('删除');
				}},{label:'编辑',onclick: function(){
					alert('编辑')	
				}}]
	var tbody = [
					["201301020112","汤亮","13级计算机科学与技术一班","18229653961","第七届蓝桥杯全国软件和信息技术专业人才大赛","2016-10-18","已审核",oper], 
					["201301020233","陈川","13级计算机科学与技术二班","18265923985","第七届蓝桥杯全国软件和信息技术专业人才大赛","2016-10-08","已审核",oper],
					["201501020122","付元礼","2015计算机科学与技术","18229973941","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper],
					["201501020128","莫文燕","2015计算机科学与技术","18536985247","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper], 
					["201501020128","肖飞宇","2015计算机科学与技术","15963285549","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper],
					["201501020112","江民喜","2015计算机科学与技术","15366985741","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper],
					["201501020105","吕月盈","2015计算机科学与技术","15366985624","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper], 
					["201501020137","王慧","2015计算机科学与技术","15866359852","第八届中国大学生服务外包创新创业大赛","2018-04-20","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper], 
					["201302","uimaker","小牛","山东济南","山东大学","1989-10-18","已审核",oper],
					["201301","admin","熊猫王子","江苏南京","南京林业大学","1982-10-18","已审核",oper]]
					
					
		$('.grid').Grid({
			thead: head,
			tbody: null,
			height:400,
			checkbox: {
				single:true	
			},
			operator: {
				type : "normal",
				width : 100	
			},
			sortCallBack : function(name,index,type){
				alert(name+","+index+','+type);
			}
			
		});
	
	$('.grid').Grid('addLoading');
	
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},2000)
	
	
	$('.pagination').pagination(100,{
		callback: function(page){
			alert(page);	
		},
		display_msg: false
	});
	
	$('.search-box input[type=radio]').click(function(e) {
        if($(this).prop('checked')){
			if($(this).attr('data-define') === 'define'){
				$('.define-input').show();
			}else{
				$('.define-input').hide();
			}
		}
    });
</script>
</html>
