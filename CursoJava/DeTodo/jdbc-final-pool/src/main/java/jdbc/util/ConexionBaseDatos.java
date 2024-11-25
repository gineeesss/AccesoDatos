package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionBaseDatos {
	private static String url="jdbc:mysql://localhost:3306/java_curso?serverTimezone=Europe/Madrid";
	private static String username="root";
	private static String password="";
	private static BasicDataSource pool;
	
	public static BasicDataSource getInstance() throws SQLException{
		if(pool==null) {
			pool = new BasicDataSource();
			pool.setUrl(url);
			pool.setUsername(username);
			pool.setPassword(password);
			pool.setInitialSize(3);
			pool.setMinIdle(3);
			pool.setMaxTotal(8);
		}
		return pool;
	}
	
	static Connection conn = null;
	public static Connection getConnection() throws SQLException{
		
		 return getInstance().getConnection();
	
	}
}

