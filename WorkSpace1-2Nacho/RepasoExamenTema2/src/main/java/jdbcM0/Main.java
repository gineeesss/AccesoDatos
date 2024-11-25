package jdbcM0;

import java.util.Scanner;

public class Main {

	private static Scanner scr = new Scanner(System.in);
	private static UsuarioRepository usuarioRepository = new UsuarioRepository();
	public static void main(String[] args) {

		selecionarOpcion();
		
	}

	private static void selecionarOpcion() {
		int opcion;
		do {
			mostrarMenu();
			opcion = getNumero();
			
			switch (opcion) {
			case 1:
				Usuario usuario = new Usuario(getNumero(),getPalabra(),getPalabra(),getPalabra());
				usuarioRepository.actualiazr(usuario);
				break;
			case 2:
				usuarioRepository.eliminar(scr.nextInt());
				break;
			case 3:
				Usuario usuario2 = new Usuario(getPalabra(),getPalabra(),getPalabra());
				usuarioRepository.agregar(usuario2);
				break;
			case 4:
				usuarioRepository.listar().forEach(System.out::println);;
				break;
			default:
				break;
			}
			
		}while(opcion!=0);
		
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

	private static void mostrarMenu() {
		System.out.println("[1] Actualizar");
		System.out.println("[2] Eliminar");
		System.out.println("[3] Agregar");
		System.out.println("[4] Listar");
		System.out.println("[0] Salir");
	}
	
}
