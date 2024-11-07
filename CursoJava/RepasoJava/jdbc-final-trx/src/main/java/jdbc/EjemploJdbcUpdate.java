package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;
import jdbc.util.ConexionBaseDatos;
import jdbc.repositorio.*;
import jdbc.repositorio.ProductoRepositorioImpl;

public class EjemploJdbcUpdate {

	public static void main(String[] args) {

	
		
		
			System.out.println("Apertura conexion");
			Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
			//repositorio.listar().forEach(p -> System.out.println(p));
			
			System.out.println("--------------------------LISTADO DE DATOS-------------------");
			
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("-------------------------FIN LISTADO---------------------");
			
			Producto producto = new Producto();
			producto.setId(4L);
			producto.setNombre("Nyao");
			producto.setPrecio(22);
			producto.setFechaRegistro(new Date());
			System.out.println(producto.toString());;
			Categoria categoria = new Categoria();
			categoria.setId(3L);			
			producto.setCategoria(categoria);
			
			repositorio.guardar(producto);
			
			System.out.println("--------------------------LISTADO DE DATOS-------------------");
			repositorio.listar().forEach(System.out::println);

			System.out.println("-------------------------FIN LISTADO---------------------");

	}

}
