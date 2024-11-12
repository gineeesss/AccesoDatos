package ilern;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrearFicherosDirectorio {

	public static void main(String[] args) throws IOException {
		//Paquete file de java.io
//		//Al crear el fichero file se le passa por parametro un String donde se le indica el nombre
//		//y extension del fichero. Tambien se puede indicar ruta y nombre
//		
//		//Fichero con nombre y extension
//		File fichero = new File("ejemplo1.txt");
//		fichero.createNewFile();
//		
//		//Fichero con ruta, nombre y extensi�n
		//File archivo = new File("src/main/resources/crearFicheros/fichero.txt");
		//Debe estar la carpeta crearFicheros en nuestro proyecto creada
		
		System.out.println("Iniciando el programa ...");
		File directorio= new File("ficherosilerna");
		if (!directorio.mkdir()) {
			if (!directorio.mkdir()) {
				System.err.println("No hemos podido crear el directorio.");
				System.exit(-1);
				
			}
			
		}
		
		
		
		File archivo = new File("ficherosilerna/fichero.txt");
		if(archivo.createNewFile()) {
			System.out.println("Creado el fichero "+ archivo);
		}else {
			System.out.println("No se ha creado el fichero");
		}
		
//		
//		//Cuando queramos crear un directorio solo necesitaremos llamar a este metodo
		//archivo = new File("src/main/resources/crearFicheros/directorio");
		archivo = new File("ficherosilerna/directorio");
		if(archivo.mkdir()) {
			System.out.println("Creado el directorio "+ archivo);
		}
		
	

		
		
//		//Como vemos el metodo es distinto y el nombre del fichero no tiene extension
//		
//		
//		//Crear un fichero con paquete java.nio.file.Files
//		
		//Path ruta = Paths.get("src/main/resources/crearFicheros/file.txt");
		
		Path ruta = Paths.get("ficherosilerna/file.txt");
		Path ejemploArchivo;
		try {
			ejemploArchivo = Files.createFile(ruta);
			System.out.println("Hemos creado un fichero "+ ejemploArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		//Crear un directorio con paquete java.nio.file.Files
//		
		//String nombre = "src/main/resources/crearFicheros/carpetaEjemplo";
		String nombre = "ficherosilerna/carpetaEjemplo";
		Path nombreRuta = Paths.get(nombre); 
		Files.createDirectories(nombreRuta);
		
		System.out.println("Hemos creado una carpeta "+ nombre);

	}

	}


