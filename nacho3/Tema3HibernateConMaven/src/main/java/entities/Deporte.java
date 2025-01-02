package entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deportes")
public class Deporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private boolean aireLibre;
	private Set<Persona> personas;

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	public Deporte(String nombre, boolean aireLibre) {
		this.nombre = nombre;
		this.aireLibre = aireLibre;
	}

	public Deporte(int id, String nombre, boolean aireLibre) {
		this.id = id;
		this.nombre = nombre;
		this.aireLibre = aireLibre;
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

	public boolean isAireLibre() {
		return aireLibre;
	}

	public void setAireLibre(boolean aireLibre) {
		this.aireLibre = aireLibre;
	}

	public Deporte() {
	}

}
