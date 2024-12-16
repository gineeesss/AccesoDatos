package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Concesionario {
        String id;
        String nombre;
        String direccion;
        String telefono;
        String poblacion;

        public Concesionario(String id, String nombre, String direccion, String telefono, String poblacion) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
            this.poblacion = poblacion;
        }

        
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getPoblacion() {
			return poblacion;
		}


		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}


		@Override
		public String toString() {
			return "Concesionario [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
					+ telefono + ", poblacion=" + poblacion + "]";
		}
        
        
        
}

