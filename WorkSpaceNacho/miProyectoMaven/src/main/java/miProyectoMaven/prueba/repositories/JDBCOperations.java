package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import miProyectoMaven.prueba.entities.Persona;

public class JDBCOperations {

	protected static Statement crearSentencia(Connection connection) {

		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.err.println("No se ha podido crear la sentencia");
			System.err.println(e.getMessage());
			System.exit(-3);
		}

		return null;

	}

	protected static PreparedStatement crearSentencia(Connection connection, String query) {
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido crear la sentencia preparada");
			System.err.println(e.getMessage());
			System.exit(-5);
		}

		return null;
	}

	public static void crearTabla(Connection conn, String query) {

		Statement sentencia = crearSentencia(conn);

		try {
			sentencia.execute(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la consulta: " + query);
			System.err.println(e.getMessage());
			System.exit(-4);
		}

	}

	public static ResultSet buscarDatos(Connection con, String query) {

		Statement sentencia = crearSentencia(con);

		try {
			sentencia.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar de la consulta: " + query);
			System.err.println(e.getMessage());
			return null;

		}

		try {
			ResultSet resultSet = sentencia.getResultSet();
			return resultSet;
		} catch (SQLException e) {
			System.err.println("No se ha podido recuperar los datos de la consulta: " + query);
			System.err.println(e.getMessage());
			return null;

		}

	}

	public static void insertData(Connection conn) {
		Statement estado = crearSentencia(conn);
		Persona persona = new Persona("Alvaro2", "61213", "435234");
		Persona persona2 = new Persona("TANIA2", "689789", "45654");
		try {
			String query = "INSERT INTO personas (nombre, password, telefono) " + "VALUES " + "('" + persona.getNombre()
					+ "','" + persona.getPassword() + "' , '" + persona.getTelefono() + "')," + " ('"
					+ persona2.getNombre() + "','" + persona2.getPassword() + "' , '" + persona2.getTelefono() + "');";
			estado.executeUpdate(query);
			System.out.println(query);
		} catch (SQLException ex) {
			System.out.println("Error al insertar datos");
		}
	}

	public static ResultSet buscarDatos(Connection con, String query, String id, String password) {
		PreparedStatement sentencia = crearSentencia(con, query);

		try {
			sentencia.setString(1, id);
			sentencia.setString(2, password);
			System.out.println("ejecutando sentecia preparada");
			sentencia.executeQuery();
		} catch (SQLException e) {
			System.err.println("No se ha podido recuperar los datos de la consulta: " + query);
			System.err.println(e.getMessage());
			return null;
		}
		try {
			ResultSet resultSet = sentencia.getResultSet();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
