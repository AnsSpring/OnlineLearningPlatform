<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.SingleChoice"%>
<%@ page import="com.database.SingleChoiceDBHelp"%>

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

<title>单选题查询页面</title>

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
		SingleChoiceDBHelp scdbh = new SingleChoiceDBHelp();
		ArrayList<SingleChoice> list = scdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>单选题<%= id %>的信息如下</li><br>
          <li>科目编码是 :<%=list.get(i).getPcode() %></li>
          <li>科目名称是 :<%=list.get(i).getName() %></li>
          <li>题目详情是 :<%=list.get(i).getQuestion() %></li>
          <li>第一个选项是 :<%=list.get(i).getOne() %></li>
          <li>第二个选型是 :<%=list.get(i).getTwo() %></li>
          <li>第三个选项是 :<%=list.get(i).getThree() %></li>
          <li>第四个选项是 :<%=list.get(i).getFour() %></li>
          <li>正确答案是 :<%=list.get(i).getAnswer() %></li>
          <li>分数是 :<%=list.get(i).getScore() %></li>
       
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
