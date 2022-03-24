<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.CodeName"%>
<%@ page import="com.database.ProjectDBHelp"%>
<%@ page import="com.entity.Admin"%>
<%@ page import="com.database.AdminDBHelp"%>
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

<title>增加课程讨论</title>

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


<form action="StudentAddChatServlet" method="post" id ="form" >

        <%
	        LoginUser lu = (LoginUser)session.getAttribute("lu");
	        String usercode = lu.getUsercode();
	        String realName = lu.getRealName();
	        String pcode = request.getParameter("pcode");
	        String pname = request.getParameter("pname");
	        pname = new String(pname.getBytes("ISO-8859-1"), "UTF-8");
	  
	   %>
	    
		<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>添加课程讨论内容<br></pre>
					</h2>
				</center>
			</caption>
	
		    <tr class="tr">
				<td align="center">科目名称</td>
				<td><input type="text" size="64" class="input" name="pname" value=<%=pname%> disabled="true"></td>
			</tr>
			
                
           <tr class="tr">
				<td align="center">讨论人</td>
				<td><input type="text" size="64" class="input" name="realName" value=<%=realName%> disabled="true"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">讨论人回复</td>
				<td><input type="text" size="64" class="input" name="advice"></td>
			</tr>
			
			<tr class="tr">
				<td align="center"><input type="reset" value="重置" name="reset" class="reset_submit">
				</td>
				<td align="center"><input type="submit" value="下一步" name="sumbit" class="reset_submit">
				</td>
			</tr>

		</table>
		
		<input type="hidden" name="usercode" value="<%= usercode%>">
		<input type="hidden" name="pcode" value="<%= pcode%>">
		<input type="hidden" name="realName" value="<%= realName%>">
		<input type="hidden" name="pname" value="<%= pname%>">
	</form>
</body>
</html>
