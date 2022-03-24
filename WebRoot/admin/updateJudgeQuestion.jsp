<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>更新判断题信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	
   window.onload = function() {

		var form = document.getElementById("form");
		
		var inputs = document.getElementsByTagName("input");

		form.onsubmit = function() {
			
			for ( var i = 0; i < inputs.length; i++) {

				if (inputs[i].value == "") {

					alert("The existing option is not filled in !!!");

					return false;
				}

			}

		}

	}
</script>


<style type="text/css">
.caption {
	font-family: "宋体";
	color: #6495ED;
	height: 80px;
}

.tr {
    font-family:"宋体";
    color: #6495ED;
	background-color: #D1EEEE;
	height: 36px;
}

.input{
   border-color: #D1EEEE;
   border-style: solid;
   height: 30px;
   color: #6495ED;
}

.textarea{
   border-color: #D1EEEE;
   border-style: solid;
   height: 200px;
   color: #6495ED;
   width: 410px;
}

.reset_submit{
   border-color: #D1EEEE;
   border-style: solid;
   background-color: #6495ED;
   height: 30px;
}
</style>
</head>

<body> 

    <%
		JudgeQuestionDBHelp jqdbh = new JudgeQuestionDBHelp();
		ArrayList<JudgeQuestion> list = jqdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
		String pcode = null;
		String content = null;
	    String answer = null;
		String score = null;

	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		    JudgeQuestion j = list.get(i);

			if (j.getId() == id) {

				pcode = j.getPcode();
				content = j.getContent();
				answer = j.getAnswer();
				score = j.getScore();

			}
		}
	%>
	
<form action="ModifyJudgeQuestionServlet" method="post" id ="form" >
	<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>修改判断题内容<br></pre>
					</h2>
				</center>
			</caption>
			
		
		    <tr class="tr">
				<td align="center">题目</td>
				<td><input type="text" size="64" class="input" name="content" value="<%=content %>"></td>
			</tr>
			
		   <tr class="tr">
				<td align="center">参考答案</td>
				<td>
                    <select id="select" name="answer">
                       <option value="2">×</option>
                       <option value="1">√</option>
                    </select>
                </td>
			</tr>
			
			<tr class="tr">
				<td align="center">分数</td>
				<td><input type="text" size="64" class="input" name="score" value="<%=score %>"></td>
			</tr>
			

			
			<tr class="tr">
				<td align="center"><input type="reset" value="修改" name="reset"
					class="reset_submit"></td>
				<td align="center"><input type="submit" value="下一步" name="sumbit" 
				    class="reset_submit"></td>
			</tr>
			
			<input type="hidden" name="id" value="<%= id%>">
			<input type="hidden" name="pcode" value="<%= pcode%>">
  </table>
</form>
</body>
</html>

