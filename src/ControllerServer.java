import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;

/**
 * This Controller class is used to
 * run the web front-end. It creates a 
 * conection to a jetty server set on port 8005. 
 * it then initialises servlet addresses.
 * @author Joseph Harwood 16041849
 * @version 1.0
 */
 
public class ControllerServer {
	
	public static void main(String[] args) throws Exception {
		//Create connection to the  server
		Server server = new Server(8005);
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp");
		ctx.setContextPath("/vehiclesdb");
		
		//config
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*[^/]*jstl.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
				"org.eclipse.jetty.annotations.AnnotationConfiguration");
		
		// Mappings
		ctx.addServlet("servlets.ServletHome", "/home");
		ctx.addServlet("servlets.ServletAddVehicle", "/addVehicle");
		ctx.addServlet("servlets.ServletUpdateVehicle", "/updateVehicle");
		ctx.addServlet("servlets.ServletSearchVehicle", "/searchVehicle");
		ctx.addServlet("servlets.ServletDeleteVehicle", "/deleteVehicle");
		ctx.addServlet("servlets.ServletLogin", "/login");
		ctx.addServlet("servlets.ServletLogout", "/logout");
		ctx.addServlet("servlets.ServletSoldVehicle", "/soldVehicle");
		ctx.addServlet("servlets.ServletUnsoldVehicle", "/unsoldVehicle");
		ctx.addServlet("servlets.ServletAddUser", "/addUser");
		ctx.addServlet("servlets.ServletGetApi", "/getApi");
		
		// API Route Mappings 
		ctx.addServlet("servlets.ServletApi", "/api");
		
		// Setting the handler and starting the Server
		server.setHandler(ctx);
		server.start();
		server.join();
	} 
}
