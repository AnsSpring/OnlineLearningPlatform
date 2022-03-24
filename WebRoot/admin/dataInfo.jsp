<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Result"%>
<%@ page import="com.database.ResultDBHelp "%>
<%@ page import="com.entity.LoginUser"%>
<%@ page import="com.entity.Course"%>
<%@ page import="com.database.CourseDBHelp "%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据可视化</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->

<style type="text/css">
.tr1{
	background-color: #6495ED;
	font-size: x-large;
	font-family: "宋体";
}

.href{

    text-decoration: none;
    margin-left: 145px;
}

.a{
  text-decoration: none;
}

.tr2{
   
   background-color: #6495ED;
   font-size: large;
   font-family: "宋体";
   color: #ffffff;
   height:30px;
  
}

.span{
   
    text-decoration: none;
    color: white;
    font-size: large;
    font-family: "宋体";
    font-weight: bolder;
}


</style>


<script type="text/javascript" src="JS/jquery-3.3.1.min.js"></script> 

<script type="text/javascript">
   
   function confirmDeleteJsp(){
   
        var msg = "Are you sure you want to delete it?!!"
        
        if(confirm(msg) == true){
              
              return true;
        }else{
              return false;
        
        }
   };


//显示时间
function showTime() {

    
    var d = new Date();
	var year = d.getFullYear();
    var month = d.getMonth() + 1;
    var date = d.getDate();
	var days = new Array("日","一","二","三","四","五","六");
	var day = d.getDay();
	var hour = (d.getHours() < 10) ? ("0" + d.getHours()) : d.getHours();
	var min = (d.getMinutes() < 10) ? ("0" + d.getMinutes()) : d.getMinutes();
	var sec = (d.getSeconds() < 10) ? ("0" + d.getSeconds()) : d.getSeconds();
	var now = year + "年" + month + "月" + date + "日"+"&nbsp;"+"星期" + days[day] + "&nbsp;" + hour + ":" + min + ":" + sec;
	document.getElementById("spanTime").innerHTML = "现在时间是:" + now;

}


var timer;

$(document).ready(function(){
    if (timer == undefined)
        timer = window.setInterval(showTime, 1000);
});

</script>


</head>

<body bottommargin="0" topmargin="5px" leftmargin="0" rightmargin="0">

    <%
	   LoginUser lu = (LoginUser)session.getAttribute("lu");
	   String username = lu.getUsername();
	   String usercode = lu.getUsercode();
	  
	%>

<div style="height: 55px">

   <table width="100%" align="center" bgcolor="#3CB371" height="50px">
        <tr>
            <td width="2%"></td>
            <td align="left" width="45%"><span class="span" id="spanTime"></span></td>
            <td width="5%"></td>
            <td align="left"><span class="span">数据可视化</span></td>
            <td width="10%"></td>
            <td align="center"><span class="span">欢迎你，<span id = "usercode"><%=lu.getUsercode()%></span>-<%=lu.getRealName()%>同学</span></td>
         </tr>
   </table>
        
</div>
        
<br><br>

   <table width="100%" align="center">
        <tr>
            <td width="50%"><span id="pie" style="width:650px;height:400px;"></span></td>
            <td width="50%"><span id="pie2" style="width:650px;height:400px;"></span></td>
         </tr>
   </table>
   
   <br>
   
   <table width="100%" align="center">
        <tr>
            <td width="50%"><span id="pie3" style="width:650px;height:500px;"></span></td>
            <td width="50%"><span id="pie4" style="width:650px;height:500px;"></span></td>
         </tr>
   </table>
   
   <br><br>
        

<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.2.2/dist/echarts.js"></script>

<script type="text/javascript">

$(function(){
      
   var url = "AjaxCourseServlet";
         
   var usercode = $("#usercode").html();
   
 //  alert(usercode);
         
   var args = {"usercode":usercode};
         
   $.getJSON(url,args,function(data){
             
 //    console.log(JSON.stringify(data));
     
     //转换为数组对象 
     var result = eval(data);
           
   //  alert(result);
           
     // 基于准备好的dom，初始化echarts实例
	 var myChart = echarts.init(document.getElementById('pie'));

	 myChart.setOption({
	    
	    title: {
	    
            text: '学生选课情况',
            subtext: 'Project Data',
            left: 'center'
        },
        
        tooltip: {
        
            trigger: 'item'
        },
        
         legend: {
         
            orient: 'vertical',
            left: '20'
         },
        
		series : [
			{
				name: '课程编码和名称',
				type: 'pie',    // 设置图表类型为饼图
				radius: '50%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 50% 长度。
				data:result,       // 数据数组，name为数据项名称，value为数据项值
				
				 emphasis: {
				 
                   itemStyle: {
                   shadowBlur: 10,
                   shadowOffsetX: 0,
                   shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
                }
			}
		  ]
	   });
           
      
     });
     
      var url2 = "AjaxChatServlet";
      
      
      $.getJSON(url2,args,function(data){
             
      console.log(JSON.stringify(data));
     
      //转换为数组对象 
      var result = eval(data);
           
      //  alert(result);
           
      // 基于准备好的dom，初始化echarts实例
	  var myChart = echarts.init(document.getElementById('pie2'));

      myChart.setOption({
	    
	    title: {
	    
            text: '课程讨论情况',
            subtext: 'Chat Data',
            left: 'center'
        },
        
        tooltip: {
        
            trigger: 'item'
        },
        
         legend: {
         
            orient: 'vertical',
            left: '20'
         },
        
		series : [
			{
				name: '课程名称和讨论数量',
				type: 'pie',    // 设置图表类型为饼图
				radius: '50%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 50% 长度。
				data:result,       // 数据数组，name为数据项名称，value为数据项值
				
				 emphasis: {
				 
                   itemStyle: {
                   shadowBlur: 10,
                   shadowOffsetX: 0,
                   shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
                }
			}
		  ]
	   });
           
      
     });
     
     
    var url3 = "AjaxDxServlet";
    
 //   alert(usercode);
         
    var arg = {"usercode":usercode};
      
    $.getJSON(url3,arg,function(data){
             
      console.log(JSON.stringify(data));
     
      //转换为数组对象 
      var result = eval(data);
           
 //     alert(result);
           
      // 基于准备好的dom，初始化echarts实例
	  var myChart = echarts.init(document.getElementById('pie3'));

      myChart.setOption({
	    
	    title: {
	    
            text: '学生成绩统计-单选题',
            subtext: 'Max Score',
            left: 'center'
        },
        
	    tooltip: {
          trigger: 'item'
        },
        
        legend: {
          bottom: '5%',
          left: 'center'
        },
        
        series: [
       {
           name: 'Max Score',
           type: 'pie',
           radius: ['40%', '70%'],
           avoidLabelOverlap: false,
           label: {
             show: false,
             position: 'center'
           },
           emphasis: {
              label: {
                 show: true,
                 fontSize: '40',
                 fontWeight: 'bold'
              }
           },
           labelLine: {
             show: false
            },
            data: result
         }
        ]
	   });
           
      
     });
     
     
     var url4 = "AjaxPdServlet";
    
 //   alert(usercode);
         
    var arg = {"usercode":usercode};
      
    $.getJSON(url4,arg,function(data){
             
      console.log(JSON.stringify(data));
     
      //转换为数组对象 
      var result = eval(data);
           
 //     alert(result);
           
      // 基于准备好的dom，初始化echarts实例
	  var myChart = echarts.init(document.getElementById('pie4'));

      myChart.setOption({
	    
	    title: {
	    
            text: '学生成绩统计-判断题',
            subtext: 'Max Score',
            left: 'center'
        },
        
	    tooltip: {
          trigger: 'item'
        },
        
        legend: {
          bottom: '5%',
          left: 'center'
        },
        
        series: [
       {
           name: 'Max Score',
           type: 'pie',
           radius: ['40%', '70%'],
           avoidLabelOverlap: false,
           label: {
             show: false,
             position: 'center'
           },
           emphasis: {
              label: {
                 show: true,
                 fontSize: '40',
                 fontWeight: 'bold'
              }
           },
           labelLine: {
             show: false
            },
            data: result
         }
        ]
	   });
           
      
     });
      
      
 
      
 });


</script>
	

		
</body>
</html>
