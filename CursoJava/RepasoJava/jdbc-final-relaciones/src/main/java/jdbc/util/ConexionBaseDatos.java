package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
	private static String url="jdbc:mysql://localhost:3306/java_curso?serverTimezone=Europe/Madrid";
	private static String username="root";
	private static String password="";
	static Connection conn = null;
	public static Connection getInstance() throws SQLException{
		if(conn == null) {
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
}

