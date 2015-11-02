package cn.xtu.edu.examples.filter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by wukunguang on 15-9-28.
 */
public class AuthenticateFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SAXReader saxReader = new SAXReader();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取/WEB-INF下的路径
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resource/");
        File file = new File(path,"name.xml");
;
        //File file = new File("/WEB-INF/resource/name.xml");
        FileInputStream fileInputStream = new FileInputStream(file);





        Document document = null;
        try {
            document = saxReader.read(fileInputStream);
            Element root = document.getRootElement();
            Element banUser = root.element("baned");
            List<Element> list = banUser.elements();


            for (Element e : list){

                if (e.getName().equals("banusername")) {
                    // map.put(e.getName(), e.getText());

                    String username = request.getParameter("username");
                    System.out.println("ssssss"+request.getParameter("username"));
                    if (e.getText().equals(username)){
                       HttpServletResponse response = (HttpServletResponse) servletResponse;

                       // ((HttpServletRequest) servletRequest).getSession().setAttribute("isIllegal","1");

                        System.out.println("拦截了"+username);
                            response.sendRedirect("/forbidden.jsp");
                        System.out.println(e.getText());
                        return;

                    }
                    else {
                        ((HttpServletRequest) servletRequest).getSession().setAttribute("isIllegal","0");
                    }

                }


            }
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (DocumentException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void destroy() {

    }
}
