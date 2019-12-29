<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baba
  Date: 2019/12/23
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css"/>
    <title>Title</title>
    <script language="JavaScript">
        function addclick() {
            var s = document.getElementById("score").value;
            if (s < 0 || s > 100) {
                alert("请输入正确的分数格式!")
                return false;
            }
            document.form.submit();
        }
    </script>
    <style type="text/css">
        body {
            background: url(images/bg.gif);
        }
    </style>
</head>
<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
<form action="<%=path %>/AddGradeServlet" name="form" method="post">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
           style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="<%=path %>/images/wbg.gif" class='title' align='center'><span>学生成绩添加</span></td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

            <td width="25%" bgcolor="#FFFFFF" align="right">
                学生姓名：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <select name="studentName">
                    <option>请选择</option>
                    <c:forEach items="${studentName}" var="s">
                        <option value="${s}">${s}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                课程名称：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <select name="className">
                    <option>请选择</option>
                    <c:forEach items="${className}" var="c">
                        <option value="${c}">${c}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                &nbsp;分数:
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="score" id="score"><br/>
                <input type="button" value="添加" onclick="addclick()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
