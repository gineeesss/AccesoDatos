package relacionejercicios.ejercico1sol4;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Alumno> alumnos=Arrays.asList(
				new Alumno("Mónica García", Arrays.asList(new Asignatura("Matemáticas",6),
						new Asignatura("Lengua",7),
						new Asignatura("Inglés",4),
						new Asignatura("Informática",6))),
				new Alumno("Rafa Nadal", Arrays.asList(new Asignatura("Matemáticas",4),
						new Asignatura("Lengua",5),
						new Asignatura("Inglés",8),
						new Asignatura("Informática",9))),
				new Alumno("Novack Djokovic", Arrays.asList(new Asignatura("Matemáticas",8),
						new Asignatura("Lengua",5),
						new Asignatura("Inglés",6),
						new Asignatura("Informática",7)))
								
				);
		// Solución A
        System.out.println("Solucion A");
        alumnos.forEach(alumno->{
        	System.out.println("Alumno :"+alumno.getNombre());
        	alumno.getAsignaturas().forEach(
        			asignatura->System.out.println("Nota de "+asignatura.getNombre()+" : "+asignatura.getNota()));
        	System.out.println("   ----media : "+media(alumno.getAsignaturas()));
        }
        		
        		
        		);
        
        
        

	}
	private static double media(List<Asignatura> asignaturas) {
		double suma=0;
		for (Asignatura asignatura : asignaturas) {
			suma+=asignatura.getNota();
		}
		return  suma/asignaturas.size();
	}

}
