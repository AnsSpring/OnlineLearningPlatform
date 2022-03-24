<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>增加用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<script type="text/javascript">
	
	window.onload = function() {

		var form = document.getElementById("form");

		var inputs = document.getElementsByTagName("input");

		form.onsubmit = function() {

			for ( var i = 0; i < inputs.length; i++) {

				if (inputs[i].value == "") {

					alert("The existing option is not filled in !!!");

					return false;
				}

			}

		}

	}
	

</script>


<style type="text/css">
.caption {
	font-family: "宋体";
	color: #6495ED;
	height: 80px;
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

.reset_submit{
   border-color: #D1EEEE;
   border-style: solid;
   background-color: #6495ED;
   height: 30px;
}

#select{
   
   border-color: #D1EEEE;
   width:350px;
   height:36px;
   border-radius: 3px;
   border-style: solid;
   color: #6495ED;
}
</style>
</head>

<body> 

<% 
   Object obj=request.getAttribute("error");
   if(obj!=null){
%>
   <script type="text/javascript" language="javascript">
       alert("<%=obj%>");
   </script>
<%
   }
%>	


<form action="AddAdminServlet" method="post" id ="form" >
	    
		<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>Add User<br></pre>
					</h2>
				</center>
			</caption>
			<tr class="tr">
				<td align="center">登录名</td>
				<td><input type="text" size="64" class="input" name="username"></td>
			</tr>
			<tr class="tr">
				<td align="center">密码</td>
				<td><input type="text" size="64" class="input" name="password" value="密码默认和登录名一致，不要包含中文" disabled="disabled"></td>
			</tr>
			<tr class="tr">
				<td align="center">用户角色</td>
				<td>
                    <select id="select" name="role">
                       <option value="1">管理员</option>
                       <option value="2">教师</option>
                       <option value="3">学生</option>
                    </select>
                </td>
			</tr>
			
			<tr class="tr">
				<td align="center">用户真实姓名</td>
				<td><input type="text" size="64" class="input" name="realName"></td>
			</tr>
			<tr class="tr">
				<td align="center">年级和班级</td>
				<td><input type="text" size="64" class="input" name="classAndGrade"></td>
			</tr>
			<tr class="tr">
				<td align="center">年龄</td>
				<td><input type="text" size="64" class="input" name="age"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">性别</td>
				<td>
                    <select id="select" name="sex">
                       <option value="1">男</option>
                       <option value="2">女</option>
                       <option value="3">未知</option>
                    </select>
                </td>
			</tr>
			
			<tr class="tr">
				<td align="center">邮箱</td>
				<td><input type="text" size="64" class="input" name="mail"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">电话号码</td>
				<td><input type="text" size="64" class="input" name="phone"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">住址</td>
				<td><input type="text" size="64" class="input" name="address"></td>
			</tr>

			<tr class="tr">
				<td align="center"><input type="reset" value="重置" name="reset" class="reset_submit">
				</td>
				<td align="center"><input type="submit" value="下一步" name="sumbit" class="reset_submit">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
