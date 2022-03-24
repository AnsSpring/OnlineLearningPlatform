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

<title>校园公告查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<style type="text/css">


</style>


<body leftmargin="80px" topmargin="40px" rightmargin="80px" bgcolor="#D1EEEE">
	<%
		BulletinDBHelp bdbh = new BulletinDBHelp();
		ArrayList<Bulletin> list = bdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>第<%= id %>个公告的相关信息如下</li><br>
          <li>题目是 :<%=list.get(i).getTopic() %></li>
          <li>是否审核 :<%=list.get(i).getIsCheck() %></li>
	      <li>内容是 :<%=list.get(i).getContent() %></li>
	      <li>创建时间是 :<%=list.get(i).getCreateTime() %></li>
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
