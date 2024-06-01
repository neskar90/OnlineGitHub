

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConexion {


	  
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/assoccontracancer";
	

	public static Connection instance = null;
	
	

	public static Connection getConexion() throws SQLException {
		
		// Establecemos la conexion y almacenarla en la variable instance //
		if(instance == null) {
			
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			props.put("charset", "UTF-8");

			
			instance = DriverManager.getConnection(JDBC_URL, props);	
		}
		return instance;
		
	}
	
	
	
	
	
}