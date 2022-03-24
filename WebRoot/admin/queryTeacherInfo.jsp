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

<title>个人中心教师信息查询页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->



<style type="text/css">


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



.tr {
    font-family:"宋体";
    color: #6495ED;
	background-color: #D1EEEE;
	height: 36px;
}

.input{
   border-color: #D1EEEE;
   border-style: solid;
   height: 30px;
   color: #6495ED;
}

.textarea{
   border-color: #D1EEEE;
   border-style: solid;
   height: 200px;
   color: #6495ED;
   width: 410px;
}

.reset_submit{
   border-color: #D1EEEE;
   border-style: solid;
   background-color: #6495ED;
   height: 30px;
}

#allDiv{

    width:100%;
    height:100%;
    border: 1px solid #CD6600;
    position: relative;

}

#div{

    width:100%;
    height:100%;
    position:absolute; 
    z-index:2; 
}


a{
  
  text-decoration: none;
  color: white;
  
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
  
<body topmargin="5px" >

   <%
	   String usernames = request.getParameter("username");
	   AdminDBHelp db = new AdminDBHelp();
	   LoginUser lu = db.queryLoginInfo(usernames);
	  
	%>

 <%
        
		AdminDBHelp adbh = new AdminDBHelp();
		ArrayList<Admin> list = adbh.query();
		int id = lu.getId();
		String username = null;
		String password = null;
		String role = null;
		String realName = null;
		String classAndGrade = null;
		String age = null;
		String mail = null;
		String phone = null;
		String address = null;

	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		    Admin admin = list.get(i);

			if (admin.getId() == id) {

				username = admin.getUsername();
				password = admin.getPassword();
				role = admin.getRole();
				realName = admin.getRealName();
				classAndGrade = admin.getClassAndGrade();
				age = admin.getAge();
				mail = admin.getMail();
				phone = admin.getPhone();
				address = admin.getAddress();

			}
		}
	%>

<div id = "allDiv">	

<div style="height: 5px">

</div>



<div style="height: 55px">

   <table width="100%" align="center" bgcolor="#3CB371" height="50px">
        <tr>
            <td width="3%"></td>
            <td align="left" width="40%"><span class="span" id="spanTime"></span></td>
            <td width="5%"></td>
            <td align="left"><span class="span">教师信息修改</span></td>
            <td width="5%"></td>
            <td align="center"><span class="span">欢迎您，<span><%=lu.getRealName()%></span>老师</span></td>
            <td width="3%"></td>
         </tr>
   </table>
        
</div>



<form action="TeacherModifyAdminServlet" method="post" id ="form" >
   <div id ="div">
	<table align="center" width="40%" bgcolor="#D1EEEE">
			
			<tr class="tr">
				<td align="center">用户密码</td>
				<td><input type="text" size="64" class="input" name="password" value="<%=password %>"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">邮箱</td>
				<td><input type="text" size="64" class="input" name="mail" value="<%=mail %>"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">电话号码</td>
				<td><input type="text" size="64" class="input" name="phone" value="<%=phone %>"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">住址</td>
				<td><input type="text" size="64" class="input" name="address" value="<%=address %>"></td>
			</tr>
			

			
			<tr class="tr">
				<td align="center"><input type="reset" value="修改" name="reset"
					class="reset_submit"></td>
				<td align="center"><input type="submit" value="下一步" name="sumbit" 
				    class="reset_submit"></td>
			</tr>
			
			<input type="hidden" name="id" value="<%= id%>">
     </table>
  
    </div>
	 <img src="picture/queryStudent.png" alt="图片">
</form>

</div>
        
</body>
</html>

