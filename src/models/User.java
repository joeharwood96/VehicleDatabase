package models;

public class User {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int userType;
	private String api;
	
	public User (String firstname, String lastname, String username, String password, int userType, String api){
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.api = api;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	@Override
	public String toString() {
		return "User firstname: " + firstname + System.lineSeparator() + "Lastname: " + lastname + System.lineSeparator() + "Username: " + username + System.lineSeparator() + "password: "
				+ password + "conPassword: " + System.lineSeparator() + userType + System.lineSeparator() + api;
	}
	
}
