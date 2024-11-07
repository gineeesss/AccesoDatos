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

public class DeleteJdbc {

	public static void main(String[] args) {

	
		
		
			System.out.println("Apertura conexion");
			Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
			//repositorio.listar().forEach(p -> System.out.println(p));
			
			System.out.println("--------------------------LISTADO DE DATOS-------------------");
			
			//repositorio.listar().forEach(System.out::println);
			
			System.out.println("-------------------------FIN LISTADO---------------------");
			
			System.out.println(repositorio.porId(2L));
			
			System.out.println("-------------------------EDITAR UN PRODUCTO---------------------");
			
			//PEDIMOS EL ID
			Producto producto = new Producto();
			producto.setId(2L);
			producto.setNombre("Teclado sensitivo");
			producto.setPrecio(789);
			
			
			//repositorio.guardar(producto);

			System.out.println(repositorio.porId(2L));
			
			System.out.println("-------------------------FIN LISTADO---------------------");
			/*while (resultado.next()) {
				System.out.print(resultado.getInt("id"));
				System.out.print("|");
				System.out.print(resultado.getString("nombre"));
				System.out.print("|");
				System.out.print(resultado.getInt("precio"));
				System.out.print("|");
				System.out.print(resultado.getDate("fecha_registro"));
			}*/
		
		
		
	}

}
