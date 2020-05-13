<%--
  Created by IntelliJ IDEA.
  User: baba
  Date: 2019/12/23
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
    <title>Title</title>
    <script language="javascript">
        function changegrade(){
            var  f=document.gradeform;
            if(f.score.value > 100 || f.score.value < 0) {
                alert("请输入正确的分数格式");
                f.score.focus();
                return false;
            }
            document.gradeform.submit();
        }
    </script>
    <style type="text/css">
        body {
            background:url(images/bg.gif);
        }
    </style>
</head>
<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
<form action="<%=path %>/UpdateGradeScoreByIdServlet" name="gradeform" method="post" >
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="<%=path %>/images/wbg.gif" class='title' align='center'><span>学生成绩修改</span></td>
        </tr>
        <input type="hidden" name="id" size="20" value="${grade.id}" readonly="readonly"/>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

            <td width="25%" bgcolor="#FFFFFF" align="right">
                学生姓名：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="studentName" size="20" value="${grade.studentName}" readonly="readonly"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                课程名称：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="className" id="userPw" size="22"  value="${grade.className}" readonly="readonly"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                分数：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="score" id="userSex" size="22" value="${grade.score}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                &nbsp;
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="button" value="修改" onClick="changegrade()"/>&nbsp;
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
