package javaio.ficherosCaracteres;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File file = new File("fichero/caracteres.txt");
		
		escribir(file);
		leer(file);
	}

	private static void leer(File file) {
		//1- DEBEMOS USAR UN FileWriter
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha podido crear el FileReader");
			System.err.println(e.getMessage());
			System.exit(-4);
		} 
		int read;
		try {
			while((read=fileReader.read())!=-1) {
				System.out.print((char)read);
			}
		} catch (IOException e) {
			System.err.println("Error: No se ha podiddo leer desde el FileReader");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		//1- DEBEMOS CERRAR EL FILEREADER
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.println("Error: error al cerrar el fileReader");
			System.err.println(e.getMessage());
			System.exit(-6);
		}
	}

	private static void escribir(File file) {
		//1- DEBEMOS USAR UN FileWriter
		//2- ESCRIBIMOS EL TEXTO DESEADO
		//3- IMPORTANTE: CERRAR EL FLUJO DEL FICHERO ABIERO
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(file,true);
		} catch (IOException e) {
			System.err.println("Error: error con FileWriter");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		try {
			fileWriter.write("Vamos a escribir primera prueba \n");
		} catch (IOException e) {
			System.err.println("Error: Error al escribir con el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Error: Error al cerrar el fichero");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
	}

}
