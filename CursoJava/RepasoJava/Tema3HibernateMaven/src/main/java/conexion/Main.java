package conexion;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Persona;
import jakarta.persistence.Query;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando configuración hibernate....");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		
		System.out.println("Conectando a la base de datos....");
		final Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			// Crear un objeto Persona y persistirlo en la base de datos
			Persona persona = new Persona("Hola", 29, new Date());
			System.out.println("Persona antes de insertar: " + persona);
			session.persist(persona);
			System.out.println("Persona después de insertar: " + persona);
			
			// Modificar la persona
			//persona.setNombre("Otro Nombre");
			//persona.setEdad(33);
			session.merge(persona);
			
			// Confirmar la transacción
			session.getTransaction().commit();
			System.out.println("Persona guardada correctamente en la base de datos.");
			Persona otra = new Persona();
			otra.setId(5);
			session.persist(otra);
			//session.delete(otra);
			
			for (int i=0;i<10;i++) {
				Persona diez = new Persona("Persona"+i,i,persona.newDate(i+1,i+1,2020+i));
				session.persist(diez);
			}
			Query query = session.createQuery("FROM Persona",Persona.class);
			ArrayList<Persona> personas=(ArrayList<Persona>) query.getResultList();
			personas.forEach(item -> System.out.println(item));
		} catch (Exception e) {
			// En caso de error, revertir la transacción
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			// Cerrar la sesión y la fábrica de sesiones
			session.close();
			factory.close();
			StandardServiceRegistryBuilder.destroy(registro);
			System.out.println("Sesión y fábrica de sesiones cerradas.");
		}
	}
}
