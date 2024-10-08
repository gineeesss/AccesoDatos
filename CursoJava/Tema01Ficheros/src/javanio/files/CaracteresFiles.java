package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CaracteresFiles {

	public static void main(String[] args) {

		Path path = Path.of("fichero/nio/ficheros_caracteres.txt");
		
		escribir(path);
		leer(path);
	}

	private static void leer(Path path) {
		try {
			List <String> textos = Files.readAllLines(path);
			for(String texto:textos) {
				System.out.println(texto);
			}
		} catch (IOException e) {
			System.err.println("Error: no se que pasa tronco");
			System.err.println(e.getMessage());
			System.exit(-2);		
		}
	}

	private static void escribir(Path path) {
		try {
			Files.writeString(path, "Bonjour Monde 1",StandardOpenOption.APPEND);
			Files.writeString(path, "\nBonjour Monde 2",StandardOpenOption.APPEND);
			Files.writeString(path, "Bonjour Monde 3",StandardOpenOption.APPEND);
			Files.writeString(path, "Bonjour Monde 4",StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("Error: al escribir en el fichero");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("Escribido bien");
	}

}
