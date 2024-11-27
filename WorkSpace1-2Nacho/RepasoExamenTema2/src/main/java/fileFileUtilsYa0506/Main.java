package fileFileUtilsYa0506;

import java.io.File;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import org.apache.commons.io.FileUtils;




public class Main {
	public static void main (String[] args) {
		System.out.println("Iniciando programa...");
		File directorio = new File("ficheros");
		if(!directorio.mkdir()) {
			if(!directorio.exists()) {
				System.err.println("No se ha podido crear el directorio");
				System.exit(-1);
			}
		}
		File fichero = new File(directorio, "fichero.txt");
		try {
			fichero.createNewFile();
			System.out.println("El fichero se ha creado correctamente");
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}

		File renombre = new File(directorio, "fichero_copia.txt");
		fichero.renameTo(renombre);
		try{
			FileUtils.copyFile(renombre, fichero);
		}catch(IOException e) {
			
		}
		try{
			FileUtils.moveFile(fichero, new File("fichero.txt"));
			
		}catch(IOException e) {
			e.getMessage();
		}
	
		
		
	}
}
