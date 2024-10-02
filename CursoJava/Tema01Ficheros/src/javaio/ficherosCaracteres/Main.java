package javaio.ficherosCaracteres;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/caracteres.txt");
		
		escribir(file);
	}

	private static void escribir(File file) {
		//1- DEBEMOS USAR UN FileWriter
		//2- ESCRIBIMOS EL TEXTO DESEADO
		//3- IMPORTANTE: CERRAR EL FLUJO DEL FICHERO ABIERO

	}

}
