package miProyectoMaven.prueba;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import miProyectoMaven.prueba.repositories.JDBCOperations;
import miProyectoMaven.prueba.repositories.PersonaRepository;
import miProyectoMaven.prueba.entities.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Conexión a JDBC con MYSQL");

		String urlMysql = "jdbc:mysql://localhost:3306/m06";
		String username = "root";
		String password = "";
		//String urlH2="jdbc:h2:"+Path.of("m06").toAbsolutePath();
		
		
		System.out.println("Conectando a Servidor ...");
		//Connection connection = H2Connection.newInstance(urlMysql,username,password);
		Connection connection = MySqlConnection.newInstance(urlMysql, username, password);
		//JDBCOperations.insertData(connection);
		System.out.println("Iniciando conexión con el servidor");
		Persona persona = new Persona("Eyeywyeyey","qwerty","666");
		System.out.println(persona+"Insertada");
		PersonaRepository repository = new PersonaRepository(connection);
		repository.save(persona);
		System.out.println("---------------Persona almacenada en la base de datos");
		System.out.println(persona+"Insertada");
		System.out.println("---------------");
		System.out.println(repository.findOneById(2));
		System.out.println(repository.findAll());
		repository.findAll().forEach(persona1 -> System.out.println(persona1));
		persona.setPassword("tomatomate");
		System.out.println("--------------");
		System.out.println(persona+"Sa cambiao la contraseña");
		repository.updateById(persona.getId(),persona);
		System.out.println("--------------");
		repository.deleteById(12);
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error: No se ha podido cerrar la Conexión");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}
}
