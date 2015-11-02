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
public class WelcomeServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        System.out.println("index!!!!");
       // resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        pw.println("<!DOCTYPE>" +
                "<html>" +
                "<head>" +
                "<title>" +
                "欢迎界面" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<p>欢迎</p>"+req.getSession().getAttribute("name")+
                "<a href=\"/index/detail\">点我进入详情页"+"</a>"+
                "</body>" +
                "</html>");
        pw.flush();
        pw.close();

        //super.doGet(req, resp);


    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }
}
