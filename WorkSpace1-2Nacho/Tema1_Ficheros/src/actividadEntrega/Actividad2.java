package actividadEntrega;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import actividadEntrega.Modelo.Coche;

public class Actividad2 {
	private final File configTxt = new File("C:\\clase\\config.txt");
	private final File configDat = new File("C:\\clase\\config.dat");
	private final File configCoches = new File("C:\\clase\\coches.dat");

	public static void main(String[] args) {

		Actividad2 act2 = new Actividad2();
		act2.ej1();
		// act2.ej2();
		// act2.ej3();

	}

	private void ej1() {
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(configTxt));

			String linea;
			String nameConfig = "fichlog";
			String result = "";
			while ((linea = bfr.readLine()) != null) {
				if (linea.matches(String.format("^%s:.+", nameConfig))) {
					result = linea.substring(linea.indexOf(':') + 1);
				}
			}
			bfr.close();
			System.out.println(result);
			readLog(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ej2() {
		String[] configName = { "puerto", "nomapp", "fichlog", "numses" };
		String[] datos = { "8081", "ventas", "c:\\clase\\ventas.log", "200" };

		String result = null;

		try {
			if (!configDat.exists()) {
				DataOutputStream dto = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(configDat)));
				for (int i = 0; i < configName.length; i++) {
					dto.writeUTF(configName[i]);
					dto.writeUTF(datos[i]);
				}
				dto.close();
			}

			DataInputStream dti = new DataInputStream(new BufferedInputStream(new FileInputStream(configDat)));
			while (dti.available() > 0) {
				if (dti.readUTF().equals("fichlog")) {
					result = dti.readUTF();
				}
			}
			if (result != null)
				readLog(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readLog(String result) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader(configTxt));
		BufferedWriter bfw = null;

		String linea;
		File log = new File(result);

		// Comprobacion del fichero incidencias
		File error = new File(log.getParentFile(), "incidencias.log");
		bfw = new BufferedWriter(new FileWriter(error));

		bfr = new BufferedReader(new FileReader(log));
		while ((linea = bfr.readLine()) != null) {
			if (linea.toLowerCase().matches(".+error.+")) {
				System.out.println(linea);
				bfw.write(linea.substring(linea.toLowerCase().indexOf("error")));
				bfw.newLine();
			}
		}

		bfr.close();
		bfw.close();
	}

	public void ej3() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(configCoches))) {
			oos.writeObject(new Coche("AA", "AA"));
			oos.writeObject(new Coche("AB", "AB"));
			oos.writeObject(new Coche("BB", "BB"));
			oos.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(configCoches))) {
			List<Coche> lista = new ArrayList<>();
			Coche coche;
			while ((coche = (Coche) ois.readObject()) != null) {
				lista.add(coche);
			}
			for (Coche car : lista) {
				System.out.println(car);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
