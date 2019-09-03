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
 * This Servlet is used to delete 
 * a single vehicle based on the 
 * vehicle ID input by the user
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class ServletDeleteVehicle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Set vehicle_id to the parameter posted from the delete button being clicked
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		boolean done;
		//If true send result to home page
		try {
			done = dao.deleteVehicle(vehicle_id);
		if(done){
			resp.sendRedirect("home");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
