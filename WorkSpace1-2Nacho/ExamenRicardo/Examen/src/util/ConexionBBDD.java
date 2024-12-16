package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static String url="jdbc:mysql://localhost:3306/bdcoches";
	private static 	String username="usrcoches";
	private static String password="12345";
	public static Connection con;
	
	
	
	public static Connection getInstance() {
		if (con==null) {
			try {
				con = DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	

}
