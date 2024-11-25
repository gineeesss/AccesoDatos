package repository;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.type.descriptor.java.spi.EmbeddableAggregateJavaType;

import entities.Persona;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class MainConRepository {

	public static void main(String[] args) {
		System.out.println("Iniciadno configraucion hibernate");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		final Session session = factory.openSession();
		
		PersonaRepository personaRepository = new PersonaRepository(session);
		Persona persona = new Persona("Pillo",31, Persona.newDate(18,8, 1022));
		personaRepository.save(persona);
		persona.setEdad(51);
		personaRepository.update(persona);
		for (int i=0;i<10;i++) {
			Persona diez = new Persona("Persona"+i,i,Persona.newDate(i+1,i+1,2020+i));
			personaRepository.save(diez);
		}
		personaRepository.findAll().forEach(p -> System.out.println(p));
		personaRepository.deleteBydId(3);
		session.close();
		
	}
}
