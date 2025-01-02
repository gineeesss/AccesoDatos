package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

	private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "";
	private static Connection conn;
	// Statement stmt = null;
	// ResultSet resultado = null;

	public static Connection getInstance() throws SQLException {

		return DriverManager.getConnection(url, username, password);

	}

}
