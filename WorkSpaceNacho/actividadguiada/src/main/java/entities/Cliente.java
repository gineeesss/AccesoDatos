package entities;

public class Cliente {
	private int idCliente;
	private String dni;
	private String nombre;
	private String tfn;
	private String dir;
	private String tipocliente;
	private String zona;
	public Cliente(String dni, String nombre, String tfn, String dir, String tipocliente, String zona) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.tfn = tfn;
		this.dir = dir;
		this.tipocliente = tipocliente;
		this.zona = zona;
	}
	public Cliente() {
		super();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTfn() {
		return tfn;
	}
	public void setTfn(String tfn) {
		this.tfn = tfn;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getTipocliente() {
		return tipocliente;
	}
	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", tfn=" + tfn + ", dir="
				+ dir + ", tipocliente=" + tipocliente + ", zona=" + zona + "]";
	}
	
}
