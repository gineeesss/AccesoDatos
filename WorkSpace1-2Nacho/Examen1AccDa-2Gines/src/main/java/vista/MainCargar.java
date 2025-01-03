package vista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Concesionario;
public class MainCargar {
	private static Connection getConnection() throws SQLException {
		return Conexion.getInstance();
	}
	public static void main(String[] args) throws FileNotFoundException {
		FileReader filePath = new FileReader("concesionario.dat");
        String linea;
        String[] propiedades;
		String sql = "Insert INTO concesionario (id, nombreConcesionario, dir, telefono, poblacion) VALUES (?,?,?,?,?)";
        
        Concesionario concesionario = new Concesionario();
        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             BufferedReader br = new BufferedReader(filePath)) {
        	
        	while((linea = br.readLine())!=null) {
        	
	        	propiedades=linea.split("#");
	        	ps.setInt(1, Integer.parseInt(propiedades[0].trim()));
	        	ps.setString(2, propiedades[1].trim());
	        	ps.setString(3, propiedades[2].trim());
	        	ps.setString(4, propiedades[3].trim());
	        	ps.setString(5, propiedades[4].trim());
	            ps.executeUpdate();
	        	
        	}
	               
       } catch (Exception e) {
           System.err.println("Error: al conectar con la base de datos: ");
           System.err.println(e.getMessage());
       }
	}
}

