package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Coche;

public class CocheRepository implements Repository<Coche> {
	private static Connection getConnection() throws SQLException {
		return Conexion.getInstance();
	}
	
	@Override
	public void insertar(Coche coche) {
		String sql = "INSERT INTO coche (matricula, marca, modelo, color) VALUES (?,?,?,?)";
		try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1, coche.getMatricula());
			ps.setString(2, coche.getMarca());
			ps.setString(3, coche.getModelo());
			ps.setString(4, coche.getColor());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: al insertar coche");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void actualizar(String matricula, String marca, String modelo) {
		String sql = "UPDATE coche SET marca=?, modelo=? WHERE matricula=?";
		try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1, marca);
			ps.setString(2, modelo);
			ps.setString(3, matricula);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: al actualizar coche con matricula: "+ matricula);
			System.err.println(e.getMessage());
		}		
	}

	@Override
	public void eliminar(String matricula) {
		String sql = "DELETE FROM coche WHERE matricula=?";
		try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1, matricula);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro: error al eliminar coche con matricula: " + matricula);
			System.err.println(e.getMessage());
		}
	}

}
