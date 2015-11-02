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
    <title>詳細信息-<%=session.getAttribute("password")%></title>
</head>
<body>



<p>您的學号是2013551614</p>

<p>班级是信息工程学院软件一班,您的密碼是：<%=session.getAttribute("password")%></p>
</body>
</html>
