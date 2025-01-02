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

	private static Scanner teclado;
	private static PersonaRepository personaRepository;
	private static EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		System.out.println("Iniciando la configuración de HIBERNATE al aceso a la BBDD");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		System.out.println("Conectando a la Base de Datos...");
		final Session session = factory.openSession();
		System.out.println("Conectado correctamente a la Base de Datos...");
		// CONEXION ESTABLECIDA, INSTANCIAMOS LOS REPOSITORYS
		personaRepository = new PersonaRepository(session);
		empresaRepository = new EmpresaRepository(session);
		teclado = new Scanner(System.in);
		mostrarMenu();

	}

	private static void mostrarMenu() {

		int seleccion = 10;
		do {
			System.out.println("Sleccione alguna opción deseada : ");
			System.out.println("1. Crear una empresa nueva.");
			System.out.println("2. Crear una persona nueva.");
			System.out.println("3. Asignar una empresa a una persona.");
			System.out.println("4. Mostrar todas las empresas.");
			System.out.println("5. Mostrar todas las personas.");
			System.out.println("0. Salir del menú.");
			// System.out.println("5. Mostrar una persona.");
			// System.out.println("5. Eliminar una persona.");
			// System.out.println("5. Modificar una persona.");
			seleccion = getNumero();
			switch (seleccion) {

			case 0:
				System.out.println("Gracias, adios.");
				break;
			case 1:
				System.out.println("Has selecionado crear una empresa...");
				crearEmpresa();
				break;
			case 2:
				System.out.println("Has selecionado crear una persona...");
				crearPersona();
				break;
			case 3:
				asignarempresaPersona();
				break;
			case 4:
				System.out.println("Has selecionado Mostrar todas las empresas...");
				mostrarEmpresas();// hay que comentar que pasa con las personas...
				break;
			case 5:
				System.out.println("Has selecionado Mostrar todas las personas...");
				mostrarPersonas();
				// hay que comentar que pasa con las empresas...
				break;
			default:
				System.out.println("No ha seleccionado una opción correcta.");
				;

			}

		} while (seleccion != 0);

	}

	private static void asignarempresaPersona() {
		System.out.println("Has selecionado asignar una empresa a una persona...");
		System.out.println("Seleccione a la empresa(ID) que quiere asignar a la persona:");
		mostrarEmpresas();
		System.out.println("Seleccione a la empresa que quiere asignar a la persona (ID):");
		int empresaId = getNumero();
		mostrarPersonas();
		System.out.println("Seleccione a la persona que quiere contratar :");
		int personaId = getNumero();
		Persona personaDb = personaRepository.findOneById(personaId);
		Empresa empresaDb = empresaRepository.findOneById(empresaId);
		personaDb.setEmpresa(empresaDb);
		personaRepository.update(personaDb);
	}

	private static void mostrarPersonas() {
		personaRepository.findAll().forEach(persona -> {
			System.out.println(persona);
		});

		/*
		 * for (Persona persona : personaRepository.findAll()) {
		 * System.out.println(persona); }
		 */

	}

	private static void mostrarEmpresas() {
		empresaRepository.findAll().forEach(empresa -> {
			System.out.println(empresa);
		});

	}

	private static void crearPersona() {
		System.out.println("Introduce el NOMBRE de la persona: ");
		String nombre = teclado.nextLine();

		System.out.println("Introduce la edad de la persona: ");
		int edad = getNumero();

		System.out.println("Introduce el año de nacimiento de la persona: ");
		int year = getNumero();

		System.out.println("Introduce el mes de nacimiento de la persona: ");
		int mes = getNumero();

		System.out.println("Introduce el día de nacimiento de la persona: ");
		int dia = getNumero();

		Persona persona = new Persona(nombre, edad, Persona.newDate(dia, mes, year));

		personaRepository.save(persona);
		System.out.println("persona guardada en la base de datos " + persona);

	}

	private static void crearEmpresa() {
		System.out.println("Introduce el NOMBRE de la empresa: ");
		String nombre = teclado.nextLine();
		System.out.println("Introduce la DIRECCIÓN de la empresa: ");
		String direccion = teclado.nextLine();
		Empresa empresa = new Empresa(nombre, direccion);
		empresaRepository.save(empresa);// comprobar que se ha crado correctamente con un booleano
		System.out.println("Empresa creada " + empresa);

	}

	private static int getNumero() {
		int num = teclado.nextInt();
		teclado.nextLine();
		return num;
	}

}
