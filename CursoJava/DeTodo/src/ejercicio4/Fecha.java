package ejercicio4;

public class Fecha {
	private int numeroDia;
	private int horasTranscurridas;
	public Fecha(int numeroDia, int horasTranscurridas) {
		this.numeroDia = numeroDia;
		this.horasTranscurridas = horasTranscurridas;
	}
	public Fecha() {
	}
	public int horas() {
		return -(-31+numeroDia)*24;
	}
	
}
