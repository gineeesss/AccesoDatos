package vista;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;


public class MainVolcado {
	private static Connection getConnection() throws SQLException {
		return Conexion.getInstance();
	}
	public static void main(String[] args) {
        String filePath = "ficheros\\coche.txt";

        String sql = "SELECT * FROM coche WHERE marca = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             BufferedWriter wr = new BufferedWriter(new FileWriter(new File(filePath)))) {

        	ps.setString(1, "Volvo");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");

                wr.write(matricula + "," + marca + "," + modelo + "," + color);
                wr.newLine(); 
            }

            System.out.println("Volcado completado en:" + filePath);

        } catch (IOException e) {
            System.err.println("Error: al volvafr los datos");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: al conectar con la base de datos: ");
            System.err.println(e.getMessage());
            }
    }
}