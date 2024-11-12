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
		
		Path path=Path.of("ficheros/fichero_binario");
		escribir(path);
		leer(path);
		
	}

	private static void leer(Path path) {
		byte[] bytesFichero= new byte[] {};
		
		try {
			bytesFichero=Files.readAllBytes(path);//LEEMOS TODOS LOS BYTES DEL FICHERO
		} catch (IOException e) {
			System.err.println("Error al leer los bytes del fichero "+path.toString()+ " .");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		
		ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(bytesFichero);
		//guardamos los datos en la Ram en forma de array
		ObjectInputStream objectInputStream=null;
		
		try {
			objectInputStream=new ObjectInputStream(byteArrayInputStream);
		} catch (IOException e) {
			System.err.println("Error al crear el ObjectInputStream.");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		
		try {
			Curso curso= (Curso) objectInputStream.readObject();
			System.out.println("El objeto leído es: ");
			System.out.println(curso.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Error al crear la Clase Curso.");
			System.err.println(e.getMessage());
			System.exit(-6);
		} catch (IOException e) {
			System.err.println("Error de Entrada Salida.");
			System.err.println(e.getMessage());
			System.exit(-7);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	private static void escribir(Path path) {
		Curso curso= new Curso(003,"Procesos y Servicios",17);//lo vamos a escribir en la RAM 
		//como un array de bytes 
		ByteArrayOutputStream  byteArrayOutputStream=new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream=null;
		
		try {
			objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
		} catch (IOException e) {
			 System.err.println("Error al crear el object outputStream");
	         System.err.println(e.getMessage());
	         System.exit(-1);
		}
		
		try {
			objectOutputStream.writeObject(curso);
		} catch (IOException e) {
			System.err.println("Error al escribir el la RAM el object outputStream como array de bytes");
	        System.err.println(e.getMessage());
	        System.exit(-2);
		}
		//ya esta el objeto en la RAM como array de bytes, queremos pasarlo al fichero
		
		try {
			Files.write(path, byteArrayOutputStream.toByteArray());
		} catch (IOException e) {
			System.err.println("Error al escribir el objeto desde la RAM al fichero como array de bytes");
	        System.err.println(e.getMessage());
	        System.exit(-3);
		}
		System.out.println("Hemos escrito el objeto Curso en el ficero"+path.toString()+" ***"+path.getFileName());
	}

}
