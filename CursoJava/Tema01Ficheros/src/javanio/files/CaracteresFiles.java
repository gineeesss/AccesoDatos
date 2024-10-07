package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaracteresFiles {

	public static void main(String[] args) {

		Path path = Path.of("fichero/nio/ficheros_caracteres.txt");
		
		escribir(path);
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
