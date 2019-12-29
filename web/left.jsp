<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css"/>
    <link rel="stylesheet" href="<%=path %>/css/dtree.css" type="text/css"/>
    <style type="text/css">
        div {
            padding: 0px;
            margin: 0px;
        }

        body {
            scrollbar-base-color: #bae87c;
            scrollbar-arrow-color: #FFFFFF;
            scrollbar-shadow-color: #c1ea8b;
            padding: 0px;
            margin: auto;
            text-align: center;
            background-color: #ffffff;
            background: url(images/bg.gif);
        }

        .bitem {
            background: url(images/side_snow.gif);
            height: 110px;
            line-height: 26px;
            text-align: center;
            cursor: pointer;
            background-repeat: no-repeat;
            margin-top: 0px;

        }

        .title {
            margin-left: 2px;
            background: url(images/menubg.gif);
            background-repeat: no-repeat;
            text-align: center;
            cursor: pointer;
            height: 26px;
            line-height: 26px;
        }
    </style>
    <script language='javascript'>var curopenItem = '1';</script>
    <script language="javascript" type="text/javascript" src="js/menu.js"></script>
    <base target="main"/>
</head>
<body target="main">
<div class='bitem'>

    <div class='title'>
        <tr>学生信息</tr>
        <br></div>
    <tr><a href="<%=path%>/StudentInfoManageServlet" target='main'>学生信息管理</a></tr>
    <br>
    <tr> 学生信息录入</tr>
    <br>
    <tr> 学生信息修改</tr>
    <br>
</div>

<div class='bitem'>
    <div class='title'>
        <tr>学生成绩</tr>
        <br/></div>
    <tr><a href="<%=path%>/StudentGradeManageServlet" target='main'>学生成绩管理</a> </tr>
    <br>
    <tr> 学生成绩录入</tr>
    <br>

</div>

<div class='bitem'>
    <div class='title'>
        <tr>通告</tr>
        <br></div>
    <tr> 通告信息管理</tr>
    <br>
    <tr> 添加通告</tr>
</div>
<div class='bitem'>
    <div class='title'>
        <tr>管理员账号</tr>
        <br></div>
    <tr> 管理员账号管理</tr>
    <br>
    <tr> 修改密码</tr>
</div>
</body>
</html>