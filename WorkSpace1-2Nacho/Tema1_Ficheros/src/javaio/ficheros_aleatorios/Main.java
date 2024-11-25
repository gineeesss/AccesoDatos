package javaio.ficheros_aleatorios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Main {
	public static void main(String[] args) {
		File file=new File("ficheros/aleatorio.txt");
		//necesitamos el RamdomAccessFile
		RandomAccessFile randomAccessFile=null;
		
		try {
			randomAccessFile=new RandomAccessFile(file,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero: " + file.getName());
			System.err.println(e.getMessage());
			 System.exit(-1); 
		}
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		escribir(randomAccessFile,"Hola Mundo en un fichero aleatorio!!");
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		seek(randomAccessFile,0);
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		leer(randomAccessFile);
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		seek(randomAccessFile,7);
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		escribir(randomAccessFile,"******");
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		seek(randomAccessFile,0);
		pointer(randomAccessFile);//mi imprime dónde está el puntero.
		leer(randomAccessFile);
		//para finalizar cerramos el fichero
		cerrar(randomAccessFile);
		
		
	}

	private static void cerrar(RandomAccessFile randomAccessFile) {
		try {
			System.out.println("cerramos el fichero y el programa");
			randomAccessFile.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el fichero");
			System.err.println(e.getMessage());
			System.exit(-6);
		}		
	}

	private static void leer(RandomAccessFile randomAccessFile) {
		String leido;
		
		try {
			while((leido=randomAccessFile.readLine())!= null) {
				System.out.println(leido);
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer del fichero");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		
	}

	private static void seek(RandomAccessFile randomAccessFile, int posicion) {
		System.out.println("nos vamos a posicionar el el registro"+posicion);
		
		try {
			randomAccessFile.seek(posicion);
		} catch (IOException e) {
			System.err.println("No se ha podido posicionarme en el fichero");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
	}

	private static void escribir(RandomAccessFile randomAccessFile, String texto) {
		System.out.println("vamos a escribir en el fichero de acceso aleatorio, lo siguiente: "+texto);
		
		try {
			randomAccessFile.writeBytes(texto);
		} catch (IOException e) {
			 System.err.println("No se ha podido escribir en el fichero");
			 System.err.println(e.getMessage());
			 System.exit(-3);
		}
	}

	private static void pointer(RandomAccessFile randomAccessFile) {
		
		try {
			System.out.println("Posición del puntero: "+randomAccessFile.getFilePointer());
		} catch (IOException e) {
			System.err.println("No se ha podido comprobar la ubicación del puntero.");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
	}

}
