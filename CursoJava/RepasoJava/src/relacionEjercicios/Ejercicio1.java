package relacionEjercicios;

public class Ejercicio1 {
	public static void main (String[] args) {
		String nombre = "Monica García";
		String[] asignaturas = {"Matemáticas","Lengua","Inglés","Informática"};
		int[] notas = {6,7,4,6};
		System.out.print("Alumno: "+nombre);
		System.out.printf("\n"+asignaturas[0]+": "+notas[0]);
		System.out.printf("\n"+asignaturas[1]+": "+notas[1]);
		System.out.printf("\n"+asignaturas[2]+": "+notas[2]);
		System.out.printf("\n"+asignaturas[3]+": "+notas[3]);
		System.out.printf("\n"+"Nota media: %.2f",(notas[0]+notas[1]+notas[2]+notas[3])/4.0);
	}
	private static double media2(int... valores) {
		double suma=0;
		for (int valor: valores){
			suma+=valor;
		}
		return suma/valores.length;
	}
	 	
}