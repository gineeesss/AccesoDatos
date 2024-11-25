package jdbcM0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:mysql://localhost:3306/jdbcm0?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "";
	private static Connection conn;

	public static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println(conn.getCatalog());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;

	}
}
