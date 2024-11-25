package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;
import jdbc.util.ConexionBaseDatos;
import jdbc.repositorio.*;
import jdbc.repositorio.ProductoRepositorioImpl;

public class EjemploJdbcListar {

	public static void main(String[] args) {

	
		
		try (
				Connection conn = ConexionBaseDatos.getConnection();
				//Statement stmt = conn.createStatement();
				//ResultSet resultado=stmt.executeQuery("SELECT * FROM productos")
				)
		{
			System.out.println("Apertura conexion");
			Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
			//repositorio.listar().forEach(p -> System.out.println(p));
			
			System.out.println("--------------------------LISTADO DE DATOS-------------------");
			
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("-------------------------FIN LISTADO---------------------");
			
			System.out.println("HOLAAA");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
	}

}
