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

<title>学生登录界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	window.onload = function() {

		var form = document.getElementById("form");

		var username = document.getElementById("username");
		var password = document.getElementById("password");

		form.onsubmit = function() {

			if (username.value == "") {

				alert("username should not be empty !!!");
				return false;
			}

			if (password.value == "") {

				alert("password should not be empty !!!");
				return false;
			}
		}
	}
</script>

<style type="text/css">

.tr3 {
	font-family: "宋体";
	color: #CD6600;
	font-size: large;
	font-weight: bolder;
}

.tr5 {
	font-family: "宋体";
	color: #CD6600;
	font-size: large;
	font-weight: bolder;
}

.table {
	border-style: solid;
	border-color: #CD6600;
	border-width: thin;
	border-radius: 6px;
}

.input {
	border-style: solid;
	border-color: #CD6600;
	border-width: thin;
}

.div {
	white-space: nowrap;
	font-family: "宋体";
	color: #CD6600;
	font-size: large;
}

.submit_register {
	border-style: solid;
	border-color: #CD6600;
	border-width: medium;
	color: #FFFFFF;
	background-color: #CD6600;
}

#submit_register {
	white-space: nowrap;
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

</style>

</head>

<body bottommargin="0" topmargin="0" leftmargin="0" rightmargin="0"style="overflow: hidden">

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


<% 
   Object obj2=request.getAttribute("success");
   if(obj2!=null){
%>
   <script type="text/javascript" language="javascript">
       alert("<%=obj2%>");
   </script>
<%
   }
%>


<% 
   Object obj3=request.getAttribute("role");
   if(obj3!=null){
%>
   <script type="text/javascript" language="javascript">
       alert("<%=obj3%>");
   </script>
<%
   }
%>
	
<div id = "allDiv">	
   <form method="post" action="StudentLoginServlet" autocomplete="off" id = "form">
      <div id ="div">
		<table width="100%" height="100%">
			<tr height="6%" class="tr1">
				<td></td>
			</tr>

			<tr align="center" class="tr2">

				<td>
					<table class="table" height="30%" ; width="20" ; align="center";
					bgcolor="F0FFF0" cellspacing="20"; >
						<caption class="tr5">
							<center>
								<pre>Welcome Student Login</pre> 
							</center>
						</caption>

						<tr height="10">
							<td><div class="div">
									<b>username</b>&nbsp;<input type="text" name="username"
										class="input" id = "username" autocomplete="off">
								</div>
							</td>
						</tr>
						<tr height="10">
							<td><div class="div">
									<b>password</b>&nbsp;<input type="password" name="password"
										class="input" id = "password" autocomplete="off">
								</div>
							</td>
						</tr>

						<tr>
							<td><div id="submit_register">
									<center>
										<input type="submit" value="load" class="submit_register" size="4">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
										<input type="reset" value="reset" class="submit_register" size="4">
									</center>
								</div>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr height="10%" class="tr3">
				<td><center>
						<pre>在  线  学  习  平  台  学  生  登  录  界  面</pre>
					</center></td>
			</tr>

			<tr height="5%" class="tr4">
				<td></td>
			</tr>

		</table>
   
     </div>
	   <img src="picture/student.png" alt="图片">
   </form>
   

   </div>
</body>
</html>
