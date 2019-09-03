package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.VehicleDAO;

/**
 * This Servlet class is used 
 * to add a new vehicle to the
 * database, taking input from the 
 * user of the web front-end
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletAddUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("addUser.jsp");
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehicleDAO dao = new VehicleDAO();
		//Set variables to the information posted from the form on addVehicle.jsp 
		String firstname = (String) req.getParameter("firstname");
		String lastname = (String) req.getParameter("lastname");
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		String conPassword = (String) req.getParameter("conPassword");
		String api = getSaltString();
		
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
		
			//Create a new vehicle with the variables
			User u = new User(
					firstname,
					lastname,
					username,
					password,
					0,
					api
			);
			//Try the insert and redirect back to the home page
			try {
				boolean done = dao.insertUser(u);
				System.out.println(done);;
				if (done) {
					resp.sendRedirect("home");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		
	}
	
	protected String getSaltString() {
	    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    StringBuilder salt = new StringBuilder();
	    Random rnd = new Random();
	    while (salt.length() < 18) { // length of the random string.
	        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	        salt.append(SALTCHARS.charAt(index));
	    }
	    String saltStr = salt.toString();
	    return saltStr;

	}

}


