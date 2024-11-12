package miProyectoMaven.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import miProyectoMaven.prueba.repositories.JDBCOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexion a jdbc CON de MYSQL.");
		String urlMysql = "jdbc:mysql://localhost/m07";
		// String urlH2 = "jdbc:h2:" + Path.of("m06").toAbsolutePath().toString();
		String username = "root";
		String password = "";
		System.out.println("Conectando al servidor MYSQL ... ");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);
		// Connection connection = H2Connection.newInstance(urlH2, username, password);
		System.out.println("Conectado a la base de datos del servidor MYSQL.");
		// String crearTablaPersonas = "CREATE TABLE IF NOT EXISTS PERSONAS(" + "id
		// INTEGER PRIMARY KEY AUTO_INCREMENT,"
		// + "nombre VARCHAR(30) NOT NULL," + "password VARCHAR(30) NOT NULL," +
		// "telefono VARCHAR(9) NOT NULL);";
		// JDBCOperations.crearTabla(connection, crearTablaPersonas);

		/*
		 * String crearTablaDirecciones = "CREATE TABLE IF NOT EXISTS DIRECCIONES(" +
		 * "id INTEGER PRIMARY KEY AUTO_INCREMENT," + "persona_id INTEGER NOT NULL," +
		 * "direccion VARCHAR(50) NOT NULL, " +
		 * "FOREIGN KEY (persona_id) REFERENCES personas(id));";
		 * JDBCOperations.crearTabla(connection, crearTablaDirecciones);
		 */

		// PEDIMOS EL ID AL USUARIO POR TECLADO O FORMULARIO
		// PROBLEMAS DE SEGURIDAD DEL STATEMENT ...
		// JDBCOperations.insertData(connection);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el ID de su usuario para recuperar sus datos :");
		String iduser = scanner.next();
		scanner.nextLine();
		System.out.println("Introduzca la contraseña de su usuario para recuperar sus datos :");
		String passUser = scanner.nextLine();
		// String buscarPersona = "SELECT * FROM PERSONAS WHERE ID=" + iduser + " AND
		// password='" + passUser + "';";// PUNTO
		String buscarPersona = "SELECT * FROM PERSONAS";// WHERE ID=? AND password=?;"; // Y
		System.out.println(buscarPersona);
		// ResultSet resultSet = JDBCOperations.buscarDatos(connection, buscarPersona,
		// iduser, passUser); // COMA
		ResultSet resultSet = JDBCOperations.buscarDatos(connection, buscarPersona);
		if (resultSet != null) {

			try {
				while (!resultSet.isLast()) {
					resultSet.next();
					System.out.println("Datos recuperados: ");
					System.out.println("ID : " + resultSet.getInt(1) + " Nombre: " + resultSet.getString("nombre")
							+ " Password: " + resultSet.getString("password") + " Teléfono: "
							+ resultSet.getString("telefono"));
				}
			} catch (SQLException e) {
				System.err.println("No se ha podido recorrer el resulset.");
				System.err.println(e.getMessage());
				System.exit(-5);
			}

		}
		System.out.println("-----*----*---*--------");
		System.out.println("Se ha procesado los datos del servidor SGBD.");
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("No se ha podido cerrar la conexión.");
			System.err.println(e.getMessage());
			System.exit(-6);
		}

		System.out.println("Cerrando la conexión con el servidor SGBD.");
	}

}
