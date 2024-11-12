package javaio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando el programa ...");
		File directorio= new File("ficheros3");
		if (!directorio.mkdir()) {
			if (!directorio.exists()) {
				System.err.println("No hemos podido crear el directorio.");
				System.exit(-1);
				
			}
			
		}
		File fichero= new File(directorio,"fichero.txt");
		
		try {
			fichero.createNewFile();
			System.out.println("Fichero creado correctamente.");
		} catch (IOException e) {
			System.err.println("no se ha podido crear el fichero correctamente.");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
		File renombre= new File(directorio,"fichero_de_copia.txt");
		fichero.renameTo(renombre);
		//Vamos a usar una nueva clase FileUtils:::COPIA UN FICHERO EN OTRO
		try {
			FileUtils.copyFile(renombre, fichero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("no se ha podido copiar el fichero,"+renombre.getName()+" al fichero"+fichero.getName()+"  correctamente.");

			e.printStackTrace();
		}
		//Vamos a usar una nueva clase FileUtils:::MOVER UN FICHERO A OTRA CARPETA
		/*
		 * try { FileUtils.moveFile(fichero, new File("fichero3.txt")); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * System.err.println("no se ha podido mover el fichero,"+fichero.getName());
		 * e.printStackTrace(); }
		 */
		if(fichero.delete()) {
			System.out.println("El fichero ha sido borrado");
			
		}
		else {
			System.out.println("el fichero no se ha podido borrar");
		}
		
		System.out.println("Finalizando el programa.");
		
	}

}
