package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private String URL;
	private String username;
	private String password;
	private String driverClasseName;
	
	public Database(String URL, String username, String password,String driverClasseName) {
		super();
		this.URL=URL;
		this.username = username;
		this.password = password;
		this.driverClasseName = driverClasseName;
	}
	
	public Connection connexion() {
		try {
			Connection connection = DriverManager.getConnection(URL, username, password);
			return connection;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
