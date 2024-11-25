package miProyectoMaven.prueba;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadaDatosDelSGBD {

	public static void main(String[] args) {

		System.out.println("Conexion a jdbc CON de MYSQL.");
		String urlMysql = "jdbc:mysql://localhost/m07";
		// String urlH2 = "jdbc:h2:" + Path.of("m06").toAbsolutePath().toString();
		String username = "root";
		String password = "";
		System.out.println("Conectando al servidor MYSQL ... ");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);

		try {
			DatabaseMetaData misDatosBD = connection.getMetaData();
			System.out.println("Nombre del SGBD :" + misDatosBD.getDatabaseProductName());
			System.out.println("Version del SGBD :" + misDatosBD.getDatabaseProductVersion());
			System.out.println("Nombre del driver del SGBD :" + misDatosBD.getDriverName());
			System.out.println("versión del driver del SGBD :" + misDatosBD.getDriverVersion());
			System.out.println("Nivel de aislamiento :" + misDatosBD.getDefaultTransactionIsolation());
			System.out.println("Usuario actual :" + misDatosBD.getUserName());

			System.out.println("Bases de datos :");
			ResultSet rsa = misDatosBD.getCatalogs();
			/*
			 * while (!rsa.isLast()) { rsa.next();
			 * 
			 * 
			 * }
			 */
			for (int i = 0; rsa.next(); i++) {
				System.out.println((rsa.getString("TABLE_CAT")) + "|");
				System.out.println("---");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
