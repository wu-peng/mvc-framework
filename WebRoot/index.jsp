<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="stu" method="post">
    	姓名：<input type="text" name="name"/><br/>
    	地址：<input type="text" name="address"/><br/>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
