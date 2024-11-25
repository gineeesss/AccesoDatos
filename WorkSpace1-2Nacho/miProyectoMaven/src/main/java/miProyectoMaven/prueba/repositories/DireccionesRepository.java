package miProyectoMaven.prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import miProyectoMaven.prueba.entities.Direccion;

public class DireccionesRepository implements Repository<Direccion> {

	Connection connection;

	public DireccionesRepository(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Direccion> findAll() {

		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM DIRECCIONES";
		ArrayList<Direccion> direcciones = new ArrayList<>();

		try {
			estado.executeQuery(query);

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos de la query: " + query);
			System.err.println(e.getMessage());
			return direcciones;
		}

		try {
			ResultSet resultSet = estado.getResultSet();
			while (!resultSet.isLast()) {
				resultSet.next();
				Direccion direccion = new Direccion(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3));
				direcciones.add(direccion);
			}

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos con el resultset");
			System.err.println(e.getMessage());
		}

		return direcciones;
	}

	@Override
	public Direccion findOneById(int id) {
		String query = "SELECT * FROM DIRECCIONES WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setInt(1, id);
			estado.executeQuery(query);

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return null;
		}
		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Direccion(resultSet.getInt(1), // el ID de la direccion
					resultSet.getInt(2), // persona_id
					resultSet.getString(3) // la descripcion de la dirección

			);

		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos");
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public Direccion save(Direccion direccion) {
		String query = "INSERT INTO Direcciones (persona_id,direccion) VALUES(?,?)";
		PreparedStatement estado = null;

		try {
			estado = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			System.err.println("No se ha podido crear la sentencia");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		try {
			estado.setInt(1, direccion.getPersonaId());
			estado.setString(2, direccion.getDireccion());

			estado.executeUpdate();// la direccion acaba de ser insertada en la Base de datos
			ResultSet key = estado.getGeneratedKeys();// recuperamos el id autonumerico recien creado en la base de
														// datos
			key.next();// nos posicionamos
			direccion.setId(key.getInt(1));// le seteamaos el nuevo id a la direccion
			System.out.println("Datos de la direccion guardados correctamente en la BD");
			return direccion;

		} catch (SQLException e) {
			System.err.println("Error al insertar datos de direccion");
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public void deleteById(int id) {
		String query = "DELETE FROM direcciones WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setInt(1, id);
			if (estado.executeUpdate() > 0)
				System.out.println("La direccion ha sido eliminada de la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al eliminar datos direccion");
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void updateById(int id, Direccion direccion) {

		String query = "UPDATE direcciones SET persona_id=?,direccion=? WHERE id=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setInt(1, direccion.getPersonaId());
			estado.setString(2, direccion.getDireccion());
			// estado.setInt(4, id);
			estado.setInt(3, direccion.getId());

			if (estado.executeUpdate() > 0)
				System.out.println("La direccion ha sido actualizada de la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al eliminar datos direccion");
			System.err.println(e.getMessage());
		}

	}

}
