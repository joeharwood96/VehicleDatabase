package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Vehicle;
import models.VehicleDAO;

/**
 * This Servlet class is used to 
 * get information from the User
 * database and then check that the 
 * user input is a valid user
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		ArrayList<Vehicle> allVehicles;
		
		try {
			allVehicles = dao.getAllVehicles();
			RequestDispatcher view = req.getRequestDispatcher("login.jsp");
			req.setAttribute("allVehicles", allVehicles);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the username and password that was posted from the login page
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");

		//MD5 Hash the password
        MessageDigest md;
        
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			//for each byte in the password hash the byte
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        password = sb.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
        
		
		boolean user;
		VehicleDAO dao = new VehicleDAO();
		
		//If the user input is a user then set the session and send true to home
		try {
			user = dao.getUser(username, password);
			if(user == true){
				HttpSession session = req.getSession();
				session.setAttribute("loggedin", true);
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				resp.sendRedirect("home");
				
			}else {
				req.setAttribute("error","Unknown user, please try again");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				System.out.println(username);
				System.out.println(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
