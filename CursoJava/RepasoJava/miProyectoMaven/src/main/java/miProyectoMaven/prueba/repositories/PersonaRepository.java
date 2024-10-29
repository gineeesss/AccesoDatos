package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

import miProyectoMaven.prueba.entities.Direccion;
import miProyectoMaven.prueba.entities.Persona;

public class PersonaRepository implements Repository<Persona> {

	Connection connection;
	public PersonaRepository (Connection connection) {
		this.connection = connection;
	}
	
	public List<Persona> findAllWithDirecciones(){
		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM personas p LEFT JOIN direcciones d ON p.id=d.persona_id order by p.id";
		ArrayList<Persona> personas = new ArrayList<>();
		
		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta: "+query);
			System.err.println(e.getMessage());
			return personas;
		}
		try {
			ResultSet rS = estado.getResultSet();
			while(!rS.isLast()) {
				rS.next();
				Persona persona = new Persona(
						rS.getInt(1),
						rS.getString(2),
						rS.getString(3),
						rS.getString(4)
						);
				Direccion direccion = new Direccion(
						rS.getInt(5),
						rS.getInt(6),
						rS.getString(7)
						);
				if(personas.contains(persona)) {
					int posicion = personas.indexOf(persona);
					Persona p = personas.get(posicion);
					p.addDireccion(direccion);
					personas.set(posicion, p);
				}else {
					persona.addDireccion(direccion);	
					personas.add(persona);
				}				
			}			
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos");
			System.err.println(e.getMessage());
		}
		return personas;
	}
	
	@Override
	public List<Persona> findAll() {
		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM PERSONAS;";
		ArrayList<Persona> personas = new ArrayList<>();
		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("Error: no se ha podido ejecutar la consulta"+query);
			System.err.println(e.getMessage());
			return personas;
		}
		try {
			ResultSet resultSet = estado.getResultSet();
			while(!resultSet.isLast()) {
				resultSet.next();
				Persona persona = new Persona(
						resultSet.getInt(1),    //ID
						resultSet.getString(2), //NOMBRE
						resultSet.getString(3), //PASSWORD
						resultSet.getString(4)  //TELEFONO
						);
				personas.add(persona);
			}
			return personas;
		} catch (SQLException e) {
			System.err.println("Error: no se ha podido crear el resultSet");
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	
	@Override
	public Persona findOneById(int id) {
		String query = "SELECT * FROM PERSONAS WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			estado.executeQuery();
		} catch (SQLException e) {
			System.err.println("Erro: no se ha podido ejecutar la sentencia: "+query);
			System.err.println(e.getMessage());
			return null;
		}
		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Persona(
					resultSet.getInt(1),    //ID
					resultSet.getString(2), //NOMBRE
					resultSet.getString(3), //PASSWORD
					resultSet.getString(4)  //TELEFONO						
			);
		} catch (SQLException e) {
			System.err.println("Erro: no se ha podido recuperar el resultSet");
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	
	
	
	@Override
	public Persona save(Persona t) {
		String query = "INSERT INTO PERSONAS(nombre,password,telefono) VALUES (?,?,?)";
		PreparedStatement estado = null;
		//PreparedStatement estado = null;
		try {
			//estado = JDBCOperations.crearSentencia(connection, query);
			estado = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			estado.setString(1,t.getNombre());
			estado.setString(2,t.getPassword());
			estado.setString(3,t.getTelefono());
			estado.executeUpdate();
			ResultSet key = estado.getGeneratedKeys();  // RECUPERAMOS EL ID AUTONUMERICO RECIEN CREADO EN LA BASE DE DATOS
			key.next();									// NOS POSICIONAMOS
			t.setId(key.getInt(1));						// LE SETEAMOS EL NUEVO ID A LA PERSONA
			System.out.println("Datos de la persona guardados correctamente en la BD");
			return t;
		} catch (SQLException e) {
			System.err.println("Error: No se ha ejecutar la Insercción");
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	
	
	
	@Override
	public void deleteById(int id) {
		String query = "DELETE FROM PERSONAS WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			if(estado.executeUpdate()>0) 
			System.out.println("La persona ha sido eliminada");
		} catch (SQLException e) {
			System.err.println("Error al actualizar datos");
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void updateById(int id, Persona persona) {
		String query = "UPDATE PERSONAS SET nombre=?, password=?, telefono=? WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setString(1, persona.getNombre());
			estado.setString(2, persona.getPassword());
			estado.setString(3, persona.getTelefono());
			estado.setInt(4, persona.getId());
			if(estado.executeUpdate()>0) 
			System.out.println("La persona ha sido updateada");
		} catch (SQLException e) {
			System.err.println("Error al eliminar datos");
			System.err.println(e.getMessage());
		}		
		
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
