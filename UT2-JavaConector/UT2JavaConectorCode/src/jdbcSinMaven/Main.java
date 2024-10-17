package jdbcSinMaven;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC de Maven");
		String urlH2="jdbc:h2:"+Path.of("m06").toAbsolutePath();
		String username = "root";
		String password = "secret";
		System.out.println("Conectando a Servidor H2...");
		Connection connection = H2Connection.newInstance(urlH2,username,password);
		System.out.println("Conectado");
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Cerrando la conexión");
		}
	}
}
