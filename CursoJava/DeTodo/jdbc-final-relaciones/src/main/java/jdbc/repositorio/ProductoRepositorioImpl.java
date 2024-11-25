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
		return ConexionBaseDatos.getInstance();
		
	}
	
	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<>();
		
		try(Statement stm = getConnection().createStatement();
			ResultSet rs = stm.executeQuery("SELECT p.*, c.nombre as categoria FROM productos p  INNER JOIN categorias c ON (p.categoria_id=c.id)")){
			while(rs.next()) {
				productos.add(crearProducto(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Producto porId(Long id) {
		Producto producto = null;
		try(PreparedStatement stmt = getConnection().prepareStatement("SELECT p.*, c.id ad categoria_id, c.nombre as categoria FROM productos p  INNER JOIN categorias c ON (p.categoria_id=c.id) WHERE p.id=?")){
			stmt.setLong(1, id);
			
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					producto=crearProducto(rs);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}	
		return producto;
	}

	@Override
	public void guardar(Producto producto) {
		String sql;
		//VAMOS A APROVECHAR PARA FUARDAR (INSERT( Y ADEMÁS ACTUALIZAR(UPDATE)
		if(producto.getId()!=null && producto.getId()>0) {
			// EL PRODUCTO YA EXISTE EN LA BDD
			sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE ID=?";
		}else {
			sql = "INSERT INTO productos(nombre,precio,categoria_id,fecha_registro) VALUES (?,?,?,?)";
		}
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			stmt.setLong(3, producto.getCategoria().getId());
			if(sql.contains("UPDATE")) {
				stmt.setLong(4, producto.getId());
			}else {
				stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
