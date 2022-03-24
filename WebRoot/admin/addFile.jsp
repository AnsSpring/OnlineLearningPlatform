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

<title>上传文件</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->

</head>

<body leftmargin="40" topmargin="40" bgcolor="#D1EEEE">

 <%
	   LoginUser lu = (LoginUser)session.getAttribute("lu");
	   String username = lu.getUsername();
	   String usercode = lu.getUsercode();
	   String realName = lu.getRealName();
	   
	   session.setAttribute("lu",lu);
	   
	   String pname = request.getParameter("pname");
	   pname = new String(pname.getBytes("ISO-8859-1"), "UTF-8");
	   
	   String pcode = request.getParameter("pcode");
	   
	   session.setAttribute("pcode",pcode);
	  
	%>

 <form action="UploadServlet" method="post" enctype="multipart/form-data">
      上传人姓名：<input type="text" name="name" value="<%= realName%>" disabled="disabled"><br>
      课程名称：<input type="text" name="pname" value="<%= pname%>" disabled="disabled"><br>
      文件类型 ：<select id="select" name="fileType">
            <option value="1">课件</option>
            <option value="2">视频</option>
            <option value="3">未知</option>
       </select>
      <br>
        文件（图片，文档，视频等）：<input type="file" name="pic"><br>
      <input type="submit" value="提交" width="40">
  </form>

</body>
</html>
