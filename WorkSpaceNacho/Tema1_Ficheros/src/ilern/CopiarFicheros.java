package ilern;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiarFicheros {

	public static void main(String args[]) throws IOException {

		// Ejemplo de copiado de archivos con java.io

		// Primero se crean los ficheros
		File archivoOrigen = new File("ficherosilerna/origen.txt");
		archivoOrigen.createNewFile();
		File archivoDestino = new File("ficherosilerna/destino.txt");
		archivoDestino.createNewFile();

		try {
			// Se lee el origen
			InputStream origen = new BufferedInputStream(new FileInputStream(archivoOrigen));
			// Fichero destino
			OutputStream destino = new BufferedOutputStream(new FileOutputStream(archivoDestino));

			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = origen.read(buffer)) > 0) {
				// se escriben los datos de un fichero a otro
				destino.write(buffer, 0, lengthRead);
				// Se cierra el proceso
				destino.flush();
			}

			// Ejemplo de copiado de datos con la api java.nio
			Path orig = Paths.get("ficherosilerna/ejemploCopia.txt");
			Path ejemploOrigen = Files.createFile(orig);

			Path dest = Paths.get("ficherosilerna/destino");
			Path ejemploDestino = Files.createFile(dest);

			Files.copy(orig, dest, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("se ha realizado la copia de ficheros");
		} catch (Exception e) {
			e.getCause();
		}
	}
}




