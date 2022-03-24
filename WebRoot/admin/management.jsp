<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<style type="text/css">

.div{
   font-family: "宋体";
   color:white;
   width:79.8%;
   height:60px;
   margin:auto;
   text-align:center;
   overflow:hidden;
   font-size:medium;
   font-weight:bold;
   background-color: #6495ED;

}

.a{
  text-decoration: none;
  color: white;
}

.tr{
   
   background-color:#6495ED;
   font-size: large;
   font-family: "宋体";
   color: #ffffff;
   height:30px;
  
}

</style>

</head>
  
<body topmargin="10" vlink="#6495ED">
   <div class="div"><pre><center><h2>后  台  管  理  模  块</h2></center></pre></div>
		<table width="77%" align="center">
			<tr bgcolor="#6495ED">
				<td>
					<table width="77%" align="center">
						<tr height="40">
							<th>
								<a href="admin/adminManagement.jsp" class="a">用户基本信息管理</a>
							</th>
							<th>
								<a href="admin/projectManagement.jsp" class="a">科目管理</a>
							</th>
							<th>
								<a href="admin/scManagement.jsp" class="a">单选题型管理</a>
							</th>
							
							<th>
								<a href="admin/jqManagement.jsp" class="a">判断题型管理</a>
							</th>
							
							<th>
								<a href="admin/erManagement.jsp" class="a">学生成绩管理</a>
							</th>
							
							
						</tr>
						
						
						<tr height="40">
							<th>
								<a href="admin/chatManagement.jsp" class="a">课程讨论管理</a>
							</th>
							
							<th>
								<a href="admin/fileManagement.jsp" class="a">文件管理</a>
							</th>
							
							<th>
								<a href="admin/bulletinManagement.jsp" class="a">公告管理</a>
							</th>
							
							<th>
								<a href="admin/courseManagement.jsp" class="a">选课管理</a>
							</th>
							
						</tr>
						
					</table>

				</td>
			</tr>
			
			<tr>
				<td>
					<center>
						<img src="picture/backStage.png">
					</center>
				</td>
			</tr>

		</table>

		<table width="80%" align="center"  bgcolor="#87CEEB">

			<tr>
				<td class="tr">
					<center>
						<h4>
							<pre>欢 迎 访 问 后 台 管 理 页 面</pre>
						</h4>
					</center>
				</td>
			</tr>
			<tr>
				<td class="tr">
					<center>
						<h4>
							<pre>基 于 JAVA WEB 的 在 线 学 习 平 台</pre>
						</h4>
					</center>
				</td>
			</tr>
		</table>

	</body>
</html>
