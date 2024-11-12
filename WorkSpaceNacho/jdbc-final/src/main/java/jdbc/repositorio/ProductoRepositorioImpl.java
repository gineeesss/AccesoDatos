package jdbc.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

	private Connection getConnection() throws SQLException {

		return ConexionBaseDatos.getInstance();
	}

	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<>();

		try (Statement stm = getConnection().createStatement();
				ResultSet rs = stm.executeQuery("SELECT * FROM productos")) {
			while (rs.next()) {
				Producto p = crearProducto(rs);

				productos.add(p);

			}
		} catch (SQLException e) {

		}

		return productos;
	}

	private Producto crearProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		// System.out.print(rs.getInt("id"));
		p.setId(rs.getLong("id"));
		// System.out.print(" | ");
		// System.out.print(rs.getString("nombre"));
		p.setNombre(rs.getString("nombre"));
		// System.out.print(" | ");
		// System.out.print(rs.getInt("precio"));
		p.setPrecio(rs.getInt("precio"));
		// System.out.print(" | ");
		// System.out.println(rs.getDate("fecha_registro"));
		p.setFechaRegistro(rs.getDate("fecha_registro"));
		return p;
	}

	@Override
	public Producto porId(Long id) {
		Producto producto = null;

		try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM productos WHERE id = ? ")) {
			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					producto = crearProducto(rs);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public void guardar(Producto producto) {
		String sql;
		// VAMOS A APROVECHAR PARA GUARDAR (INSERT) Y ADEMÁS ACTUALIZAR(UPDATE)
		if (producto.getId() != null && producto.getId() > 0) {
			// EL PRODUCTO YA EXISTE EN LA BBDD
			sql = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
		} else {
			// EL PRODUCTO NO EXISTE EN LA BBDD
			sql = "INSERT INTO productos(nombre,precio,fecha_registro) " + " VALUES(?,?,?)";
		}
		try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			if (producto.getId() != null && producto.getId() > 0) {
				stmt.setLong(3, producto.getId());
			} else {
				stmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(Long id) {

		try (PreparedStatement stmt = getConnection().prepareStatement("DELETE" + " FROM productos WHERE id = ?")) {

			stmt.setLong(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
