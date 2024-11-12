package miProyectoMaven.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";

	private MySQLConnection() {

	}

	public static Connection newInstance(String url, String username, String password) {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("No se ha podido encontrar el Driver: " + driver);
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.err.println("No se ha podido estblecer connexión con el servidor");
			System.err.println(e.getMessage());
			System.exit(-2);
		}

		return connection;
	}

}
