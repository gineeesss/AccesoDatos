package actividadEntrega;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private final static File configText = new File("C:\\clase\\config.txt");

	public static void main(String[] args) {
		ejercio1();

	}

	private static void ejercio1() {
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(configText));
			String linea;
			String nameConfig = "fichlog";
			String result = "";
			while ((linea = bfr.readLine()) != null) {
				if (linea.matches(String.format("^%s:.+", nameConfig))) {
					result = linea.substring(linea.indexOf(":") + 1);
					// ya tenemos la ruta del fichero de log a leer

				}
			}
			bfr.close();
			System.out.println(result);
			readLog(result);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readLog(String result) throws IOException {
		// ahora procesamos el fichero de log buscando errores en el log
		BufferedReader bfr = new BufferedReader(new FileReader(result));
		BufferedWriter bfw = null;

		String linea;
		File log = new File(result);

		// Comprobacion del fichero incidencias
		File error = new File(log.getParentFile(), "incidencias.log");
		bfw = new BufferedWriter(new FileWriter(error));
		String errorb = "error";
		bfr = new BufferedReader(new FileReader(log));
		while ((linea = bfr.readLine()) != null) {
			if (linea.matches(String.format("^%s:.+", errorb))) {
				System.out.println(linea);
				bfw.write(linea.substring(linea.toLowerCase().indexOf("error")));
				bfw.newLine();
			}
		}

		bfr.close();
		bfw.close();
	}

}
