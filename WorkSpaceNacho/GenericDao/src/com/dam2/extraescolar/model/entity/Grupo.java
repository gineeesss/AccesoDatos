package com.dam2.extraescolar.model.entity;

public class Grupo {
	private Integer id;
	private String codGrupo;
	private String descripcion;
	
	public Grupo() {	
	}
	
	public Grupo(Integer id) {
		
	}
	
	public Grupo(Integer id, String codGrupo) {
		
	}
	
	public Grupo(Integer id, String codGrupo, String descripcion) {
		this.id = id;
		this.codGrupo = codGrupo;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}