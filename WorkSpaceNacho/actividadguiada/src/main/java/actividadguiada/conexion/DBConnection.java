package actividadguiada.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/bdclientes?serverTimezone=Europe/Madrid";
	private static String username = "usrcliente";
	private static String password = "";
	protected static Connection con;

	public static Connection getConnection() throws SQLException {
		if (con == null) {
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
		}
		return con;
	}
}
