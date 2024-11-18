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
		return null;
	}

	@Override
	public Persona findOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Persona t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBy(int id) {
		// TODO Auto-generated method stub
		
	}

}
