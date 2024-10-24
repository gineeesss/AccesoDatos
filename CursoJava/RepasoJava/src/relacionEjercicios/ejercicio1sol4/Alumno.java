package relacionEjercicios.ejercicio1sol4;

import java.util.ArrayList;
import java.util.List;

import relacionEjercicios.Ejercicio1Asignatura;

public class Alumno {
	private String nombre;
	private  List<Ejercicio1Asignatura> asignaturas;

	public Alumno() {
	}

	public Alumno(String nombre, Ejercicio1Asignatura... asignaturas) {
		this.nombre = nombre;
		this.asignaturas = new ArrayList<>();
		for (int i = 0; i < asignaturas.length; i++) {
			this.asignaturas.add(asignaturas[i]);
		}
	}

	public Alumno(String nombre, List<Ejercicio1Asignatura> asignaturas) {
		this.nombre = nombre;
		this.asignaturas = asignaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Ejercicio1Asignatura> getAsignaturas() {
		return asignaturas;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", asignaturas=" + asignaturas + "]";
	}

	public static double media(List<Ejercicio1Asignatura> asignaturas) {
		double media=0;
		for(Ejercicio1Asignatura a: asignaturas) {
			media+=a.getNota();
		}
		return media/asignaturas.size();
	}
//crear metodo nota media y llamarlo desde el main para calcilarala y pos sacarla
}
