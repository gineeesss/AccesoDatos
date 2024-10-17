package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
