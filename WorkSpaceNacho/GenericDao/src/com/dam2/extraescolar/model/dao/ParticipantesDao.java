package com.dam2.extraescolar.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.dam2.extraescolar.model.entity.Grupo;
import com.dam2.extraescolar.model.entity.Participante;
import com.dam2.extraescolar.util.UtilFecha;

public class ParticipantesDao extends GenericDao<Participante, Integer> {

	private String nombreAnterior;

	public ParticipantesDao() {
		super();
		nombreAnterior = "";
	}

	@Override
	public Participante get(Integer id) {
		Participante participante = new Participante(id);
		return get(participante);
	}

	/**
	 * Realiza una consulta según los campos completados
	 *
	 * @param entity
	 * @return devuelve el primer registro que cumpla la condicion
	 */
	@Override
	public Participante get(Participante entity) {
		Participante participante = null;
		error = false;
		if (entity != null) {
			String condicion = "WHERE 1 ";
			if (entity.getId() != null) {
				condicion += "AND id = " + entity.getId() + " ";
			}

			if (entity.getNif() != null) {
				condicion += "AND nif = '" + entity.getNif() + "' ";
			}
			if (entity.getNombre() != null) {
				condicion += "AND nombre = \"" + entity.getNombre() + "\" ";
			}
			if (entity.getApellidos() != null) {
				condicion += "AND apellidos = \"" + entity.getApellidos() + "\" ";
			}
			if (entity.getFechaNacimiento() != null) {
				condicion += "AND fecha_nacimiento = \"" + UtilFecha.LocalDateToStringMysql(entity.getFechaNacimiento())
						+ "\" ";
			}
			if (entity.getGrupo() != null && entity.getGrupo().getId() != null) {
				condicion += "AND id_grupo = " + entity.getGrupo().getId() + "\" ";
			}

			String sql = "SELECT id, " 
							+ "nif, nombre, apellidos, fecha_nacimiento, id_grupo " 
							+ "FROM participantes "
					+ condicion;
			try {
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					participante = itemToEntity(rs);
					nombreAnterior = obtieneClaveOrdenacion(participante);
				}
				rs.close();
			} catch (SQLException ex) {
				participante = null;
				error = true;
			}
		}
		
		return participante;
	}

	@Override
	public Integer add(Participante entity) {
		Integer id = null;
		error = false;
		if (entity != null) {
			try {
				id = _add(entity);
				con.commit();

			} catch (SQLException ex) {
				id = null;
				error = true;
				try {
					con.rollback();
				} catch (SQLException ex1) {
				}
			}
		}
		return id;
	}

	@Override
	public boolean add(List<Participante> list) {
		boolean correcto = true;
		error = false;

		try {
			for (Participante entity : list) {
				_add(entity);
			}
			con.commit();

		} catch (SQLException ex) {
			correcto = false;
			error = true;
			try {
				con.rollback();
			} catch (SQLException ex1) {
			}
		}
		return correcto;
	}

	/**
	 * Actualiza el registro que tiene el id
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public boolean update(Participante entity) {
		boolean correcto = true;
		if (entity != null) {
			String sql = "UPDATE participantes SET " 
								+ "nif=?, nombre=?, apellidos=?, fecha_nacimiento=?, id_grupo=? "
								+ "WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, entity.getNif());
				ps.setString(2, entity.getNombre());
				ps.setString(3, entity.getApellidos());
				ps.setDate(4, UtilFecha.LocalDateToDateSql(entity.getFechaNacimiento()));
				ps.setInt(5, entity.getId());
				ps.executeUpdate();
				con.commit();
			} catch (SQLException ex) {
				correcto = false;
				error = true;
				try {
					con.rollback();
				} catch (SQLException ex1) {
				}
			}
		}
		return correcto;
	}

	@Override
	public boolean delete(Integer id) {
		boolean correcto = true;
		String sql = "DELETE FROM participantes " 
							+ "WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			correcto = false;
			error = true;
			try {
				con.rollback();
			} catch (SQLException ex1) {
			}
		}
		return correcto;
	}

	@Override
	public Participante next(Participante entity) {
        Participante participante = null;
        if (entity != null) {            
            List<Participante> participantes = listNext(1);

            if (!participantes.isEmpty()) {
                participante = participantes.get(0);
                nombreAnterior = obtieneClaveOrdenacion(participante);
            } 
        }
        return participante;
	}

	@Override
	public Participante previous(Participante entity) {
        Participante participante = null;
        if (entity != null) {
            List<Participante> participantes = listPrevious(1);

            if (!participantes.isEmpty()) {
                participante = participantes.get(0);
                nombreAnterior = obtieneClaveOrdenacion(participante);
            }
        }
        return participante;
	}

	@Override
	public List<Participante> listAll() {
		List<Participante> participantes = new ArrayList<Participante>();
		Participante participante;
		error = false;
		String sql = "SELECT id, " 
					+ "nif, nombre, apellidos, fecha_nacimiento, id_grupo "
					+ "FROM participantes "
					+ "ORDER BY apellidos ASC, nombre ASC";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				participante = itemToEntity(rs);
				participantes.add(participante);
			}
			rs.close();
		} catch (SQLException ex) {
			error = true;
		}
		nombreAnterior = "";
		return participantes;
	}

	@Override
	public List<Participante> listNext(int rows) {
		List<Participante> participantes = new ArrayList<Participante>();
		Participante participante=null;
		error = false;
		String sql = "SELECT id, " 
							+ "nif, nombre, apellidos, fecha_nacimiento, id_grupo " 
							+ "FROM participantes " 
							+ "WHERE    "
									+ "CONCAT(apellidos, \" \", nombre) > " + nombreAnterior + " " 
							+ "ORDER BY apellidos ASC, nombre ASC "
							+ "LIMIT " + rows;

		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				participante = itemToEntity(rs);
				participantes.add(participante);
			}
			rs.close();
			if (participante != null)
				nombreAnterior = obtieneClaveOrdenacion(participante);
		} catch (SQLException ex) {
			error = true;
		}
		return participantes;

	}

	@Override
	public List<Participante> listPrevious(int rows) {
		List<Participante> participantes = new ArrayList<Participante>();
		Participante participante=null;
		error = false;
		String sql = "SELECT id, " 
						+ "nif, nombre, apellidos, fecha_nacimiento, id_grupo " 
						+ "FROM participantes " 
						+ "WHERE    "
						+ "CONCAT(apellidos, \" \", nombre) < " + nombreAnterior + " " 
						+ "ORDER BY apellidos ASC, nombre ASC "
						+ "ORDER BY apellidos DESC, nombre DESC LIMIT " + rows;

		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				participante = itemToEntity(rs);
				participantes.add(participante);
			}
			rs.close();
			if (participante != null)
				nombreAnterior = obtieneClaveOrdenacion(participante);
		} catch (SQLException ex) {
			error = true;
		}
		return participantes;

	}

	@Override
	public boolean exist(Participante entity) {
		error = false;
		boolean encontrado = false;
		if (entity != null) {
			String sql = "SELECT id " 
							+ "FROM participantes WHERE nif =  " + entity.getNif();
			try {
				ResultSet rs = stmt.executeQuery(sql);
				encontrado = rs.next();
				rs.close();
			} catch (SQLException ex) {
				error = true;
			}
		}
		return encontrado;
	}

//------------------------------------------
// Funcionalidades extra	
//------------------------------------------	
	public List<Participante> listAllJoinparticipaciones() {
		List<Participante> participantes = new ArrayList<Participante>();
		Participante participante;
		error = false;
		String sql = "SELECT id, " + "nif, nombre, apellidos, fecha_nacimiento, id_grupo "
				+ "FROM participantes " 
				+ "ORDER BY apellidos ASC, nombre ASC";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			GruposDao gruposDao = new GruposDao();
			while (rs.next()) {
				participante = itemToEntity(rs);
				participantes.add(participante);
				participante.setGrupo(gruposDao.get(participante.getGrupo().getId()));
			}
			rs.close();
		} catch (SQLException ex) {
			error = true;
		}
		return participantes;
	}

//------------------------------------------
// Métodos auxiliares	
//------------------------------------------	
	private Integer _add(Participante entity) throws SQLException {
		Integer id = null;
		String sql = "INSERT INTO participantes " + "(nif, nombre, apellidos, fecha_nacimiento, id_grupo) VALUES "
				+ "(?,?,?,?,?)";
		if (entity != null) {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, entity.getNif());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			if (entity.getFechaNacimiento()!=null)
				ps.setDate(4, UtilFecha.LocalDateToDateSql(entity.getFechaNacimiento()));
			else
				ps.setNull(4, Types.TIMESTAMP);
			if (entity.getGrupo()!=null)
				ps.setInt(5, entity.getGrupo().getId());
			else
				ps.setNull(5,Types.INTEGER);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			} else {
				id = -1; // Si se ha añadido pero no se ha devuelto un id
			}
		}
		return id;
	}

	private Participante itemToEntity(ResultSet rs) throws SQLException {
		Participante participante = new Participante();
		participante = new Participante();
		participante.setId(rs.getInt("id"));
		participante.setNif(rs.getString("nif"));
		participante.setNombre(rs.getString("nombre"));
		participante.setApellidos(rs.getString("apellidos"));
		participante.setFechaNacimiento(UtilFecha.DateSqlToLocalDate(rs.getDate("fecha_nacimiento")));
		Grupo grupo = new Grupo(rs.getInt("id_grupo"));
		participante.setGrupo(grupo);
		return participante;
	}
	
	private String obtieneClaveOrdenacion(Participante entity) {
		return entity.getApellidos() + " " + entity.getNombre();
	}


}