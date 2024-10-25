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
			System.err.println("Error al ejecutar la query: " + query);
			System.err.println(e.getMessage());
		}
		
		ResultSet resultSet;
		try {
			resultSet = estado.getResultSet();
			while(!resultSet.isLast()) {
				resultSet.next();
				Direccion direccion=new Direccion(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3)
						);
				direcciones.add(direccion);
			}
		} catch (SQLException e) {
			System.err.println("Error al extraer el ResultSet");
			System.err.println(e.getMessage());
		}
		
		
		
		return null;
	}

	@Override
	public Direccion findOneById(int id) {
		String query = "SELECT * FROM DIRECCIONES WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("Erro: no se ha podido ejecutar la sentencia: "+query);
			System.err.println(e.getMessage());
			return null;
		}
		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Direccion(
					resultSet.getInt(1),    //ID
					resultSet.getInt(2), 	//IDPERSONA
					resultSet.getString(3)  //DIRECCION			
			);
		} catch (SQLException e) {
			System.err.println("Erro: no se ha podido recuperar el resultSet");
			System.err.println(e.getMessage());
		}
		return null;
		}

	@Override
	public Direccion save(Direccion t) {
		String query = "INSERT INTO DIRECCIONES(id,persona_id,direccion) VALUES (?,?,?)";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		//PreparedStatement estado = null;
		try {
			//estado = connection.prepareStatement(quert, Statement.RETURN_GENERATED.KEYS);
			estado.setInt(1,t.getId());
			estado.setInt(1,t.getPersonaId());
			estado.setString(1,t.getDireccion());
			estado.executeUpdate();
			ResultSet key = estado.getGeneratedKeys();  // RECUPERAMOS EL ID AUTONUMERICO RECIEN CREADO EN LA BASE DE DATOS
			key.next();									// NOS POSICIONAMOS
			t.setId(key.getInt(1));						// LE SETEAMOS EL NUEVO ID A LA PERSONA
			System.out.println("Datos de la direccion guardados correctamente en la BD");
			return t;
		} catch (SQLException e) {
			System.err.println("Error: No se ha ejecutar la Insercción");
			System.err.println(e.getMessage());
		}
		return null;
		}

	@Override
	public void deleteById(int id) {
		String query = "DELETE FROM DIRECCION WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			if(estado.executeUpdate()>0) 
			System.out.println("La direccion ha sido eliminada");
		} catch (SQLException e) {
			System.err.println("Error al eliminar datos");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateById(int id, Direccion direccion) {
		String query = "UPDATE DIRECCIONES SET id=?, persona_id=?, direccion=? WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, direccion.getPersonaId());
			estado.setString(2, direccion.getDireccion());
			estado.setInt(3, direccion.getId());
			if(estado.executeUpdate()>0) 
			System.out.println("La direccion ha sido eliminada");
		} catch (SQLException e) {
			System.err.println("Error al actualizar datos");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
	}


}
