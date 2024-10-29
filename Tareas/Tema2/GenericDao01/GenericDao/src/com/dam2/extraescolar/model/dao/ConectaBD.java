package com.dam2.extraescolar.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {

	private static ConectaBD conectaBD;
	private Connection connection;
	private boolean error;
	
	final static int DB_VERSION = 1;
	final static String DB_URL = "castelarlamp.duckdns.org";
	final static int DB_PORT = 33069;
	final static String DB_DESCRIPCION_VERSION = "Creación inicial";
//	final static String DB_NAME = "INDICA LA BD";
//	final static String DB_USER = "INDICA EL USUARIO";	
	final static String DB_NAME = "acadt";
	final static String DB_USER = "acadt";		
	final static String DB_PASSWORD = "dam2";

	private ConectaBD() throws ExceptionDataBase {
		error = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlAcceso = "jdbc:mysql://" + DB_URL + ":" + DB_PORT + "/" + DB_NAME;
			connection = DriverManager.getConnection(urlAcceso, DB_USER, DB_PASSWORD);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException ex) {
			error = true;
			System.err.println("Driver sqlite no encontrado");
		} catch (SQLException ex) {
			try {
				connection.rollback();
			} catch (SQLException ex1) {
			}
			error = true;
			System.err.println("Se ha producido un error en la sentencia SQL");
		}
	}

	public static ConectaBD getConectaBD() throws ExceptionDataBase {
		if (conectaBD == null) {
			conectaBD = new ConectaBD();
		}
		return conectaBD;
	}

	public Connection getConnection() {
		return connection;
	}


	public boolean isError() {
		return error;
	}

}
