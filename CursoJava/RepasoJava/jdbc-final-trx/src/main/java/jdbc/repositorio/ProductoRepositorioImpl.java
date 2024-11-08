package jdbc.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

	private Connection getConnection() throws SQLException{
		return ConexionBaseDatos.getConnection();
		
	}
	
	@Override
	public List<Producto> listar() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		try(	
				Connection conn = getConnection();
				Statement stm = getConnection().createStatement();ResultSet rs = stm.executeQuery("SELECT * FROM productos"))
		{
			while(rs.next()) {
				productos.add(crearProducto(rs));
			}
		} 
		return productos;
	}

	private Producto crearProducto(ResultSet rs) throws SQLException {
		Producto producto =  new Producto();
		
		producto.setId(rs.getLong("id"));
		producto.setNombre(rs.getString("nombre"));
		producto.setPrecio(rs.getInt("precio"));
		producto.setFechaRegistro(rs.getDate("fecha_registro"));
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("categoria_id"));
		categoria.setNombre(rs.getString("categoria"));
		producto.setCategoria(categoria);
		return producto;
	}


	@Override
	public Producto porId(Long id) throws SQLException {
		Producto producto = null;
		try(
				Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE id=?"))
		{
			stmt.setLong(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					producto=crearProducto(rs);
				}
			}
		}
		return producto;
	}

	@Override
	public void guardar(Producto producto) throws SQLException {
		String sql;
		//VAMOS A APROVECHAR PARA FUARDAR (INSERT( Y ADEMÁS ACTUALIZAR(UPDATE)
		if(producto.getId()!=null && producto.getId()>0) {
			// EL PRODUCTO YA EXISTE EN LA BDD
			sql = "UPDATE productos SET nombre=?, precio=?, WHERE ID=?";
		}else {
			sql = "INSERT INTO productos(nombre,precio,fecha_registro) VALUES (?,?,?)";
		}
		try(
				Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			if(sql.contains("UPDATE")) {
				stmt.setLong(3, producto.getId());
			}else {
				stmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
			}
			stmt.executeUpdate();
		} 
	}

	@Override
	public boolean eliminar(Long id) throws SQLException {

		try(
				Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHEERE id=?"))
		{
			stmt.setLong(1, id);
	
		} 
		return false;
	}

}
