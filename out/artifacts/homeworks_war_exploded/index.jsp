<%--
  Created by IntelliJ IDEA.
  User: wukunguang
  Date: 15-9-21
  Time: 下午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
  <body>
    <h1 class="text-danger">
        <%
        if (!(request.getSession().getAttribute("username")==null)){
            out.println("欢迎"+session.getAttribute("username"));
        }
        else {
            request.getSession().setAttribute("attention","提示，非法操作！");
            response.sendRedirect("/welcome.jsp");
        }

        %>
        </h1>
  </body>
</html>
