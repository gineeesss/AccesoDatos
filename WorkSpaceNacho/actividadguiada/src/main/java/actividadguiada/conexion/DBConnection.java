package actividadguiada.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/bdclientes?serverTimezone=Europe/Madrid";
	private static String username = "usrcliente";
	private static String password = "";
	protected static Connection con;

	public static Connection getConnection(){
		
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
				System.out.println("Conectado a la base de datos");
				System.out.println(con.getMetaData().getDriverName());
				System.out.println(con.getMetaData().getDatabaseProductName());
				System.out.println(con.getCatalog());
				} catch (SQLException e) {
					System.err.println("ERROR: error al crear la conexion");
					System.err.println(e.getMessage());
					e.printStackTrace();
			}
		}
		return con;
	}
}
