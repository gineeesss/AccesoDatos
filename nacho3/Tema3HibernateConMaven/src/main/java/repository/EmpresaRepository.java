package repository;

import java.util.List;

import org.hibernate.Session;

import entities.Empresa;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class EmpresaRepository implements Repository<Empresa> {

	final Session session;

	public EmpresaRepository(Session session) {
		this.session = session;
	}

	@Override
	public List<Empresa> findAll() {
		session.beginTransaction();
		Query query = session.createQuery("FROM Empresa", Empresa.class);
		List<Empresa> empresas = query.getResultList();
		session.getTransaction().commit();
		// return query.getResultList();
		return empresas;
	}

	@Override
	public Empresa findOneById(int id) {
		session.beginTransaction();
		Query query = session.createQuery("FROM Empresa where id =: idEmpresa", Empresa.class);
		query.setParameter("idEmpresa", id);
		try {
			return (Empresa) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("no existe esa empresa o id en la bbdd");
			return new Empresa();

		} finally {
			session.getTransaction().commit();
		}
	}

	@Override
	public void save(Empresa empresa) {
		session.beginTransaction();
		// session.save(persona);
		session.clear();
		session.persist(empresa);
		session.getTransaction().commit();

	}

	@Override
	public void updateById(int id, Empresa empresa) {
		session.beginTransaction();
		session.clear();
		empresa.setId(id);
		// session.update(persona);
		session.merge(empresa);
		session.getTransaction().commit();
	}

	public void update(Empresa empresa) {
		session.beginTransaction();
		session.clear();
		// session.update(persona);
		session.merge(empresa);
		session.getTransaction().commit();

	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		session.clear();
		Empresa empresa = new Empresa();
		empresa.setId(id);
		// session.delete(persona);
		session.remove(empresa);
		session.getTransaction().commit();
	}

	public void delete(Empresa empresa) {
		session.beginTransaction();
		session.clear();
		// session.delete(persona);
		session.remove(empresa);
		session.getTransaction().commit();
	}

}
