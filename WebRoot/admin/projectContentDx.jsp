<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Admin"%>
<%@ page import="com.database.AdminDBHelp "%>
<%@ page import="com.entity.LoginUser"%>
<%@ page import="com.entity.Project"%>
<%@ page import="com.database.ProjectDBHelp"%>
<%@ page import="com.entity.ProjectCount"%>
<%@ page import="com.database.SingleChoiceDBHelp"%>
<%@ page import="com.entity.SingleChoice"%>



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

<title>课程内容页面-单选题</title>

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

#S{

    width:100%; 
    height: 50;
    color:#6495ED; 
    font-weight: bolder;
    font-size: x-large

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
	   String pcode = request.getParameter("pcode");
	   
	   ProjectDBHelp pdbh = new ProjectDBHelp();
	   ArrayList<ProjectCount> pList = pdbh.queryProjectCount(usercode);
	   
	   String pname = null;
	   
	   for(int i = 0, len = pList.size(); i < len; i++){
	       
	       if(pList.get(i).getCode().equals(pcode)){
	          
	           pname = pList.get(i).getName();
	       }
	   }
	  
	  
	%>

<div style="height: 55px">

   <table width="100%" align="center" bgcolor="#3CB371" height="50px">
        <tr>
            <td width="2%"></td>
            <td align="left" width="40%"><span class="span" id="spanTime"></span></td>
            <td width="5%"></td>
            <td align="left"><span class="span">课程信息管理-单选题-<span><%=pname%></span></span></td>
            <td width="6%"></td>
            <td align="center"><span class="span">欢迎你，<span><%=lu.getRealName()%></span>同学</span></td>
         </tr>
   </table>
        
</div>
        
        <table width="76%" align="center">
            <tr>
                <td align="left" ><span class="span"><a href="admin/projectContent.jsp" class="href">
                <pre>返回上页</pre></a></span></td>
                <td width="60%" align="center"></td>
                <td  align="right"><span class="span"><a href="admin/home.jsp" class="href">
                <pre>返回首页</pre></a></span></td>
            </tr>
        </table>

		<%
		
			  SingleChoiceDBHelp scdbh = new SingleChoiceDBHelp();
	          ArrayList<SingleChoice> list = scdbh.queryByCode(pcode);
			
		%>

<form action="SumSingleChoiceServlet" method="post" id ="form" >


		<table width="96%" align="center">
			<tr bgcolor="#6495ED" height="34">
				<th>
					序号
				</th>
				<th>
					问题描述
				</th>
				<th>
					选项A
				</th>
				<th>
					选项B
				</th>
				<th>
					选项C
				</th>
				<th>
					选项D
				</th>
				<th>
					参考选项
				</th>
			
			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {
			%>

			<tr align="center" bgcolor="#D1EEEE" height="32">
				<td>
					<span><%=list.get(i).getId()%></span>
				</td>
				<td>
				    <%=list.get(i).getQuestion()%>
				</td>
				<td>
				    <%=list.get(i).getOne()%>

				</td>
				<td>
				    <%=list.get(i).getTwo()%>
				</td>
				<td>
				    <%=list.get(i).getThree()%>
				</td>
				<td>
				    <%=list.get(i).getFour()%>
				</td>
				<td>
                    <select id="select" name="answer">
                       <option value="1">选项A</option>
                       <option value="2">选项B</option>
                       <option value="3">选项C</option>
                       <option value="4">选项D</option>
                    </select>
                </td>
				
			</tr>

			<%
				}
			%>
			

		</table>
		
		<br>
		
		<table width="96%" align="center">
			<tr height="50">
				<th>
					<span><input id = "s" type="submit" value="下一步" name="sumbit"></span>
				</th>
				
			</tr>
			
			
		</table>
		
		<input type="hidden" name="pcode" value="<%= pcode%>">
		
		<input type="hidden" name="pname" value="<%= pname%>">
		
		<input type="hidden" name="usercode" value="<%= lu.getUsercode()%>">
		
		<input type="hidden" name="realName" value="<%= lu.getRealName()%>">
		
  </form>	
</body>
</html>


