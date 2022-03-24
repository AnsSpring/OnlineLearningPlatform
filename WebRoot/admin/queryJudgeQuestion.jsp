<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Project"%>
<%@ page import="com.database.ProjectDBHelp"%>
<%@ page import="com.entity.JudgeQuestion"%>
<%@ page import="com.database.JudgeQuestionDBHelp"%>

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

<title>判断题页面</title>

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
		JudgeQuestionDBHelp jdbh = new JudgeQuestionDBHelp();
		ArrayList<JudgeQuestion> list = jdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>判断题<%= id %>的信息如下</li><br>
          <li>科目编码是 :<%=list.get(i).getPcode()%></li>
          <li>科目是 :<%=list.get(i).getName()%></li>
          <li>题目是 :<%=list.get(i).getContent()%></li>
          <li>参考答案是 :<%=list.get(i).getAnswer()%></li>
          <li>分值是 :<%=list.get(i).getScore()%></li>
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
