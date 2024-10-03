package javanio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;;

public class Main {

	public static void main(String[] args) {
		//Path path = Path.of("fichero","aleatorio.txt");
		Path path = Path.of("fichero/nio/aleatorio.txt");
		System.out.println(path.normalize().toString());
		System.out.println(path.toAbsolutePath());
		//CREAMOS ESA RUTA EN EL SISTEMA DE ARCHIVOS, CREAMOS EL DIRECTORIO
		path.toFile().getParentFile().mkdir();
		//CREAMOS EN ESA RUTA EN EL SISTEMA DE ARCHIVOS, CREAMOS EL ARCHIVO
		File file = path.toFile();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear el ficheor en el path");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}

}
