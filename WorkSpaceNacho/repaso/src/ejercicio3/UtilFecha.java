package ejercicio3;

public class UtilFecha {

	/*
	 * 3. Escriba un programa que pida un número de días, horas y minutos y
	 * visualice el equivalente en segundos.
	 */
	public static int ddhhmmToSegundos(int dias, int horas, int minutos) {
		return dias*86400+horas*3600+minutos*60; //24*60*60"=86400
	}
}
