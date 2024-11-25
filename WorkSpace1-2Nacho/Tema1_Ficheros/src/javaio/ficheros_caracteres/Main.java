package javaio.ficheros_caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

	File file= new File("ficheros/caracteres.txt");
	
	escribir(file);
	leer(file);
	
	
	
	}

	private static void leer(File file) {
		//1- Debemos usar un FileReader
		FileReader fileReader=null;
		
		try {
			fileReader=new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido crear el FileReader");
            System.err.println(e.getMessage());
            System.exit(-4);
		}
		int read;
		try {
			while((read=fileReader.read())!=-1) {
				System.out.print((char)read);
				
			}
			System.out.println();
		} catch (IOException e) {
			System.err.println("Error al leer desde el FileReader");
            System.err.println(e.getMessage());
            System.exit(-5);
		}
		//1- Debemos CERRAR EL FileReader
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.println("Error al CERRAR el FileReader");
            System.err.println(e.getMessage());
            System.exit(-6);
		}
	}

	private static void escribir(File file) {
		//1- Debemos usar un FileWriter
		
		
		FileWriter fileWriter=null;
		
		try {
			fileWriter=new FileWriter(file,true);
		} catch (IOException e) {
			System.err.println("Error: Error al crear el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		try {//2- Escribimos el texto deseado
			fileWriter.write("Vamos a escribir primer prueba!!! \n"
					+ " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur finibus tortor vel efficitur vestibulum. Nulla a bibendum metus, sed volutpat massa. Nunc posuere augue vel enim dapibus pharetra. Pellentesque laoreet urna ac tincidunt venenatis. Duis quis nisi id nisl vestibulum scelerisque sit amet id nulla. Fusce laoreet, nisl nec pellentesque sagittis, augue eros pretium felis, ut placerat diam erat sed risus. Donec fringilla nulla quis porttitor lacinia. Vestibulum ut arcu at est finibus scelerisque. Sed quis ante turpis. Nulla eleifend placerat pulvinar.\r\n"
					+ "\r\n"
					+ "Fusce sagittis rhoncus consequat. Vestibulum ipsum turpis, venenatis rutrum orci ac, consequat vulputate ex. Vivamus et sapien justo. Pellentesque accumsan hendrerit quam ac malesuada. Nunc et lorem ut purus rhoncus mattis. Nulla nec dui mauris. Praesent non metus vitae ligula hendrerit consectetur.\r\n"
					+ "\r\n"
					+ "Duis vel augue non nibh ullamcorper facilisis vitae a libero. Maecenas sed feugiat libero, at dictum lorem. Nullam convallis turpis laoreet enim elementum, vel ullamcorper risus mollis. Nulla facilisi. Nulla semper tortor dui. Aenean fringilla dui eu enim auctor euismod. Integer porttitor convallis varius. Sed accumsan mauris tincidunt, eleifend neque in, consectetur elit. Morbi quis mauris fermentum, suscipit turpis vel, mollis metus. Aliquam tincidunt mauris id pulvinar pharetra. Curabitur lectus nulla, pharetra eu sagittis vel, tincidunt ut augue. Ut sed diam vestibulum, dictum enim in, euismod metus. Maecenas in ligula scelerisque, semper elit sed, egestas sem. Donec non interdum est. Etiam libero magna, ultricies in pharetra a, egestas in mi.\r\n"
					+ "\r\n"
					+ "Quisque interdum imperdiet mollis. Aliquam hendrerit lacus eget libero tincidunt euismod. Nulla quis mi diam. Cras pharetra gravida metus, sit amet lobortis ante interdum quis. Donec ut est tellus. Sed luctus enim convallis, lobortis ipsum nec, pellentesque felis. Aliquam varius ex ut scelerisque posuere. Maecenas faucibus tincidunt tellus sit amet dapibus.\r\n"
					+ "\r\n"
					+ "Nulla varius tincidunt gravida. Nulla vel tristique ligula, vitae commodo felis. Morbi vel erat ligula. Integer vitae quam sit amet augue lobortis consectetur ut eget leo. Quisque pharetra lectus metus, quis commodo nibh malesuada non. Maecenas eleifend turpis arcu, vitae tempor nisl pulvinar ut. Sed ullamcorper molestie nisi non iaculis. ");
		} catch (IOException e) {
			System.err.println("Error: Error al escribir con el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		//3- Muy importante : Cerrar el flujo del fichero abierto.
		
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Error: Error al cerrar el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
	}

}
