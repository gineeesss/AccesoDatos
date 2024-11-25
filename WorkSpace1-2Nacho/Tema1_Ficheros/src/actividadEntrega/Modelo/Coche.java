package actividadEntrega.Modelo;

import java.io.Serializable;

public class Coche implements Serializable {

	private String matricula;
	private String anoMatriculacion;

	public Coche() {

	}

	public Coche(String matricula, String anoMatriculacion) {
		this.matricula = matricula;
		this.anoMatriculacion = anoMatriculacion;
	}

	@Override
	public String toString() {
		return "Coche{" + "matricula='" + matricula + '\'' + ", anoMatriculacion='" + anoMatriculacion + '\'' + '}';
	}
}
