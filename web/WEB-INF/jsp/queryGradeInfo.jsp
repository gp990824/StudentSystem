<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    @author gp
    @create 2020/5/13 10:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>查询到的学生成绩信息</title>
    <script language="JavaScript">

        function deletegrade(id) {
            if (confirm("您确定要删除吗?")) {
                window.location.href = "<%=path%>/DeleteGradeByIdServlet?id=" + id;
            }
        }


    </script>
    <style type="text/css">
        body {
            background: url(images/bg.gif);
        }
    </style>
</head>
<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="6" align='center'>&nbsp;学生成绩表&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
        <td width="10%">成绩ID</td>
        <td width="25%">姓名</td>
        <td width="25%">课程名</td>
        <td width="15%">分数</td>
        <td width="25%">操作</td>
    </tr>
    <c:forEach items="${grades}" var="g">
        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${g.id}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${g.studentName}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${g.className}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${g.score}
            </td>

            <td bgcolor="#FFFFFF" align="center">
                <a href="#" onclick="deletegrade(${g.id})">删除</a>
                <a href="<%=path %>/QueryGradeInfoByIdServlet?id=${g.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
