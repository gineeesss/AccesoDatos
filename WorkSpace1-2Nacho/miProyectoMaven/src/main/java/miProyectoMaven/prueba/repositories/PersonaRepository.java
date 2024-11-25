package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miProyectoMaven.prueba.entities.Direccion;
import miProyectoMaven.prueba.entities.Persona;

public class PersonaRepository implements Repository<Persona> {

	Connection connection;

	public PersonaRepository(Connection connection) {
		this.connection = connection;
	}

	public List<Persona> findAllWithDirecciones() {

		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM personas p INNER JOIN direcciones d ON p.id=d.persona_id order by p.id";
		ArrayList<Persona> personas = new ArrayList<>();

		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return personas;
		}

		try {
			ResultSet rS = estado.getResultSet();

			while (!rS.isLast()) {
				rS.next();
				Persona persona = new Persona(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4));

				Direccion direccion = new Direccion(rS.getInt(5), rS.getInt(6), rS.getString(7));

				if (personas.contains(persona)) {// esa persona ya la tenemos metida dentro dela array
					// list de personas a devolver.
					// tenemos que localizar esa persona, en el arraylist, y le añadimos esta nueva
					// direccion
					int posicion = personas.indexOf(persona);
					Persona p = personas.get(posicion);
					p.addDireccion(direccion);
					personas.set(posicion, p);

				} else {// esta es la primera vez que encuentro a esta persona, y esa dirección

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
		String query = "SELECT * FROM PERSONAS";
		ArrayList<Persona> personas = new ArrayList<>();

		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return personas;
		}

		try {
			ResultSet resultSet = estado.getResultSet();
			while (!resultSet.isLast()) {
				resultSet.next();
				Persona persona = new Persona(resultSet.getInt(1), // el ID
						resultSet.getString(2), // nombre
						resultSet.getString(3), // password
						resultSet.getString(4)// telefono
				);
				personas.add(persona);

			}
			// return personas;

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos");
			System.err.println(e.getMessage());
		}

		return personas;
	}

	@Override
	public Persona findOneById(int id) {
		String query = "SELECT * FROM personas WHERE id = ?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setInt(1, id);
			System.out.println("seteado el id");
			estado.executeQuery();

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return null;
		}
		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Persona(resultSet.getInt(1), // el ID
					resultSet.getString(2), // nombre
					resultSet.getString(3), // password
					resultSet.getString(4)// telefono
			);

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos");
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public Persona save(Persona persona) {
		String query = "INSERT INTO PERSONAS(nombre,password,telefono) VALUES(?,?,?)";
		PreparedStatement estado = null;

		try {
			estado = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			System.err.println("No se ha podido crear la sentencia");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		try {
			estado.setString(1, persona.getNombre());
			estado.setString(2, persona.getPassword());
			estado.setString(3, persona.getTelefono());
			estado.executeUpdate();// la persona acaba de ser insertada en la Base de datos
			ResultSet key = estado.getGeneratedKeys();// recuperamos el id autonumerico recien creado en la base de
														// datos
			key.next();// nos posicionamos
			persona.setId(key.getInt(1));// le setemaos el nuevo id a la persona.
			System.out.println("Datos de la persona guardados correctamente en la BD");
			return persona;

		} catch (SQLException e) {
			System.err.println("Error al insertar datos");
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
			if (estado.executeUpdate() > 0)
				System.out.println("La persona ha sido eliminada de la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al eliminar datos");
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void updateById(int id, Persona persona) {

		String query = "UPDATE personas SET nombre=?,password=?,telefono=? WHERE id=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setString(1, persona.getNombre());
			estado.setString(2, persona.getPassword());
			estado.setString(3, persona.getTelefono());

			// estado.setInt(4, id);skjdlfjlñjrejfñ
			estado.setInt(4, persona.getId());

			if (estado.executeUpdate() > 0)
				System.out.println("La persona ha sido actualizada de la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al actualizar datos");
			System.err.println(e.getMessage());
		}

	}

}
