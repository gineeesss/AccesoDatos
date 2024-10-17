package miProyectoMaven.prueba;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

import miProyectoMaven.prueba.repositories.JDBCOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC con MYSQL");
		String urlMysql = "jdbc:mysql://localhost/m06";
		//String urlH2="jdbc:h2:"+Path.of("m06").toAbsolutePath();
		String username = "root";
		String password = "secret";
		System.out.println("Conectando a Servidor H2...");
		Connection connection = H2Connection.newInstance(urlMysql,username,password);
		String crearTablaPersonas="CREATE TABLE IF NOT EXIST PERSONAS("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "nombre VARCHAR(30) NOT NULL,"
				+ "password VARCHAR(30) NOT NULL,"
				+ "telefono INTEGER(9) NOT NULL);";
		
		String crearTablaDireccioness="CREATE TABLE IF NOT EXIST DIRECCIONES("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "persona_id INTEGER REFERENCES personas(id),"
				+ "dirrecion VARCHAR(50) NOT NULL,"
				+ "telefono INTEGER(9) NOT NULL);";
		JDBCOperations.crearTabla(connection, crearTablaPersonas);
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Cerrando la conexión");
		}
	}
}
