import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Empresa;
import entities.Persona;
import repository.EmpresaRepository;
import repository.PersonaRepository;

public class MainEmpresaPrsonas {

	public static void main(String[] args) {

		System.out.println("Iniciando configuración hibernate....");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		System.out.println("Conectando a la Base de Datos...");
		final Session session = factory.openSession();
		System.out.println("Conectado correctamente a la Base de Datos...");
		PersonaRepository personaRepository = new PersonaRepository(session);
		EmpresaRepository empresaRepository = new EmpresaRepository(session);
		Empresa empresa = new Empresa("DAM2 Company", "Avda Ramon y Cajal s/n");

		System.out.println(empresa + "Antes de guardar en la bbdd");
		empresaRepository.save(empresa);
		System.out.println(empresa + "Después de guardar en la bbdd");

		Persona persona = new Persona("Hernán Cortes", 504, Persona.newDate(18, 8, 1490), empresa);
		System.out.println(persona + " Antes de guardar en la bbdd");
		personaRepository.save(persona);
		System.out.println(persona + " Antes de guardar en la bbdd");

		System.out.println(empresa + "Después de guardar en al trabajador la bbdd");
		System.out.println(persona.getEmpresa().getNombre());

		session.close();
		System.out.println("Desconectado correctamente de la Base de Datos...");

	}

}
