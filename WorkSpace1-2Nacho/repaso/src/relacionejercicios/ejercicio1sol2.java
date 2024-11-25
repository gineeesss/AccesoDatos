package relacionejercicios;

import java.util.Arrays;
import java.util.List;

public class ejercicio1sol2 {

	public static void main(String[] args) {
		String nombre="Monica García";
		Asignatura[] asignaturas = {
				new Asignatura("Matematícas",6),
				new Asignatura("Lenguaje",7),
				new Asignatura("Inglés",4),
				new Asignatura("Informática",6)
				};
		List<Asignatura> asignaturas2 = Arrays.asList(
				new Asignatura("Matematícas",6),
				new Asignatura("Lenguaje",7),
				new Asignatura("Inglés",4),
				new Asignatura("Informática",6)
				); 
		List<Asignatura> asignaturas3 = Arrays.asList(
				asignaturas
				); 
		
		System.out.println("Alumno : "+ nombre);
		// Solución A
		System.out.println("Solución A un for clásico: ");
		for(int i=0;i<asignaturas.length;i++) {
			System.out.println("Nota de  " +asignaturas[i].getNombre()+ " : "+asignaturas[i].getNota());
		}
		//System.out.println("Nota media : "+media(asignaturas));
		 // Solución B
			/*
			 * System.out.println("Solución B un foreach de Java: "); for(Asignatura
			 * asignatura: asignaturas) { System.out.println("Nota de  "
			 * +asignatura.getNombre()+" : "+asignatura.getNota()); }
			 * System.out.println("Nota media : "+media(asignaturas));
			 */
		 // Solución C
		System.out.println("Solución C un foreach lambda ");
		asignaturas2.forEach(a->System.out.println("Nota de "+a.getNombre()+" : "+a.getNota()));
		System.out.println("Nota media : "+media(asignaturas2));
		// Solución D
		 System.out.println("Solucion D");
		 asignaturas2.forEach(System.out::println);
		 System.out.println("Nota media : "+media(asignaturas2));
		// Solución E Filtrar asignaturas que empiecen por M
		 System.out.println("Solucion E Filtrar asignaturas que empiecen por M");
		 asignaturas2.stream()
		 .filter(a->a.getNombre().startsWith("M"))
		 .forEach(System.out::println);
		 System.out.println("Nota media : "+media(asignaturas2));
		 
		 
		
	}

	private static double media(List<Asignatura> asignaturas) {
		double suma=0;
		for (Asignatura asignatura: asignaturas) {
			suma+=asignatura.getNota();
		}
		return suma/asignaturas.size();
	}

}
