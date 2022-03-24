<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Admin"%>
<%@ page import="com.database.AdminDBHelp"%>

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

<title>更新学生信息</title>

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
</style>
</head>

<body> 

    <%
		AdminDBHelp adbh = new AdminDBHelp();
		ArrayList<Admin> list = adbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
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
	
<form action="ModifyStudentServlet" method="post" id ="form" >
	<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>Modify Admin<br></pre>
					</h2>
				</center>
			</caption>
			
			<tr class="tr">
				<td align="center">登录名</td>
				<td><input type="text" size="64" class="input" name="username" value="<%=username %>"></td>
			</tr>
			<tr class="tr">
				<td align="center">用户密码</td>
				<td><input type="text" size="64" class="input" name="password" value="<%=password %>"></td>
			</tr>
			<tr class="tr">
				<td align="center">用户角色</td>
				<td>
                    <select id="select" name="role" >
                       <option value="3">学生</option>
                    </select>
                </td>
			</tr>
			
			<tr class="tr">
				<td align="center">用户真实姓名</td>
				<td><input type="text" size="64" class="input" name="realName" value="<%=realName %>"></td>
			</tr>
			<tr class="tr">
				<td align="center">年级和班级</td>
				<td><input type="text" size="64" class="input" name="classAndGrade" value="<%=classAndGrade %>"></td>
			</tr>
			<tr class="tr">
				<td align="center">年龄</td>
				<td><input type="text" size="64" class="input" name="age" value="<%=age %>"></td>
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
</form>
</body>
</html>

