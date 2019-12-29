<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.top { padding: 0;width:1280px; height: 244px; background: url(images/header.gif) no-repeat 0 100%;
			background-size:100% 100%;
			background-attachment:fixed;
			align:center; }
		.text{	
			margin-left:450px;
			margin-top:20px;
			align:center;
			font-size:28px;
			font-style:normal;
			font-stretch:normal;
			width:350px;
		}
		.rigth{
			margin:10px;
			margin-left:790px;
			width:550px;
			color:red;
		}
	</style>
	 
  </head>
  <body class="top">
  	<table >
  		<div class="text">
  		<p >学生信息管理系统欢迎您</p></div>
  		 
  	</table>
  </body>
</html>