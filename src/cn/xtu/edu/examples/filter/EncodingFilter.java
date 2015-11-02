package cn.xtu.edu.examples.filter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wukunguang on 15-9-28.
 */
public class EncodingFilter implements Filter {

    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        encoding = filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("DoEncoding");


        File file = new File("/resource/name.xml");
        System.out.println(file.getName());
        servletResponse.setCharacterEncoding(encoding);
        servletRequest.setCharacterEncoding(encoding);
        Map<String,String> map = new HashMap<String,String>();

       // HttpServletRequest request = (HttpServletRequest) servletRequest;
       // String path = request.getSession().getServletContext().getRealPath("/WEB-INF/resource/");

        filterChain.doFilter(servletRequest, servletResponse);
       // System.out.println(path);
    }

    @Override
    public void destroy() {

        encoding = null;


    }
}
