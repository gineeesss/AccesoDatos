package javanio.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFiles {

	public static void main(String[] args) {
	
		Path path = Path.of("fichero/fichero_binario");
		//escribir(path);
		leer(path);
	}

	
	private static void leer(Path path) {
		byte[] bytesFichero = new byte[] {};
		try {
			bytesFichero = Files.readAllBytes(path); ////LEEMOS TODOS LOS BYTES DEL FICHERO
		} catch (IOException e) {
			System.err.println("Error: al leer los bytes del fichero");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytesFichero);
	
		ObjectInputStream objectInputStream = null;
		
		try {
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
		} catch (IOException e) {
			System.err.println("Error: al crear el ObjectInputStream");
			System.err.println(e.getMessage());
			System.exit(-5);
		} 
		try {
			Curso curso = (Curso) objectInputStream.readObject();
			System.out.println(curso);
		} catch (ClassNotFoundException e) {
			System.err.println("Error al crear el curso o yo que se");
			System.err.println(e.getMessage());
			System.exit(-6);
		} catch (IOException e) {
			System.err.println("Error: entrada salida");
			System.err.println(e.getMessage());
			System.exit(-7);
		}
		
	}


	//CREAR OBJETO EN LA RAM
	private static void escribir(Path path) {
		Curso curso = new Curso(001,"Acceso a Datos",29);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		} catch (IOException e) {
			System.err.println("Error: al crear el object outputStream");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		try {
			objectOutputStream.writeObject(curso);
		} catch (IOException e) {
			System.err.println("Error: al escribir en la RAM el object outputstream como array de bytes");
			System.err.println(e.getMessage());
		System.exit(-2);	
		}
		try {
			Files.write(path, byteArrayOutputStream.toByteArray());
		} catch (IOException e) {
			System.err.println("Error: al escribir el objeto desde la RAM al fichero como un array de bytes");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		System.out.println("Hemos escrito el objeto curso en el ficher: "+path.toString() + " " + path.getFileName());
	}

}
