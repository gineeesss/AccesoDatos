package ejercicio3;

public class Fecha {
	private int segundos;
	private int minutos;
	private int horas;
	private int dias;
	public Fecha(int minutos, int horas, int dias) {
		this.minutos = minutos;
		this.horas = horas;
		this.dias = dias;
	}
	public Fecha() {}
	public int pasarASegundos() {
		return dias*86400 + horas*3600 + minutos*60;
	}
	
}