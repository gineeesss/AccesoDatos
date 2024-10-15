package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Conector conector = new Conector();
		Connection conn = null;
		Statement stmnt=null;
		try {
			conn = conector.conector();
			System.out.println("Conectado a la base de datos");
			String sql="SELECT * FROM examenes";
			stmnt=conn.createStatement();
			ResultSet rs =stmnt.executeQuery(sql);
			while(rs.next()) {
				int cod=rs.getInt(1); // SE PEUDE DECIR LA POSCION DE LA COLUMNA O EL NOMBRE --> int cod=rs.getInt(CODIGOEXA);
				String desc=rs.getString(2);
				System.out.print("Codigo examen: "+cod + "\t");
				System.out.println("Descripción examen: "+desc);
			}
			rs.close();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			try {
				stmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
