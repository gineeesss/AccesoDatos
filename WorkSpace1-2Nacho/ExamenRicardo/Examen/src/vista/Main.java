package vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Coche;
import modelo.Concesionario;
import repositorio.CocheRepository;

public class Main {
	
	static Scanner scr = new Scanner(System.in);
	static CocheRepository cocherepo = new CocheRepository();

public static void main(String[] args) {
	
	
	int opcion=0;
	
	do {
		opcion = mostrarMenu();
		switch(opcion) {
		case 1:
			insertarCoche();
			break;
		case 2:
			actualizarCoche();
			break;
		case 3:
			eliminarCoche();
			break;
		case 4: 
			guardarFichero();
			break;
		case 5:
			guardarConcesionarios();
		default:
			System.out.println("Elige una opcion valida");
		}
	} while (opcion!=0);
}

private static void guardarConcesionarios() {
	
	cocherepo.cargarDatosDesdeFichero();

}

private static void guardarFichero() {
	
	ArrayList<Coche> volvos = cocherepo.buscarVolvo();
	
	File path = new File("C:"+File.separator+"clases");
	if (path.mkdir())
	{
		System.out.println("Creada la carpeta...");
	}
	File file = new File("C:"+File.separator+"clases"+File.separator+"coche.txt");
	try	(	
			FileWriter fw = new FileWriter(file);
		){
		file.createNewFile();
		
		for(Coche coche : volvos) {
			fw.write(coche.toString()+"\n");
		}
			fw.flush();
		
	} catch (IOException e) {
		System.err.println(e.getMessage());
		
	}

}

private static void eliminarCoche() {
	System.out.println("Introduce la matricula del coche: ");
	String matricula = scr.nextLine();
	
	cocherepo.eliminar(matricula);
	
}

private static void actualizarCoche() {
	System.out.println("Introduce la matricula del coche: ");
	String matricula = scr.nextLine();
	
	System.out.println("Nueva marca: ");
	String marca = scr.nextLine();
	System.out.println("Nuevo modelo: ");
	String modelo = scr.nextLine();
	
	Coche coche = new Coche(marca,modelo);
	
	cocherepo.actualizar(matricula, coche);
}

private static void insertarCoche() {
	System.out.println("Inserta los siguientes datos: ");
	System.out.println("Matricula: ");
	String matricula = scr.nextLine();
	System.out.println("Marca: ");
	String marca = scr.nextLine();
	System.out.println("Modelo: ");
	String modelo = scr.nextLine();
	System.out.println("Color: ");
	String color = scr.nextLine();
	
	Coche coche  = new Coche(matricula,marca,modelo,color);
	cocherepo.insertar(coche);
}

private static int mostrarMenu() {
	System.out.println("Selecciona una opción: ");
	System.out.println("1. Insertar un coche");
	System.out.println("2. Actualizar un coche");
	System.out.println("3. Eliminar un coche");
	System.out.println("4. Guardar volvos en fichero");
	System.out.println("5. Guardar concesionarios en la base de datos");
	return getNumero();
}

private static int getNumero() {
	int numero = scr.nextInt();
	scr.nextLine();
	return numero;
}

}
