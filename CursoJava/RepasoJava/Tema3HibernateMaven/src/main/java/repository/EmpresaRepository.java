package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Empresa;
import entities.Persona;

public class EmpresaRepository implements Repository<Empresa>{

	final Session session ;
	public EmpresaRepository(Session session) {
		this.session=session;
	};
	
	@Override
	public List<Empresa> findAll() {
		session.beginTransaction();
		Query<Empresa> query = session.createQuery("FROM Empresa",Empresa.class);
		List<Empresa> empresas = query.getResultList();
		session.getTransaction().commit();
		return empresas;
	}

	@Override
	public Empresa findOneById(int id) {
		session.beginTransaction();
		Query query =session.createQuery("FROM Empresa where id=: idEmpresa", Empresa.class);
		query.setParameter("idEmpresa", id);
		try {
			return (Empresa) query.getSingleResult();
		}catch (Exception e) {
			System.out.println("No existe");
			return new Empresa();
		}finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void save(Empresa empresa) {
		session.beginTransaction();
		//session.save(persona);
		session.clear();
		session.persist(empresa);
		session.getTransaction().commit();
	}

	public void updateById(int id, Empresa empresa) {
		session.beginTransaction();
		session.clear();
		empresa.setId(id);
		//session.update(persona);
		session.merge(empresa); //lo hace persistente
		session.getTransaction().commit();
	}

	public void delete(Empresa empresa) {
		session.beginTransaction();
		session.clear();
		//session.update(persona);
		session.merge(empresa); //lo hace persistente
		session.getTransaction().commit();
	}

	public void update(Empresa empresa) {
		session.beginTransaction();
		session.clear();
		//session.update(persona);
		session.merge(empresa); //lo hace persistente
		session.getTransaction().commit();
	}

	@Override
	public void deleteBydId(int id) {
		
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub
		
	}
	
}
