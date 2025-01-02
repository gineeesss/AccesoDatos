package main.java.modelo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.objetos.Estudiante;

public class ModeloDAOImpl {
	private static SessionFactory factory;

	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List estudiantes = session.createQuery("FROM Estudiante").list();
			for (Iterator iterator = estudiantes.iterator(); iterator.hasNext();) {
				Estudiante estudiante = (Estudiante) iterator.next();
				System.out.print("Nombre: " + estudiante.getNombre());
				System.out.print("  Apellido: " + estudiante.getApellido());
				System.out.println("  Dni: " + estudiante.getDni());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Integer crearAlumno(String nombre, String apellido, String dni){
	    
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
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    } finally {
	       session.close(); 
	    }
	    return idEstudiante;
	 }
	

	public void updateEstudiantes() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Estudiante  estudiante = (Estudiante) session.load(Estudiante.class, new Long(101));
			System.out.println("Estudiante cargado. " + estudiante);
			tx.commit();
			
			//actualizar valor
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

   
}
