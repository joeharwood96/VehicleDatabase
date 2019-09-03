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
 * This Servlet class gets a list of 
 * all Vehicles from the Vehicles database
 * forwards the result to index.jsp
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletHome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		ArrayList<Vehicle> allVehicles;
		//Get all vehicles from the database and send the variable all vehicles to the home page
		try {
			allVehicles = dao.getAllVehicles();
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			req.setAttribute("allVehicles", allVehicles);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
