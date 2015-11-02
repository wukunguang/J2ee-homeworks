package cn.xtu.edu.examples.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wukunguang on 15-9-28.
 */
public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        //resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        pw.println("<!DOCTYPE>" +
                "<html>" +
                "<head>" +
                "<title>" +
                "详情界面" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<p>欢迎</p>"+req.getSession().getAttribute("name")+
                "<b>您的學号是2013551614</b>" +
                "<p>班级是信息工程学院软件一班</p>"+
                "</body>" +
                "</html>");

    }
}
