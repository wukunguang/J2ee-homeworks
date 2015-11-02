<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1 class="text-danger">

      <%

          out.println("罪犯是不被欢迎的。");


      %>
  </h1>

    <br>
  </body>
</html>
