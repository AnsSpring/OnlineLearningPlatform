<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>下载文件</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->

</head>

<body leftmargin="20" topmargin="20" bgcolor="#D1EEEE">

 <%
	   LoginUser lu = (LoginUser)session.getAttribute("lu");
	   String username = lu.getUsername();
	   String usercode = lu.getUsercode();
	   String realName = lu.getRealName();
	   
	   session.setAttribute("lu",lu);
	   
	   String fileName = request.getParameter("fileName");
	   fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
	  
	%>

 <form action="DownloadServlet" method="post" id ="form">
 
      姓名：<input type="text" name="name" value="<%= realName%>" disabled="disabled"><br>
      文件名称：<input type="text" name="fileName" value="<%= fileName%>" disabled="disabled"><br>
      
      <input type="hidden" name="fileName" value="<%= fileName%>" ><br>
      <input type="submit" value="确定下载">
  </form>

</body>
</html>
