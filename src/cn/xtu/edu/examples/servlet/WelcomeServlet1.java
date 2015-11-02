package cn.xtu.edu.examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet1 extends HttpServlet {

	//private String welcome_prefix = "Hello,";
	//private final String FIRST_VISITOR = "fisrtVisitor";
	/**
	 * Constructor of the object.
	 */
	public WelcomeServlet1() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		



	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		String name = request.getParameter("name");

		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		//if (session.getAttribute("isIllegal").equals("1")){

	//		response.sendRedirect("/forbdden.jsp");
	//	}
		if (name.trim().equals("") || password.trim().equals("") ){
			session.setAttribute("massage","注意，用户名或者密码不能为空");
			response.sendRedirect("/welcome.jsp");


		}
		else if (name.equals("wukunguang") && password.equals("123456")){
			session.setAttribute("name",name);
			session.setAttribute("password",password);
			response.sendRedirect("/index");
		}
		else {
			session.setAttribute("message","提示！用戶名或者密碼錯誤！");
			response.sendRedirect("/welcome.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		super.init();
		//ServletConfig config = this.getServletConfig();
	//	if(config.getInitParameter("welcome_prefix") != null){
	//		welcome_prefix = config.getInitParameter("welcome_prefix");
	//	}
	}

}
