package actividadguiada.conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        
        try (Connection conexion = DBConnection.getConnection();){
            System.out.println("Conexión exitosa"); 
            menu();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void menu() {
    	System.out.println("[1] : Insertar tres filas en la tabla de clientes utilizando una clase llamada AppClientes a través de una función main");
    	System.out.println("[2] : Actualizar el campo a tipo=”A”  cuya zona sea “BA");
	    System.out.println("[3] : Eliminar el cliente cuya zona sea CABA");
	    System.out.println("[4] : Listar por consola todos los clientes");
	    
    
    
    }
    
}
