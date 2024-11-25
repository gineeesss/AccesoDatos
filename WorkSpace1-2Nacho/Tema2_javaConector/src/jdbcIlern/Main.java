package jdbcIlern;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		ConectorBBDD conector = null;
		Connection conn = null;
		Statement stmnt = null;
		try {
			conn = ConectorBBDD.conector();
			// conn = conector.conector();
			System.out.println("Conectado a la base de datos.");
			String sql = "SELECT * FROM examenes order by 1 ";

			stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				int cod = rs.getInt(1);// int cod=rs.getInt("CODIGOEXA");
				String desc = rs.getString(2);// int cod=rs.getInt("DESCRIPCIONEXA");
				System.out.println("Codigo examen :" + cod);
				System.out.println("Descripción del examen :" + desc);
			}
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmnt != null)

					stmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
