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

<title>更新单选题信息</title>

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
		SingleChoiceDBHelp scdbh = new SingleChoiceDBHelp();
		ArrayList<SingleChoice> list = scdbh.query();
		int id = Integer.parseInt(request.getParameter("id"));
		String pcode = null;
		String question = null;
	    String one = null;
		String two = null;
	    String three = null;
		String four = null;
	    String answer = null;
		Integer score = null;

	%>

	<%
		for (int i = 0; i < list.size(); i++) {
		
		    SingleChoice sc = list.get(i);

			if (sc.getId() == id) {

				pcode = sc.getPcode();
				question = sc.getQuestion();
				one = sc.getOne();
				two = sc.getTwo();
				three = sc.getThree();
				four = sc.getFour();
				answer = sc.getAnswer();
				score = sc.getScore();

			}
		}
	%>
	
<form action="ModifySingleChoiceServlet" method="post" id ="form" >
	<table align="center" width="40%">
			<caption class="caption">
				<center>
					<h2>
						<pre>修改单选题内容<br></pre>
					</h2>
				</center>
			</caption>
			
			<tr class="tr">
				<td align="center">问题描述</td>
				<td><input type="text" size="64" class="input" name="question" value="<%=question %>"></td>
			</tr>
			
		    <tr class="tr">
				<td align="center">第一个选项</td>
				<td><input type="text" size="64" class="input" name="one" value="<%=one %>"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">第二个选项</td>
				<td><input type="text" size="64" class="input" name="two" value="<%=two %>"></td>
			</tr>
			
				   <tr class="tr">
				<td align="center">第三个选项</td>
				<td><input type="text" size="64" class="input" name="three" value="<%=three %>"></td>
			</tr>
			
			<tr class="tr">
				<td align="center">第四个选项</td>
				<td><input type="text" size="64" class="input" name="four" value="<%=four %>"></td>
			</tr>
			
		   <tr class="tr">
				<td align="center">参考答案</td>
				<td>
                    <select id="select" name="answer">
                       <option value="1">第一个选项</option>
                       <option value="2">第二个选项</option>
                       <option value="3">第三个选项</option>
                       <option value="4">第四个选项</option>
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

