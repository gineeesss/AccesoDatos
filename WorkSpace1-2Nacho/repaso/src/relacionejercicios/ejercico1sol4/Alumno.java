package relacionejercicios.ejercico1sol4;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String nombre;
	private List<Asignatura> asignaturas;
	public Alumno() {
			}
	
	public Alumno(String nombre, Asignatura...asignaturas ) {
		this.nombre=nombre;
		this.asignaturas= new ArrayList<>();
			for(int i=0;i<asignaturas.length;i++) {
				this.asignaturas.add(asignaturas[i]);
			}
	}
	public Alumno(String nombre, List<Asignatura> asignaturas)	{
		this.nombre=nombre;
		this.asignaturas=asignaturas;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

		
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", asignaturas=" + asignaturas + "]";
	}
	
	
	

	
}
