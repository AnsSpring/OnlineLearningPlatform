<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Chat"%>
<%@ page import="com.database.ChatDBHelp"%>

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

<title>课程讨论查询页面</title>

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
		ChatDBHelp scdbh = new ChatDBHelp();
		ArrayList<Chat> list = scdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>单选题<%= id %>的信息如下</li><br><br>
          <li>科目编码是 :<%=list.get(i).getCode() %></li>
          <li>科目名称是 :<%=list.get(i).getName() %></li>
          <li>回复人编码是 :<%=list.get(i).getUsercode() %></li>
          <li>回复人真实姓名是 :<%=list.get(i).getUsername() %></li>
          <li>回复是 :<%=list.get(i).getAdvice() %></li>
          <li>审核结果是 :<%=list.get(i).getIsCheck() %></li>
       
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
