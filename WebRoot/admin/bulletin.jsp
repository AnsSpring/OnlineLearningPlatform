<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>在线学习平台</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">

.tr1{
	
	background-color: #6495ED;
	font-size: x-large;
	font-family: "宋体";
	color: white;
	font-weight: bold;
}

.tr2{
    
    background-color: #6495ED;
    font-family: "宋体";
    font-size: medium;
}

.a{

  text-decoration: none;
  color: white;
  
}

#content{
  
  width: 79.8%;
  height: 1260px;
  margin: auto;
  border: 1px solid #6495ED;
  background-color: #D1EEEE;
  
}


#span{
 
  height: 20px;
  font-size: large;
  font-family: "宋体";
  color: #6495ED;
  font-weight: bold;

}

.p{

   font-family: "宋体";
   text-indent:2em;
   font-size: larger;
   color: black;
   word-wrap:break-word;

}

#flash{
   
   margin-top:0px;
   margin-left:10px;
   width: 483px;
   height: 281px;
   border: 1px solid white;
   position: relative;
   float: left;

}

#flash2{
   
   margin-top:0px;
   margin-left:10px;
   width: 477px;
   height: 340px;
   border: 1px solid white;

}

#flash3{
   
   margin-top:0px;
   margin-left:10px;
   width: 514px;
   height: 273px;
   border: 1px solid white;

}


#flash4{
   
   margin-top:0px;
   margin-left:10px;
   width: 498px;
   height: 370px;
   border: 1px solid white;

}


#flash img{

   position: absolute;
   left:0px;
   top:0px;
   display:none;   

}

#flash ul{

   position: absolute;
   left: 160px;
   bottom: 4px;
}

#flash ul li{

   list-style: none;
   width: 12px;
   height: 12px;
   background: white;
   float: left;
   border-radius:50%;
   margin-right:10px; 

}

.div1{

    width: 79.8%;
    margin: auto;
    background: #D1EEEE;
    font-size:medium;
    color: #6495ED;
    line-height: 30px;
    border: 1px solid #6495ED;
    font-family: "宋体";
    font-weight: bold;
}

.textarea{
   border-color: #D1EEEE;
   border-style: solid;
   height:80px;
   color: #000;
   width: 98%;
   margin: auto;
}

.submit{
   border-color: #D1EEEE;
   border-style: solid;
   background-color: #6495ED;
   height: 30px;
   color: white;
   
}

.bottom{
   
   background-color: #6495ED;
   font-size: large;
   font-family: "宋体";
   color: #ffffff;
   height:30px;
  
}



</style>




</head>

<body>


<form action="UserAddBulletinServlet" method="post" id ="form" >


<table width="80%" height="70px" align="center" cellspacing="1" id="table">

			<tr height="30px" class="tr1">
				<td>
					<center>
						<pre>在  线  学  习  平  台  介  绍</pre>
					</center>
				</td>
			</tr>
</table>

<div id = "content">
  
   <div>
      
      <p class="p">
    在线学习是通过计算机互联网，或是通过手机无线网络，在一个网络虚拟教室与教室进行网络授课、学习的方式。
    这种学习方式是由多媒体网络学习资源、网上学习社区及网络技术平台构成的全新的学习环境。
    其好处就是不受时间、地点、空间的限制，并且可以实现和现实当中一样的互动。
        
      </p>
   
   </div>
   
   <table cellspacing="4px" cellpadding="4px"> 
   <tr>
    <td>
    <div id = "flash2" >
   
     <img src="picture/bulletin.png" alt="图片1">

   </div>
   </td>
   <td>
   <div><p class="p">
   
   在线学习是通过计算机 互联网，或是通过手机无线网络，在一个网络虚拟教室与教室进行网络授课、学习的方式。
   目前的在线学习已经不局限于此，目前网上有完善的在线学习平台系统例如像丁博士。这样的学习平台系统可以智
   能地将一个云题库与平台对接根据你的学习需要去完成你的学习目标。例如学生可以在线学习与自己学习同步的课
   程体系然后同步作答题目，作答完成后由系统智能为你呈现解题过程辅助你提高学习成绩。
  <br>
  &nbsp;&nbsp; 随着互联网的发展，教育行业在十年前就推广远程教育，通过互联网虚拟教室来实现远程视频授课，电子文档共享，
  从而让教师与学生在网络上形成一种授课与学习的互动；而现在的3G时代的来临让更加方便的学习不仅仅通过笨重的计算机，
  只要一个可以有大流量通的手机，通过3G的快速网络推进，我们就能更方便的直接地通过手机等掌上工具在线学习，
  而无线的网络使得人们的日常互动变得更加的有效！
      
   </p>
   </div>
   </td>
   </tr>
   
   <tr>
    <td>
    <div id = "flash2" >
   
     <img src="picture/book.png" alt="图片1">

   </div>
   </td>
   <td>
   <div><p class="p">
   
随着知识经济的到来，我们的学习模式受到了前所未有的冲击，各种新的学习模式如潮水般涌现，
在所有学习模式中，最具有冲击力的便是随着网络技术发展而出现的网络化学习，又称在线学习，
它是通过在网上建立教育平台，学员应用网络进行在线学习的一种全新方式。这种在线学习方式是
由多媒体网络学习资源、网上学习社区及网络技术平台构成的全新的 学习环境。相对于其他的学习模式来说，
它具有无可比拟的优势。
  <br>
  &nbsp;&nbsp; 在线学习的一个好处就是不受时间，地点，空间的限制，并且可以实现和现实当中一样的互动。
在线学习的局限性，缺乏人性化的沟通。网络人为地拉大了人与人之间的距离，为直接的情感交流设置了障碍。
缺乏员工间、讲师与员工之间的情感交流、情绪沟通，学习的效果可能大打折扣。实践功能薄弱。要真正获得和掌握知识、
技术，仅仅通过E-Learning的讲解还不够，必须亲自参与练习，在现实环境中运用。

      
   </p>
   </div>
   </td>
   </tr>
   
    <tr>
    <td>
    <div id = "flash2" >
   
     <img src="picture/book2.png" alt="图片1">

   </div>
   </td>
   <td>
   <div><p class="p">
   
在线学习的特点决定了远程学习以自学为主， 学生的大部分学习时间与 教师、同学是分离的，没有教室，更没有课堂的氛围，
这些特点会使得许多刚刚开始远程学习的学生不可避免地遇到一些困难或有些不习惯。
因此远程学习要求学习者首先应具备以下的能力。
  <br>
  &nbsp;&nbsp; 始终保持自发的学习动力。参加远程学习的学生绝大部分是成人，他们的学习动机各式各样，但不外乎提高学历、
  增加技能、在职充电、扩展职业范围等。他们一般具有较强的学习动机，较明确的学习目的，
  但是在以后长达几年的学习过程中能否保持住由此产生的学习动力是决定其学习成败的关键。对于远程学习者来说，
  这同样具有非常重大的意义。在具体的学习过程中，面对一个问题，积极的学习者不会只接受一个答案，
  或是等待老师告诉你该持什么样观点或立场；也不会只局限于到某本书或教材的某章某节上去寻找答案。

      
   </p>
   </div>
   </td>
   </tr>
   </table>
   
</div>

	
   <table width="80%" height="70px" align="center" cellpadding="10px" bgcolor="#87CEEB">
		
		   <tr ><td class="bottom"><center><h4><pre>欢  迎  访  问  在  线  学  习  平  台</pre></h4></center></td></tr>
		   <tr>
		   <td class="bottom"><center><h4><pre>Copyright  MaHaiTing  All  rights  reserved</pre></h4></center></td>
		   </tr>
   </table>
</form>
</body>
</html>
