package javanio.files;

import java.io.Serializable;

public class Curso implements Serializable {
	private int id;
	private String nombre;
	private int numAlumn;
	public Curso(int id, String nombre, int numAlumn) {
		this.id = id;
		this.nombre = nombre;
		this.numAlumn = numAlumn;
	}
	public Curso() {
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", numAlumn=" + numAlumn + "]";
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
	public int getNumAlumn() {
		return numAlumn;
	}
	public void setNumAlumn(int numAlumn) {
		this.numAlumn = numAlumn;
	}
	
	
}
