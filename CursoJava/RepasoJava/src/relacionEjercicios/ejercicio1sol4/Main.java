package relacionEjercicios.ejercicio1sol4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Alumno> alumnos = Arrays.asList(
				new Alumno("Mónica García", Arrays.asList(new Ejercicio1Asignatura("Matemáticas",6),new Ejercicio1Asignatura("Religión",7),new Ejercicio1Asignatura("Inglés",4),new Ejercicio1Asignatura("Informática",6))),
				new Alumno("Mohamed IV", Arrays.asList(new Ejercicio1Asignatura("Matemáticas",6),new Ejercicio1Asignatura("Religión",7),new Ejercicio1Asignatura("Inglés",4),new Ejercicio1Asignatura("Informática",6))),
				new Alumno("Gloria Fuertes", Arrays.asList(new Ejercicio1Asignatura("Matemáticas",6),new Ejercicio1Asignatura("Religión",7),new Ejercicio1Asignatura("Inglés",4),new Ejercicio1Asignatura("Informática",6))),
				new Alumno("Sorolla", Arrays.asList(new Ejercicio1Asignatura("Matemáticas",6),new Ejercicio1Asignatura("Religión",7),new Ejercicio1Asignatura("Inglés",4),new Ejercicio1Asignatura("Informática",6)))
				);
	System.out.println("Solución A");
	alumnos.forEach(alumno->{
		System.out.println("Alumno :"+alumno.getNombre());
		alumno.getAsignaturas().forEach(
				asignatura->System.out.println(asignatura.getNombre()+": "+asignatura.getNota()));
	});
	
	}
}