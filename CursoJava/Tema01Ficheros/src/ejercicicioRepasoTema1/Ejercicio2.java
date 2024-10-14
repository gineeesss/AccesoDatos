package ejercicicioRepasoTema1;

import java.io.FileReader;
import javax.swing.JOptionPane;


public class Ejercicio2 {
	public static void main(String[] args) {
		//Contar el numero de vocales, constantes, y numeros que hay en un fichero, pasado por teclaod (ruta)
		//1. Pedimos la ruta por teclado

		String ruta=JOptionPane.showInputDialog(null,"Inserta ruta","Inserción",JOptionPane.INFORMATION_MESSAGE);
		int contarVocales = 0;
		int contarConstantes=0;
		int contarNumeros=0;
		try(FileReader fr = new FileReader(ruta)){
			int caracter;
			int vocales[]= {65,69,73,79,85};
			boolean esVocal;
			while((caracter=fr.read())!=-1) {
				
			}
			
			
			
			
			
			
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		
		}
	}
}
