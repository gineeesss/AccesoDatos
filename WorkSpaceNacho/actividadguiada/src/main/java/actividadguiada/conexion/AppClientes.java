package actividadguiada.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Cliente;

public class AppClientes {
	
	private void crearCliente() {
		String slq="";
		try (PreparedStatement ps = con.prepareStatement(slq);){
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
