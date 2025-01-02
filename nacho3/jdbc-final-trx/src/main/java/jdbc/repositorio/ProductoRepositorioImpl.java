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

public class ProductoRepositorioImpl implements Repositorio<Producto> {

	private Connection getConnection() throws SQLException {

		return ConexionBaseDatos.getInstance();
	}

	@Override
	public List<Producto> listar() throws SQLException {
		List<Producto> productos = new ArrayList<>();

		try (Statement stm = getConnection().createStatement();
				ResultSet rs = stm.executeQuery("SELECT p.*,c.nombre as categoria FROM productos p "
						+ " LEFT JOIN categorias c ON (p.categoria_id=c.id) ORDER BY p.id")) {
			while (rs.next()) {
				Producto p = crearProducto(rs);

				productos.add(p);

			}
		}

		return productos;
	}

	private Producto crearProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto();

		p.setId(rs.getLong("id"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getInt("precio"));
		p.setFechaRegistro(rs.getDate("fecha_registro"));
		p.setSku(rs.getString("sku"));
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("categoria_id"));
		categoria.setNombre(rs.getString("categoria"));
		p.setCategoria(categoria);

		return p;
	}

	@Override
	public Producto porId(Long id) throws SQLException {
		Producto producto = null;

		try (PreparedStatement stmt = getConnection()
				.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p "
						+ "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ? ")) {
			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					producto = crearProducto(rs);
				}

			}
		}
		return producto;
	}

	@Override
	public void guardar(Producto producto) throws SQLException {
		String sql;
		// VAMOS A APROVECHAR PARA GUARDAR (INSERT) Y ADEMÁS ACTUALIZAR(UPDATE)
		if (producto.getId() != null && producto.getId() > 0) {
			// EL PRODUCTO YA EXISTE EN LA BBDD
			sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=?, sku=? WHERE id=?";
		} else {
			// EL PRODUCTO NO EXISTE EN LA BBDD
			sql = "INSERT INTO productos(nombre,precio,categoria_id,sku,fecha_registro) " + " VALUES(?,?,?,?,?)";
		}
		try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			stmt.setLong(3, producto.getCategoria().getId());// COMPROBAR QUE GETCATEGORIA NO SEA NULL
			stmt.setString(4, producto.getSku());
			// Y SI LO ES LE SETEAMOS UN SETNULL

			if (producto.getId() != null && producto.getId() > 0) {
				stmt.setLong(5, producto.getId());
			} else {
				stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
			}
			stmt.executeUpdate();
		}

	}

	@Override
	public void eliminar(Long id) throws SQLException {

		try (PreparedStatement stmt = getConnection().prepareStatement("DELETE" + " FROM productos WHERE id = ?")) {

			stmt.setLong(1, id);
			stmt.executeUpdate();

		}

	}

}
