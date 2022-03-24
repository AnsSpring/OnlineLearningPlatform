<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Project"%>
<%@ page import="com.database.ProjectDBHelp"%>

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

<title>科目管理页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->

<style type="text/css">
.tr1{
	background-color: #6495ED;
	font-size: x-large;
	font-family: "宋体";
}

.href{

    text-decoration: none;
    margin-left: 145px;
}

.a{
  text-decoration: none;
}

.tr2{
   
   background-color: #6495ED;
   font-size: large;
   font-family: "宋体";
   color: #ffffff;
   height:30px;
  
}

.span{
   
    text-decoration: none;
    color: #6495ED;
    font-size: large;
    font-family: "宋体";
    font-weight: bolder;
}
</style>

<script type="text/javascript">
   
   function confirmDeleteJsp(){
   
        var msg = "Are you sure you want to delete it?!!"
        
        if(confirm(msg) == true){
              
              return true;
        }else{
              return false;
        
        }
   }


</script>

</head>

	<body bottommargin="0" topmargin="30px" leftmargin="0" rightmargin="0">
        
        <table width="76%" align="center">
            <tr>
                <td align="left" ><span class="span"><a href="admin/management.jsp" class="href">
                <pre>返回上页</pre></a></span></td>
                <td width="60%" align="center"><span class="span"><a href="admin/addProject.jsp" class="href">
                <pre>添加科目</pre></a></span></td>
                <td  align="right"><span class="span"><a href="admin/home.jsp" class="href">
                <pre>返回首页</pre></a></span></td>
            </tr>
        </table>

		<%
			ProjectDBHelp pdbh = new ProjectDBHelp();
			ArrayList<Project> list = pdbh.query();
		%>

		<table width="80%" align="center">
			<tr bgcolor="#6495ED" height="34">
				<th>
					序号
				</th>
				<th>
					课程名称
				</th>
				<th>
					任课老师
				</th>
				<th>
					更新
				</th>
				<th>
					删除
				</th>
			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {
			%>

			<tr align="center" bgcolor="#D1EEEE" height="32">
				<td>
					<a href="admin/queryProject.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getId()%></a>
				</td>
				<td>
					<a href="admin/queryProject.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getName()%></a>
				</td>
				<td>
					<a href="admin/queryProject.jsp?id=<%=list.get(i).getId()%>"
						class="a"><%=list.get(i).getTeacherName()%></a>
				</td>
				<td>
					<a href="admin/updateProject.jsp?id=<%=list.get(i).getId()%>" class="a">update</a>
				</td>
				<td>
				    <a href="admin/deleteProject.jsp?id=<%=list.get(i).getId()%>" class="a" onclick="return confirmDeleteJsp()">delete</a>
			    </td>
			</tr>

			<%
				}
			%>

		</table>
		
	</body>
</html>
