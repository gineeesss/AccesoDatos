package miProyectoMaven.prueba;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class MetaDatosDelSGBD {

	public static void main(String[] args) {

		System.out.println("Conexion a jdbc CON de MYSQL");
		String urlMysql = "jdbc:mysql://localhost/m06";
		String username = "root";
		String password = "";
		System.out.println("Conectando al servidor MTSQL...");
		Connection connection = MySqlConnection.newInstance(urlMysql, username, password);
		try {
			DatabaseMetaData misDatosBD=connection.getMetaData();
			System.out.println("Nombre del SGBD: " +misDatosBD.getDatabaseMajorVersion());
			System.out.println("Version del SGBD: "+misDatosBD.getDatabaseProductName());
			System.out.println("Nombre del driver del SGBD: "+misDatosBD.getDriverName());
			System.out.println("Versión del driver del SGBD: "+misDatosBD.getDriverVersion());
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
