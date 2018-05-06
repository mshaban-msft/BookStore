package backend_engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class backend_controller {

	
	/**************************************/
	/* server interfacing */
	/**************************************/
	public static void insert_into_all() {
		
		/* provide access credentials */
		String user_name = "root";
		String password = "admin";
		String port = "jdbc:mysql://localhost:3306/library";
		String jdbc_connector = "com.mysql.jdbc.Driver";
		
		try
		{
			/* connect to database */
			Class.forName(jdbc_connector);
			Connection con=DriverManager.getConnection(port, user_name, password);
			
			/* perform queries */
			Statement stmt=con.createStatement();
			String query = "INSERT INTO PUBLISHER VALUES (123, 456, 789);";
			stmt.executeUpdate(query);
			
			/* close connection */
			con.close(); 
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
}
