package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import miProyectoMaven.prueba.entities.Persona;

public class JDBCOperations {
	public static Statement crearSentencia(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("No se ha podido crear la sentencia");
			System.exit(-2);
		}
		return null;
	}
	
	public static PreparedStatement crearSentencia(Connection connection, String query) {
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("No se ha podido crear la sentencia");
			System.exit(-2);
		}
		return null;
	}
	public static ResultSet buscarDatos(Connection con, String query, String id, String password) {
		PreparedStatement sentencia= crearSentencia(con,query);
		try {
			sentencia.setString(1, id);
			sentencia.setString(2, password);
			sentencia.executeQuery();
		} catch (SQLException e) {
			System.err.println("No se ha podido cargar los datos de la consulta: "+ query);
			System.err.println(e.getMessage());
		}
		try {
			ResultSet resultSet = sentencia.getResultSet();
			return resultSet;
		} catch (SQLException e) {
			System.err.println("No se ha poddido crear/reccuperar el resultset");
			System.err.println(e.getMessage());
		}

		return null;
	}
	
	public static void insertData(Connection conn) {
		Statement statement = crearSentencia(conn);
		String query = "INSERT INTO PERSONAS (id, nombre, password, telefono) VALUES (?,?,?,?);";
		//Persona persona = new Persona("porras","porras","666");
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println("Error al insertar");
		}
	}
	

	public static void crearTabla(Connection conn, String query) {
		Statement sentencia = crearSentencia(conn);
		try {
			sentencia.execute(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("No se ha ejecutar la sentencia");
			System.exit(-3);
		}
	}
	
	public static ResultSet buscarDatos(Connection con, String query) {
		Statement sentencia = crearSentencia(con);
		try {
			sentencia.executeQuery(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("No se ha podido ejecutar los datos de la consulta");
			System.exit(-4);
		}
		try {
			return sentencia.getResultSet();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("No se ha podido extrear los datos de la consulta");
			return null;
		}
	}
}
