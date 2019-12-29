<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

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
		body{
			background-image:url("images/bg.gif")
			
		}
	</style>
  </head>
  <%!String getDate() 
{ 
Date now = new Date(); 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
return sdf.format(now); 
} 
%>
  <body>
  	<div class="nav" id="container">
	<div class="main_top">
		<ul class="main_top_title">
			<li>服务器基本信息</li>
		</ul>
	</div>
	<table class="main_con1" cellpadding="0" cellspacing="0">
		<tr class="main_con_title">	
			<td colspan="4">服务器的有关参数</td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td class="main_con_item1">系统名称：</td>
			<td class="main_con_item2">学生信息管理系统</td>
			<td class="main_con_item3">服务器操作系统：</td>
			<td class="main_con_item4">windows 10</td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td  class="main_con_item1">服务器：</td>
			<td  class="main_con_item2"><%=request.getServerName()%></td>
			<td  class="main_con_item3">服务器端口：</td>
			<td  class="main_con_item4"><%=request.getServerPort()%></td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td class="main_con_item1">使用协议：</td>
			<td class="main_con_item2"><%=request.getProtocol() %></td>
			<td class="main_con_item3">系统版本号：</td>
			<td class="main_con_item4">1.4</td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td class="main_con_item1">服务器时间：</td>
			<td class="main_con_item2"><%=getDate()%></td>
			<td class="main_con_item3">建议分辩率：</td>
			<td class="main_con_item4">越高越好</td>
		</tr>
	</table>
	<table class="main_con1" cellpadding="0" cellspacing="0">
		<tr class="main_con_title">	
			<td colspan="4">系统快捷管理操作</td>
		</tr>
		<tr>	
			<td colspan="2" class="main_con_item1">常用管理链接：自己写去</td>
		</tr>
	</table>
	<table class="main_con1" cellpadding="0" cellspacing="0">
		<tr class="main_con_title">	
			<td colspan="4">系统维护联系方式 110 技术支持 120</td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td class="main_con_item1">学校名称：</td>
			<td class="main_con_item2">江西农业大学</td>
			<td class="main_con_item3">通迅地址：</td>
			<td class="main_con_item4">江西省南昌市青山湖区庐山中大道888号江西农业大学东区</td>
		</tr>
		<tr  onmouseover="changecolor(this);" onmouseout="changecolor(this);">
			<td class="main_con_item1">邮政编码：</td>
			<td class="main_con_item2">330000</td>
			
		</tr>
		
	</table>
</div>
  </body>
</html>