package javaio.ficheros_binarios;

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
	//CREAMOS UN FICHERO DEONDE GUARDAR EL OBJETO CREADO
		File file=new File("ficheros/objeto");
		guardarObjeto(file);
		recuperarObjecto(file);
		System.out.println("Fin del programa que escribe un objeto en el fichero, después lo lee y lo imprime.");

	}

	
	
	private static void recuperarObjecto(File file) {
		FileInputStream fileInputStream=null;
		//debemos leer desde el fiuchero
		try {
			fileInputStream= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error al abrir el FileInputStream");
			System.err.println(e.getMessage());
			System.exit(-6);
			
		}
		//necesitamos un ObjectInputStream para conectar el flujo
		ObjectInputStream objectInputStream=null;
		
		try {
			objectInputStream= new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			System.err.println("Error al crear el objectInputStream");
			System.err.println(e.getMessage());
			System.exit(-7);

		}
		//leeremos del fichero los datos de la persona
		try {
			Persona persona=(Persona)objectInputStream.readObject();
			System.out.println(persona.toString());
			
		} catch (ClassNotFoundException e) {
			System.err.println("Error al recuperar el objeto del fichero");
			System.err.println(e.getMessage());
			System.exit(-8);
		} catch (IOException e) {
			System.err.println("Error al recuperar el objeto del fichero");
			System.err.println(e.getMessage());
			System.exit(-9);
			
		}
		//CERRAMOS LOS FLUJOS ABIERTOS
		try {
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			System.err.println("Error aL CERRAR los flujos del fichero");
			System.err.println(e.getMessage());
			System.exit(-9);
		}
		
		
		
	}



	private static void guardarObjeto(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("No se ha podido crear el fichero: "+file.getName());
			System.err.println(e.getMessage());
			//e.printStackTrace();
			System.exit(-1);
		}
        //CREAR EL OBJETO QUE DESEAMOS GUARDAR
		Scanner scanner=new Scanner(System.in);
		System.out.println("Por favor dame el ID de la persona: ");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Por favor dame el nombre de la persona: ");
		String nombre=scanner.nextLine();
		System.out.println("Por favor dame la edad de la persona: ");
		int edad=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Por favor dame la dirección de la persona: ");
		String direccion=scanner.nextLine();
	
		System.out.println("Vamos a crear el archivo y leer el objeto del archivo ...");
		Persona persona=new Persona(id,nombre,edad,direccion);
		//CREAMOS EL FILEOUTPUTSTREAM
		//para guardar el objeto desde la RAM a un fichero
		//Flujo de datos de salida
		FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("no se ha encontrado el fichero: "+
		file.getName());
			System.err.println(e.getMessage());
			System.exit(-2);
			//e.printStackTrace();
		}		
		//CONVERTIR EL OBJETO EN BYTES
		//NECESITAMOS OBJECTOUTPUTSTREAM
		ObjectOutputStream objectOutputStream=null;
		try {
			objectOutputStream=new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido crear el ObjectOutputStream");
			System.err.println(e.getMessage());
			System.exit(-3);
			//e.printStackTrace();
		}
		//ESCRIBIMOS EL OBJETO EN el ObjectOutputStream
		try {
			objectOutputStream.writeObject(persona);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el fichero: " + file.getName());
			System.err.println(e.getMessage());
			System.exit(-4);
		
		}
		//CERRAMOS los flujos abiertos correctamente
		try {
			objectOutputStream.close();
			fileOutputStream.close();
			scanner.close();
			
			
		} catch (IOException e) {
			 System.err.println("No se ha podido cerrar correctamente el flujo");
			 System.err.println(e.getMessage());
			 System.exit(-4);
		}
	}
	
	

}
