package javaio.ficherosAleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.spi.FileSystemProvider;

public class Main {

	public static void main(String[] args) {
		File file = new File("fichero/aleatorio.txt");
		
		//NECESITAMOS EL RamcomAccessFile
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("Error: No se ha podido crear el RandomAccessFile"+ file.getName());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		escribir(randomAccessFile,"Hola TRONCOS!!! QUE TAAAAALLLL??¿"); 
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		seek(randomAccessFile,0); 
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		leer(randomAccessFile);
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		seek(randomAccessFile,0); 
		escribir(randomAccessFile,"****"); 
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		seek(randomAccessFile,0); 
		leer(randomAccessFile);
		pointer(randomAccessFile);//imprimere ande esta elpuntero
		cerrar(randomAccessFile);
	}

	private static void cerrar(RandomAccessFile randomAccessFile) {
		try {
			randomAccessFile.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar el fichero");
			System.err.println(e.getMessage());
			System.exit(-99);
		}
		
	}

	private static void leer(RandomAccessFile randomAccessFile) {
		String leido;
		try {
			while((leido=randomAccessFile.readLine())!=null) {
				System.out.println(leido);
			}
		} catch (IOException e) {
			System.err.println("Error: No se ha podido leer el fichero");
			System.out.println(e.getMessage());
			System.exit(-5);
		}
	}

	private static void seek(RandomAccessFile randomAccessFile, int posicion) {
		try {
			randomAccessFile.seek(posicion);
		} catch (IOException e) {
		System.out.println("Error: No se ha podiddo posicinar en el ficheor");
		System.err.println(e.getMessage());
		System.exit(-4);
		}
	}

	private static void escribir(RandomAccessFile randomAccessFile, String texto) {
		System.out.println("Vamos a escribir en el fichero de acceso aleatorio lo siguiente: "+texto);
		try {
			randomAccessFile.writeBytes(texto);
		} catch (IOException e) {
			System.err.println("Error: no se ha podido escribir en el fichero");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		
	}

	private static void pointer(RandomAccessFile randomAccessFile) {
		try {
			System.out.println("Posicion del puntero: "+randomAccessFile.getFilePointer());
		} catch (IOException e) {
			System.err.println("Error: No se ha podido comprobar la ubicacion del puntero");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
	}

	

}
