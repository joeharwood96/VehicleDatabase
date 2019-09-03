package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VehicleDAO;

/**
 * This Servlet class gets the 
 * vehicle ID of the vehicle being 
 * updated, then creates a new 
 * vehicle object from the input 
 * of the user using the wb front-end
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletSoldVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Get the vehicle id of the sold button clicked
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		System.out.println(vehicle_id);
		//Set the vehicle sold to true based on the vehicle id
		boolean done;
		try {
			done = dao.soldVehicle(vehicle_id);
		if(done){
			resp.sendRedirect("home");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}