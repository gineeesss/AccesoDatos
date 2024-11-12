package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CaracteresFiles {

	public static void main(String[] args) {
		
		Path path=Path.of("ficheros/nio/ficheros_caracteres.txt");
		escribir(path);
		leer(path);
		
		
		
		
		
		

	}

	private static void leer(Path path) {
		
		try {
			List<String> textos= Files.readAllLines(path);
			for(String texto:textos) {
				System.out.println(texto);
				
			}
		} catch (IOException e) {
			System.err.println("Error al leer del fichero : "+path.toString());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("hemos leído en el fichero de caracteres correctacmente");
		
	}

	private static void escribir(Path path) {
		
		try {
			Files.writeString(path, "hola Mundo con Files \n");
			Files.writeString(path, "hola Mundo con Files 2 \n",StandardOpenOption.APPEND);
			//se le indica que escriba preservando las lineas anteriores
			Files.writeString(path, "hola Mundo con Files 3 \n",StandardOpenOption.APPEND);
			Files.writeString(path, "hola Mundo con Files 4 \n",StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero : "+path.toString());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("hemos escrito en el fichero de caracteres correctacmente");
		
		
	}

}
