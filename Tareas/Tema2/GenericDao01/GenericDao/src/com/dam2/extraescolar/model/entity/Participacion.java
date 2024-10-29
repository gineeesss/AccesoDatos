package com.dam2.extraescolar.model.entity;

public class Participacion {
	private Integer id;
	private Participante participante;
	private Actividad actividad;

	public Participacion() {
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
	 * @return the participante
	 */
	public Participante getParticipante() {
		return participante;
	}

	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	/**
	 * @return the actividad
	 */
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}


}
