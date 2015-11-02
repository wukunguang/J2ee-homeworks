<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dom4j.DocumentException" %>
<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="java.io.FileNotFoundException" %>
<%--
  Created by IntelliJ IDEA.
  User: wukunguang
  Date: 15-10-27
  Time: 下午7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");


    //session.setAttribute("name",username);
    //session.setAttribute("password", password);

    try {
        if (confirm(request)){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            response.sendRedirect("user/welcomeuser.jsp?username="+request.getParameter("username"));
        }
        else {
            session.setAttribute("message","提示！用户名密码错误！");
            response.sendRedirect("/welcome.jsp");
        }
    } catch (DocumentException e) {
        e.printStackTrace();
        response.sendRedirect("/welcome.jsp");
    }

%>
<%!

    public boolean confirm(HttpServletRequest request) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();

        //获取/WEB-INF下的路径
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resource/");
        File file = new File(path,"name.xml");
        ;
        //File file = new File("/WEB-INF/resource/name.xml");
        FileInputStream fileInputStream = new FileInputStream(file);

        boolean isConfirm = false;

        Document document = null;
        document = saxReader.read(fileInputStream);
        Element root = document.getRootElement();
        Element accessElement = root.element("access"); //获取access节点

        List<Element> el = accessElement.elements("user");

        //  List<Element> el = userData.elements();  //获取用户节点下的所有子节点。

        for (Element e: el){
            System.out.println(e.element("username").getText());
            isConfirm = e.element("username").getText().equals(request.getParameter("username"))
                    && e.element("password").getText().equals(request.getParameter("password"));
            if (isConfirm){
                break;
            }
        }

        return isConfirm;
    }

%>

