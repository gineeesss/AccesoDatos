package relacionejercicios;

public class ejercicio1 {

	public static void main(String[] args) {
		// 1. Escriba un programa que visualice la nota media de las siguientes asignaturas:
		//Matemáticas, Lengua, Ingles, Informática. La salida tendrá el siguiente formato:
		//Alumno: Mónica García
			//Matemáticas: 6
			//Lengua: 7
			//Inglés: 4
			//Informática: 6
			//Nota media: 5.75
		
		String nombre = "Mónica García";
        int notaMatematicas = 6;
        int notaLengua = 7;
        int notaIngles = 4;
        int notaInformatica = 6;
     // SOLUCIÓN A
     //   System.out.println("Solucion A");
     //   System.out.println("Nota media " + (notaMatematicas + notaLengua + notaIngles + notaInformatica) / 4.0);
     // SOLUCIÓN B
		System.out.println("Solucion B");
        double notaMedia = (notaMatematicas + notaLengua + notaIngles + notaInformatica) / 4.0;
        System.out.println("Nota media " + notaMedia);
     // SOLUCIÓN C llamada a método
        System.out.println("Solucion C");
        System.out.println("Nota media " + media(notaMatematicas,notaLengua, notaIngles, notaInformatica) );   
     // SOLUCIÓN D   llamada a método argumentos
        System.out.println("Solucion D");
        System.out.println("Nota media " + media2(notaMatematicas,notaLengua, notaIngles, notaInformatica) );
        
        
	}

	private static double media2(int... valores) {
		double suma=0;
		for(int valor: valores) {
			suma+=valor;
		}
		return  suma/valores.length;
	}

	private static Double media(int notaMatematicas, int notaLengua, int notaIngles, int notaInformatica) {
		double suma=0;
		suma=(notaMatematicas + notaLengua + notaIngles + notaInformatica);
		
		return suma/4.0;
	}

}
