package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	private static Connection connect = null;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String BB_URL = "jdbc:mysql://localhost:3306/oposiciones";
	static final String USUARIO = "root";
	static final String CONTRA = "";
	
	public Connection conector() throws Exception{
		try {
			Class.forName(JDBC_DRIVER);
			connect = DriverManager.getConnection(BB_URL, USUARIO, CONTRA);
		}catch(Exception e) {
			throw e;
		}
		return connect;
	}
}
