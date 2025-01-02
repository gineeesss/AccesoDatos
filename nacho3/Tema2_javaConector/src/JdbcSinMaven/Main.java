package JdbcSinMaven;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexion a jdbc sin de Maven con H2");
		// String urlMysql = "jdbc:mysql://localhost/oposiciones";
		String urlH2 = "jdbc:h2:" + Path.of("m06").toAbsolutePath().toString();
		String username = "root";
		String password = "secret";
		System.out.println("Conectando al servidor H2 ... ");
		// Connection connection = MySQLConnection.newInstance(urlMysql, username,
		// password);
		Connection connection = H2Connection.newInstance(urlH2, username, password);
		System.out.println("Conectado a la base de datos del servidor H2.");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cerrando la conexión con el servidor SGBD.");
	}

}
