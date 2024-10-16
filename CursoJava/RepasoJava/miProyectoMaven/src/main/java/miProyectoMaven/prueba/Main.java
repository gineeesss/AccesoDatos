package miProyectoMaven.prueba;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC de Maven");
		String urlMysql="jdbc:mysql:/localhost/oposiciones";
		String username = "root";
		String password = "";
		System.out.println("Conectando a Servidor...");
		Connection connection = MySqlConnection.newInstance(urlMysql,username,password);
	}
}
