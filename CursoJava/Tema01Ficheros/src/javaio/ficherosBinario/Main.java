package javaio.ficherosBinario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//creamos un fichero donde guardar el objeto creado
		File file = new File("fichero/objeto");
		guardarObjeto(file);
		recuperarObjeto(file);
	}
	
	private static void recuperarObjeto(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el FileInputStream");
			System.out.println(e.getMessage());
			System.exit(-6);
		}
		//NECESITAMOS UN OBJETOINPUTSTREAM PARA CONECTAR EL FLUJO
		ObjectInputStream objectInputStream=null;
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			System.out.println("Error al crear ObjectInputStream");
			System.out.println(e.getMessage());
			System.exit(-7);
		}
		//LEEREMOS DEL FICHERO LOS DATOS DE LA PERSONA
		try {
			Persona persona = (Persona) objectInputStream.readObject();
			System.out.println(persona);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al recuperar el objeto del fichero");
			System.out.println(e.getMessage());
			System.exit(-8);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al recuperar el objeto del ficher");
			System.out.println(e.getMessage());
			System.exit(-9);
		}
		//CERRAMOS LOS FLUJOS ABIERTOS (mangueras)
		try {
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar los flujos");
			System.out.println(e.getMessage());
			System.exit(-10);
		}
		
	}

	private static void guardarObjeto(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("No se ha podido crear el fichero: "+file.getName());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		//CREAR EL OBJETO QUE DESEAMOS
		Scanner scr = new Scanner(System.in);
		System.out.println("Introducir id: ");
		int id = scr.nextInt();
		System.out.println("Introducir nombre: ");
		String nombre  = scr.next();
		System.out.println("Introducir edad: ");
		int edad = scr.nextInt();
		System.out.println("Introducir direccion: ");
		String direccion = scr.next();
		Persona persona = new Persona(id,nombre,edad,direccion);
		
		//CREAMOS EL FINLEOUTPUTSTREAM
		//PARA GUARDAR EL OBJETO DESDE LA RAM A UN FICHERO
		//FLJO DE DATOS DE SALIDA
		
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha encontrado el fichero: "+ file.getName());
			System.exit(-2);
		}
		//CONVERTIT EL OBJETO EN BYTES
		//NECESITAMOS OBJETOUTPUTSTREAM
		ObjectOutputStream objetOutputStream = null;
		try {
			objetOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			System.out.println("No se ha podido crear el fichero: "+ file.getName());
			System.out.println(e.getMessage());
			System.exit(-3);
		}
		
		//ESCRIBIMOS EL OBJETO EN EL ObjectOutputStream
		try {
			objetOutputStream.writeObject(persona);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podidio escribir en el fichero: "+ file.getName());
			System.exit(-4);
		}
		//CERRAMOS LOS FLUJOS ABIERTOS
		try {
			objetOutputStream.close();
			fileOutputStream.close();
			scr.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar lo que sea");
			System.err.println(e.getMessage());
			System.out.println(-5);
		}
		
	}
}
