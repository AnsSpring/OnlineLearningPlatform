<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Chat"%>
<%@ page import="com.database.ChatDBHelp"%>
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

<title>更新课程讨论信息</title>

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
			
			//查询学生和教师的基本信息
			AdminDBHelp adbh = new AdminDBHelp();
			ArrayList<Admin> aList = adbh.queryByUser();
		%>

    <%
		ChatDBHelp cdbh = new ChatDBHelp();
		ArrayList<Chat> list = cdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
		String advice = null;
	

	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		    Chat c = list.get(i);

			if (c.getId() == id) {

				advice = c.getAdvice();
			}
		}
	%>
	
<form action="ModifyChatServlet" method="post" id ="form" >
	<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>修改课程内容<br></pre>
					</h2>
				</center>
			</caption>
			
			 <tr class="tr">
				<td align="center">讨论人</td>
				<td>
                    <select id="select" name="usercode">
                <%
			    	for (int i = 0; i < aList.size(); i++) {
		       	%>
		       	
                       <option value=<%=aList.get(i).getUsercode() +"," + aList.get(i).getRealName()%>><%=aList.get(i).getRealName()%></option>
                       
                <%
				   }
			    %>  
                    </select>
                </td>
            </tr> 
            
			<tr class="tr">
				<td align="center">讨论人回复</td>
				<td><input type="text" size="64" class="input" name="advice" value="<%=advice %>"></td>
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

