package jdbcIlern;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorBBDD {
	private static Connection connect = null;

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String BB_URL = "jdbc:mysql://localhost/oposiciones";// puerto mysql 3306
	static final String USUARIO = "root";
	static final String CONTRA = "";

	public static Connection conector() throws Exception {
		try {
			Class.forName(JDBC_DRIVER);
			try {
				connect = DriverManager.getConnection(BB_URL, USUARIO, CONTRA);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("fin");
		}
		return connect;

	}

}
