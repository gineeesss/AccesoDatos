package javaio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando el programa ...");
		File directorio = new File("fichero");
		if (!directorio.exists()) {
			System.err.println("No hemos podido crear el directorio");
			//System.exit(-1);
		}
		File fichero = new File(directorio,"fichero.txt");
		try {
			fichero.createNewFile();
			System.out.println("Sa creao el fichero");
		} catch (IOException  e) {
			System.err.println("No se ha podido crear el fichero");
			//System.exit(-3);
		}
		File renombre = new File(directorio,"ficheroCopia.txt");
		fichero.renameTo(renombre);


		//Vamos a usar una nueva clase FileUtils:::COPIA UN FICHERO EN OTRO
		try {
			FileUtils.copyFile(renombre, fichero);
		} catch (IOException e) {
			System.out.println("No se ha podido hacer lo que sea");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Vamos a usar una nueva clase FileUtils:::MOVER UN FICHERO A OTRA CARPETA
		
		try {
			FileUtils.moveFile(fichero, new File("fichero3.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

