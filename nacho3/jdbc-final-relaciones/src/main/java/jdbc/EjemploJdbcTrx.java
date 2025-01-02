package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;
import jdbc.util.ConexionBaseDatos;

public class EjemploJdbcTrx {

	public static void main(String[] args) {

		try (Connection conn = ConexionBaseDatos.getInstance();)
		// ABRIR LA TRANSACCION

		// Statement stmt = conn.createStatement();
		// try (Connection conn = ConexionBaseDatos.getInstance();)

		// ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");)
		{
			System.out.println("Apertura conexión");
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

			// CERRAR LA TRANSACCION
			// PARA FINALIZAR CERRAMOS
			// aqui cerraremos la conexion (se cierra con eL autoclose del try)

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Cerrando conexión.");
			// a través del TRY

		}

	}

}
