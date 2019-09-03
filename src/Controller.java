import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Vehicle;
import models.VehicleDAO;

/**
 * This Controller class is used to 
 * run the console interface, users input 
 * determines functionality base on the switch case 
 * @author Joseph Harwood 16041849
 * @version 1.0
 */

public class Controller {

	public static void main(String[] args) throws SQLException {
		//Initialize variables
		VehicleDAO dao = new VehicleDAO();
		Vehicle vehicle = null;
		ArrayList<Vehicle> allVehicles = null;
		Scanner in = new Scanner(System.in);
		int option = 0;
		
		
		do{
			//Print console 
			System.out.println("-------------------------------");
			System.out.println("Please select an option \n "
					+ "1 = Show all vehicle records \n "
					+ "2 = Search for vehicle record \n "
					+ "3 = Insert vehicle record \n "
					+ "4 = Update vehicle record \n "
					+ "5 = Delete vehicle record \n "
					+ "6 = Exit");
			System.out.println("-------------------------------");
			option = in.nextInt();
			//Start switch case
			switch(option)
			{
				case 1:
					//Print all vehicles to console
					allVehicles = dao.getAllVehicles();
					for(Vehicle v : allVehicles)
					{
						System.out.println("-----------------------");
						System.out.println(v);
					}
					break;
				case 2:
					//Search by ID
					System.out.println("Please search by vehicle ID: ");
					int searchInputId = in.nextInt();
					System.out.println(dao.getVehicle(searchInputId));
					break;
				case 3: 
					//Create a new vehicle
					System.out.println("Please enter new vehicle detials...");
					in.nextLine();
					System.out.println("Please enter make: ");
					String make = in.nextLine();
					System.out.println("Please enter model: ");
					String model = in.nextLine();
					System.out.println("Please enter year: ");
					int year = in.nextInt();
					in.nextLine();
					System.out.println("Please enter price: ");
					int price = in.nextInt();
					in.nextLine();
					System.out.println("Please enter license number: ");
					String license_number = in.nextLine();
					System.out.println("Please enter colour: ");
					String colour = in.nextLine();
					System.out.println("Please enter number of doors: ");
					int number_doors = in.nextInt();
					in.nextLine();
					System.out.println("Please enter transmission: ");
					String transmission = in.nextLine();
					System.out.println("Please enter milage: ");
					int milage = in.nextInt();
					in.nextLine();
					System.out.println("Please enter fuel type: ");
					String fuel_type = in.nextLine();
					System.out.println("Please enter engine size: ");
					int engine_size = in.nextInt();
					in.nextLine();
					System.out.println("Please enter body style: ");
					String body_style = in.nextLine();
					System.out.println("Please enter condition: ");
					String condition = in.nextLine();
					System.out.println("Please enter notes: ");
					String notes = in.nextLine();
					
					//check that licence registrations are in the correct format
					Matcher match = Pattern.compile("[A-Z]([A-Z]|\\d)\\d\\d[A-Z][A-Z][A-Z]").matcher(license_number);
				
					if (match.find()) {

					    System.out.println(license_number + ": is a valid number plate");

					} else {
						
						System.out.println(license_number + ": not a valid number plate. Reload the program to start again");
						System.exit(0);
						
					}
					//Create new vehicle with input of users
					vehicle = new Vehicle(
								1, 
								make, 
								model, 
								year, 
								price, 
								license_number, 
								colour,
								number_doors,
								transmission, 
								milage,
								fuel_type,
								engine_size,
								body_style,
								condition,
								notes,
								false
							); 
					dao.insertVehicle(vehicle);
					allVehicles = dao.getAllVehicles();
					//Print all vehicles to console
					for( Vehicle v : allVehicles)
					{
						System.out.println("------------------------");
						System.out.println(v);
					}
					break;
				case 4:
					//Update a vehicle
					System.out.println("Please choose the Vehicle ID you wish to update");
					int updateInputId = in.nextInt();
					in.nextLine();
					System.out.println("Please update make: ");
					String newMake = in.nextLine();
					System.out.println("Please update model: ");
					String newModel = in.nextLine();
					System.out.println("Please update year: ");
					int newYear = in.nextInt();
					in.nextLine();
					System.out.println("Please update price: ");
					int newPrice = in.nextInt();
					in.nextLine();
					System.out.println("Please update license number: ");
					String newLicense_number = in.nextLine();
					System.out.println("Please update colour: ");
					String newColour = in.nextLine();
					System.out.println("Please update number of doors: ");
					int newNumber_doors = in.nextInt();
					in.nextLine();
					System.out.println("Please update transmission: ");
					String newTransmission = in.nextLine();
					System.out.println("Please update milage: ");
					int newMilage = in.nextInt();
					in.nextLine();
					System.out.println("Please update fuel type: ");
					String newFuel_type = in.nextLine();
					System.out.println("Please update engine size: ");
					int newEngine_size = in.nextInt();
					in.nextLine();
					System.out.println("Please update body style: ");
					String newBody_style = in.nextLine();
					System.out.println("Please update condition: ");
					String newCondition = in.nextLine();
					System.out.println("Please update notes: ");
					String newNotes = in.nextLine();
					//Create a new vehicle with user input
					Vehicle updatedVehicle = new Vehicle(
								updateInputId, 
								newMake, 
								newModel,
								newYear,
								newPrice,
								newLicense_number,
								newColour,
								newNumber_doors,
								newTransmission,
								newMilage,
								newFuel_type,
								newEngine_size,
								newBody_style,
								newCondition,
								newNotes,
								false
							);
					
					dao.updateVehicle(updatedVehicle, updateInputId);
					allVehicles = dao.getAllVehicles();
					//Print out all vehicles to console
					for( Vehicle v : allVehicles)
					{
						System.out.println("------------------------");
						System.out.println(v);
					}
					break;
				case 5:
					//Delete by a vehicle when user inputs an ID
					System.out.println("Please choose the record ID you wish to delete");
					int deleteInputId = in.nextInt();
					dao.deleteVehicle(deleteInputId);
					allVehicles = dao.getAllVehicles();
					for( Vehicle v : allVehicles)
					{
						System.out.println("------------------------");
						System.out.println(v);
					}
					break;
				case 6:
					//Exit the loop
					System.out.println("Goodbye!");
					break;
				default:
					//If user inputs is unrecognised 
					System.out.println("No match");
			}
		}while(option != 6);
		in.close();
	}

}
