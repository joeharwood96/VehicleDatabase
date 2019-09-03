package models;
import java.sql.*;
import java.util.ArrayList;

/**
 * The VehicleDAO is used create a 
 * connection and use methods to 
 * alter the database dependant on
 * user input
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class VehicleDAO {
	
	/**
	 * The getDBConnection method 
	 * creates a connection to the 
	 * sqlite database
	 * @return The connection
	 * @exception ClassNotFoundException if database is not found
	 * @exception SQLException if the url is not found
	 */
	
	private static Connection getDBConnection()
	{
		Connection conn = null;
		//Try to connect to sqlite
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		//Try to connect to the vehicles database
		try
		{
			String url = "jdbc:sqlite:vehicles.sqlite";
			conn = DriverManager.getConnection(url);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	/**
	 * The getAllVehicles method retrieves all of the 
	 * vehicles in the Vehicles database
	 * @return A list of all vehicles in the Vehicles database
	 * @throws SQLException if the query is incorrect
	 */
	
	public ArrayList<Vehicle> getAllVehicles() throws SQLException 
	{
		System.out.println("Retrieving all vehicles...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM vehicles";
		Vehicle temp = null;
		ArrayList<Vehicle> vehicleList = new ArrayList<>();
		//Connect to the database and run the query
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery: " + query);
			result = statement.executeQuery(query);
			//While result to query get information
			while(result.next()) {
				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");
				boolean sold = result.getBoolean("sold");
				//Create a new vehicle list with the results
				vehicleList.add(new Vehicle(
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
						sold
					));
			}
		} finally {
			if(result != null) {result.close();}
			if(statement != null) {statement.close();}
			if(dbConnection != null){dbConnection.close();}
		}
		return vehicleList;
	}
	
	/**
	 * The getVehicles mathod searches for Vehicles 
	 * based on the input from the user
	 * @param type = The type of search taken place e.g ID, Make, Year
	 * @param value = The input of the user
	 * @return A list of vehicles resulting from the query
	 * @throws SQLException if the query is incorrect
	 */
	
	public ArrayList<Vehicle> getVehicles(String type, String value) throws SQLException 
	{
		System.out.println("Retrieving all vehicles...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM vehicles WHERE " + type + " = ?;";
		System.out.println(query);
		ArrayList<Vehicle> vehicleList = new ArrayList<>();
		//Connect to the database and run the query
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query);
			statement.setString(1, value);
			System.out.println("DBQuery: " + query);
			result = statement.executeQuery();
			//While result to query get information
			while(result.next()) {
				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");
				boolean sold = result.getBoolean("sold");
				//Create a new vehicle list with the results
				vehicleList.add(new Vehicle(
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
						sold
					));
			}
		} finally {
			if(result != null) {result.close();}
			if(statement != null) {statement.close();}
			if(dbConnection != null){dbConnection.close();}
		}
		return vehicleList;
	}
	
	/**
	 * The getVehicle method searches for vehicles 
	 * in the Vehicles database based on their id
	 * @param id = The id of the vehicles being searched 
	 * @return A single Vehicle from the Vehicle database
	 * @throws SQLException if the query is incorrect
	 */
	
	public Vehicle getVehicle(int id) throws SQLException {
		System.out.println("Searching for vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Vehicle vehicle = null;
		String query = "SELECT * FROM vehicles WHERE vehicle_id = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setInt(1, id);
			System.out.println(query);
			System.out.println("-----------------------");
			// execute SQL query
			result = statement.executeQuery();
			
			while(result.next()){
				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");
				boolean sold = result.getBoolean("sold");
				
				
				vehicle = new Vehicle( 
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
						sold
					);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (result != null) { result.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return vehicle;
	}
	
	/**
	 * The getUser method checks that the user has 
	 * input a valid user when signing in
	 * @param username = input username from user 
	 * @param password = input password from user
	 * @return false if there is no user in the database 
	 * with the input credentials
	 * @throws SQLException if the query is incorrect
	 */
	
	public boolean getUser(String username, String password) throws SQLException {
		System.out.println("Searching for vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM users WHERE username = ? AND password = ?;";
		System.out.println(password);
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setString(1, username);
			statement.setString(2, password);
			System.out.println(query);
			// execute SQL query
			result = statement.executeQuery();	
			
			while(result.next()){
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (result != null) { result.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return false;
	}
	
	/**
	 * The deleteVehicle method deletes a vehicle
	 * based on the vehicle id inputed by the user
	 * @param id = the vehicle ID input by the user
	 * @return true
	 * @throws SQLException if the query is incorrect
	 */

	public boolean deleteVehicle(int id) throws SQLException {
		System.out.println("Deleting vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String query = "DELETE FROM vehicles WHERE vehicle_id = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setInt(1, id);
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	/**
	 * The soldVehicle method changes a vehicle
	 * to being sold equeal to true based 
	 * on the vehicle id inputed by the user
	 * @param id = the vehicle ID input by the user
	 * @return true
	 * @throws SQLException if the query is incorrect
	 */

	public boolean soldVehicle(int id) throws SQLException {
		System.out.println("Updating sold...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String query = "UPDATE vehicles SET sold = 1 WHERE vehicle_id = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setInt(1, id);
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	/**
	 * The unsoldVehicle method changes a vehicle
	 * to being unsold equeal to true based 
	 * on the vehicle id inputed by the user
	 * @param id = the vehicle ID input by the user
	 * @return true
	 * @throws SQLException if the query is incorrect
	 */

	public boolean unsoldVehicle(int id) throws SQLException {
		System.out.println("Updating sold...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String query = "UPDATE vehicles SET sold = 0 WHERE vehicle_id = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setInt(1, id);
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	/**
	 * The insertVehicle method inputs 
	 * a new Vehicle object into the Vehicles
	 * database
	 * @param v = the new vehicle created
	 * @return true
	 * @throws SQLException if the query is incorrect
	 */
	
	public boolean insertVehicle(Vehicle v) throws SQLException {
		System.out.println("Inserting new vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		String query = "INSERT INTO vehicles "
				+ "(make, "
				+ "model, "
				+ "year, "
				+ "price, "
				+ "license_number, "
				+ "colour, "
				+ "number_doors, "
				+ "transmission, "
				+ "mileage, "
				+ "fuel_type, "
				+ "engine_size, "
				+ "body_style, "
				+ "condition, "
				+ "notes"
				+ " )"
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setString(1, v.getMake());
			statement.setString(2, v.getModel());
			statement.setInt(3, v.getYear());
			statement.setInt(4, v.getPrice());
			statement.setString(5, v.getLicense_number());
			statement.setString(6, v.getColour());
			statement.setInt(7, v.getNumber_doors());
			statement.setString(8, v.getTransmission());
			statement.setInt(9, v.getMileage());
			statement.setString(10, v.getFuel_type());
			statement.setInt(11, v.getEngine_size());
			statement.setString(12, v.getBody_style());
			statement.setString(13, v.getCondition());
			statement.setString(14, v.getNotes());
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	public boolean insertUser(User u) throws SQLException {
		System.out.println("Inserting new user...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		String query = "INSERT INTO users "
				+ "(firstname, "
				+ "surname, "
				+ "username, "
				+ "password, "
				+ "user_type, "
				+ "apiKey"
				+ " )"
				+ " VALUES ( ?, ?, ?, ?, ?, ?);";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setString(1, u.getFirstname());
			statement.setString(2, u.getLastname());
			statement.setString(3, u.getUsername());
			statement.setString(4, u.getPassword());
			statement.setInt(5, u.getUserType());
			statement.setString(6, u.getApi());
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	/**
	 * The updateVehicle method updates a single
	 * Vehicle in the vehicles database based on the 
	 * Vehicle ID input by a user
	 * @param v = new Vehicle object created by update
	 * @param id = the vehicle ID of the vehicle being 
	 * updated
	 * @return true
	 * @throws SQLException if the query is incorrect
	 */
	
	public boolean updateVehicle(Vehicle v, int id) throws SQLException {
		System.out.println("Updating vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String query = "UPDATE vehicles "
						+ "SET make = ? "
						+ ", model = ? "
						+ ", year = ? "
						+ ", price = ?"
						+ ", license_number = ? "
						+ ", colour = ? "
						+ ", number_doors = ? "
						+ ", transmission = ? "
						+ ", mileage = ? "
						+ ", fuel_type = ? "
						+ ", engine_size = ? "
						+ ", body_style = ? "
						+ ", condition = ? "
						+ ", notes = ? "
						+ "WHERE vehicle_id = ? ;";
		//Set the prepared statement to the get information
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setInt(15, id);
			statement.setString(1, v.getMake());
			statement.setString(2, v.getModel());
			statement.setInt(3, v.getYear());
			statement.setInt(4, v.getPrice());
			statement.setString(5, v.getLicense_number());
			statement.setString(6, v.getColour());
			statement.setInt(7, v.getNumber_doors());
			statement.setString(8, v.getTransmission());
			statement.setInt(9, v.getMileage());
			statement.setString(10, v.getFuel_type());
			statement.setInt(11, v.getEngine_size());
			statement.setString(12, v.getBody_style());
			statement.setString(13, v.getCondition());
			statement.setString(14, v.getNotes());
			System.out.println(query);
			// execute SQL query
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (resultset != null) { resultset.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return true;
	}
	
	public User getUserApi(String username, String password) throws SQLException {
		System.out.println("Searching for vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		String query = "SELECT * FROM users WHERE username = ? AND password = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setString(1, username);
			statement.setString(2, password);
			System.out.println(query);
			System.out.println("-----------------------");
			// execute SQL query
			result = statement.executeQuery();
			
			while(result.next()){
				
				String firstname = result.getString("firstname");
				String lastname = result.getString("surname");
				String usernames = result.getString("username");
				String passwords  = result.getString("password");
				int userType = result.getInt("user_type");
				String api = result.getString("apiKey");
				
				user = new User( 
						firstname,
						lastname, 
						usernames,
						passwords,
						userType,
						api
					);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (result != null) { result.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return user;
	}
	
	public boolean checkUserApi(String api) throws SQLException {
		System.out.println("Searching for vehicle...");
		Connection dbConnection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		String query = "SELECT * FROM users WHERE apiKey = ?;";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(query); 
			statement.setString(1, api);
			System.out.println(query);
			System.out.println("-----------------------");
			// execute SQL query
			result = statement.executeQuery();
			
			while(result.next()){
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally
		{
			if (result != null) { result.close();}
			if (statement != null) {statement.close();}
			if (dbConnection != null) { dbConnection.close();} 
		}
		return false;
	}
	
	
}
