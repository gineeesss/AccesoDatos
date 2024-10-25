package miProyectoMaven.prueba;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import miProyectoMaven.prueba.repositories.JDBCOperations;
import miProyectoMaven.prueba.entities.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC con MYSQL");

		String urlMysql = "jdbc:mysql://localhost:3306/m06";
		String username = "root";
		String password = "";
		//String urlH2="jdbc:h2:"+Path.of("m06").toAbsolutePath();
		
		
		System.out.println("Conectando a Servidor ...");
		//Connection connection = H2Connection.newInstance(urlMysql,username,password);
		Connection connection = MySqlConnection.newInstance(urlMysql, username, password);
		
		JDBCOperations.insertData(connection);
			
		Persona persona = new Persona("Nacho","qwerty","666");


		
		
		
		
		
		
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error: No se ha podido cerrar la Conexión");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}
}
