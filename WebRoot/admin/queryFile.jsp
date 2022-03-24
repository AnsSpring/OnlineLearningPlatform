<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.FileVo"%>
<%@ page import="com.database.FileVoDBHelp"%>

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

<title>文件详情页面</title>

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
		FileVoDBHelp pdbh = new FileVoDBHelp();
		ArrayList<FileVo> list = pdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>文件<%= id %>的信息如下</li><br>
          <li>课程名称是 :<%=list.get(i).getPname() %></li>
          <li>文件名称是 :<%=list.get(i).getName() %></li>
          <li>文件类型是 :<%=list.get(i).getFileType() %></li>
          <li>文件地址是 :<%=list.get(i).getAddress() %></li>
          <li>文件上传人是 :<%=list.get(i).getRealName()%></li>
          <li>文件上传时间是 :<%=list.get(i).getCreateTime()%></li>
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
