<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dom4j.DocumentException" %>
<%@ page import="java.io.FileNotFoundException" %>
<%--
  Created by IntelliJ IDEA.
  User: wukunguang
  Date: 15-10-13
  Time: 下午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>欢迎<%=session.getAttribute("username")%></title>
</head>
<body>


<p><b>欢迎访问，<%=session.getAttribute("username") %></b>同学</p>

<p><b><a href="userinfo.jsp">点我查看详细详细</a></b></p>

</body>
</html>
