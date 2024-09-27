package javaio;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando el programa ...");
		File directorio = new File("fichero");
		if (!directorio.mkdir()) {
			System.err.println("No hemos podido crear el directorio");
			//System.exit(-1);
		}
		File fichero = new File(directorio,"fichero.txt");
		try {
			fichero.createNewFile();
			System.out.println("Sa creao el fichero");
		} catch (IOException e) {
			System.err.println("No se ha podido crear el fichero");
			//System.exit(-3);
		}
		File renombre = new File(directorio,"ficheroCopia.txt");
		fichero.renameTo(renombre);
	}
	
}

