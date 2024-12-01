package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:mysql://localhost:3306/bdcoches?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "";
	private static Connection conn;

	public static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println(conn.getCatalog());
				System.out.println(conn.getMetaData().getURL());
			} catch (SQLException e) {
				System.err.println("Error: no se ha podido obtener la instancia de la conexión");
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return conn;

	}
}
