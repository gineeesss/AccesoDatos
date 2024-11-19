package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Persona;

public class PersonaRepository implements Repository<Persona>{

	final Session session;
	
	public PersonaRepository(Session session) {
		this.session = session;
	}
	
	@Override
	public List<Persona> findAll() {
		session.beginTransaction();
		Query<Persona> query = session.createQuery("FROM Persona",Persona.class);
		List<Persona> personas = query.getResultList();
		session.getTransaction().commit();
		return personas;
	}

	@Override
	public Persona findOneById(int id) {
		session.beginTransaction();
		Query query =session.createQuery("FROM Persona where id=: idPersona", Persona.class);
		query.setParameter("idPersona", id);
		try {
			return (Persona) query.getSingleResult();
		}catch (Exception e) {
			System.out.println("No existe");
			return null;
		}finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void save(Persona persona) {
		session.beginTransaction();
		//session.save(persona);
		session.clear();
		session.persist(persona);
		session.getTransaction().commit();
	}

	@Override
	public void updateById(int id) {
		session.beginTransaction();
		session.clear();
		//session.update(persona);
		//session.merge(); //lo hace persistente
		session.getTransaction().commit();
	}
	@Override
	public void update(Persona persona) {
		session.beginTransaction();
		session.clear();
		//session.update(persona);
		session.merge(persona); //lo hace persistente
		session.getTransaction().commit();
	}

	@Override
	public void delete(Persona persona) {
		session.beginTransaction();
		session.clear();
		//session.update(persona);
		session.remove(persona); //lo hace persistente
		session.getTransaction().commit();		
	}

	@Override
	public void deleteBydId(int id) {
		session.beginTransaction();
		session.clear();
		Persona persona = new Persona();
		persona.setId(id);
		//session.update(persona);
		session.remove(persona); //lo hace persistente
		session.getTransaction().commit();
	}


}
