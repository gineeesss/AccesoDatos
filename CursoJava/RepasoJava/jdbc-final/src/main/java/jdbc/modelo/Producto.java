package jdbc.modelo;

import java.util.Date;

public class Producto {
	private Long id;
	private String nombre;
	private Integer precio;
	private Date facheRegistro;
	public Producto(Long id, String nombre, Integer precio, Date facheRegistro) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.facheRegistro = facheRegistro;
	}
	
	public Producto(String nombre, Integer precio, Date facheRegistro) {
		this.nombre = nombre;
		this.precio = precio;
		this.facheRegistro = facheRegistro;
	}

	public Producto() {
	}
	

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", facheRegistro=" + facheRegistro
				+ "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Date getFacheRegistro() {
		return facheRegistro;
	}
	public void setFacheRegistro(Date facheRegistro) {
		this.facheRegistro = facheRegistro;
	}
	
}
