package miProyectoMaven.prueba;

import java.sql.Connection;

import miProyectoMaven.prueba.entities.Persona;
import miProyectoMaven.prueba.repositories.PersonaRepository;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Conexion a jdbc CON de MYSQL.");
		String urlMysql = "jdbc:mysql://localhost/m07";
		// String urlH2 = "jdbc:h2:" + Path.of("m06").toAbsolutePath().toString();
		String username = "root";
		String password = "";
		System.out.println("Conectando al servidor MYSQL ... ");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);
		System.out.println("Iniciando conexión con el servidor");
		// Persona persona = new Persona("pedrito", "qwerty", "78763");
		// System.out.println(persona + "La almacenamos en la base de datos");
		PersonaRepository repository = new PersonaRepository(connection);
		// repository.save(persona);

		// System.out.println("_-------Persona almacenada en la base de datos--");
		// System.out.println(persona + "almacenada en la base de datos con un id valido
		// autonumerico");
		System.out.println(repository.findOneById(11));
		Persona persona = repository.findOneById(11);
		// System.out.println(repository.findOneById(persona.getId()));
		// System.out.println(repository.findAll());
		repository.findAll().forEach(alumno -> System.out.println(alumno));
		persona.setPassword("123estoesunpass34");
		System.out.println(persona + "Le hemos cambiado la contraseña");
		repository.updateById(persona.getId(), persona);
		System.out.println(repository.findOneById(persona.getId()));
		// repository.deleteById(18);
		// System.out.println(repository.findAllWithDirecciones());
		repository.findAllWithDirecciones().forEach(p -> System.out.println(p));
	}

}
