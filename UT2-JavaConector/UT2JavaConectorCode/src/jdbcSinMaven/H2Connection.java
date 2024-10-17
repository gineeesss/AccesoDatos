package jdbcSinMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

	public static void main(String[] args) {
		
	}
		private H2Connection() {}

		public static Connection newInstance(String url, String username, String password) {
			Connection connection = null;
			try {
				connection=DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				}
			return connection;
		}
		
}
