<%--
  Created by IntelliJ IDEA.
  User: baba
  Date: 2019/12/22
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
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

    <title>ע��ʧ��!</title>
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
<h1 align="center">�Բ��𣬴��û���������ʹ��,������ע�ᣡ</h1>
<div align="center"><a href="/StudentSystem/index.jsp">������ﷵ��</a>
</div>
</body>
</html>
