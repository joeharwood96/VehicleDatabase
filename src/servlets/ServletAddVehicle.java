package servlets;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/**
 * This Servlet class is used 
 * to add a new vehicle to the
 * database, taking input from the 
 * user of the web front-end
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletAddVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("addVehicle.jsp");
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Set variables to the information posted from the form on addVehicle.jsp 
		String make = (String) req.getParameter("make");
		String model = (String) req.getParameter("model");
		int year = Integer.parseInt(req.getParameter("year"));
		int price = Integer.parseInt(req.getParameter("price"));
		String license_number = (String) req.getParameter("license_number");
		String colour = (String) req.getParameter("colour");
		int number_doors = Integer.parseInt(req.getParameter("number_doors"));
		String transmission = (String) req.getParameter("transmission");
		int mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuel_type = (String) req.getParameter("fuel_type");
		int engine_size = Integer.parseInt(req.getParameter("engine_size"));
		String body_style = (String) req.getParameter("body_style");
		String condition = (String) req.getParameter("condition");
		String notes = (String) req.getParameter("notes");
		//Create a new vehicle with the variables
		Vehicle v = new Vehicle(
				1, 
				make,
				model,
				year,
				price,
				license_number,
				colour,
				number_doors,
				transmission,
				mileage,
				fuel_type,
				engine_size,
				body_style,
				condition,
				notes,
				false
		);
		//Try the insert and redirect back to the home page
		try {
			boolean done = dao.insertVehicle(v);
			System.out.println(done);;
			if (done) {
				resp.sendRedirect("home");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

}
