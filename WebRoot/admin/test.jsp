<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.JudgeQuestion"%>
<%@ page import="com.database.JudgeQuestionDBHelp "%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>统计</title>
    
    
    
</head>
<body>
<div id="chart1" style="width:600px; height: 400px;"></div>
<div id="chartMethodOne" style="width:600px; height: 400px;"></div>
<div id="main" style="width: 600px;height:400px;"></div>
<div id="pie" style="width: 600px;height:400px;"></div>

<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.2.2/dist/echarts.js"></script>


<script type="text/javascript">
    //指定图标的配置和数据
    var option = {
        title:{
            text:'折线图'
        },
        tooltip:{},
        legend:{
            data:['访客来源']
        },
        xAxis:{
            data:["智联招聘","51job","拉钩","Boss直聘"]
        },
        yAxis:{
        },
        series:[{
            name:'访问量',
            type:'line',
            areaStyle: {
                normal: {}
            },
            data:[600,310,200,800]
        }]
    };
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart1'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
</script>

<script>
	//基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartMethodOne'));
    myChart.setOption({
        title: {
            text: '月度票量折线图（点击钻取加载，当年1-12月）'
        },
        tooltip: {},
        //legend: {
        //data:['']
        //},
        xAxis: {
            data: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
        },
        yAxis: {},
        series: [{
            name: '票量',
            type: 'line',
            data:[40,20,35,60,55,10,123490,12345,234,1234,12345,2344]
        }]

    });
</script>

<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));

	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '销量柱状图'
		},
		tooltip: {},
		legend: {
			data:['销量']
		},
		xAxis: {
			data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
		},
		yAxis: {},
		series: [{
			name: '销量',
			type: 'bar',
			data: [5, 20, 36, 10, 10, 20]
		}]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>

<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('pie'));

	myChart.setOption({
		series : [
			{
				name: '访问来源',
				type: 'pie',    // 设置图表类型为饼图
				radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
				data:[          // 数据数组，name 为数据项名称，value 为数据项值
					{value:235, name:'视频广告'},
					{value:274, name:'联盟广告'},
					{value:310, name:'邮件营销'},
					{value:335, name:'直接访问'},
					{value:400, name:'搜索引擎'}
				]
			}
		]
	})
</script>

</body>
</html>

