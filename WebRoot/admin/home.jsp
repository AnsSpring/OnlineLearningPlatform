<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基于JAVA WEB的在线学习平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">

*{
  
   margin: 0px;
   padding: 0px;
}

#content{

   width: 100%;
   height: 30px;
   background-color: #6495ED;
   font-size:x-large;
   text-align: center;
   line-height: 30px;
   font-family: "宋体";
   border: 1px solid #D1EEEE;

}


#theme{

   width: 100%;
   height: 40px;
   background-color:  #D1EEEE;
   font-size:x-large;
   text-align: center;
   line-height: 40px;
   font-family: "宋体";
   border: 2px solid #D1EEEE;

}

.a{
   
   color: white;
   text-decoration: none;
   height: 30px;
   line-height: 30px;
   text-align: center;

}

#flash{

   width:1366px;
   height:634px;
   border: 1px solid white;
   position: relative;

}

#flash img{

   position: absolute;
   left:0px;
   top:0px;
   display:none;   

}

#flash ul{

   position: absolute;
   left:620px;
   bottom: 20px;
}

#flash ul li{

   list-style: none;
   width: 12px;
   height: 12px;
   background: white;
   float: left;
   border-radius:50%;
   margin-right:10px; 

}

.bottom{
   
   background-color: #6495ED;
   font-size: large;
   font-family: "宋体";
   color: #ffffff;
   height:30px;
  
}

</style>

<script type="text/javascript" src="JS/jquery-3.3.1.min.js"></script>



<script type="text/javascript">

	var timer;
	
	function run() {
	
		var flash = document.getElementById("flash");
		var is = flash.getElementsByTagName("img");
		var ls = flash.getElementsByTagName("li");

		var c = 0;
		
		//使用jQuery来实现图片的淡入淡出的效果	
		timer = setInterval(function() {

			c++;
			c = c == 4 ? 0 : c;
			
            //让c号图片显示，其他的图片隐藏
			$("#flash img").eq(c).fadeIn(600).siblings("img").fadeOut(600);
			
			//让c号图片变成绿色，其他li变白
			$("#flash ul li").eq(c).css("background"," #6495ED").siblings("li").css("background","white");

			}, 2000);

	}
	
	
	window.onload = function() {
	
		run();
	}

	function stop() {

		clearInterval(timer);
	}

	function start() {

		run();
	}
</script>


</head>
  
<body> 
    
<div id = "content">
        
   <table width="100%" align="center" id = "table">
	   <tr>
	        <td align="center" width="60%"></td>
	        <td align="center"><a href="admin/bulletin.jsp"  class="a">网站介绍</a></td>
	        <td align="center"><a href="admin/studentLogin.jsp"  class="a">学生登陆</a></td>
			<td align="center"><a href="admin/teacherLogin.jsp"  class="a">教师登陆</a></td>
			<td align="center"><a href="admin/register.jsp"  class="a">管理员注册 |</a>
			<a href="admin/login.jsp"  class="a">登录</a></td>
	   </tr>
   </table>
</div>
           
<div id = "theme"><center><pre>在  线  学  习  平  台</pre></center></div>

<div id = "flash" onmouseover="stop()" onmouseout="start()">
   
     <img src="picture/homepage1.png" alt="图片1" style="display: block;">
     <img src="picture/homepage2.png" alt="图片2">
	 <img src="picture/homepage3.png" alt="图片3">
	 <img src="picture/homepage4.png" alt="图片4">
	    <ul>
		   <li style="background:#6495ED;"></li>
		   <li></li>
		   <li></li>
		   <li></li>
		 </ul>

</div>

<table width="100%" height="120px" align="center" cellpadding="10px" bgcolor="#87CEEB">
		
		   <tr ><td class="bottom"><center><h4><pre>欢 迎 访 问 在 线 学 习 平 台 首 页</pre></h4></center></td></tr>
		   <tr>
		   <td class="bottom"><center><h4><pre>学 校 地 址：青 海 省 西 宁 市 城 北 区 宁 大 路 251 号</pre></h4></center></td>
		   </tr>
</table>
  
</body>
</html>
