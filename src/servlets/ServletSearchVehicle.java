package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/**
 * This Sevlet class gets the type 
 * of search e.g Vehicle ID, Make, Year
 * and also the value from the 
 * user of the web front-end
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletSearchVehicle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Get the type and value posted from the search bar and dropdown form home
		String type = (String) req.getParameter("type");
		String value = (String) req.getParameter("value");
		ArrayList<Vehicle> allVehicles;
		//Seach by the value and type, send the results to the search page
		try {
			allVehicles = dao.getVehicles(type, value);
			RequestDispatcher view = req.getRequestDispatcher("searchVehicle.jsp");
			req.setAttribute("Vehicles",allVehicles);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
