<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员欢迎您!</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	</head>
  	<frameset	rows="120,*" cols="*" frameborder="no" border="1" framespacing="0">
  		<frame src="top.jsp" name="topFrame" scrolling="no">
	   <frameset cols="200,*" name="btFrame" frameborder="NO" framespacing="0">
	    <frame src="left.jsp" noresize name="menu" scrolling="yes">
	    <frame src="right.jsp" noresize name="main" scrolling="yes">
	  </frameset>
  	</frameset>
  <noframes>
	  <body>您的浏览器不支持框架！</body>
  </noframes>
  </html>