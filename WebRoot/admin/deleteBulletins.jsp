<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Bulletin"%>
<%@ page import="com.database.BulletinDBHelp "%>

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

<title>删除公告页面</title>

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
		BulletinDBHelp sdbh = new BulletinDBHelp();
		int id = Integer.parseInt(request.getParameter("id"));
		sdbh.delete(id);
	%>
	<jsp:forward page="bullInfo.jsp"></jsp:forward>
</body>
</html>
