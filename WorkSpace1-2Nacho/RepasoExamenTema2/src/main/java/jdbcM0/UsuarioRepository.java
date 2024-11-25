package jdbcM0;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbcM0.Usuario;

public class UsuarioRepository implements Repository<Usuario> {
	
	private Connection getConnection() throws SQLException {
		return Conexion.getInstance();
	}
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList();
		String sql = "SELECT * FROM usuarios;" ;
		try(Statement st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while(rs.next()) {
				Usuario usuario = crearPersona(rs);
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.err.println("Error: al extraer un listado");
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

	private Usuario crearPersona(ResultSet rs) {
		Usuario usuario = new Usuario();
		
		try {
			usuario.setId(rs.getInt(1));
			usuario.setUsername(rs.getString(2));
			usuario.setPassword(rs.getString(3));
			usuario.setEmail(rs.getString(4));
		}
		catch (SQLException e) {
			System.err.println("Error: No se ha podido setear las características del registro a una instancia Usuario");
			System.err.println(e.getMessage());
		}

		return usuario;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM usuarios WHERE id=?";
		try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: error al eliminar usuario con id: " + id);
			System.err.println(e.getMessage());
			return false;
		}
	}

	public void agregar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";
        try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1,usuario.getUsername());
			ps.setString(2,usuario.getPassword());
			ps.setString(3,usuario.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
			System.err.println("Error: al insertar usuario en la bd");
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void actualiazr(Usuario usuario) {
        String sql = "UPDATE usuarios SET username=?, password=?, email=? WHERE id=?";
        try (	PreparedStatement ps = getConnection().prepareStatement(sql);){
			ps.setString(1,usuario.getUsername());
			ps.setString(2,usuario.getPassword());
			ps.setString(3,usuario.getEmail());
			ps.setInt(4,usuario.getId());
			ps.executeUpdate();
			} catch (SQLException e) {
			System.err.println("Eror: al actualizar el usuario");
		}
	}

	

}
