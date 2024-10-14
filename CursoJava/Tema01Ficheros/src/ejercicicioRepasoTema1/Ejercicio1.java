package ejercicicioRepasoTema1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) {
		//1. Escribir en un fichero "Hola mundo"
		//Leer el anterior fichero, mostrando su contenido por pantalla
		
		File folder = new File("ficherosEjerRepaso");
        if (!folder.exists()) {
            folder.mkdirs(); // Crea la carpeta (o las carpetas si no existen)
        }
        
		try (FileWriter fw= new FileWriter("ficherosEjerRepaso/ejercicio1Repaso.txt",true)){
			fw.write("Hola holita vecinito");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	
}
