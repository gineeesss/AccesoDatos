package test.java.tema3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.objetos.Estudiante;
import main.java.tema3.Dao.EstudianteDaoImpl;

public class TestEstudiante {

	@Test
	public void testBorrado() {
		boolean b = true;
		EstudianteDaoImpl dao = new EstudianteDaoImpl();
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setApellido("Palomo");
		estudiante.setDni("112222444H");
		estudiante.setEdad(21);
		estudiante.setId(1);
		
		assertEquals(b, dao.deleteEstudiantes(estudiante));

	}
	
	@Test
	public void updateEstudianteTest() {
		boolean b=true;
		EstudianteDaoImpl dao = new EstudianteDaoImpl();
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setApellido("Palomo");
		estudiante.setDni("112222444H");
		estudiante.setEdad(21);
		estudiante.setId(1);
		
		assertEquals(b,dao.updateEstudiantes(estudiante));
	}
}
