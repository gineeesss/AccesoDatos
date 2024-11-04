package jdbc.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

	private Connection getConnection() throws SQLException{
		return ConexionBaseDatos.getInstance();
		
	}
	
	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<>();
		try(Statement stm = getConnection().createStatement();ResultSet rs = stm.executeQuery("SELECT * FROM productos")){
			while(rs.next()) {
				productos.add(crearProducto(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Producto crearProducto(ResultSet rs) throws SQLException {
		Producto producto =  new Producto();
		producto.setId(rs.getLong("id"));
		producto.setNombre(rs.getString("nombre"));
		producto.setPrecio(rs.getInt("precio"));
		producto.setFacheRegistro(rs.getDate("fecha_registro"));
		return producto;
	}

	@Override
	public Producto porId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(Producto t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
