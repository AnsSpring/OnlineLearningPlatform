<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Bulletin"%>
<%@ page import="com.database.BulletinDBHelp"%>

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

<title>更新公告</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	
	window.onload = function() {

		var form = document.getElementById("form");

		var inputs = document.getElementsByTagName("input");
		
		var textareas = document.getElementsByTagName("textarea");

		form.onsubmit = function() {

			for ( var i = 0; i < inputs.length; i++) {

				if (inputs[i].value == "") {

					alert("The existing option is not filled in !!!");

					return false;
				}

			}
			
			for ( var i = 0; i < textareas.length; i++) {

				if (textareas[i].value == "") {

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
		BulletinDBHelp bdbh = new BulletinDBHelp();
		ArrayList<Bulletin> list = bdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
		String topic = null;
		String content = null;
		String isCheck = null;

	%>

	<%
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getId() == id) {

				topic = list.get(i).getTopic();
				content = list.get(i).getContent();
				isCheck = list.get(i).getIsCheck();

			}
		}
	%>
	
	<form action="TeacherModifyBulletinServlet" method="post" id ="form" >
		<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>Modify Bulletin<br></pre>
					</h2>
				</center>
			</caption>
			<tr class="tr">
				<td align="center">公告名称</td>
				<td><input type="text" size="64" class="input" name="topic" value="<%=topic %>"></td>
			</tr>
			<tr class="tr">
				<td align="center">公告内容</td>
				<td><textarea class="textarea" name="content"><%=content %></textarea></td>
			</tr>
			
			<tr class="tr">
				<td align="center"><input type="reset" value="修改" name="reset"
					class="reset_submit"></td>
				<td align="center"><input type="submit" value="下一步"
					name="sumbit" class="reset_submit"></td>
			</tr>
			
			<input type="hidden" name="id" value="<%= id%>">
			
		</table>
	</form>
</body>
</html>
