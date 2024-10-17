package miProyectoMaven.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String driver="com.mysql.cj.jdbc.Driver";

	
	private MySqlConnection() {
		
	}
	public static Connection newInstance(String url,String username,String password) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("Error: No se ha podido encontrar el Driver");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.err.println("Error: No se ha podido establecer conexión con el servidor");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		return connection;	
	}
}
