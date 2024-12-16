package modelo;

import java.io.Serializable;

public class Coche implements Serializable {
	private String matricula, marca,modelo,color;

	public Coche(String matricula, String marca, String modelo, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}
	
	public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public Coche() {}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "| Matricula: " + matricula + " | Marca:" + marca + " | Modelo: " + modelo + " | Color: " + color + " | ";
	}
	
	
}
