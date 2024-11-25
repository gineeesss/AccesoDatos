package jdbc;

import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;

public class DeleteJdbc {

	public static void main(String[] args) {

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
		System.out.println("-------------EDITAR UN PRODUCTO-------");
		Producto producto = new Producto();
		/*
		 * // producto.setId(2L); ESTO SERÍA UN UPDATE
		 * producto.setNombre("Teclado2 sensitivo"); producto.setPrecio(899);
		 * producto.setFechaRegistro(new Date());// ASÍ SERRÍA UN INSERT
		 * 
		 * repositorio.guardar(producto);
		 */
		// Producto NUEVO
		System.out.println("---------------LISTADO DE DATOS-------");
		repositorio.listar().forEach(System.out::println);
		System.out.println("-------------FIN--LISTADO DE DATOS-------");

		System.out.println("---------------BORRADO DE DATOS-------");
		repositorio.eliminar(4L);
		System.out.println("---------------LISTADO DE DATOS-------");
		repositorio.listar().forEach(System.out::println);
		System.out.println("-------------FIN--LISTADO DE DATOS-------");

		// PARA FINALIZAR CERRAMOS
		// aqui cerraremos la conexion (se cierra con eL autoclose del try)

	}

}
