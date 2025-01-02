package repository;

import java.util.List;

import org.hibernate.Session;

import entities.Persona;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class PersonaRepository implements Repository<Persona> {

	final Session session;

	public PersonaRepository(Session session) {
		this.session = session;
	}

	@Override
	public List<Persona> findAll() {
		session.beginTransaction();
		Query query = session.createQuery("FROM Persona", Persona.class);
		List<Persona> personas = query.getResultList();
		session.getTransaction().commit();
		// return query.getResultList();
		return personas;
	}

	@Override
	public Persona findOneById(int id) {
		session.beginTransaction();
		Query query = session.createQuery("FROM Persona where id =: idPersona", Persona.class);
		query.setParameter("idPersona", id);
		try {
			return (Persona) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("no existe esa persona o id en la bbdd");
			return new Persona();

		} finally {
			session.getTransaction().commit();
		}

	}

	@Override
	public void save(Persona persona) {
		session.beginTransaction();

		session.clear();
		// session.save(persona);
		session.persist(persona);
		session.getTransaction().commit();

	}

	@Override
	public void updateById(int id, Persona persona) {
		session.beginTransaction();
		session.clear();
		persona.setId(id);
		// session.update(persona);
		session.merge(persona);
		session.getTransaction().commit();

	}

	public void update(Persona persona) {
		session.beginTransaction();
		session.clear();
		// session.update(persona);
		session.merge(persona);
		session.getTransaction().commit();

	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		session.clear();
		Persona persona = new Persona();
		persona.setId(id);
		// session.delete(persona);
		session.remove(persona);
		session.getTransaction().commit();
	}

	public void delete(Persona persona) {
		session.beginTransaction();
		session.clear();
		// session.delete(persona);
		session.remove(persona);
		session.getTransaction().commit();
	}

}
