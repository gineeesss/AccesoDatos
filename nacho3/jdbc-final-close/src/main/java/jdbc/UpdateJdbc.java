package jdbc;

import java.util.Date;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.repositorio.Repositorio;

public class UpdateJdbc {

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
		producto.setId(2L);// ESTO SERÍA UN UPDATE
		producto.setNombre("Teclado2 USB");
		producto.setPrecio(64);
		producto.setFechaRegistro(new Date());// ASÍ SERRÍA UN INSERT
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		producto.setCategoria(categoria);
		repositorio.guardar(producto);
		System.out.println("----NUEVO PRODUCTO ACTUALIZADO EN LA BASE DE DATOS----");
		// Producto NUEVO
		System.out.println("---------------LISTADO DE DATOS-------");
		repositorio.listar().forEach(System.out::println);
		System.out.println("-------------FIN--LISTADO DE DATOS-------");
		System.out.println("----INSERTANDO NUEVO PRODUCTO EN LA BASE DE DATOS----");
		Producto producto2 = new Producto();
		// producto.setId(2L);// ESTO SERÍA UN UPDATE
		producto2.setNombre("RATÓN USB");
		producto2.setPrecio(4);
		producto2.setFechaRegistro(new Date());// ASÍ SERRÍA UN INSERT
		Categoria categoria2 = new Categoria();
		categoria2.setId(2L);
		producto2.setCategoria(categoria2);
		repositorio.guardar(producto2);
		System.out.println("----NUEVO PRODUCTO INSERTADO EN LA BASE DE DATOS----");
		System.out.println("---------------LISTADO DE DATOS-------");
		repositorio.listar().forEach(System.out::println);
		System.out.println("-------------FIN--LISTADO DE DATOS-------");
		// PARA FINALIZAR CERRAMOS
		// aqui cerraremos la conexion (se cierra con eL autoclose del try)

	}

}
