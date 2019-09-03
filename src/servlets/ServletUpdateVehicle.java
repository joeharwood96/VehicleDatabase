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
 * This Servlet class gets the 
 * vehicle ID of the vehicle being 
 * updated, then creates a new 
 * vehicle object from the input 
 * of the user using th
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletUpdateVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		Vehicle Vehicle;
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		
		try {
			Vehicle = dao.getVehicle(vehicle_id);
			RequestDispatcher view = req.getRequestDispatcher("updateVehicle.jsp");
			req.setAttribute("Vehicles", Vehicle);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Get the parameters form the form on the update page and set them to the variables
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
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
				vehicle_id, 
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
		//Try to update the vehicle with the vehicle created and the vehicle id
		try {
			boolean done = dao.updateVehicle(v, vehicle_id);
			System.out.println(done);;
			if (done) {
				resp.sendRedirect("home");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

}

