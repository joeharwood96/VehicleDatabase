package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This Servlet class is used 
 * to log the user out when the
 * logout button has been pressed
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletLogout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Set the session loggedin to false
		HttpSession session = req.getSession();
		session.setAttribute("loggedin", false);
		resp.sendRedirect("home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		
	}
}