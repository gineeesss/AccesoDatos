package ejercicio3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] tiempo = new int[3] ;
		System.out.println("Introduce días");
		tiempo[0] = scr.nextInt();
		System.out.println("Introduce horas");
		tiempo[1] = scr.nextInt();
		System.out.println("Introduce minutos");
		tiempo[2] = scr.nextInt();
		Fecha fecha = new Fecha(tiempo[0],tiempo[1],tiempo[2]);
		System.out.println(fecha.pasarASegundos());
	}
}
