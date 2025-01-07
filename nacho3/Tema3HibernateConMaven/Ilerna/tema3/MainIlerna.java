import java.util.Scanner;
import main.java.objetos.Estudiante;
import main.java.tema3.Dao.EstudianteDaoImpl;

public class MainIlerna {
	private static Scanner scr = new Scanner(System.in);
	private static EstudianteDaoImpl dao = new EstudianteDaoImpl();
	public static void main(String[] args) {
		
		int eleccion;
		do {
			menu();
			eleccion=getNumber();
			switch(eleccion) {
			case 1:
				dao.crearAlumno(getWord(),getWord(),getWord());
				break;
			case 2:
				dao.updateEstudiante();
				break;
			case 3:
				dao.deleteEstudiantes();
				break;
				
			}
		}while(eleccion!=0);
	}
	
	private static void menu(){
		System.out.println("[1] CREAR ALUMNO");
		System.out.println("[2] UPDATE ESTUDIANTE");
		System.out.println("[3] DELETE ESTUDIANTE");
	}
	private static Integer getNumber() {
		return scr.nextInt();
	}
	private static String getWord() {	
		return scr.next();
	}
}
