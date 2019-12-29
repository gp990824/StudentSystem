<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page isELIgnored="false" %>
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
	body {
		 background:url(images/bg.gif);
		}
	</style>
	</head>
<body >
		<h1 align="center">对不起，用户名与密码不匹配！</h1>
		<div align="center"><a href="/StudentSystem/index.jsp">点击这里返回</a>
		</div>
</body>
</html>