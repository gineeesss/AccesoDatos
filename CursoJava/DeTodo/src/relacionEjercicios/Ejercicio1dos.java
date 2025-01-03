package relacionEjercicios;

import java.util.Arrays;
import java.util.List;

public class Ejercicio1dos {
	public static void main(String[] args) {
		String nombre = "Mónica García";
		Ejercicio1Asignatura[] asignaturas = {
				new Ejercicio1Asignatura("Matemátiacas",6),
				new Ejercicio1Asignatura("Lenguaje",7),
				new Ejercicio1Asignatura("Inglés",4),
				new Ejercicio1Asignatura("Informática",6)			
		};
		System.out.println("Alumno: "+ nombre);
		double suma = 0;
		for(Ejercicio1Asignatura a: asignaturas){
			System.out.println(a.getNombre()+": "+a.getNota());
			suma+=a.getNota();
		}
		System.out.println("Nota media: "+suma/asignaturas.length);
		
		
		System.out.println("\n \n \n \n ");
		
		
		
		List<Ejercicio1Asignatura> lista = Arrays.asList(
				new Ejercicio1Asignatura("Matemátiacas",6),
				new Ejercicio1Asignatura("Lenguaje",7),
				new Ejercicio1Asignatura("Inglés",4),
				new Ejercicio1Asignatura("Informática",6)
				);
		lista.forEach(a-> System.out.println(a.getNombre()+": "+a.getNota()));
		System.out.println("Nota media: "+media(lista));

		System.out.println("\n \n \n \n ");
		System.out.println("Filtrando por nombre o yo que se");
		lista.stream()
		.filter(a->a.getNombre()
	    .startsWith("M"))
		.forEach(System.out::println);
		System.out.println("Nota media: "+media(lista));
		
	}
	
	private static double media(List<Ejercicio1Asignatura> lista){
		double suma =0.0;
		for(Ejercicio1Asignatura a: lista) {
			suma+=a.getNota();
		}
		return suma/lista.size();
	}
}
