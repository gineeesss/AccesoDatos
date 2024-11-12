package ejercicosRepasoTema1;

import java.io.FileReader;

import javax.swing.JOptionPane;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Contar el numero de vocales , constantes,
		// y números quehay en un fichero, pasado por teclado(la ruta)
		// 1- pedimos la ruta por teclado
		String ruta = JOptionPane.showInputDialog(null, "Iserta ruta", "Inserción", JOptionPane.INFORMATION_MESSAGE);
		// variables para contar
		int contarVocales = 0;
		int contarConsonantes = 0;
		int contarNumeros = 0;
		try (FileReader fr = new FileReader(ruta)) {
			int caracter;
			// necesitamos localizar las vocales MAYUSCULAS en la tabla ascii(su código
			// decimal)
			int vocales[] = { 65, 69, 73, 79, 85 };
			boolean esVocal;
			// leemos el fichero hasta el final
			while ((caracter = fr.read()) != -1) {
				// ahora tengo que preguntar por contarVocales,contarConsonantes,contarNumeros

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		// IMPRIMIMOS LOS RESULTADOS
		System.out.println("Hay " + contarVocales + " vocales");
		System.out.println("Hay " + contarConsonantes + " Consonantes");
		System.out.println("Hay " + contarNumeros + " Números");

	}

}
