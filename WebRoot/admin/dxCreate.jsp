<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Admin"%>
<%@ page import="com.database.AdminDBHelp "%>
<%@ page import="com.entity.LoginUser"%>
<%@ page import="com.entity.SingleChoice"%>
<%@ page import="com.database.SingleChoiceDBHelp"%>

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

<title>教师创建作业页面</title>

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
	  
	%>

<div style="height: 55px">

   <table width="100%" align="center" bgcolor="#3CB371" height="50px">
        <tr>
            <td width="2%"></td>
            <td align="left" width="45%"><span class="span" id="spanTime"></span></td>
            <td width="5%"></td>
            <td align="left"><span class="span">作业创建 -- 创建单选题</span></td>
            <td width="10%"></td>
            <td align="center"><span class="span">欢迎您，<span><%=lu.getRealName()%></span>老师</span></td>
         </tr>
   </table>
        
</div>
        
        <table width="76%" align="center">
            <tr>
                <td align="left" ><span class="span"><a href="admin/teacherInfo.jsp" class="href">
                <pre>返回上页</pre></a></span></td>
                <td width="60%" align="center"><span class="span"><a href="admin/tAddSingleChoice.jsp" class="href">
                <pre>添加单选题</pre></a></span></td>
                <td  align="right"><span class="span"><a href="admin/home.jsp" class="href">
                <pre>返回首页</pre></a></span></td>
            </tr>
        </table>

		<%
			SingleChoiceDBHelp scdbh = new SingleChoiceDBHelp();
			ArrayList<SingleChoice> list = scdbh.query();
		%>

		<table width="90%" align="center">
			<tr bgcolor="#6495ED" height="34">
				<th>
					Number
				</th>
				<th>
					ProjectName
				</th>
				<th>
					Question
				</th>
				<th>
					Update
				</th>
				<th>
					Delete
				</th>
			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {
			%>

			<tr align="center" bgcolor="#D1EEEE" height="32">
				<td>
					<a href="admin/querySingleChoice.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getId()%></a>
				</td>
				<td>
					<a href="admin/querySingleChoice.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getName()%></a>
				</td>
				<td>
					<a href="admin/querySingleChoice.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getQuestion()%></a>
				</td>
				<td>
					<a href="admin/updateDx.jsp?id=<%=list.get(i).getId()%>" class="a">update</a>
				</td>
				<td>
				    <a href="admin/deleteDx.jsp?id=<%=list.get(i).getId()%>" class="a" onclick="return confirmDeleteJsp()">delete</a>
			    </td>
			</tr>

			<%
				}
			%>

		</table>
		<br><br><br>
		
	</body>
</html>