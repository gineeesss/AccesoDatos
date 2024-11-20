import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Empresa;
import entities.Persona;
import repository.EmpresaRepository;
import repository.PersonaRepository;

public class MainEmpresaPersona {
	public static void main(String[] args) {
		System.out.println("Iniciadno configraucion hibernate");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		final Session session = factory.openSession();
		
		
		
		EmpresaRepository empresaRepository= new EmpresaRepository(session);
		PersonaRepository personaRepository= new PersonaRepository(session);
		
		Empresa empresa= new Empresa("DAM2", "Avda Ramon y Cajal");
		System.out.println("Empersa antes de guardar: "+ empresa);
		empresaRepository.save(empresa);
		System.out.println("Empresa después de guardar: "+ empresa);
		
		Persona persona = new Persona("Hernan Cortés",504,Persona.newDate(18, 6, 1490), empresa);
		System.out.println("Persona antes de guardar: "+ persona);
		personaRepository.save(persona);
		
		System.out.println("Persona después de guardar: "+ persona);
		System.out.println(empresa);
		
		session.close();
		
	}
}
