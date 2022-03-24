<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Admin"%>
<%@ page import="com.database.AdminDBHelp "%>
<%@ page import="com.entity.LoginUser"%>

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

<title>教师详情页面</title>

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

#menu{
  
  background-color: #6495ED;
  width: 1200px;
  height: 40px;
  margin: 0 auto;
  padding: 0px;
  font-weight: bold;

}

ul{

   list-style: none;
}

ul li{
  
  float: left;
  line-height: 40px;
  text-align: center;
  position: relative;
  width: 240px;

}

a{
  
  text-decoration: none;
  color: white;
  display: block;
  padding: 0 10px;
  height: 40px;
  
}

a:HOVER {
	
	color: #fff;
	background-color: #228B22;
}

ul li ul li{
  
   float: none;
   background-color: #6495ED;
   margin-top: 1px;

}

ul li ul{
  
   position: absolute;
   left: 0px;
   top: 40px;
   display: none;
}


.span{
   
    text-decoration: none;
    color: white;
    font-size: large;
    font-family: "宋体";
    font-weight: bolder;
}

#bottom{
  
  background-color:#D1EEEE;
  width: 1200px;
  height: 600px;
  margin: 0 auto;
  padding: 0px;
  font-weight: bold;

}

#t{

   color:#6495ED;
   font-weight: bold;
   font-size: large;

}


</style>

<script type="text/javascript" src="JS/jquery-3.3.1.min.js"></script> 

<script type="text/javascript">
 
 $(function(){
 
    $(".every").mouseover(function(){
      
        $(this).children("ul").show();       
         
    });
    
     $(".every").mouseout(function(){
      
        $(this).children("ul").hide();       
         
    });
 
 
 });  
 
 
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
  
<body topmargin="5px">

<div style="height: 5px">

</div>

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
            <td align="left"><span class="span">在线学习平台</span></td>
            <td width="10%"></td>
            <td align="center"><span class="span">欢迎您，<span><%=lu.getRealName()%></span>老师</span></td>
         </tr>
   </table>
        
</div>


<div id = "menu">
 <ul>

     <li class="every"><a href="admin/teacherInfo.jsp">文件管理</a>
         <ul>
              <li><a href="admin/uploadFileInfo.jsp">课件资料</a></li>
              <li><a href="admin/jobInfo.jsp">作业下载</a></li>
         </ul>
     </li>
     <li class="every"><a href="admin/teacherInfo.jsp">学生管理</a>
         <ul>
              <li><a href="admin/studentManagement.jsp">学生信息管理</a></li>
              <li><a href="admin/studyInfo.jsp">学习成绩统计</a></li>
              <li><a href="admin/studentCourseInfo.jsp">学生选课审核</a></li>
         </ul>
     </li>
     <li class="every"><a href="admin/teacherInfo.jsp">作业创建</a>
          
         <ul>
              <li><a href="admin/classManagement.jsp">课程管理</a></li>
              <li><a href="admin/dxCreate.jsp">创建单选题</a></li>
              <li><a href="admin/pdCreate.jsp">创建判断题</a></li>
         </ul>
     </li>
   
     <li class="every"><a href="admin/teacherInfo.jsp">个人中心</a>
        
          <ul>
              <li><a href="admin/queryTeacherInfo.jsp?username=<%=username%>">信息修改</a></li>
              <li><a href="admin/queryUserInfo.jsp?username=<%=username%>">信息查询</a></li>
              <li><a href="admin/teacherChatInfo.jsp">课程讨论</a></li>
              <li><a href="admin/bullInfo.jsp">公告通知</a></li>
          </ul>
     </li>
     
     <li><a href="admin/home.jsp">退出登录</a></li>
 </ul>
</div>    

<div id = "bottom">

<br>

&ensp;&ensp;&ensp;&ensp;<span id ="t">教师可以上传相关科目资料，上传视频，文本文件等，对学生进行考核，试卷以及作业的创建，
监督学生的学习情况（题目完成度、视频完成度、学生是否申请过，后台记录，学习进度。</span>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
   
</div>  

<br>
        
</body>
</html>