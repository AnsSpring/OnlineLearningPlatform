<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Result"%>
<%@ page import="com.database.ResultDBHelp "%>
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

<title>学生成绩管理页面</title>

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
                <pre></pre></a></span></td>
                <td  align="right"><span class="span"><a href="admin/home.jsp" class="href">
                <pre>返回首页</pre></a></span></td>
            </tr>
        </table>

	    <%
			ResultDBHelp rdbh = new ResultDBHelp();
			ArrayList<Result> list = rdbh.query();
		%>

		<table width="90%" align="center">
			<tr bgcolor="#6495ED" height="34">
				<th>
					编号
				</th>
				<th>
					题型
				</th>
				<th>
					科目
				</th>
				<th>
					做题人
				</th>
				<th>
					做题时间
				</th>
				<th>
					题目总分
				</th>
				<th>
					实际得分
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
					<%=list.get(i).getId()%>
				</td>
				<td>
					<%=list.get(i).getTypeValue()%>
				</td>
				<td>
				    <%=list.get(i).getName()%>
				</td>
				<td>
					<%=list.get(i).getRealName()%>
				</td>
				<td>
				    <%=list.get(i).getCreateTime()%>
			    </td>
			    <td>
					<%=list.get(i).getTotalScore()%>
				</td>
				<td>
				    <%=list.get(i).getScore()%>
			    </td>
			    <td>
				    <a href="admin/deleteEr.jsp?id=<%=list.get(i).getId()%>" class="a" onclick="return confirmDeleteJsp()">delete</a>
			    </td>
			</tr>

			<%
				}
			%>

		</table>
		
	</body>
</html>
