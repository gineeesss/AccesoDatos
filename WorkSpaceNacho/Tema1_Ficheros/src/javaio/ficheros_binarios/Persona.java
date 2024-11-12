package javaio.ficheros_binarios;

import java.io.Serializable;

public class Persona implements Serializable{
	// OBJETO PERSONA ES UN EJEMPL DE POJO
	//VAMOS A HACER ESTE OBJETO SUCEPTIBLE DE SER SERIALIZADO
	
	private int id;
	private String nombre;
	private int edad;
	private String direccion;
		
	public Persona(int id, String nombre, int edad, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
	}

	public Persona() {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + "]";
	}
	
	

}
