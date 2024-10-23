package miProyectoMaven.prueba.entities;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private int id;
	private String nombre;
	private String password;
	private String telefono;
	private List<Direccion> direcciones;
	public Persona(int id, String nombre, String password, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.telefono = telefono;
	}
	public Persona(String nombre, String password, String telefono) {
		this.nombre = nombre;
		this.password = password;
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		if(direcciones==null) {
			this.direcciones=new ArrayList<>();
		}
		this.direcciones = direcciones;
	}
	
	
}
