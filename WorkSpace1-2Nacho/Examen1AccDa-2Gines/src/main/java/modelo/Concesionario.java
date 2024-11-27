package modelo;

public class Concesionario {
	private int id;
	private String nombreConcesionario;
	private String dir;
	private int telefono;
	private String poblacion;
	public Concesionario(int id, String nombreConcesionario, String dir, int telefono, String poblacion) {
		this.id = id;
		this.nombreConcesionario = nombreConcesionario;
		this.dir = dir;
		this.telefono = telefono;
		this.poblacion = poblacion;
	}
	public Concesionario(String nombreConcesionario, String dir, int telefono, String poblacion) {
		this.nombreConcesionario = nombreConcesionario;
		this.dir = dir;
		this.telefono = telefono;
		this.poblacion = poblacion;
	}
	public Concesionario() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreConcesionario() {
		return nombreConcesionario;
	}
	public void setNombreConcesionario(String nombreConcesionario) {
		this.nombreConcesionario = nombreConcesionario;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", nombreConcesionario=" + nombreConcesionario + ", dir=" + dir
				+ ", telefono=" + telefono + ", poblacion=" + poblacion + "]";
	}
	
}
