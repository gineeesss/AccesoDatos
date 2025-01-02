package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;
import jdbc.util.ConexionBaseDatos;

public class EjemploJdbcTrx {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = ConexionBaseDatos.getInstance();)
		// Statement stmt = conn.createStatement();
		// try (Connection conn = ConexionBaseDatos.getInstance();)

		// ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");)
		{
			System.out.println("Apertura conexión");

			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);// se inicia LA TRANSACCION
			}

			try {

				// OPERAMOS CON LA BASE DE DATOS

				Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
				// mañana martes 5/11/2024
				/*
				 * System.out.println("---------------LISTADO DE DATOS-------");
				 * repositorio.listar().forEach(p -> System.out.println(p));
				 */
				System.out.println("---------------LISTADO DE DATOS-------");
				repositorio.listar().forEach(System.out::println);
				System.out.println("-------------FIN--LISTADO DE DATOS-------");
				// Pedimos el ID
				System.out.println(repositorio.porId(2L));

				// PARA FINALIZAR CERRAMOS
				// aqui cerraremos la conexion (se cierra con eL autoclose del try)
				Producto producto = new Producto();
				producto.setId(2L);// ESTO SERÍA UN UPDATE
				producto.setNombre("Teclado3 IMB");
				producto.setPrecio(64);
				producto.setFechaRegistro(new Date());// ASÍ SERRÍA UN INSERT
				Categoria categoria = new Categoria();
				categoria.setId(2L);
				producto.setCategoria(categoria);
				producto.setSku("0908abd");// 123abc YA EXISTE
				repositorio.guardar(producto);
				System.out.println("----NUEVO PRODUCTO ACTUALIZADO EN LA BASE DE DATOS----");
				// Producto NUEVO
				System.out.println("---------------LISTADO DE DATOS-------");
				repositorio.listar().forEach(System.out::println);
				System.out.println("-------------FIN--LISTADO DE DATOS-------");
				System.out.println("----INSERTANDO NUEVO PRODUCTO EN LA BASE DE DATOS----");
				Producto producto2 = new Producto();
				// producto.setId(2L);// ESTO SERÍA UN UPDATE
				producto2.setNombre("RATÓN 3");
				producto2.setPrecio(4);
				producto2.setSku("zztedfaa2");
				producto2.setFechaRegistro(new Date());// ASÍ SERRÍA UN INSERT
				Categoria categoria2 = new Categoria();
				categoria2.setId(2L);
				producto2.setCategoria(categoria2);
				repositorio.guardar(producto2);
				System.out.println("----NUEVO PRODUCTO INSERTADO EN LA BASE DE DATOS----");
				System.out.println("---------------LISTADO DE DATOS-------");
				repositorio.listar().forEach(System.out::println);
				System.out.println("-------------FIN--LISTADO DE DATOS-------");
				// si TODO EL BLOQUE DE INSTRUCCIONES SE EJECUTA CON EXITO// se CIERRA LA
				// TRANSACCION
				conn.commit();
				// PARA FINALIZAR CERRAMOS

			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}

		}
	}

}
