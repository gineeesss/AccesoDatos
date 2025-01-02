package entities;

import java.util.Set;

//@Entity
//@Table(name = "empresas")
public class Empresa {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String direccion;
	// @OneToMany(mappedBy = "empresa")
	private Set<Persona> personas;

	public Empresa() {
	}

	public Empresa(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Empresa(int id, String nombre, String direccion, Set<Persona> personas) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.personas = personas;
	}

	public Empresa(String nombre, String direccion, Set<Persona> personas) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.personas = personas;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		// return "Empresa [id=" + id + ", nombre=" + nombre + ", direccion=" +
		// direccion + ", personas=" + personas + "]";
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa : id: ").append(id).append(" nombre : ").append(nombre).append(" dirección : ")
				.append(direccion).append(" personas : \n");
		if (personas != null) {
			personas.forEach(p -> builder.append("\t").append(p.getNombre()));
		}
		return builder.toString();

	}

}
