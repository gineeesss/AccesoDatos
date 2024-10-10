package ejemplos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CrearFicherosDirectorios {

	public static void main(String[] args) {
	//DEBEMOS CRERA UN FICHERO EN NUESTRO DIRECTORIO DENTRO DE LA CARPETA RESOURCE
	//NOMBRE DEL DIRECTORIO: crearfichero
	//Y CREAMOS UN FICHERO LLAMADO fichero.txt
	//CLASES QUE PODEMOS USAR: File (java.io)
	//DESPUES TAMBIEN CON java.nio
		
		System.out.println("PROGRAMA INICIADO");
		File resource = new File("resource");
		if(!resource.exists()) {
			boolean creado = resource.mkdir();
			if(creado) {
				System.err.println("DIRECTORIO CREADO");
			}else System.err.println("DIRECTORIO NO CREADO");
		}
		File fichero = new File(resource,"fichero.txt");
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear el fichero");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		Path path = Path.of(resource);
	}

}
