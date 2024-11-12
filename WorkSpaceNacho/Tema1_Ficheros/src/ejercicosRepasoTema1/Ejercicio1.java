package ejercicosRepasoTema1;

import java.io.FileWriter;

public class Ejercicio1 {

	public static void main(String[] args) {
		// 1. Escribir en un fichero "Hola mundo".
		// Leer el anterior fichero, mostrando su contenido por pantalla.
		try (FileWriter fw = new FileWriter("C:\\clase\\holamundo.txt", true)) {

			fw.write("Hola Mundo DAM2");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
