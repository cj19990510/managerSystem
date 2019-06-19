<%@ page language="java" import="java.util.*" import ="org.vo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title>竞赛 ECharts 显示</title>
    <script src="js/jquery_e.js" type="text/javascript"></script>
    <script src="js/echarts.min.js" type="text/javascript"></script>
    
    <style type="text/css">
        html, body, #main { height: 100%; width: 100%; margin: 0; padding: 0 }
    </style>
</head>
<body>            
   
   
    <div id="main" style=""></div>  <!--定义了 100%长宽的div容器-->
   
   <input type="hidden" id="echartsParameter" value="<s:property value="#session.echartsParameter"/>" /> 
   
    <script type="text/javascript">
        var echartsParameter = $("#echartsParameter").val();
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
           backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
             offset: 0,
              color: '#f7f8fa'
               }, {
               offset: 1,
                color: '#cdd0d5'
                 }]),

            title: { text: echartsParameter+'\n竞赛报名队伍及成员Echarts力导图分析' 
            
            
            },
            tooltip: {
                formatter: function (x) {
                    return x.data.des;
                }
            }, 
            color:['#00BFFF','#00FF7F','#FF7F50','#968ade','#11abff','#fd87ab','#11abff','#ffdf33','#968ade','#ffdf33','#968ade'], 
           // color:['#11abff','#fd87ab','#48cda6','#ffdf33','#968ade','#11abff','#fd87ab','#11abff','#ffdf33','#968ade','#ffdf33','#968ade'], 
             //x轴 data 和结点的  颜色  设置      color 数组           
            legend: {
              x: "center",
              data: ['竞赛名称','队伍名称','队员姓名']
             },
            series: [
                {
                    type: 'graph',
                    layout: 'force',
                    force:{
                    layoutAnimation : false,
                    draggable : false,
                    focusNodeAdjacency : true
                    },
                    symbolSize: 80,
                    roam: true,
                    
                    hoverAnimation:true,
                    focusNodeAdjacency:true,    //鼠标移动到 某一结点 值显示 该结点相关的信息
                    edgeSymbol: ['circle', 'arrow'],
                    edgeSymbolSize: [4, 10],
                    edgeLabel: {
                        normal: {
                            textStyle: {
                                fontSize: 20
                            }
                        }
                    },
                    force: {
                        repulsion: 2500,
                        edgeLength: [10, 50]
                    },
                    draggable: true,
                    itemStyle: {
                        normal: {
                        
           
                         
                        }
                    },
                    lineStyle: {
                        normal: {
                            width: 2,
                            color: '#4b565b'

                        }
                    },
                    edgeLabel: {
                        normal: {
                            show: true,
                            formatter: function(params){
                                var names = params.data.name;
							    var paramsNameNumber = names.length;    
							    
							    console.log("paramsNameNumber:"+paramsNameNumber );
							
							    var provideNumber = 4;
							
							    var tempStr = "";
							    if (paramsNameNumber > provideNumber) {
							                 var first = names.substring(0, provideNumber);
							                 var end = names.substring(provideNumber,paramsNameNumber);
							                 tempStr = first+"\n"+end;
							    }else {
							        
							        tempStr = names;
							    }
							    return tempStr;
							}

                        }
                    },
                     categories: [
                      {name: '竞赛名称'},{name:'队伍名称'},{name:'队员姓名'}
                         
                     ],
                    label: {
                     normal: {
                            show: true,
                            color:'#474747',
                            fontWeight:'lighter',
                            width:'6',
                            fontSize:'11',
                           textStyle: {
                           }
                        }
                    },
                   
                   //结点不可以重复出现 那么要唯一  关联关系可以重复出现
                   nodes:[],
                   //{id:'1000',category:'总公司',des:'地址:',itemStyle:'null',name:'name'}
                 
                   links:[]
                }]
                
              };
            
            myChart.showLoading();
 
 //将ajax 放入函数调用  点击select 标签的时候 触发onchange="gradeChange()" 下面这个函数  获取不同的标签的值 代入url 实现功能点之间的切换

  
   var url= 'echarts/getTeam_PersonOfContest.action';
  

    $.ajax({  
        type:"post",
        data:{"echartsParameter":echartsParameter}, 
        url:url,  
        async:true,   
        success:function(result) {//获取返回值  
    
        
      
     //  alert(linkresult);
        var dataObj=eval("("+result+")");

        var node = dataObj.nodes;
        var link = dataObj.links;
  
       
        option.series[0].nodes=node;
        option.series[0].links=link;
        myChart.hideLoading();
        myChart.clear();
        myChart.setOption(option);
    
        },  
        error:function(e) {  
          alert("验证失败!");  
        }  
      });  
      
      
     
      
     
    </script>
</body>
</html>