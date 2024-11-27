package vista;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

import conexion.Conexion;
import modelo.Coche;
import repository.CocheRepository;



public class Main {
	public static Scanner scr = new Scanner(System.in);
	private static CocheRepository cocheRepository = new CocheRepository();
	
	public static void main(String[] args) {
		operaciones();	
	}

	private static void operaciones() {
		int opcion;
		do {
			mostrarMenu();
			opcion =getNumero();
			switch(opcion){
			case 1:
				System.out.println("Inserta a continuación: Matricula + Marca + Modelo + Color");
				Coche coche = new Coche(getPalabra(), getPalabra(), getPalabra(), getPalabra());
				cocheRepository.insertar(coche);
				break;
			case 2:
				System.out.println("Inserta a continuación: Matricula + Marca + Modelo ");
				cocheRepository.actualizar(getPalabra(), getPalabra(), getPalabra());
				break;
			case 3:
				System.out.println("Insertar Matrícula: ");
				cocheRepository.eliminar(getPalabra());
				break;
			}
			
		}while(opcion!=0);
		
	}
	private static void mostrarMenu() {
		System.out.println("[1] Insertar Coche");
		System.out.println("[2] Actualizar Coche");
		System.out.println("[3] Eliminar Coche");
		//System.out.println("[4] Listar");
		System.out.println("[0] Salir");
	}
	
	private static int getNumero() {
		int numero = scr.nextInt();
		scr.nextLine();
		return numero;
	}
	private static String getPalabra() {
		String cadena = scr.nextLine();
		//scr.nextLine();
		return cadena;
	}
}
