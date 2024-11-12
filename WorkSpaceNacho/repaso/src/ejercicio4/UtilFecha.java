package ejercicio4;

public class UtilFecha {

	public static int ddhhmmToSegundos(int dias, int horas, int minutos) {
		return dias*86400+horas*3600+minutos*60; //24*60*60"=86400
	}
	//horas del mes hasta el día
	public static  int horasTranscurridasMes(int dia) {
		return dia*24;
	}
	
}
