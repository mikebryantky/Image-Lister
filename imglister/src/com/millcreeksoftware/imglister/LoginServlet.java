

package com.millcreeksoftware.imglister;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mike Bryant
 */
public class LoginServlet extends HttpServlet {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -313317927255642013L;


	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Validates a user/pass combination and, if valid, allows the user 
	 * to enter the site. Otherwise, the user is redirected back to
	 * index.jsp.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String redirect = "index.jsp";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if( !"".equals(userName) && !"".equals(password) ) {
			if(AppProps.get(userName + ".pass").equals(password)) {
			    LoginData loginData = new LoginData(userName, AppProps.get(userName + ".baseDir"));
			    request.getSession().setAttribute("loginData", loginData);
				redirect = "list.jsp";
			}			
		}
		
		response.sendRedirect(redirect);
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

		doPost(request, response);
	}
	
}
