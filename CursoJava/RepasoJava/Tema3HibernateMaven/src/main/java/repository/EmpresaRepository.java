package repository;

import java.util.List;

import org.hibernate.Session;

import entities.Empresa;
import entities.Persona;

public class EmpresaRepository implements Repository<Empresa>{

	final Session session ;
	public EmpresaRepository(Session session) {
		this.session=session;
	};
	
	@Override
	public List<Empresa> findAll() {
		return null;
	}

	@Override
	public Empresa findOneById(int id) {
		
		return null;
	}

	@Override
	public void save(Empresa t) {
		
	}

	@Override
	public void updateById(int id) {
		
	}

	@Override
	public void delete(Persona persona) {
		
	}

	@Override
	public void update(Persona persona) {
		
	}

	@Override
	public void deleteBydId(int id) {
		
	}
	
}
