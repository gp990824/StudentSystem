<%--
  Created by IntelliJ IDEA.
  User: baba
  Date: 2019/12/22
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <title></title>
    <script language="JavaScript">

        function deletegrade(id) {
            if (confirm("您确定要删除吗?")) {
                window.location.href = "<%=path%>/GradeDelServlet?id=" + id;
            }
        }

        function studentQuery() {
            if (document.getElementById("studentName").value == "") {
                alert("请输入学生姓名!");
                return false;
            }
            document.formUpdata.submit();
        }

        function addgrade() {
            window.location.href = "<%=path%>/QueryTotalClassStudentNameServlet";
        }
    </script>
    <style type="text/css">
        body {
            background: url(images/bg.gif);
        }
    </style>
</head>
<body leftmargin="2" topmargin="2">
<table>
    <form action="<%=path %>/UpdateGradeServlet" name="formUpdata" method="post">
        <tr>
            学生成绩查询:
        </tr>
        <tr>
            <td width="25%" bgcolor="#FFFFFF" align="right"> 请输入成绩ID：</td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" id="studentName" name="id" size="20"/>
                <input type="button" value="查询" onClick="studentQuery()"/>&nbsp;
            </td>
        </tr>
    </form>
</table>
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="6" align='center'>&nbsp;学生成绩表&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
        <td width="10%">ID</td>
        <td width="25%">姓名</td>
        <td width="25%">课程名</td>
        <td width="15%">分数</td>
        <td width="25%">操作</td>
    </tr>
    <c:forEach items="${grade}" var="s">
        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${s.id}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.stu_id}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.c_id}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.score}
            </td>

            <td bgcolor="#FFFFFF" align="center">
                <a href="#" onclick="deletegrade(${s.id})">删除</a>
                <a href="<%=path %>/UpdateGradeServlet?id=${s.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>


<table width='98%' border='0'>
    <tr>
        <td>
            <input type="button" value="添加" style="width: 80px;" onclick="addgrade()"/>
        </td>
    </tr>
</table>

</body>
</html>
