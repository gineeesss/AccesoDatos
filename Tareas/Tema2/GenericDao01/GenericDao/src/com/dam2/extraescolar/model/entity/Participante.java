package com.dam2.extraescolar.model.entity;

import java.time.LocalDate;
import java.util.List;

public class Participante {
	private Integer id;
	private String nif;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;	
	private Grupo grupo;   
	private List<Participacion> participaciones;

	public Participante() {
	}
	
	public Participante(Integer id) {
		this.id=id;
	}	
	
	public Participante(String nif, String nombre, String apellidos, LocalDate fechaNacimiento,Grupo grupo) {
		this(null, nif,nombre, apellidos, fechaNacimiento, grupo);
	}
	
	public Participante(Integer id, String nif, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo) {
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.grupo = grupo;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}


	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * @return the participaciones
	 */
	public List<Participacion> getParticipaciones() {
		return participaciones;
	}


	/**
	 * @param participaciones the participaciones to set
	 */
	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", grupo=" + grupo + ", participaciones=" + participaciones
				+ "]";
	}

}
