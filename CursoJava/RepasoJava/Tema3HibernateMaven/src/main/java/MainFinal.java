import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Empresa;
import entities.Persona;
import repository.EmpresaRepository;
import repository.PersonaRepository;

public class MainFinal {

	private static Scanner scr;
	private static PersonaRepository personaRepository;
	private static EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		System.out.println("Iniciadno configraucion hibernate");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		final Session session = factory.openSession();
		
		empresaRepository= new EmpresaRepository(session);
		personaRepository= new PersonaRepository(session);
		
		scr= new Scanner(System.in);//.useDelimiter("\\n");
		mostrarMenu();
	}

	private static void mostrarMenu() {

		int seleccion;
		do{
			System.out.println("\nSeleccione alguna opción: ");
			System.out.println("1. Crear una empresa");
			System.out.println("1. Crear una persona ");
			System.out.println("3. Asignar Empresa -> Persona");
			System.out.println("4. Mostrar todas las empresas");
			System.out.println("5. Mostrar todas las peronas");
			seleccion = getNumero();
			switch(seleccion) {
			
			case 0:
				System.out.println("Gracias, adiós.");
				break;
			case 1:
				crearEmpresa();
				break;
			case 2:
				crearPersona();
				break;
			case 3:
				asignarEmpresaPersona();
				break;
			case 4:
				mostrarEmpresas();
				break;
			case 5:
				mostrarPersonas();
				break;
			default:
				System.out.println("No ha seleccionado una opción correcta");
			}
			
			
			
		}while(seleccion!=0);
	}

	private static void asignarEmpresaPersona() {
		System.out.println("Selecciona a la empresa(ID) que quiere asignar a la persona (ID)");		
		mostrarPersonas();
		int empresaId=getNumero();
		System.out.println("Selecciona a la persona(ID) que quiere contratar");
		mostrarEmpresas();
		int personaId=getNumero();
		Persona personaDb = personaRepository.findOneById(personaId);
		Empresa empresaDb = empresaRepository.findOneById(empresaId);
		personaDb.setEmpresa(empresaDb);
	}

	private static void mostrarPersonas() {
		personaRepository.findAll().forEach(System.out::print);
		
	}

	private static void mostrarEmpresas() {
		empresaRepository.findAll().forEach(System.out::print);
	}

	private static void crearPersona() {
		System.out.println("[Nombre] :");
		String nombre=getPalabra();
		System.out.println("Edad: ");
		int edad=getNumero();
		System.out.println("Día: ");
		int dia = getNumero();
		System.out.println("Mes: ");
		int mes = getNumero();
		System.out.println("Year: ");
		int year = getNumero();
		Persona persona= new Persona(nombre, edad, Persona.newDate(dia,mes,year));
		personaRepository.save(persona);
		System.out.println("Empresa creada: "+ persona);
	}

	private static void crearEmpresa() {
		System.out.println("[Nombre] :");
		//String nombre=scr.next();
		String nombre=getPalabra();
		System.out.println("[Direccion]: ");
		//String direccion=scr.next();
		String direccion=getPalabra();
		Empresa empresa = new Empresa (nombre, direccion);
		empresaRepository.save(empresa);
		//System.out.println("Empresa creada: "+ empresa);
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
