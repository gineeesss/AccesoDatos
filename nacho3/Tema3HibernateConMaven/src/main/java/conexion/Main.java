package conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {

		System.out.println("Iniciando configuración hibernate....");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		System.out.println("Conectando a la Base de Datos...");
		final Session session = factory.openSession();
		System.out.println("Conectado correctamente a la Base de Datos...");
		// session.beginTransaction();

		// recuperamos todas las personas
		// Query query = session.createQuery("FROM Persona", Persona.class);
		// ArrayList<Persona> personas = (ArrayList<Persona>) query.getResultList();
		// personas.forEach(persona -> System.out.println(persona));
		// recuperamos una sóla personas:
		/*
		 * Query query = session.createQuery("FROM Persona where id =: idPersona",
		 * Persona.class); query.setParameter("idPersona", 2); try { Persona persona =
		 * (Persona) query.getSingleResult(); System.out.println(persona);
		 * 
		 * } catch (NoResultException e) {
		 * System.out.println("NO se ha encontrado a la persona con el ID indicado."); }
		 */
		// Persona persona = new Persona(15, "Juan sin miedo", 29, new Date());
		/*
		 * Persona persona = new Persona("Juan sin miedo", 29, Persona.newDate(14, 11,
		 * 2024)); System.out.println("Antes de insertar : " + persona);
		 * session.save(persona);
		 */
		// session.persist(persona);
		/*
		 * Persona persona = new Persona(); persona.setId(2); session.delete(persona);
		 * System.out.println("Despues de borrar : " + persona);
		 * 
		 * System.out.println(persona.getId());
		 * persona.setNombre("Otro nombre en la misma persona"); session.save(persona);
		 * System.out.println("Despues de updatar : " + persona);
		 */

		/*
		 * persona.setNombre("Otopersona"); persona.setEdad(32); //
		 * session.update(persona); session.merge(persona);
		 * System.out.println("Despues de updatar : " + persona);
		 */
		// session.getTransaction().commit();
		session.close();
		System.out.println("Desconectado correctamente de la Base de Datos...");

	}

}
