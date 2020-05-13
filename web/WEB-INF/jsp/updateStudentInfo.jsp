<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baba
  Date: 2019/12/22
  Time: 16:38
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
    <title></title>
    <script language="javascript">
        function check4() {
            var f = document.formAdd;

            if (f.name.value == "") {
                alert("请输入用户名");
                f.name.focus();
                return false;
            }

            if ((f.password.value.length < 6) || (f.password.value == "")) {
                alert("请输入至少 6 个字符的密码!");
                f.password.focus();
                return false;
            }


            if (f.sex.value == "") {
                alert("请指定性别");
                f.sex.focus();
                return false;
            }


            var q1 = f.email.value.indexOf("@");
            var q2 = f.email.value.indexOf(".");
            if (q1 == -1 || q2 == -1) {
                alert("请输入有效的电子邮件地址");
                f.email.focus();
                return false;
            }

            document.formAdd.submit();
        }
    </script>
    <style type="text/css">
        body {
            background: url(images/bg.gif);
        }
    </style>
</head>
<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
<form action="<%=path %>/UpdateStudentInfoServlet" name="formAdd" method="post">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
           style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="<%=path %>/images/wbg.gif" class='title' align='center'><span>学生信息修改</span></td>
        </tr>
        <input type="hidden" name="id" size="20" value="${user.id}"/>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

            <td width="25%" bgcolor="#FFFFFF" align="right">
                用户名：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="name" size="20" value="${user.name}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                密码：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="password" name="password" id="userPw" size="22" value="${user.password}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                性别：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <select name="sex" id="userSex">
                    <option>${user.sex}</option>
                    <c:if test="${user.sex eq '男'}">
                        <option>女</option>
                    </c:if>
                    <c:if test="${user.sex eq '女'}">
                        <option>男</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                电子邮箱：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="email" id="userEm" size="22" value="${user.email}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                &nbsp;
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="button" value="修改" onClick="check4()"/>&nbsp;
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
