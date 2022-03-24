<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Result"%>
<%@ page import="com.database.ResultDBHelp "%>
<%@ page import="com.entity.LoginUser"%>
<%@ page import="com.entity.SumCourse"%>
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

<title>已选课程查看</title>

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
            <td align="left"><span class="span">已选课程</span></td>
            <td width="10%"></td>
            <td align="center"><span class="span">欢迎你，<span><%=lu.getRealName()%></span>同学</span></td>
         </tr>
   </table>
        
</div>
        
        <table width="76%" align="center">
            <tr>
                <td align="left" ><span class="span"><a href="admin/studentInfo.jsp" class="href">
                <pre>返回上页</pre></a></span></td>
                <td width="60%" align="center"><span class="span"><a href="admin/addStudent.jsp" class="href">
                <pre></pre></a></span></td>
                <td  align="right"><span class="span"><a href="admin/home.jsp" class="href">
                <pre>返回首页</pre></a></span></td>
            </tr>
        </table>

		<%
			CourseDBHelp rdbh = new CourseDBHelp();
			ArrayList<SumCourse> list = rdbh.queryByStudentCode(usercode);
		%>






















































		<table width="90%" align="center">
			<tr bgcolor="#6495ED" height="34">
				<th>
					编号
				</th>
				<th>
					科目
				</th>
				<th>
					任课教师
				</th>
				<th>
					选课人
				</th>
				<th>
					选课时间
				</th>
			    <th>
					审核结果
				</th>
				<th>
					作业上传
				</th>
				<th>
					取消课程
				</th>
			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {
			%>

			<tr align="center" bgcolor="#D1EEEE" height="32">
				<td>
					<%=list.get(i).getId()%>
				</td>
				<td>
				    <%=list.get(i).getName()%>
				</td>
				<td>
					<%=list.get(i).getTeacherName()%>
				</td>
				<td>
					<%=list.get(i).getRealName()%>
				</td>
				<td>
				    <%=list.get(i).getCreateTime()%>
			    </td>
			   	<td>
				    <%=list.get(i).getIsCheck()%>
			    </td>
			    <td>
				    <a href="admin/addFile.jsp?pname=<%=list.get(i).getName()%>&pcode=<%=list.get(i).getCode()%>" class="a"">作业上传</a>
			    </td>
			    <td>
				    <a href="admin/deleteCourse.jsp?id=<%=list.get(i).getId()%>" class="a" onclick="return confirmDeleteJsp()">delete</a>
			    </td>
			</tr>

			<%
				}
			%>

		</table>
		
		<br><br><br><br>
		
	</body>
</html>
