package javanio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		
		//Path path = Path.of("ficheros","aleatorio.txt");
		Path path = Path.of("ficheros/nio/aleatorio2.txt");
		System.out.println(path.normalize().toString());
		System.out.println(path.toAbsolutePath());
		//creamos esa ruta en el sistema de archivos, creamos el directorio
		path.toFile().getParentFile().mkdir();
		//creamos en esa ruta en el sistema de archivos, creamos el archivo
		File file=path.toFile();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear el fichero en el path: "+path.toString());
		}
		
	}

}
