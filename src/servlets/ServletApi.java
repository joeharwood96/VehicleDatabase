package servlets;

import models.User;
import models.Vehicle;
import models.VehicleDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VehicleDAO dao = new VehicleDAO();
	Gson gson = new Gson(); 
	PrintWriter writer;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String api = req.getParameter("api");
		boolean user;
		
		try {
			user = dao.checkUserApi(api);
			if(user == true){
				
				ArrayList<Vehicle> allVehicles = null;
				try {
					allVehicles = dao.getAllVehicles();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resp.setContentType("application/json");
				writer = resp.getWriter();
				String vehicleJSON = gson.toJson(allVehicles);
				writer.write(vehicleJSON);
				writer.close();
			} else {
				writer = resp.getWriter();
				writer.write("No access");
				writer.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
	
		//Create a new vehicle with the variables
		Vehicle v = gson.fromJson(req.getParameter("json"), Vehicle.class);
		
		
		String api = req.getParameter("api");
		boolean user;
		
		try {
			user = dao.checkUserApi(api);
			if(user == true){
		
				boolean inserted = false;
				try {
					inserted = dao.insertVehicle(v);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(inserted) {
					writer.write("new vehicle inserted");
				} else {
					writer.write("error");
				}
				resp.setContentType("application/json");
				writer = resp.getWriter();
				String vehicleJSON = gson.toJson(v);
				writer.write(vehicleJSON);
				writer.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
	
		//Create a new vehicle with the variables
		Vehicle v = gson.fromJson(req.getParameter("json"), Vehicle.class);
		
		String api = req.getParameter("api");
		boolean user;
		
		try {
			user = dao.checkUserApi(api);
			if(user == true){
			
				boolean inserted = false;
				try {
					inserted = dao.updateVehicle(v, v.getVehicle_id());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(inserted) {
					writer.write("Vehicle updated");
				} else {
					writer.write("error");
				}
				resp.setContentType("application/json");
				writer = resp.getWriter();
				String vehicleJSON = gson.toJson(v);
				writer.write(vehicleJSON);
				writer.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		//Set vehicle_id to the parameter posted from the delete button being clicked
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		
		String api = req.getParameter("api");
		boolean user;
		
		try {
			user = dao.checkUserApi(api);
			if(user == true){
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
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
