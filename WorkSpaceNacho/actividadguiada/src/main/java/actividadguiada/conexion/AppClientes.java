package actividadguiada.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;

public class AppClientes {
	private static Connection conn = DBConnection.getConnection();
	private static List<Cliente> clientes = new ArrayList();
	private static Scanner scr =new Scanner(System.in);
	
	public static void main(String[] args) {
        
       
            menu();
      
    }
    public static void menu() {

	    
    	do{

    		System.out.println("[1] : Insertar tres filas en la tabla de clientes utilizando una clase llamada AppClientes a través de una función main");
        	System.out.println("[2] : Actualizar el campo a tipo=”A”  cuya zona sea “BA");
    	    System.out.println("[3] : Eliminar el cliente cuya zona sea CABA");
    	    System.out.println("[4] : Listar por consola todos los clientes");
    	    System.out.println("[5] : Crear Cliente");
    	    String eleccion = scr.nextLine();
    	    switch(eleccion) {
	    	    case "1":
	    	    	insertar3Clientes();
	    	    	break;
	    	    case "2":
	    	    	actualiarTipo();
	    	    	break;
	    	    case "3":
	    	    	eliminarClienteCABA();
	    	    	break;
	    	    case "4":
	    	    	listarClientes();
	    	    	break;
	    	    case "5":
	    	    	break;
	    	    default:
    	    		System.out.println("MAL");
    		}
    		
    	}while(true);
    	
    	
    }
    private static void listarClientes() {
        String sql = "SELECT idCliente, dni, nombre, tfn, dir, tipocliente, zona FROM Cliente";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            clientes.clear();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTfn(rs.getString("tfn"));
                cliente.setDir(rs.getString("dir"));
                cliente.setTipocliente(rs.getString("tipocliente"));
                cliente.setZona(rs.getString("zona"));

                clientes.add(cliente);
                conn.commit();
            }

            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados.");
            } else {
                System.out.println("Listado de clientes:");
                clientes.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
    }

	private static void eliminarClienteCABA( ) {
		String sql = "DELETE FROM Cliente WHERE zona = 'CABA'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " cliente(s) eliminado(s).");
            conn.commit();
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
        
	}
	private static void actualiarTipo( ) {
	   String sql = "UPDATE Cliente SET tipocliente = 'A' WHERE zona = 'BA'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int rowsAffected = ps.executeUpdate();
            conn.commit();
            System.out.println(rowsAffected + " cliente(s) actualizado(s).");
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
		
	}
	private static void insertar3Clientes( ) {
		String sql = "INSERT INTO Cliente (dni, nombre, tfn,  dir, tipocliente, zona) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
        	ps.setString(1, "123a");
        	ps.setString(2, "Cliente1");
        	ps.setString(3, "333");
        	ps.setString(4, "calle 3");
            ps.setString(5, "B");
            ps.setString(6, "BA");
            ps.executeUpdate();

           	ps.setString(1, "456b");
        	ps.setString(2, "Cliente2");
        	ps.setString(3, "555");
        	ps.setString(4, "calle 6");
            ps.setString(5, "A");
            ps.setString(6, "CABA");
            ps.executeUpdate();

           	ps.setString(1, "789c");
        	ps.setString(2, "Cliente3");
        	ps.setString(3, "612");
        	ps.setString(4, "calle 13");
            ps.setString(5, "C");
            ps.setString(6, "CA");
            ps.executeUpdate();
            conn.commit();
            System.out.println("Se insertaron 3 clientes correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar clientes: " + e.getMessage());
        }			
	}
	private void crearCliente( ) {
		 String sql = "INSERT INTO Cliente (nombre, tipocliente, zona) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("Ingresa el nombre del cliente: ");
            String nombre  = scr.nextLine();

            System.out.print("Ingresa el tipo del cliente: ");
            String tipo  = scr.nextLine();

            System.out.print("Ingresa la zona del cliente: ");
            String zona  = scr.nextLine();

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setString(3, zona);
            ps.executeUpdate();
            conn.commit();
            System.out.println("Cliente creado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear cliente: " + e.getMessage());
        }
	}
}
