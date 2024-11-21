package entities;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")

public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int edad;
	@ManyToOne(/*cascade=CascadeType.ALL*/)
	private Empresa empresa;

	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	public Persona() {}
	
	public Persona(int id, String nombre, int edad, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Persona(String nombre, int edad, Empresa empresa, Date fechaNacimiento) {
		this.nombre = nombre;
		this.edad = edad;
		this.empresa = empresa;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(int id, String nombre, int edad, Empresa empresa, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.empresa = empresa;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String nombre, int edad, Date fechaNacimiento) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Persona(String nombre, int edad, Date fechaNacimiento, Empresa empresa) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public static Date newDate(int dia, int mes, int anio) {
		Calendar calendar = new Calendar.Builder().build();
		calendar.set(mes, anio);
		return calendar.getTime();
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento+"empresaId="+ empresa+ "]";
	}
}
