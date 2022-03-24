<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>用户查询页面</title>

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
		AdminDBHelp sdbh = new AdminDBHelp();
		ArrayList<Admin> list = sdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		if(list.get(i).getId() == id){
	%>
      <ul>
          <li>用户<%= id %>的信息如下</li><br>
          <li>用户编码是 :<%=list.get(i).getUsercode() %></li>
          <li>登录名是 :<%=list.get(i).getUsername() %></li>
          <li>密码是 :<%=list.get(i).getPassword()%></li>
          <li>角色是 :<%=list.get(i).getRole() %></li>
          <li>真实姓名是 :<%=list.get(i).getRealName() %></li>
          <li>年级和班级是 :<%=list.get(i).getClassAndGrade()%></li>
          <li>性别是 :<%=list.get(i).getSex()%></li>
          <li>年龄是 :<%=list.get(i).getAge() %></li>
          <li>邮箱是 :<%=list.get(i).getMail()%></li>
          <li>电话号码是 :<%=list.get(i).getPhone()%></li>
          <li>地址是 :<%=list.get(i).getAddress() %></li>
          <li>创建时间是 :<%=list.get(i).getCreateTime()%></li>
      </ul>

	<%
	  }
		 }
	%>

</body>
</html>
