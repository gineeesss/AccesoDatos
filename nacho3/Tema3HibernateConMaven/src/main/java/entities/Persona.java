package entities;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")

public class Persona {

	// id
	// Constructor vacío
	// Stters y Getter standars

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private int edad;
	// @ManyToOne()
	private Empresa empresa;

	private Set<Deporte> deportes;

	public Set<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(Set<Deporte> deportes) {
		this.deportes = deportes;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	// @Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	public Persona() {
	}

	public Persona(int id, String nombre, int edad, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(int id, String nombre, int edad, Date fechaNacimiento, Empresa empresa) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.empresa = empresa;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String nombre, int edad, Date fechaNacimiento, Empresa empresa) {
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

	public static Date newDate(int dia, int mes, int anio) {
		Calendar calendar = new Calendar.Builder().build();
		calendar.set(anio, (mes - 1), dia);
		return calendar.getTime();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona : id: ").append(id).append(" nombre : ").append(nombre).append(" edad : ").append(edad)
				.append("Fecha nacimiento : ").append(getFechaNacimientoString()).append(" Nombre empresa : \n");
		if (empresa != null) {
			builder.append("\t").append(empresa.getNombre());
		} else {
			builder.append("\t").append("Sin empresa asignada aún.");
		}
		return builder.toString();

	}

	public String getFechaNacimientoString() {
		Calendar calendar = new Calendar.Builder().build();
		calendar.setTime(fechaNacimiento);
		return calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ (calendar.get(Calendar.YEAR) + 1);
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

}
