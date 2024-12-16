package repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Coche;
import modelo.Concesionario;
import util.ConexionBBDD;

public class CocheRepository implements Repository<Coche> {
		
	private static Connection con = ConexionBBDD.getInstance();
	
	
	@Override
	public void insertar(Coche coche) {
		String sql = "INSERT INTO coche VALUES (?,?,?,?);";
		try(
			PreparedStatement st = con.prepareStatement(sql);
			){
			
			st.setString(1, coche.getMatricula() );
			st.setString(2, coche.getMarca());
			st.setString(3, coche.getModelo());
			st.setString(4, coche.getColor());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error al insertar un coche en la base de datos");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void actualizar(String matricula, Coche coche) {
		String sql = "UPDATE coche SET marca = ? , modelo = ? WHERE matricula = ?;";
		try(
			PreparedStatement st = con.prepareStatement(sql);
			){
			
			st.setString(1, coche.getMarca() );
			st.setString(2, coche.getModelo());
			st.setString(3, matricula);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error al actualizar un coche en la base de datos");
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void eliminar(String matricula) {
		String sql = "DELETE FROM coche WHERE matricula=?;";
		try(
			PreparedStatement st = con.prepareStatement(sql);
			){
		
			st.setString(1, matricula);
			
			st.execute();
			
		} catch (SQLException e) {
			System.err.println("Error al eliminar un coche de la base de datos");
			System.err.println(e.getMessage());
		}
		
	}
	
	public ArrayList buscarVolvo() {
		ArrayList<Coche> volvos = new ArrayList();
		
		String sql = "SELECT * FROM coche WHERE marca = ?";
		
		try(
				PreparedStatement st = con.prepareStatement(sql);
				
				)
		{
			st.setString(1, "volvo");
			ResultSet rs = st.executeQuery();
			
			
			if (rs!=null) {
				
				while(rs.next()) {
					Coche coche = new Coche();
					coche.setMatricula(rs.getString(1));
					coche.setMarca(rs.getString(2));
					coche.setModelo(rs.getString(3));
					coche.setColor(rs.getString(4));
					
					System.out.println(coche);
					
					volvos.add(coche);	

				}
			} else {
				System.out.println("No hay volvo en la base de datos");
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("Error al recuperar volvos");
			System.err.println(e.getMessage());
		}
		
		
		return volvos;
	}
	
	
	 public void cargarDatosDesdeFichero() {
	        String sql = """
	                INSERT INTO concesionarios (id, nombre, direccion, telefono, poblacion)
	                VALUES (?, ?, ?, ?, ?)
	                """;

	        try (BufferedReader bf = new BufferedReader(new FileReader("."+File.separator+"resources"+File.separator+"concesionario.dat"));
	             PreparedStatement st = con.prepareStatement(sql)) {

	            String linea;
	            while ((linea = bf.readLine()) != null) {
	                String[] datos = linea.split("#", 5);
	                if (datos.length == 5) {
	                    Concesionario concesionario = new Concesionario(datos[0], datos[1], datos[2], datos[3], datos[4]);

	                    // Insertar los datos en la base de datos
	                    st.setString(1, concesionario.getId());
	                    st.setString(2, concesionario.getNombre());
	                    st.setString(3, concesionario.getDireccion());
	                    st.setString(4, concesionario.getTelefono());
	                    st.setString(5, concesionario.getPoblacion());
	                    st.executeUpdate();
	                }
	            }
	            System.out.println("Datos cargados correctamente.");

	        } catch (IOException e) {
	            System.err.println("Error al leer el fichero de concesionarios");
	            System.out.println(e.getMessage());
	        } catch (SQLException e) {
	            System.err.println("Error al insertar datos en concesionarios.");
	            System.out.println(e.getMessage());
	        }
	    }
}
