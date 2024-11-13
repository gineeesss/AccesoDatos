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
		
		System.out.println("Conectando a la base de datos....");
		final Session session = factory.openSession();
		
		System.out.println("Conectando correctamente a la base de datos....");
		session.close();//factory.close();StandardServiceRegistryBuilder.destroy(registro);
		
		System.out.println("Sesion cerrada");
	}

}
