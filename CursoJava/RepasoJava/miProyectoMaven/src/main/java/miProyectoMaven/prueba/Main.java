package miProyectoMaven.prueba;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import miProyectoMaven.prueba.repositories.JDBCOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC con MYSQL");

		String urlMysql = "jdbc:mysql://localhost:3306/m06";
		String username = "root";
		String password = "";
		//String urlH2="jdbc:h2:"+Path.of("m06").toAbsolutePath();
		
		
		System.out.println("Conectando a Servidor ...");
		//Connection connection = H2Connection.newInstance(urlMysql,username,password);
		Connection connection = MySqlConnection.newInstance(urlMysql, username, password);
		String crearTablaPersonas="CREATE TABLE IF NOT EXISTS PERSONAS("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "nombre VARCHAR(30) NOT NULL,"
				+ "password VARCHAR(30) NOT NULL,"
				+ "telefono INTEGER(9) NOT NULL);";
		
		String crearTablaDirecciones="CREATE TABLE IF NOT EXISTS DIRECCIONES("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "persona_id INTEGER REFERENCES personas(id),"
				+ "direccion VARCHAR(50) NOT NULL,"
				+ "FOREIGN KEY (personas_id) REFERENCES personas(id));";
		
		//JDBCOperations.crearTabla(connection, crearTablaPersonas);
		//JDBCOperations.crearTabla(connection, crearTablaDirecciones);
		
		JDBCOperations.insertarDatos(connection);
			
		Scanner scr = new Scanner(System.in);
		//String iduser= scr.nextLine();
		//scr.nextLine();
		//System.out.println("Contra");
		//String passUser = scr.nextLine();
	
		//String buscarPersona = "SELECT * FROM PERSONAS WHERE ID ='" + iduser+"' AND password='"+ passUser+"';";
		//String buscarPersona = "SELECT * FROM PERSONAS WHERE ID=1;";
		/*String buscarPersona = "SELECT * FROM PERSONAS WHERE ID =? AND password=?;";
		
	
		ResultSet resultSet = JDBCOperations.buscarDatos(connection, buscarPersona, iduser,passUser);
		//ResultSet resultSet = JDBCOperations.buscarDatos(connection, buscarPersona);
		if(resultSet!=null) {
			try {
				while(!resultSet.isLast()) {
					resultSet.next();
					System.out.println("ID: " + resultSet.getInt(1) + "Nombre: " + resultSet.getString(2)+resultSet.getString(3)+resultSet.getString(4));
				}
			} catch (SQLException e) {
				System.err.println("Error: No se ha podido recorrer el resulutSet");
				System.err.println(e.getMessage());
				System.exit(-5);
			}
		}
		*/
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error: No se ha podido cerrar la Conexión");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}
}
