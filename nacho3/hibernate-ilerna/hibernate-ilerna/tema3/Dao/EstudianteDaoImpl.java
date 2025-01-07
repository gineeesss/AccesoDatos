package main.java.tema3.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.objetos.Estudiante;
import main.java.tema3.HibernateUtil;

public class EstudianteDaoImpl {

	private static SessionFactory factory;
	HibernateUtil util;

	public Integer crearAlumno(String nombre, String apellido, String dni) {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer idEstudiante = null;

		try {
			tx = session.beginTransaction();
			Estudiante estudiante = new Estudiante();
			estudiante.setNombre(nombre);
			estudiante.setApellido(apellido);
			estudiante.setDni(dni);
			idEstudiante = (Integer) session.save(estudiante);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idEstudiante;
	}

	public Integer crearAlumnoObjeto(Estudiante estudiante) {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer idEstudiante = null;

		try {
			tx = session.beginTransaction();

			idEstudiante = (Integer) session.save(estudiante);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idEstudiante;
	}

	public void updateEstudiantes() {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Estudiante estudiante = (Estudiante) session.load(Estudiante.class, new Long(101));
			tx.commit();
			// actualizar valor
			estudiante.setNombre("Juan");
			estudiante.setApellido("Palomo");
			Transaction tx7 = session.beginTransaction();
			session.update(estudiante);

			tx7.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateEstudiantes(Estudiante estudiante) {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			// actualizar valor
			estudiante.setNombre("Juan");
			estudiante.setApellido("Palomo");
			Transaction tx7 = session.beginTransaction();
			session.update(estudiante);

			tx7.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteEstudiantes() {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Estudiante estudiante = new Estudiante();
			estudiante.setId(1);
			session.delete(estudiante);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteEstudiantes(Estudiante estudiante) {
		util = new HibernateUtil();
		factory = util.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(estudiante);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
